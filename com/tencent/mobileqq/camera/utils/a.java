package com.tencent.mobileqq.camera.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.mobileqq.camera.adapter.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.zip.InflaterInputStream;
import org.light.device.YearClass;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
@TargetApi(9)
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f201024a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f201025b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71197);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f201024a = false;
            f201025b = true;
        }
    }

    @TargetApi(10)
    public static Bitmap a(byte[] bArr, Rect rect, boolean z16, int i3) throws IOException, OutOfMemoryError {
        boolean z17;
        int i16;
        double d16;
        double d17;
        double d18;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        if (i18 > i17) {
            z17 = true;
        } else {
            z17 = false;
        }
        double max = (Math.max(i17, i18) * 1.0d) / Math.min(i17, i18);
        double height = (rect.height() * 1.0d) / rect.width();
        double d19 = i18;
        double d26 = i17;
        if (max > height) {
            if (z17) {
                d17 = height * d26;
                i16 = i17;
                d16 = d26;
            } else {
                d18 = height * d19;
                i16 = i17;
                d16 = d18;
                d17 = d19;
            }
        } else if (max < height) {
            if (z17) {
                d18 = (1.0d / height) * d19;
                i16 = i17;
                d16 = d18;
                d17 = d19;
            } else {
                d17 = (1.0d / height) * d26;
                i16 = i17;
                d16 = d26;
            }
        } else {
            i16 = i17;
            d16 = d26;
            d17 = d19;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.camera.CameraUtils", 2, "clipJpegToBitmap tw=" + d17 + " th=" + d16 + " bw=" + i18 + " bh=" + i16 + " br=" + max + " sr=" + height);
        }
        options.inJustDecodeBounds = false;
        Rect rect2 = new Rect((int) ((d19 - d17) / 2.0d), (int) ((d26 - d16) / 2.0d), (int) ((d19 + d17) / 2.0d), (int) ((d26 + d16) / 2.0d));
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
        Bitmap decodeRegion = newInstance.decodeRegion(rect2, options);
        newInstance.recycle();
        Matrix matrix = new Matrix();
        matrix.setRotate(i3, decodeRegion.getWidth() / 2.0f, decodeRegion.getHeight() / 2.0f);
        if (z16) {
            matrix.postScale(-1.0f, 1.0f);
        }
        return Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix, false);
    }

    @TargetApi(10)
    public static Bitmap b(byte[] bArr, Rect rect, boolean z16, int i3) throws IOException, OutOfMemoryError {
        boolean z17;
        int i16;
        double d16;
        double d17;
        double d18;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        if (i18 > i17) {
            z17 = true;
        } else {
            z17 = false;
        }
        double max = (Math.max(i17, i18) * 1.0d) / Math.min(i17, i18);
        double height = (rect.height() * 1.0d) / rect.width();
        double d19 = i18;
        double d26 = i17;
        if (max > height) {
            if (z17) {
                d17 = height * d26;
                i16 = i17;
                d16 = d26;
            } else {
                d18 = height * d19;
                i16 = i17;
                d16 = d18;
                d17 = d19;
            }
        } else if (max < height) {
            if (z17) {
                d18 = (1.0d / height) * d19;
                i16 = i17;
                d16 = d18;
                d17 = d19;
            } else {
                d17 = (1.0d / height) * d26;
                i16 = i17;
                d16 = d26;
            }
        } else {
            i16 = i17;
            d16 = d26;
            d17 = d19;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.camera.CameraUtils", 2, "clipJpegToBitmap tw=" + d17 + " th=" + d16 + " bw=" + i18 + " bh=" + i16 + " br=" + max + " sr=" + height);
        }
        options.inJustDecodeBounds = false;
        Rect rect2 = new Rect((int) ((d19 - d17) / 2.0d), (int) ((d26 - d16) / 2.0d), (int) ((d19 + d17) / 2.0d), (int) ((d26 + d16) / 2.0d));
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
        Bitmap decodeRegion = newInstance.decodeRegion(rect2, options);
        newInstance.recycle();
        return decodeRegion;
    }

    public static byte[] c(byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.camera.CameraUtils", 4, "[decodeXML] + BEGIN");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = inflaterInputStream.read(bArr2);
                if (-1 != read) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("OlympicUtil", 2, "inflateConfigString");
                th5.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static boolean d(Context context) {
        return CameraWrapper.h().k();
    }

    public static int e(Context context) {
        return h(context).getInt("qcamera_conf_version", 0);
    }

    public static int f(com.tencent.mobileqq.camera.a aVar, int i3, int i16) {
        if (i16 == -1) {
            i16 = 0;
        }
        Camera.CameraInfo cameraInfo = aVar.a()[i3];
        if (cameraInfo.facing == 1) {
            return ((aVar.b().g(i3, cameraInfo.orientation) - i16) + 360) % 360;
        }
        return (aVar.b().g(i3, cameraInfo.orientation) + i16) % 360;
    }

    public static SharedPreferences g(Context context) {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), "qcamera_local", "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("qcamera_local_mmkv_migrate", false)) {
            QLog.d("Q.camera.CameraUtils", 1, "mmkv migrate Constant.QCAMERA_LOCAL_MMKV_MIGRATE");
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), "qcamera_local", "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("qcamera_local_mmkv_migrate", true).apply();
        }
        return fromSpAdapter;
    }

    public static SharedPreferences h(Context context) {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), "qcamera_pref", "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("qcamera_conf_mmvk_migrate", false)) {
            QLog.d("Q.camera.CameraUtils", 1, "mmkv migrate Constant.QCAMERA_CONF_MMKV_MIGRATE");
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), "qcamera_pref", "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("qcamera_conf_mmvk_migrate", true).apply();
        }
        return fromSpAdapter;
    }

    public static boolean i() {
        try {
            int j3 = CameraWrapper.h().j();
            if (j3 > 0) {
                for (int i3 = 0; i3 < j3; i3++) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i3, cameraInfo);
                    if (1 == cameraInfo.facing) {
                        return true;
                    }
                }
            }
        } catch (RuntimeException e16) {
            QLog.e("Q.camera.CameraUtils", 1, "hasFrontCamera error, ", e16);
        }
        return false;
    }

    public static boolean j() {
        if (CameraWrapper.h().j() < 1 || !CameraWrapper.h().e()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.camera.CameraUtils", 2, "isCameraReady  OK");
        }
        return true;
    }

    public static boolean k() {
        int i3;
        boolean z16;
        if (f201025b) {
            int i16 = 2;
            if (QLog.isColorLevel()) {
                QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] + ENTER");
            }
            QLog.i("Q.camera.CameraUtils", 1, "My Phone: " + b.c().b() + ",  Model: " + b.c().a());
            boolean k3 = CameraWrapper.h().k();
            boolean l3 = l();
            if (!k3 && l3) {
                if (CameraWrapper.h().m()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 1");
                    }
                    i3 = 3;
                } else if (j()) {
                    i3 = 10;
                    z16 = true;
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_FailCode", String.valueOf(i3));
                    hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qcamera_choice_type", false, 0L, 0L, hashMap, "");
                    QLog.i("Q.camera.CameraUtils", 1, "[isChoiceQCamera] choice self qcamera: " + z16 + " choiceResult: " + i3);
                    f201024a = z16;
                    f201025b = false;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 3");
                    }
                    i3 = 4;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 0, qcameraDisabled=" + k3 + " sysVerSupported=" + l3);
                }
                if (k3) {
                    i16 = 1;
                }
                i3 = i16;
            }
            z16 = false;
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("param_FailCode", String.valueOf(i3));
            hashMap2.put(BaseConstants.RDM_NoChangeFailCode, "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qcamera_choice_type", false, 0L, 0L, hashMap2, "");
            QLog.i("Q.camera.CameraUtils", 1, "[isChoiceQCamera] choice self qcamera: " + z16 + " choiceResult: " + i3);
            f201024a = z16;
            f201025b = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.camera.CameraUtils", 1, "[isChoiceQCamera] choice self qcamera final: " + f201024a);
        }
        return f201024a;
    }

    public static boolean l() {
        if (Build.VERSION.SDK_INT >= CameraWrapper.h().i() && YearClass.get(BaseApplication.getContext()) > 2013) {
            return true;
        }
        return false;
    }

    public static boolean m(Context context, String str, int i3) throws XmlPullParserException, IOException {
        n(h(context), str, i3);
        CameraWrapper.h().n(true);
        f201025b = true;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0279  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean n(SharedPreferences sharedPreferences, String str, int i3) throws XmlPullParserException, IOException {
        int i16;
        int i17;
        int i18;
        SharedPreferences.Editor edit;
        boolean z16;
        String str2;
        String str3;
        int i19;
        String str4;
        int i26;
        int i27 = 4;
        QLog.i("Q.camera.CameraUtils", 4, "[parseXML] + BEGIN");
        int i28 = 0;
        if (TextUtils.isEmpty(str)) {
            QLog.e("Q.camera.CameraUtils", 4, "[parseXML] sourceString is empty");
            return false;
        }
        Boolean bool = Boolean.FALSE;
        int i29 = 1;
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            int eventType = newPullParser.getEventType();
            edit = sharedPreferences.edit();
            edit.clear();
            edit.putInt("qcamera_conf_version", i3);
            String b16 = b.c().b();
            String str5 = b16 + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase();
            if (QLog.isColorLevel()) {
                QLog.i("Q.camera.CameraUtils", 4, "parseXML myPhoneType = " + b16 + ", subPhoneName = " + str5);
            }
            z16 = false;
            while (eventType != i29) {
                if (eventType != 2) {
                    str2 = str5;
                    str3 = b16;
                } else {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase(b16)) {
                        try {
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.camera.CameraUtils", 4, "parseXML tagName = " + name + " myPhoneType = " + b16 + ", subPhoneName = " + str5);
                                }
                                int attributeCount = newPullParser.getAttributeCount();
                                int i36 = 0;
                                while (i36 < attributeCount) {
                                    String attributeName = newPullParser.getAttributeName(i36);
                                    String str6 = str5;
                                    String attributeValue = newPullParser.getAttributeValue(i36);
                                    if (attributeName.equalsIgnoreCase("disableCameraSDK")) {
                                        z16 = Boolean.valueOf(Boolean.parseBoolean(attributeValue)).booleanValue();
                                        i19 = attributeCount;
                                    } else if (attributeName.startsWith("int_")) {
                                        i19 = attributeCount;
                                        edit.putInt(attributeName, Integer.valueOf(Integer.parseInt(attributeValue)).intValue());
                                    } else {
                                        i19 = attributeCount;
                                        if (attributeName.startsWith("str_")) {
                                            edit.putString(attributeName, String.valueOf(attributeValue));
                                        } else {
                                            edit.putBoolean(attributeName, Boolean.valueOf(Boolean.parseBoolean(attributeValue)).booleanValue());
                                        }
                                    }
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb5 = new StringBuilder();
                                        str4 = b16;
                                        sb5.append("parseXML item[");
                                        sb5.append(i36 + 1);
                                        sb5.append("] name = ");
                                        sb5.append(attributeName);
                                        sb5.append(", value = ");
                                        sb5.append(attributeValue);
                                        QLog.i("Q.camera.CameraUtils", 4, sb5.toString());
                                    } else {
                                        str4 = b16;
                                    }
                                    i36++;
                                    str5 = str6;
                                    attributeCount = i19;
                                    b16 = str4;
                                }
                                str2 = str5;
                                str3 = b16;
                                bool = Boolean.TRUE;
                            } catch (IOException e16) {
                                e = e16;
                                i18 = 0;
                                QLog.e("Q.camera.CameraUtils", 1, e, new Object[i18]);
                                throw e;
                            } catch (Exception e17) {
                                e = e17;
                                i16 = 0;
                                QLog.e("Q.camera.CameraUtils", 1, e, new Object[i16]);
                                if (QLog.isColorLevel()) {
                                }
                                return bool.booleanValue();
                            }
                        } catch (XmlPullParserException e18) {
                            e = e18;
                            i17 = 0;
                            i27 = 1;
                            QLog.e("Q.camera.CameraUtils", i27, e, new Object[i17]);
                            throw e;
                        }
                    } else {
                        str2 = str5;
                        str3 = b16;
                        if ("PhoneModel".equalsIgnoreCase(name)) {
                            int attributeCount2 = newPullParser.getAttributeCount();
                            int i37 = 0;
                            while (i37 < attributeCount2) {
                                String attributeName2 = newPullParser.getAttributeName(i37);
                                String attributeValue2 = newPullParser.getAttributeValue(i37);
                                if (attributeName2.equalsIgnoreCase("disableCameraSDK")) {
                                    z16 = Boolean.valueOf(Boolean.parseBoolean(attributeValue2)).booleanValue();
                                } else if (attributeName2.startsWith("int_")) {
                                    edit.putInt(attributeName2, Integer.valueOf(Integer.parseInt(attributeValue2)).intValue());
                                } else if (attributeName2.startsWith("str_")) {
                                    edit.putString(attributeName2, String.valueOf(attributeValue2));
                                } else {
                                    edit.putBoolean(attributeName2, Boolean.valueOf(Boolean.parseBoolean(attributeValue2)).booleanValue());
                                }
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb6 = new StringBuilder();
                                    i26 = attributeCount2;
                                    sb6.append("parseRootXML item[");
                                    sb6.append(i37 + 1);
                                    sb6.append("] name = ");
                                    sb6.append(attributeName2);
                                    sb6.append(", value = ");
                                    sb6.append(attributeValue2);
                                    QLog.i("Q.camera.CameraUtils", 4, sb6.toString());
                                } else {
                                    i26 = attributeCount2;
                                }
                                i37++;
                                attributeCount2 = i26;
                            }
                        }
                    }
                }
                eventType = newPullParser.next();
                str5 = str2;
                b16 = str3;
                i27 = 4;
                i28 = 0;
                i29 = 1;
            }
        } catch (IOException e19) {
            e = e19;
            i18 = i28;
        } catch (XmlPullParserException e26) {
            e = e26;
            i17 = i28;
            i27 = i29;
        } catch (Exception e27) {
            e = e27;
            i16 = i28;
        }
        try {
            if (bool.booleanValue()) {
                edit.putBoolean("disableCameraSDK", z16);
                i27 = 1;
                QLog.i("Q.camera.CameraUtils", 1, "[parseXML] phone config founds disableCamera: " + z16);
            } else {
                edit.putBoolean("disableCameraSDK", z16);
                i27 = 1;
                QLog.i("Q.camera.CameraUtils", 1, "[parseXML] phone config not founds disableCamera: " + z16);
            }
            edit.commit();
            if (QLog.isColorLevel()) {
                QLog.i("Q.camera.CameraUtils", 4, "[parseXML] + END parse isPhoneFind=" + bool);
            }
            return bool.booleanValue();
        } catch (XmlPullParserException e28) {
            e = e28;
            i17 = 0;
            QLog.e("Q.camera.CameraUtils", i27, e, new Object[i17]);
            throw e;
        }
    }

    public static void o(Matrix matrix, boolean z16, int i3, int i16, int i17, int i18, int i19) {
        boolean z17;
        float f16;
        matrix.reset();
        if (i16 < i17) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && i18 != 0) {
            i16 = (i19 * i17) / i18;
        }
        if (z16) {
            f16 = -1.0f;
        } else {
            f16 = 1.0f;
        }
        matrix.setScale(f16, 1.0f);
        matrix.postRotate(i3);
        float f17 = i16;
        float f18 = i17;
        matrix.postScale(f17 / 2000.0f, f18 / 2000.0f);
        matrix.postTranslate(f17 / 2.0f, f18 / 2.0f);
    }

    public static Bitmap p(Bitmap bitmap, int i3, boolean z16) {
        System.currentTimeMillis();
        Bitmap bitmap2 = null;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (i3 != 0 && i3 != 360) {
                Matrix matrix = new Matrix();
                matrix.setRotate(i3, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    if (z16 && bitmap != createBitmap) {
                        try {
                            s(bitmap);
                        } catch (OutOfMemoryError e16) {
                            e = e16;
                            bitmap2 = createBitmap;
                            e.printStackTrace();
                            QLog.w("Q.camera.CameraUtils", 2, "OutOfMemoryError. ", e);
                            return bitmap2;
                        }
                    }
                    return createBitmap;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                }
            } else {
                return bitmap;
            }
        }
        return bitmap2;
    }

    public static void q(Context context, boolean z16) {
        h(context).edit().putBoolean("disableCameraSDK", z16);
    }

    public static void r(Context context, int i3) {
        h(context).edit().putInt("qcamera_conf_version", i3).commit();
    }

    public static boolean s(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            return true;
        }
        return false;
    }
}
