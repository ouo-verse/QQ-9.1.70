package com.tencent.luggage.wxa.x7;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum d implements com.tencent.luggage.wxa.ca.d {
    INSTANCE;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements Iterable {

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            public int f144617a;

            public a() {
                this.f144617a = 0;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.tencent.luggage.wxa.ca.i next() {
                int i3 = this.f144617a;
                this.f144617a = i3 + 1;
                if (i3 == 0) {
                    return c.INSTANCE;
                }
                throw new IndexOutOfBoundsException("No more elements, total count: 1");
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f144617a < 1) {
                    return true;
                }
                return false;
            }
        }

        public b() {
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a();
        }
    }

    @Override // com.tencent.luggage.wxa.ca.d
    public Iterable a() {
        return new b();
    }
}
