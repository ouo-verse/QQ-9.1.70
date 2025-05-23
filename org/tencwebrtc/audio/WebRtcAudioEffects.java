package org.tencwebrtc.audio;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.NoiseSuppressor;
import android.support.annotation.Nullable;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.UUID;
import org.tencwebrtc.Logging;

/* compiled from: P */
/* loaded from: classes29.dex */
class WebRtcAudioEffects {
    private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
    private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
    private static final boolean DEBUG = false;
    private static final String TAG = "WebRtcAudioEffectsExternal";

    @Nullable
    private static AudioEffect.Descriptor[] cachedEffects;

    @Nullable
    private AcousticEchoCanceler aec;

    /* renamed from: ns, reason: collision with root package name */
    @Nullable
    private NoiseSuppressor f423870ns;
    private boolean shouldEnableAec;
    private boolean shouldEnableNs;

    public WebRtcAudioEffects() {
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }

    private static void assertTrue(boolean z16) {
        if (z16) {
        } else {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private boolean effectTypeIsVoIP(UUID uuid) {
        if ((AudioEffect.EFFECT_TYPE_AEC.equals(uuid) && isAcousticEchoCancelerSupported()) || (AudioEffect.EFFECT_TYPE_NS.equals(uuid) && isNoiseSuppressorSupported())) {
            return true;
        }
        return false;
    }

    @Nullable
    private static AudioEffect.Descriptor[] getAvailableEffects() {
        AudioEffect.Descriptor[] descriptorArr = cachedEffects;
        if (descriptorArr != null) {
            return descriptorArr;
        }
        try {
            AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
            cachedEffects = queryEffects;
            return queryEffects;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC, AOSP_ACOUSTIC_ECHO_CANCELER);
    }

    private static boolean isEffectTypeAvailable(UUID uuid, UUID uuid2) {
        AudioEffect.Descriptor[] availableEffects = getAvailableEffects();
        if (availableEffects == null) {
            return false;
        }
        for (AudioEffect.Descriptor descriptor : availableEffects) {
            if (descriptor.type.equals(uuid)) {
                return !r4.uuid.equals(uuid2);
            }
        }
        return false;
    }

    public static boolean isNoiseSuppressorSupported() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS, AOSP_NOISE_SUPPRESSOR);
    }

    public void enable(int i3) {
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        String str2;
        String str3;
        Logging.d(TAG, "enable(audioSession=" + i3 + ")");
        boolean z19 = true;
        if (this.aec == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        assertTrue(z16);
        if (this.f423870ns == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        assertTrue(z17);
        boolean isAcousticEchoCancelerSupported = isAcousticEchoCancelerSupported();
        String str4 = NodeProps.ENABLED;
        if (isAcousticEchoCancelerSupported) {
            AcousticEchoCanceler create = AcousticEchoCanceler.create(i3);
            this.aec = create;
            if (create != null) {
                boolean enabled = create.getEnabled();
                if (this.shouldEnableAec && isAcousticEchoCancelerSupported()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (this.aec.setEnabled(z18) != 0) {
                    Logging.e(TAG, "Failed to set the AcousticEchoCanceler state");
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("AcousticEchoCanceler: was ");
                if (!enabled) {
                    str2 = "disabled";
                } else {
                    str2 = NodeProps.ENABLED;
                }
                sb5.append(str2);
                sb5.append(", enable: ");
                sb5.append(z18);
                sb5.append(", is now: ");
                if (!this.aec.getEnabled()) {
                    str3 = "disabled";
                } else {
                    str3 = NodeProps.ENABLED;
                }
                sb5.append(str3);
                Logging.d(TAG, sb5.toString());
            } else {
                Logging.e(TAG, "Failed to create the AcousticEchoCanceler instance");
            }
        }
        if (isNoiseSuppressorSupported()) {
            NoiseSuppressor create2 = NoiseSuppressor.create(i3);
            this.f423870ns = create2;
            if (create2 != null) {
                boolean enabled2 = create2.getEnabled();
                if (!this.shouldEnableNs || !isNoiseSuppressorSupported()) {
                    z19 = false;
                }
                if (this.f423870ns.setEnabled(z19) != 0) {
                    Logging.e(TAG, "Failed to set the NoiseSuppressor state");
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("NoiseSuppressor: was ");
                if (!enabled2) {
                    str = "disabled";
                } else {
                    str = NodeProps.ENABLED;
                }
                sb6.append(str);
                sb6.append(", enable: ");
                sb6.append(z19);
                sb6.append(", is now: ");
                if (!this.f423870ns.getEnabled()) {
                    str4 = "disabled";
                }
                sb6.append(str4);
                Logging.d(TAG, sb6.toString());
                return;
            }
            Logging.e(TAG, "Failed to create the NoiseSuppressor instance");
        }
    }

    public void release() {
        Logging.d(TAG, "release");
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
            this.aec = null;
        }
        NoiseSuppressor noiseSuppressor = this.f423870ns;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this.f423870ns = null;
        }
    }

    public boolean setAEC(boolean z16) {
        Logging.d(TAG, "setAEC(" + z16 + ")");
        if (!isAcousticEchoCancelerSupported()) {
            Logging.w(TAG, "Platform AEC is not supported");
            this.shouldEnableAec = false;
            return false;
        }
        if (this.aec != null && z16 != this.shouldEnableAec) {
            Logging.e(TAG, "Platform AEC state can't be modified while recording");
            return false;
        }
        this.shouldEnableAec = z16;
        return true;
    }

    public boolean setNS(boolean z16) {
        Logging.d(TAG, "setNS(" + z16 + ")");
        if (!isNoiseSuppressorSupported()) {
            Logging.w(TAG, "Platform NS is not supported");
            this.shouldEnableNs = false;
            return false;
        }
        if (this.f423870ns != null && z16 != this.shouldEnableNs) {
            Logging.e(TAG, "Platform NS state can't be modified while recording");
            return false;
        }
        this.shouldEnableNs = z16;
        return true;
    }
}
