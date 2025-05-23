package com.tencent.could.huiyansdk.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class LanguageStyle {
    private static final /* synthetic */ LanguageStyle[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final LanguageStyle AUTO;
    public static final LanguageStyle CUSTOMIZE_LANGUAGE;
    public static final LanguageStyle ENGLISH;
    public static final LanguageStyle SIMPLIFIED_CHINESE;
    public static final LanguageStyle TRADITIONAL_CHINESE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        LanguageStyle languageStyle = new LanguageStyle("AUTO", 0);
        AUTO = languageStyle;
        LanguageStyle languageStyle2 = new LanguageStyle("ENGLISH", 1);
        ENGLISH = languageStyle2;
        LanguageStyle languageStyle3 = new LanguageStyle("SIMPLIFIED_CHINESE", 2);
        SIMPLIFIED_CHINESE = languageStyle3;
        LanguageStyle languageStyle4 = new LanguageStyle("TRADITIONAL_CHINESE", 3);
        TRADITIONAL_CHINESE = languageStyle4;
        LanguageStyle languageStyle5 = new LanguageStyle("CUSTOMIZE_LANGUAGE", 4);
        CUSTOMIZE_LANGUAGE = languageStyle5;
        $VALUES = new LanguageStyle[]{languageStyle, languageStyle2, languageStyle3, languageStyle4, languageStyle5};
    }

    LanguageStyle(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static LanguageStyle valueOf(String str) {
        return (LanguageStyle) Enum.valueOf(LanguageStyle.class, str);
    }

    public static LanguageStyle[] values() {
        return (LanguageStyle[]) $VALUES.clone();
    }
}
