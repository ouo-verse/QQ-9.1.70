package com.tencent.biz.qqcircle.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class co {
    public static long a() {
        String str;
        Map<String, String> c16 = l.c("exp_progressbar_hiding_exp");
        long j3 = 0;
        if (c16 == null || !c16.containsKey("time")) {
            return 0L;
        }
        String str2 = c16.get("time");
        if (str2 != null) {
            str = str2;
        } else {
            str = "";
        }
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            QLog.d("QFSVideoSeekBarVisibleUtil", 1, "[getHideSeekBarVideDuration] fail convert string to long, timeValue=" + str2);
        }
        return j3 * 1000;
    }

    public static boolean b() {
        l.i("exp_progressbar_hiding_exp");
        long a16 = a();
        QLog.d("QFSVideoSeekBarVisibleUtil", 1, "[hitHideSeekBarExp] paramTime=" + a16);
        if (a16 > 0) {
            return true;
        }
        return false;
    }
}
