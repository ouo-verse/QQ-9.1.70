package com.tencent.liteav.videobase.utils;

import android.graphics.SurfaceTexture;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SurfaceTextureHolder f119402a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceTexture f119403b;

    f(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        this.f119402a = surfaceTextureHolder;
        this.f119403b = surfaceTexture;
    }

    public static Runnable a(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        return new f(surfaceTextureHolder, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTextureHolder.lambda$onFrameAvailable$0(this.f119402a, this.f119403b);
    }
}
