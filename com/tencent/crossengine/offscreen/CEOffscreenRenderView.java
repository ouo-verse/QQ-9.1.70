package com.tencent.crossengine.offscreen;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CEOffscreenRenderView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: d, reason: collision with root package name */
    private CEOffscreenEGLRender f100518d;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        com.tencent.crossengine.log.a.a("CEOffscreenRenderView", "onSurfaceTextureAvailable ");
        this.f100518d.h(new Surface(surfaceTexture), i3, i16);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.tencent.crossengine.log.a.a("CEOffscreenRenderView", "onSurfaceTextureDestroyed ");
        this.f100518d.i();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        com.tencent.crossengine.log.a.a("CEOffscreenRenderView", "onSurfaceTextureSizeChanged ");
        this.f100518d.g(new Surface(surfaceTexture), i3, i16);
    }

    public void setOnCheckDrawListener(b bVar) {
        CEOffscreenEGLRender cEOffscreenEGLRender = this.f100518d;
        if (cEOffscreenEGLRender != null) {
            cEOffscreenEGLRender.f(bVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
