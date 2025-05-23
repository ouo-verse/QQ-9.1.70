package org.tencwebrtc.voiceengine;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.Arrays;
import java.util.List;
import org.tencwebrtc.ContextUtils;
import org.tencwebrtc.Logging;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class WebRtcAudioUtils {
    private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    private static final String TAG = "WebRtcAudioUtils";
    private static int defaultSampleRateHz = 16000;
    private static boolean isDefaultSampleRateOverridden;
    private static boolean useWebRtcBasedAcousticEchoCanceler;
    private static boolean useWebRtcBasedNoiseSuppressor;
    private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = new String[0];
    private static final String[] BLACKLISTED_AEC_MODELS = new String[0];
    private static final String[] BLACKLISTED_NS_MODELS = new String[0];

    public static boolean deviceIsBlacklistedForOpenSLESUsage() {
        return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(DeviceInfoMonitor.getModel());
    }

    private static String deviceTypeToString(int i3) {
        switch (i3) {
            case 1:
                return "TYPE_BUILTIN_EARPIECE";
            case 2:
                return "TYPE_BUILTIN_SPEAKER";
            case 3:
                return "TYPE_WIRED_HEADSET";
            case 4:
                return "TYPE_WIRED_HEADPHONES";
            case 5:
                return "TYPE_LINE_ANALOG";
            case 6:
                return "TYPE_LINE_DIGITAL";
            case 7:
                return "TYPE_BLUETOOTH_SCO";
            case 8:
                return "TYPE_BLUETOOTH_A2DP";
            case 9:
                return "TYPE_HDMI";
            case 10:
                return "TYPE_HDMI_ARC";
            case 11:
                return "TYPE_USB_DEVICE";
            case 12:
                return "TYPE_USB_ACCESSORY";
            case 13:
                return "TYPE_DOCK";
            case 14:
                return "TYPE_FM";
            case 15:
                return "TYPE_BUILTIN_MIC";
            case 16:
                return "TYPE_FM_TUNER";
            case 17:
                return "TYPE_TV_TUNER";
            case 18:
                return "TYPE_TELEPHONY";
            case 19:
                return "TYPE_AUX_LINE";
            case 20:
                return "TYPE_IP";
            case 21:
                return "TYPE_BUS";
            case 22:
                return "TYPE_USB_HEADSET";
            default:
                return "TYPE_UNKNOWN";
        }
    }

    public static List<String> getBlackListedModelsForAecUsage() {
        return Arrays.asList(BLACKLISTED_AEC_MODELS);
    }

    public static List<String> getBlackListedModelsForNsUsage() {
        return Arrays.asList(BLACKLISTED_NS_MODELS);
    }

    public static synchronized int getDefaultSampleRateHz() {
        int i3;
        synchronized (WebRtcAudioUtils.class) {
            i3 = defaultSampleRateHz;
        }
        return i3;
    }

    public static String getThreadInfo() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    private static boolean hasMicrophone() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    public static boolean isAutomaticGainControlSupported() {
        return false;
    }

    public static synchronized boolean isDefaultSampleRateOverridden() {
        boolean z16;
        synchronized (WebRtcAudioUtils.class) {
            z16 = isDefaultSampleRateOverridden;
        }
        return z16;
    }

    public static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    private static boolean isVolumeFixed(AudioManager audioManager) {
        return audioManager.isVolumeFixed();
    }

    private static void logAudioDeviceInfo(String str, AudioManager audioManager) {
        String str2;
        AudioDeviceInfo[] devices = audioManager.getDevices(3);
        if (devices.length == 0) {
            return;
        }
        Logging.d(str, "Audio Devices: ");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("  ");
            sb5.append(deviceTypeToString(audioDeviceInfo.getType()));
            if (audioDeviceInfo.isSource()) {
                str2 = "(in): ";
            } else {
                str2 = "(out): ";
            }
            sb5.append(str2);
            if (audioDeviceInfo.getChannelCounts().length > 0) {
                sb5.append("channels=");
                sb5.append(Arrays.toString(audioDeviceInfo.getChannelCounts()));
                sb5.append(", ");
            }
            if (audioDeviceInfo.getEncodings().length > 0) {
                sb5.append("encodings=");
                sb5.append(Arrays.toString(audioDeviceInfo.getEncodings()));
                sb5.append(", ");
            }
            if (audioDeviceInfo.getSampleRates().length > 0) {
                sb5.append("sample rates=");
                sb5.append(Arrays.toString(audioDeviceInfo.getSampleRates()));
                sb5.append(", ");
            }
            sb5.append("id=");
            sb5.append(audioDeviceInfo.getId());
            Logging.d(str, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void logAudioState(String str) {
        logDeviceInfo(str);
        AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        logAudioStateBasic(str, audioManager);
        logAudioStateVolume(str, audioManager);
        logAudioDeviceInfo(str, audioManager);
    }

    private static void logAudioStateBasic(String str, AudioManager audioManager) {
        Logging.d(str, "Audio State: audio mode: " + modeToString(audioManager.getMode()) + ", has mic: " + hasMicrophone() + ", mic muted: " + audioManager.isMicrophoneMute() + ", music active: " + audioManager.isMusicActive() + ", speakerphone: " + audioManager.isSpeakerphoneOn() + ", BT SCO: " + audioManager.isBluetoothScoOn());
    }

    private static void logAudioStateVolume(String str, AudioManager audioManager) {
        int[] iArr = {0, 3, 2, 4, 5, 1};
        Logging.d(str, "Audio State: ");
        boolean isVolumeFixed = isVolumeFixed(audioManager);
        Logging.d(str, "  fixed volume=" + isVolumeFixed);
        if (!isVolumeFixed) {
            for (int i3 = 0; i3 < 6; i3++) {
                int i16 = iArr[i3];
                StringBuilder sb5 = new StringBuilder();
                sb5.append("  " + streamTypeToString(i16) + MsgSummary.STR_COLON);
                sb5.append("volume=");
                sb5.append(SystemMethodProxy.getStreamVolume(audioManager, i16));
                sb5.append(", max=");
                sb5.append(audioManager.getStreamMaxVolume(i16));
                logIsStreamMute(str, audioManager, i16, sb5);
                Logging.d(str, sb5.toString());
            }
        }
    }

    private static void logIsStreamMute(String str, AudioManager audioManager, int i3, StringBuilder sb5) {
        sb5.append(", muted=");
        sb5.append(audioManager.isStreamMute(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String modeToString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return "MODE_INVALID";
                    }
                    return "MODE_IN_COMMUNICATION";
                }
                return "MODE_IN_CALL";
            }
            return "MODE_RINGTONE";
        }
        return "MODE_NORMAL";
    }

    public static boolean runningOnEmulator() {
        if (Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_")) {
            return true;
        }
        return false;
    }

    public static synchronized void setDefaultSampleRateHz(int i3) {
        synchronized (WebRtcAudioUtils.class) {
            isDefaultSampleRateOverridden = true;
            defaultSampleRateHz = i3;
        }
    }

    public static synchronized void setWebRtcBasedAcousticEchoCanceler(boolean z16) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedAcousticEchoCanceler = z16;
        }
    }

    public static synchronized void setWebRtcBasedAutomaticGainControl(boolean z16) {
        synchronized (WebRtcAudioUtils.class) {
            Logging.w(TAG, "setWebRtcBasedAutomaticGainControl() is deprecated");
        }
    }

    public static synchronized void setWebRtcBasedNoiseSuppressor(boolean z16) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedNoiseSuppressor = z16;
        }
    }

    private static String streamTypeToString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return "STREAM_INVALID";
                            }
                            return "STREAM_NOTIFICATION";
                        }
                        return "STREAM_ALARM";
                    }
                    return "STREAM_MUSIC";
                }
                return "STREAM_RING";
            }
            return "STREAM_SYSTEM";
        }
        return "STREAM_VOICE_CALL";
    }

    public static synchronized boolean useWebRtcBasedAcousticEchoCanceler() {
        boolean z16;
        synchronized (WebRtcAudioUtils.class) {
            if (useWebRtcBasedAcousticEchoCanceler) {
                Logging.w(TAG, "Overriding default behavior; now using WebRTC AEC!");
            }
            z16 = useWebRtcBasedAcousticEchoCanceler;
        }
        return z16;
    }

    public static synchronized boolean useWebRtcBasedAutomaticGainControl() {
        synchronized (WebRtcAudioUtils.class) {
        }
        return true;
    }

    public static synchronized boolean useWebRtcBasedNoiseSuppressor() {
        boolean z16;
        synchronized (WebRtcAudioUtils.class) {
            if (useWebRtcBasedNoiseSuppressor) {
                Logging.w(TAG, "Overriding default behavior; now using WebRTC NS!");
            }
            z16 = useWebRtcBasedNoiseSuppressor;
        }
        return z16;
    }

    static void logDeviceInfo(String str) {
    }
}
