package com.tencent.luggage.wxa.p003do;

import android.os.Build;
import android.os.Environment;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.io.InputStream;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f124405a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f124406b;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
    
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0045, code lost:
    
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a() {
        if (f124405a == null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = x.a(new v(Environment.getRootDirectory(), "build.prop"));
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    f124405a = Boolean.valueOf(properties.containsKey("ro.miui.ui.version.name"));
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th5;
                }
            } catch (Exception e16) {
                w.b("Vendor.MIUI", "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e16);
                f124405a = Boolean.FALSE;
            }
        }
        return f124405a.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
    
        if (r4 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0068, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        if (r4 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 24) {
            f124406b = Boolean.FALSE;
            return false;
        }
        if (f124406b == null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = x.a(new v(Environment.getRootDirectory(), "build.prop"));
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    w.b("Vendor.MIUI", "ro.miui.ui.version.name %s", properties.getProperty("ro.miui.ui.version.name", ""));
                    f124406b = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                } catch (Exception e16) {
                    w.b("Vendor.MIUI", "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e16);
                    f124406b = Boolean.FALSE;
                }
            } catch (Throwable th5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
                throw th5;
            }
        }
        return f124406b.booleanValue();
    }

    public static boolean c() {
        String str = Build.BRAND;
        if (!w0.c(str) && str.toLowerCase().contains("xiaomi")) {
            return true;
        }
        return false;
    }
}
