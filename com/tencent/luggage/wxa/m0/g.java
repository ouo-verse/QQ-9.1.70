package com.tencent.luggage.wxa.m0;

import java.io.File;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final String f133985a;

    /* renamed from: b, reason: collision with root package name */
    public final long f133986b;

    /* renamed from: c, reason: collision with root package name */
    public final long f133987c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f133988d;

    /* renamed from: e, reason: collision with root package name */
    public final File f133989e;

    /* renamed from: f, reason: collision with root package name */
    public final long f133990f;

    public g(String str, long j3, long j16, long j17, File file) {
        boolean z16;
        this.f133985a = str;
        this.f133986b = j3;
        this.f133987c = j16;
        if (file != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f133988d = z16;
        this.f133989e = file;
        this.f133990f = j17;
    }

    public boolean a() {
        return !this.f133988d;
    }

    public boolean b() {
        if (this.f133987c == -1) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        if (!this.f133985a.equals(gVar.f133985a)) {
            return this.f133985a.compareTo(gVar.f133985a);
        }
        long j3 = this.f133986b - gVar.f133986b;
        if (j3 == 0) {
            return 0;
        }
        return j3 < 0 ? -1 : 1;
    }
}
