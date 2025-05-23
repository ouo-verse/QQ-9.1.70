package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.CpuInfoUtil;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes23.dex */
public class CorePlayer implements Runnable, BaseDecodeDataComponent.HandleDecodeDataCallback {
    private static final AtomicInteger PLAYER_ID_CREATOR = new AtomicInteger(0);
    private static final String TAG = "CorePlayer";
    final List<IAudioListener> mAudioEffectList;

    @NonNull
    private final PlayerCallback mCallback;

    @Nullable
    private IDataSource mDataSource;

    @NonNull
    private final BaseDecoder mDecoder;

    @NonNull
    private final Handler mEventHandler;

    @NonNull
    private final QMThreadExecutor mExecutor;
    protected AudioInformation mInformation;
    volatile boolean mIsExit;

    @Nullable
    private INativeDataSource mNativeDataSource;
    private BaseDecodeDataComponent mPcmCompnent;
    private String mPlayPath;
    private int mPlayerID;
    private int mPlayerMode;

    @Nullable
    private Float mSpeedToSet;

    @NonNull
    private final PlayerStateRunner mStateRunner;
    final List<IAudioListener> mTerminalAudioEffectList;
    private String mThreadName;

    @Nullable
    private PerformanceTracer performanceTracer;
    private int mTargetBitDepth = 2;
    private boolean mIsAudioEffectParamPrepared = false;

    public CorePlayer(@Nullable IDataSource iDataSource, @Nullable INativeDataSource iNativeDataSource, @NonNull PlayerCallback playerCallback, @NonNull Looper looper, @NonNull BaseDecoder baseDecoder, @NonNull QMThreadExecutor qMThreadExecutor) {
        PlayerStateRunner playerStateRunner = new PlayerStateRunner(0);
        this.mStateRunner = playerStateRunner;
        this.mPlayerID = PLAYER_ID_CREATOR.addAndGet(1);
        this.mAudioEffectList = new CopyOnWriteArrayList();
        this.mTerminalAudioEffectList = new CopyOnWriteArrayList();
        this.mSpeedToSet = null;
        this.mThreadName = "Unnamed";
        this.mPlayerMode = 0;
        this.mIsExit = false;
        this.performanceTracer = null;
        this.mPlayPath = null;
        if (iDataSource != null && iNativeDataSource != null) {
            throw new IllegalArgumentException("you can't set IDataSource and INativeDataSource at the same time!");
        }
        if (iDataSource == null && iNativeDataSource == null) {
            throw new IllegalArgumentException("at least on data source is required!");
        }
        this.mEventHandler = new Handler(looper);
        this.mDecoder = baseDecoder;
        this.mDataSource = iDataSource;
        this.mNativeDataSource = iNativeDataSource;
        this.mCallback = playerCallback;
        playerStateRunner.transfer(1);
        this.mExecutor = qMThreadExecutor;
    }

    private String axiliary(String str) {
        return "ID: " + this.mPlayerID + ". " + str;
    }

    private void callExceptionCallback(int i3, int i16) {
        callExceptionCallback(i3, i16, 0);
    }

    private void decodeEndOrFailed(int i3, int i16) {
        Logger.d(TAG, axiliary("decodeEndOrFailed"));
        try {
            if (this.mPcmCompnent == null) {
                Logger.e(TAG, axiliary("mPcmCompnent null! Exiting"));
                return;
            }
            if (this.mInformation != null) {
                Logger.i(TAG, axiliary(String.format("current: %d, duration: %d, isExit: %b, decodeSucc: %b", Long.valueOf(this.mDecoder.getCurrentTime()), Long.valueOf(this.mInformation.getDuration()), Boolean.valueOf(this.mIsExit), Boolean.valueOf(this.mPcmCompnent.hasDecodeDataSuccess()))));
                i3 &= this.mDecoder.getErrorCodeMask();
            }
            int i17 = 68;
            if (!this.mIsExit && this.mPcmCompnent.hasDecodeDataSuccess()) {
                if (getCurPositionByDecoder() < getDuration() - 5000) {
                    Logger.e(TAG, axiliary("Decode failed! Exiting."));
                    if (TextUtils.isEmpty(this.mPlayPath) || !isPathExternalStorage(this.mPlayPath)) {
                        i17 = 67;
                    }
                    callExceptionCallback(i16, i17, i3);
                    this.mStateRunner.transfer(6);
                    return;
                }
                if (i16 == 92) {
                    Logger.i(TAG, axiliary("Decode ended! Exiting."));
                    this.mStateRunner.transfer(7);
                    return;
                }
                return;
            }
            Logger.i(TAG, axiliary("\u4e0d\u7559\u75d5\u8ff9\u7684\u9000\u51fa \u65f6\u673a\uff1a\u89e3\u7801\u65f6\u9000\u51fa  step = 4"));
            exitNotCallback();
            this.mStateRunner.transfer(9);
            if (TextUtils.isEmpty(this.mPlayPath) || !isPathExternalStorage(this.mPlayPath)) {
                i17 = 67;
            }
            callExceptionCallback(i16, i17, i3);
        } catch (Throwable th5) {
            Logger.e(TAG, th5);
        }
    }

    private void exitNotCallback() {
        Logger.i(TAG, axiliary("exitNotCallback"));
        this.mIsExit = true;
    }

    private boolean isPathExternalStorage(@NonNull String str) {
        if (!str.contains("emulated/0") && !str.contains("sdcard0")) {
            return true;
        }
        return false;
    }

    public void addAudioListener(@NonNull IAudioListener iAudioListener) {
        long j3;
        if (iAudioListener.isTerminal()) {
            if (!this.mTerminalAudioEffectList.contains(iAudioListener)) {
                this.mTerminalAudioEffectList.add(iAudioListener);
                Logger.i(TAG, "[addAudioListener] terminal audio added: " + iAudioListener);
            }
        } else if (!this.mAudioEffectList.contains(iAudioListener)) {
            this.mAudioEffectList.add(iAudioListener);
            Logger.i(TAG, "[addAudioListener] audio added: " + iAudioListener);
        }
        if (this.mIsAudioEffectParamPrepared) {
            try {
                j3 = iAudioListener.onPlayerReady(this.mTargetBitDepth, this.mInformation, getCurPosition());
            } catch (Throwable th5) {
                Logger.e(TAG, "[addAudioListener] failed to init audio: " + iAudioListener, th5);
                j3 = 0L;
            }
            if (j3 != 0) {
                Logger.e(TAG, "[addAudioListener] failed to init audio %s, ret: %d", iAudioListener, Long.valueOf(j3));
                return;
            }
            return;
        }
        Logger.i(TAG, "[addAudioListener] audio information not ready. init will be delayed.");
    }

    public void changePlayThreadPriorityImmediately() {
        Logger.d(TAG, axiliary("changePlayThreadPriorityImmediately"));
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent == null) {
            return;
        }
        baseDecodeDataComponent.changePlayThreadPriorityImmediately();
    }

    public SeekTable createSeekTable() {
        BaseDecoder baseDecoder = this.mDecoder;
        if (baseDecoder != null) {
            return new NativeSeekTable(baseDecoder);
        }
        throw new IllegalStateException("please setDataSource before creating seek table!");
    }

    public void flush() {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent != null) {
            baseDecodeDataComponent.flush();
        }
    }

    public long getCurPosition() {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent == null) {
            return 0L;
        }
        return baseDecodeDataComponent.getCurPosition();
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public long getCurPositionByDecoder() {
        try {
            return this.mDecoder.getCurrentTime();
        } catch (SoNotFindException e16) {
            Logger.e(TAG, e16);
            return 0L;
        } catch (Throwable th5) {
            Logger.e(TAG, "Strange Exception!", th5);
            return 0L;
        }
    }

    public AudioInformation getCurrentAudioInformation() {
        return this.mInformation;
    }

    public long getDuration() {
        AudioInformation audioInformation = this.mInformation;
        if (audioInformation != null) {
            try {
                return audioInformation.getDuration();
            } catch (Throwable th5) {
                Logger.e(TAG, th5);
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public long getMinPcmBufferSize() {
        return this.mDecoder.getMinBufferSize();
    }

    public int getPlayerMode() {
        return this.mPlayerMode;
    }

    public int getPlayerState() {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent == null) {
            return 0;
        }
        return baseDecodeDataComponent.getPlayerState();
    }

    public int getSessionId() {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent != null) {
            return baseDecodeDataComponent.getSessionId();
        }
        return 0;
    }

    public float getSpeed() {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent != null) {
            return baseDecodeDataComponent.getSpeed();
        }
        Float f16 = this.mSpeedToSet;
        if (f16 != null) {
            return f16.floatValue();
        }
        return 1.0f;
    }

    public synchronized boolean hasDecodeData() {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent == null) {
            return false;
        }
        return baseDecodeDataComponent.hasDecodeData();
    }

    public synchronized boolean hasDecodeDataSuccess() {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent == null) {
            return false;
        }
        return baseDecodeDataComponent.hasDecodeDataSuccess();
    }

    public boolean isInit() {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent == null) {
            return false;
        }
        return baseDecodeDataComponent.isInit();
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public void onAudioTrackChanged(AudioTrack audioTrack) {
        this.mDecoder.setAudioTrack(audioTrack);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public void onPullDecodeDataEndOrFailed(int i3, int i16) {
        decodeEndOrFailed(i3, i16);
    }

    public void pause(boolean z16) {
        Logger.i(TAG, axiliary("pause"));
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent == null) {
            return;
        }
        baseDecodeDataComponent.pause(z16);
    }

    public void play() {
        Logger.i(TAG, axiliary("play"));
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent == null) {
            return;
        }
        baseDecodeDataComponent.play();
    }

    public void prepare() {
        Logger.i(TAG, axiliary("prepare"));
        this.mStateRunner.transfer(3);
        this.mExecutor.execute(this, null);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public int pullDecodeData(int i3, byte[] bArr) {
        return this.mDecoder.decodeData(i3, bArr);
    }

    public void release() {
        Logger.i(TAG, axiliary("release"));
        this.mEventHandler.removeCallbacksAndMessages(null);
        exitNotCallback();
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent != null) {
            baseDecodeDataComponent.releaseNotify();
        }
        this.mStateRunner.transfer(8);
    }

    public void removeAudioListener(@NonNull IAudioListener iAudioListener) {
        if (this.mAudioEffectList.remove(iAudioListener)) {
            Logger.i(TAG, "[removeAudioListener] audio removed: " + iAudioListener);
        }
        if (this.mTerminalAudioEffectList.remove(iAudioListener)) {
            Logger.i(TAG, "[removeAudioListener] terminal audio removed: " + iAudioListener);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:1|2|3|(1:5)(2:163|(1:165)(1:166))|6|(2:8|(1:128)(1:12))(1:(14:130|(2:132|(1:160)(1:136))(1:161)|137|138|(1:140)(1:159)|141|142|143|144|(2:151|152)|146|(1:148)|149|150)(1:162))|13|14|15|(3:45|46|(20:50|(21:55|56|57|58|59|60|61|(1:63)|18|(1:20)|22|(1:24)(1:44)|25|26|27|28|(2:36|37)|30|(1:32)|33|34)|117|(1:119)|120|61|(0)|18|(0)|22|(0)(0)|25|26|27|28|(0)|30|(0)|33|34))|17|18|(0)|22|(0)(0)|25|26|27|28|(0)|30|(0)|33|34|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0281, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0282, code lost:
    
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r4, axiliary("release throw a exception = " + r0.getMessage()), r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x024b A[Catch: all -> 0x02eb, TRY_LEAVE, TryCatch #5 {all -> 0x02eb, blocks: (B:60:0x01eb, B:61:0x0225, B:63:0x0229, B:18:0x0247, B:20:0x024b, B:117:0x01f6, B:119:0x0202, B:120:0x0204), top: B:15:0x01a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0229 A[Catch: all -> 0x02eb, TryCatch #5 {all -> 0x02eb, blocks: (B:60:0x01eb, B:61:0x0225, B:63:0x0229, B:18:0x0247, B:20:0x024b, B:117:0x01f6, B:119:0x0202, B:120:0x0204), top: B:15:0x01a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03c5 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0431 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x040d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03de A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11, types: [int] */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v2, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v9 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str;
        String str2;
        String str3;
        int i3;
        int i16;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z16;
        Float f16;
        BaseDecodeDataComponent baseDecodeDataComponent;
        String str8;
        IDataSource iDataSource;
        BaseDecodeDataComponent baseDecodeDataComponent2;
        ?? r132 = "exit, thread: ";
        CpuInfoUtil.startProcessInfoOutput();
        Logger.i(TAG, axiliary("run, thread: " + Thread.currentThread().getName()));
        int i17 = 62;
        try {
            this.mCallback.playThreadStart(this);
            IDataSource iDataSource2 = this.mDataSource;
            if (iDataSource2 != null) {
                i3 = this.mDecoder.init(iDataSource2);
                Logger.i(TAG, axiliary("mDecoder init from dataSource: " + i3));
            } else {
                INativeDataSource iNativeDataSource = this.mNativeDataSource;
                if (iNativeDataSource != null) {
                    i3 = this.mDecoder.init(iNativeDataSource);
                    Logger.i(TAG, axiliary("mDecoder init from native dataSource: " + i3));
                } else {
                    Logger.i(TAG, axiliary("[run] no dataSource!"));
                    i3 = -1;
                }
            }
            if (i3 == -9) {
                Logger.e(TAG, axiliary("empty file, maybe external sdcard or other permission issue"));
                this.mStateRunner.transfer(9);
                if (!TextUtils.isEmpty(this.mPlayPath) && isPathExternalStorage(this.mPlayPath)) {
                    callExceptionCallback(91, 100);
                } else {
                    callExceptionCallback(91, 200);
                }
            } else {
                if (i3 != 0) {
                    Logger.e(TAG, axiliary("\u4e0d\u7559\u75d5\u8ff9\u7684\u9000\u51fa \u65f6\u673a\uff1a\u521d\u59cb\u5316\u65f6 step = 1"));
                    this.mStateRunner.transfer(9);
                    if (i3 == -2) {
                        if (!TextUtils.isEmpty(this.mPlayPath) && isPathExternalStorage(this.mPlayPath)) {
                            i16 = 56;
                        } else {
                            i16 = 55;
                        }
                    } else {
                        i16 = 62;
                    }
                    callExceptionCallback(91, i16);
                    if (this.mPcmCompnent != null) {
                        Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
                    } else {
                        Logger.e(TAG, axiliary("thread finally, ERROR!!!, no mPcmCompnent"));
                    }
                    CpuInfoUtil.stopProcessInfoOutput();
                    try {
                        this.mDecoder.release();
                    } catch (Throwable th5) {
                        Logger.e(TAG, axiliary("release throw a exception = " + th5.getMessage()), th5);
                    }
                    IDataSource iDataSource3 = this.mDataSource;
                    if (iDataSource3 != null) {
                        try {
                            iDataSource3.close();
                        } catch (IOException e16) {
                            Logger.e(TAG, axiliary("release dataSource throw a exception = " + e16.getMessage()), e16);
                        }
                    }
                    BaseDecodeDataComponent baseDecodeDataComponent3 = this.mPcmCompnent;
                    if (baseDecodeDataComponent3 != null) {
                        baseDecodeDataComponent3.release();
                    }
                    this.mPlayerMode = 0;
                    Logger.i(TAG, axiliary("exit, thread: " + Thread.currentThread().getName()));
                    return;
                }
                this.mInformation = this.mDecoder.getAudioInformation();
            }
            try {
                PlayerConfigManager.getInstance().setCommonPlayerRef(this);
                try {
                    if (this.mInformation != null) {
                        try {
                            if (!this.mIsExit && this.mPcmCompnent == null) {
                                if (this.mInformation.getDuration() >= 2000 && this.mPlayerMode != 1) {
                                    PlayerStateRunner playerStateRunner = this.mStateRunner;
                                    AudioInformation audioInformation = this.mInformation;
                                    PlayerCallback playerCallback = this.mCallback;
                                    Handler handler = this.mEventHandler;
                                    int i18 = this.mPlayerID;
                                    AudioListenerDelegate audioListenerDelegate = new AudioListenerDelegate(false);
                                    try {
                                        AudioListenerDelegate audioListenerDelegate2 = new AudioListenerDelegate(true);
                                        str7 = "exit, thread: ";
                                        z16 = false;
                                        str5 = TAG;
                                        str6 = "thread finally, ERROR!!!, no mPcmCompnent";
                                        this.mPcmCompnent = new StreamDecodeDataComponent(this, playerStateRunner, audioInformation, playerCallback, this, handler, i18, audioListenerDelegate, audioListenerDelegate2);
                                        f16 = this.mSpeedToSet;
                                        r132 = z16;
                                        if (f16 != null) {
                                            this.mPcmCompnent.setSpeed(f16.floatValue());
                                            this.mSpeedToSet = null;
                                            r132 = z16;
                                        }
                                        baseDecodeDataComponent = this.mPcmCompnent;
                                        if (baseDecodeDataComponent != null) {
                                            baseDecodeDataComponent.handleDecodeData();
                                        }
                                        if (this.mPcmCompnent != null) {
                                            str8 = str5;
                                            Logger.i(str8, axiliary("thread finally, mIsExit = " + this.mIsExit));
                                        } else {
                                            str8 = str5;
                                            Logger.e(str8, axiliary(str6));
                                        }
                                        CpuInfoUtil.stopProcessInfoOutput();
                                        this.mDecoder.release();
                                        iDataSource = this.mDataSource;
                                        if (iDataSource != null) {
                                            try {
                                                iDataSource.close();
                                            } catch (IOException e17) {
                                                Logger.e(str8, axiliary("release dataSource throw a exception = " + e17.getMessage()), e17);
                                            }
                                        }
                                        baseDecodeDataComponent2 = this.mPcmCompnent;
                                        if (baseDecodeDataComponent2 != null) {
                                            baseDecodeDataComponent2.release();
                                        }
                                        this.mPlayerMode = r132;
                                        Logger.i(str8, axiliary(str7 + Thread.currentThread().getName()));
                                    } catch (Throwable th6) {
                                        th = th6;
                                        str4 = "exit, thread: ";
                                        r132 = 0;
                                        str = TAG;
                                        str2 = "thread finally, ERROR!!!, no mPcmCompnent";
                                        str3 = str4;
                                        try {
                                            Logger.e(str, th);
                                        } finally {
                                            if (this.mPcmCompnent != null) {
                                                Logger.i(str, axiliary("thread finally, mIsExit = " + this.mIsExit));
                                            } else {
                                                Logger.e(str, axiliary(str2));
                                            }
                                            CpuInfoUtil.stopProcessInfoOutput();
                                            try {
                                                this.mDecoder.release();
                                            } catch (Throwable th7) {
                                                Logger.e(str, axiliary("release throw a exception = " + th7.getMessage()), th7);
                                            }
                                            IDataSource iDataSource4 = this.mDataSource;
                                            if (iDataSource4 != null) {
                                                try {
                                                    iDataSource4.close();
                                                } catch (IOException e18) {
                                                    Logger.e(str, axiliary("release dataSource throw a exception = " + e18.getMessage()), e18);
                                                }
                                            }
                                            BaseDecodeDataComponent baseDecodeDataComponent4 = this.mPcmCompnent;
                                            if (baseDecodeDataComponent4 != null) {
                                                baseDecodeDataComponent4.release();
                                            }
                                            this.mPlayerMode = r132;
                                            Logger.i(str, axiliary(str3 + Thread.currentThread().getName()));
                                        }
                                    }
                                }
                                str5 = TAG;
                                str6 = "thread finally, ERROR!!!, no mPcmCompnent";
                                str7 = "exit, thread: ";
                                z16 = false;
                                if (this.mPlayerMode != 1) {
                                    this.mPlayerMode = 1;
                                }
                                this.mPcmCompnent = new StaticDecodeDataComponent(this, this.mStateRunner, this.mInformation, this.mCallback, this, this.mEventHandler, this.mPlayerID, new AudioListenerDelegate(false), new AudioListenerDelegate(true));
                                f16 = this.mSpeedToSet;
                                r132 = z16;
                                if (f16 != null) {
                                }
                                baseDecodeDataComponent = this.mPcmCompnent;
                                if (baseDecodeDataComponent != null) {
                                }
                                if (this.mPcmCompnent != null) {
                                }
                                CpuInfoUtil.stopProcessInfoOutput();
                                this.mDecoder.release();
                                iDataSource = this.mDataSource;
                                if (iDataSource != null) {
                                }
                                baseDecodeDataComponent2 = this.mPcmCompnent;
                                if (baseDecodeDataComponent2 != null) {
                                }
                                this.mPlayerMode = r132;
                                Logger.i(str8, axiliary(str7 + Thread.currentThread().getName()));
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            str4 = "exit, thread: ";
                            r132 = 0;
                        }
                    }
                    str5 = TAG;
                    str6 = "thread finally, ERROR!!!, no mPcmCompnent";
                    str7 = "exit, thread: ";
                    r132 = 0;
                    baseDecodeDataComponent = this.mPcmCompnent;
                    if (baseDecodeDataComponent != null) {
                    }
                    if (this.mPcmCompnent != null) {
                    }
                    CpuInfoUtil.stopProcessInfoOutput();
                    this.mDecoder.release();
                    iDataSource = this.mDataSource;
                    if (iDataSource != null) {
                    }
                    baseDecodeDataComponent2 = this.mPcmCompnent;
                    if (baseDecodeDataComponent2 != null) {
                    }
                    this.mPlayerMode = r132;
                    Logger.i(str8, axiliary(str7 + Thread.currentThread().getName()));
                } catch (Throwable th9) {
                    th = th9;
                    str3 = str7;
                    str = str5;
                    str2 = str6;
                }
            } catch (Throwable th10) {
                th = th10;
                str = TAG;
                str2 = "thread finally, ERROR!!!, no mPcmCompnent";
                str3 = "exit, thread: ";
                r132 = 0;
            }
        } catch (Throwable th11) {
            str = TAG;
            str2 = "thread finally, ERROR!!!, no mPcmCompnent";
            str3 = "exit, thread: ";
            r132 = 0;
            try {
                if (th11 instanceof SoNotFindException) {
                    i17 = 69;
                } else if (th11 instanceof UnsatisfiedLinkError) {
                    i17 = 60;
                }
                Logger.e(str, axiliary("\u4e0d\u7559\u75d5\u8ff9\u7684\u9000\u51fa \u65f6\u673a\uff1a\u521d\u59cb\u5316\u65f6 step = 2"));
                this.mStateRunner.transfer(9);
                callExceptionCallback(91, i17);
                Logger.e(str, "[run] init decoder throws an exception!", th11);
                if (this.mPcmCompnent != null) {
                    Logger.i(str, axiliary("thread finally, mIsExit = " + this.mIsExit));
                } else {
                    Logger.e(str, axiliary(str2));
                }
                CpuInfoUtil.stopProcessInfoOutput();
                try {
                    this.mDecoder.release();
                } catch (Throwable th12) {
                    Logger.e(str, axiliary("release throw a exception = " + th12.getMessage()), th12);
                }
                IDataSource iDataSource5 = this.mDataSource;
                if (iDataSource5 != null) {
                    try {
                        iDataSource5.close();
                    } catch (IOException e19) {
                        Logger.e(str, axiliary("release dataSource throw a exception = " + e19.getMessage()), e19);
                    }
                }
                BaseDecodeDataComponent baseDecodeDataComponent5 = this.mPcmCompnent;
                if (baseDecodeDataComponent5 != null) {
                    baseDecodeDataComponent5.release();
                }
                this.mPlayerMode = 0;
                Logger.i(str, axiliary(str3 + Thread.currentThread().getName()));
            } catch (Throwable th13) {
                th = th13;
                Logger.e(str, th);
            }
        }
    }

    public void seek(int i3) {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent != null) {
            baseDecodeDataComponent.seek(i3);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public int seekTo(int i3) {
        return this.mDecoder.seekTo(i3);
    }

    public void setAudioStreamType(int i3) {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent != null) {
            baseDecodeDataComponent.setAudioStreamType(i3);
        }
    }

    public void setLeastCommonMultiple(int i3) {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent != null) {
            baseDecodeDataComponent.setLeastCommonMultiple(i3);
        }
    }

    public void setPlayPath(String str) {
        this.mPlayPath = str;
    }

    public void setPlayerMode(int i3) {
        this.mPlayerMode = i3;
    }

    public void setSpeed(float f16) {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent == null) {
            this.mSpeedToSet = Float.valueOf(f16);
        } else {
            baseDecodeDataComponent.setSpeed(f16);
        }
    }

    public void setThreadName(String str) {
        this.mThreadName = str;
    }

    public void setVolume(float f16, float f17) {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent != null) {
            baseDecodeDataComponent.setVolume(f16, f17);
        }
    }

    public void setVolumeForHuawei(float f16, float f17) {
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent != null) {
            baseDecodeDataComponent.setVolumeForHuawei(f16, f17);
        }
    }

    public void stop() {
        Logger.i(TAG, axiliary("stop"));
        BaseDecodeDataComponent baseDecodeDataComponent = this.mPcmCompnent;
        if (baseDecodeDataComponent == null) {
            exitNotCallback();
        } else {
            baseDecodeDataComponent.stop();
        }
    }

    private void callExceptionCallback(int i3, int i16, int i17) {
        this.mCallback.playerException(this, i3, i16, i17);
    }

    /* loaded from: classes23.dex */
    public class AudioListenerDelegate implements IAudioListener {
        private final boolean mIsTerminal;

        public AudioListenerDelegate(boolean z16) {
            this.mIsTerminal = z16;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public long getActualTime(long j3) {
            Iterator<IAudioListener> it = getAudioListeners().iterator();
            while (it.hasNext()) {
                j3 = it.next().getActualTime(j3);
            }
            return j3;
        }

        @NonNull
        public List<IAudioListener> getAudioListeners() {
            if (this.mIsTerminal) {
                return CorePlayer.this.mTerminalAudioEffectList;
            }
            return CorePlayer.this.mAudioEffectList;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public boolean isEnabled() {
            Iterator<IAudioListener> it = getAudioListeners().iterator();
            while (it.hasNext()) {
                if (it.next().isEnabled()) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public boolean isTerminal() {
            return this.mIsTerminal;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public boolean onPcm(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j3) {
            BufferInfo bufferInfo3;
            boolean z16;
            boolean z17 = false;
            if (!this.mIsTerminal) {
                List<IAudioListener> list = CorePlayer.this.mAudioEffectList;
                if (list.size() == 0) {
                    bufferInfo.fillInto(bufferInfo2);
                } else {
                    BufferInfo bufferInfo4 = bufferInfo;
                    BufferInfo bufferInfo5 = bufferInfo2;
                    for (IAudioListener iAudioListener : list) {
                        if (iAudioListener.isEnabled()) {
                            try {
                                bufferInfo5.setByteBufferCapacity(bufferInfo4.bufferSize);
                                z16 = iAudioListener.onPcm(bufferInfo4, bufferInfo5, j3);
                            } catch (Throwable th5) {
                                Logger.e(CorePlayer.TAG, "[onPcm] failed. audio: " + iAudioListener + " e: " + th5);
                                z16 = false;
                            }
                            if (z16) {
                                BufferInfo bufferInfo6 = bufferInfo5;
                                bufferInfo5 = bufferInfo4;
                                bufferInfo4 = bufferInfo6;
                            } else {
                                bufferInfo4.fillInto(bufferInfo5);
                            }
                        } else {
                            bufferInfo4.fillInto(bufferInfo5);
                        }
                        int i3 = bufferInfo5.bufferSize;
                    }
                    if (bufferInfo4 == bufferInfo) {
                        bufferInfo.fillInto(bufferInfo2);
                    }
                }
            } else {
                List<IAudioListener> list2 = CorePlayer.this.mTerminalAudioEffectList;
                if (list2.size() == 0) {
                    bufferInfo.fillInto(bufferInfo2);
                } else {
                    int size = list2.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        IAudioListener iAudioListener2 = list2.get(size);
                        if (iAudioListener2.isEnabled()) {
                            try {
                                bufferInfo2.setByteBufferCapacity(bufferInfo.bufferSize);
                                z17 = iAudioListener2.onPcm(bufferInfo, bufferInfo2, j3);
                            } catch (Throwable th6) {
                                Logger.e(CorePlayer.TAG, "[onPcm] failed. audio: " + iAudioListener2 + " e: " + th6);
                            }
                            if (z17) {
                                bufferInfo3 = bufferInfo2;
                            } else {
                                bufferInfo.fillInto(bufferInfo2);
                            }
                        } else {
                            bufferInfo.fillInto(bufferInfo2);
                            size--;
                        }
                    }
                    bufferInfo3 = bufferInfo;
                    if (bufferInfo3 == bufferInfo) {
                        bufferInfo.fillInto(bufferInfo2);
                    }
                }
            }
            return true;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public long onPlayerReady(int i3, AudioInformation audioInformation, long j3) {
            CorePlayer.this.mTargetBitDepth = i3;
            CorePlayer.this.mIsAudioEffectParamPrepared = true;
            Iterator<IAudioListener> it = getAudioListeners().iterator();
            while (it.hasNext()) {
                it.next().onPlayerReady(i3, audioInformation, j3);
            }
            return 0L;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public void onPlayerSeekComplete(long j3) {
            Iterator<IAudioListener> it = getAudioListeners().iterator();
            while (it.hasNext()) {
                it.next().onPlayerSeekComplete(j3);
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public void onPlayerStopped() {
            Iterator<IAudioListener> it = getAudioListeners().iterator();
            while (it.hasNext()) {
                it.next().onPlayerStopped();
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
        public boolean onPcm(FloatBufferInfo floatBufferInfo, FloatBufferInfo floatBufferInfo2, long j3) {
            FloatBufferInfo floatBufferInfo3;
            boolean z16;
            boolean z17 = false;
            if (!this.mIsTerminal) {
                List<IAudioListener> list = CorePlayer.this.mAudioEffectList;
                if (list.size() == 0) {
                    floatBufferInfo.copy(floatBufferInfo2);
                } else {
                    FloatBufferInfo floatBufferInfo4 = floatBufferInfo;
                    FloatBufferInfo floatBufferInfo5 = floatBufferInfo2;
                    for (IAudioListener iAudioListener : list) {
                        if (iAudioListener.isEnabled()) {
                            try {
                                floatBufferInfo5.setFloatBufferCapacity(floatBufferInfo4.bufferSize);
                                z16 = iAudioListener.onPcm(floatBufferInfo4, floatBufferInfo5, j3);
                            } catch (Throwable th5) {
                                Logger.e(CorePlayer.TAG, "[onPcm] failed. audio: " + iAudioListener + " e: " + th5);
                                z16 = false;
                            }
                            if (z16) {
                                FloatBufferInfo floatBufferInfo6 = floatBufferInfo5;
                                floatBufferInfo5 = floatBufferInfo4;
                                floatBufferInfo4 = floatBufferInfo6;
                            } else {
                                floatBufferInfo4.copy(floatBufferInfo5);
                            }
                        } else {
                            floatBufferInfo4.copy(floatBufferInfo5);
                        }
                        int i3 = floatBufferInfo5.bufferSize;
                    }
                    if (floatBufferInfo4 == floatBufferInfo) {
                        floatBufferInfo.copy(floatBufferInfo2);
                    }
                }
            } else {
                List<IAudioListener> list2 = CorePlayer.this.mTerminalAudioEffectList;
                if (list2.size() == 0) {
                    floatBufferInfo.copy(floatBufferInfo2);
                } else {
                    int size = list2.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        IAudioListener iAudioListener2 = list2.get(size);
                        if (iAudioListener2.isEnabled()) {
                            try {
                                floatBufferInfo2.setFloatBufferCapacity(floatBufferInfo.bufferSize);
                                z17 = iAudioListener2.onPcm(floatBufferInfo, floatBufferInfo2, j3);
                            } catch (Throwable th6) {
                                Logger.e(CorePlayer.TAG, "[onPcm] failed. audio: " + iAudioListener2 + " e: " + th6);
                            }
                            if (z17) {
                                floatBufferInfo3 = floatBufferInfo2;
                            } else {
                                floatBufferInfo.copy(floatBufferInfo2);
                            }
                        } else {
                            floatBufferInfo.copy(floatBufferInfo2);
                            size--;
                        }
                    }
                    floatBufferInfo3 = floatBufferInfo;
                    if (floatBufferInfo3 == floatBufferInfo) {
                        floatBufferInfo.copy(floatBufferInfo2);
                    }
                }
            }
            return true;
        }
    }
}
