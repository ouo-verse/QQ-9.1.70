package com.tencent.luggage.wxa.ar;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static String f121630a;

    /* renamed from: b, reason: collision with root package name */
    public static String f121631b;

    /* renamed from: c, reason: collision with root package name */
    public static String f121632c;

    public static String a() {
        if (TextUtils.isEmpty(f121630a)) {
            f121630a = Build.BRAND;
        }
        return f121630a;
    }

    public static String b() {
        if (TextUtils.isEmpty(f121632c)) {
            f121632c = Build.MANUFACTURER;
        }
        return f121632c;
    }

    public static String c() {
        if (TextUtils.isEmpty(f121631b)) {
            String initConfig = XWalkEnvironment.getInitConfig("deviceModel", (String) null);
            if (initConfig != null) {
                f121631b = initConfig;
                x0.d("CachedSystemBuildInfo", "device model from init args:" + f121631b);
            } else {
                f121631b = DeviceInfoMonitor.getModel();
                x0.f("CachedSystemBuildInfo", "device model, not available in init args, use Build.MODEL:" + f121631b);
            }
        }
        return f121631b;
    }
}
