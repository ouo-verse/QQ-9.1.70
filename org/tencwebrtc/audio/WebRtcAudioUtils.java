package org.tencwebrtc.audio;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import java.util.Arrays;
import org.tencwebrtc.Logging;

/* compiled from: P */
/* loaded from: classes29.dex */
final class WebRtcAudioUtils {
    private static final String TAG = "WebRtcAudioUtilsExternal";

    WebRtcAudioUtils() {
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

    public static String getThreadInfo() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    private static boolean hasMicrophone(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.microphone");
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
    public static void logAudioState(String str, Context context, AudioManager audioManager) {
        logDeviceInfo(str);
        logAudioStateBasic(str, context, audioManager);
        logAudioStateVolume(str, audioManager);
        logAudioDeviceInfo(str, audioManager);
    }

    private static void logAudioStateBasic(String str, Context context, AudioManager audioManager) {
        Logging.d(str, "Audio State: audio mode: " + modeToString(audioManager.getMode()) + ", has mic: " + hasMicrophone(context) + ", mic muted: " + audioManager.isMicrophoneMute() + ", music active: " + audioManager.isMusicActive() + ", speakerphone: " + audioManager.isSpeakerphoneOn() + ", BT SCO: " + audioManager.isBluetoothScoOn());
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

    static void logDeviceInfo(String str) {
    }
}
