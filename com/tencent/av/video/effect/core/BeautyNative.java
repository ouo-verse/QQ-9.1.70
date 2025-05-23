package com.tencent.av.video.effect.core;

import com.tencent.av.video.effect.utils.NativeLoader;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BeautyNative {
    static {
        if (!NativeLoader.mIsSoLoaded) {
            NativeLoader.loadSo();
        }
    }

    public static native byte[] beautyProcess20(byte[] bArr, int i3, int i16, int i17, int i18);

    public static native byte[] beautyProcess25(byte[] bArr, int i3, int i16, int i17, int i18, int i19, boolean z16);

    public static native byte[] convertI420ToNV12(byte[] bArr, int i3, int i16);

    public static native byte[] convertI420ToNV21(byte[] bArr, int i3, int i16);
}
