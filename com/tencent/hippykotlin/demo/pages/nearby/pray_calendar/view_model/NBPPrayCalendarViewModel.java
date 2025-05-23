package com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.AttendanceStatusRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPAttendanceService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPAttendanceService$getAttendanceStatus$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.ICalendar;
import com.tencent.kuikly.core.module.b;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.common.a;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k25.c;
import k25.d;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class NBPPrayCalendarViewModel extends g implements a {
    public MutableState<Integer> accumulateCount;
    public SnapshotStateList<String> attendanceDateList;
    public SnapshotStateMap<String, g35.a> attendanceMap;
    public c currentRequestDate;
    public c endDate;
    public MutableState<Boolean> hasReceivedSignInData;
    public boolean isAttendanceListRequesting;
    public MutableState<Boolean> isReachEnd;
    public MutableState<Boolean> isRemindOn;
    public MutableState<Boolean> isTodaySignIn;
    public String openShootResultPageNotifyCallbackRef;
    public final com.tencent.kuikly.core.pager.g pageData;
    public e qqmcConfig;
    public MutableState<d> todayCard;
    public c todayDate;

    public NBPPrayCalendarViewModel(com.tencent.kuikly.core.pager.g gVar) {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<Boolean> mutableStateOf$default2;
        MutableState<d> mutableStateOf$default3;
        MutableState<Boolean> mutableStateOf$default4;
        MutableState<Integer> mutableStateOf$default5;
        MutableState<Boolean> mutableStateOf$default6;
        this.pageData = gVar;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isTodaySignIn = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.hasReceivedSignInData = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.todayCard = mutableStateOf$default3;
        this.todayDate = new c(0, 0, 0, 15);
        this.endDate = new c(0, 0, 0, 15);
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isRemindOn = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.accumulateCount = mutableStateOf$default5;
        this.attendanceMap = SnapshotStateKt.mutableStateMapOf();
        this.attendanceDateList = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isReachEnd = mutableStateOf$default6;
        this.currentRequestDate = new c(0, 0, 0, 15);
        ICalendar c16 = b.c((b) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCalendarModule"), 0L, 1, null);
        int c17 = c16.c(ICalendar.Field.YEAR);
        int c18 = c16.c(ICalendar.Field.MONTH) + 1;
        int c19 = c16.c(ICalendar.Field.DAY_OF_MONTH);
        this.todayDate = new c(c17, c18, c19, 8);
        KLog kLog = KLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("init for ");
        sb5.append(c17);
        sb5.append('-');
        sb5.append(c18);
        sb5.append('-');
        DatalineDetailViewModel$$ExternalSyntheticOutline0.m(sb5, c19, kLog, "NBPPrayCalendarViewModel");
    }

    public final void addAttendanceDate(c cVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cVar.f411446d);
        sb5.append('-');
        sb5.append(cVar.f411447e);
        String sb6 = sb5.toString();
        if (isFuture(this.endDate, cVar) || this.attendanceDateList.contains(sb6)) {
            return;
        }
        this.attendanceDateList.add(sb6);
    }

    public final void fetchAttendanceList(boolean z16, final Function0<Unit> function0) {
        String joinToString$default;
        if (this.isAttendanceListRequesting) {
            return;
        }
        this.isAttendanceListRequesting = true;
        if (z16) {
            this.attendanceMap.clear();
            this.attendanceDateList.clear();
            this.isReachEnd.setValue(Boolean.FALSE);
            this.currentRequestDate = this.todayDate;
        }
        final ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 3; i3++) {
            arrayList.add(reduceMonth(this.currentRequestDate, i3));
        }
        final Function3<Boolean, String, g35.c, Unit> function3 = new Function3<Boolean, String, g35.c, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model.NBPPrayCalendarViewModel$fetchAttendanceList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Boolean bool, String str, g35.c cVar) {
                String str2 = str;
                g35.c cVar2 = cVar;
                if (bool.booleanValue()) {
                    if (cVar2 != null) {
                        List<c> list = arrayList;
                        NBPPrayCalendarViewModel nBPPrayCalendarViewModel = this;
                        c cVar3 = cVar2.f401212e;
                        if (cVar3 != null) {
                            nBPPrayCalendarViewModel.endDate = cVar3;
                        }
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            nBPPrayCalendarViewModel.addAttendanceDate((c) it.next());
                        }
                        List<g35.a> list2 = cVar2.f401211d;
                        nBPPrayCalendarViewModel.getClass();
                        for (g35.a aVar : list2) {
                            c cVar4 = aVar.f401207d;
                            if (cVar4 != null) {
                                nBPPrayCalendarViewModel.attendanceMap.put(nBPPrayCalendarViewModel.getDayKey(cVar4), aVar);
                                nBPPrayCalendarViewModel.addAttendanceDate(cVar4);
                            }
                        }
                        c reduceMonth = nBPPrayCalendarViewModel.reduceMonth(nBPPrayCalendarViewModel.currentRequestDate, 3);
                        nBPPrayCalendarViewModel.currentRequestDate = reduceMonth;
                        nBPPrayCalendarViewModel.isReachEnd.setValue(Boolean.valueOf(nBPPrayCalendarViewModel.isFuture(nBPPrayCalendarViewModel.endDate, reduceMonth)));
                    }
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                } else {
                    if (str2 != null) {
                        Utils.INSTANCE.currentBridgeModule().qToast(str2, QToastMode.Warning);
                    }
                    Function0<Unit> function03 = function0;
                    if (function03 != null) {
                        function03.invoke();
                    }
                }
                this.isAttendanceListRequesting = false;
                return Unit.INSTANCE;
            }
        };
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getAttendanceList req: ");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, new Function1<c, CharSequence>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model.NBPAttendanceServiceExt$getAttendanceList$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(c cVar) {
                c cVar2 = cVar;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(cVar2.f411446d);
                sb5.append('-');
                sb5.append(cVar2.f411447e);
                sb5.append('-');
                sb5.append(cVar2.f411448f);
                return sb5.toString();
            }
        }, 30, null);
        m3.append(joinToString$default);
        kLog.i("NBPAttendanceServiceExt", m3.toString());
        AttendanceListRequest attendanceListRequest = new AttendanceListRequest(arrayList);
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(attendanceListRequest, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, attendanceListRequest.getCmd()), new Function1<OIDBResponse<g35.c>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model.NBPAttendanceServiceExt$getAttendanceList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<g35.c> oIDBResponse) {
                c cVar;
                List<g35.a> list;
                OIDBResponse<g35.c> oIDBResponse2 = oIDBResponse;
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getAttendanceList rsp: attendanceDetails = ");
                g35.c cVar2 = oIDBResponse2.rsp;
                String str = null;
                m16.append((cVar2 == null || (list = cVar2.f401211d) == null) ? null : Integer.valueOf(list.size()));
                m16.append(", endDate = ");
                g35.c cVar3 = oIDBResponse2.rsp;
                if (cVar3 != null && (cVar = cVar3.f401212e) != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(cVar.f411446d);
                    sb5.append(cVar.f411447e);
                    sb5.append(cVar.f411448f);
                    str = sb5.toString();
                }
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m16, str, kLog2, "NBPAttendanceServiceExt");
                function3.invoke(Boolean.valueOf(oIDBResponse2.success), oIDBResponse2.f114186msg, oIDBResponse2.rsp);
                return Unit.INSTANCE;
            }
        }));
    }

    public final e getDTElementParams(String str, e eVar) {
        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_luck_card_calendar");
        nearbyDTBaseParams.v("dt_eid", str);
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            nearbyDTBaseParams.v(next, eVar.e(next));
        }
        return nearbyDTBaseParams;
    }

    public final String getDayKey(c cVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cVar.f411446d);
        sb5.append('-');
        sb5.append(cVar.f411447e);
        sb5.append('-');
        sb5.append(cVar.f411448f);
        return sb5.toString();
    }

    public final long getTimestampForDate(c cVar) {
        ICalendar c16 = b.c((b) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCalendarModule"), 0L, 1, null);
        c16.b(ICalendar.Field.YEAR, cVar.f411446d);
        c16.b(ICalendar.Field.MONTH, cVar.f411447e - 1);
        c16.b(ICalendar.Field.DAY_OF_MONTH, cVar.f411448f);
        return c16.a();
    }

    public final void handleDetailClick(g35.a aVar, c cVar) {
        boolean isToday = isToday(cVar);
        boolean z16 = (aVar != null ? aVar.f401208e : null) != null;
        if (isToday) {
            if (z16) {
                NBPJumpUtil.jumpPraySharePage$default(aVar != null ? aVar.f401208e : null, getTimestampForDate(cVar));
                return;
            } else {
                jumpMoodGroupPage();
                return;
            }
        }
        if (z16) {
            NBPJumpUtil.jumpPraySharePage$default(aVar != null ? aVar.f401208e : null, getTimestampForDate(cVar));
        } else if (isFuture(cVar)) {
            Utils.INSTANCE.currentBridgeModule().qToast("\u597d\u798f\u6c14\u5728\u8def\u4e0a", QToastMode.Info);
        } else {
            Utils.INSTANCE.currentBridgeModule().qToast("\u8865\u5361\u529f\u80fd\u656c\u8bf7\u671f\u5f85", QToastMode.Info);
        }
    }

    public final boolean isFuture(c cVar, c cVar2) {
        int i3 = cVar.f411446d;
        int i16 = cVar2.f411446d;
        return i3 > i16 || (i3 == i16 && cVar.f411447e > cVar2.f411447e) || (i3 == i16 && cVar.f411447e == cVar2.f411447e && cVar.f411448f > cVar2.f411448f);
    }

    public final boolean isToday(c cVar) {
        int i3 = cVar.f411446d;
        c cVar2 = this.todayDate;
        return i3 == cVar2.f411446d && cVar.f411447e == cVar2.f411447e && cVar.f411448f == cVar2.f411448f;
    }

    public final void jumpMoodGroupPage() {
        NBPJumpUtil.jumpMoodGroupPage$default(6, this.pageData.n().k("mid", 2), 0, null, false, 24);
    }

    @Override // com.tencent.ntcompose.lifecycle.common.a
    public final void onStateChanged(com.tencent.ntcompose.lifecycle.common.c cVar, Lifecycle.Event event) {
        String str;
        e eVar;
        if (event == Lifecycle.Event.ON_CREATE) {
            String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("105439", "{}");
            KLog.INSTANCE.i("NBPPrayCalendarViewModel", "getQQMCConfig: 105439: " + stringFromQQCommonConfig);
            try {
                eVar = new e(stringFromQQCommonConfig);
            } catch (Throwable unused) {
                eVar = null;
            }
            this.qqmcConfig = eVar;
            NBPPrayCalendarViewModel$fetchAttendanceStatus$1 nBPPrayCalendarViewModel$fetchAttendanceStatus$1 = new NBPPrayCalendarViewModel$fetchAttendanceStatus$1(null, this);
            com.tencent.kuikly.core.manager.c cVar2 = com.tencent.kuikly.core.manager.c.f117352a;
            ICalendar c16 = b.c((b) cVar2.g().acquireModule("KRCalendarModule"), 0L, 1, null);
            int c17 = c16.c(ICalendar.Field.YEAR);
            int c18 = c16.c(ICalendar.Field.MONTH) + 1;
            int c19 = c16.c(ICalendar.Field.DAY_OF_MONTH);
            c cVar3 = new c(c17, c18, c19, 8);
            KLog.INSTANCE.i("NBPAttendanceService", "getAttendanceStatus req: " + c17 + '-' + c18 + '-' + c19);
            AttendanceStatusRequest attendanceStatusRequest = new AttendanceStatusRequest(cVar3);
            QQKuiklyPlatformApi.Companion.sendOIDBRequest(attendanceStatusRequest, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, attendanceStatusRequest.getCmd()), new NBPAttendanceService$getAttendanceStatus$1(nBPPrayCalendarViewModel$fetchAttendanceStatus$1)));
            fetchAttendanceList(true, null);
            this.openShootResultPageNotifyCallbackRef = k.b((k) cVar2.g().acquireModule("KRNotifyModule"), "NEARBY_RECEIVE_PRAY_CARD", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model.NBPPrayCalendarViewModel$addOpenResultPageNotify$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar2) {
                    e eVar3 = eVar2;
                    KLog.INSTANCE.i("NBPPrayCalendarViewModel", "open shoot result page");
                    if (eVar3 != null && !NBPPrayCalendarViewModel.this.isTodaySignIn.getValue().booleanValue()) {
                        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel = NBPPrayCalendarViewModel.this;
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model.NBPPrayCalendarViewModel$addOpenResultPageNotify$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                if (NBPPrayCalendarViewModel.this.isTodaySignIn.getValue().booleanValue()) {
                                    NBPPrayCalendarViewModel.this.fetchAttendanceList(true, null);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        nBPPrayCalendarViewModel.getClass();
                        NBPAttendanceService.INSTANCE.getAttendanceStatus(new NBPPrayCalendarViewModel$fetchAttendanceStatus$1(function0, nBPPrayCalendarViewModel));
                    }
                    return Unit.INSTANCE;
                }
            }, 2, null);
            return;
        }
        if (event != Lifecycle.Event.ON_DESTROY || (str = this.openShootResultPageNotifyCallbackRef) == null) {
            return;
        }
        ((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule")).e("NEARBY_RECEIVE_PRAY_CARD", str);
    }

    public final c reduceMonth(c cVar, int i3) {
        int i16 = cVar.f411446d;
        int i17 = cVar.f411447e - i3;
        if (i17 <= 0) {
            i16 = ((i17 / 12) + i16) - 1;
            i17 = (i17 % 12) + 12;
        }
        return new c(i16, i17, 0, 12);
    }

    public final boolean isCurrentMonth(c cVar) {
        if (cVar != null) {
            int i3 = cVar.f411446d;
            c cVar2 = this.todayDate;
            if (i3 == cVar2.f411446d && cVar.f411447e == cVar2.f411447e) {
                return true;
            }
        }
        return false;
    }

    public final boolean isFuture(c cVar) {
        int i3 = cVar.f411446d;
        c cVar2 = this.todayDate;
        int i16 = cVar2.f411446d;
        return i3 > i16 || (i3 == i16 && cVar.f411447e > cVar2.f411447e) || (i3 == i16 && cVar.f411447e == cVar2.f411447e && cVar.f411448f > cVar2.f411448f);
    }
}
