package com.tencent.gdtad.statistics;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtOriginalExposureReporter {
    public static final String ORIGINAL_EXPOSURE_ACTION_TYPE_INSTALLED = "2";
    private static final String ORIGINAL_EXPOSURE_ACTION_TYPE_KEY = "__ACTION_TYPE__";
    public static final String ORIGINAL_EXPOSURE_ACTION_TYPE_NONAPP = "0";
    public static final String ORIGINAL_EXPOSURE_ACTION_TYPE_UNINSTALLED = "1";
    public static final String ORIGINAL_EXPOSURE_VIEW_PERCENT = "1";
    private static final String ORIGINAL_EXPOSURE_VIEW_PERCENT_KEY = "__VIEW_PERCENT__";
    public static final String ORIGINAL_EXPOSURE_VIEW_TIME = "0";
    private static final String ORIGINAL_EXPOSURE_VIEW_TIME_KEY = "__VIEW_TIME__";
    public static final int PRODUCTTYPE_ERROR = -1;
    private static final String TAG = "GdtOriginalExposureReporter";
    public static HashSet<String> mOriginalExposureCache = new HashSet<>();

    @NonNull
    private static String getActionType(boolean z16, boolean z17) {
        if (z16) {
            if (z17) {
                return "2";
            }
            return "1";
        }
        return "0";
    }

    public static boolean isAppProductType(int i3) {
        if (i3 == 12) {
            return true;
        }
        return false;
    }

    public static String replaceUrlMacros(String str, int i3, Context context, String str2) {
        return replaceUrlMacros(str, i3, PackageUtil.isAppInstalled(context, str2));
    }

    public static void reportOriginalExposure(@Nullable GdtAd gdtAd, @Nullable Context context, int i3, boolean z16) {
        if (gdtAd != null && context != null) {
            String originalExposureUrl = gdtAd.getOriginalExposureUrl();
            if (TextUtils.isEmpty(originalExposureUrl)) {
                QLog.e(TAG, 1, "original exposure url is empty");
                return;
            }
            if (z16 && mOriginalExposureCache.contains(gdtAd.getTraceId())) {
                QLog.e(TAG, 1, "ad has original exposed");
                return;
            }
            String replaceUrlMacros = replaceUrlMacros(originalExposureUrl, getActionType(gdtAd.isAppProductType(), PackageUtil.isAppInstalled(context, gdtAd.getAppPackageName())), "1", "0");
            if (i3 >= 0) {
                replaceUrlMacros = replaceUrlMacros + "&slot=" + i3;
            }
            GdtReporter.doCgiReport(replaceUrlMacros);
            mOriginalExposureCache.add(gdtAd.getTraceId());
            QLog.d(TAG, 1, "original exposure report url: " + replaceUrlMacros);
            return;
        }
        QLog.e(TAG, 1, "gdtAd or context is null");
    }

    public static String replaceUrlMacros(String str, int i3, boolean z16) {
        return replaceUrlMacros(str, getActionType(isAppProductType(i3), z16), "1", "0");
    }

    public static String replaceUrlMacros(String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        return !TextUtils.isEmpty(str) ? str.replace(ORIGINAL_EXPOSURE_ACTION_TYPE_KEY, str2).replace(ORIGINAL_EXPOSURE_VIEW_PERCENT_KEY, str3).replace(ORIGINAL_EXPOSURE_VIEW_TIME_KEY, str4) : str;
    }

    public static void reportOriginalExposure(@Nullable GdtAd gdtAd, @Nullable Context context, int i3) {
        reportOriginalExposure(gdtAd, context, i3, true);
    }

    public static void reportOriginalExposure(GdtAd gdtAd, Context context) {
        reportOriginalExposure(gdtAd, context, -1);
    }
}
