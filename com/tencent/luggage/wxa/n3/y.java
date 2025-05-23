package com.tencent.luggage.wxa.n3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final int f135272a;

    /* renamed from: b, reason: collision with root package name */
    public final int f135273b;

    /* renamed from: c, reason: collision with root package name */
    public final String f135274c;

    /* renamed from: d, reason: collision with root package name */
    public final int f135275d;

    /* renamed from: e, reason: collision with root package name */
    public final List f135276e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f135277f;

    /* renamed from: g, reason: collision with root package name */
    public final String f135278g;

    /* renamed from: h, reason: collision with root package name */
    public final String f135279h;

    /* renamed from: i, reason: collision with root package name */
    public final List f135280i;

    public y(int i3, int i16, String str, int i17, List ilinkAppIds, boolean z16, String str2, String str3, List ilinkLogs) {
        Intrinsics.checkNotNullParameter(ilinkAppIds, "ilinkAppIds");
        Intrinsics.checkNotNullParameter(ilinkLogs, "ilinkLogs");
        this.f135272a = i3;
        this.f135273b = i16;
        this.f135274c = str;
        this.f135275d = i17;
        this.f135276e = ilinkAppIds;
        this.f135277f = z16;
        this.f135278g = str2;
        this.f135279h = str3;
        this.f135280i = ilinkLogs;
    }

    public final int a() {
        return this.f135273b;
    }

    public final String b() {
        return this.f135278g;
    }

    public final String c() {
        return this.f135279h;
    }

    public final boolean d() {
        return this.f135277f;
    }

    public final int e() {
        return this.f135272a;
    }

    public final String f() {
        return this.f135274c;
    }

    public final int g() {
        return this.f135275d;
    }

    public String toString() {
        return "PullLogCmd(startTime=" + this.f135272a + ", endTime=" + this.f135273b + ", uploadToken=" + this.f135274c + ", useNetType=" + this.f135275d + ", ilinkAppIds=" + this.f135276e + ", includeDevLog=" + this.f135277f + ", extBuffer=" + this.f135278g + ", ilinkCaPath=" + this.f135279h + ", ilinkLogs=" + this.f135280i + ')';
    }
}
