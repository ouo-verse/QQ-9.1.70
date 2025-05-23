package cooperation.qzone.util;

import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class GpsComplementUtil {
    private static final String TAG = "ExifComplement";

    public static boolean complementByDB(String str, double d16, double d17) {
        String str2;
        String str3;
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_GPS_COMPLEMENT, 1) == 0 || LocalMultiProcConfig.getInt(LocalMultiProcConfig.QZONE_GPS_SWITCH, 1) == 0 || JpegExifReader.isCrashJpeg(str)) {
            return false;
        }
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            QLog.i(TAG, 2, "complementByDB destPath:" + str + "\nlat: " + d17 + " lng:" + d16 + "\nTAG_GPS_LATITUDE:" + exifInterface.getAttribute("GPSLatitude"));
            if (d16 != 0.0d && d17 != 0.0d && TextUtils.isEmpty(exifInterface.getAttribute("GPSLatitude"))) {
                QZLog.i(TAG, 2, "[Complement] complementByDB gps lat: " + d17 + " lng:" + d16);
                exifInterface.setAttribute("GPSLatitude", PhotoUtils.gpsInfoConvert(d17));
                exifInterface.setAttribute("GPSLongitude", PhotoUtils.gpsInfoConvert(d16));
                if (d16 > 0.0d) {
                    str2 = "E";
                } else {
                    str2 = "W";
                }
                exifInterface.setAttribute("GPSLongitudeRef", str2);
                if (d17 > 0.0d) {
                    str3 = "N";
                } else {
                    str3 = androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH;
                }
                exifInterface.setAttribute("GPSLatitudeRef", str3);
                exifInterface.setAttribute("DateTime", new SimpleDateFormat("yyyy:MM:dd hh:mm:ss").format(new Date()));
                try {
                    exifInterface.saveAttributes();
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(QZoneHelper.Statics.KEY_GPS_PIC_EDIT, String.valueOf(1));
                    hashMap.put(QZoneHelper.Statics.KEY_GPS_COMPLEMENT_BY_DB, String.valueOf(1));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, QZoneHelper.Statics.EVENTKEY_GPS_INFO, true, 0L, 0L, hashMap, (String) null, true);
                    return true;
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            return false;
        } catch (IOException e17) {
            e17.printStackTrace();
            return false;
        }
    }

    public static boolean complementByExif(String str, String str2) {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_GPS_COMPLEMENT, 1) != 0 && LocalMultiProcConfig.getInt(LocalMultiProcConfig.QZONE_GPS_SWITCH, 1) != 0 && !JpegExifReader.isCrashJpeg(str2) && !JpegExifReader.isCrashJpeg(str)) {
            try {
                ExifInterface exifInterface = new ExifInterface(str2);
                ExifInterface exifInterface2 = new ExifInterface(str);
                QLog.i(TAG, 2, "complementByExif srcPath:" + str + "\ndestPath:" + str2 + "\nTAG_GPS_LONGITUDE:" + exifInterface.getAttribute("GPSLongitude"));
                HashMap<String, String> hashMap = new HashMap<>();
                if (TextUtils.isEmpty(exifInterface.getAttribute("GPSLongitude"))) {
                    String attribute = exifInterface2.getAttribute("GPSLongitude");
                    String attribute2 = exifInterface2.getAttribute("GPSLatitude");
                    if (!TextUtils.isEmpty(attribute) && !TextUtils.isEmpty(attribute2)) {
                        QZLog.i(TAG, 2, "[Complement] complementByExif lat: " + attribute2 + " lng:" + attribute);
                        exifInterface.setAttribute("GPSLongitude", attribute);
                        exifInterface.setAttribute("GPSLatitude", attribute2);
                        if (exifInterface2.getAttribute("GPSLongitudeRef") != null) {
                            exifInterface.setAttribute("GPSLongitudeRef", exifInterface2.getAttribute("GPSLongitudeRef"));
                        }
                        if (exifInterface2.getAttribute("GPSLatitudeRef") != null) {
                            exifInterface.setAttribute("GPSLatitudeRef", exifInterface2.getAttribute("GPSLatitudeRef"));
                        }
                        if (exifInterface2.getAttribute("DateTime") != null) {
                            exifInterface.setAttribute("DateTime", exifInterface2.getAttribute("DateTime"));
                        }
                        if (exifInterface2.getAttribute("Make") != null) {
                            exifInterface.setAttribute("Make", exifInterface2.getAttribute("Make"));
                        }
                        if (exifInterface2.getAttribute("Model") != null) {
                            exifInterface.setAttribute("Model", exifInterface2.getAttribute("Model"));
                        }
                        try {
                            exifInterface.saveAttributes();
                            hashMap.put(QZoneHelper.Statics.KEY_GPS_PIC_EDIT, String.valueOf(1));
                            hashMap.put(QZoneHelper.Statics.KEY_GPS_COMPLEMENT_BY_EXIF, String.valueOf(1));
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, QZoneHelper.Statics.EVENTKEY_GPS_INFO, true, 0L, 0L, hashMap, (String) null, true);
                            return true;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }
                return false;
            } catch (IOException e17) {
                e17.printStackTrace();
            }
        }
        return false;
    }

    public static boolean complementByLocal(String str, double d16, double d17) {
        String str2;
        String str3;
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_GPS_COMPLEMENT, 1) != 0 && LocalMultiProcConfig.getInt(LocalMultiProcConfig.QZONE_GPS_SWITCH, 1) != 0 && d16 != Double.MIN_VALUE && d17 != Double.MIN_VALUE && !JpegExifReader.isCrashJpeg(str)) {
            try {
                ExifInterface exifInterface = new ExifInterface(str);
                QLog.i(TAG, 2, "complementByLocal path:" + str + "\nlat: " + d17 + " lng:" + d16 + "\nTAG_GPS_LATITUDE:" + exifInterface.getAttribute("GPSLatitude"));
                if (TextUtils.isEmpty(exifInterface.getAttribute("GPSLatitude"))) {
                    QLog.i(TAG, 2, "[Complement] complementByLocal lat: " + d17 + " lng:" + d16);
                    exifInterface.setAttribute("GPSLatitude", PhotoUtils.gpsInfoConvert(d17));
                    exifInterface.setAttribute("GPSLongitude", PhotoUtils.gpsInfoConvert(d16));
                    if (d16 > 0.0d) {
                        str2 = "E";
                    } else {
                        str2 = "W";
                    }
                    exifInterface.setAttribute("GPSLongitudeRef", str2);
                    if (d17 > 0.0d) {
                        str3 = "N";
                    } else {
                        str3 = androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH;
                    }
                    exifInterface.setAttribute("GPSLatitudeRef", str3);
                    exifInterface.setAttribute("DateTime", new SimpleDateFormat("yyyy:MM:dd hh:mm:ss").format(new Date()));
                    try {
                        exifInterface.saveAttributes();
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(QZoneHelper.Statics.KEY_GPS_CAPTURE_PIC, String.valueOf(1));
                        hashMap.put(QZoneHelper.Statics.KEY_GPS_COMPLEMENT_BY_LOCAL, String.valueOf(1));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, QZoneHelper.Statics.EVENTKEY_GPS_INFO, true, 0L, 0L, hashMap, (String) null, true);
                        return true;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        return false;
                    }
                }
            } catch (IOException e17) {
                e17.printStackTrace();
            }
        }
        return false;
    }
}
