package com.tencent.luggage.wxa.dp;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final Iterable f124407a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC6145a f124408b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.dp.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6145a {
        Iterable a(Object obj);
    }

    public a(Iterable iterable, InterfaceC6145a interfaceC6145a) {
        this.f124407a = iterable;
        this.f124408b = interfaceC6145a;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new b(this.f124407a.iterator(), this.f124408b);
    }
}
