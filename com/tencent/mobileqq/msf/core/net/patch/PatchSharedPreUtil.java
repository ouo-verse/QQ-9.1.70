package com.tencent.mobileqq.msf.core.net.patch;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes15.dex */
public class PatchSharedPreUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String FILE_NAME = "installed_patch_name.txt";
    private static final String KEY_CONFIG_VERSION_PATCH = "key_config_version_patch";
    private static final String KEY_COUNT_FAIL_INSTALL_PATCH = "key_count_fail_install_patch_";
    private static final String KEY_COUNT_FAIL_STARTUP_PATCH = "key_count_fail_startup_patch_";
    private static final String KEY_PREFIX_CONFIG_PATCH = "key_config_patch_";
    private static final String KEY_TIME_PULL_PATCH_RECONNECT = "key_time_pull_patch_reconnect";
    private static final String KEY_VERIFY_STATUS_PATCH = "key_verify_status_patch_";
    public static final String SHARED_PREFERENCE_HOTPATCH = "hotpatch_preference";

    public PatchSharedPreUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getCountFailInstallPatch(Context context, String str, String str2) {
        return context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).getInt(KEY_COUNT_FAIL_INSTALL_PATCH + str + str2, 0);
    }

    public static int getCountFailStartupPatch(Context context, String str, String str2) {
        return context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).getInt(KEY_COUNT_FAIL_STARTUP_PATCH + str + str2, 0);
    }

    public static String getInstalledPatchName(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        String str2;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(context.getFilesDir(), FILE_NAME);
            byte[] bArr = new byte[256];
            if (file.exists()) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        str2 = new String(bArr, 0, read);
                    } else {
                        str2 = null;
                    }
                    bufferedInputStream2 = bufferedInputStream;
                } catch (Throwable unused) {
                    if (bufferedInputStream == null) {
                        return null;
                    }
                    try {
                        bufferedInputStream.close();
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            } else {
                str2 = null;
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused3) {
                }
            }
            return str2;
        } catch (Throwable unused4) {
            bufferedInputStream = null;
        }
    }

    public static long getLastTimePullPatchReconnect(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).getLong(KEY_TIME_PULL_PATCH_RECONNECT, 0L);
    }

    public static String getPatchConfig(Context context, String str) {
        return context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).getString(KEY_PREFIX_CONFIG_PATCH + str, null);
    }

    public static int getPatchConfigVersion(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).getInt(KEY_CONFIG_VERSION_PATCH, 0);
    }

    public static String getPatchReportInfo(Context context, String str) {
        return context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).getString(str, null);
    }

    public static boolean getPatchVerifyStatus(Context context, String str) {
        return context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).getBoolean(KEY_VERIFY_STATUS_PATCH + str, false);
    }

    public static void saveInstalledPatchName(Context context, String str, String str2) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(context.getFilesDir(), FILE_NAME);
            if (TextUtils.isEmpty(str2)) {
                if (file.exists()) {
                    file.delete();
                }
            } else {
                byte[] bytes = str2.getBytes();
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bufferedOutputStream2.write(bytes);
                    bufferedOutputStream = bufferedOutputStream2;
                } catch (Throwable unused) {
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream == null) {
                        return;
                    }
                    bufferedOutputStream.close();
                }
            }
            if (bufferedOutputStream == null) {
                return;
            }
        } catch (Throwable unused2) {
        }
        try {
            bufferedOutputStream.close();
        } catch (IOException unused3) {
        }
    }

    public static void updateCountFailInstallPatch(Context context, String str, String str2, int i3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).edit();
        edit.putInt(KEY_COUNT_FAIL_INSTALL_PATCH + str + str2, i3);
        edit.commit();
    }

    public static void updateCountFailStartupPatch(Context context, String str, String str2, int i3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).edit();
        edit.putInt(KEY_COUNT_FAIL_STARTUP_PATCH + str + str2, i3);
        edit.commit();
    }

    public static void updateLastTimePullPatchReconnect(Context context, long j3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).edit();
        edit.putLong(KEY_TIME_PULL_PATCH_RECONNECT, j3);
        edit.commit();
    }

    public static void updatePatchConfig(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).edit();
        edit.putString(KEY_PREFIX_CONFIG_PATCH + str, str2);
        edit.commit();
    }

    public static void updatePatchConfigVersion(Context context, int i3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).edit();
        edit.putInt(KEY_CONFIG_VERSION_PATCH, i3);
        edit.commit();
    }

    public static void updatePatchReportInfo(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static void updatePatchVerifyStatus(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCE_HOTPATCH, 4).edit();
        edit.putBoolean(KEY_VERIFY_STATUS_PATCH + str, z16);
        edit.commit();
    }
}
