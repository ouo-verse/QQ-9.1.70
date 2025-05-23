package com.tencent.mobileqq.remind;

import androidx.room.RoomMasterTable;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.ErrorCode;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f280884a;

    /* renamed from: b, reason: collision with root package name */
    public static String[] f280885b;

    /* renamed from: c, reason: collision with root package name */
    public static String[] f280886c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50724);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f280884a = 25568;
        f280885b = new String[]{"00", HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
        f280886c = new String[]{"00", HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", WadlProxyConsts.OPER_TYPE_APK_SIGN, WadlProxyConsts.OPER_TYPE_MONITOR, "35", "36", "37", "38", "39", "40", "41", RoomMasterTable.DEFAULT_ID, "43", "44", "45", "46", "47", "48", "49", "50", "51", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "53", "54", "55", "56", "57", "58", ErrorCode.ERR_NET};
    }

    public static String a(long j3) {
        Date date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 E HH:mm");
        try {
            date = calendar.getTime();
        } catch (IllegalArgumentException unused) {
            date = new Date();
        }
        return simpleDateFormat.format(date);
    }

    public static long b(int i3, int i16, int i17) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(i3 * 86400 * 1000);
        calendar.set(11, i16);
        calendar.set(12, i17);
        try {
            return calendar.getTimeInMillis();
        } catch (IllegalArgumentException unused) {
            return new Date().getTime();
        }
    }

    public static String c(int i3) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        date.setTime(i3 * 86400 * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM\u6708dd\u65e5 E");
        if (simpleDateFormat.format(date).equals(simpleDateFormat.format(calendar.getTime()))) {
            return HardCodeUtil.qqStr(R.string.u5l);
        }
        return simpleDateFormat.format(date);
    }

    public static int d(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return calendar.get(11);
    }

    public static int e(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return calendar.get(12);
    }

    public static long f(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 0, 1, 0, 0, 0);
        long time = calendar.getTime().getTime();
        long j16 = ((j3 - time) / 1000) / 86400;
        if (j16 > 25568) {
            j16 = 25568;
        }
        if (j16 < 0) {
            j16 = 0;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(time);
            sb5.append("|");
            sb5.append(j3);
            sb5.append("|");
            sb5.append(r2 / 86400);
            QLog.d("remind", 4, sb5.toString());
        }
        return j16;
    }
}
