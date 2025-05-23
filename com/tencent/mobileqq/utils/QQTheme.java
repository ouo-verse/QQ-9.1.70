package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQTheme {
    public static final String DEFAULT_THEME_ID = "1000";
    public static final String DIY_THEME_ID = "999";
    private static final String FEATURE_THEME_ID_CACHE = "theme_id_cache_2";
    public static final int INIT_RES_ID_CACHED = 4;
    public static final int INIT_RES_ID_CLASS = 5;
    public static final int INIT_RES_ID_TRAVERSE = 3;
    public static final String INTERNAL_THEME_DIR_810 = "theme_810";
    public static final String KEY_SIMPLE_THEME_ID = "simple_theme_id";
    public static final String KEY_THEME = "theme_root";
    public static final ColorFilter NIGHTMODE_COLORFILTER;
    public static final int NIGHTMODE_MASKCOLOR;
    public static final String PREFERENCE_NAME = "theme";
    public static final List<String> SIMPLE_THEME_IDS;
    private static final String TAG = "QQTheme";
    public static final String[] THEME_DEFAULT_IDS = ThemeConstants.THEME_DEFAULT_IDS;
    public static final String THEME_ID = "themeId";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_BLUE = "3491";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_GRREEN = "3063";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_PURPLE = "3065";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_RED = "3067";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_T_RED = "3066";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_YELLOW = "3064";
    public static final String THEME_ID_DAYMODE_SIMPLE_GRAY = "2921";
    public static final String THEME_ID_DAYMODE_SIMPLE_WHITE = "2971";
    public static final String THEME_ID_NIGHTMODE = "1103";
    public static final String THEME_ID_NIGHTMODE_SIMPLE = "2920";
    public static final String THEME_KEY_CURRENT_THEME_ID = "currentThemeId_6.3.5";
    public static final String THEME_SUPER = "isSuperTheme";
    public static final String THEME_VERSION = "version";
    public static final String THEME_VIP_SPLASH = "isVipSplash";
    public static final String THEME_VIP_SPLASH_SHOW_TIME = "VipSplashShowTime";
    public static final String THEME_VIP_SPLASH_SKIP = "VipSplashSkip";
    public static final String THEME_VIP_SPLASH_SKIP_SHOW = "VipSplashSkipShow";
    public static final String THEME_VIP_SPLASH_SWITCH = "isVipSplashSwitch";
    public static String lastThemeId = "";
    private static volatile Boolean sCacheSwitchOn;
    private static String sCurThemeId;
    public static int sInitType;
    private static volatile Boolean sIsSuperTheme;

    static {
        int i3 = ThemeConstants.NIGHTMODE_MASKCOLOR;
        NIGHTMODE_MASKCOLOR = i3;
        NIGHTMODE_COLORFILTER = new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
        SIMPLE_THEME_IDS = Arrays.asList(ThemeConstants.SIMPLE_THEME_ID_LIST);
        sInitType = 3;
    }

    public static String getCurrentThemeId() {
        return getCurrentThemeId(true);
    }

    public static String getNewSimpleThemeId() {
        SharedPreferences a16 = em.b().a();
        if (a16 == null) {
            return "";
        }
        return a16.getString("simple_theme_id", null);
    }

    public static SharedPreferences getUinThemePreferences(String str) {
        if (str == null) {
            str = "noLogin";
        }
        BaseApplication context = BaseApplication.getContext();
        String str2 = str + "_theme";
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, str2, "vas_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            synchronized (QQTheme.class) {
                if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
                    QLog.i(TAG, 1, "migrateToSpAdapter");
                    QMMKV.migrateToSpAdapter(context, str2, "vas_mmkv_configurations");
                    fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
                }
            }
        }
        return fromSpAdapter;
    }

    public static String getUserCurrentThemeId(String str) {
        String string = getUinThemePreferences(str).getString("currentThemeId_6.3.5", null);
        if (TextUtils.isEmpty(string)) {
            return "1000";
        }
        return string;
    }

    public static boolean isBaseDIYTheme() {
        return isBaseDIYTheme(getCurrentThemeId());
    }

    public static boolean isColorDark(int i3) {
        if (1.0d - ((((Color.red(i3) * 0.299d) + (Color.green(i3) * 0.587d)) + (Color.blue(i3) * 0.114d)) / 255.0d) < 0.5d) {
            return false;
        }
        return true;
    }

    public static boolean isCustomTheme(String str, boolean z16) {
        return isCustomTheme(z16 ? getUserCurrentThemeId(str) : getCurrentThemeId());
    }

    public static boolean isDefaultOrDIYTheme() {
        String currentThemeId = getCurrentThemeId();
        if (!"1000".equals(currentThemeId) && !"999".equals(currentThemeId)) {
            return false;
        }
        return true;
    }

    public static boolean isDefaultTheme() {
        return "1000".equals(getCurrentThemeId());
    }

    public static boolean isLastThemeIsNight() {
        if (!"1103".equals(lastThemeId) && !"2920".equals(lastThemeId)) {
            return false;
        }
        return true;
    }

    public static boolean isNowSimpleUI() {
        return isThemeSimpleUI(getCurrentThemeId());
    }

    public static boolean isNowThemeDefaultNight() {
        return "1103".equals(getCurrentThemeId());
    }

    public static boolean isNowThemeIsDIY() {
        return isNowThemeIsDIY(getCurrentThemeId());
    }

    public static boolean isNowThemeIsNight() {
        String currentThemeId = getCurrentThemeId();
        if (!"1103".equals(currentThemeId) && !"2920".equals(currentThemeId)) {
            return false;
        }
        return true;
    }

    public static boolean isNowThemeIsNightForQzone() {
        return isNowThemeIsNight();
    }

    public static synchronized boolean isNowThemeIsSuperTheme() {
        boolean booleanValue;
        synchronized (QQTheme.class) {
            if (sIsSuperTheme == null) {
                sIsSuperTheme = Boolean.valueOf(em.b().a().getBoolean(THEME_SUPER, false));
            }
            booleanValue = sIsSuperTheme.booleanValue();
        }
        return booleanValue;
    }

    public static boolean isNowThemeSimpleNight() {
        return "2920".equals(getCurrentThemeId());
    }

    public static boolean isSimpleColrThemeStateBarUseWhite(String str) {
        if (!"3064".equals(str) && !"2971".equals(str) && !"2921".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean isSimpleWhite() {
        return "2971".equals(getCurrentThemeId());
    }

    public static boolean isThemeSimpleDayUI(String str) {
        if ("2920".equals(str)) {
            return false;
        }
        if (!"2971".equals(str) && !"2921".equals(str) && !"3064".equals(str) && !"3063".equals(str) && !"3066".equals(str) && !"3065".equals(str) && !"3067".equals(str) && !"3491".equals(str) && !"1001".equals(str) && !SIMPLE_THEME_IDS.contains(str)) {
            return false;
        }
        return true;
    }

    public static final boolean isThemeSimpleUI(String str) {
        if (!"2920".equals(str) && !isThemeSimpleDayUI(str)) {
            return false;
        }
        return true;
    }

    public static boolean isVasTheme() {
        return ("1000".equals(sCurThemeId) || "1103".equals(sCurThemeId) || isThemeSimpleUI(sCurThemeId)) ? false : true;
    }

    private static String realGetThemeId() {
        if (BaseApplication.getContext() == null) {
            return "1000";
        }
        String newSimpleThemeId = getNewSimpleThemeId();
        if (!TextUtils.isEmpty(newSimpleThemeId)) {
            return newSimpleThemeId;
        }
        String str = null;
        String string = em.b().a().getString("theme_root", null);
        if (TextUtils.isEmpty(string)) {
            return "1000";
        }
        try {
            String str2 = File.separator;
            if (string.endsWith(str2)) {
                string = string.substring(0, string.length() - 1);
            }
            if (string.contains(INTERNAL_THEME_DIR_810)) {
                String[] simpleSplitStr = simpleSplitStr(string, str2.charAt(0));
                if (simpleSplitStr.length >= 3) {
                    str = simpleSplitStr[simpleSplitStr.length - 3];
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            } else {
                String substring = string.substring(string.lastIndexOf("/") + 1);
                if (!TextUtils.isEmpty(substring)) {
                    String[] split = substring.split("_");
                    if (split.length == 2) {
                        return split[0];
                    }
                }
            }
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            System.gc();
        }
        return "1000";
    }

    public static void setCurThemeId(String str) {
        sCurThemeId = str;
    }

    public static void setNewSimpleThemeId(String str) {
        em.b().a().edit().putString("simple_theme_id", str).apply();
    }

    public static void setNightFilter(Drawable drawable) {
        if (drawable != null) {
            if (isNowThemeIsNight()) {
                drawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
            } else {
                drawable.clearColorFilter();
            }
        }
    }

    protected static String[] simpleSplitStr(String str, char c16) {
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(c16);
        simpleStringSplitter.setString(str);
        ArrayList arrayList = new ArrayList();
        Iterator it = simpleStringSplitter.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static void storeLastThemeId(String str) {
        lastThemeId = str;
    }

    public static synchronized void updateSuperTheme(boolean z16) {
        synchronized (QQTheme.class) {
            sIsSuperTheme = Boolean.valueOf(z16);
        }
    }

    public static String getCurrentThemeId(boolean z16) {
        String str = sCurThemeId;
        if (str != null && z16) {
            return str;
        }
        String realGetThemeId = realGetThemeId();
        setCurThemeId(realGetThemeId);
        return realGetThemeId;
    }

    public static boolean isBaseDIYTheme(String str) {
        return "999".equals(str);
    }

    public static boolean isNowThemeIsDIY(String str) {
        boolean z16;
        boolean equals = "999".equals(str);
        if (equals || str == null) {
            return equals;
        }
        try {
            if (Integer.parseInt(str) >= 5000) {
                if (Integer.parseInt(str) < 1000000) {
                    z16 = true;
                    return z16;
                }
            }
            z16 = false;
            return z16;
        } catch (Exception e16) {
            QLog.d(TAG, 2, "getIsDIYTheme err" + e16.getMessage());
            return equals;
        }
    }

    public static boolean isVasTheme(String str) {
        return ("1000".equals(str) || "1103".equals(str) || isThemeSimpleUI(str)) ? false : true;
    }

    public static boolean isCustomTheme(String str) {
        for (String str2 : THEME_DEFAULT_IDS) {
            if (str.equals(str2)) {
                return false;
            }
        }
        return true;
    }
}
