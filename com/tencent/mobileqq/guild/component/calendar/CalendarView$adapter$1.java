package com.tencent.mobileqq.guild.component.calendar;

import com.tencent.mobileqq.guild.component.calendar.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public /* synthetic */ class CalendarView$adapter$1 extends FunctionReferenceImpl implements Function1<d.CalendarMonth, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarView$adapter$1(Object obj) {
        super(1, obj, CalendarView.class, "onMonthReach", "onMonthReach(Lcom/tencent/mobileqq/guild/component/calendar/CalendarItem$CalendarMonth;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d.CalendarMonth calendarMonth) {
        invoke2(calendarMonth);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull d.CalendarMonth p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((CalendarView) this.receiver).Q(p06);
    }
}
