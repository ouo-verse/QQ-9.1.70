package com.tencent.mobileqq.qqlive.sail.trtc.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnRemoteUserEnterRoom;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/TrtcBaseEvent;", "appId", "", "remoteUserId", "(Ljava/lang/String;Ljava/lang/String;)V", "getRemoteUserId", "()Ljava/lang/String;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class OnRemoteUserEnterRoom extends TrtcBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String remoteUserId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnRemoteUserEnterRoom(@NotNull String appId, @NotNull String remoteUserId) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(remoteUserId, "remoteUserId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appId, (Object) remoteUserId);
        } else {
            this.remoteUserId = remoteUserId;
        }
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
