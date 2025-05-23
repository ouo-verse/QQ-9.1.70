package com.tencent.thumbplayer.common;

import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;

/* loaded from: classes26.dex */
public class TPCryptoUtil {
    private static final String TAG = "TPCryptoUtil";

    public static String generateHttpToken(int i3, String str) {
        if (!TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            return "";
        }
        try {
            return native_generateHttpToken(i3, str);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.i(TAG, "call native_generateHttpToken has exception:" + e16.getMessage());
            return "";
        }
    }

    public static String generateHttpVerificationCode() {
        if (!TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            return "";
        }
        try {
            return native_generateHttpVerificationCode();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.i(TAG, "call native_generateHttpVerificationCode has exception:" + e16.getMessage());
            return "";
        }
    }

    private static native String native_generateHttpToken(int i3, String str);

    private static native String native_generateHttpVerificationCode();
}
