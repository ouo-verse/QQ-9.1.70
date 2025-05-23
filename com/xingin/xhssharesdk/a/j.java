package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.c0;
import com.xingin.xhssharesdk.a.e;
import com.xingin.xhssharesdk.a.k;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class j<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final a<K, V> f389927a;

    /* renamed from: b, reason: collision with root package name */
    public final K f389928b = "";

    /* renamed from: c, reason: collision with root package name */
    public final V f389929c = "";

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final c0.a f389930a;

        /* renamed from: c, reason: collision with root package name */
        public final c0.a f389932c;

        /* renamed from: b, reason: collision with root package name */
        public final K f389931b = "";

        /* renamed from: d, reason: collision with root package name */
        public final V f389933d = "";

        public a(c0.a.C10093a c10093a, c0.a.C10093a c10093a2) {
            this.f389930a = c10093a;
            this.f389932c = c10093a2;
        }
    }

    public j(c0.a.C10093a c10093a, c0.a.C10093a c10093a2) {
        this.f389927a = new a<>(c10093a, c10093a2);
    }

    public static <T> T a(c cVar, nz4.e eVar, c0.a aVar, T t16) {
        int ordinal = aVar.ordinal();
        if (ordinal != 9) {
            boolean z16 = true;
            if (ordinal != 10) {
                if (ordinal != 13) {
                    int i3 = d.f389903d;
                    c0.c.b bVar = c0.c.f389901a;
                    switch (aVar.ordinal()) {
                        case 0:
                            return (T) Double.valueOf(Double.longBitsToDouble(cVar.d()));
                        case 1:
                            return (T) Float.valueOf(Float.intBitsToFloat(cVar.a()));
                        case 2:
                            return (T) Long.valueOf(cVar.g());
                        case 3:
                            return (T) Long.valueOf(cVar.g());
                        case 4:
                            return (T) Integer.valueOf(cVar.e());
                        case 5:
                            return (T) Long.valueOf(cVar.d());
                        case 6:
                            return (T) Integer.valueOf(cVar.a());
                        case 7:
                            if (cVar.g() == 0) {
                                z16 = false;
                            }
                            return (T) Boolean.valueOf(z16);
                        case 8:
                            return (T) bVar.a(cVar);
                        case 9:
                            throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
                        case 10:
                            throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
                        case 11:
                            int e16 = cVar.e();
                            int i16 = cVar.f389878b;
                            int i17 = cVar.f389880d;
                            if (e16 <= i16 - i17 && e16 > 0) {
                                byte[] bArr = cVar.f389877a;
                                e.d dVar = e.f389907b;
                                T t17 = (T) new e.d(e.f389908c.a(bArr, i17, e16));
                                cVar.f389880d += e16;
                                return t17;
                            }
                            if (e16 == 0) {
                                return (T) e.f389907b;
                            }
                            byte[] f16 = cVar.f(e16);
                            e.d dVar2 = e.f389907b;
                            return (T) new e.d(f16);
                        case 12:
                            return (T) Integer.valueOf(cVar.e());
                        case 13:
                            throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
                        case 14:
                            return (T) Integer.valueOf(cVar.a());
                        case 15:
                            return (T) Long.valueOf(cVar.d());
                        case 16:
                            int e17 = cVar.e();
                            return (T) Integer.valueOf((-(e17 & 1)) ^ (e17 >>> 1));
                        case 17:
                            long g16 = cVar.g();
                            return (T) Long.valueOf((-(g16 & 1)) ^ (g16 >>> 1));
                        default:
                            throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                    }
                }
                return (T) Integer.valueOf(cVar.e());
            }
            k.a d16 = ((l) t16).d();
            int e18 = cVar.e();
            if (cVar.f389884h < 100) {
                int c16 = cVar.c(e18);
                cVar.f389884h++;
                d16.f();
                try {
                    d16.f389937e.c(k.h.f389947c, cVar, eVar);
                    if (cVar.f389881e == 0) {
                        cVar.f389884h--;
                        cVar.f389883g = c16;
                        cVar.m();
                        if (!d16.f389938f) {
                            d16.f389937e.g();
                            d16.f389938f = true;
                        }
                        return (T) d16.f389937e;
                    }
                    throw new m("Protocol message end-group tag did not match expected tag.");
                } catch (RuntimeException e19) {
                    if (e19.getCause() instanceof IOException) {
                        throw ((IOException) e19.getCause());
                    }
                    throw e19;
                }
            }
            throw new m("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        throw new RuntimeException("Groups are not allowed in maps.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(q<K, V> qVar, c cVar, nz4.e eVar) {
        int c16 = cVar.c(cVar.e());
        a<K, V> aVar = this.f389927a;
        Object obj = aVar.f389931b;
        Object obj2 = aVar.f389933d;
        while (true) {
            int k3 = cVar.k();
            if (k3 == 0) {
                break;
            }
            if (k3 == c0.a(1, this.f389927a.f389930a.f389889b)) {
                obj = a(cVar, eVar, this.f389927a.f389930a, obj);
            } else if (k3 == c0.a(2, this.f389927a.f389932c.f389889b)) {
                obj2 = a(cVar, eVar, this.f389927a.f389932c, obj2);
            } else if (!cVar.h(k3)) {
                break;
            }
        }
        if (cVar.f389881e == 0) {
            cVar.f389883g = c16;
            cVar.m();
            qVar.put(obj, obj2);
            return;
        }
        throw new m("Protocol message end-group tag did not match expected tag.");
    }
}
