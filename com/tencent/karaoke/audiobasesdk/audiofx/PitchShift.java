package com.tencent.karaoke.audiobasesdk.audiofx;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* loaded from: classes7.dex */
public class PitchShift implements PitchInterface {
    private static final String TAG = "PitchShift";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private byte[] mPitchBuffer;
    private long nativeHandle;
    private boolean mIsValid = false;
    private int mPitchLevel = 0;

    private native int native_init(int i3, int i16);

    private native int native_process(byte[] bArr, int i3, byte[] bArr2, int i16);

    private native void native_release();

    private native void native_shift(int i3);

    public synchronized int getPitchLevel() {
        return this.mPitchLevel;
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public synchronized boolean init(int i3, int i16) {
        LogUtil.d(TAG, "init");
        if (mIsLoaded) {
            int native_init = native_init(i3, i16);
            if (native_init != 0) {
                LogUtil.w(TAG, "native init failed: " + native_init);
                this.mIsValid = false;
            } else {
                this.mIsValid = true;
            }
            return this.mIsValid;
        }
        LogUtil.w(TAG, "PitchShift invalid");
        return false;
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public synchronized int process(byte[] bArr, int i3) {
        if (this.mIsValid) {
            byte[] bArr2 = this.mPitchBuffer;
            if (bArr2 == null) {
                this.mPitchBuffer = new byte[i3];
            } else if (bArr2.length != i3) {
                this.mPitchBuffer = new byte[i3];
            }
            int native_process = native_process(bArr, i3, this.mPitchBuffer, i3);
            if (native_process > 0) {
                System.arraycopy(this.mPitchBuffer, 0, bArr, 0, i3);
            }
            return native_process;
        }
        LogUtil.w(TAG, "PitchShift invalid");
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public int processLast(byte[] bArr, int i3) {
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public synchronized void release() {
        LogUtil.d(TAG, "release");
        if (this.mIsValid) {
            native_release();
            this.mPitchBuffer = null;
            this.mIsValid = false;
        } else {
            LogUtil.w(TAG, "PitchShift invalid");
        }
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public int seek() {
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.audiofx.PitchInterface
    public synchronized void setPitchShift(int i3) {
        if (!this.mIsValid) {
            LogUtil.w(TAG, "PitchShift invalid");
            return;
        }
        this.mPitchLevel = i3;
        int i16 = 12;
        if (i3 <= 12) {
            i16 = -12;
            if (i3 < -12) {
            }
            native_shift(i3);
        }
        i3 = i16;
        native_shift(i3);
    }

    public synchronized int process(byte[] bArr, int i3, byte[] bArr2, int i16) {
        if (this.mIsValid) {
            return native_process(bArr, i3, bArr2, i16);
        }
        LogUtil.w(TAG, "PitchShift invalid");
        return -1;
    }
}
