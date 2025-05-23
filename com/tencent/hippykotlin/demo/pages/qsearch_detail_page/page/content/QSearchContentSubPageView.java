package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.ITabPager;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.SubPageName;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchContactTabContentView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchExpressionTabContentView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchMiniAppTabContentView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.SearchNetApi;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchPageListAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchPageListEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchPageListEvent$addDragEndListener$1;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchPageListView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.config.impl.QCircleDynamicNameApiImpl;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes32.dex */
public final class QSearchContentSubPageView extends QSearchDetailBaseSubPage<QSearchContentSubPageAttr, QSearchContentSubPageEvent> implements ITabPager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchContentSubPageView.class, "refTabName", "getRefTabName()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/data/pb/UnifySearchTabInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchContentSubPageView.class, "tabClickedIndex", "getTabClickedIndex()I", 0)};
    public aa<QSearchCategoryView> categoryViewRef;
    public QSearchContentViewModel contentViewModel;
    public aa<QSearchPageListView> pageListRef;
    public final ReadWriteProperty refTabName$delegate = c.a(null);
    public final ReadWriteProperty tabClickedIndex$delegate = c.a(-1);

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$configTabContentAttr(final QSearchContentSubPageView qSearchContentSubPageView, QSearchTabContentAttr qSearchTabContentAttr, UnifySearchTabInfo unifySearchTabInfo) {
        QSearchContentViewModel qSearchContentViewModel = qSearchContentSubPageView.contentViewModel;
        QSearchContentViewModel qSearchContentViewModel2 = null;
        if (qSearchContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel = null;
        }
        qSearchTabContentAttr.index = qSearchContentViewModel.getTabTypeList().indexOf(unifySearchTabInfo);
        String keyword = ((QSearchContentSubPageAttr) qSearchContentSubPageView.getAttr()).getViewModel().getKeyword();
        ReadWriteProperty readWriteProperty = qSearchTabContentAttr.keyword$delegate;
        KProperty<?>[] kPropertyArr = QSearchTabContentAttr.$$delegatedProperties;
        readWriteProperty.setValue(qSearchTabContentAttr, kPropertyArr[1], keyword);
        qSearchTabContentAttr.querySource$delegate.setValue(qSearchTabContentAttr, kPropertyArr[2], Integer.valueOf(((QSearchContentSubPageAttr) qSearchContentSubPageView.getAttr()).getViewModel().querySource));
        QSearchContentViewModel qSearchContentViewModel3 = qSearchContentSubPageView.contentViewModel;
        if (qSearchContentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel3 = null;
        }
        qSearchTabContentAttr.currentTabIndex$delegate.setValue(qSearchTabContentAttr, kPropertyArr[0], Integer.valueOf(qSearchContentViewModel3.getCurrentIndex()));
        qSearchTabContentAttr.tabData = unifySearchTabInfo;
        QSearchContentViewModel qSearchContentViewModel4 = qSearchContentSubPageView.contentViewModel;
        if (qSearchContentViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
        } else {
            qSearchContentViewModel2 = qSearchContentViewModel4;
        }
        qSearchTabContentAttr.viewModel = qSearchContentViewModel2.getTabContentViewModel(unifySearchTabInfo);
        qSearchTabContentAttr.muted$delegate.setValue(qSearchTabContentAttr, kPropertyArr[3], Boolean.valueOf(((QSearchContentSubPageAttr) qSearchContentSubPageView.getAttr()).getViewModel().getMuted()));
        qSearchTabContentAttr.pageStatus$delegate.setValue(qSearchTabContentAttr, kPropertyArr[4], ((QSearchContentSubPageAttr) qSearchContentSubPageView.getAttr()).getViewModel().getPageStatus());
        QSearchDetailViewModel viewModel = ((QSearchContentSubPageAttr) qSearchContentSubPageView.getAttr()).getViewModel();
        qSearchTabContentAttr.pageWidth$delegate.setValue(qSearchTabContentAttr, kPropertyArr[5], Double.valueOf(((Number) viewModel.pageWidth$delegate.getValue(viewModel, QSearchDetailViewModel.$$delegatedProperties[5])).doubleValue()));
        qSearchTabContentAttr.dragBeginHandler = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView$configTabContentAttr$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ScrollParams scrollParams) {
                QSearchContentSubPageView.this.hideKeyboard();
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchContentSubPageAttr access$getAttr(QSearchContentSubPageView qSearchContentSubPageView) {
        return (QSearchContentSubPageAttr) qSearchContentSubPageView.getAttr();
    }

    public static final void access$handleTabSwitch(QSearchContentSubPageView qSearchContentSubPageView, int i3) {
        Object orNull;
        QSearchContentViewModel qSearchContentViewModel = qSearchContentSubPageView.contentViewModel;
        QSearchContentViewModel qSearchContentViewModel2 = null;
        if (qSearchContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel = null;
        }
        if (i3 != qSearchContentViewModel.getCurrentIndex()) {
            if (qSearchContentSubPageView.getTabClickedIndex() < 0) {
                QSearchContentViewModel qSearchContentViewModel3 = qSearchContentSubPageView.contentViewModel;
                if (qSearchContentViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                    qSearchContentViewModel3 = null;
                }
                com.tencent.kuikly.core.reactive.collection.c<UnifySearchTabInfo> tabTypeList = qSearchContentViewModel3.getTabTypeList();
                QSearchContentViewModel qSearchContentViewModel4 = qSearchContentSubPageView.contentViewModel;
                if (qSearchContentViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                    qSearchContentViewModel4 = null;
                }
                orNull = CollectionsKt___CollectionsKt.getOrNull(tabTypeList, qSearchContentViewModel4.getCurrentIndex());
                qSearchContentSubPageView.refTabName$delegate.setValue(qSearchContentSubPageView, $$delegatedProperties[0], (UnifySearchTabInfo) orNull);
            }
            QSearchContentViewModel qSearchContentViewModel5 = qSearchContentSubPageView.contentViewModel;
            if (qSearchContentViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            } else {
                qSearchContentViewModel2 = qSearchContentViewModel5;
            }
            qSearchContentViewModel2.currentIndex$delegate.setValue(qSearchContentViewModel2, QSearchContentViewModel.$$delegatedProperties[1], Integer.valueOf(i3));
        }
        qSearchContentSubPageView.hideKeyboard();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ViewContainer<?, ?> viewContainer2 = viewContainer;
                QSearchContentViewModel qSearchContentViewModel = QSearchContentSubPageView.this.contentViewModel;
                if (qSearchContentViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                    qSearchContentViewModel = null;
                }
                if (!qSearchContentViewModel.hideTab) {
                    final QSearchContentSubPageView qSearchContentSubPageView = QSearchContentSubPageView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView$body$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final QSearchContentSubPageView qSearchContentSubPageView2 = QSearchContentSubPageView.this;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.mo153width(tVar2.getPagerData().m());
                                    tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(16.0f) + 56.0f);
                                    tVar2.paddingBottom(11.0f);
                                    if (!QSearchContentSubPageView.access$getAttr(QSearchContentSubPageView.this).getViewModel().isVasTheme()) {
                                        tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_primary"));
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            final QSearchContentSubPageView qSearchContentSubPageView3 = QSearchContentSubPageView.this;
                            vVar2.addChild(new QSearchCategoryView(), new Function1<QSearchCategoryView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.1.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchCategoryView qSearchCategoryView) {
                                    QSearchCategoryView qSearchCategoryView2 = qSearchCategoryView;
                                    final QSearchContentSubPageView qSearchContentSubPageView4 = QSearchContentSubPageView.this;
                                    qSearchCategoryView2.ref(qSearchCategoryView2, new Function1<aa<QSearchCategoryView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.1.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(aa<QSearchCategoryView> aaVar) {
                                            QSearchContentSubPageView.this.categoryViewRef = aaVar;
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QSearchContentSubPageView qSearchContentSubPageView5 = QSearchContentSubPageView.this;
                                    qSearchCategoryView2.attr(new Function1<QSearchCategoryAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.1.2.2

                                        /* renamed from: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView$body$1$1$2$2$2, reason: invalid class name and collision with other inner class name */
                                        /* loaded from: classes32.dex */
                                        public final class C47412 extends Lambda implements Function3<ce, Integer, Integer, Unit> {
                                            public static final C47412 INSTANCE = new C47412();

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(ce ceVar, Integer num, Integer num2) {
                                                ce ceVar2 = ceVar;
                                                if (num.intValue() == num2.intValue()) {
                                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                                    ceVar2.fontWeight500();
                                                } else {
                                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                    ceVar2.fontWeight400();
                                                }
                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                return Unit.INSTANCE;
                                            }

                                            public C47412() {
                                                super(3);
                                            }
                                        }

                                        /* renamed from: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView$body$1$1$2$2$3, reason: invalid class name */
                                        /* loaded from: classes32.dex */
                                        public final class AnonymousClass3 extends Lambda implements Function3<m, Integer, Integer, Unit> {
                                            public final /* synthetic */ QSearchContentSubPageView $ctx;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            public AnonymousClass3(QSearchContentSubPageView qSearchContentSubPageView) {
                                                super(3);
                                                this.$ctx = qSearchContentSubPageView;
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(m mVar, Integer num, Integer num2) {
                                                m mVar2 = mVar;
                                                int intValue = num.intValue();
                                                num2.intValue();
                                                mVar2.paddingLeft(28.0f);
                                                QSearchContentViewModel qSearchContentViewModel = this.$ctx.contentViewModel;
                                                if (qSearchContentViewModel == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                                    qSearchContentViewModel = null;
                                                }
                                                if (intValue == qSearchContentViewModel.getTabTypeList().size() - 1) {
                                                    mVar2.paddingRight(28.0f);
                                                } else {
                                                    mVar2.paddingRight(0.0f);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }

                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchCategoryAttr qSearchCategoryAttr) {
                                            int collectionSizeOrDefault;
                                            QSearchCategoryAttr qSearchCategoryAttr2 = qSearchCategoryAttr;
                                            qSearchCategoryAttr2.m140flex(1.0f);
                                            qSearchCategoryAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(16.0f) + 25.0f);
                                            qSearchCategoryAttr2.marginTop(15.0f);
                                            QSearchContentViewModel qSearchContentViewModel2 = QSearchContentSubPageView.this.contentViewModel;
                                            QSearchContentViewModel qSearchContentViewModel3 = null;
                                            if (qSearchContentViewModel2 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                                qSearchContentViewModel2 = null;
                                            }
                                            com.tencent.kuikly.core.reactive.collection.c<UnifySearchTabInfo> tabTypeList = qSearchContentViewModel2.getTabTypeList();
                                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(tabTypeList, 10);
                                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                            Iterator<UnifySearchTabInfo> it = tabTypeList.iterator();
                                            while (it.hasNext()) {
                                                arrayList.add(it.next().tabName);
                                            }
                                            qSearchCategoryAttr2.getItemTitles().clear();
                                            qSearchCategoryAttr2.getItemTitles().addAll(arrayList);
                                            QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                                            h color$default = QUIToken.color$default("brand_standard");
                                            QSearchCategoryAttr.IndicatorStyle indicatorStyle = qSearchCategoryAttr2.indicatorStyle;
                                            indicatorStyle.color = color$default;
                                            indicatorStyle.height = 2.0f;
                                            indicatorStyle.margin = 5.0f;
                                            QSearchContentViewModel qSearchContentViewModel4 = QSearchContentSubPageView.this.contentViewModel;
                                            if (qSearchContentViewModel4 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                            } else {
                                                qSearchContentViewModel3 = qSearchContentViewModel4;
                                            }
                                            qSearchCategoryAttr2.currentIndex$delegate.setValue(qSearchCategoryAttr2, QSearchCategoryAttr.$$delegatedProperties[1], Integer.valueOf(qSearchContentViewModel3.getCurrentIndex()));
                                            qSearchCategoryAttr2.textViewStyle = C47412.INSTANCE;
                                            qSearchCategoryAttr2.tabViewStyle = new AnonymousClass3(QSearchContentSubPageView.this);
                                            qSearchCategoryAttr2.autoScrollExtDistance = 28.0f;
                                            qSearchCategoryAttr2.useScrollableIndicator = qSearchCategoryAttr2.getPager().getPageData().getIsAndroid();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QSearchContentSubPageView qSearchContentSubPageView6 = QSearchContentSubPageView.this;
                                    qSearchCategoryView2.event(new Function1<QSearchCategoryEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.1.2.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchCategoryEvent qSearchCategoryEvent) {
                                            QSearchCategoryEvent qSearchCategoryEvent2 = qSearchCategoryEvent;
                                            final QSearchContentSubPageView qSearchContentSubPageView7 = QSearchContentSubPageView.this;
                                            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.1.2.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Integer num) {
                                                    int intValue = num.intValue();
                                                    QSearchContentSubPageView.access$handleTabSwitch(QSearchContentSubPageView.this, intValue);
                                                    QSearchContentSubPageView qSearchContentSubPageView8 = QSearchContentSubPageView.this;
                                                    qSearchContentSubPageView8.tabClickedIndex$delegate.setValue(qSearchContentSubPageView8, QSearchContentSubPageView.$$delegatedProperties[1], Integer.valueOf(intValue));
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            qSearchCategoryEvent2.getClass();
                                            qSearchCategoryEvent2.registerEvent("clickCategorySwitch", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryEvent$clickCategorySwitch$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj) {
                                                    Function1<Integer, Unit> function12 = function1;
                                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                                    function12.invoke((Integer) obj);
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
                }
                final QSearchContentSubPageView qSearchContentSubPageView2 = QSearchContentSubPageView.this;
                viewContainer2.addChild(new QSearchPageListView(), new Function1<QSearchPageListView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QSearchPageListView qSearchPageListView) {
                        QSearchPageListView qSearchPageListView2 = qSearchPageListView;
                        final QSearchContentSubPageView qSearchContentSubPageView3 = QSearchContentSubPageView.this;
                        qSearchPageListView2.ref(qSearchPageListView2, new Function1<aa<QSearchPageListView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<QSearchPageListView> aaVar) {
                                final QSearchCategoryView b16;
                                aa<QSearchPageListView> aaVar2 = aaVar;
                                QSearchContentSubPageView qSearchContentSubPageView4 = QSearchContentSubPageView.this;
                                qSearchContentSubPageView4.pageListRef = aaVar2;
                                aa<QSearchCategoryView> aaVar3 = qSearchContentSubPageView4.categoryViewRef;
                                if (aaVar3 != null && (b16 = aaVar3.b()) != null) {
                                    QSearchPageListView b17 = aaVar2.b();
                                    b16.pageListView = b17;
                                    if (b17 != null) {
                                        b17.event(new Function1<QSearchPageListEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView$bindPageListView$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchPageListEvent qSearchPageListEvent) {
                                                boolean z16;
                                                QSearchPageListEvent qSearchPageListEvent2 = qSearchPageListEvent;
                                                z16 = ((QSearchCategoryAttr) QSearchCategoryView.this.getAttr()).useScrollableIndicator;
                                                if (z16) {
                                                    final QSearchCategoryView qSearchCategoryView = QSearchCategoryView.this;
                                                    qSearchPageListEvent2.addScrollListener(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView$bindPageListView$1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ScrollParams scrollParams) {
                                                            QSearchCategoryView qSearchCategoryView2 = QSearchCategoryView.this;
                                                            qSearchCategoryView2.scrollParam = scrollParams;
                                                            QSearchCategoryView.access$updateIndicatorOffset(qSearchCategoryView2);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QSearchCategoryView qSearchCategoryView2 = QSearchCategoryView.this;
                                                    qSearchPageListEvent2.addScrollEndListener(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView$bindPageListView$1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ScrollParams scrollParams) {
                                                            QSearchCategoryView qSearchCategoryView3 = QSearchCategoryView.this;
                                                            KProperty<Object>[] kPropertyArr = QSearchCategoryView.$$delegatedProperties;
                                                            qSearchCategoryView3.getClass();
                                                            QSearchCategoryView qSearchCategoryView4 = QSearchCategoryView.this;
                                                            qSearchCategoryView4.scrollParam = scrollParams;
                                                            QSearchCategoryView.access$updateIndicatorOffset(qSearchCategoryView4);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                                final QSearchCategoryView qSearchCategoryView3 = QSearchCategoryView.this;
                                                qSearchPageListEvent2.addPageChangeListener(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView$bindPageListView$1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        QSearchCategoryView qSearchCategoryView4 = QSearchCategoryView.this;
                                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                                        QSearchCategoryView.access$tryScrollToEnsureCurTabVisible(qSearchCategoryView4, ((Integer) obj).intValue());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchCategoryView qSearchCategoryView4 = QSearchCategoryView.this;
                                                qSearchPageListEvent2.addDragBeginListener(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchCategoryView$bindPageListView$1.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                        QSearchCategoryView qSearchCategoryView5 = QSearchCategoryView.this;
                                                        KProperty<Object>[] kPropertyArr = QSearchCategoryView.$$delegatedProperties;
                                                        qSearchCategoryView5.getClass();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchContentSubPageView qSearchContentSubPageView4 = QSearchContentSubPageView.this;
                        qSearchPageListView2.attr(new Function1<QSearchPageListAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchPageListAttr qSearchPageListAttr) {
                                QSearchPageListAttr qSearchPageListAttr2 = qSearchPageListAttr;
                                qSearchPageListAttr2.m140flex(1.0f);
                                qSearchPageListAttr2.pageItemWidth(qSearchPageListAttr2.getPager().getPageData().m());
                                qSearchPageListAttr2.pageDirection(true);
                                qSearchPageListAttr2.showScrollerIndicator(false);
                                QSearchContentViewModel qSearchContentViewModel2 = null;
                                ScrollerAttr.bouncesEnable$default(qSearchPageListAttr2, false, false, 2, null);
                                QSearchContentViewModel qSearchContentViewModel3 = QSearchContentSubPageView.this.contentViewModel;
                                if (qSearchContentViewModel3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                    qSearchContentViewModel3 = null;
                                }
                                qSearchPageListAttr2.scrollEnable(!qSearchContentViewModel3.hideTab);
                                qSearchPageListAttr2.setKeepItemAlive(true);
                                QSearchContentViewModel qSearchContentViewModel4 = QSearchContentSubPageView.this.contentViewModel;
                                if (qSearchContentViewModel4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                    qSearchContentViewModel4 = null;
                                }
                                qSearchPageListAttr2.defaultPageIndex(qSearchContentViewModel4.getCurrentIndex());
                                QSearchContentViewModel qSearchContentViewModel5 = QSearchContentSubPageView.this.contentViewModel;
                                if (qSearchContentViewModel5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                } else {
                                    qSearchContentViewModel2 = qSearchContentViewModel5;
                                }
                                qSearchPageListAttr2.firstContentLoadMaxIndex(qSearchContentViewModel2.getTabTypeList().size());
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchContentSubPageView qSearchContentSubPageView5 = QSearchContentSubPageView.this;
                        qSearchPageListView2.event(new Function1<QSearchPageListEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.3
                            {
                                super(1);
                            }

                            /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<kotlin.jvm.functions.Function1<com.tencent.kuikly.core.views.bn, kotlin.Unit>>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List<kotlin.jvm.functions.Function1<com.tencent.kuikly.core.views.bn, kotlin.Unit>>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchPageListEvent qSearchPageListEvent) {
                                QSearchPageListEvent qSearchPageListEvent2 = qSearchPageListEvent;
                                final QSearchContentSubPageView qSearchContentSubPageView6 = QSearchContentSubPageView.this;
                                qSearchPageListEvent2.addPageChangeListener(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        QSearchContentSubPageView qSearchContentSubPageView7 = QSearchContentSubPageView.this;
                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                        QSearchContentSubPageView.access$handleTabSwitch(qSearchContentSubPageView7, ((Integer) obj).intValue());
                                        QSearchContentSubPageView qSearchContentSubPageView8 = QSearchContentSubPageView.this;
                                        int intValue = ((Number) obj).intValue();
                                        QSearchContentViewModel qSearchContentViewModel2 = null;
                                        if (qSearchContentSubPageView8.getTabClickedIndex() >= 0) {
                                            if (qSearchContentSubPageView8.getTabClickedIndex() == intValue) {
                                                QSearchContentViewModel qSearchContentViewModel3 = qSearchContentSubPageView8.contentViewModel;
                                                if (qSearchContentViewModel3 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                                } else {
                                                    qSearchContentViewModel2 = qSearchContentViewModel3;
                                                }
                                                qSearchContentViewModel2.getCurrentIndex();
                                                qSearchContentSubPageView8.reportAbnormalEvent(true);
                                                qSearchContentSubPageView8.tabClickedIndex$delegate.setValue(qSearchContentSubPageView8, QSearchContentSubPageView.$$delegatedProperties[1], -1);
                                            }
                                        } else {
                                            QSearchContentViewModel qSearchContentViewModel4 = qSearchContentSubPageView8.contentViewModel;
                                            if (qSearchContentViewModel4 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                            } else {
                                                qSearchContentViewModel2 = qSearchContentViewModel4;
                                            }
                                            qSearchContentViewModel2.getCurrentIndex();
                                            qSearchContentSubPageView8.reportAbnormalEvent(true);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchContentSubPageView qSearchContentSubPageView7 = QSearchContentSubPageView.this;
                                qSearchPageListEvent2.addScrollListener(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        QSearchContentViewModel qSearchContentViewModel2 = QSearchContentSubPageView.this.contentViewModel;
                                        QSearchContentViewModel qSearchContentViewModel3 = null;
                                        if (qSearchContentViewModel2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                            qSearchContentViewModel2 = null;
                                        }
                                        if (!qSearchContentViewModel2.isPagerScrolling()) {
                                            QSearchContentViewModel qSearchContentViewModel4 = QSearchContentSubPageView.this.contentViewModel;
                                            if (qSearchContentViewModel4 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                            } else {
                                                qSearchContentViewModel3 = qSearchContentViewModel4;
                                            }
                                            qSearchContentViewModel3.isPagerScrolling$delegate.setValue(qSearchContentViewModel3, QSearchContentViewModel.$$delegatedProperties[2], Boolean.TRUE);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchContentSubPageView qSearchContentSubPageView8 = QSearchContentSubPageView.this;
                                qSearchPageListEvent2.addScrollEndListener(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        QSearchContentViewModel qSearchContentViewModel2 = QSearchContentSubPageView.this.contentViewModel;
                                        if (qSearchContentViewModel2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                            qSearchContentViewModel2 = null;
                                        }
                                        qSearchContentViewModel2.isPagerScrolling$delegate.setValue(qSearchContentViewModel2, QSearchContentViewModel.$$delegatedProperties[2], Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchContentSubPageView qSearchContentSubPageView9 = QSearchContentSubPageView.this;
                                qSearchPageListEvent2.addDragBeginListener(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        QSearchContentViewModel qSearchContentViewModel2 = QSearchContentSubPageView.this.contentViewModel;
                                        if (qSearchContentViewModel2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                            qSearchContentViewModel2 = null;
                                        }
                                        qSearchContentViewModel2.isPagerDragging$delegate.setValue(qSearchContentViewModel2, QSearchContentViewModel.$$delegatedProperties[3], Boolean.TRUE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchContentSubPageView qSearchContentSubPageView10 = QSearchContentSubPageView.this;
                                Function1<ScrollParams, Unit> function1 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.3.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        QSearchContentViewModel qSearchContentViewModel2 = QSearchContentSubPageView.this.contentViewModel;
                                        if (qSearchContentViewModel2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                            qSearchContentViewModel2 = null;
                                        }
                                        qSearchContentViewModel2.isPagerDragging$delegate.setValue(qSearchContentViewModel2, QSearchContentViewModel.$$delegatedProperties[3], Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                };
                                if (qSearchPageListEvent2.innerDragEndHandler == null) {
                                    QSearchPageListEvent$addDragEndListener$1 qSearchPageListEvent$addDragEndListener$1 = new QSearchPageListEvent$addDragEndListener$1(qSearchPageListEvent2);
                                    qSearchPageListEvent2.innerDragEndHandler = qSearchPageListEvent$addDragEndListener$1;
                                    Intrinsics.checkNotNull(qSearchPageListEvent$addDragEndListener$1);
                                    qSearchPageListEvent2.dragEnd(qSearchPageListEvent$addDragEndListener$1);
                                }
                                if (!qSearchPageListEvent2.dragEndListeners.contains(function1)) {
                                    qSearchPageListEvent2.dragEndListeners.add(function1);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchContentSubPageView qSearchContentSubPageView6 = QSearchContentSubPageView.this;
                        Function0<com.tencent.kuikly.core.reactive.collection.c<UnifySearchTabInfo>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<UnifySearchTabInfo>>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final com.tencent.kuikly.core.reactive.collection.c<UnifySearchTabInfo> invoke() {
                                QSearchContentViewModel qSearchContentViewModel2 = QSearchContentSubPageView.this.contentViewModel;
                                if (qSearchContentViewModel2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                                    qSearchContentViewModel2 = null;
                                }
                                return qSearchContentViewModel2.getTabTypeList();
                            }
                        };
                        final QSearchContentSubPageView qSearchContentSubPageView7 = QSearchContentSubPageView.this;
                        LoopDirectivesViewKt.a(qSearchPageListView2, function0, new Function2<LoopDirectivesView<UnifySearchTabInfo>, UnifySearchTabInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<UnifySearchTabInfo> loopDirectivesView, UnifySearchTabInfo unifySearchTabInfo) {
                                LoopDirectivesView<UnifySearchTabInfo> loopDirectivesView2 = loopDirectivesView;
                                final UnifySearchTabInfo unifySearchTabInfo2 = unifySearchTabInfo;
                                int i3 = (int) unifySearchTabInfo2.tabMask;
                                if (i3 == 3) {
                                    final QSearchContentSubPageView qSearchContentSubPageView8 = QSearchContentSubPageView.this;
                                    loopDirectivesView2.addChild(new QSearchGuildTabContentView(), new Function1<QSearchGuildTabContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchGuildTabContentView qSearchGuildTabContentView) {
                                            final QSearchContentSubPageView qSearchContentSubPageView9 = QSearchContentSubPageView.this;
                                            final UnifySearchTabInfo unifySearchTabInfo3 = unifySearchTabInfo2;
                                            qSearchGuildTabContentView.attr(new Function1<QSearchTabContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchTabContentAttr qSearchTabContentAttr) {
                                                    QSearchContentSubPageView.access$configTabContentAttr(QSearchContentSubPageView.this, qSearchTabContentAttr, unifySearchTabInfo3);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (i3 == 4) {
                                    final QSearchContentSubPageView qSearchContentSubPageView9 = QSearchContentSubPageView.this;
                                    loopDirectivesView2.addChild(new QSearchExpressionTabContentView(), new Function1<QSearchExpressionTabContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchExpressionTabContentView qSearchExpressionTabContentView) {
                                            final QSearchContentSubPageView qSearchContentSubPageView10 = QSearchContentSubPageView.this;
                                            final UnifySearchTabInfo unifySearchTabInfo3 = unifySearchTabInfo2;
                                            qSearchExpressionTabContentView.attr(new Function1<QSearchTabContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchTabContentAttr qSearchTabContentAttr) {
                                                    QSearchContentSubPageView.access$configTabContentAttr(QSearchContentSubPageView.this, qSearchTabContentAttr, unifySearchTabInfo3);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (i3 == 5) {
                                    final QSearchContentSubPageView qSearchContentSubPageView10 = QSearchContentSubPageView.this;
                                    loopDirectivesView2.addChild(new QSearchContactTabContentView(), new Function1<QSearchContactTabContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchContactTabContentView qSearchContactTabContentView) {
                                            final QSearchContentSubPageView qSearchContentSubPageView11 = QSearchContentSubPageView.this;
                                            final UnifySearchTabInfo unifySearchTabInfo3 = unifySearchTabInfo2;
                                            qSearchContactTabContentView.attr(new Function1<QSearchTabContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchTabContentAttr qSearchTabContentAttr) {
                                                    QSearchContentSubPageView.access$configTabContentAttr(QSearchContentSubPageView.this, qSearchTabContentAttr, unifySearchTabInfo3);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (i3 == 6) {
                                    final QSearchContentSubPageView qSearchContentSubPageView11 = QSearchContentSubPageView.this;
                                    loopDirectivesView2.addChild(new QSearchTroopTabContentView(), new Function1<QSearchTroopTabContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchTroopTabContentView qSearchTroopTabContentView) {
                                            final QSearchContentSubPageView qSearchContentSubPageView12 = QSearchContentSubPageView.this;
                                            final UnifySearchTabInfo unifySearchTabInfo3 = unifySearchTabInfo2;
                                            qSearchTroopTabContentView.attr(new Function1<QSearchTabContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchTabContentAttr qSearchTabContentAttr) {
                                                    QSearchContentSubPageView.access$configTabContentAttr(QSearchContentSubPageView.this, qSearchTabContentAttr, unifySearchTabInfo3);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (i3 == 7) {
                                    final QSearchContentSubPageView qSearchContentSubPageView12 = QSearchContentSubPageView.this;
                                    loopDirectivesView2.addChild(new QSearchMiniAppTabContentView(), new Function1<QSearchMiniAppTabContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchMiniAppTabContentView qSearchMiniAppTabContentView) {
                                            final QSearchContentSubPageView qSearchContentSubPageView13 = QSearchContentSubPageView.this;
                                            final UnifySearchTabInfo unifySearchTabInfo3 = unifySearchTabInfo2;
                                            qSearchMiniAppTabContentView.attr(new Function1<QSearchTabContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.5.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchTabContentAttr qSearchTabContentAttr) {
                                                    QSearchContentSubPageView.access$configTabContentAttr(QSearchContentSubPageView.this, qSearchTabContentAttr, unifySearchTabInfo3);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (i3 != 9) {
                                    final QSearchContentSubPageView qSearchContentSubPageView13 = QSearchContentSubPageView.this;
                                    loopDirectivesView2.addChild(new QSearchTabContentView(), new Function1<QSearchTabContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.7
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchTabContentView qSearchTabContentView) {
                                            final QSearchContentSubPageView qSearchContentSubPageView14 = QSearchContentSubPageView.this;
                                            final UnifySearchTabInfo unifySearchTabInfo3 = unifySearchTabInfo2;
                                            qSearchTabContentView.attr(new Function1<QSearchTabContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.7.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchTabContentAttr qSearchTabContentAttr) {
                                                    QSearchContentSubPageView.access$configTabContentAttr(QSearchContentSubPageView.this, qSearchTabContentAttr, unifySearchTabInfo3);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    final QSearchContentSubPageView qSearchContentSubPageView14 = QSearchContentSubPageView.this;
                                    loopDirectivesView2.addChild(new QSearchDaZiTabContentView(), new Function1<QSearchDaZiTabContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.6
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchDaZiTabContentView qSearchDaZiTabContentView) {
                                            final QSearchContentSubPageView qSearchContentSubPageView15 = QSearchContentSubPageView.this;
                                            final UnifySearchTabInfo unifySearchTabInfo3 = unifySearchTabInfo2;
                                            qSearchDaZiTabContentView.attr(new Function1<QSearchTabContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.2.5.6.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchTabContentAttr qSearchTabContentAttr) {
                                                    QSearchContentSubPageView.access$configTabContentAttr(QSearchContentSubPageView.this, qSearchTabContentAttr, unifySearchTabInfo3);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(viewContainer2.getPager().getPageData().getIsIOS());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                        tVar2.mo113backgroundColor(h.INSTANCE.j());
                                        tVar2.mo153width(20.0f);
                                        tVar2.mo141height(tVar2.getPagerData().l());
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.4.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView.body.1.4.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
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
        return new QSearchContentSubPageAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchContentSubPageEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage
    public final SubPageName getSubPageName() {
        return SubPageName.CONTENT;
    }

    public final int getTabClickedIndex() {
        return ((Number) this.tabClickedIndex$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.ITabPager
    public final boolean hasTab(int i3) {
        int collectionSizeOrDefault;
        QSearchContentViewModel qSearchContentViewModel = this.contentViewModel;
        if (qSearchContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel = null;
        }
        com.tencent.kuikly.core.reactive.collection.c<UnifySearchTabInfo> tabTypeList = qSearchContentViewModel.getTabTypeList();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(tabTypeList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<UnifySearchTabInfo> it = tabTypeList.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf((int) it.next().tabMask));
        }
        return arrayList.contains(Integer.valueOf(i3));
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.ITabPager
    public final void jumpToTab(int i3) {
        aa<QSearchPageListView> aaVar;
        QSearchPageListView b16;
        int collectionSizeOrDefault;
        QSearchContentViewModel qSearchContentViewModel = this.contentViewModel;
        QSearchContentViewModel qSearchContentViewModel2 = null;
        if (qSearchContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel = null;
        }
        if (qSearchContentViewModel.hideTab || (aaVar = this.pageListRef) == null || (b16 = aaVar.b()) == null) {
            return;
        }
        QSearchContentViewModel qSearchContentViewModel3 = this.contentViewModel;
        if (qSearchContentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
        } else {
            qSearchContentViewModel2 = qSearchContentViewModel3;
        }
        com.tencent.kuikly.core.reactive.collection.c<UnifySearchTabInfo> tabTypeList = qSearchContentViewModel2.getTabTypeList();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(tabTypeList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<UnifySearchTabInfo> it = tabTypeList.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf((int) it.next().tabMask));
        }
        int indexOf = arrayList.indexOf(Integer.valueOf(i3));
        if (indexOf >= 0) {
            ScrollerView.setContentOffset$default(b16, b16.getPager().getPageData().m() * indexOf, 0.0f, false, null, 8, null);
            return;
        }
        Utils.INSTANCE.logToNative("QSearchContentSubPageView #jumpToTab tabType=" + i3 + " not exist");
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage
    public final void pageDidAppear() {
        k.b(Utils.INSTANCE.notifyModule(""), "update_click_correction_query", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView$pageDidAppear$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    QSearchContentSubPageView qSearchContentSubPageView = QSearchContentSubPageView.this;
                    QSearchContentSubPageView.access$getAttr(qSearchContentSubPageView).getViewModel().setKeyword(eVar2.p("correction_key_word"));
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        QSearchContentViewModel qSearchContentViewModel = this.contentViewModel;
        QSearchContentViewModel qSearchContentViewModel2 = null;
        if (qSearchContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel = null;
        }
        QSearchContentViewModel qSearchContentViewModel3 = this.contentViewModel;
        if (qSearchContentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
        } else {
            qSearchContentViewModel2 = qSearchContentViewModel3;
        }
        QSearchTabContentViewModel tabContentViewModel = qSearchContentViewModel.getTabContentViewModel(qSearchContentViewModel2.getCurrentIndex());
        if (tabContentViewModel != null) {
            tabContentViewModel.playVideoInNextTickIfNeed();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage
    public final void pageDidDisappear() {
        QSearchContentViewModel qSearchContentViewModel = this.contentViewModel;
        QSearchContentViewModel qSearchContentViewModel2 = null;
        if (qSearchContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel = null;
        }
        QSearchContentViewModel qSearchContentViewModel3 = this.contentViewModel;
        if (qSearchContentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
        } else {
            qSearchContentViewModel2 = qSearchContentViewModel3;
        }
        QSearchTabContentViewModel tabContentViewModel = qSearchContentViewModel.getTabContentViewModel(qSearchContentViewModel2.getCurrentIndex());
        if (tabContentViewModel != null) {
            tabContentViewModel.setPlayIndex(-2);
            tabContentViewModel.needPlayVideo = false;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage
    public final void pageWillDestroy() {
        QSearchContentViewModel qSearchContentViewModel = this.contentViewModel;
        QSearchContentViewModel qSearchContentViewModel2 = null;
        if (qSearchContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel = null;
        }
        QSearchContentViewModel qSearchContentViewModel3 = this.contentViewModel;
        if (qSearchContentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
        } else {
            qSearchContentViewModel2 = qSearchContentViewModel3;
        }
        QSearchTabContentViewModel tabContentViewModel = qSearchContentViewModel.getTabContentViewModel(qSearchContentViewModel2.getCurrentIndex());
        if (tabContentViewModel != null) {
            tabContentViewModel.setPlayIndex(-1);
            tabContentViewModel.needPlayVideo = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void reportAbnormalEvent(boolean z16) {
        String str;
        String str2;
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE", "pageId", "pg_qq_network_search_result_level2_page");
        m3.v("xsj_custom_pgid", "pg_qq_network_search_result_level2_page");
        m3.v("xsj_eid", "em_search_top_tab");
        QSearchContentViewModel qSearchContentViewModel = this.contentViewModel;
        if (qSearchContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel = null;
        }
        UnifySearchTabInfo currentTabInfo = qSearchContentViewModel.getCurrentTabInfo();
        String str3 = "";
        if (currentTabInfo == null || (str = currentTabInfo.tabName) == null) {
            str = "";
        }
        m3.v("tab_name", str);
        QSearchContentViewModel qSearchContentViewModel2 = this.contentViewModel;
        if (qSearchContentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel2 = null;
        }
        UnifySearchTabInfo currentTabInfo2 = qSearchContentViewModel2.getCurrentTabInfo();
        m3.t("tab_mask", currentTabInfo2 != null ? (int) currentTabInfo2.tabMask : 0);
        UnifySearchTabInfo unifySearchTabInfo = (UnifySearchTabInfo) this.refTabName$delegate.getValue(this, $$delegatedProperties[0]);
        if (unifySearchTabInfo != null && (str2 = unifySearchTabInfo.tabName) != null) {
            str3 = str2;
        }
        m3.v("ref_tab_name", str3);
        m3.v("search_query_text", ((QSearchContentSubPageAttr) getAttr()).getViewModel().getKeyword());
        QSearchContentViewModel qSearchContentViewModel3 = this.contentViewModel;
        if (qSearchContentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel3 = null;
        }
        UnifySearchTabInfo currentTabInfo3 = qSearchContentViewModel3.getCurrentTabInfo();
        if (currentTabInfo3 != null) {
            QSearchContentViewModel qSearchContentViewModel4 = this.contentViewModel;
            if (qSearchContentViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
                qSearchContentViewModel4 = null;
            }
            m3.v("search_trace_id", qSearchContentViewModel4.getTabContentViewModel(currentTabInfo3).repo.currentTraceId);
        }
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        if (iSearchReport != null) {
            m3.v("query_source", String.valueOf(iSearchReport.getQuerySource()));
            m3.v("user_source", String.valueOf(iSearchReport.getUserSource()));
        }
        Utils utils = Utils.INSTANCE;
        utils.currentBridgeModule().reportCustomDtEvent("ev_xsj_abnormal_imp", m3);
        if (z16) {
            utils.currentBridgeModule().reportCustomDtEvent("ev_xsj_abnormal_clck", m3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        QSearchContentViewModel qSearchContentViewModel;
        String str;
        QSearchContentViewModel qSearchContentViewModel2;
        com.tencent.kuikly.core.reactive.collection.c<UnifySearchTabInfo> cVar;
        com.tencent.kuikly.core.nvi.serialization.json.b bVar;
        QSearchContentViewModel qSearchContentViewModel3;
        final QSearchContentSubPageView qSearchContentSubPageView = this;
        qSearchContentSubPageView.contentViewModel = ((QSearchContentSubPageAttr) getAttr()).getViewModel().getContentPageViewModel();
        super.created();
        QSearchContentViewModel qSearchContentViewModel4 = qSearchContentSubPageView.contentViewModel;
        if (qSearchContentViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewModel");
            qSearchContentViewModel = null;
        } else {
            qSearchContentViewModel = qSearchContentViewModel4;
        }
        final int i3 = ((QSearchContentSubPageAttr) getAttr()).getViewModel().querySource;
        final boolean isSendReqByOIDB = SearchNetApi.INSTANCE.isSendReqByOIDB();
        boolean isAndroid = getPager().getPageData().getIsAndroid();
        if (qSearchContentViewModel.hideTab && qSearchContentViewModel.initTab > 0) {
            str = "contentViewModel";
        } else {
            com.tencent.kuikly.core.reactive.collection.c<UnifySearchTabInfo> tabTypeList = qSearchContentViewModel.getTabTypeList();
            ArrayList arrayList = new ArrayList();
            String item = Utils.INSTANCE.cacheModule("").getItem("search_tab_infos");
            if (!(item.length() == 0)) {
                str = "contentViewModel";
                qSearchContentViewModel2 = qSearchContentViewModel;
                cVar = tabTypeList;
                try {
                    bVar = new com.tencent.kuikly.core.nvi.serialization.json.b(item);
                } catch (JSONException e16) {
                    Utils.INSTANCE.logToNative("QSearchStorageUtil #getTabInfo:" + e16);
                    bVar = null;
                }
                if (bVar != null) {
                    int c16 = bVar.c();
                    for (int i16 = 0; i16 < c16; i16++) {
                        e l3 = bVar.l(i16);
                        if (l3 != null) {
                            arrayList.add(new UnifySearchTabInfo(l3.q("tab_name", ""), l3.o("tab_mask", 0L)));
                        }
                    }
                }
            } else {
                UnifySearchTabInfo unifySearchTabInfo = new UnifySearchTabInfo("\u5168\u90e8", 1L);
                UnifySearchTabInfo unifySearchTabInfo2 = new UnifySearchTabInfo("\u7528\u6237", 5L);
                UnifySearchTabInfo unifySearchTabInfo3 = new UnifySearchTabInfo("\u7fa4\u804a", 6L);
                qSearchContentViewModel2 = qSearchContentViewModel;
                UnifySearchTabInfo unifySearchTabInfo4 = new UnifySearchTabInfo("\u9891\u9053", 3L);
                cVar = tabTypeList;
                UnifySearchTabInfo unifySearchTabInfo5 = new UnifySearchTabInfo("\u8868\u60c5", 4L);
                UnifySearchTabInfo unifySearchTabInfo6 = new UnifySearchTabInfo("\u673a\u5668\u4eba", 10L);
                str = "contentViewModel";
                UnifySearchTabInfo unifySearchTabInfo7 = new UnifySearchTabInfo(QCircleDynamicNameApiImpl.ORIGIN_OLD_NAME, 2L);
                arrayList.add(unifySearchTabInfo);
                arrayList.add(unifySearchTabInfo2);
                arrayList.add(unifySearchTabInfo3);
                arrayList.add(unifySearchTabInfo4);
                arrayList.add(unifySearchTabInfo5);
                arrayList.add(unifySearchTabInfo6);
                arrayList.add(unifySearchTabInfo7);
            }
            cVar.addAll(arrayList);
            if (isAndroid) {
                qSearchContentViewModel2.fetchNetTabs(i3, isSendReqByOIDB);
            } else {
                final QSearchContentViewModel qSearchContentViewModel5 = qSearchContentViewModel2;
                TimerKt.d(1500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentViewModel$fetchTabs$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        QSearchContentViewModel.this.fetchNetTabs(i3, isSendReqByOIDB);
                        return Unit.INSTANCE;
                    }
                });
            }
            qSearchContentSubPageView = this;
        }
        QSearchContentViewModel qSearchContentViewModel6 = qSearchContentSubPageView.contentViewModel;
        if (qSearchContentViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            qSearchContentViewModel3 = null;
        } else {
            qSearchContentViewModel3 = qSearchContentViewModel6;
        }
        qSearchContentViewModel3.getCurrentIndex();
        qSearchContentSubPageView.reportAbnormalEvent(false);
        getPager().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView$created$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QSearchContentSubPageView.this.hideKeyboard();
                return Unit.INSTANCE;
            }
        });
    }
}
