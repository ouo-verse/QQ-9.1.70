package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class CssStyleSet {
    public static final String A_STYLE = "a";
    public static final String BACKGROUND_COLOR_STYLE = "background-color";
    public static final String BLOCK_STYLE = "block";
    public static final String BOLD_STYLE = "bold";
    public static final String CLAMP_STYLE = "-webkit-line-clamp";
    public static final String COLOR_STYLE = "color";
    public static final String DISPLAY_STYLE = "display";
    public static final String DIV_STYLE = "div";
    public static final String FONT_SIZE_STYLE = "font-size";
    public static final String FONT_WEIGHT_STYLE = "font-weight";
    public static final String HEIGHT_STYLE = "height";
    public static final String HREF_STYLE = "href";
    public static final String INLINE_STYLE = "inline";
    public static final String LINE_HEIGHT_STYLE = "line-height";
    public static final String PADDING_BOTTOM = "padding-bottom";
    public static final String PADDING_LEFT = "padding-left";
    public static final String PADDING_RIGHT = "padding-right";
    public static final String PADDING_TOP = "padding-top";
    public static final String P_STYLE = "p";
    public static final String RADIUS = "border-radius";
    public static final String RATIO_STYLE = "ratio";
    public static final String STRONG_STYLE = "strong";
    public static final String WIDTH_STYLE = "width";
    private final Map<String, CssStyle> cssStyleMap = new HashMap();

    public void addCssStyle(CssStyle cssStyle) {
        this.cssStyleMap.put(cssStyle.styleName, cssStyle);
    }

    public void addInheritStyle(CssStyleSet cssStyleSet) {
        if (cssStyleSet != null) {
            for (Map.Entry<String, CssStyle> entry : cssStyleSet.getCssStyleMap().entrySet()) {
                if (entry.getValue().isInherit) {
                    addCssStyle(entry.getValue());
                }
            }
        }
    }

    public Map<String, CssStyle> getCssStyleMap() {
        return this.cssStyleMap;
    }
}
