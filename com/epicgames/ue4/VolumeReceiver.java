package com.epicgames.ue4;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;

/* compiled from: P */
/* loaded from: classes2.dex */
class VolumeReceiver extends BroadcastReceiver {
    private static String STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private static String STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
    private static String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static IntentFilter filter;
    private static VolumeReceiver receiver;

    VolumeReceiver() {
    }

    public static void startReceiver(Activity activity) {
        UE4.Log.debug("Registering volume receiver");
        if (filter == null) {
            IntentFilter intentFilter = new IntentFilter();
            filter = intentFilter;
            intentFilter.addAction(VOLUME_CHANGED_ACTION);
        }
        if (receiver == null) {
            receiver = new VolumeReceiver();
        }
        activity.registerReceiver(receiver, filter);
        int streamVolume = SystemMethodProxy.getStreamVolume((AudioManager) activity.getSystemService("audio"), 3);
        UE4.Log.debug("startVolumeReceiver: " + streamVolume);
        volumeChanged(streamVolume);
    }

    public static void stopReceiver(Activity activity) {
        UE4.Log.debug("Unregistering volume receiver");
        activity.unregisterReceiver(receiver);
    }

    private static native void volumeChanged(int i3);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        UE4.Log.debug("OnReceive VOLUME_CHANGED_ACTION");
        int intValue = ((Integer) intent.getExtras().get(STREAM_TYPE)).intValue();
        int intValue2 = ((Integer) intent.getExtras().get(STREAM_VALUE)).intValue();
        if (intValue == 3) {
            volumeChanged(intValue2);
            return;
        }
        UE4.Log.debug("skipping volume change from stream " + intValue);
    }
}
