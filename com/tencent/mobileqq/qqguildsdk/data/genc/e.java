package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected String f266464a = "";

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<f> f266465b = new ArrayList<>();

    public ArrayList<f> a() {
        return this.f266465b;
    }

    public String b() {
        return this.f266464a;
    }

    public void c(ArrayList<f> arrayList) {
        this.f266465b = arrayList;
    }

    public void d(String str) {
        this.f266464a = str;
    }

    public String toString() {
        return "GWGProAISearchMsgShareData{mSessionId=" + this.f266464a + "mMsgList=" + this.f266465b + "}";
    }
}
