package com.tencent.hippy.qq.utils;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyCommonUtils {
    public static void checkDebugHippyUpdate(QQAppInterface qQAppInterface, AppActivity appActivity, String str) {
        if (!isMqqapi(str)) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("module");
            String queryParameter2 = parse.getQueryParameter("url");
            String queryParameter3 = parse.getQueryParameter("framework");
            String str2 = "mqqapi://hippy/open?bundleName=" + queryParameter + "&bundleUrl=" + queryParameter2;
            if (!TextUtils.isEmpty(queryParameter3)) {
                str = str2 + "&framework=" + queryParameter3;
            } else {
                str = str2;
            }
        }
        handleMqqJump(qQAppInterface, appActivity, str);
    }

    public static boolean checkHippyQRCode(String str) {
        TextUtils.isEmpty(str);
        return false;
    }

    public static AppInterface getAppInterface() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null) {
            return null;
        }
        AppRuntime runtime = application.getRuntime();
        if (runtime instanceof ToolAppRuntime) {
            AppRuntime appRuntime = runtime.getAppRuntime("modular_web");
            if (!(appRuntime instanceof AppInterface)) {
                return null;
            }
            return (AppInterface) appRuntime;
        }
        if (!(runtime instanceof AppInterface)) {
            return null;
        }
        return (AppInterface) runtime;
    }

    public static void handleMqqJump(QQAppInterface qQAppInterface, Activity activity, String str) {
        ax c16 = bi.c(qQAppInterface, activity, str);
        if (c16 != null) {
            c16.b();
        }
    }

    private static boolean hasHippyParams(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("module");
        String queryParameter2 = parse.getQueryParameter("url");
        if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2)) {
            return true;
        }
        return false;
    }

    public static Map<String, Object> hippyMapToMap(HippyMap hippyMap) {
        Set<Map.Entry<String, Object>> entrySet;
        HashMap hashMap = new HashMap();
        if (hippyMap != null && hippyMap.size() != 0 && (entrySet = hippyMap.entrySet()) != null && entrySet.size() != 0) {
            for (Map.Entry<String, Object> entry : entrySet) {
                if (entry != null && entry.getKey() != null) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return hashMap;
    }

    private static boolean isMqqapi(String str) {
        return str.startsWith(SchemaUtils.SCHEMA_MQQAPI);
    }

    private static boolean isQbScheme(String str) {
        if (!str.startsWith("qb://react") && !str.startsWith("qb://hippy")) {
            return false;
        }
        return true;
    }
}
