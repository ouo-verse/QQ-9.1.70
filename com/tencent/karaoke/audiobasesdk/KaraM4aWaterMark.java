package com.tencent.karaoke.audiobasesdk;

import android.text.TextUtils;
import com.tencent.component.utils.LogUtil;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.File;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraM4aWaterMark {
    private static final String TAG = "KaraM4aWaterMark";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();

    public static String getTempFilePath(String str) {
        if (str.endsWith(".m4a")) {
            return str.substring(0, str.length() - 4) + "_temp.m4a";
        }
        if (str.endsWith(".mp4")) {
            return str.substring(0, str.length() - 4) + "_temp.mp4";
        }
        return str + "_temp";
    }

    public static String getWaterMark(String str, String str2) {
        if (!mIsLoaded) {
            LogUtil.e(TAG, "is not loaded");
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "path is null");
            return "";
        }
        if (new File(str).exists()) {
            LogUtil.d(TAG, "file exist");
            String native_getWaterMark = native_getWaterMark(str, str2);
            LogUtil.i(TAG, "getWaterMark value= " + native_getWaterMark);
            return native_getWaterMark;
        }
        LogUtil.e(TAG, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
        return "";
    }

    private static native String native_getWaterMark(String str, String str2);

    private static native int native_readWaterMark(String str);

    private static native int native_setWaterMark(String str, String str2, String str3, String str4);

    private static native int native_writeWaterMark(String str, String str2, int i3);

    public static int readWaterMark(String str) {
        if (mIsLoaded) {
            if (TextUtils.isEmpty(str)) {
                LogUtil.w(TAG, "readWaterMark -> filePath is empty, so do nothing");
                return -2;
            }
            return native_readWaterMark(str);
        }
        return -1;
    }

    public static int setWaterMark(String str, String str2, String str3, String str4) {
        if (!mIsLoaded) {
            return -3;
        }
        if (TextUtils.isEmpty(str)) {
            LogUtil.w(TAG, "writeWaterMark -> filePath is empty, so do nothing");
            return -2;
        }
        try {
            int native_setWaterMark = native_setWaterMark(new String(str.getBytes("utf-8")), new String(str2.getBytes("utf-8")), new String(str3.getBytes("utf-8")), new String(str4.getBytes("utf-8")));
            LogUtil.d(TAG, "setWaterMark: ret = " + native_setWaterMark);
            return native_setWaterMark;
        } catch (Exception e16) {
            LogUtil.e(TAG, "params data error: ", e16);
            return -3;
        }
    }

    public static int writeWaterMark(String str, String str2, int i3) {
        if (mIsLoaded) {
            if (TextUtils.isEmpty(str)) {
                LogUtil.w(TAG, "writeWaterMark -> filePath is empty, so do nothing");
                return -2;
            }
            return native_writeWaterMark(str, str2, i3);
        }
        return -1;
    }
}
