package com.tencent.mobileqq.guild.quicksearch.calendar;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel", f = "CalendarSearchViewModel.kt", i = {0, 0, 0, 0, 0}, l = {180}, m = "createMonthRangeCalendars", n = {"this", "start", "endCalendar", "calendars", "tempDay"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes14.dex */
public final class CalendarSearchViewModel$createMonthRangeCalendars$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CalendarSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarSearchViewModel$createMonthRangeCalendars$1(CalendarSearchViewModel calendarSearchViewModel, Continuation<? super CalendarSearchViewModel$createMonthRangeCalendars$1> continuation) {
        super(continuation);
        this.this$0 = calendarSearchViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h26;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h26 = this.this$0.h2(null, null, this);
        return h26;
    }
}
