package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.SubPageName;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes32.dex */
public final class QSearchHistorySubPageView extends QSearchDetailBaseSubPage<QSearchHistoryContentAttr, QSearchHistoryContentEvent> {
    public QSearchHistoryViewModel historyViewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchHistoryContentAttr access$getAttr(QSearchHistorySubPageView qSearchHistorySubPageView) {
        return (QSearchHistoryContentAttr) qSearchHistorySubPageView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchHistorySubPageView qSearchHistorySubPageView = QSearchHistorySubPageView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QSearchHistorySubPageView qSearchHistorySubPageView2 = QSearchHistorySubPageView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                if (!QSearchHistorySubPageView.access$getAttr(QSearchHistorySubPageView.this).getViewModel().isVasTheme()) {
                                    tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("bg_bottom_light"));
                                }
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchHistorySubPageView qSearchHistorySubPageView3 = QSearchHistorySubPageView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                QSearchHistoryViewModel qSearchHistoryViewModel = QSearchHistorySubPageView.this.historyViewModel;
                                if (qSearchHistoryViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("historyViewModel");
                                    qSearchHistoryViewModel = null;
                                }
                                return Boolean.valueOf(qSearchHistoryViewModel.getDataList().size() > 0);
                            }
                        };
                        final QSearchHistorySubPageView qSearchHistorySubPageView4 = QSearchHistorySubPageView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final QSearchHistorySubPageView qSearchHistorySubPageView5 = QSearchHistorySubPageView.this;
                                ar.a(conditionView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aq<?, ?> aqVar) {
                                        aq<?, ?> aqVar2 = aqVar;
                                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ao aoVar) {
                                                ao aoVar2 = aoVar;
                                                aoVar2.m140flex(1.0f);
                                                aoVar2.showScrollerIndicator(false);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchHistorySubPageView qSearchHistorySubPageView6 = QSearchHistorySubPageView.this;
                                        Function0<c<String>> function02 = new Function0<c<String>>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final c<String> invoke() {
                                                QSearchHistoryViewModel qSearchHistoryViewModel = QSearchHistorySubPageView.this.historyViewModel;
                                                if (qSearchHistoryViewModel == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("historyViewModel");
                                                    qSearchHistoryViewModel = null;
                                                }
                                                return qSearchHistoryViewModel.getDataList();
                                            }
                                        };
                                        final QSearchHistorySubPageView qSearchHistorySubPageView7 = QSearchHistorySubPageView.this;
                                        LoopDirectivesViewKt.a(aqVar2, function02, new Function2<LoopDirectivesView<String>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.3
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(LoopDirectivesView<String> loopDirectivesView, String str) {
                                                LoopDirectivesView<String> loopDirectivesView2 = loopDirectivesView;
                                                final String str2 = str;
                                                QSearchHistoryViewModel qSearchHistoryViewModel = QSearchHistorySubPageView.this.historyViewModel;
                                                if (qSearchHistoryViewModel == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("historyViewModel");
                                                    qSearchHistoryViewModel = null;
                                                }
                                                final int indexOf = qSearchHistoryViewModel.getDataList().indexOf(str2);
                                                final QSearchHistorySubPageView qSearchHistorySubPageView8 = QSearchHistorySubPageView.this;
                                                loopDirectivesView2.addChild(new QSearchHistoryItemView(), new Function1<QSearchHistoryItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchHistoryItemView qSearchHistoryItemView) {
                                                        QSearchHistoryItemView qSearchHistoryItemView2 = qSearchHistoryItemView;
                                                        final String str3 = str2;
                                                        final QSearchHistorySubPageView qSearchHistorySubPageView9 = qSearchHistorySubPageView8;
                                                        final int i3 = indexOf;
                                                        qSearchHistoryItemView2.attr(new Function1<QSearchHistoryItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.3.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(QSearchHistoryItemAttr qSearchHistoryItemAttr) {
                                                                QSearchHistoryItemAttr qSearchHistoryItemAttr2 = qSearchHistoryItemAttr;
                                                                qSearchHistoryItemAttr2.historyWord = str3;
                                                                qSearchHistoryItemAttr2.keyword = QSearchHistorySubPageView.access$getAttr(qSearchHistorySubPageView9).getViewModel().getInputText();
                                                                qSearchHistoryItemAttr2.viewModel = QSearchHistorySubPageView.access$getAttr(qSearchHistorySubPageView9).getViewModel().getHistoryPageViewModel();
                                                                qSearchHistoryItemAttr2.index = i3;
                                                                qSearchHistoryItemAttr2.tabData = QSearchHistorySubPageView.access$getAttr(qSearchHistorySubPageView9).tabData;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QSearchHistorySubPageView qSearchHistorySubPageView10 = qSearchHistorySubPageView8;
                                                        final String str4 = str2;
                                                        qSearchHistoryItemView2.event(new Function1<QSearchHistoryItemEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.3.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(QSearchHistoryItemEvent qSearchHistoryItemEvent) {
                                                                final QSearchHistorySubPageView qSearchHistorySubPageView11 = QSearchHistorySubPageView.this;
                                                                final String str5 = str4;
                                                                qSearchHistoryItemEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.3.1.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        QSearchHistorySubPageView.this.emit("clickHistoryWord", str5);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchHistorySubPageView qSearchHistorySubPageView8 = QSearchHistorySubPageView.this;
                                        aqVar2.addChild(new QSearchHistoryFooterView(), new Function1<QSearchHistoryFooterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchHistoryFooterView qSearchHistoryFooterView) {
                                                QSearchHistoryFooterView qSearchHistoryFooterView2 = qSearchHistoryFooterView;
                                                final QSearchHistorySubPageView qSearchHistorySubPageView9 = QSearchHistorySubPageView.this;
                                                qSearchHistoryFooterView2.attr(new Function1<QSearchHistoryFooterAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchHistoryFooterAttr qSearchHistoryFooterAttr) {
                                                        QSearchHistoryFooterAttr qSearchHistoryFooterAttr2 = qSearchHistoryFooterAttr;
                                                        qSearchHistoryFooterAttr2.keyword = QSearchHistorySubPageView.access$getAttr(QSearchHistorySubPageView.this).getViewModel().getInputText();
                                                        qSearchHistoryFooterAttr2.tabData = QSearchHistorySubPageView.access$getAttr(QSearchHistorySubPageView.this).tabData;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchHistorySubPageView qSearchHistorySubPageView10 = QSearchHistorySubPageView.this;
                                                qSearchHistoryFooterView2.event(new Function1<QSearchHistoryFooterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchHistoryFooterEvent qSearchHistoryFooterEvent) {
                                                        final QSearchHistorySubPageView qSearchHistorySubPageView11 = QSearchHistorySubPageView.this;
                                                        qSearchHistoryFooterEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.4.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                QSearchHistoryViewModel historyPageViewModel = QSearchHistorySubPageView.access$getAttr(QSearchHistorySubPageView.this).getViewModel().getHistoryPageViewModel();
                                                                historyPageViewModel.getDataList().clear();
                                                                historyPageViewModel.syncStorage();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchHistorySubPageView qSearchHistorySubPageView9 = QSearchHistorySubPageView.this;
                                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ap apVar) {
                                                final QSearchHistorySubPageView qSearchHistorySubPageView10 = QSearchHistorySubPageView.this;
                                                apVar.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView.body.1.1.3.1.5.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                        QSearchHistorySubPageView.this.hideKeyboard();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
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
        return new QSearchHistoryContentAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchHistoryContentEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        this.historyViewModel = ((QSearchHistoryContentAttr) getAttr()).getViewModel().getHistoryPageViewModel();
        super.created();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage
    public final SubPageName getSubPageName() {
        return SubPageName.HISTORY;
    }
}
