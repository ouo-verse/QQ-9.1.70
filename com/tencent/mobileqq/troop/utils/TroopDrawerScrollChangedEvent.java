package com.tencent.mobileqq.troop.utils;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/utils/TroopDrawerScrollChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "oldScrollX", "", "newScrollX", "(II)V", "getNewScrollX", "()I", "getOldScrollX", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final /* data */ class TroopDrawerScrollChangedEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;
    private final int newScrollX;
    private final int oldScrollX;

    public TroopDrawerScrollChangedEvent(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.oldScrollX = i3;
            this.newScrollX = i16;
        }
    }

    public static /* synthetic */ TroopDrawerScrollChangedEvent copy$default(TroopDrawerScrollChangedEvent troopDrawerScrollChangedEvent, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = troopDrawerScrollChangedEvent.oldScrollX;
        }
        if ((i17 & 2) != 0) {
            i16 = troopDrawerScrollChangedEvent.newScrollX;
        }
        return troopDrawerScrollChangedEvent.copy(i3, i16);
    }

    public final int component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.oldScrollX;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.newScrollX;
    }

    @NotNull
    public final TroopDrawerScrollChangedEvent copy(int oldScrollX, int newScrollX) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopDrawerScrollChangedEvent) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(oldScrollX), Integer.valueOf(newScrollX));
        }
        return new TroopDrawerScrollChangedEvent(oldScrollX, newScrollX);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopDrawerScrollChangedEvent)) {
            return false;
        }
        TroopDrawerScrollChangedEvent troopDrawerScrollChangedEvent = (TroopDrawerScrollChangedEvent) other;
        if (this.oldScrollX == troopDrawerScrollChangedEvent.oldScrollX && this.newScrollX == troopDrawerScrollChangedEvent.newScrollX) {
            return true;
        }
        return false;
    }

    public final int getNewScrollX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.newScrollX;
    }

    public final int getOldScrollX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.oldScrollX;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return (this.oldScrollX * 31) + this.newScrollX;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "TroopDrawerScrollChangedEvent(oldScrollX=" + this.oldScrollX + ", newScrollX=" + this.newScrollX + ")";
    }
}
