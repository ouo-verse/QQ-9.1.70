package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view;

import com.tencent.kuikly.core.views.ScrollParams;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes32.dex */
public final /* synthetic */ class QSearchPageListEvent$addDragEndListener$1 extends FunctionReferenceImpl implements Function1<ScrollParams, Unit> {
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<kotlin.jvm.functions.Function1<com.tencent.kuikly.core.views.bn, kotlin.Unit>>, java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ScrollParams scrollParams) {
        ScrollParams scrollParams2 = scrollParams;
        Iterator it = ((QSearchPageListEvent) this.receiver).dragEndListeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(scrollParams2);
        }
        return Unit.INSTANCE;
    }

    public QSearchPageListEvent$addDragEndListener$1(Object obj) {
        super(1, obj, QSearchPageListEvent.class, "handleNativeDragEnd", "handleNativeDragEnd(Lcom/tencent/kuikly/core/views/ScrollParams;)V", 0);
    }
}
