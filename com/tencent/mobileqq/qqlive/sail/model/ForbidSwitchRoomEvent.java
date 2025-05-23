package com.tencent.mobileqq.qqlive.sail.model;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/ForbidSwitchRoomEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "forbid", "", "roomId", "", "isSafeSwitch", "(ZJZ)V", "getForbid", "()Z", "getRoomId", "()J", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class ForbidSwitchRoomEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;
    private final boolean forbid;
    private final boolean isSafeSwitch;
    private final long roomId;

    public /* synthetic */ ForbidSwitchRoomEvent(boolean z16, long j3, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, j3, (i3 & 4) != 0 ? false : z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17), Integer.valueOf(i3), defaultConstructorMarker);
    }

    public final boolean getForbid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.forbid;
    }

    public final long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.roomId;
    }

    public final boolean isSafeSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSafeSwitch;
    }

    public ForbidSwitchRoomEvent(boolean z16, long j3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17));
            return;
        }
        this.forbid = z16;
        this.roomId = j3;
        this.isSafeSwitch = z17;
    }
}
