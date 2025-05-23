package com.tencent.hippykotlin.demo.pages.nearby.feed_like;

import c01.c;
import c45.a;
import c45.i;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$handle$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$request$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerGetLikeInfoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;
import p35.ac;
import p35.x;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPFeedLikeViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedLikeViewModel.class, "likedUsers", "getLikedUsers()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedLikeViewModel.class, QFSSearchBaseRequest.EXTRA_KEY_USER_COUNT, "getUserCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedLikeViewModel.class, "pageState", "getPageState()I", 0)};
    public final String feedId;
    public boolean isEnd;
    public boolean isRequesting;
    public final String likeKey;
    public StrangerFeedRepo repo;
    public int retryCount;
    public final String userId;
    public final ReadWriteProperty likedUsers$delegate = c.b();
    public final ReadWriteProperty userCount$delegate = c.a(0);
    public String mLikeAttachInfo = "";
    public final ReadWriteProperty pageState$delegate = c.a(0);

    public NBPFeedLikeViewModel(int i3, String str, String str2, String str3) {
        this.likeKey = str;
        this.feedId = str2;
        this.userId = str3;
        this.repo = new StrangerFeedRepo(i3);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<af> getLikedUsers() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.likedUsers$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final int getPageState() {
        return ((Number) this.pageState$delegate.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final int getUserCount() {
        return ((Number) this.userCount$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final void requestFeedLikeList() {
        if ((getUserCount() <= getLikedUsers().size() && getUserCount() > 0) || this.isEnd || this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        KLog kLog = KLog.INSTANCE;
        kLog.i("NBPFeedLikeViewModel", "begin requestFeedLikeList");
        StrangerFeedRepo strangerFeedRepo = this.repo;
        if (strangerFeedRepo != null) {
            String str = this.userId;
            String str2 = this.likeKey;
            String str3 = this.mLikeAttachInfo;
            String str4 = this.feedId;
            final Function3<x, Integer, String, Unit> function3 = new Function3<x, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikeViewModel$requestFeedLikeList$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(x xVar, Integer num, String str5) {
                    String str6;
                    List<af> list;
                    x xVar2 = xVar;
                    String str7 = str5;
                    if (num.intValue() == 0 && xVar2 != null) {
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("likeInfo count: ");
                        ac acVar = xVar2.f425225d;
                        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, acVar != null ? Integer.valueOf(acVar.f425120e) : null, kLog2, "NBPFeedLikeViewModel");
                        ac acVar2 = xVar2.f425225d;
                        if (acVar2 != null && (list = acVar2.f425121f) != null) {
                            NBPFeedLikeViewModel.this.getLikedUsers().addAll(list);
                        }
                        NBPFeedLikeViewModel nBPFeedLikeViewModel = NBPFeedLikeViewModel.this;
                        ac acVar3 = xVar2.f425225d;
                        nBPFeedLikeViewModel.userCount$delegate.setValue(nBPFeedLikeViewModel, NBPFeedLikeViewModel.$$delegatedProperties[1], Integer.valueOf(acVar3 != null ? acVar3.f425120e : 0));
                        NBPFeedLikeViewModel.this.setPageState(2);
                        ac acVar4 = xVar2.f425225d;
                        String str8 = acVar4 != null ? acVar4.f425123i : null;
                        if (str8 == null || str8.length() == 0) {
                            NBPFeedLikeViewModel.this.isEnd = true;
                        }
                        NBPFeedLikeViewModel nBPFeedLikeViewModel2 = NBPFeedLikeViewModel.this;
                        ac acVar5 = xVar2.f425225d;
                        if (acVar5 == null || (str6 = acVar5.f425123i) == null) {
                            str6 = "";
                        }
                        nBPFeedLikeViewModel2.mLikeAttachInfo = str6;
                    } else {
                        KLog kLog3 = KLog.INSTANCE;
                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("Error fetching like info: ", str7, kLog3, "NBPFeedLikeViewModel");
                        final NBPFeedLikeViewModel nBPFeedLikeViewModel3 = NBPFeedLikeViewModel.this;
                        int i3 = nBPFeedLikeViewModel3.retryCount;
                        if (i3 < 3) {
                            nBPFeedLikeViewModel3.retryCount = i3 + 1;
                            TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikeViewModel$requestFeedLikeList$1.2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    NBPFeedLikeViewModel.this.requestFeedLikeList();
                                    return Unit.INSTANCE;
                                }
                            });
                        } else {
                            ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch like info error, retryCount: "), NBPFeedLikeViewModel.this.retryCount, kLog3, "NBPFeedLikeViewModel");
                            NBPFeedLikeViewModel.this.setPageState(1);
                        }
                    }
                    NBPFeedLikeViewModel.this.isRequesting = false;
                    return Unit.INSTANCE;
                }
            };
            StringBuilder sb5 = new StringBuilder();
            sb5.append("fetchLikeInfo: reqType=");
            sb5.append(1);
            sb5.append(" needCount=");
            sb5.append(1);
            sb5.append(" userId=");
            StringBuilder m3 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(VasBusinessReportData$$ExternalSyntheticOutline0.m(sb5, str, " likeKey=", str2, " roundParam="), str3, " count=", 15, " feedId=");
            m3.append(str4);
            kLog.i("StrangerFeedRepo", m3.toString());
            StrangerGetLikeInfoRequest strangerGetLikeInfoRequest = new StrangerGetLikeInfoRequest(strangerFeedRepo.appId, str, str2, str3, str4);
            Function4<x, byte[], Integer, String, Unit> function4 = new Function4<x, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedRepo$fetchLikeInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public final Unit invoke(x xVar, byte[] bArr, Integer num, String str5) {
                    ac acVar;
                    ac acVar2;
                    ac acVar3;
                    x xVar2 = xVar;
                    int intValue = num.intValue();
                    String str6 = str5;
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchLikeInfo: rspCount=");
                    Integer num2 = null;
                    m16.append((xVar2 == null || (acVar3 = xVar2.f425225d) == null) ? null : Integer.valueOf(acVar3.f425120e));
                    m16.append(", code=");
                    m16.append(intValue);
                    m16.append(", msg=");
                    m16.append(str6);
                    m16.append(" \u70b9\u8d5e\u6570 ");
                    m16.append((xVar2 == null || (acVar2 = xVar2.f425225d) == null) ? null : Integer.valueOf(acVar2.f425120e));
                    m16.append(" \u6211\u8d5e ");
                    if (xVar2 != null && (acVar = xVar2.f425225d) != null) {
                        num2 = Integer.valueOf(acVar.f425122h);
                    }
                    m16.append(num2);
                    m16.append(TokenParser.SP);
                    kLog2.i("StrangerFeedRepo", m16.toString());
                    function3.invoke(xVar2, Integer.valueOf(intValue), str6);
                    return Unit.INSTANCE;
                }
            };
            a aVar = new a(i.d(strangerGetLikeInfoRequest.getRequest()));
            int appId = strangerGetLikeInfoRequest.getAppId();
            CommonProxyService$request$1 commonProxyService$request$1 = new CommonProxyService$request$1(function4, strangerGetLikeInfoRequest);
            StringBuilder m16 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId, " service=", "QQStranger.FeedSvr", " method=");
            m16.append("GetLikeInfo");
            kLog.i("CommonProxyService", m16.toString());
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, appId + util.base64_pad_url + "QQStranger.FeedSvr.GetLikeInfo");
            CommonProxyRequest commonProxyRequest = new CommonProxyRequest(appId, "QQStranger.FeedSvr", "GetLikeInfo", aVar);
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest, null, new CommonProxyService$handle$1(aPICallTechReporter, commonProxyService$request$1), 6);
        }
    }

    public final void setPageState(int i3) {
        this.pageState$delegate.setValue(this, $$delegatedProperties[2], Integer.valueOf(i3));
    }
}
