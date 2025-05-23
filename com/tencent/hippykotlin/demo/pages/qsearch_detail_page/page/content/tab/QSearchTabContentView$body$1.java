package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab;

import com.tencent.hippykotlin.demo.pages.base.ECRefreshListView;
import com.tencent.hippykotlin.demo.pages.base.ECRefreshListViewAttr;
import com.tencent.hippykotlin.demo.pages.base.ECRefreshListViewEvent;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.SearchCorrectionQueryCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchEmptyItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchEmptyItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTabContentView$body$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QSearchTabContentView $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchTabContentView$body$1(QSearchTabContentView qSearchTabContentView) {
        super(1);
        this.$ctx = qSearchTabContentView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final QSearchTabContentView qSearchTabContentView = this.$ctx;
        viewContainer.addChild(new ECRefreshListView(), new Function1<ECRefreshListView<ISearchItemModel>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$body$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ECRefreshListView<ISearchItemModel> eCRefreshListView) {
                ECRefreshListView<ISearchItemModel> eCRefreshListView2 = eCRefreshListView;
                final QSearchTabContentView qSearchTabContentView2 = QSearchTabContentView.this;
                eCRefreshListView2.ref(eCRefreshListView2, new Function1<aa<ECRefreshListView<ISearchItemModel>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aa<ECRefreshListView<ISearchItemModel>> aaVar) {
                        QSearchTabContentView qSearchTabContentView3 = QSearchTabContentView.this;
                        KProperty<Object>[] kPropertyArr = QSearchTabContentView.$$delegatedProperties;
                        qSearchTabContentView3.getClass();
                        return Unit.INSTANCE;
                    }
                });
                final QSearchTabContentView qSearchTabContentView3 = QSearchTabContentView.this;
                eCRefreshListView2.attr(new Function1<ECRefreshListViewAttr<ISearchItemModel>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECRefreshListViewAttr<ISearchItemModel> eCRefreshListViewAttr) {
                        ECRefreshListViewAttr<ISearchItemModel> eCRefreshListViewAttr2 = eCRefreshListViewAttr;
                        eCRefreshListViewAttr2.m140flex(1.0f);
                        c<ISearchItemModel> dataList = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().getDataList();
                        ReadWriteProperty readWriteProperty = eCRefreshListViewAttr2.dataList$delegate;
                        KProperty<?>[] kPropertyArr = ECRefreshListViewAttr.$$delegatedProperties;
                        readWriteProperty.setValue(eCRefreshListViewAttr2, kPropertyArr[1], dataList);
                        eCRefreshListViewAttr2.listState$delegate.setValue(eCRefreshListViewAttr2, kPropertyArr[2], QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().getListState());
                        eCRefreshListViewAttr2.loadingDelay = 0;
                        eCRefreshListViewAttr2.footerHeight = 60.0f;
                        eCRefreshListViewAttr2.preloadDistance = 3000.0f;
                        final QSearchTabContentView qSearchTabContentView4 = QSearchTabContentView.this;
                        final e emptyOrErrorViewReportParams = qSearchTabContentView4.getEmptyOrErrorViewReportParams(QSearchTabContentView.access$getAttr(qSearchTabContentView4).getKeyword(), QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().repo.currentTraceId, null);
                        eCRefreshListViewAttr2.emptyViewBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createEmptyView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                final e eVar = emptyOrErrorViewReportParams;
                                viewContainer3.addChild(new QSearchEmptyItemView(), new Function1<QSearchEmptyItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createEmptyView$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchEmptyItemView qSearchEmptyItemView) {
                                        final e eVar2 = e.this;
                                        qSearchEmptyItemView.attr(new Function1<QSearchEmptyItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.createEmptyView.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchEmptyItemAttr qSearchEmptyItemAttr) {
                                                QSearchEmptyItemAttr qSearchEmptyItemAttr2 = qSearchEmptyItemAttr;
                                                qSearchEmptyItemAttr2.positionAbsolute();
                                                qSearchEmptyItemAttr2.m142left(0.0f);
                                                qSearchEmptyItemAttr2.m149right(0.0f);
                                                qSearchEmptyItemAttr2.m138bottom((qSearchEmptyItemAttr2.getPager().getPageData().g() - 148.0f) / 2);
                                                qSearchEmptyItemAttr2.mo141height(148.0f);
                                                qSearchEmptyItemAttr2.alignItemsCenter();
                                                EcommerceExtKt.elementVR(qSearchEmptyItemAttr2, "em_search_no_result_card", e.this);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                Function1<ViewContainer<?, ?>, Unit> appendEmptyView = QSearchTabContentView.this.appendEmptyView(emptyOrErrorViewReportParams);
                                if (appendEmptyView != null) {
                                    appendEmptyView.invoke(viewContainer3);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        eCRefreshListViewAttr2.errorViewBuilder = QSearchTabContentView.access$createErrorView(QSearchTabContentView.this);
                        eCRefreshListViewAttr2.buttonBgColor = QUISkinColor.INSTANCE.wrapColor("brand_standard");
                        QSearchTabContentView qSearchTabContentView5 = QSearchTabContentView.this;
                        eCRefreshListViewAttr2.footerViewBuilder = qSearchTabContentView5.createFooterView(qSearchTabContentView5.getEmptyOrErrorViewReportParams(QSearchTabContentView.access$getAttr(qSearchTabContentView5).getKeyword(), QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().repo.currentTraceId, null));
                        return Unit.INSTANCE;
                    }
                });
                final QSearchTabContentView qSearchTabContentView4 = QSearchTabContentView.this;
                eCRefreshListView2.event(new Function1<ECRefreshListViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECRefreshListViewEvent eCRefreshListViewEvent) {
                        final ECRefreshListViewEvent eCRefreshListViewEvent2 = eCRefreshListViewEvent;
                        final QSearchTabContentView qSearchTabContentView5 = QSearchTabContentView.this;
                        eCRefreshListViewEvent2.refreshHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.3.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().loadData(QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword(), QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getQuerySource(), false, null);
                                return Unit.INSTANCE;
                            }
                        };
                        final QSearchTabContentView qSearchTabContentView6 = QSearchTabContentView.this;
                        eCRefreshListViewEvent2.loadMoreHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.3.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                QSearchTabContentViewModel.loadMoreData$default(QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel(), null, 1, null);
                                return Unit.INSTANCE;
                            }
                        };
                        final QSearchTabContentView qSearchTabContentView7 = QSearchTabContentView.this;
                        eCRefreshListViewEvent2.retryHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.3.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().loadData(QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword(), QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getQuerySource(), false, null);
                                return Unit.INSTANCE;
                            }
                        };
                        final QSearchTabContentView qSearchTabContentView8 = QSearchTabContentView.this;
                        eCRefreshListViewEvent2.dragBeginHandler = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollParams scrollParams) {
                                ScrollParams scrollParams2 = scrollParams;
                                QSearchTabContentView qSearchTabContentView9 = QSearchTabContentView.this;
                                qSearchTabContentView9.userScrolling$delegate.setValue(qSearchTabContentView9, QSearchTabContentView.$$delegatedProperties[0], Boolean.TRUE);
                                Function1<? super ScrollParams, Unit> function1 = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).dragBeginHandler;
                                if (function1 != null) {
                                    function1.invoke(scrollParams2);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        final QSearchTabContentView qSearchTabContentView9 = QSearchTabContentView.this;
                        eCRefreshListViewEvent2.scrollEndHandler = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.3.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollParams scrollParams) {
                                QSearchTabContentView qSearchTabContentView10 = QSearchTabContentView.this;
                                qSearchTabContentView10.userScrolling$delegate.setValue(qSearchTabContentView10, QSearchTabContentView.$$delegatedProperties[0], Boolean.FALSE);
                                if (eCRefreshListViewEvent2.getPager().getPageData().getIsIOS()) {
                                    QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().playVideoInNextTickIfNeed();
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        return Unit.INSTANCE;
                    }
                });
                final QSearchTabContentView qSearchTabContentView5 = QSearchTabContentView.this;
                eCRefreshListView2.itemViewBuilder = new Function2<ViewContainer<?, ?>, ISearchItemModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(ViewContainer<?, ?> viewContainer2, ISearchItemModel iSearchItemModel) {
                        final ISearchItemModel iSearchItemModel2 = iSearchItemModel;
                        final int indexOf = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().getDataList().indexOf(iSearchItemModel2);
                        final QSearchTabContentView qSearchTabContentView6 = QSearchTabContentView.this;
                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.mo113backgroundColor(h.INSTANCE.j());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchTabContentView qSearchTabContentView7 = QSearchTabContentView.this;
                                final int i3 = indexOf;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.4.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final u uVar2 = uVar;
                                        final QSearchTabContentView qSearchTabContentView8 = QSearchTabContentView.this;
                                        final int i16 = i3;
                                        VisibilityEventKt.a(uVar2, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.body.1.1.4.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Float f16) {
                                                float floatValue = f16.floatValue();
                                                QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().itemViewVisiblePercentMap.put(Integer.valueOf(i16), Float.valueOf(floatValue));
                                                if (!uVar2.getPager().getPageData().getIsIOS() || !QSearchTabContentView.this.getUserScrolling()) {
                                                    QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().playVideoInNextTickIfNeed();
                                                }
                                                if (floatValue > 0.5f && i16 > QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().getDataList().size() - 10 && Intrinsics.areEqual(QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().getListState(), RefreshListState.Idle.INSTANCE)) {
                                                    QSearchTabContentViewModel.loadMoreData$default(QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel(), null, 1, null);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchTabContentView qSearchTabContentView8 = QSearchTabContentView.this;
                                final ISearchItemModel iSearchItemModel3 = iSearchItemModel2;
                                qSearchTabContentView8.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configCorrectionQueryItem$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                        final ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                                        if (iSearchItemModel4 instanceof SearchCorrectionQueryCardItemModel) {
                                            final QSearchTabContentView qSearchTabContentView9 = qSearchTabContentView8;
                                            viewContainer4.addChild(new QSearchCorrectionQueryItemView(), new Function1<QSearchCorrectionQueryItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configCorrectionQueryItem$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView) {
                                                    QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView2 = qSearchCorrectionQueryItemView;
                                                    final ISearchItemModel iSearchItemModel5 = ISearchItemModel.this;
                                                    final QSearchTabContentView qSearchTabContentView10 = qSearchTabContentView9;
                                                    qSearchCorrectionQueryItemView2.attr(new Function1<QSearchCorrectionQueryItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configCorrectionQueryItem.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchCorrectionQueryItemAttr qSearchCorrectionQueryItemAttr) {
                                                            QSearchCorrectionQueryItemAttr qSearchCorrectionQueryItemAttr2 = qSearchCorrectionQueryItemAttr;
                                                            String str = ((SearchCorrectionQueryCardItemModel) ISearchItemModel.this).correctionQuery;
                                                            ReadWriteProperty readWriteProperty = qSearchCorrectionQueryItemAttr2.correctionQuery$delegate;
                                                            KProperty<?>[] kPropertyArr = QSearchCorrectionQueryItemAttr.$$delegatedProperties;
                                                            readWriteProperty.setValue(qSearchCorrectionQueryItemAttr2, kPropertyArr[0], str);
                                                            qSearchCorrectionQueryItemAttr2.keyWord$delegate.setValue(qSearchCorrectionQueryItemAttr2, kPropertyArr[1], ((SearchCorrectionQueryCardItemModel) ISearchItemModel.this).keyWord);
                                                            QSearchTabContentView qSearchTabContentView11 = qSearchTabContentView10;
                                                            qSearchCorrectionQueryItemAttr2.reportParams = qSearchTabContentView11.getCorrectionQueryViewReportParams(QSearchTabContentView.access$getAttr(qSearchTabContentView11).getKeyword(), QSearchTabContentView.access$getAttr(qSearchTabContentView10).getViewModel().repo.currentTraceId, ((SearchCorrectionQueryCardItemModel) ISearchItemModel.this).correctionQuery);
                                                            qSearchCorrectionQueryItemAttr2.marginBottom(qSearchTabContentView10.correctionItemMarginBottom());
                                                            QSearchTabContentView qSearchTabContentView12 = qSearchTabContentView10;
                                                            EcommerceExtKt.elementVR(qSearchCorrectionQueryItemAttr2, "em_bas_error_correction_prompt", qSearchTabContentView12.getCorrectionQueryViewReportParams(QSearchTabContentView.access$getAttr(qSearchTabContentView12).getKeyword(), QSearchTabContentView.access$getAttr(qSearchTabContentView10).getViewModel().repo.currentTraceId, ((SearchCorrectionQueryCardItemModel) ISearchItemModel.this).correctionQuery));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QSearchTabContentView qSearchTabContentView11 = qSearchTabContentView9;
                                                    qSearchCorrectionQueryItemView2.event(new Function1<QSearchCorrectionQueryItemEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configCorrectionQueryItem.1.1.2

                                                        /* compiled from: P */
                                                        /* renamed from: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configCorrectionQueryItem$1$1$2$1, reason: invalid class name and collision with other inner class name */
                                                        /* loaded from: classes32.dex */
                                                        public final class C49971 extends Lambda implements Function1<String, Unit> {
                                                            public final /* synthetic */ QSearchTabContentView $ctx;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            public C49971(QSearchTabContentView qSearchTabContentView) {
                                                                super(1);
                                                                this.$ctx = qSearchTabContentView;
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(String str) {
                                                                String str2 = str;
                                                                QSearchTabContentView.access$getAttr(this.$ctx).getViewModel().reset();
                                                                QSearchTabContentView.access$getAttr(this.$ctx).getViewModel().disableCorrectionQuery = true;
                                                                k notifyModule = Utils.INSTANCE.notifyModule("");
                                                                e eVar = new e();
                                                                eVar.w("disable_correction_query", true);
                                                                Unit unit = Unit.INSTANCE;
                                                                k.d(notifyModule, "update_disable_correction_query", eVar, false, 4, null);
                                                                if (str2 != null) {
                                                                    QSearchTabContentView.access$getAttr(this.$ctx).getViewModel().loadData(str2, QSearchTabContentView.access$getAttr(this.$ctx).getQuerySource(), true, null);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }

                                                        /* compiled from: P */
                                                        /* renamed from: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configCorrectionQueryItem$1$1$2$2, reason: invalid class name and collision with other inner class name */
                                                        /* loaded from: classes32.dex */
                                                        public final class C49982 extends Lambda implements Function1<String, Unit> {
                                                            public final /* synthetic */ QSearchTabContentView $ctx;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            public C49982(QSearchTabContentView qSearchTabContentView) {
                                                                super(1);
                                                                this.$ctx = qSearchTabContentView;
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(String str) {
                                                                String str2 = str;
                                                                QSearchTabContentView.access$getAttr(this.$ctx).getViewModel().reset();
                                                                QSearchTabContentView.access$getAttr(this.$ctx).getViewModel().disableCorrectionQuery = true;
                                                                k notifyModule = Utils.INSTANCE.notifyModule("");
                                                                e eVar = new e();
                                                                eVar.w("disable_correction_query", true);
                                                                eVar.v("correction_key_word", str2);
                                                                Unit unit = Unit.INSTANCE;
                                                                k.d(notifyModule, "update_click_correction_query", eVar, false, 4, null);
                                                                if (str2 != null) {
                                                                    QSearchTabContentView.access$getAttr(this.$ctx).getViewModel().loadData(str2, QSearchTabContentView.access$getAttr(this.$ctx).getQuerySource(), true, null);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }

                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchCorrectionQueryItemEvent qSearchCorrectionQueryItemEvent) {
                                                            QSearchCorrectionQueryItemEvent qSearchCorrectionQueryItemEvent2 = qSearchCorrectionQueryItemEvent;
                                                            qSearchCorrectionQueryItemEvent2.onClickCancelModifyEvent = new C49971(QSearchTabContentView.this);
                                                            qSearchCorrectionQueryItemEvent2.onClickCorrectionQueryEvent = new C49982(QSearchTabContentView.this);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(vVar2);
                                QSearchTabContentView.this.configItemView(iSearchItemModel2, indexOf).invoke(vVar2);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
