package com.tencent.hippy.qq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyDebugUtil {
    private static final String DEBUG_TOOL_BUNDLE_NAME = "DebugTool";
    public static final int DEBUG_VERSION = 2147483646;
    public static String KEY_ENV_SWITCH = "envSwitch";
    public static String KEY_HIPPY_DEBUG = "key_extra_hippy_debug";
    public static String KEY_HIPPY_EXTRA_BUNDLE_NAME = "key_extra_bundle_name";
    public static String KEY_HIPPY_SERVER_HOST = "key_extra_serve_host";
    private static boolean isOpenDebugHippy = false;

    public static boolean deleteModule(String str, int i3) {
        if (!TextUtils.isEmpty(str) && isDebugEnable()) {
            if (((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(str) == i3) {
                ((IHippySetting) QRoute.api(IHippySetting.class)).setModuleVersion(str, -1);
            }
            FileUtils.deleteDirectory(((IHippySetting) QRoute.api(IHippySetting.class)).getModuleFile(str, i3).getAbsolutePath());
            return true;
        }
        return false;
    }

    public static void enableDebug(boolean z16) {
        if (!isDebugEnable()) {
            return;
        }
        HippyQQEngine.onDebugSwitchChanged(z16);
        getEditor().putBoolean(KEY_HIPPY_DEBUG, z16).commit();
    }

    public static void enableDebugModule(String str) {
        HippyQQEngine.onDebugModuleChanged(str);
        getEditor().putString(KEY_HIPPY_EXTRA_BUNDLE_NAME, str).commit();
    }

    public static void enableDebugPort(String str) {
        HippyQQEngine.onDebugPortChanged(str);
        getEditor().putString(KEY_HIPPY_SERVER_HOST, str).commit();
    }

    private static SharedPreferences.Editor getEditor() {
        return BaseApplication.getContext().getSharedPreferences(KEY_ENV_SWITCH, 4).edit();
    }

    public static String getHippyBundleName() {
        if (!isDebugEnable()) {
            return "Demo";
        }
        return BaseApplication.getContext().getSharedPreferences(KEY_ENV_SWITCH, 4).getString(KEY_HIPPY_EXTRA_BUNDLE_NAME, "Demo");
    }

    public static JSONArray getHippyModules() {
        JSONArray jSONArray = new JSONArray();
        if (!isDebugEnable()) {
            return jSONArray;
        }
        synchronized (HippyDebugUtil.class) {
            File hippyFileByType = ((IHippySetting) QRoute.api(IHippySetting.class)).getHippyFileByType("bundle");
            if (hippyFileByType == null) {
                return jSONArray;
            }
            for (File file : hippyFileByType.listFiles()) {
                String name = file.getName();
                if (!DEBUG_TOOL_BUNDLE_NAME.equals(name)) {
                    jSONArray.mo162put(name);
                }
            }
            return jSONArray;
        }
    }

    public static String getHippyServerHost() {
        if (!isDebugEnable()) {
            return "localhost:38989";
        }
        return BaseApplication.getContext().getSharedPreferences(KEY_ENV_SWITCH, 4).getString(KEY_HIPPY_SERVER_HOST, "localhost:38989");
    }

    public static HashMap<String, String> getLibraryVersions() {
        return ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).getLibraryVersions();
    }

    public static JSONArray getModuleInfo(String str) throws Exception {
        JSONArray jSONArray = new JSONArray();
        if (!isDebugEnable()) {
            return jSONArray;
        }
        synchronized (HippyDebugUtil.class) {
            File moduleFile = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleFile(str);
            if (moduleFile == null) {
                return jSONArray;
            }
            for (File file : moduleFile.listFiles()) {
                JSONObject jSONObject = new JSONObject();
                String name = file.getName();
                jSONObject.put("version", name);
                File file2 = new File(moduleFile, name);
                if (file2.exists()) {
                    File file3 = new File(file2, "config.json");
                    if (file3.exists()) {
                        jSONObject.put(DownloadInfo.spKey_Config, FileUtils.readFileToString(file3));
                        jSONArray.mo162put(jSONObject);
                    }
                }
            }
            return jSONArray;
        }
    }

    public static void gotoDebugTool(Context context) {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = DEBUG_TOOL_BUNDLE_NAME;
        openHippyInfo.framework = "react";
        openHippyInfo.enableOpenDebugHippy().openHippy(context);
    }

    public static boolean isDebugEnable() {
        if (!isOpenDebugHippy) {
            return false;
        }
        return true;
    }

    public static boolean isHippyDebug() {
        if (!isDebugEnable()) {
            return false;
        }
        return BaseApplication.getContext().getSharedPreferences(KEY_ENV_SWITCH, 4).getBoolean(KEY_HIPPY_DEBUG, false);
    }

    public static void setDebugModuleAndPort(String str, String str2) {
        if (!isDebugEnable()) {
            return;
        }
        enableDebugModule(str);
        enableDebugModule(str2);
    }

    public static void setOpenDebugHippyState(boolean z16) {
        isOpenDebugHippy = z16;
    }
}
