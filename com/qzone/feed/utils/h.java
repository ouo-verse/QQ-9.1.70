package com.qzone.feed.utils;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.PrivacyTextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h {
    public static int a(int i3) {
        if (i3 != 3) {
            if (i3 == 4) {
                return 4;
            }
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 != 8) {
                        if (i3 != 10) {
                            return 1;
                        }
                        return 1024;
                    }
                    return 128;
                }
                return 16;
            }
            return 9999;
        }
        return 64;
    }

    public static int b(int i3) {
        if (i3 == 4) {
            return 4;
        }
        if (i3 != 16) {
            if (i3 != 64) {
                if (i3 != 128) {
                    if (i3 != 1024) {
                        if (i3 != 9999) {
                            return 1;
                        }
                        return 5;
                    }
                    return 10;
                }
                return 8;
            }
            return 3;
        }
        return 6;
    }

    public static int c(int i3) {
        switch (i3) {
            case 1:
                return R.drawable.g5u;
            case 2:
                return R.drawable.g5z;
            case 3:
                return R.drawable.qui_lock;
            case 4:
            case 6:
                return R.drawable.qui_user;
            case 5:
                return R.drawable.g5v;
            case 7:
            default:
                return 0;
            case 8:
                return R.drawable.qui_blacklist;
            case 9:
                return R.drawable.g77;
            case 10:
                return R.drawable.qui_group;
        }
    }

    public static int g(int i3) {
        switch (i3) {
            case 3:
                return 64;
            case 4:
                return 4;
            case 5:
            case 7:
            default:
                return 1;
            case 6:
                return 16;
            case 8:
                return 128;
            case 9:
                return 512;
            case 10:
                return 1024;
        }
    }

    public static boolean h(int i3) {
        if (i3 != 16 && i3 != 128) {
            return false;
        }
        return true;
    }

    public static String d(int i3) {
        if (i3 == 1) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionPublic", "\u516c\u5f00");
        }
        if (i3 == 4) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionFriend", "QQ\u597d\u53cb\u53ef\u89c1");
        }
        if (i3 == 16) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionWhiteList", "\u90e8\u5206\u597d\u53cb\u53ef\u89c1");
        }
        if (i3 == 64) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionSelf", "\u79c1\u5bc6");
        }
        if (i3 == 128) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionBlackList", "\u90e8\u5206\u597d\u53cb\u4e0d\u53ef\u89c1");
        }
        if (i3 == 512) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionFriendCircle", "\u597d\u53cb\u5708\u53ef\u89c1");
        }
        if (i3 == 1024) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionSafeFeed", "\u5171\u540c\u597d\u53cb\u53ef\u89c1");
        }
        if (i3 != 9999) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionPublic", PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL);
        }
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionAnswerQuestion", "\u56de\u7b54\u95ee\u9898\u53ef\u89c1");
    }

    public static String f(int i3) {
        if (i3 == 1) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionPublic", PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL);
        }
        if (i3 == 4) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionFriend", "QQ\u597d\u53cb\u53ef\u89c1");
        }
        if (i3 == 16) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionWhiteList", "\u90e8\u5206\u597d\u53cb\u53ef\u89c1");
        }
        if (i3 == 64) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionSelf", "\u4ec5\u81ea\u5df1\u53ef\u89c1");
        }
        if (i3 == 128) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionBlackList", "\u90e8\u5206\u597d\u53cb\u4e0d\u53ef\u89c1");
        }
        if (i3 == 512) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionFriendCircle", "\u597d\u53cb\u5708\u53ef\u89c1");
        }
        if (i3 == 1024) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionSafeFeed", "\u5171\u540c\u597d\u53cb\u53ef\u89c1");
        }
        if (i3 != 9999) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionPublic", PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL);
        }
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionAnswerQuestion", "\u56de\u7b54\u95ee\u9898\u53ef\u89c1");
    }

    public static String e(int i3) {
        int i16;
        switch (i3) {
            case 1:
                i16 = R.string.ghc;
                break;
            case 2:
            case 5:
                i16 = R.string.f172992gc2;
                break;
            case 3:
                i16 = R.string.ghd;
                break;
            case 4:
                i16 = R.string.f172994gc4;
                break;
            case 6:
                i16 = R.string.gc7;
                break;
            case 7:
            case 9:
            default:
                i16 = 0;
                break;
            case 8:
                i16 = R.string.f172993gc3;
                break;
            case 10:
                i16 = R.string.f2191465m;
                break;
        }
        if (i16 == 0) {
            return null;
        }
        return BaseApplication.getContext().getResources().getString(i16);
    }
}
