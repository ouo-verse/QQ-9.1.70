package com.tencent.mobileqq.mini.apkg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApkgConfigManager implements Manager {
    public static final String KEY_BASELIB_LAST_URL = "lastUrl";
    public static final String KEY_BASELIB_LOCAL_URL = "downloadUrl";
    public static final String KEY_BASELIB_LOCAL_VERSION = "version";
    public static final String KEY_BASELIB_MIN_UPDATE_TIME = "baselib_min_update_time";
    public static final String KEY_BASELIB_UPDATE_QUA = "baselib_update_qua";
    private static final String TAG = "ApkgConfigManager";
    private static BaseLibInfo baseLibInfo;
    private QQAppInterface mApp;
    private ApkgConfigHolder mConfig;

    public ApkgConfigManager(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ApkgConfigManager init");
        }
        this.mApp = qQAppInterface;
        this.mConfig = ApkgConfigHolder.readConfig(qQAppInterface);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
