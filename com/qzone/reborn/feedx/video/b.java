package com.qzone.reborn.feedx.video;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.util.Iterator;
import java.util.LinkedList;
import kh.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final QZonePlayer f55807a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedList<kh.c> f55808b;

    public b(QZonePlayer qZonePlayer) {
        LinkedList<kh.c> linkedList = new LinkedList<>();
        this.f55808b = linkedList;
        this.f55807a = qZonePlayer;
        linkedList.add(new d(this));
        d();
    }

    private void d() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().c(this.f55807a);
        }
    }

    public void b(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().a(superPlayerOption, iSuperPlayer);
        }
    }

    public void c(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().b(superPlayerOption, iSuperPlayer);
        }
    }

    public void e() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public boolean f(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().e(iSuperPlayer, i3, i16, i17, str);
        }
        return false;
    }

    public void g(Object obj) {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().f(obj);
        }
    }

    public void h() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    public void i() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    public void j() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    public void k() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    public void l(Object obj) {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().k(obj);
        }
    }

    public void m() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    public void n() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().m();
        }
    }

    public void o(Object obj) {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().n(obj);
        }
    }

    public void p() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }

    public void q(ISuperPlayer iSuperPlayer) {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().p(iSuperPlayer);
        }
    }

    public void r() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().q();
        }
    }

    public void s() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().r();
        }
    }

    public void t(int i3, int i16) {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().s(i3, i16);
        }
    }

    public void u() {
        Iterator<kh.c> it = this.f55808b.iterator();
        while (it.hasNext()) {
            it.next().t();
        }
    }

    public void a(kh.c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.u(this);
        this.f55808b.add(cVar);
    }
}
