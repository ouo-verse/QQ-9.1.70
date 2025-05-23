package com.tencent.mobileqq.mini.util;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.utils.MiniAppMMKVUtils;
import com.tencent.mobileqq.minigame.ui.retain.UsageGuideStyle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RetainDialogModuleUtil {
    private static final int A_DAY_MILL_SECOND = 86400000;
    private static final int A_WEEK_MILL_SECOND = 604800000;
    public static final String KEY_LAST_TIME_OF_COLOR_SIGN_TYPE_IN_MILL = "last_time_of_color_sign_type_";
    public static final String KEY_LAST_TIME_OF_DESKTOP_SHORTCUT_TYPE_IN_MILL = "last_time_of_desktop_shortcut_type_";
    private static final String KEY_RETAIN_USAGE_GUIDE = "retain_usage_guide";
    public static final String TAG = "RetainDialogModuleUtil";

    public static JSONObject getFunctionRetainJson() {
        String string = StorageUtil.getPreference().getString(getUsageGuideJsonKey(), "");
        try {
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("usageGuide")) {
                return jSONObject;
            }
            return null;
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return null;
        }
    }

    public static JSONObject getProperRetainModule(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (isModuleTypeAllRight(optJSONObject.optInt("moduleType"), str)) {
                    return optJSONObject;
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject2;
    }

    public static JSONObject getRecommendModule(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                int optInt = optJSONObject.optInt("moduleType");
                if (optInt == 0 || optInt == 1) {
                    return optJSONObject;
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject2;
    }

    private static String getUsageGuideJsonKey() {
        return "retain_usage_guide_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }

    public static void removeFunctionRetainJson() {
        StorageUtil.getPreference().edit().remove(getUsageGuideJsonKey()).commit();
    }

    public static UsageGuideStyle getUsageGuide(JSONObject jSONObject) {
        return UsageGuideStyle.createFromConfigJson(jSONObject != null ? jSONObject.optJSONObject("usageGuide") : null);
    }

    private static boolean isModuleTypeAllRight(int i3, String str) {
        if (i3 == 2) {
            long currentTimeMillis = System.currentTimeMillis() - MiniAppMMKVUtils.getLong(KEY_LAST_TIME_OF_DESKTOP_SHORTCUT_TYPE_IN_MILL + str, 0L);
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 1, "[isModuleTypeAllRight], type:" + i3 + ",interval:" + currentTimeMillis);
            }
            return currentTimeMillis >= 604800000;
        }
        if (i3 == 3) {
            long currentTimeMillis2 = System.currentTimeMillis() - MiniAppMMKVUtils.getLong(KEY_LAST_TIME_OF_COLOR_SIGN_TYPE_IN_MILL + str, 0L);
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 1, "[isModuleTypeAllRight], type:" + i3 + ",interval:" + currentTimeMillis2);
            }
            if (currentTimeMillis2 < 86400000) {
                return false;
            }
        }
        return true;
    }

    public static void saveFunctionRetainJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            StorageUtil.getPreference().edit().putString(getUsageGuideJsonKey(), jSONObject.toString());
        }
    }

    public static void saveShowTime(int i3, String str) {
        if (i3 == 3) {
            MiniAppMMKVUtils.putLong(KEY_LAST_TIME_OF_COLOR_SIGN_TYPE_IN_MILL + str, System.currentTimeMillis());
            return;
        }
        if (i3 == 2) {
            MiniAppMMKVUtils.putLong(KEY_LAST_TIME_OF_DESKTOP_SHORTCUT_TYPE_IN_MILL + str, System.currentTimeMillis());
        }
    }

    public static JSONObject getProperRetainModule(String str, String str2) {
        try {
            return getProperRetainModule(new JSONObject(str), str2);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }
}
