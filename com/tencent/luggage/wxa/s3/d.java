package com.tencent.luggage.wxa.s3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f140012a;

    /* renamed from: b, reason: collision with root package name */
    public final String f140013b;

    /* renamed from: c, reason: collision with root package name */
    public final int f140014c;

    /* renamed from: d, reason: collision with root package name */
    public final long f140015d;

    /* renamed from: e, reason: collision with root package name */
    public final String f140016e;

    /* renamed from: f, reason: collision with root package name */
    public final List f140017f;

    /* renamed from: g, reason: collision with root package name */
    public final String f140018g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f140019h;

    /* renamed from: i, reason: collision with root package name */
    public final String f140020i;

    public d(String str, String deviceType, int i3, long j3, String deviceUsername, List logPath, String str2, boolean z16, String str3) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(deviceUsername, "deviceUsername");
        Intrinsics.checkNotNullParameter(logPath, "logPath");
        this.f140012a = str;
        this.f140013b = deviceType;
        this.f140014c = i3;
        this.f140015d = j3;
        this.f140016e = deviceUsername;
        this.f140017f = logPath;
        this.f140018g = str2;
        this.f140019h = z16;
        this.f140020i = str3;
    }

    public final String a() {
        return this.f140018g;
    }

    public final String b() {
        return this.f140013b;
    }

    public final long c() {
        return this.f140015d;
    }

    public final String d() {
        return this.f140016e;
    }

    public final String e() {
        return this.f140020i;
    }

    public final boolean f() {
        return this.f140019h;
    }

    public final List g() {
        return this.f140017f;
    }

    public final int h() {
        return this.f140014c;
    }

    public final String i() {
        return this.f140012a;
    }
}
