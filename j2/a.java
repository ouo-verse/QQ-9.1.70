package j2;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.honorid.core.data.HonorAccount;
import h45.h;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    public static String a() {
        return b("yyyyMMddHHmmssSSS");
    }

    public static String b(String str) {
        return new SimpleDateFormat(str, Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
    }

    public static String c(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : bArr) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() == 1) {
                    sb5.append('0');
                }
                sb5.append(hexString);
            }
            return sb5.toString();
        }
        return "";
    }

    public static boolean d(HonorAccount honorAccount) {
        if (honorAccount == null) {
            return false;
        }
        if (!TextUtils.isEmpty(honorAccount.l())) {
            return true;
        }
        if (!TextUtils.isEmpty(honorAccount.p()) && !TextUtils.isEmpty(honorAccount.M0()) && !TextUtils.isEmpty(honorAccount.D0()) && !TextUtils.isEmpty(honorAccount.A0())) {
            return true;
        }
        e.c("BaseUtil", "addHonorAccount is invalid", true);
        return false;
    }

    public static byte[] e(String str) {
        if (TextUtils.isEmpty(str)) {
            e.b("BaseUtil", "getUTF8Bytes, str is empty", true);
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            e.b("BaseUtil", "getBytes error", true);
            return new byte[0];
        }
    }

    public static String f(Context context) {
        String a16 = h.a(context, 0);
        if (!TextUtils.isEmpty(a16) && !"NULL".equals(a16)) {
            return i2.e.c(a16 + a());
        }
        e.c("BaseUtil", "TransID get imei is null", true);
        return null;
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (byte b16 : str.getBytes("UTF-8")) {
                int i3 = b16 & 255;
                if (i3 > 31 && i3 < 127) {
                }
                e.c("BaseUtil", "byte not printable", true);
                return false;
            }
        } catch (UnsupportedEncodingException unused) {
            e.c("BaseUtil", "UnsupportedEncodingException", true);
        }
        return true;
    }

    public static String h(Context context) {
        if (context != null) {
            return context.getPackageName();
        }
        return "";
    }

    public static boolean i(Context context) {
        return context.getPackageName().equals(h45.e.a(context).b());
    }
}
