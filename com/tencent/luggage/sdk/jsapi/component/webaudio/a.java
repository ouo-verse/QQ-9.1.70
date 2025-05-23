package com.tencent.luggage.sdk.jsapi.component.webaudio;

import com.tencent.luggage.wxa.ca.d;
import com.tencent.luggage.wxa.ca.i;
import com.tencent.luggage.wxa.zd.r;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum a implements d {
    INSTANCE;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b implements Iterable {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.sdk.jsapi.component.webaudio.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C5971a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            public int f120258a;

            public C5971a() {
                this.f120258a = 0;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i next() {
                int i3 = this.f120258a;
                this.f120258a = i3 + 1;
                if (i3 == 0) {
                    return r.INSTANCE;
                }
                throw new IndexOutOfBoundsException("No more elements, total count: 1");
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f120258a < 1) {
                    return true;
                }
                return false;
            }
        }

        public b() {
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C5971a();
        }
    }

    @Override // com.tencent.luggage.wxa.ca.d
    public Iterable a() {
        return new b();
    }
}
