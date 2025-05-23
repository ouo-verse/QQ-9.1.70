package com.tencent.mobileqq.matchfriend.reborn.content.signal.utils;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\b"}, d2 = {"", "", "b", "", "c", "Ljava/util/Calendar;", "otherDay", "a", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {
    public static final boolean a(Calendar calendar, Calendar otherDay) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Intrinsics.checkNotNullParameter(otherDay, "otherDay");
        return calendar.get(1) == otherDay.get(1) && calendar.get(6) == otherDay.get(6);
    }

    public static final boolean b(long j3) {
        Calendar current = Calendar.getInstance();
        current.setTimeInMillis(System.currentTimeMillis());
        Intrinsics.checkNotNullExpressionValue(current, "current");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().also { las\u2026InMillis = this\n        }");
        return a(current, calendar);
    }

    public static final String c(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return calendar.get(1) + "-" + (calendar.get(2) + 1) + "-" + calendar.get(5);
    }
}
