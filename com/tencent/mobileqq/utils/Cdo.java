package com.tencent.mobileqq.utils;

import java.util.Calendar;

/* compiled from: P */
/* renamed from: com.tencent.mobileqq.utils.do, reason: invalid class name */
/* loaded from: classes20.dex */
public class Cdo {
    public static long a(long j3) {
        if (j3 == 0) {
            j3 = System.currentTimeMillis();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis((j3 / 1000) * 1000);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }
}
