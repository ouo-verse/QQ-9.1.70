package com.tencent.mobileqq.troop.homework.common.trooplist.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.trooplist.data.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/trooplist/event/HWTroopListEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "TroopRangeChanged", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/event/HWTroopListEvent$TroopRangeChanged;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public abstract class HWTroopListEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/trooplist/event/HWTroopListEvent$TroopRangeChanged;", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/event/HWTroopListEvent;", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/b;", "info", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/b;", "getInfo", "()Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/b;", "<init>", "(Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/b;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class TroopRangeChanged extends HWTroopListEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final b info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TroopRangeChanged(@NotNull b info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) info);
            } else {
                this.info = info;
            }
        }

        @NotNull
        public final b getInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.info;
        }
    }

    public /* synthetic */ HWTroopListEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    HWTroopListEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
