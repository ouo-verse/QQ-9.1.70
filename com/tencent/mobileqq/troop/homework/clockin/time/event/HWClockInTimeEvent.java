package com.tencent.mobileqq.troop.homework.clockin.time.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.time.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/event/HWClockInTimeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "HWClockInTimeInfoUpdate", "Lcom/tencent/mobileqq/troop/homework/clockin/time/event/HWClockInTimeEvent$HWClockInTimeInfoUpdate;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public abstract class HWClockInTimeEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/event/HWClockInTimeEvent$HWClockInTimeInfoUpdate;", "Lcom/tencent/mobileqq/troop/homework/clockin/time/event/HWClockInTimeEvent;", "Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "clockInInfo", "Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "getClockInInfo", "()Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "<init>", "(Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class HWClockInTimeInfoUpdate extends HWClockInTimeEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final a clockInInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HWClockInTimeInfoUpdate(@NotNull a clockInInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(clockInInfo, "clockInInfo");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) clockInInfo);
            } else {
                this.clockInInfo = clockInInfo;
            }
        }

        @NotNull
        public final a getClockInInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.clockInInfo;
        }
    }

    public /* synthetic */ HWClockInTimeEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    HWClockInTimeEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
