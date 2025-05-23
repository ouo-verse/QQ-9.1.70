package com.tencent.mobileqq.guild.component.calendar;

import android.content.res.Resources;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004*\u0001\u000e\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0086\u0004\"#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Ljava/util/Calendar;", "day", "", "c", QQPermissionConstants.Permission.CALENDAR_GROUP, "", "d", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "b", "()Ljava/util/Locale;", "systemLocale", "com/tencent/mobileqq/guild/component/calendar/CalendarExKt$a", "Lcom/tencent/mobileqq/guild/component/calendar/CalendarExKt$a;", "dataTimeFormatter", "qqguild-component_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class CalendarExKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f215867a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f215868b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/component/calendar/CalendarExKt$a", "Ljava/lang/ThreadLocal;", "Ljava/text/DateFormat;", "Ljava/text/SimpleDateFormat;", "a", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", CalendarExKt.a());
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Locale>() { // from class: com.tencent.mobileqq.guild.component.calendar.CalendarExKt$systemLocale$2
            @Override // kotlin.jvm.functions.Function0
            public final Locale invoke() {
                return Resources.getSystem().getConfiguration().locale;
            }
        });
        f215867a = lazy;
        f215868b = new a();
    }

    public static final /* synthetic */ Locale a() {
        return b();
    }

    private static final Locale b() {
        return (Locale) f215867a.getValue();
    }

    public static final boolean c(@NotNull Calendar calendar, @NotNull Calendar day) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Intrinsics.checkNotNullParameter(day, "day");
        if (calendar.get(1) == day.get(1) && calendar.get(6) == day.get(6)) {
            return true;
        }
        return false;
    }

    public static final int d(@NotNull Calendar calendar, @NotNull Calendar calendar2) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Intrinsics.checkNotNullParameter(calendar2, "calendar");
        return ((calendar.get(1) - calendar2.get(1)) * 12) + ((calendar.get(2) + 1) - (calendar2.get(2) + 1));
    }
}
