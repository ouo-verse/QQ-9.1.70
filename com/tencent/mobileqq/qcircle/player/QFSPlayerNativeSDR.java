package com.tencent.mobileqq.qcircle.player;

/* loaded from: classes16.dex */
public class QFSPlayerNativeSDR {
    private static boolean SO_LOAD = false;
    public static int SR_QUALITY_HIGH = 1;
    public static int SR_QUALITY_NORMAL = 0;
    private static final String TAG = "QFSPlayerNativeSDR";
    private long mNativePtr;

    private native boolean bindNativeInfo();

    public boolean execute(int i3, int i16, int i17, int i18, int i19, int i26) {
        return nativeExecute(i3, i16, i17, i18, i19, i26);
    }

    public boolean init(int i3) {
        if (!SO_LOAD) {
            bindNativeInfo();
            SO_LOAD = true;
        }
        boolean nativeCreateSDRObj = nativeCreateSDRObj(i3);
        if (this.mNativePtr != 0 && nativeCreateSDRObj) {
            return true;
        }
        return false;
    }

    public native boolean nativeCreateSDRObj(int i3);

    public native boolean nativeDestroy();

    public native boolean nativeExecute(int i3, int i16, int i17, int i18, int i19, int i26);

    public boolean release() {
        return nativeDestroy();
    }
}
