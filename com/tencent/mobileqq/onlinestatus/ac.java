package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import com.tencent.mobileqq.app.BatteryBroadcastReceiver;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ac implements BusinessObserver {
    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        boolean z17;
        if (i3 == 26364) {
            int i16 = 0;
            if (bundle != null) {
                int i17 = bundle.getInt(BatteryBroadcastReceiver.KEY_BATTERY, 0);
                z17 = bundle.getBoolean(BatteryBroadcastReceiver.KEY_CHANGE_IN_CHARGING, false);
                i16 = i17;
            } else {
                z17 = false;
            }
            a(i16);
            if (z17) {
                b();
            }
        }
    }

    public void b() {
    }

    public void a(int i3) {
    }
}
