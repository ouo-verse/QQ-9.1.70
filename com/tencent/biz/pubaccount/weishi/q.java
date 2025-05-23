package com.tencent.biz.pubaccount.weishi;

import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private final String f81353a;

    /* renamed from: b, reason: collision with root package name */
    private final int f81354b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f81355c;

    /* renamed from: d, reason: collision with root package name */
    private String f81356d;

    /* renamed from: e, reason: collision with root package name */
    private String f81357e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f81358f;

    /* renamed from: g, reason: collision with root package name */
    private RecentContactInfo f81359g;

    public q(String str, int i3, boolean z16) {
        this.f81353a = str;
        this.f81354b = i3;
        this.f81355c = z16;
    }

    public String a() {
        return this.f81356d;
    }

    public String b() {
        return this.f81353a;
    }

    public String c() {
        return this.f81357e;
    }

    public RecentContactInfo d() {
        return this.f81359g;
    }

    public boolean e() {
        return this.f81355c;
    }

    public boolean f() {
        return this.f81358f;
    }

    public q g(String str) {
        this.f81356d = str;
        return this;
    }

    public q h(boolean z16) {
        this.f81358f = z16;
        return this;
    }

    public q i(String str) {
        this.f81357e = str;
        return this;
    }

    public q j(RecentContactInfo recentContactInfo) {
        this.f81359g = recentContactInfo;
        return this;
    }
}
