package com.tencent.mobileqq.mini.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo;
import com.tencent.qqmini.sdk.launcher.model.StartupReportData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes33.dex */
public class LaunchParam implements Parcelable {
    public static final Parcelable.Creator<LaunchParam> CREATOR = new Parcelable.Creator<LaunchParam>() { // from class: com.tencent.mobileqq.mini.sdk.LaunchParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LaunchParam createFromParcel(Parcel parcel) {
            LaunchParam launchParam = new LaunchParam();
            try {
                launchParam.scene = parcel.readInt();
                launchParam.miniAppId = parcel.readString();
                launchParam.extraKey = parcel.readString();
                launchParam.entryPath = parcel.readString();
                launchParam.navigateExtData = parcel.readString();
                launchParam.fromMiniAppId = parcel.readString();
                launchParam.launchClickTimeMillis = parcel.readLong();
                launchParam.tempState = parcel.readInt();
                launchParam.timestamp = parcel.readLong();
                launchParam.shareTicket = parcel.readString();
                launchParam.envVersion = parcel.readString();
                launchParam.reportData = parcel.readString();
                launchParam.extendData = parcel.readString();
                launchParam.entryModel = (EntryModel) parcel.readParcelable(EntryModel.class.getClassLoader());
                launchParam.fromBackToMiniApp = parcel.readInt();
                launchParam.fromEnvVersion = parcel.readString();
                launchParam.fromMiniAppInfo = (MiniAppInfo) parcel.readParcelable(MiniAppInfo.class.getClassLoader());
                launchParam.privateExtraData = parcel.readString();
                ArrayList arrayList = new ArrayList();
                launchParam.fileMaterialInfoList = arrayList;
                parcel.readList(arrayList, MiniAppInfo.class.getClassLoader());
                launchParam.forceReload = parcel.readInt();
                boolean z16 = true;
                launchParam.skipHotReload = parcel.readInt() != 0;
                launchParam.spkTaskKey = parcel.readString();
                launchParam.taskType = parcel.readInt();
                launchParam.taskAppId = parcel.readString();
                launchParam.taskId = parcel.readString();
                launchParam.isCloseGameBox = parcel.readInt() != 0;
                launchParam.startupReportData = (StartupReportData) parcel.readParcelable(StartupReportData.class.getClassLoader());
                launchParam.isPreIntercept = parcel.readInt() != 0;
                if (parcel.readInt() == 0) {
                    z16 = false;
                }
                launchParam.isPreInterceptSuccess = z16;
            } catch (Throwable th5) {
                QDLog.e("miniapp", "LaunchParam createFromParcel exception!", th5);
            }
            return launchParam;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LaunchParam[] newArray(int i3) {
            return new LaunchParam[i3];
        }
    };
    public static final int FLAG_NEED_KILL = 2;
    public static final int FLAG_NEED_NEW_PROCESS = 1;
    public static final int FLAG_NONE = 0;
    public static final int LAUNCH_SCENE_1017 = 1017;
    public static final int LAUNCH_SCENE_1025 = 1025;
    public static final int LAUNCH_SCENE_1034 = 1034;
    public static final int LAUNCH_SCENE_1053 = 1053;
    public static final int LAUNCH_SCENE_1059 = 1059;
    public static final int LAUNCH_SCENE_1069 = 1069;
    public static final int LAUNCH_SCENE_1095 = 1095;
    public static final int LAUNCH_SCENE_1096 = 1096;
    public static final int LAUNCH_SCENE_1103 = 1103;
    public static final int LAUNCH_SCENE_ACCOUNT_PANEL = 4013;
    public static final int LAUNCH_SCENE_AD_BANNER_POPUP = 2094;
    public static final int LAUNCH_SCENE_AD_SCHEME = 2054;
    public static final int LAUNCH_SCENE_AIO_INTIMATE_DRAW = 2064;
    public static final int LAUNCH_SCENE_AIO_PANEL = 2053;
    public static final int LAUNCH_SCENE_AIO_SHORTCUT_PANEL = 4008;
    public static final int LAUNCH_SCENE_AIO_SWEET_GREY_TIPS = 2080;
    public static final int LAUNCH_SCENE_AIO_TITLE = 4014;
    public static final int LAUNCH_SCENE_APP_STORE_GAME_LIST = 2002;
    public static final int LAUNCH_SCENE_APP_STORE_TOP_LIST = 2001;
    public static final int LAUNCH_SCENE_ARK_BATTLE = 2072;
    public static final int LAUNCH_SCENE_ARK_INNER_TEMPLATE_MESSAGE = 2061;
    public static final int LAUNCH_SCENE_ARK_SEARCH_OPEN_CARD = 2075;
    public static final int LAUNCH_SCENE_ARK_UNKNOWN = 2059;
    public static final int LAUNCH_SCENE_BIGINSERTPAGE = 4005;
    public static final int LAUNCH_SCENE_C2C_AIO_SHORTCUT_PANEL = 4016;
    public static final int LAUNCH_SCENE_COLOR_NOTE = 1131;
    public static final int LAUNCH_SCENE_CONTACTS = 2006;
    public static final int LAUNCH_SCENE_DESKTOP_BOUTIQUE_RECOMMEND = 3008;
    public static final int LAUNCH_SCENE_DESKTOP_CHESS_ROOM = 3038;
    public static final int LAUNCH_SCENE_DESKTOP_DITTO_FEEDS = 3016;
    public static final int LAUNCH_SCENE_DESKTOP_DITTO_QUICK_MATCH = 3013;
    public static final int LAUNCH_SCENE_DESKTOP_DITTO_RECOMMEND = 3012;
    public static final int LAUNCH_SCENE_DESKTOP_EVERYONE_PLAYING = 3007;
    public static final int LAUNCH_SCENE_DESKTOP_FRIENDS_PK = 3009;
    public static final int LAUNCH_SCENE_DESKTOP_FRIENDS_PLAYING_MORE = 3004;
    public static final int LAUNCH_SCENE_DESKTOP_HEALTH_CODE = 3039;
    public static final int LAUNCH_SCENE_DESKTOP_HEALTH_EXP = 3044;
    public static final String LAUNCH_SCENE_DESKTOP_HEALTH_VIA = "3044_1";
    public static final int LAUNCH_SCENE_DESKTOP_HOT = 3023;
    public static final int LAUNCH_SCENE_DESKTOP_MORE = 3005;
    public static final String LAUNCH_SCENE_DESKTOP_MORE_VIA = "3005_1";
    public static final int LAUNCH_SCENE_DESKTOP_MOST_COMMONLY_USED = 3027;
    public static final int LAUNCH_SCENE_DESKTOP_MYAPP_MORE = 3041;
    public static final int LAUNCH_SCENE_DESKTOP_MYAPP_MORE_EXP = 3043;
    public static final String LAUNCH_SCENE_DESKTOP_MYAPP_MORE_VIA = "3043_1";
    public static final int LAUNCH_SCENE_DESKTOP_MY_APP = 3003;
    public static final int LAUNCH_SCENE_DESKTOP_MY_APP_RED_DOT = 3021;
    public static final int LAUNCH_SCENE_DESKTOP_PLAY = 3024;
    public static final int LAUNCH_SCENE_DESKTOP_POPULARITY_LIST = 3010;
    public static final int LAUNCH_SCENE_DESKTOP_RECENT_APP = 3001;
    public static final int LAUNCH_SCENE_DESKTOP_RECENT_APP_RED_DOT = 3020;
    public static final int LAUNCH_SCENE_DESKTOP_RECOMMEND_APP = 3002;
    public static final int LAUNCH_SCENE_DESKTOP_RESULT = 3026;
    public static final int LAUNCH_SCENE_DESKTOP_SEARCH_APP = 2077;
    public static final int LAUNCH_SCENE_DESKTOP_SEARCH_BAR = 3006;
    public static final int LAUNCH_SCENE_DESKTOP_SHORTCUT = 1023;
    public static final int LAUNCH_SCENE_DESKTOP_TOP_BANNER = 3011;
    public static final int LAUNCH_SCENE_EXP_DESKTOP = 3401;
    public static final int LAUNCH_SCENE_EXP_WX_DESKTOP = 3422;
    public static final int LAUNCH_SCENE_FILE_TENCENT_DOC = 2012;
    public static final int LAUNCH_SCENE_FILE_WEIYUN = 2011;
    public static final int LAUNCH_SCENE_FLOAT_DRAG_AD = 2115;
    public static final int LAUNCH_SCENE_FRD_LIKE_MINI_APP_VIDEO = 2089;
    public static final int LAUNCH_SCENE_GUILD_APPLICATION = 5002;
    public static final int LAUNCH_SCENE_INTIMATE_RELATIONSHIP_PLAY_TOGETHER = 2064;
    public static final int LAUNCH_SCENE_INTIMATE_SWEET_KEY = 2087;
    public static final int LAUNCH_SCENE_KD_SMALL_GAME_AD_CARD = 2086;
    public static final int LAUNCH_SCENE_KD_SMALL_GAME_CARD = 2103;
    public static final int LAUNCH_SCENE_KUOLIE_RECOMM = 2065;
    public static final int LAUNCH_SCENE_KUO_LIE_AIO_SHORTCUT_PANEL = 4017;
    public static final int LAUNCH_SCENE_LEBA = 2007;
    public static final int LAUNCH_SCENE_LEBA_MINIAPP = 2050;
    public static final int LAUNCH_SCENE_LEFT_PANEL = 4007;
    public static final int LAUNCH_SCENE_LIEF_ACHIVEMENT = 2062;
    public static final int LAUNCH_SCENE_MAIN_ENTRY = 1001;
    public static final int LAUNCH_SCENE_MINIAPP_ECSHOP = 4003;
    public static final int LAUNCH_SCENE_MINI_APP_MESSAGE_PUBLIC_ACCOUNT = 4012;
    public static final int LAUNCH_SCENE_MINI_APP_ONCE_SUBSCRIBE = 2105;
    public static final int LAUNCH_SCENE_MINI_APP_PHONE_NUMBER_SEARCH = 2111;
    public static final int LAUNCH_SCENE_MINI_APP_PROFILE = 1024;
    public static final int LAUNCH_SCENE_MINI_APP_ROBOT = 2112;
    public static final int LAUNCH_SCENE_MINI_APP_SUBSCRIBE = 2085;
    public static final int LAUNCH_SCENE_MINI_APP_SYSTEM_SUBSCRIBE = 2114;
    public static final int LAUNCH_SCENE_MINI_CODE_FROM_ALBUM = 1049;
    public static final int LAUNCH_SCENE_MINI_CODE_FROM_LONG_PRESS = 1048;
    public static final int LAUNCH_SCENE_MINI_CODE_FROM_SCAN = 1047;
    public static final int LAUNCH_SCENE_MINI_GAME_PUBLIC_ACCOUNT = 4011;
    public static final int LAUNCH_SCENE_MODIFY_FRIEND_INTERACTIVE_STORAGE = 2218;
    public static final int LAUNCH_SCENE_MODIFY_PWD = 2201;
    public static final int LAUNCH_SCENE_NAVIGATE_FROM_MINI_APP = 1038;
    public static final int LAUNCH_SCENE_NEW_EXPRESS_SERVICE = 3040;
    public static final int LAUNCH_SCENE_NEW_TINY_GAME = 5007;
    public static final int LAUNCH_SCENE_OPEN_BY_MINI_APP = 1037;
    public static final int LAUNCH_SCENE_PENDANTHOLDER = 4004;
    public static final int LAUNCH_SCENE_PROFILE_GUEST_CARD = 2062;
    public static final int LAUNCH_SCENE_PROFILE_OWNER_CARD = 2062;
    public static final int LAUNCH_SCENE_PUBLIC_ACCOUNT_MEMNU = 1035;
    public static final int LAUNCH_SCENE_PUBLIC_ACCOUNT_MESSAGE_CARD = 1074;
    public static final int LAUNCH_SCENE_PUBLIC_ACCOUNT_TEMPLATE_MESSAGE = 1043;
    public static final int LAUNCH_SCENE_PUBLIC_ACCOUNT_WEISHI = 4006;
    public static final int LAUNCH_SCENE_QQ_FAV = 1010;
    public static final int LAUNCH_SCENE_QQ_NOTICE = 2102;
    public static final int LAUNCH_SCENE_QQ_SAFE_CENTER = 4010;
    public static final int LAUNCH_SCENE_QQ_WALLET = 1019;
    public static final int LAUNCH_SCENE_QQ_X_MAN = 2093;
    public static final int LAUNCH_SCENE_QR_CODE_FROM_ALBUM = 1013;
    public static final int LAUNCH_SCENE_QR_CODE_FROM_LONG_PRESS = 1012;
    public static final int LAUNCH_SCENE_QR_CODE_FROM_SCAN = 1011;
    public static final int LAUNCH_SCENE_QUN = 2010;
    public static final int LAUNCH_SCENE_QZONE = 2009;
    public static final int LAUNCH_SCENE_QZONE_FRIEND_PLAYING_NINE = 2092;
    public static final int LAUNCH_SCENE_QZONE_FRIEND_PLAYING_THIRD = 2090;
    public static final int LAUNCH_SCENE_QZONE_PUBLISH_MOOD = 2100;
    public static final int LAUNCH_SCENE_QZONE_SHUOSHUO_LIST = 2060;
    public static final int LAUNCH_SCENE_QZONE_SWEET_WIDGET = 2088;
    public static final int LAUNCH_SCENE_RECENT_COLOR_NOTE = 1132;
    public static final int LAUNCH_SCENE_SAFE_MINIAPP_SCHEME = 2098;
    public static final int LAUNCH_SCENE_SAFE_MINIAPP_SCHEME_2119 = 2119;
    public static final int LAUNCH_SCENE_SCHEME = 2016;
    public static final int LAUNCH_SCENE_SEARCH = 2005;
    public static final int LAUNCH_SCENE_SEARCH_ENTRY = 4001;
    public static final int LAUNCH_SCENE_SEARCH_GUESS_YOU_LIKE = 3029;
    public static final int LAUNCH_SCENE_SEARCH_HAS_USED = 1027;
    public static final int LAUNCH_SCENE_SEARCH_LIVE = 3017;
    public static final int LAUNCH_SCENE_SEARCH_RECOMMEND_FOR_YOU = 3028;
    public static final int LAUNCH_SCENE_SEARCH_RESULT_FIND = 1006;
    public static final int LAUNCH_SCENE_SEARCH_RESULT_TOP = 1005;
    public static final int LAUNCH_SCENE_SETTING_ME = 2066;
    public static final int LAUNCH_SCENE_SHARE_C2C = 1007;
    public static final int LAUNCH_SCENE_SHARE_GROUP = 1008;
    public static final int LAUNCH_SCENE_SHARE_MESSAGE_TO_FRIEND = 2217;
    public static final int LAUNCH_SCENE_SHARE_OPEN_SDK = 1036;
    public static final int LAUNCH_SCENE_SHARE_QZONE = 2003;
    public static final int LAUNCH_SCENE_SHARE_TICKET = 1044;
    public static final int LAUNCH_SCENE_SPLASH = 2004;
    public static final int LAUNCH_SCENE_STATUS_SETTING_UI = 4015;
    public static final int LAUNCH_SCENE_STORY_CAMERA_PLAY_SHOW = 2083;
    public static final int LAUNCH_SCENE_TEMPLATE_MESSAGE = 1014;
    public static final int LAUNCH_SCENE_UNKNOWN = 9999;
    public static final int LAUNCH_SCENE_USER_TOP_ENTRY = 1022;
    public static final int LAUNCH_SCENE_WEATHER = 2066;
    public static final int LAUNCH_SCENE_WEBVIEW_HOOK = 2014;
    public static final String LAUNCH_VIA_QQ_X_MAN = "2016_4";
    public static final String MINI_APPID_COLLECTION_PAGE = "101495732";
    public static final int STATE_LOADING = 1;
    public static final int STATE_NONE = 0;
    public EntryModel entryModel;
    public String entryPath;
    public String envVersion;
    public String extendData;
    public String extraKey;
    public String fakeUrl;
    public List<FileMaterialInfo> fileMaterialInfoList;
    public int fromBackToMiniApp;
    public String fromEnvVersion;
    public String fromMiniAppId;
    public MiniAppInfo fromMiniAppInfo;
    public boolean isCloseGameBox;
    public boolean isPreIntercept;
    public boolean isPreInterceptSuccess;
    public long launchClickTimeMillis;
    public String miniAppId;
    public String navigateExtData;
    public String privateExtraData;
    public String reportData;
    public String shareTicket;
    public String slotId;
    public String spkTaskKey;
    public StartupReportData startupReportData;
    public String taskAppId;
    public String taskId;
    public int taskType;
    public int tianshuAdId;
    public long timestamp;
    public String via;
    public int scene = 9999;
    public int tempState = 0;
    public int forceReload = 0;
    public boolean skipHotReload = false;
    public boolean isScreenRecordEnabled = false;

    public static boolean isCollectionPage(String str) {
        return "101495732".equals(str);
    }

    private static String standardEntryPath(String str) {
        return SimpleMiniAppConfig.SimpleLaunchParam.standardEntryPath(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getScheme() {
        String str = "mqqapi://microapp/open?mini_appid=" + this.miniAppId;
        if (!TextUtils.isEmpty(this.entryPath)) {
            str = str + "&entryPath=" + this.entryPath;
        }
        if (TextUtils.isEmpty(this.extendData)) {
            return str;
        }
        return str + "&extraData=" + this.extendData;
    }

    public boolean isValid() {
        int i3 = this.scene;
        if (i3 == 1037) {
            return (TextUtils.isEmpty(this.miniAppId) || TextUtils.isEmpty(this.fromMiniAppId)) ? false : true;
        }
        if (i3 != 2003) {
            switch (i3) {
                case 1011:
                case 1012:
                case 1013:
                    return !TextUtils.isEmpty(this.fakeUrl);
                default:
                    return (TextUtils.isEmpty(this.miniAppId) && TextUtils.isEmpty(this.fakeUrl)) ? false : true;
            }
        }
        return !TextUtils.isEmpty(this.fakeUrl);
    }

    public void standardize() {
        this.entryPath = standardEntryPath(this.entryPath);
    }

    public String toString() {
        return "LaunchParam{scene=" + this.scene + ", miniAppId='" + this.miniAppId + "', extraKey='" + this.extraKey + "', entryPath='" + this.entryPath + "', extendData='" + this.extendData + "', navigateExtData='" + this.navigateExtData + "', fromMiniAppId='" + this.fromMiniAppId + "', fakeUrl='" + this.fakeUrl + "', timestamp=" + this.timestamp + ", launchClickTimeMillis=" + this.launchClickTimeMillis + ", tempState=" + this.tempState + ", shareTicket=" + this.shareTicket + ", envVersion=" + this.envVersion + ", reportData=" + this.reportData + ", fromBackToMiniApp=" + this.fromBackToMiniApp + ", fromEnvVersion=" + this.fromEnvVersion + "\uff0cisPreIntercept=" + this.isPreIntercept + "\uff0cisPreInterceptSuccess=" + this.isPreInterceptSuccess + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.scene);
        parcel.writeString(this.miniAppId);
        parcel.writeString(this.extraKey);
        parcel.writeString(this.entryPath);
        parcel.writeString(this.navigateExtData);
        parcel.writeString(this.fromMiniAppId);
        parcel.writeLong(this.launchClickTimeMillis);
        parcel.writeInt(this.tempState);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.shareTicket);
        parcel.writeString(this.envVersion);
        parcel.writeString(this.reportData);
        parcel.writeString(this.extendData);
        parcel.writeParcelable(this.entryModel, i3);
        parcel.writeInt(this.fromBackToMiniApp);
        parcel.writeString(this.fromEnvVersion);
        parcel.writeParcelable(this.fromMiniAppInfo, i3);
        parcel.writeString(this.privateExtraData);
        parcel.writeList(this.fileMaterialInfoList);
        parcel.writeInt(this.forceReload);
        parcel.writeInt(this.skipHotReload ? 1 : 0);
        parcel.writeString(this.spkTaskKey);
        parcel.writeInt(this.taskType);
        parcel.writeString(this.taskAppId);
        parcel.writeString(this.taskId);
        parcel.writeInt(this.isCloseGameBox ? 1 : 0);
        parcel.writeParcelable(this.startupReportData, i3);
        parcel.writeInt(this.isPreIntercept ? 1 : 0);
        parcel.writeInt(this.isPreInterceptSuccess ? 1 : 0);
    }
}
