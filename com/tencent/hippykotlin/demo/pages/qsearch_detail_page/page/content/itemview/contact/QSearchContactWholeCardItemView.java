package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchContactWholeCardItemView extends QSearchBaseWholeCardItemView<QSearchContactWholeCardItemAttr, QSearchContactWholeCardItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchContactWholeCardItemAttr access$getAttr(QSearchContactWholeCardItemView qSearchContactWholeCardItemView) {
        return (QSearchContactWholeCardItemAttr) qSearchContactWholeCardItemView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView
    public final Function1<ViewContainer<?, ?>, Unit> buildItem(final boolean z16) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.QSearchContactWholeCardItemView$buildItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchContactWholeCardItemView qSearchContactWholeCardItemView = QSearchContactWholeCardItemView.this;
                final boolean z17 = z16;
                viewContainer.addChild(new ContactSingleItemView(), new Function1<ContactSingleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.QSearchContactWholeCardItemView$buildItem$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ContactSingleItemView contactSingleItemView) {
                        final QSearchContactWholeCardItemView qSearchContactWholeCardItemView2 = QSearchContactWholeCardItemView.this;
                        final boolean z18 = z17;
                        contactSingleItemView.attr(new Function1<ContactSingleItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.QSearchContactWholeCardItemView.buildItem.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ContactSingleItemAttr contactSingleItemAttr) {
                                ContactSingleItemAttr contactSingleItemAttr2 = contactSingleItemAttr;
                                SearchContactItemModel searchContactItemModel = QSearchContactWholeCardItemView.access$getAttr(QSearchContactWholeCardItemView.this).data;
                                if (searchContactItemModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("data");
                                    searchContactItemModel = null;
                                }
                                contactSingleItemAttr2.data = searchContactItemModel;
                                contactSingleItemAttr2.keyword = QSearchContactWholeCardItemView.access$getAttr(QSearchContactWholeCardItemView.this).keyword;
                                contactSingleItemAttr2.index = QSearchContactWholeCardItemView.access$getAttr(QSearchContactWholeCardItemView.this).index;
                                contactSingleItemAttr2.traceId = QSearchContactWholeCardItemView.access$getAttr(QSearchContactWholeCardItemView.this).traceId;
                                contactSingleItemAttr2.showDivider = z18;
                                contactSingleItemAttr2.tabData = QSearchContactWholeCardItemView.access$getAttr(QSearchContactWholeCardItemView.this).getTabData();
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
        return new QSearchContactWholeCardItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchContactWholeCardItemEvent();
    }
}
