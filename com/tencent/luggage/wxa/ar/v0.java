package com.tencent.luggage.wxa.ar;

import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class v0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f121787a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static int f121788b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f121789c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static String f121790d = "";

    public static int a() {
        if (f121787a <= 0) {
            int i3 = y0.s().getInt("sNDeviceRd", -1);
            f121787a = i3;
            if (i3 <= 0) {
                f121787a = new Random().nextInt(10000000) + 1;
                y0.s().edit().putInt("sNDeviceRd", f121787a).commit();
            }
        }
        return (f121787a % 10000) + 1;
    }

    public static void b(int i3) {
        if (i3 != 10001) {
            f121788b = i3 % 10000;
        }
        x0.d("XWebGrayValueUtil", "setGrayValueForTest, gray value:" + f121788b);
        y0.r().edit().putInt("TEST_GRAY_VALUE", f121788b).commit();
    }

    public static int c() {
        return y0.r().getInt("TEST_GRAY_VALUE", -1);
    }

    public static int d() {
        byte[] digest;
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
        if (f121789c != 0 && format.equals(f121790d)) {
            return f121789c;
        }
        f121790d = format;
        int e16 = e();
        if (e16 == 0) {
            e16 = b();
        }
        try {
            digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(((e16 & 4294967295L) + "@" + format).getBytes());
        } catch (Throwable th5) {
            x0.a("XWebGrayValueUtil", "getTodayGrayValue error", th5);
            f121789c = e16;
        }
        if (digest != null && digest.length > 3) {
            int i3 = ((digest[0] & Byte.MAX_VALUE) << 24) | (digest[3] & 255) | ((digest[2] & 255) << 8) | ((digest[1] & 255) << 16);
            if (i3 == 0) {
                f121789c = e16;
                return e16;
            }
            f121789c = (i3 % 10000) + 1;
            return f121789c;
        }
        f121789c = e16;
        return e16;
    }

    public static int e() {
        return y0.j().getInt(CommonConstant.RETKEY.USERID, 0);
    }

    public static boolean f() {
        if (e() != 0) {
            return true;
        }
        return false;
    }

    public static void g() {
        int i3 = f121788b;
        if (i3 != 0 && i3 != -1) {
            x0.d("XWebGrayValueUtil", "resetGrayValue, gray value not changed:" + f121788b);
            return;
        }
        f121788b = 0;
        f121788b = b();
        x0.d("XWebGrayValueUtil", "resetGrayValue, gray value:" + f121788b);
    }

    public static void c(int i3) {
        y0.j().edit().putInt(CommonConstant.RETKEY.USERID, i3).commit();
    }

    public static int b() {
        int i3;
        int i16 = f121788b;
        if (i16 != 0) {
            return i16;
        }
        try {
            i3 = y0.r().getInt("TEST_GRAY_VALUE", -1);
            f121788b = i3;
        } catch (Throwable th5) {
            x0.a("XWebGrayValueUtil", "getGrayValue error", th5);
            f121788b = 0;
        }
        if (i3 > 0) {
            x0.d("XWebGrayValueUtil", "getGrayValue, using test gray value:" + f121788b);
            return f121788b;
        }
        int i17 = y0.s().getInt("GRAY_VALUE", -1);
        f121788b = i17;
        if (i17 > 0) {
            x0.d("XWebGrayValueUtil", "getGrayValue, using uin gray value:" + f121788b);
            return f121788b;
        }
        int a16 = a();
        f121788b = a16;
        if (a16 > 0) {
            x0.d("XWebGrayValueUtil", "getGrayValue, using device gray value:" + f121788b);
            return f121788b;
        }
        return f121788b;
    }

    public static boolean a(int i3) {
        byte[] digest;
        if (i3 == 0) {
            return false;
        }
        c(i3);
        try {
            digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(("xweb_gray_value" + (i3 & 4294967295L)).getBytes());
        } catch (Throwable th5) {
            f121788b = 0;
            x0.a("XWebGrayValueUtil", "setGrayValueByUserId, gray value reset to 0, error", th5);
        }
        if (digest != null && digest.length > 3) {
            int i16 = ((digest[0] & Byte.MAX_VALUE) << 24) | (digest[3] & 255) | ((digest[2] & 255) << 8) | ((digest[1] & 255) << 16);
            if (i16 == 0) {
                return false;
            }
            f121788b = (i16 % 10000) + 1;
            int i17 = y0.s().getInt("GRAY_VALUE", -1);
            y0.s().edit().putInt("GRAY_VALUE", f121788b).commit();
            if (i17 == f121788b) {
                return false;
            }
            x0.d("XWebGrayValueUtil", "setGrayValueByUserId, gray value changed from " + i17 + " to " + f121788b);
            n0.a(1749L, 29L, 1L);
            return true;
        }
        return false;
    }

    public static int a(String str) {
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
        int e16 = e();
        if (e16 == 0) {
            e16 = b();
        }
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(((e16 & 4294967295L) + "@" + format + "key=" + str).getBytes());
            if (digest != null && digest.length > 3) {
                int i3 = ((digest[0] & Byte.MAX_VALUE) << 24) | (digest[3] & 255) | ((digest[2] & 255) << 8) | ((digest[1] & 255) << 16);
                if (i3 == 0) {
                    return f121789c;
                }
                return (i3 % 10000) + 1;
            }
            return f121789c;
        } catch (Throwable th5) {
            x0.a("XWebGrayValueUtil", "getTodayGrayValueByKey error", th5);
            return f121789c;
        }
    }
}
