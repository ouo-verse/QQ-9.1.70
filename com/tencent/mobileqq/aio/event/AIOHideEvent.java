package com.tencent.mobileqq.aio.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOHideEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "uin", "", "uinType", "", "nick", "(Ljava/lang/String;ILjava/lang/String;)V", "getNick", "()Ljava/lang/String;", "getUin", "getUinType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "aio_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final /* data */ class AIOHideEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @Nullable
    private final String nick;

    @NotNull
    private final String uin;
    private final int uinType;

    public AIOHideEvent(@NotNull String uin, int i3, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uin, Integer.valueOf(i3), str);
            return;
        }
        this.uin = uin;
        this.uinType = i3;
        this.nick = str;
    }

    public static /* synthetic */ AIOHideEvent copy$default(AIOHideEvent aIOHideEvent, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = aIOHideEvent.uin;
        }
        if ((i16 & 2) != 0) {
            i3 = aIOHideEvent.uinType;
        }
        if ((i16 & 4) != 0) {
            str2 = aIOHideEvent.nick;
        }
        return aIOHideEvent.copy(str, i3, str2);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uin;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.uinType;
    }

    @Nullable
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.nick;
    }

    @NotNull
    public final AIOHideEvent copy(@NotNull String uin, int uinType, @Nullable String nick) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AIOHideEvent) iPatchRedirector.redirect((short) 8, this, uin, Integer.valueOf(uinType), nick);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new AIOHideEvent(uin, uinType, nick);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIOHideEvent)) {
            return false;
        }
        AIOHideEvent aIOHideEvent = (AIOHideEvent) other;
        if (Intrinsics.areEqual(this.uin, aIOHideEvent.uin) && this.uinType == aIOHideEvent.uinType && Intrinsics.areEqual(this.nick, aIOHideEvent.nick)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getNick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.nick;
    }

    @NotNull
    public final String getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.uin;
    }

    public final int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.uinType;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        int hashCode2 = ((this.uin.hashCode() * 31) + this.uinType) * 31;
        String str = this.nick;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "AIOHideEvent(uin=" + this.uin + ", uinType=" + this.uinType + ", nick=" + this.nick + ")";
    }
}
