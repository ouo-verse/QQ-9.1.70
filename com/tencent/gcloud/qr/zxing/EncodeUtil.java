package com.tencent.gcloud.qr.zxing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EncodeUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String BARCODE_FORMAT_CLASS = "com.google.zxing.BarcodeFormat";
    private static final String BITMATRIX_CLASS = "com.google.zxing.common.BitMatrix";
    private static final String QRCODE_WRITER_CLASS = "com.google.zxing.qrcode.QRCodeWriter";
    private int mHeight;
    private int mOffColor;
    private int mOnColor;
    private int mWidth;

    public EncodeUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mWidth = 230;
        this.mHeight = 230;
        this.mOnColor = -16777216;
        this.mOffColor = -1;
    }

    private static Bitmap addLogo(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        if (width2 != 0 && height2 != 0) {
            float f16 = ((width * 1.0f) / 5.0f) / width2;
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                canvas.scale(f16, f16, width / 2, height / 2);
                canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
                canvas.save();
                canvas.restore();
                return createBitmap;
            } catch (Exception e16) {
                e16.getStackTrace();
                return null;
            }
        }
        return bitmap;
    }

    public static Bitmap compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        for (int i3 = 100; byteArrayOutputStream.toByteArray().length / 1024 > 100 && i3 > 0; i3 -= 10) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    private static Object deleteWhite(Object obj) {
        Object obj2;
        Object obj3 = null;
        if (obj == null) {
            Log.d("tag", "QRCodeAPI EncodeUtil deleteWhite matrixObj is null");
            return null;
        }
        try {
            Method method = obj.getClass().getMethod("getEnclosingRectangle", new Class[0]);
            Method method2 = obj.getClass().getMethod("getWidth", new Class[0]);
            Method method3 = obj.getClass().getMethod("getHeight", new Class[0]);
            Class<?> cls = obj.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method method4 = cls.getMethod("get", cls2, cls2);
            int[] iArr = (int[]) method.invoke(obj, new Object[0]);
            int intValue = ((Integer) method2.invoke(obj, new Object[0])).intValue();
            int intValue2 = ((Integer) method3.invoke(obj, new Object[0])).intValue();
            int i3 = iArr[2] + 1;
            int i16 = iArr[3] + 1;
            if (i3 <= intValue) {
                intValue = i3;
            }
            if (i16 <= intValue2) {
                intValue2 = i16;
            }
            Constructor<?>[] declaredConstructors = BitMatrix.class.getDeclaredConstructors();
            Constructor<?> constructor = null;
            for (int i17 = 0; i17 < declaredConstructors.length; i17++) {
                constructor = declaredConstructors[i17];
                if (constructor.getGenericParameterTypes().length == 2) {
                    break;
                }
            }
            if (constructor != null) {
                constructor.setAccessible(true);
                obj2 = constructor.newInstance(Integer.valueOf(intValue), Integer.valueOf(intValue2));
            } else {
                obj2 = null;
            }
            try {
                if (obj2 == null) {
                    Log.d("tag", "QRCodeAPI EncodeUtil deleteWhite resMatrixObj is null");
                    return null;
                }
                Method method5 = obj2.getClass().getMethod(QCircleLpReportDc05507.KEY_CLEAR, new Class[0]);
                Class<?> cls3 = obj2.getClass();
                Class<?> cls4 = Integer.TYPE;
                Method method6 = cls3.getMethod("set", cls4, cls4);
                method5.invoke(obj2, new Object[0]);
                for (int i18 = 0; i18 < intValue; i18++) {
                    for (int i19 = 0; i19 < intValue2; i19++) {
                        if (((Boolean) method4.invoke(obj, Integer.valueOf(iArr[0] + i18), Integer.valueOf(iArr[1] + i19))).booleanValue()) {
                            method6.invoke(obj2, Integer.valueOf(i18), Integer.valueOf(i19));
                        }
                    }
                }
                return obj2;
            } catch (Exception e16) {
                e = e16;
                obj3 = obj2;
                e.printStackTrace();
                return obj3;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb A[Catch: Exception -> 0x01a2, TryCatch #1 {Exception -> 0x01a2, blocks: (B:11:0x001d, B:15:0x0028, B:18:0x0030, B:40:0x00eb, B:42:0x00f3, B:44:0x00f9, B:46:0x0101, B:50:0x0151, B:52:0x016c, B:54:0x017b, B:55:0x0174, B:58:0x017e, B:60:0x0182, B:62:0x019d, B:70:0x00cf, B:21:0x0050, B:22:0x0058, B:24:0x005b, B:26:0x0065, B:30:0x006a, B:31:0x009c, B:33:0x009f, B:35:0x00af, B:38:0x00b3), top: B:10:0x001d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f3 A[Catch: Exception -> 0x01a2, TryCatch #1 {Exception -> 0x01a2, blocks: (B:11:0x001d, B:15:0x0028, B:18:0x0030, B:40:0x00eb, B:42:0x00f3, B:44:0x00f9, B:46:0x0101, B:50:0x0151, B:52:0x016c, B:54:0x017b, B:55:0x0174, B:58:0x017e, B:60:0x0182, B:62:0x019d, B:70:0x00cf, B:21:0x0050, B:22:0x0058, B:24:0x005b, B:26:0x0065, B:30:0x006a, B:31:0x009c, B:33:0x009f, B:35:0x00af, B:38:0x00b3), top: B:10:0x001d, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap createQRCode(String str, Bitmap bitmap) {
        Object obj;
        Constructor<?> constructor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) bitmap);
        }
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    int i3 = this.mWidth;
                    int i16 = this.mHeight;
                    if (i3 <= i16) {
                        i3 = i16;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
                    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
                    hashMap.put(EncodeHintType.MARGIN, 1);
                    try {
                        Constructor<?>[] declaredConstructors = QRCodeWriter.class.getDeclaredConstructors();
                        constructor = null;
                        for (int i17 = 0; i17 < declaredConstructors.length; i17++) {
                            constructor = declaredConstructors[i17];
                            if (constructor.getGenericParameterTypes().length == 0) {
                                break;
                            }
                        }
                    } catch (Exception e16) {
                        Log.d("tag", "QRCodeAPI EncodeUtil createQRCode encode error:" + e16.toString());
                    }
                    if (constructor != null) {
                        constructor.setAccessible(true);
                        Object newInstance = constructor.newInstance(new Object[0]);
                        Class<?> cls = Class.forName(BARCODE_FORMAT_CLASS);
                        Class cls2 = Integer.TYPE;
                        Method method = QRCodeWriter.class.getMethod("encode", String.class, cls, cls2, cls2, Map.class);
                        Object[] enumConstants = cls.getEnumConstants();
                        Object obj2 = null;
                        for (int i18 = 0; i18 < enumConstants.length; i18++) {
                            obj2 = enumConstants[i18];
                            if (obj2.toString().equals(CommonConstant.RETKEY.QR_CODE)) {
                                break;
                            }
                        }
                        obj = method.invoke(newInstance, str, obj2, Integer.valueOf(i3), Integer.valueOf(i3), hashMap);
                        if (obj != null) {
                            Log.d("tag", "QRCodeAPI EncodeUtil createQRCode bitMatrix is null");
                            return null;
                        }
                        Object deleteWhite = deleteWhite(obj);
                        if (deleteWhite == null) {
                            Log.d("tag", "QRCodeAPI EncodeUtil createQRCode bitMatrix after deleteWhite is null");
                            return null;
                        }
                        Method method2 = deleteWhite.getClass().getMethod("getWidth", new Class[0]);
                        Method method3 = deleteWhite.getClass().getMethod("getHeight", new Class[0]);
                        Class<?> cls3 = deleteWhite.getClass();
                        Class<?> cls4 = Integer.TYPE;
                        Method method4 = cls3.getMethod("get", cls4, cls4);
                        int intValue = ((Integer) method2.invoke(deleteWhite, new Object[0])).intValue();
                        int intValue2 = ((Integer) method3.invoke(deleteWhite, new Object[0])).intValue();
                        int[] iArr = new int[intValue * intValue2];
                        for (int i19 = 0; i19 < intValue2; i19++) {
                            for (int i26 = 0; i26 < intValue; i26++) {
                                if (((Boolean) method4.invoke(deleteWhite, Integer.valueOf(i26), Integer.valueOf(i19))).booleanValue()) {
                                    iArr[(i19 * intValue) + i26] = this.mOnColor;
                                } else {
                                    iArr[(i19 * intValue) + i26] = this.mOffColor;
                                }
                            }
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(intValue, intValue2, Bitmap.Config.ARGB_8888);
                        createBitmap.setPixels(iArr, 0, intValue, 0, 0, intValue, intValue2);
                        if (bitmap != null) {
                            return addLogo(createBitmap, bitmap);
                        }
                        return createBitmap;
                    }
                    obj = null;
                    if (obj != null) {
                    }
                } else {
                    return null;
                }
            } catch (Exception e17) {
                e17.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public void initData(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.mWidth = i3;
        this.mHeight = i16;
        this.mOnColor = i17;
        this.mOffColor = i18;
    }

    public void setQRCodeSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else if (i3 > 0) {
            this.mWidth = i3;
            this.mHeight = i3;
        }
    }

    public boolean writeToFile(Bitmap bitmap, String str, String str2) {
        FileOutputStream fileOutputStream;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, bitmap, str, str2)).booleanValue();
        }
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            Log.e("QR", "mkdirs Error");
            return false;
        }
        try {
            fileOutputStream = new FileOutputStream(new File(str, str2 + ".jpg"));
        } catch (Exception e16) {
            e16.printStackTrace();
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            return false;
        }
        try {
            fileOutputStream.flush();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            z16 = true;
        } catch (Exception e17) {
            e17.printStackTrace();
            z16 = false;
        }
        try {
            fileOutputStream.close();
            return z16;
        } catch (Exception e18) {
            e18.printStackTrace();
            return false;
        }
    }
}
