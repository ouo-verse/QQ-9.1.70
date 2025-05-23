package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsPrivacyAccess;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes25.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f369763a;

    /* renamed from: b, reason: collision with root package name */
    private static SharedPreferences.Editor f369764b;

    public static String a(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("tsui", 0);
        f369763a = sharedPreferences;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("tsui", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        String a16 = a();
        String androidID = AppUtil.getAndroidID(context);
        String c16 = c(context);
        String replace = b(context).replace("-", "");
        if (a16 != null && a16.length() > 0) {
            sb5.append(a16);
            sb5.append("|");
        }
        if (androidID != null && androidID.length() > 0) {
            sb5.append(androidID);
            sb5.append("|");
        }
        if (c16 != null && c16.length() > 0) {
            sb5.append(c16);
            sb5.append("|");
        }
        if (replace != null && replace.length() > 0) {
            sb5.append(replace);
        }
        if (sb5.length() > 0) {
            String a17 = a(sb5.toString());
            if (!TextUtils.isEmpty(a17)) {
                a(context, "tsui", a17);
                return a17;
            }
        }
        String replace2 = UUID.randomUUID().toString().replace("-", "");
        a(context, "tsui", replace2);
        return replace2;
    }

    private static byte[] b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return messageDigest.digest();
        } catch (Exception unused) {
            return "".getBytes();
        }
    }

    private static String c(Context context) {
        try {
            String configurePrivacy = TbsPrivacyAccess.getConfigurePrivacy(context, TbsPrivacyAccess.ConfigurablePrivacy.SERIAL, "");
            if (!TextUtils.isEmpty(configurePrivacy) && !configurePrivacy.contains("unknown")) {
                return configurePrivacy;
            }
            return a();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    private static String b(Context context) {
        try {
            String a16 = r.a(context);
            int nextInt = new Random().nextInt(2147483646);
            return new UUID(("" + nextInt + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.DEVICE.length() % 10) + (Build.HARDWARE.length() % 10) + (Build.ID.length() % 10) + (a16.length() % 10) + (Build.PRODUCT.length() % 10) + (c(context).length() % 10)).hashCode(), c(context).hashCode()).toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String a(String str) {
        try {
            String a16 = a(b(str));
            return a16.length() > 0 ? a16 : "";
        } catch (Exception e16) {
            TbsLog.w("SDKUID", "encrypt sdkuid failed, origin is " + str + "reason: " + e16);
            return "";
        }
    }

    private static void a(Context context, String str, String str2) {
        if (f369763a == null) {
            f369763a = context.getApplicationContext().getSharedPreferences("tsui", 0);
        }
        SharedPreferences.Editor edit = f369763a.edit();
        f369764b = edit;
        edit.putString(str, str2);
        f369764b.commit();
    }

    private static String a(byte[] bArr) {
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

    private static String a() {
        return Build.FINGERPRINT + new Random().nextInt(2147483646);
    }
}
