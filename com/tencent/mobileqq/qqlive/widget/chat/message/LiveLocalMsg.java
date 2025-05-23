package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/message/LiveLocalMsg;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/i;", "getHeader", "", "roomId", "J", "getRoomId", "()J", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "sender", "Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "getSender", "()Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "msgHeader", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/i;", "", "isSendMsgAlienation", "Z", "()Z", "setSendMsgAlienation", "(Z)V", "<init>", "(JLjava/lang/String;Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveLocalMsg extends SimpleBaseEvent implements f {
    static IPatchRedirector $redirector_;
    private boolean isSendMsgAlienation;

    @NotNull
    private final i msgHeader;
    private final long roomId;

    @NotNull
    private final LiveLoginInfo sender;

    @NotNull
    private final String text;

    public LiveLocalMsg(long j3, @NotNull String text, @NotNull LiveLoginInfo sender) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(sender, "sender");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), text, sender);
            return;
        }
        this.roomId = j3;
        this.text = text;
        this.sender = sender;
        this.msgHeader = new i();
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.f
    @Nullable
    public i getHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (i) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.msgHeader;
    }

    public final long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.roomId;
    }

    @NotNull
    public final LiveLoginInfo getSender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveLoginInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.sender;
    }

    @NotNull
    public final String getText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.text;
    }

    public final boolean isSendMsgAlienation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isSendMsgAlienation;
    }

    public final void setSendMsgAlienation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isSendMsgAlienation = z16;
        }
    }
}
