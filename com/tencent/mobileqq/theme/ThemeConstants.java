package com.tencent.mobileqq.theme;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ThemeConstants {
    static IPatchRedirector $redirector_ = null;
    public static final int ANIMATE_BG_AIO = 3;
    public static final int ANIMATE_BG_CONVERSATION = 2;
    public static final int ANIMATE_BG_DRAWER = 1;
    public static final int ANIMATE_TAB_CALL = 13;
    public static final int ANIMATE_TAB_CONTACTS = 12;
    public static final int ANIMATE_TAB_CONVERSATION = 11;
    public static final int ANIMATE_TAB_FLASH_SHOW = 18;
    public static final int ANIMATE_TAB_GUILD = 19;
    public static final int ANIMATE_TAB_LEBA = 14;
    public static final int ANIMATE_TAB_NOW = 15;
    public static final int ANIMATE_TAB_QCIRCLE = 17;
    public static final int ANIMATE_TAB_SEE = 16;
    public static final String BUNDLE_KEY_DYNAMIC_ENABLE = "dynamic_enable";
    public static final String BUNDLE_KEY_DYNAMIC_SWITCH = "dynamic_switch";
    public static final String BUNDLE_KEY_DYNAMIC_WEBVIEW_ENABLE = "dynamic_webview_enable";
    public static final String BUNDLE_KEY_MESSAGE = "message";
    public static final String BUNDLE_KEY_PAGE_AIO = "pageAIO";
    public static final String BUNDLE_KEY_PAGE_DRAWER = "pageDrawer";
    public static final String BUNDLE_KEY_PAGE_DYNAMIC = "pageDynamic";
    public static final String BUNDLE_KEY_PAGE_FRIEND = "pageFriend";
    public static final String BUNDLE_KEY_PAGE_MESSAGE = "pageMessage";
    public static final String BUNDLE_KEY_RESULT_INT = "result_int";
    public static final String BUNDLE_KEY_SERVER_AFTER_DOWNLOAD = "server_after_download";
    public static final String BUNDLE_KEY_SERVER_WITH_UNZIP = "server_with_unzip";
    public static final String CMD_REQ_GET_0X5EB_FOR_THEME = "OidbSvc.0x5eb_ForTheme";
    public static final String CMD_THEME_AUTH = "AuthSvr.ThemeAuth";
    public static final String DEFAULT_THEME_ID = "1000";
    public static final String DIY_ASSETS_EMPTY = "999_empty";
    public static final int DIY_STYLE_END = 1000000;
    public static final int DIY_STYLE_START = 5000;
    public static final String DIY_THEME_ID = "999";
    public static final String DIY_THEME_VERSION = "20000000";
    public static final int FEETYPE_FREE = 1;
    public static final int FEETYPE_SVIP = 5;
    public static final int FEETYPE_VIP = 4;
    public static final String KEY_ELDER_UI_SWITCH = "key_elder_ui_switch";
    public static final String KEY_ENABLE_TOOL_SYNC = "enableToolSync";
    public static final String KEY_SIMPLE_NO_NIGHT_UI_828 = "key_simple_no_night_ui_828";
    public static final String KEY_SIMPLE_NO_NIGHT_UI_NEW = "key_simple_no_night_ui_new";
    public static final String KEY_SIMPLE_SHOULD_SHOW_SWITCH_DIALOG = "key_simple_should_show_switch_dialog";
    public static final String KEY_SIMPLE_THEME_ID = "simple_theme_id";
    public static final String KEY_SIMPLE_UI_EXP_LEBA_FRAME_MODE = "key_simple_ui_exp_leba_frame_mode";
    public static final String KEY_SIMPLE_UI_PREF = "key_simple_ui_pref";
    public static final String KEY_SIMPLE_UI_PREF_828 = "key_simple_ui_pref_828";
    public static final String KEY_SIMPLE_UI_PREF_NEW = "key_simple_ui_pref_new";
    public static final String KEY_SIMPLE_UI_SWITCH = "key_simple_ui_switch";
    public static final String KEY_THEME = "theme_root";
    public static final String LOCAL_THEME_ID = "900";
    public static final String MMKV_THEME_MMAP_FILE = "common_mmkv_configurations";
    public static final String MMKV_THEME_SP_MIGRATE = "mmkv_simple_migrate";
    public static final ColorFilter NIGHTMODE_COLORFILTER;
    public static final int NIGHTMODE_MASKCOLOR;
    public static final String OLD_ENGINE_PATH = "oldEnginePath";
    public static final String PKG_SUFFIX = ".zip";
    public static final String[] SIMPLE_THEME_ID_LIST;
    public static final String SOUND_THEME_TYPE = "1";
    public static final String SP_KEY_AUTH_TIME = "authTime";
    public static final String SP_KEY_CLEAN_LIST = "cleanList";
    public static final String SP_THEME_FILE_NAME = "theme";
    public static final String START_DOWNLOAD_RESULT = "StartDownloadResult";
    public static String TAB_NAME_KANDIAN = null;
    public static String TAB_NAME_KANDIAN_RIJ_FRAME = null;
    public static String TAB_NAME_QCIRCLE = null;
    public static final String THEME_ANIMATION_AIO1_VIDEO = "qq_skin_aio_enter.mp4";
    public static final String THEME_ANIMATION_AIO2_VIDEO = "qq_skin_aio.mp4";
    public static final String THEME_ANIMATION_AIO3_VIDEO = "qq_skin_aio_leave.mp4";
    public static final String THEME_ANIMATION_AIO_VIDEO = "qq_skin_aio.mp4";
    public static final String THEME_ANIMATION_CONVERSATION1_VIDEO = "qq_skin_conversation_enter.mp4";
    public static final String THEME_ANIMATION_CONVERSATION2_VIDEO = "qq_skin_conversation.mp4";
    public static final String THEME_ANIMATION_CONVERSATION3_VIDEO = "qq_skin_conversation_leave.mp4";
    public static final String THEME_ANIMATION_CONVERSATION_VIDEO = "qq_skin_conversation.mp4";
    public static final String THEME_ANIMATION_DRAWER1_VIDEO = "qq_skin_drawer_enter.mp4";
    public static final String THEME_ANIMATION_DRAWER2_VIDEO = "qq_skin_drawer.mp4";
    public static final String THEME_ANIMATION_DRAWER3_VIDEO = "qq_skin_drawer_leave.mp4";
    public static final String THEME_ANIMATION_DRAWER_CONVERSATION_VIDEO = "qq_skin_drawer_conversation.mp4";
    public static final String THEME_ANIMATION_DRAWER_VIDEO = "qq_skin_drawer.mp4";
    public static final String THEME_ANIMATION_SPLASH_VIDEO = "qq_skin_splash.mp4";
    public static final String THEME_DEBUG_KEY = "ThemeDebugKeyLog:";
    public static final String[] THEME_DEFAULT_IDS;
    public static final String THEME_DIY_BG_FEETYPE_SUFFIX = "_feetype";
    public static final String THEME_DIY_BG_FROM_SUFFIX = "_from";
    public static final String THEME_DIY_BG_ID_SUFFIX = "_id";
    public static final String THEME_DIY_BG_NAME_SUFFIX = "_name";
    public static final String THEME_DIY_BG_THUM_SUFFIX = "_thum";
    public static final String THEME_DIY_BG_URL_SUFFIX = "_url";
    public static final String THEME_ERROR_ID_LIST = "listOfErrorThemeSrc";
    public static final String THEME_ID = "themeId";
    public static final int[] THEME_IDS;
    public static final String[] THEME_ID_COLOR_CODE_LIST;
    public static final String THEME_ID_DAYMODE_SIMPLEUI_BLUE = "3491";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_GRREEN = "3063";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_PURPLE = "3065";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_RED = "3067";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_T_RED = "3066";
    public static final String THEME_ID_DAYMODE_SIMPLEUI_YELLOW = "3064";
    public static final String THEME_ID_DAYMODE_SIMPLE_GRAY = "2921";
    public static final String THEME_ID_DAYMODE_SIMPLE_WHITE = "2971";
    public static final String THEME_ID_GOLDEN = "2101";
    public static final String[] THEME_ID_IMAGE_LIST_MAME;
    public static final String THEME_ID_LOCAL_SIMPLE = "1001";
    public static final String THEME_ID_NIGHTMODE = "1103";
    public static final String THEME_ID_NIGHTMODE_SIMPLE = "2920";
    public static final String THEME_ID_SIMPLE_SPEC = "simpleSkin";
    public static final String THEME_ID_WHITEMODE = "2105";
    public static final String THEME_ISVOICE = "isVoiceTheme";
    public static final String THEME_KEY_CURRENT_THEME_ID = "currentThemeId_6.3.5";
    public static final String THEME_KEY_CURRENT_THEME_VERSION = "currentThemeVersion";
    public static final String THEME_KEY_USER_DOWNLOAD = "userDownloadTheme";
    public static final String THEME_KEY_USER_SWITCH_TIMES = "user_switch_theme_times";
    public static final String THEME_MSSAGE_VOICE_NAME = "message.mp3";
    public static final String THEME_ORIENTATION_HORIZONTAL = "horizontal";
    public static final String THEME_PATH = "themePath";
    public static final String THEME_SET_TIME_KEY = "themeSetTimeKey";
    public static final String THEME_SHARED_PREFERENCES = "userThemeSharedPreferences";
    public static final String THEME_SIZE = "size";
    public static final String THEME_SP_KEY_VERSION = "themeSpVersion";
    public static final String THEME_SP_SEPARATOR = ",";
    public static final int THEME_SP_VERSION_1 = 1;
    public static final String THEME_STATUS = "themeStatus";
    public static final String THEME_STATUS_COMPLETE = "5";
    public static final String THEME_STATUS_DOWNLOAD_END = "3";
    public static final String THEME_STATUS_DOWNLOAD_NONE = "1";
    public static final String THEME_STATUS_DOWNLOAD_PAUSE = "4";
    public static final String THEME_STATUS_DOWNLOAD_PROGRESS = "2";
    public static final String THEME_TYPE = "themeType";
    public static final String THEME_TYPE_ANIMATE = "animation";
    public static final int THEME_TYPE_FROM_SERVER = 1;
    public static final String THEME_URL = "url";
    public static final String THEME_VERSION = "version";
    public static final String THEME_VOICE_BASE_HOME = "voice";
    public static final String THEME_VOICE_SETTING = "theme_voice_setting_";
    public static final String WEEK_KEY_INDEX = "themeIndex";
    public static final String WEEK_KEY_SERIES_ID = "seriesID";
    public static final String WEEK_KEY_THEME_ARRAY = "themeArray";
    public static final String WEEK_KEY_THEME_LENGTH = "themeLength";
    public static final String WEEK_KEY_THEME_START_TIME = "startTime";
    public static final int ZIP_VERSION = 20000000;
    public static final int ZIP_VERSION_OLD = 200;
    public static final String ZIP_VERSION_STR = "20000000";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40694);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SIMPLE_THEME_ID_LIST = new String[]{"2971", "2921", "3063", "3064", "3066", "3065", "3491", "3067", "2920"};
        THEME_ID_COLOR_CODE_LIST = new String[]{"#FFFFFF", "#F5F6FA", "#12D6BC", "#FFE454", "#FF779A", "#6532D7", "#19497D", "#FF6772", "#2D2F32"};
        THEME_IDS = new int[]{2971, 2921, 3063, 3064, 3066, 3065, 3491, 3067, 2920};
        THEME_ID_IMAGE_LIST_MAME = new String[]{"\u6781\u7b80\u767d", "\u7d20\u96c5\u7070", "\u6d45\u8471\u7eff", "\u76db\u590f\u9ec4", "\u6843\u6843\u7c89", "\u661f\u8fb0\u7d2b", "\u7ecf\u5178\u84dd", "\u5143\u6c14\u7ea2", "\u6781\u81f4\u9ed1"};
        THEME_DEFAULT_IDS = new String[]{"999", "1000", "1103", "2971", "2921", "3064", "3063", "3066", "3065", "3067", "3491", "2920"};
        int parseColor = Color.parseColor("#4d000000");
        NIGHTMODE_MASKCOLOR = parseColor;
        TAB_NAME_QCIRCLE = "com.tencent.mobileqq.activity.qcircle.QCircleFrame";
        TAB_NAME_KANDIAN = "com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame";
        TAB_NAME_KANDIAN_RIJ_FRAME = "com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame";
        NIGHTMODE_COLORFILTER = new PorterDuffColorFilter(parseColor, PorterDuff.Mode.SRC_ATOP);
    }

    public ThemeConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
