package com.tencent.mobileqq.olympic.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.InflaterInputStream;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static SimpleDateFormat f255235a;

    /* renamed from: b, reason: collision with root package name */
    private static int f255236b;

    /* renamed from: c, reason: collision with root package name */
    private static int f255237c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73441);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f255235a = null;
        f255236b = -1;
        f255237c = -1;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("http://hb.url.cn/myapp/qq_desk/")) {
            return str.substring(31);
        }
        if (str.startsWith("http://")) {
            return str.substring(7);
        }
        return str;
    }

    public static long b(String str) {
        long j3;
        if (f255235a == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            f255235a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        }
        try {
            j3 = f255235a.parse(str).getTime();
        } catch (ParseException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("OlympicUtil", 2, "", e16);
            }
            j3 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OlympicUtil", 2, "data2Millis, date = " + str + ",millionSeconds = " + j3);
        }
        return j3;
    }

    public static boolean c() {
        return BaseApplication.getContext().getSharedPreferences("olympic", 0).getBoolean("dpc_ar_entrance", true);
    }

    public static byte[] d(byte[] bArr) {
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

    public static void e(String str, Object... objArr) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, objArr);
        }
    }

    public static void f(AppInterface appInterface, String str, int i3) {
        g(appInterface, str, i3, "");
    }

    public static void g(AppInterface appInterface, String str, int i3, String str2) {
        g.a(appInterface, "CliOper", "", str2, str, str, 0, 0, "" + i3, "", "", "");
    }

    public static Bitmap h(Bitmap bitmap, float f16) {
        if (bitmap != null && f16 != 1.0f && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            Matrix matrix = new Matrix();
            matrix.postScale(f16, f16);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("OlympicUtil", 2, "scaleBitmap,", e16);
                    return bitmap;
                }
                return bitmap;
            }
        }
        return bitmap;
    }

    public static void i(boolean z16) {
        BaseApplication.getContext().getSharedPreferences("olympic", 0).edit().putBoolean("dpc_ar_entrance", z16).commit();
    }
}
