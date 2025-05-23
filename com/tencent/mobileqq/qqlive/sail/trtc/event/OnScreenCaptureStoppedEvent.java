package com.tencent.mobileqq.qqlive.sail.trtc.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/event/OnScreenCaptureStoppedEvent;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/event/TrtcBaseEvent;", "appId", "", "reason", "", "(Ljava/lang/String;I)V", "getReason", "()I", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class OnScreenCaptureStoppedEvent extends TrtcBaseEvent {
    static IPatchRedirector $redirector_;
    private final int reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnScreenCaptureStoppedEvent(@NotNull String appId, int i3) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appId, i3);
        } else {
            this.reason = i3;
        }
    }

    public final int getReason() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.reason;
    }
}
