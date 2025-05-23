package cooperation.qzone.networkedmodule;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneModuleCompat {
    private static final int IN_BLACK_LIST = 1;
    private static final int NOT_INIT = -1;
    private static final int NOT_IN_BLACK_LIST = 0;
    private static final String TAG = "QzoneModuleCompat";
    private static int sIsInBlackList = -1;

    public static synchronized boolean isDeviceInBlackList() {
        synchronized (QzoneModuleCompat.class) {
            int i3 = sIsInBlackList;
            if (i3 != -1) {
                return i3 == 1;
            }
            String str = "";
            String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_ADDITIONAL_BLACK_LIST, "");
            if (!TextUtils.isEmpty(config)) {
                str = TextUtils.isEmpty("") ? config : "," + config;
            }
            if (TextUtils.isEmpty(str)) {
                sIsInBlackList = 0;
                return false;
            }
            try {
                String[] split = str.split(",");
                String lowerCase = DeviceInfoMonitor.getModel().toLowerCase();
                String lowerCase2 = Build.MANUFACTURER.toLowerCase();
                QLog.i(TAG, 1, "Device info -- model: " + lowerCase + ", manufacturer: " + lowerCase2 + ", platform: " + System.getProperty("ro.board.platform"));
                int length = split.length;
                for (int i16 = 0; i16 < length; i16++) {
                    String str2 = split[i16];
                    if (!str2.contains(lowerCase) && !str2.equals(lowerCase2)) {
                    }
                    sIsInBlackList = 1;
                    return true;
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "catch an exception:", th5);
            }
            sIsInBlackList = 0;
            return false;
        }
    }
}
