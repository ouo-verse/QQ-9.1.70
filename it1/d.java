package it1;

import android.opengl.EGLContext;
import android.util.Size;
import android.view.Surface;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private c f408699a;

    public d(EGLContext eGLContext, Surface surface) {
        this.f408699a = b.d(null, eGLContext, surface, 0, 0);
    }

    public void a() {
        this.f408699a.destroy();
        this.f408699a = null;
    }

    public Size b() {
        c cVar = this.f408699a;
        if (cVar == null) {
            return new Size(0, 0);
        }
        return cVar.b();
    }

    public boolean c() {
        if (this.f408699a != null) {
            return true;
        }
        return false;
    }

    public void d() {
        c cVar = this.f408699a;
        if (cVar == null) {
            return;
        }
        cVar.makeCurrent();
    }

    public void e() {
        c cVar = this.f408699a;
        if (cVar == null) {
            return;
        }
        cVar.swapBuffers();
    }

    public void f() {
        c cVar = this.f408699a;
        if (cVar == null) {
            return;
        }
        cVar.a();
    }

    public d(javax.microedition.khronos.egl.EGLContext eGLContext, Surface surface) {
        this.f408699a = a.d(null, eGLContext, surface, 0, 0);
    }
}
