package com.tencent.biz.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g {
    public static int a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    int type = NetworkMonitor.getType(activeNetworkInfo);
                    if (QLog.isColorLevel()) {
                        QLog.d(NetworkUtil.TAG, 2, "getNetworkType type = ", Integer.valueOf(type));
                    }
                    if (type != 0) {
                        if (type == 1) {
                            return 1;
                        }
                        return -1;
                    }
                    int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return 3;
                        case 13:
                        case 18:
                        case 19:
                            return 4;
                        default:
                            if (QLog.isColorLevel()) {
                                QLog.d(NetworkUtil.TAG, 2, "getNetworkType subType = ", Integer.valueOf(subtype));
                            }
                            return -1;
                    }
                }
                if (activeNetworkInfo == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(NetworkUtil.TAG, 2, "getNetworkType networkInfo = null");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(NetworkUtil.TAG, 2, "getNetworkType networkInfo isConnected =", Boolean.valueOf(activeNetworkInfo.isConnected()));
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(NetworkUtil.TAG, 2, "getNetworkType could not get ConnectivityManager");
            }
        } catch (IllegalStateException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(NetworkUtil.TAG, 2, "getNetworkType IllegalStateException", e16);
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d(NetworkUtil.TAG, 2, "getNetworkType exception", e17);
            }
        }
        return 0;
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d(NetworkUtil.TAG, 2, "isNetworkAvailable exception", e16);
        }
        return false;
    }

    public static String c(String str, int i3) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                String host = new URL(str).getHost();
                String reqDns = InnerDns.getInstance().reqDns(host, i3);
                if (!TextUtils.isEmpty(reqDns)) {
                    if (!reqDns.contains(":")) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(reqDns);
                        if (str.startsWith("https")) {
                            str2 = ":443";
                        } else {
                            str2 = ":80";
                        }
                        sb5.append(str2);
                        reqDns = sb5.toString();
                    }
                    return str.replaceFirst(host, reqDns);
                }
                return str;
            } catch (MalformedURLException e16) {
                QLog.e(NetworkUtil.TAG, 1, "MalformedURLException", e16);
                return str;
            }
        }
        return str;
    }
}
