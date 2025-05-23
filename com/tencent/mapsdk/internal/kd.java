package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.utils.cache.DiskCache;
import com.tencent.mapsdk.core.utils.cache.MemoryCache;
import com.tencent.mapsdk.internal.jz;
import com.tencent.mapsdk.internal.kf;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kd {

    /* renamed from: a, reason: collision with root package name */
    private static kb f148959a = new kb();

    public static String a(String str) {
        return f148959a.f148953a.a(str);
    }

    private static <D extends ka> kg<D> b(int i3, Class<D> cls, jz.a... aVarArr) {
        return a(a(i3, cls, aVarArr));
    }

    private static <D extends ka> jx<D> c(int i3, Class<D> cls, jz.a... aVarArr) {
        jz a16 = a(i3, cls, aVarArr);
        if (a16 instanceof jx) {
            return (jx) a16;
        }
        return null;
    }

    private static <D extends ka> jx<D> b(jz<D> jzVar) {
        if (jzVar instanceof jx) {
            return (jx) jzVar;
        }
        return null;
    }

    public static <D extends ka> jz<D> a(int i3, Class<D> cls, jz.a... aVarArr) {
        jz<D> jzVar = null;
        if (cls != null && aVarArr != null && aVarArr.length != 0) {
            kc kcVar = new kc(i3);
            boolean z16 = aVarArr.length > 1;
            for (jz.a aVar : aVarArr) {
                if (aVar instanceof MemoryCache.a) {
                    jzVar = f148959a.a(cls, (MemoryCache.a) aVar, MemoryCache.class);
                } else if (aVar instanceof kf.c) {
                    kf.c cVar = (kf.c) aVar;
                    kf.a aVar2 = cVar.f148968j;
                    if (aVar2 == kf.a.DISK) {
                        jzVar = f148959a.a(cls, cVar, DiskCache.class);
                    } else if (aVar2 == kf.a.DB) {
                        jzVar = f148959a.a(cls, cVar, ke.class);
                    }
                }
                if (z16 && jzVar != null) {
                    kcVar.f148956a.addAll(Arrays.asList(jzVar));
                }
            }
            if (z16) {
                return kcVar;
            }
        }
        return jzVar;
    }

    public static <D extends ka> kg<D> a(jz<D> jzVar) {
        if (jzVar instanceof kg) {
            return (kg) jzVar;
        }
        return null;
    }
}
