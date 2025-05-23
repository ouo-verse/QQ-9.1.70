package com.tencent.util;

import android.os.Build;
import androidx.collection.ArrayMap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.em;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TokenResUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String SWITCH_893 = "new_default_ui_style_893";
    private static final String SWITCH_898 = "new_default_ui_style_898";
    private static final String SWITCH_ALLOW_M_VERSION = "default_allow_m_version";
    private static final String SWITCH_FILE_USE_QUI_TAB_BAR = "file_use_qui_tab_bar";
    private static final String SWITCH_USE_QUI_SEARCH_BAR = "search_is_use_qui_searchbar";
    private static final String SWITCH_USE_SIMPLE_BUBBLE = "use_simple_bubble";
    private static volatile Boolean sIsUseQUISearchBar;
    private static final ArrayMap<String, Boolean> sSwitchMap;
    private static final List<String> sSwitchNames;
    private static volatile Boolean sTokenSwitchFlag;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sSwitchNames = Arrays.asList(SWITCH_893, SWITCH_898, SWITCH_FILE_USE_QUI_TAB_BAR, SWITCH_USE_SIMPLE_BUBBLE);
            sSwitchMap = new ArrayMap<>();
        }
    }

    public TokenResUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean aioPlusIconNewStyle() {
        if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight()) {
            return false;
        }
        return true;
    }

    public static boolean fixAioScaleSwitchOn() {
        return true;
    }

    public static int getDefaultRes(int i3, int i16) {
        if (QQTheme.isDefaultTheme()) {
            return i16;
        }
        return i3;
    }

    private static boolean getSimpleBubbleSwitch() {
        return getSwitchStatus(SWITCH_USE_SIMPLE_BUBBLE);
    }

    public static int getStandardDefaultRes(int i3, int i16) {
        if (aioPlusIconNewStyle()) {
            return i16;
        }
        return i3;
    }

    public static boolean getSwitchStatus(String str) {
        if (sTokenSwitchFlag == null) {
            synchronized (TokenResUtils.class) {
                if (sTokenSwitchFlag == null) {
                    sTokenSwitchFlag = Boolean.TRUE;
                    updateTokenSwitch();
                }
            }
        }
        Boolean bool = sSwitchMap.get(str);
        if (bool != null && bool.booleanValue() && isVersionPermit() && !QQTheme.isNowThemeIsSuperTheme()) {
            return true;
        }
        return false;
    }

    private static int getTokenRes(String str, int i3, int i16) {
        return getSwitchStatus(str) ? i16 : i3;
    }

    public static void initThemeSpValue() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("vas_theme_init_tool_sync", true);
        em.b().a().edit().putBoolean(ThemeConstants.KEY_ENABLE_TOOL_SYNC, isSwitchOn).apply();
        QLog.d("TokenResUtils", 1, "initThemeSpValue =,toolsSync" + isSwitchOn);
    }

    private static boolean isVersionPermit() {
        if (Build.VERSION.SDK_INT > 23) {
            return true;
        }
        return ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn(SWITCH_ALLOW_M_VERSION);
    }

    private static void updateTokenSwitch() {
        IFeatureServiceProxy iFeatureServiceProxy = (IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class);
        for (String str : sSwitchNames) {
            ArrayMap<String, Boolean> arrayMap = sSwitchMap;
            if (!arrayMap.containsKey(str)) {
                arrayMap.put(str, Boolean.valueOf(iFeatureServiceProxy.isFeatureSwitchOn(str)));
            }
        }
        initThemeSpValue();
    }

    public static boolean useNewSearch() {
        return true;
    }

    public static boolean useQuiTabBar() {
        return getSwitchStatus(SWITCH_FILE_USE_QUI_TAB_BAR);
    }

    public static boolean useSimpleBubble() {
        if (getSimpleBubbleSwitch() && (QQTheme.isDefaultTheme() || QQTheme.isNowThemeDefaultNight())) {
            return true;
        }
        return false;
    }

    public static boolean useTokenIcon() {
        return !QQTheme.isNowThemeIsSuperTheme();
    }

    public static boolean useTokenRes1() {
        return true;
    }

    public static boolean useTokenRes2() {
        return true;
    }

    public static boolean useTokenRes3() {
        return getSwitchStatus(SWITCH_893);
    }

    public static boolean useTokenRes4() {
        return getSwitchStatus(SWITCH_898);
    }

    public static int getTokenRes(int i3, int i16) {
        return QQTheme.isNowThemeIsSuperTheme() ? i3 : i16;
    }

    public static int getTokenRes1(int i3, int i16) {
        return i16;
    }

    public static int getTokenRes2(int i3, int i16) {
        return i16;
    }
}
