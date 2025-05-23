package com.tencent.qphone.base.util;

import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static boolean a() {
        AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService("audio");
        if (audioManager != null && audioManager.getRingerMode() == 2) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        String str = Build.MANUFACTURER + DeviceInfoMonitor.getModel();
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("xiaomi")) {
            if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "vibrate_in_normal", -1) != 1) {
                return false;
            }
            return true;
        }
        if (Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "vibrate_when_ringing", -1) != 1) {
            return false;
        }
        return true;
    }

    public static boolean c() {
        AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService("audio");
        if (audioManager != null && audioManager.getRingerMode() == 0) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService("audio");
        if (audioManager != null && audioManager.getRingerMode() == 1) {
            return true;
        }
        return false;
    }
}
