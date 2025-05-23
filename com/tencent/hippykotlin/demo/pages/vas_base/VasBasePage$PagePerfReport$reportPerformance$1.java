package com.tencent.hippykotlin.demo.pages.vas_base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.LaunchTimestamps;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQPerformance;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.Query;
import com.tencent.hippykotlin.demo.pages.foundation.lib.ReportAttaData;
import com.tencent.hippykotlin.demo.pages.foundation.lib.VersionMode;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqDevice;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPerformanceModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$PagePerfReport$reportPerformance$1", f = "VasBasePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class VasBasePage$PagePerfReport$reportPerformance$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ VasBasePage.PagePerfReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasBasePage$PagePerfReport$reportPerformance$1(VasBasePage.PagePerfReport pagePerfReport, Continuation<? super VasBasePage$PagePerfReport$reportPerformance$1> continuation) {
        super(2, continuation);
        this.this$0 = pagePerfReport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VasBasePage$PagePerfReport$reportPerformance$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((VasBasePage$PagePerfReport$reportPerformance$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x00be, code lost:
    
        if (((com.tencent.kuikly.core.module.t) r16.g().acquireModule("KRTurboDisplayModule")).a() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00c0, code lost:
    
        r3 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00ab, code lost:
    
        if ((com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils.INSTANCE.compare("9.0.35") >= 0) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0094, code lost:
    
        if ((com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils.INSTANCE.compare("9.0.0") >= 0) == false) goto L13;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Map mapOf;
        String str;
        String str2;
        VersionMode versionMode;
        Map mapOf2;
        Map<String, String> plus;
        boolean startsWith$default;
        long j3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        QQPerformance qQPerformance = QQPerformance.INSTANCE;
        String pageName = this.this$0.page.getPageName();
        VasBasePage.PagePerfReport pagePerfReport = this.this$0;
        long j16 = pagePerfReport.firstScreenShowedTime;
        if (j16 <= 0) {
            j16 = pagePerfReport.viewDidLoadTime;
        }
        long j17 = j16;
        c cVar = c.f117352a;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("ext1", String.valueOf(PageDataExtKt.getResVersion(cVar.g().getPageData()))), TuplesKt.to("ext2", ((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getDeviceInfo().systemVersion));
        final ReportAttaData reportAttaData = new ReportAttaData(pageName, j17, "", 2, mapOf, 0);
        final LaunchTimestamps launchTimestamps = qQPerformance.getLaunchTimestamps();
        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
        }
        if (k.a(cVar)) {
        }
        int i3 = 1;
        if (i3 == 4) {
            Long valueOf = Long.valueOf(launchTimestamps.renderLayerRenderCacheStart);
            if (!(valueOf.longValue() != 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                j3 = valueOf.longValue();
            } else {
                j3 = launchTimestamps.contentViewCreated;
            }
            str = String.valueOf(j3);
        } else if (j17 > 0) {
            str = String.valueOf(j17);
        } else {
            str = "0";
        }
        Pair[] pairArr = new Pair[24];
        pairArr[0] = TuplesKt.to("attaid", "06f00076856");
        pairArr[1] = TuplesKt.to("token", "4916318627");
        pairArr[2] = TuplesKt.to("business", "qqvip");
        pairArr[3] = TuplesKt.to("page", pageName);
        pairArr[4] = TuplesKt.to("type", "4");
        pairArr[5] = TuplesKt.to("click_start", String.valueOf(launchTimestamps.openPage));
        pairArr[6] = TuplesKt.to("engine_start", String.valueOf(launchTimestamps.fetchContextEnd));
        pairArr[7] = TuplesKt.to("module_start", String.valueOf(launchTimestamps.viewLoadStart));
        pairArr[8] = TuplesKt.to("module_end", String.valueOf(launchTimestamps.viewLoadEnd));
        pairArr[9] = TuplesKt.to("first_frame_view", String.valueOf(launchTimestamps.contentViewCreated));
        pairArr[10] = TuplesKt.to("first_screen_view", str);
        pairArr[11] = TuplesKt.to("inter_act", "");
        pairArr[12] = TuplesKt.to("cache_mode", String.valueOf(1));
        if (k.a(cVar)) {
            str2 = "android";
        } else {
            str2 = "ios";
        }
        pairArr[13] = TuplesKt.to("platform", str2);
        Map<QQKuiklyPlatformApi.QQNetworkType, String> map = ((MqqDevice) Mqq.device$delegate.getValue()).networkTypeMap;
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        String str3 = map.get(companion.getNetworkType());
        if (str3 == null) {
            str3 = "Unknown";
        }
        pairArr[14] = TuplesKt.to("network", str3);
        pairArr[15] = TuplesKt.to("qua", cVar.g().getPageData().getAppVersion());
        pairArr[16] = TuplesKt.to("load_mode", String.valueOf(BoxType$EnumUnboxingSharedUtility.ordinal(i3)));
        pairArr[17] = TuplesKt.to("uin", companion.getUin());
        pairArr[18] = TuplesKt.to("device", ((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getDeviceInfo().model);
        pairArr[19] = TuplesKt.to("ip", "");
        pairArr[20] = TuplesKt.to("offline_mode", String.valueOf(BoxType$EnumUnboxingSharedUtility.ordinal(launchTimestamps.isForceUpdate ? 1 : 2)));
        pairArr[21] = TuplesKt.to("offline_version", String.valueOf(PageDataExtKt.getResVersion(cVar.g().getPageData())));
        if (cVar.g().getPageData().u()) {
            versionMode = VersionMode.Debug;
        } else if (PageDataExtKt.isPublic(cVar.g().getPageData())) {
            versionMode = VersionMode.Public;
        } else {
            versionMode = VersionMode.CI;
        }
        pairArr[22] = TuplesKt.to("ext12", String.valueOf(versionMode.mode));
        pairArr[23] = TuplesKt.to("report_version", "1");
        mapOf2 = MapsKt__MapsKt.mapOf(pairArr);
        final Query query = new Query(mapOf2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (mapOf != null) {
            for (Map.Entry entry : mapOf.entrySet()) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) entry.getKey(), "ext", false, 2, null);
                if (startsWith$default) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        plus = MapsKt__MapsKt.plus(query.query, linkedHashMap);
        query.query = plus;
        c cVar2 = c.f117352a;
        if (cVar2.g().getPageData().u()) {
            KLog kLog = KLog.INSTANCE;
            String pageName2 = cVar2.g().getPageName();
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[reportPerformance-debug] not report, cost: ");
            m3.append(qQPerformance.getLaunchCost());
            m3.append(" firstScreenCost: ");
            m3.append(reportAttaData.firstScreen - launchTimestamps.openPage);
            m3.append(", query:");
            m3.append(query);
            kLog.i(pageName2, m3.toString());
        } else {
            QQKuiklyPerformanceModule qQKuiklyPerformanceModule = (QQKuiklyPerformanceModule) cVar2.g().acquireModule("QQKuiklyPerformanceModule");
            String query2 = query.toString();
            Function1<? super e, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.QQPerformance$reportAtta$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj2) {
                    KLog kLog2 = KLog.INSTANCE;
                    String pageName3 = c.f117352a.g().getPageName();
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("reportPerformance cost: ");
                    m16.append(QQPerformance.INSTANCE.getLaunchCost());
                    m16.append(" firstScreenCost:");
                    m16.append(ReportAttaData.this.firstScreen - launchTimestamps.openPage);
                    m16.append(", reportAtta ");
                    m16.append(obj2);
                    m16.append(" query:");
                    m16.append(query);
                    kLog2.i(pageName3, m16.toString());
                    return Unit.INSTANCE;
                }
            };
            qQKuiklyPerformanceModule.getClass();
            if (k.a(cVar2)) {
                if (!(QQUtils.INSTANCE.compare("8.9.88") >= 0)) {
                    function1.invoke(-1);
                }
            }
            if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar2)) {
                if (!(QQUtils.INSTANCE.compare("8.9.90") >= 0)) {
                    function1.invoke(-1);
                }
            }
            e eVar = new e();
            eVar.v("attainfo", query2);
            qQKuiklyPerformanceModule.asyncToNativeMethod("reportPerformanceToAtta", eVar, function1);
        }
        return Unit.INSTANCE;
    }
}
