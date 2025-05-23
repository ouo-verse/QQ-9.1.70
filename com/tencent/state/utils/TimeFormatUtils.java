package com.tencent.state.utils;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.state.square.SquareBaseKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/utils/TimeFormatUtils;", "", "()V", "ONE_DAY", "", "ONE_HOUR", "ONE_MINUTE", "ONE_MONTH", "ONE_YEAR", "TAG", "", "TEN_MINUTES", "checkIsInCurrentMonth", "", "time", "", "formatCurrentDate", "formatInteractionTime", "formatPassTimeBaseOnSeconds", "endTime", "startTime", "formatTimeBaseOnMill", "date", "Ljava/util/Date;", "formatStr", "formatTimeToDate", "getTimeDistance", "beginDate", "endDate", "isSameYear", "isToday", "isYesterday", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class TimeFormatUtils {
    public static final TimeFormatUtils INSTANCE = new TimeFormatUtils();
    public static final int ONE_DAY = 86400;
    public static final int ONE_HOUR = 3600;
    public static final int ONE_MINUTE = 60;
    public static final int ONE_MONTH = 2592000;
    public static final int ONE_YEAR = 31104000;
    private static final String TAG = "TimeFormatUtils";
    public static final int TEN_MINUTES = 600;

    TimeFormatUtils() {
    }

    private final boolean isSameYear(long time) {
        Calendar pre = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        Intrinsics.checkNotNullExpressionValue(pre, "pre");
        pre.setTime(date);
        Calendar cal = Calendar.getInstance();
        Date date2 = new Date(time);
        Intrinsics.checkNotNullExpressionValue(cal, "cal");
        cal.setTime(date2);
        return cal.get(1) == pre.get(1);
    }

    private final boolean isYesterday(long time) {
        Calendar pre = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        Intrinsics.checkNotNullExpressionValue(pre, "pre");
        pre.setTime(date);
        Calendar cal = Calendar.getInstance();
        Date date2 = new Date(time);
        Intrinsics.checkNotNullExpressionValue(cal, "cal");
        cal.setTime(date2);
        return cal.get(1) == pre.get(1) && cal.get(6) - pre.get(6) == -1;
    }

    public final boolean checkIsInCurrentMonth(long time) {
        Calendar calendar = Calendar.getInstance();
        Calendar pre = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(pre, "pre");
        pre.setTimeInMillis(time);
        return calendar.get(1) == pre.get(1) && calendar.get(2) == pre.get(2);
    }

    public final String formatCurrentDate() {
        String format = new SimpleDateFormat("yyyy.MM.dd").format(new Date(System.currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(format, "dataFormat.format(date)");
        return format;
    }

    public final String formatInteractionTime(long time) {
        if (isToday(time)) {
            return formatTimeBaseOnMill(time, DateUtil.DATE_FORMAT_HOUR);
        }
        return formatTimeBaseOnMill(time, "MM\u6708dd\u65e5");
    }

    public final String formatTimeBaseOnMill(long time, String formatStr) {
        Intrinsics.checkNotNullParameter(formatStr, "formatStr");
        return formatTimeBaseOnMill(new Date(time), formatStr);
    }

    public final String formatTimeToDate(long time) {
        Date date = new Date(time);
        if (isToday(time)) {
            return "\u4eca\u5929 " + new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(date);
        }
        if (isYesterday(time)) {
            return "\u6628\u5929 " + new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(date);
        }
        if (isSameYear(time)) {
            String format = new SimpleDateFormat("MM\u6708dd\u65e5 HH:mm").format(date);
            Intrinsics.checkNotNullExpressionValue(format, "dataFormat.format(date)");
            return format;
        }
        String format2 = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 HH:mm").format(date);
        Intrinsics.checkNotNullExpressionValue(format2, "dataFormat.format(date)");
        return format2;
    }

    public final long getTimeDistance(Date beginDate, Date endDate) {
        Intrinsics.checkNotNullParameter(beginDate, "beginDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Calendar fromCalendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(fromCalendar, "fromCalendar");
        fromCalendar.setTime(beginDate);
        fromCalendar.set(11, fromCalendar.getMinimum(11));
        fromCalendar.set(12, fromCalendar.getMinimum(12));
        fromCalendar.set(13, fromCalendar.getMinimum(13));
        fromCalendar.set(14, fromCalendar.getMinimum(14));
        Calendar toCalendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(toCalendar, "toCalendar");
        toCalendar.setTime(endDate);
        toCalendar.set(11, fromCalendar.getMinimum(11));
        toCalendar.set(12, fromCalendar.getMinimum(12));
        toCalendar.set(13, fromCalendar.getMinimum(13));
        toCalendar.set(14, fromCalendar.getMinimum(14));
        Date time = toCalendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "toCalendar.time");
        long time2 = time.getTime();
        Date time3 = fromCalendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time3, "fromCalendar.time");
        return Math.abs((time2 - time3.getTime()) / 86400000);
    }

    public final boolean isToday(long time) {
        Calendar pre = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        Intrinsics.checkNotNullExpressionValue(pre, "pre");
        pre.setTime(date);
        Calendar cal = Calendar.getInstance();
        Date date2 = new Date(time);
        Intrinsics.checkNotNullExpressionValue(cal, "cal");
        cal.setTime(date2);
        return cal.get(1) == pre.get(1) && cal.get(6) - pre.get(6) == 0;
    }

    public final String formatTimeBaseOnMill(Date date, String formatStr) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(formatStr, "formatStr");
        try {
            String format = new SimpleDateFormat(formatStr).format(date);
            Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(formatStr).format(date)");
            return format;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "formatTime err.", th5);
            return "";
        }
    }

    public final String formatPassTimeBaseOnSeconds(long endTime, long startTime) {
        long j3 = endTime - startTime;
        if (j3 <= 600) {
            return "\u521a\u521a";
        }
        long j16 = 3600;
        if (j3 < j16) {
            return String.valueOf(j3 / 60) + "\u5206\u949f\u524d";
        }
        long j17 = 86400;
        if (j3 < j17) {
            return String.valueOf(j3 / j16) + "\u5c0f\u65f6\u524d";
        }
        long j18 = ONE_MONTH;
        if (j3 < j18) {
            return String.valueOf(j3 / j17) + "\u5929\u524d";
        }
        if (j3 >= ONE_YEAR) {
            return "\u521a\u521a";
        }
        return String.valueOf(j3 / j18) + "\u6708\u524d";
    }
}
