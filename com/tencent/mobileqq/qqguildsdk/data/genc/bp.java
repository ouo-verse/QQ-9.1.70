package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bp {

    /* renamed from: c, reason: collision with root package name */
    protected int f266216c;

    /* renamed from: a, reason: collision with root package name */
    protected dh f266214a = new dh();

    /* renamed from: b, reason: collision with root package name */
    protected byte[] f266215b = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    protected String f266217d = "";

    /* renamed from: e, reason: collision with root package name */
    protected ArrayList<cy> f266218e = new ArrayList<>();

    public byte[] a() {
        return this.f266215b;
    }

    public ArrayList<cy> b() {
        return this.f266218e;
    }

    public int c() {
        return this.f266216c;
    }

    public String d() {
        return this.f266217d;
    }

    public dh e() {
        return this.f266214a;
    }

    public void f(byte[] bArr) {
        this.f266215b = bArr;
    }

    public void g(ArrayList<cy> arrayList) {
        this.f266218e = arrayList;
    }

    public void h(int i3) {
        this.f266216c = i3;
    }

    public void i(String str) {
        this.f266217d = str;
    }

    public void j(dh dhVar) {
        this.f266214a = dhVar;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProGetHotLiveReq{mSource=");
        sb5.append(this.f266214a);
        sb5.append("mCookies.length=");
        byte[] bArr = this.f266215b;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("mRefreshNum=");
        sb5.append(this.f266216c);
        sb5.append("mSessionId=");
        sb5.append(this.f266217d);
        sb5.append("mNeedTopItems=");
        sb5.append(this.f266218e);
        sb5.append("}");
        return sb5.toString();
    }
}
