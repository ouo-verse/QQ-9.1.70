package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExpressionTitleMoreCardItemView extends QSearchBaseTitleMoreCardItemView<ExpressionTitleMoreCardItemAttr> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ExpressionTitleMoreCardItemAttr access$getAttr(ExpressionTitleMoreCardItemView expressionTitleMoreCardItemView) {
        return (ExpressionTitleMoreCardItemAttr) expressionTitleMoreCardItemView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final Function1<ViewContainer<?, ?>, Unit> buildItems() {
        final float m3 = (((getPagerData().m() - 16.0f) - 51) - 32.0f) / 4;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionTitleMoreCardItemView$buildItems$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ExpressionTitleMoreCardItemView expressionTitleMoreCardItemView = ExpressionTitleMoreCardItemView.this;
                final float f16 = m3;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionTitleMoreCardItemView$buildItems$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionTitleMoreCardItemView.buildItems.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingBottom(16.0f).paddingTop(6.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        ?? r06 = ExpressionTitleMoreCardItemView.access$getAttr(ExpressionTitleMoreCardItemView.this).getData().itemList;
                        final float f17 = f16;
                        final ExpressionTitleMoreCardItemView expressionTitleMoreCardItemView2 = ExpressionTitleMoreCardItemView.this;
                        Iterator it = r06.iterator();
                        final int i3 = 0;
                        while (it.hasNext()) {
                            Object next = it.next();
                            int i16 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            final ExpressionInfo expressionInfo = (ExpressionInfo) next;
                            vVar2.addChild(new ExpressionSingleItemView(), new Function1<ExpressionSingleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionTitleMoreCardItemView$buildItems$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ExpressionSingleItemView expressionSingleItemView) {
                                    final int i17 = i3;
                                    final ExpressionInfo expressionInfo2 = expressionInfo;
                                    final float f18 = f17;
                                    final ExpressionTitleMoreCardItemView expressionTitleMoreCardItemView3 = expressionTitleMoreCardItemView2;
                                    expressionSingleItemView.attr(new Function1<ExpressionItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionTitleMoreCardItemView$buildItems$1$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ExpressionItemAttr expressionItemAttr) {
                                            ExpressionItemAttr expressionItemAttr2 = expressionItemAttr;
                                            expressionItemAttr2.isInGroup = true;
                                            expressionItemAttr2.index = i17;
                                            expressionItemAttr2.expressionInfo = expressionInfo2;
                                            float f19 = f18;
                                            expressionItemAttr2.size = new com.tencent.kuikly.core.base.w(f19, f19);
                                            expressionItemAttr2.data = ExpressionTitleMoreCardItemView.access$getAttr(expressionTitleMoreCardItemView3).getData();
                                            expressionItemAttr2.borderRadius = 4.0f;
                                            expressionItemAttr2.keyword = ExpressionTitleMoreCardItemView.access$getAttr(expressionTitleMoreCardItemView3).keyword;
                                            expressionItemAttr2.traceId = ExpressionTitleMoreCardItemView.access$getAttr(expressionTitleMoreCardItemView3).traceId;
                                            expressionItemAttr2.tabData = ExpressionTitleMoreCardItemView.access$getAttr(expressionTitleMoreCardItemView3).tabData;
                                            ExpressionTitleMoreCardItemAttr access$getAttr = ExpressionTitleMoreCardItemView.access$getAttr(expressionTitleMoreCardItemView3);
                                            expressionItemAttr2.setPageStatus((PageStatus) access$getAttr.pageStatus$delegate.getValue(access$getAttr, ExpressionTitleMoreCardItemAttr.$$delegatedProperties[0]));
                                            if (i17 != 0) {
                                                expressionItemAttr2.marginLeft(17.0f);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            i3 = i16;
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
        return new ExpressionTitleMoreCardItemAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final e getReportParams() {
        String str;
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        e reportParams = super.getReportParams();
        if (iSearchReport == null || (str = iSearchReport.getTabName(4)) == null) {
            str = "";
        }
        reportParams.v("target_tab_name", str);
        reportParams.t("target_tab_mask", 4);
        reportParams.v("transfer_info", TemplateItemsKt.mergeTransferInfo(((ExpressionTitleMoreCardItemAttr) getAttr()).getData().getReportInfo(), reportParams));
        return reportParams;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final Integer getJumpTabWhenClickMore() {
        return 4;
    }
}
