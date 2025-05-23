package com.google.protobuf;

import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class bi {

    /* renamed from: c, reason: collision with root package name */
    private static final bi f35717c = new bi();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, bq<?>> f35719b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final br f35718a = new ak();

    bi() {
    }

    public static bi a() {
        return f35717c;
    }

    public <T> void b(T t16, bn bnVar, t tVar) throws IOException {
        e(t16).i(t16, bnVar, tVar);
    }

    public bq<?> c(Class<?> cls, bq<?> bqVar) {
        ad.b(cls, "messageType");
        ad.b(bqVar, QZoneDTLoginReporter.SCHEMA);
        return this.f35719b.putIfAbsent(cls, bqVar);
    }

    public <T> bq<T> d(Class<T> cls) {
        ad.b(cls, "messageType");
        bq<T> bqVar = (bq) this.f35719b.get(cls);
        if (bqVar == null) {
            bq<T> a16 = this.f35718a.a(cls);
            bq<T> bqVar2 = (bq<T>) c(cls, a16);
            if (bqVar2 != null) {
                return bqVar2;
            }
            return a16;
        }
        return bqVar;
    }

    public <T> bq<T> e(T t16) {
        return d(t16.getClass());
    }
}
