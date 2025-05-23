package com.tencent.luggage.wxa.y5;

import com.tencent.luggage.wxa.ca.d;
import com.tencent.luggage.wxa.ca.i;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum a implements d {
    INSTANCE;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements Iterable {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.y5.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6938a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            public int f145427a;

            public C6938a() {
                this.f145427a = 0;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i next() {
                int i3 = this.f145427a;
                this.f145427a = i3 + 1;
                if (i3 == 0) {
                    return c.INSTANCE;
                }
                throw new IndexOutOfBoundsException("No more elements, total count: 1");
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f145427a < 1) {
                    return true;
                }
                return false;
            }
        }

        public b() {
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C6938a();
        }
    }

    @Override // com.tencent.luggage.wxa.ca.d
    public Iterable a() {
        return new b();
    }
}
