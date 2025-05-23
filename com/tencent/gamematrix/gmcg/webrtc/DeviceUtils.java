package com.tencent.gamematrix.gmcg.webrtc;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Pair;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes6.dex */
public class DeviceUtils {
    public static String getDeviceGuid(Context context) {
        String string = context.getSharedPreferences("tenc_cloudgame", 0).getString("device_guid", null);
        if (string == null) {
            String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
            context.getSharedPreferences("tenc_cloudgame", 0).edit().putString("device_guid", replaceAll).commit();
            return replaceAll;
        }
        return string;
    }

    public static String getDeviceInstanceId(Context context) {
        return DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
    }

    public static Pair<Integer, Integer> getOpenGLESVersion(Context context) {
        int i3 = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo().reqGlEsVersion;
        return new Pair<>(Integer.valueOf(((-65536) & i3) >> 16), Integer.valueOf(i3 & 65535));
    }
}
