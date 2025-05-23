package com.tencent.mobileqq.winkpublish.util;

import com.tencent.mobileqq.winkpublish.util.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;

/* compiled from: P */
/* loaded from: classes21.dex */
public class AUploadImageSizeStrategy {
    public static final int DEFAULT_IMAGE_SIZE = 1080;
    public float maxRatio;
    public int maxX;
    public int maxY;
    public float minRatio;
    public int minX;
    public int minY;
    public int normalX;
    public int normalY;
    public String qualityName;
    public String resolutionName;
    public static AUploadImageSizeStrategy NORMAL = new AUploadImageSizeStrategy(QzoneConfig.SECONDARY_PHOTO_UPLOAD_RESOLUTION_LOW, QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_LOW, 1080, 1080, 1.0f, 1080, 10000, 1.0f, 10000, 1080);
    public static AUploadImageSizeStrategy NORMAL_WEBP = new AUploadImageSizeStrategy(QzoneConfig.SECONDARY_PHOTO_UPLOAD_RESOLUTION_LOW, QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_LOW_WEBP, 1080, 1080, 1.0f, 1080, 10000, 1.0f, 10000, 1080);
    public static AUploadImageSizeStrategy BIG = new AUploadImageSizeStrategy(QzoneConfig.SECONDARY_PHOTO_UPLOAD_RESOLUTION_HIGH, QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH, 1200, 1200, 0.5f, 1200, 10000, 2.0f, 10000, 1200);
    public static AUploadImageSizeStrategy HD = new AUploadImageSizeStrategy(QzoneConfig.SECONDARY_PHOTO_UPLOAD_RESOLUTION_HIGH, QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH, 1600, 1600, 1.0f, 1600, 10000, 1.0f, 10000, 1600);
    public static AUploadImageSizeStrategy HD_WEBP = new AUploadImageSizeStrategy(QzoneConfig.SECONDARY_PHOTO_UPLOAD_RESOLUTION_HIGH, QzoneConfig.SECONDARY_PHOTO_UPLOAD_QUALITY_HIGH_WEBP, 1600, 1600, 0.5f, 1600, 10000, 2.0f, 10000, 1600);

    public AUploadImageSizeStrategy(String str, String str2, int i3, int i16, float f16, int i17, int i18, float f17, int i19, int i26) {
        this.resolutionName = str;
        this.qualityName = str2;
        this.normalX = i3;
        this.normalY = i16;
        this.minRatio = f16;
        this.minX = i17;
        this.minY = i18;
        this.maxRatio = f17;
        this.maxX = i19;
        this.maxY = i26;
    }

    private static AUploadImageSizeStrategy getImageSizeStrategy(int i3, boolean z16) {
        AUploadImageSizeStrategy aUploadImageSizeStrategy = NORMAL;
        if (i3 == 0) {
            if (z16) {
                return NORMAL_WEBP;
            }
            return aUploadImageSizeStrategy;
        }
        if (i3 == 1) {
            return BIG;
        }
        if (i3 == 2) {
            if (!z16) {
                return HD;
            }
            return HD_WEBP;
        }
        return aUploadImageSizeStrategy;
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
            String b16 = uq3.c.b1(str, str2, str3);
            if (b16 == null) {
                return 80;
            }
            String[] split = b16.split(",");
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 4 && i3 != 5) {
                        return 80;
                    }
                    intValue = Integer.valueOf(split[1]).intValue();
                } else {
                    intValue = Integer.valueOf(split[0]).intValue();
                }
            } else {
                intValue = Integer.valueOf(split[2]).intValue();
            }
            return intValue;
        } catch (Exception e16) {
            QLog.e("QCircleImageSizeStrategy", 1, "Service size format error:" + e16.getMessage());
            return 80;
        }
    }

    public static ImageUtil.Size getNetSizeConfig(String str, ImageUtil.Size size, float f16, float f17, float f18) {
        String a16 = uq3.c.a1("PhotoUpload", str);
        QLog.i("SizeConfig", 1, "sizeConfig:" + a16);
        if (a16 != null) {
            try {
                String[] split = a16.split(",");
                String str2 = "";
                int networkType = NetworkState.getNetworkType();
                if (networkType != 1) {
                    if (networkType != 2) {
                        if (networkType == 3 || networkType == 4 || networkType == 5) {
                            str2 = split[1];
                        }
                    } else {
                        str2 = split[0];
                    }
                } else {
                    str2 = split[2];
                }
                String[] split2 = str2.split("\\*");
                int intValue = Integer.valueOf(split2[0]).intValue();
                int intValue2 = Integer.valueOf(split2[1]).intValue();
                QLog.i("QCircleImageSizeStrategy", 1, "@coverOptimize size[0] =" + split[0] + " size[1]" + split[1] + " size[2] " + split[2]);
                if (f16 < f17) {
                    return new ImageUtil.Size(intValue, intValue2);
                }
                if (f16 > f18) {
                    return new ImageUtil.Size(intValue2, intValue);
                }
                return new ImageUtil.Size(intValue, intValue);
            } catch (Exception e16) {
                QLog.w("QCircleImageSizeStrategy", 1, "Service size config format error:" + e16.getMessage());
            }
        }
        return size;
    }

    private static ImageUtil.Size getNewSize(int i3, int i16, int i17, int i18) {
        float f16 = i3;
        float f17 = i16;
        float min = Math.min(i17 / f16, i18 / f17);
        if (min < 1.0d) {
            return new ImageUtil.Size((int) (f16 * min), (int) (f17 * min));
        }
        return new ImageUtil.Size(i3, i16);
    }

    private static IUploadConfig.UploadImageSize getSizeWithStrategy(ImageUtil.Size size, AUploadImageSizeStrategy aUploadImageSizeStrategy) {
        ImageUtil.Size size2;
        if (size == null) {
            return null;
        }
        if (aUploadImageSizeStrategy == null) {
            return new IUploadConfig.UploadImageSize(size.width, size.height, 100);
        }
        float f16 = size.width / size.height;
        if (f16 < aUploadImageSizeStrategy.minRatio) {
            size2 = new ImageUtil.Size(aUploadImageSizeStrategy.minX, aUploadImageSizeStrategy.minY);
        } else if (f16 > aUploadImageSizeStrategy.maxRatio) {
            size2 = new ImageUtil.Size(aUploadImageSizeStrategy.maxX, aUploadImageSizeStrategy.maxY);
        } else {
            size2 = new ImageUtil.Size(aUploadImageSizeStrategy.normalX, aUploadImageSizeStrategy.normalY);
        }
        ImageUtil.Size netSizeConfig = getNetSizeConfig(aUploadImageSizeStrategy.resolutionName, size2, f16, aUploadImageSizeStrategy.minRatio, aUploadImageSizeStrategy.maxRatio);
        ImageUtil.Size newSize = getNewSize(size.width, size.height, netSizeConfig.width, netSizeConfig.height);
        return new IUploadConfig.UploadImageSize(newSize.width, newSize.height, getNetQualityConfig(NetworkState.getNetworkType(), "PhotoUpload", aUploadImageSizeStrategy.qualityName));
    }

    public static IUploadConfig.UploadImageSize getTargetSize(int i3, int i16, int i17, boolean z16) {
        return getTargetSize(new ImageUtil.Size(i3, i16), i17, z16);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.resolutionName);
        stringBuffer.append("(");
        stringBuffer.append(this.normalX);
        stringBuffer.append(",");
        stringBuffer.append(this.normalY);
        stringBuffer.append(")");
        stringBuffer.append(" - min(");
        stringBuffer.append(this.minX);
        stringBuffer.append(",");
        stringBuffer.append(this.minY);
        stringBuffer.append(")");
        stringBuffer.append(" - max(");
        stringBuffer.append(this.maxX);
        stringBuffer.append(",");
        stringBuffer.append(this.maxY);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public static IUploadConfig.UploadImageSize getTargetSize(ImageUtil.Size size, int i3, boolean z16) {
        if (size == null) {
            return null;
        }
        return getSizeWithStrategy(size, getImageSizeStrategy(i3, z16));
    }
}
