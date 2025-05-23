package com.tencent.mobileqq.guild.base.extension;

import com.tencent.mobileqq.guild.util.Logger;
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/base/extension/CalendarEx;", "", "", "year", "month", "day", "Ljava/util/Calendar;", "c", "", "millis", "d", "e", "", "", "f", "timeInMillis", "a", "b", "Lkotlin/Lazy;", "()Ljava/util/List;", "weekdays", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class CalendarEx {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CalendarEx f214714a = new CalendarEx();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy weekdays;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.guild.base.extension.CalendarEx$weekdays$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends String> invoke() {
                Object m476constructorimpl;
                List list;
                DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(CalendarExKt.a());
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Method declaredMethod = dateFormatSymbols.getClass().getDeclaredMethod("getTinyWeekdays", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(dateFormatSymbols, new Object[0]);
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    list = ArraysKt___ArraysKt.toList((String[]) invoke);
                    m476constructorimpl = Result.m476constructorimpl(list);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("error getTinyWeekdays...");
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("CalendarEx", 1, (String) it.next(), m479exceptionOrNullimpl);
                    }
                    String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
                    Intrinsics.checkNotNullExpressionValue(shortWeekdays, "shortWeekdays");
                    m476constructorimpl = ArraysKt___ArraysKt.toList(shortWeekdays);
                }
                return (List) m476constructorimpl;
            }
        });
        weekdays = lazy;
    }

    CalendarEx() {
    }

    private final List<String> b() {
        return (List) weekdays.getValue();
    }

    @NotNull
    public final String a(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  \u2026illis(timeInMillis)\n    }");
        return CalendarExKt.b(calendar);
    }

    @NotNull
    public final Calendar c(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        calendar.set(year, month - 1, day, 0, 0, 0);
        calendar.set(14, 0);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  \u2026dar.MILLISECOND, 0)\n    }");
        return calendar;
    }

    @NotNull
    public final Calendar d(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        calendar.setTimeInMillis(millis);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  \u2026meInMillis = millis\n    }");
        return calendar;
    }

    @NotNull
    public final Calendar e() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  \u2026dar.MILLISECOND, 0)\n    }");
        return calendar;
    }

    @NotNull
    public final List<String> f() {
        return b();
    }
}
