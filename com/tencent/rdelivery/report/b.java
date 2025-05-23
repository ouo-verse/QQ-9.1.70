package com.tencent.rdelivery.report;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import java.lang.reflect.Constructor;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f364373a = false;

    public static void a(Context context) {
        String str;
        Object invoke;
        try {
            try {
                str = UserAction.getSDKVersion();
            } catch (Exception e16) {
                e16.printStackTrace();
                try {
                    String message = e16.getMessage();
                    String substring = message.substring(message.indexOf("com"), message.indexOf("("));
                    String substring2 = substring.substring(0, substring.lastIndexOf(46));
                    String substring3 = substring.substring(substring.lastIndexOf(46) + 1);
                    Class<?> cls = Class.forName(substring2);
                    try {
                        Constructor<?> constructor = cls.getConstructor(Context.class);
                        constructor.setAccessible(true);
                        invoke = constructor.newInstance(context);
                    } catch (Exception unused) {
                        invoke = cls.getDeclaredMethod("a", Context.class).invoke(null, context);
                    }
                    str = (String) cls.getMethod(substring3, new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception e17) {
                    e17.printStackTrace();
                    str = null;
                }
            }
            if (c(str, "3.1.2")) {
                f364373a = true;
                UserAction.registerTunnel(new TunnelInfo("0AND0SOBHI4GADI0", "", ""));
            }
        } catch (ClassNotFoundException e18) {
            e18.printStackTrace();
        }
    }

    public static void b(String str, Map<String, String> map, boolean z16, boolean z17) {
        if (!f364373a) {
            return;
        }
        ReportMethodProxy.onUserActionToTunnel("0AND0SOBHI4GADI0", str, map, z16, z17);
    }

    private static boolean c(String str, String str2) {
        if (str.compareTo(str2) >= 0) {
            return true;
        }
        return false;
    }
}
