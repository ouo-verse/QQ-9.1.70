package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.module.QQSearchModule;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.DoubleVideoItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.SearchCorrectionQueryCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildDoubleItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchLBSPermissionHelper;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchChainReporter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchPagePerfReporter;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.pager.g;
import defpackage.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QSearchTabContentViewModel extends QSearchVideoPlayViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentViewModel.class, "dataList", "getDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentViewModel.class, "listState", "getListState()Lcom/tencent/hippykotlin/demo/pages/base/RefreshListState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentViewModel.class, "isEnd", "isEnd()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentViewModel.class, "emptyPageExtraInfo", "getEmptyPageExtraInfo()Lkuikly/com/tencent/trpcprotocol/search/unifysearch/EmptyPageExtraInfo;", 0)};
    public boolean disableCorrectionQuery;
    public final ReadWriteProperty emptyPageExtraInfo$delegate;
    public final QSearchLBSPermissionHelper lbsPermissionHelper;
    public int netStatus;
    public final QSearchPagePerfReporter perfReporter;
    public final QSearchContentNetRepo repo;
    public final UnifySearchTabInfo tabData;
    public final ReadWriteProperty dataList$delegate = c.b();
    public final ReadWriteProperty listState$delegate = c.a(RefreshListState.Idle.INSTANCE);
    public String keyword = "";
    public int querySource = 2;

    public QSearchTabContentViewModel(UnifySearchTabInfo unifySearchTabInfo, g gVar, QSearchPagePerfReporter qSearchPagePerfReporter, QSearchLBSPermissionHelper qSearchLBSPermissionHelper, boolean z16) {
        this.tabData = unifySearchTabInfo;
        this.perfReporter = qSearchPagePerfReporter;
        this.lbsPermissionHelper = qSearchLBSPermissionHelper;
        c.a(Boolean.FALSE);
        this.emptyPageExtraInfo$delegate = c.a(null);
        this.repo = createContentNetRepo(gVar, unifySearchTabInfo, z16);
    }

    public static void loadMoreData$default(final QSearchTabContentViewModel qSearchTabContentViewModel, Function2 function2, int i3, Object obj) {
        if (qSearchTabContentViewModel.netStatus != 0) {
            return;
        }
        qSearchTabContentViewModel.netStatus = 2;
        final Function2 function22 = null;
        qSearchTabContentViewModel.repo.loadMoreData(qSearchTabContentViewModel.keyword, qSearchTabContentViewModel.disableCorrectionQuery, qSearchTabContentViewModel.querySource, new Function5<Boolean, Boolean, List<? extends ISearchItemModel>, String, e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel$loadMoreData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(Boolean bool, Boolean bool2, List<? extends ISearchItemModel> list, String str, e eVar) {
                RefreshListState.LoadingMoreResult loadingMoreResult;
                boolean booleanValue = bool.booleanValue();
                boolean booleanValue2 = bool2.booleanValue();
                List<? extends ISearchItemModel> list2 = list;
                QSearchTabContentViewModel qSearchTabContentViewModel2 = QSearchTabContentViewModel.this;
                qSearchTabContentViewModel2.emptyPageExtraInfo$delegate.setValue(qSearchTabContentViewModel2, QSearchTabContentViewModel.$$delegatedProperties[3], eVar);
                QSearchTabContentViewModel qSearchTabContentViewModel3 = QSearchTabContentViewModel.this;
                if (qSearchTabContentViewModel3.netStatus == 2) {
                    if (booleanValue && list2 != null) {
                        qSearchTabContentViewModel3.appendData(list2, "");
                        loadingMoreResult = new RefreshListState.LoadingMoreResult(true, !booleanValue2);
                    } else {
                        loadingMoreResult = new RefreshListState.LoadingMoreResult(false, !booleanValue2);
                    }
                    qSearchTabContentViewModel3.setListState(loadingMoreResult);
                    Function2<Boolean, Boolean, Unit> function23 = function22;
                    if (function23 != null) {
                        function23.invoke(Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2));
                    }
                    QSearchTabContentViewModel.this.netStatus = 0;
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Incorrect condition in loop: B:50:0x00fc */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel>, java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void appendData(List<? extends ISearchItemModel> list, String str) {
        int lastIndex;
        Object orNull;
        int lastIndex2;
        Object orNull2;
        Object orNull3;
        Object obj;
        Object orNull4;
        final ArrayList arrayList = new ArrayList();
        com.tencent.kuikly.core.reactive.collection.c<ISearchItemModel> dataList = getDataList();
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(getDataList());
        orNull = CollectionsKt___CollectionsKt.getOrNull(dataList, lastIndex);
        ISearchItemModel iSearchItemModel = (ISearchItemModel) orNull;
        int i3 = 0;
        if (iSearchItemModel instanceof SearchGuildDoubleItemModel) {
            SearchGuildDoubleItemModel searchGuildDoubleItemModel = (SearchGuildDoubleItemModel) iSearchItemModel;
            if (searchGuildDoubleItemModel.modelList.size() == 1) {
                if (list != null) {
                    orNull4 = CollectionsKt___CollectionsKt.getOrNull(list, 0);
                    obj = (ISearchItemModel) orNull4;
                } else {
                    obj = null;
                }
                SearchGuildBaseItemModel searchGuildBaseItemModel = obj instanceof SearchGuildBaseItemModel ? (SearchGuildBaseItemModel) obj : null;
                if (searchGuildBaseItemModel != null && searchGuildBaseItemModel.getType() == ((SearchGuildBaseItemModel) searchGuildDoubleItemModel.modelList.get(0)).getType()) {
                    arrayList.add(searchGuildDoubleItemModel.modelList.get(0));
                    CollectionsKt__MutableCollectionsKt.removeLast(getDataList());
                }
            }
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        final Ref.IntRef intRef3 = new Ref.IntRef();
        intRef3.element = -1;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel$fillItemsWithReportParams$allocateResultNum$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                if (Ref.IntRef.this.element >= 0) {
                    int i16 = intRef3.element;
                    for (int i17 = (i16 - intRef2.element) - 1; i17 < i16; i17++) {
                        if (i17 >= 0) {
                            ISearchItemModel iSearchItemModel2 = arrayList.get(i17);
                            SearchGuildBaseItemModel searchGuildBaseItemModel2 = iSearchItemModel2 instanceof SearchGuildBaseItemModel ? (SearchGuildBaseItemModel) iSearchItemModel2 : null;
                            if (searchGuildBaseItemModel2 != null) {
                                searchGuildBaseItemModel2.resultNumber = intRef2.element + 1;
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ISearchItemModel iSearchItemModel2 = (ISearchItemModel) it.next();
            intRef3.element++;
            if (!(iSearchItemModel2 instanceof SearchGuildBaseItemModel)) {
                function0.invoke();
                intRef.element = -1;
                intRef2.element = -1;
            } else {
                int i16 = intRef.element;
                if (i16 < 0) {
                    intRef.element = ((SearchGuildBaseItemModel) iSearchItemModel2).getType();
                    intRef2.element = -1;
                } else {
                    SearchGuildBaseItemModel searchGuildBaseItemModel2 = (SearchGuildBaseItemModel) iSearchItemModel2;
                    if (i16 != searchGuildBaseItemModel2.getType()) {
                        function0.invoke();
                        intRef.element = searchGuildBaseItemModel2.getType();
                        intRef2.element = -1;
                    }
                }
                SearchGuildBaseItemModel searchGuildBaseItemModel3 = (SearchGuildBaseItemModel) iSearchItemModel2;
                int i17 = searchGuildBaseItemModel3.reportIndex;
                if (i17 > 0) {
                    intRef2.element = i17;
                } else {
                    int i18 = intRef2.element + 1;
                    intRef2.element = i18;
                    searchGuildBaseItemModel3.reportIndex = i18;
                }
            }
        }
        intRef3.element++;
        function0.invoke();
        ArrayList arrayList2 = new ArrayList();
        if (str.length() > 0) {
            String str2 = this.keyword;
            SearchCorrectionQueryCardItemModel searchCorrectionQueryCardItemModel = new SearchCorrectionQueryCardItemModel();
            searchCorrectionQueryCardItemModel.keyWord = str2;
            searchCorrectionQueryCardItemModel.correctionQuery = str;
            arrayList2.add(searchCorrectionQueryCardItemModel);
        }
        while (i3 <= lastIndex2) {
            ISearchItemModel iSearchItemModel3 = (ISearchItemModel) arrayList.get(i3);
            if (iSearchItemModel3 instanceof SearchGuildBaseItemModel) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(arrayList, i3 - 1);
                ISearchItemModel iSearchItemModel4 = (ISearchItemModel) orNull2;
                int i19 = i3 + 1;
                orNull3 = CollectionsKt___CollectionsKt.getOrNull(arrayList, i19);
                ISearchItemModel iSearchItemModel5 = (ISearchItemModel) orNull3;
                if (iSearchItemModel5 instanceof SearchGuildBaseItemModel) {
                    SearchGuildBaseItemModel searchGuildBaseItemModel4 = (SearchGuildBaseItemModel) iSearchItemModel3;
                    if (searchGuildBaseItemModel4.getType() == ((SearchGuildBaseItemModel) iSearchItemModel5).getType()) {
                        SearchGuildDoubleItemModel searchGuildDoubleItemModel2 = new SearchGuildDoubleItemModel();
                        searchGuildDoubleItemModel2.type = searchGuildBaseItemModel4.getType();
                        searchGuildDoubleItemModel2.modelList.add(iSearchItemModel3);
                        searchGuildDoubleItemModel2.modelList.add(iSearchItemModel5);
                        arrayList2.add(searchGuildDoubleItemModel2);
                        i3 += 2;
                    }
                }
                if (iSearchItemModel4 instanceof SearchGuildBaseItemModel) {
                    SearchGuildBaseItemModel searchGuildBaseItemModel5 = (SearchGuildBaseItemModel) iSearchItemModel3;
                    if (searchGuildBaseItemModel5.getType() == ((SearchGuildBaseItemModel) iSearchItemModel4).getType()) {
                        SearchGuildDoubleItemModel searchGuildDoubleItemModel3 = new SearchGuildDoubleItemModel();
                        searchGuildDoubleItemModel3.type = searchGuildBaseItemModel5.getType();
                        searchGuildDoubleItemModel3.modelList.add(iSearchItemModel3);
                        arrayList2.add(searchGuildDoubleItemModel3);
                        i3 = i19;
                    }
                }
                arrayList2.add(iSearchItemModel3);
                i3 = i19;
            } else {
                i3++;
                arrayList2.add(iSearchItemModel3);
            }
        }
        getDataList().addAll(arrayList2);
    }

    public final void cleanPB() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<ISearchItemModel> it = getDataList().iterator();
        while (it.hasNext()) {
            it.next().appendFeedPbToken(arrayList);
        }
        Utils.INSTANCE.currentBridgeModule().cleanPB(arrayList);
    }

    public QSearchContentNetRepo createContentNetRepo(g gVar, UnifySearchTabInfo unifySearchTabInfo, boolean z16) {
        return new QSearchContentNetRepo(gVar.getAppVersion(), gVar, unifySearchTabInfo, z16);
    }

    public final void doLoadData(final Function2<? super Boolean, ? super Boolean, Unit> function2, boolean z16) {
        if (this.netStatus == 1) {
            return;
        }
        this.netStatus = 1;
        setListState(RefreshListState.Loading.INSTANCE);
        this.repo.loadData(this.keyword, this.disableCorrectionQuery, this.querySource, z16, new Function5<Boolean, Boolean, List<? extends ISearchItemModel>, String, e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel$doLoadData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(Boolean bool, Boolean bool2, List<? extends ISearchItemModel> list, String str, e eVar) {
                boolean z17;
                Object obj;
                String str2;
                boolean z18;
                QSearchTabContentViewModel$doLoadData$1 qSearchTabContentViewModel$doLoadData$1;
                boolean z19;
                com.tencent.kuikly.core.manager.c cVar;
                boolean z26;
                String str3;
                QSearchTabContentViewModel qSearchTabContentViewModel;
                RefreshListState refreshResult;
                FunctionCardItemModel functionCardItemModel;
                int i3;
                Object first;
                boolean booleanValue = bool.booleanValue();
                boolean booleanValue2 = bool2.booleanValue();
                List<? extends ISearchItemModel> list2 = list;
                String str4 = str;
                QSearchTabContentViewModel qSearchTabContentViewModel2 = QSearchTabContentViewModel.this;
                qSearchTabContentViewModel2.emptyPageExtraInfo$delegate.setValue(qSearchTabContentViewModel2, QSearchTabContentViewModel.$$delegatedProperties[3], eVar);
                if (booleanValue && list2 != null) {
                    QSearchTabContentViewModel qSearchTabContentViewModel3 = QSearchTabContentViewModel.this;
                    qSearchTabContentViewModel3.reset();
                    qSearchTabContentViewModel3.appendData(list2, str4);
                    Utils utils = Utils.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("cath test ");
                    com.tencent.kuikly.core.manager.c cVar2 = com.tencent.kuikly.core.manager.c.f117352a;
                    m3.append(cVar2.g().getPageData().n().p("func_payload"));
                    utils.logToNative(m3.toString());
                    if (QSearchChainReporter.isSearching) {
                        QSearchChainReporter.isSearching = false;
                        long currentTimeStamp = utils.currentBridgeModule().currentTimeStamp();
                        QSearchChainReporter.SearchChain searchChain = QSearchChainReporter.searchChain;
                        long j3 = searchChain.startTime;
                        String str5 = searchChain.keyword;
                        long j16 = searchChain.reqTab;
                        cVar = cVar2;
                        long j17 = searchChain.endReqTab;
                        long j18 = searchChain.reqCtx;
                        long j19 = searchChain.endReqCtx;
                        long j26 = searchChain.reqGps;
                        long j27 = searchChain.endReqGps;
                        z26 = booleanValue;
                        boolean z27 = searchChain.isFromActivePage;
                        BridgeModule currentBridgeModule = utils.currentBridgeModule();
                        z17 = booleanValue2;
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                        str3 = "func_payload";
                        eVar2.u("search_start", j3);
                        eVar2.u("result_show", currentTimeStamp);
                        eVar2.u("cost_in_total", currentTimeStamp - j3);
                        eVar2.u("lbs_cost", j27 - j26);
                        eVar2.u("lbs_start_timestamp", j26);
                        eVar2.u("lbs_end_timestamp", j27);
                        eVar2.v("keyword", str5);
                        eVar2.u("tab_req_start_timestamp", j16);
                        eVar2.u("tab_req_end_timestamp", j17);
                        eVar2.u("tab_req_cost", j17 - j16);
                        eVar2.u("ctx_req_start_timestamp", j18);
                        eVar2.u("ctx_req_end_timestamp", j19);
                        eVar2.u("ctx_req_cost", j19 - j18);
                        eVar2.w("is_from_active_page", z27);
                        obj = "0DOU0TYBSY4OEY1K";
                        str2 = "custom_beacon_app_key";
                        eVar2.v(str2, obj);
                        Unit unit = Unit.INSTANCE;
                        currentBridgeModule.reportDT("kuikly_net_search", eVar2);
                        searchChain.reset();
                        qSearchTabContentViewModel = qSearchTabContentViewModel3;
                    } else {
                        z26 = booleanValue;
                        z17 = booleanValue2;
                        obj = "0DOU0TYBSY4OEY1K";
                        str2 = "custom_beacon_app_key";
                        qSearchTabContentViewModel = qSearchTabContentViewModel3;
                        cVar = cVar2;
                        str3 = "func_payload";
                    }
                    if (((int) qSearchTabContentViewModel.tabData.tabMask) == 1 && qSearchTabContentViewModel.querySource == 20) {
                        String p16 = cVar.g().getPageData().n().p(str3);
                        if (p16.length() == 0) {
                            functionCardItemModel = null;
                        } else {
                            FunctionCardItemModel functionCardItemModel2 = new FunctionCardItemModel();
                            com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = new com.tencent.kuikly.core.nvi.serialization.json.e(p16);
                            functionCardItemModel2.cardId = eVar3.p(com.tencent.biz.lebasearch.Utils.KEY_BUSINESS_ID);
                            functionCardItemModel2.name = eVar3.p("name");
                            functionCardItemModel2.iconUrl = eVar3.p("iconUrl");
                            functionCardItemModel = functionCardItemModel2;
                        }
                        if (!qSearchTabContentViewModel.getDataList().isEmpty()) {
                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) qSearchTabContentViewModel.getDataList());
                            if (first instanceof SearchCorrectionQueryCardItemModel) {
                                i3 = 1;
                                if (functionCardItemModel != null && functionCardItemModel.isValid()) {
                                    qSearchTabContentViewModel.getDataList().add(i3, functionCardItemModel);
                                }
                            }
                        }
                        i3 = 0;
                        if (functionCardItemModel != null) {
                            qSearchTabContentViewModel.getDataList().add(i3, functionCardItemModel);
                        }
                    }
                    if (qSearchTabContentViewModel.getDataList().isEmpty()) {
                        refreshResult = new RefreshListState.Empty();
                    } else {
                        refreshResult = new RefreshListState.RefreshResult(true, !z17);
                    }
                    qSearchTabContentViewModel.setListState(refreshResult);
                    z19 = true;
                    qSearchTabContentViewModel$doLoadData$1 = this;
                    z18 = z26;
                } else {
                    z17 = booleanValue2;
                    obj = "0DOU0TYBSY4OEY1K";
                    str2 = "custom_beacon_app_key";
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("loadData error success=");
                    z18 = booleanValue;
                    sb5.append(z18);
                    kLog.e("QSearchTabContentViewModel", sb5.toString());
                    qSearchTabContentViewModel$doLoadData$1 = this;
                    if (!QSearchTabContentViewModel.this.getDataList().isEmpty()) {
                        QSearchTabContentViewModel.this.setListState(new RefreshListState.RefreshResult(false, !z17));
                        Utils.INSTANCE.currentBridgeModule().toast("\u7f51\u7edc\u4e0d\u7ed9\u529b,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                    } else {
                        QSearchTabContentViewModel.this.setListState(new RefreshListState.Error());
                    }
                    z19 = false;
                }
                Function2<Boolean, Boolean, Unit> function22 = function2;
                if (function22 != null) {
                    function22.invoke(Boolean.valueOf(z18), Boolean.valueOf(z17));
                }
                QSearchPagePerfReporter qSearchPagePerfReporter = QSearchTabContentViewModel.this.perfReporter;
                if (qSearchPagePerfReporter != null && !qSearchPagePerfReporter.hasReported) {
                    qSearchPagePerfReporter.hasReported = true;
                    if (qSearchPagePerfReporter.startTime != 0) {
                        Utils utils2 = Utils.INSTANCE;
                        long currentTimeStamp2 = utils2.currentBridgeModule().currentTimeStamp() - qSearchPagePerfReporter.startTime;
                        if (currentTimeStamp2 > 0) {
                            BridgeModule currentBridgeModule2 = utils2.currentBridgeModule();
                            com.tencent.kuikly.core.nvi.serialization.json.e m16 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("pageName", "pg_qq_network_search_result_level2_page", "firstFrameTime", (int) currentTimeStamp2);
                            m16.v("hasData", z19 ? "1" : "0");
                            m16.v(str2, obj);
                            Unit unit2 = Unit.INSTANCE;
                            currentBridgeModule2.reportDT("search_page_first_frame_perf", m16);
                        }
                    }
                }
                QSearchTabContentViewModel.this.netStatus = 0;
                return Unit.INSTANCE;
            }
        });
    }

    public final com.tencent.kuikly.core.reactive.collection.c<ISearchItemModel> getDataList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.dataList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final e getEmptyPageExtraInfo() {
        return (e) this.emptyPageExtraInfo$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final RefreshListState getListState() {
        return (RefreshListState) this.listState$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void innerLoadData(final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (!k.a(cVar)) {
            doLoadData(function2, true);
            return;
        }
        QQSearchModule qqSearchModule = Utils.INSTANCE.qqSearchModule();
        Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function1 = new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel$innerLoadData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                if ((eVar2 != null ? eVar2.j("errorCode") : -1) == 0) {
                    QSearchTabContentViewModel.this.doLoadData(function2, true);
                } else {
                    KLog.INSTANCE.i("QSearchTabContentViewModel", "loadData no lbs permission. send request without lbs");
                    QSearchTabContentViewModel.this.doLoadData(function2, false);
                    QSearchLBSPermissionHelper qSearchLBSPermissionHelper = QSearchTabContentViewModel.this.lbsPermissionHelper;
                    if (!qSearchLBSPermissionHelper.hasRequestLBSPermission) {
                        qSearchLBSPermissionHelper.hasRequestLBSPermission = true;
                        QQSearchModule qqSearchModule2 = Utils.INSTANCE.qqSearchModule();
                        final QSearchTabContentViewModel qSearchTabContentViewModel = QSearchTabContentViewModel.this;
                        final Function2<Boolean, Boolean, Unit> function22 = function2;
                        Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function12 = new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel$innerLoadData$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar3) {
                                com.tencent.kuikly.core.nvi.serialization.json.e eVar4 = eVar3;
                                if ((eVar4 != null ? eVar4.j("errorCode") : -1) == 0) {
                                    KLog.INSTANCE.i("QSearchTabContentViewModel", "loadData lbs permission ok. send request with lbs");
                                    QSearchTabContentViewModel.this.doLoadData(function22, true);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        qqSearchModule2.getClass();
                        if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                            qqSearchModule2.callNativeMethod("requestPermission", new com.tencent.kuikly.core.nvi.serialization.json.e(), function12);
                        } else {
                            function12.invoke(new com.tencent.kuikly.core.nvi.serialization.json.e());
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        qqSearchModule.getClass();
        if (k.a(cVar)) {
            qqSearchModule.callNativeMethod("hasPermission", new com.tencent.kuikly.core.nvi.serialization.json.e(), function1);
        } else {
            function1.invoke(new com.tencent.kuikly.core.nvi.serialization.json.e());
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchVideoPlayViewModel
    public final boolean isVideoItem(int i3) {
        return getDataList().get(i3).canPlay();
    }

    public void loadData(String str, int i3, boolean z16, Function2<? super Boolean, ? super Boolean, Unit> function2) {
        if (Intrinsics.areEqual(str, this.keyword) && Intrinsics.areEqual(getListState(), RefreshListState.Loading.INSTANCE) && !z16) {
            return;
        }
        this.querySource = i3;
        if (str.length() == 0) {
            this.keyword = "";
            reset();
        } else {
            if (!Intrinsics.areEqual(this.keyword, str)) {
                reset();
            }
            this.keyword = str;
            innerLoadData(function2);
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchVideoPlayViewModel
    public final void predownloadVideo() {
        if (getPlayIndex() < 0 || getPlayIndex() >= getDataList().size()) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int size = getDataList().size();
        for (int playIndex = getPlayIndex(); playIndex < size; playIndex++) {
            ISearchItemModel iSearchItemModel = getDataList().get(playIndex);
            if (iSearchItemModel instanceof DoubleVideoItemModel) {
                Iterator it = ((DoubleVideoItemModel) iSearchItemModel).dataList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((StFeedEx) it.next()).feedPbToken);
                    if (arrayList.size() > 3) {
                        break;
                    }
                }
                if (arrayList.size() > 3) {
                    break;
                }
            }
        }
        if ((!arrayList.isEmpty()) && AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(com.tencent.kuikly.core.manager.c.f117352a)) {
            Utils.INSTANCE.currentBridgeModule().qCirclePreloadFeeds(arrayList);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
    public final void reset() {
        this.itemViewVisiblePercentMap.clear();
        setPlayIndex(-1);
        this.needPlayVideo = false;
        cleanPB();
        getDataList().clear();
    }

    public final void setListState(RefreshListState refreshListState) {
        this.listState$delegate.setValue(this, $$delegatedProperties[1], refreshListState);
    }
}
