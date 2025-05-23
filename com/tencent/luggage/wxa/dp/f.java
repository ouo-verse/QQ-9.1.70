package com.tencent.luggage.wxa.dp;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final Iterable f124422a;

    /* renamed from: b, reason: collision with root package name */
    public final a f124423b;

    /* renamed from: c, reason: collision with root package name */
    public final b f124424c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f124425d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        Object a(Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void b();
    }

    public f(Iterable iterable, a aVar, boolean z16) {
        this(iterable, aVar, null, z16);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new g(this.f124422a.iterator(), this.f124423b, this.f124424c, this.f124425d);
    }

    public f(Iterable iterable, a aVar, b bVar, boolean z16) {
        this.f124422a = iterable;
        this.f124423b = aVar;
        this.f124424c = bVar;
        this.f124425d = z16;
    }
}
