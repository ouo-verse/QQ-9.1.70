package com.tencent.mtt.hippy.common;

import android.view.View;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyTag {
    private static final String TAG_CLASS_NAME = "className";

    public static HippyMap createTagMap(String str, HippyMap hippyMap) {
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushString("className", str);
        return hippyMap2;
    }

    public static String getClassName(View view) {
        return getStringValue(view, "className");
    }

    private static int getIntValue(View view, String str) {
        if (view != null && str != null) {
            Object tag = view.getTag();
            if (tag instanceof HippyMap) {
                HippyMap hippyMap = (HippyMap) tag;
                if (hippyMap.containsKey(str)) {
                    return hippyMap.getInt(str);
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    private static String getStringValue(View view, String str) {
        if (view != null && str != null) {
            Object tag = view.getTag();
            if (tag instanceof HippyMap) {
                HippyMap hippyMap = (HippyMap) tag;
                if (hippyMap.containsKey(str)) {
                    return hippyMap.getString(str);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private static void setIntValue(View view, String str, int i3) {
        if (view != null && str != null) {
            Object tag = view.getTag();
            if (tag instanceof HippyMap) {
                ((HippyMap) tag).pushInt(str, i3);
            }
        }
    }

    private static void setStringValue(View view, String str, String str2) {
        if (view != null && str != null) {
            Object tag = view.getTag();
            if (tag instanceof HippyMap) {
                HippyMap hippyMap = (HippyMap) tag;
                if (str2 == null) {
                    str2 = "";
                }
                hippyMap.pushString(str, str2);
            }
        }
    }
}
