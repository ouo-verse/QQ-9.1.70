package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$7;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCityDataModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache.QPlusTrafficCache;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetAccountRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetOverviewRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusQueryPromotionOptionsRsp;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class QPlusTrafficRepository {
    public static final QPlusTrafficRepository INSTANCE = new QPlusTrafficRepository();
    public static final Lazy accountCache$delegate;
    public static final Lazy overviewCache$delegate;

    static {
        Lazy lazy;
        Lazy lazy2;
        LazyKt__LazyJVMKt.lazy(new Function0<QPPromoteReceiverCityDataModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$cityDataModel$2
            @Override // kotlin.jvm.functions.Function0
            public final QPPromoteReceiverCityDataModel invoke() {
                return new QPPromoteReceiverCityDataModel();
            }
        });
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QPlusTrafficCache<QPlusGetAccountRsp>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$accountCache$2
            @Override // kotlin.jvm.functions.Function0
            public final QPlusTrafficCache<QPlusGetAccountRsp> invoke() {
                return new QPlusTrafficCache<>(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("QPlusTraffic_Account_", c.f117352a.g().getPageData().n().p("uin")), new QPlusGetAccountRsp(null, null, 3, null));
            }
        });
        accountCache$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QPlusTrafficCache<QPlusGetOverviewRsp>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$overviewCache$2
            @Override // kotlin.jvm.functions.Function0
            public final QPlusTrafficCache<QPlusGetOverviewRsp> invoke() {
                return new QPlusTrafficCache<>(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("QPlusTraffic_Overview_", c.f117352a.g().getPageData().n().p("uin")), new QPlusGetOverviewRsp(null, 1, null));
            }
        });
        overviewCache$delegate = lazy2;
        LazyKt__LazyJVMKt.lazy(new Function0<QPlusTrafficCache<QPlusQueryPromotionOptionsRsp>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$promotionOptionCache$2
            @Override // kotlin.jvm.functions.Function0
            public final QPlusTrafficCache<QPlusQueryPromotionOptionsRsp> invoke() {
                return new QPlusTrafficCache<>(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("QPlusTraffic_Promotion_Option_", c.f117352a.g().getPageData().n().p("uin")), new QPlusQueryPromotionOptionsRsp(null, null));
            }
        });
    }

    public final void reqAccountInfo(final Function1<? super QPlusGetAccountRsp, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
        QPlusGetAccountRsp qPlusGetAccountRsp = new QPlusGetAccountRsp(null, null, 3, null);
        Function2<QPlusGetAccountRsp, String, Unit> function22 = new Function2<QPlusGetAccountRsp, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqAccountInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(QPlusGetAccountRsp qPlusGetAccountRsp2, String str) {
                QPlusGetAccountRsp qPlusGetAccountRsp3 = qPlusGetAccountRsp2;
                ((QPlusTrafficCache) QPlusTrafficRepository.accountCache$delegate.getValue()).saveCache("", qPlusGetAccountRsp3, str);
                function1.invoke(qPlusGetAccountRsp3);
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e eVar = new e();
        QPlusTrafficRepository$requestWithCmd$1 qPlusTrafficRepository$requestWithCmd$1 = new QPlusTrafficRepository$requestWithCmd$1(function2, qPlusGetAccountRsp, function22);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest("trpc.ecom.qplus_deliver_access_svr.QplusAccessSvr/GetAccount", eVar, false, qPlusTrafficRepository$requestWithCmd$1);
    }

    public final void reqOrderDetail(String str, final Function1<? super QPlusGetPromotionDetailRsp, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2) {
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp = new QPlusGetPromotionDetailRsp(null);
        Function1<QPlusGetPromotionDetailRsp, Unit> function12 = new Function1<QPlusGetPromotionDetailRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqOrderDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp2) {
                function1.invoke(qPlusGetPromotionDetailRsp2);
                return Unit.INSTANCE;
            }
        };
        Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqOrderDetail$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                int intValue = num.intValue();
                function2.invoke(Integer.valueOf(intValue), str2);
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("plan_id", str);
        NetworkUtils$requestWithCmd$7 networkUtils$requestWithCmd$7 = new NetworkUtils$requestWithCmd$7(function22, qPlusGetPromotionDetailRsp, function12);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest("trpc.ecom.qplus_deliver_access_svr.QplusAccessSvr/GetPromotionDetail", m3, false, networkUtils$requestWithCmd$7);
    }
}
