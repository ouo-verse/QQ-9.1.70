package com.tencent.could.huiyansdk.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class HuiYanPublicEvent {
    private static final /* synthetic */ HuiYanPublicEvent[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HuiYanPublicEvent GET_LIVE_TYPE;
    public static final HuiYanPublicEvent GET_NET_RESULT;
    public static final HuiYanPublicEvent LOCAL_CHECK_OVER;
    public static final HuiYanPublicEvent START_CHECK;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18807);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HuiYanPublicEvent huiYanPublicEvent = new HuiYanPublicEvent("GET_LIVE_TYPE", 0);
        GET_LIVE_TYPE = huiYanPublicEvent;
        HuiYanPublicEvent huiYanPublicEvent2 = new HuiYanPublicEvent("START_CHECK", 1);
        START_CHECK = huiYanPublicEvent2;
        HuiYanPublicEvent huiYanPublicEvent3 = new HuiYanPublicEvent("LOCAL_CHECK_OVER", 2);
        LOCAL_CHECK_OVER = huiYanPublicEvent3;
        HuiYanPublicEvent huiYanPublicEvent4 = new HuiYanPublicEvent("GET_NET_RESULT", 3);
        GET_NET_RESULT = huiYanPublicEvent4;
        $VALUES = new HuiYanPublicEvent[]{huiYanPublicEvent, huiYanPublicEvent2, huiYanPublicEvent3, huiYanPublicEvent4};
    }

    HuiYanPublicEvent(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static HuiYanPublicEvent valueOf(String str) {
        return (HuiYanPublicEvent) Enum.valueOf(HuiYanPublicEvent.class, str);
    }

    public static HuiYanPublicEvent[] values() {
        return (HuiYanPublicEvent[]) $VALUES.clone();
    }
}
