package com.tencent.gamecenter.wadl.sdk.downloader.b.d;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f107330a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f107331b;

    /* renamed from: c, reason: collision with root package name */
    private long f107332c;

    /* renamed from: d, reason: collision with root package name */
    private long f107333d;

    public b(List<String> list, List<String> list2) {
        this(list, list2, 60L, 60L);
    }

    public List<String> a() {
        return this.f107330a;
    }

    public long b() {
        return this.f107332c;
    }

    public List<String> c() {
        return this.f107331b;
    }

    public long d() {
        return this.f107333d;
    }

    public String toString() {
        return "IPInfo{mV4Ips=" + this.f107330a + ", mV6Ips=" + this.f107331b + ", v4Ttl=" + this.f107332c + ", v6Ttl=" + this.f107333d + '}';
    }

    public b(List<String> list, List<String> list2, long j3, long j16) {
        this.f107330a = new ArrayList();
        new ArrayList();
        this.f107330a = list;
        this.f107331b = list2;
        this.f107332c = j3;
        this.f107333d = j16;
    }
}
