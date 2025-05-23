package com.tencent.luggage.wxa.oh;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static int f136525a = -1;

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        if (length <= 1 || str.charAt(0) != '\"') {
            return str;
        }
        int i3 = length - 1;
        return str.charAt(i3) == '\"' ? str.substring(1, i3) : str;
    }

    public static int a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            return 2;
        }
        if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
            return 3;
        }
        return wifiConfiguration.wepKeys[0] != null ? 1 : 0;
    }

    public static int a(ScanResult scanResult) {
        String str;
        if (scanResult == null || (str = scanResult.capabilities) == null) {
            return -1;
        }
        if (str.contains("WEP")) {
            return 1;
        }
        if (scanResult.capabilities.contains("PSK")) {
            return 2;
        }
        return scanResult.capabilities.contains("EAP") ? 3 : 0;
    }
}
