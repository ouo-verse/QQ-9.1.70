package com.hihonor.mcs.fitness.health.datastore;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public class QueryRequest {

    /* renamed from: a, reason: collision with root package name */
    private long f36336a;

    /* renamed from: b, reason: collision with root package name */
    private long f36337b;

    /* renamed from: c, reason: collision with root package name */
    private int f36338c;

    /* renamed from: d, reason: collision with root package name */
    private int f36339d;

    /* renamed from: e, reason: collision with root package name */
    private int f36340e = 100;

    /* renamed from: f, reason: collision with root package name */
    private String f36341f = null;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface OrderTypeDef {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface QueryDataTypeDef {
    }

    public QueryRequest(int i3, long j3, long j16) {
        this.f36338c = i3;
        this.f36336a = j3;
        this.f36337b = j16;
    }

    public int a() {
        return this.f36338c;
    }

    public long b() {
        return this.f36337b;
    }

    public int c() {
        return this.f36339d;
    }

    public int d() {
        return this.f36340e;
    }

    public String e() {
        return this.f36341f;
    }

    public long f() {
        return this.f36336a;
    }

    public QueryRequest g(long j3) {
        this.f36337b = j3;
        return this;
    }

    public QueryRequest h(long j3) {
        this.f36336a = j3;
        return this;
    }
}
