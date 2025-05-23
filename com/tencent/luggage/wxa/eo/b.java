package com.tencent.luggage.wxa.eo;

import com.tencent.luggage.wxa.bk.m;
import com.tencent.luggage.wxa.ca.i;
import com.tencent.luggage.wxa.fd.k;
import com.tencent.luggage.wxa.lj.v;
import com.tencent.luggage.wxa.mc.u;
import com.tencent.luggage.wxa.n3.s0;
import com.tencent.luggage.wxa.p004if.a0;
import com.tencent.luggage.wxa.p7.j;
import com.tencent.luggage.wxa.tn.j0;
import com.tencent.luggage.wxa.zd.r;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum b implements com.tencent.luggage.wxa.ca.d {
    INSTANCE;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.eo.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6179b implements Iterable {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.eo.b$b$a */
        /* loaded from: classes8.dex */
        public class a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            public int f124977a;

            public a() {
                this.f124977a = 0;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i next() {
                int i3 = this.f124977a;
                this.f124977a = i3 + 1;
                switch (i3) {
                    case 0:
                        return com.tencent.luggage.wxa.lc.g.INSTANCE;
                    case 1:
                        return com.tencent.luggage.wxa.p6.g.INSTANCE;
                    case 2:
                        return k.INSTANCE;
                    case 3:
                        return com.tencent.luggage.wxa.mk.c.INSTANCE;
                    case 4:
                        return com.tencent.luggage.wxa.jc.b.INSTANCE;
                    case 5:
                        return s0.INSTANCE;
                    case 6:
                        return com.tencent.luggage.wxa.l4.f.INSTANCE;
                    case 7:
                        return com.tencent.luggage.wxa.t5.c.INSTANCE;
                    case 8:
                        return j.INSTANCE;
                    case 9:
                        return com.tencent.luggage.wxa.y5.c.INSTANCE;
                    case 10:
                        return com.tencent.luggage.wxa.r9.b.INSTANCE;
                    case 11:
                        return com.tencent.luggage.wxa.o3.b.INSTANCE;
                    case 12:
                        return a0.INSTANCE;
                    case 13:
                        return com.tencent.luggage.wxa.lc.e.INSTANCE;
                    case 14:
                        return com.tencent.luggage.wxa.t6.g.INSTANCE;
                    case 15:
                        return j0.INSTANCE;
                    case 16:
                        return v.INSTANCE;
                    case 17:
                        return r.INSTANCE;
                    case 18:
                        return com.tencent.luggage.wxa.j6.c.INSTANCE;
                    case 19:
                        return com.tencent.luggage.wxa.jm.c.INSTANCE;
                    case 20:
                        return com.tencent.luggage.wxa.td.e.INSTANCE;
                    case 21:
                        return com.tencent.luggage.wxa.x7.c.INSTANCE;
                    case 22:
                        return com.tencent.luggage.wxa.i7.c.INSTANCE;
                    case 23:
                        return u.INSTANCE;
                    case 24:
                        return m.INSTANCE;
                    case 25:
                        return com.tencent.luggage.wxa.t6.d.INSTANCE;
                    default:
                        throw new IndexOutOfBoundsException("No more elements, total count: 26");
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f124977a < 26) {
                    return true;
                }
                return false;
            }
        }

        public C6179b() {
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a();
        }
    }

    @Override // com.tencent.luggage.wxa.ca.d
    public Iterable a() {
        return new C6179b();
    }
}
