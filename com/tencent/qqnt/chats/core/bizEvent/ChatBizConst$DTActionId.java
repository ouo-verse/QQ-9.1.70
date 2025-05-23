package com.tencent.qqnt.chats.core.bizEvent;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/chats/core/bizEvent/ChatBizConst$DTActionId", "", "Lcom/tencent/qqnt/chats/core/bizEvent/ChatBizConst$DTActionId;", "<init>", "(Ljava/lang/String;I)V", "ListExpo", "PageIn", "PageOut", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatBizConst$DTActionId {
    private static final /* synthetic */ ChatBizConst$DTActionId[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ChatBizConst$DTActionId ListExpo;
    public static final ChatBizConst$DTActionId PageIn;
    public static final ChatBizConst$DTActionId PageOut;

    private static final /* synthetic */ ChatBizConst$DTActionId[] $values() {
        return new ChatBizConst$DTActionId[]{ListExpo, PageIn, PageOut};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40129);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ListExpo = new ChatBizConst$DTActionId("ListExpo", 0);
        PageIn = new ChatBizConst$DTActionId("PageIn", 1);
        PageOut = new ChatBizConst$DTActionId("PageOut", 2);
        $VALUES = $values();
    }

    ChatBizConst$DTActionId(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ChatBizConst$DTActionId valueOf(String str) {
        return (ChatBizConst$DTActionId) Enum.valueOf(ChatBizConst$DTActionId.class, str);
    }

    public static ChatBizConst$DTActionId[] values() {
        return (ChatBizConst$DTActionId[]) $VALUES.clone();
    }
}
