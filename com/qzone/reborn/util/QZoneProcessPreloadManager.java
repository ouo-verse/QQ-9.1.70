package com.qzone.reborn.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.Iterator;

/* loaded from: classes37.dex */
public enum QZoneProcessPreloadManager {
    INSTANCE;

    private static final String TAG = "QZoneProcessPreloadManager";
    private long lastPreloadPeakTime;

    public static QZoneProcessPreloadManager g() {
        return INSTANCE;
    }

    public void preloadPeak() {
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_IS_CAN_PRELOAD_PEAK, 1) == 1) {
            if (System.currentTimeMillis() - this.lastPreloadPeakTime <= QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PRELOAD_PEAK_DURATION, 180000L)) {
                return;
            }
            this.lastPreloadPeakTime = System.currentTimeMillis();
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.PreLoadThread).post(new Runnable() { // from class: com.qzone.reborn.util.QZoneProcessPreloadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        BaseApplication baseApplication = BaseApplication.context;
                        if (QZoneProcessPreloadManager.this.isPeakAlive(baseApplication)) {
                            return;
                        }
                        Intent intent = new Intent(baseApplication, (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
                        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 2);
                        baseApplication.startService(intent);
                    } catch (Exception e16) {
                        if (QZLog.isColorLevel()) {
                            QZLog.e(QZoneProcessPreloadManager.TAG, 1, "preload peak fail ", e16);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPeakAlive(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
            while (it.hasNext()) {
                if ("com.tencent.mobileqq:peak".equals(it.next().processName)) {
                    return true;
                }
            }
        } catch (Exception e16) {
            QZLog.e(TAG, 1, "get Process Info fail ", e16);
        }
        return false;
    }
}
