package com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer;

import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class ObservableView<A extends k, E extends l> extends ComposeView<A, E> implements ad {
    public final List<Function0<Unit>> frameChangeHandlers = new ArrayList();
    public final Set<ScrollerView<?, ?>> scrollers = new LinkedHashSet();

    @Override // com.tencent.kuikly.core.views.ad
    public final void contentSizeDidChanged(float f16, float f17) {
        ad.a.a(this, f16, f17);
        trigger();
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void contentViewDidSetFrameToRenderView() {
        ad.a.b(this);
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void layoutFrameDidChanged(d dVar) {
        super.layoutFrameDidChanged(dVar);
        trigger();
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void onContentOffsetDidChanged(float f16, float f17, ScrollParams scrollParams) {
        trigger();
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void onPagerParentScrollerDidScroll() {
        ad.a.c(this);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void scrollFrameDidChanged(d dVar) {
        ad.a.d(this, dVar);
        trigger();
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void scrollerDragBegin(ScrollParams scrollParams) {
        ad.a.e(this, scrollParams);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void scrollerScrollDidEnd(ScrollParams scrollParams) {
        ad.a.f(this, scrollParams);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void subViewsDidLayout() {
        ad.a.g(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>>, java.util.ArrayList] */
    public final void trigger() {
        Iterator it = this.frameChangeHandlers.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }
}
