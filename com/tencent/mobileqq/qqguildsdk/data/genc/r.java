package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<Long> f266664a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    protected int f266665b;

    public ArrayList<Long> a() {
        return this.f266664a;
    }

    public int b() {
        return this.f266665b;
    }

    public void c(ArrayList<Long> arrayList) {
        this.f266664a = arrayList;
    }

    public void d(int i3) {
        this.f266665b = i3;
    }

    public String toString() {
        return "GWGProBatchGetGuildLabelInfoReq{mGuildIds=" + this.f266664a + "mReqSource=" + this.f266665b + "}";
    }
}
