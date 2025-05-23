package com.tencent.mobileqq.troopmanage.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/event/TroopManagePrettyEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "replyTextLeft", "", "replyTextRight", "(Ljava/lang/String;Ljava/lang/String;)V", "getReplyTextLeft", "()Ljava/lang/String;", "getReplyTextRight", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopManagePrettyEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String replyTextLeft;

    @NotNull
    private final String replyTextRight;

    public TroopManagePrettyEvent(@NotNull String replyTextLeft, @NotNull String replyTextRight) {
        Intrinsics.checkNotNullParameter(replyTextLeft, "replyTextLeft");
        Intrinsics.checkNotNullParameter(replyTextRight, "replyTextRight");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) replyTextLeft, (Object) replyTextRight);
        } else {
            this.replyTextLeft = replyTextLeft;
            this.replyTextRight = replyTextRight;
        }
    }

    @NotNull
    public final String getReplyTextLeft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.replyTextLeft;
    }

    @NotNull
    public final String getReplyTextRight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.replyTextRight;
    }
}
