package com.tencent.pts.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public final class PTSNodeAttributeConstant {
    static IPatchRedirector $redirector_ = null;
    public static final String ATTRIBUTE_DEFAULT_INDICATOR_STYLE_DOT = "dot";
    public static final String ATTRIBUTE_DEFAULT_INDICATOR_STYLE_TXT = "text";
    public static final String ATTRIBUTE_ID = "id";
    public static final String ATTRIBUTE_PRESS_BACKGROUND_COLOR = "pts:on-pressed-background-color";
    public static final String ATTRIBUTE_PRESS_COLOR = "pts:on-pressed-color";
    public static final String ATTRIBUTE_PRESS_SRC = "pts:on-pressed-src";
    public static final String ATTRIBUTE_PTS_INDICATOR_BOTTOM = "pts:indicator-bottom";
    public static final String ATTRIBUTE_PTS_INDICATOR_DOTS_GAP = "pts:indicator-dots-gap";
    public static final String ATTRIBUTE_PTS_INDICATOR_DOTS_HEIGHT = "pts:indicator-dots-height";
    public static final String ATTRIBUTE_PTS_INDICATOR_DOTS_RADIUS = "pts:indicator-dots-radius";
    public static final String ATTRIBUTE_PTS_INDICATOR_DOTS_WIDTH = "pts:indicator-dots-width";
    public static final String ATTRIBUTE_PTS_INDICATOR_RIGHT = "pts:indicator-right";
    public static final String ATTRIBUTE_PTS_INDICATOR_RULE_HORIZONTAL = "pts:indicator-rule-horizontal";
    public static final String ATTRIBUTE_PTS_INDICATOR_RULE_VERTICAL = "pts:indicator-rule-vertical";
    public static final String ATTRIBUTE_PTS_INDICATOR_STYLE = "pts:indicator-style";
    public static final String END_TIMESTAMP = "end-timestamp";
    public static final String EVENT_TYPE_PTS_ON_EXPOSURE = "pts:on-exposure";
    public static final String EVENT_TYPE_PTS_ON_PRESS = "pts:on-pressed-";
    public static final String EVENT_TYPE_PTS_ON_SCROLL_ITEM_EXPOSURE = "pts:on-scroll-item-exposure";
    public static final String EVENT_TYPE_PTS_ON_SWIPER_DRAG = "pts:on-swiper-drag";
    public static final String EVENT_TYPE_PTS_ON_SWIPER_ITEM_EXPOSURE = "pts:on-swiper-item-exposure";
    public static final String EVENT_TYPE_PTS_ON_TAP = "pts:on-tap";
    public static final String EVENT_TYPE_TAP = "bindtap";
    public static final String IMAGE_URL = "src";
    public static final String MATH_ROUND = "math-round";
    public static final String MODE = "mode";
    public static final String MODE_ASPECT_FILL = "aspectFill";
    public static final String MODE_ASPECT_FIT = "aspectFit";
    public static final String MODE_CENTER = "center";
    public static final String MODE_SCALE_TO_FILL = "scaleToFill";
    public static final String PTS_CELL_TYPE = "pts:cell-type";
    public static final String PTS_CUSTOM_VIEW_TYPE = "pts:custom-view";
    public static final String START_TIMESTAMP = "start-timestamp";
    public static final String TEXT_CONTENT = "content";
    public static final String TIMER_STYLE = "timer-style";
    public static final String VIEW_ID = "viewID";

    PTSNodeAttributeConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
