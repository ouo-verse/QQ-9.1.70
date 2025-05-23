package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes32.dex */
public /* synthetic */ class QSearchPageListEvent$addPageChangeListener$1 extends FunctionReferenceImpl implements Function1<Object, Unit> {
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>, java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object obj) {
        QSearchPageListEvent qSearchPageListEvent = (QSearchPageListEvent) this.receiver;
        qSearchPageListEvent.getClass();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
        int j3 = ((e) obj).j("index");
        Iterator it = qSearchPageListEvent.pageChangeListeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(Integer.valueOf(j3));
        }
        return Unit.INSTANCE;
    }

    public QSearchPageListEvent$addPageChangeListener$1(Object obj) {
        super(1, obj, QSearchPageListEvent.class, "handlePageChange", "handlePageChange(Ljava/lang/Object;)V", 0);
    }
}
