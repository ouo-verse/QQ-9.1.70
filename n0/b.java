package n0;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {
    public static int a(String str) {
        int readOrientation = JpegExifReader.readOrientation(str);
        if (readOrientation != 3) {
            if (readOrientation != 6) {
                if (readOrientation != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }

    @TargetApi(8)
    public static Bitmap b(String str, int i3, int i16) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i17 = 1;
        options.inJustDecodeBounds = true;
        FilePicURLDrawlableHelper.m(str, options);
        options.inJustDecodeBounds = false;
        int i18 = options.outHeight;
        int i19 = options.outWidth / i3;
        int i26 = i18 / i16;
        if (i19 >= i26) {
            i19 = i26;
        }
        if (i19 > 0) {
            i17 = i19;
        }
        options.inSampleSize = i17;
        try {
            return FilePicURLDrawlableHelper.m(str, options);
        } catch (Exception unused) {
            QLog.d("wifiphoto", 2, "getImageThumbnail error imagePath is " + str);
            return null;
        } catch (OutOfMemoryError unused2) {
            QLog.d("wifiphoto", 2, "getImageThumbnail error(OOM)! imagePath is " + str);
            return null;
        }
    }

    @TargetApi(8)
    public static Bitmap c(String str, int i3, int i16) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i17 = 1;
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i18 = options.outHeight;
        int i19 = options.outWidth / i3;
        int i26 = i18 / i16;
        if (i19 >= i26) {
            i19 = i26;
        }
        if (i19 > 0) {
            i17 = i19;
        }
        options.inSampleSize = i17;
        try {
            return ThumbnailUtils.extractThumbnail(SafeBitmapFactory.decodeFile(str, options), i3, i16, 2);
        } catch (Exception unused) {
            QLog.d("wifiphoto", 2, "getImageThumbnailForSize error imagePath is " + str);
            return null;
        } catch (OutOfMemoryError unused2) {
            QLog.d("wifiphoto", 2, "getImageThumbnailForSize error(OOM)! imagePath is " + str);
            return null;
        }
    }

    @TargetApi(8)
    public static Bitmap d(String str, int i3, int i16) {
        return ThumbnailUtils.createVideoThumbnail(str, 3);
    }

    public static void e(String str, int i3) {
        String num;
        try {
            if (JpegExifReader.isCrashJpeg(str)) {
                return;
            }
            ExifInterface exifInterface = new ExifInterface(str);
            if (i3 != 90) {
                if (i3 != 180) {
                    if (i3 != 270) {
                        num = Integer.toString(1);
                    } else {
                        num = Integer.toString(8);
                    }
                } else {
                    num = Integer.toString(3);
                }
            } else {
                num = Integer.toString(6);
            }
            exifInterface.setAttribute("Orientation", num);
            exifInterface.saveAttributes();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
