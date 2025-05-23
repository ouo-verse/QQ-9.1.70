package com.tencent.luggage.wxa.p6;

import com.tencent.luggage.wxa.ca.i;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum a implements com.tencent.luggage.wxa.ca.d {
    INSTANCE;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements Iterable {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p6.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6586a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            public int f137353a;

            public C6586a() {
                this.f137353a = 0;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i next() {
                int i3 = this.f137353a;
                this.f137353a = i3 + 1;
                if (i3 == 0) {
                    return com.tencent.luggage.wxa.t6.g.INSTANCE;
                }
                throw new IndexOutOfBoundsException("No more elements, total count: 1");
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f137353a < 1) {
                    return true;
                }
                return false;
            }
        }

        public b() {
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C6586a();
        }
    }

    @Override // com.tencent.luggage.wxa.ca.d
    public Iterable a() {
        return new b();
    }
}
