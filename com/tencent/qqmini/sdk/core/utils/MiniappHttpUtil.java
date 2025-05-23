package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniappHttpUtil {
    public static final int LOCAL_RET_CODE_ABORTED = -5;
    public static final int LOCAL_RET_CODE_CONNECT = -2;
    public static final int LOCAL_RET_CODE_EXCEPTION = -1;
    public static final int LOCAL_RET_CODE_METHOD_NOT_SUPPORT = -3;
    public static final int LOCAL_RET_CODE_URL_INVALID = -4;
    private static final String TAG = "MiniappHttpUtil";

    public static String convertCode2Reason(String str, int i3) {
        if (i3 != -5) {
            if (i3 != -3 && i3 != -2) {
                return "unknown reason";
            }
            return "request protocol error";
        }
        if (TextUtils.isEmpty(str)) {
            return "abort";
        }
        return str + ":fail abort";
    }

    public static boolean isRefererVersionValid(String str) {
        if (TextUtils.isEmpty(str) && !FastClickUtils.isFastDoubleClick(TAG, 500L)) {
            QMLog.e(TAG, "version is null, return.");
            return false;
        }
        if (TextUtils.isEmpty(str) && FastClickUtils.isFastDoubleClick(TAG, 500L)) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if ((charAt <= 31 && charAt != '\t') || charAt >= '\u007f') {
                return false;
            }
        }
        return true;
    }
}
