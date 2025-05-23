package com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils;

import c45.d;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import defpackage.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import oicq.wlogin_sdk.tools.util;
import zz0.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class VasReporter implements c, b {
    public static final Companion Companion = new Companion();
    public static final Set<String> OPEN_TWO_PAGES_LIST;
    public static final int[] STAY_ARRAY_DEFAULT;
    public final VasBusinessReportData businessData;
    public int clickCount;
    public long createTime;
    public boolean hasReportHeartbeat;
    public boolean isPageDestroyFlag;
    public boolean isPageInvisibleFlag;
    public boolean isPageVisible;
    public long lastReportHeartbeatTimestamp;
    public final Function1<String, Unit> logger;
    public final com.tencent.kuikly.core.pager.b pager;
    public long popBackActionCalledTimestamp;
    public int scrollCount;
    public String sessionId = "";
    public long visibleTime;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final String getPlatform() {
            com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
            if (PageDataExtKt.isIpad(cVar.g().getPageData())) {
                return "ipad";
            }
            if (k.a(cVar)) {
                return "android";
            }
            if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
                return "iphone";
            }
            return "unknown";
        }

        public final String reportListToString(List<VasReportFullData> list) {
            Iterator<T> it = list.iterator();
            String str = "";
            while (it.hasNext()) {
                str = str + ((VasReportFullData) it.next());
            }
            return str;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object reportWeData(List<VasReportFullData> list, Function1<? super String, Unit> function1, Continuation<? super Unit> continuation) {
            VasReporter$Companion$reportWeData$2 vasReporter$Companion$reportWeData$2;
            Object coroutine_suspended;
            int i3;
            int collectionSizeOrDefault;
            Continuation intercepted;
            Object coroutine_suspended2;
            Companion companion;
            OIDBResponse oIDBResponse;
            if (continuation instanceof VasReporter$Companion$reportWeData$2) {
                vasReporter$Companion$reportWeData$2 = (VasReporter$Companion$reportWeData$2) continuation;
                int i16 = vasReporter$Companion$reportWeData$2.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    vasReporter$Companion$reportWeData$2.label = i16 - Integer.MIN_VALUE;
                    Object obj = vasReporter$Companion$reportWeData$2.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = vasReporter$Companion$reportWeData$2.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        Iterator<T> it = list.iterator();
                        if (!it.hasNext()) {
                            MapsKt__MapsKt.emptyMap();
                            final kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.b bVar = new kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.b("negative_feedback", arrayList);
                            final VasReporter$Companion$reportWeData$response$1 vasReporter$Companion$reportWeData$response$1 = new Function1<byte[], kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.c>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasReporter$Companion$reportWeData$response$1
                                @Override // kotlin.jvm.functions.Function1
                                public final kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.c invoke(byte[] bArr) {
                                    return (kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.c) i.a(kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.c.f413171d, bArr);
                                }
                            };
                            vasReporter$Companion$reportWeData$2.L$0 = this;
                            vasReporter$Companion$reportWeData$2.L$1 = list;
                            vasReporter$Companion$reportWeData$2.L$2 = function1;
                            vasReporter$Companion$reportWeData$2.label = 1;
                            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(vasReporter$Companion$reportWeData$2);
                            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                            QQKuiklyPlatformApi.Companion.sendOIDBRequest(new BaseOIDBRequest<d, d>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasPbOIDBRequest$pbOIDBRequest$2$request$1
                                public final int oidbServiceType = 0;
                                public final int oidbCmd = 37818;

                                @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
                                public final d decodeResponse(byte[] bArr) {
                                    return vasReporter$Companion$reportWeData$response$1.invoke(bArr);
                                }

                                @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
                                public final int getOidbCmd() {
                                    return this.oidbCmd;
                                }

                                @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
                                public final int getOidbServiceType() {
                                    return this.oidbServiceType;
                                }

                                @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
                                public final d getRequest() {
                                    return d.this;
                                }
                            }, false, new Function1<OIDBResponse<d>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasPbOIDBRequest$pbOIDBRequest$2$1
                                public final /* synthetic */ int $cmd = 37818;
                                public final /* synthetic */ int $type = 0;

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(OIDBResponse<d> oIDBResponse2) {
                                    OIDBResponse<d> oIDBResponse3 = oIDBResponse2;
                                    if (!oIDBResponse3.success) {
                                        KLog kLog = KLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("VasPbOIDBRequest error cmd[");
                                        m3.append(this.$cmd);
                                        m3.append("] type[");
                                        m3.append(this.$type);
                                        m3.append("] code[");
                                        m3.append(oIDBResponse3.code);
                                        m3.append("] msg[");
                                        m3.append(oIDBResponse3.f114186msg);
                                        m3.append(']');
                                        kLog.e("VasPbOIDBRequest", m3.toString());
                                    }
                                    Continuation.this.resumeWith(Result.m476constructorimpl(oIDBResponse3));
                                    return Unit.INSTANCE;
                                }

                                {
                                    super(1);
                                }
                            });
                            obj = safeContinuation.getOrThrow();
                            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (obj == coroutine_suspended2) {
                                DebugProbes.probeCoroutineSuspended(vasReporter$Companion$reportWeData$2);
                            }
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            companion = this;
                        } else {
                            ((VasReportFullData) it.next()).businessData.getClass();
                            throw null;
                        }
                    } else if (i3 == 1) {
                        function1 = vasReporter$Companion$reportWeData$2.L$2;
                        list = vasReporter$Companion$reportWeData$2.L$1;
                        companion = vasReporter$Companion$reportWeData$2.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    oIDBResponse = (OIDBResponse) obj;
                    if (oIDBResponse.success) {
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("report fail, code=");
                        m3.append(oIDBResponse.code);
                        m3.append(", msg=");
                        m3.append(oIDBResponse.f114186msg);
                        m3.append(", reportList=");
                        m3.append(companion.reportListToString(list));
                        String sb5 = m3.toString();
                        KLog.INSTANCE.e("VasReporter", sb5);
                        if (function1 != null) {
                            function1.invoke(sb5);
                        }
                    } else if (function1 != null) {
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("report success, code=");
                        m16.append(oIDBResponse.code);
                        m16.append(", msg=");
                        m16.append(oIDBResponse.f114186msg);
                        m16.append(", reportList=");
                        m16.append(companion.reportListToString(list));
                        function1.invoke(m16.toString());
                    }
                    return Unit.INSTANCE;
                }
            }
            vasReporter$Companion$reportWeData$2 = new VasReporter$Companion$reportWeData$2(this, continuation);
            Object obj2 = vasReporter$Companion$reportWeData$2.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = vasReporter$Companion$reportWeData$2.label;
            if (i3 != 0) {
            }
            oIDBResponse = (OIDBResponse) obj2;
            if (oIDBResponse.success) {
            }
            return Unit.INSTANCE;
        }
    }

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"vas_qqvip_root_page", "vas_gxh_shop", "vas_qqvip_telecom_home"});
        OPEN_TWO_PAGES_LIST = of5;
        STAY_ARRAY_DEFAULT = new int[]{1000, 2000, 3000, 5000, 7000, 9000, 15000};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VasReporter(com.tencent.kuikly.core.pager.b bVar, VasBusinessReportData vasBusinessReportData, Function1<? super String, Unit> function1) {
        this.pager = bVar;
        this.businessData = vasBusinessReportData;
        this.logger = function1;
        onCreate();
    }

    public static final boolean access$shouldStopReportHeartbeat(VasReporter vasReporter) {
        return vasReporter.isPageDestroyFlag || vasReporter.isPageInvisibleFlag;
    }

    public final void debugLog(String str) {
        Function1 function1 = this.logger;
        if (function1 == null) {
            function1 = VasReporter$getLogger$1.INSTANCE;
        }
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("page=");
        m3.append(this.pager.getPageName());
        m3.append(", log=");
        m3.append(str);
        function1.invoke(m3.toString());
    }

    public final void onCreate() {
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar) && OPEN_TWO_PAGES_LIST.contains(this.pager.getPageName())) {
            this.businessData.getClass();
            throw null;
        }
        this.businessData.getClass();
        this.createTime = a.f453719a.a();
        this.sessionId = cVar.g().getPageData().n().q("uin", "") + util.base64_pad_url + this.createTime + util.base64_pad_url + RandomKt.Random(this.createTime).nextInt(10000);
        resetTime();
        doReportAction$enumunboxing$(1, this.createTime, 0L);
        this.pager.addPagerEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        int hashCode = str.hashCode();
        if (hashCode == -2124303921) {
            if (str.equals(Pager.PAGER_EVENT_DID_APPEAR)) {
                debugLog("PAGER_EVENT_DID_APPEAR");
                if (this.isPageVisible) {
                    return;
                }
                this.isPageVisible = true;
                resetTime();
                doReportAction$enumunboxing$(3, this.visibleTime, 0L);
                if (this.hasReportHeartbeat) {
                    debugLog("only report one runs heartbeat");
                } else {
                    this.hasReportHeartbeat = true;
                    BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new VasReporter$reportHeartbeat$1(this, null), 3, null);
                }
                BridgeManager.f117344a.e(this);
                return;
            }
            return;
        }
        if (hashCode == -1488301262) {
            if (str.equals(Pager.PAGER_EVENT_FIRST_FRAME_PAINT)) {
                debugLog("PAGER_EVENT_FIRST_FRAME_PAINT");
                return;
            }
            return;
        }
        if (hashCode != -970249943) {
            if (hashCode == -795353671 && str.equals(Pager.PAGER_EVENT_WILL_DESTROY)) {
                debugLog("PAGER_EVENT_WILL_DESTROY");
                this.pager.removePagerEventObserver(this);
                doReportAction$enumunboxing$(2, 0L, 0L);
                this.isPageDestroyFlag = true;
                return;
            }
            return;
        }
        if (str.equals(Pager.PAGER_EVENT_DID_DISAPPEAR)) {
            debugLog("PAGER_EVENT_DID_DISAPPEAR");
            this.isPageVisible = false;
            this.isPageInvisibleFlag = true;
            doReportAction$enumunboxing$(4, 0L, 0L);
            BridgeManager.f117344a.E();
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    @Override // com.tencent.kuikly.core.manager.b
    public final void onSetRenderViewFrame(int i3, float f16, float f17, float f18, float f19) {
        b.a.a(this, i3, f16, f17, f18, f19);
    }

    public final void resetTime() {
        long j3;
        if (this.visibleTime > 0) {
            j3 = a.f453719a.a();
        } else {
            j3 = this.createTime;
        }
        this.visibleTime = j3;
        this.lastReportHeartbeatTimestamp = j3;
    }

    @Override // com.tencent.kuikly.core.manager.b
    public final void onCallKotlin(int i3, Object... objArr) {
        if (i3 == 5) {
            Object obj = objArr[2];
            if (Intrinsics.areEqual(obj, "scrollEnd")) {
                if (this.scrollCount < 2) {
                    debugLog("eventName=" + obj + ", scrollCount=" + this.scrollCount);
                    doReportAction$enumunboxing$(7, 0L, 0L);
                    this.scrollCount = this.scrollCount + 1;
                    return;
                }
                BridgeManager.f117344a.E();
                return;
            }
            if (Intrinsics.areEqual(obj, "click")) {
                debugLog("eventName=" + obj + ", clickCount=" + this.clickCount);
                if (this.clickCount >= 2) {
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click time(=");
                    m3.append(this.clickCount);
                    m3.append("), not report.");
                    debugLog(m3.toString());
                    BridgeManager.f117344a.E();
                    return;
                }
                final long a16 = a.f453719a.a();
                final long j3 = a16 - this.visibleTime;
                debugLog("reportClick delay 100ms");
                TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasReporter$reportClick$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        if (Math.abs(VasReporter.this.popBackActionCalledTimestamp - a16) <= 100) {
                            VasReporter.this.debugLog("popBackActionIsCalled not report click");
                        } else {
                            VasReporter.this.debugLog("reportClick now");
                            VasReporter.this.doReportAction$enumunboxing$(6, a16, j3);
                            VasReporter.this.clickCount++;
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        }
    }

    @Override // com.tencent.kuikly.core.manager.b
    public final void onCallNative(int i3, Object... objArr) {
        if (i3 == 8) {
            Object obj = objArr[2];
            if (Intrinsics.areEqual(obj, "closePage")) {
                this.popBackActionCalledTimestamp = a.f453719a.a();
                debugLog("callNativeEventName=" + obj);
            }
        }
    }

    public final void doReportAction$enumunboxing$(int i3, long j3, long j16) {
        long j17;
        long j18 = j16;
        long a16 = j3 == 0 ? a.f453719a.a() : j3;
        int i16 = (6 == i3 || 7 == i3) ? 0 : (int) (a16 - this.visibleTime);
        if (j18 <= 0) {
            if (5 != i3 && 4 != i3) {
                j17 = this.visibleTime;
            } else {
                j17 = this.lastReportHeartbeatTimestamp;
            }
            j18 = a16 - j17;
        }
        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new VasReporter$doReportAction$1(this, i3, a16, i16, (int) j18, null), 3, null);
    }
}
