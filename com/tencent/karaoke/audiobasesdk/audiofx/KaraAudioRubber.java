package com.tencent.karaoke.audiobasesdk.audiofx;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraAudioRubber implements PitchInterface {
    private static final String TAG = "KaraAudioRubber";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private int mPitchLevel = 0;
    private long nativeHandle;

    private native boolean native_ProcessFlush();

    private native void native_ProcessInput(byte[] bArr, int i3);

    private native int native_ProcessOutput(byte[] bArr, int i3);

    private native int native_RemainingData();

    private native void native_SetPitchShift(int i3);

    private native boolean native_SetTempo(double d16);

    private native int native_init(int i3, int i16, int i17);

    private native int native_process(byte[] bArr, int i3);

    private native boolean native_processFinish();

    private native int native_processFlushOutput(byte[] bArr, int i3);

    private native void native_release();

    private native int native_seek();

    public synchronized int getPitchLevel() {
        return this.mPitchLevel;
    }

    public synchronized int getRemainingData() {
        if (this.mIsValid) {
            return native_RemainingData();
        }
        LogUtil.w(TAG, "KaraAudioRubber invalid");
        return -1;
    }

    public synchronized boolean init(int i3, int i16, int i17) {
        LogUtil.d(TAG, "init -> sampleRate:" + i3 + ", channels:" + i16 + ", sampleSize:" + i17);
        if (mIsLoaded) {
            int native_init = native_init(i3, i16, i17);
            if (native_init != 0) {
                LogUtil.w(TAG, "native init failed: " + native_init);
                this.mIsValid = false;
                return false;
            }
            this.mIsValid = true;
            native_SetPitchShift(this.mPitchLevel);
            LogUtil.d(TAG, "init -> process ret:" + native_init);
            return true;
        }
        LogUtil.w(TAG, "KaraAudioRubber invalid");
        return false;
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public synchronized int process(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_process(bArr, i3);
        }
        LogUtil.w(TAG, "KaraAudioRubber invalid");
        return -1;
    }

    public synchronized boolean processFlush() {
        if (this.mIsValid) {
            return native_ProcessFlush();
        }
        LogUtil.w(TAG, "KaraAudioRubber invalid");
        return false;
    }

    public synchronized int processInput(byte[] bArr, int i3) {
        if (this.mIsValid) {
            native_ProcessInput(bArr, i3);
            return 0;
        }
        LogUtil.w(TAG, "KaraAudioRubber invalid");
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public synchronized int processLast(byte[] bArr, int i3) {
        if (this.mIsValid) {
            if (!native_processFinish()) {
                return -1;
            }
            return native_processFlushOutput(bArr, i3);
        }
        LogUtil.w(TAG, "KaraAudioRubber invalid");
        return -1;
    }

    public synchronized int processOutput(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_ProcessOutput(bArr, i3);
        }
        LogUtil.w(TAG, "KaraAudioRubber invalid");
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public synchronized void release() {
        LogUtil.d(TAG, "release");
        if (this.mIsValid) {
            native_release();
            this.mIsValid = false;
        } else {
            LogUtil.w(TAG, "KaraAudioRubber invalid");
        }
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public synchronized int seek() {
        if (this.mIsValid) {
            return native_seek();
        }
        LogUtil.w(TAG, "KaraAudioRubber invalid");
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x001e, code lost:
    
        if (r2 < (-12)) goto L14;
     */
    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void setPitchShift(int i3) {
        if (!mIsLoaded) {
            LogUtil.w(TAG, "PitchShift invalid");
            return;
        }
        if (this.mPitchLevel == i3) {
            return;
        }
        int i16 = 12;
        if (i3 <= 12) {
            i16 = -12;
        }
        i3 = i16;
        this.mPitchLevel = i3;
        native_SetPitchShift(i3);
    }

    public synchronized boolean setTempo(double d16) {
        LogUtil.d(TAG, "setTempo:" + d16);
        if (this.mIsValid) {
            return native_SetTempo(d16);
        }
        LogUtil.w(TAG, "KaraAudioRubber invalid");
        return false;
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public boolean init(int i3, int i16) {
        return init(i3, i16, i3 * 360);
    }
}
