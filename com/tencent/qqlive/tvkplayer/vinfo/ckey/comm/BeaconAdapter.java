package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BeaconAdapter {
    public static String getBeacon3Qimei16(Context context) {
        if (context != null) {
            try {
                return (String) context.getClassLoader().loadClass("com.tencent.beacon.event.UserAction").getMethod("getQIMEI", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String getBeacon41Qimei16(Context context) {
        if (context != null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.tencent.beacon.event.open.BeaconReport");
                return (String) context.getClassLoader().loadClass("com.tencent.beacon.qimei.Qimei").getMethod("getQimeiOld", new Class[0]).invoke(loadClass.getMethod("getQimei", new Class[0]).invoke(loadClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]), new Object[0]);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String getBeacon41Qimei36(Context context) {
        if (context != null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.tencent.beacon.event.open.BeaconReport");
                return (String) context.getClassLoader().loadClass("com.tencent.beacon.qimei.Qimei").getMethod("getQimeiNew", new Class[0]).invoke(loadClass.getMethod("getQimei", new Class[0]).invoke(loadClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]), new Object[0]);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String getBeacon42Qimei16(Context context, String str) {
        if (context != null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.tencent.beacon.event.open.BeaconReport");
                return (String) context.getClassLoader().loadClass("com.tencent.qimei.sdk.Qimei").getMethod("getQimei16", new Class[0]).invoke(loadClass.getMethod("getQimei", String.class).invoke(loadClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str), new Object[0]);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String getBeacon42Qimei36(Context context, String str) {
        if (context != null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.tencent.beacon.event.open.BeaconReport");
                return (String) context.getClassLoader().loadClass("com.tencent.qimei.sdk.Qimei").getMethod("getQimei36", new Class[0]).invoke(loadClass.getMethod("getQimei", String.class).invoke(loadClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str), new Object[0]);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static void onUserActionToTunnel(Context context, String str, String str2, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18) {
        if (context == null) {
            return;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.tencent.beacon.event.UserAction");
            Class<?> cls = Boolean.TYPE;
            Class<?> cls2 = Long.TYPE;
            loadClass.getMethod("onUserActionToTunnel", String.class, String.class, cls, cls2, cls2, Map.class, cls, cls).invoke(null, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), map, Boolean.valueOf(z17), Boolean.valueOf(z18));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void registerTunnel(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.tencent.beacon.upload.TunnelInfo");
            context.getClassLoader().loadClass("com.tencent.beacon.event.UserAction").getMethod("registerTunnel", loadClass).invoke(null, loadClass.getConstructor(String.class, String.class, String.class).newInstance(str, str2, str3));
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
        } catch (InstantiationException e18) {
            e18.printStackTrace();
        } catch (NoSuchMethodException e19) {
            e19.printStackTrace();
        } catch (InvocationTargetException e26) {
            e26.printStackTrace();
        }
    }
}
