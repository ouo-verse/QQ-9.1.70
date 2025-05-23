package com.tencent.hippykotlin.demo.pages.qsearch_detail_page;

import c01.c;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.SearchBar;
import com.tencent.hippykotlin.demo.pages.base.SearchBar$showKeyboard$1;
import com.tencent.hippykotlin.demo.pages.base.SearchBarAttr;
import com.tencent.hippykotlin.demo.pages.base.SearchBarEvent;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.module.QQPermissionModule;
import com.tencent.hippykotlin.demo.pages.base.view.AccessibilityRichTextView;
import com.tencent.hippykotlin.demo.pages.base.view.AccessibilityTextView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentSubPageView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchTabNetRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistoryContentAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistoryContentEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistorySubPageView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistoryViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsContentAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsContentEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchChainReporter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchMiniAppCache;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchPagePerfReporter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.SearchNetApi;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.IDialogPager;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.f;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import defpackage.k;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes32.dex */
public final class QSearchDetailPage extends BasePager implements ISearchReport, ITabPager, IDialogPager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDetailPage.class, "hint", "getHint()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDetailPage.class, "showDialog", "getShowDialog()Z", 0)};
    public aa<QSearchContentSubPageView> contentSubPageRef;
    public Function1<? super ViewContainer<?, ?>, Unit> dialogBuilder;
    public aa<SearchBar> searchBarRef;
    public final QSearchDetailViewModel viewModel = new QSearchDetailViewModel();
    public final ReadWriteProperty hint$delegate = c.b();
    public final ReadWriteProperty showDialog$delegate = c.a(Boolean.FALSE);

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QSearchDetailPage qSearchDetailPage = QSearchDetailPage.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        e eVar = new e();
                        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
                        eVar.v("pageId", "pg_qq_network_search_result_level2_page");
                        eVar.t("user_source", QSearchDetailPage.this.viewModel.userSource);
                        Unit unit = Unit.INSTANCE;
                        EcommerceExtKt.pageVR(mVar2, "pg_qq_network_search_result_level2_page", eVar);
                        return Unit.INSTANCE;
                    }
                });
                final QSearchDetailPage qSearchDetailPage2 = QSearchDetailPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QSearchDetailPage qSearchDetailPage3 = QSearchDetailPage.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(tVar2.getPagerData().getStatusBarHeight() + 60.0f);
                                tVar2.paddingTop(tVar2.getPagerData().getStatusBarHeight());
                                if (!QSearchDetailPage.this.viewModel.isVasTheme()) {
                                    tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_primary"));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchDetailPage qSearchDetailPage4 = QSearchDetailPage.this;
                        vVar2.addChild(new SearchBar(), new Function1<SearchBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(SearchBar searchBar) {
                                SearchBar searchBar2 = searchBar;
                                final QSearchDetailPage qSearchDetailPage5 = QSearchDetailPage.this;
                                searchBar2.ref(searchBar2, new Function1<aa<SearchBar>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<SearchBar> aaVar) {
                                        boolean isBlank;
                                        boolean isBlank2;
                                        final QSearchDetailPage qSearchDetailPage6 = QSearchDetailPage.this;
                                        qSearchDetailPage6.searchBarRef = aaVar;
                                        String q16 = qSearchDetailPage6.getPageData().n().q("hint", "");
                                        isBlank = StringsKt__StringsJVMKt.isBlank(q16);
                                        if (!(!isBlank)) {
                                            isBlank2 = StringsKt__StringsJVMKt.isBlank(qSearchDetailPage6.getPageData().n().q("keyword", ""));
                                            if (isBlank2) {
                                                TimerKt.c(500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$initHint$2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        SearchBar b16;
                                                        aa<SearchBar> aaVar2 = QSearchDetailPage.this.searchBarRef;
                                                        if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                                                            b16.performTaskWhenRenderViewDidLoad(new SearchBar$showKeyboard$1(b16));
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            }
                                        } else {
                                            try {
                                                Utils utils = Utils.INSTANCE;
                                                String urlDecode = utils.currentBridgeModule().urlDecode(q16);
                                                qSearchDetailPage6.getHint().clear();
                                                qSearchDetailPage6.getHint().add(urlDecode);
                                                TimerKt.c(500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$initHint$1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        SearchBar b16;
                                                        aa<SearchBar> aaVar2 = QSearchDetailPage.this.searchBarRef;
                                                        if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                                                            b16.performTaskWhenRenderViewDidLoad(new SearchBar$showKeyboard$1(b16));
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                utils.logToNative("QSearchDetailPage beryl created. paramHint: " + urlDecode);
                                            } catch (Exception e16) {
                                                Utils.INSTANCE.logToNative("QSearchDetailPage [init] beryl error: " + e16);
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchDetailPage qSearchDetailPage6 = QSearchDetailPage.this;
                                searchBar2.attr(new Function1<SearchBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(SearchBarAttr searchBarAttr) {
                                        SearchBarAttr searchBarAttr2 = searchBarAttr;
                                        QSearchDetailPage qSearchDetailPage7 = QSearchDetailPage.this;
                                        KProperty<Object>[] kPropertyArr = QSearchDetailPage.$$delegatedProperties;
                                        searchBarAttr2.hint$delegate.setValue(searchBarAttr2, SearchBarAttr.$$delegatedProperties[0], qSearchDetailPage7.getHint());
                                        searchBarAttr2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchDetailPage qSearchDetailPage7 = QSearchDetailPage.this;
                                searchBar2.event(new Function1<SearchBarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.2.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(SearchBarEvent searchBarEvent) {
                                        final SearchBarEvent searchBarEvent2 = searchBarEvent;
                                        final QSearchDetailPage qSearchDetailPage8 = QSearchDetailPage.this;
                                        searchBarEvent2.onClickSearch = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.2.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                boolean isBlank;
                                                boolean isBlank2;
                                                SearchBar b16;
                                                String str = obj instanceof String ? (String) obj : null;
                                                String str2 = "";
                                                if (str == null) {
                                                    str = "";
                                                }
                                                if (!(str.length() == 0)) {
                                                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                                                    if (!isBlank) {
                                                        QSearchDetailPage qSearchDetailPage9 = QSearchDetailPage.this;
                                                        KProperty<Object>[] kPropertyArr = QSearchDetailPage.$$delegatedProperties;
                                                        qSearchDetailPage9.searchText(str, 2);
                                                    }
                                                } else {
                                                    QSearchDetailPage qSearchDetailPage10 = QSearchDetailPage.this;
                                                    KProperty<Object>[] kPropertyArr2 = QSearchDetailPage.$$delegatedProperties;
                                                    if (!qSearchDetailPage10.getHint().isEmpty()) {
                                                        str2 = qSearchDetailPage10.getHint().get(0);
                                                    }
                                                    isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                                                    if (!isBlank2) {
                                                        aa<SearchBar> aaVar = QSearchDetailPage.this.searchBarRef;
                                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                            b16.setText(str2);
                                                        }
                                                        QSearchDetailPage.this.searchText(str2, 21);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final QSearchDetailPage qSearchDetailPage9 = QSearchDetailPage.this;
                                        FrameEventKt.f(searchBarEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.2.2.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                SearchBar b16;
                                                if (QSearchDetailPage.this.viewModel.getKeyword().length() > 50) {
                                                    QSearchDetailPage.this.viewModel.getKeyword();
                                                    QSearchDetailViewModel qSearchDetailViewModel = QSearchDetailPage.this.viewModel;
                                                    String substring = qSearchDetailViewModel.getKeyword().substring(0, 50);
                                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                    qSearchDetailViewModel.setKeyword(substring);
                                                }
                                                aa<SearchBar> aaVar = QSearchDetailPage.this.searchBarRef;
                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                    b16.setText(QSearchDetailPage.this.viewModel.getKeyword());
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchDetailPage qSearchDetailPage10 = QSearchDetailPage.this;
                                        searchBarEvent2.onClickCancel = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.2.2.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                SearchBar b16;
                                                aa<SearchBar> aaVar = QSearchDetailPage.this.searchBarRef;
                                                if (aaVar == null || (b16 = aaVar.b()) == null) {
                                                    return null;
                                                }
                                                AbstractBaseView.callRenderViewMethod$default(b16, IECSearchBar.METHOD_ON_CANCEL_RESULT, String.valueOf(QSearchDetailPage.this.viewModel.closeType), null, 4, null);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final QSearchDetailPage qSearchDetailPage11 = QSearchDetailPage.this;
                                        searchBarEvent2.onClickBack = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.2.2.3.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                SearchBar b16;
                                                SubPageName currentPage = QSearchDetailPage.this.viewModel.getCurrentPage();
                                                SubPageName subPageName = SubPageName.CONTENT;
                                                if (currentPage != subPageName) {
                                                    if (QSearchDetailPage.this.viewModel.getKeyword().length() > 0) {
                                                        aa<SearchBar> aaVar = QSearchDetailPage.this.searchBarRef;
                                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                            b16.setText(QSearchDetailPage.this.viewModel.getKeyword());
                                                        }
                                                        QSearchDetailPage.this.hideKeyboard();
                                                        QSearchDetailPage.this.viewModel.setCurrentPage(subPageName);
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                                BridgeModule.closePage$default(IPagerIdKtxKt.getBridgeModule(searchBarEvent2), null, null, 3);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final QSearchDetailPage qSearchDetailPage12 = QSearchDetailPage.this;
                                        searchBarEvent2.onTextChanged = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.2.2.3.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                QSearchDetailViewModel qSearchDetailViewModel = QSearchDetailPage.this.viewModel;
                                                String str = obj instanceof String ? (String) obj : null;
                                                if (str == null) {
                                                    str = "";
                                                }
                                                qSearchDetailViewModel.inputText$delegate.setValue(qSearchDetailViewModel, QSearchDetailViewModel.$$delegatedProperties[2], str);
                                                if (QSearchDetailPage.this.viewModel.getInputText().length() == 0) {
                                                    QSearchDetailPage.this.viewModel.setCurrentPage(SubPageName.HISTORY);
                                                } else if (QSearchDetailPage.this.viewModel.getCurrentPage() != SubPageName.CONTENT || !Intrinsics.areEqual(QSearchDetailPage.this.viewModel.getInputText(), QSearchDetailPage.this.viewModel.getKeyword())) {
                                                    QSearchDetailPage.this.viewModel.setCurrentPage(SubPageName.SUG_WORD);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QSearchDetailPage qSearchDetailPage3 = QSearchDetailPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchDetailPage qSearchDetailPage4 = QSearchDetailPage.this;
                        vVar2.addChild(new QSearchContentSubPageView(), new Function1<QSearchContentSubPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchContentSubPageView qSearchContentSubPageView) {
                                QSearchContentSubPageView qSearchContentSubPageView2 = qSearchContentSubPageView;
                                final QSearchDetailPage qSearchDetailPage5 = QSearchDetailPage.this;
                                qSearchContentSubPageView2.ref(qSearchContentSubPageView2, new Function1<aa<QSearchContentSubPageView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<QSearchContentSubPageView> aaVar) {
                                        QSearchDetailPage.this.contentSubPageRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchDetailPage qSearchDetailPage6 = QSearchDetailPage.this;
                                qSearchContentSubPageView2.attr(new Function1<QSearchContentSubPageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchContentSubPageAttr qSearchContentSubPageAttr) {
                                        QSearchContentSubPageAttr qSearchContentSubPageAttr2 = qSearchContentSubPageAttr;
                                        qSearchContentSubPageAttr2.viewModel = QSearchDetailPage.this.viewModel;
                                        qSearchContentSubPageAttr2.m140flex(1.0f);
                                        qSearchContentSubPageAttr2.m152visibility(QSearchDetailPage.this.viewModel.getCurrentPage() == SubPageName.CONTENT);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchDetailPage qSearchDetailPage5 = QSearchDetailPage.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QSearchDetailPage.this.viewModel.getCurrentPage() == SubPageName.SUG_WORD);
                            }
                        };
                        final QSearchDetailPage qSearchDetailPage6 = QSearchDetailPage.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final QSearchDetailPage qSearchDetailPage7 = QSearchDetailPage.this;
                                conditionView.addChild(new QSearchSugWordsSubPageView(), new Function1<QSearchSugWordsSubPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchSugWordsSubPageView qSearchSugWordsSubPageView) {
                                        QSearchSugWordsSubPageView qSearchSugWordsSubPageView2 = qSearchSugWordsSubPageView;
                                        final QSearchDetailPage qSearchDetailPage8 = QSearchDetailPage.this;
                                        qSearchSugWordsSubPageView2.attr(new Function1<QSearchSugWordsContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchSugWordsContentAttr qSearchSugWordsContentAttr) {
                                                QSearchSugWordsContentAttr qSearchSugWordsContentAttr2 = qSearchSugWordsContentAttr;
                                                qSearchSugWordsContentAttr2.absolutePositionAllZero();
                                                QSearchDetailViewModel qSearchDetailViewModel = QSearchDetailPage.this.viewModel;
                                                qSearchSugWordsContentAttr2.viewModel = qSearchDetailViewModel;
                                                UnifySearchTabInfo currentTabInfo = qSearchDetailViewModel.getContentPageViewModel().getCurrentTabInfo();
                                                if (currentTabInfo == null) {
                                                    currentTabInfo = new UnifySearchTabInfo("", 0L);
                                                }
                                                qSearchSugWordsContentAttr2.tabData = currentTabInfo;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchDetailPage qSearchDetailPage9 = QSearchDetailPage.this;
                                        qSearchSugWordsSubPageView2.event(new Function1<QSearchSugWordsContentEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.4.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchSugWordsContentEvent qSearchSugWordsContentEvent) {
                                                QSearchSugWordsContentEvent qSearchSugWordsContentEvent2 = qSearchSugWordsContentEvent;
                                                final QSearchDetailPage qSearchDetailPage10 = QSearchDetailPage.this;
                                                final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.4.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(String str) {
                                                        SearchBar b16;
                                                        String str2 = str;
                                                        QSearchDetailPage qSearchDetailPage11 = QSearchDetailPage.this;
                                                        KProperty<Object>[] kPropertyArr = QSearchDetailPage.$$delegatedProperties;
                                                        qSearchDetailPage11.searchText(str2, 7);
                                                        aa<SearchBar> aaVar = QSearchDetailPage.this.searchBarRef;
                                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                            b16.setText(str2);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                qSearchSugWordsContentEvent2.getClass();
                                                qSearchSugWordsContentEvent2.registerEvent("clickSugWord", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsContentEvent$clickSugWord$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        Function1<String, Unit> function12 = function1;
                                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                                        function12.invoke((String) obj);
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
                        final QSearchDetailPage qSearchDetailPage7 = QSearchDetailPage.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QSearchDetailPage.this.viewModel.getCurrentPage() == SubPageName.HISTORY);
                            }
                        };
                        final QSearchDetailPage qSearchDetailPage8 = QSearchDetailPage.this;
                        ConditionViewKt.b(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final QSearchDetailPage qSearchDetailPage9 = QSearchDetailPage.this;
                                conditionView.addChild(new QSearchHistorySubPageView(), new Function1<QSearchHistorySubPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchHistorySubPageView qSearchHistorySubPageView) {
                                        QSearchHistorySubPageView qSearchHistorySubPageView2 = qSearchHistorySubPageView;
                                        final QSearchDetailPage qSearchDetailPage10 = QSearchDetailPage.this;
                                        qSearchHistorySubPageView2.attr(new Function1<QSearchHistoryContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.6.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchHistoryContentAttr qSearchHistoryContentAttr) {
                                                QSearchHistoryContentAttr qSearchHistoryContentAttr2 = qSearchHistoryContentAttr;
                                                qSearchHistoryContentAttr2.absolutePositionAllZero();
                                                QSearchDetailViewModel qSearchDetailViewModel = QSearchDetailPage.this.viewModel;
                                                qSearchHistoryContentAttr2.viewModel = qSearchDetailViewModel;
                                                UnifySearchTabInfo currentTabInfo = qSearchDetailViewModel.getContentPageViewModel().getCurrentTabInfo();
                                                if (currentTabInfo == null) {
                                                    currentTabInfo = new UnifySearchTabInfo("", 0L);
                                                }
                                                qSearchHistoryContentAttr2.tabData = currentTabInfo;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchDetailPage qSearchDetailPage11 = QSearchDetailPage.this;
                                        qSearchHistorySubPageView2.event(new Function1<QSearchHistoryContentEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.6.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchHistoryContentEvent qSearchHistoryContentEvent) {
                                                QSearchHistoryContentEvent qSearchHistoryContentEvent2 = qSearchHistoryContentEvent;
                                                final QSearchDetailPage qSearchDetailPage12 = QSearchDetailPage.this;
                                                final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage.body.1.3.6.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(String str) {
                                                        SearchBar b16;
                                                        String str2 = str;
                                                        QSearchDetailPage qSearchDetailPage13 = QSearchDetailPage.this;
                                                        KProperty<Object>[] kPropertyArr = QSearchDetailPage.$$delegatedProperties;
                                                        qSearchDetailPage13.searchText(str2, 6);
                                                        aa<SearchBar> aaVar = QSearchDetailPage.this.searchBarRef;
                                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                            b16.setText(str2);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                qSearchHistoryContentEvent2.getClass();
                                                qSearchHistoryContentEvent2.registerEvent("clickHistoryWord", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistoryContentEvent$clickHistoryWord$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        Function1<String, Unit> function12 = function1;
                                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                                        function12.invoke((String) obj);
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
                final QSearchDetailPage qSearchDetailPage4 = QSearchDetailPage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        QSearchDetailPage qSearchDetailPage5 = QSearchDetailPage.this;
                        return Boolean.valueOf(((Boolean) qSearchDetailPage5.showDialog$delegate.getValue(qSearchDetailPage5, QSearchDetailPage.$$delegatedProperties[1])).booleanValue());
                    }
                };
                final QSearchDetailPage qSearchDetailPage5 = QSearchDetailPage.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        Function1<? super ViewContainer<?, ?>, Unit> function1 = QSearchDetailPage.this.dialogBuilder;
                        if (function1 != null) {
                            function1.invoke(conditionView2);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        boolean isBlank;
        registerViewCreator("TextView", new f() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$registerDefaultAccessibilityForTextComponent$1
            @Override // com.tencent.kuikly.core.pager.f
            public final DeclarativeBaseView<?, ?> createView() {
                return new AccessibilityTextView();
            }
        });
        registerViewCreator("RichTextView", new f() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$registerDefaultAccessibilityForTextComponent$2
            @Override // com.tencent.kuikly.core.pager.f
            public final DeclarativeBaseView<?, ?> createView() {
                return new AccessibilityRichTextView();
            }
        });
        super.created();
        final QSearchDetailViewModel qSearchDetailViewModel = this.viewModel;
        g pageData = getPageData();
        qSearchDetailViewModel.pageData = pageData;
        qSearchDetailViewModel.useOIDBReq = SearchNetApi.INSTANCE.isSendReqByOIDB();
        QSearchPagePerfReporter qSearchPagePerfReporter = qSearchDetailViewModel.perfReporter;
        qSearchPagePerfReporter.getClass();
        Utils utils = Utils.INSTANCE;
        qSearchPagePerfReporter.startTime = utils.currentBridgeModule().currentTimeStamp();
        String p16 = pageData.n().p("keyword");
        isBlank = StringsKt__StringsJVMKt.isBlank(p16);
        if (!isBlank) {
            try {
                qSearchDetailViewModel.setKeyword(utils.currentBridgeModule().urlDecode(p16));
            } catch (Exception e16) {
                Utils.INSTANCE.logToNative("QSearchDetailViewModel [init] error: " + e16);
            }
        }
        if ((qSearchDetailViewModel.getKeyword().length() == 0) != false) {
            qSearchDetailViewModel.setCurrentPage(SubPageName.HISTORY);
        }
        if (pageData.n().a("sessionId")) {
            qSearchDetailViewModel.sessionId = pageData.n().p("sessionId");
        } else {
            e n3 = pageData.n();
            String lowerCase = "sessionId".toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            if (n3.a(lowerCase)) {
                e n16 = pageData.n();
                String lowerCase2 = "sessionId".toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                qSearchDetailViewModel.sessionId = n16.p(lowerCase2);
            }
        }
        QSearchChainReporter.INSTANCE.updateSearchStartTime(pageData.n().o("start_search_stamp", Utils.INSTANCE.currentBridgeModule().currentTimeStamp()), qSearchDetailViewModel.getKeyword(), true);
        if (pageData.n().a(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE)) {
            qSearchDetailViewModel.querySource = pageData.n().k(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, 2);
        } else {
            e n17 = pageData.n();
            String lowerCase3 = QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
            if (n17.a(lowerCase3)) {
                e n18 = pageData.n();
                String lowerCase4 = QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase()");
                qSearchDetailViewModel.querySource = n18.k(lowerCase4, 2);
            }
        }
        if (pageData.n().a("close_self")) {
            qSearchDetailViewModel.closeType = pageData.n().g("close_self", false) ? 1 : 0;
        }
        g gVar = qSearchDetailViewModel.pageData;
        QSearchTabNetRepo qSearchTabNetRepo = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            gVar = null;
        }
        int j3 = gVar.n().j("user_source");
        if (j3 <= 0) {
            int i3 = qSearchDetailViewModel.querySource;
            int i16 = i3 != 1 ? i3 != 3 ? 0 : 6 : 1;
            g gVar2 = qSearchDetailViewModel.pageData;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                gVar2 = null;
            }
            gVar2.n().t("user_source", i16);
            j3 = i16;
        }
        qSearchDetailViewModel.userSource = j3;
        qSearchDetailViewModel.repo = new QSearchTabNetRepo(pageData);
        QSearchTabNetRepo qSearchTabNetRepo2 = qSearchDetailViewModel.repo;
        if (qSearchTabNetRepo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        } else {
            qSearchTabNetRepo = qSearchTabNetRepo2;
        }
        qSearchDetailViewModel.contentPageViewModel = new QSearchContentViewModel(qSearchTabNetRepo, pageData, qSearchDetailViewModel.perfReporter, qSearchDetailViewModel.useOIDBReq);
        qSearchDetailViewModel.subWordPageViewModel = new QSearchSugWordsViewModel();
        final QSearchHistoryViewModel qSearchHistoryViewModel = new QSearchHistoryViewModel(qSearchDetailViewModel.userSource);
        ReactiveObserver.INSTANCE.b(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel$init$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return QSearchDetailViewModel.this.getKeyword();
            }
        }, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel$init$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                boolean isBlank2;
                bool.booleanValue();
                isBlank2 = StringsKt__StringsJVMKt.isBlank(QSearchDetailViewModel.this.getKeyword());
                if (!isBlank2) {
                    QSearchHistoryViewModel qSearchHistoryViewModel2 = qSearchHistoryViewModel;
                    String keyword = QSearchDetailViewModel.this.getKeyword();
                    if (qSearchHistoryViewModel2.getDataList().contains(keyword)) {
                        qSearchHistoryViewModel2.getDataList().remove(keyword);
                    }
                    qSearchHistoryViewModel2.getDataList().add(0, keyword);
                    int size = qSearchHistoryViewModel2.getDataList().size();
                    if (size > qSearchHistoryViewModel2.historiesMaxCount) {
                        qSearchHistoryViewModel2.getDataList().remove(size - 1);
                    }
                    qSearchHistoryViewModel2.syncStorage();
                }
                return Unit.INSTANCE;
            }
        });
        qSearchDetailViewModel.historyPageViewModel = qSearchHistoryViewModel;
    }

    public final com.tencent.kuikly.core.reactive.collection.c<String> getHint() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.hint$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport
    public final int getQuerySource() {
        return this.viewModel.querySource;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport
    public final String getSessionId() {
        return this.viewModel.sessionId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport
    public final String getTabName(int i3) {
        Iterator<UnifySearchTabInfo> it = this.viewModel.getContentPageViewModel().getTabTypeList().iterator();
        while (it.hasNext()) {
            UnifySearchTabInfo next = it.next();
            if (((int) next.tabMask) == i3) {
                return next.tabName;
            }
        }
        return "";
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport
    public final int getUserSource() {
        return this.viewModel.userSource;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.ITabPager
    public final boolean hasTab(int i3) {
        QSearchContentSubPageView b16;
        aa<QSearchContentSubPageView> aaVar = this.contentSubPageRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return false;
        }
        return b16.hasTab(i3);
    }

    public final void hideKeyboard() {
        SearchBar b16;
        aa<SearchBar> aaVar = this.searchBarRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        AbstractBaseView.callRenderViewMethod$default(b16, "hideKeyboard", null, null, 6, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.ITabPager
    public final void jumpToTab(int i3) {
        QSearchContentSubPageView b16;
        aa<QSearchContentSubPageView> aaVar = this.contentSubPageRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        b16.jumpToTab(i3);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onCreatePager(String str, e eVar) {
        super.onCreatePager(str, eVar);
        Utils.INSTANCE.getClass();
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        QQPermissionModule qQPermissionModule = (QQPermissionModule) cVar.k(BridgeManager.f117344a.u()).acquireModule("QQPermissionModule");
        int i3 = QQPermissionModule.$r8$clinit;
        qQPermissionModule.getClass();
        if (k.a(cVar)) {
            e eVar2 = new e();
            eVar2.v("moduleId", "qq_big_search");
            qQPermissionModule.toNative(false, "enterModule", eVar2.toString(), null, false);
            return;
        }
        new e();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onDestroyPager() {
        super.onDestroyPager();
        Utils.INSTANCE.getClass();
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        QQPermissionModule qQPermissionModule = (QQPermissionModule) cVar.k(BridgeManager.f117344a.u()).acquireModule("QQPermissionModule");
        int i3 = QQPermissionModule.$r8$clinit;
        qQPermissionModule.getClass();
        if (k.a(cVar)) {
            e eVar = new e();
            eVar.v("moduleId", "qq_big_search");
            qQPermissionModule.toNative(false, "exitModule", eVar.toString(), null, false);
            return;
        }
        new e();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, Pager.PAGER_EVENT_ROOT_VIEW_SIZE_CHANGED)) {
            Utils.INSTANCE.logToNative("QSearchDetailPage [onReceivePagerEvent] " + str + TokenParser.SP + eVar);
            QSearchDetailViewModel qSearchDetailViewModel = this.viewModel;
            qSearchDetailViewModel.pageWidth$delegate.setValue(qSearchDetailViewModel, QSearchDetailViewModel.$$delegatedProperties[5], Double.valueOf(eVar.h("width")));
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        super.pageDidAppear();
        com.tencent.kuikly.core.module.k.b(Utils.INSTANCE.notifyModule(""), "update_click_correction_query", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$pageDidAppear$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                SearchBar b16;
                e eVar2 = eVar;
                if (eVar2 != null) {
                    QSearchDetailPage qSearchDetailPage = QSearchDetailPage.this;
                    String p16 = eVar2.p("correction_key_word");
                    aa<SearchBar> aaVar = qSearchDetailPage.searchBarRef;
                    if (aaVar != null && (b16 = aaVar.b()) != null) {
                        b16.setText(p16);
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        this.viewModel.setPageStatus(PageStatus.DID_APPEAR);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        this.viewModel.setPageStatus(PageStatus.DID_DISAPPEAR);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel>] */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        this.viewModel.setPageStatus(PageStatus.WILL_DESTROY);
        Iterator it = this.viewModel.getContentPageViewModel().subPageViewModelMap.values().iterator();
        while (it.hasNext()) {
            ((QSearchTabContentViewModel) it.next()).cleanPB();
        }
        QSearchMiniAppCache.INSTANCE.getMiniAppCache().clear();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final boolean scaleFontSizeEnable() {
        return true;
    }

    public final void searchText(final String str, final int i3) {
        getPager().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage$searchText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                boolean isBlank;
                QSearchDetailPage.this.hideKeyboard();
                QSearchDetailPage.this.viewModel.setCurrentPage(SubPageName.CONTENT);
                if (Intrinsics.areEqual(str, QSearchDetailPage.this.viewModel.getKeyword())) {
                    QSearchDetailPage.this.viewModel.setKeyword("");
                }
                QSearchDetailPage.this.viewModel.querySource = i3;
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    QSearchDetailPage.this.viewModel.setKeyword(str);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.IDialogPager
    public final void setDialogBuilder(Function1<? super ViewContainer<?, ?>, Unit> function1) {
        this.dialogBuilder = function1;
        this.showDialog$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(function1 != null));
    }
}
