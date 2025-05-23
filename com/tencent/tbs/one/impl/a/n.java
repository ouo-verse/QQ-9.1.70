package com.tencent.tbs.one.impl.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f374592a;

    /* renamed from: b, reason: collision with root package name */
    private static SharedPreferences.Editor f374593b;

    private static String a() {
        return Build.FINGERPRINT + new Random().nextInt(2147483646);
    }

    public static String b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("tsui", 0);
        f374592a = sharedPreferences;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("tsui", "");
            if (!TextUtils.isEmpty(string)) {
                g.a("getSDKUID from sp is " + string, new Object[0]);
                return string;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        String a16 = a();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(System.currentTimeMillis());
        String sb7 = sb6.toString();
        String g16 = g(context);
        if (a16 != null && a16.length() > 0) {
            sb5.append(a16);
            sb5.append("|");
        }
        if (sb7 != null && sb7.length() > 0) {
            sb5.append(sb7);
            sb5.append("|");
        }
        if (g16 != null && g16.length() > 0) {
            sb5.append(g16);
            sb5.append("|");
        }
        String replace = f(context).replace("-", "");
        if (replace != null && replace.length() > 0) {
            sb5.append(replace);
        }
        if (sb5.length() > 0) {
            try {
                String c16 = c(e(sb5.toString()));
                if (c16 != null && c16.length() > 0) {
                    g.a("getSDKUID sha1 is " + c16, new Object[0]);
                    d(context, "tsui", c16);
                    return c16;
                }
            } catch (Exception e16) {
                Log.getStackTraceString(e16);
            }
        }
        String replace2 = UUID.randomUUID().toString().replace("-", "");
        g.a("getSDKUID default is " + replace2, new Object[0]);
        d(context, "tsui", replace2);
        return replace2;
    }

    private static String c(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                sb5.append("0");
            }
            sb5.append(hexString);
        }
        return sb5.toString().toUpperCase(Locale.CHINA);
    }

    private static void d(Context context, String str, String str2) {
        if (f374592a == null) {
            f374592a = context.getApplicationContext().getSharedPreferences("tsui", 0);
        }
        SharedPreferences.Editor edit = f374592a.edit();
        f374593b = edit;
        edit.putString(str, str2);
        f374593b.commit();
    }

    private static byte[] e(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return messageDigest.digest();
        } catch (Exception unused) {
            return "".getBytes();
        }
    }

    private static String f(Context context) {
        try {
            String b16 = e.b(context);
            int nextInt = new Random().nextInt(2147483646);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(nextInt);
            sb5.append(Build.BOARD.length() % 10);
            sb5.append(Build.BRAND.length() % 10);
            sb5.append(Build.DEVICE.length() % 10);
            sb5.append(Build.HARDWARE.length() % 10);
            sb5.append(Build.ID.length() % 10);
            sb5.append(b16.length() % 10);
            sb5.append(Build.PRODUCT.length() % 10);
            sb5.append(g(context).length() % 10);
            return new UUID(sb5.toString().hashCode(), g(context).hashCode()).toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private static String g(Context context) {
        try {
            String string = context.getSharedPreferences("uifa", 0).getString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, "");
            if (!TextUtils.isEmpty(string) && !string.contains("unknown")) {
                return string;
            }
            return a();
        } catch (Exception unused) {
            return "unknown";
        }
    }
}
