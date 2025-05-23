package com.tencent.could.huiyansdk.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class HuiYanAuthTipsEvent {
    private static final /* synthetic */ HuiYanAuthTipsEvent[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HuiYanAuthTipsEvent ACT_BLINK;
    public static final HuiYanAuthTipsEvent ACT_NOD_HEAD;
    public static final HuiYanAuthTipsEvent ACT_OPEN_MOUTH;
    public static final HuiYanAuthTipsEvent ACT_SCREEN_SHAKING;
    public static final HuiYanAuthTipsEvent ACT_SHAKE_HEAD;
    public static final HuiYanAuthTipsEvent INCOMPLETE_FACE;
    public static final HuiYanAuthTipsEvent LIGHT_TOO_LOW;
    public static final HuiYanAuthTipsEvent LIGHT_TOO_STRONG;
    public static final HuiYanAuthTipsEvent NONE;
    public static final HuiYanAuthTipsEvent NO_CHIN;
    public static final HuiYanAuthTipsEvent NO_FACE;
    public static final HuiYanAuthTipsEvent NO_LEFT_EYE;
    public static final HuiYanAuthTipsEvent NO_LEFT_FACE;
    public static final HuiYanAuthTipsEvent NO_MOUTH;
    public static final HuiYanAuthTipsEvent NO_NOSE;
    public static final HuiYanAuthTipsEvent NO_RIGHT_EYE;
    public static final HuiYanAuthTipsEvent NO_RIGHT_FACE;
    public static final HuiYanAuthTipsEvent POSE_CLOSER;
    public static final HuiYanAuthTipsEvent POSE_FARTHER;
    public static final HuiYanAuthTipsEvent POSE_INCORRECT;
    public static final HuiYanAuthTipsEvent POSE_KEEP;
    public static final HuiYanAuthTipsEvent POSE_OPEN_EYE;
    public static final HuiYanAuthTipsEvent TOO_MANY_FACE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20039);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HuiYanAuthTipsEvent huiYanAuthTipsEvent = new HuiYanAuthTipsEvent("NONE", 0);
        NONE = huiYanAuthTipsEvent;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent2 = new HuiYanAuthTipsEvent("ACT_OPEN_MOUTH", 1);
        ACT_OPEN_MOUTH = huiYanAuthTipsEvent2;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent3 = new HuiYanAuthTipsEvent("ACT_BLINK", 2);
        ACT_BLINK = huiYanAuthTipsEvent3;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent4 = new HuiYanAuthTipsEvent("ACT_NOD_HEAD", 3);
        ACT_NOD_HEAD = huiYanAuthTipsEvent4;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent5 = new HuiYanAuthTipsEvent("ACT_SHAKE_HEAD", 4);
        ACT_SHAKE_HEAD = huiYanAuthTipsEvent5;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent6 = new HuiYanAuthTipsEvent("ACT_SCREEN_SHAKING", 5);
        ACT_SCREEN_SHAKING = huiYanAuthTipsEvent6;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent7 = new HuiYanAuthTipsEvent("NO_FACE", 6);
        NO_FACE = huiYanAuthTipsEvent7;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent8 = new HuiYanAuthTipsEvent("NO_LEFT_FACE", 7);
        NO_LEFT_FACE = huiYanAuthTipsEvent8;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent9 = new HuiYanAuthTipsEvent("NO_RIGHT_FACE", 8);
        NO_RIGHT_FACE = huiYanAuthTipsEvent9;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent10 = new HuiYanAuthTipsEvent("NO_CHIN", 9);
        NO_CHIN = huiYanAuthTipsEvent10;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent11 = new HuiYanAuthTipsEvent("NO_MOUTH", 10);
        NO_MOUTH = huiYanAuthTipsEvent11;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent12 = new HuiYanAuthTipsEvent("NO_NOSE", 11);
        NO_NOSE = huiYanAuthTipsEvent12;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent13 = new HuiYanAuthTipsEvent("NO_LEFT_EYE", 12);
        NO_LEFT_EYE = huiYanAuthTipsEvent13;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent14 = new HuiYanAuthTipsEvent("NO_RIGHT_EYE", 13);
        NO_RIGHT_EYE = huiYanAuthTipsEvent14;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent15 = new HuiYanAuthTipsEvent("POSE_KEEP", 14);
        POSE_KEEP = huiYanAuthTipsEvent15;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent16 = new HuiYanAuthTipsEvent("POSE_CLOSER", 15);
        POSE_CLOSER = huiYanAuthTipsEvent16;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent17 = new HuiYanAuthTipsEvent("POSE_FARTHER", 16);
        POSE_FARTHER = huiYanAuthTipsEvent17;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent18 = new HuiYanAuthTipsEvent("POSE_INCORRECT", 17);
        POSE_INCORRECT = huiYanAuthTipsEvent18;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent19 = new HuiYanAuthTipsEvent("POSE_OPEN_EYE", 18);
        POSE_OPEN_EYE = huiYanAuthTipsEvent19;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent20 = new HuiYanAuthTipsEvent("TOO_MANY_FACE", 19);
        TOO_MANY_FACE = huiYanAuthTipsEvent20;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent21 = new HuiYanAuthTipsEvent("INCOMPLETE_FACE", 20);
        INCOMPLETE_FACE = huiYanAuthTipsEvent21;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent22 = new HuiYanAuthTipsEvent("LIGHT_TOO_LOW", 21);
        LIGHT_TOO_LOW = huiYanAuthTipsEvent22;
        HuiYanAuthTipsEvent huiYanAuthTipsEvent23 = new HuiYanAuthTipsEvent("LIGHT_TOO_STRONG", 22);
        LIGHT_TOO_STRONG = huiYanAuthTipsEvent23;
        $VALUES = new HuiYanAuthTipsEvent[]{huiYanAuthTipsEvent, huiYanAuthTipsEvent2, huiYanAuthTipsEvent3, huiYanAuthTipsEvent4, huiYanAuthTipsEvent5, huiYanAuthTipsEvent6, huiYanAuthTipsEvent7, huiYanAuthTipsEvent8, huiYanAuthTipsEvent9, huiYanAuthTipsEvent10, huiYanAuthTipsEvent11, huiYanAuthTipsEvent12, huiYanAuthTipsEvent13, huiYanAuthTipsEvent14, huiYanAuthTipsEvent15, huiYanAuthTipsEvent16, huiYanAuthTipsEvent17, huiYanAuthTipsEvent18, huiYanAuthTipsEvent19, huiYanAuthTipsEvent20, huiYanAuthTipsEvent21, huiYanAuthTipsEvent22, huiYanAuthTipsEvent23};
    }

    HuiYanAuthTipsEvent(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static HuiYanAuthTipsEvent valueOf(String str) {
        return (HuiYanAuthTipsEvent) Enum.valueOf(HuiYanAuthTipsEvent.class, str);
    }

    public static HuiYanAuthTipsEvent[] values() {
        return (HuiYanAuthTipsEvent[]) $VALUES.clone();
    }
}
