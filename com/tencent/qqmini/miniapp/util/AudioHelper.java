package com.tencent.qqmini.miniapp.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AudioHelper {
    private static final String CLASS_NAME_APPOPSMANAGER = "AppOpsManager";
    private static final int MODE_ALLOWED = 0;
    private static final int OP_CEMARE_BEFORE_MEIZU_API19 = 35;
    private static final int OP_CEMARE_IN_ANDROID_SDK_API19 = 26;
    private static final int OP_RECORD_AUDIO_BEFORE_MEIZU_API19 = 36;
    private static final int OP_RECORD_AUDIO_IN_ANDROID_SDK_API19 = 27;
    public static final int OP_TYPE_CEMARE = 0;
    public static final int OP_TYPE_RECORD = 1;
    private static final String TAG = "AudioHelper";
    private static final int[] OP_IN_ANDROID_SDK_BEFORE_API19 = {35, 36};
    private static final int[] OP_IN_ANDROID_SDK_API19 = {26, 27};

    public static boolean isForbidByRubbishMeizu(int i3) {
        return isForbidByRubbishMeizu(i3, AppLoaderFactory.g().getContext());
    }

    private static boolean isRubbishMeizuPhone() {
        return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isForbidByRubbishMeizu(int i3, Context context) {
        Object systemService;
        if (isRubbishMeizuPhone() && (systemService = context.getSystemService("appops")) != null && systemService.getClass().getSimpleName().equals("AppOpsManager")) {
            try {
                Class<?> cls = systemService.getClass();
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod(AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class);
                int i16 = OP_IN_ANDROID_SDK_API19[i3];
                ApplicationInfo applicationInfo = AppLoaderFactory.g().getContext().getApplicationInfo();
                int intValue = ((Integer) method.invoke(systemService, Integer.valueOf(i16), Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue();
                QMLog.d(TAG, "isForbidByRubbishMeizu(), result = " + intValue);
                return intValue != 0;
            } catch (Exception e16) {
                QMLog.e(TAG, e16.toString());
            }
        }
        return false;
    }
}
