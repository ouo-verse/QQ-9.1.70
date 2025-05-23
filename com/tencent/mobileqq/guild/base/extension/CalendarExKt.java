package com.tencent.mobileqq.guild.base.extension;

import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0003\u0011\u0014\u0017\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0000\"#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012\"\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015\"\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Ljava/util/Calendar;", "day", "", "e", "f", tl.h.F, "", "b", "g", "c", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "d", "()Ljava/util/Locale;", "systemLocale", "com/tencent/mobileqq/guild/base/extension/CalendarExKt$a", "Lcom/tencent/mobileqq/guild/base/extension/CalendarExKt$a;", "dataTimeFormatter", "com/tencent/mobileqq/guild/base/extension/CalendarExKt$c", "Lcom/tencent/mobileqq/guild/base/extension/CalendarExKt$c;", "monthTimeFormatter", "com/tencent/mobileqq/guild/base/extension/CalendarExKt$b", "Lcom/tencent/mobileqq/guild/base/extension/CalendarExKt$b;", "dayTimeFormatter", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class CalendarExKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f214716a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f214717b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final c f214718c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final b f214719d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/base/extension/CalendarExKt$a", "Ljava/lang/ThreadLocal;", "Ljava/text/DateFormat;", "Ljava/text/SimpleDateFormat;", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/base/extension/CalendarExKt$b", "Ljava/lang/ThreadLocal;", "Ljava/text/DateFormat;", "Ljava/text/SimpleDateFormat;", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends ThreadLocal<DateFormat> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, CalendarExKt.a());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/base/extension/CalendarExKt$c", "Ljava/lang/ThreadLocal;", "Ljava/text/DateFormat;", "Ljava/text/SimpleDateFormat;", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends ThreadLocal<DateFormat> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM", CalendarExKt.a());
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Locale>() { // from class: com.tencent.mobileqq.guild.base.extension.CalendarExKt$systemLocale$2
            @Override // kotlin.jvm.functions.Function0
            public final Locale invoke() {
                return MobileQQ.sMobileQQ.getResources().getConfiguration().locale;
            }
        });
        f214716a = lazy;
        f214717b = new a();
        f214718c = new c();
        f214719d = new b();
    }

    public static final /* synthetic */ Locale a() {
        return d();
    }

    @NotNull
    public static final String b(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        DateFormat dateFormat = f214717b.get();
        Intrinsics.checkNotNull(dateFormat);
        String format = dateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "dataTimeFormatter.get()!!.format(this.time)");
        return format;
    }

    @NotNull
    public static final String c(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        DateFormat dateFormat = f214719d.get();
        Intrinsics.checkNotNull(dateFormat);
        String dayContentToString = dateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(dayContentToString, "dayContentToString");
        return dayContentToString;
    }

    private static final Locale d() {
        return (Locale) f214716a.getValue();
    }

    public static final boolean e(@NotNull Calendar calendar, @NotNull Calendar day) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Intrinsics.checkNotNullParameter(day, "day");
        if (calendar.get(1) == day.get(1) && calendar.get(6) == day.get(6)) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Calendar f(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Object clone = calendar.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) clone;
        if (calendar2.get(2) == 0) {
            calendar2.add(1, -1);
            calendar2.set(2, 11);
        } else {
            calendar2.add(2, -1);
        }
        return calendar2;
    }

    @NotNull
    public static final String g(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        DateFormat dateFormat = f214718c.get();
        Intrinsics.checkNotNull(dateFormat);
        String format = dateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "monthTimeFormatter.get()!!.format(this.time)");
        return format;
    }

    @NotNull
    public static final Calendar h(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        Object clone = calendar.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) clone;
        if (calendar2.get(2) == 11) {
            calendar2.add(1, 1);
            calendar2.set(2, 0);
        } else {
            calendar2.add(2, 1);
        }
        return calendar2;
    }
}
