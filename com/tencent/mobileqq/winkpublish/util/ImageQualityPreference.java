package com.tencent.mobileqq.winkpublish.util;

/* loaded from: classes21.dex */
public class ImageQualityPreference {
    private static final int DEFAULT_VIDEO_MAX_LENGTH = 999999;
    public static final int QUALITY_BIG = 1;
    public static final int QUALITY_HD = 2;
    public static final int QUALITY_NORMAL = 0;
    public static final int QUALITY_RAW = 3;
    private static final String TAG = "[upload2]ImageQualityPreference";
    public static final int TYPE_3G = 3;
    public static final int TYPE_GLOBAL = -1;
    public static final String TYPE_PHOTO = "photo";
    public static final String TYPE_SHUOSHUO_ALL_PIC = "shuoshuoallpic";
    public static final String TYPE_VIDEO = "video";
    public static final int TYPE_WIFI = 1;
    private static ImageQualityPreference sInstance;

    ImageQualityPreference() {
    }

    public static ImageQualityPreference getInstance() {
        if (sInstance == null) {
            synchronized (ImageQualityPreference.class) {
                if (sInstance == null) {
                    sInstance = new ImageQualityPreference();
                }
            }
        }
        return sInstance;
    }
}
