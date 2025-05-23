package com.tencent.mobileqq.qqlive.room.multichat.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes17.dex */
public final class MultiAvChatType {
    private static final /* synthetic */ MultiAvChatType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MultiAvChatType LIVE_BOX_NINE;
    public static final MultiAvChatType LIVE_BOX_NONE;
    public static final MultiAvChatType LIVE_BOX_SEVEN;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55669);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        MultiAvChatType multiAvChatType = new MultiAvChatType("LIVE_BOX_NONE", 0);
        LIVE_BOX_NONE = multiAvChatType;
        MultiAvChatType multiAvChatType2 = new MultiAvChatType("LIVE_BOX_SEVEN", 1);
        LIVE_BOX_SEVEN = multiAvChatType2;
        MultiAvChatType multiAvChatType3 = new MultiAvChatType("LIVE_BOX_NINE", 2);
        LIVE_BOX_NINE = multiAvChatType3;
        $VALUES = new MultiAvChatType[]{multiAvChatType, multiAvChatType2, multiAvChatType3};
    }

    MultiAvChatType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MultiAvChatType valueOf(String str) {
        return (MultiAvChatType) Enum.valueOf(MultiAvChatType.class, str);
    }

    public static MultiAvChatType[] values() {
        return (MultiAvChatType[]) $VALUES.clone();
    }
}
