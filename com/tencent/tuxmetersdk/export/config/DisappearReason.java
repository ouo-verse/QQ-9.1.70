package com.tencent.tuxmetersdk.export.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class DisappearReason {
    private static final /* synthetic */ DisappearReason[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final DisappearReason AUTO;
    public static final DisappearReason CLICK_BACK;
    public static final DisappearReason CLICK_MAIN_BUTTON;
    public static final DisappearReason CLICK_STAR_OPTION;
    public static final DisappearReason CLICK_X;
    public static final DisappearReason CLOSE_APP;
    public static final DisappearReason OTHER;
    public static final DisappearReason SLIDE_DOWN;
    public static final DisappearReason SUBMIT;
    private int code;

    /* renamed from: msg, reason: collision with root package name */
    private String f383467msg;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        DisappearReason disappearReason = new DisappearReason("SUBMIT", 0, 0, "\u70b9\u51fb\u63d0\u4ea4");
        SUBMIT = disappearReason;
        DisappearReason disappearReason2 = new DisappearReason("CLICK_X", 1, 1, "\u70b9\u51fbX\u6309\u94ae");
        CLICK_X = disappearReason2;
        DisappearReason disappearReason3 = new DisappearReason("CLOSE_APP", 2, 2, "\u5173\u95edAPP");
        CLOSE_APP = disappearReason3;
        DisappearReason disappearReason4 = new DisappearReason("OTHER", 3, 3, "\u5176\u4ed6");
        OTHER = disappearReason4;
        DisappearReason disappearReason5 = new DisappearReason("CLICK_MAIN_BUTTON", 4, 4, "\u70b9\u51fb\u4e3b\u6309\u94ae");
        CLICK_MAIN_BUTTON = disappearReason5;
        DisappearReason disappearReason6 = new DisappearReason("CLICK_STAR_OPTION", 5, 5, "\u70b9\u51fb\u91cf\u8868\u9898\u7684\u9009\u9879");
        CLICK_STAR_OPTION = disappearReason6;
        DisappearReason disappearReason7 = new DisappearReason("AUTO", 6, 6, "\u81ea\u52a8\u6d88\u5931");
        AUTO = disappearReason7;
        DisappearReason disappearReason8 = new DisappearReason("CLICK_BACK", 7, 7, "\u70b9\u51fb\u8fd4\u56de\u952e");
        CLICK_BACK = disappearReason8;
        DisappearReason disappearReason9 = new DisappearReason("SLIDE_DOWN", 8, 8, "\u4e0b\u6ed1\u5f39\u7a97");
        SLIDE_DOWN = disappearReason9;
        $VALUES = new DisappearReason[]{disappearReason, disappearReason2, disappearReason3, disappearReason4, disappearReason5, disappearReason6, disappearReason7, disappearReason8, disappearReason9};
    }

    DisappearReason(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
        } else {
            this.code = i16;
            this.f383467msg = str2;
        }
    }

    public static DisappearReason valueOf(String str) {
        return (DisappearReason) Enum.valueOf(DisappearReason.class, str);
    }

    public static DisappearReason[] values() {
        return (DisappearReason[]) $VALUES.clone();
    }

    public int getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.code;
    }

    public String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f383467msg;
    }
}
