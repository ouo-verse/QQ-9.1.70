package com.tencent.mobileqq.activity.photo;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MimeHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String IMAGE_BMP = "image/bmp";
    public static final String IMAGE_GIF = "image/gif";
    public static final String IMAGE_HEIC = "image/heic";
    public static final String IMAGE_HEIF = "image/heif";
    public static final String IMAGE_JPEG = "image/jpeg";
    public static final String IMAGE_PNG = "image/png";
    public static final String IMAGE_SUBTYPE_BITMAP = "bitmap";
    public static final String IMAGE_SUBTYPE_BMP = "bmp";
    public static final String IMAGE_SUBTYPE_GIF = "gif";
    public static final String IMAGE_SUBTYPE_HEIF = "heif";
    public static final String IMAGE_SUBTYPE_JPEG = "jpeg";
    public static final String IMAGE_SUBTYPE_JPG = "jpg";
    public static final String IMAGE_SUBTYPE_PNG = "png";
    public static final String IMAGE_SUBTYPE_WEBP = "webp";
    public static final String IMAGE_UNKNOWN = "*/*";
    public static final String IMAGE_UNKNOWN2 = "image/*";
    public static final String IMAGE_WEBP = "image/webp";
    public static final String MIME_TYPE_IMAGE = "image";
    public static final String MIME_TYPE_MOBILEQQ = "mobileqq";
    public static final String MIME_TYPE_MOBILEQQ_CAMERA = "mobileqq/camera";
    public static final String MIME_TYPE_VIDEO = "video";
    private static final String TAG = "QQAlbum";
    public static final String VIDEO_MOV = "video/quicktime";
    public static final String VIDEO_MP4 = "video/mp4";

    public MimeHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String[] getMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("/");
        if (split.length != 2) {
            if (QLog.isColorLevel()) {
                QLog.i("QQAlbum", 2, "Mimetype error:" + str);
            }
            return null;
        }
        return split;
    }

    public static boolean validateImageType(String str) {
        if ("jpg".equals(str) || "gif".equals(str) || "png".equals(str) || IMAGE_SUBTYPE_JPEG.equals(str) || str.lastIndexOf("bmp") != -1 || str.lastIndexOf(IMAGE_SUBTYPE_BITMAP) != -1) {
            return true;
        }
        return false;
    }

    public static boolean validateVideoType(String str) {
        if ("video/mp4".equals(str)) {
            return true;
        }
        return false;
    }
}
