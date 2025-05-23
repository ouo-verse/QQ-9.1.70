package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.module.QQSearchModule;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildDoubleItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildBaseDoubleAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchVideoPlayViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchChainReporter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QSearchTabContentView extends QSearchReportView<QSearchTabContentAttr, QSearchTabContentEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentView.class, "userScrolling", "getUserScrolling()Z", 0)};
    public QSearchAIPictureCardViewModel aiPictureViewModel;
    public float lastPageViewWidth;
    public final ReadWriteProperty userScrolling$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$configGuildDoubleItemAttr(QSearchTabContentView qSearchTabContentView, GuildBaseDoubleAttr guildBaseDoubleAttr, SearchGuildDoubleItemModel searchGuildDoubleItemModel, int i3) {
        qSearchTabContentView.getClass();
        guildBaseDoubleAttr.data = searchGuildDoubleItemModel;
        guildBaseDoubleAttr.index = i3;
        int playIndex = ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getViewModel().getPlayIndex();
        ReadWriteProperty readWriteProperty = guildBaseDoubleAttr.playIndex$delegate;
        KProperty<?>[] kPropertyArr = GuildBaseDoubleAttr.$$delegatedProperties;
        readWriteProperty.setValue(guildBaseDoubleAttr, kPropertyArr[0], Integer.valueOf(playIndex));
        guildBaseDoubleAttr.keyword$delegate.setValue(guildBaseDoubleAttr, kPropertyArr[1], ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getKeyword());
        guildBaseDoubleAttr.traceId = ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getViewModel().repo.currentTraceId;
        guildBaseDoubleAttr.pageStatus$delegate.setValue(guildBaseDoubleAttr, kPropertyArr[2], ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getPageStatus());
        guildBaseDoubleAttr.tabData = ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).tabData;
        guildBaseDoubleAttr.userScrolling$delegate.setValue(guildBaseDoubleAttr, kPropertyArr[3], Boolean.valueOf(qSearchTabContentView.getUserScrolling()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$configGuildItemAttr(QSearchTabContentView qSearchTabContentView, GuildBaseAttr guildBaseAttr, SearchGuildBaseItemModel searchGuildBaseItemModel, int i3) {
        qSearchTabContentView.getClass();
        guildBaseAttr.data = searchGuildBaseItemModel;
        guildBaseAttr.index = i3;
        int playIndex = ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getViewModel().getPlayIndex();
        ReadWriteProperty readWriteProperty = guildBaseAttr.playIndex$delegate;
        KProperty<?>[] kPropertyArr = GuildBaseAttr.$$delegatedProperties;
        readWriteProperty.setValue(guildBaseAttr, kPropertyArr[0], Integer.valueOf(playIndex));
        guildBaseAttr.keyword$delegate.setValue(guildBaseAttr, kPropertyArr[1], ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getKeyword());
        guildBaseAttr.traceId = ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getViewModel().repo.currentTraceId;
        guildBaseAttr.pageStatus$delegate.setValue(guildBaseAttr, kPropertyArr[2], ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getPageStatus());
        guildBaseAttr.tabData = ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).tabData;
        guildBaseAttr.userScrolling$delegate.setValue(guildBaseAttr, kPropertyArr[3], Boolean.valueOf(qSearchTabContentView.getUserScrolling()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$createErrorView(final QSearchTabContentView qSearchTabContentView) {
        final e emptyOrErrorViewReportParams = qSearchTabContentView.getEmptyOrErrorViewReportParams(((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getKeyword(), ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getViewModel().repo.currentTraceId, null);
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createErrorView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final e eVar = e.this;
                final QSearchTabContentView qSearchTabContentView2 = qSearchTabContentView;
                viewContainer.addChild(new QSearchErrorView(), new Function1<QSearchErrorView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createErrorView$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QSearchErrorView qSearchErrorView) {
                        final e eVar2 = e.this;
                        final QSearchTabContentView qSearchTabContentView3 = qSearchTabContentView2;
                        qSearchErrorView.attr(new Function1<QSearchErrorAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.createErrorView.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchErrorAttr qSearchErrorAttr) {
                                QSearchErrorAttr qSearchErrorAttr2 = qSearchErrorAttr;
                                qSearchErrorAttr2.positionAbsolute();
                                qSearchErrorAttr2.m142left(0.0f);
                                qSearchErrorAttr2.m149right(0.0f);
                                qSearchErrorAttr2.m138bottom(0.0f);
                                qSearchErrorAttr2.reportParam = e.this;
                                final QSearchTabContentView qSearchTabContentView4 = qSearchTabContentView3;
                                qSearchErrorAttr2.retryHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.createErrorView.1.1.1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().loadData(QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword(), QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getQuerySource(), false, null);
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
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$dispatchActiveState(QSearchTabContentView qSearchTabContentView) {
        if (((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getPageStatus() != PageStatus.DID_APPEAR) {
            qSearchTabContentView.onInactive();
        } else if (((QSearchTabContentAttr) qSearchTabContentView.getAttr()).index == ((QSearchTabContentAttr) qSearchTabContentView.getAttr()).getCurrentTabIndex()) {
            qSearchTabContentView.onActive();
        } else {
            qSearchTabContentView.onInactive();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchTabContentAttr access$getAttr(QSearchTabContentView qSearchTabContentView) {
        return (QSearchTabContentAttr) qSearchTabContentView.getAttr();
    }

    public Function1<ViewContainer<?, ?>, Unit> appendEmptyView(e eVar) {
        return null;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new QSearchTabContentView$body$1(this);
    }

    public Function1<ViewContainer<?, ?>, Unit> configItemView(ISearchItemModel iSearchItemModel, int i3) {
        return new QSearchTabContentView$configItemView$1(iSearchItemModel, i3, this);
    }

    public float correctionItemMarginBottom() {
        return 0.0f;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchTabContentAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchTabContentEvent();
    }

    public Function1<ViewContainer<?, ?>, Unit> createFooterView(e eVar) {
        return null;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$created$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getPageStatus();
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$created$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchTabContentView.access$dispatchActiveState(QSearchTabContentView.this);
                return Unit.INSTANCE;
            }
        });
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$created$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getCurrentTabIndex());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$created$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchTabContentView.access$dispatchActiveState(QSearchTabContentView.this);
                return Unit.INSTANCE;
            }
        });
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$created$5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword();
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$created$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchTabContentView.this.onKeywordChanged();
                return Unit.INSTANCE;
            }
        });
        Utils utils = Utils.INSTANCE;
        k.b(utils.notifyModule(""), "update_disable_correction_query", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$created$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    QSearchTabContentView qSearchTabContentView = QSearchTabContentView.this;
                    boolean f16 = eVar2.f("disable_correction_query");
                    QSearchTabContentView.access$getAttr(qSearchTabContentView).getViewModel().keyword = "";
                    QSearchTabContentView.access$getAttr(qSearchTabContentView).getViewModel().disableCorrectionQuery = f16;
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        k.b(utils.notifyModule(""), "update_click_correction_query", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$created$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    QSearchTabContentView qSearchTabContentView = QSearchTabContentView.this;
                    boolean f16 = eVar2.f("disable_correction_query");
                    String p16 = eVar2.p("correction_key_word");
                    QSearchTabContentAttr access$getAttr = QSearchTabContentView.access$getAttr(qSearchTabContentView);
                    access$getAttr.keyword$delegate.setValue(access$getAttr, QSearchTabContentAttr.$$delegatedProperties[1], p16);
                    QSearchTabContentView.access$getAttr(qSearchTabContentView).getViewModel().disableCorrectionQuery = f16;
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$created$9
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                QSearchTabContentAttr access$getAttr = QSearchTabContentView.access$getAttr(QSearchTabContentView.this);
                return Double.valueOf(((Number) access$getAttr.pageWidth$delegate.getValue(access$getAttr, QSearchTabContentAttr.$$delegatedProperties[5])).doubleValue());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$created$10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                if (QSearchTabContentView.access$getAttr(QSearchTabContentView.this).index == QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getCurrentTabIndex()) {
                    QSearchTabContentView qSearchTabContentView = QSearchTabContentView.this;
                    if (!(qSearchTabContentView.lastPageViewWidth == qSearchTabContentView.getPagerData().m())) {
                        QSearchTabContentView qSearchTabContentView2 = QSearchTabContentView.this;
                        qSearchTabContentView2.lastPageViewWidth = qSearchTabContentView2.getPagerData().m();
                        Utils utils2 = Utils.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QSearchTabContentView [pageSizeChanged] ");
                        m3.append(QSearchTabContentView.this.getPagerData().m());
                        m3.append(TokenParser.SP);
                        m3.append(QSearchTabContentView.this.hashCode());
                        utils2.logToNative(m3.toString());
                        QSearchTabContentViewModel viewModel = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel();
                        String keyword = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword();
                        int querySource = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getQuerySource();
                        KProperty<Object>[] kPropertyArr = QSearchTabContentViewModel.$$delegatedProperties;
                        viewModel.loadData(keyword, querySource, false, null);
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e getCorrectionQueryViewReportParams(String str, String str2, String str3) {
        e eVar = new e();
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        eVar.v("pageId", "pg_qq_network_search_result_level2_page");
        eVar.v("tab_name", ((QSearchTabContentAttr) getAttr()).tabData.tabName);
        eVar.t("tab_mask", (int) ((QSearchTabContentAttr) getAttr()).tabData.tabMask);
        eVar.v("search_query_text", str);
        eVar.v("search_trace_id", str2);
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        if (iSearchReport != null) {
            eVar.v("query_source", String.valueOf(iSearchReport.getQuerySource()));
            eVar.v("user_source", String.valueOf(iSearchReport.getUserSource()));
        }
        eVar.v("error_correction_query", str3);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e getEmptyOrErrorViewReportParams(String str, String str2, String str3) {
        e eVar = new e();
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        eVar.v("pageId", "pg_qq_network_search_result_level2_page");
        eVar.v("tab_name", ((QSearchTabContentAttr) getAttr()).tabData.tabName);
        eVar.t("tab_mask", (int) ((QSearchTabContentAttr) getAttr()).tabData.tabMask);
        eVar.v("search_query_text", str);
        eVar.v("search_trace_id", str2);
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        if (iSearchReport != null) {
            eVar.v("query_source", String.valueOf(iSearchReport.getQuerySource()));
            eVar.v("user_source", String.valueOf(iSearchReport.getUserSource()));
        }
        if (str3 == null) {
            str3 = "{}";
        }
        eVar.v("transfer_info", TemplateItemsKt.mergeTransferInfo(str3, eVar));
        return eVar;
    }

    public final boolean getUserScrolling() {
        return ((Boolean) this.userScrolling$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActive() {
        if (((QSearchTabContentAttr) getAttr()).getViewModel().isPageActive()) {
            return;
        }
        QSearchTabContentViewModel viewModel = ((QSearchTabContentAttr) getAttr()).getViewModel();
        viewModel.isPageActive$delegate.setValue(viewModel, QSearchVideoPlayViewModel.$$delegatedProperties[1], Boolean.TRUE);
        if (!Intrinsics.areEqual(((QSearchTabContentAttr) getAttr()).getKeyword(), ((QSearchTabContentAttr) getAttr()).getViewModel().keyword)) {
            ((QSearchTabContentAttr) getAttr()).getViewModel().loadData(((QSearchTabContentAttr) getAttr()).getKeyword(), ((QSearchTabContentAttr) getAttr()).getQuerySource(), false, null);
        }
        ((QSearchTabContentAttr) getAttr()).getViewModel().playVideoInNextTickIfNeed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onInactive() {
        if (((QSearchTabContentAttr) getAttr()).getViewModel().isPageActive()) {
            QSearchTabContentViewModel viewModel = ((QSearchTabContentAttr) getAttr()).getViewModel();
            viewModel.isPageActive$delegate.setValue(viewModel, QSearchVideoPlayViewModel.$$delegatedProperties[1], Boolean.FALSE);
            QSearchTabContentViewModel viewModel2 = ((QSearchTabContentAttr) getAttr()).getViewModel();
            viewModel2.setPlayIndex(-2);
            viewModel2.needPlayVideo = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onKeywordChanged() {
        ((QSearchTabContentAttr) getAttr()).getViewModel().disableCorrectionQuery = false;
        if (((QSearchTabContentAttr) getAttr()).getKeyword().length() == 0) {
            ((QSearchTabContentAttr) getAttr()).getViewModel().reset();
            ((QSearchTabContentAttr) getAttr()).getViewModel().keyword = "";
            return;
        }
        if (((QSearchTabContentAttr) getAttr()).getViewModel().isPageActive()) {
            ((QSearchTabContentAttr) getAttr()).getViewModel().loadData(((QSearchTabContentAttr) getAttr()).getKeyword(), ((QSearchTabContentAttr) getAttr()).getQuerySource(), false, null);
            QSearchChainReporter qSearchChainReporter = QSearchChainReporter.INSTANCE;
            Utils utils = Utils.INSTANCE;
            qSearchChainReporter.updateSearchStartTime(utils.currentBridgeModule().currentTimeStamp(), ((QSearchTabContentAttr) getAttr()).getKeyword(), false);
            QQSearchModule qqSearchModule = utils.qqSearchModule();
            String keyword = ((QSearchTabContentAttr) getAttr()).getKeyword();
            qqSearchModule.getClass();
            e eVar = new e();
            eVar.v("keyWord", keyword);
            qqSearchModule.callNativeMethod("saveSearchHistoryForNetSearch", eVar, null);
        }
    }
}
