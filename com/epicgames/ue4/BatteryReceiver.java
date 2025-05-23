package com.epicgames.ue4;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: P */
/* loaded from: classes2.dex */
class BatteryReceiver extends BroadcastReceiver {
    public static IntentFilter filter;
    public static BatteryReceiver receiver;
    private int batteryLevel = 0;
    private int batteryStatus = 0;
    private int batteryTemperature = 0;

    BatteryReceiver() {
    }

    private static native void dispatchEvent(int i3, int i16, int i17);

    private void processIntent(Intent intent) {
        int i3 = 0;
        if (intent.getBooleanExtra("present", false)) {
            int intExtra = intent.getIntExtra("status", 0);
            int intExtra2 = intent.getIntExtra("level", -1);
            int intExtra3 = intent.getIntExtra("scale", -1);
            int intExtra4 = intent.getIntExtra("temperature", 0);
            if (intExtra2 >= 0 && intExtra3 > 0) {
                i3 = (intExtra2 * 100) / intExtra3;
            }
            if (intExtra != this.batteryStatus || i3 != this.batteryLevel || intExtra4 != this.batteryTemperature) {
                UE4.Log.debug("Battery: status = " + intExtra + ", rawlevel = " + intExtra2 + ", scale = " + intExtra3);
                this.batteryStatus = intExtra;
                this.batteryLevel = i3;
                this.batteryTemperature = intExtra4;
                dispatchEvent(intExtra, i3, intExtra4);
            }
        }
    }

    public static void startReceiver(Activity activity) {
        UE4.Log.debug("Registering battery receiver");
        if (filter == null) {
            filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        }
        if (receiver == null) {
            receiver = new BatteryReceiver();
        }
        activity.registerReceiver(receiver, filter);
        receiver.processIntent(activity.getIntent());
    }

    public static void stopReceiver(Activity activity) {
        UE4.Log.debug("Unregistering battery receiver");
        activity.unregisterReceiver(receiver);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        processIntent(intent);
    }
}
