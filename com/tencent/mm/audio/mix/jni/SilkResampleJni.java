package com.tencent.mm.audio.mix.jni;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class SilkResampleJni {
    static {
        System.loadLibrary("wechataudiosilk");
    }

    public static native int clearResample(String str);

    public static native int clearResampleAll();

    public static native int initResample(String str, int i3, int i16);

    public static native int resamplePcm(String str, int i3, int i16, short[] sArr, int i17, short[] sArr2);
}
