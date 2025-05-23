package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
public class LaunchParam implements Parcelable {
    public static final Parcelable.Creator<LaunchParam> CREATOR = new Parcelable.Creator<LaunchParam>() { // from class: com.tencent.qqmini.sdk.launcher.model.LaunchParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LaunchParam createFromParcel(Parcel parcel) {
            LaunchParam launchParam = new LaunchParam();
            try {
                launchParam.createFrom(parcel);
            } catch (Throwable th5) {
                QMLog.e("miniapp", "LaunchParam createFromParcel exception!", th5);
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
    public static final int FLAG_NEED_RESTART = 4;
    public static final int FLAG_NONE = 0;
    public static final String GDT_MINIAPP_VIA = "2054_20";
    public static final String KEY_REF_ID = "big_brother_ref_source_key";
    public static final int LAUNCH_SCENE_1017 = 1017;
    public static final int LAUNCH_SCENE_1025 = 1025;
    public static final int LAUNCH_SCENE_1034 = 1034;
    public static final int LAUNCH_SCENE_1053 = 1053;
    public static final int LAUNCH_SCENE_1059 = 1059;
    public static final int LAUNCH_SCENE_1069 = 1069;
    public static final int LAUNCH_SCENE_1095 = 1095;
    public static final int LAUNCH_SCENE_1096 = 1096;
    public static final int LAUNCH_SCENE_1103 = 1103;
    public static final int LAUNCH_SCENE_AD_BANNER_POPUP = 2094;
    public static final int LAUNCH_SCENE_AD_SCHEME = 2054;
    public static final int LAUNCH_SCENE_AIO_PANEL = 2053;
    public static final int LAUNCH_SCENE_APP_STORE_GAME_LIST = 2002;
    public static final int LAUNCH_SCENE_APP_STORE_TOP_LIST = 2001;
    public static final int LAUNCH_SCENE_ARK_BATTLE = 2072;
    public static final int LAUNCH_SCENE_ARK_INNER_TEMPLATE_MESSAGE = 2061;
    public static final int LAUNCH_SCENE_ARK_SEARCH_OPEN_CARD = 2075;
    public static final int LAUNCH_SCENE_ARK_UNKNOWN = 2059;
    public static final int LAUNCH_SCENE_COLOR_NOTE = 1131;
    public static final int LAUNCH_SCENE_CONTACTS = 2006;
    public static final int LAUNCH_SCENE_DESKTOP_BOUTIQUE_RECOMMEND = 3008;
    public static final int LAUNCH_SCENE_DESKTOP_DITTO_QUICK_MATCH = 3013;
    public static final int LAUNCH_SCENE_DESKTOP_DITTO_RECOMMEND = 3012;
    public static final int LAUNCH_SCENE_DESKTOP_EVERYONE_PLAYING = 3007;
    public static final int LAUNCH_SCENE_DESKTOP_FRIENDS_PK = 3009;
    public static final int LAUNCH_SCENE_DESKTOP_FRIENDS_PLAYING_MORE = 3004;
    public static final int LAUNCH_SCENE_DESKTOP_MORE = 3005;
    public static final String LAUNCH_SCENE_DESKTOP_MORE_VIA = "3005_1";
    public static final int LAUNCH_SCENE_DESKTOP_MYAPP_MORE_EXP = 3043;
    public static final String LAUNCH_SCENE_DESKTOP_MYAPP_MORE_VIA = "3043_1";
    public static final int LAUNCH_SCENE_DESKTOP_MY_APP = 3003;
    public static final int LAUNCH_SCENE_DESKTOP_POPULARITY_LIST = 3010;
    public static final int LAUNCH_SCENE_DESKTOP_RECENT_APP = 3001;
    public static final int LAUNCH_SCENE_DESKTOP_RECOMMEND_APP = 3002;
    public static final int LAUNCH_SCENE_DESKTOP_SEARCH_APP = 2077;
    public static final int LAUNCH_SCENE_DESKTOP_SEARCH_BAR = 3006;
    public static final int LAUNCH_SCENE_DESKTOP_SHORTCUT = 1023;
    public static final int LAUNCH_SCENE_DESKTOP_TOP_BANNER = 3011;
    public static final int LAUNCH_SCENE_FILE_MATERIAL = 1173;
    public static final int LAUNCH_SCENE_FILE_TENCENT_DOC = 2012;
    public static final int LAUNCH_SCENE_FILE_WEIYUN = 2011;
    public static final int LAUNCH_SCENE_FLOAT_DRAG_AD = 2115;
    public static final int LAUNCH_SCENE_GUILD = 1075;
    public static final int LAUNCH_SCENE_GUILD_APPLICATION = 5002;
    public static final int LAUNCH_SCENE_INTIMATE_RELATIONSHIP_PLAY_TOGETHER = 2064;
    public static final int LAUNCH_SCENE_KUOLIE_RECOMM = 2065;
    public static final int LAUNCH_SCENE_LEBA = 2007;
    public static final int LAUNCH_SCENE_LEBA_MINIAPP = 2050;
    public static final int LAUNCH_SCENE_MAIN_ENTRY = 1001;
    public static final int LAUNCH_SCENE_MINI_APP_ONCE_SUBSCRIBE = 2105;
    public static final int LAUNCH_SCENE_MINI_APP_PROFILE = 1024;
    public static final int LAUNCH_SCENE_MINI_APP_SUBSCRIBE = 2085;
    public static final int LAUNCH_SCENE_MINI_CODE_FROM_ALBUM = 1049;
    public static final int LAUNCH_SCENE_MINI_CODE_FROM_LONG_PRESS = 1048;
    public static final int LAUNCH_SCENE_MINI_CODE_FROM_SCAN = 1047;
    public static final int LAUNCH_SCENE_MODIFY_FRIEND_INTERACTIVE_STORAGE = 2218;
    public static final int LAUNCH_SCENE_NAVIGATE_FROM_MINI_APP = 1038;
    public static final int LAUNCH_SCENE_OPEN_BY_MINI_APP = 1037;
    public static final int LAUNCH_SCENE_PROFILE_CARD = 2062;
    public static final int LAUNCH_SCENE_PUBLIC_ACCOUNT_MEMNU = 1035;
    public static final int LAUNCH_SCENE_PUBLIC_ACCOUNT_MESSAGE_CARD = 1074;
    public static final int LAUNCH_SCENE_PUBLIC_ACCOUNT_TEMPLATE_MESSAGE = 1043;
    public static final int LAUNCH_SCENE_QQ_WALLET = 1019;
    public static final int LAUNCH_SCENE_QQ_X_MAN = 2093;
    public static final int LAUNCH_SCENE_QR_CODE_FROM_ALBUM = 1013;
    public static final int LAUNCH_SCENE_QR_CODE_FROM_LONG_PRESS = 1012;
    public static final int LAUNCH_SCENE_QR_CODE_FROM_SCAN = 1011;
    public static final int LAUNCH_SCENE_QUN = 2010;
    public static final int LAUNCH_SCENE_QZONE = 2009;
    public static final int LAUNCH_SCENE_QZONE_FRIEND_PLAYING_NINE = 2092;
    public static final int LAUNCH_SCENE_QZONE_FRIEND_PLAYING_THIRD = 2090;
    public static final int LAUNCH_SCENE_QZONE_SHUOSHUO_LIST = 2060;
    public static final int LAUNCH_SCENE_RECENT_COLOR_NOTE = 1132;
    public static final int LAUNCH_SCENE_SCHEME = 2016;
    public static final int LAUNCH_SCENE_SEARCH = 2005;
    public static final int LAUNCH_SCENE_SEARCH_HAS_USED = 1027;
    public static final int LAUNCH_SCENE_SEARCH_RESULT_FIND = 1006;
    public static final int LAUNCH_SCENE_SEARCH_RESULT_TOP = 1005;
    public static final int LAUNCH_SCENE_SHARE_C2C = 1007;
    public static final int LAUNCH_SCENE_SHARE_GROUP = 1008;
    public static final int LAUNCH_SCENE_SHARE_MESSAGE_TO_FRIEND = 2217;
    public static final int LAUNCH_SCENE_SHARE_OPEN_SDK = 1036;
    public static final int LAUNCH_SCENE_SHARE_QZONE = 2003;
    public static final int LAUNCH_SCENE_SHARE_TICKET = 1044;
    public static final int LAUNCH_SCENE_SPLASH = 2004;
    public static final int LAUNCH_SCENE_STORY_CAMERA_PLAY_SHOW = 2083;
    public static final int LAUNCH_SCENE_TEMPLATE_MESSAGE = 1014;
    public static final int LAUNCH_SCENE_UNKNOWN = 9999;
    public static final int LAUNCH_SCENE_USER_TOP_ENTRY = 1022;
    public static final int LAUNCH_SCENE_WEATHER = 2066;
    public static final int LAUNCH_SCENE_WEBVIEW_HOOK = 2014;
    public static final String LAUNCH_VIA_NEARBY = "5010_1";
    public static final String LAUNCH_VIA_QQ_X_MAN = "2016_4";
    public static final String MINI_APPID_COLLECTION_PAGE = "101495732";
    public static final String SRC_MINI = "biz_src_miniapp";
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
    public boolean isFakeAppInfo;
    public boolean isFlutterMode;
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
    public long timestamp;
    public int scene = 1001;
    public int tempState = 0;
    public int forceReload = 0;
    public boolean skipHotReload = false;
    public boolean isScreenRecordEnabled = false;

    public static boolean isCollectionPage(String str) {
        return "101495732".equals(str);
    }

    private static String standardEntryPath(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        String str3 = "";
        if (indexOf == -1) {
            str2 = "";
        } else {
            String substring = str.substring(0, indexOf);
            str2 = str.substring(indexOf + 1, str.length());
            str = substring;
        }
        if (!str.toLowerCase().endsWith(".html")) {
            str = str + ".html";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        if (!TextUtils.isEmpty(str2)) {
            str3 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        sb5.append(str3);
        return sb5.toString();
    }

    public void clone(LaunchParam launchParam) {
        if (launchParam == null) {
            return;
        }
        this.scene = launchParam.scene;
        this.miniAppId = launchParam.miniAppId;
        this.extraKey = launchParam.extraKey;
        this.entryPath = launchParam.entryPath;
        this.navigateExtData = launchParam.navigateExtData;
        this.fromMiniAppId = launchParam.fromMiniAppId;
        this.launchClickTimeMillis = launchParam.launchClickTimeMillis;
        this.tempState = launchParam.tempState;
        this.timestamp = launchParam.timestamp;
        this.shareTicket = launchParam.shareTicket;
        this.envVersion = launchParam.envVersion;
        this.reportData = launchParam.reportData;
        this.extendData = launchParam.extendData;
        this.entryModel = launchParam.entryModel;
        this.fromBackToMiniApp = launchParam.fromBackToMiniApp;
        this.isFakeAppInfo = launchParam.isFakeAppInfo;
        this.isFlutterMode = launchParam.isFlutterMode;
        this.fromEnvVersion = launchParam.fromEnvVersion;
        this.fromMiniAppInfo = launchParam.fromMiniAppInfo;
        this.privateExtraData = launchParam.privateExtraData;
        this.fileMaterialInfoList = launchParam.fileMaterialInfoList;
        this.forceReload = launchParam.forceReload;
        this.skipHotReload = launchParam.skipHotReload;
        this.isScreenRecordEnabled = launchParam.isScreenRecordEnabled;
        this.spkTaskKey = launchParam.spkTaskKey;
        this.taskId = launchParam.taskId;
        this.taskType = launchParam.taskType;
        this.taskAppId = launchParam.taskAppId;
        this.isCloseGameBox = launchParam.isCloseGameBox;
        this.startupReportData = launchParam.startupReportData;
        this.slotId = launchParam.slotId;
    }

    public void createFrom(Parcel parcel) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        this.scene = parcel.readInt();
        this.miniAppId = parcel.readString();
        this.extraKey = parcel.readString();
        this.entryPath = parcel.readString();
        this.navigateExtData = parcel.readString();
        this.fromMiniAppId = parcel.readString();
        this.launchClickTimeMillis = parcel.readLong();
        this.tempState = parcel.readInt();
        this.timestamp = parcel.readLong();
        this.shareTicket = parcel.readString();
        this.envVersion = parcel.readString();
        this.reportData = parcel.readString();
        this.extendData = parcel.readString();
        this.entryModel = (EntryModel) parcel.readParcelable(EntryModel.class.getClassLoader());
        this.fromBackToMiniApp = parcel.readInt();
        boolean z26 = false;
        if (parcel.readInt() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isFakeAppInfo = z16;
        if (parcel.readInt() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.isFlutterMode = z17;
        this.fromEnvVersion = parcel.readString();
        this.fromMiniAppInfo = (MiniAppInfo) parcel.readParcelable(MiniAppInfo.class.getClassLoader());
        this.privateExtraData = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.fileMaterialInfoList = arrayList;
        parcel.readList(arrayList, MiniAppInfo.class.getClassLoader());
        this.forceReload = parcel.readInt();
        if (parcel.readInt() != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.skipHotReload = z18;
        if (parcel.readInt() != 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.isScreenRecordEnabled = z19;
        this.spkTaskKey = parcel.readString();
        this.taskType = parcel.readInt();
        this.taskId = parcel.readString();
        this.taskAppId = parcel.readString();
        if (parcel.readInt() != 0) {
            z26 = true;
        }
        this.isCloseGameBox = z26;
        this.startupReportData = (StartupReportData) parcel.readParcelable(StartupReportData.class.getClassLoader());
        this.slotId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean fromBackToMiniApp() {
        if (this.fromBackToMiniApp == 1) {
            return true;
        }
        return false;
    }

    public String getScheme() {
        String str = "mqqapi://microapp/open?mini_appid=" + this.miniAppId;
        if (!TextUtils.isEmpty(this.entryPath)) {
            str = str + "&entryPath=" + this.entryPath;
        }
        if (!TextUtils.isEmpty(this.extendData)) {
            return str + "&extraData=" + this.extendData;
        }
        return str;
    }

    public boolean isValid() {
        int i3 = this.scene;
        if (i3 != 1037) {
            if (i3 != 2003) {
                switch (i3) {
                    case 1011:
                    case 1012:
                    case 1013:
                        return !TextUtils.isEmpty(this.fakeUrl);
                    default:
                        if (TextUtils.isEmpty(this.miniAppId) && TextUtils.isEmpty(this.fakeUrl)) {
                            return false;
                        }
                        return true;
                }
            }
            return !TextUtils.isEmpty(this.fakeUrl);
        }
        if (TextUtils.isEmpty(this.miniAppId) || TextUtils.isEmpty(this.fromMiniAppId)) {
            return false;
        }
        return true;
    }

    public void standardize() {
        this.entryPath = standardEntryPath(this.entryPath);
    }

    public String toString() {
        return "LaunchParam{scene=" + this.scene + ", miniAppId='" + this.miniAppId + "', extraKey='" + this.extraKey + "', entryPath='" + this.entryPath + "', extendData='" + this.extendData + "', navigateExtData='" + this.navigateExtData + "', fromMiniAppId='" + this.fromMiniAppId + "', fakeUrl='" + this.fakeUrl + "', timestamp=" + this.timestamp + ", launchClickTimeMillis=" + this.launchClickTimeMillis + ", tempState=" + this.tempState + ", shareTicket=" + this.shareTicket + ", envVersion=" + this.envVersion + ", reportData=" + this.reportData + ", fromBackToMiniApp=" + this.fromBackToMiniApp + ", isFakeAppInfo=" + this.isFakeAppInfo + ", isFlutterMode=" + this.isFlutterMode + ", slotId=" + this.slotId + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        String str;
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
        parcel.writeInt(this.isFakeAppInfo ? 1 : 0);
        parcel.writeInt(this.isFlutterMode ? 1 : 0);
        parcel.writeString(this.fromEnvVersion);
        parcel.writeParcelable(this.fromMiniAppInfo, i3);
        parcel.writeString(this.privateExtraData);
        parcel.writeList(this.fileMaterialInfoList);
        parcel.writeInt(this.forceReload);
        parcel.writeInt(this.skipHotReload ? 1 : 0);
        parcel.writeInt(this.isScreenRecordEnabled ? 1 : 0);
        parcel.writeString(this.spkTaskKey);
        parcel.writeInt(this.taskType);
        parcel.writeString(this.taskId);
        parcel.writeString(this.taskAppId);
        parcel.writeInt(this.isCloseGameBox ? 1 : 0);
        parcel.writeParcelable(this.startupReportData, i3);
        if (TextUtils.isEmpty(this.slotId)) {
            str = "";
        } else {
            str = this.slotId;
        }
        parcel.writeString(str);
    }
}
