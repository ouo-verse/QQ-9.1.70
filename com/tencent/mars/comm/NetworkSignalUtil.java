package com.tencent.mars.comm;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.luggage.wxa.tn.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetworkSignalUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "MicroMsg.NetworkSignalUtil";
    private static final int WIFI_STRENGTH_MAX_LEVEL = 10;

    public NetworkSignalUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Deprecated
    public static void InitNetworkSignalUtil(Context context) {
        j.f141599a.h();
    }

    private static long calWifiStrengthInNum(int i3) {
        w.e(TAG, "Wifi Signal:" + WifiManager.calculateSignalLevel(i3, 10));
        return Math.max(Math.min(r3, 10), 0) * 10;
    }

    public static long getGSMSignalStrength() {
        int a16;
        j.c d16 = j.f141599a.d();
        if (d16.d()) {
            a16 = d16.b();
        } else {
            a16 = (d16.a() + 113) / 2;
        }
        if (d16.d() && a16 == 99) {
            return -1L;
        }
        long j3 = a16 * 3.2258065f;
        if (j3 > 100) {
            j3 = 100;
        }
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public static long getWifiSignalStrength() {
        long calWifiStrengthInNum = calWifiStrengthInNum(j.f141599a.g());
        w.a(TAG, "getWifiSignalStrength " + calWifiStrengthInNum);
        return calWifiStrengthInNum;
    }
}
