package com.epicgames.ue4;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: P */
/* loaded from: classes2.dex */
class HeadsetReceiver extends BroadcastReceiver {
    public static IntentFilter filter;
    public static HeadsetReceiver receiver;

    HeadsetReceiver() {
    }

    public static void startReceiver(Activity activity) {
        UE4.Log.debug("Registering headset receiver");
        if (filter == null) {
            filter = new IntentFilter("android.intent.action.HEADSET_PLUG");
        }
        if (receiver == null) {
            receiver = new HeadsetReceiver();
        }
        activity.registerReceiver(receiver, filter);
        int intExtra = activity.getIntent().getIntExtra("state", 0);
        UE4.Log.debug("startHeadsetReceiver: " + intExtra);
        stateChanged(intExtra);
    }

    private static native void stateChanged(int i3);

    public static void stopReceiver(Activity activity) {
        UE4.Log.debug("Unregistering headset receiver");
        activity.unregisterReceiver(receiver);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        UE4.Log.debug("headsetReceiver::onReceive");
        if (intent.hasExtra("state")) {
            stateChanged(intent.getIntExtra("state", 0));
        }
    }
}
