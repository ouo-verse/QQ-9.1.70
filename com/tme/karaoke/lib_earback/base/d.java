package com.tme.karaoke.lib_earback.base;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import androidx.annotation.Nullable;
import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes27.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static AudioManager f386974a;

    public static int a() {
        AudioDeviceInfo[] devices;
        if (f386974a == null) {
            b(b.a());
        }
        AudioManager audioManager = f386974a;
        if (audioManager == null) {
            LogUtil.i("AudioManagerUtil", "getHeadPhoneAudioType: because mAudioManager is null");
            return 1;
        }
        boolean isBluetoothA2dpOn = audioManager.isBluetoothA2dpOn();
        boolean isWiredHeadsetOn = f386974a.isWiredHeadsetOn();
        LogUtil.i("AudioManagerUtil", "isBluetoothA2dpOn: " + isBluetoothA2dpOn + ", isWiredHeadsetOn: " + isWiredHeadsetOn);
        if (f386974a != null && (devices = f386974a.getDevices(2)) != null) {
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                int type = audioDeviceInfo.getType();
                LogUtil.i("AudioManagerUtil", "deviceInfoType=" + d(type));
                if (type != 8 && type != 7) {
                    if (type == 22 || type == 3 || type == 4 || type == 11 || type == 12 || type == 5) {
                        isWiredHeadsetOn = true;
                        break;
                    }
                } else {
                    isBluetoothA2dpOn = true;
                    break;
                }
            }
            LogUtil.i("AudioManagerUtil", "api aboveorEqual m ,isBlueTooth=" + isBluetoothA2dpOn + ",isWiredHeadSet = " + isWiredHeadsetOn);
        }
        if (isWiredHeadsetOn) {
            return 2;
        }
        if (!isBluetoothA2dpOn) {
            return 1;
        }
        return 3;
    }

    public static void b(@Nullable Context context) {
        if (f386974a == null) {
            try {
                f386974a = (AudioManager) context.getSystemService("audio");
            } catch (Exception e16) {
                LogUtil.e("AudioManagerUtil", "initAudioManager -> " + e16.getMessage());
            }
            if (f386974a == null && b.a() != null) {
                try {
                    f386974a = (AudioManager) b.a().getSystemService("audio");
                } catch (Exception e17) {
                    LogUtil.e("AudioManagerUtil", "initAudioManager -> " + e17.getMessage());
                }
            }
        }
    }

    public static boolean c() {
        if (a() == 1) {
            return true;
        }
        return false;
    }

    private static String d(int i3) {
        switch (i3) {
            case 1:
                return "built-in earphone speaker";
            case 2:
                return "built-in speaker";
            case 3:
                return "wired headset";
            case 4:
                return "wired headphones";
            case 5:
                return "line analog";
            case 6:
                return "line digital";
            case 7:
                return "Bluetooth device typically used for telephony";
            case 8:
                return "Bluetooth device supporting the A2DP profile";
            case 9:
                return "HDMI";
            case 10:
                return "HDMI audio return channel";
            case 11:
                return "USB device";
            case 12:
                return "USB accessory";
            case 13:
                return "DOCK";
            case 14:
                return "FM";
            case 15:
                return "built-in microphone";
            case 16:
                return "FM tuner";
            case 17:
                return "TV tuner";
            case 18:
                return "telephony";
            case 19:
                return "auxiliary line-level connectors";
            case 20:
                return "IP";
            case 21:
                return "BUS";
            default:
                return "unknown type=" + i3;
        }
    }
}
