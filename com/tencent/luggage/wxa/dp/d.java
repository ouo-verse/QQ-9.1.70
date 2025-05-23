package com.tencent.luggage.wxa.dp;

import com.tencent.luggage.wxa.dp.c;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f124416a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a f124417b;

    /* renamed from: c, reason: collision with root package name */
    public Object f124418c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f124419d;

    public d(Iterator it, c.a aVar) {
        this.f124416a = it;
        this.f124417b = aVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f124419d) {
            return true;
        }
        while (this.f124416a.hasNext()) {
            Object next = this.f124416a.next();
            if (!this.f124417b.b(next)) {
                this.f124418c = next;
                this.f124419d = true;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.f124419d && !hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.f124418c;
        this.f124418c = null;
        this.f124419d = false;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
