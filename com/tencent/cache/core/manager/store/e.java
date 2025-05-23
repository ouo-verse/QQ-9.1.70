package com.tencent.cache.core.manager.store;

import com.tencent.cache.api.Business;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.ranges.RangesKt___RangesKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Map<String, d> f98778a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static Map<Business, Set<String>> f98779b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static Map<Business, Set<String>> f98780c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final e f98781d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13976);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f98781d = new e();
        f98778a = new ConcurrentHashMap();
        f98779b = new ConcurrentHashMap();
        f98780c = new ConcurrentHashMap();
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final long a() {
        long coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(Runtime.getRuntime().maxMemory(), VasBusiness.QWALLET);
            return com.tencent.cache.core.manager.api.c.f98725d.d().m() * ((float) coerceAtMost);
        }
        return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
    }

    @NotNull
    public final Map<String, com.tencent.cache.core.manager.report.b> b() {
        Object elementAtOrNull;
        List mutableList;
        List shuffled;
        List<a> take;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Random random = new Random();
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) f98778a;
        elementAtOrNull = CollectionsKt___CollectionsKt.elementAtOrNull(concurrentHashMap.entrySet(), random.nextInt(concurrentHashMap.size()));
        Map.Entry entry = (Map.Entry) elementAtOrNull;
        if (entry != null) {
            d dVar = (d) entry.getValue();
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) dVar.f98776a);
            mutableList.addAll(dVar.f98777b);
            shuffled = CollectionsKt__CollectionsJVMKt.shuffled(mutableList);
            take = CollectionsKt___CollectionsKt.take(shuffled, 3);
            for (a aVar : take) {
                String str = ((String) entry.getKey()) + util.base64_pad_url + aVar.f98773b;
                com.tencent.cache.api.b bVar = aVar.f98772a.get();
                if (bVar instanceof com.tencent.cache.core.collection.base.b) {
                    linkedHashMap.put(str, ((com.tencent.cache.core.collection.base.b) bVar).getMonitorInfo());
                }
            }
        }
        return linkedHashMap;
    }

    public final long c() {
        List mutableList;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        Iterator it = ((ConcurrentHashMap) f98778a).entrySet().iterator();
        long j16 = 0;
        while (it.hasNext()) {
            d dVar = (d) ((Map.Entry) it.next()).getValue();
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) dVar.f98776a);
            mutableList.addAll(dVar.f98777b);
            Iterator it5 = mutableList.iterator();
            long j17 = 0;
            while (it5.hasNext()) {
                com.tencent.cache.api.b bVar = ((a) it5.next()).f98772a.get();
                if (bVar != null) {
                    j3 = bVar.getMemorySize();
                } else {
                    j3 = 0;
                }
                j17 += j3;
            }
            j16 += j17;
        }
        return j16;
    }
}
