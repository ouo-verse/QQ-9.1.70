package com.tencent.mobileqq.qwallet.hb.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HbThemeConfigApiImpl implements IHbThemeConfigApi {
    private static final String HB_THEME_CONFIG_FILE_NAME = "hbThemeConfig.cfg";
    private static final String TAG = "HbThemeConfigApi";
    private static String mConfigCache;
    private static byte[] mLock = new byte[0];

    /* JADX INFO: Access modifiers changed from: private */
    public String getSaveDir() {
        return ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getQWalletInternalPath() + com.tencent.mobileqq.base.a.c() + File.separator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x066f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0603  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void lambda$handleQWalletSettingConfig$0(String str, ConfigurationService$Config configurationService$Config) {
        int i3;
        String str2;
        String str3;
        String str4;
        String str5;
        HashMap hashMap;
        int i16;
        int i17;
        String str6;
        int i18;
        int i19;
        int i26;
        String str7;
        IQWalletPreferenceApi iQWalletPreferenceApi;
        int i27;
        String str8;
        String str9;
        String str10;
        HashMap hashMap2;
        String str11;
        String str12;
        String str13;
        String str14;
        JSONObject jSONObject;
        Iterator keys;
        Iterator it;
        String str15;
        String str16;
        long convertStringToTime;
        long convertStringToTime2;
        String str17;
        IQWalletPreferenceApi iQWalletPreferenceApi2;
        ConfigurationService$Config configurationService$Config2 = configurationService$Config;
        IQWalletPreferenceApi iQWalletPreferenceApi3 = (IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class);
        HashMap hashMap3 = new HashMap(8);
        int qWalletSettingConfigVersion = getQWalletSettingConfigVersion(MobileQQ.sMobileQQ, str);
        if (configurationService$Config2 != null) {
            i3 = configurationService$Config2.version.get();
        } else {
            i3 = 0;
        }
        String str18 = IQWalletPreferenceApi.KEY_BIRTHDAY_HB_WISH_MAX_LEN;
        String str19 = IQWalletPreferenceApi.KEY_BIRTHDAY_HB_WISH_PLACEHOLDER;
        HashMap hashMap4 = hashMap3;
        String str20 = "PopWndID";
        String str21 = "strangerchat_ext";
        String str22 = "skin_entry_error_tips";
        IQWalletPreferenceApi iQWalletPreferenceApi4 = iQWalletPreferenceApi3;
        if (configurationService$Config2 != null && i3 != qWalletSettingConfigVersion) {
            try {
                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).removeSp(str, IQWalletPreferenceApi.KEY_WALLET_APPLIST_CONFIG_NUM_COLS);
                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).removeSp(str, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_BUSI_TYPE);
                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).removeSp(str, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_IMG_URL);
                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).removeSp(str, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_TITLE);
                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).removeSp(str, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_JUMP_URL);
                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).removeSp(str, IQWalletPreferenceApi.KEY_BIRTHDAY_HB_WISH_PLACEHOLDER);
                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).removeSp(str, IQWalletPreferenceApi.KEY_BIRTHDAY_HB_WISH_MAX_LEN);
                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).removeSp(str, IQWalletPreferenceApi.KEY_BIRTHDAY_HB_THEME_LIST);
                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).removeSp(str, IQWalletPreferenceApi.KEY_BIRTHDAY_HB_SKIN_LIST);
                str2 = IQWalletPreferenceApi.KEY_BIRTHDAY_HB_SKIN_LIST;
                iQWalletPreferenceApi2 = iQWalletPreferenceApi4;
                try {
                    iQWalletPreferenceApi2.clearSp(str);
                } catch (Exception e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        iQWalletPreferenceApi4 = iQWalletPreferenceApi2;
                        str3 = IQWalletPreferenceApi.KEY_BIRTHDAY_HB_THEME_LIST;
                        QLog.e(TAG, 2, "clear QWALLET_SETTING_CONFIG error", e);
                        String str23 = "";
                        if (configurationService$Config2 == null) {
                        }
                        int i28 = i3;
                        str4 = "received QWALLET_SETTING_CONFIG error";
                        str5 = "";
                        hashMap = hashMap4;
                        if (QLog.isColorLevel()) {
                        }
                        if (configurationService$Config == null) {
                        }
                    }
                    iQWalletPreferenceApi4 = iQWalletPreferenceApi2;
                    str3 = IQWalletPreferenceApi.KEY_BIRTHDAY_HB_THEME_LIST;
                    String str232 = "";
                    if (configurationService$Config2 == null) {
                    }
                    int i282 = i3;
                    str4 = "received QWALLET_SETTING_CONFIG error";
                    str5 = "";
                    hashMap = hashMap4;
                    if (QLog.isColorLevel()) {
                    }
                    if (configurationService$Config == null) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                str2 = IQWalletPreferenceApi.KEY_BIRTHDAY_HB_SKIN_LIST;
                iQWalletPreferenceApi2 = iQWalletPreferenceApi4;
            }
            iQWalletPreferenceApi4 = iQWalletPreferenceApi2;
        } else {
            str2 = IQWalletPreferenceApi.KEY_BIRTHDAY_HB_SKIN_LIST;
        }
        str3 = IQWalletPreferenceApi.KEY_BIRTHDAY_HB_THEME_LIST;
        String str2322 = "";
        if (configurationService$Config2 == null && i3 != qWalletSettingConfigVersion) {
            String str24 = "received QWALLET_SETTING_CONFIG error";
            if (QLog.isColorLevel()) {
                i18 = qWalletSettingConfigVersion;
                QLog.d(TAG, 2, String.format("qwallet config update %s -> %s", Integer.valueOf(qWalletSettingConfigVersion), Integer.valueOf(i3)));
            } else {
                i18 = qWalletSettingConfigVersion;
            }
            if (configurationService$Config2.content_list.isEmpty()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "receiveAllConfigs|type: QWALLET_SETTING_CONFIG ,content_list is empty ,version: " + i3);
                    return;
                }
                return;
            }
            int size = configurationService$Config2.content_list.size();
            int i29 = 0;
            while (i29 < size) {
                String str25 = configurationService$Config2.content_list.get(i29);
                if (QLog.isColorLevel()) {
                    i19 = size;
                    StringBuilder sb5 = new StringBuilder();
                    i26 = i3;
                    sb5.append("receiveAllConfigs|type: QWALLET_SETTING_CONFIG ,content: ");
                    sb5.append(str25);
                    sb5.append(",version: ");
                    sb5.append(configurationService$Config2.version.get());
                    QLog.d(TAG, 2, sb5.toString());
                } else {
                    i19 = size;
                    i26 = i3;
                }
                if (TextUtils.isEmpty(str25)) {
                    str7 = str21;
                    iQWalletPreferenceApi = iQWalletPreferenceApi4;
                    str14 = str24;
                    i27 = i29;
                    str8 = str18;
                    str9 = str2;
                    str10 = str19;
                    hashMap2 = hashMap4;
                    String str26 = str20;
                    str11 = str2322;
                    str12 = str3;
                    str13 = str26;
                } else {
                    try {
                        jSONObject = new JSONObject(str25);
                        keys = jSONObject.keys();
                    } catch (Exception e18) {
                        e = e18;
                    }
                    while (keys.hasNext()) {
                        String str27 = (String) keys.next();
                        String str28 = str22;
                        try {
                        } catch (Exception e19) {
                            e = e19;
                            str22 = str28;
                            str7 = str21;
                            iQWalletPreferenceApi = iQWalletPreferenceApi4;
                            i27 = i29;
                            str8 = str18;
                            str9 = str2;
                            str10 = str19;
                            hashMap2 = hashMap4;
                            String str29 = str20;
                            str11 = str2322;
                            str12 = str3;
                            str13 = str29;
                            if (QLog.isColorLevel()) {
                            }
                            str14 = str24;
                            int i36 = i27 + 1;
                            hashMap4 = hashMap2;
                            iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                            str24 = str14;
                            str19 = str10;
                            size = i19;
                            i3 = i26;
                            str21 = str7;
                            configurationService$Config2 = configurationService$Config;
                            str2 = str9;
                            str18 = str8;
                            i29 = i36;
                            String str30 = str13;
                            str3 = str12;
                            str2322 = str11;
                            str20 = str30;
                        }
                        if (str28.equals(str27)) {
                            it = keys;
                            ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, str28, jSONObject.getString(str27));
                            str22 = str28;
                            str7 = str21;
                            iQWalletPreferenceApi = iQWalletPreferenceApi4;
                            i27 = i29;
                            str8 = str18;
                        } else {
                            it = keys;
                            str22 = str28;
                            String str31 = str21;
                            try {
                            } catch (Exception e26) {
                                e = e26;
                                str7 = str31;
                                i27 = i29;
                                iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                str8 = str18;
                                str9 = str2;
                                str10 = str19;
                                hashMap2 = hashMap4;
                                String str292 = str20;
                                str11 = str2322;
                                str12 = str3;
                                str13 = str292;
                                if (QLog.isColorLevel()) {
                                }
                                str14 = str24;
                                int i362 = i27 + 1;
                                hashMap4 = hashMap2;
                                iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                                str24 = str14;
                                str19 = str10;
                                size = i19;
                                i3 = i26;
                                str21 = str7;
                                configurationService$Config2 = configurationService$Config;
                                str2 = str9;
                                str18 = str8;
                                i29 = i362;
                                String str302 = str13;
                                str3 = str12;
                                str2322 = str11;
                                str20 = str302;
                            }
                            if (str31.equals(str27)) {
                                try {
                                    String optString = jSONObject.optString(str27, str2322);
                                    if (!TextUtils.isEmpty(optString)) {
                                        i27 = i29;
                                        try {
                                            ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str2322, str31, Base64.encodeToString(optString.getBytes(), 0));
                                        } catch (Exception e27) {
                                            e = e27;
                                            str7 = str31;
                                            str8 = str18;
                                            iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                            str9 = str2;
                                            str10 = str19;
                                            hashMap2 = hashMap4;
                                            String str2922 = str20;
                                            str11 = str2322;
                                            str12 = str3;
                                            str13 = str2922;
                                            if (QLog.isColorLevel()) {
                                            }
                                            str14 = str24;
                                            int i3622 = i27 + 1;
                                            hashMap4 = hashMap2;
                                            iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                                            str24 = str14;
                                            str19 = str10;
                                            size = i19;
                                            i3 = i26;
                                            str21 = str7;
                                            configurationService$Config2 = configurationService$Config;
                                            str2 = str9;
                                            str18 = str8;
                                            i29 = i3622;
                                            String str3022 = str13;
                                            str3 = str12;
                                            str2322 = str11;
                                            str20 = str3022;
                                        }
                                    } else {
                                        i27 = i29;
                                    }
                                    str7 = str31;
                                    str8 = str18;
                                    iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                } catch (Exception e28) {
                                    e = e28;
                                    i27 = i29;
                                }
                            } else {
                                i27 = i29;
                                if ("RedpackPopWnd".equals(str27)) {
                                    try {
                                        JSONObject optJSONObject = jSONObject.optJSONObject(str27);
                                        if (optJSONObject != null) {
                                            String str32 = str20;
                                            try {
                                                int optInt = optJSONObject.optInt(str32);
                                                str7 = str31;
                                                try {
                                                    str11 = str2322;
                                                    str16 = str18;
                                                } catch (Exception e29) {
                                                    e = e29;
                                                    str11 = str2322;
                                                    str8 = str18;
                                                    iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                                    str9 = str2;
                                                    str12 = str3;
                                                    str10 = str19;
                                                    str13 = str32;
                                                    hashMap2 = hashMap4;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    str14 = str24;
                                                    int i36222 = i27 + 1;
                                                    hashMap4 = hashMap2;
                                                    iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                                                    str24 = str14;
                                                    str19 = str10;
                                                    size = i19;
                                                    i3 = i26;
                                                    str21 = str7;
                                                    configurationService$Config2 = configurationService$Config;
                                                    str2 = str9;
                                                    str18 = str8;
                                                    i29 = i36222;
                                                    String str30222 = str13;
                                                    str3 = str12;
                                                    str2322 = str11;
                                                    str20 = str30222;
                                                }
                                                try {
                                                    ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putInt(str, "redpack_popwnd_id", optJSONObject.optInt(str32));
                                                    ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, "redpack_popwnd_group_type_" + optInt, optJSONObject.optString("GroupType"));
                                                    ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, "redpack_popwnd_url_" + optInt, optJSONObject.optString(Global.TRACKING_URL));
                                                    ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, "redpack_popwnd_state_" + optInt, optJSONObject.optString("RedpackState"));
                                                    ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putInt(str, "redpack_popwnd_freq_" + optInt, optJSONObject.optInt("PopWndFreq"));
                                                    ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putInt(str, "redpack_popwnd_total_" + optInt, optJSONObject.optInt("PopWndTotalCount"));
                                                    ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, "redpack_popwnd_network_" + optInt, optJSONObject.optString("PopWndNetworkType"));
                                                    convertStringToTime = ((IQWalletApi) QRoute.api(IQWalletApi.class)).convertStringToTime(optJSONObject.optString("PopWndBeginTime"));
                                                    convertStringToTime2 = ((IQWalletApi) QRoute.api(IQWalletApi.class)).convertStringToTime(optJSONObject.optString("PopWndEndTime"));
                                                    str15 = str32;
                                                } catch (Exception e36) {
                                                    e = e36;
                                                    iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                                    str9 = str2;
                                                    str12 = str3;
                                                    str8 = str16;
                                                    str10 = str19;
                                                    str13 = str32;
                                                    hashMap2 = hashMap4;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    str14 = str24;
                                                    int i362222 = i27 + 1;
                                                    hashMap4 = hashMap2;
                                                    iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                                                    str24 = str14;
                                                    str19 = str10;
                                                    size = i19;
                                                    i3 = i26;
                                                    str21 = str7;
                                                    configurationService$Config2 = configurationService$Config;
                                                    str2 = str9;
                                                    str18 = str8;
                                                    i29 = i362222;
                                                    String str302222 = str13;
                                                    str3 = str12;
                                                    str2322 = str11;
                                                    str20 = str302222;
                                                }
                                                try {
                                                    ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putLong(str, "redpack_popwnd_begin_time_" + optInt, convertStringToTime / 1000);
                                                    ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putLong(str, "redpack_popwnd_end_time_" + optInt, convertStringToTime2 / 1000);
                                                } catch (Exception e37) {
                                                    e = e37;
                                                    iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                                    str9 = str2;
                                                    str8 = str16;
                                                    str10 = str19;
                                                    hashMap2 = hashMap4;
                                                    String str33 = str3;
                                                    str13 = str15;
                                                    str12 = str33;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    str14 = str24;
                                                    int i3622222 = i27 + 1;
                                                    hashMap4 = hashMap2;
                                                    iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                                                    str24 = str14;
                                                    str19 = str10;
                                                    size = i19;
                                                    i3 = i26;
                                                    str21 = str7;
                                                    configurationService$Config2 = configurationService$Config;
                                                    str2 = str9;
                                                    str18 = str8;
                                                    i29 = i3622222;
                                                    String str3022222 = str13;
                                                    str3 = str12;
                                                    str2322 = str11;
                                                    str20 = str3022222;
                                                }
                                            } catch (Exception e38) {
                                                e = e38;
                                                str7 = str31;
                                            }
                                        } else {
                                            str7 = str31;
                                            str16 = str18;
                                            String str34 = str20;
                                            str11 = str2322;
                                            str15 = str34;
                                        }
                                        iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                        str9 = str2;
                                        str8 = str16;
                                        str10 = str19;
                                        hashMap2 = hashMap4;
                                        String str35 = str3;
                                        str13 = str15;
                                        str12 = str35;
                                    } catch (Exception e39) {
                                        e = e39;
                                        str7 = str31;
                                        String str36 = str20;
                                        str11 = str2322;
                                        str15 = str36;
                                        str8 = str18;
                                        iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                        str9 = str2;
                                    }
                                } else {
                                    str7 = str31;
                                    String str37 = str18;
                                    String str38 = str20;
                                    str11 = str2322;
                                    try {
                                    } catch (Exception e46) {
                                        e = e46;
                                        str9 = str2;
                                        str12 = str3;
                                        str8 = str37;
                                    }
                                    if (IQWalletPreferenceApi.KEY_WALLET_APPLIST_CONFIG.equals(str27)) {
                                        JSONObject optJSONObject2 = jSONObject.optJSONObject(str27);
                                        if (optJSONObject2 != null) {
                                            ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putInt(str, IQWalletPreferenceApi.KEY_WALLET_APPLIST_CONFIG_NUM_COLS, optJSONObject2.optInt(IQWalletPreferenceApi.KEY_WALLET_APPLIST_CONFIG_NUM_COLS));
                                        }
                                    } else if (IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL.equals(str27)) {
                                        JSONObject optJSONObject3 = jSONObject.optJSONObject(str27);
                                        if (optJSONObject3 != null) {
                                            ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_BUSI_TYPE, optJSONObject3.optString(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY));
                                            ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_IMG_URL, optJSONObject3.optString("imgURL"));
                                            ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_TITLE, optJSONObject3.optString("title"));
                                            ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_JUMP_URL, optJSONObject3.optString("jumpURL"));
                                        }
                                    } else {
                                        if (IQWalletPreferenceApi.KEY_BIRTHDAY_HB.equals(str27)) {
                                            try {
                                                QLog.d(TAG, 1, "has KEY_BIRTHDAY_HB config");
                                                JSONObject optJSONObject4 = jSONObject.optJSONObject(str27);
                                                if (optJSONObject4 != null) {
                                                    ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, str19, optJSONObject4.optString(IQWalletPreferenceApi.KEY_WISH_PLACEHOLDER));
                                                    str8 = str37;
                                                    try {
                                                        ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putInt(str, str8, optJSONObject4.optInt(IQWalletPreferenceApi.KEY_WISH_MAX_LEN));
                                                        ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putInt(str, IQWalletPreferenceApi.KEY_BIRTHDAY_HB_INVALID_SPACE, optJSONObject4.optInt(IQWalletPreferenceApi.KEY_INVALID_SPACE));
                                                        JSONArray optJSONArray = optJSONObject4.optJSONArray(IQWalletPreferenceApi.KEY_THEME_LIST);
                                                        if (optJSONArray != null) {
                                                            str12 = str3;
                                                            try {
                                                                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, str12, optJSONArray.toString());
                                                            } catch (Exception e47) {
                                                                e = e47;
                                                                str13 = str38;
                                                                iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                                                str9 = str2;
                                                                str10 = str19;
                                                                hashMap2 = hashMap4;
                                                                if (QLog.isColorLevel()) {
                                                                }
                                                                str14 = str24;
                                                                int i36222222 = i27 + 1;
                                                                hashMap4 = hashMap2;
                                                                iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                                                                str24 = str14;
                                                                str19 = str10;
                                                                size = i19;
                                                                i3 = i26;
                                                                str21 = str7;
                                                                configurationService$Config2 = configurationService$Config;
                                                                str2 = str9;
                                                                str18 = str8;
                                                                i29 = i36222222;
                                                                String str30222222 = str13;
                                                                str3 = str12;
                                                                str2322 = str11;
                                                                str20 = str30222222;
                                                            }
                                                        } else {
                                                            str12 = str3;
                                                        }
                                                        JSONArray optJSONArray2 = optJSONObject4.optJSONArray(IQWalletPreferenceApi.KEY_SKIN_LIST);
                                                        if (optJSONArray2 != null) {
                                                            str17 = str2;
                                                            try {
                                                                ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putString(str, str17, optJSONArray2.toString());
                                                            } catch (Exception e48) {
                                                                e = e48;
                                                                str10 = str19;
                                                                str13 = str38;
                                                                str9 = str17;
                                                                hashMap2 = hashMap4;
                                                                iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                                                if (QLog.isColorLevel()) {
                                                                }
                                                                str14 = str24;
                                                                int i362222222 = i27 + 1;
                                                                hashMap4 = hashMap2;
                                                                iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                                                                str24 = str14;
                                                                str19 = str10;
                                                                size = i19;
                                                                i3 = i26;
                                                                str21 = str7;
                                                                configurationService$Config2 = configurationService$Config;
                                                                str2 = str9;
                                                                str18 = str8;
                                                                i29 = i362222222;
                                                                String str302222222 = str13;
                                                                str3 = str12;
                                                                str2322 = str11;
                                                                str20 = str302222222;
                                                            }
                                                        } else {
                                                            str17 = str2;
                                                        }
                                                    } catch (Exception e49) {
                                                        e = e49;
                                                        str12 = str3;
                                                    }
                                                } else {
                                                    str17 = str2;
                                                    str12 = str3;
                                                    str8 = str37;
                                                }
                                                str10 = str19;
                                                str13 = str38;
                                                str9 = str17;
                                                hashMap2 = hashMap4;
                                                iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                            } catch (Exception e56) {
                                                e = e56;
                                                str12 = str3;
                                                str8 = str37;
                                            }
                                        } else {
                                            str9 = str2;
                                            str12 = str3;
                                            str8 = str37;
                                            try {
                                                if (IQWalletPreferenceApi.KEY_HB_ZPALN.equals(str27)) {
                                                    str10 = str19;
                                                    try {
                                                        QLog.d(TAG, 1, "has zplanHBEntry config");
                                                        JSONObject optJSONObject5 = jSONObject.optJSONObject(str27);
                                                        if (optJSONObject5 != null) {
                                                            str13 = str38;
                                                            iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                                            try {
                                                                iQWalletPreferenceApi.putStringToSp(str, IQWalletPreferenceApi.KEY_HB_ZPALN_NAME, optJSONObject5.optString("name"));
                                                                iQWalletPreferenceApi.putStringToSp(str, IQWalletPreferenceApi.KEY_HB_ZPALN_ICON_URL, optJSONObject5.optString(IQWalletPreferenceApi.KEY_ICON_URL));
                                                                iQWalletPreferenceApi.putStringToSp(str, IQWalletPreferenceApi.KEY_HB_ZPALN_SUPPORT_SHARPP, optJSONObject5.optString(IQWalletPreferenceApi.KEY_SUPPORT_SHARPP));
                                                            } catch (Exception e57) {
                                                                e = e57;
                                                            }
                                                        } else {
                                                            str13 = str38;
                                                            iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                                        }
                                                    } catch (Exception e58) {
                                                        e = e58;
                                                        str13 = str38;
                                                        iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                                    }
                                                } else {
                                                    str10 = str19;
                                                    str13 = str38;
                                                    iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                                    if (!"image_urls".equals(str27) && !"hb_theme".equals(str27) && !"hb_theme_group".equals(str27)) {
                                                        hashMap2 = hashMap4;
                                                        try {
                                                            hashMap2.put(str27, jSONObject.opt(str27));
                                                        } catch (Exception e59) {
                                                            e = e59;
                                                        }
                                                    }
                                                }
                                                hashMap2 = hashMap4;
                                            } catch (Exception e65) {
                                                e = e65;
                                                str10 = str19;
                                                str13 = str38;
                                                hashMap2 = hashMap4;
                                                iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                                if (QLog.isColorLevel()) {
                                                }
                                                str14 = str24;
                                                int i3622222222 = i27 + 1;
                                                hashMap4 = hashMap2;
                                                iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                                                str24 = str14;
                                                str19 = str10;
                                                size = i19;
                                                i3 = i26;
                                                str21 = str7;
                                                configurationService$Config2 = configurationService$Config;
                                                str2 = str9;
                                                str18 = str8;
                                                i29 = i3622222222;
                                                String str3022222222 = str13;
                                                str3 = str12;
                                                str2322 = str11;
                                                str20 = str3022222222;
                                            }
                                        }
                                        hashMap2 = hashMap4;
                                        if (QLog.isColorLevel()) {
                                            str14 = str24;
                                            QLog.e(TAG, 2, str14, e);
                                        }
                                        str14 = str24;
                                    }
                                    str9 = str2;
                                    str12 = str3;
                                    str8 = str37;
                                    str10 = str19;
                                    str13 = str38;
                                    hashMap2 = hashMap4;
                                    iQWalletPreferenceApi = iQWalletPreferenceApi4;
                                }
                                hashMap4 = hashMap2;
                                iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                                str19 = str10;
                                keys = it;
                                str2 = str9;
                                str18 = str8;
                                i29 = i27;
                                str21 = str7;
                                String str39 = str13;
                                str3 = str12;
                                str2322 = str11;
                                str20 = str39;
                            }
                        }
                        str9 = str2;
                        str10 = str19;
                        hashMap2 = hashMap4;
                        String str40 = str20;
                        str11 = str2322;
                        str12 = str3;
                        str13 = str40;
                        hashMap4 = hashMap2;
                        iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                        str19 = str10;
                        keys = it;
                        str2 = str9;
                        str18 = str8;
                        i29 = i27;
                        str21 = str7;
                        String str392 = str13;
                        str3 = str12;
                        str2322 = str11;
                        str20 = str392;
                    }
                    str7 = str21;
                    iQWalletPreferenceApi = iQWalletPreferenceApi4;
                    i27 = i29;
                    str8 = str18;
                    str9 = str2;
                    str10 = str19;
                    hashMap2 = hashMap4;
                    String str41 = str20;
                    str11 = str2322;
                    str12 = str3;
                    str13 = str41;
                    str14 = str24;
                }
                int i36222222222 = i27 + 1;
                hashMap4 = hashMap2;
                iQWalletPreferenceApi4 = iQWalletPreferenceApi;
                str24 = str14;
                str19 = str10;
                size = i19;
                i3 = i26;
                str21 = str7;
                configurationService$Config2 = configurationService$Config;
                str2 = str9;
                str18 = str8;
                i29 = i36222222222;
                String str30222222222 = str13;
                str3 = str12;
                str2322 = str11;
                str20 = str30222222222;
            }
            str5 = str2322;
            hashMap = hashMap4;
            str4 = str24;
            i17 = i3;
            i16 = i18;
        } else {
            int i2822 = i3;
            str4 = "received QWALLET_SETTING_CONFIG error";
            str5 = "";
            hashMap = hashMap4;
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("received QWALLET_SETTING_CONFIG remote version: ");
                i17 = i2822;
                sb6.append(i17);
                sb6.append(" | localVersion: ");
                i16 = qWalletSettingConfigVersion;
                sb6.append(i16);
                QLog.d(TAG, 2, sb6.toString());
            } else {
                i16 = qWalletSettingConfigVersion;
                i17 = i2822;
            }
        }
        if (configurationService$Config == null && i17 != i16) {
            try {
                try {
                    updateQWalletSettingConfigVersion(MobileQQ.sMobileQQ, str, i17);
                    JSONObject jSONObject2 = new JSONObject();
                    if (!hashMap.isEmpty()) {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                        hashMap.clear();
                    }
                    if (jSONObject2.length() > 0) {
                        str6 = jSONObject2.toString();
                    } else {
                        str6 = str5;
                    }
                    updateConfig(str6);
                } catch (Exception e66) {
                    e = e66;
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, str4, e);
                    }
                }
            } catch (Exception e67) {
                e = e67;
            }
        }
    }

    private void updateConfig(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.impl.HbThemeConfigApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (HbThemeConfigApiImpl.mLock) {
                    if (QLog.isColorLevel()) {
                        QLog.d(HbThemeConfigApiImpl.TAG, 2, "update hbTheme config: " + str);
                    }
                    FileUtils.writeFile(HbThemeConfigApiImpl.this.getSaveDir(), HbThemeConfigApiImpl.HB_THEME_CONFIG_FILE_NAME, Base64.encodeToString(str.getBytes(), 0));
                }
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi
    public String getConfigCache() {
        return mConfigCache;
    }

    public int getQWalletSettingConfigVersion(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.QWALLET_SETTING_VERSION, 0);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi
    public void handleQWalletSettingConfig(final ConfigurationService$Config configurationService$Config) {
        final String c16 = com.tencent.mobileqq.base.a.c();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                HbThemeConfigApiImpl.this.lambda$handleQWalletSettingConfig$0(c16, configurationService$Config);
            }
        }, 64, null, true);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi
    public void setConfigCache(String str) {
        mConfigCache = str;
    }

    public void updateQWalletSettingConfigVersion(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.QWALLET_SETTING_VERSION, i3);
        edit.commit();
    }
}
