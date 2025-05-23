package com.tencent.mobileqq.qqbattery.feature;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    public static int f(Context context) {
        if (i.b.c(context)) {
            com.tencent.mobileqq.qqbattery.utils.a.a("QQBattery_DeviceStatusMonitorFeature", "POWER_CONNECTED", new Object[0]);
            return 1;
        }
        if (!i.b.e(context)) {
            com.tencent.mobileqq.qqbattery.utils.a.a("QQBattery_DeviceStatusMonitorFeature", "SCREEN_OFF", new Object[0]);
            return 3;
        }
        if (i.b.d(context)) {
            com.tencent.mobileqq.qqbattery.utils.a.a("QQBattery_DeviceStatusMonitorFeature", "POWER_SAVE_MODE OPEN", new Object[0]);
            return 4;
        }
        com.tencent.mobileqq.qqbattery.utils.a.a("QQBattery_DeviceStatusMonitorFeature", "POWER_DISCONNECTED", new Object[0]);
        return 2;
    }
}
