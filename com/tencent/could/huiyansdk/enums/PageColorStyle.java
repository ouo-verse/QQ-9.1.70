package com.tencent.could.huiyansdk.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class PageColorStyle {
    private static final /* synthetic */ PageColorStyle[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PageColorStyle Dark;
    public static final PageColorStyle Light;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19989);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        PageColorStyle pageColorStyle = new PageColorStyle("Light", 0);
        Light = pageColorStyle;
        PageColorStyle pageColorStyle2 = new PageColorStyle("Dark", 1);
        Dark = pageColorStyle2;
        $VALUES = new PageColorStyle[]{pageColorStyle, pageColorStyle2};
    }

    PageColorStyle(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static PageColorStyle valueOf(String str) {
        return (PageColorStyle) Enum.valueOf(PageColorStyle.class, str);
    }

    public static PageColorStyle[] values() {
        return (PageColorStyle[]) $VALUES.clone();
    }
}
