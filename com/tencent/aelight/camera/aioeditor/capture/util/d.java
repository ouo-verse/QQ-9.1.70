package com.tencent.aelight.camera.aioeditor.capture.util;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.aelight.camera.aioeditor.capture.util.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {
    public static String a() {
        return new SimpleDateFormat("MM/dd").format(new Date(System.currentTimeMillis()));
    }

    public static String l(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            hd0.c.g("InfoStickerUtils", "location is null while spliting location!");
            return null;
        }
        String[] split = str.split("\u00b7");
        if (split.length == 1) {
            str2 = split[0];
            if (str2.endsWith(HardCodeUtil.qqStr(R.string.y9m))) {
                str2 = str.substring(0, str.length() - 1);
            }
        } else if (split.length > 1) {
            str2 = split[0];
        }
        hd0.c.l("InfoStickerUtils", "location name is %s.", str2);
        return str2;
    }

    public static String[] b(long j3) {
        if (j3 == -1) {
            j3 = System.currentTimeMillis();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j3));
        e.b bVar = new e.b();
        bVar.f67200c = calendar.get(1);
        bVar.f67199b = calendar.get(2) + 1;
        bVar.f67198a = calendar.get(5);
        e.a c16 = e.c(bVar);
        String[] strArr = new String[4];
        strArr[0] = e.f(bVar.f67200c);
        if (c16.f67194a) {
            strArr[1] = HardCodeUtil.qqStr(R.string.y98) + e.e(c16.f67196c);
        } else {
            strArr[1] = e.e(c16.f67196c);
        }
        strArr[2] = String.valueOf(e.d(c16.f67195b).charAt(0));
        strArr[3] = String.valueOf(e.d(c16.f67195b).charAt(1));
        if (QLog.isColorLevel()) {
            QLog.d("InfoStickerUtils", 2, TextUtils.join("  ", strArr));
        }
        return strArr;
    }

    public static String c(long j3) {
        if (j3 == -1) {
            j3 = System.currentTimeMillis();
        }
        return "'" + new SimpleDateFormat("yy MM dd", Locale.US).format(new Date(j3)).toUpperCase();
    }

    public static String d(long j3) {
        if (j3 == -1) {
            j3 = System.currentTimeMillis();
        }
        return new SimpleDateFormat("dd").format(new Date(j3));
    }

    public static String e(long j3) {
        if (j3 == -1) {
            j3 = System.currentTimeMillis();
        }
        return new SimpleDateFormat("MMM", Locale.US).format(new Date(j3)).toUpperCase();
    }

    public static String f(long j3) {
        if (j3 == -1) {
            j3 = System.currentTimeMillis();
        }
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_YEAR).format(new Date(j3));
    }

    public static String g(long j3) {
        if (j3 == -1) {
            j3 = System.currentTimeMillis();
        }
        return new SimpleDateFormat("HHmm").format(new Date(j3 - 60000));
    }

    public static String h(long j3) {
        if (j3 == -1) {
            j3 = System.currentTimeMillis();
        }
        return new SimpleDateFormat("MMM dd HH:mm", Locale.US).format(new Date(j3)).toUpperCase();
    }

    public static String i(long j3) {
        if (j3 == -1) {
            j3 = System.currentTimeMillis();
        }
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(new Date(j3));
    }

    public static String j(long j3) {
        if (j3 == -1) {
            j3 = System.currentTimeMillis();
        }
        return new SimpleDateFormat("yyyy MMMM dd", Locale.US).format(new Date(j3)).toUpperCase();
    }

    public static String k(long j3) {
        if (j3 == -1) {
            j3 = System.currentTimeMillis();
        }
        return new SimpleDateFormat("HHmm").format(new Date(j3));
    }
}
