package cooperation.qzone;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

/* loaded from: classes28.dex */
public class QZonePublishConfig {
    private static final String ENABLE = "1";
    private static final String TAG = "QZonePublishConfig";

    public static boolean canUseShaishaiPublish() {
        return false;
    }

    public static boolean canUseTemplatePublish() {
        String config = QzoneConfig.getInstance().getConfig("qzone_publish_note", "publish_template_switch", "1");
        if (!TextUtils.equals(config, "1")) {
            QLog.d(TAG, 1, "canUseTemplatePublish wnsSwitch  :" + config);
            return false;
        }
        boolean serverSwitch = getServerSwitch(1073741824);
        QLog.d(TAG, 1, "canUseTemplateFromServer :" + serverSwitch);
        return serverSwitch;
    }

    private static boolean getServerSwitch(int i3) {
        if ((i3 & LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, QZoneHelper.getLongAccountUin())) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isUseQCirclePublish() {
        return true;
    }
}
