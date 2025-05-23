package com.tencent.biz.pubaccount.weishi.util;

/* compiled from: P */
/* loaded from: classes32.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private String f81800a;

    /* renamed from: b, reason: collision with root package name */
    private String f81801b;

    /* renamed from: c, reason: collision with root package name */
    private int f81802c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f81803d;

    public w(String str) {
        this.f81800a = str;
    }

    public void a() {
        this.f81802c++;
        x.b("LoadMoreReportHelper", "onLoadMore() sopName = " + this.f81800a + ", loadMoreTriggerCnt = " + this.f81802c);
    }

    public void c(int i3) {
        if (this.f81803d) {
            return;
        }
        this.f81803d = true;
        com.tencent.biz.pubaccount.weishi.report.g.d().i(this.f81800a, this.f81801b, i3);
    }

    public void d() {
        if (this.f81802c <= 0) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.report.g.d().h(this.f81800a, this.f81801b, this.f81802c);
        this.f81802c = 0;
    }

    public void e(String str) {
        this.f81801b = str;
    }

    public void b() {
        this.f81803d = false;
    }
}
