package com.tencent.liteav.base;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: classes7.dex */
public abstract class PathService {
    public static final int DIR_MODULE = 3;

    PathService() {
    }

    private static native void nativeOverride(int i3, String str);

    public static void override(int i3, String str) {
        nativeOverride(i3, str);
    }
}
