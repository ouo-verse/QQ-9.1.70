package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cv {

    /* renamed from: a, reason: collision with root package name */
    protected long f266348a;

    /* renamed from: b, reason: collision with root package name */
    protected long f266349b;

    /* renamed from: e, reason: collision with root package name */
    protected int f266352e;

    /* renamed from: h, reason: collision with root package name */
    protected int f266355h;

    /* renamed from: i, reason: collision with root package name */
    protected long f266356i;

    /* renamed from: c, reason: collision with root package name */
    protected String f266350c = "";

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<String> f266351d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    protected fd f266353f = new fd();

    /* renamed from: g, reason: collision with root package name */
    protected ArrayList<df> f266354g = new ArrayList<>();

    public String a() {
        return this.f266350c;
    }

    public long b() {
        return this.f266356i;
    }

    public long c() {
        return this.f266349b;
    }

    public int d() {
        return this.f266355h;
    }

    public long e() {
        return this.f266348a;
    }

    public ArrayList<df> f() {
        return this.f266354g;
    }

    public ArrayList<String> g() {
        return this.f266351d;
    }

    public int h() {
        return this.f266352e;
    }

    public fd i() {
        return this.f266353f;
    }

    public void j(String str) {
        this.f266350c = str;
    }

    public void k(long j3) {
        this.f266349b = j3;
    }

    public void l(long j3) {
        this.f266348a = j3;
    }

    public void m(ArrayList<df> arrayList) {
        this.f266354g = arrayList;
    }

    public void n(ArrayList<String> arrayList) {
        this.f266351d = arrayList;
    }

    public void o(int i3) {
        this.f266352e = i3;
    }

    public void p(fd fdVar) {
        this.f266353f = fdVar;
    }

    public String toString() {
        return "GWGProHeartbeatReq{mGuildId=" + this.f266348a + "mChannelId=" + this.f266349b + "mAuthMeta=" + this.f266350c + "mRoomIdList=" + this.f266351d + "mStreamType=" + this.f266352e + "mUserDevState=" + this.f266353f + "mKvInfoList=" + this.f266354g + "mChannelType=" + this.f266355h + "mChannelDataVersion=" + this.f266356i + "}";
    }
}
