package com.tencent.mobileqq.mini.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppSecurityUtil {
    private static final String DEFAULT_SIMPLE_UIN = "0";
    private static final String KEY_MMKV_MIGRATE_FLAG = "_migrate_flag_";
    public static final String SAFE_BLOCK_MINIAPP_OPTIMIZATION_TVALUE_HANDLE = "0X800AA17";
    public static final String SAFE_BLOCK_MINIAPP_OPTIMIZATION_TVALUE_QUIT = "0X800AA16";
    public static final String SAFE_BLOCK_MINIAPP_OPTIMIZATION_TVALUE_SHOW = "0X800AA15";
    private static final String SP_MINI_APP_SECURITY_UTIL = "MiniAppSecurityUtil_Shared_Prefs";
    public static final String TAG = "MiniAppSecurityUtil";
    private static final String kLoginMiniAppForbidToken = "kLoginMiniAppForbidToken";
    private static final String kLoginMiniAppUin = "kLoginMiniAppUin";
    private static final List<String> sMiniAppLoginSecurityList = Arrays.asList("1109048181", "1109907872", "1109664704", "1108149324");

    public static boolean checkMiniAppForLogin(String str) {
        Map<String, String> argumentsFromURL = getArgumentsFromURL(str);
        if (argumentsFromURL != null) {
            String str2 = argumentsFromURL.get("_mappid");
            if (!TextUtils.isEmpty(str2) && sMiniAppLoginSecurityList.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        if (android.text.TextUtils.isEmpty(getLoginMiniAppForbidToken(com.tencent.qphone.base.util.BaseApplication.getContext(), r4)) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean doCheckSafeUnblockWithLogin(String str) {
        boolean z16 = true;
        try {
            if (!TextUtils.isEmpty(str) && sMiniAppLoginSecurityList.contains(str)) {
                String loginMiniAppUin = getLoginMiniAppUin(BaseApplication.getContext());
                if (!TextUtils.isEmpty(loginMiniAppUin)) {
                }
            }
            z16 = false;
            return z16;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "doCheckSafeUnblockWithLogin error: " + e16.getMessage());
            return false;
        }
    }

    public static void doClearAfterLoginSuccess(boolean z16) {
        try {
            String loginMiniAppUin = getLoginMiniAppUin(BaseApplication.getContext());
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doClearAfterLoginSuccess uin: " + getSimpleUin(loginMiniAppUin));
            }
            if (!TextUtils.isEmpty(loginMiniAppUin)) {
                if (z16) {
                    QLog.e(TAG, 1, "doClearAfterLoginSuccess, forbid_token: " + getLoginMiniAppForbidToken(BaseApplication.getContext(), loginMiniAppUin));
                }
                removeLoginMiniAppForbidToken(BaseApplication.getContext(), loginMiniAppUin);
                removeLoginMiniAppUin(BaseApplication.getContext());
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "remove LoginMiniAppData error: " + e16.getMessage());
        }
    }

    private static Map<String, String> getArguments(String str) {
        HashMap hashMap = new HashMap();
        try {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split != null && split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static Map<String, String> getArgumentsFromURL(String str) {
        Map<String, String> map;
        int indexOf;
        if (str != null && -1 != (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER))) {
            map = getArguments(str.substring(indexOf + 1));
        } else {
            map = null;
        }
        if (map == null) {
            return new HashMap();
        }
        return map;
    }

    public static String getLoginMiniAppForbidToken(Context context, String str) {
        try {
            String string = getMiniAppSecuritySp().getString(str + "_" + kLoginMiniAppForbidToken, "");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getLoginMiniAppForbidToken uin: " + getSimpleUin(str));
            }
            return string;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getLoginMiniAppForbidToken error: " + e16.getMessage());
            return "";
        }
    }

    public static String getLoginMiniAppUin(Context context) {
        try {
            return getMiniAppSecuritySp().getString(kLoginMiniAppUin, "");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getLoginMiniAppUin error: " + e16.getMessage());
            return "";
        }
    }

    private static SharedPreferences getMiniAppSecuritySp() {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), SP_MINI_APP_SECURITY_UTIL, "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), SP_MINI_APP_SECURITY_UTIL, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }

    private static String getSimpleUin(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "0";
            }
            return str.substring(str.length() - 4);
        } catch (Exception unused) {
            return "0";
        }
    }

    public static void removeLoginMiniAppForbidToken(Context context, String str) {
        try {
            SharedPreferences.Editor edit = getMiniAppSecuritySp().edit();
            edit.remove(str + "_" + kLoginMiniAppForbidToken);
            edit.commit();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "removeLoginMiniAppForbidToken error: " + e16.getMessage());
        }
    }

    public static void removeLoginMiniAppUin(Context context) {
        try {
            SharedPreferences.Editor edit = getMiniAppSecuritySp().edit();
            edit.remove(kLoginMiniAppUin);
            edit.commit();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "removeLoginMiniAppUin error: " + e16.getMessage());
        }
    }

    public static void updateLoginMiniAppForbidToken(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = getMiniAppSecuritySp().edit();
            edit.putString(str + "_" + kLoginMiniAppForbidToken, str2);
            edit.commit();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateLoginMiniAppForbidToken error: " + e16.getMessage());
        }
    }

    public static void updateLoginMiniAppUin(Context context, String str) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateLoginMiniAppUin uin: " + getSimpleUin(str));
            }
            SharedPreferences.Editor edit = getMiniAppSecuritySp().edit();
            edit.putString(kLoginMiniAppUin, str);
            edit.commit();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateLoginMiniAppUin error: " + e16.getMessage());
        }
    }
}
