package com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.AttendanceStatusRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPAttendanceService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPAttendanceService$getAttendanceStatus$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.ICalendar;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import k25.b;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.i;
import o25.a;
import o25.d;
import v25.m;
import v25.q;

/* loaded from: classes31.dex */
public final class NBPPendantViewModel extends NBPMainBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "showActivityIcon", "getShowActivityIcon()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "activityIconUrl", "getActivityIconUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "showLandMark", "getShowLandMark()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "landMarkIcon", "getLandMarkIcon()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "showLandMarkBubble", "getShowLandMarkBubble()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "landMarkChatAvatarUrl", "getLandMarkChatAvatarUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "landMarkChatNum", "getLandMarkChatNum()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "bubbleAnimateState", "getBubbleAnimateState()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "showPrayCalendar", "getShowPrayCalendar()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "showPrayCalendarTips", "getShowPrayCalendarTips()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPendantViewModel.class, "isPrayCalendarSignIn", "isPrayCalendarSignIn()Z", 0)};
    public final ReadWriteProperty activityIconUrl$delegate;
    public String activityJumpUrl;
    public a areaInfo;
    public final ReadWriteProperty bubbleAnimateState$delegate;
    public String dismissBubbleInfoTimeoutRef;
    public final ReadWriteProperty isPrayCalendarSignIn$delegate;
    public final ReadWriteProperty landMarkChatAvatarUrl$delegate;
    public final ReadWriteProperty landMarkChatNum$delegate;
    public final ReadWriteProperty landMarkIcon$delegate;
    public String openShootResultPageNotifyCallbackRef;
    public final NBPPendantRepo repo;
    public final ReadWriteProperty showActivityIcon$delegate;
    public final ReadWriteProperty showLandMark$delegate;
    public final ReadWriteProperty showLandMarkBubble$delegate;
    public final ReadWriteProperty showPrayCalendar$delegate;
    public final ReadWriteProperty showPrayCalendarTips$delegate;

    public NBPPendantViewModel() {
        Boolean bool = Boolean.FALSE;
        this.showActivityIcon$delegate = c.a(bool);
        this.activityIconUrl$delegate = c.a("");
        this.activityJumpUrl = "";
        this.showLandMark$delegate = c.a(bool);
        this.landMarkIcon$delegate = c.a("");
        this.showLandMarkBubble$delegate = c.a(bool);
        this.landMarkChatAvatarUrl$delegate = c.a("");
        this.landMarkChatNum$delegate = c.a(0);
        this.bubbleAnimateState$delegate = c.a(0);
        this.showPrayCalendar$delegate = c.a(Boolean.TRUE);
        this.showPrayCalendarTips$delegate = c.a(bool);
        this.isPrayCalendarSignIn$delegate = c.a(bool);
        this.dismissBubbleInfoTimeoutRef = "";
        this.repo = new NBPPendantRepo();
    }

    public final boolean canShowPrayCalendarAnimation() {
        return !isPrayCalendarSignIn() && ((Boolean) this.showPrayCalendarTips$delegate.getValue(this, $$delegatedProperties[9])).booleanValue();
    }

    public final boolean isPrayCalendarSignIn() {
        return ((Boolean) this.isPrayCalendarSignIn$delegate.getValue(this, $$delegatedProperties[10])).booleanValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerCreated() {
        this.openShootResultPageNotifyCallbackRef = k.b((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_RECEIVE_PRAY_CARD", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant.NBPPendantViewModel$addOpenResultPageNotify$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                KLog.INSTANCE.i("NBPPendantViewModel", "open shoot result page");
                if (eVar2 != null && !NBPPendantViewModel.this.isPrayCalendarSignIn()) {
                    NBPAttendanceService nBPAttendanceService = NBPAttendanceService.INSTANCE;
                    final NBPPendantViewModel nBPPendantViewModel = NBPPendantViewModel.this;
                    nBPAttendanceService.getAttendanceStatus(new Function3<Boolean, String, b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant.NBPPendantViewModel$addOpenResultPageNotify$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(Boolean bool, String str, b bVar) {
                            bool.booleanValue();
                            b bVar2 = bVar;
                            NBPPendantViewModel nBPPendantViewModel2 = NBPPendantViewModel.this;
                            nBPPendantViewModel2.isPrayCalendarSignIn$delegate.setValue(nBPPendantViewModel2, NBPPendantViewModel.$$delegatedProperties[10], Boolean.valueOf(bVar2 != null ? bVar2.f411442d : false));
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerWillDestroy() {
        if (this.dismissBubbleInfoTimeoutRef.length() > 0) {
            TimerKt.b(this.dismissBubbleInfoTimeoutRef);
        }
        String str = this.openShootResultPageNotifyCallbackRef;
        if (str != null) {
            ((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule")).e("NEARBY_RECEIVE_PRAY_CARD", str);
        }
    }

    public final void setShowPrayCalendarTips(boolean z16) {
        this.showPrayCalendarTips$delegate.setValue(this, $$delegatedProperties[9], Boolean.valueOf(z16));
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onLocationFinish(boolean z16, NBPSsoLocation nBPSsoLocation) {
        if (z16) {
            KLog kLog = KLog.INSTANCE;
            kLog.i("NBPPendantViewModel", "start request pendant info");
            NBPPendantRepo nBPPendantRepo = this.repo;
            final Function1<m, Unit> function1 = new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant.NBPPendantViewModel$requestPendantInfo$1
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(m mVar) {
                    List<a> list;
                    Object firstOrNull;
                    String str;
                    List<String> list2;
                    Object firstOrNull2;
                    List<q> list3;
                    Object firstOrNull3;
                    boolean z17;
                    m mVar2 = mVar;
                    if (mVar2 != null && (list3 = mVar2.f440866e) != null) {
                        firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list3);
                        q qVar = (q) firstOrNull3;
                        if (qVar != null) {
                            NBPPendantViewModel nBPPendantViewModel = NBPPendantViewModel.this;
                            m25.e eVar = qVar.f440889h;
                            String str2 = eVar != null ? eVar.f416060d : null;
                            String str3 = qVar.f440890i;
                            KLog.INSTANCE.i("NBPPendantViewModel", QUISkinImage$$ExternalSyntheticOutline0.m("rptRectIcon: ", str2, ", ", str3));
                            if (str2 != null) {
                                if (str2.length() > 0) {
                                    z17 = true;
                                    if (z17) {
                                        if (str3.length() > 0) {
                                            ReadWriteProperty readWriteProperty = nBPPendantViewModel.showActivityIcon$delegate;
                                            KProperty<?>[] kPropertyArr = NBPPendantViewModel.$$delegatedProperties;
                                            readWriteProperty.setValue(nBPPendantViewModel, kPropertyArr[0], Boolean.TRUE);
                                            nBPPendantViewModel.activityJumpUrl = str3;
                                            nBPPendantViewModel.activityIconUrl$delegate.setValue(nBPPendantViewModel, kPropertyArr[1], str2);
                                        }
                                    }
                                }
                            }
                            z17 = false;
                            if (z17) {
                            }
                        }
                    }
                    if (mVar2 != null && (list = mVar2.f440867f) != null) {
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                        a aVar = (a) firstOrNull;
                        if (aVar != null) {
                            final NBPPendantViewModel nBPPendantViewModel2 = NBPPendantViewModel.this;
                            nBPPendantViewModel2.areaInfo = aVar;
                            ReadWriteProperty readWriteProperty2 = nBPPendantViewModel2.showLandMark$delegate;
                            KProperty<?>[] kPropertyArr2 = NBPPendantViewModel.$$delegatedProperties;
                            KProperty<?> kProperty = kPropertyArr2[2];
                            Boolean bool = Boolean.TRUE;
                            readWriteProperty2.setValue(nBPPendantViewModel2, kProperty, bool);
                            d dVar = aVar.f421834i;
                            String str4 = "";
                            if (dVar == null || (str = dVar.f421845i) == null) {
                                str = "";
                            }
                            nBPPendantViewModel2.landMarkIcon$delegate.setValue(nBPPendantViewModel2, kPropertyArr2[3], str);
                            d dVar2 = aVar.f421834i;
                            int i3 = dVar2 != null ? dVar2.f421843f : 0;
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("rptArea: ");
                            m3.append((String) nBPPendantViewModel2.landMarkIcon$delegate.getValue(nBPPendantViewModel2, kPropertyArr2[3]));
                            m3.append(", onlineNum: ");
                            m3.append(i3);
                            kLog2.i("NBPPendantViewModel", m3.toString());
                            if (i3 > 0) {
                                nBPPendantViewModel2.showLandMarkBubble$delegate.setValue(nBPPendantViewModel2, kPropertyArr2[4], bool);
                                nBPPendantViewModel2.landMarkChatNum$delegate.setValue(nBPPendantViewModel2, kPropertyArr2[6], Integer.valueOf(i3));
                                d dVar3 = aVar.f421834i;
                                if (dVar3 != null && (list2 = dVar3.f421844h) != null) {
                                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                                    String str5 = (String) firstOrNull2;
                                    if (str5 != null) {
                                        str4 = str5;
                                    }
                                }
                                nBPPendantViewModel2.landMarkChatAvatarUrl$delegate.setValue(nBPPendantViewModel2, kPropertyArr2[5], str4);
                                kLog2.i("NBPPendantViewModel", "landMark avatar url: " + str4);
                                TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant.NBPPendantViewModel$startBubbleAnimate$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPPendantViewModel nBPPendantViewModel3 = NBPPendantViewModel.this;
                                        nBPPendantViewModel3.bubbleAnimateState$delegate.setValue(nBPPendantViewModel3, NBPPendantViewModel.$$delegatedProperties[7], 1);
                                        return Unit.INSTANCE;
                                    }
                                }, 1, null);
                                nBPPendantViewModel2.dismissBubbleInfoTimeoutRef = TimerKt.d(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant.NBPPendantViewModel$dismissBubbleDelay$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPPendantViewModel nBPPendantViewModel3 = NBPPendantViewModel.this;
                                        nBPPendantViewModel3.bubbleAnimateState$delegate.setValue(nBPPendantViewModel3, NBPPendantViewModel.$$delegatedProperties[7], 2);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                            jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_square_en");
                            jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            nBPPendantRepo.getClass();
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("start requestPendantInfo, gps: ");
            m3.append(nBPSsoLocation.lat02);
            m3.append(", ");
            m3.append(nBPSsoLocation.lon02);
            kLog.i("NBPPendantRepo", m3.toString());
            double d16 = 1000000;
            GetRecInfoRequest getRecInfoRequest = new GetRecInfoRequest(new n25.k((String) null, (String) null, 0, (String) null, nBPSsoLocation.address, 0, new i((long) (nBPSsoLocation.lat02 * d16), (long) (nBPSsoLocation.lon02 * d16), 12), 0, 0, (String) null, (String) null, nBPSsoLocation.province, nBPSsoLocation.city, 0, 0, (String) null, nBPSsoLocation.district, (String) null, (String) null, (String) null, 2025391));
            Function1<PbResponse<m>, Unit> function12 = new Function1<PbResponse<m>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant.NBPPendantRepo$requestPendantInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(PbResponse<m> pbResponse) {
                    PbResponse<m> pbResponse2 = pbResponse;
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestPendantInfo, code: ");
                    m16.append(pbResponse2.code);
                    m16.append(", msg: ");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m16, pbResponse2.f114187msg, kLog2, "NBPPendantRepo");
                    function1.invoke(pbResponse2.rsp);
                    return Unit.INSTANCE;
                }
            };
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoGetRecInfo");
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.sendPbRequest$default(getRecInfoRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
            Function3<Boolean, String, b, Unit> function3 = new Function3<Boolean, String, b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant.NBPPendantViewModel$checkPrayCalendarEntry$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(Boolean bool, String str, b bVar) {
                    bool.booleanValue();
                    b bVar2 = bVar;
                    NBPPendantViewModel nBPPendantViewModel = NBPPendantViewModel.this;
                    nBPPendantViewModel.isPrayCalendarSignIn$delegate.setValue(nBPPendantViewModel, NBPPendantViewModel.$$delegatedProperties[10], Boolean.valueOf(bVar2 != null ? bVar2.f411442d : false));
                    Pair<Long, Integer> parsePrayCalendarTips = NearbyProUtilsKt.parsePrayCalendarTips();
                    if (NearbyFormatUtils.INSTANCE.isToday(parsePrayCalendarTips.component1().longValue()) && parsePrayCalendarTips.component2().intValue() >= 2) {
                        NBPPendantViewModel.this.setShowPrayCalendarTips(false);
                    } else {
                        NBPPendantViewModel.this.setShowPrayCalendarTips(true);
                        NearbyProUtilsKt.setPrayCalendarTips(false);
                    }
                    return Unit.INSTANCE;
                }
            };
            ICalendar c16 = com.tencent.kuikly.core.module.b.c((com.tencent.kuikly.core.module.b) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCalendarModule"), 0L, 1, null);
            int c17 = c16.c(ICalendar.Field.YEAR);
            int c18 = c16.c(ICalendar.Field.MONTH) + 1;
            int c19 = c16.c(ICalendar.Field.DAY_OF_MONTH);
            k25.c cVar = new k25.c(c17, c18, c19, 8);
            kLog.i("NBPAttendanceService", "getAttendanceStatus req: " + c17 + '-' + c18 + '-' + c19);
            AttendanceStatusRequest attendanceStatusRequest = new AttendanceStatusRequest(cVar);
            QQKuiklyPlatformApi.Companion.sendOIDBRequest(attendanceStatusRequest, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, attendanceStatusRequest.getCmd()), new NBPAttendanceService$getAttendanceStatus$1(function3)));
        }
    }
}
