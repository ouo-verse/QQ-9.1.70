package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.ICalendar;
import com.tencent.kuikly.core.module.b;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import zz0.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyFormatUtils {
    public static final NearbyFormatUtils INSTANCE = new NearbyFormatUtils();
    public static long mOneYearTime;
    public static long mThreeDayAgoTime;
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
        mThreeDayAgoTime = c16.a();
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

    public final String formatFeedTime(long j3) {
        long j16 = 60;
        long a16 = ((a.f453719a.a() - j3) / 1000) / j16;
        long j17 = a16 / j16;
        if (a16 < 1) {
            return "\u521a\u521a";
        }
        if (j17 < 1) {
            return a16 + "\u5206\u949f\u524d";
        }
        if (j17 < 24) {
            return j17 + "\u5c0f\u65f6\u524d";
        }
        return formatStateItemTime(j3);
    }

    public final boolean isToday(long j3) {
        return j3 >= mYesterdayTime;
    }

    public final String formatPALikeCount(int i3) {
        boolean endsWith$default;
        String removeSuffix;
        if (i3 < 1000) {
            return String.valueOf(i3);
        }
        String valueOf = String.valueOf(i3 / 1000);
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(valueOf, ".0", false, 2, null);
        if (endsWith$default) {
            StringBuilder sb5 = new StringBuilder();
            removeSuffix = StringsKt__StringsKt.removeSuffix(valueOf, (CharSequence) ".0");
            sb5.append(removeSuffix);
            sb5.append('k');
            return sb5.toString();
        }
        return valueOf + 'k';
    }

    public final String formatStateItemTime(long j3) {
        if (j3 == 0) {
            return "";
        }
        c cVar = c.f117352a;
        b bVar = (b) cVar.g().acquireModule("KRCalendarModule");
        bVar.b(j3);
        if (j3 >= mYesterdayTime) {
            b.c((b) cVar.g().acquireModule("KRCalendarModule"), 0L, 1, null);
            return bVar.a(j3, DateUtil.DATE_FORMAT_HOUR);
        }
        if (j3 >= mTwoDayAgoTime) {
            return bVar.a(j3, "\u6628\u5929 HH:mm");
        }
        if (j3 >= mThreeDayAgoTime) {
            return bVar.a(j3, "\u524d\u5929 HH:mm");
        }
        if (j3 >= mOneYearTime) {
            return bVar.a(j3, "M-dd HH:mm");
        }
        return bVar.a(j3, "yy-MM-dd HH:mm");
    }
}
