package com.tencent.intervideo.nowproxy.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NetworkUtil {
    static IPatchRedirector $redirector_;

    public NetworkUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return 30;
        }
        if (!activeNetworkInfo.isAvailable()) {
            return 31;
        }
        return NetworkMonitor.getType(activeNetworkInfo);
    }

    public static boolean hasProxy() {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(property) && !TextUtils.isEmpty(property2)) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }
}
