package com.tencent.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IUIServiceProxy;
import com.tencent.mobileqq.utils.QQTheme;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QUITokenResUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_QUI_DEBUG_THEME_ID = "KEY_QUI_DEBUG_THEME_ID";

    public QUITokenResUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getCurrentDebugThemeId() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(KEY_QUI_DEBUG_THEME_ID, "0");
    }

    public static int getDrawableId(int i3, int i16) {
        if (useQUIToken()) {
            return i16;
        }
        return i3;
    }

    public static int getResId(int i3, int i16) {
        if (useQUIToken()) {
            return i16;
        }
        return i3;
    }

    public static int handleDIY(int i3, int i16) {
        if (!QQTheme.isNowThemeIsDIY()) {
            return i16;
        }
        return i3;
    }

    public static boolean isNowQUIDebugTheme() {
        if (QQUIAppSetting.isPublicVersion() || QQUIAppSetting.isGrayVersion()) {
            return false;
        }
        String currentDebugThemeId = getCurrentDebugThemeId();
        if (TextUtils.isEmpty(currentDebugThemeId) || "0".equals(currentDebugThemeId)) {
            return false;
        }
        return true;
    }

    public static void setCurrentDebugThemeId(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString(KEY_QUI_DEBUG_THEME_ID, str);
    }

    public static boolean useQUIToken() {
        return ((IUIServiceProxy) QRoute.api(IUIServiceProxy.class)).useQUIToken();
    }
}
