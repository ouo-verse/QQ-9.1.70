package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class TroopTagView$buildContent$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ TroopTagView $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTagView$buildContent$1(TroopTagView troopTagView) {
        super(1);
        this.$ctx = troopTagView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final TroopTagView troopTagView = this.$ctx;
        Function0<c<SearchNetLabel>> function0 = new Function0<c<SearchNetLabel>>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView$buildContent$1.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final c<SearchNetLabel> invoke() {
                TroopTagView troopTagView2 = TroopTagView.this;
                KProperty<Object>[] kPropertyArr = TroopTagView.$$delegatedProperties;
                return troopTagView2.getLabelList();
            }
        };
        final TroopTagView troopTagView2 = this.$ctx;
        LoopDirectivesViewKt.a(viewContainer, function0, new Function2<LoopDirectivesView<SearchNetLabel>, SearchNetLabel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView$buildContent$1.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(LoopDirectivesView<SearchNetLabel> loopDirectivesView, SearchNetLabel searchNetLabel) {
                final SearchNetLabel searchNetLabel2 = searchNetLabel;
                final TroopTagView troopTagView3 = TroopTagView.this;
                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView.buildContent.1.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final TroopTagView troopTagView4 = TroopTagView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView.buildContent.1.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.paddingTop(TroopTagView.access$getAttr(TroopTagView.this).useWrapMode ? TroopTagView.access$getAttr(TroopTagView.this).wrapMarginTop : 0.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final SearchNetLabel searchNetLabel3 = searchNetLabel2;
                        final TroopTagView troopTagView5 = TroopTagView.this;
                        vVar2.addChild(new QSearchSingleTagView(), new Function1<QSearchSingleTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView.buildContent.1.2.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchSingleTagView qSearchSingleTagView) {
                                final SearchNetLabel searchNetLabel4 = SearchNetLabel.this;
                                final TroopTagView troopTagView6 = troopTagView5;
                                qSearchSingleTagView.attr(new Function1<QSearchSingleTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView.buildContent.1.2.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchSingleTagAttr qSearchSingleTagAttr) {
                                        QSearchSingleTagAttr qSearchSingleTagAttr2 = qSearchSingleTagAttr;
                                        qSearchSingleTagAttr2.label = SearchNetLabel.this;
                                        TroopTagView troopTagView7 = troopTagView6;
                                        qSearchSingleTagAttr2.maxWidth$delegate.setValue(qSearchSingleTagAttr2, QSearchSingleTagAttr.$$delegatedProperties[0], Float.valueOf(((Boolean) troopTagView7.needTail$delegate.getValue(troopTagView7, TroopTagView.$$delegatedProperties[1])).booleanValue() ? troopTagView6.getMaxWidth() : 0.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
