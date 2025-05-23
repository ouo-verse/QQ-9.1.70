package com.tencent.cache.core.manager.store;

import android.os.Build;
import com.tencent.cache.core.manager.api.CacheConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Pair<Integer, Integer> f98784a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final com.tencent.cache.core.bitmap.cache.c<String, Object> f98785b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final com.tencent.cache.core.bitmap.pool.e f98786c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final i f98787d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14036);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        i iVar = new i();
        f98787d = iVar;
        Pair<Integer, Integer> b16 = iVar.b(com.tencent.cache.core.manager.api.c.f98725d.d(), "init");
        f98784a = b16;
        f98786c = new com.tencent.cache.core.bitmap.pool.e(b16.getSecond().intValue(), com.tencent.cache.core.bitmap.pool.b.f98684e.a());
        int intValue = f98784a.getFirst().intValue();
        f98785b = new h(intValue, intValue);
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<com.tencent.cache.core.manager.report.b> a() {
        List<com.tencent.cache.core.manager.report.b> emptyList;
        int i3;
        boolean z16;
        int i16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        com.tencent.cache.core.bitmap.cache.c<String, Object> cVar = f98785b;
        com.tencent.cache.core.bitmap.base.lrucache.b<String, com.tencent.cache.core.bitmap.cache.b<String, Object>> bVar = cVar.f98671c[cVar.f98669a - 1];
        int h16 = bVar.h() + bVar.f();
        ArrayList arrayList = new ArrayList();
        try {
            com.tencent.cache.core.bitmap.base.lrucache.b<String, com.tencent.cache.core.bitmap.cache.b<String, Object>>[] bVarArr = cVar.f98671c;
            int length = bVarArr.length;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i36 = 0;
            while (i29 < length) {
                com.tencent.cache.core.bitmap.base.lrucache.b<String, com.tencent.cache.core.bitmap.cache.b<String, Object>> bVar2 = bVarArr[i29];
                int f16 = i27 + bVar2.f();
                int i37 = i17;
                int i38 = i18;
                com.tencent.cache.core.bitmap.base.lrucache.b<String, com.tencent.cache.core.bitmap.cache.b<String, Object>>[] bVarArr2 = bVarArr;
                int i39 = length;
                int i46 = i19;
                int i47 = i26;
                com.tencent.cache.core.bitmap.cache.c<String, Object> cVar2 = cVar;
                int i48 = i28;
                arrayList.add(new com.tencent.cache.core.manager.report.b(bVar2.a(), bVar2.n(), bVar2.f(), h16));
                Map<String, com.tencent.cache.core.bitmap.cache.b<String, Object>> p16 = bVar2.p();
                Set<Map.Entry<String, com.tencent.cache.core.bitmap.cache.b<String, Object>>> entrySet = p16.entrySet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : entrySet) {
                    if (((com.tencent.cache.core.bitmap.cache.b) ((Map.Entry) obj).getValue()).f98667i) {
                        arrayList2.add(obj);
                    }
                }
                i36 += arrayList2.size();
                if (arrayList2.isEmpty()) {
                    i3 = 0;
                } else {
                    Iterator it = arrayList2.iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        if (((com.tencent.cache.core.bitmap.cache.b) ((Map.Entry) it.next()).getValue()).f98660b > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16 && (i3 = i3 + 1) < 0) {
                            CollectionsKt__CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                i28 = i48 + i3;
                Iterator it5 = arrayList2.iterator();
                int i49 = 0;
                while (it5.hasNext()) {
                    i49 += ((com.tencent.cache.core.bitmap.cache.b) ((Map.Entry) it5.next()).getValue()).f98660b;
                }
                i19 = i46 + i49;
                Set<Map.Entry<String, com.tencent.cache.core.bitmap.cache.b<String, Object>>> entrySet2 = p16.entrySet();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : entrySet2) {
                    if (!((com.tencent.cache.core.bitmap.cache.b) ((Map.Entry) obj2).getValue()).f98667i) {
                        arrayList3.add(obj2);
                    }
                }
                i26 = i47 + arrayList3.size();
                if (arrayList3.isEmpty()) {
                    i16 = 0;
                } else {
                    Iterator it6 = arrayList3.iterator();
                    i16 = 0;
                    while (it6.hasNext()) {
                        if (((com.tencent.cache.core.bitmap.cache.b) ((Map.Entry) it6.next()).getValue()).f98660b > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17 && (i16 = i16 + 1) < 0) {
                            CollectionsKt__CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                i18 = i16 + i38;
                Iterator it7 = arrayList3.iterator();
                int i56 = 0;
                while (it7.hasNext()) {
                    i56 += ((com.tencent.cache.core.bitmap.cache.b) ((Map.Entry) it7.next()).getValue()).f98660b;
                }
                i17 = i37 + i56;
                i29++;
                i27 = f16;
                bVarArr = bVarArr2;
                cVar = cVar2;
                length = i39;
            }
            com.tencent.cache.core.bitmap.cache.c<String, Object> cVar3 = cVar;
            int i57 = i17;
            int i58 = i18;
            int i59 = i19;
            int i65 = i26;
            int i66 = i28;
            int i67 = cVar3.f98669a;
            int i68 = 0;
            for (int i69 = 0; i69 < i67; i69++) {
                i68 += cVar3.f98671c[i69].a();
            }
            com.tencent.cache.core.manager.report.b bVar3 = new com.tencent.cache.core.manager.report.b(i68, cVar3.k(), i27, h16);
            bVar3.f98755a = new com.tencent.cache.core.manager.report.a(i36, i66, i59);
            bVar3.f98756b = new com.tencent.cache.core.manager.report.a(i65, i58, i57);
            Unit unit = Unit.INSTANCE;
            arrayList.add(bVar3);
            return arrayList;
        } catch (Exception e16) {
            com.tencent.cache.core.util.b bVar4 = com.tencent.cache.core.util.b.f98833f;
            StringBuilder a16 = com.tencent.cache.api.collection.c.a("getMonitorInfo fail, ");
            a16.append(e16.getMessage());
            bVar4.h("SteppedLruCache", 1, a16.toString());
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    public final Pair<Integer, Integer> b(CacheConfig cacheConfig, String str) {
        long coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(Runtime.getRuntime().maxMemory(), VasBusiness.QWALLET);
            if (cacheConfig.u() == 0.0f) {
                cacheConfig.O(0.1875f);
            }
            float f16 = (float) coerceAtMost;
            float u16 = cacheConfig.u() * f16;
            float v3 = cacheConfig.v() * f16;
            if (Build.VERSION.SDK_INT < 26) {
                u16 *= cacheConfig.t();
                v3 *= cacheConfig.t();
            }
            com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initDefaultMaxSize ");
            sb5.append(str);
            sb5.append(", ");
            sb5.append("imageCacheMaxSize: ");
            float f17 = (float) 1048576;
            sb5.append(u16 / f17);
            sb5.append(", ");
            sb5.append("bitmapPoolMaxSize:");
            sb5.append(v3 / f17);
            bVar.j("GlobalImageCache", 1, sb5.toString());
            return new Pair<>(Integer.valueOf((int) u16), Integer.valueOf((int) v3));
        }
        return (Pair) iPatchRedirector.redirect((short) 7, (Object) this, (Object) cacheConfig, (Object) str);
    }

    @NotNull
    public final com.tencent.cache.core.bitmap.pool.e c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.cache.core.bitmap.pool.e) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f98786c;
    }

    @NotNull
    public final com.tencent.cache.core.bitmap.cache.c<String, Object> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.cache.core.bitmap.cache.c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return f98785b;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return f98785b.k() + f98786c.f98690b;
    }
}
