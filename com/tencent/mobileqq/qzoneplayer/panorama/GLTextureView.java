package com.tencent.mobileqq.qzoneplayer.panorama;

import android.content.Context;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.SafeTextureView;

/* compiled from: P */
/* loaded from: classes35.dex */
public class GLTextureView extends SafeTextureView {
    private Surface C;

    /* renamed from: d, reason: collision with root package name */
    protected d f279386d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f279387e;

    /* renamed from: f, reason: collision with root package name */
    protected int f279388f;

    /* renamed from: h, reason: collision with root package name */
    protected int f279389h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f279390i;

    /* renamed from: m, reason: collision with root package name */
    private RendererType f279391m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public enum RendererType {
        NONE,
        NOMARL,
        VIDEO360
    }

    public GLTextureView(Context context) {
        super(context);
        this.f279390i = false;
        this.f279391m = RendererType.NONE;
        this.f279387e = context;
    }

    public Surface a(RendererType rendererType) {
        d dVar = this.f279386d;
        if (dVar != null) {
            dVar.m();
            this.f279386d = null;
        }
        setOnTouchListener(null);
        this.f279391m = rendererType;
        this.C = null;
        if (rendererType == RendererType.VIDEO360 && a.e(this.f279387e) && !BaseVideoManager.belowICE_CREAM) {
            b a16 = c.b().a();
            if (a16 != null) {
                d dVar2 = new d(this.f279387e, a16, getSurfaceTexture(), this.f279388f, this.f279389h);
                this.f279386d = dVar2;
                dVar2.g();
                if (this.f279390i) {
                    this.f279386d.w(this.f279388f, this.f279389h);
                }
                this.C = this.f279386d.r();
                this.f279386d.B(f());
            } else {
                this.C = new Surface(getSurfaceTexture());
            }
        } else {
            this.C = new Surface(getSurfaceTexture());
        }
        return this.C;
    }

    public int b() {
        return this.f279389h;
    }

    public int c() {
        return this.f279388f;
    }

    public Surface d(RendererType rendererType) {
        d dVar;
        if (this.f279391m == rendererType && this.C != null) {
            if (this.f279390i && (dVar = this.f279386d) != null) {
                dVar.w(this.f279388f, this.f279389h);
            }
        } else {
            this.C = a(rendererType);
        }
        return this.C;
    }

    public boolean e() {
        return this.f279391m == RendererType.VIDEO360;
    }

    public boolean f() {
        int screenWidth = FeedVideoEnv.getScreenWidth();
        int screenHeight = FeedVideoEnv.getScreenHeight();
        int c16 = c();
        int b16 = b();
        if (c16 <= b16) {
            c16 = b16;
        }
        if (screenWidth <= screenHeight) {
            screenWidth = screenHeight;
        }
        return c16 == screenWidth;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        k();
    }

    public void h(int i3, int i16) {
        setDisplaySize(i3, i16);
        d dVar = this.f279386d;
        if (dVar != null) {
            dVar.x(i3, i16);
            this.f279386d.B(f());
        }
    }

    public void i() {
        d dVar = this.f279386d;
        if (dVar != null) {
            dVar.y();
        }
    }

    public boolean j(View view, MotionEvent motionEvent) {
        d dVar = this.f279386d;
        if (dVar == null) {
            return false;
        }
        dVar.z(view, motionEvent);
        return false;
    }

    public void k() {
        this.f279391m = RendererType.NONE;
        d dVar = this.f279386d;
        if (dVar != null) {
            dVar.m();
            this.f279386d = null;
        }
    }

    public void setDisplaySize(int i3, int i16) {
        this.f279388f = i3;
        this.f279389h = i16;
    }

    public void g(int i3, int i16) {
        this.f279390i = true;
        setDisplaySize(i3, i16);
        d dVar = this.f279386d;
        if (dVar != null) {
            dVar.w(i3, i16);
        }
    }
}
