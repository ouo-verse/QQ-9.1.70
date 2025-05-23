package com.tencent.gdtad.volume;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.log.GdtLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class VolumeChangeObserver {
    private static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private static final String TAG = "VolumeBroadcastReceiver";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";

    @Nullable
    private VolumeChangeListener listener;
    private Context mContext;
    private VolumeBroadcastReceiver mVolumeBroadcastReceiver;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private class VolumeBroadcastReceiver extends BroadcastReceiver {
        VolumeBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, @NonNull Intent intent) {
            boolean z16;
            int intExtra = intent.getIntExtra(VolumeChangeObserver.EXTRA_VOLUME_STREAM_TYPE, -1);
            if (intExtra == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            GdtLog.d(VolumeChangeObserver.TAG, "VolumeBroadcastReceiver action type = " + intent.getAction() + ", isStreamMusic = " + z16 + ", streamType = " + intExtra);
            if (VolumeChangeObserver.VOLUME_CHANGED_ACTION.equals(intent.getAction()) && z16 && VolumeChangeObserver.this.listener != null) {
                VolumeChangeObserver.this.listener.onVolumeChanged(new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface VolumeChangeListener {
        void onVolumeChanged(Object... objArr);
    }

    public VolumeChangeObserver(Context context) {
        this.mContext = context;
    }

    public void registerReceiver() {
        this.mVolumeBroadcastReceiver = new VolumeBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VOLUME_CHANGED_ACTION);
        this.mContext.registerReceiver(this.mVolumeBroadcastReceiver, intentFilter);
    }

    public void setListener(VolumeChangeListener volumeChangeListener) {
        this.listener = volumeChangeListener;
    }

    public void unregisterReceiver() {
        Context context;
        try {
            VolumeBroadcastReceiver volumeBroadcastReceiver = this.mVolumeBroadcastReceiver;
            if (volumeBroadcastReceiver != null && (context = this.mContext) != null) {
                context.unregisterReceiver(volumeBroadcastReceiver);
                this.listener = null;
            }
        } catch (IllegalArgumentException e16) {
            GdtLog.d(TAG, "VolumeBroadcastReceiver unregisterReceiver failed, error is " + e16);
        }
    }
}
