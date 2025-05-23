package com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model;

import c01.c;
import c45.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractMarkReadRequest;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveMsgListRequest;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo$fetchInteractiveMsgList$1;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo$markInteractiveAsRead$1;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import i35.b;
import j35.f;
import java.util.List;
import k35.j;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPInteractiveViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPInteractiveViewModel.class, "hadMoreData", "getHadMoreData()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPInteractiveViewModel.class, "mutualFollowText", "getMutualFollowText()Ljava/lang/String;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NBPInteractiveViewModel.class, "interactiveMsgList", "getInteractiveMsgList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPInteractiveViewModel.class, "pageState", "getPageState()I", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NBPInteractiveViewModel.class, "userList", "getUserList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public boolean isEnd;
    public boolean isRequesting;
    public final g pageData;
    public final ReadWriteProperty hadMoreData$delegate = c.a(Boolean.FALSE);
    public a cookie = new a(new byte[0]);
    public final ReadWriteProperty mutualFollowText$delegate = c.a("\u56de\u5173");
    public final ReadWriteProperty interactiveMsgList$delegate = c.b();
    public final ReadWriteProperty pageState$delegate = c.a(0);
    public final ReadWriteProperty userList$delegate = c.b();

    public NBPInteractiveViewModel(g gVar) {
        this.pageData = gVar;
    }

    public final void fetchFirstInteractiveMsgList() {
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        int j3 = this.pageData.n().j("unreadCount");
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("fetchFirstInteractiveMsgList unreadCount:", j3, ", cookie:"), this.cookie.f30291a.length, KLog.INSTANCE, "NBPInteractivePage");
        a aVar = this.cookie;
        Function1<f, Unit> function1 = new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel$fetchFirstInteractiveMsgList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(f fVar) {
                List emptyList;
                f fVar2 = fVar;
                List<b> list = fVar2 != null ? fVar2.f409218e : null;
                if (list == null) {
                    NBPInteractiveViewModel.this.setPageState(1);
                } else if (list.isEmpty()) {
                    NBPInteractiveViewModel.this.setPageState(3);
                } else {
                    NBPInteractiveViewModel nBPInteractiveViewModel = NBPInteractiveViewModel.this;
                    nBPInteractiveViewModel.cookie = fVar2.f409220h;
                    nBPInteractiveViewModel.setPageState(2);
                    NBPInteractiveViewModel.this.getInteractiveMsgList().addAll(list);
                    NBPInteractiveViewModel nBPInteractiveViewModel2 = NBPInteractiveViewModel.this;
                    nBPInteractiveViewModel2.hadMoreData$delegate.setValue(nBPInteractiveViewModel2, NBPInteractiveViewModel.$$delegatedProperties[0], Boolean.valueOf(fVar2.f409219f));
                    NBPInteractiveViewModel.this.isEnd = fVar2.f409219f;
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    KLog.INSTANCE.i("NBPInteractiveRepo", "mark interactive read ids:" + emptyList);
                    NBPInteractMarkReadRequest nBPInteractMarkReadRequest = new NBPInteractMarkReadRequest(emptyList);
                    NBPInteractiveRepo$markInteractiveAsRead$1 nBPInteractiveRepo$markInteractiveAsRead$1 = new Function1<PbResponse<u25.f>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo$markInteractiveAsRead$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(PbResponse<u25.f> pbResponse) {
                            PbResponse<u25.f> pbResponse2 = pbResponse;
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("markInteractiveAsRead, code: ");
                            m3.append(pbResponse2.code);
                            m3.append(", msg: ");
                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pbResponse2.f114187msg, kLog, "NBPInteractiveRepo");
                            Utils.INSTANCE.cacheModule("").setInt(NearbyProUtilsKt.getInteractiveNumCacheKey(), 0);
                            AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_AIO_LIST_CLEAR_MSG_EVENT", false, 4, null);
                            return Unit.INSTANCE;
                        }
                    };
                    APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.like_svr.Like.SsoMarkAsRead");
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPInteractMarkReadRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nBPInteractiveRepo$markInteractiveAsRead$1), 6);
                    QQNearbyModule.Companion.getInstance().asyncToNativeMethod("clearTianShuRedPoint", (e) null, (Function1<? super e, Unit>) null);
                }
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFirstInteractiveMsgList list size: ");
                m3.append(list != null ? Integer.valueOf(list.size()) : null);
                m3.append(", isEnd: ");
                m3.append(fVar2 != null ? Boolean.valueOf(fVar2.f409219f) : null);
                kLog.i("NBPInteractivePage", m3.toString());
                NBPInteractiveViewModel.this.isRequesting = false;
                return Unit.INSTANCE;
            }
        };
        if (j3 < 20) {
            j3 = 20;
        }
        NBPInteractiveMsgListRequest nBPInteractiveMsgListRequest = new NBPInteractiveMsgListRequest(j3, aVar);
        NBPInteractiveRepo$fetchInteractiveMsgList$1 nBPInteractiveRepo$fetchInteractiveMsgList$1 = new NBPInteractiveRepo$fetchInteractiveMsgList$1(function1);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.interact_svr.Interact.SsoGetInteractMsgList");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPInteractiveMsgListRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nBPInteractiveRepo$fetchInteractiveMsgList$1), 6);
    }

    public final void fetchFirstInteractiveUserList() {
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        NBPInteractiveRepo.fetchInteractUserList$default(this.pageData.n().j("mid"), this.cookie, new Function1<k35.g, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel$fetchFirstInteractiveUserList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(k35.g gVar) {
                k35.g gVar2 = gVar;
                List<j> list = gVar2 != null ? gVar2.f411548d : null;
                if (list == null) {
                    NBPInteractiveViewModel.this.setPageState(1);
                } else if (list.isEmpty()) {
                    NBPInteractiveViewModel.this.setPageState(3);
                } else {
                    NBPInteractiveViewModel nBPInteractiveViewModel = NBPInteractiveViewModel.this;
                    nBPInteractiveViewModel.cookie = gVar2.f411550f;
                    nBPInteractiveViewModel.setPageState(2);
                    NBPInteractiveViewModel.this.getUserList().addAll(list);
                    NBPInteractiveViewModel nBPInteractiveViewModel2 = NBPInteractiveViewModel.this;
                    nBPInteractiveViewModel2.hadMoreData$delegate.setValue(nBPInteractiveViewModel2, NBPInteractiveViewModel.$$delegatedProperties[0], Boolean.valueOf(gVar2.f411549e));
                    NBPInteractiveViewModel.this.isEnd = gVar2.f411549e;
                }
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFirstInteractiveUserList size:");
                m3.append(list != null ? Integer.valueOf(list.size()) : null);
                m3.append(", isEnd:");
                m3.append(gVar2 != null ? Boolean.valueOf(gVar2.f411549e) : null);
                m3.append(", cookie:");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, NBPInteractiveViewModel.this.cookie.f30291a.length, kLog, "NBPInteractivePage");
                NBPInteractiveViewModel.this.isRequesting = false;
                return Unit.INSTANCE;
            }
        });
    }

    public final com.tencent.kuikly.core.reactive.collection.c<b> getInteractiveMsgList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.interactiveMsgList$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final int getPageState() {
        return ((Number) this.pageState$delegate.getValue(this, $$delegatedProperties[3])).intValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<j> getUserList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.userList$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final void reportInteractive(String str, String str2, String str3, Integer num) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_interact_msg_list", "dt_eid", str2);
        m3.v("nearby_circle_type", num);
        m3.v("nearby_user_from", str3);
        e eVar = new e();
        eVar.v("dt_pgid", "pg_nearby_interact_msg_list");
        eVar.v("nearby_user_from", str3);
        Unit unit = Unit.INSTANCE;
        m3.v("cur_pg", eVar);
        m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, m3);
    }

    public final void setPageState(int i3) {
        this.pageState$delegate.setValue(this, $$delegatedProperties[3], Integer.valueOf(i3));
    }
}
