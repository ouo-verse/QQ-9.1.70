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
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel", f = "CalendarSearchViewModel.kt", i = {0, 0}, l = {141}, m = "loadMonthCalendarData", n = {"endData", "calendars"}, s = {"L$0", "L$1"})
/* loaded from: classes14.dex */
public final class CalendarSearchViewModel$loadMonthCalendarData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CalendarSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarSearchViewModel$loadMonthCalendarData$1(CalendarSearchViewModel calendarSearchViewModel, Continuation<? super CalendarSearchViewModel$loadMonthCalendarData$1> continuation) {
        super(continuation);
        this.this$0 = calendarSearchViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object n26;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        n26 = this.this$0.n2(null, this);
        return n26;
    }
}
