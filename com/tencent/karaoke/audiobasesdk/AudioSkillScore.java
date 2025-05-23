package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioSkillScore {
    private static final String TAG = "AudioSkillScore";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int native_getPortamento();

    private native int native_getVibrato();

    private native int native_initWithDuration(int i3);

    private native int native_process(float[][] fArr);

    private native void native_release();

    private native int native_setPortamentosTimeStamp(int[] iArr);

    private native int native_setVibratosTimeStamp(int[] iArr);

    public synchronized int getPortamento() {
        if (this.mIsValid) {
            return native_getPortamento();
        }
        LogUtil.i(TAG, "getPortamento, mIsValid == false");
        return -1;
    }

    public synchronized int getVibrato() {
        if (this.mIsValid) {
            return native_getVibrato();
        }
        LogUtil.i(TAG, "getVibrato, mIsValid == false");
        return -1;
    }

    public synchronized int initWithDuration(int i3) {
        boolean z16;
        if (mIsLoaded) {
            int native_initWithDuration = native_initWithDuration(i3);
            if (native_initWithDuration >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            return native_initWithDuration;
        }
        LogUtil.i(TAG, "init: so is not loaded");
        return -1;
    }

    public synchronized int process(float[][] fArr) {
        if (this.mIsValid) {
            return native_process(fArr);
        }
        LogUtil.i(TAG, "process, mIsValid == false");
        return -1;
    }

    public synchronized void release() {
        if (this.mIsValid) {
            native_release();
            this.mIsValid = false;
        } else {
            LogUtil.i(TAG, "getPortamento, mIsValid == false");
        }
    }

    public synchronized int setPortamentosTimeStamp(int[] iArr) {
        if (this.mIsValid) {
            return native_setPortamentosTimeStamp(iArr);
        }
        LogUtil.i(TAG, "setPortamentosTimeStamp, mIsValid == false");
        return -1;
    }

    public synchronized int setVibratosTimeStamp(int[] iArr) {
        if (this.mIsValid) {
            return native_setVibratosTimeStamp(iArr);
        }
        LogUtil.i(TAG, "setVibratosTimeStamp, mIsValid == false");
        return -1;
    }
}
