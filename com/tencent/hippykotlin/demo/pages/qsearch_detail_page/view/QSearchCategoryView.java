package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerEvent;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.bo;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchCategoryView extends ComposeView<QSearchCategoryAttr, QSearchCategoryEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchCategoryView.class, "tabFrameMapSize", "getTabFrameMapSize()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchCategoryView.class, "indicatorOffset", "getIndicatorOffset()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchCategoryView.class, "indicatorWidth", "getIndicatorWidth()F", 0)};
    public float lastTabWidth;
    public QSearchPageListView pageListView;
    public ScrollParams scrollParam;
    public float scrollViewWidth;
    public float scrollX;
    public aa<ScrollerView<?, ?>> scrollerViewRef;
    public final Map<Integer, d> tabFrameMap = new LinkedHashMap();
    public final Map<Integer, Float> tabOffsetXMap = new LinkedHashMap();
    public final ReadWriteProperty tabFrameMapSize$delegate = c.a(0);
    public final ReadWriteProperty indicatorOffset$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty indicatorWidth$delegate = c.a(Float.valueOf(10.0f));

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchCategoryAttr access$getAttr(QSearchCategoryView qSearchCategoryView) {
        return (QSearchCategoryAttr) qSearchCategoryView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, com.tencent.kuikly.core.layout.d>] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
    public static final void access$tryScrollToEnsureCurTabVisible(QSearchCategoryView qSearchCategoryView, int i3) {
        d dVar;
        aa<ScrollerView<?, ?>> aaVar;
        ScrollerView<?, ?> b16;
        ScrollerView<?, ?> b17;
        aa<ScrollerView<?, ?>> aaVar2;
        ScrollerView<?, ?> b18;
        if ((qSearchCategoryView.scrollViewWidth == 0.0f) || (dVar = (d) qSearchCategoryView.tabFrameMap.get(Integer.valueOf(i3))) == null) {
            return;
        }
        float x16 = dVar.getX();
        Float f16 = (Float) qSearchCategoryView.tabOffsetXMap.get(Integer.valueOf(i3));
        float floatValue = x16 + (f16 != null ? f16.floatValue() : 0.0f);
        float width = dVar.getWidth() + floatValue;
        float f17 = 2;
        float f18 = (floatValue + width) / f17;
        Float f19 = (Float) qSearchCategoryView.tabOffsetXMap.get(Integer.valueOf(((QSearchCategoryAttr) qSearchCategoryView.getAttr()).getItemTitles().size() - 1));
        float floatValue2 = (f19 != null ? f19.floatValue() : 0.0f) + qSearchCategoryView.lastTabWidth;
        float f26 = qSearchCategoryView.scrollViewWidth;
        float f27 = floatValue2 - f26;
        if (f27 <= 0.0f) {
            float f28 = qSearchCategoryView.scrollX;
            if (floatValue - f28 < 0.0f) {
                aa<ScrollerView<?, ?>> aaVar3 = qSearchCategoryView.scrollerViewRef;
                if (aaVar3 == null || (b17 = aaVar3.b()) == null) {
                    return;
                }
                ScrollerView.setContentOffset$default(b17, floatValue - ((QSearchCategoryAttr) qSearchCategoryView.getAttr()).autoScrollExtDistance, 0.0f, true, null, 8, null);
                return;
            }
            if (width - f28 <= f26 || (aaVar = qSearchCategoryView.scrollerViewRef) == null || (b16 = aaVar.b()) == null) {
                return;
            }
            ScrollerView.setContentOffset$default(b16, (width - qSearchCategoryView.scrollViewWidth) + ((QSearchCategoryAttr) qSearchCategoryView.getAttr()).autoScrollExtDistance, 0.0f, true, null, 8, null);
            return;
        }
        float f29 = f26 / f17;
        if (Math.abs((f18 - qSearchCategoryView.scrollX) - f29) > 0.001f) {
            float f36 = f18 - f29;
            float f37 = 0;
            if (f36 < f37) {
                f36 = f37 + 0.001f;
            }
            if (f36 > f27) {
                f36 = f27 - 0.001f;
            }
            float f38 = f36;
            if (Math.abs(f38 - qSearchCategoryView.scrollX) <= 0.001f || (aaVar2 = qSearchCategoryView.scrollerViewRef) == null || (b18 = aaVar2.b()) == null) {
                return;
            }
            ScrollerView.setContentOffset$default(b18, f38, 0.0f, true, null, 8, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, com.tencent.kuikly.core.layout.d>] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, com.tencent.kuikly.core.layout.d>] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, com.tencent.kuikly.core.layout.d>] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
    public static final void access$updateIndicatorOffset(QSearchCategoryView qSearchCategoryView) {
        float f16;
        ScrollParams scrollParams = qSearchCategoryView.scrollParam;
        if (scrollParams == null) {
            d dVar = (d) qSearchCategoryView.tabFrameMap.get(Integer.valueOf(((QSearchCategoryAttr) qSearchCategoryView.getAttr()).getCurrentIndex()));
            float x16 = dVar != null ? dVar.getX() : 0.0f;
            Float f17 = (Float) qSearchCategoryView.tabOffsetXMap.get(Integer.valueOf(((QSearchCategoryAttr) qSearchCategoryView.getAttr()).getCurrentIndex()));
            f16 = x16 + (f17 != null ? f17.floatValue() : 0.0f);
            if (dVar != null) {
                r2 = dVar.getWidth();
            }
        } else {
            int offsetX = (int) ((scrollParams.getOffsetX() + 0.001f) / scrollParams.getViewWidth());
            float offsetX2 = ((scrollParams.getOffsetX() + 0.001f) % scrollParams.getViewWidth()) / scrollParams.getViewWidth();
            d dVar2 = (d) qSearchCategoryView.tabFrameMap.get(Integer.valueOf(offsetX));
            if (dVar2 == null) {
                return;
            }
            float x17 = dVar2.getX();
            Float f18 = (Float) qSearchCategoryView.tabOffsetXMap.get(Integer.valueOf(offsetX));
            float floatValue = x17 + (f18 != null ? f18.floatValue() : 0.0f);
            float width = dVar2.getWidth();
            if (offsetX2 > 0.001f) {
                int i3 = offsetX + 1;
                d dVar3 = (d) qSearchCategoryView.tabFrameMap.get(Integer.valueOf(i3));
                if (dVar3 != null) {
                    float x18 = dVar3.getX();
                    Float f19 = (Float) qSearchCategoryView.tabOffsetXMap.get(Integer.valueOf(i3));
                    f16 = (((x18 + (f19 != null ? f19.floatValue() : 0.0f)) - floatValue) * offsetX2) + floatValue;
                    r2 = ((dVar3.getWidth() - width) * offsetX2) + width;
                }
            }
            r2 = width;
            f16 = floatValue;
        }
        ReadWriteProperty readWriteProperty = qSearchCategoryView.indicatorOffset$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(qSearchCategoryView, kPropertyArr[1], Float.valueOf(f16));
        qSearchCategoryView.indicatorWidth$delegate.setValue(qSearchCategoryView, kPropertyArr[2], Float.valueOf(r2));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                final QSearchCategoryView qSearchCategoryView = QSearchCategoryView.this;
                bo.a(viewContainer2, new Function1<ScrollerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollerView<?, ?> scrollerView) {
                        boolean z16;
                        ScrollerView<?, ?> scrollerView2 = scrollerView;
                        final QSearchCategoryView qSearchCategoryView2 = QSearchCategoryView.this;
                        scrollerView2.ref(scrollerView2, new Function1<aa<ScrollerView<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<ScrollerView<?, ?>> aaVar) {
                                QSearchCategoryView.this.scrollerViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        scrollerView2.attr(new Function1<ScrollerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollerAttr scrollerAttr) {
                                ScrollerAttr scrollerAttr2 = scrollerAttr;
                                scrollerAttr2.m140flex(1.0f);
                                scrollerAttr2.flexDirectionRow();
                                scrollerAttr2.showScrollerIndicator(false);
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchCategoryView qSearchCategoryView3 = QSearchCategoryView.this;
                        scrollerView2.event(new Function1<ScrollerEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollerEvent scrollerEvent) {
                                ScrollerEvent scrollerEvent2 = scrollerEvent;
                                final QSearchCategoryView qSearchCategoryView4 = QSearchCategoryView.this;
                                FrameEventKt.d(scrollerEvent2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(d dVar) {
                                        QSearchCategoryView.this.scrollViewWidth = dVar.getWidth();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchCategoryView qSearchCategoryView5 = QSearchCategoryView.this;
                                scrollerEvent2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        QSearchCategoryView.this.scrollX = scrollParams.getOffsetX();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchCategoryView qSearchCategoryView4 = QSearchCategoryView.this;
                        Function0<com.tencent.kuikly.core.reactive.collection.c<String>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<String>>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final com.tencent.kuikly.core.reactive.collection.c<String> invoke() {
                                return QSearchCategoryView.access$getAttr(QSearchCategoryView.this).getItemTitles();
                            }
                        };
                        final QSearchCategoryView qSearchCategoryView5 = QSearchCategoryView.this;
                        LoopDirectivesViewKt.a(scrollerView2, function0, new Function2<LoopDirectivesView<String>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<String> loopDirectivesView, String str) {
                                final String str2;
                                LoopDirectivesView<String> loopDirectivesView2 = loopDirectivesView;
                                final String str3 = str;
                                final int indexOf = QSearchCategoryView.access$getAttr(QSearchCategoryView.this).getItemTitles().indexOf(str3);
                                if (QSearchCategoryView.access$getAttr(QSearchCategoryView.this).getCurrentIndex() == indexOf) {
                                    str2 = "\u5df2\u9009\u5b9a";
                                } else {
                                    str2 = "";
                                }
                                final QSearchCategoryView qSearchCategoryView6 = QSearchCategoryView.this;
                                w.a(loopDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        boolean z17;
                                        v vVar2 = vVar;
                                        final QSearchCategoryView qSearchCategoryView7 = QSearchCategoryView.this;
                                        final int i3 = indexOf;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                Function3<? super m, ? super Integer, ? super Integer, Unit> function3 = QSearchCategoryView.access$getAttr(QSearchCategoryView.this).tabViewStyle;
                                                if (function3 != null) {
                                                    function3.invoke(tVar2, Integer.valueOf(i3), Integer.valueOf(QSearchCategoryView.access$getAttr(QSearchCategoryView.this).getCurrentIndex()));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final int i16 = indexOf;
                                        final QSearchCategoryView qSearchCategoryView8 = QSearchCategoryView.this;
                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final u uVar2 = uVar;
                                                final int i17 = i16;
                                                final QSearchCategoryView qSearchCategoryView9 = qSearchCategoryView8;
                                                FrameEventKt.d(uVar2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(d dVar) {
                                                        int lastIndex;
                                                        boolean z18;
                                                        d dVar2 = dVar;
                                                        int i18 = i17;
                                                        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(QSearchCategoryView.access$getAttr(qSearchCategoryView9).getItemTitles());
                                                        if (i18 == lastIndex) {
                                                            qSearchCategoryView9.lastTabWidth = dVar2.getWidth();
                                                        }
                                                        if (!qSearchCategoryView9.tabOffsetXMap.containsKey(Integer.valueOf(i17)) || !Intrinsics.areEqual((Float) qSearchCategoryView9.tabOffsetXMap.get(Integer.valueOf(i17)), dVar2.getX())) {
                                                            qSearchCategoryView9.tabOffsetXMap.put(Integer.valueOf(i17), Float.valueOf(dVar2.getX()));
                                                            z18 = ((QSearchCategoryAttr) qSearchCategoryView9.getAttr()).useScrollableIndicator;
                                                            if (z18) {
                                                                QSearchCategoryView.access$updateIndicatorOffset(qSearchCategoryView9);
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchCategoryView qSearchCategoryView10 = qSearchCategoryView8;
                                                final int i18 = i16;
                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        QSearchCategoryView.this.emit("clickCategorySwitch", Integer.valueOf(i18));
                                                        float m3 = uVar2.getPager().getPageData().m() * i18;
                                                        QSearchCategoryView.this.getClass();
                                                        QSearchCategoryView qSearchCategoryView11 = QSearchCategoryView.this;
                                                        qSearchCategoryView11.scrollParam = null;
                                                        QSearchPageListView qSearchPageListView = qSearchCategoryView11.pageListView;
                                                        if (qSearchPageListView != null) {
                                                            ScrollerView.setContentOffset$default(qSearchPageListView, m3, 0.0f, false, null, 8, null);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchCategoryView qSearchCategoryView9 = QSearchCategoryView.this;
                                        final int i17 = indexOf;
                                        final String str4 = str3;
                                        final String str5 = str2;
                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                final QSearchCategoryView qSearchCategoryView10 = QSearchCategoryView.this;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        tVar.paddingBottom(QSearchCategoryView.access$getAttr(QSearchCategoryView.this).indicatorStyle.margin + QSearchCategoryView.access$getAttr(QSearchCategoryView.this).indicatorStyle.height);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchCategoryView qSearchCategoryView11 = QSearchCategoryView.this;
                                                final int i18 = i17;
                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.3.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final QSearchCategoryView qSearchCategoryView12 = QSearchCategoryView.this;
                                                        final int i19 = i18;
                                                        FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.3.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Type inference failed for: r0v9, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, com.tencent.kuikly.core.layout.d>] */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(d dVar) {
                                                                boolean z18;
                                                                d dVar2 = dVar;
                                                                if (!QSearchCategoryView.this.tabFrameMap.containsKey(Integer.valueOf(i19)) || !Intrinsics.areEqual(QSearchCategoryView.this.tabFrameMap.get(Integer.valueOf(i19)), dVar2)) {
                                                                    QSearchCategoryView.this.tabFrameMap.put(Integer.valueOf(i19), dVar2);
                                                                    QSearchCategoryView qSearchCategoryView13 = QSearchCategoryView.this;
                                                                    qSearchCategoryView13.tabFrameMapSize$delegate.setValue(qSearchCategoryView13, QSearchCategoryView.$$delegatedProperties[0], Integer.valueOf(qSearchCategoryView13.tabFrameMap.size()));
                                                                    z18 = ((QSearchCategoryAttr) QSearchCategoryView.this.getAttr()).useScrollableIndicator;
                                                                    if (z18) {
                                                                        QSearchCategoryView.access$updateIndicatorOffset(QSearchCategoryView.this);
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str6 = str4;
                                                final QSearchCategoryView qSearchCategoryView12 = QSearchCategoryView.this;
                                                final int i19 = i17;
                                                final String str7 = str5;
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.3.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str8 = str6;
                                                        final QSearchCategoryView qSearchCategoryView13 = qSearchCategoryView12;
                                                        final int i26 = i19;
                                                        final String str9 = str7;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.3.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(str8);
                                                                Function3<? super ce, ? super Integer, ? super Integer, Unit> function3 = QSearchCategoryView.access$getAttr(qSearchCategoryView13).textViewStyle;
                                                                if (function3 != null) {
                                                                    function3.invoke(ceVar2, Integer.valueOf(i26), Integer.valueOf(QSearchCategoryView.access$getAttr(qSearchCategoryView13).getCurrentIndex()));
                                                                }
                                                                ceVar2.accessibility(str9 + str8 + "\u6309\u94ae");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        z17 = ((QSearchCategoryAttr) QSearchCategoryView.this.getAttr()).useScrollableIndicator;
                                        if (!z17) {
                                            final int i18 = indexOf;
                                            final QSearchCategoryView qSearchCategoryView10 = QSearchCategoryView.this;
                                            Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.4
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    boolean z18 = false;
                                                    if (i18 == QSearchCategoryView.access$getAttr(qSearchCategoryView10).getCurrentIndex()) {
                                                        QSearchCategoryView qSearchCategoryView11 = qSearchCategoryView10;
                                                        if (((Number) qSearchCategoryView11.tabFrameMapSize$delegate.getValue(qSearchCategoryView11, QSearchCategoryView.$$delegatedProperties[0])).intValue() == QSearchCategoryView.access$getAttr(qSearchCategoryView10).getItemTitles().size()) {
                                                            z18 = true;
                                                        }
                                                    }
                                                    return Boolean.valueOf(z18);
                                                }
                                            };
                                            final QSearchCategoryView qSearchCategoryView11 = QSearchCategoryView.this;
                                            final int i19 = indexOf;
                                            ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.5
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ConditionView conditionView) {
                                                    final QSearchCategoryView qSearchCategoryView12 = QSearchCategoryView.this;
                                                    final int i26 = i19;
                                                    w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.5.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar3) {
                                                            final QSearchCategoryView qSearchCategoryView13 = QSearchCategoryView.this;
                                                            final int i27 = i26;
                                                            vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.5.1.5.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                /* JADX WARN: Type inference failed for: r0v10, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, com.tencent.kuikly.core.layout.d>] */
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    h hVar = QSearchCategoryView.access$getAttr(QSearchCategoryView.this).indicatorStyle.color;
                                                                    if (hVar == null) {
                                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).getPrimaryTextColor();
                                                                    }
                                                                    tVar2.mo113backgroundColor(hVar);
                                                                    tVar2.mo141height(QSearchCategoryView.access$getAttr(QSearchCategoryView.this).indicatorStyle.height);
                                                                    d dVar = (d) QSearchCategoryView.this.tabFrameMap.get(Integer.valueOf(i27));
                                                                    tVar2.mo153width(dVar != null ? dVar.getWidth() : 0.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        z16 = ((QSearchCategoryAttr) QSearchCategoryView.this.getAttr()).useScrollableIndicator;
                        if (z16) {
                            final QSearchCategoryView qSearchCategoryView6 = QSearchCategoryView.this;
                            Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.6
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    QSearchCategoryView qSearchCategoryView7 = QSearchCategoryView.this;
                                    return Float.valueOf(((Number) qSearchCategoryView7.indicatorOffset$delegate.getValue(qSearchCategoryView7, QSearchCategoryView.$$delegatedProperties[1])).floatValue());
                                }
                            };
                            final QSearchCategoryView qSearchCategoryView7 = QSearchCategoryView.this;
                            BindDirectivesViewKt.a(scrollerView2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.7
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                    final QSearchCategoryView qSearchCategoryView8 = QSearchCategoryView.this;
                                    w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.7.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            final QSearchCategoryView qSearchCategoryView9 = QSearchCategoryView.this;
                                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView.body.1.2.7.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.positionAbsolute();
                                                    h hVar = QSearchCategoryView.access$getAttr(QSearchCategoryView.this).indicatorStyle.color;
                                                    if (hVar == null) {
                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).getPrimaryTextColor();
                                                    }
                                                    tVar2.mo113backgroundColor(hVar);
                                                    tVar2.mo141height(QSearchCategoryView.access$getAttr(QSearchCategoryView.this).indicatorStyle.height);
                                                    QSearchCategoryView qSearchCategoryView10 = QSearchCategoryView.this;
                                                    ReadWriteProperty readWriteProperty = qSearchCategoryView10.indicatorWidth$delegate;
                                                    KProperty<?>[] kPropertyArr = QSearchCategoryView.$$delegatedProperties;
                                                    tVar2.mo153width(((Number) readWriteProperty.getValue(qSearchCategoryView10, kPropertyArr[2])).floatValue());
                                                    QSearchCategoryView qSearchCategoryView11 = QSearchCategoryView.this;
                                                    tVar2.m142left(((Number) qSearchCategoryView11.indicatorOffset$delegate.getValue(qSearchCategoryView11, kPropertyArr[1])).floatValue());
                                                    tVar2.m138bottom(0.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchCategoryAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchCategoryEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView$created$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QSearchCategoryView.access$getAttr(QSearchCategoryView.this).getItemTitles();
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView$created$2
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r4v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, com.tencent.kuikly.core.layout.d>] */
            /* JADX WARN: Type inference failed for: r4v4, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchCategoryView.this.tabFrameMap.clear();
                QSearchCategoryView.this.tabOffsetXMap.clear();
                QSearchCategoryView qSearchCategoryView = QSearchCategoryView.this;
                qSearchCategoryView.tabFrameMapSize$delegate.setValue(qSearchCategoryView, QSearchCategoryView.$$delegatedProperties[0], 0);
                return Unit.INSTANCE;
            }
        });
    }
}
