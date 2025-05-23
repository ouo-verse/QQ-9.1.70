package com.tencent.mobileqq.qqlive.data.anchor.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomBizData;", "", "muteAllUser", "", "(Z)V", "getMuteAllUser", "()Z", "setMuteAllUser", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final /* data */ class QQLiveAnchorRoomBizData {
    static IPatchRedirector $redirector_;
    private boolean muteAllUser;

    public QQLiveAnchorRoomBizData(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.muteAllUser = z16;
        }
    }

    public static /* synthetic */ QQLiveAnchorRoomBizData copy$default(QQLiveAnchorRoomBizData qQLiveAnchorRoomBizData, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = qQLiveAnchorRoomBizData.muteAllUser;
        }
        return qQLiveAnchorRoomBizData.copy(z16);
    }

    public final boolean component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.muteAllUser;
    }

    @NotNull
    public final QQLiveAnchorRoomBizData copy(boolean muteAllUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QQLiveAnchorRoomBizData) iPatchRedirector.redirect((short) 5, (Object) this, muteAllUser);
        }
        return new QQLiveAnchorRoomBizData(muteAllUser);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof QQLiveAnchorRoomBizData) && this.muteAllUser == ((QQLiveAnchorRoomBizData) other).muteAllUser) {
            return true;
        }
        return false;
    }

    public final boolean getMuteAllUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.muteAllUser;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        boolean z16 = this.muteAllUser;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    public final void setMuteAllUser(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.muteAllUser = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "QQLiveAnchorRoomBizData(muteAllUser=" + this.muteAllUser + ")";
    }
}
