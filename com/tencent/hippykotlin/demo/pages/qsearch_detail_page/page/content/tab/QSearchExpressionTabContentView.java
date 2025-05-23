package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionWholeCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionWholeCardItemView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchExpressionTabContentView extends QSearchTabContentView {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchTabContentAttr access$getAttr(QSearchExpressionTabContentView qSearchExpressionTabContentView) {
        return (QSearchTabContentAttr) qSearchExpressionTabContentView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final Function1<ViewContainer<?, ?>, Unit> configItemView(final ISearchItemModel iSearchItemModel, final int i3) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchExpressionTabContentView$configItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ISearchItemModel iSearchItemModel2 = ISearchItemModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchExpressionTabContentView$configItemView$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ISearchItemModel.this instanceof ExpressionItemModel);
                    }
                };
                final ISearchItemModel iSearchItemModel3 = ISearchItemModel.this;
                final int i16 = i3;
                final QSearchExpressionTabContentView qSearchExpressionTabContentView = this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchExpressionTabContentView$configItemView$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                        Intrinsics.checkNotNull(iSearchItemModel4, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionItemModel");
                        final ExpressionItemModel expressionItemModel = (ExpressionItemModel) iSearchItemModel4;
                        final int i17 = i16;
                        final QSearchExpressionTabContentView qSearchExpressionTabContentView2 = qSearchExpressionTabContentView;
                        conditionView.addChild(new ExpressionWholeCardItemView(), new Function1<ExpressionWholeCardItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchExpressionTabContentView.configItemView.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ExpressionWholeCardItemView expressionWholeCardItemView) {
                                final ExpressionItemModel expressionItemModel2 = ExpressionItemModel.this;
                                final int i18 = i17;
                                final QSearchExpressionTabContentView qSearchExpressionTabContentView3 = qSearchExpressionTabContentView2;
                                expressionWholeCardItemView.attr(new Function1<ExpressionWholeCardItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchExpressionTabContentView.configItemView.1.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ExpressionWholeCardItemAttr expressionWholeCardItemAttr) {
                                        ExpressionWholeCardItemAttr expressionWholeCardItemAttr2 = expressionWholeCardItemAttr;
                                        expressionWholeCardItemAttr2.data = ExpressionItemModel.this;
                                        int i19 = i18;
                                        expressionWholeCardItemAttr2.lineIndex = i19;
                                        expressionWholeCardItemAttr2.isFirstItem = i19 == 0;
                                        expressionWholeCardItemAttr2.setLastItem(i19 == QSearchExpressionTabContentView.access$getAttr(qSearchExpressionTabContentView3).getViewModel().getDataList().size() - 1);
                                        expressionWholeCardItemAttr2.keyword = QSearchExpressionTabContentView.access$getAttr(qSearchExpressionTabContentView3).getViewModel().keyword;
                                        expressionWholeCardItemAttr2.traceId = QSearchExpressionTabContentView.access$getAttr(qSearchExpressionTabContentView3).getViewModel().repo.currentTraceId;
                                        expressionWholeCardItemAttr2.pageStatus$delegate.setValue(expressionWholeCardItemAttr2, ExpressionWholeCardItemAttr.$$delegatedProperties[0], QSearchExpressionTabContentView.access$getAttr(qSearchExpressionTabContentView3).getPageStatus());
                                        expressionWholeCardItemAttr2.tabData = QSearchExpressionTabContentView.access$getAttr(qSearchExpressionTabContentView3).tabData;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchExpressionTabContentView$configItemView$1.3
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
