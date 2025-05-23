package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.downstream.FileDataSink;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.DataSourceException;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.HttpDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.upstream.TracerDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.Thread;
import java.util.List;

/* loaded from: classes23.dex */
public class CommonPlayer extends BaseMediaPlayer {
    private static final int INIT_STATE_CHECK_TIME = 5000;
    private static final String TAG = "CommonPlayer";
    private int currentState;

    @Nullable
    private Looper eventLooper;
    private boolean isMatchHuawei;

    @Nullable
    private CorePlayer mAudioPlayer;
    private int mBufferPercentage;
    private final ListPlayerListenerCallback mCallback;
    private long mDuration;

    @NonNull
    private final QMThreadExecutor mExecutor;
    private String mLocalPlayPath;
    private boolean mPreferMediaCodecDecode;

    @Nullable
    private Float mSpeedToSet;

    @Nullable
    private OpenedResources openedResources;

    /* loaded from: classes23.dex */
    public class CorePlayerCallback implements PlayerCallback {
        private final IDataSource mDataSource;
        private final IDataSourceFactory mFactory;

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerEnded(CorePlayer corePlayer) {
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerEnded() callback ended");
                CommonPlayer.this.TransferStateTo(7);
                CommonPlayer.this.mCallback.onCompletion(CommonPlayer.this);
                return;
            }
            Logger.i(CommonPlayer.TAG, "different playerEnded");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerException(CorePlayer corePlayer, int i3, int i16, int i17) {
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.e(CommonPlayer.TAG, "playerException() callback exception what = " + i3 + ",extra = " + i16 + " mAudioPlayer:" + CommonPlayer.this.mAudioPlayer);
                if (CommonPlayer.this.mAudioPlayer != null) {
                    Logger.e(CommonPlayer.TAG, "handleMessage state = " + CommonPlayer.this.mAudioPlayer.getPlayerState());
                    Logger.e(CommonPlayer.TAG, "handleMessage isInit = " + CommonPlayer.this.mAudioPlayer.isInit() + ",isStartDecode = " + CommonPlayer.this.mAudioPlayer.hasDecodeData() + ",decodeSuccess = " + CommonPlayer.this.mAudioPlayer.hasDecodeDataSuccess());
                }
                if (!CommonPlayer.this.mPreferMediaCodecDecode || i3 != 91) {
                    CommonPlayer.this.onError(i3, i16, i17);
                    return;
                }
                CommonPlayer.this.mPreferMediaCodecDecode = false;
                IDataSourceFactory iDataSourceFactory = this.mFactory;
                if (iDataSourceFactory != null) {
                    try {
                        CommonPlayer.this.setDataSource(iDataSourceFactory);
                        CommonPlayer.this.prepare();
                        return;
                    } catch (Exception e16) {
                        Logger.e(CommonPlayer.TAG, "retry nativeDecoder", e16);
                        CommonPlayer.this.onError(i3, i16, i17);
                        return;
                    }
                }
                IDataSource iDataSource = this.mDataSource;
                if (iDataSource != null) {
                    CommonPlayer.this.setDataSourceInternal(iDataSource);
                    CommonPlayer.this.prepare();
                    return;
                } else {
                    CommonPlayer.this.onError(i3, i16, i17);
                    return;
                }
            }
            Logger.i(CommonPlayer.TAG, "different playerException");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerPaused(CorePlayer corePlayer) {
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerPaused() callback paused");
            } else {
                Logger.i(CommonPlayer.TAG, "different playerPaused");
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerPrepared(CorePlayer corePlayer) {
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerPrepared() callback prepared");
                CommonPlayer.this.TransferStateTo(2);
                CommonPlayer.this.mCallback.onPrepared(CommonPlayer.this);
                return;
            }
            Logger.i(CommonPlayer.TAG, "different playerPrepared");
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerSeekCompletion(CorePlayer corePlayer, int i3) {
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerSeekCompletion() callback seek completion");
                CommonPlayer.this.mCallback.onSeekComplete(CommonPlayer.this, i3);
            } else {
                Logger.i(CommonPlayer.TAG, "different playerSeekCompletion");
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerStarted(CorePlayer corePlayer) {
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerStarted() callback started");
                CommonPlayer.this.mCallback.onStarted(CommonPlayer.this);
            } else {
                Logger.i(CommonPlayer.TAG, "different playerStarted");
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playerStopped(CorePlayer corePlayer) {
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.i(CommonPlayer.TAG, "playerStopped() callback stopped");
            } else {
                Logger.i(CommonPlayer.TAG, "different playerStopped");
            }
        }

        CorePlayerCallback(IDataSourceFactory iDataSourceFactory, IDataSource iDataSource) {
            this.mFactory = iDataSourceFactory;
            this.mDataSource = iDataSource;
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerCallback
        public void playThreadStart(CorePlayer corePlayer) {
        }
    }

    /* loaded from: classes23.dex */
    public static class OpenedResources {

        @Nullable
        private File bufferFile;

        @Nullable
        private CacheDataSource dataSource;

        OpenedResources() {
        }

        public void release() {
            File file = this.bufferFile;
            if (file != null && !file.delete()) {
                Logger.w(CommonPlayer.TAG, "[release] failed to delete buffer file: " + this.bufferFile);
            }
            CacheDataSource cacheDataSource = this.dataSource;
            if (cacheDataSource != null) {
                cacheDataSource.setListener(null);
                this.dataSource.releaseLock();
            }
        }
    }

    public CommonPlayer() {
        this(null, null, false, new QMThreadExecutor() { // from class: com.tencent.qqmusic.mediaplayer.CommonPlayer.1
            @Override // com.tencent.qqmusic.mediaplayer.QMThreadExecutor
            public void execute(Runnable runnable, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
                BaseThread baseThread = new BaseThread(runnable, "decoder");
                baseThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                baseThread.start();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String auxiliary(String str) {
        String str2;
        CorePlayer corePlayer = this.mAudioPlayer;
        if (this.mPreferMediaCodecDecode) {
            str2 = "[MediaCodec]";
        } else {
            str2 = "";
        }
        if (corePlayer == null) {
            return "null";
        }
        return "[" + corePlayer + "]" + str2 + str;
    }

    private void checkToRelease() {
        if (this.currentState == 8) {
            Logger.i(TAG, auxiliary("[checkToRelease]"));
            resetInternal();
            this.mCallback.clear();
        }
    }

    @NonNull
    private Looper insureEventLooper() {
        if (this.eventLooper == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("CommonPlayer_EventHandler_" + hashCode());
            baseHandlerThread.start();
            this.eventLooper = baseHandlerThread.getLooper();
        }
        return this.eventLooper;
    }

    private void onError(int i3, int i16) {
        onError(i3, i16, 0);
    }

    private synchronized void resetInternal() {
        OpenedResources openedResources = this.openedResources;
        if (openedResources != null) {
            openedResources.release();
            this.openedResources = null;
        }
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.release();
            this.mAudioPlayer = null;
        }
        Looper looper = this.eventLooper;
        if (looper != null && looper != Looper.getMainLooper()) {
            this.eventLooper.quitSafely();
            this.eventLooper = null;
        }
        this.mDuration = 0L;
        this.mBufferPercentage = 0;
        this.mSpeedToSet = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSourceInternal(@NonNull IDataSource iDataSource) {
        BaseDecoder nativeDecoder;
        TransferStateTo(1);
        if (this.mPreferMediaCodecDecode) {
            nativeDecoder = new MediaCodecDecoder();
        } else {
            nativeDecoder = new NativeDecoder();
        }
        CorePlayerCallback corePlayerCallback = new CorePlayerCallback(null, iDataSource);
        CorePlayer corePlayer = new CorePlayer(new TracerDataSource(iDataSource), null, corePlayerCallback, insureEventLooper(), nativeDecoder, this.mExecutor);
        this.mAudioPlayer = corePlayer;
        corePlayer.setThreadName(iDataSource.toString());
        setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
    }

    private void setSpeedToCorePlayerIfNeeded(@NonNull CorePlayer corePlayer) {
        Float f16 = this.mSpeedToSet;
        if (f16 != null) {
            corePlayer.setSpeed(f16.floatValue());
            this.mSpeedToSet = null;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void TransferStateTo(int i3) {
        Logger.i("CommonPlayer StateRunner", this.currentState + " -> " + i3);
        this.currentState = i3;
        ListPlayerListenerCallback listPlayerListenerCallback = this.mCallback;
        if (listPlayerListenerCallback != null) {
            listPlayerListenerCallback.onStateChanged(this, i3);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void addAudioListener(@NonNull IAudioListener iAudioListener) {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.addAudioListener(iAudioListener);
        }
    }

    public void addPlayerListenerCallback(PlayerListenerCallback playerListenerCallback) {
        this.mCallback.add(playerListenerCallback);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public SeekTable createSeekTable() throws IllegalStateException {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer == null) {
            return null;
        }
        return corePlayer.createSeekTable();
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void flush() {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer == null) {
            Logger.e(TAG, "[getCurrentFrame] mAudioPlayer is null!");
        } else {
            corePlayer.flush();
        }
    }

    public int getBufferedPercentage() {
        return this.mBufferPercentage;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public AudioInformation getCurrentAudioInformation() {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            return corePlayer.getCurrentAudioInformation();
        }
        return null;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public long getCurrentPosition() throws IllegalStateException {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            return corePlayer.getCurPosition();
        }
        Logger.e(TAG, "getCurrentPosition() mAudioPlayer is null!");
        return 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public long getCurrentPositionFromFile() throws IllegalStateException {
        return 0L;
    }

    public long getDecodePosition() {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            return corePlayer.getCurPositionByDecoder();
        }
        Logger.e(TAG, "getDecodePosition() ERROR : mAudioPlayer is null!");
        return 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public int getDecoderType() {
        if (this.mPreferMediaCodecDecode) {
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public int getDuration() throws IllegalStateException {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            long duration = corePlayer.getDuration();
            this.mDuration = duration;
            return (int) duration;
        }
        Logger.e(TAG, "getDuration() mAudioPlayer is null!");
        long j3 = this.mDuration;
        if (j3 <= 0) {
            j3 = 0;
        }
        return (int) j3;
    }

    public int getPlayerMode() {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            return corePlayer.getPlayerMode();
        }
        return 0;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public int getPlayerState() {
        return this.currentState;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public int getSessionId() {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            return corePlayer.getSessionId();
        }
        return 0;
    }

    public float getSpeed() {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            return corePlayer.getSpeed();
        }
        Float f16 = this.mSpeedToSet;
        if (f16 != null) {
            return f16.floatValue();
        }
        return 1.0f;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public boolean isPlaying() throws IllegalStateException {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            if (corePlayer.getPlayerState() != 4) {
                return false;
            }
            return true;
        }
        Logger.e(TAG, "isPlaying() mAudioPlayer is null!");
        return false;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void pause() throws IllegalStateException {
        TransferStateTo(5);
        Logger.i(TAG, auxiliary("[pause]"));
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.pause(false);
        } else {
            Logger.e(TAG, "pause() mAudioPlayer is null!");
        }
        notifyPauseSong();
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void pauseRealTime() throws IllegalStateException {
        TransferStateTo(5);
        Logger.i(TAG, auxiliary("[pauseRealTime]"));
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.pause(true);
        } else {
            Logger.e(TAG, "pauseRealTime() mAudioPlayer is null!");
        }
        notifyPauseSong();
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void prepare() throws IllegalStateException {
        if (this.currentState == 8) {
            Logger.e(TAG, "prepare already released!");
            return;
        }
        TransferStateTo(3);
        Logger.i(TAG, auxiliary("[prepare]"));
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.prepare();
        } else {
            Logger.e(TAG, "prepare() null mAudioPlayer!");
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void prepareAsync() throws UnSupportMethodException {
        throw new UnSupportMethodException("Soft decode player cannot support prepareAsync");
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void release() throws IllegalStateException {
        TransferStateTo(8);
        Logger.i(TAG, auxiliary("[release]"));
        resetInternal();
        this.mCallback.clear();
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void removeAudioListener(@NonNull IAudioListener iAudioListener) {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.removeAudioListener(iAudioListener);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void reset() throws IllegalStateException {
        TransferStateTo(0);
        Logger.i(TAG, auxiliary("[reset]"));
        resetInternal();
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void seekTo(int i3) throws IllegalStateException {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.seek(i3);
        } else {
            Logger.e(TAG, "seekTo() mAudioPlayer is null!");
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setAudioStreamType(int i3) {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.setAudioStreamType(i3);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(String str) throws IllegalStateException, IllegalArgumentException {
        if (str != null) {
            TransferStateTo(1);
            Logger.i(TAG, "setDataSource, path: " + str);
            this.mBufferPercentage = 100;
            setDataSourceInternal(new FileDataSource(str));
            checkToRelease();
            return;
        }
        Logger.e(TAG, "setDataSource() ERROR:the path is null!");
        throw new IllegalArgumentException("the path is null!");
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setLeastCommonMultiple(int i3) {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.setLeastCommonMultiple(i3);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setPlayLocalPath(String str) {
        this.mLocalPlayPath = str;
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.setPlayPath(str);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setPlayerListenerCallback(PlayerListenerCallback playerListenerCallback) {
        this.mCallback.clear();
        this.mCallback.add(playerListenerCallback);
    }

    public void setPlayerMode(int i3) {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.setPlayerMode(i3);
        }
    }

    public void setSpeed(float f16) {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.setSpeed(f16);
        } else {
            this.mSpeedToSet = Float.valueOf(f16);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setVolume(float f16, float f17) throws IllegalStateException {
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.setVolume(f16, f17);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setWakeMode(Context context, int i3) throws UnSupportMethodException {
        throw new UnSupportMethodException("Soft decode player cannot support setWakeMode");
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void start() throws IllegalStateException {
        TransferStateTo(4);
        Logger.i(TAG, auxiliary("[start]"));
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer != null) {
            corePlayer.play();
        } else {
            Logger.e(TAG, "start() mAudioPlayer is null!");
        }
        notifyStartPlaySong();
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void stop() throws IllegalStateException {
        try {
            TransferStateTo(6);
            Logger.i(TAG, auxiliary("[stop]"));
            CorePlayer corePlayer = this.mAudioPlayer;
            if (corePlayer != null) {
                corePlayer.stop();
            } else {
                Logger.e(TAG, "stop() mAudioPlayer is null!");
            }
        } catch (Exception e16) {
            Logger.e(TAG, e16);
        }
    }

    public CommonPlayer(@Nullable PlayerListenerCallback playerListenerCallback) {
        this(playerListenerCallback, null, false, new QMThreadExecutor() { // from class: com.tencent.qqmusic.mediaplayer.CommonPlayer.2
            @Override // com.tencent.qqmusic.mediaplayer.QMThreadExecutor
            public void execute(Runnable runnable, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
                BaseThread baseThread = new BaseThread(runnable, "decoder");
                baseThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                baseThread.start();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i3, int i16, int i17) {
        TransferStateTo(9);
        Logger.e(TAG, "onError prefer MediaCodec " + this.mPreferMediaCodecDecode);
        this.mCallback.onError(this, i3, i16, i17);
    }

    public CommonPlayer(@Nullable PlayerListenerCallback playerListenerCallback, @Nullable Looper looper, boolean z16, @NonNull QMThreadExecutor qMThreadExecutor) {
        ListPlayerListenerCallback listPlayerListenerCallback = new ListPlayerListenerCallback();
        this.mCallback = listPlayerListenerCallback;
        this.mAudioPlayer = null;
        boolean z17 = false;
        this.currentState = 0;
        this.mSpeedToSet = null;
        this.mPreferMediaCodecDecode = false;
        this.mLocalPlayPath = null;
        this.isMatchHuawei = false;
        if (playerListenerCallback != null) {
            listPlayerListenerCallback.add(playerListenerCallback);
        }
        this.eventLooper = looper;
        int i3 = Build.VERSION.SDK_INT;
        this.mPreferMediaCodecDecode = z16;
        this.mExecutor = qMThreadExecutor;
        if ((Build.MANUFACTURER + Build.BRAND + DeviceInfoMonitor.getModel()).toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI) && i3 >= 26) {
            z17 = true;
        }
        this.isMatchHuawei = z17;
        reset();
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws UnSupportMethodException {
        throw new UnSupportMethodException("Soft decode player cannot support setDataSource by FileDescriptor");
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            setDataSource(uri.toString());
            return;
        }
        if (!scheme.equalsIgnoreCase("http") && !scheme.equalsIgnoreCase("https")) {
            if (scheme.equalsIgnoreCase("content")) {
                return;
            }
            scheme.equalsIgnoreCase("file");
            return;
        }
        setDataSource(new DefaultMediaHTTPService(), uri);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(IMediaHTTPService iMediaHTTPService, Uri uri) throws IllegalStateException, IllegalArgumentException {
        File createTempFile;
        try {
            String str = this.mCacheDir;
            if (str != null && !str.isEmpty()) {
                createTempFile = File.createTempFile("mediaHttpCommonPlayer", "tmp", new File(this.mCacheDir));
            } else {
                createTempFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
            }
            createTempFile.delete();
            if (!createTempFile.createNewFile()) {
                onError(90, 103, 0);
                return;
            }
            String absolutePath = createTempFile.getAbsolutePath();
            CacheDataSource cacheDataSource = new CacheDataSource(new HttpDataSource(uri, null, iMediaHTTPService), new FileDataSource(absolutePath), new FileDataSink(absolutePath), insureEventLooper());
            OpenedResources openedResources = new OpenedResources();
            this.openedResources = openedResources;
            openedResources.bufferFile = createTempFile;
            this.openedResources.dataSource = cacheDataSource;
            cacheDataSource.setListener(new BufferListener());
            setDataSourceInternal(cacheDataSource);
            checkToRelease();
        } catch (IOException unused) {
            onError(90, 103, 0);
        }
    }

    /* loaded from: classes23.dex */
    public class BufferListener implements CacheDataSource.Listener {
        BufferListener() {
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
        public void onBufferEnded() {
            Logger.i(CommonPlayer.TAG, CommonPlayer.this.auxiliary("buffer ended."));
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
        public void onBufferStarted(long j3) {
            Logger.i(CommonPlayer.TAG, CommonPlayer.this.auxiliary("buffer started."));
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
        public long onStreamingError(IOException iOException) {
            Logger.e(CommonPlayer.TAG, CommonPlayer.this.auxiliary("streaming error!"), iOException);
            return -1L;
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
        public void onStreamingFinished() {
            CommonPlayer.this.mBufferPercentage = 100;
            Logger.i(CommonPlayer.TAG, CommonPlayer.this.auxiliary("streaming finished"));
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
        public void onUpStreamTransfer(long j3, long j16) {
            int round;
            if ((CommonPlayer.this.getPlayerState() == 2 || CommonPlayer.this.getPlayerState() == 4) && (round = (int) Math.round((j3 / j16) * 100.0d)) != CommonPlayer.this.mBufferPercentage) {
                CommonPlayer.this.mBufferPercentage = round;
                ListPlayerListenerCallback listPlayerListenerCallback = CommonPlayer.this.mCallback;
                CommonPlayer commonPlayer = CommonPlayer.this;
                listPlayerListenerCallback.onBufferingUpdate(commonPlayer, commonPlayer.mBufferPercentage);
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.TransferListener
        public void onTransferEnd() {
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.TransferListener
        public void onTransferStart() {
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.TransferListener
        public void onBytesTransferred(long j3, long j16) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.TransferListener
        public void onBytesTransferring(long j3, long j16) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.TransferListener
        public void onBytesTransferError(long j3, long j16, long j17) {
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(IDataSourceFactory iDataSourceFactory) throws IllegalArgumentException, DataSourceException {
        if (iDataSourceFactory != null) {
            TransferStateTo(1);
            CorePlayerCallback corePlayerCallback = new CorePlayerCallback(iDataSourceFactory, null);
            if (this.mPreferMediaCodecDecode) {
                this.mAudioPlayer = new CorePlayer(iDataSourceFactory.createDataSource(), null, corePlayerCallback, insureEventLooper(), new MediaCodecDecoder(), this.mExecutor);
            } else {
                INativeDataSource createNativeDataSource = iDataSourceFactory.createNativeDataSource();
                if (createNativeDataSource != null) {
                    this.mAudioPlayer = new CorePlayer(null, createNativeDataSource, corePlayerCallback, insureEventLooper(), new NativeDecoder(), this.mExecutor);
                } else {
                    this.mAudioPlayer = new CorePlayer(iDataSourceFactory.createDataSource(), null, corePlayerCallback, insureEventLooper(), new NativeDecoder(), this.mExecutor);
                }
            }
            this.mAudioPlayer.setThreadName(iDataSourceFactory.toString());
            setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
            String str = this.mLocalPlayPath;
            if (str != null) {
                this.mAudioPlayer.setPlayPath(str);
            }
            checkToRelease();
            return;
        }
        throw new IllegalArgumentException("dataSourceFactory is null!");
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(TrackInfo trackInfo) throws IllegalArgumentException, IllegalStateException, DataSourceException, IOException {
        TransferStateTo(1);
        Logger.i(TAG, "setDataSource, trackInfo.getUri: " + trackInfo.getUri());
        Logger.i(TAG, "setDataSource, trackInfo.range: " + trackInfo.getRange().toString());
        this.mBufferPercentage = 100;
        TrackDataSource trackDataSource = new TrackDataSource(trackInfo);
        List<PlayerListenerCallback> collection = this.mCallback.toCollection();
        this.mCallback.clear();
        this.mCallback.add(trackDataSource);
        this.mCallback.addAll(collection);
        TransferStateTo(1);
        TracerDataSource tracerDataSource = new TracerDataSource(trackDataSource);
        TrackCorePlayer trackCorePlayer = new TrackCorePlayer(tracerDataSource, new CorePlayerCallback(null, tracerDataSource), insureEventLooper(), this.mExecutor);
        this.mAudioPlayer = trackCorePlayer;
        trackDataSource.setTrackStateCallback(trackCorePlayer);
        this.mAudioPlayer.setThreadName(trackDataSource.toString());
        setSpeedToCorePlayerIfNeeded(this.mAudioPlayer);
        checkToRelease();
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseMediaPlayer
    public void setDataSource(Context context, final UriLoader uriLoader) throws DataSourceException {
        setDataSource(new IDataSourceFactory() { // from class: com.tencent.qqmusic.mediaplayer.CommonPlayer.3
            @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
            @NonNull
            public IDataSource createDataSource() throws DataSourceException {
                return CacheDataSource.Factory.createFromUriLoader(uriLoader, CommonPlayer.this.mCacheDir);
            }

            @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
            @Nullable
            public INativeDataSource createNativeDataSource() {
                return null;
            }
        });
    }
}
