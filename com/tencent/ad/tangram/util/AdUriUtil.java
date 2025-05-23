package com.tencent.ad.tangram.util;

import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdUriUtil {
    private static final String TAG = "AdUriUtil";

    @Nullable
    public static String getQueryParameter(@Nullable Uri uri, String str) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                return uri.getQueryParameter(str);
            } catch (Throwable th5) {
                AdLog.e(TAG, "getQueryParameter", th5);
            }
        }
        return null;
    }

    @Nullable
    public static Uri parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Uri.parse(str);
        } catch (Throwable th5) {
            AdLog.e(TAG, "parse", th5);
            return null;
        }
    }

    public static String replaceHttpsWithHttpForVivoY67OnAndroidM(String str) {
        if (TextUtils.isEmpty(DeviceInfoMonitor.getModel()) || !DeviceInfoMonitor.getModel().toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) || !DeviceInfoMonitor.getModel().toLowerCase().contains("y67") || Build.VERSION.SDK_INT != 23) {
            return str;
        }
        return replaceSchemaOfUrl(str, "https", "http");
    }

    private static String replaceSchemaOfUrl(String str, @NonNull String str2, String str3) {
        Uri parse;
        Uri.Builder buildUpon;
        Uri.Builder scheme;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (parse = parse(str)) == null || !str2.equalsIgnoreCase(parse.getScheme()) || (buildUpon = parse.buildUpon()) == null || (scheme = buildUpon.scheme(str3)) == null) {
            return str;
        }
        return scheme.toString();
    }
}
