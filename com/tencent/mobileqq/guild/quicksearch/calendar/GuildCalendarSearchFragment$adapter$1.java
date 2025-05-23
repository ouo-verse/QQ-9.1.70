package com.tencent.mobileqq.guild.quicksearch.calendar;

import com.tencent.mobileqq.guild.home.schedule.models.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class GuildCalendarSearchFragment$adapter$1 extends FunctionReferenceImpl implements Function1<a.CalendarDay, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildCalendarSearchFragment$adapter$1(Object obj) {
        super(1, obj, GuildCalendarSearchFragment.class, "onPickDate", "onPickDate(Lcom/tencent/mobileqq/guild/home/schedule/models/CalendarItem$CalendarDay;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a.CalendarDay calendarDay) {
        invoke2(calendarDay);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull a.CalendarDay p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildCalendarSearchFragment) this.receiver).Ph(p06);
    }
}
