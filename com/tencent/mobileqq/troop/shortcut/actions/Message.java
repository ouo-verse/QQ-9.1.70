package com.tencent.mobileqq.troop.shortcut.actions;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/actions/Message;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/troop/shortcut/actions/Message$MessageType;", "a", "Lcom/tencent/mobileqq/troop/shortcut/actions/Message$MessageType;", "b", "()Lcom/tencent/mobileqq/troop/shortcut/actions/Message$MessageType;", "type", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "<init>", "(Lcom/tencent/mobileqq/troop/shortcut/actions/Message$MessageType;Ljava/lang/String;)V", "MessageType", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class Message {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MessageType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String msg;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/actions/Message$MessageType;", "", "(Ljava/lang/String;I)V", "MSG_TYPE_DEFAULT", "MSG_TYPE_SEND_MESSAGE", "MSG_TYPE_INPUT", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class MessageType {
        private static final /* synthetic */ MessageType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final MessageType MSG_TYPE_DEFAULT;
        public static final MessageType MSG_TYPE_INPUT;
        public static final MessageType MSG_TYPE_SEND_MESSAGE;

        private static final /* synthetic */ MessageType[] $values() {
            return new MessageType[]{MSG_TYPE_DEFAULT, MSG_TYPE_SEND_MESSAGE, MSG_TYPE_INPUT};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24947);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            MSG_TYPE_DEFAULT = new MessageType("MSG_TYPE_DEFAULT", 0);
            MSG_TYPE_SEND_MESSAGE = new MessageType("MSG_TYPE_SEND_MESSAGE", 1);
            MSG_TYPE_INPUT = new MessageType("MSG_TYPE_INPUT", 2);
            $VALUES = $values();
        }

        MessageType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static MessageType valueOf(String str) {
            return (MessageType) Enum.valueOf(MessageType.class, str);
        }

        public static MessageType[] values() {
            return (MessageType[]) $VALUES.clone();
        }
    }

    public Message(@NotNull MessageType type, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) type, (Object) msg2);
        } else {
            this.type = type;
            this.msg = msg2;
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msg;
    }

    @NotNull
    public final MessageType b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        if (this.type == message.type && Intrinsics.areEqual(this.msg, message.msg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return (this.type.hashCode() * 31) + this.msg.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "Message(type=" + this.type + ", msg=" + this.msg + ")";
    }
}
