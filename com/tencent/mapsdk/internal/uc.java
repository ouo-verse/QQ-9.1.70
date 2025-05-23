package com.tencent.mapsdk.internal;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes9.dex */
public final class uc extends TextureView implements TextureView.SurfaceTextureListener, bw {

    /* renamed from: a, reason: collision with root package name */
    private tr f151241a;

    /* renamed from: b, reason: collision with root package name */
    private tq f151242b;

    /* renamed from: c, reason: collision with root package name */
    private SurfaceTexture f151243c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f151244d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f151245e;

    public uc(bf bfVar) {
        super(bfVar.getContext());
        this.f151244d = false;
        this.f151245e = false;
        this.f151241a = (tr) bfVar.b();
        setSurfaceTextureListener(this);
        setOpaque(bfVar.o());
        this.f151242b = new tq(this.f151241a);
        tq.a(bfVar.n());
        this.f151242b.f151003a = bfVar.p();
        this.f151242b.start();
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void a() {
        this.f151245e = false;
        if (this.f151243c != null && this.f151244d && getSurfaceTexture() != this.f151243c && isAvailable()) {
            setSurfaceTexture(this.f151243c);
            this.f151244d = false;
        }
        tq tqVar = this.f151242b;
        if (tqVar != null) {
            tqVar.b();
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void b() {
        this.f151245e = true;
        tq tqVar = this.f151242b;
        if (tqVar != null) {
            tqVar.a();
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void c() {
        tq tqVar = this.f151242b;
        if (tqVar != null) {
            tqVar.c();
        }
        SurfaceTexture surfaceTexture = this.f151243c;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f151243c = null;
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void d() {
        tq tqVar = this.f151242b;
        if (tqVar != null) {
            synchronized (tqVar) {
                this.f151242b.notify();
            }
        }
    }

    @Override // android.view.View
    protected final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        tr trVar = this.f151241a;
        if (trVar != null && trVar.a(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final boolean e() {
        return isOpaque();
    }

    @Override // android.view.TextureView, android.view.View, com.tencent.mapsdk.internal.bw
    public final void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        tr trVar = this.f151241a;
        if (trVar != null) {
            trVar.e(i3, i16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    @TargetApi(16)
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        this.f151243c = surfaceTexture;
        a(surfaceTexture, i3, i16);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f151244d = true;
        if (!this.f151245e) {
            return true;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        tr trVar = this.f151241a;
        if (trVar != null) {
            trVar.a((GL10) null, i3, i16);
            tq tqVar = this.f151242b;
            if (tqVar != null) {
                tqVar.d();
            }
        }
    }

    @Override // android.view.View, com.tencent.mapsdk.internal.bw
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void setMapOpaque(boolean z16) {
        if (this.f151241a != null) {
            setOpaque(z16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void a(Object obj, int i3, int i16) {
        this.f151242b.a(obj);
        tr trVar = this.f151241a;
        if (trVar != null) {
            trVar.a((GL10) null, (EGLConfig) null);
            this.f151241a.a((GL10) null, i3, i16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void a(float f16) {
        if (this.f151242b != null) {
            tq.a(f16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void setZOrderMediaOverlay(boolean z16) {
    }
}
