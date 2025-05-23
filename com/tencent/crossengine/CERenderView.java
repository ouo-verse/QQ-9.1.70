package com.tencent.crossengine;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.crossengine.log.a;
import tf0.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CERenderView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: d, reason: collision with root package name */
    private RenderContext f100454d;

    /* renamed from: e, reason: collision with root package name */
    private d f100455e;

    /* renamed from: f, reason: collision with root package name */
    private GestureDetector f100456f;

    public CERenderView(Context context, RenderContext renderContext, d dVar) {
        super(context);
        setSurfaceTextureListener(this);
        this.f100455e = dVar;
        this.f100454d = renderContext;
        setOpaque(false);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        a.a("CERenderView", "onSurfaceTextureAvailable width : " + i3 + "; height : " + i16);
        this.f100454d.f(new Surface(surfaceTexture), i3, i16);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        a.a("CERenderView", "onSurfaceTextureDestroyed");
        this.f100454d.b();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        a.a("CERenderView", "onSurfaceTextureSizeChanged width : " + i3 + "; height : " + i16);
        this.f100454d.i(new Surface(surfaceTexture), i3, i16);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f100456f;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return this.f100455e.a(motionEvent);
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.f100456f = gestureDetector;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
