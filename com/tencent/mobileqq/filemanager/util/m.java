package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class m {
    public static boolean a(String str, String str2) {
        try {
            JSONObject b16 = b(str);
            if (b16 == null) {
                QLog.i("FilePicTabMCSwitch", 1, "getMCQQSwitchOn exception");
                return false;
            }
            boolean optBoolean = b16.optBoolean(str2, false);
            QLog.i("FilePicTabMCSwitch", 1, "getMCQQSwitchOn: " + optBoolean + " hasKey:" + b16.has(str2) + " content=" + b16);
            return optBoolean;
        } catch (Throwable unused) {
            QLog.i("FilePicTabMCSwitch", 1, "getMCQQSwitchOn exception");
            return false;
        }
    }

    public static JSONObject b(String str) {
        String str2;
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(str, new byte[0]);
        if (loadRawConfig != null && loadRawConfig.length != 0) {
            try {
                str2 = new String(loadRawConfig, StandardCharsets.UTF_8);
                try {
                    return new JSONObject(str2);
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("FilePicTabMCSwitch", 1, "parse raw config failed!!! str: " + str2 + "\n", e);
                    return null;
                }
            } catch (Exception e17) {
                e = e17;
                str2 = null;
            }
        } else {
            QLog.e("FilePicTabMCSwitch", 1, "get null raw config!!! groupId: " + str);
            return null;
        }
    }

    public static boolean c() {
        if (!a("105663", "switchOn")) {
            return false;
        }
        return true;
    }
}
