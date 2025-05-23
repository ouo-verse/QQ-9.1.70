package com.tencent.qqmini.miniapp.util;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DateUtils {
    private static final String TAG = "DateUtils";

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

    public static Date getSmartDateByTime(String str) {
        SimpleDateFormat simpleDateFormat;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() >= 10) {
            if (Pattern.compile(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_app_time_pattern)).matcher(str).matches()) {
                simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");
            } else {
                simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
            }
        } else if (str.length() >= 7) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        } else if (str.length() >= 4) {
            simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_YEAR);
        } else {
            simpleDateFormat = null;
        }
        if (simpleDateFormat == null) {
            return null;
        }
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e16) {
            e16.printStackTrace();
            QMLog.e(TAG, "getDateByStrTime exception." + e16);
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

    public static int getYearByDateStr(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }
}
