package com.tencent.karaoke.audiobasesdk.audiofx;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AEtimrescore {
    private static final String TAG = "AEtimrescore";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    public static boolean sIsDebug = false;
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int native_debug(String str, int i3);

    private native void native_flush();

    private native int native_getPublicF0Total(float[] fArr, long j3);

    private native int native_getResult(byte[] bArr, long j3, float[] fArr);

    private native int native_init(int i3, int i16);

    private native int native_process(float f16, byte[] bArr, int i3);

    private native int native_processAll(byte[] bArr, int i3, float[] fArr);

    private native int native_toStopProcess(float[] fArr, long[] jArr);

    private native int native_uinit();

    public static void setDebug(boolean z16) {
        sIsDebug = z16;
    }

    public synchronized int debug(String str, int i3) {
        if (this.mIsValid) {
            return native_debug(str, i3);
        }
        LogUtil.w(TAG, "AEtimrescore invalid");
        return -1;
    }

    public synchronized int getPublicF0Total(float[] fArr) {
        if (this.mIsValid) {
            if (fArr != null && fArr.length != 0) {
                return native_getPublicF0Total(fArr, fArr.length);
            }
            LogUtil.e(TAG, "f0data is null");
            return -2;
        }
        LogUtil.w(TAG, "AEtimrescore invalid");
        return -1;
    }

    public synchronized int getResult(byte[] bArr, int i3, float[] fArr) {
        if (this.mIsValid) {
            int native_getResult = native_getResult(bArr, i3, fArr);
            LogUtil.d(TAG, "getResult:  ret " + native_getResult + " , obj: " + this);
            return native_getResult;
        }
        LogUtil.w(TAG, "AEtimrescore invalid , obj: " + this);
        return -1;
    }

    public synchronized int init(int i3, int i16) {
        boolean z16;
        LogUtil.d(TAG, "init 1 , obj: " + this);
        if (mIsLoaded) {
            LogUtil.d(TAG, "init 2 , obj: " + this);
            int native_init = native_init(i3, i16);
            if (native_init == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            LogUtil.d(TAG, "init 3 ,ret" + native_init + " , obj: " + this);
            return native_init;
        }
        LogUtil.w(TAG, "AEtimrescore invalid , obj: " + this);
        return -1;
    }

    public synchronized int process(float f16, byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_process(f16, bArr, i3);
        }
        LogUtil.w(TAG, "AEtimrescore invalid");
        return -1;
    }

    public synchronized int release() {
        if (this.mIsValid) {
            LogUtil.d(TAG, "release: 1  , obj: " + this);
            int native_uinit = native_uinit();
            LogUtil.d(TAG, "release: 2 ,ret" + native_uinit + " , obj: " + this);
            this.mIsValid = false;
            return native_uinit;
        }
        LogUtil.w(TAG, "AEtimrescore invalid , obj: " + this);
        return -1;
    }

    public synchronized int toStopProcess(float[] fArr, long[] jArr) {
        if (this.mIsValid) {
            LogUtil.i(TAG, "toStopProcess 1 : " + fArr[0] + "  >> " + jArr[0] + " , obj: " + this);
            int native_toStopProcess = native_toStopProcess(fArr, jArr);
            LogUtil.i(TAG, "toStopProcess 2 : " + fArr[0] + "  >> " + jArr[0] + " ,ret: " + native_toStopProcess + " , obj: " + this);
            return native_toStopProcess;
        }
        LogUtil.w(TAG, "AEtimrescore invalid , obj: " + this);
        return -1;
    }
}
