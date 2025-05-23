package hynb.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import hynb.p.g;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f406879a;

    /* renamed from: b, reason: collision with root package name */
    public static String f406880b;

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, String> f406881c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static String f406882d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f406883e = null;

    public static String a(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        if (bArr != null) {
            for (byte b16 : bArr) {
                sb5.append(Integer.toString((b16 & 255) + 256, 16).substring(1));
            }
        }
        return sb5.toString();
    }

    public static String b(String str) {
        return a(MessageDigest.getInstance("md5").digest(a(str)));
    }

    public static String c() {
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(1);
        int i16 = calendar.get(2) + 1;
        int i17 = calendar.get(5);
        int i18 = calendar.get(11);
        int i19 = calendar.get(12);
        int i26 = calendar.get(13);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        if (i16 < 10) {
            sb5.append(0);
            sb5.append(i16);
        } else {
            sb5.append(i16);
        }
        if (i17 < 10) {
            sb5.append(0);
            sb5.append(i17);
        } else {
            sb5.append(i17);
        }
        if (i18 < 10) {
            sb5.append(0);
            sb5.append(i18);
        } else {
            sb5.append(i18);
        }
        if (i19 < 10) {
            sb5.append(0);
            sb5.append(i19);
        } else {
            sb5.append(i19);
        }
        if (i26 < 10) {
            sb5.append(0);
            sb5.append(i26);
        } else {
            sb5.append(i26);
        }
        return sb5.toString();
    }

    public static String d() {
        String str = f406882d;
        if (str != null) {
            return str;
        }
        Locale locale = Locale.getDefault();
        String str2 = locale.getLanguage() + "-" + locale.getCountry();
        f406882d = str2;
        return str2;
    }

    public static String e() {
        String str = f406883e;
        if (str != null) {
            return str;
        }
        String str2 = "Android" + Build.VERSION.RELEASE;
        f406883e = str2;
        return str2;
    }

    public static String f() {
        if (TextUtils.isEmpty(f406879a)) {
            f406879a = hynb.m.a.c();
        }
        return f406879a;
    }

    public static String g() {
        if (TextUtils.isEmpty(f406880b)) {
            f406880b = hynb.m.a.b();
        }
        return f406880b;
    }

    public static Map<String, String> b() {
        f406881c.put("User-Agent", "Android-privacy");
        return f406881c;
    }

    public static byte[] a(UUID uuid) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        return wrap.array();
    }

    public static String a() {
        try {
            return a(MessageDigest.getInstance("md5").digest(UUID.randomUUID().toString().getBytes("UTF-8")));
        } catch (Exception unused) {
            return null;
        }
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("statistics_huya", 0);
    }

    public static byte[] a(String str) {
        return str.getBytes("UTF-8");
    }

    public static String a(int i3) {
        String str = null;
        try {
            str = b("ABCDEFGHIJKLMNOP&" + i3).substring(0, 16).toLowerCase(Locale.ENGLISH);
            g.f406799a.b("getEncryptKeyWithSubCode result key:" + str);
            return str;
        } catch (Exception e16) {
            g.f406799a.a("getEncryptKeyWithSubCode error:" + e16.getMessage());
            return str;
        }
    }
}
