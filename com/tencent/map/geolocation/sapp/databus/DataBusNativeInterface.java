package com.tencent.map.geolocation.sapp.databus;

import android.content.Context;
import c.t.m.sapp.c.e;
import c.t.m.sapp.c.f;
import c.t.m.sapp.c.i;
import dalvik.system.DexClassLoader;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DataBusNativeInterface {
    private static final String TAG = "DataBusNInt";
    private static boolean isInited = false;
    private static Class mProxyClass;

    private static void doInit(Context context) throws ClassNotFoundException {
        DexClassLoader a16 = f.a(context).a();
        if (a16 == null) {
            i.a("LMI,DataBus 41");
            e.b().a("LMI", "DataBus 41");
        } else {
            mProxyClass = a16.loadClass("com.tencent.map.geolocation.sapp.proxy.DataBusProxy");
            i.a("LMI,DataBus 0");
            e.b().a("LMI", "DataBus 0");
            isInited = true;
        }
    }

    public static String getCommValueByJni(int i3, String str, String str2) {
        Class cls;
        if (isInited && (cls = mProxyClass) != null) {
            try {
                return (String) cls.getDeclaredMethod("getCommValueByJni", Integer.TYPE, String.class, String.class).invoke(null, Integer.valueOf(i3), str, str2);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static void init(Context context) {
        try {
            doInit(context);
        } catch (Throwable unused) {
        }
    }

    public static void logCallbackFromJni(int i3, String str, String str2) {
        Class cls;
        if (isInited && (cls = mProxyClass) != null) {
            try {
                cls.getDeclaredMethod("logCallbackFromJni", Integer.TYPE, String.class, String.class).invoke(null, Integer.valueOf(i3), str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public static void notifyListenersByJni(int i3, byte[] bArr) {
        Class cls;
        if (isInited && (cls = mProxyClass) != null) {
            try {
                cls.getDeclaredMethod("notifyListenersByJni", Integer.TYPE, byte[].class).invoke(null, Integer.valueOf(i3), bArr);
            } catch (Exception unused) {
            }
        }
    }
}
