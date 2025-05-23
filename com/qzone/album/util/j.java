package com.qzone.album.util;

import android.graphics.Bitmap;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sharpP.SharpPUtils;
import cooperation.qzone.util.MediaUtil;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class j {
    public static String a(String str) {
        boolean z16;
        String str2;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        String P = u4.a.z().P(file.getAbsolutePath());
        if ("webp".equals(P)) {
            str2 = MimeHelper.IMAGE_SUBTYPE_JPEG;
            z16 = true;
        } else {
            z16 = false;
            str2 = P;
        }
        if (z16) {
            try {
                Bitmap n3 = com.qzone.util.image.c.n(file.getAbsolutePath(), null);
                if (n3 != null) {
                    String str3 = String.valueOf(System.currentTimeMillis()) + "." + str2;
                    boolean saveBitmapToSystemAlbumJpg = MediaUtil.saveBitmapToSystemAlbumJpg(null, n3, 90, str3);
                    n3.recycle();
                    if (saveBitmapToSystemAlbumJpg) {
                        return MediaUtil.getCameraPath(str3);
                    }
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        if (P.equals("sharpp")) {
            try {
                Bitmap decodeSharpP = SharpPUtils.decodeSharpP(file.getAbsolutePath());
                if (decodeSharpP != null) {
                    String str4 = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                    boolean saveBitmapToSystemAlbumJpg2 = MediaUtil.saveBitmapToSystemAlbumJpg(null, decodeSharpP, 90, str4);
                    decodeSharpP.recycle();
                    if (saveBitmapToSystemAlbumJpg2) {
                        return MediaUtil.getCameraPath(str4);
                    }
                }
            } catch (OutOfMemoryError e16) {
                QZLog.w("NameUtil", "Out of Memory ", e16);
            }
        }
        if (z16) {
            return null;
        }
        String str5 = String.valueOf(System.currentTimeMillis()) + "." + P;
        MediaUtil.saveFileToSystemAlbum(null, str, str5);
        return MediaUtil.getCameraPath(str5);
    }

    public static String b(String str) {
        boolean z16;
        String str2;
        ImageLoader imageLoader = ImageLoader.getInstance(BaseApplication.getContext());
        ImageLoader.Options options = new ImageLoader.Options();
        options.fileRootPath = g4.d.f401216a;
        File imageFile = imageLoader.getImageFile(str, options);
        if (imageFile == null) {
            return null;
        }
        String P = u4.a.z().P(imageFile.getAbsolutePath());
        if ("webp".equals(P)) {
            str2 = MimeHelper.IMAGE_SUBTYPE_JPEG;
            z16 = true;
        } else {
            z16 = false;
            str2 = P;
        }
        if (z16) {
            try {
                Bitmap n3 = com.qzone.util.image.c.n(imageFile.getAbsolutePath(), null);
                if (n3 != null) {
                    String str3 = String.valueOf(System.currentTimeMillis()) + "." + str2;
                    boolean saveBitmapToSystemAlbumJpg = MediaUtil.saveBitmapToSystemAlbumJpg(null, n3, 90, str3);
                    n3.recycle();
                    if (saveBitmapToSystemAlbumJpg) {
                        return MediaUtil.getCameraPath(str3);
                    }
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        if (P.equals("sharpp")) {
            try {
                Bitmap decodeSharpP = SharpPUtils.decodeSharpP(imageFile.getAbsolutePath());
                if (decodeSharpP != null) {
                    String str4 = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                    boolean saveBitmapToSystemAlbumJpg2 = MediaUtil.saveBitmapToSystemAlbumJpg(null, decodeSharpP, 90, str4);
                    decodeSharpP.recycle();
                    if (saveBitmapToSystemAlbumJpg2) {
                        return MediaUtil.getCameraPath(str4);
                    }
                }
            } catch (OutOfMemoryError e16) {
                QZLog.w("NameUtil", "Out of Memory ", e16);
            }
        }
        if (z16) {
            return null;
        }
        String str5 = String.valueOf(System.currentTimeMillis()) + "." + P;
        MediaUtil.saveFileToSystemAlbum(null, imageFile.getAbsolutePath(), str5);
        return MediaUtil.getCameraPath(str5);
    }
}
