package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils;

import com.heytap.databaseengine.utils.DateUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/utils/d;", "", "", "timestamp", "", "a", "c", "()J", "todayBeginTime", "b", "thisYearBeginTime", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f244359a = new d();

    d() {
    }

    private final long b() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.set(2, 0);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private final long c() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public final String a(long timestamp) {
        long currentTimeMillis = System.currentTimeMillis() - timestamp;
        long j3 = 60;
        long j16 = (currentTimeMillis / 1000) / j3;
        long j17 = j16 / j3;
        if (j16 == 0) {
            return "\u521a\u521a";
        }
        if (j17 == 0) {
            return j16 + "\u5206\u949f\u524d";
        }
        boolean z16 = false;
        if (1 <= j17 && j17 < 24) {
            z16 = true;
        }
        if (z16) {
            return j17 + "\u5c0f\u65f6\u524d";
        }
        long c16 = c();
        long j18 = c16 - 86400000;
        long j19 = c16 - 172800000;
        long b16 = b();
        String str = "yy-MM-dd HH:mm";
        if (currentTimeMillis >= 0) {
            if (timestamp >= c16) {
                str = DateUtil.DATE_FORMAT_HOUR;
            } else if (timestamp >= j18) {
                str = "\u6628\u5929 HH:mm";
            } else if (timestamp >= j19) {
                str = "\u524d\u5929 HH:mm";
            } else if (timestamp >= b16) {
                str = "M-dd HH:mm";
            }
        }
        String format = new SimpleDateFormat(str, Locale.CHINA).format(new Date(timestamp));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(pattern\u2026).format(Date(timestamp))");
        return format;
    }
}
