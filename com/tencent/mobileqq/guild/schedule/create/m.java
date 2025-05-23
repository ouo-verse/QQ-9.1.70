package com.tencent.mobileqq.guild.schedule.create;

import android.util.Pair;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes14.dex */
public class m {
    public static Pair<Long, Long> a(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i3 = calendar.get(11) + 1;
        calendar.set(11, i3);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(11, i3 + 1);
        return new Pair<>(Long.valueOf(timeInMillis), Long.valueOf(calendar.getTimeInMillis()));
    }

    private static long b(int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return 0L;
                    }
                    return 3600000L;
                }
                return 1800000L;
            }
            return 900000L;
        }
        return MiniBoxNoticeInfo.MIN_5;
    }

    public static String c(int i3) {
        ly1.b a16 = ly1.b.a(i3);
        if (a16 != null) {
            return a16.b();
        }
        return "";
    }

    public static String d(long j3) {
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(new Date(j3));
    }

    public static String e(long j3) {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date(j3));
    }

    public static int f(long j3, long j16) {
        long j17 = j16 - j3;
        if (j17 <= 0) {
            return -1;
        }
        if ((j17 * 1.0d) / 86400000 > 7) {
            return 1;
        }
        return 0;
    }

    public static boolean g(long j3) {
        if (j3 < NetConnInfoCenter.getServerTimeMillis()) {
            return false;
        }
        return true;
    }

    public static boolean h(long j3, int i3) {
        if (j3 < NetConnInfoCenter.getServerTimeMillis() + b(i3)) {
            return false;
        }
        return true;
    }
}
