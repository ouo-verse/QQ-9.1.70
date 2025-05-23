package com.tencent.luggage.wxa.dp;

import com.tencent.luggage.wxa.dp.f;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f124426a;

    /* renamed from: b, reason: collision with root package name */
    public final f.a f124427b;

    /* renamed from: c, reason: collision with root package name */
    public f.b f124428c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f124429d;

    /* renamed from: e, reason: collision with root package name */
    public Object f124430e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f124431f;

    public g(Iterator it, f.a aVar, f.b bVar, boolean z16) {
        this.f124426a = it;
        this.f124427b = aVar;
        this.f124428c = bVar;
        this.f124429d = z16;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f124431f) {
            return true;
        }
        while (this.f124426a.hasNext()) {
            Object a16 = this.f124427b.a(this.f124426a.next());
            this.f124430e = a16;
            if (a16 != null || this.f124429d) {
                this.f124431f = true;
                return true;
            }
        }
        f.b bVar = this.f124428c;
        if (bVar != null) {
            bVar.b();
            this.f124428c = null;
            return false;
        }
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.f124431f && !hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.f124430e;
        this.f124430e = null;
        this.f124431f = false;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
