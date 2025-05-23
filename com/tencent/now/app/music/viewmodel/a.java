package com.tencent.now.app.music.viewmodel;

import am3.d;
import am3.e;
import am3.f;
import android.text.TextUtils;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.now.app.music.model.data.MusicItem;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements ThreadCenter.HandlerKeyable {
    private bm3.b C;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.now.app.music.controller.b f338079m;

    /* renamed from: d, reason: collision with root package name */
    public d f338074d = new d();

    /* renamed from: e, reason: collision with root package name */
    public am3.b f338075e = new am3.b();

    /* renamed from: f, reason: collision with root package name */
    public am3.c f338076f = new am3.c();

    /* renamed from: h, reason: collision with root package name */
    public f f338077h = new f();

    /* renamed from: i, reason: collision with root package name */
    public e f338078i = new e();
    private int D = 0;

    public a(bm3.b bVar) {
        this.C = bVar;
        a(bVar);
        d();
        this.f338076f.h(false);
    }

    private void a(bm3.b bVar) {
        this.f338074d.a(bVar.f28658m);
        this.f338075e.a(bVar.C);
        this.f338078i.a(bVar.D);
        this.f338076f.a(bVar.E);
        this.f338077h.a(bVar.F);
    }

    private void d() {
        this.f338074d.b();
        this.f338075e.b();
        this.f338078i.b();
        this.f338076f.b();
        this.f338077h.b();
    }

    public void b() {
        com.tencent.now.app.music.controller.b bVar = this.f338079m;
        if (bVar != null) {
            bVar.d(false);
        }
        ThreadCenter.clear(this);
    }

    public void c(int i3) {
        this.D = i3;
        this.f338074d.j(0);
        this.f338075e.j(0);
        this.f338078i.l(0);
        this.f338076f.l(0);
        this.f338077h.m(0);
        com.tencent.now.app.music.controller.b bVar = this.f338079m;
        if (bVar != null && bVar.b() == 0) {
            this.C.G.setVisibility(0);
        }
    }

    public void e(int i3) {
        this.D = i3;
    }

    public void f(com.tencent.now.app.music.controller.b bVar) {
        this.f338079m = bVar;
        this.f338074d.f(bVar);
        this.f338075e.k(bVar);
        this.f338076f.g(bVar);
        this.f338078i.g(bVar);
        this.f338077h.h(bVar);
    }

    public void g() {
        f fVar = this.f338077h;
        if (fVar != null) {
            fVar.n();
        }
        this.f338077h = null;
    }

    public void h(MusicItem musicItem) {
        com.tencent.now.app.music.controller.a aVar;
        if (musicItem == null) {
            return;
        }
        this.f338074d.e(this.D);
        boolean z16 = false;
        this.f338077h.g(0);
        com.tencent.now.app.music.controller.b bVar = this.f338079m;
        if (bVar != null) {
            aVar = bVar.k();
        } else {
            aVar = null;
        }
        if (aVar != null && aVar.a() != -999) {
            this.f338075e.f(aVar.a());
        } else if (!TextUtils.isEmpty(musicItem.songLyric)) {
            this.f338075e.f(2);
        } else {
            this.f338075e.f(-1);
        }
        this.f338076f.h(true);
        if (aVar != null && aVar.b() != -999) {
            this.f338076f.f(aVar.b());
        } else {
            this.f338076f.f(0);
        }
        if (aVar != null && aVar.c() != -999) {
            e eVar = this.f338078i;
            int c16 = aVar.c();
            int i3 = this.D;
            if (musicItem.getSingFlag() == 2) {
                z16 = true;
            }
            eVar.f(c16, i3, z16);
            return;
        }
        e eVar2 = this.f338078i;
        int singFlag = musicItem.getSingFlag();
        int i16 = this.D;
        if (musicItem.getSingFlag() == 2) {
            z16 = true;
        }
        eVar2.f(singFlag, i16, z16);
    }
}
