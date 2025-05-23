package org.tencwebrtc.voiceengine;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.NoiseSuppressor;
import android.support.annotation.Nullable;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.UUID;
import org.tencwebrtc.Logging;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WebRtcAudioEffects {
    private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
    private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
    private static final boolean DEBUG = false;
    private static final String TAG = "WebRtcAudioEffects";

    @Nullable
    private static AudioEffect.Descriptor[] cachedEffects;

    @Nullable
    private AcousticEchoCanceler aec;

    /* renamed from: ns, reason: collision with root package name */
    @Nullable
    private NoiseSuppressor f423905ns;
    private boolean shouldEnableAec;
    private boolean shouldEnableNs;

    WebRtcAudioEffects() {
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }

    private static void assertTrue(boolean z16) {
        if (z16) {
        } else {
            throw new AssertionError("Expected condition to be true");
        }
    }

    public static boolean canUseAcousticEchoCanceler() {
        boolean z16;
        if (isAcousticEchoCancelerSupported() && !WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler() && !isAcousticEchoCancelerBlacklisted() && !isAcousticEchoCancelerExcludedByUUID()) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logging.d(TAG, "canUseAcousticEchoCanceler: " + z16);
        return z16;
    }

    public static boolean canUseNoiseSuppressor() {
        boolean z16;
        if (isNoiseSuppressorSupported() && !WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor() && !isNoiseSuppressorBlacklisted() && !isNoiseSuppressorExcludedByUUID()) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logging.d(TAG, "canUseNoiseSuppressor: " + z16);
        return z16;
    }

    public static WebRtcAudioEffects create() {
        return new WebRtcAudioEffects();
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
        AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
        cachedEffects = queryEffects;
        return queryEffects;
    }

    public static boolean isAcousticEchoCancelerBlacklisted() {
        boolean contains = WebRtcAudioUtils.getBlackListedModelsForAecUsage().contains(DeviceInfoMonitor.getModel());
        if (contains) {
            Logging.w(TAG, DeviceInfoMonitor.getModel() + " is blacklisted for HW AEC usage!");
        }
        return contains;
    }

    private static boolean isAcousticEchoCancelerEffectAvailable() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC);
    }

    private static boolean isAcousticEchoCancelerExcludedByUUID() {
        for (AudioEffect.Descriptor descriptor : getAvailableEffects()) {
            if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_AEC) && descriptor.uuid.equals(AOSP_ACOUSTIC_ECHO_CANCELER)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return isAcousticEchoCancelerEffectAvailable();
    }

    private static boolean isEffectTypeAvailable(UUID uuid) {
        AudioEffect.Descriptor[] availableEffects = getAvailableEffects();
        if (availableEffects == null) {
            return false;
        }
        for (AudioEffect.Descriptor descriptor : availableEffects) {
            if (descriptor.type.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNoiseSuppressorBlacklisted() {
        boolean contains = WebRtcAudioUtils.getBlackListedModelsForNsUsage().contains(DeviceInfoMonitor.getModel());
        if (contains) {
            Logging.w(TAG, DeviceInfoMonitor.getModel() + " is blacklisted for HW NS usage!");
        }
        return contains;
    }

    private static boolean isNoiseSuppressorEffectAvailable() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS);
    }

    private static boolean isNoiseSuppressorExcludedByUUID() {
        for (AudioEffect.Descriptor descriptor : getAvailableEffects()) {
            if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_NS) && descriptor.uuid.equals(AOSP_NOISE_SUPPRESSOR)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNoiseSuppressorSupported() {
        return isNoiseSuppressorEffectAvailable();
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
        if (this.f423905ns == null) {
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
                if (this.shouldEnableAec && canUseAcousticEchoCanceler()) {
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
            this.f423905ns = create2;
            if (create2 != null) {
                boolean enabled2 = create2.getEnabled();
                if (!this.shouldEnableNs || !canUseNoiseSuppressor()) {
                    z19 = false;
                }
                if (this.f423905ns.setEnabled(z19) != 0) {
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
                if (!this.f423905ns.getEnabled()) {
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
        NoiseSuppressor noiseSuppressor = this.f423905ns;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this.f423905ns = null;
        }
    }

    public boolean setAEC(boolean z16) {
        Logging.d(TAG, "setAEC(" + z16 + ")");
        if (!canUseAcousticEchoCanceler()) {
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
        if (!canUseNoiseSuppressor()) {
            Logging.w(TAG, "Platform NS is not supported");
            this.shouldEnableNs = false;
            return false;
        }
        if (this.f423905ns != null && z16 != this.shouldEnableNs) {
            Logging.e(TAG, "Platform NS state can't be modified while recording");
            return false;
        }
        this.shouldEnableNs = z16;
        return true;
    }
}
