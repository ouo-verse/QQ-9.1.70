package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<String> f266635a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    protected int f266636b;

    /* renamed from: c, reason: collision with root package name */
    protected long f266637c;

    public ArrayList<String> a() {
        return this.f266635a;
    }

    public int b() {
        return this.f266636b;
    }

    public long c() {
        return this.f266637c;
    }

    public void d(ArrayList<String> arrayList) {
        this.f266635a = arrayList;
    }

    public void e(int i3) {
        this.f266636b = i3;
    }

    public String toString() {
        return "GWGProAISearchWordsReportReq{mGuildWordIds=" + this.f266635a + "mReportType=" + this.f266636b + "mTimestamp=" + this.f266637c + "}";
    }
}
