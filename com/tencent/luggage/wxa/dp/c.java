package com.tencent.luggage.wxa.dp;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final Iterable f124414a;

    /* renamed from: b, reason: collision with root package name */
    public final a f124415b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        boolean b(Object obj);
    }

    public c(Iterable iterable, a aVar) {
        this.f124414a = iterable;
        this.f124415b = aVar;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new d(this.f124414a.iterator(), this.f124415b);
    }
}
