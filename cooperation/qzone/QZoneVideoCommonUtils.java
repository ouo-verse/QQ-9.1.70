package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import com.tencent.util.AbiUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.PerfTracer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneVideoCommonUtils {
    public static final String RECORD_LOCAL_BLACK_LIST = "GN9000L|ASUS_T00F|H30-T00";
    public static final String REFER_GIF = "refer_gif";
    public static final String REFER_SHORT_VIDEO_FOR_VIDEO_COVER = "cover_mall_record_video";
    public static final String REFER_UPLOAD_VIDEO_FOR_H5 = "ref_h5_record_video";
    public static final long STORAGE_LIMIT = 62914560;
    private static final String TAG = "QZoneVideoCommonUtils";
    public static final String TRIM_HW_LOCAL_BLACK_LIST = "GT-N7100|";
    public static final String TRIM_LOCAL_BLACK_LIST = "M032|ASUS_T00F";
    private static int mCpuFamily = -1;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class VideoSupport {
        private boolean mAvailable;
        private boolean mGoLocal;
        private boolean mShowTip;
        private String mTip;
        public static final VideoSupport Available = new VideoSupport(true, HardCodeUtil.qqStr(R.string.scj), false, false);
        public static final VideoSupport OrderSetBanned = new VideoSupport(false, "CPU\u6307\u4ee4\u96c6\u4e0d\u652f\u6301", false, true);
        public static final VideoSupport BlackListBanned = new VideoSupport(false, HardCodeUtil.qqStr(R.string.f172593sc4), false, true);
        public static final VideoSupport HardwareLimited = new VideoSupport(false, HardCodeUtil.qqStr(R.string.sbf), false, true);
        public static final VideoSupport OSVersionBanned = new VideoSupport(false, HardCodeUtil.qqStr(R.string.sbn), false, true);
        public static final VideoSupport NoExternalBanned = new VideoSupport(false, HardCodeUtil.qqStr(R.string.sbr), true, true);
        public static final VideoSupport ExternalSpaceBanned = new VideoSupport(false, HardCodeUtil.qqStr(R.string.f172592sc3), true, true);
        public static final VideoSupport CodecFeatureBanned = new VideoSupport(false, HardCodeUtil.qqStr(R.string.f172588sb1), false, true);
        public static final VideoSupport LoadSoFail = new VideoSupport(false, HardCodeUtil.qqStr(R.string.sdf), true, true);

        VideoSupport(boolean z16, String str, boolean z17, boolean z18) {
            this.mAvailable = z16;
            this.mTip = str;
            this.mShowTip = z17;
            this.mGoLocal = z18;
        }

        public String getTip() {
            return this.mTip;
        }

        public boolean isAvailable() {
            return this.mAvailable;
        }

        public boolean isGoLocal() {
            return this.mGoLocal;
        }

        public boolean isShowTip() {
            return this.mShowTip;
        }

        public String toString() {
            return "VideoSupport{mAvailable=" + this.mAvailable + ", mTip='" + this.mTip + "', mShowTip=" + this.mShowTip + ", mGoLocal=" + this.mGoLocal + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface onForwardVideoActivityFailedListener {
        void onFail(Activity activity, String str);
    }

    public static void forwardInstallAndStartUpOtherActivity(long j3, Activity activity, String str, onForwardVideoActivityFailedListener onforwardvideoactivityfailedlistener, Bundle bundle) {
        String str2;
        PerfTracer.traceStart(PerfTracer.VIDEO_COMPONENT_PRE_LAUNCH);
        if (activity == null) {
            QLog.w(TAG, 2, "forwardInstallAndStartUpVideoActivity activity is null");
            return;
        }
        VideoSupport recordSupport = getRecordSupport();
        VideoSupport trimSupport = getTrimSupport();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "support record=" + recordSupport.isAvailable() + ", support trim=" + trimSupport.isAvailable());
        }
        if (!recordSupport.isAvailable() && !trimSupport.isAvailable()) {
            if (recordSupport.isShowTip()) {
                str2 = recordSupport.getTip();
            } else {
                str2 = null;
            }
            if (str2 == null || str2.length() == 0) {
                str2 = activity.getString(R.string.gpg);
            }
            if (onforwardvideoactivityfailedlistener != null) {
                onforwardvideoactivityfailedlistener.onFail(activity, str2);
            }
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "qzone video is not supported, recordSupport tips=" + recordSupport.getTip() + ",trimSupport tips=" + trimSupport.getTip() + ",show tips=" + str2);
                return;
            }
            return;
        }
        installVideoActivityForOther(j3, activity, false, false, str, bundle);
        PerfTracer.traceEnd(PerfTracer.VIDEO_COMPONENT_PRE_LAUNCH);
    }

    public static void forwardInstallAndStartUpVideoActivity(long j3, Activity activity, String str, onForwardVideoActivityFailedListener onforwardvideoactivityfailedlistener) {
        String str2;
        PerfTracer.traceStart(PerfTracer.VIDEO_COMPONENT_PRE_LAUNCH);
        if (activity == null) {
            QLog.w(TAG, 2, "forwardInstallAndStartUpVideoActivity activity is null");
            return;
        }
        VideoSupport recordSupport = getRecordSupport();
        VideoSupport trimSupport = getTrimSupport();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "support record=" + recordSupport.isAvailable() + ", support trim=" + trimSupport.isAvailable());
        }
        if (!recordSupport.isAvailable() && !trimSupport.isAvailable()) {
            if (recordSupport.isShowTip()) {
                str2 = recordSupport.getTip();
            } else {
                str2 = null;
            }
            if (str2 == null || str2.length() == 0) {
                str2 = activity.getString(R.string.gpg);
            }
            if (onforwardvideoactivityfailedlistener != null) {
                onforwardvideoactivityfailedlistener.onFail(activity, str2);
            }
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "qzone video is not supported, recordSupport tips=" + recordSupport.getTip() + ",trimSupport tips=" + trimSupport.getTip() + ",show tips=" + str2);
                return;
            }
            return;
        }
        installVideoActivity(j3, activity, recordSupport.isAvailable(), trimSupport.isAvailable(), str);
        PerfTracer.traceEnd(PerfTracer.VIDEO_COMPONENT_PRE_LAUNCH);
    }

    private static void getCpuFamily() {
        String str = Build.CPU_ABI;
        if (str.contains(AbiUtil.ARM)) {
            mCpuFamily = 1;
            return;
        }
        if (str.contains(ResourceAttributes.HostArchValues.X86)) {
            mCpuFamily = 2;
        } else if (str.contains("mips")) {
            mCpuFamily = 3;
        } else {
            mCpuFamily = 0;
        }
    }

    public static long getCpuFrequency() {
        return ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getCpuMaxFreq() / 1024;
    }

    private static long getFreeSpace() {
        try {
            return CacheManager.getSDCardRemain();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "Get Free Space Failed", e16);
            return 0L;
        }
    }

    public static VideoSupport getRecordSupport() {
        int i3;
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_SUPPORT_RECORD, -1) == 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getRecordSupport() severBlackList");
            }
            return VideoSupport.BlackListBanned;
        }
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_NEED_LOCAL_BLACK_LIST, 1);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Build.Model=" + DeviceInfoMonitor.getModel());
        }
        if (config > 0 && RECORD_LOCAL_BLACK_LIST.contains(DeviceInfoMonitor.getModel())) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getRecordSupport() localBlackList");
            }
            return VideoSupport.BlackListBanned;
        }
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_IGNORE_LOCAL_JUDGE, -1) == 1) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getRecordSupport() severWhiteList");
            }
        } else {
            if (mCpuFamily < 0) {
                getCpuFamily();
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getRecordSupport() mCpuFamily=" + mCpuFamily + ", CPU_ABI=" + Build.CPU_ABI);
            }
            int config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_SUPPORTED_CPU_FAMILY, 2);
            int i16 = mCpuFamily;
            if (i16 >= 0) {
                i3 = 1 << i16;
            } else {
                i3 = 1;
            }
            if ((i3 & config2) == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getRecordSupport() serverCpuFamily=" + config2 + " mCpuFamily=" + mCpuFamily);
                }
                return VideoSupport.OrderSetBanned;
            }
            if (!((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(0, 1)) {
                return VideoSupport.HardwareLimited;
            }
        }
        int config3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_MIN_SDK, 21);
        int i17 = Build.VERSION.SDK_INT;
        if (i17 < config3) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getRecordSupport() localSdkVersion=" + i17 + " serverSdkVersion=" + config3);
            }
            return VideoSupport.OSVersionBanned;
        }
        if (!CacheManager.isExternalAvailable()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getRecordSupport() sdcard !mounted");
            }
            return VideoSupport.NoExternalBanned;
        }
        long freeSpace = getFreeSpace();
        if (freeSpace < 62914560) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getRecordSupport() sdCardFreeSpace=" + freeSpace + " STORAGE_LIMIT=62914560");
            }
            return VideoSupport.ExternalSpaceBanned;
        }
        if (!((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "CaptureUtil.supportCapture is false");
            }
            return VideoSupport.OSVersionBanned;
        }
        return VideoSupport.Available;
    }

    public static VideoSupport getTrimHWSupport() {
        return ((IQZoneVideoCommonUtilsProxy) QRoute.api(IQZoneVideoCommonUtilsProxy.class)).getTrimHWSupport();
    }

    public static VideoSupport getTrimSupport() {
        VideoSupport trimHWSupport = getTrimHWSupport();
        if (trimHWSupport.isAvailable()) {
            return trimHWSupport;
        }
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_SUPPORT_TRIM, -1) == 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTrimSupport() severBlackList");
            }
            return VideoSupport.BlackListBanned;
        }
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_NEED_LOCAL_BLACK_LIST, 1);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Build.Model=" + DeviceInfoMonitor.getModel());
        }
        if (config > 0 && TRIM_LOCAL_BLACK_LIST.contains(DeviceInfoMonitor.getModel())) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTrimSupport() localBlackList");
            }
            return VideoSupport.BlackListBanned;
        }
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_IGNORE_LOCAL_JUDGE, -1) == 1) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTrimSupport() severWhiteList");
            }
        } else {
            if (mCpuFamily < 0) {
                getCpuFamily();
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTrimSupport() mCpuFamily=" + mCpuFamily);
            }
            int config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_SUPPORTED_CPU_FAMILY, 2);
            int i3 = mCpuFamily;
            if (i3 < 0) {
                i3 = 0;
            }
            if (((1 << i3) & config2) == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getTrimSupport() serverCpuFamily=" + config2 + " mCpuFamily=" + mCpuFamily);
                }
                return VideoSupport.OrderSetBanned;
            }
            if (!((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(0, 1)) {
                return VideoSupport.HardwareLimited;
            }
        }
        int config3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_MIN_SDK, 14);
        int i16 = Build.VERSION.SDK_INT;
        if (i16 < config3) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTrimSupport() localSdkVersion=" + i16 + " serverSdkVersion=" + config3);
            }
            return VideoSupport.OSVersionBanned;
        }
        if (!CacheManager.isExternalAvailable()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTrimSupport() sdcard !mounted");
            }
            return VideoSupport.NoExternalBanned;
        }
        long freeSpace = getFreeSpace();
        if (freeSpace < 62914560) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTrimSupport() sdCardFreeSpace=" + freeSpace + " STORAGE_LIMIT=62914560");
            }
            return VideoSupport.ExternalSpaceBanned;
        }
        return VideoSupport.Available;
    }

    public static void gotoRecordPreview(Activity activity, int i3, String str, long j3, Bundle bundle) {
        ((IQZoneVideoCommonUtilsProxy) QRoute.api(IQZoneVideoCommonUtilsProxy.class)).gotoRecordPreview(activity, i3, str, j3, bundle);
    }

    public static void installVideoActivity(long j3, Activity activity, boolean z16, boolean z17, String str) {
        ((IQZoneVideoCommonUtilsProxy) QRoute.api(IQZoneVideoCommonUtilsProxy.class)).installVideoActivity(j3, activity, z16, z17, str);
    }

    public static void installVideoActivityForOther(long j3, Activity activity, boolean z16, boolean z17, String str, Bundle bundle) {
        ((IQZoneVideoCommonUtilsProxy) QRoute.api(IQZoneVideoCommonUtilsProxy.class)).installVideoActivityForOther(j3, activity, z16, z17, str, bundle);
    }

    public static void installVideoActivity(long j3, Activity activity, boolean z16, boolean z17, String str, boolean z18, boolean z19, String str2, boolean z26, String str3, String str4, Intent intent) {
        ((IQZoneVideoCommonUtilsProxy) QRoute.api(IQZoneVideoCommonUtilsProxy.class)).installVideoActivity(j3, activity, z16, z17, str, z18, z19, str2, z26, str3, str4, intent);
    }

    public static void installVideoActivity(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, String str2, String str3, Intent intent) {
        ((IQZoneVideoCommonUtilsProxy) QRoute.api(IQZoneVideoCommonUtilsProxy.class)).installVideoActivity(getRecordSupport().isAvailable(), getTrimSupport().isAvailable(), activity, str, z16, z17, z18, z19, z26, z27, str2, str3, intent);
    }
}
