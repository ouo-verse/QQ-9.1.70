package com.tencent.timi.game.teamlist.presenter;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.timi.game.teamlist.presenter.c;
import com.tencent.timi.game.teamlist.view.TeamListFilterView;
import com.tencent.timi.game.teamlist.view.TeamListSlideView;
import com.tencent.timi.game.utils.l;
import dn4.e;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b implements e.b {

    /* renamed from: a, reason: collision with root package name */
    private e f379812a;

    /* renamed from: b, reason: collision with root package name */
    private dn4.c f379813b;

    /* renamed from: d, reason: collision with root package name */
    private int f379815d;

    /* renamed from: e, reason: collision with root package name */
    private int f379816e;

    /* renamed from: h, reason: collision with root package name */
    private TeamListSlideView f379819h;

    /* renamed from: i, reason: collision with root package name */
    private TeamListFilterView f379820i;

    /* renamed from: c, reason: collision with root package name */
    private String f379814c = "";

    /* renamed from: f, reason: collision with root package name */
    private int f379817f = -1;

    /* renamed from: g, reason: collision with root package name */
    private c f379818g = new c();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements c.b {
        a() {
        }

        @Override // com.tencent.timi.game.teamlist.presenter.c.b
        public void a(int i3) {
            b.this.f379819h.h();
        }
    }

    public b(dn4.c cVar) {
        this.f379813b = cVar;
        this.f379812a = new e(cVar);
    }

    private void e() {
        l.b("TeamListSlidePresenter", "loadCacheData");
        this.f379812a.i(dn4.b.f394317a, this);
    }

    private void f(String str) {
        this.f379812a.h(str, this.f379815d, this.f379816e, this);
    }

    public void b(RecyclerView recyclerView) {
        recyclerView.setAdapter(this.f379818g);
        this.f379818g.m0(new a());
    }

    public void c(TeamListFilterView teamListFilterView) {
        this.f379820i = teamListFilterView;
        teamListFilterView.setData(this.f379813b);
    }

    public void d(TeamListSlideView teamListSlideView) {
        l.b("TeamListSlidePresenter", "bindTeamListSlideView");
        this.f379819h = teamListSlideView;
    }

    public void g() {
        this.f379820i.j(true);
        e();
        h();
    }

    public void h() {
        l.b("TeamListSlidePresenter", "refresh");
        this.f379812a.j();
        f(this.f379814c);
    }

    public void i(String str, int i3, int i16) {
        this.f379814c = str;
        this.f379815d = i3;
        this.f379816e = i16;
        this.f379818g.n0(str, i3, i16);
    }

    public void j(int i3) {
        this.f379817f = i3;
        this.f379818g.o0(i3);
    }

    @Override // dn4.e.b
    public void onDataSetChange() {
        this.f379818g.l0(this.f379812a.f394336g);
        TeamListSlideView teamListSlideView = this.f379819h;
        e eVar = this.f379812a;
        teamListSlideView.p(eVar.f394330a, eVar.f394336g.size());
        this.f379819h.n();
    }
}
