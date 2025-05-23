package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchMiniAppWholeCardItemView extends QSearchBaseWholeCardItemView<QSearchMiniAppWholeCardItemAttr, QSearchMiniAppWholeCardItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchMiniAppWholeCardItemAttr access$getAttr(QSearchMiniAppWholeCardItemView qSearchMiniAppWholeCardItemView) {
        return (QSearchMiniAppWholeCardItemAttr) qSearchMiniAppWholeCardItemView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView
    public final Function1<ViewContainer<?, ?>, Unit> buildItem(final boolean z16) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.QSearchMiniAppWholeCardItemView$buildItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchMiniAppWholeCardItemView qSearchMiniAppWholeCardItemView = QSearchMiniAppWholeCardItemView.this;
                final boolean z17 = z16;
                viewContainer.addChild(new MiniAppSingleItemView(), new Function1<MiniAppSingleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.QSearchMiniAppWholeCardItemView$buildItem$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(MiniAppSingleItemView miniAppSingleItemView) {
                        final QSearchMiniAppWholeCardItemView qSearchMiniAppWholeCardItemView2 = QSearchMiniAppWholeCardItemView.this;
                        final boolean z18 = z17;
                        miniAppSingleItemView.attr(new Function1<MiniAppSingleItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.QSearchMiniAppWholeCardItemView.buildItem.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(MiniAppSingleItemAttr miniAppSingleItemAttr) {
                                MiniAppSingleItemAttr miniAppSingleItemAttr2 = miniAppSingleItemAttr;
                                miniAppSingleItemAttr2.keyword = QSearchMiniAppWholeCardItemView.access$getAttr(QSearchMiniAppWholeCardItemView.this).keyword;
                                SearchMiniAppItemModel searchMiniAppItemModel = QSearchMiniAppWholeCardItemView.access$getAttr(QSearchMiniAppWholeCardItemView.this).data;
                                if (searchMiniAppItemModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("data");
                                    searchMiniAppItemModel = null;
                                }
                                miniAppSingleItemAttr2.data = searchMiniAppItemModel;
                                miniAppSingleItemAttr2.index = QSearchMiniAppWholeCardItemView.access$getAttr(QSearchMiniAppWholeCardItemView.this).index;
                                miniAppSingleItemAttr2.traceId = QSearchMiniAppWholeCardItemView.access$getAttr(QSearchMiniAppWholeCardItemView.this).traceId;
                                miniAppSingleItemAttr2.tabData = QSearchMiniAppWholeCardItemView.access$getAttr(QSearchMiniAppWholeCardItemView.this).getTabData();
                                miniAppSingleItemAttr2.showDivider = z18;
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
        return new QSearchMiniAppWholeCardItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchMiniAppWholeCardItemEvent();
    }
}
