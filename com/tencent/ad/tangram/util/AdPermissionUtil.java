package com.tencent.ad.tangram.util;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;

/* loaded from: classes3.dex */
public final class AdPermissionUtil {
    private static final String TAG = "AdPermissionUtil";

    public static boolean checkPermission(@Nullable Context context, @Nullable String str) {
        if (context == null) {
            return false;
        }
        try {
            if (context.getApplicationContext() == null || TextUtils.isEmpty(str)) {
                return false;
            }
            if (context.getApplicationContext().checkCallingOrSelfPermission(str) != 0) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            AdLog.d(TAG, "checkPermission", th5);
            return false;
        }
    }
}
