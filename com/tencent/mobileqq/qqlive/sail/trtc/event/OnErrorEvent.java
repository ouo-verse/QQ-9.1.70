package com.tencent.mobileqq.qqlive.sail.trtc.event;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnErrorEvent;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/TrtcBaseEvent;", "appId", "", "errCode", "", "errMsg", "extra", "Landroid/os/Bundle;", "(Ljava/lang/String;ILjava/lang/String;Landroid/os/Bundle;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getExtra", "()Landroid/os/Bundle;", "isScreenCaptureError", "", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class OnErrorEvent extends TrtcBaseEvent {
    static IPatchRedirector $redirector_;
    private final int errCode;

    @Nullable
    private final String errMsg;

    @Nullable
    private final Bundle extra;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnErrorEvent(@NotNull String appId, int i3, @Nullable String str, @Nullable Bundle bundle) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appId, Integer.valueOf(i3), str, bundle);
            return;
        }
        this.errCode = i3;
        this.errMsg = str;
        this.extra = bundle;
    }

    public final int getErrCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.errCode;
    }

    @Nullable
    public final String getErrMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.errMsg;
    }

    @Nullable
    public final Bundle getExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.extra;
    }

    public final boolean isScreenCaptureError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        int i3 = this.errCode;
        if (i3 != -1308 && i3 != -1309 && i3 != -7001) {
            return false;
        }
        return true;
    }
}
