package com.tencent.qqmini.sdk.launcher.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class StorageUtil {
    public static long getDirUsedSpace(String str) {
        long j3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2 != null) {
                    j3 += getDirUsedSpace(file2.getAbsolutePath());
                }
            }
        }
        return j3;
    }

    public static SharedPreferences getPreference() {
        return SharedPreferencesUtil.getPreference();
    }
}
