package com.tencent.mobileqq.simpleui;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SimpleUIUtil {
    static IPatchRedirector $redirector_ = null;
    private static boolean FORCE_DNOT_MODIFY_STATUS_BAR_FONT = false;
    public static int INDEX_OF_SIMPLE_UI_NIGHT = 0;
    private static final String QZONE_ACTION_GET_THEME_ID = "action_qzone_get_themeid";
    private static final String QZONE_IPC_NAME = "QzoneIPCModule";
    public static int SIMPLE_UI_STATUS_BAR_COLOR_PRE_M = 0;
    private static boolean SIMPLE_UI_SWITCH_OPENED_LAST = false;
    public static final int SIMPLE_UI__AIO__MODE_BG_GRAY = 1;
    public static final int SIMPLE_UI__AIO__MODE_BG_WHILTE__LINE_SPACE = 0;
    public static final int SIMPLE_UI__AIO__MODE_NORMAL = 0;
    public static final String TAG = "SimpleUILogSimpleUIUtil";
    public static int aioBgResId;
    public static int aioStatusResId;
    public static int aioTitleResId;
    public static int bgColor;
    public static int friendNormalResId;
    public static int friendPressResId;
    public static int inputBgResId;
    public static int inputResId;
    public static boolean isNeedInvalidate;
    public static String pullOffThemeId;
    public static int pullOffThemeIndex;
    private static int sSimpleUIAIOMode;
    private static AtomicInteger s_ElderUISwitch;
    private static AtomicInteger s_SimpleNoNightUIPref;
    private static AtomicInteger s_SimpleUIExpLebaFrameMode;
    private static AtomicInteger s_SimpleUILebaFeedsAvatarJumpType;
    private static AtomicInteger s_SimpleUIPref;
    private static AtomicInteger s_SimpleUISwitch;
    public static int searchBgResId;
    public static int searchEditBgResId;
    public static int searchIconResId;
    public static int searchIconTextResId;
    public static int searchVoiceResId;
    public static int showupResId;
    public static int structFriendResId;
    public static int structUserResId;
    public static int textColor;
    public static int titleBarResId;
    public static int userNormalResId;
    public static int userPressResId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42623);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        s_SimpleUISwitch = new AtomicInteger(Integer.MIN_VALUE);
        s_SimpleUIPref = new AtomicInteger(Integer.MIN_VALUE);
        s_SimpleNoNightUIPref = new AtomicInteger(Integer.MIN_VALUE);
        s_ElderUISwitch = new AtomicInteger(Integer.MIN_VALUE);
        s_SimpleUIExpLebaFrameMode = new AtomicInteger(Integer.MIN_VALUE);
        s_SimpleUILebaFeedsAvatarJumpType = new AtomicInteger(Integer.MIN_VALUE);
        SIMPLE_UI_SWITCH_OPENED_LAST = false;
        SIMPLE_UI_STATUS_BAR_COLOR_PRE_M = -2368549;
        FORCE_DNOT_MODIFY_STATUS_BAR_FONT = false;
        pullOffThemeId = "2971";
        pullOffThemeIndex = -1;
        INDEX_OF_SIMPLE_UI_NIGHT = QQTheme.SIMPLE_THEME_IDS.indexOf("2920");
        bgColor = 0;
        textColor = 0;
        sSimpleUIAIOMode = 0;
        isNeedInvalidate = false;
    }

    public SimpleUIUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void adjustColorForQQBrowserActivity(boolean z16, Window window) {
        if (ImmersiveUtils.isSupporImmersive() == 0 || !ImmersiveUtils.couldSetStatusTextColor() || QQTheme.isNowThemeIsNight()) {
            return;
        }
        ImmersiveUtils.setStatusTextColorNew(!z16, window, false);
    }

    public static void adjustSimpleStatusBar(ImmersiveTitleBar2 immersiveTitleBar2, Window window) {
        if (getSimpleUISwitch()) {
            boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
            if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor() && !FORCE_DNOT_MODIFY_STATUS_BAR_FONT) {
                if (QQTheme.isThemeSimpleDayUI(QQTheme.getCurrentThemeId())) {
                    if (!QQTheme.isSimpleColrThemeStateBarUseWhite(QQTheme.getCurrentThemeId())) {
                        ImmersiveUtils.setStatusTextColorNew(false, window);
                    } else {
                        ImmersiveUtils.setStatusTextColorNew(true, window);
                    }
                } else {
                    ImmersiveUtils.setStatusTextColorNew(!isNowThemeIsNight, window);
                }
            } else if (ImmersiveUtils.isSupporImmersive() != 0 && immersiveTitleBar2 != null && !isNowThemeIsNight) {
                immersiveTitleBar2.setBackgroundColor(SIMPLE_UI_STATUS_BAR_COLOR_PRE_M);
            }
            SIMPLE_UI_SWITCH_OPENED_LAST = true;
            return;
        }
        if (true != SIMPLE_UI_SWITCH_OPENED_LAST) {
            if (immersiveTitleBar2 != null) {
                ImmersiveUtils.adjustThemeStatusBar(window);
                return;
            }
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor() && !FORCE_DNOT_MODIFY_STATUS_BAR_FONT) {
            ImmersiveUtils.setStatusTextColorNew(false, window);
        } else if (ImmersiveUtils.isSupporImmersive() != 0 && immersiveTitleBar2 != null) {
            immersiveTitleBar2.setBackgroundColor(BaseApplication.getContext().getResources().getColor(R.color.skin_color_title_immersive_bar));
        }
        SIMPLE_UI_SWITCH_OPENED_LAST = false;
    }

    public static int getCurrentMode(boolean z16) {
        if (isNowSimpleMode()) {
            return 1;
        }
        if (z16) {
            return 2;
        }
        if (isNowElderMode()) {
            return 3;
        }
        return 0;
    }

    public static int getPrefByThemeId(String str) {
        for (int i3 = 0; i3 < QQTheme.SIMPLE_THEME_IDS.size(); i3++) {
            if (TextUtils.equals(str, getThemeId(i3))) {
                return i3;
            }
        }
        return -1;
    }

    public static int getSimpleNoNightUIPref() {
        int i3 = 0;
        boolean z16 = true;
        if (MobileQQ.sProcessId != 1) {
            z16 = false;
        }
        if (z16 && s_SimpleNoNightUIPref.get() != Integer.MIN_VALUE && isValidSimplePref(s_SimpleNoNightUIPref.get())) {
            return s_SimpleNoNightUIPref.get();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0;
        }
        SharedPreferences uinThemePreferences = QQTheme.getUinThemePreferences(peekAppRuntime.getAccount());
        int i16 = uinThemePreferences.getInt(ThemeConstants.KEY_SIMPLE_NO_NIGHT_UI_828, -1);
        if (!isValidSimplePref(i16)) {
            int i17 = uinThemePreferences.getInt(ThemeConstants.KEY_SIMPLE_NO_NIGHT_UI_NEW, 0);
            SharedPreferences.Editor edit = uinThemePreferences.edit();
            edit.remove(ThemeConstants.KEY_SIMPLE_NO_NIGHT_UI_NEW);
            edit.commit();
            if (isValidSimplePref(i17) && i17 != INDEX_OF_SIMPLE_UI_NIGHT) {
                i3 = i17;
            }
        } else {
            i3 = i16;
        }
        s_SimpleNoNightUIPref.compareAndSet(Integer.MIN_VALUE, i3);
        return i3;
    }

    static int getSimpleUIAIOMode() {
        return sSimpleUIAIOMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSimpleUIExpLebaFrameMode() {
        return s_SimpleUIExpLebaFrameMode.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSimpleUILebaFeedsAvatarJumpType() {
        return s_SimpleUILebaFeedsAvatarJumpType.get();
    }

    public static final int getSimpleUIPref() {
        int i3 = 0;
        boolean z16 = true;
        if (MobileQQ.sProcessId != 1) {
            z16 = false;
        }
        if (z16 && s_SimpleUIPref.get() != Integer.MIN_VALUE && isValidSimplePref(s_SimpleUIPref.get())) {
            return s_SimpleUIPref.get();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            SharedPreferences uinThemePreferences = QQTheme.getUinThemePreferences(peekAppRuntime.getAccount());
            int i16 = uinThemePreferences.getInt(ThemeConstants.KEY_SIMPLE_UI_PREF_828, -1);
            if (!isValidSimplePref(i16)) {
                int i17 = uinThemePreferences.getInt(ThemeConstants.KEY_SIMPLE_UI_PREF_NEW, 0);
                SharedPreferences.Editor edit = uinThemePreferences.edit();
                edit.remove(ThemeConstants.KEY_SIMPLE_UI_PREF_NEW);
                edit.commit();
                if (isValidSimplePref(i17)) {
                    i3 = i17;
                }
            } else {
                i3 = i16;
            }
            s_SimpleUIPref.compareAndSet(Integer.MIN_VALUE, i3);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSimpleUIPrefInt() {
        return s_SimpleUIPref.get();
    }

    public static final boolean getSimpleUISwitch() {
        if (!isNowSimpleMode() && !isNowElderMode()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSimpleUISwitchInt() {
        return s_SimpleUISwitch.get();
    }

    public static int getSimpleUiBgColor() {
        int i3 = bgColor;
        if (i3 != 0) {
            return i3;
        }
        String currentThemeId = QQTheme.getCurrentThemeId();
        if ("2971".equals(currentThemeId)) {
            bgColor = -1;
        } else if ("2921".equals(currentThemeId)) {
            bgColor = -657670;
        } else if ("3064".equals(currentThemeId)) {
            bgColor = -7084;
        } else if ("3063".equals(currentThemeId)) {
            bgColor = -15542596;
        } else if ("3066".equals(currentThemeId)) {
            bgColor = -34918;
        } else if ("3065".equals(currentThemeId)) {
            bgColor = -10145065;
        } else if ("3067".equals(currentThemeId)) {
            bgColor = -39054;
        } else if ("3491".equals(currentThemeId)) {
            bgColor = -15120003;
        }
        return bgColor;
    }

    public static int getSimpleUiTextColor() {
        int i3 = textColor;
        if (i3 != 0) {
            return i3;
        }
        String currentThemeId = QQTheme.getCurrentThemeId();
        if ("2971".equals(currentThemeId)) {
            textColor = Color.parseColor("#03081A");
        } else if ("1000".equals(currentThemeId)) {
            textColor = Color.parseColor("#03081A");
        } else if ("2921".equals(currentThemeId)) {
            textColor = Color.parseColor("#03081A");
        } else if ("3064".equals(currentThemeId)) {
            textColor = Color.parseColor("#03081A");
        } else if ("3063".equals(currentThemeId)) {
            textColor = -1;
        } else if ("3066".equals(currentThemeId)) {
            textColor = -1;
        } else if ("3065".equals(currentThemeId)) {
            textColor = -1;
        } else if ("3067".equals(currentThemeId)) {
            textColor = -1;
        } else if ("3491".equals(currentThemeId)) {
            textColor = -1;
        }
        return textColor;
    }

    public static String getThemeId(int i3) {
        List<String> list = QQTheme.SIMPLE_THEME_IDS;
        if (list.size() > i3 && i3 >= 0) {
            return list.get(i3);
        }
        if (pullOffThemeIndex == i3) {
            return pullOffThemeId;
        }
        return "2971";
    }

    public static int getThemeIndex(String str) {
        List<String> list = QQTheme.SIMPLE_THEME_IDS;
        if (list.size() == 0) {
            return -1;
        }
        if (list.contains(str)) {
            return list.indexOf(str);
        }
        pullOffThemeId = str;
        int size = list.size();
        pullOffThemeIndex = size;
        return size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isNowElderMode() {
        byte b16;
        if (com.tencent.common.config.pad.f.o()) {
            return false;
        }
        if (MobileQQ.sProcessId == 1) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 != false && s_ElderUISwitch.get() != Integer.MIN_VALUE) {
            if (s_ElderUISwitch.get() != 1) {
                return false;
            }
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        boolean z16 = QQTheme.getUinThemePreferences(peekAppRuntime.getAccount()).getBoolean(ThemeConstants.KEY_ELDER_UI_SWITCH, false);
        s_ElderUISwitch.compareAndSet(Integer.MIN_VALUE, z16 ? 1 : 0);
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean isNowSimpleMode() {
        byte b16;
        if (com.tencent.common.config.pad.f.o()) {
            return false;
        }
        if (MobileQQ.sProcessId == 1) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 != false && s_SimpleUISwitch.get() != Integer.MIN_VALUE) {
            if (s_SimpleUISwitch.get() != 1) {
                return false;
            }
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        boolean z16 = QQTheme.getUinThemePreferences(peekAppRuntime.getAccount()).getBoolean(ThemeConstants.KEY_SIMPLE_UI_SWITCH, false);
        s_SimpleUISwitch.compareAndSet(Integer.MIN_VALUE, z16 ? 1 : 0);
        return z16;
    }

    public static boolean isSimpleWhiteUi() {
        return "2971".equals(QQTheme.getCurrentThemeId());
    }

    public static boolean isValidSimplePref(int i3) {
        if ((i3 < 0 || i3 >= QQTheme.SIMPLE_THEME_IDS.size()) && i3 != pullOffThemeIndex) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isValidSimplePref error bPref=" + i3);
                return false;
            }
            return false;
        }
        return true;
    }

    public static void onDestroy() {
        s_SimpleUISwitch.set(Integer.MIN_VALUE);
        s_SimpleUIPref.set(Integer.MIN_VALUE);
        s_SimpleNoNightUIPref.set(Integer.MIN_VALUE);
    }

    public static void setElderUISwitchInt(int i3) {
        s_ElderUISwitch.set(i3);
    }

    public static void setSimpleNightIndex(int i3) {
        INDEX_OF_SIMPLE_UI_NIGHT = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSimpleNoNightPrefInt(int i3) {
        s_SimpleNoNightUIPref.set(i3);
    }

    static void setSimpleUIAIOMode(int i3) {
        sSimpleUIAIOMode = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSimpleUIExpLebaFrameMode(int i3) {
        s_SimpleUIExpLebaFrameMode.set(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSimpleUILebaFeedsAvatarJumpType(int i3) {
        s_SimpleUILebaFeedsAvatarJumpType.set(i3);
    }

    public static void setSimpleUIPrefInt(int i3) {
        s_SimpleUIPref.set(i3);
    }

    public static void setSimpleUISwitchInt(int i3) {
        s_SimpleUISwitch.set(i3);
    }

    public static void updateSimpleUIData() {
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        setSimpleUISwitchInt(isNowSimpleUI ? 1 : 0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        QQTheme.getUinThemePreferences(peekAppRuntime.getAccount()).edit().putBoolean(ThemeConstants.KEY_SIMPLE_UI_SWITCH, isNowSimpleUI).commit();
    }

    public static boolean useDarkResource() {
        if (Color.parseColor("#03081A") == getSimpleUiTextColor()) {
            return true;
        }
        return false;
    }

    public static void adjustColorForQQBrowserActivity(boolean z16, int i3, Window window) {
        if (getSimpleUISwitch()) {
            boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
            if (ImmersiveUtils.isSupporImmersive() == 0 || !ImmersiveUtils.couldSetStatusTextColor() || isNowThemeIsNight) {
                return;
            }
            if (z16) {
                ImmersiveUtils.setStatusTextColorNew(false, window, false);
            } else {
                ImmersiveUtils.setStatusTextColorNew(true, window, false);
            }
        }
    }

    public static void adjustColorForQQBrowserActivity(boolean z16, Color color, Window window) {
        if (getSimpleUISwitch()) {
            boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
            if (ImmersiveUtils.isSupporImmersive() == 0 || !ImmersiveUtils.couldSetStatusTextColor() || isNowThemeIsNight) {
                return;
            }
            if (z16) {
                ImmersiveUtils.setStatusTextColorNew(false, window, false);
            } else {
                ImmersiveUtils.setStatusTextColorNew(true, window, false);
            }
        }
    }

    public static void adjustSimpleStatusBar(SystemBarCompact systemBarCompact, Window window) {
        adjustSimpleStatusBar(systemBarCompact, window, null);
    }

    public static void adjustSimpleStatusBar(SystemBarCompact systemBarCompact, Window window, Boolean bool) {
        boolean booleanValue;
        if (getSimpleUISwitch()) {
            boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
            if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor() && !FORCE_DNOT_MODIFY_STATUS_BAR_FONT) {
                if (bool == null) {
                    booleanValue = !isNowThemeIsNight;
                } else {
                    booleanValue = bool.booleanValue();
                }
                if (QQTheme.isThemeSimpleDayUI(QQTheme.getCurrentThemeId())) {
                    if (!QQTheme.isSimpleColrThemeStateBarUseWhite(QQTheme.getCurrentThemeId())) {
                        ImmersiveUtils.setStatusTextColorNew(false, window);
                    } else {
                        ImmersiveUtils.setStatusTextColorNew(true, window);
                    }
                } else {
                    ImmersiveUtils.setStatusTextColorNew(booleanValue, window);
                }
            } else if (ImmersiveUtils.isSupporImmersive() != 0 && systemBarCompact != null && !isNowThemeIsNight) {
                systemBarCompact.setStatusBarColor(SIMPLE_UI_STATUS_BAR_COLOR_PRE_M);
            }
            SIMPLE_UI_SWITCH_OPENED_LAST = true;
            return;
        }
        if (true != SIMPLE_UI_SWITCH_OPENED_LAST) {
            if (systemBarCompact != null) {
                ImmersiveUtils.adjustThemeStatusBar(window);
                return;
            }
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor() && !FORCE_DNOT_MODIFY_STATUS_BAR_FONT) {
            ImmersiveUtils.setStatusTextColor(bool == null ? false : bool.booleanValue(), window);
        } else if (ImmersiveUtils.isSupporImmersive() != 0 && systemBarCompact != null) {
            systemBarCompact.setStatusBarColor(R.color.skin_color_title_immersive_bar);
        }
        SIMPLE_UI_SWITCH_OPENED_LAST = false;
    }

    public static void switchStatus() {
    }

    public static void setLineSpaceIfNeccessary(TextView textView) {
    }
}
