package com.tencent.pts.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class PTSConstant {
    static IPatchRedirector $redirector_ = null;
    public static final String CUSTOM_VIEW_TYPE_NINE_PATCH = "nine-patch";
    public static final String CUSTOM_VIEW_TYPE_SCROLL_VIEW = "scroll-view";
    public static final String CUSTOM_VIEW_TYPE_TIMER = "CountDownTimer";
    public static final String CUSTOM_VIEW_TYPE_UMBREON = "Umbreon";
    public static final String VNT_BLOCK = "block";
    public static final String VNT_BORING = "boring";
    public static final String VNT_BUTTON = "button";
    public static final String VNT_CONTAINER = "view";
    public static final String VNT_IMAGE = "img";
    public static final String VNT_LIST = "list";
    public static final String VNT_NINE_PATCH_VIEW = "nine-patch";
    public static final String VNT_PAGE = "page";
    public static final String VNT_RICH_TEXT = "rich-text";
    public static final String VNT_SWIPER = "swiper";
    public static final String VNT_SWIPER_ITEM = "swiper-item";
    public static final String VNT_TEXT = "text";

    public PTSConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
