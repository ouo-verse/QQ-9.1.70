package cooperation.qzone.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes28.dex */
public class gifCoderWnsConfig {
    public static final int DEVICE_LEVEL_HIGH = 3;
    public static final int DEVICE_LEVEL_LOW = 1;
    public static final int DEVICE_LEVEL_MIDDLE = 2;
    public static final int lowerDeviceGifSize = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_CREATE_GIF_LOW_DEVICE_SIZE, 720);
    public static final int middleDeviceGifSize = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_CREATE_GIF_MIDDLE_DEVICE_SIZE, 720);
    public static final int highDeviceGifSize = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_CREATE_GIF_HIGH_DEVICE_SIZE, 720);
    public static final int DEFAULT_DELAY = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_DELAY, 200);
    public static final int DEFAULT_GIF_SIZE_LIMIT = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_SIZE_LIMIT, 64);
    public static final int DEFAULT_GIF_MAX_DELAY = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_MAX_SPEED, 20);
    public static final int DEFAULT_GIF_MIN_MULTIPLE_DELAY = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_MIN_MULTIPLE_SPEED, 3);
    private static int generateGifBlackList = -1;

    public static int getCurrentDeviceGifSize() {
        int currentDeviceLevel = getCurrentDeviceLevel();
        if (currentDeviceLevel == 1) {
            return lowerDeviceGifSize;
        }
        if (currentDeviceLevel == 2) {
            return middleDeviceGifSize;
        }
        if (currentDeviceLevel == 3) {
            return highDeviceGifSize;
        }
        return 720;
    }

    public static int getCurrentDeviceLevel() {
        if (((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(2, 2)) {
            return 3;
        }
        if (((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(1, 1)) {
            return 2;
        }
        return 1;
    }

    public static boolean isQzoneGenerateGifBlackList() {
        int i3 = generateGifBlackList;
        if (i3 >= 0) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        for (String str : QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_GENERATE_GIF_BLACK_LIST, QzoneConfig.DefaultValue.DEFAULT_GENERATE_GIF_BLACK_LIST).split(",")) {
            if (DeviceInfoMonitor.getModel().equalsIgnoreCase(str)) {
                generateGifBlackList = 1;
                return true;
            }
        }
        generateGifBlackList = 0;
        return false;
    }
}
