package com.gyailib.librarytest;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAIFaceAuth {
    private long nativePtr;

    static {
        try {
            System.loadLibrary("all_in_one_so");
        } catch (Error e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native int processAllJni(CrossTesterConfig crossTesterConfig);

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }
}
