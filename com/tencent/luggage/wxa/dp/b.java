package com.tencent.luggage.wxa.dp;

import com.tencent.luggage.wxa.dp.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f124409a;

    /* renamed from: b, reason: collision with root package name */
    public final a.InterfaceC6145a f124410b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f124411c = Collections.emptyList().iterator();

    /* renamed from: d, reason: collision with root package name */
    public Object f124412d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f124413e;

    public b(Iterator it, a.InterfaceC6145a interfaceC6145a) {
        this.f124409a = it;
        this.f124410b = interfaceC6145a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Iterator it;
        if (this.f124413e) {
            return true;
        }
        if (this.f124411c == null) {
            return false;
        }
        while (!this.f124411c.hasNext()) {
            this.f124412d = null;
            this.f124411c = null;
            if (!this.f124409a.hasNext()) {
                return false;
            }
            Iterable a16 = this.f124410b.a(this.f124409a.next());
            if (a16 != null) {
                it = a16.iterator();
            } else {
                it = Collections.emptyList().iterator();
            }
            this.f124411c = it;
        }
        this.f124412d = this.f124411c.next();
        this.f124413e = true;
        return true;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.f124413e && !hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.f124412d;
        this.f124412d = null;
        this.f124413e = false;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
