package com.qzone.proxy.feedcomponent.util;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f50895a = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT, Locale.CHINA);

    /* renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f50896b = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);

    /* renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f50897c = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.CHINA);

    /* renamed from: d, reason: collision with root package name */
    public static final SimpleDateFormat f50898d = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, Locale.CHINA);

    /* renamed from: e, reason: collision with root package name */
    public static final SimpleDateFormat f50899e = new SimpleDateFormat("MM\u6708dd\u65e5 HH:mm", Locale.CHINA);

    public static final String b(long j3) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3);
        long timeInMillis = calendar.getTimeInMillis();
        int i3 = calendar2.get(1);
        int i16 = calendar2.get(2) + 1;
        int i17 = calendar2.get(5);
        if (j(timeInMillis, j3)) {
            return String.format("%d\u6708%d\u65e5", Integer.valueOf(i16), Integer.valueOf(i17));
        }
        return String.format("%d\u5e74%d\u6708%d\u65e5", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }

    public static final String e(long j3) {
        return f(j3, Calendar.getInstance());
    }

    public static final String f(long j3, Calendar calendar) {
        long timeInMillis = ((calendar.getTimeInMillis() - (((calendar.get(11) * 60) * 60) * 1000)) - ((calendar.get(12) * 60) * 1000)) - (calendar.get(13) * 1000);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3);
        long timeInMillis2 = calendar.getTimeInMillis() - j3;
        long j16 = timeInMillis - j3;
        int i3 = calendar2.get(11);
        int i16 = calendar2.get(12);
        if (timeInMillis2 >= 0) {
            if (j16 < 0) {
                return "\u4eca\u5929" + a(i3) + ":" + a(i16);
            }
            if (j16 >= 0 && j16 < 86400000) {
                return "\u6628\u5929" + a(i3) + ":" + a(i16);
            }
            if (j16 >= 86400000 && j16 <= 172800500) {
                return "\u524d\u5929" + a(i3) + ":" + a(i16);
            }
        } else if (j16 < 0 && i(calendar.getTimeInMillis(), j3)) {
            return "\u4eca\u5929" + a(i3) + ":" + a(i16);
        }
        int i17 = calendar2.get(1);
        int i18 = calendar2.get(2) + 1;
        int i19 = calendar2.get(5);
        if (calendar.get(1) != i17) {
            return i17 + "\u5e74" + a(i18) + "\u6708" + a(i19) + "\u65e5 " + a(i3) + ":" + a(i16);
        }
        return a(i18) + "\u6708" + a(i19) + "\u65e5" + a(i3) + ":" + a(i16);
    }

    public static final long g(Calendar calendar) {
        return ((calendar.getTimeInMillis() - (((calendar.get(11) * 60) * 60) * 1000)) - ((calendar.get(12) * 60) * 1000)) - (calendar.get(13) * 1000);
    }

    public static boolean i(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static boolean j(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        return calendar.get(1) == calendar2.get(1);
    }

    static String a(int i3) {
        if (i3 < 10) {
            return '0' + String.valueOf(i3);
        }
        return String.valueOf(i3);
    }

    public static final String h(long j3) {
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

    public static final String c(long j3, String str) {
        String[] split;
        String replace;
        String replace2;
        if (j3 < 0) {
            j3 = 0;
        }
        if (!TextUtils.isEmpty(str) && (split = str.split(ContainerUtils.FIELD_DELIMITER)) != null && split.length >= 3) {
            String str2 = split[0];
            if (j3 < 3600 && j3 >= 60) {
                str2 = split[1];
            } else if (j3 < 60) {
                str2 = split[2];
            }
            if (!TextUtils.isEmpty(str2)) {
                String lowerCase = str2.toLowerCase();
                int i3 = (int) (j3 / 3600);
                int i16 = (int) ((j3 % 3600) / 60);
                int i17 = (int) (j3 % 60);
                if (!lowerCase.contains("hh")) {
                    replace = lowerCase.replace(tl.h.F, String.valueOf(i3));
                } else if (i3 < 10) {
                    replace = lowerCase.replace("hh", "0" + i3);
                } else {
                    replace = lowerCase.replace("hh", String.valueOf(i3));
                }
                if (!lowerCase.contains("mm")) {
                    replace2 = replace.replace(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, String.valueOf(i16));
                } else if (i16 < 10) {
                    replace2 = replace.replace("mm", "0" + i16);
                } else {
                    replace2 = replace.replace("mm", String.valueOf(i16));
                }
                if (!lowerCase.contains("ss")) {
                    return replace2.replace(ReportConstant.COSTREPORT_PREFIX, String.valueOf(i17));
                }
                if (i17 < 10) {
                    return replace2.replace("ss", "0" + i17);
                }
                return replace2.replace("ss", String.valueOf(i17));
            }
            return "";
        }
        return "";
    }

    public static final String d(int i3) {
        if (i3 > 99999999) {
            return e(i3 * 1000);
        }
        return f50899e.format(new Date(i3 * 1000));
    }
}
