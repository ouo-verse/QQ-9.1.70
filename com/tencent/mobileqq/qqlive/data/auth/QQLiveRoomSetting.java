package com.tencent.mobileqq.qqlive.data.auth;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\n\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\f\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/data/auth/QQLiveRoomSetting;", "", "isHiddenUserinfo", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final /* data */ class QQLiveRoomSetting {
    static IPatchRedirector $redirector_;
    private final boolean isHiddenUserinfo;

    public QQLiveRoomSetting(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.isHiddenUserinfo = z16;
        }
    }

    public static /* synthetic */ QQLiveRoomSetting copy$default(QQLiveRoomSetting qQLiveRoomSetting, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = qQLiveRoomSetting.isHiddenUserinfo;
        }
        return qQLiveRoomSetting.copy(z16);
    }

    public final boolean component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isHiddenUserinfo;
    }

    @NotNull
    public final QQLiveRoomSetting copy(boolean isHiddenUserinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QQLiveRoomSetting) iPatchRedirector.redirect((short) 4, (Object) this, isHiddenUserinfo);
        }
        return new QQLiveRoomSetting(isHiddenUserinfo);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof QQLiveRoomSetting) && this.isHiddenUserinfo == ((QQLiveRoomSetting) other).isHiddenUserinfo) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        boolean z16 = this.isHiddenUserinfo;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    public final boolean isHiddenUserinfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isHiddenUserinfo;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "QQLiveRoomSetting(isHiddenUserinfo=" + this.isHiddenUserinfo + ")";
    }
}
