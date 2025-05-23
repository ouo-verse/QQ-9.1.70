package com.tencent.libra.cache;

import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.libra.cache.c;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.business.Monitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class b {
    @JvmDefault
    @NotNull
    public static Business a(c cVar, @Nullable Option option) {
        boolean z16;
        boolean z17;
        Object first;
        Business e16 = com.tencent.cache.core.manager.api.c.f98725d.e();
        Set a16 = c.a.a(cVar, option);
        boolean z18 = true;
        if (a16 != null && !a16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (!(a16 instanceof Collection) || !a16.isEmpty()) {
                Iterator it = a16.iterator();
                while (it.hasNext()) {
                    if (((com.tencent.cache.api.d) it.next()).b() == e16) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                }
            }
            z18 = false;
            if (!z18) {
                first = CollectionsKt___CollectionsKt.first(a16);
                return ((com.tencent.cache.api.d) first).b();
            }
        }
        return e16;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00b0  */
    @JvmDefault
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PageHierarchy b(c cVar, @Nullable Option option) {
        boolean z16;
        PageHierarchy pageHierarchy;
        String str;
        boolean z17;
        boolean z18;
        PageHierarchy pageHierarchy2 = null;
        if (option == null || option.getTargetView() == null || !com.tencent.cache.core.manager.api.c.f98725d.d().H()) {
            return null;
        }
        Business business = cVar.getBusiness(option);
        Set a16 = c.a.a(cVar, option);
        boolean z19 = false;
        if (a16 != null && !a16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : a16) {
                if (((com.tencent.cache.api.d) obj).b() == business) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((com.tencent.cache.api.d) it.next()).c() == PageHierarchy.MainPage) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            z19 = true;
                            break;
                        }
                    }
                }
                if (z19) {
                    pageHierarchy = PageHierarchy.MainPage;
                } else {
                    pageHierarchy = PageHierarchy.NonMainPage;
                }
                if (pageHierarchy != null && business == com.tencent.cache.core.manager.api.c.f98725d.e()) {
                    com.tencent.cache.api.d currentPageArgus = Monitor.INSTANCE.getCurrentPageArgus();
                    if (currentPageArgus != null) {
                        pageHierarchy2 = currentPageArgus.c();
                    }
                    PageHierarchy pageHierarchy3 = pageHierarchy2;
                    str = "currentPage";
                    pageHierarchy = pageHierarchy3;
                } else {
                    str = "fragmentCache";
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("BusinessTagProvider", 1, "getSubBusiness, seq = " + option.getSeq() + ", business:" + business + ", pageHierarchy:" + pageHierarchy + ", from:" + str);
                }
                return pageHierarchy;
            }
        }
        pageHierarchy = null;
        if (pageHierarchy != null) {
        }
        str = "fragmentCache";
        if (QLog.isDevelopLevel()) {
        }
        return pageHierarchy;
    }
}
