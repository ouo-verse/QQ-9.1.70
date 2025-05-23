package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tab.exp.sdk.impl.q;
import com.tencent.tab.tabmonitor.export.config.TabAggregateType;
import java.util.Arrays;
import nd4.m;
import nd4.t;
import nd4.w;
import nd4.y;
import nd4.z;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final q f374134a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final TabExpDependInjector f374135b;

    /* renamed from: c, reason: collision with root package name */
    private d f374136c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private nd4.r f374137d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(@NonNull q qVar, @NonNull TabExpDependInjector tabExpDependInjector) {
        this.f374134a = qVar;
        this.f374135b = tabExpDependInjector;
        b();
        a();
    }

    private void a() {
        this.f374136c = new d(c(this.f374134a), this.f374135b);
    }

    private void b() {
        this.f374137d = nd4.s.c().a(new t.b().d(x.f(this.f374134a.f(), this.f374134a.n())).c(), new m.b().e(this.f374135b.getMetricsReportImpl()).d());
        TabAggregateType tabAggregateType = TabAggregateType.AVG;
        this.f374137d.b(new y(new w.b().f("tab_metrics").e(Arrays.asList("tab_monitor_api", "tab_monitor_status_code", "tab_monitor_app_id", "tab_monitor_channel")).g(Arrays.asList(new z("NetTTFBTimeKey", tabAggregateType), new z("NetRequestTimeKey", tabAggregateType), new z("NetParseTimeKey", tabAggregateType))).d()));
    }

    @NonNull
    private q c(@NonNull q qVar) {
        return new q.b().w(qVar.f()).x(qVar.g()).y(qVar.h()).C(qVar.j()).G(qVar.n()).D(qVar.k()).A(qVar.i()).m(qVar.b()).F(qVar.m()).E(qVar.l()).j(qVar.a()).l(qVar.e()).h(qVar.c()).i(qVar.d()).z();
    }

    @Nullable
    public cd4.c d() {
        return this.f374136c;
    }

    public synchronized void e(@Nullable kd4.a aVar) {
        d dVar = this.f374136c;
        if (dVar != null) {
            dVar.h(aVar);
        }
        nd4.r rVar = this.f374137d;
        if (rVar != null) {
            rVar.c();
        }
    }

    public synchronized void f(@Nullable String str, @Nullable kd4.a aVar) {
        d dVar = this.f374136c;
        if (dVar != null) {
            dVar.i(str, aVar);
        }
    }
}
