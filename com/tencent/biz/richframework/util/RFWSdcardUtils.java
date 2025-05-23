package com.tencent.biz.richframework.util;

import android.os.Environment;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWSdcardUtils {
    public static String sSdCardDir;

    public static String getSdCardDirectory() {
        if (!TextUtils.isEmpty(sSdCardDir)) {
            return sSdCardDir;
        }
        if (sdCardExists()) {
            sSdCardDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return sSdCardDir;
    }

    public static boolean sdCardExists() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable unused) {
            return false;
        }
    }
}
