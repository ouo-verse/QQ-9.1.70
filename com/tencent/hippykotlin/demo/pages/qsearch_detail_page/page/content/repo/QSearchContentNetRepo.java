package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo;

import c45.a;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.base.module.QQSearchModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.SearchItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchDeviceInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchEmptyPageExtraInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchGeoInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchGroupConditonFilter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchReqBody;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchRichText;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchRspBody;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabContent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabContentResult;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchText;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTitleTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchChainReporter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchReportKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.SearchNetApi$covertPbByteArrayToString$1;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.SearchNetApi$sendOidbPbRequest$1;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import defpackage.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.RandomKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.e;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.f;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.q;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.r;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.s;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.t;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.v;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QSearchContentNetRepo {
    public final String appVersion;
    public String currentTraceId;
    public e emptyPageExtraInfo;
    public boolean isEnd;
    public String lbs;
    public ArrayList<Integer> localIndexContainer;
    public boolean nightMode;
    public boolean studyMode;
    public final UnifySearchTabInfo tab;
    public String traceIdForFirstScreenData;
    public final boolean useOIDBReq;
    public int userSource;
    public a sessionInfo = new a(new byte[0]);
    public a busiSessionInfo = new a(new byte[0]);
    public String sessionInfoMSF = "";
    public String busiSessionInfoMSf = "";

    public QSearchContentNetRepo(String str, g gVar, UnifySearchTabInfo unifySearchTabInfo, boolean z16) {
        ArrayList<Integer> arrayListOf;
        this.appVersion = str;
        this.tab = unifySearchTabInfo;
        this.useOIDBReq = z16;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(0);
        this.localIndexContainer = arrayListOf;
        this.lbs = gVar.n().p("lbs");
        this.userSource = gVar.n().j("user_source");
        this.studyMode = gVar.n().g("study_mode_status", false);
        this.nightMode = PageDataExtKt.isNightMode(gVar);
        this.traceIdForFirstScreenData = "";
        this.currentTraceId = "";
    }

    public static final void access$notifyFail(QSearchContentNetRepo qSearchContentNetRepo, int i3, String str, final Function5 function5) {
        qSearchContentNetRepo.getClass();
        Utils.INSTANCE.logToNative("QSearchContentNetRepo requestData failed, errorCode=" + i3 + ", errorMsg=" + str);
        TimerKt.d(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo$notifyFail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Function5<Boolean, Boolean, List<? extends ISearchItemModel>, String, e, Unit> function52 = function5;
                Boolean bool = Boolean.FALSE;
                function52.invoke(bool, bool, null, "", null);
                return Unit.INSTANCE;
            }
        });
    }

    public final String getExtensionData(int i3) {
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        String currentAccount = currentBridgeModule.getCurrentAccount();
        long currentTimeStamp = currentBridgeModule.currentTimeStamp();
        this.currentTraceId = currentAccount + util.base64_pad_url + currentTimeStamp + util.base64_pad_url + (RandomKt.Random(currentTimeStamp).nextInt(90000) + 10000);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("traceId", this.currentTraceId);
        eVar.v("firstTraceId", this.traceIdForFirstScreenData);
        eVar.t(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, i3);
        eVar.t("userSource", this.userSource);
        eVar.u("sourceVersion", com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt.getResVersion(c.f117352a.g().getPageData()));
        if (this.traceIdForFirstScreenData.length() == 0) {
            this.traceIdForFirstScreenData = this.currentTraceId;
        }
        return eVar.toString();
    }

    public void loadData(final String str, final boolean z16, final int i3, boolean z17, final Function5<? super Boolean, ? super Boolean, ? super List<? extends ISearchItemModel>, ? super String, ? super e, Unit> function5) {
        this.traceIdForFirstScreenData = "";
        this.sessionInfo = new a(new byte[0]);
        this.busiSessionInfo = new a(new byte[0]);
        this.sessionInfoMSF = "";
        this.busiSessionInfoMSf = "";
        this.localIndexContainer.set(0, 0);
        this.isEnd = false;
        if (!z17) {
            AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(CacheDiskLru$$ExternalSyntheticOutline0.m("loadData send request without lbs keyword:", str, " useOIDBReq:"), this.useOIDBReq, KLog.INSTANCE, "QSearchContentNetRepo");
            this.lbs = "";
            doRequestData(str, z16, i3, function5);
            return;
        }
        KLog.INSTANCE.i("QSearchContentNetRepo", "getLBSThenRequestData keyword:" + str);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TimerKt.d(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo$getLBSThenRequestData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                if (!booleanRef2.element) {
                    booleanRef2.element = true;
                    NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestData lbs timeout lbs="), this.lbs, KLog.INSTANCE, "QSearchTabNetRepo");
                    this.doRequestData(str, z16, i3, function5);
                }
                return Unit.INSTANCE;
            }
        });
        QSearchChainReporter.SearchChain searchChain = QSearchChainReporter.searchChain;
        Utils utils = Utils.INSTANCE;
        searchChain.reqGps = utils.currentBridgeModule().currentTimeStamp();
        QQSearchModule qqSearchModule = utils.qqSearchModule();
        Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function1 = new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo$getLBSThenRequestData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                String str2;
                boolean isBlank;
                com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                if (eVar2 == null || (str2 = eVar2.p("lbs")) == null) {
                    str2 = "";
                }
                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank) {
                    QSearchContentNetRepo.this.lbs = str2;
                }
                QSearchChainReporter.searchChain.endReqGps = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
                Ref.BooleanRef booleanRef2 = booleanRef;
                if (!booleanRef2.element) {
                    booleanRef2.element = true;
                    NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestData lbs="), QSearchContentNetRepo.this.lbs, KLog.INSTANCE, "QSearchTabNetRepo");
                    QSearchContentNetRepo.this.doRequestData(str, z16, i3, function5);
                }
                return Unit.INSTANCE;
            }
        };
        qqSearchModule.getClass();
        qqSearchModule.callNativeMethod("getLbsInfo", new com.tencent.kuikly.core.nvi.serialization.json.e(), function1);
    }

    public final void loadMoreData(String str, boolean z16, int i3, Function5<? super Boolean, ? super Boolean, ? super List<? extends ISearchItemModel>, ? super String, ? super e, Unit> function5) {
        if (this.isEnd) {
            Boolean bool = Boolean.TRUE;
            function5.invoke(bool, bool, null, "", this.emptyPageExtraInfo);
            return;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("loadMoreData: disableCorrectionQuery:");
        sb5.append(z16);
        sb5.append(" lbs:");
        NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(sb5, !Intrinsics.areEqual(this.lbs, ""), kLog, "QSearchContentNetRepo");
        doRequestData(str, z16, i3, function5);
    }

    public final void reportRequest(String str, int i3) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        eVar.v("pageId", "pg_qq_network_search_result_level2_page");
        eVar.v("tab_name", this.tab.tabName);
        eVar.t("tab_mask", (int) this.tab.tabMask);
        eVar.t("query_source", i3);
        eVar.t("user_source", this.userSource);
        eVar.v("search_query_text", str);
        eVar.v("search_trace_id", this.currentTraceId);
        eVar.v("xsj_custom_pgid", "pg_qq_network_search_result_level2_page");
        eVar.v("xsj_eid", "em_bas_search_request");
        eVar.v("eid", "em_bas_search_request");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_xsj_abnormal_imp", eVar);
    }

    public UnifySearchReqBody createMSFReqBody(String str, boolean z16, int i3) {
        Object orNull;
        Object orNull2;
        List base64CodeBatch = Utils.INSTANCE.currentBridgeModule().base64CodeBatch(new String[]{this.lbs, getExtensionData(i3)});
        UnifySearchDeviceInfo unifySearchDeviceInfo = new UnifySearchDeviceInfo(this.studyMode, this.nightMode);
        String str2 = this.appVersion;
        UnifySearchTabInfo unifySearchTabInfo = this.tab;
        String str3 = this.sessionInfoMSF;
        String str4 = this.busiSessionInfoMSf;
        orNull = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 0);
        String str5 = (String) orNull;
        String str6 = str5 == null ? "" : str5;
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 1);
        String str7 = (String) orNull2;
        return new UnifySearchReqBody(str, str2, unifySearchTabInfo, str3, unifySearchDeviceInfo, null, z16, str6, null, str4, str7 == null ? "" : str7, 288);
    }

    public ReqGetSearchResult createReqBody(String str, boolean z16, int i3) {
        Object orNull;
        Object orNull2;
        List base64CodeBatch = Utils.INSTANCE.currentBridgeModule().base64CodeBatch(new String[]{this.lbs, getExtensionData(i3)});
        kuikly.com.tencent.trpcprotocol.search.unifysearch.c cVar = new kuikly.com.tencent.trpcprotocol.search.unifysearch.c(k.a(c.f117352a) ? 2 : 0, this.studyMode, this.nightMode, 17);
        String str2 = this.appVersion;
        UnifySearchTabInfo unifySearchTabInfo = this.tab;
        a aVar = this.sessionInfo;
        a aVar2 = this.busiSessionInfo;
        orNull = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 0);
        String str3 = (String) orNull;
        String str4 = str3 == null ? "" : str3;
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 1);
        String str5 = (String) orNull2;
        return new ReqGetSearchResult(str, str2, unifySearchTabInfo, aVar, cVar, aVar2, z16, str4, str5 == null ? "" : str5, null, null, 1536);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0079, code lost:
    
        if (r2 == null) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMSFReqSuccessResult(UnifySearchRspBody unifySearchRspBody, Function5<? super Boolean, ? super Boolean, ? super List<? extends ISearchItemModel>, ? super String, ? super e, Unit> function5, boolean z16) {
        List emptyList;
        ?? emptyList2;
        UnifySearchEmptyPageExtraInfo unifySearchEmptyPageExtraInfo;
        String str;
        UnifySearchEmptyPageExtraInfo unifySearchEmptyPageExtraInfo2;
        String str2;
        UnifySearchEmptyPageExtraInfo unifySearchEmptyPageExtraInfo3;
        String str3;
        UnifySearchEmptyPageExtraInfo unifySearchEmptyPageExtraInfo4;
        UnifySearchRichText unifySearchRichText;
        List<UnifySearchText> list;
        int collectionSizeOrDefault;
        List<UnifySearchTabContent> list2;
        List<UnifySearchTabContent> list3;
        List<UnifySearchTabContent> list4;
        int i3;
        ArrayList arrayList = new ArrayList();
        UnifySearchTabContentResult unifySearchTabContentResult = unifySearchRspBody.tabContentResult;
        int i16 = 0;
        if (unifySearchTabContentResult != null && (list4 = unifySearchTabContentResult.resultItems) != null) {
            for (Object obj : list4) {
                int i17 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                UnifySearchTabContent unifySearchTabContent = (UnifySearchTabContent) obj;
                if (SearchItemsKt.parseContent(unifySearchTabContent)) {
                    ISearchItemModel iSearchItemModel = unifySearchTabContent.searchItem;
                    i3 = iSearchItemModel != null && iSearchItemModel.isValid() ? i17 : 0;
                }
                arrayList.add(unifySearchTabContent);
            }
        }
        UnifySearchTabContentResult unifySearchTabContentResult2 = unifySearchRspBody.tabContentResult;
        if (unifySearchTabContentResult2 != null && (list3 = unifySearchTabContentResult2.resultItems) != null) {
            list3.removeAll(arrayList);
        }
        UnifySearchTabContentResult unifySearchTabContentResult3 = unifySearchRspBody.tabContentResult;
        if (unifySearchTabContentResult3 != null && (list2 = unifySearchTabContentResult3.resultItems) != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                ISearchItemModel iSearchItemModel2 = ((UnifySearchTabContent) it.next()).searchItem;
                if (iSearchItemModel2 != null) {
                    arrayList2.add(iSearchItemModel2);
                }
            }
            emptyList = CollectionsKt___CollectionsKt.toList(arrayList2);
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        List list5 = emptyList;
        ArrayList arrayList3 = new ArrayList();
        int i18 = 0;
        for (Object obj2 : list5) {
            int i19 = i18 + 1;
            if (i18 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleMSFReqSuccessResult:    \u8fc7\u6ee4\u6389\u6807\u9898\u6a21\u677f  index:", i18, KLog.INSTANCE, "ashionwang");
            if (!(((ISearchItemModel) obj2) instanceof QSearchTitleTemplateModel)) {
                arrayList3.add(obj2);
            }
            i18 = i19;
        }
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            Object next = it5.next();
            int i26 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SearchItemsKt.setSerialNumber((ISearchItemModel) next, this.localIndexContainer, i26 >= arrayList3.size() ? null : (ISearchItemModel) arrayList3.get(i26));
            i16 = i26;
        }
        UnifySearchTabContentResult unifySearchTabContentResult4 = unifySearchRspBody.tabContentResult;
        if (unifySearchTabContentResult4 == null || (unifySearchEmptyPageExtraInfo4 = unifySearchTabContentResult4.emptyPageExtraInfo) == null || (unifySearchRichText = unifySearchEmptyPageExtraInfo4.richText) == null || (list = unifySearchRichText.highlightText) == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList2 = new ArrayList(collectionSizeOrDefault);
            for (UnifySearchText unifySearchText : list) {
                String str4 = unifySearchText.text;
                String str5 = unifySearchText.jumpLink;
                MapsKt__MapsKt.emptyMap();
                emptyList2.add(new v(str4, str5));
            }
        }
        UnifySearchTabContentResult unifySearchTabContentResult5 = unifySearchRspBody.tabContentResult;
        String str6 = (unifySearchTabContentResult5 == null || (unifySearchEmptyPageExtraInfo3 = unifySearchTabContentResult5.emptyPageExtraInfo) == null || (str3 = unifySearchEmptyPageExtraInfo3.text) == null) ? "" : str3;
        String str7 = (unifySearchTabContentResult5 == null || (unifySearchEmptyPageExtraInfo2 = unifySearchTabContentResult5.emptyPageExtraInfo) == null || (str2 = unifySearchEmptyPageExtraInfo2.jumpUrl) == null) ? "" : str2;
        MapsKt__MapsKt.emptyMap();
        q qVar = new q(emptyList2);
        UnifySearchTabContentResult unifySearchTabContentResult6 = unifySearchRspBody.tabContentResult;
        this.emptyPageExtraInfo = new e(str6, str7, qVar, (unifySearchTabContentResult6 == null || (unifySearchEmptyPageExtraInfo = unifySearchTabContentResult6.emptyPageExtraInfo) == null || (str = unifySearchEmptyPageExtraInfo.title) == null) ? "" : str, 16);
        function5.invoke(Boolean.TRUE, Boolean.valueOf(z16), list5, unifySearchRspBody.correctionQuery, this.emptyPageExtraInfo);
    }

    public void handleOIDBSuccessResult(r rVar, Function5<? super Boolean, ? super Boolean, ? super List<? extends ISearchItemModel>, ? super String, ? super e, Unit> function5, boolean z16) {
        int i3;
        List list;
        String joinToString$default;
        t tVar = rVar.f413245f;
        List<s> list2 = tVar != null ? tVar.f413257e : null;
        ArrayList arrayList = new ArrayList();
        if (list2 != null) {
            for (s sVar : list2) {
                String str = sVar.f413249d;
                String str2 = sVar.f413250e;
                long j3 = sVar.f413251f;
                int i16 = sVar.f413252h;
                String str3 = sVar.f413253i;
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(sVar.f413254m.f30291a, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) SearchNetApi$covertPbByteArrayToString$1.INSTANCE, 30, (Object) null);
                arrayList.add(new UnifySearchTabContent(str, str2, j3, i16, str3, joinToString$default));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        int i17 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i18 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            UnifySearchTabContent unifySearchTabContent = (UnifySearchTabContent) next;
            if (SearchItemsKt.parseContent(unifySearchTabContent)) {
                ISearchItemModel iSearchItemModel = unifySearchTabContent.searchItem;
                i3 = iSearchItemModel != null && iSearchItemModel.isValid() ? i18 : 0;
            }
            arrayList2.add(unifySearchTabContent);
        }
        arrayList.removeAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ISearchItemModel iSearchItemModel2 = ((UnifySearchTabContent) it5.next()).searchItem;
            if (iSearchItemModel2 != null) {
                arrayList3.add(iSearchItemModel2);
            }
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList3);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list3 = list;
        ArrayList arrayList4 = new ArrayList();
        int i19 = 0;
        for (Object obj : list3) {
            int i26 = i19 + 1;
            if (i19 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleOIDBSuccessResult:    \u8fc7\u6ee4\u6389\u6807\u9898\u6a21\u677f  index:", i19, KLog.INSTANCE, "ashionwang");
            if (!(((ISearchItemModel) obj) instanceof QSearchTitleTemplateModel)) {
                arrayList4.add(obj);
            }
            i19 = i26;
        }
        Iterator it6 = arrayList4.iterator();
        while (it6.hasNext()) {
            Object next2 = it6.next();
            int i27 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SearchItemsKt.setSerialNumber((ISearchItemModel) next2, this.localIndexContainer, i27 >= arrayList4.size() ? null : (ISearchItemModel) arrayList4.get(i27));
            i17 = i27;
        }
        t tVar2 = rVar.f413245f;
        this.emptyPageExtraInfo = tVar2 != null ? tVar2.f413258f : null;
        Boolean bool = Boolean.TRUE;
        Boolean valueOf = Boolean.valueOf(z16);
        String str4 = rVar.D;
        t tVar3 = rVar.f413245f;
        function5.invoke(bool, valueOf, list3, str4, tVar3 != null ? tVar3.f413258f : null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0125, code lost:
    
        r9 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r15, "-", null, null, 0, null, null, 62, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0071, code lost:
    
        r9 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r15, "-", null, null, 0, null, null, 62, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void doRequestData(final String str, boolean z16, int i3, final Function5<? super Boolean, ? super Boolean, ? super List<? extends ISearchItemModel>, ? super String, ? super e, Unit> function5) {
        String str2;
        String str3;
        NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doRequestData useOIDBReq="), this.useOIDBReq, KLog.INSTANCE, "QSearchTabNetRepo");
        String str4 = "";
        if (this.useOIDBReq) {
            ReqGetSearchResult createReqBody = createReqBody(str, z16, i3);
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QSearchContentNetRepo requestData begin: keyword=");
            m3.append(createReqBody.keyWord);
            m3.append(", tabs=");
            m3.append(this.tab.tabName);
            m3.append(", traceId=");
            m3.append(this.currentTraceId);
            m3.append(", traceIdForFirstScreenData=");
            m3.append(this.traceIdForFirstScreenData);
            m3.append(", querySource=");
            m3.append(i3);
            String sb5 = m3.toString();
            kuikly.com.tencent.trpcprotocol.search.unifysearch.g gVar = createReqBody.groupConditionFilter;
            if (gVar != null) {
                List<String> list = gVar.f413200e;
                if (list == null || str3 == null) {
                    str3 = "";
                }
                f fVar = gVar.f413201f;
                if (fVar != null) {
                    str4 = String.valueOf(fVar.f413197h);
                }
                StringBuilder m16 = HotViewKt$$ExternalSyntheticOutline0.m(sb5, ", rankType=");
                m16.append(gVar.f413199d);
                m16.append(", tags=");
                m16.append(str3);
                m16.append(", geoInfo=");
                m16.append(str4);
                sb5 = m16.toString();
            }
            QSearchUtilKt.fastLog(sb5, this.sessionInfo.f30291a.length == 0);
            reportRequest(str, i3);
            final long timeStamp = QSearchUtilKt.getTimeStamp();
            QSearchChainReporter.searchChain.reqCtx = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
            QQKuiklyPlatformApi.Companion.sendOIDBRequest(createReqBody, false, new SearchNetApi$sendOidbPbRequest$1(QSearchUtilKt.getTimeStamp(), createReqBody, new Function1<OIDBResponse<r>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo$requestByOIDB$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(OIDBResponse<r> oIDBResponse) {
                    List<s> list2;
                    OIDBResponse<r> oIDBResponse2 = oIDBResponse;
                    QSearchChainReporter.SearchChain searchChain = QSearchChainReporter.searchChain;
                    Utils utils = Utils.INSTANCE;
                    searchChain.endReqCtx = utils.currentBridgeModule().currentTimeStamp();
                    int timeStamp2 = (int) (QSearchUtilKt.getTimeStamp() - timeStamp);
                    r rVar = oIDBResponse2.rsp;
                    int i16 = oIDBResponse2.code;
                    if (i16 != 0) {
                        QSearchContentNetRepo.access$notifyFail(this, i16, oIDBResponse2.f114186msg, function5);
                    } else if (rVar != null) {
                        StringBuilder m17 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("QSearchContentNetRepo requestByOIDB success, costTime=", timeStamp2, " end=");
                        m17.append(rVar.f413246h);
                        m17.append("\uff0csize=");
                        t tVar = rVar.f413245f;
                        m17.append((tVar == null || (list2 = tVar.f413257e) == null) ? 0 : list2.size());
                        utils.logToNative(m17.toString());
                        QSearchContentNetRepo qSearchContentNetRepo = this;
                        qSearchContentNetRepo.sessionInfo = rVar.f413247i;
                        qSearchContentNetRepo.busiSessionInfo = rVar.f413248m;
                        boolean z17 = rVar.f413246h == 1;
                        qSearchContentNetRepo.isEnd = z17;
                        qSearchContentNetRepo.handleOIDBSuccessResult(rVar, function5, z17);
                    } else {
                        QSearchContentNetRepo.access$notifyFail(this, -1, "no net body", function5);
                    }
                    return Unit.INSTANCE;
                }
            }));
            return;
        }
        UnifySearchReqBody createMSFReqBody = createMSFReqBody(str, z16, i3);
        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QSearchContentNetRepo requestDataByMsf begin: keyword=");
        m17.append(createMSFReqBody.keyWord);
        m17.append(", tabs=");
        m17.append(this.tab.tabName);
        m17.append(", traceId=");
        m17.append(this.currentTraceId);
        m17.append(", traceIdForFirstScreenData=");
        m17.append(this.traceIdForFirstScreenData);
        m17.append(", querySource=");
        m17.append(i3);
        String sb6 = m17.toString();
        UnifySearchGroupConditonFilter unifySearchGroupConditonFilter = createMSFReqBody.groupConditionFilter;
        if (unifySearchGroupConditonFilter != null) {
            List<String> list2 = unifySearchGroupConditonFilter.tags;
            if (list2 == null || str2 == null) {
                str2 = "";
            }
            UnifySearchGeoInfo unifySearchGeoInfo = unifySearchGroupConditonFilter.geoInfo;
            if (unifySearchGeoInfo != null) {
                str4 = String.valueOf(unifySearchGeoInfo.cityId);
            }
            StringBuilder m18 = HotViewKt$$ExternalSyntheticOutline0.m(sb6, ", rankType=");
            m18.append(unifySearchGroupConditonFilter.groupRankType);
            m18.append(", tags=");
            m18.append(str2);
            m18.append(", geoInfo=");
            m18.append(str4);
            sb6 = m18.toString();
        }
        QSearchUtilKt.fastLog(sb6, this.sessionInfoMSF.length() == 0);
        reportRequest(str, i3);
        QSearchChainReporter.searchChain.reqCtx = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        final long timeStamp2 = QSearchUtilKt.getTimeStamp();
        NetworkUtils.INSTANCE.requestWithCmd("trpc.unifysearch.unite.netresult/NetResult", createMSFReqBody, new UnifySearchRspBody(0, null, null, 0, null, null, null, null, 255, null), new Function1<UnifySearchRspBody, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo$doRequestDataByMsf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(UnifySearchRspBody unifySearchRspBody) {
                List<UnifySearchTabContent> list3;
                UnifySearchRspBody unifySearchRspBody2 = unifySearchRspBody;
                int timeStamp3 = (int) (QSearchUtilKt.getTimeStamp() - timeStamp2);
                int i16 = unifySearchRspBody2.resultCode;
                if (i16 != 0) {
                    QSearchReportKt.reportNetQuality("trpc.unifysearch.unite.netresult/NetResult", timeStamp3, i16, str);
                    QSearchContentNetRepo.access$notifyFail(this, unifySearchRspBody2.resultCode, unifySearchRspBody2.errorMsg, function5);
                } else {
                    QSearchChainReporter.SearchChain searchChain = QSearchChainReporter.searchChain;
                    Utils utils = Utils.INSTANCE;
                    searchChain.endReqCtx = utils.currentBridgeModule().currentTimeStamp();
                    StringBuilder m19 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("QSearchContentNetRepo doRequestDataByMsf success, costTime=", timeStamp3, " end=");
                    m19.append(unifySearchRspBody2.isEnd);
                    m19.append("\uff0csize=");
                    UnifySearchTabContentResult unifySearchTabContentResult = unifySearchRspBody2.tabContentResult;
                    m19.append((unifySearchTabContentResult == null || (list3 = unifySearchTabContentResult.resultItems) == null) ? 0 : list3.size());
                    utils.logToNative(m19.toString());
                    QSearchReportKt.reportNetQuality("trpc.unifysearch.unite.netresult/NetResult", timeStamp3, 0, str);
                    QSearchContentNetRepo qSearchContentNetRepo = this;
                    qSearchContentNetRepo.sessionInfoMSF = unifySearchRspBody2.sessionInfo;
                    qSearchContentNetRepo.busiSessionInfoMSf = unifySearchRspBody2.busiSessionInfo;
                    boolean z17 = unifySearchRspBody2.isEnd == 1;
                    qSearchContentNetRepo.isEnd = z17;
                    qSearchContentNetRepo.handleMSFReqSuccessResult(unifySearchRspBody2, function5, z17);
                }
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo$doRequestDataByMsf$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str5) {
                int intValue = num.intValue();
                QSearchReportKt.reportNetQuality("trpc.unifysearch.unite.netresult/NetResult", (int) (QSearchUtilKt.getTimeStamp() - timeStamp2), intValue, str);
                QSearchContentNetRepo.access$notifyFail(this, intValue, str5, function5);
                return Unit.INSTANCE;
            }
        });
    }
}
