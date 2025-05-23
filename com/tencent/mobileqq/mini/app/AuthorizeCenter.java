package com.tencent.mobileqq.mini.app;

import NS_MINI_INTERFACE.INTERFACE$StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE$StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.ApiScopeEntry;
import com.tencent.mobileqq.mini.apkg.ExtConfigInfo;
import com.tencent.mobileqq.mini.apkg.UserAuthScope;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.utils.MiniGameMMKVUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AuthorizeCenter {
    public static final int AUTH_FLAG_FALSE = 4;
    public static final int AUTH_FLAG_NONE = 1;
    public static final int AUTH_FLAG_TRUE = 2;
    public static final String IS_ONCE_SUB_ITEM_MAINTAIN = "once_sub_item_maintain";
    public static final String IS_SYS_SUB_ITEM_MAINTAIN = "sys_sub_item_maintain";
    public static final String KEY_API_NAME = "api_name";
    public static final String KEY_API_NAME_CLICK_ADVERT = "advert_tap";
    public static final String KEY_API_NAME_GET_ADVERT = "webapi_getadvert";
    public static final String KEY_API_NAME_GET_BLOCK_AD = "getBlockAd";
    public static final String KEY_API_NAME_GET_NAVIGATE_WX_APPINFO = "webapi_getnavigatewxaappinfo";
    public static final String KEY_API_NAME_GET_SUBJECT_ALTER_INFO = "getSubjectalterInfo";
    public static final String KEY_API_NAME_GET_USER_INFO = "webapi_getuserinfo";
    public static final String KEY_API_NAME_GET_USER_INFO_OPEN_DATA = "webapi_getuserinfo_opendata";
    public static final String KEY_API_NAME_PLUGIN_GETUSERINFO = "webapi_plugin_getuserinfo";
    public static final String KEY_API_NAME_PLUGIN_LOGIN = "webapi_plugin_login";
    public static final String KEY_API_NAME_PLUGIN_SETAUTH = "webapi_plugin_setauth";
    public static final String KEY_API_NAME_RUN_STEP_HISTORY = "webapi_getwerunstep_history";
    public static final String KEY_API_NAME_WXA_SUBSCRIBE_BIZ = "webapi_wxa_subscribe_biz";
    public static final String KEY_AUTHORITY_SYNCHRONIZED = "authority_synchronized";
    public static final String KEY_AUTH_ROAM_FLAG = "key_auth_roam_flag";
    public static final String KEY_IS_REQUEST_USER_INFO_AUTH_BY_USER = "from_component";
    public static final String SCOPE_ADDRESS = "scope.address";
    public static final String SCOPE_BOOKSHELF_INSERT = "scope.insertBookShelf";
    public static final String SCOPE_CAMERA = "scope.camera";
    public static final String SCOPE_CHANNEL_USER_INFO = "scope.channelUserInfo";
    public static final String SCOPE_CHOOSE_IMAGE = "scope.chooseImage";
    public static final String SCOPE_CHOOSE_MEDIA = "scope.chooseMedia";
    public static final String SCOPE_CHOOSE_MESSAGE_FILE = "scope.chooseMessageFile";
    public static final String SCOPE_CHOOSE_VIDEO = "scope.chooseVideo";
    public static final String SCOPE_CLIP_BOARD = "scope.clipboard";
    public static final String SCOPE_CM_SHOW_INFO = "scope.cmshowInfo";
    public static final String SCOPE_EXPAND_USER_INFO = "scope.expandUserInfo";
    public static final String SCOPE_GET_PHONE_NUMBER = "scope.getPhoneNumber";
    public static final String SCOPE_INVOICE = "scope.invoice";
    public static final String SCOPE_INVOICE_TITLE = "scope.invoiceTitle";
    public static final String SCOPE_JOIN_IP_CHAT = "scope.joinVoIPChat";
    public static final String SCOPE_MAKE_MEDIA = "scope.makeMedia";
    public static final String SCOPE_NEARBY_USER_INFO = "scope.nearbyUserInfo";
    public static final String SCOPE_PERSONALIZE = "scope.personalize";
    public static final String SCOPE_RECENT_COLORSIGN = "scope.recentColorSign";
    public static final String SCOPE_RECORD = "scope.record";
    public static final String SCOPE_SCOPE_GUILD_ROLES = "scope.guildRoles";
    public static final String SCOPE_USER_INFO = "scope.userInfo";
    public static final String SCOPE_USER_LOCATION = "scope.userLocation";
    public static final String SCOPE_WEREN = "scope.qqrun";
    public static final String SCOPE_WRITE_PHOTOS_ALBUM = "scope.writePhotosAlbum";
    public static final String SETTING_ADD_FRIEND = "setting.addFriend";
    public static final String SETTING_APP_INFO_QUERIED = "setting.appInfoQueried";
    public static final String SETTING_APP_MSG_SUBSCRIBED = "setting.appMsgSubscribed";
    public static final String SETTING_APP_ONCE_MSG_SUBSCRIBED = "setting.onceMsgSubscribed";
    public static final String SETTING_SHARE_FRIENDSHIP = "setting.shareFriendship";
    public static final String SETTING_SHARE_PLATRANK = "setting.platRank";
    public static final String SETTING_SYS_MSG_SUBSCRIBED = "setting.sysMsgSubscribed";
    public static final String TAG = "AuthorizeCenter";
    private static ExtConfigInfo extConfigInfo;
    private static volatile String sTempAllowPluginScopeName;
    private int ANTH_DELAY = 60;
    private String appid;

    /* renamed from: sp, reason: collision with root package name */
    private SharedPreferences f246321sp;
    private static String systemPermissionConfig = MiniAppConfProcessor.g(QzoneConfig.SECONDARY_KEY_MINI_APP_SYSTEM_PERMISSION_CONFIG, QzoneConfig.MINI_APP_SYSTEM_PERMISSION_CONFIG);
    private static final HashMap<String, String> scopeMap = new HashMap<>();
    public static final List<String> scopeList = new ArrayList();
    public static final HashMap<String, String> scopeTitleMap = new HashMap<>();
    public static final HashMap<String, String> scopeDescMap = new HashMap<>();
    public static final HashMap<String, String> scopeReportMap = new HashMap<>();
    public static final HashMap<String, String> settingScopeTitleMap = new HashMap<>();
    public static final HashMap<String, String> systemPermissionMap = new HashMap<>();
    public static final HashMap<String, String> negativeButtonDesMap = new HashMap<>();
    private static final HashMap<String, Integer> scopeAuthTypeMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class AuthorizeInfo {
        public int authFlag;
        public String scopeName;

        public AuthorizeInfo(String str, int i3) {
            this.scopeName = str;
            this.authFlag = i3;
        }
    }

    @Deprecated
    public AuthorizeCenter() {
    }

    public static void clearAuth(String str, String str2) {
        QLog.i(TAG, 1, "clear all auth ");
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(str + "_" + str2, 4);
        for (String str3 : scopeMap.values()) {
            if (sharedPreferences.getInt(str3, 1) != 1) {
                sharedPreferences.edit().putInt(str3, 1).commit();
            }
        }
        sharedPreferences.edit().putBoolean("authority_synchronized", true).commit();
    }

    public static String getEventNameByScopeName(String str) {
        for (Map.Entry<String, String> entry : scopeMap.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return "";
    }

    public static String getScopeName(String str, String str2) {
        String str3;
        String str4;
        if ("authorize".equals(str)) {
            String scopeNameByParams = getScopeNameByParams(str2);
            if (isScopeNameValid(scopeNameByParams)) {
                return scopeNameByParams;
            }
        }
        try {
            str3 = new JSONObject(str2).optString("api_name");
        } catch (Throwable unused) {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            str4 = str;
        } else {
            str4 = str + "." + str3;
        }
        String str5 = scopeMap.get(str4);
        return ("operateWXData".equals(str) && TextUtils.isEmpty(str3)) ? handleOperateWXDataScopeName(str2, str5) : str5;
    }

    private static String getScopeNameByParams(String str) {
        try {
            String string = new JSONObject(str).optJSONArray("scope").getString(0);
            return !TextUtils.isEmpty(string) ? string.trim() : string;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public static String getScopePluginSetauthName(String str, String str2) {
        return "scope.plugin.setauth." + str + "." + str2;
    }

    public static String getSystemPermission(String str, String str2) {
        if ("authorize".equals(str)) {
            return systemPermissionMap.get(getEventNameByScopeName(getScopeNameByParams(str2)));
        }
        return systemPermissionMap.get(str);
    }

    private static String handleOperateWXDataScopeName(String str, String str2) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            String optString = optJSONObject.optString("api_name");
            if (!KEY_API_NAME_PLUGIN_LOGIN.equals(optString) && !KEY_API_NAME_PLUGIN_GETUSERINFO.equals(optString)) {
                return str2;
            }
            String optString2 = optJSONObject.optJSONObject("data").optString("miniprogram_appid");
            String optString3 = optJSONObject.optString("plugin_appid");
            return (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) ? str2 : getScopePluginSetauthName(optString2, optString3);
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e(TAG, 2, "handleOperateWXDataScopeName " + th5.getMessage(), th5);
            return str2;
        }
    }

    public static boolean isInScopeList(String str, String str2) {
        return !TextUtils.isEmpty(getScopeName(str, str2));
    }

    public static boolean isScopeNameValid(String str) {
        Iterator<String> it = scopeList.iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAuthList$1(boolean z16, JSONObject jSONObject) {
        if (z16 && jSONObject != null) {
            QLog.d(TAG, 1, "getAuthList success, ret:", jSONObject);
            Object opt = jSONObject.opt("authList");
            if (opt instanceof byte[]) {
                INTERFACE$StGetAuthListRsp iNTERFACE$StGetAuthListRsp = new INTERFACE$StGetAuthListRsp();
                try {
                    iNTERFACE$StGetAuthListRsp.mergeFrom((byte[]) opt);
                    updateAuthList(iNTERFACE$StGetAuthListRsp.auths.get(), iNTERFACE$StGetAuthListRsp.settings.get());
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e(TAG, 1, "getAuthList InvalidProtocolBufferMicroException:", e16);
                    return;
                }
            }
            return;
        }
        QLog.e(TAG, 1, "getAuthList failed");
    }

    private static void mergeExtConfigInfo() {
        String str;
        if (extConfigInfo != null) {
            return;
        }
        String string = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppExtConfigDetail", 4).getString("MiniAppExtConfigDetail", null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            ExtConfigInfo fromJson = ExtConfigInfo.fromJson(new JSONObject(string));
            extConfigInfo = fromJson;
            Iterator<ApiScopeEntry> it = fromJson.apiScopeEntries.iterator();
            while (it.hasNext()) {
                ApiScopeEntry next = it.next();
                if (next != null && !TextUtils.isEmpty(next.eventName) && !TextUtils.isEmpty(next.scope)) {
                    if (TextUtils.isEmpty(next.apiName)) {
                        str = next.eventName;
                    } else {
                        str = next.eventName + "." + next.apiName;
                    }
                    scopeMap.put(str, next.scope);
                    List<String> list = scopeList;
                    if (!list.contains(next.scope)) {
                        list.add(next.scope);
                    }
                }
            }
            Iterator<UserAuthScope> it5 = extConfigInfo.userAuthScopes.iterator();
            while (it5.hasNext()) {
                UserAuthScope next2 = it5.next();
                if (next2 != null && !TextUtils.isEmpty(next2.scope)) {
                    if (!TextUtils.isEmpty(next2.desc)) {
                        scopeTitleMap.put(next2.scope, next2.desc);
                    }
                    if (!TextUtils.isEmpty(next2.settingPageTitle)) {
                        settingScopeTitleMap.put(next2.scope, next2.settingPageTitle);
                    }
                    HashMap<String, String> hashMap = scopeDescMap;
                    if (!hashMap.containsKey(next2.scope)) {
                        hashMap.put(next2.scope, "");
                    }
                    HashMap<String, Integer> hashMap2 = scopeAuthTypeMap;
                    if (!hashMap2.containsKey(next2.scope)) {
                        hashMap2.put(next2.scope, Integer.valueOf(next2.authType));
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "mergeExtConfigInfo error:", e16);
        }
    }

    public static void setAllowPluginScopeName(String str) {
        sTempAllowPluginScopeName = str;
    }

    private static void staticInit() {
        try {
            if (!TextUtils.isEmpty(systemPermissionConfig)) {
                JSONObject jSONObject = new JSONObject(systemPermissionConfig);
                if (jSONObject.length() > 0) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        String optString = jSONObject.optString(str);
                        systemPermissionMap.put(str, optString);
                        QLog.i(TAG, 1, "event : " + str + "; permissionname : " + optString);
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "systemPermissionConfig error", th5);
            HashMap<String, String> hashMap = systemPermissionMap;
            hashMap.put("chooseLocation", "android.permission.ACCESS_FINE_LOCATION");
            hashMap.put("openLocation", "android.permission.ACCESS_FINE_LOCATION");
            hashMap.put("getLocation", "android.permission.ACCESS_FINE_LOCATION");
            hashMap.put("chooseVideo", QQPermissionConstants.Permission.CAMERA);
            hashMap.put("makeMedia", QQPermissionConstants.Permission.CAMERA);
            hashMap.put("chooseImage", QQPermissionConstants.Permission.CAMERA);
            hashMap.put("saveImageToPhotosAlbum", QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
            hashMap.put("saveVideoToPhotosAlbum", QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
            hashMap.put("startRecord", QQPermissionConstants.Permission.RECORD_AUDIO);
            hashMap.put("operateRecorder", QQPermissionConstants.Permission.RECORD_AUDIO);
            hashMap.put(PluginConst.VoIPPluginConst.API_JOIN_IP_CHAT, QQPermissionConstants.Permission.RECORD_AUDIO);
            hashMap.put("operateCamera", QQPermissionConstants.Permission.CAMERA);
            hashMap.put("updateCamera", QQPermissionConstants.Permission.CAMERA);
        }
        HashMap<String, String> hashMap2 = scopeMap;
        hashMap2.put("chooseLocation", SCOPE_USER_LOCATION);
        hashMap2.put("getLocation", SCOPE_USER_LOCATION);
        hashMap2.put("saveImageToPhotosAlbum", SCOPE_WRITE_PHOTOS_ALBUM);
        hashMap2.put("saveVideoToPhotosAlbum", SCOPE_WRITE_PHOTOS_ALBUM);
        hashMap2.put("startRecord", SCOPE_RECORD);
        hashMap2.put("operateWXData", SCOPE_USER_INFO);
        hashMap2.put("chooseInvoiceTitle", SCOPE_INVOICE_TITLE);
        hashMap2.put("chooseInvoice", SCOPE_INVOICE);
        hashMap2.put("openAddress", SCOPE_ADDRESS);
        hashMap2.put("openWeRunSetting", SCOPE_WEREN);
        hashMap2.put(PluginConst.DataJsPluginConst.API_GET_NATIVE_WERUN_DATA, SCOPE_WEREN);
        hashMap2.put(PluginConst.SubscribeJsPluginConst.API_SUBSCRIBE_APP_MSG, "setting.appMsgSubscribed");
        hashMap2.put(PluginConst.SubscribeJsPluginConst.API_SUBSCRIBE_ONCE_APP_MSG, "setting.onceMsgSubscribed");
        hashMap2.put(PluginConst.SubscribeJsPluginConst.API_SUBSCRIBE_SYS_MSG, "setting.sysMsgSubscribed");
        hashMap2.put("insertCamera", SCOPE_CAMERA);
        hashMap2.put("Personalize", SCOPE_PERSONALIZE);
        hashMap2.put("getPhoneNumber", SCOPE_GET_PHONE_NUMBER);
        hashMap2.put(PluginConst.DataJsPluginConst.API_BOOKSHELF_INSERT, SCOPE_BOOKSHELF_INSERT);
        hashMap2.put(PluginConst.CMShowJsPluginConst.API_GET_CM_SHOW_INFO, SCOPE_CM_SHOW_INFO);
        hashMap2.put("addRecentColorSign", SCOPE_RECENT_COLORSIGN);
        hashMap2.put(PluginConst.ExpandJsPluginConst.API_GET_GET_EXPAND_USER_INFO, SCOPE_EXPAND_USER_INFO);
        hashMap2.put(PluginConst.ChannelJsPluginConst.API_GET_CHANNEL_USER_INFO, SCOPE_CHANNEL_USER_INFO);
        hashMap2.put(PluginConst.NearbyJsPluginConst.API_GET_GET_NEARBY_USER_INFO, SCOPE_NEARBY_USER_INFO);
        hashMap2.put(PluginConst.OtherJsPluginConst.API_QUERY_APP_INFO, SETTING_APP_INFO_QUERIED);
        hashMap2.put(PluginConst.OtherJsPluginConst.API_GUILD_ROLES, SCOPE_SCOPE_GUILD_ROLES);
        List<String> list = scopeList;
        list.add(SCOPE_USER_LOCATION);
        list.add(SCOPE_USER_INFO);
        list.add(SCOPE_ADDRESS);
        list.add(SCOPE_INVOICE_TITLE);
        list.add(SCOPE_INVOICE);
        list.add(SCOPE_WEREN);
        list.add(SCOPE_RECORD);
        list.add(SCOPE_WRITE_PHOTOS_ALBUM);
        list.add(SCOPE_CAMERA);
        list.add(SCOPE_PERSONALIZE);
        list.add("setting.appMsgSubscribed");
        list.add("setting.addFriend");
        list.add("setting.shareFriendship");
        list.add(SETTING_SHARE_PLATRANK);
        list.add(SCOPE_GET_PHONE_NUMBER);
        list.add(SCOPE_BOOKSHELF_INSERT);
        list.add(SCOPE_CM_SHOW_INFO);
        list.add(SCOPE_RECENT_COLORSIGN);
        list.add(SCOPE_EXPAND_USER_INFO);
        list.add(SCOPE_CHANNEL_USER_INFO);
        list.add(SCOPE_NEARBY_USER_INFO);
        list.add(SETTING_APP_INFO_QUERIED);
        list.add(SCOPE_SCOPE_GUILD_ROLES);
        list.add(SCOPE_CLIP_BOARD);
        list.add(SCOPE_CHOOSE_IMAGE);
        list.add(SCOPE_CHOOSE_VIDEO);
        list.add(SCOPE_MAKE_MEDIA);
        list.add(SCOPE_CHOOSE_MEDIA);
        list.add(SCOPE_CHOOSE_MESSAGE_FILE);
        list.add(SCOPE_JOIN_IP_CHAT);
        HashMap<String, String> hashMap3 = scopeTitleMap;
        hashMap3.put(SCOPE_USER_LOCATION, HardCodeUtil.qqStr(R.string.f171622jt4));
        hashMap3.put(SCOPE_USER_INFO, HardCodeUtil.qqStr(R.string.f171621jt3));
        hashMap3.put(SCOPE_ADDRESS, HardCodeUtil.qqStr(R.string.jt_));
        hashMap3.put(SCOPE_INVOICE_TITLE, HardCodeUtil.qqStr(R.string.jte));
        hashMap3.put(SCOPE_INVOICE, "\u83b7\u53d6\u4f60\u7684\u53d1\u7968\u4fe1\u606f");
        hashMap3.put(SCOPE_WEREN, HardCodeUtil.qqStr(R.string.iun));
        hashMap3.put(SCOPE_RECORD, HardCodeUtil.qqStr(R.string.jtf));
        hashMap3.put(SCOPE_WRITE_PHOTOS_ALBUM, HardCodeUtil.qqStr(R.string.jth));
        hashMap3.put(SCOPE_CAMERA, HardCodeUtil.qqStr(R.string.jtn));
        hashMap3.put(SCOPE_PERSONALIZE, HardCodeUtil.qqStr(R.string.jtb));
        hashMap3.put("setting.appMsgSubscribed", HardCodeUtil.qqStr(R.string.jtr));
        hashMap3.put("setting.addFriend", HardCodeUtil.qqStr(R.string.jtp));
        hashMap3.put("setting.shareFriendship", HardCodeUtil.qqStr(R.string.f211745ln));
        hashMap3.put(SETTING_SHARE_PLATRANK, HardCodeUtil.qqStr(R.string.f211775lq));
        hashMap3.put(SCOPE_GET_PHONE_NUMBER, HardCodeUtil.qqStr(R.string.ium));
        hashMap3.put(SCOPE_BOOKSHELF_INSERT, HardCodeUtil.qqStr(R.string.f167162c7));
        hashMap3.put(SCOPE_CM_SHOW_INFO, HardCodeUtil.qqStr(R.string.f167202ca));
        hashMap3.put(SCOPE_RECENT_COLORSIGN, HardCodeUtil.qqStr(R.string.f167332cn));
        hashMap3.put(SCOPE_EXPAND_USER_INFO, HardCodeUtil.qqStr(R.string.f167272ch));
        hashMap3.put(SCOPE_CHANNEL_USER_INFO, HardCodeUtil.qqStr(R.string.f167182c9));
        hashMap3.put(SCOPE_NEARBY_USER_INFO, HardCodeUtil.qqStr(R.string.f167312cl));
        hashMap3.put(SETTING_APP_INFO_QUERIED, HardCodeUtil.qqStr(R.string.f167142c5));
        HashMap<String, String> hashMap4 = scopeDescMap;
        hashMap4.put(SCOPE_USER_LOCATION, "");
        hashMap4.put(SCOPE_USER_INFO, HardCodeUtil.qqStr(R.string.iul));
        hashMap4.put(SCOPE_ADDRESS, "");
        hashMap4.put(SCOPE_INVOICE_TITLE, "");
        hashMap4.put(SCOPE_INVOICE, "");
        hashMap4.put(SCOPE_WEREN, "");
        hashMap4.put(SCOPE_RECORD, "");
        hashMap4.put(SCOPE_WRITE_PHOTOS_ALBUM, "");
        hashMap4.put(SCOPE_CAMERA, "");
        hashMap4.put(SCOPE_PERSONALIZE, "");
        hashMap4.put("setting.appMsgSubscribed", HardCodeUtil.qqStr(R.string.jta));
        hashMap4.put("setting.addFriend", "");
        hashMap4.put("setting.shareFriendship", HardCodeUtil.qqStr(R.string.f211725ll));
        hashMap4.put(SETTING_SHARE_PLATRANK, HardCodeUtil.qqStr(R.string.f211755lo));
        hashMap4.put(SCOPE_GET_PHONE_NUMBER, "");
        hashMap4.put(SCOPE_BOOKSHELF_INSERT, HardCodeUtil.qqStr(R.string.f167172c8));
        hashMap4.put(SCOPE_CM_SHOW_INFO, HardCodeUtil.qqStr(R.string.f167262cg));
        hashMap4.put(SCOPE_RECENT_COLORSIGN, HardCodeUtil.qqStr(R.string.f167342co));
        hashMap4.put(SCOPE_EXPAND_USER_INFO, HardCodeUtil.qqStr(R.string.f167282ci));
        hashMap4.put(SCOPE_CHANNEL_USER_INFO, HardCodeUtil.qqStr(R.string.f167192c_));
        hashMap4.put(SCOPE_NEARBY_USER_INFO, HardCodeUtil.qqStr(R.string.f167322cm));
        hashMap4.put(SETTING_APP_INFO_QUERIED, HardCodeUtil.qqStr(R.string.f167152c6));
        HashMap<String, String> hashMap5 = scopeReportMap;
        hashMap5.put(SCOPE_USER_LOCATION, "userLocation");
        hashMap5.put(SCOPE_USER_INFO, "userinfo");
        hashMap5.put(SCOPE_ADDRESS, "chooseAddress");
        hashMap5.put(SCOPE_INVOICE_TITLE, "invoiceTitle");
        hashMap5.put(SCOPE_INVOICE, "invoice");
        hashMap5.put(SCOPE_WEREN, "qqrun");
        hashMap5.put(SCOPE_RECORD, QQPermissionConstants.Permission.AUIDO_GROUP);
        hashMap5.put(SCOPE_WRITE_PHOTOS_ALBUM, "writePhotosAlbum");
        hashMap5.put(SCOPE_CAMERA, "camera");
        hashMap5.put(SCOPE_PERSONALIZE, "personalize");
        hashMap5.put("setting.appMsgSubscribed", MiniProgramLpReportDC04239.MINI_GAME_SUB_ACTION_APP_MSG_SUBSCRIBED);
        hashMap5.put("setting.addFriend", QQFriendJsPlugin.API_ADD_FRIEND);
        hashMap5.put("setting.shareFriendship", "shareFriendship");
        hashMap5.put(SETTING_SHARE_PLATRANK, "platRank");
        hashMap5.put(SCOPE_GET_PHONE_NUMBER, "getphonenumber");
        hashMap5.put("setting.onceMsgSubscribed", MiniProgramLpReportDC04239.MINI_GAME_SUB_ACTION_ONCE_MSG_SUBSCRIBED);
        hashMap5.put(SCOPE_BOOKSHELF_INSERT, "insertBookShelf");
        hashMap5.put(SCOPE_CM_SHOW_INFO, "cmshowInfo");
        hashMap5.put(SCOPE_RECENT_COLORSIGN, "addRecentColorSign");
        hashMap5.put(SCOPE_EXPAND_USER_INFO, PluginConst.ExpandJsPluginConst.API_GET_GET_EXPAND_USER_INFO);
        hashMap5.put(SCOPE_CHANNEL_USER_INFO, PluginConst.ChannelJsPluginConst.API_GET_CHANNEL_USER_INFO);
        hashMap5.put(SCOPE_NEARBY_USER_INFO, PluginConst.NearbyJsPluginConst.API_GET_GET_NEARBY_USER_INFO);
        hashMap5.put(SETTING_APP_INFO_QUERIED, PluginConst.OtherJsPluginConst.API_QUERY_APP_INFO);
        HashMap<String, String> hashMap6 = settingScopeTitleMap;
        hashMap6.put(SCOPE_USER_LOCATION, HardCodeUtil.qqStr(R.string.jt5));
        hashMap6.put(SCOPE_USER_INFO, HardCodeUtil.qqStr(R.string.jt6));
        hashMap6.put(SCOPE_ADDRESS, HardCodeUtil.qqStr(R.string.f171619jt1));
        hashMap6.put(SCOPE_INVOICE_TITLE, HardCodeUtil.qqStr(R.string.jtl));
        hashMap6.put(SCOPE_INVOICE, "\u53d1\u7968\u4fe1\u606f");
        hashMap6.put(SCOPE_WEREN, HardCodeUtil.qqStr(R.string.f171620jt2));
        hashMap6.put(SCOPE_RECORD, HardCodeUtil.qqStr(R.string.jtm));
        hashMap6.put(SCOPE_WRITE_PHOTOS_ALBUM, HardCodeUtil.qqStr(R.string.jts));
        hashMap6.put(SCOPE_CAMERA, HardCodeUtil.qqStr(R.string.jtd));
        hashMap6.put(SCOPE_PERSONALIZE, HardCodeUtil.qqStr(R.string.jt7));
        hashMap6.put("setting.appMsgSubscribed", HardCodeUtil.qqStr(R.string.f167292cj));
        hashMap6.put("setting.addFriend", HardCodeUtil.qqStr(R.string.jtq));
        hashMap6.put("setting.shareFriendship", HardCodeUtil.qqStr(R.string.f211735lm));
        hashMap6.put(SETTING_SHARE_PLATRANK, HardCodeUtil.qqStr(R.string.f211765lp));
        hashMap6.put(SCOPE_CM_SHOW_INFO, HardCodeUtil.qqStr(R.string.f167262cg));
        hashMap6.put(SCOPE_BOOKSHELF_INSERT, HardCodeUtil.qqStr(R.string.f167422cw));
        hashMap6.put(SCOPE_RECENT_COLORSIGN, HardCodeUtil.qqStr(R.string.f167432cx));
        hashMap6.put(SCOPE_EXPAND_USER_INFO, HardCodeUtil.qqStr(R.string.f167272ch));
        hashMap6.put(SCOPE_CHANNEL_USER_INFO, HardCodeUtil.qqStr(R.string.f167182c9));
        hashMap6.put(SCOPE_NEARBY_USER_INFO, HardCodeUtil.qqStr(R.string.f167312cl));
        hashMap6.put(SETTING_APP_INFO_QUERIED, HardCodeUtil.qqStr(R.string.f167142c5));
        hashMap6.put(SCOPE_SCOPE_GUILD_ROLES, HardCodeUtil.qqStr(R.string.f167302ck));
        hashMap6.put(SCOPE_CLIP_BOARD, HardCodeUtil.qqStr(R.string.f167632dg));
        hashMap6.put(SCOPE_CHOOSE_IMAGE, HardCodeUtil.qqStr(R.string.f167592dc));
        hashMap6.put(SCOPE_CHOOSE_VIDEO, HardCodeUtil.qqStr(R.string.f167622df));
        hashMap6.put(SCOPE_MAKE_MEDIA, HardCodeUtil.qqStr(R.string.f167652di));
        hashMap6.put(SCOPE_CHOOSE_MEDIA, HardCodeUtil.qqStr(R.string.f167602dd));
        hashMap6.put(SCOPE_CHOOSE_MESSAGE_FILE, HardCodeUtil.qqStr(R.string.f167612de));
        hashMap6.put(SCOPE_JOIN_IP_CHAT, HardCodeUtil.qqStr(R.string.f167642dh));
        hashMap6.put(SCOPE_GET_PHONE_NUMBER, HardCodeUtil.qqStr(R.string.ium));
        negativeButtonDesMap.put("setting.appMsgSubscribed", HardCodeUtil.qqStr(R.string.jtg));
        mergeExtConfigInfo();
    }

    private static void updateScopeDescriptionMap(String str, JSONObject jSONObject) {
        if (jSONObject.has(str)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject.has("desc")) {
                scopeDescMap.put(str, optJSONObject.optString("desc"));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009a, code lost:
    
        if (com.tencent.mobileqq.mini.app.AuthorizeCenter.sTempAllowPluginScopeName.equals(getScopePluginSetauthName(r6, r5)) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getAuthFlag(String str, String str2) {
        String scopeName = getScopeName(str, str2);
        if (TextUtils.isEmpty(scopeName)) {
            return 2;
        }
        if ("operateWXData".equals(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject("data");
                String optString = optJSONObject.optString("api_name");
                if (!KEY_API_NAME_GET_USER_INFO_OPEN_DATA.equals(optString) && !KEY_API_NAME_GET_ADVERT.equals(optString) && !KEY_API_NAME_RUN_STEP_HISTORY.equals(optString) && !KEY_API_NAME_CLICK_ADVERT.equals(optString) && !KEY_API_NAME_GET_BLOCK_AD.equals(optString) && !KEY_API_NAME_GET_NAVIGATE_WX_APPINFO.equals(optString) && !KEY_API_NAME_PLUGIN_SETAUTH.equals(optString)) {
                    if (KEY_API_NAME_PLUGIN_LOGIN.equals(optString) || KEY_API_NAME_PLUGIN_GETUSERINFO.equals(optString)) {
                        String optString2 = optJSONObject.optJSONObject("data").optString("miniprogram_appid");
                        String optString3 = optJSONObject.optString("plugin_appid");
                        if (sTempAllowPluginScopeName != null) {
                        }
                    }
                }
                return 2;
            } catch (Throwable unused) {
            }
        }
        return this.f246321sp.getInt(scopeName, 1);
    }

    public int getAuthFlagFromAuthorize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        return this.f246321sp.getInt(str, 1);
    }

    public List<AuthorizeInfo> getAuthorizeList(int i3) {
        ArrayList arrayList = new ArrayList();
        for (String str : scopeList) {
            Integer num = scopeAuthTypeMap.get(str);
            if (num == null || num.intValue() != 1) {
                int i16 = this.f246321sp.getInt(str, 1);
                if (i16 == 2) {
                    if ((i3 & 2) == 2) {
                        arrayList.add(new AuthorizeInfo(str, 2));
                    }
                } else if (i16 == 1) {
                    if ((i3 & 1) == 1) {
                        arrayList.add(new AuthorizeInfo(str, 1));
                    }
                } else if ((i3 & 4) == 4) {
                    arrayList.add(new AuthorizeInfo(str, 4));
                }
            }
        }
        return arrayList;
    }

    public boolean isAuthorizeSynchronized() {
        return this.f246321sp.getBoolean("authority_synchronized", false);
    }

    public boolean isOnceSubMaintain() {
        return this.f246321sp.getBoolean("once_sub_item_maintain", false);
    }

    public boolean isSystemSubscribeMaintain() {
        return this.f246321sp.getBoolean("sys_sub_item_maintain", false);
    }

    public void setAuthorize(String str, boolean z16) {
        setAuthorize(str, z16, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.app.AuthorizeCenter.1
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z17, JSONObject jSONObject) {
                if (QLog.isColorLevel()) {
                    QLog.e(AuthorizeCenter.TAG, 2, "setAuthorize() onCmdListener isSuccess: " + z17 + "   ; ret: " + jSONObject);
                }
            }
        });
    }

    public void setAuthorizeSynchronized() {
        this.f246321sp.edit().putBoolean("authority_synchronized", true).commit();
    }

    public boolean shouldAskEveryTime(String str, String str2) {
        Integer num;
        String scopeName = getScopeName(str, str2);
        return (TextUtils.isEmpty(scopeName) || (num = scopeAuthTypeMap.get(scopeName)) == null || num.intValue() != 1) ? false : true;
    }

    public void updateAuth(String str, boolean z16) {
        SharedPreferences sharedPreferences = this.f246321sp;
        if (sharedPreferences == null) {
            return;
        }
        if (z16) {
            sharedPreferences.edit().putInt(str, 2).commit();
        } else {
            sharedPreferences.edit().putInt(str, 4).commit();
        }
    }

    public void updateIsOnceSubMsgMaintain(boolean z16) {
        this.f246321sp.edit().putBoolean("once_sub_item_maintain", z16).apply();
    }

    public void updateIsSysSubMsgMaintain(boolean z16) {
        this.f246321sp.edit().putBoolean("sys_sub_item_maintain", z16).apply();
    }

    public void updateOnceSubMsgSetting(String str, boolean z16, List<INTERFACE$StSubscribeMessage> list, final MiniAppCmdInterface miniAppCmdInterface) {
        INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo = new INTERFACE$StUserSettingInfo();
        iNTERFACE$StUserSettingInfo.settingItem.set(str);
        String str2 = scopeTitleMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            iNTERFACE$StUserSettingInfo.desc.set(str2);
        }
        iNTERFACE$StUserSettingInfo.authState.set(z16 ? 1 : 2);
        iNTERFACE$StUserSettingInfo.subItems.set(list);
        MiniAppCmdUtil.getInstance().updateUserSetting(null, this.appid, iNTERFACE$StUserSettingInfo, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.app.AuthorizeCenter.2
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z17, JSONObject jSONObject) {
                MiniAppCmdInterface miniAppCmdInterface2 = miniAppCmdInterface;
                if (miniAppCmdInterface2 != null) {
                    miniAppCmdInterface2.onCmdListener(z17, jSONObject);
                }
            }
        });
    }

    private void getAuthList(String str) {
        QLog.d(TAG, 1, "getAuthList appId:", str);
        MiniAppCmdUtil.getInstance().getAuthList(null, str, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.app.b
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                AuthorizeCenter.this.lambda$getAuthList$1(z16, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$roamAuthState$0(String str, String str2, boolean z16, JSONObject jSONObject) {
        QLog.d(TAG, 1, "roamAuthState isSuc:", Boolean.valueOf(z16), ", ret:", jSONObject);
        if (z16) {
            MiniGameMMKVUtils.INSTANCE.saveBool(str, true);
            getAuthList(str2);
        }
    }

    public void setAuthorize(String str, boolean z16, final MiniAppCmdInterface miniAppCmdInterface) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f246321sp.edit().putInt(str, z16 ? 2 : 4).commit();
        if (str.startsWith("setting")) {
            INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo = new INTERFACE$StUserSettingInfo();
            iNTERFACE$StUserSettingInfo.settingItem.set(str);
            String str2 = scopeTitleMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                iNTERFACE$StUserSettingInfo.desc.set(str2);
            }
            iNTERFACE$StUserSettingInfo.authState.set(z16 ? 1 : 2);
            MiniAppCmdUtil.getInstance().updateUserSetting(null, this.appid, iNTERFACE$StUserSettingInfo, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.app.AuthorizeCenter.3
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z17, JSONObject jSONObject) {
                    if (QLog.isColorLevel()) {
                        QLog.e(AuthorizeCenter.TAG, 2, "updateUserSetting() onCmdListener isSuccess: " + z17 + "   ; ret: " + jSONObject);
                    }
                    MiniAppCmdInterface miniAppCmdInterface2 = miniAppCmdInterface;
                    if (miniAppCmdInterface2 != null) {
                        miniAppCmdInterface2.onCmdListener(z17, jSONObject);
                    }
                }
            });
            return;
        }
        INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo = new INTERFACE$StUserAuthInfo();
        iNTERFACE$StUserAuthInfo.scope.set(str);
        String str3 = scopeTitleMap.get(str);
        if (!TextUtils.isEmpty(str3)) {
            iNTERFACE$StUserAuthInfo.desc.set(str3);
        }
        iNTERFACE$StUserAuthInfo.authState.set(z16 ? 1 : 2);
        MiniAppCmdUtil.getInstance().setAuth(null, this.appid, iNTERFACE$StUserAuthInfo, miniAppCmdInterface);
    }

    public AuthorizeCenter(String str, String str2) {
        this.f246321sp = BaseApplicationImpl.getApplication().getSharedPreferences(str + "_" + str2, 4);
        this.appid = str;
        HashMap<String, String> hashMap = scopeMap;
        if (hashMap == null || hashMap.size() == 0) {
            staticInit();
        }
    }

    public static void updateScopeDescription(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Iterator<Map.Entry<String, String>> it = scopeDescMap.entrySet().iterator();
        while (it.hasNext()) {
            updateScopeDescriptionMap(it.next().getKey(), jSONObject);
        }
    }

    public void updateAuthSettingItem(List<INTERFACE$StUserSettingInfo> list) {
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo = list.get(i3);
                String str = iNTERFACE$StUserSettingInfo.settingItem.get();
                if ("setting.onceMsgSubscribed".equals(str)) {
                    updateIsOnceSubMsgMaintain(!iNTERFACE$StUserSettingInfo.subItems.get().isEmpty());
                } else if ("setting.sysMsgSubscribed".equals(str)) {
                    updateIsSysSubMsgMaintain(!iNTERFACE$StUserSettingInfo.subItems.get().isEmpty());
                } else if ("setting.appMsgSubscribed".equals(str) && iNTERFACE$StUserSettingInfo.subItems.get().isEmpty()) {
                    this.f246321sp.edit().putInt(str, 1).commit();
                } else if ("setting.appMsgSubscribed".equals(str)) {
                    this.f246321sp.edit().putInt(str, 2).commit();
                }
            }
        }
    }

    public void roamAuthState(final String str) {
        char c16 = 0;
        QLog.d(TAG, 1, "roamAuthState appId:", str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(TAG, 1, "roamAuthState appRuntime null");
            return;
        }
        final String str2 = "key_auth_roam_flag_" + peekAppRuntime.getCurrentUin() + "_" + str;
        if (MiniGameMMKVUtils.INSTANCE.getBool(str2)) {
            QLog.i(TAG, 1, "roamAuthState done before");
            getAuthList(str);
            return;
        }
        if (this.f246321sp == null) {
            QLog.e(TAG, 1, "roamAuthState sp null");
            return;
        }
        ArrayList<INTERFACE$StUserAuthInfo> arrayList = new ArrayList<>();
        try {
            Map<String, ?> all = this.f246321sp.getAll();
            int i3 = 4;
            if (all != null) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String key = entry.getKey();
                    if (key.startsWith("scope")) {
                        int intValue = ((Integer) entry.getValue()).intValue();
                        Object[] objArr = new Object[4];
                        objArr[c16] = "roamAuthState scope:";
                        objArr[1] = key;
                        objArr[2] = ", flag:";
                        objArr[3] = Integer.valueOf(intValue);
                        QLog.d(TAG, 1, objArr);
                        if (intValue != 1) {
                            INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo = new INTERFACE$StUserAuthInfo();
                            iNTERFACE$StUserAuthInfo.scope.set(key);
                            iNTERFACE$StUserAuthInfo.authState.set(intValue == 2 ? 1 : 2);
                            arrayList.add(iNTERFACE$StUserAuthInfo);
                        }
                    }
                    c16 = 0;
                }
            } else {
                QLog.w(TAG, 1, "roamAuthState allEntries null");
                for (String str3 : scopeList) {
                    if (str3.startsWith("scope") && this.f246321sp.contains(str3)) {
                        int i16 = this.f246321sp.getInt(str3, 1);
                        Object[] objArr2 = new Object[i3];
                        objArr2[0] = "roamAuthState scope:";
                        objArr2[1] = str3;
                        objArr2[2] = ", flag:";
                        objArr2[3] = Integer.valueOf(i16);
                        QLog.d(TAG, 1, objArr2);
                        if (i16 != 1) {
                            INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo2 = new INTERFACE$StUserAuthInfo();
                            iNTERFACE$StUserAuthInfo2.scope.set(str3);
                            iNTERFACE$StUserAuthInfo2.authState.set(i16 == 2 ? 1 : 2);
                            arrayList.add(iNTERFACE$StUserAuthInfo2);
                        }
                    }
                    i3 = 4;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "roamAuthState exception:", e16);
        }
        if (arrayList.size() > 0) {
            MiniAppCmdUtil.getInstance().setAuths(null, this.appid, arrayList, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.app.a
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    AuthorizeCenter.this.lambda$roamAuthState$0(str2, str, z16, jSONObject);
                }
            });
        } else {
            getAuthList(str);
        }
    }

    public void updateAuthList(List<INTERFACE$StUserAuthInfo> list, List<INTERFACE$StUserSettingInfo> list2) {
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo = list.get(i3);
                String str = iNTERFACE$StUserAuthInfo.scope.get();
                int i16 = iNTERFACE$StUserAuthInfo.authState.get();
                if (i16 == 1) {
                    this.f246321sp.edit().putInt(str, 2).commit();
                } else if (i16 == 2) {
                    this.f246321sp.edit().putInt(str, 4).commit();
                }
            }
        }
        if (list2 != null) {
            for (int i17 = 0; i17 < list2.size(); i17++) {
                INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo = list2.get(i17);
                String str2 = iNTERFACE$StUserSettingInfo.settingItem.get();
                int i18 = iNTERFACE$StUserSettingInfo.authState.get();
                if (i18 == 1) {
                    this.f246321sp.edit().putInt(str2, 2).commit();
                } else if (i18 == 2) {
                    this.f246321sp.edit().putInt(str2, 4).commit();
                }
            }
        }
    }
}
