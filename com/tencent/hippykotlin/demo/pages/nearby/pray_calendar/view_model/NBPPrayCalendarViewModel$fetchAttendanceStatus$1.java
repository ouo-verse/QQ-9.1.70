package com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model;

import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import k25.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPPrayCalendarViewModel$fetchAttendanceStatus$1 extends Lambda implements Function3<Boolean, String, b, Unit> {
    public final /* synthetic */ Function0<Unit> $callback;
    public final /* synthetic */ NBPPrayCalendarViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPPrayCalendarViewModel$fetchAttendanceStatus$1(Function0<Unit> function0, NBPPrayCalendarViewModel nBPPrayCalendarViewModel) {
        super(3);
        this.$callback = function0;
        this.this$0 = nBPPrayCalendarViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(Boolean bool, String str, b bVar) {
        String str2 = str;
        b bVar2 = bVar;
        if (bool.booleanValue()) {
            if (bVar2 != null) {
                NBPPrayCalendarViewModel nBPPrayCalendarViewModel = this.this$0;
                nBPPrayCalendarViewModel.isTodaySignIn.setValue(Boolean.valueOf(bVar2.f411442d));
                nBPPrayCalendarViewModel.hasReceivedSignInData.setValue(Boolean.TRUE);
                nBPPrayCalendarViewModel.todayCard.setValue(bVar2.f411443e);
                nBPPrayCalendarViewModel.isRemindOn.setValue(Boolean.valueOf(bVar2.f411444f));
                nBPPrayCalendarViewModel.accumulateCount.setValue(Integer.valueOf(bVar2.f411445h));
            }
        } else if (str2 != null) {
            Utils.INSTANCE.currentBridgeModule().qToast(str2, QToastMode.Warning);
        }
        Function0<Unit> function0 = this.$callback;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
