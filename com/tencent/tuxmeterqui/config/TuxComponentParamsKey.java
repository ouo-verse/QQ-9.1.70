package com.tencent.tuxmeterqui.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class TuxComponentParamsKey {
    static IPatchRedirector $redirector_ = null;
    public static final String BACKGROUND_COLOR = "background_color";
    public static final String MATRIX_DISPLAY_TYPE = "matrix_display_type";
    public static final String OPTION_MULTIPLE = "multiple";
    public static final String OPTION_TYPE_LINE_ITEMS = "option_type_line_items";
    public static final String OPTION_TYPE_MAX = "option_type_max";
    public static final String PRIMARY_COLOR = "primary_color";
    public static final String STAR_OPTION_TYPE = "star_option_type";
    public static final String TEXT_COLOR = "text_color";

    public TuxComponentParamsKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
