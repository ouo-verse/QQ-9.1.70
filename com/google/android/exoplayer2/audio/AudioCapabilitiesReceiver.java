package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class AudioCapabilitiesReceiver {
    AudioCapabilities audioCapabilities;
    private final Context context;
    private final Listener listener;
    private final BroadcastReceiver receiver;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        HdmiAudioPlugBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                AudioCapabilities capabilities = AudioCapabilities.getCapabilities(intent);
                if (!capabilities.equals(AudioCapabilitiesReceiver.this.audioCapabilities)) {
                    AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
                    audioCapabilitiesReceiver.audioCapabilities = capabilities;
                    audioCapabilitiesReceiver.listener.onAudioCapabilitiesChanged(capabilities);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Listener {
        void onAudioCapabilitiesChanged(AudioCapabilities audioCapabilities);
    }

    public AudioCapabilitiesReceiver(Context context, Listener listener) {
        this.context = (Context) Assertions.checkNotNull(context);
        this.listener = (Listener) Assertions.checkNotNull(listener);
        this.receiver = Util.SDK_INT >= 21 ? new HdmiAudioPlugBroadcastReceiver() : null;
    }

    public AudioCapabilities register() {
        Intent registerReceiver;
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver == null) {
            registerReceiver = null;
        } else {
            registerReceiver = this.context.registerReceiver(broadcastReceiver, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        }
        AudioCapabilities capabilities = AudioCapabilities.getCapabilities(registerReceiver);
        this.audioCapabilities = capabilities;
        return capabilities;
    }

    public void unregister() {
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
        }
    }
}
