package com.tencent.qcircle.oscar.app;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.ttpic.baseutils.io.FileUtils;

/* loaded from: classes22.dex */
public class PAGSOLoadUtil {
    public static final String TAG = "PAGSOLoadUtil";
    private static boolean success = false;

    public static boolean loadSoSync(@NonNull String str) {
        boolean z16 = success;
        if (!z16) {
            if (TextUtils.isEmpty(str)) {
                success = false;
                Logger.e(TAG, "load so path is empty.");
                return success;
            }
            try {
                if (!FileUtils.exists(str)) {
                    success = false;
                    Logger.e(TAG, "load so file is not existed.");
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
                            Logger.e(str2, e16.getMessage());
                            Logger.d(str2, "load " + str + MsgSummary.STR_COLON + success);
                            return success;
                        }
                    } catch (Exception e17) {
                        success = false;
                        String str3 = TAG;
                        Logger.e(str3, e17.getMessage());
                        Logger.d(str3, "load " + str + MsgSummary.STR_COLON + success);
                        return success;
                    }
                } catch (UnsatisfiedLinkError e18) {
                    success = false;
                    String str4 = TAG;
                    Logger.e(str4, e18.getMessage());
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
}
