package com.tencent.hippykotlin.demo.pages.nearby.public_account.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$handle$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$request$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.log.KLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import m25.c;
import n25.k;
import o25.e;
import o35.a;
import o35.d;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes31.dex */
public final class QQStrangerPublicAccountRepo {
    public c cardListCommonExt;
    public String cardListCookies = "";

    public final void fetchCardList(final boolean z16, int i3, e eVar, k kVar, final byte[] bArr, final Function3<? super Boolean, ? super byte[], ? super d, Unit> function3) {
        String str;
        if (z16) {
            str = this.cardListCookies;
        } else {
            str = "";
        }
        final String str2 = str;
        c cVar = z16 ? this.cardListCommonExt : null;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("start fetchCardList, ", i3, ", cookies:", str2, ", redExtSize:");
        m3.append(bArr.length);
        m3.append(", isMoreFetch:");
        m3.append(z16);
        m3.append(", commonExt:");
        m3.append(this.cardListCommonExt);
        kLog.i("QQStrangerPublicAccountRepo", m3.toString());
        GetCardListRequest getCardListRequest = new GetCardListRequest(i3, eVar, kVar, bArr, str2, cVar);
        Function4<d, byte[], Integer, String, Unit> function4 = new Function4<d, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.repo.QQStrangerPublicAccountRepo$fetchCardList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(d dVar, byte[] bArr2, Integer num, String str3) {
                List<a> list;
                String str4;
                d dVar2 = dVar;
                byte[] bArr3 = bArr2;
                int intValue = num.intValue();
                String str5 = str3;
                boolean z17 = intValue == 0;
                Integer num2 = null;
                if (z17) {
                    QQStrangerPublicAccountRepo qQStrangerPublicAccountRepo = QQStrangerPublicAccountRepo.this;
                    if (dVar2 == null || (str4 = dVar2.f421893f) == null) {
                        str4 = "";
                    }
                    qQStrangerPublicAccountRepo.cardListCookies = str4;
                    qQStrangerPublicAccountRepo.cardListCommonExt = dVar2 != null ? dVar2.f421894h : null;
                }
                function3.invoke(Boolean.valueOf(z17), bArr3, dVar2);
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("end fetchCardList: rspIsNull=");
                m16.append(dVar2 == null);
                m16.append(", code=");
                m16.append(intValue);
                m16.append(", msg=");
                m16.append(str5);
                m16.append(", end=");
                m16.append(dVar2 != null ? Boolean.valueOf(dVar2.f421892e) : null);
                m16.append(", visitor=");
                m16.append(dVar2 != null ? Boolean.valueOf(dVar2.f421895i) : null);
                m16.append(", cardSize=");
                if (dVar2 != null && (list = dVar2.f421891d) != null) {
                    num2 = Integer.valueOf(list.size());
                }
                m16.append(num2);
                m16.append(", reqCookies:");
                m16.append(str2);
                m16.append(", reqRedExtSize:");
                m16.append(bArr.length);
                m16.append(", rspCookies:");
                m16.append(QQStrangerPublicAccountRepo.this.cardListCookies);
                m16.append(", reqMoreFetch:");
                AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(m16, z16, kLog2, "QQStrangerPublicAccountRepo");
                return Unit.INSTANCE;
            }
        };
        c45.a aVar = new c45.a(i.d(getCardListRequest.getRequest()));
        int appId = getCardListRequest.getAppId();
        CommonProxyService$request$1 commonProxyService$request$1 = new CommonProxyService$request$1(function4, getCardListRequest);
        StringBuilder m16 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId, " service=", "QQStranger.CardSvr", " method=");
        m16.append("GetCardList");
        kLog.i("CommonProxyService", m16.toString());
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, appId + util.base64_pad_url + "QQStranger.CardSvr.GetCardList");
        CommonProxyRequest commonProxyRequest = new CommonProxyRequest(appId, "QQStranger.CardSvr", "GetCardList", aVar);
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest, null, new CommonProxyService$handle$1(aPICallTechReporter, commonProxyService$request$1), 6);
    }
}
