package com.tencent.bugly.common.reporter.builder;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.OSVersionFormatUtil;
import com.tencent.bugly.common.utils.StringUtil;
import com.tencent.rmonitor.common.lifecycle.a;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ReportDataBuilder {
    public static final String[] FILTER_DEFAULT = new String[0];
    public static final String[] FILTER_STAGE = {"stage"};
    public static final String KEY_64_BIT_FLAG = "is64bit";
    public static final String KEY_ACCOUNT_ID = "account_id";
    public static final String KEY_APP_KEY = "app_key";
    public static final String KEY_APP_NAME = "app_name";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_APP_VERSION_MODE = "app_version_mode";
    public static final String KEY_ATTRIBUTES = "Attributes";
    public static final String KEY_BASE_TYPE = "base_type";
    public static final String KEY_BIZ_EXTEND_INFO = "biz_extend_info";
    public static final String KEY_BODY = "Body";
    public static final String KEY_BRAND = "brand";
    public static final String KEY_BUILD_NUMBER = "build_number";
    public static final String KEY_BUNDLE_ID = "bundle_id";
    public static final String KEY_CLIENT_IDENTIFY = "client_identify";
    public static final String KEY_EVENT_TIME = "event_time";
    public static final String KEY_EVENT_TIME_IN_MS = "event_time_in_ms";
    public static final String KEY_EXCEPTION_LINK = "exception_link";
    public static final String KEY_EXTEND_INFO = "extend_info";
    public static final String KEY_FULL_OS_VERSION = "full_os_version";
    public static final String KEY_GC_INFO = "gc_info";
    public static final String KEY_HARDWARE_OS = "hardware_os";
    public static final String KEY_HOT_PATCH = "toolyrx";
    public static final String KEY_LAUNCH_ID = "launch_id";
    public static final String KEY_LINKAGE = "linkages";
    public static final String KEY_MODEL = "model";
    public static final String KEY_MY_PID = "key_my_pid";
    public static final String KEY_OPERATION_LOG = "operation_log";
    public static final String KEY_OS_VERSION = "os_version";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_PROCESS_LAUNCH_ID = "process_launch_id";
    public static final String KEY_PROCESS_NAME = "process_name";
    public static final String KEY_PRODUCT_ID = "product_id";
    public static final String KEY_PROTOCOL_VERSION = "protocol_version";
    public static final String KEY_RESOURCE = "Resource";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_STACK_TYPE = "stack_structure_type";
    public static final String KEY_STAGE = "stage";
    public static final String KEY_SUB_TYPE = "sub_type";
    public static final String KEY_TRANSLATE_TYPE = "translate_type";
    public static final String KEY_UNIQUE_ID = "unique_id";
    public static final String KEY_USER_CUSTOM = "user_custom";
    private static final String LINKER = "-";
    private static final long ONE_SECOND_IN_MS = 1000;
    private static final String TAG = "Bugly_RDataBuilder";

    public static boolean containLinkData(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || !jSONObject.has(KEY_ATTRIBUTES) || (optJSONObject = jSONObject.optJSONObject(KEY_ATTRIBUTES)) == null || !optJSONObject.has("-")) {
            return false;
        }
        return true;
    }

    public static String getBundleId(Context context) {
        if (context != null) {
            return context.getPackageName();
        }
        return "";
    }

    public static String getClientIdentify(UserMeta userMeta) {
        return StringUtil.getMD5(userMeta.uin + userMeta.getUniqueID() + System.currentTimeMillis());
    }

    public static int getPidFromParam(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(KEY_MY_PID)) {
            return jSONObject.optInt(KEY_MY_PID);
        }
        return 0;
    }

    public static String getPluginFullNameFromParam(JSONObject jSONObject) {
        return getPluginFullNameFromParam(jSONObject, "-");
    }

    public static String getPluginNameFromParam(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("sub_type")) {
            return jSONObject.optString("sub_type");
        }
        return "";
    }

    public static String getProcessLaunchIdFromParam(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(KEY_PROCESS_LAUNCH_ID)) {
            return jSONObject.optString(KEY_PROCESS_LAUNCH_ID);
        }
        return "";
    }

    public static JSONObject makeAttributes(String[] strArr) {
        HashSet hashSet;
        JSONObject jSONObject = new JSONObject();
        try {
            if (strArr == null) {
                hashSet = new HashSet();
            } else {
                hashSet = new HashSet(Arrays.asList(strArr));
            }
            if (!hashSet.contains("stage")) {
                jSONObject.put("stage", a.f());
            }
            jSONObject.put(KEY_HOT_PATCH, HotPatchWrapper.getInstance().getAppHotPatchNum());
        } catch (Throwable th5) {
            Logger.f365497g.e(TAG, "makeAttributes fail for " + th5);
        }
        return jSONObject;
    }

    public static JSONObject makeParam(Context context, String str, String str2, UserMeta userMeta) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_PRODUCT_ID, userMeta.appId);
            jSONObject.put("app_key", userMeta.appKey);
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("event_time", currentTimeMillis / 1000);
            jSONObject.put(KEY_EVENT_TIME_IN_MS, currentTimeMillis);
            jSONObject.put(KEY_BASE_TYPE, str);
            jSONObject.put("sub_type", str2);
            jSONObject.put("app_version", userMeta.appVersion);
            jSONObject.put(KEY_APP_VERSION_MODE, userMeta.appVersionMode);
            jSONObject.put("sdk_version", userMeta.sdkVersion);
            jSONObject.put(KEY_BUNDLE_ID, getBundleId(context));
            jSONObject.put(KEY_BUILD_NUMBER, userMeta.buildNumber);
            jSONObject.put(KEY_CLIENT_IDENTIFY, getClientIdentify(userMeta));
            jSONObject.put("platform", "Android");
            jSONObject.put(KEY_RESOURCE, makeResource(userMeta));
            jSONObject.put(KEY_LAUNCH_ID, TraceGenerator.getLaunchId(context));
            jSONObject.put(KEY_PROCESS_LAUNCH_ID, TraceGenerator.getProcessLaunchId());
            jSONObject.put(KEY_PROTOCOL_VERSION, 1);
            jSONObject.put(KEY_MY_PID, Process.myPid());
            return jSONObject;
        } catch (Throwable th5) {
            Logger.f365497g.e(TAG, "makeParam fail for " + th5);
            return null;
        }
    }

    public static JSONObject makeResource(UserMeta userMeta) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_HARDWARE_OS, "android");
            String oSVersion = PrivacyInformation.getInstance().getOSVersion();
            int androidFrameworkVersion = PrivacyInformation.getInstance().getAndroidFrameworkVersion();
            jSONObject.put("os_version", OSVersionFormatUtil.formatOSVersion(androidFrameworkVersion, oSVersion));
            jSONObject.put(KEY_FULL_OS_VERSION, OSVersionFormatUtil.makeFullOSVersion(androidFrameworkVersion, oSVersion));
            jSONObject.put("model", userMeta.getModel());
            jSONObject.put("unique_id", userMeta.getUniqueID());
            jSONObject.put("brand", PrivacyInformation.getInstance().getManufacture());
            jSONObject.put(KEY_ACCOUNT_ID, userMeta.uin);
            return jSONObject;
        } catch (Throwable th5) {
            Logger.f365497g.e(TAG, "makeResource fail for " + th5);
            return null;
        }
    }

    public static String getPluginFullNameFromParam(JSONObject jSONObject, String str) {
        String str2 = "";
        String optString = (jSONObject == null || !jSONObject.has(KEY_BASE_TYPE)) ? "" : jSONObject.optString(KEY_BASE_TYPE);
        if (jSONObject != null && jSONObject.has("sub_type")) {
            str2 = jSONObject.optString("sub_type");
        }
        return optString + str + str2;
    }

    public static JSONObject makeAttributes() {
        return makeAttributes(FILTER_DEFAULT);
    }
}
