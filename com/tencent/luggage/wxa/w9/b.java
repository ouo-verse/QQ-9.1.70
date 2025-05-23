package com.tencent.luggage.wxa.w9;

import com.tencent.luggage.wxa.bk.m;
import com.tencent.luggage.wxa.ca.d;
import com.tencent.luggage.wxa.ca.i;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum b implements d {
    INSTANCE;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.w9.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6870b implements Iterable {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.w9.b$b$a */
        /* loaded from: classes8.dex */
        public class a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            public int f144131a;

            public a() {
                this.f144131a = 0;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i next() {
                int i3 = this.f144131a;
                this.f144131a = i3 + 1;
                if (i3 == 0) {
                    return m.INSTANCE;
                }
                throw new IndexOutOfBoundsException("No more elements, total count: 1");
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f144131a < 1) {
                    return true;
                }
                return false;
            }
        }

        public C6870b() {
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a();
        }
    }

    @Override // com.tencent.luggage.wxa.ca.d
    public Iterable a() {
        return new C6870b();
    }
}
