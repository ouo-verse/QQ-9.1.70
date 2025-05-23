package com.tencent.pts.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public final class PTSNodeStyleConstant {
    static IPatchRedirector $redirector_ = null;
    public static final String BACKGROUND_COLOR = "background-color";
    public static final String BACKGROUND_IMAGE = "background-image";
    public static final String BORDER_BOTTOM_LEFT_RADIUS = "border-bottom-left-radius";
    public static final String BORDER_BOTTOM_RIGHT_RADIUS = "border-bottom-right-radius";
    public static final String BORDER_COLOR = "border-color";
    public static final String BORDER_RADIUS = "border-radius";
    public static final String BORDER_TOP_LEFT_RADIUS = "border-top-left-radius";
    public static final String BORDER_TOP_RIGHT_RADIUS = "border-top-right-radius";
    public static final String BORDER_WIDTH = "border-width";
    public static final String BOTTOM = "bottom";
    public static final String CALCULATED_HEIGHT = "calculated_height";
    public static final String CALCULATED_LEFT = "calculated_left";
    public static final String CALCULATED_TOP = "calculated_top";
    public static final String CALCULATED_WIDTH = "calculated_width";
    public static final String COLOR = "color";
    public static final String FONT_FAMILY = "font-family";
    public static final String FONT_SIZE = "font-size";
    public static final String FONT_STYLE = "font-style";
    public static final String FONT_WEIGHT = "font-weight";
    public static final String HEIGHT = "height";
    public static final String LEFT = "left";
    public static final String LINE_HEIGHT = "line-height";
    public static final String LINE_MAX_NUM = "-webkit-line-clamp";
    public static final String PADDING = "padding";
    public static final String PADDING_BOTTOM = "padding-bottom";
    public static final String PADDING_LEFT = "padding-left";
    public static final String PADDING_RIGHT = "padding-right";
    public static final String PADDING_TOP = "padding-top";
    public static final String RIGHT = "right";
    public static final String TEXT_ALIGN = "text-align";
    public static final String TEXT_DECORATION = "text-decoration";
    public static final String TEXT_WORD_BREAK = "word-break";
    public static final String TOP = "top";
    public static final String WIDTH = "width";

    PTSNodeStyleConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
