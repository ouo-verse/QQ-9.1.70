package com.tencent.av.video.effect.utils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LowLightUtils {
    static {
        if (!NativeLoader.mIsSoLoaded) {
            NativeLoader.loadSo();
        }
    }

    public static native int[] DetectLowLight(byte[] bArr, int i3, int i16, int i17, int i18, float f16);
}
