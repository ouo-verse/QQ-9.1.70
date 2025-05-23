package com.qzone.proxy.feedcomponent.util;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.PrivacyTextUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class m {
    public static byte a(int i3) {
        if (i3 == 4) {
            return (byte) 4;
        }
        if (i3 != 16) {
            if (i3 != 64) {
                if (i3 != 128) {
                    if (i3 != 512) {
                        if (i3 != 1024) {
                            return (byte) 1;
                        }
                        return (byte) 10;
                    }
                    return (byte) 9;
                }
                return (byte) 8;
            }
            return (byte) 3;
        }
        return (byte) 6;
    }

    public static String b(int i3) {
        if (i3 == 4) {
            return "QQ\u597d\u53cb\u53ef\u89c1";
        }
        if (i3 == 16) {
            return "\u90e8\u5206\u597d\u53cb\u53ef\u89c1";
        }
        if (i3 == 64) {
            return "\u4ec5\u81ea\u5df1\u53ef\u89c1";
        }
        if (i3 == 128) {
            return "\u90e8\u5206\u597d\u53cb\u4e0d\u53ef\u89c1";
        }
        if (i3 == 512) {
            return "\u597d\u53cb\u5708\u53ef\u89c1";
        }
        if (i3 != 1024) {
            return PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL;
        }
        return "\u5171\u540c\u597d\u53cb\u53ef\u89c1";
    }
}
