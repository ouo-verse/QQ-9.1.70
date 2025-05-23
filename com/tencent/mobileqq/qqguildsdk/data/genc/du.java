package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class du {

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<Long> f266443a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    protected boolean f266444b;

    /* renamed from: c, reason: collision with root package name */
    protected long f266445c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f266446d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f266447e;

    /* renamed from: f, reason: collision with root package name */
    protected int f266448f;

    public boolean a() {
        return this.f266446d;
    }

    public long b() {
        return this.f266445c;
    }

    public boolean c() {
        return this.f266447e;
    }

    public int d() {
        return this.f266448f;
    }

    public boolean e() {
        return this.f266444b;
    }

    public ArrayList<Long> f() {
        return this.f266443a;
    }

    public void g(boolean z16) {
        this.f266446d = z16;
    }

    public void h(long j3) {
        this.f266445c = j3;
    }

    public void i(boolean z16) {
        this.f266447e = z16;
    }

    public void j(int i3) {
        this.f266448f = i3;
    }

    public void k(boolean z16) {
        this.f266444b = z16;
    }

    public void l(ArrayList<Long> arrayList) {
        this.f266443a = arrayList;
    }

    public String toString() {
        return "GWGProRemoveRiskMembersReq{mTinyidList=" + this.f266443a + "mSelectAll=" + this.f266444b + "mGuildId=" + this.f266445c + "mAddBlack=" + this.f266446d + "mRemoveFromGuild=" + this.f266447e + "mRevokeType=" + this.f266448f + "}";
    }
}
