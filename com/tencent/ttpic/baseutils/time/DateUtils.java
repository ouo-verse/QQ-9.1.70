package com.tencent.ttpic.baseutils.time;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DateUtils {
    private static final String TAG = "DateUtils";
    public static final SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat SERVER_DATE_FORMAT = new SimpleDateFormat(DateUtil.DATE_FORMAT_12);
    public static final SimpleDateFormat EXIF_DATE_FORMAT = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(DateUtil.DATE_FORMAT_14);
    public static final SimpleDateFormat DEFAULT_DAY_FORMAT = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);

    public static long calcTimeCost(long j3) {
        return System.currentTimeMillis() - j3;
    }

    public static int daysBetween(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
            Date parse = simpleDateFormat.parse(str);
            Date parse2 = simpleDateFormat.parse(str2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.setTime(parse2);
            return (int) ((calendar.getTimeInMillis() - timeInMillis) / 86400000);
        } catch (Exception e16) {
            LogUtils.e(TAG, e16.getMessage());
            return 0;
        }
    }

    public static String format(Date date) {
        return DEFAULT_FORMAT.format(date);
    }

    public static synchronized String getCurrentServerFormat() {
        String format;
        synchronized (DateUtils.class) {
            format = SERVER_DATE_FORMAT.format(new Date());
        }
        return format;
    }

    public static synchronized Date getDefaultDate(String str) {
        Date parse;
        synchronized (DateUtils.class) {
            parse = parse(str, DEFAULT_FORMAT);
        }
        return parse;
    }

    public static String getFormattedCurrentDate() {
        return DEFAULT_DATE_FORMAT.format(new Date());
    }

    public static String getFormattedCurrentDay() {
        return DEFAULT_DAY_FORMAT.format(new Date());
    }

    public static String getFormattedDayByDate(Date date) {
        return DEFAULT_DAY_FORMAT.format(date);
    }

    public static synchronized Date getServerDate(String str) {
        Date parse;
        synchronized (DateUtils.class) {
            parse = parse(str, SERVER_DATE_FORMAT);
        }
        return parse;
    }

    public static Date parse(String str, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e16) {
            LogUtils.e(e16);
            return null;
        }
    }

    public static Date parse(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (ParseException e16) {
            LogUtils.e(e16);
            return null;
        }
    }

    public static Date parse(String str) {
        try {
            return DEFAULT_FORMAT.parse(str);
        } catch (ParseException e16) {
            LogUtils.e(e16);
            return null;
        }
    }
}
