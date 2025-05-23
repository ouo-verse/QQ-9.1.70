package com.tencent.now.pkgame.pkgame.pklib.model;

import android.os.Bundle;
import com.tencent.now.pkgame.pkgame.pklib.repository.impl.ServiceDataSourceImpl;
import com.tencent.now.pkgame.pkgame.pklib.state.PkGameStateManager;
import com.tencent.now.pkgame.pkgame.pklib.time.PKTimer;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.q;
import g55.s;
import java.util.ArrayList;
import java.util.List;
import or4.g;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private ko3.b f338966b;

    /* renamed from: c, reason: collision with root package name */
    private ho3.a f338967c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.now.pkgame.pkgame.pklib.time.a f338968d;

    /* renamed from: e, reason: collision with root package name */
    private mo3.c f338969e;

    /* renamed from: f, reason: collision with root package name */
    private PkGameStateManager f338970f;

    /* renamed from: g, reason: collision with root package name */
    private int f338971g;

    /* renamed from: m, reason: collision with root package name */
    private long f338977m;

    /* renamed from: n, reason: collision with root package name */
    private long f338978n;

    /* renamed from: o, reason: collision with root package name */
    private Bundle f338979o;

    /* renamed from: p, reason: collision with root package name */
    private String f338980p;

    /* renamed from: q, reason: collision with root package name */
    private int f338981q;

    /* renamed from: h, reason: collision with root package name */
    private List<a> f338972h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private List<b> f338973i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private boolean f338974j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f338975k = false;

    /* renamed from: l, reason: collision with root package name */
    private co3.d f338976l = new co3.d();

    /* renamed from: a, reason: collision with root package name */
    private ko3.a f338965a = new com.tencent.now.pkgame.pkgame.pklib.repository.impl.a();

    public e(long j3) {
        this.f338978n = j3;
        ServiceDataSourceImpl serviceDataSourceImpl = new ServiceDataSourceImpl();
        this.f338966b = serviceDataSourceImpl;
        serviceDataSourceImpl.d(this.f338972h);
        this.f338968d = new PKTimer(this);
        ho3.a aVar = new ho3.a();
        this.f338967c = aVar;
        this.f338966b.b(aVar);
        this.f338969e = new mo3.c();
        this.f338970f = new PkGameStateManager(this, this.f338967c, this.f338969e);
    }

    public void A() {
        this.f338965a.c();
    }

    public void a(c cVar) {
        this.f338965a.b(cVar);
    }

    public void b(a aVar) {
        this.f338972h.add(aVar);
    }

    public void c(b bVar) {
        this.f338973i.add(bVar);
    }

    public void d(mo3.d dVar) {
        this.f338969e.a(dVar);
    }

    public void e(int i3, ko3.c<s> cVar) {
        boolean q16 = q();
        AegisLogger.i("PK_Biz|PkGameModel", "fetchPkContribList isRankLinkPK: " + q());
        if (q16) {
            this.f338966b.f(this.f338978n, 0, i3, cVar);
        } else {
            this.f338966b.a(this.f338978n, i3, cVar);
        }
    }

    public void f(ko3.c<q> cVar) {
        this.f338966b.e(this.f338978n, cVar);
    }

    public void g(int i3, ko3.c<s> cVar) {
        boolean q16 = q();
        AegisLogger.i("PK_Biz|PkGameModel", "fetchPkResult isRankLinkPK: " + q());
        if (q16) {
            this.f338966b.f(this.f338978n, 0, i3, cVar);
        } else {
            this.f338966b.a(this.f338978n, i3, cVar);
        }
    }

    public long h() {
        return this.f338977m;
    }

    public co3.d i() {
        return this.f338976l;
    }

    public mo3.c j() {
        return this.f338969e;
    }

    public void k(long j3, long j16, ko3.c<g> cVar) {
        this.f338966b.c(j3, j16, cVar);
    }

    public ho3.a l() {
        return this.f338967c;
    }

    public com.tencent.now.pkgame.pkgame.pklib.time.a m() {
        return this.f338968d;
    }

    public Bundle n() {
        return this.f338979o;
    }

    public long o() {
        return this.f338978n;
    }

    public String p() {
        return this.f338980p;
    }

    public boolean q() {
        AegisLogger.i("PK_Biz|PkGameModel", "pkType: " + this.f338981q);
        if (this.f338981q == 2) {
            return true;
        }
        return false;
    }

    public void r() {
        this.f338971g++;
    }

    public void s() {
        this.f338965a.d();
    }

    public void t(boolean z16) {
        AegisLogger.i("PK_Biz|PkGameModel", "release", "isExitRoom: " + z16);
        if (z16) {
            this.f338972h.clear();
        }
        this.f338973i.clear();
        this.f338975k = false;
        this.f338974j = false;
        this.f338968d.release();
        this.f338970f.h(z16);
        this.f338969e.f();
    }

    public void u(long j3) {
        this.f338977m = j3;
    }

    public void v(boolean z16) {
        if (this.f338973i.size() == 0) {
            AegisLogger.i("PK_Biz|PkGameModel", "\u6ca1\u6709PK\u754c\u9762\uff0c\u5ffd\u7565\u7ed3\u7b97\u72b6\u6001\uff0c\u907f\u514d\u5f71\u54cd\u4e0b\u4e00\u573aPK\u3002");
            return;
        }
        this.f338975k = z16;
        AegisLogger.i("PK_Biz|PkGameModel", "isPKSettled:" + this.f338975k + ", hasNotifyPKSettled:" + this.f338974j);
        if (this.f338975k && !this.f338974j) {
            this.f338974j = true;
            for (int i3 = 0; i3 < this.f338973i.size(); i3++) {
                this.f338973i.get(i3).a();
            }
        }
    }

    public void w(long j3) {
        this.f338965a.a(j3);
    }

    public void x(int i3) {
        this.f338981q = i3;
    }

    public void y(Bundle bundle) {
        this.f338979o = bundle;
    }

    public void z(String str) {
        this.f338980p = str;
    }
}
