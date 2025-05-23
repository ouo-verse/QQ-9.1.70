package com.qzone.util.image;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f59806a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f59807b;

    static {
        c();
        f59807b = new String[]{"MT788", "M9"};
    }

    public static final String a(String str) {
        return f59806a.get(str);
    }

    public static HashMap<String, String> b(b bVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : f59806a.keySet()) {
            String attribute = bVar.getAttribute(str);
            if (attribute != null) {
                hashMap.put(f59806a.get(str), attribute);
            }
        }
        return hashMap;
    }

    private static void c() {
        f59806a.put("Orientation", "0x0112");
        f59806a.put("DateTime", "0x0132");
        f59806a.put("Make", "0x010f");
        f59806a.put("Model", "0x0110");
        f59806a.put("Flash", "0x9209");
        f59806a.put("ImageWidth", "0x0100");
        f59806a.put("ImageLength", "0x0101");
        f59806a.put("GPSLatitude", "0x0002");
        f59806a.put("GPSLongitude", "0x0004");
        f59806a.put("GPSLatitudeRef", "0x0001");
        f59806a.put("GPSLongitudeRef", "0x0003");
        f59806a.put("WhiteBalance", "0xa403");
        f59806a.put("UserComment", "0x9286");
        f59806a.put("ExposureTime", "0x829a");
        f59806a.put("FNumber", "0x829d");
        f59806a.put("ISOSpeedRatings", "0x8827");
        f59806a.put("GPSAltitude", "0x0006");
        f59806a.put("GPSAltitudeRef", "0x0005");
        f59806a.put("GPSTimeStamp", "0x0007");
        f59806a.put("GPSDateStamp", "0x001d");
        f59806a.put("FocalLength", "0x920a");
        f59806a.put("GPSProcessingMethod", "0x001b");
    }
}
