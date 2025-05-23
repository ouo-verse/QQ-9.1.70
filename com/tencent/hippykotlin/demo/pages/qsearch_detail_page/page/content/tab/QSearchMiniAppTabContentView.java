package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.QSearchMiniAppWholeCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.QSearchMiniAppWholeCardItemView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchMiniAppTabContentView extends QSearchTabContentView {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchTabContentAttr access$getAttr(QSearchMiniAppTabContentView qSearchMiniAppTabContentView) {
        return (QSearchTabContentAttr) qSearchMiniAppTabContentView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final Function1<ViewContainer<?, ?>, Unit> configItemView(final ISearchItemModel iSearchItemModel, final int i3) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchMiniAppTabContentView$configItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ISearchItemModel iSearchItemModel2 = ISearchItemModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchMiniAppTabContentView$configItemView$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ISearchItemModel.this instanceof SearchMiniAppItemModel);
                    }
                };
                final ISearchItemModel iSearchItemModel3 = ISearchItemModel.this;
                final QSearchMiniAppTabContentView qSearchMiniAppTabContentView = this;
                final int i16 = i3;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchMiniAppTabContentView$configItemView$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                        Intrinsics.checkNotNull(iSearchItemModel4, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel");
                        final SearchMiniAppItemModel searchMiniAppItemModel = (SearchMiniAppItemModel) iSearchItemModel4;
                        final QSearchMiniAppTabContentView qSearchMiniAppTabContentView2 = qSearchMiniAppTabContentView;
                        final int i17 = i16;
                        conditionView.addChild(new QSearchMiniAppWholeCardItemView(), new Function1<QSearchMiniAppWholeCardItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchMiniAppTabContentView.configItemView.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchMiniAppWholeCardItemView qSearchMiniAppWholeCardItemView) {
                                final SearchMiniAppItemModel searchMiniAppItemModel2 = SearchMiniAppItemModel.this;
                                final QSearchMiniAppTabContentView qSearchMiniAppTabContentView3 = qSearchMiniAppTabContentView2;
                                final int i18 = i17;
                                qSearchMiniAppWholeCardItemView.attr(new Function1<QSearchMiniAppWholeCardItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchMiniAppTabContentView.configItemView.1.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchMiniAppWholeCardItemAttr qSearchMiniAppWholeCardItemAttr) {
                                        QSearchMiniAppWholeCardItemAttr qSearchMiniAppWholeCardItemAttr2 = qSearchMiniAppWholeCardItemAttr;
                                        qSearchMiniAppWholeCardItemAttr2.data = SearchMiniAppItemModel.this;
                                        qSearchMiniAppWholeCardItemAttr2.keyword = QSearchMiniAppTabContentView.access$getAttr(qSearchMiniAppTabContentView3).getViewModel().keyword;
                                        qSearchMiniAppWholeCardItemAttr2.index = i18;
                                        qSearchMiniAppWholeCardItemAttr2.traceId = QSearchMiniAppTabContentView.access$getAttr(qSearchMiniAppTabContentView3).getViewModel().repo.currentTraceId;
                                        qSearchMiniAppWholeCardItemAttr2.isFirstItem = i18 == 0;
                                        qSearchMiniAppWholeCardItemAttr2.tabData = QSearchMiniAppTabContentView.access$getAttr(qSearchMiniAppTabContentView3).tabData;
                                        qSearchMiniAppWholeCardItemAttr2.setLastItem(i18 == QSearchMiniAppTabContentView.access$getAttr(qSearchMiniAppTabContentView3).getViewModel().getDataList().size() - 1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchMiniAppTabContentView$configItemView$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(ConditionView conditionView) {
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final float correctionItemMarginBottom() {
        return 8.0f;
    }
}
