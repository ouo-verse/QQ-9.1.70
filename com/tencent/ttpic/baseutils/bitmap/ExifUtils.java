package com.tencent.ttpic.baseutils.bitmap;

import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ExifUtils {
    private static final String TAG = "CameraExif";

    public static int exchange(int i3) {
        if (i3 != 90) {
            if (i3 != 180) {
                if (i3 != 270) {
                    return 1;
                }
                return 8;
            }
            return 3;
        }
        return 6;
    }

    public static double getExifAltitude(String str) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            String attribute = exifInterface.getAttribute("GPSAltitude");
            String attribute2 = exifInterface.getAttribute("GPSAltitudeRef");
            double gpsValue2Num = gpsValue2Num(attribute);
            if ("1".equals(attribute2)) {
                return gpsValue2Num * (-1.0d);
            }
            return gpsValue2Num;
        } catch (Exception e16) {
            LogUtils.e(e16);
            return 0.0d;
        }
    }

    public static long getExifDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            String attribute = new ExifInterface(str).getAttribute("DateTime");
            if (TextUtils.isEmpty(attribute)) {
                return new File(str).lastModified();
            }
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(attribute).getTime();
        } catch (Exception e16) {
            LogUtils.e(e16);
            return 0L;
        }
    }

    public static double[] getExifGPS(String str) {
        if (str == null) {
            return null;
        }
        try {
            double[] dArr = new double[2];
            ExifInterface exifInterface = new ExifInterface(str);
            String attribute = exifInterface.getAttribute("GPSLatitude");
            String attribute2 = exifInterface.getAttribute("GPSLatitudeRef");
            String attribute3 = exifInterface.getAttribute("GPSLongitude");
            String attribute4 = exifInterface.getAttribute("GPSLongitudeRef");
            if (!TextUtils.isEmpty(attribute)) {
                if (androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH.equals(attribute2)) {
                    dArr[0] = getGpsCoord(attribute.split(",")) * (-1.0d);
                } else {
                    dArr[0] = getGpsCoord(attribute.split(","));
                }
            }
            if (!TextUtils.isEmpty(attribute3)) {
                if ("W".equals(attribute4)) {
                    dArr[1] = getGpsCoord(attribute3.split(",")) * (-1.0d);
                } else {
                    dArr[1] = getGpsCoord(attribute3.split(","));
                }
            }
            return dArr;
        } catch (Exception e16) {
            LogUtils.e(e16);
            return null;
        }
    }

    private static double getGpsCoord(String[] strArr) {
        double d16;
        double d17;
        double d18 = 0.0d;
        if (strArr == null) {
            return 0.0d;
        }
        if (strArr.length > 0) {
            d16 = gpsValue2Num(strArr[0]);
        } else {
            d16 = 0.0d;
        }
        if (strArr.length > 1) {
            d17 = gpsValue2Num(strArr[1]);
        } else {
            d17 = 0.0d;
        }
        if (strArr.length > 2) {
            d18 = gpsValue2Num(strArr[2]);
        }
        double floor = d17 + ((d16 - Math.floor(d16)) * 60.0d);
        double floor2 = Math.floor(d16);
        double floor3 = d18 + ((floor - Math.floor(floor)) * 60.0d);
        double floor4 = Math.floor(floor);
        if (floor3 >= 60.0d) {
            double d19 = floor3 / 60.0d;
            floor4 += Math.floor(d19);
            floor3 -= Math.floor(d19) * 60.0d;
        }
        if (floor4 >= 60.0d) {
            double d26 = floor4 / 60.0d;
            floor2 += Math.floor(d26);
            floor4 -= Math.floor(d26) * 60.0d;
        }
        return floor2 + (floor4 / 60.0d) + (floor3 / 3600.0d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
    
        if (r3 <= 8) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
    
        r2 = pack(r11, r1, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
    
        if (r2 == 1229531648) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007a, code lost:
    
        if (r2 == 1296891946) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.e(com.tencent.ttpic.baseutils.bitmap.ExifUtils.TAG, "Invalid byte order");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0082, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        if (r2 != 1229531648) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0085, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0088, code lost:
    
        r4 = pack(r11, r1 + 4, 4, r2) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0091, code lost:
    
        if (r4 < 10) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0093, code lost:
    
        if (r4 <= r3) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
    
        r1 = r1 + r4;
        r3 = r3 - r4;
        r4 = pack(r11, r1 - 2, 2, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009e, code lost:
    
        r9 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a0, code lost:
    
        if (r4 <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
    
        if (r3 < 12) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ac, code lost:
    
        if (pack(r11, r1, 2, r2) != 274) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ce, code lost:
    
        r1 = r1 + 12;
        r3 = r3 - 12;
        r4 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ae, code lost:
    
        r11 = pack(r11, r1 + 8, 2, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b3, code lost:
    
        if (r11 == 1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b6, code lost:
    
        if (r11 == 3) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b9, code lost:
    
        if (r11 == 6) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00bb, code lost:
    
        if (r11 == 8) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bd, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.i(com.tencent.ttpic.baseutils.bitmap.ExifUtils.TAG, "Unsupported orientation");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c3, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c4, code lost:
    
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c7, code lost:
    
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ca, code lost:
    
        return 180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cd, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d4, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.e(com.tencent.ttpic.baseutils.bitmap.ExifUtils.TAG, "Invalid offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00da, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0087, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00db, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.i(com.tencent.ttpic.baseutils.bitmap.ExifUtils.TAG, "Orientation not found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e1, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0068, code lost:
    
        r3 = 0;
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getOrientation(byte[] bArr) {
        int i3;
        int i16;
        if (bArr == null) {
            return 0;
        }
        int i17 = 0;
        while (true) {
            if (i17 + 3 >= bArr.length) {
                i3 = 0;
                break;
            }
            int i18 = i17 + 1;
            if ((bArr[i17] & 255) != 255) {
                break;
            }
            int i19 = bArr[i18] & 255;
            if (i19 != 255) {
                i18++;
                if (i19 != 216 && i19 != 1) {
                    if (i19 != 217 && i19 != 218) {
                        int pack = pack(bArr, i18, 2, false);
                        if (pack >= 2 && (i16 = i18 + pack) <= bArr.length) {
                            if (i19 == 225 && pack >= 8 && pack(bArr, i18 + 2, 4, false) == 1165519206 && pack(bArr, i18 + 6, 2, false) == 0) {
                                i17 = i18 + 8;
                                i3 = pack - 8;
                                break;
                            }
                            i17 = i16;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i17 = i18;
        }
        LogUtils.e(TAG, "Invalid length");
        return 0;
    }

    private static double gpsValue2Num(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split("/")) == null || split.length <= 0) {
            return 0.0d;
        }
        if (split.length == 1) {
            return Double.valueOf(split[0]).doubleValue();
        }
        if (Math.abs(Double.valueOf(split[1]).doubleValue()) < 1.0E-4d) {
            return 0.0d;
        }
        return Double.valueOf(split[0]).doubleValue() / Double.valueOf(split[1]).doubleValue();
    }

    public static void incExifData(String str, int i3) {
        long lastModified;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            String attribute = exifInterface.getAttribute("DateTime");
            if (!TextUtils.isEmpty(attribute)) {
                lastModified = simpleDateFormat.parse(attribute).getTime();
            } else {
                lastModified = new File(str).lastModified();
            }
            String format = simpleDateFormat.format(Long.valueOf(lastModified + (i3 * 1000)));
            exifInterface.setAttribute("DateTime", format);
            exifInterface.saveAttributes();
            LogUtils.d("ExifUtils", "date written %s", format);
        } catch (Exception e16) {
            LogUtils.e(e16);
        }
    }

    private static int pack(byte[] bArr, int i3, int i16, boolean z16) {
        int i17;
        if (z16) {
            i3 += i16 - 1;
            i17 = -1;
        } else {
            i17 = 1;
        }
        int i18 = 0;
        while (true) {
            int i19 = i16 - 1;
            if (i16 > 0) {
                i18 = (bArr[i3] & 255) | (i18 << 8);
                i3 += i17;
                i16 = i19;
            } else {
                return i18;
            }
        }
    }

    private static boolean read(InputStream inputStream, byte[] bArr, int i3) {
        try {
            if (inputStream.read(bArr, 0, i3) != i3) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
    
        if (r3 <= 8) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
    
        r2 = pack(r11, r1, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
    
        if (r2 == 1229531648) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007a, code lost:
    
        if (r2 == 1296891946) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.e(com.tencent.ttpic.baseutils.bitmap.ExifUtils.TAG, "Invalid byte order");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0082, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        if (r2 != 1229531648) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0086, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0087, code lost:
    
        r2 = pack(r11, r1 + 4, 4, r5) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0090, code lost:
    
        if (r2 < 10) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0092, code lost:
    
        if (r2 <= r3) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
    
        r1 = r1 + r2;
        r3 = r3 - r2;
        r2 = pack(r11, r1 - 2, 2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
    
        r4 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009f, code lost:
    
        if (r2 <= 0) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a3, code lost:
    
        if (r3 < 12) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
    
        if (pack(r11, r1, 2, r5) != 274) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00cd, code lost:
    
        r1 = r1 + 12;
        r3 = r3 - 12;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ad, code lost:
    
        if (r12 == 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b1, code lost:
    
        if (r12 == 90) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b5, code lost:
    
        if (r12 == 180) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b9, code lost:
    
        if (r12 == 270) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bd, code lost:
    
        r12 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c2, code lost:
    
        write(r11, r1 + 8, r12, 2, r5);
        com.tencent.ttpic.baseutils.log.LogUtils.i(com.tencent.ttpic.baseutils.bitmap.ExifUtils.TAG, "Unsupported orientation");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00cc, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bf, code lost:
    
        r12 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c1, code lost:
    
        r12 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bb, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d3, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.e(com.tencent.ttpic.baseutils.bitmap.ExifUtils.TAG, "Invalid offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00d9, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00da, code lost:
    
        com.tencent.ttpic.baseutils.log.LogUtils.i(com.tencent.ttpic.baseutils.bitmap.ExifUtils.TAG, "Orientation not found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0068, code lost:
    
        r3 = 0;
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int setOrientation(byte[] bArr, int i3) {
        int i16;
        int i17;
        if (bArr == null) {
            return 0;
        }
        int i18 = 0;
        while (true) {
            boolean z16 = true;
            if (i18 + 3 < bArr.length) {
                int i19 = i18 + 1;
                if ((bArr[i18] & 255) != 255) {
                    break;
                }
                int i26 = bArr[i19] & 255;
                if (i26 != 255) {
                    i19++;
                    if (i26 != 216 && i26 != 1) {
                        if (i26 != 217 && i26 != 218) {
                            int pack = pack(bArr, i19, 2, false);
                            if (pack >= 2 && (i17 = i19 + pack) <= bArr.length) {
                                if (i26 == 225 && pack >= 8 && pack(bArr, i19 + 2, 4, false) == 1165519206 && pack(bArr, i19 + 6, 2, false) == 0) {
                                    i18 = i19 + 8;
                                    i16 = pack - 8;
                                    break;
                                }
                                i18 = i17;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                i18 = i19;
            } else {
                i16 = 0;
                break;
            }
        }
        LogUtils.e(TAG, "Invalid length");
        return 0;
    }

    private static void write(byte[] bArr, int i3, int i16, int i17, boolean z16) {
        int i18;
        if (z16) {
            i3 += i17 - 1;
            i18 = -1;
        } else {
            i18 = 1;
        }
        while (true) {
            int i19 = i17 - 1;
            if (i17 > 0) {
                bArr[i3] = (byte) (i16 & 255);
                i16 >>= 8;
                i3 += i18;
                i17 = i19;
            } else {
                return;
            }
        }
    }

    public static int getOrientation(InputStream inputStream) {
        int i3;
        if (inputStream == null) {
            return 0;
        }
        byte[] bArr = new byte[8];
        while (read(inputStream, bArr, 2) && (bArr[0] & 255) == 255) {
            int i16 = bArr[1] & 255;
            if (i16 != 255 && i16 != 216 && i16 != 1) {
                if (i16 == 217 || i16 == 218 || !read(inputStream, bArr, 2)) {
                    return 0;
                }
                int pack = pack(bArr, 0, 2, false);
                if (pack < 2) {
                    LogUtils.e(TAG, "Invalid length");
                    return 0;
                }
                i3 = pack - 2;
                if (i16 == 225 && i3 >= 6) {
                    if (!read(inputStream, bArr, 6)) {
                        return 0;
                    }
                    i3 -= 6;
                    if (pack(bArr, 0, 4, false) == 1165519206 && pack(bArr, 4, 2, false) == 0) {
                        break;
                    }
                }
                try {
                    inputStream.skip(i3);
                } catch (IOException unused) {
                    return 0;
                }
            }
        }
        i3 = 0;
        if (i3 > 8) {
            byte[] bArr2 = new byte[i3];
            if (!read(inputStream, bArr2, i3)) {
                return 0;
            }
            int pack2 = pack(bArr2, 0, 4, false);
            if (pack2 != 1229531648 && pack2 != 1296891946) {
                LogUtils.e(TAG, "Invalid byte order");
                return 0;
            }
            boolean z16 = pack2 == 1229531648;
            int pack3 = pack(bArr2, 4, 4, z16) + 2;
            if (pack3 >= 10 && pack3 <= i3) {
                int i17 = pack3 + 0;
                int i18 = i3 - pack3;
                int pack4 = pack(bArr2, i17 - 2, 2, z16);
                while (true) {
                    int i19 = pack4 - 1;
                    if (pack4 <= 0 || i18 < 12) {
                        break;
                    }
                    if (pack(bArr2, i17, 2, z16) == 274) {
                        int pack5 = pack(bArr2, i17 + 8, 2, z16);
                        if (pack5 == 1) {
                            return 0;
                        }
                        if (pack5 == 3) {
                            return 180;
                        }
                        if (pack5 == 6) {
                            return 90;
                        }
                        if (pack5 == 8) {
                            return 270;
                        }
                        LogUtils.i(TAG, "Unsupported orientation");
                        return 0;
                    }
                    i17 += 12;
                    i18 -= 12;
                    pack4 = i19;
                }
            } else {
                LogUtils.e(TAG, "Invalid offset");
                return 0;
            }
        }
        LogUtils.i(TAG, "Orientation not found");
        return 0;
    }
}
