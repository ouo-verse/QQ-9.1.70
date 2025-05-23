package com.tencent.luggage.wxa.km;

import com.tencent.luggage.wxa.ca.d;
import com.tencent.luggage.wxa.ca.i;
import com.tencent.luggage.wxa.jm.c;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum a implements d {
    INSTANCE;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements Iterable {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.km.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6401a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            public int f132669a;

            public C6401a() {
                this.f132669a = 0;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i next() {
                int i3 = this.f132669a;
                this.f132669a = i3 + 1;
                if (i3 == 0) {
                    return c.INSTANCE;
                }
                throw new IndexOutOfBoundsException("No more elements, total count: 1");
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f132669a < 1) {
                    return true;
                }
                return false;
            }
        }

        public b() {
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C6401a();
        }
    }

    @Override // com.tencent.luggage.wxa.ca.d
    public Iterable a() {
        return new b();
    }
}
