package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTroopTabContentViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTroopWholeCardItemView extends QSearchBaseWholeCardItemView<QSearchTroopWholeCardItemAttr, QSearchTroopWholeCardItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchTroopWholeCardItemAttr access$getAttr(QSearchTroopWholeCardItemView qSearchTroopWholeCardItemView) {
        return (QSearchTroopWholeCardItemAttr) qSearchTroopWholeCardItemView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView
    public final Function1<ViewContainer<?, ?>, Unit> buildItem(final boolean z16) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopWholeCardItemView$buildItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchTroopWholeCardItemView qSearchTroopWholeCardItemView = QSearchTroopWholeCardItemView.this;
                final boolean z17 = z16;
                viewContainer.addChild(new TroopSingleItemView(), new Function1<TroopSingleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopWholeCardItemView$buildItem$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TroopSingleItemView troopSingleItemView) {
                        final QSearchTroopWholeCardItemView qSearchTroopWholeCardItemView2 = QSearchTroopWholeCardItemView.this;
                        final boolean z18 = z17;
                        troopSingleItemView.attr(new Function1<TroopSingleItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopWholeCardItemView.buildItem.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TroopSingleItemAttr troopSingleItemAttr) {
                                String str;
                                TroopSingleItemAttr troopSingleItemAttr2 = troopSingleItemAttr;
                                troopSingleItemAttr2.keyword = QSearchTroopWholeCardItemView.access$getAttr(QSearchTroopWholeCardItemView.this).keyword;
                                SearchTroopItemModel searchTroopItemModel = QSearchTroopWholeCardItemView.access$getAttr(QSearchTroopWholeCardItemView.this).data;
                                if (searchTroopItemModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("data");
                                    searchTroopItemModel = null;
                                }
                                troopSingleItemAttr2.data = searchTroopItemModel;
                                troopSingleItemAttr2.index = QSearchTroopWholeCardItemView.access$getAttr(QSearchTroopWholeCardItemView.this).index;
                                troopSingleItemAttr2.viewModel = QSearchTroopWholeCardItemView.access$getAttr(QSearchTroopWholeCardItemView.this).viewModel;
                                QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel = QSearchTroopWholeCardItemView.access$getAttr(QSearchTroopWholeCardItemView.this).viewModel;
                                if (qSearchTroopTabContentViewModel == null || (str = qSearchTroopTabContentViewModel.repo.currentTraceId) == null) {
                                    str = "";
                                }
                                troopSingleItemAttr2.traceId = str;
                                troopSingleItemAttr2.tabData = QSearchTroopWholeCardItemView.access$getAttr(QSearchTroopWholeCardItemView.this).getTabData();
                                troopSingleItemAttr2.showDivider = z18;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchTroopWholeCardItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchTroopWholeCardItemEvent();
    }
}
