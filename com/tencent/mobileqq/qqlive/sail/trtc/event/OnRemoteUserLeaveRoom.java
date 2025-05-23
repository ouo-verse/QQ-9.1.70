package com.tencent.mobileqq.qqlive.sail.trtc.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnRemoteUserLeaveRoom;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/TrtcBaseEvent;", "appId", "", "remoteUserId", "reason", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getReason", "()I", "getRemoteUserId", "()Ljava/lang/String;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class OnRemoteUserLeaveRoom extends TrtcBaseEvent {
    static IPatchRedirector $redirector_;
    private final int reason;

    @NotNull
    private final String remoteUserId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnRemoteUserLeaveRoom(@NotNull String appId, @NotNull String remoteUserId, int i3) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(remoteUserId, "remoteUserId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appId, remoteUserId, Integer.valueOf(i3));
        } else {
            this.remoteUserId = remoteUserId;
            this.reason = i3;
        }
    }

    public final int getReason() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.reason;
    }

    @NotNull
    public final String getRemoteUserId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.remoteUserId;
    }
}
