package com.tencent.luggage.wxa.p003do;

import android.content.Context;
import com.tencent.luggage.wxa.tn.w;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            try {
                try {
                    try {
                        Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                        boolean booleanValue = ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
                        w.a("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.valueOf(booleanValue));
                        return booleanValue;
                    } catch (IllegalAccessException unused) {
                        w.b("MicroMsg.Vendor.Vivo", "hasCutOut, IllegalAccessException!!");
                        w.a("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
                        return false;
                    } catch (InvocationTargetException unused2) {
                        w.b("MicroMsg.Vendor.Vivo", "hasCutOut, InvocationTargetException!!");
                        w.a("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
                        return false;
                    }
                } catch (NoSuchMethodException unused3) {
                    w.b("MicroMsg.Vendor.Vivo", "hasCutOut, NoSuchMethodException!!");
                    w.a("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
                    return false;
                }
            } catch (ClassNotFoundException unused4) {
                w.b("MicroMsg.Vendor.Vivo", "hasCutOut, ClassNotFoundException!!");
                w.a("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
                return false;
            }
        } catch (Throwable unused5) {
            w.a("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            return false;
        }
    }
}
