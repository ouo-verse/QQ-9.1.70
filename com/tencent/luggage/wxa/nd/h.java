package com.tencent.luggage.wxa.nd;

import java.net.InetAddress;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    public static int f135677d = 900;

    /* renamed from: a, reason: collision with root package name */
    public InetAddress f135678a;

    /* renamed from: b, reason: collision with root package name */
    public int f135679b;

    /* renamed from: c, reason: collision with root package name */
    public int f135680c;

    public h(InetAddress inetAddress, int i3, int i16) {
        this.f135678a = inetAddress;
        this.f135679b = i3;
        this.f135680c = i16;
    }

    public InetAddress a() {
        return this.f135678a;
    }

    public int b() {
        return this.f135679b;
    }

    public int c() {
        return this.f135680c;
    }

    public h(String str, int i3) {
        this(InetAddress.getByName(str), i3, f135677d);
    }
}
