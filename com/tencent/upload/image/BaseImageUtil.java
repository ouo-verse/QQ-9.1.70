package com.tencent.upload.image;

import android.media.ExifInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.utils.UploadLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BaseImageUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BaseImageUtil";

    public BaseImageUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void getPicArgs(ExifInterface exifInterface, ExifInterface exifInterface2, boolean z16) {
        String attribute = exifInterface.getAttribute("DateTime");
        String attribute2 = exifInterface.getAttribute("Flash");
        String attribute3 = exifInterface.getAttribute("FocalLength");
        String attribute4 = exifInterface.getAttribute("GPSAltitude");
        String attribute5 = exifInterface.getAttribute("GPSAltitudeRef");
        String attribute6 = exifInterface.getAttribute("GPSDateStamp");
        String attribute7 = exifInterface.getAttribute("GPSLatitude");
        String attribute8 = exifInterface.getAttribute("GPSLatitudeRef");
        String attribute9 = exifInterface.getAttribute("GPSLongitude");
        String attribute10 = exifInterface.getAttribute("GPSLongitudeRef");
        String attribute11 = exifInterface.getAttribute("GPSProcessingMethod");
        String attribute12 = exifInterface.getAttribute("GPSTimeStamp");
        String attribute13 = exifInterface.getAttribute("ISOSpeedRatings");
        String attribute14 = exifInterface.getAttribute("Make");
        String attribute15 = exifInterface.getAttribute("Model");
        exifInterface.getAttribute("Orientation");
        String attribute16 = exifInterface.getAttribute("WhiteBalance");
        String attribute17 = exifInterface.getAttribute("UserComment");
        if (attribute != null && z16) {
            exifInterface2.setAttribute("DateTime", attribute);
        } else {
            exifInterface2.setAttribute("DateTime", "");
        }
        if (attribute2 != null) {
            exifInterface2.setAttribute("Flash", attribute2);
        }
        if (attribute3 != null) {
            exifInterface2.setAttribute("FocalLength", attribute3);
        }
        if (attribute4 != null && z16) {
            exifInterface2.setAttribute("GPSAltitude", attribute4);
        }
        if (attribute5 != null && z16) {
            exifInterface2.setAttribute("GPSAltitudeRef", attribute5);
        }
        if (attribute6 != null && z16) {
            exifInterface2.setAttribute("GPSDateStamp", attribute6);
        }
        if (attribute7 != null && z16) {
            exifInterface2.setAttribute("GPSLatitude", attribute7);
        }
        if (attribute8 != null && z16) {
            exifInterface2.setAttribute("GPSLatitudeRef", attribute8);
        }
        if (attribute9 != null && z16) {
            exifInterface2.setAttribute("GPSLongitude", attribute9);
        }
        if (attribute10 != null && z16) {
            exifInterface2.setAttribute("GPSLongitudeRef", attribute10);
        }
        if (attribute11 != null && z16) {
            exifInterface2.setAttribute("GPSProcessingMethod", attribute11);
        }
        if (attribute12 != null && z16) {
            exifInterface2.setAttribute("GPSTimeStamp", attribute12);
        }
        if (attribute13 != null) {
            exifInterface2.setAttribute("ISOSpeedRatings", attribute13);
        }
        if (attribute14 != null && z16) {
            exifInterface2.setAttribute("Make", attribute14);
        }
        if (attribute15 != null && z16) {
            exifInterface2.setAttribute("Model", attribute15);
        }
        if (attribute16 != null) {
            exifInterface2.setAttribute("WhiteBalance", attribute16);
        }
        if (attribute17 != null && z16) {
            exifInterface2.setAttribute("UserComment", attribute17);
        }
    }

    public static boolean saveExif(ExifInterface exifInterface, ExifInterface exifInterface2) {
        if (exifInterface != null && exifInterface2 != null) {
            getPicArgs(exifInterface, exifInterface2, true);
            String attribute = exifInterface.getAttribute("ImageLength");
            String attribute2 = exifInterface.getAttribute("ImageWidth");
            if (attribute != null) {
                exifInterface2.setAttribute("ImageLength", attribute);
            }
            if (attribute2 != null) {
                exifInterface2.setAttribute("ImageWidth", attribute2);
            }
            try {
                exifInterface2.saveAttributes();
                return true;
            } catch (Exception e16) {
                UploadLog.e(TAG, "Failed to save EXIF. " + e16.getMessage());
            }
        }
        return false;
    }
}
