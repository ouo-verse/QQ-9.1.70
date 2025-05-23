package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SettingUtil {
    private static final String TAG = "SettingUtil";

    public static int getSecureInt(ContentResolver contentResolver, String str, int i3) {
        try {
            return Settings.Secure.getInt(contentResolver, str, i3);
        } catch (RuntimeException e16) {
            Logger.e(TAG, "Settings Secure getInt throwFromSystemServer:", e16);
            return i3;
        }
    }

    public static int getSystemInt(ContentResolver contentResolver, String str, int i3) {
        try {
            return Settings.System.getInt(contentResolver, str, i3);
        } catch (RuntimeException e16) {
            Logger.e(TAG, "Settings System getInt throwFromSystemServer:", e16);
            return i3;
        }
    }
}
