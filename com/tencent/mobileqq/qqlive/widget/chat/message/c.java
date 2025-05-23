package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/message/c;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/i;", "getHeader", "", "toString", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "d", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "b", "()Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "followPushMessage", "e", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/i;", "msgHeader", "<init>", "(Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FollowPushMessage followPushMessage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i msgHeader;

    public c(@NotNull FollowPushMessage followPushMessage) {
        Intrinsics.checkNotNullParameter(followPushMessage, "followPushMessage");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) followPushMessage);
        } else {
            this.followPushMessage = followPushMessage;
            this.msgHeader = new i();
        }
    }

    @NotNull
    public final FollowPushMessage b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FollowPushMessage) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.followPushMessage;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.f
    @Nullable
    public i getHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (i) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgHeader;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "FollowPushScreenMessage(followPushMessage=" + this.followPushMessage + ')';
    }
}
