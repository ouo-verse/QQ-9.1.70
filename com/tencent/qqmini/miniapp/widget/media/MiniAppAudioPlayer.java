package com.tencent.qqmini.miniapp.widget.media;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* loaded from: classes23.dex */
public class MiniAppAudioPlayer implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnPreparedListener {
    private static final int MIN_START_TIME = 1000;
    public static final int STATE_BUFFERING = 0;
    public static final int STATE_COMPLETION = 5;
    public static final int STATE_ERROR = 6;
    public static final int STATE_PAUSE = 3;
    public static final int STATE_PLAYING = 2;
    public static final int STATE_PREPARE = 1;
    public static final int STATE_STOP = 4;
    private static final String TAG = "MiniAppAudioPlayer";
    private static final int UPDATE_INTERVAL = 300;
    private boolean audioFocus;
    private Context mContext;
    private int mDuration;
    private Runnable mLoopingRunnable;
    private MediaPlayer mPlayer;
    private AudioPlayerListener mPlayerListener;
    private String mSrc;
    private Runnable mStartRunnable;
    private volatile int mStartTime;
    private int mState;
    private final Handler mUiHandler;
    private OnPreparedListener preparedListener;

    /* loaded from: classes23.dex */
    public interface AudioPlayerListener {
        void onError(int i3, int i16);

        void onPlayerBufferingUpdate(int i3);

        void onPlayerProgress(String str, int i3, int i16);

        void onPlayerSeek(boolean z16, int i3);

        void onPlayerStateChange(int i3);
    }

    /* loaded from: classes23.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    public MiniAppAudioPlayer() {
        this(null);
    }

    private void handleCompletion() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            this.mDuration = mediaPlayer.getDuration();
        }
    }

    private void initMediaPlayer() {
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        this.mPlayer = reportMediaPlayer;
        reportMediaPlayer.setOnPreparedListener(this);
        this.mPlayer.setOnCompletionListener(this);
        this.mPlayer.setOnErrorListener(this);
        this.mPlayer.setOnSeekCompleteListener(this);
        this.mPlayer.setOnBufferingUpdateListener(this);
    }

    private void muteAudioFocus(boolean z16) {
        try {
            ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.mContext, z16);
        } catch (Exception e16) {
            QMLog.e(TAG, "muteAudioFocus.....", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPlayerError(int i3, int i16) {
        QMLog.d(TAG, "notifyPlayerError.....what..." + i3 + " extra..." + i16);
        AudioPlayerListener audioPlayerListener = this.mPlayerListener;
        if (audioPlayerListener != null) {
            audioPlayerListener.onError(i3, i16);
            notifyPlayerStateChange(6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPlayerProgress(int i3) {
        AudioPlayerListener audioPlayerListener = this.mPlayerListener;
        if (audioPlayerListener != null) {
            audioPlayerListener.onPlayerProgress(this.mSrc, this.mDuration, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyPlayerStateChange(int i3) {
        this.mState = i3;
        AudioPlayerListener audioPlayerListener = this.mPlayerListener;
        if (audioPlayerListener != null) {
            audioPlayerListener.onPlayerStateChange(i3);
        }
    }

    private void resetMediaPlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
            } catch (Exception e16) {
                QMLog.e(TAG, "resetMediaPlayer.....", e16);
            }
        }
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.mPlayer;
        int i3 = 0;
        if (mediaPlayer != null) {
            try {
                i3 = Math.max(mediaPlayer.getCurrentPosition(), 0);
            } catch (Exception e16) {
                QMLog.w(TAG, "getCurrentPosition: failed", e16);
            }
        }
        return Math.min(i3, this.mDuration);
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getState() {
        return this.mState;
    }

    public boolean isPaused() {
        if (this.mState == 3) {
            return true;
        }
        return false;
    }

    public boolean isPlaying() {
        QMLog.i(TAG, "isPlaying!");
        try {
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer == null) {
                return false;
            }
            if (!mediaPlayer.isPlaying()) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QMLog.e(TAG, "mPlayer.isPlaying exception. ", e16);
            return false;
        }
    }

    public boolean isPrepared() {
        if (this.mState == 1) {
            return true;
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
        QMLog.d(TAG, "onBufferingUpdate....." + i3);
        AudioPlayerListener audioPlayerListener = this.mPlayerListener;
        if (audioPlayerListener != null) {
            audioPlayerListener.onPlayerBufferingUpdate(i3);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        QMLog.d(TAG, "onCompletion.....");
        handleCompletion();
        notifyPlayerStateChange(5);
        notifyPlayerProgress(0);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        QMLog.d(TAG, "onError.....what..." + i3 + " extra..." + i16);
        if (i3 == 100) {
            MediaPlayer mediaPlayer2 = this.mPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            initMediaPlayer();
        }
        notifyPlayerError(i3, i16);
        notifyPlayerProgress(0);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        int i3;
        QMLog.d(TAG, "onPrepared.....");
        notifyPlayerStateChange(1);
        OnPreparedListener onPreparedListener = this.preparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        try {
            MediaPlayer mediaPlayer2 = this.mPlayer;
            if (mediaPlayer2 != null) {
                i3 = mediaPlayer2.getDuration();
            } else {
                i3 = 0;
            }
            this.mDuration = Math.max(i3, 0);
        } catch (Exception e16) {
            QMLog.e(TAG, "onPrepared Exception! ", e16);
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        QMLog.d(TAG, "onSeekComplete.....");
        AudioPlayerListener audioPlayerListener = this.mPlayerListener;
        if (audioPlayerListener != null) {
            audioPlayerListener.onPlayerSeek(true, getCurrentPosition());
        }
    }

    public void pause() {
        muteAudioFocus(false);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            notifyPlayerStateChange(3);
        }
    }

    public void release() {
        muteAudioFocus(false);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mPlayer = null;
            notifyPlayerProgress(0);
        }
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mLoopingRunnable);
        }
    }

    public void seekTo(int i3) {
        int state = getState();
        if (this.mPlayer != null && state > 0 && state < 3 && i3 >= 0) {
            try {
                AudioPlayerListener audioPlayerListener = this.mPlayerListener;
                if (audioPlayerListener != null) {
                    audioPlayerListener.onPlayerSeek(false, i3);
                }
                this.mPlayer.seekTo(i3);
                return;
            } catch (Exception e16) {
                QMLog.e(TAG, "seekTo.....", e16);
                return;
            }
        }
        this.mStartTime = i3;
    }

    public void setAudioContext(Context context) {
        this.mContext = context;
    }

    public void setAudioFocus(boolean z16) {
        this.audioFocus = z16;
    }

    public void setAudioPlayerListener(AudioPlayerListener audioPlayerListener) {
        this.mPlayerListener = audioPlayerListener;
    }

    public void setDataSource(String str, OnPreparedListener onPreparedListener) {
        this.mSrc = str;
        this.preparedListener = onPreparedListener;
        try {
            this.mDuration = 0;
            resetMediaPlayer();
            this.mPlayer.setDataSource(str);
            notifyPlayerStateChange(0);
            notifyPlayerProgress(0);
            this.mPlayer.prepareAsync();
        } catch (Exception e16) {
            resetMediaPlayer();
            notifyPlayerError(1, 0);
            QMLog.e(TAG, "setDataSource.....", e16);
        }
    }

    public void setLooping(boolean z16) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setLooping(z16);
            } catch (Exception e16) {
                QMLog.e(TAG, "mPlayer.setLooping exception! ", e16);
            }
        }
    }

    public void setStartTime(int i3) {
        this.mStartTime = i3;
    }

    public void setVolume(float f16) {
        try {
            if (this.mPlayer != null && f16 >= 0.0f && f16 <= 1.0f) {
                QMLog.i(TAG, "setVolume:" + f16);
                this.mPlayer.setVolume(f16, f16);
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "setVolume e :" + e16.getMessage());
        }
    }

    public void start() {
        int i3 = this.mState;
        if (i3 == 1 || i3 == 3) {
            try {
                ThreadManager.executeOnComputationThreadPool(this.mStartRunnable);
                muteAudioFocus(this.audioFocus);
                Handler handler = this.mUiHandler;
                if (handler != null) {
                    handler.post(this.mLoopingRunnable);
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "resetMediaPlayer.....", th5);
            }
        }
    }

    public void stop() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            muteAudioFocus(false);
            notifyPlayerProgress(0);
            notifyPlayerStateChange(4);
        }
    }

    public MiniAppAudioPlayer(Handler handler) {
        this.audioFocus = false;
        this.mStartRunnable = new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                if (MiniAppAudioPlayer.this.mPlayer == null) {
                    return;
                }
                try {
                    MiniAppAudioPlayer.this.mPlayer.start();
                    MiniAppAudioPlayer.this.notifyPlayerStateChange(2);
                    if (MiniAppAudioPlayer.this.mStartTime > 0) {
                        MiniAppAudioPlayer miniAppAudioPlayer = MiniAppAudioPlayer.this;
                        miniAppAudioPlayer.seekTo(miniAppAudioPlayer.mStartTime);
                    }
                } catch (Exception e16) {
                    MiniAppAudioPlayer.this.notifyPlayerError(1, 0);
                    QMLog.d(MiniAppAudioPlayer.TAG, "mStartRunnable....." + e16);
                }
            }
        };
        this.mLoopingRunnable = new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                int currentPosition = MiniAppAudioPlayer.this.getCurrentPosition();
                QMLog.d(MiniAppAudioPlayer.TAG, "position:" + currentPosition + "duration:" + MiniAppAudioPlayer.this.mDuration + " " + this);
                MiniAppAudioPlayer.this.notifyPlayerProgress(currentPosition);
                if (MiniAppAudioPlayer.this.mUiHandler != null && MiniAppAudioPlayer.this.getState() == 2) {
                    MiniAppAudioPlayer.this.mUiHandler.postDelayed(this, 300L);
                }
            }
        };
        this.mUiHandler = handler;
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                stop();
            }
        } else {
            initMediaPlayer();
        }
        ScreenOffOnListener.getInstance().registListener(new ScreenOffOnListener.ReceiveListener() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.3
            @Override // com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener.ReceiveListener
            public void onReceiveListener(Context context, Intent intent) {
                String action = intent.getAction();
                QMLog.i(MiniAppAudioPlayer.TAG, "onReceiveListener:" + action);
                if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action) && MiniAppAudioPlayer.this.isPlaying()) {
                    MiniAppAudioPlayer.this.stop();
                }
            }
        });
    }
}
