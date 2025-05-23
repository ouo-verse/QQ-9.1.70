package com.tencent.luggage.wxa.c9;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f123434a;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f123439f;

    /* renamed from: b, reason: collision with root package name */
    public int f123435b = 44100;

    /* renamed from: c, reason: collision with root package name */
    public int f123436c = 2;

    /* renamed from: d, reason: collision with root package name */
    public int f123437d = 2;

    /* renamed from: e, reason: collision with root package name */
    public long f123438e = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f123440g = false;

    public boolean a() {
        return this.f123440g;
    }

    public void b() {
        this.f123435b = 44100;
        this.f123436c = 44100;
        this.f123437d = 2;
        this.f123434a = "";
        this.f123438e = 0L;
        byte[] bArr = this.f123439f;
        if (bArr != null) {
            Arrays.fill(bArr, 0, bArr.length, (byte) 0);
        }
    }

    public void a(boolean z16) {
        this.f123440g = z16;
    }
}
