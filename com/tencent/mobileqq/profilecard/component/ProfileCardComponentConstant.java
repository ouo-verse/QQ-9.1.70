package com.tencent.mobileqq.profilecard.component;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileCardComponentConstant {
    static IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_QQ_DIAMOND_GUEST_URL = "https://club.vip.qq.com/guestprivilege?_wv=16777218&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&_wvx=10&friend={friendqq}";
    public static final String DEFAULT_QQ_DIAMOND_HOST_URL = "https://club.vip.qq.com/privilege?_wv=16777218&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&_wvx=10";
    public static final String DEFAULT_QQ_VALUE_GUEST_URL = "https://club.vip.qq.com/card/friend?_wv=16778247&_wwv=68&_wvx=10&qq={friendqq}";
    public static final String DEFAULT_QQ_VALUE_HOST_URL = "https://club.vip.qq.com/card?_wvx=10&_nav_anim=true&_nav_alpha=0";
    public static final String TOGGLE_KEY_QQ_DIAMOND_GUEST_URL = "qq_diamond_guest_url";
    public static final String TOGGLE_KEY_QQ_DIAMOND_HOST_URL = "qq_diamond_host_url";
    public static final String TOGGLE_KEY_QQ_VALUE_GUEST_URL = "qq_value_guest_url";
    public static final String TOGGLE_KEY_QQ_VALUE_HOST_URL = "qq_value_host_url";
    public static final String TOGGLE_SWITCH_QQ_VALUE = "qq_8838_profilecard_qqvalue_jump_url";

    public ProfileCardComponentConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
