package org.apache.commons.lang.time;

import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DateFormatUtils {
    public static final FastDateFormat ISO_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");
    public static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");
    public static final FastDateFormat ISO_DATE_FORMAT = FastDateFormat.getInstance(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
    public static final FastDateFormat ISO_DATE_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-ddZZ");
    public static final FastDateFormat ISO_TIME_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ss");
    public static final FastDateFormat ISO_TIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ssZZ");
    public static final FastDateFormat ISO_TIME_NO_T_FORMAT = FastDateFormat.getInstance("HH:mm:ss");
    public static final FastDateFormat ISO_TIME_NO_T_TIME_ZONE_FORMAT = FastDateFormat.getInstance("HH:mm:ssZZ");
    public static final FastDateFormat SMTP_DATETIME_FORMAT = FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

    public static String format(long j3, String str) {
        return format(new Date(j3), str, (TimeZone) null, (Locale) null);
    }

    public static String formatUTC(long j3, String str) {
        return format(new Date(j3), str, DateUtils.UTC_TIME_ZONE, (Locale) null);
    }

    public static String format(Date date, String str) {
        return format(date, str, (TimeZone) null, (Locale) null);
    }

    public static String formatUTC(Date date, String str) {
        return format(date, str, DateUtils.UTC_TIME_ZONE, (Locale) null);
    }

    public static String format(Calendar calendar, String str) {
        return format(calendar, str, (TimeZone) null, (Locale) null);
    }

    public static String formatUTC(long j3, String str, Locale locale) {
        return format(new Date(j3), str, DateUtils.UTC_TIME_ZONE, locale);
    }

    public static String format(long j3, String str, TimeZone timeZone) {
        return format(new Date(j3), str, timeZone, (Locale) null);
    }

    public static String formatUTC(Date date, String str, Locale locale) {
        return format(date, str, DateUtils.UTC_TIME_ZONE, locale);
    }

    public static String format(Date date, String str, TimeZone timeZone) {
        return format(date, str, timeZone, (Locale) null);
    }

    public static String format(Calendar calendar, String str, TimeZone timeZone) {
        return format(calendar, str, timeZone, (Locale) null);
    }

    public static String format(long j3, String str, Locale locale) {
        return format(new Date(j3), str, (TimeZone) null, locale);
    }

    public static String format(Date date, String str, Locale locale) {
        return format(date, str, (TimeZone) null, locale);
    }

    public static String format(Calendar calendar, String str, Locale locale) {
        return format(calendar, str, (TimeZone) null, locale);
    }

    public static String format(long j3, String str, TimeZone timeZone, Locale locale) {
        return format(new Date(j3), str, timeZone, locale);
    }

    public static String format(Date date, String str, TimeZone timeZone, Locale locale) {
        return FastDateFormat.getInstance(str, timeZone, locale).format(date);
    }

    public static String format(Calendar calendar, String str, TimeZone timeZone, Locale locale) {
        return FastDateFormat.getInstance(str, timeZone, locale).format(calendar);
    }
}
