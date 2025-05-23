package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import n25.f;
import u25.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbySsoDoLikeRequestModel$Companion {
    public static void requestLikeStatusFeed$default(final boolean z16, final String str) {
        String str2;
        QQNearbyModule.Companion companion = QQNearbyModule.Companion;
        if (companion.getInstance().getUserInfo() != null) {
            QQNearbyModule.UserInfo userInfo = companion.getInstance().getUserInfo();
            final String str3 = "";
            if (userInfo == null || (str2 = userInfo.tid) == null) {
                str2 = "";
            }
            SsoDoLikeRequest ssoDoLikeRequest = new SsoDoLikeRequest(d.b(z16), str, str2);
            Function1<PbResponse<b>, Unit> function1 = new Function1<PbResponse<b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.model.NearbySsoDoLikeRequestModel$Companion$requestLikeStatusFeed$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(PbResponse<b> pbResponse) {
                    f fVar;
                    f fVar2;
                    PbResponse<b> pbResponse2 = pbResponse;
                    if (pbResponse2.success) {
                        k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
                        e eVar = new e();
                        Object obj = str;
                        boolean z17 = z16;
                        String str4 = str3;
                        b bVar = pbResponse2.rsp;
                        eVar.t("count", (bVar == null || (fVar2 = bVar.f438161d) == null) ? 0 : fVar2.f418062e);
                        eVar.v("feedId", obj);
                        eVar.t("isLike", z17 ? 1 : 0);
                        if (str4.length() > 0) {
                            eVar.v("extInfo", str4);
                        }
                        Unit unit = Unit.INSTANCE;
                        k.d(kVar, "NearbyFeedLikeStatusChangedEvent", eVar, false, 4, null);
                        KLog kLog = KLog.INSTANCE;
                        NearbyConst nearbyConst = NearbyConst.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestLikeStatusFeed success like count:");
                        b bVar2 = pbResponse2.rsp;
                        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, (bVar2 == null || (fVar = bVar2.f438161d) == null) ? null : Integer.valueOf(fVar.f418062e), kLog, "feed_detail_page");
                    } else {
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestLikeStatusFeed failure code:");
                        m16.append(pbResponse2.code);
                        m16.append(", message:");
                        m16.append(pbResponse2.f114187msg);
                        m16.append('}');
                        kLog2.i("feed_detail_page", m16.toString());
                    }
                    return Unit.INSTANCE;
                }
            };
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.like_svr.Like.SsoDoLike");
            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.sendPbRequest$default(ssoDoLikeRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
        }
    }
}
