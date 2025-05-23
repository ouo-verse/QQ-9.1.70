package com.qzone.misc.network.downloader;

import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends IPConfigStrategy implements QzoneConfig.QzoneConfigChangeListener {

    /* renamed from: d, reason: collision with root package name */
    private Map<String, String> f48403d = new HashMap();

    public d() {
        initConfig();
        setDefaultIsp(2);
        QzoneConfig.getInstance().addListener(this);
    }

    private void addWnsConfig() {
        if (QzoneConfig.enableDirectIpQZoneConfig()) {
            addConfigItem(this.f48403d, "PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_BACKUP_IP);
            addConfigItem(this.f48403d, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP);
            addConfigItem(this.f48403d, QzoneConfig.MAIN_KEY_PHOTO_AB_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_BACKUP_IP_A);
            addConfigItem(this.f48403d, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_A);
            addConfigItem(this.f48403d, QzoneConfig.MAIN_KEY_PHOTO_AB_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_BACKUP_IP_B);
            addConfigItem(this.f48403d, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_B);
            addConfigItem(this.f48403d, QzoneConfig.MAIN_KEY_VIDEO_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_BACKUP_IP_VIDEO);
            addConfigItem(this.f48403d, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_BACKUP_IP_VIDEO);
            addConfigItem(this.f48403d, "PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IPV4);
            addConfigItem(this.f48403d, "PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_BACKUP_IPV4);
        }
    }

    private void initConfig() {
        this.f48403d.clear();
        addWnsConfig();
        super.setConfig(this.f48403d);
    }

    @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
    public void onConfigChange() {
        if (QLog.isColorLevel()) {
            QLog.d("QzoneIPStracyConfig", 2, "QzoneBackupConfig receive change");
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
