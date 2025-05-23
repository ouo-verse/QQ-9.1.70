package com.tencent.mobileqq.vashealth.huawei;

import com.heytap.databaseengine.utils.DateUtil;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {
    public static long a() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        return calendar.getTimeInMillis();
    }

    public static long b() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }
}
