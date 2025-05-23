package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    protected long f266646a;

    /* renamed from: b, reason: collision with root package name */
    protected long f266647b;

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<cc> f266648c = new ArrayList<>();

    public long a() {
        return this.f266647b;
    }

    public ArrayList<cc> b() {
        return this.f266648c;
    }

    public long c() {
        return this.f266646a;
    }

    public void d(long j3) {
        this.f266647b = j3;
    }

    public void e(ArrayList<cc> arrayList) {
        this.f266648c = arrayList;
    }

    public void f(long j3) {
        this.f266646a = j3;
    }

    public String toString() {
        return "GWGProAVMemberGroupListReq{mGuildId=" + this.f266646a + "mChannelId=" + this.f266647b + "mGroupTypes=" + this.f266648c + "}";
    }
}
