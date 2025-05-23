package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cn {

    /* renamed from: a, reason: collision with root package name */
    protected long f266320a;

    /* renamed from: b, reason: collision with root package name */
    protected int f266321b;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f266323d;

    /* renamed from: e, reason: collision with root package name */
    protected int f266324e;

    /* renamed from: f, reason: collision with root package name */
    protected int f266325f;

    /* renamed from: h, reason: collision with root package name */
    protected int f266327h;

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<cf> f266322c = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    protected ArrayList<cm> f266326g = new ArrayList<>();

    public int a() {
        return this.f266321b;
    }

    public ArrayList<cf> b() {
        return this.f266322c;
    }

    public ArrayList<cm> c() {
        return this.f266326g;
    }

    public int d() {
        return this.f266327h;
    }

    public boolean e() {
        return this.f266323d;
    }

    public int f() {
        return this.f266324e;
    }

    public int g() {
        return this.f266325f;
    }

    public long h() {
        return this.f266320a;
    }

    public void i(int i3) {
        this.f266321b = i3;
    }

    public void j(ArrayList<cf> arrayList) {
        this.f266322c = arrayList;
    }

    public void k(int i3) {
        this.f266327h = i3;
    }

    public void l(boolean z16) {
        this.f266323d = z16;
    }

    public void m(int i3) {
        this.f266324e = i3;
    }

    public void n(int i3) {
        this.f266325f = i3;
    }

    public void o(long j3) {
        this.f266320a = j3;
    }

    public String toString() {
        return "GWGProGuildOnlineReportReq{mTinyId=" + this.f266320a + "mActiveTab=" + this.f266321b + "mBrowseInfo=" + this.f266322c + "mIsVisiting=" + this.f266323d + "mScene=" + this.f266324e + "mSourceType=" + this.f266325f + "mExts=" + this.f266326g + "mFromPageId=" + this.f266327h + "}";
    }
}
