package com.tencent.cache.core.manager.control;

import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class j implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f98743d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Business f98744e;

    public j(List list, Business business) {
        this.f98743d = list;
        this.f98744e = business;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list, (Object) business);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.cache.core.manager.report.c cVar = new com.tencent.cache.core.manager.report.c(ClearMode.PageChanged);
        if (com.tencent.cache.core.manager.api.c.f98725d.d().k()) {
            Iterator it = this.f98743d.iterator();
            while (it.hasNext()) {
                h.f98741a.b((Business) it.next());
            }
        }
        if (com.tencent.cache.core.manager.api.c.f98725d.d().l()) {
            for (Business business : this.f98743d) {
                com.tencent.cache.core.manager.store.i iVar = com.tencent.cache.core.manager.store.i.f98787d;
                Intrinsics.checkNotNullParameter(business, "targetBusiness");
                com.tencent.cache.core.util.b.f98833f.j("GlobalImageCache", 1, "trimByBusiness start");
                long e16 = iVar.e();
                com.tencent.cache.core.bitmap.cache.c<String, Object> cVar2 = com.tencent.cache.core.manager.store.i.f98785b;
                String name = PageHierarchy.NonMainPage.name();
                cVar2.getClass();
                Intrinsics.checkNotNullParameter(business, "business");
                int i3 = cVar2.f98669a;
                for (int i16 = 0; i16 < i3; i16++) {
                    Map<String, com.tencent.cache.core.bitmap.cache.b<String, Object>> map = cVar2.f98671c[i16].p();
                    Intrinsics.checkNotNullExpressionValue(map, "map");
                    for (Map.Entry<String, com.tencent.cache.core.bitmap.cache.b<String, Object>> entry : map.entrySet()) {
                        if (Intrinsics.areEqual(entry.getValue().f98665g, business.name()) && (name == null || Intrinsics.areEqual(name, entry.getValue().f98666h))) {
                            cVar2.f98671c[i16].j(entry.getKey());
                        }
                    }
                }
                long e17 = iVar.e();
                com.tencent.cache.core.util.b.f98833f.j("GlobalImageCache", 1, "trimByBusiness complete, sImageCache: {beforeSize=" + e16 + ", afterSize=" + e17 + ", removed=" + (e16 - e17) + '}');
            }
        }
        StringBuilder a16 = com.tencent.cache.api.collection.c.a("pageChange_");
        Business business2 = this.f98744e;
        if (business2 != null) {
            str = business2.name();
        } else {
            str = null;
        }
        a16.append(str);
        cVar.c(a16.toString(), null);
        com.tencent.cache.core.manager.api.b b16 = com.tencent.cache.core.manager.api.c.f98725d.b();
        if (b16 != null) {
            b16.a(ClearMode.PageChanged, 0.0f);
        }
    }
}
