package com.qzone.misc.network.uploader;

import com.qzone.util.image.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneImageSizeStrategy {
    public static final int DEFAULT_IMAGE_SIZE = 1080;
    public float MAX_RATIO;
    public int MAX_X;
    public int MAX_Y;
    public float MIN_RATIO;
    public int MIN_X;
    public int MIN_Y;
    public int NORMAL_X;
    public int NORMAL_Y;
    public String QUALITY_NAME;
    public String RESOLUTION_NAME;
    public static QZoneImageSizeStrategy NORMAL = new QZoneImageSizeStrategy(QzoneConfig.SECONDARY_PHOTO_UPLOAD_RESOLUTION_LOW, QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_LOW, 1080, 1080, 1.0f, 1080, 10000, 1.0f, 10000, 1080);
    public static QZoneImageSizeStrategy NORMAL_WEBP = new QZoneImageSizeStrategy(QzoneConfig.SECONDARY_PHOTO_UPLOAD_RESOLUTION_LOW, QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_LOW_WEBP, 1080, 1080, 1.0f, 1080, 10000, 1.0f, 10000, 1080);
    public static QZoneImageSizeStrategy BIG = new QZoneImageSizeStrategy(QzoneConfig.SECONDARY_PHOTO_UPLOAD_RESOLUTION_HIGH, QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH, 1200, 1200, 0.5f, 1200, 10000, 2.0f, 10000, 1200);
    public static QZoneImageSizeStrategy HD = new QZoneImageSizeStrategy(QzoneConfig.SECONDARY_PHOTO_UPLOAD_RESOLUTION_HIGH, QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH, 1600, 1600, 1.0f, 1600, 10000, 1.0f, 10000, 1600);
    public static QZoneImageSizeStrategy HD_WEBP = new QZoneImageSizeStrategy(QzoneConfig.SECONDARY_PHOTO_UPLOAD_RESOLUTION_HIGH, QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH_WEBP, 1600, 1600, 0.5f, 1600, 10000, 2.0f, 10000, 1600);

    public QZoneImageSizeStrategy(String str, String str2, int i3, int i16, float f16, int i17, int i18, float f17, int i19, int i26) {
        this.RESOLUTION_NAME = str;
        this.QUALITY_NAME = str2;
        this.NORMAL_X = i3;
        this.NORMAL_Y = i16;
        this.MIN_RATIO = f16;
        this.MIN_X = i17;
        this.MIN_Y = i18;
        this.MAX_RATIO = f17;
        this.MAX_X = i19;
        this.MAX_Y = i26;
    }

    public static IUploadConfig.UploadImageSize getCoverUploadSize() {
        int i3;
        int i16;
        String[] split;
        int i17 = 1080;
        try {
            String[] split2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_QZONECOVER_UPLOADRESOLUTION, QzoneConfig.DefaultValue.QZONECOVER_UPLOADRESOLUTION).split(",");
            int networkType = NetworkState.getNetworkType();
            if (networkType == 1) {
                split = split2[2].split("\\*");
            } else if (networkType != 2) {
                split = (networkType == 3 || networkType == 4 || networkType == 5) ? split2[1].split("\\*") : null;
            } else {
                split = split2[0].split("\\*");
            }
        } catch (Exception e16) {
            e = e16;
            i3 = 1080;
        }
        if (split != null) {
            i3 = Integer.parseInt(split[0]);
            try {
                i17 = Integer.parseInt(split[1]);
            } catch (Exception e17) {
                e = e17;
                QZLog.e("Upload Cover", "getCoverUploadSize() exception occured=", e);
                i16 = i17;
                i17 = i3;
                return new IUploadConfig.UploadImageSize(i17, i16, getNetQualityConfig(NetworkState.getNetworkType(), QzoneConfig.MAIN_KEY_QZONECOVER, "UploadQuality"));
            }
            i16 = i17;
            i17 = i3;
            return new IUploadConfig.UploadImageSize(i17, i16, getNetQualityConfig(NetworkState.getNetworkType(), QzoneConfig.MAIN_KEY_QZONECOVER, "UploadQuality"));
        }
        i16 = 1080;
        return new IUploadConfig.UploadImageSize(i17, i16, getNetQualityConfig(NetworkState.getNetworkType(), QzoneConfig.MAIN_KEY_QZONECOVER, "UploadQuality"));
    }

    private static QZoneImageSizeStrategy getImageSizeStrategy(int i3, boolean z16) {
        QZoneImageSizeStrategy qZoneImageSizeStrategy = NORMAL;
        if (i3 == 0) {
            return !z16 ? qZoneImageSizeStrategy : NORMAL_WEBP;
        }
        if (i3 == 1) {
            return BIG;
        }
        if (i3 != 2) {
            return qZoneImageSizeStrategy;
        }
        if (!z16) {
            return HD;
        }
        return HD_WEBP;
    }

    public static int getNetQuality(int i3, boolean z16) {
        return getNetQualityConfig(NetworkState.getNetworkType(), "PhotoUpload", getImageSizeStrategy(i3, z16).QUALITY_NAME);
    }

    public static int getNetQualityConfig(int i3, String str, String str2) {
        String str3;
        int intValue;
        if (str.equals("PhotoUpload")) {
            str3 = "80,80,80";
            if (!str2.equals(QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_LOW) && !str2.equals(QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH)) {
                if (str2.equals(QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_LOW_WEBP)) {
                    str3 = QzoneConfig.DefaultValue.PHOTO_UPLOAD_QUALITY_LOW_WEBP;
                } else {
                    if (str2.equals(QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH_WEBP)) {
                        str3 = QzoneConfig.DefaultValue.PHOTO_UPLOAD_QUALITY_HIGH_WEBP;
                    }
                    str3 = "";
                }
            }
        } else {
            if (str.equals(QzoneConfig.MAIN_KEY_QZONECOVER) && str2.equals("UploadQuality")) {
                str3 = QzoneConfig.DefaultValue.QZONECOVER_UPLOADQUALITY;
            }
            str3 = "";
        }
        try {
            String config = QzoneConfig.getInstance().getConfig(str, str2, str3);
            if (config == null) {
                return 80;
            }
            String[] split = config.split(",");
            if (i3 == 1) {
                intValue = Integer.valueOf(split[2]).intValue();
            } else if (i3 == 2) {
                intValue = Integer.valueOf(split[0]).intValue();
            } else {
                if (i3 != 3 && i3 != 4 && i3 != 5) {
                    return 80;
                }
                intValue = Integer.valueOf(split[1]).intValue();
            }
            return intValue;
        } catch (Exception e16) {
            QZLog.e("QZoneImageSizeStrategy", "Service size format error:" + QLog.getStackTraceString(e16));
            return 80;
        }
    }

    public static c.a getNetSizeConfig(String str, c.a aVar, float f16, float f17, float f18) {
        String config = QzoneConfig.getInstance().getConfig("PhotoUpload", str);
        QZLog.i("SizeConfig", "sizeConfig:" + config);
        if (config != null) {
            try {
                String[] split = config.split(",");
                String str2 = "";
                int networkType = NetworkState.getNetworkType();
                if (networkType == 1) {
                    str2 = split[2];
                } else if (networkType == 2) {
                    str2 = split[0];
                } else if (networkType == 3 || networkType == 4 || networkType == 5) {
                    str2 = split[1];
                }
                String[] split2 = str2.split("\\*");
                int intValue = Integer.valueOf(split2[0]).intValue();
                int intValue2 = Integer.valueOf(split2[1]).intValue();
                QLog.i("QZoneImageSizeStrategy", 1, "@coverOptimize size[0] =" + split[0] + " size[1]" + split[1] + " size[2] " + split[2]);
                if (f16 < f17) {
                    return new c.a(intValue, intValue2);
                }
                if (f16 > f18) {
                    return new c.a(intValue2, intValue);
                }
                return new c.a(intValue, intValue);
            } catch (Exception e16) {
                QZLog.w("QZoneImageSizeStrategy", "Service size config format error:" + QLog.getStackTraceString(e16));
            }
        }
        return aVar;
    }

    public static IUploadConfig.UploadImageSize getTargetSize(int i3, int i16, int i17, boolean z16) {
        return getTargetSize(new c.a(i3, i16), i17, z16);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.RESOLUTION_NAME);
        stringBuffer.append("(");
        stringBuffer.append(this.NORMAL_X);
        stringBuffer.append(",");
        stringBuffer.append(this.NORMAL_Y);
        stringBuffer.append(")");
        stringBuffer.append(" - min(");
        stringBuffer.append(this.MIN_X);
        stringBuffer.append(",");
        stringBuffer.append(this.MIN_Y);
        stringBuffer.append(")");
        stringBuffer.append(" - max(");
        stringBuffer.append(this.MAX_X);
        stringBuffer.append(",");
        stringBuffer.append(this.MAX_Y);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public static IUploadConfig.UploadImageSize getTargetSize(c.a aVar, int i3, boolean z16) {
        if (aVar == null) {
            return null;
        }
        return getSizeWithStrategy(aVar, getImageSizeStrategy(i3, z16));
    }

    public static IUploadConfig.UploadImageSize getPhotoWallTargetSize(c.a aVar, int i3) {
        if (aVar == null) {
            return new IUploadConfig.UploadImageSize(0, 0, i3);
        }
        int i16 = aVar.f59812a;
        int i17 = aVar.f59813b;
        int i18 = i16 > i17 ? i16 : i17;
        if (i18 < 960) {
            return new IUploadConfig.UploadImageSize(i16, i17, i3);
        }
        if (i18 == i16) {
            int i19 = (int) ((i17 / i16) * 960.0d);
            if (i19 != 0) {
                i17 = i19;
            }
            return new IUploadConfig.UploadImageSize(960, i17, i3);
        }
        int i26 = (int) ((i16 / i17) * 960.0d);
        if (i26 != 0) {
            i16 = i26;
        }
        return new IUploadConfig.UploadImageSize(i16, 960, i3);
    }

    private static c.a getNewSize(int i3, int i16, int i17, int i18) {
        float f16 = i3;
        float f17 = i16;
        float min = Math.min(i17 / f16, i18 / f17);
        if (min < 1.0d) {
            return new c.a((int) (f16 * min), (int) (f17 * min));
        }
        return new c.a(i3, i16);
    }

    private static IUploadConfig.UploadImageSize getSizeWithStrategy(c.a aVar, QZoneImageSizeStrategy qZoneImageSizeStrategy) {
        c.a aVar2;
        if (aVar == null) {
            return null;
        }
        if (qZoneImageSizeStrategy == null) {
            return new IUploadConfig.UploadImageSize(aVar.f59812a, aVar.f59813b, 100);
        }
        float f16 = aVar.f59812a / aVar.f59813b;
        if (f16 < qZoneImageSizeStrategy.MIN_RATIO) {
            aVar2 = new c.a(qZoneImageSizeStrategy.MIN_X, qZoneImageSizeStrategy.MIN_Y);
        } else if (f16 > qZoneImageSizeStrategy.MAX_RATIO) {
            aVar2 = new c.a(qZoneImageSizeStrategy.MAX_X, qZoneImageSizeStrategy.MAX_Y);
        } else {
            aVar2 = new c.a(qZoneImageSizeStrategy.NORMAL_X, qZoneImageSizeStrategy.NORMAL_Y);
        }
        c.a netSizeConfig = getNetSizeConfig(qZoneImageSizeStrategy.RESOLUTION_NAME, aVar2, f16, qZoneImageSizeStrategy.MIN_RATIO, qZoneImageSizeStrategy.MAX_RATIO);
        c.a newSize = getNewSize(aVar.f59812a, aVar.f59813b, netSizeConfig.f59812a, netSizeConfig.f59813b);
        return new IUploadConfig.UploadImageSize(newSize.f59812a, newSize.f59813b, getNetQualityConfig(NetworkState.getNetworkType(), "PhotoUpload", qZoneImageSizeStrategy.QUALITY_NAME));
    }
}
