package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITbsReader {
    public static final int COPY_SELECT_TEXT = 5003;
    public static final int GET_BAR_ANIMATING = 5000;
    public static final int GET_BAR_ISSHOWING = 5024;
    public static final int HIDDEN_BAR = 5001;
    public static final int INSTALL_QB = 5011;
    public static final String KEY_FILE_COMPONENT_VERSION = "tbs_file_component_version";
    public static final String KEY_INSTALLED_PLUGIN_VERSION_PREFIX = "tbs_plugin_version_";
    public static final String KEY_IS_EXCEPT_CQUATRE = "tbs_except_use_cquatre";
    public static final int LIFE_CYCLE_ON_CREATE = 30001;
    public static final int LIFE_CYCLE_ON_DESTROY = 30006;
    public static final int LIFE_CYCLE_ON_PAUSE = 30002;
    public static final int LIFE_CYCLE_ON_RESUME = 30003;
    public static final int LIFE_CYCLE_ON_START = 30004;
    public static final int LIFE_CYCLE_ON_STOP = 30005;
    public static final int NOTIFY_CANDISPLAY = 12;
    public static final int NOTIFY_COMMON_INFO = 5049;
    public static final int NOTIFY_ENTRY_EDIT_MODE = 5070;
    public static final int NOTIFY_ERRORCODE = 19;
    public static final int NOTIFY_HIDE_SELECTMENU = 5073;
    public static final int NOTIFY_OPEN_FILE_BEGIN = 5071;
    public static final int NOTIFY_QUERY_ENCRYPT_SUPPORT = 5060;
    public static final int NOTIFY_REQUEST_ENCRYPT_INPUT_PWD = 5061;
    public static final int NOTIFY_RESPONSE_ENCRYPT_INPUT_PWD = 5062;
    public static final int NOTIFY_RESPONSE_ENCRYPT_PASSWORD_VERIFY = 5063;
    public static final int NOTIFY_SHOW_SELECTMENU = 5072;
    public static final int NOTIFY_SHOW_TOOLBAR = 5050;
    public static final int OPEN_FILEREADER_ASYNC_LOAD_READER_ENTRY_CALLBACK = 7002;
    public static final int OPEN_FILEREADER_LOAD_LICENSE_CALLBACK = 7003;
    public static final int OPEN_FILEREADER_STATUS_UI_CALLBACK = 7000;
    public static final int OPEN_FILEREADER_STREAM_MODE_CALLBACK = 7004;
    public static final int OPEN_FILEREADER_SYNC_LOAD_READER_ENTRY_CALLBACK = 7001;
    public static final int PDF_SEEK_PROGRESS = 307;
    public static final String POLICY_BUILTIN_ASSETS_FIRST = "buildinAssetsFirst";
    public static final String POLICY_BUILTIN_ASSETS_ONLY = "buildinAssetsOnly";
    public static final String POLICY_BUILTIN_FIRST = "buildinFirst";
    public static final String POLICY_BUILTIN_ONLY = "buildinOnly";
    public static final String POLICY_LOCAL_FIRST = "localFirst";
    public static final String POLICY_LOCAL_ONLY = "localOnly";
    public static final int READER_COMMAND_IS_EDIT_MODE = 8001;
    public static final int READER_COMMAND_ON_BACK_PRESSED = 8002;
    public static final int READER_CUSTOM_QQ_EVENT = 6001;
    public static final int READER_EVENT_BTN_CANCEL = 3009;
    public static final int READER_EVENT_BTN_COPY = 3008;
    public static final int READER_EVENT_BTN_EDIT = 3015;
    public static final int READER_EVENT_BTN_SEARCH = 3012;
    public static final int READER_EVENT_CHM = 3010;
    public static final int READER_EVENT_CHM_READER = 3011;
    public static final int READER_EVENT_CLICK = 3000;
    public static final int READER_EVENT_HIDE_MENU_WITHOUT_ANIMATION = 3013;
    public static final int READER_EVENT_NIGHT_MODE_CHANGED = 3018;
    public static final int READER_EVENT_ON_BACK_PRESSED = 3016;
    public static final int READER_EVENT_OPEN_FAILED = 3007;
    public static final int READER_EVENT_SCALE_BEGIN = 3004;
    public static final int READER_EVENT_SCALE_END = 3005;
    public static final int READER_EVENT_SCROLLING = 3003;
    public static final int READER_EVENT_SCROLL_BEGIN = 3001;
    public static final int READER_EVENT_SCROLL_END = 3002;
    public static final int READER_EVENT_SCROLL_RATIO = 3006;
    public static final int READER_EVENT_SHARE_MENU_VISIBLE = 3017;
    public static final int READER_EVENT_STAT_REQ = 3014;
    public static final int READER_MENU_ID_FILE_SEND = 268435456;
    public static final int READER_MENU_ID_OPEN_THIRDPARTY = 16777216;
    public static final int READER_MENU_ID_OPEN_THIRDPARTY_CANCEL_DEFAULT = 33554432;
    public static final int READER_MENU_ID_RECENT_FILE_LIST = 1048576;
    public static final int READER_PAGE_TOAST = 5048;
    public static final int READER_PDF_LIST = 5008;
    public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
    public static final int READER_PLUGIN_CANLOAD = 5013;
    public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
    public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
    public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
    public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIT_SCREEN = 5083;
    public static final int READER_PLUGIN_COMMAND_USER_STATICS = 6002;
    public static final int READER_PLUGIN_DOCX_FINDRESULT = 5080;
    public static final int READER_PLUGIN_DOWNLOADING = 5014;
    public static final int READER_PLUGIN_LOADING_HIDE = 5033;
    public static final int READER_PLUGIN_PDF_OUTLINE_EXIST = 5037;
    public static final int READER_PLUGIN_QUERY_TEXT_FIND = 5081;
    public static final int READER_PLUGIN_QUERY_TEXT_FIT_SCREEN = 5082;
    public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
    public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
    public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
    public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
    public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
    public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
    public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
    public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
    public static final int READER_PLUGIN_SO_ERR = 5025;
    public static final int READER_PLUGIN_SO_INTO_START = 5027;
    public static final int READER_PLUGIN_SO_PROGRESS = 5028;
    public static final int READER_PLUGIN_SO_SUCCESS = 5031;
    public static final int READER_PLUGIN_SO_VERSION = 5030;
    public static final int READER_PLUGIN_STATUS = 5012;
    public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
    public static final int READER_PPT_PLAY_MODEL = 5009;
    public static final int READER_SEARCH_IN_DOCUMENT = 5026;
    public static final int READER_TOAST = 5005;
    public static final int READER_TXT_READING_MODEL = 5010;
    public static final int SEARCH_SELECT_TEXT = 5004;
    public static final int SHOW_BAR = 5002;
    public static final int SHOW_DIALOG = 5006;
    public static final String SP_TBS_FILE = "tbs_file_plugin_config";
    public static final int TBS_READER_TYPE_MIXER = 3;
    public static final int TBS_READER_TYPE_ONLY_VIEW = 1;
    public static final int TBS_READER_TYPE_SDK_CREATE_READER_ERR = 1001;
    public static final int TBS_READER_TYPE_SDK_DOWNLOAD_FILE_ERR = 1004;
    public static final int TBS_READER_TYPE_SDK_DOWNLOAD_FILE_SUCCESS = 1003;
    public static final int TBS_READER_TYPE_SDK_ENTRY_LOAD_ERR = 1000;
    public static final int TBS_READER_TYPE_SDK_OPEN_FILE_ERR = 1101;
    public static final int TBS_READER_TYPE_SDK_OPEN_FILE_SUCCESS = 1100;
    public static final int TBS_READER_TYPE_SDK_SUPPORT_EXT_ERR = 1002;
    public static final int TBS_READER_TYPE_STATUS_UI_OPENED = 0;
    public static final int TBS_READER_TYPE_STATUS_UI_SHUTDOWN = 1;
    public static final int WEBVIEW_GET_TITLE_HEIGHT = 5045;
    public static final int WEBVIEW_GET_VISBLE_TITLE_HEIGHT = 5047;
    public static final int WEBVIEW_ON_VISBLE_TITLE_HEIGHT_CHANGED = 5046;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IReaderCore {
        void closeFile();

        void destroy();

        boolean init(Context context);

        void onSizeChanged(Integer num, Integer num2);

        int openFile(Context context, Bundle bundle, FrameLayout frameLayout, View view);

        void prepareHeadlessReader(Context context, String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IReaderPlugin {
        void destroy();

        int downloadPlugin(Context context, String str);

        int initPlugin(Context context);
    }

    Object createAtom(int i3);

    void destroy();

    void doCommand(Integer num, Object obj, Object obj2);

    IReaderCore getReaderCore();

    IReaderPlugin getReaderPlugin();

    void registerAtom(Object obj);

    void setListener(Object obj);
}
