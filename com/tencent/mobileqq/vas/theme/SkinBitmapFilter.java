package com.tencent.mobileqq.vas.theme;

import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinData;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SkinBitmapFilter {
    private static final String TAG = "SkinBitmapFilter";
    private static final List<String> sMonitorDrawable = Arrays.asList("qui_common_bg_bottom_standard_bg.xml", "qui_common_bg_primary_bg.xml");

    private boolean isMonitor(@NonNull SkinData skinData) {
        String str;
        if (!isQuiDrawable(skinData)) {
            return false;
        }
        String str2 = skinData.mFileName;
        if ((str2 == null || !sMonitorDrawable.contains(str2)) && ((str = skinData.mOriginalFileName) == null || !sMonitorDrawable.contains(str))) {
            return false;
        }
        return true;
    }

    private boolean isQuiDrawable(@NonNull SkinData skinData) {
        String str = skinData.mFileName;
        if (str == null) {
            return false;
        }
        if (str.startsWith("qui_")) {
            return true;
        }
        String str2 = skinData.mOriginalFileName;
        if (str2 == null || !str2.startsWith("qui_")) {
            return false;
        }
        return true;
    }

    private void printError(@NonNull SkinData skinData, String str) {
        String str2 = "[" + str + "] fileName=" + skinData.mFileName;
        if (!TextUtils.isEmpty(skinData.mOriginalFileName)) {
            str2 = str2 + " originalFileName=" + skinData.mOriginalFileName;
        }
        QLog.w(TAG, 1, Log.getStackTraceString(new RuntimeException(str2)));
    }

    public boolean needBlockSetAlpha(SkinData skinData, int i3) {
        if (skinData != null && i3 != 255) {
            if (isMonitor(skinData)) {
                printError(skinData, "onAlphaSet, alpha=" + i3);
                return true;
            }
            if (QLog.isDevelopLevel() && isQuiDrawable(skinData)) {
                printError(skinData, "onAlphaSet");
            }
        }
        return false;
    }

    public boolean needBlockSetColorFilter(SkinData skinData, ColorFilter colorFilter) {
        if (skinData == null) {
            return false;
        }
        if (isMonitor(skinData)) {
            printError(skinData, "onColorFilterSet");
            return true;
        }
        if (QLog.isDevelopLevel() && isQuiDrawable(skinData)) {
            printError(skinData, "onColorFilterSet");
        }
        return false;
    }
}
