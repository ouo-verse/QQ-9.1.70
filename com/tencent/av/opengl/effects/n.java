package com.tencent.av.opengl.effects;

import com.tencent.av.business.manager.pendant.PendantItem;

/* compiled from: P */
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private o f73995a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f73996b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f73997c = 0;

    /* renamed from: d, reason: collision with root package name */
    private q f73998d;

    public n(q qVar) {
        this.f73998d = qVar;
    }

    public void a() {
        o oVar = this.f73995a;
        if (oVar != null) {
            oVar.a();
            this.f73995a = null;
        }
    }

    public void b(com.tencent.avcore.camera.data.c cVar, ab abVar, t tVar, int i3, int i16) {
        if (this.f73995a == null) {
            return;
        }
        int d16 = d(cVar, abVar);
        this.f73997c = d16;
        this.f73995a.d(d16);
        if (this.f73995a.b()) {
            com.tencent.av.utils.ab abVar2 = this.f73998d.f74029o;
            if (abVar2 != null) {
                abVar2.e("extraRenderIn");
            }
            t c16 = this.f73995a.c(tVar, i3, i16);
            if (c16 != null) {
                this.f73998d.e(11, tVar, c16);
                tVar.f74045a = c16.f74045a;
                tVar.f74046b = c16.f74046b;
                c16.b();
            }
            com.tencent.av.utils.ab abVar3 = this.f73998d.f74029o;
            if (abVar3 != null) {
                abVar3.d("extraRenderIn");
            }
        }
    }

    public void c(t tVar, boolean z16, boolean z17, int i3, int i16) {
        int i17;
        o oVar = this.f73995a;
        if (oVar == null) {
            return;
        }
        boolean z18 = false;
        if ((z16 || z17) && z16 && z17) {
            z18 = true;
        }
        if (z18) {
            i17 = this.f73996b;
        } else {
            i17 = this.f73997c;
        }
        oVar.d(i17);
        if (this.f73995a.b()) {
            com.tencent.av.utils.ab abVar = this.f73998d.f74029o;
            if (abVar != null) {
                abVar.e("extraRenderOut");
            }
            t c16 = this.f73995a.c(tVar, i3, i16);
            if (c16 != null) {
                this.f73998d.e(12, tVar, c16);
                tVar.f74045a = c16.f74045a;
                tVar.f74046b = c16.f74046b;
                c16.b();
            }
            com.tencent.av.utils.ab abVar2 = this.f73998d.f74029o;
            if (abVar2 != null) {
                abVar2.d("extraRenderOut");
            }
        }
    }

    public int d(com.tencent.avcore.camera.data.c cVar, ab abVar) {
        PendantItem pendantItem = abVar.f73917c;
        if (pendantItem != null && abVar.f73916b != null && pendantItem.needHMirror) {
            return 1;
        }
        return 0;
    }

    public void e() {
        if (this.f73995a == null) {
            this.f73995a = new o();
        }
    }

    public void f(com.tencent.avcore.camera.data.c cVar, ab abVar) {
        this.f73996b = d(cVar, abVar);
    }
}
