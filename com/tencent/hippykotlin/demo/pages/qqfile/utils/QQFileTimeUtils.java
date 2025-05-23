package com.tencent.hippykotlin.demo.pages.qqfile.utils;

import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.ICalendar;
import com.tencent.kuikly.core.module.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFileTimeUtils {
    public static final QQFileTimeUtils INSTANCE = new QQFileTimeUtils();
    public static long mOneYearTime;
    public static long mTwoDayAgoTime;
    public static long mYesterdayTime;

    static {
        ICalendar c16 = b.c((b) c.f117352a.g().acquireModule("KRCalendarModule"), 0L, 1, null);
        c16.b(ICalendar.Field.HOUR_OF_DAY, 0);
        c16.b(ICalendar.Field.MINUS, 0);
        c16.b(ICalendar.Field.SECOND, 0);
        mYesterdayTime = c16.a();
        ICalendar.Field field = ICalendar.Field.DAY_OF_MONTH;
        c16.d(field, -1);
        mTwoDayAgoTime = c16.a();
        c16.d(field, -1);
        c16.a();
        c16.d(field, -5);
        c16.a();
        c16.d(field, 7);
        ICalendar.Field field2 = ICalendar.Field.MONTH;
        c16.d(field2, -1);
        c16.a();
        c16.d(field2, 1);
        c16.b(field, 1);
        c16.b(field2, 0);
        mOneYearTime = c16.a();
    }
}
