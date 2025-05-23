package com.tencent.avcore.jni.codec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class DeviceCheckHelper {
    static IPatchRedirector $redirector_;

    public DeviceCheckHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean checkAVCDecWhitelistDevices1() {
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase("LGE") && DeviceInfoMonitor.getModel().equalsIgnoreCase("Nexus 4") && Build.PRODUCT.equalsIgnoreCase("occam")) {
            return true;
        }
        if (str.equalsIgnoreCase("LGE") && DeviceInfoMonitor.getModel().equalsIgnoreCase("Nexus 5") && Build.PRODUCT.equalsIgnoreCase("hammerhead")) {
            return true;
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && DeviceInfoMonitor.getModel().equalsIgnoreCase("GT-I9500")) {
            return true;
        }
        if (str.equalsIgnoreCase("LGE") && DeviceInfoMonitor.getModel().equalsIgnoreCase("LG-D802")) {
            return true;
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU) && DeviceInfoMonitor.getModel().equalsIgnoreCase("MX4 Pro")) {
            return true;
        }
        return false;
    }

    private static boolean checkAVCDecWhitelistDevices2() {
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU) && DeviceInfoMonitor.getModel().equalsIgnoreCase("M353") && Build.PRODUCT.equalsIgnoreCase("meizu_mx3")) {
            return true;
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU) && DeviceInfoMonitor.getModel().equalsIgnoreCase("m1 note") && Build.PRODUCT.equalsIgnoreCase("m1 note")) {
            return true;
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && DeviceInfoMonitor.getModel().equalsIgnoreCase("SM-N9006V")) {
            return true;
        }
        if (str.equalsIgnoreCase("smartisan") && DeviceInfoMonitor.getModel().equalsIgnoreCase("SM705") && Build.PRODUCT.equalsIgnoreCase("msm8974sfo_lte")) {
            return true;
        }
        if (str.equalsIgnoreCase("OPPO") && DeviceInfoMonitor.getModel().equalsIgnoreCase("N5207") && Build.PRODUCT.equalsIgnoreCase("N5207")) {
            return true;
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && DeviceInfoMonitor.getModel().equalsIgnoreCase("HM 1SC") && Build.PRODUCT.equalsIgnoreCase("armani")) {
            return true;
        }
        return false;
    }

    public static boolean checkDecoderSupportColorFormat(int i3) {
        if (i3 != 19 && i3 != 21 && i3 != 2130706944 && i3 != 2141391876) {
            return false;
        }
        return true;
    }

    public static boolean checkEncoderSupportColorFormat(int i3) {
        if (i3 != 19 && i3 != 21) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        continue;
     */
    @SuppressLint({"NewApi"})
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isAVCDecSupportColorformats() {
        List<MediaCodecInfo> decoderInfos = AndroidCodecBase.getDecoderInfos("video/avc");
        for (int i3 = 0; i3 < decoderInfos.size(); i3++) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = AndroidCodecBase.getCodecCapabilities(decoderInfos.get(i3), "video/avc");
            if (codecCapabilities != null && codecCapabilities.colorFormats != null) {
                int i16 = 0;
                while (true) {
                    int[] iArr = codecCapabilities.colorFormats;
                    if (i16 < iArr.length) {
                        if (checkDecoderSupportColorFormat(iArr[i16])) {
                            return true;
                        }
                        i16++;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isAVCDecWhitelistDevices() {
        if (checkAVCDecWhitelistDevices1()) {
            return isAVCDecSupportColorformats();
        }
        if (checkAVCDecWhitelistDevices2()) {
            return isAVCDecSupportColorformats();
        }
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && DeviceInfoMonitor.getModel().equalsIgnoreCase("SM-N9005")) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        continue;
     */
    @SuppressLint({"NewApi"})
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isAVCEncSupportColorformats() {
        List<MediaCodecInfo> endoderInfos = AndroidCodecBase.getEndoderInfos("video/avc");
        for (int i3 = 0; i3 < endoderInfos.size(); i3++) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = AndroidCodecBase.getCodecCapabilities(endoderInfos.get(i3), "video/avc");
            if (codecCapabilities != null) {
                int i16 = 0;
                while (true) {
                    int[] iArr = codecCapabilities.colorFormats;
                    if (i16 < iArr.length) {
                        if (checkEncoderSupportColorFormat(iArr[i16])) {
                            return true;
                        }
                        i16++;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isAVCEncWhitelistDevices() {
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase("OPPO") && DeviceInfoMonitor.getModel().equalsIgnoreCase("N5207") && Build.PRODUCT.equalsIgnoreCase("N5207")) {
            return isAVCEncSupportColorformats();
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && DeviceInfoMonitor.getModel().equalsIgnoreCase("GT-I9500")) {
            return isAVCEncSupportColorformats();
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && DeviceInfoMonitor.getModel().equalsIgnoreCase("MI NOTE LTE") && Build.PRODUCT.equalsIgnoreCase("virgo")) {
            return isAVCEncSupportColorformats();
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ASUS) && DeviceInfoMonitor.getModel().equalsIgnoreCase("ASUS_Z00ADA") && Build.PRODUCT.equalsIgnoreCase("CN_Z00A")) {
            return isAVCEncSupportColorformats();
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && DeviceInfoMonitor.getModel().equalsIgnoreCase("MI 4W") && Build.PRODUCT.equalsIgnoreCase("cancro_wc_lte")) {
            return isAVCEncSupportColorformats();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        r3 = r3 + 1;
     */
    @SuppressLint({"NewApi"})
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isHevcDecSupportColorformats() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        List<MediaCodecInfo> decoderInfos = AndroidCodecBase.getDecoderInfos("video/hevc");
        int i3 = 0;
        while (i3 < decoderInfos.size() && (codecCapabilities = AndroidCodecBase.getCodecCapabilities(decoderInfos.get(i3), "video/hevc")) != null && codecCapabilities.colorFormats != null) {
            int i16 = 0;
            while (true) {
                int[] iArr = codecCapabilities.colorFormats;
                if (i16 < iArr.length) {
                    if (checkDecoderSupportColorFormat(iArr[i16])) {
                        return true;
                    }
                    i16++;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r3 = r3 + 1;
     */
    @SuppressLint({"NewApi"})
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isHevcEncSupportColorformats() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        List<MediaCodecInfo> endoderInfos = AndroidCodecBase.getEndoderInfos("video/hevc");
        int i3 = 0;
        while (i3 < endoderInfos.size() && (codecCapabilities = AndroidCodecBase.getCodecCapabilities(endoderInfos.get(i3), "video/hevc")) != null) {
            int i16 = 0;
            while (true) {
                int[] iArr = codecCapabilities.colorFormats;
                if (i16 < iArr.length) {
                    if (checkEncoderSupportColorFormat(iArr[i16])) {
                        return true;
                    }
                    i16++;
                }
            }
        }
        return false;
    }
}
