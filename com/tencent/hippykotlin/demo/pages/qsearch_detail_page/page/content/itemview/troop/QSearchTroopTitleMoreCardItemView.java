package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTroopTitleMoreCardItemView extends QSearchBaseTitleMoreCardItemView<QSearchTroopTitleMoreCardItemAttr> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchTroopTitleMoreCardItemAttr access$getAttr(QSearchTroopTitleMoreCardItemView qSearchTroopTitleMoreCardItemView) {
        return (QSearchTroopTitleMoreCardItemAttr) qSearchTroopTitleMoreCardItemView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final Function1<ViewContainer<?, ?>, Unit> buildItems() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopTitleMoreCardItemView$buildItems$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                int size = QSearchTroopTitleMoreCardItemView.access$getAttr(QSearchTroopTitleMoreCardItemView.this).getData().troopList.size();
                for (final int i3 = 0; i3 < size; i3++) {
                    final QSearchTroopTitleMoreCardItemView qSearchTroopTitleMoreCardItemView = QSearchTroopTitleMoreCardItemView.this;
                    viewContainer2.addChild(new TroopSingleItemView(), new Function1<TroopSingleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopTitleMoreCardItemView$buildItems$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(TroopSingleItemView troopSingleItemView) {
                            final QSearchTroopTitleMoreCardItemView qSearchTroopTitleMoreCardItemView2 = QSearchTroopTitleMoreCardItemView.this;
                            final int i16 = i3;
                            troopSingleItemView.attr(new Function1<TroopSingleItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopTitleMoreCardItemView.buildItems.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel>, java.util.ArrayList] */
                                /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel>, java.util.ArrayList] */
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TroopSingleItemAttr troopSingleItemAttr) {
                                    TroopSingleItemAttr troopSingleItemAttr2 = troopSingleItemAttr;
                                    troopSingleItemAttr2.isInGroup = true;
                                    troopSingleItemAttr2.keyword = QSearchTroopTitleMoreCardItemView.access$getAttr(QSearchTroopTitleMoreCardItemView.this).keyword;
                                    troopSingleItemAttr2.data = (SearchTroopItemModel) QSearchTroopTitleMoreCardItemView.access$getAttr(QSearchTroopTitleMoreCardItemView.this).getData().troopList.get(i16);
                                    troopSingleItemAttr2.index = i16;
                                    troopSingleItemAttr2.traceId = QSearchTroopTitleMoreCardItemView.access$getAttr(QSearchTroopTitleMoreCardItemView.this).traceId;
                                    troopSingleItemAttr2.showDivider = i16 != QSearchTroopTitleMoreCardItemView.access$getAttr(QSearchTroopTitleMoreCardItemView.this).getData().troopList.size() - 1;
                                    troopSingleItemAttr2.tabData = QSearchTroopTitleMoreCardItemView.access$getAttr(QSearchTroopTitleMoreCardItemView.this).tabData;
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchTroopTitleMoreCardItemAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final e getReportParams() {
        String str;
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        e reportParams = super.getReportParams();
        if (iSearchReport == null || (str = iSearchReport.getTabName(6)) == null) {
            str = "";
        }
        reportParams.v("target_tab_name", str);
        reportParams.t("target_tab_mask", 6);
        reportParams.v("transfer_info", TemplateItemsKt.mergeTransferInfo(((QSearchTroopTitleMoreCardItemAttr) getAttr()).getData().getReportInfo(), reportParams));
        return reportParams;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final float paddingTop() {
        return 0.0f;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final float topBorderRadius() {
        return 0.0f;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final Integer getJumpTabWhenClickMore() {
        return 6;
    }
}
