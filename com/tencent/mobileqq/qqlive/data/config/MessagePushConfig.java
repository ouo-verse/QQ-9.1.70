package com.tencent.mobileqq.qqlive.data.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class MessagePushConfig {
    static IPatchRedirector $redirector_;
    private ArrayList<Integer> messageType;

    /* loaded from: classes17.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private MessagePushConfig messagePushConfig;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.messagePushConfig = new MessagePushConfig();
            }
        }

        public Builder addMessageType(MessagePushType messagePushType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messagePushType);
            }
            this.messagePushConfig.messageType.add(Integer.valueOf(messagePushType.level));
            return this;
        }

        public MessagePushConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MessagePushConfig) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.messagePushConfig;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes17.dex */
    public static final class MessagePushType {
        private static final /* synthetic */ MessagePushType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final MessagePushType CHAT;
        public static final MessagePushType ENTER;
        public int level;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56667);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            MessagePushType messagePushType = new MessagePushType("CHAT", 0, 33);
            CHAT = messagePushType;
            MessagePushType messagePushType2 = new MessagePushType("ENTER", 1, 200);
            ENTER = messagePushType2;
            $VALUES = new MessagePushType[]{messagePushType, messagePushType2};
        }

        MessagePushType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.level = i16;
            }
        }

        public static MessagePushType valueOf(String str) {
            return (MessagePushType) Enum.valueOf(MessagePushType.class, str);
        }

        public static MessagePushType[] values() {
            return (MessagePushType[]) $VALUES.clone();
        }
    }

    public MessagePushConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.messageType = new ArrayList<>();
        }
    }

    public ArrayList<Integer> getMessageType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.messageType;
    }
}
