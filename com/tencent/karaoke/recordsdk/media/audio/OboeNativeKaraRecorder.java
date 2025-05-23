package com.tencent.karaoke.recordsdk.media.audio;

import android.annotation.SuppressLint;
import android.os.Process;
import com.tencent.component.utils.LogUtil;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.karaoke.audiobasesdk.IKaraResampler;
import com.tencent.karaoke.audiobasesdk.KaraResampler;
import com.tencent.karaoke.audiobasesdk.SimpleKaraResampler;
import com.tencent.karaoke.recordsdk.media.NativeKaraRecorderBase;
import com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.nio.ByteBuffer;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@SuppressLint({"NewApi"})
@Deprecated
/* loaded from: classes7.dex */
public class OboeNativeKaraRecorder extends NativeKaraRecorderBase implements oy4.a {
    private static final String TAG = "OboeNativeKaraRecorder";
    private static boolean mIsLoaded = false;
    private long mEngineHandle;
    private volatile boolean mIsValid;
    private NativeRecordThread mRecordThread;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class NativeRecordThread extends AbstractKaraRecorder.RecordThread {
        private byte[] C;

        public NativeRecordThread(String str) {
            super(str);
            if (((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).isUseNewResampler) {
                this.C = new byte[((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer.capacity() * 2];
            } else if (((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mSimpleKaraResampler == null) {
                this.C = new byte[((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer.capacity() * 2];
            } else {
                this.C = new byte[((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mResampleBuffer.capacity() * 2];
            }
        }

        private void o() {
            synchronized (OboeNativeKaraRecorder.this.mCurrentState) {
                if (!OboeNativeKaraRecorder.this.mSeekRequests.isEmpty()) {
                    AbstractKaraRecorder.c removeLast = OboeNativeKaraRecorder.this.mSeekRequests.removeLast();
                    OboeNativeKaraRecorder.this.mSeekRequests.clear();
                    OboeNativeKaraRecorder.this.mSyncPosition = 0;
                    c(removeLast);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x013a A[Catch: all -> 0x01bb, TRY_LEAVE, TryCatch #2 {, blocks: (B:24:0x0049, B:26:0x005f, B:28:0x0067, B:30:0x007f, B:34:0x009a, B:35:0x00b2, B:32:0x00b5, B:40:0x0127, B:42:0x013a, B:43:0x0180, B:56:0x00c1, B:58:0x00c9, B:59:0x00d5, B:63:0x00ef, B:64:0x0107, B:61:0x010a, B:67:0x016d, B:70:0x017a), top: B:23:0x0049, inners: #3 }] */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int remaining;
            long j3;
            Process.setThreadPriority(-19);
            byte[] bArr = new byte[4096];
            synchronized (OboeNativeKaraRecorder.this.mCurrentState) {
                while (OboeNativeKaraRecorder.this.mCurrentState.a(2)) {
                    o();
                    if (OboeNativeKaraRecorder.this.mCurrentState.a(2)) {
                        try {
                            LockMethodProxy.wait(OboeNativeKaraRecorder.this.mCurrentState);
                        } catch (InterruptedException e16) {
                            LogUtil.w("NativeKaraRecorder_RecordThread", "pause state is interrupted", e16);
                        }
                    }
                }
            }
            while (true) {
                if (!((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mIsRecord) {
                    break;
                }
                synchronized (((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer) {
                    ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer.flip();
                    remaining = ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer.remaining();
                    if (remaining != 0) {
                        if (((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).isUseNewResampler) {
                            ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer.get(this.C, 0, remaining);
                            OboeNativeKaraRecorder.this.getClass();
                            if (((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mKaraResampler != null) {
                                remaining = ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mKaraResampler.resample(this.C, remaining, ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mNewResampleBuffer, ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mNewResampleBuffer.length);
                                if (remaining < 0) {
                                    LogUtil.e("NativeKaraRecorder_RecordThread", "resample failed: " + remaining);
                                } else {
                                    System.arraycopy(((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mNewResampleBuffer, 0, this.C, 0, remaining);
                                }
                            }
                            ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer.clear();
                            j3 = OboeNativeKaraRecorder.this.mSyncTimeMillis;
                            if (j3 > 0) {
                                OboeNativeKaraRecorder.this.mSyncPosition = wz0.a.c((((int) (j3 - System.currentTimeMillis())) / 10) * 10);
                                OboeNativeKaraRecorder.this.mSyncTimeMillis = 0L;
                                LogUtil.i("NativeKaraRecorder_RecordThread", "Sync Position: " + OboeNativeKaraRecorder.this.mSyncPosition);
                            }
                        } else {
                            if (((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mSimpleKaraResampler == null) {
                                ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer.get(this.C, 0, remaining);
                            } else {
                                int resample = ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mSimpleKaraResampler.resample(((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer, remaining / 2, ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mResampleBuffer);
                                if (resample < 0) {
                                    LogUtil.e("NativeKaraRecorder_RecordThread", "resample failed: " + resample);
                                } else {
                                    remaining = Math.min(resample * 2, this.C.length);
                                    ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mResampleBuffer.get(this.C, 0, remaining);
                                    ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mResampleBuffer.clear();
                                }
                            }
                            ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer.clear();
                            j3 = OboeNativeKaraRecorder.this.mSyncTimeMillis;
                            if (j3 > 0) {
                            }
                        }
                    } else {
                        try {
                            ((NativeKaraRecorderBase) OboeNativeKaraRecorder.this).mOriginalBuffer.wait(10L);
                        } catch (InterruptedException e17) {
                            LogUtil.w("NativeKaraRecorder_RecordThread", e17);
                        }
                    }
                }
                break;
                o();
            }
            f(OboeNativeKaraRecorder.this.mHasRecordLength);
            return;
            if (remaining > 0) {
                int a16 = n.a(this.C, remaining);
                int i3 = OboeNativeKaraRecorder.this.mHasRecordLength;
                OboeNativeKaraRecorder.this.updateHasRecordLength(a16);
                int i16 = a16 / 4096;
                int i17 = a16 % 4096;
                int i18 = 0;
                if (i16 > 0) {
                    while (i18 < i16) {
                        int i19 = i18 * 4096;
                        System.arraycopy(this.C, i19, bArr, 0, 4096);
                        d(bArr, 4096, i19 + i3);
                        i18++;
                    }
                }
                if (i17 != 0) {
                    int i26 = i18 * 4096;
                    int i27 = a16 - i26;
                    System.arraycopy(this.C, i26, bArr, 0, i27);
                    d(bArr, i27, i3 + i26);
                }
            }
            o();
        }
    }

    static {
        try {
            System.loadLibrary("oboe_audio_record_v7a");
            mIsLoaded = true;
        } catch (Exception e16) {
            LogUtil.e(TAG, "System.loadLibrary failed", e16);
        } catch (UnsatisfiedLinkError e17) {
            LogUtil.e(TAG, "System.loadLibrary failed", e17);
        }
    }

    public OboeNativeKaraRecorder() {
        this.mIsValid = false;
        this.mEngineHandle = 0L;
    }

    private native int native_getFramesPerBurst(long j3);

    private native long native_init(int i3, int i16, int i17, int i18);

    private static native boolean native_isAAudioRecommended();

    private static native boolean native_isAAudioSupported();

    private native void native_release(long j3);

    private native void native_setAudioApi(long j3, int i3);

    private native void native_setByteBuffer(long j3, ByteBuffer byteBuffer);

    private native void native_setPlaybackDeviceId(long j3, int i3);

    private native void native_setRecordingDeviceId(long j3, int i3);

    private native void native_startRecord(long j3);

    private native void native_stopRecord(long j3);

    private native void native_turnFeedbackOn(long j3, boolean z16);

    @Override // com.tencent.karaoke.recordsdk.media.NativeKaraRecorderBase, com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public int getDelay() {
        return 0;
    }

    @Override // com.tencent.karaoke.recordsdk.media.NativeKaraRecorderBase, com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public int init(com.tencent.karaoke.recordsdk.media.i iVar) {
        LogUtil.i(TAG, "init begin.");
        if (!mIsLoaded) {
            LogUtil.e(TAG, "init -> so not loaded");
            this.mCurrentState.d(0);
            return -3002;
        }
        super.init(iVar);
        this.mCurrentState.d(2);
        if (this.isHuaweiAPIAbove26SystemEarback) {
            this.mMode = 1;
        }
        long native_init = native_init(this.mDefaultSampleRate, 1, this.mDefaultFramesPerBuffer, this.mMode);
        this.mEngineHandle = native_init;
        if (native_init == 0) {
            LogUtil.e(TAG, "nativeInit failed");
            this.mIsValid = false;
            this.mCurrentState.d(0);
            return -3002;
        }
        LogUtil.i(TAG, "init -> isAAudioRecommended:" + native_isAAudioRecommended() + ", bufferSize:" + native_getFramesPerBurst(this.mEngineHandle));
        int i3 = this.mDefaultSampleRate;
        int i16 = this.mDefaultFramesPerBuffer;
        this.mNativeBuffer = ByteBuffer.allocateDirect(i16 * 1 * 2);
        int i17 = i16 * 2;
        this.mNativeBuffer = ByteBuffer.allocateDirect(i17);
        this.mBufferRing = new NativeKaraRecorderBase.a(i17, 100);
        int i18 = i16 * 100;
        if (i3 != 44100) {
            if (i3 != 48000) {
                SimpleKaraResampler simpleKaraResampler = new SimpleKaraResampler();
                this.mSimpleKaraResampler = simpleKaraResampler;
                int init = simpleKaraResampler.init(1, i3, 44100, i18);
                if (init != 0) {
                    LogUtil.e(TAG, "init -> resampler init failed:" + init);
                    this.mIsValid = false;
                    this.mCurrentState.d(0);
                    return -3002;
                }
                this.mResampleBuffer = ByteBuffer.allocateDirect(this.mSimpleKaraResampler.maxOutFrameCount() * 2);
            } else {
                this.isUseNewResampler = true;
                KaraResampler karaResampler = new KaraResampler();
                this.mKaraResampler = karaResampler;
                int init2 = karaResampler.init(i3, 1, 44100, 1, 1);
                if (init2 != 0) {
                    LogUtil.e(TAG, "init -> resampler init failed:" + init2);
                    this.mIsValid = false;
                    this.mCurrentState.d(0);
                    return -3002;
                }
                this.mNewResampleBuffer = new byte[i18 * 2];
            }
        }
        this.mOriginalBuffer = ByteBuffer.allocateDirect(i18 * 2);
        native_setByteBuffer(this.mEngineHandle, this.mNativeBuffer);
        NativeRecordThread nativeRecordThread = new NativeRecordThread("Native-RecordThread-" + System.currentTimeMillis());
        this.mRecordThread = nativeRecordThread;
        nativeRecordThread.start();
        this.mBufferThread = new NativeKaraRecorderBase.BufferThread("Native-BufferThread-" + System.currentTimeMillis());
        if (this.isHuaweiAPIAbove26SystemEarback) {
            turnFeedback(true);
        }
        oy4.b.a().c(this);
        this.mIsValid = true;
        LogUtil.i(TAG, "init end.");
        return 0;
    }

    @Override // oy4.a
    public boolean isEarbackWorking() {
        return this.mIsFeedback;
    }

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public void onPlayBlock(long j3) {
        LogUtil.i(TAG, "onPlayBlock -> blockTime:" + j3);
        if (!this.mIsWaitingForPlayStart && j3 > 46) {
            this.mRecordIgnoreCount -= (int) ((46.0d / wz0.a.b(this.mNativeBuffer.capacity(), 48000, 1, 2)) + 0.5d);
        }
    }

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public void onPlayStart(boolean z16, int i3) {
        LogUtil.i(TAG, "onPlayStart begin.");
        super.onPlayStart(z16, i3);
        if (z16) {
            this.mRecordTotalDelayCount = (int) ((this.mPlayDelay + 100) / wz0.a.b(this.mNativeBuffer.capacity(), 48000, 1, 2));
            LogUtil.i(TAG, "onPlayStart -> mPlayStartTime:" + this.mPlayStartTime + ", totalDelay:" + this.mPlayDelay + ", mRecordTotalDelayCount:" + this.mRecordTotalDelayCount);
            this.mRecordIgnoreCount = 0;
        }
    }

    public void onRecordBuff(int i3) {
        int length;
        byte[] a16 = this.mBufferRing.a();
        this.mNativeBuffer.get(a16, 0, i3);
        this.mNativeBuffer.clear();
        if (this.mBufferThread != null && !this.mIsWaitingForPlayStart) {
            int i16 = this.mRecordIgnoreCount;
            if (i16 >= this.mRecordTotalDelayCount) {
                this.mBufferThread.d(a16);
                return;
            }
            this.mRecordIgnoreCount = i16 + 1;
            tryResetRecordStaticsParams();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onRecordBufferFull -> ignore record : ");
            sb5.append(this.mRecordIgnoreCount);
            sb5.append(", buffer:");
            if (a16 == null) {
                length = -1;
            } else {
                length = a16.length;
            }
            sb5.append(length);
            LogUtil.i(TAG, sb5.toString());
        }
    }

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public void pause() {
        LogUtil.i(TAG, "pause");
        if (!this.mIsValid) {
            LogUtil.w(TAG, HippyReporter.RemoveEngineReason.INVALID);
            return;
        }
        super.pause();
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.a(8)) {
                LogUtil.i(TAG, "current state has been 8");
            } else {
                if (this.mCurrentState.b(4, 2)) {
                    this.mCurrentState.d(8);
                    return;
                }
                throw new IllegalStateException("current status is: " + this.mCurrentState);
            }
        }
    }

    public void release() {
        LogUtil.i(TAG, "release");
        long j3 = this.mEngineHandle;
        if (j3 != 0) {
            native_release(j3);
            this.mEngineHandle = 0L;
        }
    }

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public void resume() {
        LogUtil.i(TAG, "resume");
        if (!this.mIsValid) {
            LogUtil.w(TAG, HippyReporter.RemoveEngineReason.INVALID);
            return;
        }
        super.resume();
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.a(4)) {
                LogUtil.w(TAG, "current state has been 4");
                return;
            }
            if (this.mCurrentState.a(8)) {
                this.mIsRecord = true;
                this.mCurrentState.d(4);
            } else {
                throw new IllegalStateException("current status is: " + this.mCurrentState);
            }
        }
    }

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public void start(com.tencent.karaoke.recordsdk.media.j jVar) {
        LogUtil.i(TAG, "start");
        if (!this.mIsValid) {
            LogUtil.w(TAG, HippyReporter.RemoveEngineReason.INVALID);
            return;
        }
        super.start(jVar);
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.a(4)) {
                LogUtil.w(TAG, "current state has been 4");
                return;
            }
            if (this.mCurrentState.a(2)) {
                this.mCurrentState.d(4);
                this.mIsRecord = true;
                this.mCurrentState.notifyAll();
                startRecord();
                this.mIsRecord = true;
                return;
            }
            throw new IllegalStateException("current status is: " + this.mCurrentState);
        }
    }

    public void startRecord() {
        long j3 = this.mEngineHandle;
        if (j3 != 0) {
            native_startRecord(j3);
        }
    }

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public void stop() {
        LogUtil.i(TAG, "stop");
        if (!this.mIsValid) {
            LogUtil.w(TAG, HippyReporter.RemoveEngineReason.INVALID);
            return;
        }
        super.stop();
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.a(16)) {
                LogUtil.i(TAG, "current state has been 16");
                return;
            }
            this.mCurrentState.d(16);
            this.mIsRecord = false;
            if (this.mRecordThread != null && !Thread.currentThread().equals(this.mRecordThread)) {
                try {
                    this.mRecordThread.join();
                } catch (InterruptedException e16) {
                    LogUtil.w(TAG, e16);
                }
            }
            stopRecord();
            this.mBufferThread.quit();
            oy4.b.a().c(null);
            this.mErrListener = null;
            this.mRecListeners.clear();
            native_release(this.mEngineHandle);
            KaraResampler karaResampler = this.mKaraResampler;
            if (karaResampler != null) {
                karaResampler.release();
            }
            IKaraResampler iKaraResampler = this.mSimpleKaraResampler;
            if (iKaraResampler != null) {
                iKaraResampler.release();
            }
            this.mIsValid = false;
        }
    }

    public void stopRecord() {
        long j3 = this.mEngineHandle;
        if (j3 != 0) {
            native_stopRecord(j3);
        }
    }

    @Override // oy4.a
    public void turnFeedback(boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("turn feedback ");
        if (z16) {
            str = "on";
        } else {
            str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        sb5.append(str);
        LogUtil.i(TAG, sb5.toString());
        if (!mIsLoaded) {
            LogUtil.w(TAG, HippyReporter.RemoveEngineReason.INVALID);
        } else if (this.mIsFeedback ^ z16) {
            native_turnFeedbackOn(this.mEngineHandle, z16);
            this.mIsFeedback = z16;
        }
    }

    public OboeNativeKaraRecorder(com.tencent.karaoke.recordsdk.media.c cVar, int i3) {
        super(cVar, i3);
        this.mIsValid = false;
        this.mEngineHandle = 0L;
    }
}
