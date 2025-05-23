package com.tencent.kuikly.core.manager;

import com.tencent.kuikly.core.exception.PagerCreatorNotFundException;
import com.tencent.kuikly.core.exception.PagerNotFoundException;
import com.tencent.kuikly.core.exception.ReactiveObserverNotFoundException;
import com.tencent.kuikly.core.global.GlobalFunctions;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.PageCreateTrace;
import com.tencent.kuikly.core.pager.d;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.utils.UrlParamIterator;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0005J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002J\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0001J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0002J(\u0010\u001a\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002J&\u0010\u001d\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00022\n\u0010\u001c\u001a\u00060\u0002j\u0002`\u001b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0002J\u001c\u0010 \u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\"\u001a\u00020\u0002J\u0006\u0010#\u001a\u00020\u000bJ\u0006\u0010$\u001a\u00020\u000bR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010&R<\u0010+\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040(j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/kuikly/core/manager/c;", "", "", "pageName", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/pager/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "url", "p", "pagerId", "k", "", "o", "g", h.F, "Lcom/tencent/kuikly/core/reactive/ReactiveObserver;", "i", "pagerData", "", "a", "event", "data", "e", "b", "", "viewRef", "f", "Lcom/tencent/kuikly/core/global/GlobalFunctionRef;", "functionRef", "c", "d", "creator", "r", DomainData.DOMAIN_NAME, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/kuikly/core/kmp/b;", "Lcom/tencent/kuikly/core/kmp/b;", "pagerMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "pagerNameMap", "reactiveObserverMap", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.kuikly.core.kmp.b<com.tencent.kuikly.core.pager.b> pagerMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.kuikly.core.kmp.b<ReactiveObserver> reactiveObserverMap;

    /* renamed from: a, reason: collision with root package name */
    public static final c f117352a = new c();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Function0<com.tencent.kuikly.core.pager.b>> pagerNameMap = new HashMap<>();

    static {
        String str = "100000000";
        boolean z16 = false;
        int i3 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        pagerMap = new com.tencent.kuikly.core.kmp.b<>(str, z16, i3, defaultConstructorMarker);
        reactiveObserverMap = new com.tencent.kuikly.core.kmp.b<>(str, z16, i3, defaultConstructorMarker);
    }

    c() {
    }

    private final Function0<com.tencent.kuikly.core.pager.b> q(String pageName) {
        HashMap<String, Function0<com.tencent.kuikly.core.pager.b>> hashMap = pagerNameMap;
        String lowerCase = pageName.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        return hashMap.get(lowerCase);
    }

    public final void a(String pagerId, String url, String pagerData) {
        com.tencent.kuikly.core.pager.b invoke;
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pagerData, "pagerData");
        PageCreateTrace pageCreateTrace = new PageCreateTrace();
        String p16 = p(url);
        com.tencent.kuikly.core.kmp.b<ReactiveObserver> bVar = reactiveObserverMap;
        bVar.e(pagerId, new ReactiveObserver());
        pageCreateTrace.i();
        Function0<com.tencent.kuikly.core.pager.b> q16 = q(p16);
        com.tencent.kuikly.core.pager.b innerPager = (q16 == null || (invoke = q16.invoke()) == null) ? null : invoke.innerPager();
        pageCreateTrace.h();
        if (innerPager != null) {
            pagerMap.e(pagerId, innerPager);
            innerPager.setPageName(p16);
            innerPager.setPageTrace(pageCreateTrace);
            innerPager.onCreatePager(pagerId, new e(pagerData));
            return;
        }
        bVar.d(pagerId);
        throw new PagerCreatorNotFundException("[createPager]: pager \u672a\u6ce8\u518c. pagerName: " + p16, pagerId, p16, pagerData);
    }

    public final void b(String pagerId) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        com.tencent.kuikly.core.kmp.b<com.tencent.kuikly.core.pager.b> bVar = pagerMap;
        com.tencent.kuikly.core.pager.b b16 = bVar.b(pagerId);
        if (b16 != null) {
            b16.onDestroyPager();
        }
        bVar.d(pagerId);
        com.tencent.kuikly.core.kmp.b<ReactiveObserver> bVar2 = reactiveObserverMap;
        ReactiveObserver b17 = bVar2.b(pagerId);
        if (b17 != null) {
            b17.p();
        }
        bVar2.d(pagerId);
    }

    public final void c(String pagerId, String functionRef, Object data) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(functionRef, "functionRef");
        GlobalFunctions.f117252a.e(pagerId, functionRef, data);
    }

    public final void d(String pagerId) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        com.tencent.kuikly.core.pager.b b16 = pagerMap.b(pagerId);
        if (b16 != null) {
            b16.onLayoutView();
        }
    }

    public final void e(String pagerId, String event, Object data) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.kuikly.core.pager.b b16 = pagerMap.b(pagerId);
        if (b16 != null) {
            d.a(b16, event, data);
        }
    }

    public final void f(String pagerId, int viewRef, String event, String data) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(event, "event");
        e eVar = data != null ? new e(data) : null;
        com.tencent.kuikly.core.pager.b b16 = pagerMap.b(pagerId);
        if (b16 != null) {
            b16.onViewEvent(viewRef, event, eVar);
        }
    }

    public final com.tencent.kuikly.core.pager.b g() {
        com.tencent.kuikly.core.kmp.b<com.tencent.kuikly.core.pager.b> bVar = pagerMap;
        BridgeManager bridgeManager = BridgeManager.f117344a;
        com.tencent.kuikly.core.pager.b b16 = bVar.b(bridgeManager.u());
        if (b16 != null) {
            return b16;
        }
        throw new PagerNotFoundException("pager not found: " + bridgeManager.u());
    }

    public final com.tencent.kuikly.core.pager.b h() {
        return pagerMap.b(BridgeManager.f117344a.u());
    }

    public final ReactiveObserver i() {
        com.tencent.kuikly.core.kmp.b<ReactiveObserver> bVar = reactiveObserverMap;
        BridgeManager bridgeManager = BridgeManager.f117344a;
        ReactiveObserver b16 = bVar.b(bridgeManager.u());
        if (b16 != null) {
            return b16;
        }
        throw new ReactiveObserverNotFoundException("ReactiveObserver not found: " + bridgeManager.u());
    }

    public final String j() {
        return "100000000";
    }

    public final com.tencent.kuikly.core.pager.b k(String pagerId) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        com.tencent.kuikly.core.pager.b b16 = pagerMap.b(pagerId);
        if (b16 != null) {
            return b16;
        }
        throw new PagerNotFoundException("pager not found: " + pagerId);
    }

    public final boolean l() {
        return pagerMap.a("100000000");
    }

    public final boolean m() {
        return pagerMap.c();
    }

    public final boolean n(String pagerId) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        return Intrinsics.areEqual(pagerId, j());
    }

    public final boolean o(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        if (pageName.length() > 1000) {
            return pagerNameMap.containsKey(pageName);
        }
        HashMap<String, Function0<com.tencent.kuikly.core.pager.b>> hashMap = pagerNameMap;
        String lowerCase = pageName.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        return hashMap.containsKey(lowerCase);
    }

    public final void r(String pageName, Function0<? extends com.tencent.kuikly.core.pager.b> creator) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(creator, "creator");
        HashMap<String, Function0<com.tencent.kuikly.core.pager.b>> hashMap = pagerNameMap;
        String lowerCase = pageName.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        hashMap.put(lowerCase, creator);
    }

    private final String p(String url) {
        if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            String[] strArr = {"v_bundleName", "pageName", "pagerName"};
            UrlParamIterator urlParamIterator = new UrlParamIterator(url);
            while (urlParamIterator.hasNext()) {
                Pair<? extends String, ? extends String> next = urlParamIterator.next();
                String component1 = next.component1();
                String component2 = next.component2();
                if (ArraysKt.contains(strArr, component1)) {
                    return component2;
                }
            }
        }
        return url;
    }
}
