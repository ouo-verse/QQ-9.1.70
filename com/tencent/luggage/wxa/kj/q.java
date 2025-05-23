package com.tencent.luggage.wxa.kj;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f132407a = new q();

    public static final void a(p pVar, com.tencent.luggage.wxa.wj.c cVar) {
        Intrinsics.checkNotNullParameter(pVar, "<this>");
        a(pVar, cVar, false, 2, null);
    }

    public static /* synthetic */ void a(p pVar, com.tencent.luggage.wxa.wj.c cVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cVar = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        a(pVar, cVar, z16);
    }

    public static final void a(p pVar, com.tencent.luggage.wxa.wj.c cVar, boolean z16) {
        n currentPage;
        v currentPageView;
        Intrinsics.checkNotNullParameter(pVar, "<this>");
        Iterator a16 = pVar.a(z16);
        Intrinsics.checkNotNullExpressionValue(a16, "this.stackIterator(includeStagingPages)");
        while (a16.hasNext()) {
            n nVar = (n) a16.next();
            if (nVar instanceof g) {
                Iterator I = ((g) nVar).I();
                Intrinsics.checkNotNullExpressionValue(I, "it.pagesIterator()");
                while (I.hasNext()) {
                    ((v) I.next()).a(cVar);
                }
            } else {
                nVar.getCurrentPageView().a(cVar);
            }
        }
        List<v> preloadedPageView = pVar.getPreloadedPageView();
        if (preloadedPageView != null) {
            Iterator<T> it = preloadedPageView.iterator();
            while (it.hasNext()) {
                ((v) it.next()).a(cVar);
            }
        }
        if (cVar != null || (currentPage = pVar.getCurrentPage()) == null || (currentPageView = currentPage.getCurrentPageView()) == null) {
            return;
        }
        pVar.b(currentPageView);
    }
}
