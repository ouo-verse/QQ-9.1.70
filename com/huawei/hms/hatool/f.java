package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f implements g {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f37096a;

    /* renamed from: b, reason: collision with root package name */
    private String f37097b;

    /* renamed from: c, reason: collision with root package name */
    private String f37098c;

    /* renamed from: d, reason: collision with root package name */
    private String f37099d;

    /* renamed from: e, reason: collision with root package name */
    private String f37100e;

    /* renamed from: f, reason: collision with root package name */
    private List<b1> f37101f;

    public f(byte[] bArr, String str, String str2, String str3, String str4, List<b1> list) {
        this.f37096a = (byte[]) bArr.clone();
        this.f37097b = str;
        this.f37098c = str2;
        this.f37100e = str3;
        this.f37099d = str4;
        this.f37101f = list;
    }

    private n0 a(Map<String, String> map) {
        return w.a(this.f37097b, this.f37096a, map);
    }

    private void b() {
        b0.c().a(new d1(this.f37101f, this.f37098c, this.f37099d, this.f37100e));
    }

    @Override // java.lang.Runnable
    public void run() {
        v.c("hmsSdk", "send data running");
        int b16 = a(a()).b();
        if (b16 != 200) {
            b();
            return;
        }
        v.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f37099d, this.f37100e, this.f37098c, Integer.valueOf(b16));
    }

    private Map<String, String> a() {
        return k.b(this.f37098c, this.f37100e, this.f37099d);
    }
}
