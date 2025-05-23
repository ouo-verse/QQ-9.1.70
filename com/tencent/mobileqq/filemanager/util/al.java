package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes12.dex */
public class al {

    /* renamed from: a, reason: collision with root package name */
    private static Calendar f209335a = Calendar.getInstance();

    public static String a(long j3) {
        f209335a.setTimeInMillis(System.currentTimeMillis());
        int i3 = f209335a.get(1);
        int i16 = f209335a.get(2);
        int i17 = f209335a.get(5);
        f209335a.setTimeInMillis(j3);
        int i18 = f209335a.get(1);
        int i19 = f209335a.get(2);
        int i26 = f209335a.get(5);
        if (i3 != i18) {
            return new SimpleDateFormat("yyyy-MM-dd ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(j3));
        }
        if (i16 != i19) {
            return new SimpleDateFormat("MM-dd ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(j3));
        }
        if (i17 == i26) {
            return new SimpleDateFormat("HH:mm ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(j3));
        }
        if (i17 - i26 <= 1) {
            return HardCodeUtil.qqStr(R.string.f213775r4);
        }
        return new SimpleDateFormat("MM-dd ", BaseApplication.getContext().getResources().getConfiguration().locale).format(new Date(j3));
    }

    private static String b(long j3, String str) {
        if (j3 == 0) {
            return "";
        }
        try {
            return new SimpleDateFormat(str).format(new Date(j3));
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(j3));
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    public static String c(long j3) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(com.tencent.mobileqq.service.message.e.K0() * 1000);
        calendar2.setTimeInMillis(j3);
        int i3 = calendar.get(1);
        int i16 = calendar.get(6) - calendar2.get(6);
        if (calendar2.get(1) != i3) {
            Calendar calendar3 = (Calendar) calendar2.clone();
            do {
                i16 += calendar3.getActualMaximum(6);
                calendar3.add(1, 1);
            } while (calendar3.get(1) != i3);
        }
        if (i16 <= 7) {
            return "7\u5929\u5185";
        }
        return b(j3, "yyyy\u5e74MM\u6708");
    }
}
