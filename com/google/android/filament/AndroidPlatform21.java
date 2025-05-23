package com.google.android.filament;

import android.opengl.EGLContext;

/* loaded from: classes2.dex */
final class AndroidPlatform21 {
    AndroidPlatform21() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getSharedContextNativeHandle(Object obj) {
        return ((EGLContext) obj).getNativeHandle();
    }
}
