package com.tencent.luggage.wxa.ag;

import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.xd.p;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends p {
    public final void a(n nVar) {
        v currentPageView = nVar.getCurrentPageView();
        setContext(currentPageView, currentPageView.getComponentId()).dispatch();
        setContext(currentPageView.y0(), currentPageView.getComponentId()).dispatch();
    }
}
