package com.tencent.mobileqq.guild.home.views.dialog;

import com.tencent.mobileqq.guild.home.schedule.models.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class ScheduleDateLocatorDialog$adapter$2 extends FunctionReferenceImpl implements Function1<a.CalendarMonth, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ScheduleDateLocatorDialog$adapter$2(Object obj) {
        super(1, obj, ScheduleDateLocatorDialog.class, "onReachMonth", "onReachMonth(Lcom/tencent/mobileqq/guild/home/schedule/models/CalendarItem$CalendarMonth;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a.CalendarMonth calendarMonth) {
        invoke2(calendarMonth);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull a.CalendarMonth p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((ScheduleDateLocatorDialog) this.receiver).Bh(p06);
    }
}
