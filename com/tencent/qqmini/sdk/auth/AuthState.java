package com.tencent.qqmini.sdk.auth;

import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AuthState {
    public static final String IS_ONCE_SUB_ITEM_MAINTAIN = "once_sub_item_maintain";
    public static final String IS_SYS_SUB_ITEM_MAINTAIN = "sys_sub_item_maintain";
    public static final String KEY_AUTHORITY_SYNCHRONIZED = "authority_synchronized";
    static final String TAG = "AuthState";
    private static volatile String sTempAllowPluginScopeName;
    private static final HashMap<String, Integer> scopeAuthTypeMap = new HashMap<>();
    private String mAppId;
    private Context mContext;
    private String mUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements AsyncResult {
        a() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            QMLog.e(AuthState.TAG, "updateUserSetting() onCmdListener isSuccess: " + z16 + "   ; ret: " + jSONObject);
        }
    }

    static {
        initDefaultAskEveryTimeMap();
        initDefaultAskEveryTimeWhenRejectedMap();
    }

    public AuthState() {
    }

    public static String getAllowPluginScopeName() {
        return sTempAllowPluginScopeName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences getSharedPreferences() {
        return this.mContext.getSharedPreferences(this.mAppId + "_" + this.mUin, 4);
    }

    private static void initDefaultAskEveryTimeMap() {
        HashMap<String, Integer> hashMap = scopeAuthTypeMap;
        hashMap.put(AuthorizeCenter.SCOPE_GET_PHONE_NUMBER, 1);
        hashMap.put("scope.uploadAvatar", 1);
    }

    private static void initDefaultAskEveryTimeWhenRejectedMap() {
        HashMap<String, Integer> hashMap = scopeAuthTypeMap;
        hashMap.put(AuthorizeCenter.SCOPE_EXPAND_USER_INFO, 2);
        hashMap.put(AuthorizeCenter.SCOPE_CHANNEL_USER_INFO, 2);
        hashMap.put(AuthorizeCenter.SCOPE_NEARBY_USER_INFO, 2);
    }

    public static void setAllowPluginScopeName(String str) {
        sTempAllowPluginScopeName = str;
    }

    public void clearAll() {
        QMLog.i(TAG, "clear all auth ");
        SharedPreferences sharedPreferences = getSharedPreferences();
        Iterator<String> it = PermissionManager.g().getAllPermissions().iterator();
        while (it.hasNext()) {
            sharedPreferences.edit().putInt(it.next(), 1).commit();
        }
        sharedPreferences.edit().putBoolean("authority_synchronized", true).commit();
    }

    public int getAuthFlag(String str) {
        return getSharedPreferences().getInt(str, 1);
    }

    public List<AuthStateItem> getAuthStateList(int i3) {
        ArrayList arrayList = new ArrayList();
        for (String str : PermissionManager.g().getAllPermissions()) {
            Integer num = scopeAuthTypeMap.get(str);
            if (num == null || num.intValue() != 1) {
                int i16 = getSharedPreferences().getInt(str, 1);
                if (i16 == 2) {
                    if ((i3 & 2) == 2) {
                        arrayList.add(new AuthStateItem(str, 2));
                    }
                } else if (i16 == 1) {
                    if ((i3 & 1) == 1) {
                        arrayList.add(new AuthStateItem(str, 1));
                    }
                } else if ((i3 & 4) == 4) {
                    arrayList.add(new AuthStateItem(str, 4));
                }
            }
        }
        return arrayList;
    }

    public void grantPermission(final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.auth.AuthState.1
            @Override // java.lang.Runnable
            public void run() {
                AuthState.this.getSharedPreferences().edit().putInt(str, 2).apply();
            }
        });
    }

    public boolean isOnceSubMaintain() {
        return getSharedPreferences().getBoolean("once_sub_item_maintain", false);
    }

    public boolean isPermissionGranted(String str) {
        if (2 == (getSharedPreferences().getInt(str, 1) & 2)) {
            return true;
        }
        return false;
    }

    public boolean isSynchronized() {
        return getSharedPreferences().getBoolean("authority_synchronized", false);
    }

    public boolean isSystemSubscribeMaintain() {
        return getSharedPreferences().getBoolean("sys_sub_item_maintain", false);
    }

    public void revokePermission(String str) {
        getSharedPreferences().edit().putInt(str, 4).apply();
    }

    public void setAuthState(String str, boolean z16) {
        setAuthState(str, z16, new AsyncResult() { // from class: com.tencent.qqmini.sdk.auth.AuthState.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z17, JSONObject jSONObject) {
                QMLog.e(AuthState.TAG, "setAuthorize() onCmdListener isSuccess: " + z17 + "   ; ret: " + jSONObject);
            }
        });
    }

    public void setSynchronized() {
        getSharedPreferences().edit().putBoolean("authority_synchronized", true).commit();
    }

    public boolean shouldAskEveryTime(String str) {
        Integer num = scopeAuthTypeMap.get(str);
        if (num != null && num.intValue() == 1) {
            return true;
        }
        return false;
    }

    public boolean shouldAskEveryTimeWhenRejected(String str) {
        Integer num = scopeAuthTypeMap.get(str);
        if (num != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    public void updateAuthStateList(List<UserAuthInfo> list, List<UserSettingInfo> list2) {
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                UserAuthInfo userAuthInfo = list.get(i3);
                String str = userAuthInfo.scope;
                int i16 = userAuthInfo.authState;
                if (i16 == 1) {
                    getSharedPreferences().edit().putInt(str, 2).commit();
                } else if (i16 == 2) {
                    getSharedPreferences().edit().putInt(str, 4).commit();
                }
            }
        }
        if (list2 != null) {
            for (int i17 = 0; i17 < list2.size(); i17++) {
                UserSettingInfo userSettingInfo = list2.get(i17);
                String str2 = userSettingInfo.settingItem;
                int i18 = userSettingInfo.authState;
                if (i18 == 1) {
                    getSharedPreferences().edit().putInt(str2, 2).commit();
                } else if (i18 == 2) {
                    getSharedPreferences().edit().putInt(str2, 4).commit();
                }
            }
        }
    }

    public void updateIsOnceSubMsgMaintain(boolean z16) {
        getSharedPreferences().edit().putBoolean("once_sub_item_maintain", z16).apply();
    }

    public void updateIsSysSubMsgMaintain(boolean z16) {
        getSharedPreferences().edit().putBoolean("sys_sub_item_maintain", z16).apply();
    }

    public void updateOnceSubMsgSetting(String str, boolean z16, List<INTERFACE$StSubscribeMessage> list, final AsyncResult asyncResult) {
        int i3;
        INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo = new INTERFACE$StUserSettingInfo();
        if (str != null) {
            iNTERFACE$StUserSettingInfo.settingItem.set(str);
        }
        PBInt32Field pBInt32Field = iNTERFACE$StUserSettingInfo.authState;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        pBInt32Field.set(i3);
        if (list != null) {
            iNTERFACE$StUserSettingInfo.subItems.set(list);
        }
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).updateUserSetting(this.mAppId, iNTERFACE$StUserSettingInfo, new AsyncResult() { // from class: com.tencent.qqmini.sdk.auth.AuthState.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z17, JSONObject jSONObject) {
                AsyncResult asyncResult2 = asyncResult;
                if (asyncResult2 != null) {
                    asyncResult2.onReceiveResult(z17, jSONObject);
                }
            }
        });
    }

    public AuthState(Context context, String str, String str2) {
        this.mContext = context;
        this.mAppId = str;
        this.mUin = str2;
    }

    public void setAuthState(String str, boolean z16, AsyncResult asyncResult) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z16) {
            grantPermission(str);
        } else {
            revokePermission(str);
        }
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (str.startsWith("setting")) {
            INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo = new INTERFACE$StUserSettingInfo();
            iNTERFACE$StUserSettingInfo.settingItem.set(str);
            PermissionInfo scopePermission = PermissionManager.g().getScopePermission(str);
            PBStringField pBStringField = iNTERFACE$StUserSettingInfo.desc;
            if (scopePermission != null) {
                str = scopePermission.description;
            }
            pBStringField.set(str);
            iNTERFACE$StUserSettingInfo.authState.set(z16 ? 1 : 2);
            channelProxy.updateUserSetting(this.mAppId, iNTERFACE$StUserSettingInfo, new a());
            return;
        }
        UserAuthInfo userAuthInfo = new UserAuthInfo();
        userAuthInfo.scope = str;
        PermissionInfo scopePermission2 = PermissionManager.g().getScopePermission(str);
        if (scopePermission2 != null) {
            str = scopePermission2.description;
        }
        userAuthInfo.desc = str;
        userAuthInfo.authState = z16 ? 1 : 2;
        channelProxy.setAuth(this.mAppId, userAuthInfo, asyncResult);
    }
}
