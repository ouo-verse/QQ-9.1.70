package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.pager.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class QSearchBaseAnimControlItemView<A extends QSearchBaseAnimControlItemAttr, E extends l> extends QSearchReportView<A, E> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBaseAnimControlItemView.class, "isViewAppear", "isViewAppear()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBaseAnimControlItemView.class, "canPlayAnim", "getCanPlayAnim()Z", 0)};
    public final ReadWriteProperty canPlayAnim$delegate;
    public final ReadWriteProperty isViewAppear$delegate;
    public QSearchDetailPage pager;

    public QSearchBaseAnimControlItemView() {
        Boolean bool = Boolean.TRUE;
        this.isViewAppear$delegate = c.a(bool);
        this.canPlayAnim$delegate = c.a(bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchBaseAnimControlItemAttr access$getAttr(QSearchBaseAnimControlItemView qSearchBaseAnimControlItemView) {
        return (QSearchBaseAnimControlItemAttr) qSearchBaseAnimControlItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$updateCanDisplayAnim(QSearchBaseAnimControlItemView qSearchBaseAnimControlItemView) {
        int i3;
        QSearchDetailViewModel qSearchDetailViewModel;
        QSearchContentViewModel contentPageViewModel;
        if (qSearchBaseAnimControlItemView.getPager().getPageData().getIsAndroid()) {
            boolean z16 = false;
            if (((Boolean) qSearchBaseAnimControlItemView.isViewAppear$delegate.getValue(qSearchBaseAnimControlItemView, $$delegatedProperties[0])).booleanValue()) {
                QSearchBaseAnimControlItemAttr qSearchBaseAnimControlItemAttr = (QSearchBaseAnimControlItemAttr) qSearchBaseAnimControlItemView.getAttr();
                if (((PageStatus) qSearchBaseAnimControlItemAttr.pageStatus$delegate.getValue(qSearchBaseAnimControlItemAttr, QSearchBaseAnimControlItemAttr.$$delegatedProperties[0])) == PageStatus.DID_APPEAR) {
                    QSearchDetailPage qSearchDetailPage = qSearchBaseAnimControlItemView.pager;
                    if (qSearchDetailPage != null) {
                        int size = qSearchDetailPage.viewModel.getContentPageViewModel().getTabTypeList().size();
                        for (int i16 = 0; i16 < size; i16++) {
                            if (((int) qSearchDetailPage.viewModel.getContentPageViewModel().getTabTypeList().get(i16).tabMask) == ((int) ((QSearchBaseAnimControlItemAttr) qSearchBaseAnimControlItemView.getAttr()).tabData.tabMask)) {
                                i3 = Math.abs(i16 - qSearchDetailPage.viewModel.getContentPageViewModel().getCurrentIndex());
                                break;
                            }
                        }
                    }
                    i3 = 0;
                    QSearchDetailPage qSearchDetailPage2 = qSearchBaseAnimControlItemView.pager;
                    if (((qSearchDetailPage2 == null || (qSearchDetailViewModel = qSearchDetailPage2.viewModel) == null || (contentPageViewModel = qSearchDetailViewModel.getContentPageViewModel()) == null) ? true : contentPageViewModel.isPagerScrolling()) ? i3 <= 1 : i3 == 0) {
                        z16 = true;
                    }
                }
            }
            if (qSearchBaseAnimControlItemView.getCanPlayAnim() != z16) {
                qSearchBaseAnimControlItemView.canPlayAnim$delegate.setValue(qSearchBaseAnimControlItemView, $$delegatedProperties[1], Boolean.valueOf(z16));
            }
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView$body$1
            public final /* synthetic */ QSearchBaseAnimControlItemView<A, E> $ctx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$ctx = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QSearchBaseAnimControlItemView<A, E> qSearchBaseAnimControlItemView = this.$ctx;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        Event event2 = event;
                        final QSearchBaseAnimControlItemView<QSearchBaseAnimControlItemAttr, l> qSearchBaseAnimControlItemView2 = qSearchBaseAnimControlItemView;
                        VisibilityEventKt.e(event2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView.body.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                QSearchBaseAnimControlItemView<QSearchBaseAnimControlItemAttr, l> qSearchBaseAnimControlItemView3 = qSearchBaseAnimControlItemView2;
                                qSearchBaseAnimControlItemView3.isViewAppear$delegate.setValue(qSearchBaseAnimControlItemView3, QSearchBaseAnimControlItemView.$$delegatedProperties[0], Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchBaseAnimControlItemView<QSearchBaseAnimControlItemAttr, l> qSearchBaseAnimControlItemView3 = qSearchBaseAnimControlItemView;
                        VisibilityEventKt.c(event2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                QSearchBaseAnimControlItemView<QSearchBaseAnimControlItemAttr, l> qSearchBaseAnimControlItemView4 = qSearchBaseAnimControlItemView3;
                                qSearchBaseAnimControlItemView4.isViewAppear$delegate.setValue(qSearchBaseAnimControlItemView4, QSearchBaseAnimControlItemView.$$delegatedProperties[0], Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                this.$ctx.configView().invoke(viewContainer2);
                return Unit.INSTANCE;
            }
        };
    }

    public abstract Function1<ViewContainer<?, ?>, Unit> configView();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public void created() {
        super.created();
        b pager = getPager();
        this.pager = pager instanceof QSearchDetailPage ? (QSearchDetailPage) pager : null;
        bindValueChange(new Function0<Object>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView$created$1
            public final /* synthetic */ QSearchBaseAnimControlItemView<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                QSearchBaseAnimControlItemView<A, E> qSearchBaseAnimControlItemView = this.this$0;
                return Boolean.valueOf(((Boolean) qSearchBaseAnimControlItemView.isViewAppear$delegate.getValue(qSearchBaseAnimControlItemView, QSearchBaseAnimControlItemView.$$delegatedProperties[0])).booleanValue());
            }
        }, new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView$created$2
            public final /* synthetic */ QSearchBaseAnimControlItemView<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchBaseAnimControlItemView.access$updateCanDisplayAnim(this.this$0);
                return Unit.INSTANCE;
            }
        });
        bindValueChange(new Function0<Object>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView$created$3
            public final /* synthetic */ QSearchBaseAnimControlItemView<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                QSearchBaseAnimControlItemAttr access$getAttr = QSearchBaseAnimControlItemView.access$getAttr(this.this$0);
                return (PageStatus) access$getAttr.pageStatus$delegate.getValue(access$getAttr, QSearchBaseAnimControlItemAttr.$$delegatedProperties[0]);
            }
        }, new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView$created$4
            public final /* synthetic */ QSearchBaseAnimControlItemView<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchBaseAnimControlItemView.access$updateCanDisplayAnim(this.this$0);
                return Unit.INSTANCE;
            }
        });
        final QSearchDetailPage qSearchDetailPage = this.pager;
        if (qSearchDetailPage != null) {
            qSearchDetailPage.bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView$created$5$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Integer.valueOf(QSearchDetailPage.this.viewModel.getContentPageViewModel().getCurrentIndex());
                }
            }, new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView$created$5$2
                public final /* synthetic */ QSearchBaseAnimControlItemView<A, E> $ctx;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$ctx = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    QSearchBaseAnimControlItemView.access$updateCanDisplayAnim(this.$ctx);
                    return Unit.INSTANCE;
                }
            });
            qSearchDetailPage.bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView$created$5$3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(QSearchDetailPage.this.viewModel.getContentPageViewModel().isPagerScrolling());
                }
            }, new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView$created$5$4
                public final /* synthetic */ QSearchBaseAnimControlItemView<A, E> $ctx;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$ctx = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    QSearchBaseAnimControlItemView.access$updateCanDisplayAnim(this.$ctx);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final boolean getCanPlayAnim() {
        return ((Boolean) this.canPlayAnim$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }
}
