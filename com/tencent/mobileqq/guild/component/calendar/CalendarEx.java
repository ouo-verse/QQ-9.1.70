package com.tencent.mobileqq.guild.component.calendar;

import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.util.Calendar;
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
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/CalendarEx;", "", "", "millis", "Ljava/util/Calendar;", "a", "", "", "b", "Lkotlin/Lazy;", "getWeekdays", "()Ljava/util/List;", "weekdays", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class CalendarEx {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CalendarEx f215865a = new CalendarEx();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy weekdays;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.guild.component.calendar.CalendarEx$weekdays$2
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
                if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
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

    @NotNull
    public final Calendar a(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        calendar.setTimeInMillis(millis);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  \u2026meInMillis = millis\n    }");
        return calendar;
    }
}
