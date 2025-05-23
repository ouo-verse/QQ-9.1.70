package com.tencent.mobileqq.msf.sdk;

import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static String f250534a = "MSF.D.AppNetSubscriptionManager";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22448);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Object a(TelephonyManager telephonyManager) {
        try {
            Field declaredField = TelephonyManager.class.getDeclaredField("mSubscriptionManager");
            declaredField.setAccessible(true);
            return declaredField.get(telephonyManager);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(f250534a, 2, "getSubscriptionManager excep!", e16);
            } else {
                QLog.w(f250534a, 2, "getSubscriptionManager excep!");
            }
            return null;
        }
    }

    public static int a(Object obj) {
        int intValue;
        if (obj == null) {
            return -1;
        }
        try {
            try {
                Method declaredMethod = obj.getClass().getDeclaredMethod("getDefaultDataSubId", new Class[0]);
                declaredMethod.setAccessible(true);
                intValue = ((Integer) declaredMethod.invoke(obj, new Object[0])).intValue();
            } catch (NoSuchMethodException unused) {
                Method declaredMethod2 = obj.getClass().getDeclaredMethod("getDefaultDataSubscriptionId", new Class[0]);
                declaredMethod2.setAccessible(true);
                intValue = ((Integer) declaredMethod2.invoke(obj, new Object[0])).intValue();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(f250534a, 2, "getDefaultDataSubId excep!", e16);
                    return -1;
                }
                QLog.w(f250534a, 2, "getDefaultDataSubId excep!");
                return -1;
            }
            return intValue;
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.w(f250534a, 2, "getDefaultDataSubscriptionId excep!", e17);
                return -1;
            }
            QLog.w(f250534a, 2, "getDefaultDataSubscriptionId excep!");
            return -1;
        }
    }

    public static int a(TelephonyManager telephonyManager, NetworkInfo networkInfo) {
        TelephonyManager createForSubscriptionId;
        int networkType;
        long currentTimeMillis = System.currentTimeMillis();
        int a16 = a(a(telephonyManager));
        if (networkInfo != null) {
            networkType = NetworkMonitor.getSubtype(networkInfo);
        } else {
            if (a16 != -1) {
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        createForSubscriptionId = telephonyManager.createForSubscriptionId(a16);
                        networkType = NetworkMonitor.getNetworkType(createForSubscriptionId);
                    }
                } catch (Exception e16) {
                    QLog.e(f250534a, 1, "getNetworkType excep!", e16);
                    networkType = 0;
                }
            }
            networkType = NetworkMonitor.getNetworkType(telephonyManager);
        }
        int c16 = m.c(networkType);
        if (QLog.isColorLevel()) {
            QLog.d(f250534a, 2, "getNetworkType:" + c16 + " ,simID:" + a16 + " ,cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return c16;
    }

    public static int a(TelephonyManager telephonyManager, int i3) {
        try {
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getNetworkClass", Integer.TYPE);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(telephonyManager, Integer.valueOf(i3))).intValue();
        } catch (Exception e16) {
            QLog.e(f250534a, 1, "getSystemNetworkClass excep!", e16);
            return 1;
        }
    }
}
