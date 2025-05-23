package com.tencent.hippy.qq.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFilePathUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import org.apache.http.HttpResponse;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyFileManagerUtil {
    private static final String CONTENT = "content";
    private static final String DIR_PATH = AppConstants.SDCARD_FILE_SAVE_PATH + "Hippy/Photo/";
    private static final String IMG_PATH = "imgPath";
    private static final String MSG = "msg";
    private static final String MSG_DATA_INVALID = "\u65e0\u6548\u6570\u636e";
    private static final String MSG_DOWNLOAD_FAILURE = "\u4e0b\u8f7d\u5931\u8d25";
    private static final String MSG_FILE_NOT_EXIST = "\u6587\u4ef6\u4e0d\u5b58\u5728";
    private static final String MSG_NO_PERMISSION = "\u65e0\u76f8\u518c\u8bbf\u95ee\u6743\u9650";
    private static final String MSG_SAVE_FAILURE = "\u4fdd\u5b58\u5931\u8d25";
    private static final String MSG_SAVE_SUCCESS = "\u4fdd\u5b58\u6210\u529f";
    private static final String RET_CODE = "retCode";
    private static final int RET_CODE_DATA_INVALID = -2;
    private static final int RET_CODE_DOWNLOAD_FAILURE = -4;
    private static final int RET_CODE_FILE_NOT_EXIST = -1;
    private static final int RET_CODE_NO_PERMISSION = -3;
    private static final int RET_CODE_SAVE_FAILURE = -5;
    private static final int RET_CODE_SAVE_SUCCESS = 0;
    private static final String STATUS_CODE = "statusCode";
    public static final String TAG = "HippyFileManagerUtil";

    private static String getCurrentTime() {
        return String.format(Locale.getDefault(), "img_%d_%02d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf((int) (Math.random() * 10.0d)));
    }

    private static String getImageType(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(47)) == -1) {
            return "";
        }
        return "." + str.substring(indexOf + 1);
    }

    private static HippyMap getResultHippyMap(int i3, String str) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("retCode", i3);
        hippyMap.pushString("msg", str);
        return hippyMap;
    }

    public static void saveImage(final Context context, HippyMap hippyMap, final HippyResultCodeCallback hippyResultCodeCallback) {
        if (!BaseForwardUtil.b(context)) {
            hippyResultCodeCallback.callBack(getResultHippyMap(-3, MSG_NO_PERMISSION));
            return;
        }
        final String string = hippyMap.getString(IMG_PATH);
        final String string2 = hippyMap.getString("content");
        try {
            if (!TextUtils.isEmpty(string)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.utils.HippyFileManagerUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HippyFileManagerUtil.saveImageByFilePath(string, hippyResultCodeCallback);
                    }
                }, 64, null, true);
            } else {
                if (!string2.startsWith("http://") && !string2.startsWith("https://")) {
                    if (string2.startsWith("data:")) {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.utils.HippyFileManagerUtil.3
                            @Override // java.lang.Runnable
                            public void run() {
                                HippyFileManagerUtil.saveImageByBase64(string2, hippyResultCodeCallback);
                            }
                        }, 64, null, true);
                    } else {
                        hippyResultCodeCallback.callBack(getResultHippyMap(-2, MSG_DATA_INVALID));
                    }
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.utils.HippyFileManagerUtil.2
                    @Override // java.lang.Runnable
                    public void run() {
                        HippyFileManagerUtil.saveImageByUrl(context, string2, hippyResultCodeCallback);
                    }
                }, 128, null, true);
            }
        } catch (Exception unused) {
            hippyResultCodeCallback.callBack(getResultHippyMap(-5, MSG_SAVE_FAILURE));
        }
    }

    public static void saveImageByBase64(String str, HippyResultCodeCallback hippyResultCodeCallback) {
        byte[] decode;
        int indexOf = str.indexOf(",");
        if (indexOf > 0) {
            try {
                decode = PluginBaseInfoHelper.Base64Helper.decode(str.substring(indexOf), 0);
            } catch (OutOfMemoryError unused) {
                hippyResultCodeCallback.callBack(getResultHippyMap(-5, MSG_SAVE_FAILURE));
                return;
            }
        } else {
            decode = null;
        }
        if (decode == null) {
            hippyResultCodeCallback.callBack(getResultHippyMap(-2, MSG_DATA_INVALID));
            return;
        }
        String saveImageByteToFile = saveImageByteToFile(decode, hippyResultCodeCallback);
        if (!TextUtils.isEmpty(saveImageByteToFile)) {
            saveImageByFilePath(saveImageByteToFile, hippyResultCodeCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveImageByFilePath(String str, HippyResultCodeCallback hippyResultCodeCallback) {
        try {
            if (TextUtils.isEmpty(((IFilePathUtil) QRoute.api(IFilePathUtil.class)).copyImageFileToMediaStorage(str))) {
                hippyResultCodeCallback.callBack(getResultHippyMap(-1, "\u6587\u4ef6\u4e0d\u5b58\u5728"));
            } else {
                hippyResultCodeCallback.callBack(getResultHippyMap(0, MSG_SAVE_SUCCESS));
            }
        } catch (Exception unused) {
            hippyResultCodeCallback.callBack(getResultHippyMap(-2, MSG_DATA_INVALID));
        } catch (OutOfMemoryError unused2) {
            hippyResultCodeCallback.callBack(getResultHippyMap(-5, MSG_SAVE_FAILURE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveImageByUrl(Context context, String str, HippyResultCodeCallback hippyResultCodeCallback) {
        int i3;
        try {
            HttpResponse openRequest = HttpUtil.openRequest(context, str, null, "GET", null, null);
            if (openRequest != null) {
                i3 = openRequest.getStatusLine().getStatusCode();
            } else {
                i3 = 0;
            }
            if (i3 == 200) {
                String saveImageByteToFile = saveImageByteToFile(HttpUtil.readHttpResponseSteam(openRequest).toByteArray(), hippyResultCodeCallback);
                if (!TextUtils.isEmpty(saveImageByteToFile)) {
                    saveImageByFilePath(saveImageByteToFile, hippyResultCodeCallback);
                    return;
                }
            } else {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt("retCode", -4);
                hippyMap.pushString("msg", MSG_DOWNLOAD_FAILURE);
                hippyMap.pushInt("statusCode", i3);
                hippyResultCodeCallback.callBack(hippyMap);
            }
            hippyResultCodeCallback.callBack(getResultHippyMap(-5, MSG_SAVE_FAILURE));
        } catch (IOException unused) {
            hippyResultCodeCallback.callBack(getResultHippyMap(-5, MSG_SAVE_FAILURE));
        } catch (IllegalArgumentException unused2) {
            hippyResultCodeCallback.callBack(getResultHippyMap(-2, MSG_DATA_INVALID));
        }
    }

    private static String saveImageByteToFile(byte[] bArr, HippyResultCodeCallback hippyResultCodeCallback) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        String imageType = getImageType(options.outMimeType);
        if (TextUtils.isEmpty(imageType)) {
            hippyResultCodeCallback.callBack(getResultHippyMap(-2, MSG_DATA_INVALID));
            return "";
        }
        try {
            String str = DIR_PATH;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = str + getCurrentTime() + imageType;
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return str2;
        } catch (IOException unused) {
            hippyResultCodeCallback.callBack(getResultHippyMap(-5, MSG_SAVE_FAILURE));
            return "";
        }
    }
}
