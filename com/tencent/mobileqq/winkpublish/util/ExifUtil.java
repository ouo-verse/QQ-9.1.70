package com.tencent.mobileqq.winkpublish.util;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.winkpublish.model.ExtendExifInterface;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ExifUtil {
    private static HashMap<String, String> EXIF_TAG_CODE_MAP = new HashMap<>();
    private static final String EXIF_TAG_USERCOMMENT = "UserComment";
    public static String TAG = "ExifUtil";

    static {
        initExifTagCodeMap();
    }

    public static final String getExifTagCode(String str) {
        return EXIF_TAG_CODE_MAP.get(str);
    }

    public static HashMap<String, String> getExifToHashMap(ExtendExifInterface extendExifInterface) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : EXIF_TAG_CODE_MAP.keySet()) {
            String attribute = extendExifInterface.getAttribute(str);
            if (attribute != null) {
                hashMap.put(EXIF_TAG_CODE_MAP.get(str), attribute);
            }
        }
        return hashMap;
    }

    public static HashMap<String, String> getExifToHashMapForKey(ExtendExifInterface extendExifInterface) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : EXIF_TAG_CODE_MAP.keySet()) {
            String attribute = extendExifInterface.getAttribute(str);
            if (attribute != null) {
                hashMap.put(str, attribute);
            }
        }
        return hashMap;
    }

    @SuppressLint({"InlinedApi"})
    private static void initExifTagCodeMap() {
        EXIF_TAG_CODE_MAP.put("Orientation", "0x0112");
        EXIF_TAG_CODE_MAP.put("DateTime", "0x0132");
        EXIF_TAG_CODE_MAP.put("Make", "0x010f");
        EXIF_TAG_CODE_MAP.put("Model", "0x0110");
        EXIF_TAG_CODE_MAP.put("Flash", "0x9209");
        EXIF_TAG_CODE_MAP.put("ImageWidth", "0x0100");
        EXIF_TAG_CODE_MAP.put("ImageLength", "0x0101");
        EXIF_TAG_CODE_MAP.put("GPSLatitude", "0x0002");
        EXIF_TAG_CODE_MAP.put("GPSLongitude", "0x0004");
        EXIF_TAG_CODE_MAP.put("GPSLatitudeRef", "0x0001");
        EXIF_TAG_CODE_MAP.put("GPSLongitudeRef", "0x0003");
        EXIF_TAG_CODE_MAP.put("WhiteBalance", "0xa403");
        EXIF_TAG_CODE_MAP.put("UserComment", "0x9286");
        EXIF_TAG_CODE_MAP.put("ExposureTime", "0x829a");
        EXIF_TAG_CODE_MAP.put("FNumber", "0x829d");
        EXIF_TAG_CODE_MAP.put("ISOSpeedRatings", "0x8827");
        EXIF_TAG_CODE_MAP.put("GPSAltitude", "0x0006");
        EXIF_TAG_CODE_MAP.put("GPSAltitudeRef", "0x0005");
        EXIF_TAG_CODE_MAP.put("GPSTimeStamp", "0x0007");
        EXIF_TAG_CODE_MAP.put("GPSDateStamp", "0x001d");
        EXIF_TAG_CODE_MAP.put("FocalLength", "0x920a");
        EXIF_TAG_CODE_MAP.put("GPSProcessingMethod", "0x001b");
    }
}
