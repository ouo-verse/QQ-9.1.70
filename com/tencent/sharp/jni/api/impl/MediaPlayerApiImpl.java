package com.tencent.sharp.jni.api.impl;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.IMediaPlayerApi;
import com.tencent.sharp.jni.callback.OnCompletionListener;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes34.dex */
public class MediaPlayerApiImpl implements IMediaPlayerApi, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    private static final int MSG_CHANGE_AUDIO_MODE = 2;
    private static final int MSG_PLAY_RING_INTERNAL = 0;
    private static final int MSG_STOP_RING_INTERNAL = 1;
    public static final int STATE_PLAYER_COMPLETED = 9;
    public static final int STATE_PLAYER_END = 7;
    public static final int STATE_PLAYER_ERROR = 8;
    public static final int STATE_PLAYER_IDLE = 0;
    public static final int STATE_PLAYER_INITED = 1;
    public static final int STATE_PLAYER_PAUSED = 6;
    public static final int STATE_PLAYER_PREPARED = 2;
    public static final int STATE_PLAYER_PREPARING = 3;
    public static final int STATE_PLAYER_RESETTING = 10;
    public static final int STATE_PLAYER_STARTED = 4;
    public static final int STATE_PLAYER_STOPPED = 5;
    static final String TAG = "TraeMediaPlayerImpl";
    private OnCompletionListener mCallback;
    private Context mContext;
    private int mLastState;
    private MediaPlayer mMediaPlay = null;
    private int mStreamType = 0;
    private boolean mHasCall = false;
    private boolean mLoop = false;
    private int mDurationMs = -1;
    int mLoopCount = 0;
    boolean mRingMode = false;
    private Timer mWatchTimer = null;
    private TimerTask mWatchTimerTask = null;
    private AtomicInteger mCurrentState = new AtomicInteger(0);
    private final Handler mMediaPlayerHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper()) { // from class: com.tencent.sharp.jni.api.impl.MediaPlayerApiImpl.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                MediaPlayerInfo mediaPlayerInfo = (MediaPlayerInfo) message.obj;
                MediaPlayerApiImpl.this.playRingInternal(mediaPlayerInfo.mSeq, mediaPlayerInfo.mDataSource, mediaPlayerInfo.mRid, mediaPlayerInfo.mRes, mediaPlayerInfo.mStrFilePath, mediaPlayerInfo.mLoop, mediaPlayerInfo.mLoopCount, mediaPlayerInfo.mRingMode, mediaPlayerInfo.mHasCall, mediaPlayerInfo.mCallStreamType);
                return;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                MediaPlayerApiImpl.this.checkAudioManagerModeInternal(message.arg1);
                return;
            }
            if (MediaPlayerApiImpl.this.getCurrentState() == 10) {
                MediaPlayerApiImpl mediaPlayerApiImpl = MediaPlayerApiImpl.this;
                mediaPlayerApiImpl.changeCurrentState(mediaPlayerApiImpl.mLastState);
            } else {
                QLog.e(MediaPlayerApiImpl.TAG, 1, "stopRing illegal state: " + MediaPlayerApiImpl.this.getCurrentState());
            }
            MediaPlayerApiImpl.this.stopRingInternal(((Long) message.obj).longValue());
        }
    };

    /* loaded from: classes34.dex */
    static class MediaPlayerInfo {
        public int mCallStreamType;
        public int mDataSource;
        public boolean mHasCall;
        public boolean mLoop;
        public int mLoopCount;
        public Uri mRes;
        public int mRid;
        public boolean mRingMode;
        public long mSeq;
        public String mStrFilePath;

        MediaPlayerInfo(long j3, int i3, int i16, Uri uri, String str, boolean z16, int i17, boolean z17, boolean z18, int i18) {
            this.mSeq = j3;
            this.mDataSource = i3;
            this.mRid = i16;
            this.mRes = uri;
            this.mStrFilePath = str;
            this.mLoop = z16;
            this.mLoopCount = i17;
            this.mRingMode = z17;
            this.mHasCall = z18;
            this.mCallStreamType = i18;
        }
    }

    private boolean canAsyncPrepare() {
        return getCurrentState() == 1 || getCurrentState() == 5 || getCurrentState() == 10;
    }

    private boolean canSetDataSource() {
        return getCurrentState() == 0 || getCurrentState() == 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canStart() {
        return getCurrentState() == 2 || getCurrentState() == 4 || getCurrentState() == 6 || getCurrentState() == 9 || getCurrentState() == 10;
    }

    private boolean canStop() {
        return getCurrentState() == 2 || getCurrentState() == 9 || getCurrentState() == 4 || getCurrentState() == 5 || getCurrentState() == 6 || getCurrentState() == 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int changeCurrentState(int i3) {
        return this.mCurrentState.getAndSet(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAudioManagerMode(int i3) {
        Message obtainMessage = this.mMediaPlayerHandler.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.arg1 = i3;
        this.mMediaPlayerHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAudioManagerModeInternal(int i3) {
        AudioManager audioManager;
        if (this.mHasCall) {
            return;
        }
        QLog.d(TAG, 1, "checkAudioManagerModeInternal " + i3);
        Context context = this.mContext;
        if (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null) {
            return;
        }
        QLog.d(TAG, 1, "start  setAudioManagerMode" + i3);
        audioManager.setMode(i3);
        QLog.d(TAG, 1, "setAudioManagerMode " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loopMediaPlayer(final long j3, boolean z16, int i3, int i16) {
        this.mLoop = z16;
        if (z16) {
            this.mLoopCount = 1;
            this.mDurationMs = -1;
        } else {
            this.mLoopCount = i3;
            this.mDurationMs = i3 * i16;
        }
        this.mLoopCount--;
        if (this.mDurationMs > 0) {
            this.mWatchTimer = new BaseTimer();
            TimerTask timerTask = new TimerTask() { // from class: com.tencent.sharp.jni.api.impl.MediaPlayerApiImpl.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (MediaPlayerApiImpl.this.mMediaPlay != null) {
                        if (QLog.isColorLevel()) {
                            QLog.w(MediaPlayerApiImpl.TAG, 1, "playRing, onCompletion, seq[" + j3 + "]");
                        }
                        if (MediaPlayerApiImpl.this.mCallback != null) {
                            MediaPlayerApiImpl.this.mCallback.onCompletion(j3);
                        }
                    }
                }
            };
            this.mWatchTimerTask = timerTask;
            this.mWatchTimer.schedule(timerTask, this.mDurationMs + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean playRingInternal(final long j3, int i3, int i16, Uri uri, String str, final boolean z16, final int i17, boolean z17, boolean z18, int i18) {
        boolean z19;
        QLog.w(TAG, 1, "playRingInternal, dataSource[" + i3 + "], rid[" + i16 + "], res[" + uri + "], strFilePath[" + str + "], loop[" + z16 + "], loopCount[" + i17 + "], ringMode[" + z17 + "], hasCall[" + z18 + "], callStreamType[" + i18 + "], devicesInfo[" + m.b() + "], seq[" + j3 + "]");
        if (!z16 && i17 <= 0) {
            return false;
        }
        try {
            if (!resetMediaPlayer()) {
                QLog.e(TAG, 1, "playRing reset failed.");
                return false;
            }
            if (!initMediaPlayer(j3, i3, i16, uri, str)) {
                QLog.e(TAG, 1, "playRing init player failed.");
                return false;
            }
            this.mRingMode = z17;
            int i19 = 2;
            if (z17) {
                this.mStreamType = 2;
                i19 = 1;
            } else if (Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && DeviceInfoMonitor.getModel().equals("MI 3") && !z18) {
                this.mStreamType = 2;
            } else {
                this.mStreamType = 0;
                i19 = 3;
            }
            this.mHasCall = z18;
            if (z18) {
                this.mStreamType = i18;
            }
            this.mMediaPlay.setAudioStreamType(this.mStreamType);
            this.mMediaPlay.setLooping(z16);
            final int i26 = i19;
            z19 = false;
            try {
                this.mMediaPlay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.sharp.jni.api.impl.MediaPlayerApiImpl.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        QLog.d(MediaPlayerApiImpl.TAG, 1, "onPrepared. mp=" + mediaPlayer + " mMediaPlay=" + MediaPlayerApiImpl.this.mMediaPlay);
                        MediaPlayerApiImpl.this.changeCurrentState(2);
                        synchronized (MediaPlayerApiImpl.this) {
                            if (MediaPlayerApiImpl.this.mMediaPlay == null || mediaPlayer == null) {
                                return;
                            }
                            try {
                                MediaPlayerApiImpl.this.checkAudioManagerMode(i26);
                                if (MediaPlayerApiImpl.this.canStart()) {
                                    MediaPlayerApiImpl.this.mMediaPlay.start();
                                    MediaPlayerApiImpl.this.changeCurrentState(4);
                                } else {
                                    QLog.e(MediaPlayerApiImpl.TAG, 1, "onPrepared illegal state: " + MediaPlayerApiImpl.this.getCurrentState());
                                }
                                int duration = MediaPlayerApiImpl.this.mMediaPlay.getDuration();
                                MediaPlayerApiImpl.this.loopMediaPlayer(j3, z16, i17, duration);
                                QLog.w(MediaPlayerApiImpl.TAG, 1, "playRing end, info, mLoopCount[" + MediaPlayerApiImpl.this.mLoopCount + "], mMediaPlay.getDuration()[" + duration + "], durationMs[" + MediaPlayerApiImpl.this.mDurationMs + "], mCurrentState[" + MediaPlayerApiImpl.this.getCurrentState() + "], seq[" + j3 + "]");
                            } catch (Exception e16) {
                                QLog.e(MediaPlayerApiImpl.TAG, 1, "onPrepared error: " + e16.toString());
                            }
                        }
                    }
                });
                if (canAsyncPrepare()) {
                    this.mMediaPlay.prepareAsync();
                    changeCurrentState(3);
                    QLog.e(TAG, 1, "playRing prepareAsync");
                    return true;
                }
                QLog.e(TAG, 1, "playRing illegal state: " + getCurrentState());
                return true;
            } catch (Exception e16) {
                e = e16;
                QLog.w(TAG, 1, "playRing, Exception, seq[" + j3 + "]", e);
                try {
                    this.mMediaPlay.release();
                    changeCurrentState(7);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                this.mMediaPlay = null;
                return z19;
            }
        } catch (Exception e18) {
            e = e18;
            z19 = false;
        }
    }

    private boolean resetMediaPlayer() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "resetMediaPlayer player=" + this.mMediaPlay + " state=" + getCurrentState());
        }
        if (this.mMediaPlay != null && getCurrentState() != 10) {
            if (this.mMediaPlay.isPlaying()) {
                return false;
            }
            try {
                try {
                    this.mMediaPlay.release();
                    changeCurrentState(7);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } finally {
                this.mMediaPlay = null;
            }
        }
        Timer timer = this.mWatchTimer;
        if (timer != null) {
            timer.cancel();
            this.mWatchTimer = null;
            this.mWatchTimerTask = null;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRingInternal(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 1, "stopRingInternal, mMediaPlay[" + this.mMediaPlay + "], seq[" + j3 + "]");
        }
        MediaPlayer mediaPlayer = this.mMediaPlay;
        if (mediaPlayer == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                if (canStop()) {
                    this.mMediaPlay.stop();
                    changeCurrentState(5);
                } else {
                    QLog.e(TAG, 1, "stopRingInternal illegal state: " + getCurrentState());
                }
            }
            this.mMediaPlay.reset();
            changeCurrentState(0);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            Timer timer = this.mWatchTimer;
            if (timer != null) {
                timer.cancel();
                this.mWatchTimer = null;
                this.mWatchTimerTask = null;
            }
            this.mMediaPlay.release();
            changeCurrentState(7);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        this.mMediaPlay = null;
        this.mDurationMs = -1;
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 1, "stopRingInternal end. seq[" + j3 + "]");
        }
    }

    public int getCurrentState() {
        return this.mCurrentState.get();
    }

    @Override // com.tencent.sharp.jni.api.IMediaPlayerApi
    public int getDuration() {
        return this.mDurationMs;
    }

    @Override // com.tencent.sharp.jni.api.IMediaPlayerApi
    public int getStreamType() {
        return this.mStreamType;
    }

    @Override // com.tencent.sharp.jni.api.IMediaPlayerApi
    public boolean hasCall() {
        return this.mHasCall;
    }

    @Override // com.tencent.sharp.jni.api.IMediaPlayerApi
    public void init(Context context, OnCompletionListener onCompletionListener) {
        this.mContext = context;
        this.mCallback = onCompletionListener;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onError player=" + this.mMediaPlay + " mp=" + mediaPlayer + " what=" + i3);
        }
        changeCurrentState(8);
        synchronized (this) {
            try {
                this.mMediaPlay.release();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.mMediaPlay = null;
        }
        changeCurrentState(7);
        OnCompletionListener onCompletionListener = this.mCallback;
        if (onCompletionListener == null) {
            return false;
        }
        onCompletionListener.onCompletion(-1029L);
        return false;
    }

    @Override // com.tencent.sharp.jni.api.IMediaPlayerApi
    public synchronized void stopRing(long j3) {
        this.mLastState = getCurrentState();
        changeCurrentState(10);
        Message obtainMessage = this.mMediaPlayerHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = Long.valueOf(j3);
        this.mMediaPlayerHandler.sendMessage(obtainMessage);
    }

    @Override // com.tencent.sharp.jni.api.IMediaPlayerApi
    public synchronized boolean playRing(long j3, int i3, int i16, Uri uri, String str, boolean z16, int i17, boolean z17, boolean z18, int i18) {
        Message obtainMessage = this.mMediaPlayerHandler.obtainMessage();
        obtainMessage.what = 0;
        obtainMessage.obj = new MediaPlayerInfo(j3, i3, i16, uri, str, z16, i17, z17, z18, i18);
        this.mMediaPlayerHandler.sendMessage(obtainMessage);
        return true;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        changeCurrentState(9);
        if (this.mLoop) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loop play, continue...");
                return;
            }
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "onCompletion player=" + this.mMediaPlay + " mp=" + mediaPlayer + " mLoopCount=" + this.mLoopCount);
            }
            synchronized (this) {
                if (this.mLoopCount <= 0) {
                    if (this.mMediaPlay.isPlaying()) {
                        if (canStop()) {
                            this.mMediaPlay.stop();
                            changeCurrentState(5);
                        } else {
                            QLog.e(TAG, 1, "onCompletion stop illegal state: " + getCurrentState());
                        }
                    }
                    this.mMediaPlay.reset();
                    changeCurrentState(0);
                    this.mMediaPlay.release();
                    changeCurrentState(7);
                    this.mMediaPlay = null;
                    OnCompletionListener onCompletionListener = this.mCallback;
                    if (onCompletionListener != null) {
                        onCompletionListener.onCompletion(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR);
                    }
                } else {
                    if (canStart()) {
                        this.mMediaPlay.start();
                        changeCurrentState(4);
                    } else {
                        QLog.e(TAG, 1, "onCompletion start illegal state: " + getCurrentState());
                    }
                    this.mLoopCount--;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean initMediaPlayer(final long j3, int i3, int i16, Uri uri, String str) throws Exception {
        AssetFileDescriptor assetFileDescriptor;
        this.mMediaPlay = new MediaPlayer();
        changeCurrentState(0);
        this.mMediaPlay.setOnCompletionListener(this);
        this.mMediaPlay.setOnErrorListener(this);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "initMediaPlayer seq[" + j3 + "] player=" + this.mMediaPlay);
        }
        if (i3 == 0) {
            try {
                assetFileDescriptor = this.mContext.getResources().openRawResourceFd(i16);
            } catch (Throwable th5) {
                th = th5;
                assetFileDescriptor = null;
            }
            try {
                if (canSetDataSource()) {
                    this.mMediaPlay.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    changeCurrentState(1);
                }
            } catch (Throwable th6) {
                th = th6;
                QLog.i(TAG, 1, "playRing exception: " + th.getMessage(), th);
                if (assetFileDescriptor == null) {
                }
            }
            if (assetFileDescriptor == null) {
                assetFileDescriptor.close();
            } else {
                QLog.w(TAG, 1, "playRing fail, res[" + uri + "], seq[" + j3 + "]");
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                changeCurrentState(7);
                if (this.mCallback != null) {
                    if (QQAudioHelper.f()) {
                        ((AppInterface) BaseApplicationImpl.getApplication().getRuntime()).getHandler(getClass()).postDelayed(new Runnable() { // from class: com.tencent.sharp.jni.api.impl.MediaPlayerApiImpl.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MediaPlayerApiImpl.this.mCallback != null) {
                                    MediaPlayerApiImpl.this.mCallback.onCompletion(j3);
                                }
                            }
                        }, 4000L);
                    } else {
                        this.mCallback.onCompletion(j3);
                    }
                }
                return false;
            }
        } else if (i3 != 1) {
            if (i3 != 2) {
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                changeCurrentState(7);
                return false;
            }
            if (canSetDataSource()) {
                this.mMediaPlay.setDataSource(str);
                changeCurrentState(1);
            }
        } else if (canSetDataSource()) {
            this.mMediaPlay.setDataSource(this.mContext, uri);
            changeCurrentState(1);
        }
        return true;
    }
}
