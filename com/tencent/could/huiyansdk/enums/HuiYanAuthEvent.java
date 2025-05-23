package com.tencent.could.huiyansdk.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class HuiYanAuthEvent {
    private static final /* synthetic */ HuiYanAuthEvent[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HuiYanAuthEvent ALL_ACTION_DONE;
    public static final HuiYanAuthEvent BLINK_CHECK;
    public static final HuiYanAuthEvent BLINK_CHECK_DONE;
    public static final HuiYanAuthEvent LOCAL_DETECTION_DONE;
    public static final HuiYanAuthEvent NOD_HEAD_CHECK;
    public static final HuiYanAuthEvent NOD_HEAD_CHECK_DONE;
    public static final HuiYanAuthEvent NONE;
    public static final HuiYanAuthEvent OPEN_MOUTH_CHECK;
    public static final HuiYanAuthEvent OPEN_MOUTH_CHECK_DONE;
    public static final HuiYanAuthEvent REFLECT_CHECK;
    public static final HuiYanAuthEvent SHAKE_HEAD_CHECK;
    public static final HuiYanAuthEvent SHAKE_HEAD_CHECK_DONE;
    public static final HuiYanAuthEvent SILENCE_CHECK;
    public static final HuiYanAuthEvent SILENCE_CHECK_DONE;
    public static final HuiYanAuthEvent START_AUTH;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16603);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HuiYanAuthEvent huiYanAuthEvent = new HuiYanAuthEvent("NONE", 0);
        NONE = huiYanAuthEvent;
        HuiYanAuthEvent huiYanAuthEvent2 = new HuiYanAuthEvent("START_AUTH", 1);
        START_AUTH = huiYanAuthEvent2;
        HuiYanAuthEvent huiYanAuthEvent3 = new HuiYanAuthEvent("OPEN_MOUTH_CHECK", 2);
        OPEN_MOUTH_CHECK = huiYanAuthEvent3;
        HuiYanAuthEvent huiYanAuthEvent4 = new HuiYanAuthEvent("SILENCE_CHECK", 3);
        SILENCE_CHECK = huiYanAuthEvent4;
        HuiYanAuthEvent huiYanAuthEvent5 = new HuiYanAuthEvent("BLINK_CHECK", 4);
        BLINK_CHECK = huiYanAuthEvent5;
        HuiYanAuthEvent huiYanAuthEvent6 = new HuiYanAuthEvent("NOD_HEAD_CHECK", 5);
        NOD_HEAD_CHECK = huiYanAuthEvent6;
        HuiYanAuthEvent huiYanAuthEvent7 = new HuiYanAuthEvent("SHAKE_HEAD_CHECK", 6);
        SHAKE_HEAD_CHECK = huiYanAuthEvent7;
        HuiYanAuthEvent huiYanAuthEvent8 = new HuiYanAuthEvent("REFLECT_CHECK", 7);
        REFLECT_CHECK = huiYanAuthEvent8;
        HuiYanAuthEvent huiYanAuthEvent9 = new HuiYanAuthEvent("OPEN_MOUTH_CHECK_DONE", 8);
        OPEN_MOUTH_CHECK_DONE = huiYanAuthEvent9;
        HuiYanAuthEvent huiYanAuthEvent10 = new HuiYanAuthEvent("SILENCE_CHECK_DONE", 9);
        SILENCE_CHECK_DONE = huiYanAuthEvent10;
        HuiYanAuthEvent huiYanAuthEvent11 = new HuiYanAuthEvent("BLINK_CHECK_DONE", 10);
        BLINK_CHECK_DONE = huiYanAuthEvent11;
        HuiYanAuthEvent huiYanAuthEvent12 = new HuiYanAuthEvent("NOD_HEAD_CHECK_DONE", 11);
        NOD_HEAD_CHECK_DONE = huiYanAuthEvent12;
        HuiYanAuthEvent huiYanAuthEvent13 = new HuiYanAuthEvent("SHAKE_HEAD_CHECK_DONE", 12);
        SHAKE_HEAD_CHECK_DONE = huiYanAuthEvent13;
        HuiYanAuthEvent huiYanAuthEvent14 = new HuiYanAuthEvent("ALL_ACTION_DONE", 13);
        ALL_ACTION_DONE = huiYanAuthEvent14;
        HuiYanAuthEvent huiYanAuthEvent15 = new HuiYanAuthEvent("LOCAL_DETECTION_DONE", 14);
        LOCAL_DETECTION_DONE = huiYanAuthEvent15;
        $VALUES = new HuiYanAuthEvent[]{huiYanAuthEvent, huiYanAuthEvent2, huiYanAuthEvent3, huiYanAuthEvent4, huiYanAuthEvent5, huiYanAuthEvent6, huiYanAuthEvent7, huiYanAuthEvent8, huiYanAuthEvent9, huiYanAuthEvent10, huiYanAuthEvent11, huiYanAuthEvent12, huiYanAuthEvent13, huiYanAuthEvent14, huiYanAuthEvent15};
    }

    HuiYanAuthEvent(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static HuiYanAuthEvent valueOf(String str) {
        return (HuiYanAuthEvent) Enum.valueOf(HuiYanAuthEvent.class, str);
    }

    public static HuiYanAuthEvent[] values() {
        return (HuiYanAuthEvent[]) $VALUES.clone();
    }
}
