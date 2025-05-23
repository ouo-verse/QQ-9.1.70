package com.tencent.luggage.wxa.tn;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum k implements com.tencent.luggage.wxa.ca.d {
    INSTANCE;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements Iterable {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            public int f141630a;

            public a() {
                this.f141630a = 0;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.tencent.luggage.wxa.ca.i next() {
                int i3 = this.f141630a;
                this.f141630a = i3 + 1;
                if (i3 == 0) {
                    return j0.INSTANCE;
                }
                throw new IndexOutOfBoundsException("No more elements, total count: 1");
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f141630a < 1) {
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
