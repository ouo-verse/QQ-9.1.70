package com.tencent.mobileqq.troopmanage.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/event/TroopSetInviteRobotSwitchEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "success", "", "switchValue", "", "errorMsg", "", "(ZILjava/lang/String;)V", "getErrorMsg", "()Ljava/lang/String;", "getSuccess", "()Z", "getSwitchValue", "()I", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final /* data */ class TroopSetInviteRobotSwitchEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String errorMsg;
    private final boolean success;
    private final int switchValue;

    public TroopSetInviteRobotSwitchEvent(boolean z16, int i3, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), errorMsg);
            return;
        }
        this.success = z16;
        this.switchValue = i3;
        this.errorMsg = errorMsg;
    }

    public static /* synthetic */ TroopSetInviteRobotSwitchEvent copy$default(TroopSetInviteRobotSwitchEvent troopSetInviteRobotSwitchEvent, boolean z16, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = troopSetInviteRobotSwitchEvent.success;
        }
        if ((i16 & 2) != 0) {
            i3 = troopSetInviteRobotSwitchEvent.switchValue;
        }
        if ((i16 & 4) != 0) {
            str = troopSetInviteRobotSwitchEvent.errorMsg;
        }
        return troopSetInviteRobotSwitchEvent.copy(z16, i3, str);
    }

    public final boolean component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.success;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.switchValue;
    }

    @NotNull
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.errorMsg;
    }

    @NotNull
    public final TroopSetInviteRobotSwitchEvent copy(boolean success, int switchValue, @NotNull String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TroopSetInviteRobotSwitchEvent) iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(success), Integer.valueOf(switchValue), errorMsg);
        }
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        return new TroopSetInviteRobotSwitchEvent(success, switchValue, errorMsg);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopSetInviteRobotSwitchEvent)) {
            return false;
        }
        TroopSetInviteRobotSwitchEvent troopSetInviteRobotSwitchEvent = (TroopSetInviteRobotSwitchEvent) other;
        if (this.success == troopSetInviteRobotSwitchEvent.success && this.switchValue == troopSetInviteRobotSwitchEvent.switchValue && Intrinsics.areEqual(this.errorMsg, troopSetInviteRobotSwitchEvent.errorMsg)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getErrorMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.errorMsg;
    }

    public final boolean getSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.success;
    }

    public final int getSwitchValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.switchValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        boolean z16 = this.success;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.switchValue) * 31) + this.errorMsg.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "TroopSetInviteRobotSwitchEvent(success=" + this.success + ", switchValue=" + this.switchValue + ", errorMsg=" + this.errorMsg + ")";
    }
}
