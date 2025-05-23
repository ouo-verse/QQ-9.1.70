package com.tencent.mobileqq.winkpublish.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes21.dex */
public class DateUtil {
    private static final String TAG = "[upload2]DateUtil";

    public static int getDayTimeStamp(long j3) {
        Date date = new Date(j3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        String format = simpleDateFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(format));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static int getSecondsFromDate(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[getSecondsFromDate] expireDate=" + str);
        }
        if (!TextUtils.isEmpty(str) && !str.trim().equals(" ")) {
            try {
                if (str.matches("^[0-9]*$")) {
                    if (str.length() >= 10) {
                        return Integer.valueOf(str.substring(0, 10)).intValue();
                    }
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(5, 7)) - 1, Integer.parseInt(str.substring(8, 10)), Integer.parseInt(str.substring(11, 13)), Integer.parseInt(str.substring(14, 16)), Integer.parseInt(str.substring(17, 19)));
                    return (int) (calendar.getTime().getTime() / 1000);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[getSecondsFromDate] Exception" + str + "check if exif of the picture is correct" + e16.getMessage());
            }
        }
        return 0;
    }

    public static final String getVideoPlayTime(long j3) {
        String str;
        if (j3 < 0) {
            return "";
        }
        long round = Math.round(((float) j3) / 1000.0f);
        long j16 = round / 60;
        long j17 = round % 60;
        long j18 = j16 / 60;
        long j19 = j16 % 60;
        String str2 = ":%d";
        if (j18 > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("%d");
            if (j19 >= 10) {
                str = ":%d";
            } else {
                str = ":0%d";
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            if (j17 < 10) {
                str2 = ":0%d";
            }
            sb7.append(str2);
            return String.format(sb7.toString(), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j17));
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("%d");
        if (j17 < 10) {
            str2 = ":0%d";
        }
        sb8.append(str2);
        return String.format(sb8.toString(), Long.valueOf(j19), Long.valueOf(j17));
    }
}
