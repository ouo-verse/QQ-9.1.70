package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.view.View;
import com.tencent.mobileqq.guild.component.calendar.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class FeedSearchCalendarAdapter$onBindViewHolder$1 extends FunctionReferenceImpl implements Function2<View, d.CalendarDay, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedSearchCalendarAdapter$onBindViewHolder$1(Object obj) {
        super(2, obj, FeedSearchCalendarAdapter.class, "onPickDate", "onPickDate(Landroid/view/View;Lcom/tencent/mobileqq/guild/component/calendar/CalendarItem$CalendarDay;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, d.CalendarDay calendarDay) {
        invoke2(view, calendarDay);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View p06, @NotNull d.CalendarDay p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((FeedSearchCalendarAdapter) this.receiver).u0(p06, p16);
    }
}
