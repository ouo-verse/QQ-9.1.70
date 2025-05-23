package com.heytap.databaseengine.apiv2.health.business;

import com.heytap.databaseengine.apiv2.health.HeytapHealthParams;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/* loaded from: classes2.dex */
public class ParamChecker {
    private static final long CHART_DETAILS_START_TIME = 0;
    private static final long TIME_LIMIT = 2592000000L;

    private boolean timeLimit(HeytapHealthParams heytapHealthParams) {
        return timeCheck(heytapHealthParams.getStartTime(), heytapHealthParams.getEndTime());
    }

    public boolean pass(HeytapHealthParams heytapHealthParams) {
        if (heytapHealthParams != null && timeLimit(heytapHealthParams)) {
            return true;
        }
        return false;
    }

    public boolean timeCheck(long j3, long j16) {
        LocalDate now;
        LocalDateTime atStartOfDay;
        LocalDateTime plusDays;
        ZoneId systemDefault;
        ZonedDateTime atZone;
        long epochMilli;
        if (0 <= j3 && j3 <= j16) {
            now = LocalDate.now();
            atStartOfDay = now.atStartOfDay();
            plusDays = atStartOfDay.plusDays(1L);
            systemDefault = ZoneId.systemDefault();
            atZone = plusDays.atZone(systemDefault);
            epochMilli = atZone.toInstant().toEpochMilli();
            if (j16 <= epochMilli - 1 && j16 - j3 <= 2592000000L) {
                return true;
            }
        }
        return false;
    }
}
