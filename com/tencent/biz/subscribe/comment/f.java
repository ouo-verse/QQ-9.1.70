package com.tencent.biz.subscribe.comment;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import cooperation.qzone.util.QZLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f96005a = "f";

    /* renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f96006b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f96007c = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT);

    /* renamed from: d, reason: collision with root package name */
    public static final SimpleDateFormat f96008d = new SimpleDateFormat(DateUtil.DATE_FORMAT_12);

    /* renamed from: e, reason: collision with root package name */
    public static final SimpleDateFormat f96009e = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");

    /* renamed from: f, reason: collision with root package name */
    private static StringBuilder f96010f = new StringBuilder(32);

    public static String a(long j3) {
        String str;
        String str2;
        String str3;
        int i3;
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        Object valueOf5;
        Object valueOf6;
        Object valueOf7;
        Object valueOf8;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str3 = BaseApplication.getContext().getString(R.string.ih9);
            str2 = BaseApplication.getContext().getString(R.string.ih_);
            str = BaseApplication.getContext().getString(R.string.ih8);
        } catch (Exception e16) {
            String qqStr = HardCodeUtil.qqStr(R.string.la9);
            QZLog.d(f96005a, 1, e16, new Object[0]);
            str = "%d\u5c0f\u65f6\u524d";
            str2 = "%d\u5206\u949f\u524d";
            str3 = qqStr;
        }
        long j16 = (currentTimeMillis - j3) / 1000;
        if (j16 < 60) {
            return str3;
        }
        if (j16 < 3600) {
            return String.format(str2, Long.valueOf(j16 / 60));
        }
        if (j16 < 86400) {
            return String.format(str, Long.valueOf((j16 / 60) / 60));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i16 = calendar.get(5);
        int i17 = calendar.get(11);
        int i18 = calendar.get(12);
        int i19 = calendar.get(1);
        int i26 = calendar.get(2) + 1;
        int i27 = calendar.get(6);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(currentTimeMillis);
        int i28 = calendar2.get(1);
        int i29 = calendar2.get(6);
        if (i28 != i19) {
            int i36 = 0;
            for (int i37 = i19; i37 < i28; i37++) {
                if ((i37 % 4 == 0 && i37 % 100 != 0) || i37 % 400 == 0) {
                    i36 += 366;
                } else {
                    i36 += 365;
                }
            }
            i3 = i36 + (i29 - i27);
        } else {
            i3 = i29 - i27;
        }
        StringBuilder sb5 = f96010f;
        sb5.delete(0, sb5.length());
        if (i3 == 1) {
            StringBuilder sb6 = f96010f;
            sb6.append("\u6628\u5929");
            if (i17 < 10) {
                valueOf7 = "0" + i17;
            } else {
                valueOf7 = Integer.valueOf(i17);
            }
            sb6.append(valueOf7);
            sb6.append(":");
            if (i18 < 10) {
                valueOf8 = "0" + i18;
            } else {
                valueOf8 = Integer.valueOf(i18);
            }
            sb6.append(valueOf8);
            return sb6.toString();
        }
        if (i3 == 2) {
            StringBuilder sb7 = f96010f;
            sb7.append("\u524d\u5929");
            if (i17 < 10) {
                valueOf5 = "0" + i17;
            } else {
                valueOf5 = Integer.valueOf(i17);
            }
            sb7.append(valueOf5);
            sb7.append(":");
            if (i18 < 10) {
                valueOf6 = "0" + i18;
            } else {
                valueOf6 = Integer.valueOf(i18);
            }
            sb7.append(valueOf6);
            return sb7.toString();
        }
        if (i28 != i19) {
            StringBuilder sb8 = f96010f;
            sb8.append(i19);
            sb8.append("-");
            if (i26 < 10) {
                valueOf3 = "0" + i26;
            } else {
                valueOf3 = Integer.valueOf(i26);
            }
            sb8.append(valueOf3);
            sb8.append("-");
            if (i16 < 10) {
                valueOf4 = "0" + i16;
            } else {
                valueOf4 = Integer.valueOf(i16);
            }
            sb8.append(valueOf4);
            return sb8.toString();
        }
        StringBuilder sb9 = f96010f;
        if (i26 < 10) {
            valueOf = "0" + i26;
        } else {
            valueOf = Integer.valueOf(i26);
        }
        sb9.append(valueOf);
        sb9.append("-");
        if (i16 < 10) {
            valueOf2 = "0" + i16;
        } else {
            valueOf2 = Integer.valueOf(i16);
        }
        sb9.append(valueOf2);
        return sb9.toString();
    }
}
