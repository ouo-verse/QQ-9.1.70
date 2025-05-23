package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ad {

    /* renamed from: b, reason: collision with root package name */
    protected long f266114b;

    /* renamed from: c, reason: collision with root package name */
    protected long f266115c;

    /* renamed from: d, reason: collision with root package name */
    protected int f266116d;

    /* renamed from: e, reason: collision with root package name */
    protected int f266117e;

    /* renamed from: a, reason: collision with root package name */
    protected String f266113a = "";

    /* renamed from: f, reason: collision with root package name */
    protected ArrayList<dg> f266118f = new ArrayList<>();

    public String a() {
        return this.f266113a;
    }

    public int b() {
        return this.f266117e;
    }

    public long c() {
        return this.f266115c;
    }

    public ArrayList<dg> d() {
        return this.f266118f;
    }

    public long e() {
        return this.f266114b;
    }

    public int f() {
        return this.f266116d;
    }

    public void g(String str) {
        this.f266113a = str;
    }

    public void h(int i3) {
        this.f266117e = i3;
    }

    public void i(long j3) {
        this.f266115c = j3;
    }

    public void j(ArrayList<dg> arrayList) {
        this.f266118f = arrayList;
    }

    public void k(long j3) {
        this.f266114b = j3;
    }

    public void l(int i3) {
        this.f266116d = i3;
    }

    public String toString() {
        return "GWGProCreateLobbyReq{mAppId=" + this.f266113a + "mGuildId=" + this.f266114b + "mChannelId=" + this.f266115c + "mLobbyType=" + this.f266116d + "mCapacity=" + this.f266117e + "mExtendDic=" + this.f266118f + "}";
    }
}
