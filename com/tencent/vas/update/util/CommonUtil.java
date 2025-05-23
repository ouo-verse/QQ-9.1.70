package com.tencent.vas.update.util;

import android.text.TextUtils;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CommonUtil {
    public static final String STSTEM_TAG = "VasUpdate_";
    public static int TEST_TYPE;
    public static int sCookieId;

    public static int generateCookieId() {
        int i3 = sCookieId + 1;
        sCookieId = i3;
        return i3;
    }

    public static String sComposeItemId(long j3, String str) {
        return j3 + "_" + str;
    }

    public static long sParseBidId(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str.split("_")[0]);
        } catch (Throwable th5) {
            th5.printStackTrace();
            VasUpdateWrapper.getLog().e(STSTEM_TAG, "sParseBidId error itemId = " + str, th5);
            return 0L;
        }
    }

    public static String sParseScid(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(str.indexOf("_") + 1);
        } catch (Throwable th5) {
            th5.printStackTrace();
            VasUpdateWrapper.getLog().e(STSTEM_TAG, "sParseScid error itemId = " + str, th5);
            return "";
        }
    }
}
