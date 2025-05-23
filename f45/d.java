package f45;

import c45.b;
import e45.h;
import e45.j;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d implements h {

    /* renamed from: a, reason: collision with root package name */
    public final f f397849a;

    public d(f fVar) {
        this.f397849a = fVar;
    }

    @Override // e45.h
    public final void j(int i3, List<?> list, c45.b bVar) {
        int i16;
        byte[] encodeToByteArray;
        Integer num;
        c45.c cVar = list instanceof c45.c ? (c45.c) list : null;
        if (cVar != null && (num = cVar.f30315e) != null) {
            i16 = num.intValue();
        } else {
            int i17 = 0;
            for (Object obj : list) {
                if (obj != null) {
                    i17 += e45.b.a(bVar, obj);
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            i16 = i17;
        }
        l(i3, i16);
        for (Object obj2 : list) {
            if (obj2 != null) {
                if (bVar instanceof b.e.c) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Double");
                    o(Double.doubleToRawLongBits(((Double) obj2).doubleValue()));
                } else if (bVar instanceof b.e.d) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    n(Float.floatToRawIntBits(((Float) obj2).floatValue()));
                } else if (bVar instanceof b.e.f) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
                    r(((Long) obj2).longValue());
                } else if (bVar instanceof b.e.i) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
                    r(((Long) obj2).longValue());
                } else if (bVar instanceof b.e.C0168e) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    p(((Integer) obj2).intValue());
                } else if (bVar instanceof b.e.a) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    this.f397849a.a(new byte[]{((Boolean) obj2).booleanValue()}, 1);
                } else if (bVar instanceof b.e.g) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray((String) obj2);
                    q(encodeToByteArray.length);
                    this.f397849a.a(encodeToByteArray, encodeToByteArray.length);
                } else if (bVar instanceof b.e.C0167b) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type pbandk.ByteArr");
                    m((c45.a) obj2);
                } else if (bVar instanceof b.e.h) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    q(((Integer) obj2).intValue());
                } else if (!(bVar instanceof b.c)) {
                    if (!(bVar instanceof b.d)) {
                        if (bVar instanceof b.a) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                            p(((Integer) obj2).intValue());
                        } else if (!(bVar instanceof b.f)) {
                            if (bVar instanceof b.C0166b) {
                                throw new IllegalStateException("writeValueNoTag() should only be called for primitive types".toString());
                            }
                        } else {
                            throw new IllegalStateException("writeValueNoTag() should only be called for primitive types".toString());
                        }
                    } else {
                        throw new IllegalStateException("writeValueNoTag() should only be called for primitive types".toString());
                    }
                } else {
                    throw new IllegalStateException("writeValueNoTag() should only be called for primitive types".toString());
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
    }

    public final void m(c45.a aVar) {
        q(aVar.f30291a.length);
        f fVar = this.f397849a;
        byte[] bArr = aVar.f30291a;
        fVar.a(bArr, bArr.length);
    }

    public final void n(int i3) {
        f fVar = this.f397849a;
        byte[] bArr = new byte[4];
        for (int i16 = 0; i16 < 4; i16++) {
            bArr[i16] = (byte) (i3 >> (i16 * 8));
        }
        fVar.a(bArr, 4);
    }

    public final void o(long j3) {
        f fVar = this.f397849a;
        byte[] bArr = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3] = (byte) (j3 >> (i3 * 8));
        }
        fVar.a(bArr, 8);
    }

    @Override // e45.h
    public final void a(int i3, String str) {
        byte[] encodeToByteArray;
        q(j.a(i3, 2));
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(str);
        q(encodeToByteArray.length);
        this.f397849a.a(encodeToByteArray, encodeToByteArray.length);
    }

    @Override // e45.h
    public final void b(int i3, boolean z16) {
        q(j.a(i3, 0));
        this.f397849a.a(new byte[]{z16 ? (byte) 1 : (byte) 0}, 1);
    }

    @Override // e45.h
    public final void c(int i3, long j3) {
        q(j.a(i3, 0));
        r(j3);
    }

    @Override // e45.h
    public final void d(int i3, float f16) {
        q(j.a(i3, 5));
        n(Float.floatToRawIntBits(f16));
    }

    @Override // e45.h
    public final void e(int i3, int i16) {
        q(j.a(i3, 0));
        p(i16);
    }

    @Override // e45.h
    public final void f(int i3, int i16) {
        q(j.a(i3, 0));
        q(i16);
    }

    @Override // e45.h
    public final void g(int i3, double d16) {
        q(j.a(i3, 1));
        o(Double.doubleToRawLongBits(d16));
    }

    @Override // e45.h
    public final void h(int i3, int i16) {
        q(j.a(i3, 0));
        p(i16);
    }

    @Override // e45.h
    public final void i(int i3, long j3) {
        q(j.a(i3, 0));
        r(j3);
    }

    @Override // e45.h
    public final void k(int i3, c45.a aVar) {
        q(j.a(i3, 2));
        m(aVar);
    }

    @Override // e45.h
    public final void l(int i3, int i16) {
        q(j.a(i3, 2));
        q(i16);
    }

    public final void p(int i3) {
        if (i3 >= 0) {
            q(i3);
        } else {
            r(i3);
        }
    }

    public final void q(int i3) {
        byte[] bArr = new byte[10];
        int i16 = 0;
        while (true) {
            if (i16 >= 10) {
                break;
            }
            if ((i3 & (-128)) == 0) {
                bArr[i16] = (byte) i3;
                i16++;
                break;
            } else {
                bArr[i16] = (byte) ((i3 & 127) | 128);
                i3 >>>= 7;
                i16++;
            }
        }
        this.f397849a.a(bArr, i16);
    }

    public final void r(long j3) {
        byte[] bArr = new byte[10];
        int i3 = 0;
        while (true) {
            if (i3 >= 10) {
                break;
            }
            if (((-128) & j3) == 0) {
                bArr[i3] = (byte) j3;
                i3++;
                break;
            } else {
                bArr[i3] = (byte) ((127 & j3) | 128);
                j3 >>>= 7;
                i3++;
            }
        }
        this.f397849a.a(bArr, i3);
    }
}
