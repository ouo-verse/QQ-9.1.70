package com.tencent.mobileqq.mini.appbrand.utils;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DateUtils {
    private static final String TAG = "DateUtils";

    public static long dateToLong(String str, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static Date getDateByStrTime(String str, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Date getSmartDateByTime(String str) {
        SimpleDateFormat simpleDateFormat;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() >= 10) {
            if (Pattern.compile(HardCodeUtil.qqStr(R.string.l_p)).matcher(str).matches()) {
                simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");
            } else {
                simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
            }
        } else if (str.length() >= 7) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        } else {
            simpleDateFormat = str.length() >= 4 ? new SimpleDateFormat(DateUtil.DATE_FORMAT_YEAR) : null;
        }
        if (simpleDateFormat == null) {
            return null;
        }
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e16) {
            e16.printStackTrace();
            QLog.e(TAG, 1, "getDateByStrTime exception." + e16);
            return null;
        }
    }

    public static Date getTimeByStrTime(String str) {
        try {
            return new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).parse(str);
        } catch (ParseException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static long dateToLong(String str) {
        try {
            return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).parse(str).getTime();
        } catch (ParseException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static int getDayByDateStr(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(5);
    }

    public static int getHour(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(11);
    }

    public static int getMinute(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(12);
    }

    public static int getMonthByDateStr(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(2);
    }

    public static int getYearByDateStr(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }
}
