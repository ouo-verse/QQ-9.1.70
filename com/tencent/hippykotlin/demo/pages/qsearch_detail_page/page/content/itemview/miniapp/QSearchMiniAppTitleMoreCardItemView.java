package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
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
public final class QSearchMiniAppTitleMoreCardItemView extends QSearchBaseTitleMoreCardItemView<QSearchMiniAppTitleMoreCardItemAttr> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchMiniAppTitleMoreCardItemAttr access$getAttr(QSearchMiniAppTitleMoreCardItemView qSearchMiniAppTitleMoreCardItemView) {
        return (QSearchMiniAppTitleMoreCardItemAttr) qSearchMiniAppTitleMoreCardItemView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final Function1<ViewContainer<?, ?>, Unit> buildItems() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.QSearchMiniAppTitleMoreCardItemView$buildItems$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                int size = QSearchMiniAppTitleMoreCardItemView.access$getAttr(QSearchMiniAppTitleMoreCardItemView.this).getData().miniAppList.size();
                for (final int i3 = 0; i3 < size; i3++) {
                    final QSearchMiniAppTitleMoreCardItemView qSearchMiniAppTitleMoreCardItemView = QSearchMiniAppTitleMoreCardItemView.this;
                    viewContainer2.addChild(new MiniAppSingleItemView(), new Function1<MiniAppSingleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.QSearchMiniAppTitleMoreCardItemView$buildItems$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(MiniAppSingleItemView miniAppSingleItemView) {
                            final QSearchMiniAppTitleMoreCardItemView qSearchMiniAppTitleMoreCardItemView2 = QSearchMiniAppTitleMoreCardItemView.this;
                            final int i16 = i3;
                            miniAppSingleItemView.attr(new Function1<MiniAppSingleItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.QSearchMiniAppTitleMoreCardItemView.buildItems.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel>, java.util.ArrayList] */
                                /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel>, java.util.ArrayList] */
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(MiniAppSingleItemAttr miniAppSingleItemAttr) {
                                    MiniAppSingleItemAttr miniAppSingleItemAttr2 = miniAppSingleItemAttr;
                                    miniAppSingleItemAttr2.isInGroup = true;
                                    miniAppSingleItemAttr2.keyword = QSearchMiniAppTitleMoreCardItemView.access$getAttr(QSearchMiniAppTitleMoreCardItemView.this).keyword;
                                    miniAppSingleItemAttr2.data = (SearchMiniAppItemModel) QSearchMiniAppTitleMoreCardItemView.access$getAttr(QSearchMiniAppTitleMoreCardItemView.this).getData().miniAppList.get(i16);
                                    miniAppSingleItemAttr2.index = i16;
                                    miniAppSingleItemAttr2.traceId = QSearchMiniAppTitleMoreCardItemView.access$getAttr(QSearchMiniAppTitleMoreCardItemView.this).traceId;
                                    miniAppSingleItemAttr2.showDivider = i16 != QSearchMiniAppTitleMoreCardItemView.access$getAttr(QSearchMiniAppTitleMoreCardItemView.this).getData().miniAppList.size() - 1;
                                    miniAppSingleItemAttr2.tabData = QSearchMiniAppTitleMoreCardItemView.access$getAttr(QSearchMiniAppTitleMoreCardItemView.this).tabData;
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
        return new QSearchMiniAppTitleMoreCardItemAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final e getReportParams() {
        String str;
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        e reportParams = super.getReportParams();
        if (iSearchReport == null || (str = iSearchReport.getTabName(7)) == null) {
            str = "";
        }
        reportParams.v("target_tab_name", str);
        reportParams.t("target_tab_mask", 7);
        reportParams.v("transfer_info", TemplateItemsKt.mergeTransferInfo(((QSearchMiniAppTitleMoreCardItemAttr) getAttr()).getData().getReportInfo(), reportParams));
        return reportParams;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final Integer getJumpTabWhenClickMore() {
        return 7;
    }
}
