package cooperation.qzone.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;

/* loaded from: classes28.dex */
public class PhotoDanmakuUtil {
    private static final String TAG = "PhotoDanmakuUtil";
    private static PhotoDanmakuUtil instance;
    private long phoneMemory;
    private static final String mPhotoDanmakuBlackList = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_DANMAKU_BLACK_LIST, "");
    private static final int cpuLevelLimit = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_DANMAKU_CPU_LEVEL, 1);
    private static final int memoryLevelLimit = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_DANMAKU_MEMORY_LEVEL, 1);
    private volatile String g_photoDanmakuBlacklist = null;
    private volatile boolean enableP2VFunc = false;

    public PhotoDanmakuUtil() {
        this.phoneMemory = -1L;
        if (this.phoneMemory == -1) {
            this.phoneMemory = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getTotalMem() / 1024;
        }
    }

    public static PhotoDanmakuUtil getInstance() {
        if (instance == null) {
            synchronized (PhotoDanmakuUtil.class) {
                if (instance == null) {
                    instance = new PhotoDanmakuUtil();
                }
            }
        }
        return instance;
    }

    private boolean isBuildModelInList(String str) {
        try {
            String model = DeviceInfoMonitor.getModel();
            if (model != null && model.length() != 0) {
                if (QZLog.isColorLevel()) {
                    QZLog.d(TAG, 2, "buildModel is '" + model + "'");
                }
                if (str != null && str.length() != 0) {
                    if (("," + str + ",").contains("," + model + ",")) {
                        QZLog.i(TAG, 1, "\u547d\u4e2d\u7981\u6b62\u5927\u56fe\u6d6e\u5c42\u7b56\u7565");
                        return true;
                    }
                }
                return false;
            }
            QZLog.i(TAG, 1, "buildModel is empty, hide PhotoDanmaku .\u547d\u4e2d\u7981\u6b62\u5927\u56fe\u6d6e\u5c42\u7b56\u7565");
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public boolean isEnablePhotoDanmakuFunc() {
        String str = mPhotoDanmakuBlackList;
        if (str != null && !str.equals(this.g_photoDanmakuBlacklist)) {
            this.enableP2VFunc = !isBuildModelInList(str);
            this.g_photoDanmakuBlacklist = str;
        }
        if (this.enableP2VFunc && ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(memoryLevelLimit, cpuLevelLimit)) {
            return true;
        }
        return false;
    }
}
