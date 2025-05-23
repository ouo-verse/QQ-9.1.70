package com.tencent.mobileqq.vas.theme.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.em;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.novelspecies.INovelSpaciesWidgetApi;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateBusiness;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.BusinessTintManager;
import com.tencent.mobileqq.vas.theme.ThemeMMKVPreference;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.util.VasTextUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.util.VersionUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeUtil {
    public static final int ANIMATE_BG_AIO = 3;
    public static final int ANIMATE_BG_CONVERSATION = 2;
    public static final int ANIMATE_BG_DRAWER = 1;
    public static final int ANIMATE_TAB_CALL = 13;
    public static final int ANIMATE_TAB_CONTACTS = 12;
    public static final int ANIMATE_TAB_CONVERSATION = 11;
    public static final int ANIMATE_TAB_FLASH_SHOW = 18;
    public static final int ANIMATE_TAB_GUILD = 19;
    public static final int ANIMATE_TAB_LEBA = 14;
    public static final int ANIMATE_TAB_META_DREAM = 20;
    public static final int ANIMATE_TAB_NOW = 15;
    public static final int ANIMATE_TAB_QCIRCLE = 17;
    public static final int ANIMATE_TAB_SEE = 16;
    public static final String DEFAULT_THEME_ID = "1000";
    public static final String DIY_ASSETS_EMPTY_NAME = "999_empty";
    public static final int DIY_STYLE_END = 1000000;
    public static final int DIY_STYLE_START = 5000;
    public static final String DIY_THEME_ID = "999";
    public static final String DIY_THEME_VERSION = "20000000";
    public static final String KEY_THEME_URL_AIO = "aio";
    public static final String KEY_THEME_URL_CONVERSATION = "conversation";
    public static final String KEY_THEME_URL_DRAWER = "drawer";
    public static final String LOCAL_THEME_ID = "900";
    public static ColorFilter NIGHTMODE_COLORFILTER = null;
    public static final int NIGHTMODE_MASKCOLOR;
    public static final String OLD_ENGINE_PATH = "oldEnginePath";
    public static final String PKG_SUFFIX = ".zip";
    public static final String SP_KEY_AUTH_TIME = "authTime";
    public static final String SP_KEY_CLEAN_LIST = "cleanList";
    public static final String TAG = "Theme.ThemeUtil";
    public static final String THEME_ANIMATION_AIO_VIDEO = "qq_skin_aio.mp4";
    public static final String THEME_ANIMATION_CONVERSATION_VIDEO = "qq_skin_conversation.mp4";
    public static final String THEME_ANIMATION_DRAWER_CONVERSATION_VIDEO = "qq_skin_drawer_conversation.mp4";
    public static final String THEME_ANIMATION_DRAWER_VIDEO = "qq_skin_drawer.mp4";
    public static final String THEME_DEBUG_KEY = "message.mp3";
    public static final String THEME_ERROR_ID_LIST = "listOfErrorThemeSrc";
    public static final String THEME_ID = "themeId";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_BLUE = "3491";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_GRREEN = "3063";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_PURPLE = "3065";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_RED = "3067";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_T_RED = "3066";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_YELLOW = "3064";
    public static final String THEME_ID_DAYMODE_SIMPLE_GRAY = "2921";
    public static final String THEME_ID_DAYMODE_SIMPLE_WHITE = "2971";
    public static final String THEME_ID_GOLDEN = "2101";
    public static final String THEME_ID_NIGHTMODE = "1103";
    public static final String THEME_ID_NIGHTMODE_SIMPLE = "2920";
    public static final String THEME_ID_WHITEMODE = "2105";
    public static final String THEME_ISVOICE = "isVoiceTheme";
    public static final String THEME_KEY_CURRENT_THEME_ID = "currentThemeId_6.3.5";
    public static final String THEME_KEY_CURRENT_THEME_VERSION = "currentThemeVersion";
    public static final String THEME_KEY_USER_DOWNLOAD = "userDownloadTheme";
    public static final String THEME_KEY_USER_SWITCH_TIMES = "user_switch_theme_times";
    public static final String THEME_MSSAGE_VOICE_NAME = "message.mp3";
    static final String THEME_ORIENTATION_HORIZONTAL = "horizontal";
    public static final String THEME_PATH = "themePath";
    public static final String THEME_SET_TIME_KEY = "themeSetTimeKey";
    public static final String THEME_SHARED_PREFERENCES = "userThemeSharedPreferences";
    public static final String THEME_SIMPLE_SKIN_NAME = "theme3.zip";
    public static final String THEME_SIZE = "size";
    public static final String THEME_STATUS_COMPLETE = "5";
    public static final String THEME_STATUS_DOWNLOAD_END = "3";
    public static final String THEME_STATUS_DOWNLOAD_NONE = "1";
    public static final String THEME_STATUS_DOWNLOAD_PAUSE = "4";
    public static final String THEME_STATUS_DOWNLOAD_PROGRESS = "2";
    public static final String THEME_TYPE = "themeType";
    static final String THEME_TYPE_ANIMATE = "animation";
    public static final int THEME_TYPE_FROM_SERVER = 1;
    static final String THEME_TYPE_SUPER = "super";
    public static final String THEME_URL = "url";
    public static final String THEME_VERSION = "version";
    public static final String THEME_VOICE_BASE_HOME = "voice";
    public static final String THEME_VOICE_SETTING = "theme_voice_setting_";
    private static final String TINT_A3 = "A3";
    public static final String WEEK_KEY_INDEX = "themeIndex";
    public static final String WEEK_KEY_SERIES_ID = "seriesID";
    public static final String WEEK_KEY_THEME_ARRAY = "themeArray";
    public static final String WEEK_KEY_THEME_LENGTH = "themeLength";
    public static final String WEEK_KEY_THEME_START_TIME = "startTime";
    public static int appRuntimeString;
    public static String curThemeId;
    public static boolean isNowThemeDefaultCache;
    static boolean isThemeIsAnimate;
    private static Boolean isUseTestThemeUrl;
    public static String lastThemeId;
    public static String mAnimateThemeId;
    static String mAnimateThemePath;
    static BroadcastReceiver mReceiver;
    static int mSuperThemePendant;
    static final Object refLock;
    static boolean sIsHorizontalAnimate;
    private static IThemeSwitchCallback sThemeSwitchCallback;
    static WeakReference<AppRuntime> weakApp;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ThemeInfo implements Serializable {
        public String seriesID;
        public long startTime;
        public JSONArray themeArray;
        public String themeId = "";
        public int zipVer = 0;
        public String status = "1";
        public long downsize = 0;
        public long size = 0;
        public String version = "200";
        public String downloadUrl = "";
        public boolean isVoiceTheme = false;
        public int fileNum = 0;

        public String toString() {
            return ThemeInfo.class.getName() + "{themeId=" + this.themeId + "zipVer=" + this.zipVer + ",status=" + this.status + ",downsize=" + this.downsize + ",size=" + this.size + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",isVoiceTheme=" + this.isVoiceTheme + ",fileNum=" + this.fileNum + "}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("themePath");
            String stringExtra2 = intent.getStringExtra("themeId");
            String stringExtra3 = intent.getStringExtra("bg3D");
            String stringExtra4 = intent.getStringExtra("aio");
            String stringExtra5 = intent.getStringExtra("playerSkin");
            if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2)) {
                if (!TextUtils.isEmpty(stringExtra3)) {
                    AppRuntime appRuntime = ThemeUtil.weakApp.get();
                    if (appRuntime != null) {
                        ThemeUtil.validLocalBg3D(context, appRuntime, appRuntime.getAccount(), stringExtra3);
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(stringExtra4)) {
                    ThemeUtil.previewAIOTheme(context, stringExtra4);
                    return;
                } else if (!TextUtils.isEmpty(stringExtra5)) {
                    ThemeUtil.previewPlayerSkin(context, stringExtra5);
                    return;
                } else {
                    ThemeUtil.themeFont(intent, "themeFont");
                    return;
                }
            }
            ThemeUtil.validLocalTheme(context, stringExtra, stringExtra2);
        }
    }

    static {
        int i3 = ThemeConstants.NIGHTMODE_MASKCOLOR;
        NIGHTMODE_MASKCOLOR = i3;
        NIGHTMODE_COLORFILTER = new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
        curThemeId = getCurrentThemeId();
        lastThemeId = "";
        isUseTestThemeUrl = null;
        refLock = new Object();
        appRuntimeString = 0;
        mReceiver = new a();
        sThemeSwitchCallback = new IThemeSwitchCallback() { // from class: com.tencent.mobileqq.vas.theme.api.ThemeUtil.2
            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public boolean beforeSwitch(@Nullable ThemeLocator themeLocator) {
                return false;
            }

            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public boolean postSwitch(int i16) {
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.api.ThemeUtil.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ThemeUtil.isNowThemeIsAnimate();
                        ((IThemeHandler) QRoute.api(IThemeHandler.class)).sendThemeAuth();
                    }
                }, 1000L);
                return false;
            }

            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public void beginSwitch() {
            }

            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public void onProgress(long j3, long j16) {
            }
        };
        isNowThemeDefaultCache = true;
    }

    public static boolean currentIsMergeVideoTheme() {
        return isMergeVideoTheme(getThemeId());
    }

    public static boolean currentThemeTransparentTitleBar() {
        return isNowThemeIsSuperTheme();
    }

    public static Drawable drawableTint(Context context, int i3, int i16) {
        if (!SkinEngine.getInstances().checkResExist(i3)) {
            return maskDrawableByColor(context.getResources().getDrawable(i3), i16);
        }
        return context.getResources().getDrawable(i3);
    }

    private static boolean enableNativeThemeVideoPlayer() {
        ToggleProxy toggleProxy = VasToggle.THEME_VIEDO_PLAYER_ENABLE;
        if (toggleProxy.isEnable(true) && Build.VERSION.SDK_INT >= toggleProxy.getInt(26)) {
            return true;
        }
        return false;
    }

    public static String getAnimatePathByTag(int i3) {
        String str = null;
        if (TextUtils.isEmpty(mAnimateThemePath)) {
            Bundle currentThemeInfo = getCurrentThemeInfo();
            String string = currentThemeInfo.getString("themePath");
            if (TextUtils.isEmpty(string)) {
                QLog.e(TAG, 2, "getAnimatePathByTag err ApngImage path = " + ((String) null) + " id = " + currentThemeInfo.getString("themeId"));
                return null;
            }
            String str2 = File.separator;
            if (string.endsWith(str2)) {
                mAnimateThemePath = string;
            } else {
                mAnimateThemePath = string + str2;
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    switch (i3) {
                        case 11:
                            str = mAnimateThemePath + "raw/qvip_tab_icon_conversation_animate.png";
                            break;
                        case 12:
                            str = mAnimateThemePath + "raw/qvip_tab_icon_contact_animate.png";
                            break;
                        case 13:
                            str = mAnimateThemePath + "raw/qvip_tab_icon_call_animate.png";
                            break;
                        case 14:
                            str = mAnimateThemePath + "raw/qvip_tab_icon_plugin_animate.png";
                            break;
                        case 15:
                            str = mAnimateThemePath + "raw/qvip_tab_icon_now_animate.png";
                            break;
                        case 16:
                            str = mAnimateThemePath + "raw/qvip_tab_icon_see_animate.png";
                            break;
                        case 17:
                            str = mAnimateThemePath + "raw/qvip_tab_icon_qcircle_animate.png";
                            break;
                    }
                } else {
                    str = mAnimateThemePath + "raw/qvip_chatbackground_animate.png";
                }
            } else {
                str = mAnimateThemePath + "raw/qvip_conversation_bg_animate.png";
            }
        } else {
            str = mAnimateThemePath + "raw/qvip_drawer_bg_animate.png";
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getAnimatePathByTag ApngImage path = " + str);
        }
        return str;
    }

    public static Drawable getBgBottomStandardColorDrawable(Context context) {
        if (context != null) {
            if (QQTheme.isVasTheme()) {
                return context.getDrawable(R.drawable.bg_texture);
            }
            return new ColorDrawable(context.getColor(R.color.qui_common_bg_bottom_standard));
        }
        return null;
    }

    public static String getConfigType(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            String str3 = File.separator;
            if (str.endsWith(str3)) {
                str2 = str + "config.json";
            } else {
                str2 = str + str3 + "config.json";
            }
            File file = new File(str2);
            if (file.exists()) {
                try {
                    String readFileToStringEx = FileUtils.readFileToStringEx(file, -1);
                    if (readFileToStringEx != null && readFileToStringEx.length() >= 2) {
                        String optString = new JSONObject(readFileToStringEx).optString("type");
                        if (QLog.isColorLevel()) {
                            QLog.w(TAG, 2, "getConfigType theme Type:" + optString);
                        }
                        return optString;
                    }
                    return "";
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "getConfigType err , msg:" + th5.getMessage());
                }
            }
        }
        return "";
    }

    public static AppRuntime getCreateAppRuntime() {
        AppRuntime appRuntime;
        WeakReference<AppRuntime> weakReference = weakApp;
        if (weakReference != null && (appRuntime = weakReference.get()) != null) {
            return appRuntime;
        }
        return VasUtil.getApp();
    }

    private static Bundle getCurrentSuperThemeInfo(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("themePath", str);
        return bundle;
    }

    public static String getCurrentThemeId() {
        String string = getCurrentThemeInfo().getString("themeId");
        if ("1001".equals(string)) {
            string = QQTheme.getCurrentThemeId();
        }
        if (TextUtils.isEmpty(string)) {
            string = "1000";
        }
        curThemeId = string;
        return string;
    }

    public static Bundle getCurrentThemeInfo() {
        String str;
        Bundle bundle = new Bundle();
        try {
            bundle.putString("themeId", "1000");
            bundle.putString("version", "0");
            String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
            bundle.putString("themePath", skinRootPath);
            if (skinRootPath != null && skinRootPath.length() > 0) {
                String str2 = File.separator;
                if (skinRootPath.endsWith(str2)) {
                    skinRootPath = skinRootPath.substring(0, skinRootPath.length() - 1);
                }
                if (skinRootPath.contains(QQTheme.INTERNAL_THEME_DIR_810)) {
                    String[] split = skinRootPath.split(str2);
                    if (split.length >= 3) {
                        str = split[split.length - 3];
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str) && VasTextUtil.isNumeral(str)) {
                        bundle.putString("themeId", str);
                        bundle.putString("version", "20000000");
                        if (isNewSimpleTheme(str)) {
                            resetRealThemeId(bundle);
                        }
                    }
                } else {
                    String substring = skinRootPath.substring(skinRootPath.lastIndexOf("/") + 1);
                    if (substring != null) {
                        String[] split2 = substring.split("_");
                        if (split2.length == 2) {
                            bundle.putString("themeId", split2[0]);
                            bundle.putString("version", split2[1]);
                            if (isNewSimpleTheme(split2[0])) {
                                resetRealThemeId(bundle);
                            }
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getCurrentThemeInfo, exception:", e16);
        }
        return bundle;
    }

    public static int getErrorThemeId(Context context, String str) {
        String string = getThemePreferences(context).getString("listOfErrorThemeSrc", "");
        if (string != null && string.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (!jSONObject.has(str)) {
                    return 0;
                }
                return jSONObject.getInt(str);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getErrorThemeId error:" + e16.getMessage());
                }
            }
        }
        return 0;
    }

    public static int getFileNumInFile(File file) {
        int i3;
        int i16 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        return 1;
                    }
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        int i17 = 0;
                        for (int length = listFiles.length - 1; length >= 0; length--) {
                            try {
                                File file2 = listFiles[length];
                                if (file2 != null) {
                                    if (file2.isDirectory()) {
                                        String[] list = listFiles[length].list();
                                        if (list != null) {
                                            i3 = list.length;
                                        } else {
                                            i3 = 0;
                                        }
                                        i17 += i3;
                                    } else {
                                        i17++;
                                    }
                                }
                            } catch (Exception e16) {
                                e = e16;
                                i16 = i17;
                                if (QLog.isColorLevel()) {
                                    QLog.e(TAG, 2, "ThemeJsHandler getFileNumInFile, error:" + e.getMessage());
                                }
                                return i16;
                            } catch (OutOfMemoryError e17) {
                                e = e17;
                                i16 = i17;
                                if (QLog.isColorLevel()) {
                                    QLog.e(TAG, 2, "ThemeJsHandler getFileNumInFile, OOM:" + e.getMessage());
                                }
                                return i16;
                            }
                        }
                        return i17;
                    }
                    return 0;
                }
            } catch (Exception e18) {
                e = e18;
            } catch (OutOfMemoryError e19) {
                e = e19;
            }
        }
        return 0;
    }

    public static String getIDFromSCID(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getIDFromSCID error null: zipName=" + str);
            return null;
        }
        String[] split = str.split("\\.");
        int i3 = 2;
        if (ThemeUpdateBusiness.isSupportNewScid() && str.startsWith(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX_VIDEO)) {
            str2 = split[2];
        }
        if (TextUtils.isEmpty(str2)) {
            if (str.startsWith(ThemeUpdateCallback.SCID_THEME_PREFIX) && split.length > 3) {
                str2 = split[2];
            } else if (str.startsWith(ThemeUpdateCallback.SCID_THEME_PREFIX) && split.length > 1) {
                str2 = split[1];
                if (!QLog.isColorLevel() || TextUtils.isEmpty(str2)) {
                    QLog.d(TAG, 1, "getIDFromSCID ok, zipName = " + str + ", themeid=" + str2 + ", idType=" + i3);
                }
                return str2;
            }
        }
        i3 = 0;
        if (!QLog.isColorLevel()) {
        }
        QLog.d(TAG, 1, "getIDFromSCID ok, zipName = " + str + ", themeid=" + str2 + ", idType=" + i3);
        return str2;
    }

    public static boolean getIsDIYTheme(String str) {
        boolean z16;
        if (str == null) {
            str = getCurrentThemeId();
        }
        boolean equals = "999".equals(str);
        if (!equals && str != null) {
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
        return equals;
    }

    public static synchronized int getSuperThemePendant() {
        synchronized (ThemeUtil.class) {
            if (!isNowThemeIsSuperTheme()) {
                return 0;
            }
            return mSuperThemePendant;
        }
    }

    public static String getThemeConfigID(String str) {
        return ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + str;
    }

    public static String getThemeDensity(Context context) {
        if (context == null) {
            return "xh";
        }
        int i3 = context.getResources().getDisplayMetrics().densityDpi;
        if (i3 <= 160) {
            return QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO;
        }
        if (i3 <= 160 || i3 >= 320) {
            return "xh";
        }
        return h.F;
    }

    public static int getThemeDownloadNum(Context context) {
        String string = getThemePreferences(context).getString("userDownloadTheme", "");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getThemeDownloadNum, userThemeStr = " + string);
        }
        int i3 = 0;
        if (string != null) {
            try {
                if (string.length() > 0) {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String string2 = jSONObject.getJSONObject(String.valueOf(keys.next())).getString("status");
                        if (string2.equals("5") || string2.equals("3")) {
                            i3++;
                        }
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getThemeDownloadNum error:" + e16.getMessage());
                }
            }
        }
        return i3;
    }

    public static String getThemeId() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean isNowThemeIsNight = isNowThemeIsNight(peekAppRuntime, true, null);
        String string = ThemeSwitchUtil.getPreviousThemeIdVersion(peekAppRuntime).getString("themeID");
        if (TextUtils.isEmpty(string)) {
            string = "1000";
        }
        if (isNowThemeIsNight) {
            return "1103";
        }
        return string;
    }

    public static ThemeInfo getThemeInfo(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            String string = getThemePreferences(context).getString(str, "");
            if (TextUtils.isEmpty(string)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getThemeInfoFromSp null, themeId:" + str);
                }
                return null;
            }
            String[] split = string.split(",");
            if (split.length < 5) {
                QLog.e(TAG, 1, "getThemeInfoFromSp error length: userThemeStr=" + string);
                return null;
            }
            ThemeInfo themeInfo = new ThemeInfo();
            try {
                themeInfo.themeId = str;
                if (!TextUtils.isEmpty(split[0])) {
                    themeInfo.zipVer = Integer.parseInt(split[0]);
                }
                if (!TextUtils.isEmpty(split[1])) {
                    themeInfo.version = split[1];
                }
                if (!TextUtils.isEmpty(split[2])) {
                    themeInfo.fileNum = Integer.parseInt(split[2]);
                }
                themeInfo.isVoiceTheme = "1".equals(split[3]);
                if (!TextUtils.isEmpty(split[4])) {
                    themeInfo.size = Long.parseLong(split[4]);
                }
                if (!TextUtils.isEmpty(split[5])) {
                    themeInfo.downsize = Long.parseLong(split[5]);
                }
                if (!TextUtils.isEmpty(split[6])) {
                    themeInfo.status = split[6];
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getThemeInfoFromSp error: userThemeStr=" + string + ", msg:" + e16.getMessage());
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getThemeInfoFromSp end, themeId:" + str + ", userThemeStr=" + string);
            }
            return themeInfo;
        }
        QLog.e(TAG, 1, "getThemeInfoFromSp error, themeId:" + str + ", context:" + context);
        return null;
    }

    public static SharedPreferences getThemePreferences(Context context) {
        if (context == null) {
            context = getCreateAppRuntime().getApplicationContext();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getThemePreferences null == context");
            }
        }
        return context.getSharedPreferences("userThemeSharedPreferences", 4);
    }

    public static int getThemeSwitchTimes(AppRuntime appRuntime) {
        int i3 = getUinThemePreferences(appRuntime).getInt("user_switch_theme_times", -1);
        if (-1 == i3) {
            i3 = appRuntime.getPreferences().getInt("user_switch_theme_times", 0);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getThemeSwitchTimes userSwitchThemeTimes=" + i3);
        }
        return i3;
    }

    public static String getThemeVideoFilePath(String str) {
        String string = em.b().a().getString("theme_root", null);
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (string != null) {
            String str2 = File.separator;
            if (!string.endsWith(str2)) {
                string = string + str2;
            }
        }
        return string + "raw/" + str;
    }

    public static String getThemeVoiceRootPath() {
        String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
        if (!TextUtils.isEmpty(skinRootPath)) {
            File file = new File(skinRootPath + File.separatorChar + "voice");
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static SharedPreferences getUinThemePreferences(AppRuntime appRuntime) {
        if (appRuntime == null) {
            appRuntime = getCreateAppRuntime();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUinThemePreferences null == application");
            }
        }
        return QQTheme.getUinThemePreferences(appRuntime.getAccount());
    }

    public static String getUserCurrentThemeId(AppRuntime appRuntime) {
        String str = "1000";
        if (appRuntime == null && (appRuntime = getCreateAppRuntime()) == null) {
            QLog.e(TAG, 1, "getUserCurrentThemeId Error,application == null");
            return "1000";
        }
        String string = getUinThemePreferences(appRuntime).getString("currentThemeId_6.3.5", null);
        if (appRuntime.getAccount() == null) {
            QLog.e(TAG, 1, "getUserCurrentThemeId Error, uin=noLogin");
        }
        if (TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUserCurrentThemeVersion,null == currentThemeId, currentThemeId= ThemeUtil.DEFAULT_THEME_ID");
            }
        } else {
            str = string;
        }
        curThemeId = str;
        return str;
    }

    public static String getUserCurrentThemeVersion(AppRuntime appRuntime) {
        String str = "0";
        if (appRuntime == null) {
            appRuntime = getCreateAppRuntime();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUserCurrentThemeVersion,application == null");
            }
            if (appRuntime == null) {
                QLog.e(TAG, 1, "getUserCurrentThemeVersion Error,application == null");
                return "0";
            }
        }
        SharedPreferences uinThemePreferences = getUinThemePreferences(appRuntime);
        String account = appRuntime.getAccount();
        if (account == null) {
            QLog.e(TAG, 1, "getUserCurrentThemeVersion Error, uin=noLogin");
            account = "noLogin";
        }
        String string = uinThemePreferences.getString("currentThemeVersion", null);
        if (TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUserCurrentThemeVersion,currentThemeVersion == null, currentThemeVersion=0");
            }
        } else {
            str = string;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getUserCurrentThemeVersion,uin=" + VasTextUtil.hideUinInShowString(account, 2) + ",currentThemeVersion=" + str + ", oldTime=" + uinThemePreferences.getLong("themeSetTimeKey", 0L));
        }
        return str;
    }

    public static String getUserThemeIDForReset(AppRuntime appRuntime) {
        String weekLoopTheme;
        SharedPreferences uinThemePreferences = getUinThemePreferences(appRuntime);
        String str = "1000";
        if (uinThemePreferences.contains("currentThemeId_6.3.5")) {
            String string = uinThemePreferences.getString("currentThemeId_6.3.5", "1000");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initTheme current qq already set theme:" + string);
            }
            if ("1103".equals(string)) {
                weekLoopTheme = null;
            } else {
                weekLoopTheme = getWeekLoopTheme(appRuntime);
            }
            if (!TextUtils.isEmpty(weekLoopTheme)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "initTheme current qq already set weekThemeId:" + weekLoopTheme);
                }
                return weekLoopTheme;
            }
            return string;
        }
        QLog.d(TAG, 1, "getUserThemeIDForReset sp.THEME_KEY_CURRENT_THEME_ID == null");
        ArrayList arrayList = new ArrayList();
        Map<String, ?> all = uinThemePreferences.getAll();
        if (all == null) {
            all = new HashMap<>();
        }
        Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.startsWith("currentThemeId_")) {
                arrayList.add(key);
            }
        }
        if (arrayList.isEmpty()) {
            QLog.d(TAG, 1, "initTheme list.isEmpty()");
            setCurrentThemeIdVersion(appRuntime, "1000", "0");
            return "1000";
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "set previous theme!");
        }
        Collections.sort(arrayList);
        String str2 = (String) arrayList.get(arrayList.size() - 1);
        String string2 = uinThemePreferences.getString("currentThemeVersion", "0");
        if (VersionUtil.isLaterVersion("6.0", AppSetting.f99551k)) {
            String str3 = (String) all.get(str2);
            if (str3 == null) {
                str3 = "";
            }
            if (!"1000".equals(str3) && (appRuntime instanceof AppRuntime)) {
                ((IThemeHandler) QRoute.api(IThemeHandler.class)).sendThemeVersionCheck(str3, str2, false);
            }
            str = str3;
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "old version or app == null.");
        }
        setCurrentThemeIdVersion(appRuntime, str, string2);
        return str;
    }

    public static String getWeekLoopTheme(AppRuntime appRuntime) {
        int i3;
        String str;
        String str2;
        SharedPreferences uinThemePreferences = getUinThemePreferences(appRuntime);
        String str3 = null;
        try {
            String string = uinThemePreferences.getString("themeArray", null);
            if (!TextUtils.isEmpty(uinThemePreferences.getString("seriesID", null)) && !TextUtils.isEmpty(string)) {
                int i16 = uinThemePreferences.getInt("themeLength", 7);
                int i17 = 0;
                int i18 = uinThemePreferences.getInt("themeIndex", 0);
                long j3 = uinThemePreferences.getLong("startTime", -28800L);
                int rawOffset = TimeZone.getTimeZone(DateUtil.TIME_ZONE_8).getRawOffset();
                if (System.currentTimeMillis() > j3) {
                    long j16 = rawOffset;
                    i3 = (((int) Math.ceil((System.currentTimeMillis() + j16) / 86400000)) - ((int) Math.ceil((j3 + j16) / 86400000))) % i16;
                } else {
                    i3 = i18;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getWeekLoopTheme nIndex:" + i18 + ", tIndex:" + i3);
                }
                if (i18 != i3) {
                    i18 = i3;
                }
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                if (i18 < jSONArray.length()) {
                    i17 = i18;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i17);
                if (jSONObject != null) {
                    str = jSONObject.getString("id");
                } else {
                    str = null;
                }
                if (jSONObject != null) {
                    str2 = jSONObject.getString("version");
                } else {
                    str2 = null;
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return null;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getWeekLoopTheme ok: sThemeId = " + str);
                    }
                    setCurrentThemeIdVersion(appRuntime, str, str2);
                    SharedPreferences.Editor edit = uinThemePreferences.edit();
                    edit.putInt("themeIndex", i17);
                    edit.commit();
                    return str;
                } catch (Exception e16) {
                    e = e16;
                    str3 = str;
                    QLog.e(TAG, 1, "getWeekLoopTheme error:" + e.getMessage());
                    return str3;
                }
            }
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "getWeekLoopTheme seriesID || themeArray = null");
            return null;
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static void initTheme(AppRuntime appRuntime) {
        synchronized (refLock) {
            if (appRuntime == null) {
                WeakReference<AppRuntime> weakReference = weakApp;
                if (weakReference != null) {
                    appRuntime = weakReference.get();
                } else {
                    appRuntime = null;
                }
                if (appRuntime == null) {
                    weakApp = null;
                    QLog.e(TAG, 1, "initTheme null app");
                    return;
                } else if (!appRuntime.isLogin()) {
                    weakApp = null;
                    QLog.e(TAG, 1, "initTheme logout app");
                    return;
                }
            } else {
                weakApp = new WeakReference<>(appRuntime);
            }
            if (!appRuntime.isLogin()) {
                QLog.e(TAG, 1, "initTheme logout appInterface");
                return;
            }
            if (SkinEngine.getInstances().mResources == null) {
                QLog.e(TAG, 1, "initTheme: engine is not ready");
                return;
            }
            if (getCreateAppRuntime() != null && appRuntimeString != getCreateAppRuntime().hashCode()) {
                appRuntimeString = getCreateAppRuntime().hashCode();
                getCreateAppRuntime().getApplicationContext();
                Bundle currentThemeInfo = getCurrentThemeInfo();
                String string = currentThemeInfo.getString("themeId");
                String userThemeIDForReset = getUserThemeIDForReset(appRuntime);
                QLog.i(TAG, 1, "initTheme,userThemeId=" + userThemeIDForReset + ",engine currentThemeId=" + string + ", enginePath=" + currentThemeInfo.getString("themePath"));
                ((IThemeSwitcher) QRoute.api(IThemeSwitcher.class)).startSwitch(userThemeIDForReset, ThemeReporter.FROM_INIT_THEME, sThemeSwitchCallback);
                return;
            }
            QLog.e(TAG, 1, "initTheme: had send auth");
        }
    }

    public static boolean isAnimateTheme(String str) {
        return "animation".equals(getConfigType(str));
    }

    public static boolean isDartStatusBar(Context context, int i3) {
        if (isNowThemeIsNight(null, false, null)) {
            return false;
        }
        float[] fArr = new float[3];
        Color.colorToHSV(context.getResources().getColor(i3), fArr);
        if (fArr[2] >= 0.5f) {
            return false;
        }
        return true;
    }

    public static boolean isDefaultNightTheme() {
        return "1103".equals(getUserCurrentThemeId(null));
    }

    private static boolean isDefaultOrDIY(String str) {
        if (!TextUtils.isEmpty(str) && !"1000".equals(str) && !"999".equals(str)) {
            try {
                if (Integer.parseInt(str) >= 5000 && Integer.parseInt(str) < 1000000) {
                    mAnimateThemeId = str;
                    return true;
                }
                return false;
            } catch (Exception e16) {
                QLog.d(TAG, 2, "isNowThemeIsAnimate err" + e16.getMessage());
                return false;
            }
        }
        mAnimateThemeId = str;
        return true;
    }

    @Deprecated
    public static boolean isDefaultOrDIYTheme() {
        String userCurrentThemeId = getUserCurrentThemeId(null);
        return "1000".equals(userCurrentThemeId) || "999".equals(userCurrentThemeId);
    }

    public static boolean isDefaultTheme() {
        return "1000".equals(getUserCurrentThemeId(null));
    }

    public static boolean isFixTheme(String str) {
        if (!"1103".equals(str) && !QQTheme.isThemeSimpleUI(str)) {
            return false;
        }
        return true;
    }

    public static boolean isGoldenTheme() {
        return "2101".equals(getUserCurrentThemeId(null));
    }

    public static boolean isHorizontalAnimate() {
        return sIsHorizontalAnimate;
    }

    public static boolean isIOSTheme(String str) {
        return str.startsWith("theme.ios");
    }

    @Deprecated
    public static boolean isInNightMode(AppRuntime appRuntime) {
        String userCurrentThemeId = getUserCurrentThemeId(appRuntime);
        if (!"1103".equals(userCurrentThemeId) && !"2920".equals(userCurrentThemeId)) {
            return false;
        }
        return true;
    }

    public static boolean isMergeVideoTheme(String str) {
        if (!ThemeUpdateBusiness.isSupportNewScid() || TextUtils.isEmpty(str) || isDefaultOrDIY(str)) {
            return false;
        }
        ThemeLocator themeLocator = new ThemeLocator();
        themeLocator.setThemeId(str);
        themeLocator.init(BaseApplication.context, ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX_VIDEO + str, "");
        return new File(themeLocator.getZipPath()).exists();
    }

    public static boolean isNeedUpdataById(String str) {
        boolean z16 = !TextUtils.isEmpty(str);
        if (z16) {
            if (!"1000".equals(str) && !"999".equals(str)) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (!z16 || QLog.isColorLevel()) {
            QLog.d(TAG, 1, "isNeedUpdataById error null: themeId=" + str + ", isUpdate=" + z16);
        }
        return z16;
    }

    protected static boolean isNewSimpleTheme(String str) {
        return "1001".equals(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isNowAnimationThemeFormJson(Bundle bundle) {
        boolean z16;
        String str;
        boolean z17;
        String readFileToStringEx;
        String string = bundle.getString("themePath");
        if (!TextUtils.isEmpty(string)) {
            String str2 = File.separator;
            if (string.endsWith(str2)) {
                str = string + "config.json";
            } else {
                String str3 = string + str2;
                str = string + str2 + "config.json";
                string = str3;
            }
            File file = new File(str);
            if (file.exists()) {
                try {
                    readFileToStringEx = FileUtils.readFileToStringEx(file, -1);
                } catch (Throwable th5) {
                    th = th5;
                    z17 = false;
                }
                if (readFileToStringEx != null && readFileToStringEx.length() >= 2) {
                    JSONObject jSONObject = new JSONObject(readFileToStringEx);
                    String optString = jSONObject.optString("type");
                    sIsHorizontalAnimate = "horizontal".equals(jSONObject.optString("orientation"));
                    if (QLog.isColorLevel()) {
                        QLog.w(TAG, 2, "isNowThemeIsAnimate theme Type:" + optString);
                    }
                    z16 = "animation".equals(optString);
                    try {
                        updateSuperTheme(jSONObject);
                    } catch (Throwable th6) {
                        z17 = z16;
                        th = th6;
                        resetSuperTheme();
                        QLog.e(TAG, 1, "isNowThemeIsAnimate err , msg:" + th.getMessage());
                        z16 = z17;
                        if (z16) {
                        }
                        return false;
                    }
                    if (z16) {
                        isThemeIsAnimate = true;
                        mAnimateThemePath = string;
                    }
                    return false;
                }
                resetSuperTheme();
                return true;
            }
            resetSuperTheme();
        } else {
            resetSuperTheme();
            string = null;
        }
        z16 = false;
        if (z16) {
        }
        return false;
    }

    public static synchronized boolean isNowThemeIsAnimate() {
        synchronized (ThemeUtil.class) {
            Bundle currentThemeInfo = getCurrentThemeInfo();
            String string = currentThemeInfo.getString("themeId");
            if (string != null && !string.equals(mAnimateThemeId)) {
                mAnimateThemePath = null;
                boolean z16 = false;
                isThemeIsAnimate = false;
                sIsHorizontalAnimate = false;
                if (!isDefaultOrDIY(string) && QQTheme.isVasTheme()) {
                    if (isNowAnimationThemeFormJson(currentThemeInfo)) {
                        return false;
                    }
                    if (isThemeIsAnimate) {
                        Bundle bundle = new Bundle();
                        if (VasUtil.getService().getThemeSwitchManager().getIsEnableAnimate(bundle)) {
                            if (bundle.getBoolean(ThemeConstants.BUNDLE_KEY_DYNAMIC_SWITCH, true) && bundle.getBoolean(ThemeConstants.BUNDLE_KEY_DYNAMIC_ENABLE, true)) {
                                z16 = true;
                            }
                            isThemeIsAnimate = z16;
                        }
                    }
                    mAnimateThemeId = string;
                    return isThemeIsAnimate;
                }
                resetSuperTheme();
                return false;
            }
            return isThemeIsAnimate;
        }
    }

    public static boolean isNowThemeIsDIY() {
        boolean z16;
        String currentThemeId = getCurrentThemeId();
        boolean equals = "999".equals(currentThemeId);
        if (!equals && currentThemeId != null) {
            try {
                if (Integer.parseInt(currentThemeId) >= 5000) {
                    if (Integer.parseInt(currentThemeId) < 1000000) {
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
        return equals;
    }

    public static boolean isNowThemeIsDefault(AppRuntime appRuntime, boolean z16, String str) {
        if (TextUtils.isEmpty(str)) {
            if (z16) {
                str = getUserCurrentThemeId(appRuntime);
            } else {
                str = getCurrentThemeId();
            }
        }
        return "1000".equals(str);
    }

    public static boolean isNowThemeIsDefaultCache(AppRuntime appRuntime, boolean z16) {
        if (z16) {
            isNowThemeDefaultCache = isNowThemeIsDefault(appRuntime, false, null);
        }
        return isNowThemeDefaultCache;
    }

    public static boolean isNowThemeIsNight(AppRuntime appRuntime, boolean z16, String str) {
        if (TextUtils.isEmpty(str)) {
            if (z16) {
                str = getUserCurrentThemeId(appRuntime);
            } else {
                str = getCurrentThemeId();
            }
        }
        if (!"1103".equals(str) && !"2920".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean isNowThemeIsSimple(AppRuntime appRuntime, boolean z16, String str) {
        if (TextUtils.isEmpty(str)) {
            if (z16) {
                str = getUserCurrentThemeId(appRuntime);
            } else {
                str = getCurrentThemeId();
            }
        }
        return ((ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class)).isThemeSimpleUI(str);
    }

    public static synchronized boolean isNowThemeIsSuperTheme() {
        boolean isNowThemeIsSuperTheme;
        synchronized (ThemeUtil.class) {
            isNowThemeIsSuperTheme = QQTheme.isNowThemeIsSuperTheme();
        }
        return isNowThemeIsSuperTheme;
    }

    private static boolean isNowThemeIsVideoTheme() {
        boolean z16 = false;
        if (TextUtils.isEmpty(mAnimateThemePath)) {
            String string = getCurrentThemeInfo().getString("themePath");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            String str = File.separator;
            if (string.endsWith(str)) {
                mAnimateThemePath = string;
            } else {
                mAnimateThemePath = string + str;
            }
        }
        if (!TextUtils.isEmpty(mAnimateThemePath)) {
            try {
                z16 = new File(mAnimateThemePath + "raw/qq_skin_conversation.mp4").exists();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        QLog.d(TAG, 2, "isNowThemeIsVideoTheme=" + z16);
        return z16;
    }

    public static boolean isSimpleAndOtherThemeSwitch() {
        if ((((ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class)).isThemeSimpleUI(lastThemeId) || ((ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class)).isThemeSimpleUI(curThemeId)) && !curThemeId.equals(lastThemeId)) {
            return true;
        }
        return false;
    }

    public static boolean isSimpleDayTheme(boolean z16) {
        String currentThemeId;
        if (z16) {
            currentThemeId = getUserCurrentThemeId(null);
        } else {
            currentThemeId = getCurrentThemeId();
        }
        return ((ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class)).isThemeSimpleDayUI(currentThemeId);
    }

    public static boolean isSkinEngineInitial() {
        if (SkinEngine.getInstances().mResources == null) {
            return false;
        }
        String userCurrentThemeId = getUserCurrentThemeId(getCreateAppRuntime());
        String currentThemeId = getCurrentThemeId();
        if ((TextUtils.isEmpty(SkinEngine.getInstances().getSkinRootPath()) || !currentThemeId.equals(userCurrentThemeId)) && !"1000".equals(userCurrentThemeId)) {
            return false;
        }
        return true;
    }

    public static boolean isSuperTheme(String str) {
        return THEME_TYPE_SUPER.equals(getConfigType(str));
    }

    public static boolean isVasDarkTheme() {
        Integer plateColor;
        float luminance;
        if (QQTheme.isVasTheme() && (plateColor = BusinessTintManager.instance().getPlateColor(TINT_A3)) != null && Build.VERSION.SDK_INT >= 24) {
            luminance = Color.luminance(plateColor.intValue());
            QLog.d(TAG, 2, "current A3: " + plateColor + " textLuminance: " + luminance);
            if (luminance <= 0.5f) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static Drawable maskDrawableByColor(Drawable drawable, int i3) {
        Drawable mutate;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
        } else {
            mutate = drawable.getConstantState().newDrawable().mutate();
        }
        mutate.setColorFilter(new LightingColorFilter(0, i3));
        return mutate;
    }

    public static boolean needRefreshWhenInit() {
        if (Build.VERSION.SDK_INT >= 33 && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.BRAND)) {
            return true;
        }
        return false;
    }

    public static synchronized void parseSuperTheme(String str) {
        synchronized (ThemeUtil.class) {
            if (TextUtils.isEmpty(str)) {
                QLog.d(TAG, 1, "parseSuperTheme no path");
                resetSuperTheme();
                return;
            }
            QLog.d(TAG, 1, "parseSuperTheme " + str);
            if (isNowAnimationThemeFormJson(getCurrentSuperThemeInfo(str))) {
                QLog.e(TAG, 2, "parseSuperTheme json error");
            }
        }
    }

    public static Boolean removeThemeInfo(Context context, String str) {
        if (context != null && str != null) {
            boolean commit = getThemePreferences(context).edit().remove(str).commit();
            if (!commit || QLog.isColorLevel()) {
                QLog.d(TAG, 2, "removeThemeInfo sp comit ret=" + commit + ", themeId=" + str);
            }
            return Boolean.valueOf(commit);
        }
        QLog.e(TAG, 1, "removeThemeInfo error, themeId:" + str + ", context:" + context);
        return Boolean.FALSE;
    }

    public static void reportThemeInit() {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        try {
            ((INovelSpaciesWidgetApi) QRoute.api(INovelSpaciesWidgetApi.class)).fetchAndCacheWidgetData();
            HashMap<String, Long> hashMap = SkinEngine.getInstances().sStatisticMap;
            if (hashMap != null && !hashMap.isEmpty()) {
                int i3 = QQTheme.sInitType;
                int parseInt = Integer.parseInt(QQTheme.getCurrentThemeId());
                Long l3 = hashMap.get("init_total");
                if (l3 != null && l3.longValue() > 0) {
                    VasCommonReporter.getThemeEngine().setNum1(0L).setNum2(parseInt).setNum3(i3).setValue1(String.valueOf(l3)).setValue2(String.valueOf(hashMap.get("init_hook"))).setValue3(String.valueOf(hashMap.get("init_drawable"))).setValue4(String.valueOf(hashMap.get("init_color"))).setValue5(String.valueOf(hashMap.get("init_config"))).report();
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "reportThemeInit error", e16);
        }
    }

    private static void resetRealThemeId(Bundle bundle) {
        bundle.putString("themeId", QQTheme.getNewSimpleThemeId());
    }

    private static void resetSuperTheme() {
        try {
            QQTheme.updateSuperTheme(false);
            mSuperThemePendant = 0;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.api.ThemeUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    new ThemeMMKVPreference().getPreference().edit().putBoolean(QQTheme.THEME_SUPER, false).apply();
                }
            }, 16, null, false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void resetThemeSwitchTimes(AppRuntime appRuntime) {
        getUinThemePreferences(appRuntime).edit().putInt("user_switch_theme_times", 0).commit();
        SharedPreferences.Editor edit = appRuntime.getPreferences().edit();
        edit.putInt("user_switch_theme_times", 0);
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "resetThemeSwitchTimes");
        }
    }

    public static void setColorFilterIfNeed(ImageView imageView) {
        setColorFilterIfNeed(imageView, QQTheme.isNowThemeIsNightForQzone());
    }

    public static Boolean setCurrentThemeIdVersion(AppRuntime appRuntime, String str, String str2) {
        AppRuntime appRuntime2;
        if (appRuntime == null) {
            appRuntime2 = getCreateAppRuntime();
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "setCurrentThemeIdVersion,application == null");
            }
            if (appRuntime2 == null) {
                QLog.e(TAG, 1, "setCurrentThemeIdVersion Error,application == null");
                return Boolean.FALSE;
            }
        } else {
            appRuntime2 = appRuntime;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences uinThemePreferences = getUinThemePreferences(appRuntime2);
            String account = appRuntime2.getAccount();
            if (account == null) {
                QLog.e(TAG, 1, "setCurrentThemeIdVersion Error,uin=noLogin");
                account = "noLogin";
            }
            String str3 = account;
            curThemeId = str;
            String string = uinThemePreferences.getString("currentThemeId_6.3.5", "1000");
            int i3 = uinThemePreferences.getInt("user_switch_theme_times", 0);
            long j3 = uinThemePreferences.getLong("themeSetTimeKey", 0L);
            int i16 = i3 + 1;
            SharedPreferences.Editor edit = uinThemePreferences.edit();
            edit.putString("currentThemeId_6.3.5", str);
            edit.putString("currentThemeVersion", str2);
            edit.putInt("user_switch_theme_times", i16);
            edit.putLong("themeSetTimeKey", currentTimeMillis);
            boolean commit = edit.commit();
            VasLogReporter.getTheme().report("setCurrentThemeIdVersion,uin=" + VasTextUtil.hideUinInShowString(str3, 2) + ",oldUsrThemeId=" + string + ",set new themeId=" + str + ",set new version=" + str2 + ", userSwitchThemeTimes=" + i16 + ",commitSuss=" + commit + ", oldTime=" + j3);
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_themeId", str);
                hashMap.put("param_singleSp", String.valueOf(commit));
                StatisticCollector.getInstance(appRuntime2.getApplication().getApplicationContext()).collectPerformance(str3, "VipSetCurrentThemeIdVersion", commit, 1L, 0L, hashMap, "", false);
            } catch (Exception unused) {
            }
            return Boolean.valueOf(commit);
        }
        QLog.e(TAG, 1, "setCurrentThemeIdVersion Error,themeId or version == null, themeId:" + str + "version:" + str2);
        return Boolean.FALSE;
    }

    public static void setErrorThemeId(Context context, String str, boolean z16) {
        JSONObject jSONObject;
        int i3;
        int i16;
        int i17;
        SharedPreferences themePreferences = getThemePreferences(context);
        SharedPreferences.Editor edit = themePreferences.edit();
        String string = themePreferences.getString("listOfErrorThemeSrc", "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setErrorThemeID themeId=" + str);
        }
        try {
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string);
            }
            if (jSONObject.has(str)) {
                i3 = jSONObject.getInt(str);
            } else {
                i3 = 0;
            }
            if (z16) {
                i16 = i3 % 100000;
                i17 = 500000;
            } else {
                i16 = i3 % 100000;
                i17 = AdMetricID.Report.SUCCESS;
            }
            jSONObject.put(str, i16 + i17);
            edit.putString("listOfErrorThemeSrc", jSONObject.toString()).commit();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setErrorThemeId error:" + e16.getMessage());
            }
        }
    }

    public static void setThemeFilter(Drawable drawable, String str) {
        if (drawable == null) {
            return;
        }
        if ("1103".equals(str)) {
            drawable.setColorFilter(NIGHTMODE_COLORFILTER);
        } else {
            drawable.clearColorFilter();
        }
    }

    public static Boolean setThemeInfo(Context context, ThemeInfo themeInfo) {
        String str;
        if (context != null && themeInfo != null) {
            SharedPreferences.Editor edit = getThemePreferences(context).edit();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(themeInfo.zipVer);
            sb5.append(",");
            sb5.append(themeInfo.version);
            sb5.append(",");
            sb5.append(themeInfo.fileNum);
            sb5.append(",");
            if (themeInfo.isVoiceTheme) {
                str = "1";
            } else {
                str = "0";
            }
            sb5.append(str);
            sb5.append(",");
            sb5.append(themeInfo.size);
            sb5.append(",");
            sb5.append(themeInfo.downsize);
            sb5.append(",");
            sb5.append(themeInfo.status);
            String sb6 = sb5.toString();
            boolean commit = edit.putString(themeInfo.themeId, sb6).commit();
            if (!commit || QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setThemeInfoToSp sp comit ret=" + commit + ", themeStr=" + sb6 + " themeInfo = " + themeInfo);
            }
            return Boolean.valueOf(commit);
        }
        QLog.e(TAG, 1, "setThemeInfoToSp error, themeInfo:" + themeInfo + ", context:" + context);
        return Boolean.FALSE;
    }

    public static boolean setWeekLoopTheme(AppRuntime appRuntime, String str, String str2, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setWeekLoopTheme, seriesID=" + str + ", themeArray=" + str2 + ", startTime=" + j3);
        }
        SharedPreferences uinThemePreferences = getUinThemePreferences(appRuntime);
        SharedPreferences.Editor edit = uinThemePreferences.edit();
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(uinThemePreferences.getString("seriesID", null))) {
                return true;
            }
            edit.putString("seriesID", "");
            edit.putString("themeArray", "");
            return edit.commit();
        }
        try {
            edit.putString("seriesID", str);
            edit.putString("themeArray", str2);
            if (!TextUtils.isEmpty(str2)) {
                int length = new JSONArray(str2).length();
                int i3 = 0;
                if (length <= 0) {
                    QLog.e(TAG, 2, "setWeekLoopTheme themeJsonArr Error:0 == length");
                    return false;
                }
                int rawOffset = TimeZone.getTimeZone(DateUtil.TIME_ZONE_8).getRawOffset();
                if (System.currentTimeMillis() > j3) {
                    long j16 = rawOffset;
                    i3 = (((int) Math.ceil((System.currentTimeMillis() + j16) / 86400000)) - ((int) Math.ceil((j16 + j3) / 86400000))) % length;
                }
                edit.putInt("themeLength", length);
                edit.putInt("themeIndex", i3);
                edit.putLong("startTime", j3);
            }
            boolean commit = edit.commit();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setWeekLoopTheme , setWeekLoopTheme is ok:" + commit);
                return commit;
            }
            return commit;
        } catch (Exception e16) {
            QLog.e(TAG, 2, "setWeekLoopTheme json Error:" + e16.getMessage());
            return true;
        }
    }

    public static boolean themeFont(Intent intent, String str) {
        String stringExtra = intent.getStringExtra(str);
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        try {
            ((IThemeFontAdapter) QRoute.api(IThemeFontAdapter.class)).switchFont(Integer.parseInt(stringExtra));
            return true;
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return true;
        }
    }

    private static void updateSuperTheme(JSONObject jSONObject) {
        boolean z16;
        boolean equals = THEME_TYPE_SUPER.equals(jSONObject.optString("style"));
        SharedPreferences preference = new ThemeMMKVPreference().getPreference();
        boolean z17 = true;
        if (Build.VERSION.SDK_INT > 28) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!equals || !z16) {
            z17 = false;
        }
        preference.edit().putBoolean(QQTheme.THEME_SUPER, z17).apply();
        QQTheme.updateSuperTheme(z17);
        mSuperThemePendant = jSONObject.optInt(IndividuationUrlHelper.UrlId.PENDANT_HOME);
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "updateSuperTheme:" + equals + ",targetVersion:" + z16);
        }
    }

    public static boolean useNativeThemeVideoPlayer() {
        if (!isNowThemeIsSuperTheme() && (!isNowThemeIsAnimate() || !enableNativeThemeVideoPlayer() || !isNowThemeIsVideoTheme())) {
            return false;
        }
        return true;
    }

    public static void validLocalTheme(Context context, String str) {
    }

    public static void setColorFilterIfNeed(ImageView imageView, boolean z16) {
        if (imageView == null) {
            return;
        }
        if (z16) {
            imageView.setColorFilter(1291845632);
        } else {
            imageView.setColorFilter(0);
        }
    }

    public static void validLocalTheme(Context context, String str, String str2) {
    }

    public static boolean isDefaultOrDIYTheme(boolean z16) {
        String userCurrentThemeId = z16 ? getUserCurrentThemeId(null) : getCurrentThemeId();
        return "1000".equals(userCurrentThemeId) || "999".equals(userCurrentThemeId);
    }

    public static void previewAIOTheme(Context context, String str) {
    }

    public static void previewPlayerSkin(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validLocalBg3D(Context context, AppRuntime appRuntime, String str, String str2) {
    }
}
