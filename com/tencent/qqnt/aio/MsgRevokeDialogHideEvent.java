package com.tencent.qqnt.aio;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/MsgRevokeDialogHideEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "peerId", "", "msgId", "", "(Ljava/lang/String;J)V", "getMsgId", "()J", "getPeerId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final /* data */ class MsgRevokeDialogHideEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;
    private final long msgId;

    @NotNull
    private final String peerId;

    public MsgRevokeDialogHideEvent(@NotNull String peerId, long j3) {
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, peerId, Long.valueOf(j3));
        } else {
            this.peerId = peerId;
            this.msgId = j3;
        }
    }

    public static /* synthetic */ MsgRevokeDialogHideEvent copy$default(MsgRevokeDialogHideEvent msgRevokeDialogHideEvent, String str, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = msgRevokeDialogHideEvent.peerId;
        }
        if ((i3 & 2) != 0) {
            j3 = msgRevokeDialogHideEvent.msgId;
        }
        return msgRevokeDialogHideEvent.copy(str, j3);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.peerId;
    }

    public final long component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.msgId;
    }

    @NotNull
    public final MsgRevokeDialogHideEvent copy(@NotNull String peerId, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MsgRevokeDialogHideEvent) iPatchRedirector.redirect((short) 6, this, peerId, Long.valueOf(msgId));
        }
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        return new MsgRevokeDialogHideEvent(peerId, msgId);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgRevokeDialogHideEvent)) {
            return false;
        }
        MsgRevokeDialogHideEvent msgRevokeDialogHideEvent = (MsgRevokeDialogHideEvent) other;
        if (Intrinsics.areEqual(this.peerId, msgRevokeDialogHideEvent.peerId) && this.msgId == msgRevokeDialogHideEvent.msgId) {
            return true;
        }
        return false;
    }

    public final long getMsgId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.msgId;
    }

    @NotNull
    public final String getPeerId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.peerId;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return (this.peerId.hashCode() * 31) + androidx.fragment.app.a.a(this.msgId);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MsgRevokeDialogHideEvent(peerId=" + this.peerId + ", msgId=" + this.msgId + ")";
    }
}
