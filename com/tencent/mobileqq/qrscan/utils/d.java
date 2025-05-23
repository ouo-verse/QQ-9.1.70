package com.tencent.mobileqq.qrscan.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IImgProcessApi;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.api.IQRCodeApi;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.s;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int max = (int) (Math.max(width, height) * 1.4d);
        if (max > 12800) {
            return bitmap;
        }
        int i3 = (max - width) / 2;
        int i16 = (max - height) / 2;
        Bitmap createBitmap = Bitmap.createBitmap(max, max, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, i3, i16, (Paint) null);
        return createBitmap;
    }

    public static String b(String str, String str2, String str3, String str4, String str5, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            byte[] c16 = com.tencent.mobileqq.guid.c.f213821a.c();
            if (c16 != null && c16.length > 0) {
                String bytes2HexStr = HexUtil.bytes2HexStr(c16);
                if (!TextUtils.isEmpty(bytes2HexStr)) {
                    jSONObject.put("guid", bytes2HexStr.toUpperCase());
                }
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("md5", str.toUpperCase());
            }
            if (!TextUtils.isEmpty(str2) && str2.length() < 512) {
                jSONObject.put("url", str2);
            } else if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("uuid", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("fromuin", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("touin", str5);
            }
            String c17 = com.dataline.util.a.c();
            if (!TextUtils.isEmpty(c17)) {
                jSONObject.put("ip", c17);
            }
        } catch (Throwable th5) {
            QLog.i("ScannerUtils", 1, "buildQRScanReportParams error: " + th5.getMessage());
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScannerUtils", 2, "buildQRScanReportParams json: " + jSONObject.toString());
        }
        return jSONObject.toString();
    }

    private static int c(int i3, int i16) {
        double ceil;
        int i17;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("revert_qrscan_sample_threshold_9075", false)) {
            QLog.i("IQRScanConst_ScannerUtils", 1, "calculateSampleSize use new threshold.");
            int max = Math.max(i3, i16);
            if (max > 2048) {
                ceil = Math.ceil(max / 2048.0d);
                i17 = (int) ceil;
            }
            i17 = 1;
        } else {
            int i18 = i3 * i16;
            if (i18 > 1638400) {
                ceil = Math.ceil(Math.sqrt(i18) / 1280.0d);
                i17 = (int) ceil;
            }
            i17 = 1;
        }
        QLog.i("IQRScanConst_ScannerUtils", 1, "calculateSampleSize inSampleSize=" + i17);
        return i17;
    }

    public static int d(Bitmap bitmap, int i3, SparseArray<Object> sparseArray) {
        ScannerResult e16 = e(bitmap, i3);
        if (e16 != null) {
            e16.o(sparseArray);
            return e16.g();
        }
        return 0;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:8|(1:10)|11|(3:86|87|88)(1:13)|14|(3:80|81|82)(1:16)|17|18|19|20|21|(3:24|25|(10:27|28|29|30|31|32|(2:37|38)|40|(1:42)|(4:44|45|46|(2:48|49)(1:50))(3:51|46|(0)(0))))|73|31|32|(3:35|37|38)|40|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0150, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0155, code lost:
    
        r3 = r24;
        r1 = "ScannerUtils.decodeQQCodeFromBmp";
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0196 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016c A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ScannerResult e(Bitmap bitmap, int i3) {
        long j3;
        String str;
        ScannerResult scannerResult;
        boolean z16;
        boolean z17;
        long j16;
        boolean z18;
        long j17;
        int v3;
        boolean isSwitchOn;
        if (bitmap == null || !((IQRCodeApi) QRoute.api(IQRCodeApi.class)).isValidScanImageSize(bitmap.getWidth(), bitmap.getHeight())) {
            return null;
        }
        boolean z19 = false;
        if (QLog.isDevelopLevel()) {
            QLog.d("IQRScanConst_ScannerUtils", 4, String.format("detectQQCodeFromBmp width=%b height=%b", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
        }
        long currentTimeMillis = System.currentTimeMillis();
        ScannerResult scannerResult2 = new ScannerResult();
        int i16 = i3 & 1;
        long j18 = -1;
        if (i16 == 1) {
            try {
                o();
                z17 = true;
            } catch (Throwable th5) {
                th = th5;
                j3 = -1;
                str = "ScannerUtils.decodeQQCodeFromBmp";
                scannerResult = scannerResult2;
                z16 = false;
                try {
                    th.printStackTrace();
                    QLog.e("IQRScanConst_ScannerUtils", 1, "detectQQCodeFromBmp finally error:", th);
                } finally {
                    if (z19) {
                        z();
                    }
                    if (z16) {
                        y(j3, str);
                    }
                }
            }
        } else {
            z17 = false;
        }
        if ((i3 & 2) == 2) {
            try {
                j18 = System.currentTimeMillis();
                n(j18, "ScannerUtils.decodeQQCodeFromBmp");
                j16 = j18;
                z18 = true;
            } catch (Throwable th6) {
                th = th6;
                j3 = j18;
                str = "ScannerUtils.decodeQQCodeFromBmp";
                scannerResult = scannerResult2;
                z16 = false;
                z19 = z17;
                th.printStackTrace();
                QLog.e("IQRScanConst_ScannerUtils", 1, "detectQQCodeFromBmp finally error:", th);
            }
        } else {
            j16 = -1;
            z18 = false;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            z16 = z18;
            j17 = j16;
            try {
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                v3 = v(bitmap, iArr, null, width, height, i3, scannerResult2) | 0;
            } catch (Throwable th7) {
                th = th7;
                scannerResult = scannerResult2;
            }
        } catch (Throwable th8) {
            th = th8;
            z16 = z18;
            j3 = j16;
            str = "ScannerUtils.decodeQQCodeFromBmp";
            scannerResult = scannerResult2;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101123", false) && i16 == 1) {
            try {
            } catch (Throwable th9) {
                th = th9;
                scannerResult = scannerResult2;
                z19 = z17;
                j3 = j17;
                str = "ScannerUtils.decodeQQCodeFromBmp";
                th.printStackTrace();
                QLog.e("IQRScanConst_ScannerUtils", 1, "detectQQCodeFromBmp finally error:", th);
            }
            if (!scannerResult2.m()) {
                scannerResult = scannerResult2;
                try {
                    v3 |= m(bitmap, scannerResult);
                    isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qr_scan_ai_detect", false);
                    QLog.i("IQRScanConst_ScannerUtils", 1, "isAIDetectQRCodeSwitchOn = " + isSwitchOn);
                    if (isSwitchOn && i16 == 1 && !scannerResult.m()) {
                        v3 |= x(bitmap, z16, scannerResult);
                    }
                    bitmap.recycle();
                    QLog.i("IQRScanConst_ScannerUtils", 1, String.format("detectQQCodeFromBmp mode=%d result=%d \nscannerResult=%s", Integer.valueOf(i3), Integer.valueOf(v3), scannerResult));
                    if (z17) {
                        z();
                    }
                } catch (Throwable th10) {
                    th = th10;
                    z19 = z17;
                    j3 = j17;
                    str = "ScannerUtils.decodeQQCodeFromBmp";
                    th.printStackTrace();
                    QLog.e("IQRScanConst_ScannerUtils", 1, "detectQQCodeFromBmp finally error:", th);
                }
                if (z16) {
                    str = "ScannerUtils.decodeQQCodeFromBmp";
                    QLog.i(str, 1, "detectQQCodeFromBmp cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    if (!scannerResult.m()) {
                    }
                } else {
                    j3 = j17;
                    str = "ScannerUtils.decodeQQCodeFromBmp";
                    QLog.i(str, 1, "detectQQCodeFromBmp cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    if (!scannerResult.m()) {
                        return scannerResult;
                    }
                    return null;
                }
            }
        }
        scannerResult = scannerResult2;
        isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qr_scan_ai_detect", false);
        QLog.i("IQRScanConst_ScannerUtils", 1, "isAIDetectQRCodeSwitchOn = " + isSwitchOn);
        if (isSwitchOn) {
            v3 |= x(bitmap, z16, scannerResult);
        }
        bitmap.recycle();
        QLog.i("IQRScanConst_ScannerUtils", 1, String.format("detectQQCodeFromBmp mode=%d result=%d \nscannerResult=%s", Integer.valueOf(i3), Integer.valueOf(v3), scannerResult));
        if (z17) {
        }
        if (z16) {
        }
    }

    public static int f(Uri uri, Context context, int i3, SparseArray<Object> sparseArray) {
        ScannerResult g16 = g(uri, context, i3);
        if (g16 != null) {
            g16.o(sparseArray);
            return g16.g();
        }
        return 0;
    }

    public static ScannerResult g(Uri uri, Context context, int i3) {
        return h(uri, context, i3, false);
    }

    public static ScannerResult h(Uri uri, Context context, int i3, boolean z16) {
        int u16;
        if (uri == null || context == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("IQRScanConst_ScannerUtils", 2, "detectQQCode isSharpP:" + z16 + " mode:" + i3);
        }
        ScannerResult scannerResult = new ScannerResult();
        if (z16) {
            u16 = t(uri, context, i3, scannerResult);
        } else {
            u16 = u(uri, context, i3, scannerResult);
        }
        int i16 = u16 | 0;
        if (QLog.isDevelopLevel()) {
            QLog.d("IQRScanConst_ScannerUtils", 4, "detectQQCode cost: " + (System.currentTimeMillis() - currentTimeMillis) + " result:" + i16 + "\n scannerResult:" + scannerResult);
        }
        if (!scannerResult.m()) {
            return null;
        }
        return scannerResult;
    }

    public static ScannerResult i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null) {
                return null;
            }
            return e(BitmapFactory.decodeByteArray(decode, 0, decode.length), 1);
        } catch (Throwable th5) {
            QLog.e("IQRScanConst_ScannerUtils", 1, "decodeQRCodeFromBase64 error, ", th5);
            return null;
        }
    }

    public static Pair<StringBuilder, StringBuilder> j(Uri uri, Context context) {
        ScannerResult g16 = g(uri, context, 1);
        if (g16 != null) {
            return g16.f();
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(1:155)(1:4)|5|(1:154)(1:8)|9|10|(14:128|129|130|131|132|133|134|135|136|137|138|(1:140)|141|142)(2:12|(15:14|15|16|17|18|19|20|21|22|23|24|25|(2:27|28)(1:116)|29|30)(1:127))|31|32|(1:107)(10:36|37|38|(10:40|41|42|43|44|45|46|47|48|49)(10:95|96|97|98|99|51|52|(2:57|58)|54|55)|64|65|66|(2:68|69)|54|55)|50|51|52|(0)|54|55|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0246, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0236 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x025e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v25, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int k(Context context, Uri uri, int i3, int i16, ScannerResult scannerResult) {
        boolean z16;
        ParcelFileDescriptor parcelFileDescriptor;
        String str;
        String str2;
        int i17;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ParcelFileDescriptor openFileDescriptor;
        int i18;
        String str8;
        ContentResolver contentResolver;
        int min;
        String str9;
        ParcelFileDescriptor parcelFileDescriptor2;
        String str10;
        Bitmap decodeFileDescriptor;
        Bitmap decodeFileDescriptor2;
        int i19;
        int[] iArr;
        boolean z17 = i3 >= i16 * 2 && i16 < 1280;
        boolean z18 = i3 * 2 <= i16 && i3 < 1280;
        ContentResolver contentResolver2 = context.getContentResolver();
        try {
            if (z18) {
                try {
                    openFileDescriptor = contentResolver2.openFileDescriptor(uri, "r");
                } catch (Throwable th5) {
                    th = th5;
                    str3 = "IQRScanConst_ScannerUtils";
                    str2 = "deepParseQRCode finally error:";
                    z16 = z18;
                    parcelFileDescriptor = null;
                    str = str3;
                    i17 = 0;
                    str6 = str;
                    try {
                        th.printStackTrace();
                        QLog.w(str6, 1, "deepParseQRCode error:", th);
                        str7 = str6;
                        if (parcelFileDescriptor != null) {
                        }
                        QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
                        return i17;
                    } finally {
                    }
                }
                try {
                    Bitmap decodeFileDescriptor3 = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                    openFileDescriptor.close();
                    int i26 = i3 * i3;
                    int[] iArr2 = new int[i26];
                    str5 = "IQRScanConst_ScannerUtils";
                    str4 = "deepParseQRCode finally error:";
                    decodeFileDescriptor3.getPixels(iArr2, 0, i3, 0, 0, i3, i3);
                    byte[] bArr = new byte[i26];
                    ((IImgProcessApi) QRoute.api(IImgProcessApi.class)).TransBytes(iArr2, bArr, i3, i3);
                    int w3 = w(iArr2, bArr, i3, i3, scannerResult) | 0;
                    try {
                        if (!scannerResult.l()) {
                            decodeFileDescriptor3.getPixels(iArr2, 0, i3, 0, i16 - i3, i3, i3);
                            ((IImgProcessApi) QRoute.api(IImgProcessApi.class)).TransBytes(iArr2, bArr, i3, i3);
                            w3 |= w(iArr2, bArr, i3, i3, scannerResult);
                        }
                        decodeFileDescriptor3.recycle();
                        i18 = w3;
                        str8 = "r";
                        contentResolver = contentResolver2;
                        z16 = z18;
                        z18 = z18;
                    } catch (Throwable th6) {
                        th = th6;
                        i17 = w3;
                        str6 = str5;
                        str2 = str4;
                        parcelFileDescriptor = null;
                        z16 = z18;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    parcelFileDescriptor = openFileDescriptor;
                    str = "IQRScanConst_ScannerUtils";
                    str2 = "deepParseQRCode finally error:";
                    z16 = z18;
                    i17 = 0;
                    str6 = str;
                    th.printStackTrace();
                    QLog.w(str6, 1, "deepParseQRCode error:", th);
                    str7 = str6;
                    if (parcelFileDescriptor != null) {
                    }
                    QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
                    return i17;
                }
            } else {
                str5 = "IQRScanConst_ScannerUtils";
                str4 = "deepParseQRCode finally error:";
                if (z17) {
                    str8 = "r";
                    contentResolver = contentResolver2;
                    parcelFileDescriptor = contentResolver.openFileDescriptor(uri, str8);
                    try {
                        decodeFileDescriptor2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                        parcelFileDescriptor.close();
                        i19 = i16 * i16;
                        iArr = new int[i19];
                        z16 = z18;
                    } catch (Throwable th8) {
                        th = th8;
                        z16 = z18;
                        str = str5;
                        str2 = str4;
                        i17 = 0;
                        str6 = str;
                        th.printStackTrace();
                        QLog.w(str6, 1, "deepParseQRCode error:", th);
                        str7 = str6;
                        if (parcelFileDescriptor != null) {
                        }
                        QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
                        return i17;
                    }
                    try {
                        decodeFileDescriptor2.getPixels(iArr, 0, i16, 0, 0, i16, i16);
                        byte[] bArr2 = new byte[i19];
                        ((IImgProcessApi) QRoute.api(IImgProcessApi.class)).TransBytes(iArr, bArr2, i16, i16);
                        int w16 = w(iArr, bArr2, i16, i16, scannerResult) | 0;
                        try {
                            if (scannerResult.l()) {
                                i18 = w16;
                            } else {
                                decodeFileDescriptor2.getPixels(iArr, 0, i16, i3 - i16, 0, i16, i16);
                                ((IImgProcessApi) QRoute.api(IImgProcessApi.class)).TransBytes(iArr, bArr2, i16, i16);
                                i18 = w16 | w(iArr, bArr2, i16, i16, scannerResult);
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            i17 = w16;
                        }
                        try {
                            decodeFileDescriptor2.recycle();
                            z18 = bArr2;
                        } catch (Throwable th10) {
                            th = th10;
                            i17 = i18;
                            str6 = str5;
                            str2 = str4;
                            parcelFileDescriptor = null;
                            th.printStackTrace();
                            QLog.w(str6, 1, "deepParseQRCode error:", th);
                            str7 = str6;
                            if (parcelFileDescriptor != null) {
                            }
                            QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
                            return i17;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        str3 = str5;
                        str2 = str4;
                        parcelFileDescriptor = null;
                        str = str3;
                        i17 = 0;
                        str6 = str;
                        th.printStackTrace();
                        QLog.w(str6, 1, "deepParseQRCode error:", th);
                        str7 = str6;
                        if (parcelFileDescriptor != null) {
                        }
                        QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
                        return i17;
                    }
                } else {
                    z16 = z18;
                    str8 = "r";
                    contentResolver = contentResolver2;
                    i18 = 0;
                    z18 = z18;
                }
            }
            try {
                min = Math.min(i3, i16);
            } catch (Throwable th12) {
                th = th12;
                str6 = str5;
                str2 = str4;
                i17 = i18;
                parcelFileDescriptor = null;
            }
        } catch (Throwable th13) {
            th = th13;
            z16 = z18;
        }
        if (!scannerResult.l() && min > 250) {
            try {
                parcelFileDescriptor2 = null;
                str10 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101123", false);
            } catch (Throwable th14) {
                th = th14;
                str10 = str5;
            }
            try {
            } catch (Throwable th15) {
                th = th15;
                i17 = i18;
                parcelFileDescriptor = parcelFileDescriptor2;
                str2 = str4;
                str6 = str10;
                th.printStackTrace();
                QLog.w(str6, 1, "deepParseQRCode error:", th);
                str7 = str6;
                if (parcelFileDescriptor != null) {
                }
                QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
                return i17;
            }
            if (str10 == 0) {
                str10 = str5;
                try {
                    QLog.i(str10, 1, "deepParseQRCode use new down sample.");
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = c(i3, i16);
                    QLog.i(str10, 1, "decodeBitmap inSampleSize=" + options.inSampleSize);
                    parcelFileDescriptor = contentResolver.openFileDescriptor(uri, str8);
                    try {
                        parcelFileDescriptor2 = null;
                        decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                        parcelFileDescriptor.close();
                        i17 = i18 | m(decodeFileDescriptor, scannerResult);
                    } catch (Throwable th16) {
                        th = th16;
                        i17 = i18;
                    }
                } catch (Throwable th17) {
                    th = th17;
                    parcelFileDescriptor2 = null;
                    i17 = i18;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    str2 = str4;
                    str6 = str10;
                    th.printStackTrace();
                    QLog.w(str6, 1, "deepParseQRCode error:", th);
                    str7 = str6;
                    if (parcelFileDescriptor != null) {
                    }
                    QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
                    return i17;
                }
                try {
                    decodeFileDescriptor.recycle();
                    str9 = str10;
                } catch (Throwable th18) {
                    th = th18;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    str2 = str4;
                    str6 = str10;
                    th.printStackTrace();
                    QLog.w(str6, 1, "deepParseQRCode error:", th);
                    str7 = str6;
                    if (parcelFileDescriptor != null) {
                    }
                    QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
                    return i17;
                }
            } else {
                str10 = str5;
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = (int) Math.ceil(min / 250.0d);
                ParcelFileDescriptor openFileDescriptor2 = contentResolver.openFileDescriptor(uri, str8);
                try {
                    Bitmap decodeFileDescriptor4 = BitmapFactory.decodeFileDescriptor(openFileDescriptor2.getFileDescriptor(), null, options2);
                    int width = decodeFileDescriptor4.getWidth();
                    int height = decodeFileDescriptor4.getHeight();
                    int[] iArr3 = new int[width * height];
                    decodeFileDescriptor4.getPixels(iArr3, 0, width, 0, 0, width, height);
                    decodeFileDescriptor4.recycle();
                    i17 = w(iArr3, null, width, height, scannerResult) | i18;
                    parcelFileDescriptor = openFileDescriptor2;
                    str10 = str10;
                    scannerResult.n();
                    str7 = str10;
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                            str7 = str10;
                        } catch (Throwable th19) {
                            th19.printStackTrace();
                            QLog.w(str10, 1, str4, th19);
                            str7 = str10;
                        }
                    }
                } catch (Throwable th20) {
                    th = th20;
                    i17 = i18;
                    parcelFileDescriptor = openFileDescriptor2;
                }
                QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
                return i17;
            }
            str2 = str4;
            str6 = str10;
            th.printStackTrace();
            QLog.w(str6, 1, "deepParseQRCode error:", th);
            str7 = str6;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                    str7 = str6;
                } catch (Throwable th21) {
                    th21.printStackTrace();
                    QLog.w(str6, 1, str2, th21);
                    str7 = str6;
                }
            }
            QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
            return i17;
        }
        str9 = str5;
        parcelFileDescriptor2 = null;
        i17 = i18;
        parcelFileDescriptor = parcelFileDescriptor2;
        str10 = str9;
        scannerResult.n();
        str7 = str10;
        if (parcelFileDescriptor != null) {
        }
        QLog.i(str7, 1, "deepParseQRCode isSuperWide:" + z17 + " isSuperLong:" + z16 + " scannerResult:" + scannerResult);
        return i17;
    }

    private static Bitmap l(Bitmap bitmap, int i3) {
        if (bitmap != null && !bitmap.isRecycled() && i3 > 0) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i16 = width / i3;
            int i17 = height / i3;
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int[] iArr2 = new int[i16 * i17];
            int i18 = 0;
            int i19 = 0;
            while (i19 < i17) {
                int i26 = i18;
                while (i26 < i16) {
                    int i27 = i26 * i3;
                    int i28 = i19 * i3;
                    int i29 = width - 1;
                    int min = Math.min(i27 + i3, i29);
                    int i36 = height - 1;
                    int min2 = Math.min(i28 + i3, i36);
                    int i37 = height;
                    int max = Math.max(i27 - i3, i18);
                    int i38 = i17;
                    int max2 = Math.max(i28 - i3, i18);
                    int i39 = i3 * 2;
                    int[] iArr3 = iArr2;
                    int min3 = Math.min(i27 + i39, i29);
                    int min4 = Math.min(i28 + i39, i36);
                    int i46 = i26;
                    int max3 = Math.max(i27 - i39, 0);
                    int i47 = i19;
                    int max4 = Math.max(i28 - i39, 0);
                    int i48 = max2 * width;
                    int i49 = iArr[i48 + max];
                    int i56 = i16;
                    int i57 = iArr[i48 + min];
                    int i58 = min2 * width;
                    int i59 = iArr[i58 + max];
                    int i65 = iArr[i58 + min];
                    int i66 = max4 * width;
                    int i67 = iArr[i66 + max3];
                    int i68 = iArr[i66 + min3];
                    int i69 = min4 * width;
                    int i75 = width;
                    int i76 = iArr[i69 + max3];
                    int i77 = iArr[i69 + min3];
                    float f16 = i27 - max;
                    float f17 = i3;
                    float f18 = f16 / f17;
                    float f19 = i39;
                    float f26 = (i27 - max3) / f19;
                    iArr3[(i47 * i56) + i46] = p(p(p(i49, i57, f18), p(i59, i65, f18), (i28 - max2) / f17), p(p(i67, i68, f26), p(i76, i77, f26), (i28 - max4) / f19), 0.5f);
                    i26 = i46 + 1;
                    i19 = i47;
                    height = i37;
                    i17 = i38;
                    iArr2 = iArr3;
                    i16 = i56;
                    width = i75;
                    i18 = 0;
                }
                i19++;
                i18 = 0;
            }
            return Bitmap.createBitmap(iArr2, i16, i17, Bitmap.Config.ARGB_8888);
        }
        return bitmap;
    }

    private static int m(Bitmap bitmap, ScannerResult scannerResult) {
        int i3 = 0;
        if (bitmap != null && !bitmap.isRecycled()) {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            if (min <= 250) {
                return 0;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap l3 = l(bitmap, (int) Math.ceil(min / 250.0d));
                int width = l3.getWidth();
                int height = l3.getHeight();
                QLog.i("IQRScanConst_ScannerUtils", 1, "downSampleBitmap cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", downSampleWidth=" + width + ", downSampleHeight=" + height);
                int[] iArr = new int[width * height];
                l3.getPixels(iArr, 0, width, 0, 0, width, height);
                i3 = 0 | w(iArr, null, width, height, scannerResult);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("downSampleParseQRCodeFromBmp, result=");
                sb5.append(i3);
                QLog.i("IQRScanConst_ScannerUtils", 1, sb5.toString());
                return i3;
            } catch (Throwable th5) {
                QLog.e("IQRScanConst_ScannerUtils", 1, "downSampleParseQRCodeFromBmp error,", th5);
                return i3;
            }
        }
        QLog.e("IQRScanConst_ScannerUtils", 1, "downSampleParseQRCodeFromBmp, bitmap is null or recycled.");
        return 0;
    }

    private static void n(long j3, String str) {
        ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).init(BaseApplication.getContext(), j3, str);
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, String.format("initQMini minicode=%b busiHash=%d", Boolean.valueOf(((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).isDecodeInited()), Long.valueOf(j3)));
        }
    }

    private static int o() {
        try {
            int init = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).init(1, "ANY", "UTF-8");
            int readers = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).setReaders(((IQRCodeApi) QRoute.api(IQRCodeApi.class)).getSupportReader());
            String version = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).getVersion();
            if (QLog.isDevelopLevel()) {
                QLog.d("IQRScanConst_ScannerUtils", 4, "initQbar initResult:" + init + ",setReadersResult:" + readers + "version:" + version);
            }
            if (init < 0 || readers < 0) {
                return -1;
            }
            return 0;
        } catch (Throwable th5) {
            QLog.e("IQRScanConst_ScannerUtils", 1, "initQbar failed:", th5);
            return -1;
        }
    }

    private static int p(int i3, int i16, float f16) {
        float f17 = 1.0f - f16;
        return ((int) (((i3 & 255) * f17) + ((i16 & 255) * f16))) | (((int) ((((i3 >> 24) & 255) * f17) + (((i16 >> 24) & 255) * f16))) << 24) | (((int) ((((i3 >> 16) & 255) * f17) + (((i16 >> 16) & 255) * f16))) << 16) | (((int) ((((i3 >> 8) & 255) * f17) + (((i16 >> 8) & 255) * f16))) << 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int q(Bitmap bitmap, int[] iArr, byte[] bArr, int i3, int i16, ScannerResult scannerResult) {
        byte[] bArr2;
        boolean z16;
        String str;
        boolean z17;
        long j3;
        byte[] bArr3;
        int i17;
        int i18;
        long currentTimeMillis = System.currentTimeMillis();
        if (bArr == null) {
            byte[] bArr4 = new byte[i3 * i16];
            ((IImgProcessApi) QRoute.api(IImgProcessApi.class)).TransBytes(iArr, bArr4, i3, i16);
            bArr2 = bArr4;
        } else {
            bArr2 = bArr;
        }
        boolean z18 = false;
        if (((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).getSupportDetectType() > 0 && ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).isDetectInited()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = "IQRScanConst_ScannerUtils";
        int i19 = 2;
        if (z16) {
            scannerResult.f276522f = true;
            ArrayList<com.tencent.mobileqq.qrscan.a> arrayList = new ArrayList<>();
            boolean detectSync = ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).detectSync(bitmap, arrayList);
            if (QLog.isColorLevel()) {
                QLog.i("IQRScanConst_ScannerUtils", 2, String.format("parseMiniCode exec=%b, detectRects=%s", Boolean.valueOf(detectSync), arrayList));
            }
            if (detectSync && !arrayList.isEmpty()) {
                Iterator<com.tencent.mobileqq.qrscan.a> it = arrayList.iterator();
                int i26 = 0;
                i18 = 0;
                int i27 = 0;
                while (it.hasNext()) {
                    com.tencent.mobileqq.qrscan.a next = it.next();
                    int i28 = next.f276531a;
                    if (i28 == i19 || i28 == 3) {
                        int i29 = i26 + 1;
                        Rect rect = new Rect();
                        s.a(next.f276532b, rect, i3, i16, 1.2f);
                        StringBuilder sb5 = new StringBuilder();
                        long j16 = currentTimeMillis;
                        String str3 = str2;
                        boolean z19 = z16;
                        byte[] bArr5 = bArr2;
                        int r16 = r(iArr, bArr2, i3, i16, rect.left, rect.top, rect.width(), rect.height(), next.f276531a, sb5);
                        if ((r16 & 2) != 0) {
                            i27++;
                            scannerResult.b(sb5.toString(), next.f276532b, next.f276533c, i3, i16, next.f276531a);
                        }
                        i18 |= r16;
                        bArr2 = bArr5;
                        i26 = i29;
                        z16 = z19;
                        currentTimeMillis = j16;
                        str2 = str3;
                        i19 = 2;
                        z18 = false;
                    }
                }
                str = str2;
                z17 = z16;
                j3 = currentTimeMillis;
                bArr3 = bArr2;
                if (!((IScanUtilApi) QRoute.api(IScanUtilApi.class)).recognizeQQCodeWithoutAI() && i26 > 0 && !scannerResult.j()) {
                    i18 |= s(iArr, bArr3, i3, i16, scannerResult);
                }
                i17 = i27;
                if (((IScanUtilApi) QRoute.api(IScanUtilApi.class)).recognizeQQCodeWithoutAI() && i17 == 0) {
                    i18 |= s(iArr, bArr3, i3, i16, scannerResult);
                }
                int i36 = i18;
                if (QLog.isColorLevel()) {
                    QLog.i(str, 2, String.format("parseMiniCode cost\uff1a" + (System.currentTimeMillis() - j3), new Object[0]) + " returnResult:" + i36 + " supportDetect:" + z17 + " aiDetectCnt:" + i17);
                }
                return i36;
            }
        }
        str = "IQRScanConst_ScannerUtils";
        z17 = z16;
        j3 = currentTimeMillis;
        bArr3 = bArr2;
        i17 = 0;
        i18 = 0;
        if (((IScanUtilApi) QRoute.api(IScanUtilApi.class)).recognizeQQCodeWithoutAI()) {
            i18 |= s(iArr, bArr3, i3, i16, scannerResult);
        }
        int i362 = i18;
        if (QLog.isColorLevel()) {
        }
        return i362;
    }

    private static int r(int[] iArr, byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27, StringBuilder sb5) {
        String decode = ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).decode(bArr, i3, i16, i17, i18, i19, i26, i27, 1);
        if (!((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).bValidDecodeResult(decode)) {
            return 0;
        }
        if (sb5.length() > 0) {
            sb5.delete(0, sb5.length());
        }
        sb5.append(decode);
        return 2;
    }

    private static int s(int[] iArr, byte[] bArr, int i3, int i16, ScannerResult scannerResult) {
        int i17 = 0;
        scannerResult.f276522f = false;
        StringBuilder sb5 = new StringBuilder();
        int r16 = r(iArr, bArr, i3, i16, 0, 0, 0, 0, 0, sb5);
        if ((r16 & 2) != 0) {
            int i18 = com.tencent.mobileqq.qrscan.c.f276614a;
            String substring = sb5.substring(0, i18);
            if ("WITHOUTAIQQ&".equals(substring)) {
                i17 = 2;
            } else if ("WITHOUTAIWX&".equals(substring)) {
                i17 = 3;
            }
            scannerResult.a(sb5.substring(i18, sb5.length()), i17);
        }
        return r16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f8, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f5, code lost:
    
        if (r23 == false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int t(Uri uri, Context context, int i3, ScannerResult scannerResult) {
        Throwable th5;
        int i16;
        boolean z16;
        boolean z17;
        long j3;
        int v3;
        boolean z18 = false;
        if ((i3 & 3) == 0) {
            return 0;
        }
        long j16 = -1;
        try {
            Bitmap decodeSharpP = ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).decodeSharpP(uri.getPath());
            if (QLog.isDevelopLevel()) {
                QLog.d("IQRScanConst_ScannerUtils", 4, "parseQQCodeForSharpP 0 bmp:" + decodeSharpP);
            }
            if (decodeSharpP != null) {
                int width = decodeSharpP.getWidth();
                int height = decodeSharpP.getHeight();
                if (!((IQRCodeApi) QRoute.api(IQRCodeApi.class)).isValidScanImageSize(width, height)) {
                    return 0;
                }
                if ((i3 & 1) == 1) {
                    o();
                    z17 = true;
                } else {
                    z17 = false;
                }
                if ((i3 & 2) == 2) {
                    try {
                        j16 = System.currentTimeMillis();
                        n(j16, "ScannerUtils.parseQQCodeForSharpP");
                        j3 = j16;
                        z16 = true;
                    } catch (Throwable th6) {
                        th5 = th6;
                        i16 = 0;
                        z16 = false;
                        z18 = z17;
                        try {
                            th5.printStackTrace();
                            QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForSharpP error:", th5);
                            if (z18) {
                                z();
                            }
                        } finally {
                            if (z18) {
                                z();
                            }
                            if (z16) {
                                y(j16, "ScannerUtils.parseQQCodeForSharpP");
                            }
                        }
                    }
                } else {
                    j3 = -1;
                    z16 = false;
                }
                try {
                    int[] iArr = new int[width * height];
                    decodeSharpP.getPixels(iArr, 0, width, 0, 0, width, height);
                    v3 = v(decodeSharpP, iArr, null, width, height, i3, scannerResult) | 0;
                } catch (Throwable th7) {
                    th5 = th7;
                    i16 = 0;
                }
                try {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("IQRScanConst_ScannerUtils", 4, String.format("parseQQCodeForSharpP mode=%d result=%d \nscannerResult=%s", Integer.valueOf(i3), Integer.valueOf(v3), scannerResult));
                    }
                    decodeSharpP.recycle();
                    i16 = v3;
                    z18 = z17;
                    j16 = j3;
                } catch (Throwable th8) {
                    th5 = th8;
                    i16 = v3;
                    z18 = z17;
                    j16 = j3;
                    th5.printStackTrace();
                    QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForSharpP error:", th5);
                    if (z18) {
                    }
                }
            } else {
                i16 = 0;
                z16 = false;
            }
        } catch (Throwable th9) {
            th5 = th9;
            i16 = 0;
            z16 = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int u(Uri uri, Context context, int i3, ScannerResult scannerResult) {
        int i16;
        boolean z16;
        int i17;
        long j3;
        boolean z17;
        boolean z18;
        int width;
        int height;
        int[] iArr;
        long j16;
        boolean isSwitchOn;
        Bitmap bitmap;
        int i18 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        long j17 = -1;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    try {
                        openFileDescriptor.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri finally error:", th5);
                    }
                }
                return 0;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                openFileDescriptor.close();
                int i19 = options.outWidth;
                int i26 = options.outHeight;
                options.inJustDecodeBounds = false;
                if (i19 > 12800 || i26 > 12800 || !((IQRCodeApi) QRoute.api(IQRCodeApi.class)).isValidScanImageSize(i19, i26)) {
                    return 0;
                }
                options.inSampleSize = c(i19, i26);
                ParcelFileDescriptor openFileDescriptor2 = contentResolver.openFileDescriptor(uri, "r");
                try {
                    Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor2.getFileDescriptor(), null, options);
                    if (decodeFileDescriptor == null) {
                        try {
                            openFileDescriptor2.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                            QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri finally error:", th6);
                        }
                        return 0;
                    }
                    int i27 = i3 & 1;
                    if (i27 == 1) {
                        o();
                        i17 = 1;
                    } else {
                        i17 = 0;
                    }
                    if ((i3 & 2) == 2) {
                        try {
                            j17 = System.currentTimeMillis();
                            n(j17, "ScannerUtils.parseQQCodeForUri");
                            j3 = j17;
                            z17 = true;
                        } catch (Throwable th7) {
                            th = th7;
                            i16 = 0;
                            z16 = false;
                            parcelFileDescriptor = openFileDescriptor2;
                            i18 = i17;
                            try {
                                th.printStackTrace();
                                QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri error:", th);
                                if (i18 != 0) {
                                }
                                if (z16) {
                                }
                                if (parcelFileDescriptor != null) {
                                }
                                return i16;
                            } finally {
                            }
                        }
                    } else {
                        j3 = -1;
                        z17 = false;
                    }
                    try {
                        width = decodeFileDescriptor.getWidth();
                        height = decodeFileDescriptor.getHeight();
                        iArr = new int[width * height];
                        decodeFileDescriptor.getPixels(iArr, 0, width, 0, 0, width, height);
                        z16 = z17;
                        j16 = j3;
                    } catch (Throwable th8) {
                        th = th8;
                        z18 = z17;
                        j17 = j3;
                    }
                    try {
                        i16 = v(decodeFileDescriptor, iArr, null, width, height, i3, scannerResult) | 0;
                        if (i27 == 1) {
                            try {
                                if (!scannerResult.m()) {
                                    i16 |= k(context, uri, i19, i26, scannerResult);
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                parcelFileDescriptor = openFileDescriptor2;
                                i18 = i17;
                                j17 = j16;
                                th.printStackTrace();
                                QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri error:", th);
                                if (i18 != 0) {
                                }
                                if (z16) {
                                }
                                if (parcelFileDescriptor != null) {
                                }
                                return i16;
                            }
                        }
                        try {
                            isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qr_scan_ai_detect", false);
                            QLog.i("IQRScanConst_ScannerUtils", 1, "isAIDetectQRCodeSwitchOn = " + isSwitchOn);
                        } catch (Throwable th10) {
                            th = th10;
                            j17 = j16;
                            parcelFileDescriptor = openFileDescriptor2;
                            i18 = i17;
                            th.printStackTrace();
                            QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri error:", th);
                            if (i18 != 0) {
                            }
                            if (z16) {
                            }
                            if (parcelFileDescriptor != null) {
                            }
                            return i16;
                        }
                        try {
                            try {
                                if (isSwitchOn && i27 == 1) {
                                    try {
                                        if (!scannerResult.m()) {
                                            z18 = z16;
                                            bitmap = decodeFileDescriptor;
                                            try {
                                                i16 |= x(bitmap, z18, scannerResult);
                                                i18 = i16;
                                                bitmap.recycle();
                                                if (i17 != 0) {
                                                    z();
                                                }
                                                if (z18) {
                                                    y(j16, "ScannerUtils.parseQQCodeForUri");
                                                }
                                                openFileDescriptor2.close();
                                                return i18;
                                            } catch (Throwable th11) {
                                                th = th11;
                                                z16 = z18;
                                                parcelFileDescriptor = openFileDescriptor2;
                                                i18 = i17;
                                                j17 = j16;
                                                th.printStackTrace();
                                                QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri error:", th);
                                                if (i18 != 0) {
                                                }
                                                if (z16) {
                                                }
                                                if (parcelFileDescriptor != null) {
                                                }
                                                return i16;
                                            }
                                        }
                                    } catch (Throwable th12) {
                                        th = th12;
                                    }
                                }
                                openFileDescriptor2.close();
                                return i18;
                            } catch (Throwable th13) {
                                th13.printStackTrace();
                                QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri finally error:", th13);
                                return i18;
                            }
                            bitmap.recycle();
                            if (i17 != 0) {
                            }
                            if (z18) {
                            }
                        } catch (Throwable th14) {
                            th = th14;
                            j17 = j16;
                            z16 = z18;
                            i16 = i18;
                            parcelFileDescriptor = openFileDescriptor2;
                            i18 = i17;
                            th.printStackTrace();
                            QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri error:", th);
                            if (i18 != 0) {
                            }
                            if (z16) {
                            }
                            if (parcelFileDescriptor != null) {
                            }
                            return i16;
                        }
                        z18 = z16;
                        bitmap = decodeFileDescriptor;
                        i18 = i16;
                    } catch (Throwable th15) {
                        th = th15;
                        j17 = j16;
                        i16 = i18;
                        parcelFileDescriptor = openFileDescriptor2;
                        i18 = i17;
                        th.printStackTrace();
                        QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri error:", th);
                        if (i18 != 0) {
                            z();
                        }
                        if (z16) {
                            y(j17, "ScannerUtils.parseQQCodeForUri");
                        }
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (Throwable th16) {
                                th16.printStackTrace();
                                QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri finally error:", th16);
                            }
                        }
                        return i16;
                    }
                } catch (Throwable th17) {
                    th = th17;
                    i16 = 0;
                    z16 = false;
                    parcelFileDescriptor = openFileDescriptor2;
                }
            } catch (Throwable th18) {
                th = th18;
                parcelFileDescriptor = openFileDescriptor;
                i16 = 0;
                z16 = false;
                th.printStackTrace();
                QLog.w("IQRScanConst_ScannerUtils", 1, "parseQQCodeForUri error:", th);
                if (i18 != 0) {
                }
                if (z16) {
                }
                if (parcelFileDescriptor != null) {
                }
                return i16;
            }
        } catch (Throwable th19) {
            th = th19;
        }
    }

    private static int v(Bitmap bitmap, int[] iArr, byte[] bArr, int i3, int i16, int i17, ScannerResult scannerResult) {
        if (bArr == null) {
            bArr = new byte[i3 * i16];
            ((IImgProcessApi) QRoute.api(IImgProcessApi.class)).TransBytes(iArr, bArr, i3, i16);
        }
        byte[] bArr2 = bArr;
        int i18 = 0;
        if ((i17 & 1) == 1) {
            i18 = 0 | w(iArr, bArr2, i3, i16, scannerResult);
        }
        int i19 = i18;
        if ((i17 & 2) == 2) {
            return i19 | q(bitmap, iArr, bArr2, i3, i16, scannerResult);
        }
        return i19;
    }

    private static int w(int[] iArr, byte[] bArr, int i3, int i16, ScannerResult scannerResult) {
        long currentTimeMillis = System.currentTimeMillis();
        if (bArr == null) {
            bArr = new byte[i3 * i16];
            ((IImgProcessApi) QRoute.api(IImgProcessApi.class)).TransBytes(iArr, bArr, i3, i16);
        }
        int scanImage = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).scanImage(bArr, i3, i16);
        int i17 = 1;
        if (scanImage == 1) {
            scannerResult.f276520d = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).getResult();
        } else {
            i17 = 0;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(String.format("parseQRCode cost\uff1a" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]));
            sb5.append(" returnResult:");
            sb5.append(i17);
            QLog.i("IQRScanConst_ScannerUtils", 2, sb5.toString());
        }
        return i17;
    }

    private static int x(Bitmap bitmap, boolean z16, ScannerResult scannerResult) {
        long j3;
        boolean z17;
        boolean z18;
        int i3 = 0;
        if (bitmap != null && !bitmap.isRecycled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!z16) {
                j3 = System.currentTimeMillis();
                n(j3, "ScannerUtils.parseQRCodeWithAIDetect");
                z17 = true;
            } else {
                j3 = 0;
                z17 = false;
            }
            if (((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).getSupportDetectType() > 0 && ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).isDetectInited()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                ArrayList<com.tencent.mobileqq.qrscan.a> arrayList = new ArrayList<>();
                Bitmap a16 = a(bitmap);
                boolean detectSync = ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).detectSync(a16, arrayList);
                String str = "IQRScanConst_ScannerUtils";
                QLog.i("IQRScanConst_ScannerUtils", 1, String.format("parseQRCodeWithAIDetect exec=%b, detectRects=%s", Boolean.valueOf(detectSync), arrayList));
                if (detectSync && !arrayList.isEmpty()) {
                    Iterator<com.tencent.mobileqq.qrscan.a> it = arrayList.iterator();
                    while (it.hasNext()) {
                        com.tencent.mobileqq.qrscan.a next = it.next();
                        Rect rect = new Rect();
                        s.a(next.f276532b, rect, a16.getWidth(), a16.getHeight(), 1.2f);
                        int[] iArr = new int[rect.width() * rect.height()];
                        String str2 = str;
                        a16.getPixels(iArr, 0, rect.width(), rect.left, rect.top, rect.width(), rect.height());
                        int w3 = w(iArr, null, rect.width(), rect.height(), scannerResult);
                        QLog.i(str2, 1, "parseQRCodeWithAIDetect result = " + w3);
                        i3 |= w3;
                        str = str2;
                        a16 = a16;
                    }
                }
                scannerResult.n();
                a16.recycle();
                QLog.i(str, 1, "parseQRCodeWithAIDetect cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
            if (z17) {
                y(j3, "ScannerUtils.parseQRCodeWithAIDetect");
            }
        }
        return i3;
    }

    private static void y(long j3, String str) {
        ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).unInit(j3, str);
    }

    private static int z() {
        try {
            if (((IQRCodeApi) QRoute.api(IQRCodeApi.class)).release() < 0) {
                return -1;
            }
            return 0;
        } catch (Throwable th5) {
            QLog.e("IQRScanConst_ScannerUtils", 1, "releaseQbar failed:", th5);
            return -1;
        }
    }
}
