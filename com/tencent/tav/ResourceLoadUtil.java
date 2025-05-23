package com.tencent.tav;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.tav.decoder.logger.Logger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ResourceLoadUtil {
    public static final String TAG = "ResourceLoadUtil";
    private static boolean success = false;

    public static boolean isLoaded() {
        return success;
    }

    public static boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Exception e16) {
            Logger.e(TAG, "loadFFmpegSo: ", e16);
            return false;
        }
    }

    public static boolean loadSoSync(@NonNull String str) {
        boolean z16 = success;
        if (!z16) {
            try {
                if (TextUtils.isEmpty(str)) {
                    success = false;
                    Logger.e(TAG, "load so path is empty.");
                    return success;
                }
                try {
                    try {
                        try {
                            System.load(str);
                            success = true;
                            Logger.d(TAG, "load " + str + MsgSummary.STR_COLON + success);
                            return success;
                        } catch (RuntimeException e16) {
                            success = false;
                            String str2 = TAG;
                            Logger.e(str2, "loadSoSync: load soPath = " + str, e16);
                            Logger.d(str2, "load " + str + MsgSummary.STR_COLON + success);
                            return success;
                        }
                    } catch (UnsatisfiedLinkError e17) {
                        success = false;
                        String str3 = TAG;
                        Logger.e(str3, "loadSoSync: load soPath = " + str, e17);
                        Logger.d(str3, "load " + str + MsgSummary.STR_COLON + success);
                        return success;
                    }
                } catch (Exception e18) {
                    success = false;
                    String str4 = TAG;
                    Logger.e(str4, "loadSoSync: load soPath = " + str, e18);
                    Logger.d(str4, "load " + str + MsgSummary.STR_COLON + success);
                    return success;
                }
            } catch (Throwable unused) {
                Logger.d(TAG, "load " + str + MsgSummary.STR_COLON + success);
                return success;
            }
        }
        return z16;
    }

    public static void setLoaded(boolean z16) {
        success = z16;
    }
}
