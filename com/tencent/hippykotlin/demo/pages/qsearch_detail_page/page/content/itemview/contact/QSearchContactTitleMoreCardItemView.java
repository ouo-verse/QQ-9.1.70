package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel;
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
public final class QSearchContactTitleMoreCardItemView extends QSearchBaseTitleMoreCardItemView<QSearchContactTitleMoreCardItemAttr> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchContactTitleMoreCardItemAttr access$getAttr(QSearchContactTitleMoreCardItemView qSearchContactTitleMoreCardItemView) {
        return (QSearchContactTitleMoreCardItemAttr) qSearchContactTitleMoreCardItemView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final Function1<ViewContainer<?, ?>, Unit> buildItems() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.QSearchContactTitleMoreCardItemView$buildItems$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                int size = QSearchContactTitleMoreCardItemView.access$getAttr(QSearchContactTitleMoreCardItemView.this).getData().contactList.size();
                for (final int i3 = 0; i3 < size; i3++) {
                    final QSearchContactTitleMoreCardItemView qSearchContactTitleMoreCardItemView = QSearchContactTitleMoreCardItemView.this;
                    viewContainer2.addChild(new ContactSingleItemView(), new Function1<ContactSingleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.QSearchContactTitleMoreCardItemView$buildItems$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ContactSingleItemView contactSingleItemView) {
                            final QSearchContactTitleMoreCardItemView qSearchContactTitleMoreCardItemView2 = QSearchContactTitleMoreCardItemView.this;
                            final int i16 = i3;
                            contactSingleItemView.attr(new Function1<ContactSingleItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.QSearchContactTitleMoreCardItemView.buildItems.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel>, java.util.ArrayList] */
                                /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel>, java.util.ArrayList] */
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ContactSingleItemAttr contactSingleItemAttr) {
                                    ContactSingleItemAttr contactSingleItemAttr2 = contactSingleItemAttr;
                                    contactSingleItemAttr2.isInGroup = true;
                                    contactSingleItemAttr2.keyword = QSearchContactTitleMoreCardItemView.access$getAttr(QSearchContactTitleMoreCardItemView.this).keyword;
                                    contactSingleItemAttr2.data = (SearchContactItemModel) QSearchContactTitleMoreCardItemView.access$getAttr(QSearchContactTitleMoreCardItemView.this).getData().contactList.get(i16);
                                    contactSingleItemAttr2.index = i16;
                                    contactSingleItemAttr2.traceId = QSearchContactTitleMoreCardItemView.access$getAttr(QSearchContactTitleMoreCardItemView.this).traceId;
                                    contactSingleItemAttr2.showDivider = i16 != QSearchContactTitleMoreCardItemView.access$getAttr(QSearchContactTitleMoreCardItemView.this).getData().contactList.size() - 1;
                                    contactSingleItemAttr2.tabData = QSearchContactTitleMoreCardItemView.access$getAttr(QSearchContactTitleMoreCardItemView.this).tabData;
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
        return new QSearchContactTitleMoreCardItemAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final e getReportParams() {
        String str;
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        e reportParams = super.getReportParams();
        if (iSearchReport == null || (str = iSearchReport.getTabName(5)) == null) {
            str = "";
        }
        reportParams.v("target_tab_name", str);
        reportParams.t("target_tab_mask", 5);
        reportParams.v("transfer_info", TemplateItemsKt.mergeTransferInfo(((QSearchContactTitleMoreCardItemAttr) getAttr()).getData().getReportInfo(), reportParams));
        return reportParams;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final Integer getJumpTabWhenClickMore() {
        return 5;
    }
}
