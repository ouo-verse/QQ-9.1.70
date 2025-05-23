package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAppUtil {
    private static final String TAG = "AdAppUtil";

    public static boolean isInstalled(@Nullable Context context, String str) {
        PackageManager packageManager;
        if (context == null || TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            AdLog.e(TAG, "isInstalled error");
            return false;
        }
        try {
            if (packageManager.getApplicationInfo(str, 0) == null) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @NonNull
    public static AdError launch(@Nullable Activity activity, @Nullable String str, @Nullable Bundle bundle) {
        Intent intent;
        if (activity != null && !TextUtils.isEmpty(str)) {
            AdLog.i(TAG, String.format("launch %s", str));
            if (activity.getPackageManager() != null) {
                intent = InstalledAppListMonitor.getLaunchIntentForPackage(activity.getPackageManager(), str);
            } else {
                intent = null;
            }
            if (intent == null) {
                AdLog.e(TAG, "launch error");
                return new AdError(203);
            }
            if (bundle != null && !bundle.isEmpty()) {
                intent.putExtras(bundle);
            }
            try {
                activity.startActivity(intent);
                return new AdError(0);
            } catch (Throwable th5) {
                AdLog.e(TAG, "launch", th5);
                return new AdError(202, th5);
            }
        }
        AdLog.e(TAG, "launch error");
        return new AdError(4);
    }

    @Nullable
    public static ResolveInfo resolveActivity(@Nullable Context context, @Nullable Intent intent) {
        PackageManager packageManager;
        if (context != null && intent != null && (packageManager = context.getPackageManager()) != null) {
            return packageManager.resolveActivity(intent, 65536);
        }
        return null;
    }
}
