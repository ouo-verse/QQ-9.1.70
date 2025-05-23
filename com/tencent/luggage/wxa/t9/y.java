package com.tencent.luggage.wxa.t9;

import android.os.SystemProperties;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static Class f141189a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f141190b;

    /* renamed from: c, reason: collision with root package name */
    public static Method f141191c;

    static {
        try {
            f141189a = SystemProperties.class;
            f141190b = SystemProperties.class.getDeclaredMethod("get", String.class);
            f141191c = f141189a.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            f141190b.setAccessible(true);
            f141191c.setAccessible(true);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.SystemProperties", e16, "", new Object[0]);
        }
    }

    public static int a(String str, int i3) {
        try {
            return ((Integer) f141191c.invoke(null, str, Integer.valueOf(i3))).intValue();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.SystemProperties", e16, "", new Object[0]);
            return i3;
        }
    }

    public static String a(String str) {
        try {
            return (String) f141190b.invoke(null, str);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.SystemProperties", e16, "", new Object[0]);
            return null;
        }
    }
}
