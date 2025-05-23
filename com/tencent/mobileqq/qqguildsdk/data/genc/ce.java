package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ce {

    /* renamed from: a, reason: collision with root package name */
    protected long f266244a;

    /* renamed from: b, reason: collision with root package name */
    protected int f266245b;

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<cd> f266246c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    protected int f266247d;

    public ArrayList<cd> a() {
        return this.f266246c;
    }

    public int b() {
        return this.f266245b;
    }

    public long c() {
        return this.f266244a;
    }

    public int d() {
        return this.f266247d;
    }

    public void e(ArrayList<cd> arrayList) {
        this.f266246c = arrayList;
    }

    public void f(int i3) {
        this.f266245b = i3;
    }

    public void g(long j3) {
        this.f266244a = j3;
    }

    public void h(int i3) {
        this.f266247d = i3;
    }

    public String toString() {
        return "GWGProGuildAuditInfoReq{mGuildId=" + this.f266244a + "mAuditReqType=" + this.f266245b + "mAuditList=" + this.f266246c + "mIgnoreGeneralizationWords=" + this.f266247d + "}";
    }
}
