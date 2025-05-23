package com.tencent.upload.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.image.ImageProcessUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.utils.BitmapUtils;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ImageCompressor {
    static IPatchRedirector $redirector_ = null;
    public static final int GIF_COPY_SATISFY = 2;
    public static final int GIF_COPY_UNSATISFY = 5;
    public static final int GIF_ONESHOT_COPY = 3;
    public static final int GIF_ORIGINAL_SATISFY = 1;
    public static final int GIF_ORIGINAL_UNSATISFY = 4;
    private static final String TAG = "ImageProcessor";

    public ImageCompressor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final void abortTask(AbstractUploadTask abstractUploadTask, int i3, String str, String str2, boolean z16) {
        IUploadTaskCallback iUploadTaskCallback = abstractUploadTask.uploadTaskCallback;
        if (iUploadTaskCallback != null) {
            iUploadTaskCallback.onUploadError(abstractUploadTask, i3, str2);
            abstractUploadTask.uploadTaskCallback.onUploadStateChange(abstractUploadTask, 5);
            UploadLog.v(TAG, "abortTask flowId:" + abstractUploadTask.flowId);
        }
        UploadLog.w(TAG, str);
    }

    public static final boolean copyTaskFile(AbstractUploadTask abstractUploadTask) {
        String tempFilePath = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), abstractUploadTask.getFilePath(), abstractUploadTask.md5, abstractUploadTask.flowId);
        if (TextUtils.isEmpty(tempFilePath)) {
            return false;
        }
        boolean copyFile = FileUtils.copyFile(abstractUploadTask.getFilePath(), tempFilePath);
        if (copyFile) {
            abstractUploadTask.setTmpFilePath(tempFilePath);
        }
        return copyFile;
    }

    public static String getTaskTempFile(AbstractUploadTask abstractUploadTask, Context context) {
        return FileUtils.getTempFilePath(context, abstractUploadTask.uploadFilePath, abstractUploadTask.md5, abstractUploadTask.flowId);
    }

    public static IUploadConfig.UploadImageSize getUploadImageSize(AbstractUploadTask abstractUploadTask, int i3) {
        int i16;
        String filePath = abstractUploadTask.getFilePath();
        if (!new File(filePath).exists()) {
            return null;
        }
        BitmapFactory.Options decodeBitmapOptions = ImageProcessUtil.decodeBitmapOptions(filePath);
        boolean equalsIgnoreCase = "image/jpeg".equalsIgnoreCase(decodeBitmapOptions.outMimeType);
        if (decodeBitmapOptions.outWidth == 0 && decodeBitmapOptions.outHeight == 0) {
            UploadLog.e(TAG, "getUploadImageSize size illegal. path=" + filePath);
            return null;
        }
        if (equalsIgnoreCase) {
            i16 = UploadConfiguration.getPictureQuality(filePath);
        } else {
            i16 = 100;
        }
        if (i16 <= 0) {
            i16 = 100;
        }
        IUploadConfig config = UploadGlobalConfig.getConfig();
        IUploadConfig.UploadImageSize uploadImageSize = new IUploadConfig.UploadImageSize(decodeBitmapOptions.outWidth, decodeBitmapOptions.outHeight, 100);
        boolean z16 = false;
        IUploadConfig.UploadImageSize uploadImageSize2 = config.getUploadImageSize(uploadImageSize, i3, new ImageUploadTask(false, filePath));
        UploadLog.d(TAG, "getUploadImageSize size=" + uploadImageSize + " targetSize=" + uploadImageSize2 + " q:" + i16 + " jpg:" + equalsIgnoreCase);
        if (uploadImageSize2 == null || uploadImageSize2.height <= 0 || uploadImageSize2.width <= 0 || uploadImageSize2.quality <= 0) {
            z16 = true;
        }
        if (!z16 && (uploadImageSize.width > uploadImageSize2.width || uploadImageSize.height > uploadImageSize2.height || i16 > uploadImageSize2.quality)) {
            if (i16 < uploadImageSize2.quality) {
                uploadImageSize2.quality = i16;
            }
            return uploadImageSize2;
        }
        return uploadImageSize;
    }

    public static boolean isGifPicture(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        return "image/gif".equalsIgnoreCase(ImageProcessUtil.decodeBitmapOptions(str).outMimeType);
    }

    public static final void processGif(AbstractUploadTask abstractUploadTask) {
        char c16;
        char c17;
        boolean z16;
        int currentNetworkCategory = UploadConfiguration.getCurrentNetworkCategory();
        long length = new File(abstractUploadTask.getFilePath()).length();
        UploadLog.i(TAG, "processGif, networkType:" + currentNetworkCategory + " length:" + length + " flowId:" + abstractUploadTask.flowId);
        if (length < UploadConfiguration.getGifUploadLimit(currentNetworkCategory)) {
            UploadLog.v(TAG, "processGif() \u6ee1\u8db3\u4e0a\u4f20\u539f\u56fe\u6761\u4ef6 flowId=" + abstractUploadTask.flowId);
            if (copyTaskFile(abstractUploadTask)) {
                c17 = 2;
            } else {
                c17 = 1;
            }
        } else {
            Bitmap decodeFileWithRetry = ImageProcessUtil.decodeFileWithRetry(abstractUploadTask.getFilePath(), BitmapUtils.getOptions());
            String tempFilePath = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), abstractUploadTask.getFilePath(), abstractUploadTask.md5, abstractUploadTask.flowId);
            if (decodeFileWithRetry != null && tempFilePath != null && ImageProcessUtil.bitmapToFile(decodeFileWithRetry, tempFilePath, 80, false, false, null)) {
                abstractUploadTask.uploadFilePath = tempFilePath;
                decodeFileWithRetry.recycle();
                UploadLog.v(TAG, "processGif() \u53d6\u7b2c\u4e00\u5e27\u4e0a\u4f20 flowId=" + abstractUploadTask.flowId);
                decodeFileWithRetry = null;
                c16 = (char) 3;
            } else {
                UploadLog.v(TAG, "processGif() \u4e0a\u4f20\u539f\u56fe flowId=" + abstractUploadTask.flowId);
                if (copyTaskFile(abstractUploadTask)) {
                    c16 = 5;
                } else {
                    c16 = 4;
                }
            }
            if (decodeFileWithRetry != null) {
                decodeFileWithRetry.recycle();
            }
            c17 = c16;
        }
        if (c17 != 2 && c17 != 3 && c17 != 5) {
            z16 = false;
        } else {
            z16 = true;
        }
        abstractUploadTask.keepTmpFile(!z16);
    }
}
