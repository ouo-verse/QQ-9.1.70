package com.tencent.richframework.argus.business;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.cache.api.d;
import com.tencent.cache.core.manager.api.c;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.richframework.argus.QQArgusManager;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.FragmentNode;
import com.tencent.richframework.argus.page.PageInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fR(\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR(\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c0\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/richframework/argus/business/Monitor;", "", "Lcom/tencent/richframework/argus/page/PageInfo;", "pageInfo", "Lcom/tencent/cache/api/d;", "getPageArgus", "newPageInfo", "", "isValidPageCallback", "", "fragmentName", "", "getPageArgusByFragment", "", "pageChanged", "Ljava/lang/Class;", "targetClass", "getPageArgusByAnnotation", "<set-?>", "prevPageArgus", "Lcom/tencent/cache/api/d;", "getPrevPageArgus", "()Lcom/tencent/cache/api/d;", "currentPageArgus", "getCurrentPageArgus", "setCurrentPageArgus", "(Lcom/tencent/cache/api/d;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "fragmentToPageArgus", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class Monitor {

    @Nullable
    private static d currentPageArgus;

    @Nullable
    private static d prevPageArgus;

    @NotNull
    public static final Monitor INSTANCE = new Monitor();

    @NotNull
    private static ConcurrentHashMap<String, CopyOnWriteArraySet<d>> fragmentToPageArgus = new ConcurrentHashMap<>();

    Monitor() {
    }

    private final d getPageArgus(PageInfo pageInfo) {
        d dVar;
        Iterator<T> it = pageInfo.getAllVisibleNode().iterator();
        d dVar2 = null;
        while (it.hasNext() && (dVar2 = MonitorKt.getPageArgus((ArgusNode) it.next())) == null) {
        }
        if (dVar2 == null && isValidPageCallback(pageInfo) && (!pageInfo.getAllVisibleNode().isEmpty()) && (dVar = currentPageArgus) != null) {
            Intrinsics.checkNotNull(dVar);
            Business b16 = dVar.b();
            PageHierarchy pageHierarchy = PageHierarchy.NonMainPage;
            d dVar3 = currentPageArgus;
            Intrinsics.checkNotNull(dVar3);
            return new d(b16, pageHierarchy, dVar3.a());
        }
        return dVar2;
    }

    private final boolean isValidPageCallback(PageInfo newPageInfo) {
        boolean z16;
        QRouteApi api = QRoute.api(IPerfApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPerfApi::class.java)");
        IPerfApi iPerfApi = (IPerfApi) api;
        List<String> filterValidBlock = Unified.INSTANCE.filterValidBlock(newPageInfo.getAllVisibleNode());
        if ((filterValidBlock instanceof Collection) && filterValidBlock.isEmpty()) {
            return false;
        }
        for (String str : filterValidBlock) {
            if (!Intrinsics.areEqual(str, iPerfApi.getSimpleClassName("SplashActivity")) && !Intrinsics.areEqual(str, iPerfApi.getSimpleClassName("MainFragment"))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final d getCurrentPageArgus() {
        return currentPageArgus;
    }

    @Nullable
    public final d getPageArgusByAnnotation(@NotNull Class<?> targetClass) {
        Intrinsics.checkNotNullParameter(targetClass, "targetClass");
        if (Intrinsics.areEqual(targetClass.getClassLoader(), QQArgusManager.class.getClassLoader())) {
            Page page = (Page) targetClass.getAnnotation(Page.class);
            if (page != null) {
                return new d(page);
            }
            Class<? super Object> superclass = targetClass.getSuperclass();
            Intrinsics.checkNotNullExpressionValue(superclass, "targetClass.superclass");
            return getPageArgusByAnnotation(superclass);
        }
        return null;
    }

    @Nullable
    public final Set<d> getPageArgusByFragment(@NotNull String fragmentName) {
        Intrinsics.checkNotNullParameter(fragmentName, "fragmentName");
        return fragmentToPageArgus.get(fragmentName);
    }

    @Nullable
    public final d getPrevPageArgus() {
        return prevPageArgus;
    }

    public final void pageChanged(@NotNull PageInfo newPageInfo) {
        CopyOnWriteArraySet<d> putIfAbsent;
        String str;
        Intrinsics.checkNotNullParameter(newPageInfo, "newPageInfo");
        if (RFWApplication.isDebug()) {
            RFWLog.i("BusinessMonitor", RFWLog.USR, "onPageChangeDetail, cur: " + Unified.INSTANCE.unified(newPageInfo));
        }
        d pageArgus = getPageArgus(newPageInfo);
        if (pageArgus == null) {
            return;
        }
        c cVar = c.f98725d;
        if (cVar.d().H()) {
            cVar.a().b(currentPageArgus, pageArgus);
        }
        if (!Intrinsics.areEqual(currentPageArgus, pageArgus)) {
            prevPageArgus = currentPageArgus;
        }
        currentPageArgus = pageArgus;
        Set<ArgusNode<?>> allVisibleNode = newPageInfo.getAllVisibleNode();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allVisibleNode) {
            if (obj instanceof FragmentNode) {
                arrayList.add(obj);
            }
        }
        ArrayList<String> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Class<?> blockClass = Unified.INSTANCE.getBlockClass((FragmentNode) it.next());
            if (blockClass != null) {
                str = blockClass.getName();
            } else {
                str = null;
            }
            if (str != null) {
                arrayList2.add(str);
            }
        }
        for (String str2 : arrayList2) {
            ConcurrentHashMap<String, CopyOnWriteArraySet<d>> concurrentHashMap = fragmentToPageArgus;
            CopyOnWriteArraySet<d> copyOnWriteArraySet = concurrentHashMap.get(str2);
            if (copyOnWriteArraySet == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str2, (copyOnWriteArraySet = new CopyOnWriteArraySet<>()))) != null) {
                copyOnWriteArraySet = putIfAbsent;
            }
            copyOnWriteArraySet.add(new d(pageArgus.b(), pageArgus.c(), null, 4, null));
        }
    }
}
