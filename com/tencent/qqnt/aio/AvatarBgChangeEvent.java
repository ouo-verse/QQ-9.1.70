package com.tencent.qqnt.aio;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/AvatarBgChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "peerId", "", "toRemove", "", "(Ljava/lang/String;Z)V", "getPeerId", "()Ljava/lang/String;", "getToRemove", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final /* data */ class AvatarBgChangeEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String peerId;
    private final boolean toRemove;

    public AvatarBgChangeEvent(@NotNull String peerId, boolean z16) {
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, peerId, Boolean.valueOf(z16));
        } else {
            this.peerId = peerId;
            this.toRemove = z16;
        }
    }

    public static /* synthetic */ AvatarBgChangeEvent copy$default(AvatarBgChangeEvent avatarBgChangeEvent, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = avatarBgChangeEvent.peerId;
        }
        if ((i3 & 2) != 0) {
            z16 = avatarBgChangeEvent.toRemove;
        }
        return avatarBgChangeEvent.copy(str, z16);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.peerId;
    }

    public final boolean component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.toRemove;
    }

    @NotNull
    public final AvatarBgChangeEvent copy(@NotNull String peerId, boolean toRemove) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AvatarBgChangeEvent) iPatchRedirector.redirect((short) 6, this, peerId, Boolean.valueOf(toRemove));
        }
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        return new AvatarBgChangeEvent(peerId, toRemove);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarBgChangeEvent)) {
            return false;
        }
        AvatarBgChangeEvent avatarBgChangeEvent = (AvatarBgChangeEvent) other;
        if (Intrinsics.areEqual(this.peerId, avatarBgChangeEvent.peerId) && this.toRemove == avatarBgChangeEvent.toRemove) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getPeerId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.peerId;
    }

    public final boolean getToRemove() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.toRemove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int hashCode = this.peerId.hashCode() * 31;
        boolean z16 = this.toRemove;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "AvatarBgChangeEvent(peerId=" + this.peerId + ", toRemove=" + this.toRemove + ")";
    }
}
