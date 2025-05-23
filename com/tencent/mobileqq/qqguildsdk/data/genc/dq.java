package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class dq {

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<String> f266432a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    protected String f266433b = "";

    /* renamed from: c, reason: collision with root package name */
    protected long f266434c;

    public long a() {
        return this.f266434c;
    }

    public String b() {
        return this.f266433b;
    }

    public ArrayList<String> c() {
        return this.f266432a;
    }

    public void d(long j3) {
        this.f266434c = j3;
    }

    public void e(String str) {
        this.f266433b = str;
    }

    public void f(ArrayList<String> arrayList) {
        this.f266432a = arrayList;
    }

    public String toString() {
        return "GWGProPAReportExecuteReq{mRuleNameList=" + this.f266432a + "mInstrTraceId=" + this.f266433b + "mExecTime=" + this.f266434c + "}";
    }
}
