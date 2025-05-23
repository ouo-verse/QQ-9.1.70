package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTabConfigManager {
    private static final String TAG = "HippyTabConfigManager";

    private static String getMMKVFileNameKey(String str, String str2) {
        return MMKVCommonFileKeys.TAB_CONFIG_FILE_NAME_PREFIX + str + util.base64_pad_url + str2;
    }

    private static String getMMKVMd5Key(String str, String str2) {
        return MMKVCommonFileKeys.TAB_CONFIG_MD5_PREFIX + str + "_" + str2;
    }

    public static String getTabConfigFileMd5(String str, String str2) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(getMMKVMd5Key(str, str2), "");
    }

    public static File getTabFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(getMMKVFileNameKey(str, str2), null);
        if (TextUtils.isEmpty(decodeString)) {
            return null;
        }
        return new File(new File(HippyQQFileUtil.getTabConfigDir(), str), decodeString);
    }

    public static void handleTabConfigResponse(int i3, final String str, final String str2) {
        if (i3 == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.update.c
                @Override // java.lang.Runnable
                public final void run() {
                    HippyTabConfigManager.storeTabConfigs(str2, str);
                }
            }, 64, null, true);
        }
    }

    private static boolean storeTabConfig(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str3) && str4 != null) {
            try {
                File file = new File(HippyQQFileUtil.getTabConfigDir(), str);
                String str5 = str2 + util.base64_pad_url + System.currentTimeMillis();
                File file2 = new File(file, str5);
                if (file2.exists()) {
                    file2.delete();
                }
                if (!FileUtils.writeFile(file2.getAbsolutePath(), str4)) {
                    QLog.e(TAG, 1, "storeTabFile failed fileKey:", str2);
                    return false;
                }
                String mMKVMd5Key = getMMKVMd5Key(str, str2);
                String mMKVFileNameKey = getMMKVFileNameKey(str, str2);
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                String decodeString = from.decodeString(mMKVFileNameKey, null);
                from.encodeString(mMKVMd5Key, str3).encodeString(mMKVFileNameKey, str5).commitAsync();
                if (!TextUtils.isEmpty(decodeString)) {
                    File file3 = new File(file, decodeString);
                    if (file3.exists()) {
                        file3.delete();
                    }
                }
                return true;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "storeTabFile key:", str2, " error:", th5);
                return false;
            }
        }
        QLog.e(TAG, 1, "storeTabFile params error.");
        return false;
    }

    public static void storeTabConfigs(String str, String str2) {
        try {
            JSONObject optJSONObject = new JSONObject(str2).optJSONObject("tabFileList");
            if (optJSONObject == null) {
                QLog.e(TAG, 1, "[parseTabJson] filesObj is null.");
                return;
            }
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                if (TextUtils.isEmpty(str3)) {
                    QLog.e(TAG, 1, "[parseTabJson] key is empty");
                } else {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(str3);
                    if (optJSONObject2 == null) {
                        QLog.e(TAG, 1, "[parseTabJson] fileObj is empty");
                    } else {
                        storeTabConfig(str, str3, optJSONObject2.optString("tabFileMd5"), optJSONObject2.optString("tabFileJson"));
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "parseTabJson error:", th5);
        }
    }
}
