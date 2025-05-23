package com.tencent.treasurecard.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.TreasureCardJsPlugin;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f381233a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13086);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381233a = "";
        }
    }

    @RequiresApi(api = 22)
    private static int a(Context context) {
        int defaultDataSubscriptionId;
        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
        if (Build.VERSION.SDK_INT > 24) {
            defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
            return defaultDataSubscriptionId;
        }
        try {
            return ((Integer) SubscriptionManager.class.getClass().getDeclaredMethod("getDefaultDataSubId", new Class[0]).invoke(subscriptionManager, new Object[0])).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static int b() {
        String simOperator;
        TelephonyManager telephonyManager = (TelephonyManager) ((com.tencent.treasurecard.manager.d) com.tencent.treasurecard.manager.d.i()).g().getSystemService("phone");
        if (telephonyManager == null || telephonyManager.getSimState() == 1 || (simOperator = DeviceInfoMonitor.getSimOperator(telephonyManager)) == null) {
            return 0;
        }
        if (simOperator.startsWith("46000") || simOperator.startsWith("46002") || simOperator.startsWith("46007") || simOperator.startsWith("46008")) {
            return 1;
        }
        if (!simOperator.startsWith("46001") && !simOperator.startsWith("46006") && !simOperator.startsWith("46009")) {
            if (!simOperator.startsWith("46003") && !simOperator.startsWith("46005") && !simOperator.startsWith("46011")) {
                return 0;
            }
            return 3;
        }
        return 2;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                return connectivityManager.getNetworkInfo(1).isConnected();
            } catch (Exception e16) {
                Log.e(TreasureCardJsPlugin.BUSINESS_NAME, "isWifiActive exception: " + e16.getMessage());
            }
        }
        return false;
    }

    public static void d() {
        f381233a = "" + a(((com.tencent.treasurecard.manager.d) com.tencent.treasurecard.manager.d.i()).g());
        Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "updateSimIccId SIM_ICC_ID: " + f381233a);
    }
}
