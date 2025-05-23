package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ac {

    /* renamed from: c, reason: collision with root package name */
    protected int f266108c;

    /* renamed from: d, reason: collision with root package name */
    protected int f266109d;

    /* renamed from: e, reason: collision with root package name */
    protected int f266110e;

    /* renamed from: a, reason: collision with root package name */
    protected String f266106a = "";

    /* renamed from: b, reason: collision with root package name */
    protected eo f266107b = new eo();

    /* renamed from: f, reason: collision with root package name */
    protected String f266111f = "";

    /* renamed from: g, reason: collision with root package name */
    protected ArrayList<Long> f266112g = new ArrayList<>();

    public String a() {
        return this.f266106a;
    }

    public int b() {
        return this.f266110e;
    }

    public ArrayList<Long> c() {
        return this.f266112g;
    }

    public int d() {
        return this.f266109d;
    }

    public int e() {
        return this.f266108c;
    }

    public String f() {
        return this.f266111f;
    }

    public eo g() {
        return this.f266107b;
    }

    public void h(String str) {
        this.f266106a = str;
    }

    public void i(int i3) {
        this.f266110e = i3;
    }

    public void j(ArrayList<Long> arrayList) {
        this.f266112g = arrayList;
    }

    public void k(int i3) {
        this.f266109d = i3;
    }

    public void l(int i3) {
        this.f266108c = i3;
    }

    public void m(eo eoVar) {
        this.f266107b = eoVar;
    }

    public String toString() {
        return "GWGProCreateGuildReq{mGuildName=" + this.f266106a + "mSrc=" + this.f266107b + "mIsUploadAvatar=" + this.f266108c + "mIsSetName=" + this.f266109d + "mIgnoreGeneralizationWords=" + this.f266110e + "mProfile=" + this.f266111f + "mInvitedUinList=" + this.f266112g + "}";
    }
}
