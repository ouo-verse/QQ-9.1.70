package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache.QPlusTrafficCache;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStFeed;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStGetFeedListRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStGetFollowListRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStGetMainPageCommDataRsp;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* loaded from: classes31.dex */
public final class QPlusCirFeedRepository {
    public static final QPlusCirFeedRepository INSTANCE = new QPlusCirFeedRepository();
    public static final Lazy feedCache$delegate;
    public static final Lazy videoCache$delegate;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QPlusTrafficCache<QPlusCirStGetMainPageCommDataRsp>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusCirFeedRepository$videoCache$2
            @Override // kotlin.jvm.functions.Function0
            public final QPlusTrafficCache<QPlusCirStGetMainPageCommDataRsp> invoke() {
                return new QPlusTrafficCache<>(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("QPlusTraffic_video_", c.f117352a.g().getPageData().n().p("uin")), new QPlusCirStGetMainPageCommDataRsp(0, null, 0, null, 15, null));
            }
        });
        videoCache$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QPlusTrafficCache<QPlusCirStFeed>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusCirFeedRepository$feedCache$2
            @Override // kotlin.jvm.functions.Function0
            public final QPlusTrafficCache<QPlusCirStFeed> invoke() {
                return new QPlusTrafficCache<>("QPlusTraffic_feed_", new QPlusCirStFeed(null, null, null, 1023));
            }
        });
        feedCache$delegate = lazy2;
        LazyKt__LazyJVMKt.lazy(new Function0<QPlusTrafficCache<QPlusCirStGetFeedListRsp>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusCirFeedRepository$likeCache$2
            @Override // kotlin.jvm.functions.Function0
            public final QPlusTrafficCache<QPlusCirStGetFeedListRsp> invoke() {
                return new QPlusTrafficCache<>(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("QPlusTraffic_like_", c.f117352a.g().getPageData().n().p("uin")), new QPlusCirStGetFeedListRsp(null, 0, ""));
            }
        });
        LazyKt__LazyJVMKt.lazy(new Function0<QPlusTrafficCache<QPlusCirStGetFollowListRsp>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusCirFeedRepository$followCache$2
            @Override // kotlin.jvm.functions.Function0
            public final QPlusTrafficCache<QPlusCirStGetFollowListRsp> invoke() {
                return new QPlusTrafficCache<>(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("QPlusTraffic_follow_", c.f117352a.g().getPageData().n().p("uin")), new QPlusCirStGetFollowListRsp("", 0, null));
            }
        });
    }

    public final void reqCirFeedList(final String str, final String str2, final Function1<? super QPlusCirStGetMainPageCommDataRsp, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2) {
        QPlusCirStGetMainPageCommDataRsp qPlusCirStGetMainPageCommDataRsp = new QPlusCirStGetMainPageCommDataRsp(0, null, 0, null, 15, null);
        Function4<QPlusCirStGetMainPageCommDataRsp, String, Integer, String, Unit> function4 = new Function4<QPlusCirStGetMainPageCommDataRsp, String, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusCirFeedRepository$reqCirFeedList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(QPlusCirStGetMainPageCommDataRsp qPlusCirStGetMainPageCommDataRsp2, String str3, Integer num, String str4) {
                QPlusCirStGetMainPageCommDataRsp qPlusCirStGetMainPageCommDataRsp3 = qPlusCirStGetMainPageCommDataRsp2;
                String str5 = str3;
                int intValue = num.intValue();
                String str6 = str4;
                if (intValue == 0) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("cir feeds req success, [uin:");
                    m3.append(str);
                    m3.append(" count:");
                    ArrayList<QPlusCirStFeed> arrayList = qPlusCirStGetMainPageCommDataRsp3.vecFeed;
                    m3.append(arrayList != null ? arrayList.size() : 0);
                    m3.append(" end:");
                    m3.append(qPlusCirStGetMainPageCommDataRsp3.isFinish);
                    m3.append(']');
                    kLog.i("QPlus", m3.toString());
                    if (str2.length() == 0) {
                        ((QPlusTrafficCache) QPlusCirFeedRepository.videoCache$delegate.getValue()).saveCache(str, qPlusCirStGetMainPageCommDataRsp3, str5);
                    }
                    function1.invoke(qPlusCirStGetMainPageCommDataRsp3);
                } else {
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m16 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("cir feeds req failure, [uin:"), str, " code:", intValue, " msg:");
                    m16.append(str6);
                    m16.append(']');
                    kLog2.i("QPlus", m16.toString());
                    function2.invoke(Integer.valueOf(intValue), str6);
                }
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("userId", str, "from", 10);
        m3.v("feedAttchInfo", str2);
        e eVar = new e();
        QPlusCirFeedRepository$reqCirWithCmd$1 qPlusCirFeedRepository$reqCirWithCmd$1 = new QPlusCirFeedRepository$reqCirWithCmd$1(qPlusCirStGetMainPageCommDataRsp, function4);
        currentBridgeModule.getClass();
        e eVar2 = new e();
        eVar2.v("cmd", "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageCommData");
        eVar2.v("reqParam", m3);
        eVar2.v("rspProtoc", eVar);
        currentBridgeModule.callNativeMethod("cirRequest", eVar2, qPlusCirFeedRepository$reqCirWithCmd$1);
    }
}
