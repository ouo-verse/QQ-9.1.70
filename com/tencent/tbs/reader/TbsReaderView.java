package com.tencent.tbs.reader;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import re4.b;

/* compiled from: P */
@Deprecated
/* loaded from: classes26.dex */
public class TbsReaderView extends FrameLayout implements ITbsReaderCallback {
    public static final String FILE_READER_BG_CONTENT_COLOR = "file_reader_bg_content_color";
    public static final String FILE_READER_DOWNLOAD_TYPE = "file_reader_download_type";
    public static final String FILE_READER_HIDE_TOOLBAR = "file_reader_tool_bar_hide";
    public static final String FILE_READER_UI_STYLE = "style";
    public static final int FILE_READER_UI_STYLE_QQ = 2;
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_TYPE_DOWNLOAD_CUSTOM = 1;
    public static final int READER_TYPE_DOWNLOAD_DEFAULT = 0;
    public static final int READER_TYPE_ID_TOOLBAR_CLICK = 2;
    public static final int READER_TYPE_ID_TOOLBAR_CLICK_DOWNLOAD_QB = 5;
    public static final int READER_TYPE_ID_TOOLBAR_CLICK_SHOW_DIALOG = 4;
    public static final int READER_TYPE_ID_TOOLBAR_CLICK_TO_QB = 3;
    public static final int READER_TYPE_ID_TOOLBAR_GET_VIEW = 7;
    public static final int READER_TYPE_ID_TOOLBAR_OPEN_QB = 6;
    public static final int READER_TYPE_ID_TOOLBAR_SHOW = 1;
    public static final String TAG = "TbsReaderView";
    static boolean gInitSdk = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";
    ReaderCallback mCallBack;
    Context mContext;
    ReaderPluginPreLoad mPluginPreload;
    ReaderCallback mReaderCallback;
    TbsReaderManager mReaderManager;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_CUSTOM_QQ_EVENT = 6001;
        public static final int READER_EVENT_BTN_CANCEL = 3009;
        public static final int READER_EVENT_BTN_COPY = 3008;
        public static final int READER_EVENT_BTN_EDIT = 3015;
        public static final int READER_EVENT_BTN_SEARCH = 3012;
        public static final int READER_EVENT_CHM = 3010;
        public static final int READER_EVENT_CHM_READER = 3011;
        public static final int READER_EVENT_CLICK = 3000;
        public static final int READER_EVENT_HIDE_MENU_WITHOUT_ANIMATION = 3013;
        public static final int READER_EVENT_OPEN_FAILED = 3007;
        public static final int READER_EVENT_SCALE_BEGIN = 3004;
        public static final int READER_EVENT_SCALE_END = 3005;
        public static final int READER_EVENT_SCROLLING = 3003;
        public static final int READER_EVENT_SCROLL_BEGIN = 3001;
        public static final int READER_EVENT_SCROLL_END = 3002;
        public static final int READER_EVENT_SCROLL_RATIO = 3006;
        public static final int READER_EVENT_STAT_REQ = 3014;
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
        public static final int READER_PLUGIN_COMMAND_USER_STATICS = 6002;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_LOADING_HIDE = 5033;
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

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) throws RuntimeException {
        super(context);
        this.mContext = null;
        this.mCallBack = null;
        this.mReaderCallback = null;
        this.mPluginPreload = null;
        this.mReaderManager = null;
        if (context instanceof Activity) {
            this.mCallBack = readerCallback;
            this.mContext = context;
            return;
        }
        throw new RuntimeException("error: unexpect context(none Activity)");
    }

    public static Drawable getResDrawable(Context context, int i3) {
        return null;
    }

    public static String getResString(Context context, int i3) {
        return "";
    }

    public static boolean initSDK(Context context) {
        boolean z16;
        b.d("TbsReaderView", "initSDK, start");
        if (!gInitSdk) {
            if (TbsFileInterfaceImpl.initEngine(context.getApplicationContext()) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            gInitSdk = z16;
        }
        if (gInitSdk) {
            b.d("TbsReaderView", "initSDK, Success");
            Log.i("TbsReaderView", "initSDK, Success");
        } else {
            b.b("TbsReaderView", "initSDK, Failed");
            Log.e("TbsReaderView", "initSDK, Failed");
        }
        return gInitSdk;
    }

    public static void initSDKAsync(Context context, ITbsReaderCallback iTbsReaderCallback) {
        TbsFileInterfaceImpl.initEngineAsync(context.getApplicationContext(), iTbsReaderCallback);
    }

    public static boolean isSupportExt(Context context, String str) {
        if (initSDK(context)) {
            return TbsFileInterfaceImpl.canOpenFileExt(str);
        }
        return false;
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        TbsReaderManager tbsReaderManager = this.mReaderManager;
        if (tbsReaderManager != null) {
            tbsReaderManager.doAction(num, obj, obj2);
        }
    }

    public boolean downloadPlugin(String str) {
        b.d("TbsReaderView", "downloadPlugin, start");
        TbsReaderManager tbsReaderManager = this.mReaderManager;
        if (tbsReaderManager == null) {
            b.b("TbsReaderView", "downloadPlugin, mReaderManager==null");
            Log.e("TbsReaderView", "downloadPlugin, mReaderManager==null");
            return false;
        }
        if (this.mPluginPreload == null) {
            this.mPluginPreload = tbsReaderManager.getPluginPre(this.mContext);
        }
        if (this.mPluginPreload.downloadPlugin(this.mContext, str) != 0) {
            return false;
        }
        return true;
    }

    boolean initWizard() {
        try {
            if (this.mReaderManager == null) {
                this.mReaderManager = new TbsReaderManager();
            }
            return this.mReaderManager.initReader(getContext(), this);
        } catch (NullPointerException e16) {
            e16.printStackTrace();
            b.b("TbsReaderView", "initWizard, Unexpect null object!");
            Log.e("TbsReaderView", "initWizard, Unexpect null object!");
            return false;
        }
    }

    @Override // com.tencent.tbs.reader.ITbsReaderCallback
    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        String str = "onCallBackAction:" + num + " args:" + obj + " cb:" + obj2;
        Log.d("TbsReaderView", str);
        b.d("TbsReaderView", str);
        ReaderCallback readerCallback = this.mCallBack;
        if (readerCallback != null) {
            readerCallback.onCallBackAction(num, obj, obj2);
        }
    }

    public void onSizeChanged(int i3, int i16) {
        TbsReaderManager tbsReaderManager = this.mReaderManager;
        if (tbsReaderManager != null) {
            tbsReaderManager.onSizeChanged(Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void onStop() {
        ReaderPluginPreLoad readerPluginPreLoad = this.mPluginPreload;
        if (readerPluginPreLoad != null) {
            readerPluginPreLoad.destroy();
        }
        this.mPluginPreload = null;
        TbsReaderManager tbsReaderManager = this.mReaderManager;
        if (tbsReaderManager != null) {
            tbsReaderManager.destroy();
            this.mReaderManager = null;
        }
        this.mContext = null;
        gInitSdk = false;
    }

    public int openFile(Bundle bundle) {
        b.d("TbsReaderView", "openFile, start");
        if (this.mReaderManager != null && bundle != null) {
            if (!bundle.containsKey("file_reader_top_bar_hide")) {
                bundle.putBoolean("file_reader_top_bar_hide", true);
            }
            bundle.putInt("windowType", TbsFileInterfaceImpl.FILE_READER_WINDOW_TYPE_VIEW);
            int openFileReader = this.mReaderManager.openFileReader(getContext(), bundle, this, this);
            this.mReaderManager.setTempPath(bundle.getString("tempPath"));
            if (openFileReader != 0) {
                Log.e("TbsReaderView", "openFile, openFileReader failed!");
                b.b("TbsReaderView", "openFile, openFileReader failed!");
            }
            return openFileReader;
        }
        Log.e("TbsReaderView", "openFile, Failed due to TbsReaderManager or param is null");
        b.b("TbsReaderView", "openFile, Failed due to TbsReaderManager or param is null");
        return -1;
    }

    public boolean preOpen(String str, boolean z16) {
        b.d("TbsReaderView", "preOpen, start");
        if (!isSupportExt(this.mContext, str)) {
            String str2 = "preOpen, not support extension type:" + str;
            b.b("TbsReaderView", str2);
            Log.e("TbsReaderView", str2);
            return false;
        }
        boolean initSDK = initSDK(this.mContext);
        if (initSDK) {
            initSDK = initWizard();
            if (z16 && initSDK) {
                downloadPlugin(str);
            }
        }
        return initSDK;
    }

    public void preOpenAsync(String str, boolean z16, ITbsReaderCallback iTbsReaderCallback) {
        if (!isSupportExt(this.mContext, str)) {
            String str2 = "not supported by:" + str;
            b.b("TbsReaderView", str2);
            Log.e("TbsReaderView", str2);
            return;
        }
        initSDKAsync(this.mContext, iTbsReaderCallback);
        boolean initWizard = initWizard();
        if (z16 && initWizard) {
            downloadPlugin(str);
        }
    }

    public void userStatistics(String str) {
        TbsReaderManager tbsReaderManager = this.mReaderManager;
        if (tbsReaderManager != null) {
            tbsReaderManager.doAction(6002, str, null);
        }
    }
}
