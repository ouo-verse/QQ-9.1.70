package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.os.Build;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.shortvideo.z;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VideoEnvironment {
    private static final int AVCODEC_FEATURE_NUM = 16;
    public static final int AVCODEC_MD_SUPPORT_AUDIO_SYNC = 5;
    private static final int AVCODEC_MD_SUPPORT_PRE_SEND = 2;
    private static final int AVCODEC_MD_SUPPORT_RT_BEAUTY = 1;
    private static final int AVCODEC_MD_VERSION = 0;
    private static final int NEW_JUDGE_SO_NAME_VERSION_OK = 255;
    private static final int NEW_LOAD_ERR_PARSER = -12;
    private static final int NEW_LOAD_ERR_SO_NAME_NULL = -11;
    private static final int NEW_LOAD_ERR_VERSION = -13;
    public static final String SHORT_VIDEO_CONFIG = "sv_config";
    public static final String TAG = "VideoEnvironment";
    private static final int dymAVCodecVersion = 67;
    private static boolean gAVCodecInitMD = false;
    private static int[] gAVCodecMetadata = new int[16];
    public static String debugDecodeFilePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_ROOT + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo");
    private static final Object mLockLoadStatus = new Object();

    static {
        File file = new File(ShortVideoSoLoad.getShortVideoSoPath(getContext()));
        if (!file.exists()) {
            file.mkdirs();
            LogDownLoad("VideoEnvironment:[static]loadPathFile not exist");
        }
    }

    public static void LogDownLoad(String str) {
        LogDownLoad(TAG, str, null);
    }

    public static boolean checkAndLoadAVCodec() {
        loadAVCodecSo();
        return isShortVideoSoLibLoaded();
    }

    public static boolean checkShortVideoSoReadyToLoad() {
        if (ShortVideoSoLoad.getShortVideoSoLoadStatus() == 0) {
            return true;
        }
        String shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(getContext());
        String[] strArr = new String[1];
        if (judgeCurrentSpVideoNameValidate(strArr) != 255) {
            return false;
        }
        return new File(shortVideoSoPath + strArr[0]).exists();
    }

    private static native void getAVCodecLibMetadata(int[] iArr);

    public static boolean getAVCodecSupportFeature(int i3) {
        if (getAVCodecSupportFeatureKind(i3) > 0) {
            return true;
        }
        return false;
    }

    private static int getAVCodecSupportFeatureKind(int i3) {
        if (i3 <= 0 && i3 >= 16) {
            return 0;
        }
        try {
            if (!gAVCodecInitMD) {
                getAVCodecLibMetadata(gAVCodecMetadata);
                gAVCodecInitMD = true;
            }
            return gAVCodecMetadata[i3];
        } catch (UnsatisfiedLinkError unused) {
            return 0;
        }
    }

    public static boolean getAVCodecSupportRTBeauty() {
        if (getAVCodecSupportFeatureKind(1) > 0) {
            return true;
        }
        return false;
    }

    public static int getAVCodecVersion() {
        int i3;
        try {
            if (!gAVCodecInitMD) {
                loadAVCodecSo();
                getAVCodecLibMetadata(gAVCodecMetadata);
                gAVCodecInitMD = true;
            }
            i3 = gAVCodecMetadata[0];
        } catch (UnsatisfiedLinkError unused) {
            i3 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getAVCodecVersion: AVCodec_version=" + i3);
        }
        return i3;
    }

    public static Context getContext() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    public static String getShortVideoSoLibName() {
        String[] strArr = new String[1];
        int judgeCurrentSpVideoNameValidate = judgeCurrentSpVideoNameValidate(strArr);
        LogDownLoad("getShortVideoSoLibName: errCode=" + judgeCurrentSpVideoNameValidate + " soNameValue=" + strArr[0]);
        if (judgeCurrentSpVideoNameValidate == 255) {
            return strArr[0];
        }
        return null;
    }

    public static boolean isAvcodecNewVersion() {
        AppRuntime peekAppRuntime;
        z.a c16 = z.c(z.e());
        boolean z16 = true;
        int i3 = 0;
        if (c16.a() == 0) {
            String f16 = c16.f();
            LogDownLoad("getAvcodecSoConfigVersion: currentVersion=" + f16 + " dymAVCodecVersion=67");
            int parseInt = Integer.parseInt(f16);
            if (parseInt < 67) {
                z16 = false;
            }
            i3 = parseInt;
        }
        if (!z16 && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            String account = peekAppRuntime.getAccount();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("avcodecVersion", String.valueOf(i3));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(account, "old_avcodec_info", true, 0L, 0L, hashMap, null);
        }
        return z16;
    }

    public static boolean isBeautySupported() {
        if (isX86Platform()) {
            return false;
        }
        boolean isBeautySupported = AVCoreSystemInfo.isBeautySupported();
        boolean aVCodecSupportRTBeauty = getAVCodecSupportRTBeauty();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isX86Platform: isBeautySupported=" + isBeautySupported + " isSoSupportBeauty=" + aVCodecSupportRTBeauty);
        }
        if (!isBeautySupported || !aVCodecSupportRTBeauty) {
            return false;
        }
        return true;
    }

    public static boolean isShortVideoSoLibLoaded() {
        if (ShortVideoSoLoad.getShortVideoSoLoadStatus() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isX86Platform() {
        return ah.t0();
    }

    private static int judgeCurrentSpVideoNameValidate(String[] strArr) {
        String e16 = z.e();
        LogDownLoad("LoadPathSo: currentSoName=" + e16);
        if (e16.equals("d000_1")) {
            return -11;
        }
        z.a c16 = z.c(e16);
        int a16 = c16.a();
        LogDownLoad("LoadPathSo: CfgParser err=" + a16);
        if (a16 == 0) {
            String f16 = c16.f();
            LogDownLoad("LoadPathSo: currentVersion=" + f16 + " dymAVCodecVersion=67");
            if (Integer.parseInt(f16) >= 67) {
                strArr[0] = e16;
                return 255;
            }
            return -13;
        }
        return -12;
    }

    public static synchronized int loadAVCodecSo() {
        int realDoLoadSo;
        synchronized (VideoEnvironment.class) {
            int shortVideoSoLoadStatus = ShortVideoSoLoad.getShortVideoSoLoadStatus();
            if (shortVideoSoLoadStatus == 0) {
                LogDownLoad("loadAVCodecSo[already loaded], status=" + shortVideoSoLoadStatus);
                return shortVideoSoLoadStatus;
            }
            synchronized (mLockLoadStatus) {
                realDoLoadSo = realDoLoadSo();
                LogDownLoad("loadAVCodecSo[loaded End], load code=" + realDoLoadSo);
            }
            return realDoLoadSo;
        }
    }

    public static boolean needDownloadCurrentServerVersion(int i3) {
        boolean z16;
        if (i3 >= 67) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            LogDownLoad("needDownloadCurrentServerVersion, serverVersion=" + i3 + " dymAVCodecVersion=67");
        }
        return z16;
    }

    private static int realDoLoadSo() {
        String shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(getContext());
        String[] strArr = new String[1];
        int judgeCurrentSpVideoNameValidate = judgeCurrentSpVideoNameValidate(strArr);
        if (judgeCurrentSpVideoNameValidate == 255) {
            String str = shortVideoSoPath + strArr[0];
            LogDownLoad("Before LoadPath so. loadSoPath=" + str + " soNameValue[0]=" + strArr[0]);
            int LoadExtractedShortVideo = ShortVideoSoLoad.LoadExtractedShortVideo(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("After LoadPath so. errCode=");
            sb5.append(LoadExtractedShortVideo);
            LogDownLoad(sb5.toString());
            return LoadExtractedShortVideo;
        }
        LogDownLoad("realDoLoadSo[errCode=" + judgeCurrentSpVideoNameValidate + "]");
        return judgeCurrentSpVideoNameValidate;
    }

    public static boolean supportShortVideoRecordAndPlay() {
        String str = Build.CPU_ABI;
        if (isX86Platform()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "supportShortVideoRecordAndPlay:isX86Platform, don't support, Build.CPU_ABI=" + str);
                return false;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "supportShortVideoRecordAndPlay: support, Build.CPU_ABI=" + str);
            return true;
        }
        return true;
    }

    public static boolean supportSubmitCallback() {
        int aVCodecVersion = getAVCodecVersion();
        boolean aVCodecSupportFeature = getAVCodecSupportFeature(2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "supportSubmitCallback: soVersion =" + aVCodecVersion + ", result = " + aVCodecSupportFeature);
        }
        return aVCodecSupportFeature;
    }

    public static void LogDownLoad(String str, Throwable th5) {
        LogDownLoad(TAG, str, th5);
    }

    public static void LogDownLoad(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, str2, th5);
        }
    }
}
