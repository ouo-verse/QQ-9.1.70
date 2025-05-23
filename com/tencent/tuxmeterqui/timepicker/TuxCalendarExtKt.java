package com.tencent.tuxmeterqui.timepicker;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.Calendar;
import java.util.GregorianCalendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0005H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\t\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\n\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\f\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\r\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u00a8\u0006\u000e"}, d2 = {"getMaxDayAtYear", "", "Ljava/util/GregorianCalendar;", "year", "getMaxDayInMonth", "Ljava/util/Calendar;", "isSameDay", "", QQPermissionConstants.Permission.CALENDAR_GROUP, "isSameHour", "isSameMinute", "isSameMonth", "isSameSecond", "isSameYear", "tuxmeterQUI_debug"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TuxCalendarExtKt {
    public static final int getMaxDayAtYear(@NotNull GregorianCalendar gregorianCalendar, int i3) {
        Intrinsics.checkNotNullParameter(gregorianCalendar, "<this>");
        gregorianCalendar.set(1, i3);
        return (gregorianCalendar.isLeapYear(i3) ? 1 : 0) + 365;
    }

    public static final int getMaxDayInMonth(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        return calendar.getActualMaximum(5);
    }

    public static final boolean isSameDay(@NotNull Calendar calendar, @NotNull Calendar calendar2) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Intrinsics.checkNotNullParameter(calendar2, "calendar");
        if (isSameYear(calendar, calendar2) && calendar.get(6) == calendar2.get(6)) {
            return true;
        }
        return false;
    }

    public static final boolean isSameHour(@NotNull Calendar calendar, @NotNull Calendar calendar2) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Intrinsics.checkNotNullParameter(calendar2, "calendar");
        if (isSameDay(calendar, calendar2) && calendar.get(11) == calendar2.get(11)) {
            return true;
        }
        return false;
    }

    public static final boolean isSameMinute(@NotNull Calendar calendar, @NotNull Calendar calendar2) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Intrinsics.checkNotNullParameter(calendar2, "calendar");
        if (isSameHour(calendar, calendar2) && calendar.get(12) == calendar2.get(12)) {
            return true;
        }
        return false;
    }

    public static final boolean isSameMonth(@NotNull Calendar calendar, @NotNull Calendar calendar2) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Intrinsics.checkNotNullParameter(calendar2, "calendar");
        if (isSameYear(calendar, calendar2) && calendar.get(2) == calendar2.get(2)) {
            return true;
        }
        return false;
    }

    public static final boolean isSameSecond(@NotNull Calendar calendar, @NotNull Calendar calendar2) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Intrinsics.checkNotNullParameter(calendar2, "calendar");
        if (isSameMinute(calendar, calendar2) && calendar.get(13) == calendar2.get(13)) {
            return true;
        }
        return false;
    }

    public static final boolean isSameYear(@NotNull Calendar calendar, @NotNull Calendar calendar2) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Intrinsics.checkNotNullParameter(calendar2, "calendar");
        if (calendar.get(1) == calendar2.get(1)) {
            return true;
        }
        return false;
    }
}
