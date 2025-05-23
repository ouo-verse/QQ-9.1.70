package com.vivo.push.util;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class n {

    /* renamed from: f, reason: collision with root package name */
    private static Method f387917f;

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f387912a = ag.b("ro.vivo.product.overseas", "no").equals("yes");

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f387913b = b("rom_1.0");

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f387914c = b("rom_2.0");

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f387915d = b("rom_2.5");

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f387916e = b("rom_3.0");

    /* renamed from: g, reason: collision with root package name */
    private static String f387918g = null;

    /* renamed from: h, reason: collision with root package name */
    private static String f387919h = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) SystemProperties.class.getMethod("get", String.class).invoke(null, str);
        } catch (Exception e16) {
            e16.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static boolean b(String str) {
        String b16 = ag.b("ro.vivo.rom", "");
        String b17 = ag.b("ro.vivo.rom.version", "");
        u.d("Device", "ro.vivo.rom = " + b16 + " ; ro.vivo.rom.version = " + b17);
        if (b16 == null || !b16.contains(str)) {
            return b17 != null && b17.contains(str);
        }
        return true;
    }

    public static synchronized String a() {
        synchronized (n.class) {
            if (f387918g == null && f387919h == null) {
                try {
                    Method declaredMethod = SystemProperties.class.getDeclaredMethod("get", String.class, String.class);
                    f387917f = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f387918g = (String) f387917f.invoke(null, "ro.vivo.rom", "@><@");
                    f387919h = (String) f387917f.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    u.b("Device", "getRomCode error");
                }
            }
            u.d("Device", "sRomProperty1 : " + f387918g + " ; sRomProperty2 : " + f387919h);
            String a16 = a(f387918g);
            if (!TextUtils.isEmpty(a16)) {
                return a16;
            }
            String a17 = a(f387919h);
            if (TextUtils.isEmpty(a17)) {
                return null;
            }
            return a17;
        }
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            u.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        u.d("Device", "Build.MANUFACTURER is " + str);
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(matcher.group(1));
        sb5.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        return sb5.toString();
    }
}
