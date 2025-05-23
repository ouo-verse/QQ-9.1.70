package com.google.android.filament;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.util.Log;
import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AndroidPlatform extends Platform {
    private static final String LOG_TAG = "Filament";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f32954a = 0;

    static {
        EGL14.eglGetDisplay(0);
    }

    AndroidPlatform() {
    }

    @Override // com.google.android.filament.Platform
    long getSharedContextNativeHandle(Object obj) {
        return AndroidPlatform21.getSharedContextNativeHandle(obj);
    }

    @Override // com.google.android.filament.Platform
    void log(String str) {
        Log.d(LOG_TAG, str);
    }

    @Override // com.google.android.filament.Platform
    boolean validateSharedContext(Object obj) {
        return obj instanceof EGLContext;
    }

    @Override // com.google.android.filament.Platform
    boolean validateStreamSource(Object obj) {
        return obj instanceof SurfaceTexture;
    }

    @Override // com.google.android.filament.Platform
    boolean validateSurface(Object obj) {
        return obj instanceof Surface;
    }

    @Override // com.google.android.filament.Platform
    void warn(String str) {
        Log.w(LOG_TAG, str);
    }
}
