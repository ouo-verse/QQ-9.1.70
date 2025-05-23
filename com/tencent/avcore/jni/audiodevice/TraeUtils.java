package com.tencent.avcore.jni.audiodevice;

import android.media.AudioManager;
import android.os.Build;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TraeUtils {
    static IPatchRedirector $redirector_;
    public static final String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14005);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = TraeUtils.class.getSimpleName();
        }
    }

    public TraeUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void forceVolumeControlStream(AudioManager audioManager, int i3) {
        String str = Build.MANUFACTURER;
        if (!str.equals("Google") && Build.VERSION.SDK_INT < 28) {
            Object invokeMethod = invokeMethod(audioManager, "forceVolumeControlStream", new Object[]{Integer.valueOf(i3)}, new Class[]{Integer.TYPE});
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.i(TAG, "forceVolumeControlStream  streamType[" + i3 + "], res[" + invokeMethod + "]");
                return;
            }
            return;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, "forceVolumeControlStream, manufacturer[" + str + "], sdk version[" + Build.VERSION.SDK_INT + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAudioMode(AudioManager audioManager) {
        int mode = audioManager.getMode();
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.d(TAG, "getAudioMode. mode: " + mode);
        }
        return mode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAudioSource(int i3) {
        int i16;
        if (isEabiNotLowVersion()) {
            if (i3 >= 0) {
                i16 = i3;
            } else {
                i16 = 7;
            }
        } else {
            i16 = 0;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "[getAudioSource] audioSourcePolicy[" + i3 + "], source[" + i16 + "]");
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAudioStreamType(int i3) {
        int i16;
        if (isEabiNotLowVersion()) {
            if (i3 >= 0) {
                i16 = i3;
            } else {
                i16 = 0;
            }
        } else {
            i16 = 3;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "[getAudioStreamType] audioStreamTypePolicy[" + i3 + "], streamType[" + i16 + "]");
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getSysSpeakerphoneOn(AudioManager audioManager) {
        try {
            return audioManager.isSpeakerphoneOn();
        } catch (Exception e16) {
            AVCoreLog.e(TAG, "AudioManager#isSpeakerphoneOn exception[" + e16.getMessage() + "]");
            return false;
        }
    }

    private static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        if (obj == null) {
            return null;
        }
        try {
            return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e16) {
            if (!AVCoreLog.isColorLevel()) {
                return null;
            }
            AVCoreLog.e(TAG, "invokeMethod Exception:" + e16.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isCloseSystemAPM() {
        String str = Build.MANUFACTURER;
        if (str.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI)) {
            if (!DeviceInfoMonitor.getModel().equals("MI 2") && !DeviceInfoMonitor.getModel().equals("MI 2A") && !DeviceInfoMonitor.getModel().equals("MI 2S") && !DeviceInfoMonitor.getModel().equals("MI 2SC")) {
                return false;
            }
            return true;
        }
        if (!str.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
            return false;
        }
        return DeviceInfoMonitor.getModel().equals("SCH-I959");
    }

    private static boolean isEabiNotLowVersion() {
        if (isEabiNotLowVersionByAbi(Build.CPU_ABI) || isEabiNotLowVersionByAbi(Build.CPU_ABI2)) {
            return true;
        }
        for (String str : Build.SUPPORTED_ABIS) {
            if (isEabiNotLowVersionByAbi(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEabiNotLowVersionByAbi(String str) {
        if (str != null && (str.contains(ResourceAttributes.HostArchValues.X86) || str.contains("mips") || str.equalsIgnoreCase("armeabi-v7a") || str.equalsIgnoreCase("arm64-v8a"))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setAudioMode(AudioManager audioManager, int i3) {
        AVCoreLog.i(TAG, "setAudioMode. mode: " + i3);
        audioManager.setMode(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAudioMode(int i3) {
        int i16 = isEabiNotLowVersion() ? i3 >= 0 ? i3 : 3 : 0;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(TAG, "[getAudioMode] modePolicy[" + i3 + "], mode[" + i16 + "], manufacturer[" + Build.MANUFACTURER + "], model[" + DeviceInfoMonitor.getModel() + "]");
        }
        return i16;
    }
}
