package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class CssStyle {
    private static final String TAG = "CssStyle";
    public static Map<String, Integer> fontWeightStringToInteger;
    public boolean isInherit;
    public String styleName;
    public Object styleValue;

    public static CssStyle createStyle(String str, String str2) {
        CssStyle cssStyle = new CssStyle();
        cssStyle.styleName = str;
        try {
            if ("line-height".equalsIgnoreCase(str)) {
                cssStyle.styleValue = getSize(str2);
                cssStyle.isInherit = true;
            } else if ("font-size".equalsIgnoreCase(str)) {
                cssStyle.styleValue = getSize(str2);
                cssStyle.isInherit = true;
            } else if ("color".equalsIgnoreCase(str)) {
                cssStyle.styleValue = str2;
                cssStyle.isInherit = true;
            } else if ("width".equalsIgnoreCase(str)) {
                cssStyle.styleValue = getSize(str2);
            } else if ("height".equalsIgnoreCase(str)) {
                cssStyle.styleValue = getSize(str2);
            } else if ("-webkit-line-clamp".equalsIgnoreCase(str)) {
                cssStyle.styleValue = Integer.valueOf(str2);
                cssStyle.isInherit = true;
            } else if ("padding-left".equalsIgnoreCase(str)) {
                cssStyle.styleValue = getSize(str2);
                cssStyle.isInherit = true;
            } else if ("padding-right".equalsIgnoreCase(str)) {
                cssStyle.styleValue = getSize(str2);
                cssStyle.isInherit = true;
            } else if ("padding-top".equalsIgnoreCase(str)) {
                cssStyle.styleValue = getSize(str2);
                cssStyle.isInherit = true;
            } else if ("padding-bottom".equalsIgnoreCase(str)) {
                cssStyle.styleValue = getSize(str2);
                cssStyle.isInherit = true;
            } else if ("border-radius".equalsIgnoreCase(str)) {
                cssStyle.styleValue = getSize(str2);
                cssStyle.isInherit = true;
            } else {
                cssStyle.styleValue = str2;
                cssStyle.isInherit = true;
            }
        } catch (Exception e16) {
            LogUtil.QLog.e(TAG, 1, "createStyle error! msg=" + e16);
        }
        return cssStyle;
    }

    public static CssStyle getDisplay(boolean z16) {
        CssStyle cssStyle = new CssStyle();
        cssStyle.styleName = "display";
        if (z16) {
            cssStyle.styleValue = "block";
            return cssStyle;
        }
        cssStyle.styleValue = CssStyleSet.INLINE_STYLE;
        return cssStyle;
    }

    public static int getFontWeightFromStringToInteger(String str) {
        if (fontWeightStringToInteger == null) {
            HashMap hashMap = new HashMap();
            fontWeightStringToInteger = hashMap;
            hashMap.put("thin", 100);
            fontWeightStringToInteger.put("extra light", 200);
            fontWeightStringToInteger.put(MiniAppConst.MENU_STYLE_LIGHT, 300);
            fontWeightStringToInteger.put("regular", 400);
            fontWeightStringToInteger.put("normal", 400);
            fontWeightStringToInteger.put("book", 400);
            fontWeightStringToInteger.put("roman", 400);
            fontWeightStringToInteger.put("medium", 500);
            fontWeightStringToInteger.put("semi bold", 600);
            fontWeightStringToInteger.put("demi bold", 600);
            fontWeightStringToInteger.put("bold", 700);
            fontWeightStringToInteger.put("extra bold", 800);
            fontWeightStringToInteger.put("ultra bold", 800);
            fontWeightStringToInteger.put("black", 900);
            fontWeightStringToInteger.put("heavy", 900);
        }
        Integer num = 0;
        if (str != null) {
            String lowerCase = str.toLowerCase();
            if (fontWeightStringToInteger.containsKey(lowerCase)) {
                num = fontWeightStringToInteger.get(lowerCase);
            }
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static Object getSize(String str) {
        if (str.endsWith("rpx")) {
            return Integer.valueOf(Utils.rp2px(Integer.parseInt(str.substring(0, str.length() - 3).trim())) / 2);
        }
        if (str.endsWith("px")) {
            return Integer.valueOf(Utils.dp2px(Integer.parseInt(str.substring(0, str.length() - 2))));
        }
        return null;
    }
}
