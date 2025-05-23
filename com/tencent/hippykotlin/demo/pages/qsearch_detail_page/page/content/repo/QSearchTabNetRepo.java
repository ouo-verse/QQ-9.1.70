package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo;

import c45.a;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$7;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchNetResultTabsRsp;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchChainReporter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchReportKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.SearchNetApi$sendOidbPbRequest$1;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import defpackage.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTabNetRepo {
    public final String appVersion;
    public boolean nightMode;
    public boolean studyMode;

    public QSearchTabNetRepo(g gVar) {
        this.appVersion = gVar.getAppVersion();
        this.studyMode = gVar.n().g("study_mode_status", false);
        this.nightMode = PageDataExtKt.isNightMode(gVar);
    }

    public static final void access$nofityFail(QSearchTabNetRepo qSearchTabNetRepo, int i3, String str, final Function2 function2) {
        qSearchTabNetRepo.getClass();
        Utils.INSTANCE.logToNative("QSearchTabNetRepo requestData failed, errorCode=" + i3 + ", errorMsg=" + str);
        TimerKt.d(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchTabNetRepo$nofityFail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                function2.invoke(Boolean.FALSE, null);
                return Unit.INSTANCE;
            }
        });
    }

    public final String getExtensionData(int i3) {
        e m3 = RoleCardKt$$ExternalSyntheticOutline0.m(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, i3);
        m3.u("sourceVersion", com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt.getResVersion(c.f117352a.g().getPageData()));
        return m3.toString();
    }

    public final void loadTabs(int i3, boolean z16, final Function2<? super Boolean, ? super NetReqTabRsp, Unit> function2) {
        byte[] encodeToByteArray;
        if (z16) {
            QSearchUtilKt.fastLog("QSearchTabNetRepo requestDataByOIDB begin", true);
            final long timeStamp = QSearchUtilKt.getTimeStamp();
            Utils utils = Utils.INSTANCE;
            String base64Code = utils.currentBridgeModule().base64Code(getExtensionData(i3), true);
            String str = this.appVersion;
            kuikly.com.tencent.trpcprotocol.search.unifysearch.c cVar = new kuikly.com.tencent.trpcprotocol.search.unifysearch.c(k.a(c.f117352a) ? 2 : 0, this.studyMode, this.nightMode, 17);
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(base64Code);
            SearchReqGetTabs searchReqGetTabs = new SearchReqGetTabs(str, cVar, new a(encodeToByteArray));
            QSearchChainReporter.searchChain.reqTab = utils.currentBridgeModule().currentTimeStamp();
            QQKuiklyPlatformApi.Companion.sendOIDBRequest(searchReqGetTabs, false, new SearchNetApi$sendOidbPbRequest$1(QSearchUtilKt.getTimeStamp(), searchReqGetTabs, new Function1<OIDBResponse<kuikly.com.tencent.trpcprotocol.search.unifysearch.k>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchTabNetRepo$requestDataByOIDB$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(OIDBResponse<kuikly.com.tencent.trpcprotocol.search.unifysearch.k> oIDBResponse) {
                    OIDBResponse<kuikly.com.tencent.trpcprotocol.search.unifysearch.k> oIDBResponse2 = oIDBResponse;
                    int i16 = oIDBResponse2.code;
                    if (i16 != 0) {
                        QSearchTabNetRepo.access$nofityFail(QSearchTabNetRepo.this, i16, oIDBResponse2.f114186msg, function2);
                    } else {
                        QSearchChainReporter.searchChain.endReqTab = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
                        kuikly.com.tencent.trpcprotocol.search.unifysearch.k kVar = oIDBResponse2.rsp;
                        if (kVar != null) {
                            if (kVar.f413214d != 0) {
                                QSearchTabNetRepo.access$nofityFail(QSearchTabNetRepo.this, oIDBResponse2.code, oIDBResponse2.f114186msg, function2);
                            } else {
                                QSearchUtilKt.fastLog("QSearchTabNetRepo requestDataByOIDB success, costTime=" + ((int) (QSearchUtilKt.getTimeStamp() - timeStamp)), true);
                                function2.invoke(Boolean.TRUE, new NetReqTabRsp(kVar, null));
                            }
                        } else {
                            QSearchTabNetRepo.access$nofityFail(QSearchTabNetRepo.this, -1, "requestDataByOIDB no rsp body", function2);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }));
            return;
        }
        QSearchUtilKt.fastLog("QSearchTabNetRepo requestDataByMsf begin", true);
        String str2 = this.appVersion;
        Utils utils2 = Utils.INSTANCE;
        String base64Code2 = utils2.currentBridgeModule().base64Code(getExtensionData(i3), true);
        boolean z17 = this.studyMode;
        boolean z18 = this.nightMode;
        final long timeStamp2 = QSearchUtilKt.getTimeStamp();
        QSearchChainReporter.searchChain.reqTab = utils2.currentBridgeModule().currentTimeStamp();
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        UnifySearchNetResultTabsRsp unifySearchNetResultTabsRsp = new UnifySearchNetResultTabsRsp(0, null, null, null, 0, 31, null);
        Function1<UnifySearchNetResultTabsRsp, Unit> function1 = new Function1<UnifySearchNetResultTabsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchTabNetRepo$requestDataByMsf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(UnifySearchNetResultTabsRsp unifySearchNetResultTabsRsp2) {
                UnifySearchNetResultTabsRsp unifySearchNetResultTabsRsp3 = unifySearchNetResultTabsRsp2;
                int timeStamp3 = (int) (QSearchUtilKt.getTimeStamp() - timeStamp2);
                QSearchReportKt.reportNetQuality("trpc.unifysearch.unite.netresult/NetResultTabs", timeStamp3, 0, "");
                QSearchChainReporter.searchChain.endReqTab = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
                int i16 = unifySearchNetResultTabsRsp3.resultCode;
                if (i16 != 0) {
                    QSearchTabNetRepo.access$nofityFail(this, i16, unifySearchNetResultTabsRsp3.errorMsg, function2);
                } else {
                    QSearchUtilKt.fastLog("QSearchTabNetRepo requestDataByMsf success, costTime=" + timeStamp3, true);
                    function2.invoke(Boolean.TRUE, new NetReqTabRsp(null, unifySearchNetResultTabsRsp3));
                }
                return Unit.INSTANCE;
            }
        };
        Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchTabNetRepo$requestDataByMsf$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str3) {
                int intValue = num.intValue();
                QSearchReportKt.reportNetQuality("trpc.unifysearch.unite.netresult/NetResultTabs", (int) (QSearchUtilKt.getTimeStamp() - timeStamp2), intValue, "");
                QSearchTabNetRepo.access$nofityFail(this, intValue, str3, function2);
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = utils2.currentBridgeModule();
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("version", str2, MimeTypeParser.ATTR_EXTENSION, base64Code2);
        e eVar = new e();
        eVar.w("study_mode_status", z17);
        eVar.w("night_mode_status", z18);
        m3.v("device_info", eVar);
        currentBridgeModule.ssoRequest("trpc.unifysearch.unite.netresult/NetResultTabs", m3, false, new NetworkUtils$requestWithCmd$7(function22, unifySearchNetResultTabsRsp, function1));
    }
}
