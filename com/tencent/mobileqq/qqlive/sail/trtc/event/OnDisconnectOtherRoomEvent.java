package com.tencent.mobileqq.qqlive.sail.trtc.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnDisconnectOtherRoomEvent;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/TrtcBaseEvent;", "appId", "", "errCode", "", "errMsg", "(Ljava/lang/String;ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class OnDisconnectOtherRoomEvent extends TrtcBaseEvent {
    static IPatchRedirector $redirector_;
    private final int errCode;

    @NotNull
    private final String errMsg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnDisconnectOtherRoomEvent(@NotNull String appId, int i3, @NotNull String errMsg) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appId, Integer.valueOf(i3), errMsg);
        } else {
            this.errCode = i3;
            this.errMsg = errMsg;
        }
    }

    public final int getErrCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.errCode;
    }

    @NotNull
    public final String getErrMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.errMsg;
    }
}
