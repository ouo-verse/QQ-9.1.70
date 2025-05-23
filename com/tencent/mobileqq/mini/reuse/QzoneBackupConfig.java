package com.tencent.mobileqq.mini.reuse;

import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
class QzoneBackupConfig extends IPConfigStrategy implements QzoneConfig.QzoneConfigChangeListener {
    private static final String TAG = "QzoneIPStracyConfig";
    private Map<String, String> mConfigs = new HashMap();

    public QzoneBackupConfig() {
        initConfig();
        setDefaultIsp(2);
        QzoneConfig.getInstance().addListener(this);
    }

    private void addWnsConfig() {
        if (QzoneConfig.enableDirectIpQZoneConfig()) {
            addConfigItem(this.mConfigs, "PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_BACKUP_IP);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_PHOTO_AB_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_BACKUP_IP_A);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_A);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_PHOTO_AB_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_BACKUP_IP_B);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_B);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_VIDEO_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_BACKUP_IP_VIDEO);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_VIDEO);
        }
    }

    private void initConfig() {
        this.mConfigs.clear();
        addWnsConfig();
        super.setConfig(this.mConfigs);
    }

    @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
    public void onConfigChange() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "QzoneBackupConfig receive change");
        }
        initConfig();
    }

    private void addConfigItem(Map<String, String> map, String str, String str2) {
        if (map == null || str == null || str2 == null) {
            return;
        }
        map.put(str + "||" + str2, QzoneConfig.getInstance().getConfig(str, str2));
    }
}
