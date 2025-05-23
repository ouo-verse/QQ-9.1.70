package com.tencent.karaoke.recordsdk.media.audio;

import android.annotation.SuppressLint;
import android.os.Process;
import com.tencent.component.utils.LogUtil;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.karaoke.audiobasesdk.IKaraResampler;
import com.tencent.karaoke.audiobasesdk.KaraAutoGain;
import com.tencent.karaoke.audiobasesdk.KaraResampler;
import com.tencent.karaoke.audiobasesdk.SimpleKaraResampler;
import com.tencent.karaoke.recordsdk.media.NativeKaraRecorderBase;
import com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.nio.ByteBuffer;
import kotlinx.coroutines.DebugKt;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class NativeKaraRecorder extends NativeKaraRecorderBase implements oy4.a {
    private static final int NATIVE_STOP_TAG = -99;
    private static final String TAG = "NativeKaraRecorder";
    private static boolean mIsLoaded = false;
    private volatile boolean mIsValid;
    private AbstractKaraRecorder.RecordThread mRecordThread;
    private final byte[] recorderLock;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class NativeRecordThread extends AbstractKaraRecorder.RecordThread {
        private byte[] C;

        public NativeRecordThread(String str) {
            super(str);
            if (((NativeKaraRecorderBase) NativeKaraRecorder.this).isUseNewResampler) {
                this.C = new byte[((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer.capacity() * 2];
            } else if (((NativeKaraRecorderBase) NativeKaraRecorder.this).mSimpleKaraResampler == null) {
                this.C = new byte[((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer.capacity() * 2];
            } else {
                this.C = new byte[((NativeKaraRecorderBase) NativeKaraRecorder.this).mResampleBuffer.capacity() * 2];
            }
        }

        private void o() {
            synchronized (NativeKaraRecorder.this.mCurrentState) {
                if (!NativeKaraRecorder.this.mSeekRequests.isEmpty()) {
                    AbstractKaraRecorder.c removeLast = NativeKaraRecorder.this.mSeekRequests.removeLast();
                    NativeKaraRecorder.this.mSeekRequests.clear();
                    NativeKaraRecorder.this.mSyncPosition = 0;
                    c(removeLast);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x019d A[Catch: all -> 0x021e, TRY_LEAVE, TryCatch #4 {, blocks: (B:33:0x00a3, B:35:0x00b8, B:37:0x00c0, B:39:0x00d8, B:43:0x00f3, B:44:0x010b, B:41:0x010e, B:49:0x018a, B:51:0x019d, B:52:0x01e3, B:65:0x011a, B:67:0x0122, B:68:0x0133, B:72:0x014d, B:73:0x0165, B:70:0x0168, B:76:0x01d0, B:79:0x01dd), top: B:32:0x00a3, inners: #2 }] */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int remaining;
            long j3;
            LogUtil.i("NativeKaraRecorder_RecordThread", getName() + " begin");
            Process.setThreadPriority(-19);
            byte[] bArr = new byte[4096];
            synchronized (NativeKaraRecorder.this.mCurrentState) {
                while (NativeKaraRecorder.this.mCurrentState.b(2, 8)) {
                    o();
                    if (NativeKaraRecorder.this.mCurrentState.b(2, 8)) {
                        try {
                            LockMethodProxy.wait(NativeKaraRecorder.this.mCurrentState);
                        } catch (InterruptedException e16) {
                            LogUtil.w("NativeKaraRecorder_RecordThread", "pause state is interrupted", e16);
                        }
                    }
                }
            }
            if (NativeKaraRecorder.this.mCurrentState.a(8)) {
                LogUtil.i("NativeKaraRecorder_RecordThread", "current state has been 8");
                try {
                    LockMethodProxy.wait(NativeKaraRecorder.this.mCurrentState);
                } catch (InterruptedException e17) {
                    LogUtil.w("NativeKaraRecorder_RecordThread", "pause state is interrupted", e17);
                }
            }
            LogUtil.i("NativeKaraRecorder_RecordThread", "start record begin");
            while (true) {
                if (!((NativeKaraRecorderBase) NativeKaraRecorder.this).mIsRecord) {
                    break;
                }
                synchronized (((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer) {
                    ((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer.flip();
                    remaining = ((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer.remaining();
                    if (remaining != 0) {
                        if (((NativeKaraRecorderBase) NativeKaraRecorder.this).isUseNewResampler) {
                            ((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer.get(this.C, 0, remaining);
                            NativeKaraRecorder.this.getClass();
                            if (((NativeKaraRecorderBase) NativeKaraRecorder.this).mKaraResampler != null) {
                                remaining = ((NativeKaraRecorderBase) NativeKaraRecorder.this).mKaraResampler.resample(this.C, remaining, ((NativeKaraRecorderBase) NativeKaraRecorder.this).mNewResampleBuffer, ((NativeKaraRecorderBase) NativeKaraRecorder.this).mNewResampleBuffer.length);
                                if (remaining < 0) {
                                    LogUtil.e("NativeKaraRecorder_RecordThread", "resample failed: " + remaining);
                                } else {
                                    System.arraycopy(((NativeKaraRecorderBase) NativeKaraRecorder.this).mNewResampleBuffer, 0, this.C, 0, remaining);
                                }
                            }
                            ((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer.clear();
                            j3 = NativeKaraRecorder.this.mSyncTimeMillis;
                            if (j3 > 0) {
                                NativeKaraRecorder.this.mSyncPosition = wz0.a.c((((int) (j3 - System.currentTimeMillis())) / 10) * 10);
                                NativeKaraRecorder.this.mSyncTimeMillis = 0L;
                                LogUtil.i("NativeKaraRecorder_RecordThread", "Sync Position: " + NativeKaraRecorder.this.mSyncPosition);
                            }
                        } else {
                            if (((NativeKaraRecorderBase) NativeKaraRecorder.this).mSimpleKaraResampler == null) {
                                ((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer.get(this.C, 0, remaining);
                                NativeKaraRecorder.this.getClass();
                            } else {
                                int resample = ((NativeKaraRecorderBase) NativeKaraRecorder.this).mSimpleKaraResampler.resample(((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer, remaining / 2, ((NativeKaraRecorderBase) NativeKaraRecorder.this).mResampleBuffer);
                                if (resample < 0) {
                                    LogUtil.e("NativeKaraRecorder_RecordThread", "resample failed: " + resample);
                                } else {
                                    NativeKaraRecorder.this.getClass();
                                    remaining = Math.min(resample * 2, this.C.length);
                                    ((NativeKaraRecorderBase) NativeKaraRecorder.this).mResampleBuffer.get(this.C, 0, remaining);
                                    ((NativeKaraRecorderBase) NativeKaraRecorder.this).mResampleBuffer.clear();
                                }
                            }
                            ((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer.clear();
                            j3 = NativeKaraRecorder.this.mSyncTimeMillis;
                            if (j3 > 0) {
                            }
                        }
                    } else {
                        try {
                            ((NativeKaraRecorderBase) NativeKaraRecorder.this).mOriginalBuffer.wait(10L);
                        } catch (InterruptedException e18) {
                            LogUtil.w("NativeKaraRecorder_RecordThread", e18);
                        }
                    }
                }
                break;
                o();
            }
            f(NativeKaraRecorder.this.mHasRecordLength);
            LogUtil.i("NativeKaraRecorder_RecordThread", getName() + " exit");
            return;
            if (remaining > 0) {
                int a16 = n.a(this.C, remaining);
                int i3 = NativeKaraRecorder.this.mHasRecordLength;
                NativeKaraRecorder.this.updateHasRecordLength(a16);
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
            System.loadLibrary("native_audio_record_v7a");
            mIsLoaded = true;
        } catch (Exception e16) {
            LogUtil.e(TAG, "System.loadLibrary failed", e16);
        } catch (UnsatisfiedLinkError e17) {
            LogUtil.e(TAG, "System.loadLibrary failed", e17);
        }
    }

    public NativeKaraRecorder(com.tencent.karaoke.recordsdk.media.c cVar, int i3, boolean z16) {
        super(cVar, i3);
        this.mIsValid = false;
        this.recorderLock = new byte[0];
        this.isHuaweiAPIAbove26SystemEarback = z16;
        oy4.b.a().c(this);
    }

    private void clearListener() {
        this.mErrListener = null;
        this.mRecListeners.clear();
    }

    private int internalInitThreadSafe(int i3) {
        int nativeInit;
        synchronized (this.recorderLock) {
            ByteBuffer byteBuffer = this.mNativeBuffer;
            nativeInit = nativeInit(i3, byteBuffer, byteBuffer.capacity(), this.mMode);
        }
        return nativeInit;
    }

    private void internalReleaseThreadSafe() {
        synchronized (this.recorderLock) {
            nativeRelease();
        }
    }

    private native float nativeGetMicVolumePercent();

    private native int nativeInit(int i3, ByteBuffer byteBuffer, int i16, int i17);

    private native int nativePreStop();

    private native void nativeRelease();

    private native boolean nativeSetMicVolume(float f16);

    private native int nativeStart();

    private native int nativeStop();

    private native int nativeTurnFeedback(boolean z16);

    private void onRecordBufferFull(int i3) {
        if (i3 > 0) {
            byte[] a16 = this.mBufferRing.a();
            this.mNativeBuffer.get(a16);
            this.mNativeBuffer.clear();
            if (this.mBufferThread != null && !this.mIsWaitingForPlayStart) {
                int i16 = this.mRecordIgnoreCount;
                if (i16 >= this.mRecordTotalDelayCount) {
                    this.mBufferThread.d(a16);
                    return;
                }
                this.mRecordIgnoreCount = i16 + 1;
                LogUtil.i(TAG, "onRecordBufferFull -> ignore record : " + this.mRecordIgnoreCount + ", buffer:" + a16.length);
                tryResetRecordStaticsParams();
                return;
            }
            return;
        }
        if (i3 == -99) {
            synchronized (this.mCurrentState) {
                if (this.mCurrentState.a(16)) {
                    LogUtil.i(TAG, "current state has been 16");
                    return;
                }
                LogUtil.i(TAG, "onRecordBufferFull -> stop record");
                this.mCurrentState.d(16);
                this.mIsRecord = false;
            }
        }
    }

    private void releaseResampleV1() {
        IKaraResampler iKaraResampler = this.mSimpleKaraResampler;
        if (iKaraResampler != null) {
            iKaraResampler.release();
        }
    }

    private void releaseResampleV2() {
        KaraResampler karaResampler = this.mKaraResampler;
        if (karaResampler != null) {
            karaResampler.release();
        }
    }

    private boolean stateNoValid() {
        AbstractKaraRecorder.d dVar = this.mCurrentState;
        if (dVar == null) {
            return false;
        }
        synchronized (dVar) {
            if (!this.mCurrentState.b(0, 1, 16)) {
                return false;
            }
            LogUtil.i(TAG, "state not right,state = " + this.mCurrentState.toString());
            return true;
        }
    }

    private native int test();

    public float getVolumePercent() {
        if (!mIsLoaded) {
            LogUtil.w(TAG, HippyReporter.RemoveEngineReason.INVALID);
            return -1.0f;
        }
        if (stateNoValid()) {
            LogUtil.i(TAG, "getVolumePercent stateNotValid");
            return -1.0f;
        }
        return nativeGetMicVolumePercent();
    }

    @Override // com.tencent.karaoke.recordsdk.media.NativeKaraRecorderBase, com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public int init(com.tencent.karaoke.recordsdk.media.i iVar) {
        LogUtil.i(TAG, "init");
        if (!mIsLoaded) {
            LogUtil.e(TAG, "init -> so not loaded");
            this.mCurrentState.d(0);
            return -3002;
        }
        if (uz0.e.f()) {
            LogUtil.e(TAG, "init() error: Other app is recording, we may is silenced!!! ");
        }
        super.init(iVar);
        this.mCurrentState.d(2);
        int i3 = this.mDefaultSampleRate;
        int i16 = this.mDefaultFramesPerBuffer;
        LogUtil.i(TAG, String.format("init -> sampleRate:%d, framesPerBuffer:%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        s sVar = this.mRecordParam;
        sVar.f117031a = this.mDefaultSampleRate;
        sVar.f117034d = this.mDefaultFramesPerBuffer;
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
                this.isUseNewResampler = false;
                reportResampleVersion("v1");
            } else {
                LogUtil.i(TAG, "init: samplerate is 48k,use karaResampler");
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
                reportResampleVersion("v2");
            }
        }
        this.mOriginalBuffer = ByteBuffer.allocateDirect(i18 * 2);
        if (this.isHuaweiAPIAbove26SystemEarback) {
            this.mMode = 1;
        }
        int internalInitThreadSafe = internalInitThreadSafe(i3);
        if (internalInitThreadSafe != 0) {
            LogUtil.e(TAG, "nativeInit failed: " + internalInitThreadSafe);
            this.mIsValid = false;
            releaseResampleV1();
            releaseResampleV2();
            clearListener();
            oy4.b.a().c(null);
            this.mCurrentState.d(0);
            return -3002;
        }
        int nativeStart = nativeStart();
        if (nativeStart != 0) {
            LogUtil.e(TAG, "init ->  nativeStart failed: " + nativeStart);
            releaseResampleV1();
            releaseResampleV2();
            nativeRelease();
            clearListener();
            oy4.b.a().c(null);
            this.mCurrentState.d(0);
            if (uz0.e.f()) {
                return KaraAutoGain.AutoGainErrorType.AutoGainEburInitError;
            }
            return MessageRecord.MSG_TYPE_FILE_RECEIPT;
        }
        NativeRecordThread nativeRecordThread = new NativeRecordThread("Native-RecordThread-" + System.currentTimeMillis());
        this.mRecordThread = nativeRecordThread;
        nativeRecordThread.start();
        this.mBufferThread = new NativeKaraRecorderBase.BufferThread("Native-BufferThread-" + System.currentTimeMillis());
        if (this.isHuaweiAPIAbove26SystemEarback) {
            turnFeedback(true);
        }
        this.mIsValid = true;
        return nativeStart;
    }

    @Override // oy4.a
    public boolean isEarbackWorking() {
        return this.mIsFeedback;
    }

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public void onPlayBlock(long j3) {
        LogUtil.i(TAG, "onPlayBlock -> blockTime:" + j3);
        if (!this.mIsWaitingForPlayStart) {
            if (j3 > 46) {
                int b16 = (int) ((46.0d / wz0.a.b(this.mNativeBuffer.capacity(), this.mDefaultSampleRate, 1, 2)) + 0.5d);
                LogUtil.i(TAG, "onPlayBlock: diffCount = " + b16);
                this.mRecordIgnoreCount = this.mRecordIgnoreCount - b16;
            }
            reportBlock(j3);
        }
    }

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public void onPlayStart(boolean z16, int i3) {
        int i16;
        LogUtil.i(TAG, "onPlayStart begin.");
        super.onPlayStart(z16, i3);
        if (z16) {
            if (i3 < 0) {
                i16 = 0;
            } else {
                i16 = i3;
            }
            double b16 = wz0.a.b(this.mNativeBuffer.capacity(), this.mDefaultSampleRate, 1, 2);
            LogUtil.i(TAG, "onPlayStart: onceReadTime = " + b16);
            this.mRecordTotalDelayCount = (int) (((double) (i16 + 100)) / b16);
            LogUtil.i(TAG, "onPlayStart -> mPlayStartTime:" + this.mPlayStartTime + ", totalDelay:" + i16 + ", mRecordTotalDelayCount:" + this.mRecordTotalDelayCount);
            this.mRecordIgnoreCount = 0;
            reportDelay(i3);
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
        if (this.mMode == 1) {
            turnFeedback(false);
        }
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

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public void resume() {
        LogUtil.i(TAG, "resume");
        if (!this.mIsValid) {
            LogUtil.w(TAG, HippyReporter.RemoveEngineReason.INVALID);
            return;
        }
        if (uz0.e.e()) {
            LogUtil.e(TAG, "resume() error: Other app is recording, we may is silenced!!! ");
        }
        super.resume();
        if (this.mMode == 1) {
            turnFeedback(true);
        }
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.a(4)) {
                LogUtil.w(TAG, "current state has been 4");
                return;
            }
            if (this.mCurrentState.a(16)) {
                LogUtil.i(TAG, "current state has been 16");
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

    public void setVolume(float f16) {
        LogUtil.i(TAG, "setVolume: volumePercent=" + f16);
        if (!mIsLoaded) {
            LogUtil.w(TAG, HippyReporter.RemoveEngineReason.INVALID);
            return;
        }
        if (stateNoValid()) {
            LogUtil.i(TAG, "turnFeedback: stateNotValid");
            return;
        }
        LogUtil.i(TAG, "setVolume: success=" + nativeSetMicVolume(f16));
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
                this.mIsRecord = true;
                this.mCurrentState.d(4);
                this.mIsRecord = true;
            } else {
                throw new IllegalStateException("current status is: " + this.mCurrentState);
            }
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
        nativePreStop();
        if (this.mRecordThread != null && !Thread.currentThread().equals(this.mRecordThread)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                LogUtil.i(TAG, "stop -> begin wait");
                this.mRecordThread.join(4000L);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                LogUtil.i(TAG, "stop -> end wait,cost:" + currentTimeMillis2);
                reportJoin(currentTimeMillis2);
            } catch (InterruptedException e16) {
                LogUtil.w(TAG, e16);
                LogUtil.w(TAG, "end wait because of exception ,cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            this.mRecordThread = null;
        }
        this.mIsRecord = false;
        nativeStop();
        this.mBufferThread.quit();
        oy4.b.a().c(null);
        clearListener();
        internalReleaseThreadSafe();
        releaseResampleV1();
        releaseResampleV2();
        this.mIsValid = false;
    }

    public int testAsan() {
        return test();
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
            return;
        }
        if (stateNoValid()) {
            LogUtil.i(TAG, "turnFeedback: stateNotValid");
        } else if (this.mIsFeedback ^ z16) {
            nativeTurnFeedback(z16);
            this.mIsFeedback = z16;
        }
    }

    private void reportDelay(int i3) {
    }
}
