package com.tencent.mobileqq.shortvideo;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RMBizTypeEnum;
import com.tencent.qqnt.kernel.nativeinterface.RMCodecInfo;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.thumbplayer.api.capability.TPDecoderCapability;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i {
    public static int a(AppRuntime appRuntime, int i3, int i16, int i17, int i18, int i19, com.tencent.mobileqq.aio.msglist.holder.component.video.u uVar) {
        RMCodecInfo richMediaCodecInfo;
        if (appRuntime != null && uVar != null) {
            if (!d(appRuntime, i16, i17, i18, i19)) {
                h(appRuntime, "0", "1", "0", "0", "0");
                return 0;
            }
            if (i3 == 1 || String.valueOf(1).equals(uVar.b())) {
                return 1;
            }
            if (String.valueOf(0).equals(uVar.b())) {
                if (!uVar.a()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", ", has direct download h264 video, so keep download h264 video.");
                    }
                    h(appRuntime, "0", "0", "1", "0", "0");
                    return 0;
                }
                if ("1".equals(uVar.d())) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", ", has pre download h265 video over 2 seconds, so keep download h264 video.");
                    }
                    h(appRuntime, "0", "0", "0", "1", "0");
                    return 0;
                }
            }
            com.tencent.qqnt.kernel.api.ab g16 = com.tencent.qqnt.msg.f.g();
            if (g16 != null && (richMediaCodecInfo = g16.getRichMediaCodecInfo(RMBizTypeEnum.KC2CVIDEO)) != null) {
                if (richMediaCodecInfo.decodeAbility.videoCodecFormat == VideoCodecFormatType.KCODECFORMATH264) {
                    h(appRuntime, "0", "0", "0", "0", "1");
                    return 0;
                }
                VideoCodecFormatType videoCodecFormatType = VideoCodecFormatType.KCODECFORMATH264;
            }
            return 1;
        }
        QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", ", getVideoDownloadRequestCodecFormat error, invalid params.");
        h(appRuntime, "1", "0", "0", "0", "0");
        return 0;
    }

    public static int b(AppRuntime appRuntime, int i3) {
        if (i3 != 1) {
            QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", "[needEncodeToH265Video] mIsH265Video = false");
            return 0;
        }
        if (!e(appRuntime)) {
            QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", "[needEncodeToH265Video] isConfigEnableAIOH265VideoUpload = false");
            return 0;
        }
        if (!f()) {
            QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", "[needEncodeToH265Video] isDeviceSupportEncodeH265Video = false");
            return 0;
        }
        QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", "[needEncodeToH265Video] needEncodeToH265Video = true");
        return 1;
    }

    public static boolean c(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", "isAIOConfigEnableH265Video return, invalid params.");
            return false;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_enable_h265_video", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(AppRuntime appRuntime, int i3, int i16, int i17, int i18) {
        boolean z16;
        if (appRuntime == null) {
            QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", "isAIOEnableH265Video return false, invalid params.");
            return false;
        }
        if (!c(appRuntime)) {
            QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", "isAIOEnableH265Video return false, config disable h265 video.");
            return false;
        }
        if (g()) {
            QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", "isVideoRequestFormatTypeSwitchOpen.");
            return true;
        }
        if (i3 <= 0) {
            i3 = i17;
        }
        if (i16 <= 0) {
            i16 = i18;
        }
        try {
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("SVBusiUtilForNT", 2, "[H265_VIDEO]", "isAIOEnableH265Video check video codec capability failed.", th5);
            }
        }
        if (TPDecoderCapability.getVideoDecoderCapability(172, i3, i16, 30.0f) == 1) {
            z16 = true;
            if (!z16) {
                QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", "isAIOEnableH265Video return false, disableDecodeH265Video");
            }
            return z16;
        }
        z16 = false;
        if (!z16) {
        }
        return z16;
    }

    private static boolean e(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.d("SVBusiUtilForNT", 1, "[H265_VIDEO]", "isConfigEnableTranscodingH265ToH264WhenForward return, invalid params.");
            return false;
        }
        if (!c(appRuntime)) {
            return false;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_enable_h265_video_upload", true);
    }

    @RequiresApi(api = 16)
    private static boolean f() {
        boolean isHardwareAccelerated;
        if (!QzoneConfig.isWinkPublishEnableHevc()) {
            if (QLog.isColorLevel()) {
                QLog.d("SVBusiUtilForNT", 2, "[H265_VIDEO]", "[isSupportEncodeH265Video] not enable hevc");
            }
            return false;
        }
        String winkPublishHevcBlacklist = QzoneConfig.getWinkPublishHevcBlacklist();
        if (winkPublishHevcBlacklist.contains(DeviceInfoMonitor.getModel())) {
            if (QLog.isColorLevel()) {
                QLog.d("SVBusiUtilForNT", 2, "[H265_VIDEO]", "[isSupportEncodeH265Video] in blacklist, model=" + DeviceInfoMonitor.getModel() + ", blacklist=" + winkPublishHevcBlacklist);
            }
            return false;
        }
        int winkPublishHevcOsVersion = QzoneConfig.getWinkPublishHevcOsVersion();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < winkPublishHevcOsVersion) {
            if (QLog.isColorLevel()) {
                QLog.d("SVBusiUtilForNT", 2, "[H265_VIDEO]", "[isSupportEncodeH265Video] OS Version limited, " + i3 + " < " + winkPublishHevcOsVersion);
            }
            return false;
        }
        int codecCount = MediaCodecList.getCodecCount();
        for (int i16 = 0; i16 < codecCount; i16++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i16);
            String name = codecInfoAt.getName();
            if (codecInfoAt.isEncoder() && (name.contains("hevc") || name.contains("HEVC"))) {
                if (Build.VERSION.SDK_INT >= 29) {
                    isHardwareAccelerated = codecInfoAt.isHardwareAccelerated();
                    if (isHardwareAccelerated) {
                        return true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SVBusiUtilForNT", 2, "[H265_VIDEO]", "[isSupportEncodeH265Video] encoder not hardware accelerated");
                    }
                } else {
                    return true;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SVBusiUtilForNT", 2, "[H265_VIDEO]", "[isSupportEncodeH265Video] no hevc encoder codec");
        }
        return false;
    }

    private static boolean g() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("video_request_format_type_switch", false);
    }

    private static void h(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5) {
        if (appRuntime != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("key_format_info", str);
            hashMap.put("key_decoder_capability", str2);
            hashMap.put("key_download", str3);
            hashMap.put("key_predownload", str4);
            hashMap.put("key_decode_ability", str5);
            com.tencent.mobileqq.inject.v.c(appRuntime.getCurrentUin(), "video_codec_format_h264", hashMap);
        }
    }
}
