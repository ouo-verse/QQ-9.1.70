package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.ICalendar;
import k25.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class NBPAttendanceService {
    public static final NBPAttendanceService INSTANCE = new NBPAttendanceService();

    public final void getAttendanceStatus(Function3<? super Boolean, ? super String, ? super b, Unit> function3) {
        ICalendar c16 = com.tencent.kuikly.core.module.b.c((com.tencent.kuikly.core.module.b) c.f117352a.g().acquireModule("KRCalendarModule"), 0L, 1, null);
        int c17 = c16.c(ICalendar.Field.YEAR);
        int c18 = c16.c(ICalendar.Field.MONTH) + 1;
        int c19 = c16.c(ICalendar.Field.DAY_OF_MONTH);
        k25.c cVar = new k25.c(c17, c18, c19, 8);
        KLog.INSTANCE.i("NBPAttendanceService", "getAttendanceStatus req: " + c17 + '-' + c18 + '-' + c19);
        AttendanceStatusRequest attendanceStatusRequest = new AttendanceStatusRequest(cVar);
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(attendanceStatusRequest, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, attendanceStatusRequest.getCmd()), new NBPAttendanceService$getAttendanceStatus$1(function3)));
    }
}
