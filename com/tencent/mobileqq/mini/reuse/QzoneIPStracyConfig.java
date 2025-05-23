package com.tencent.mobileqq.mini.reuse;

import android.text.TextUtils;
import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes33.dex */
class QzoneIPStracyConfig extends IPConfigStrategy implements QzoneConfig.QzoneConfigChangeListener {
    private static final String TAG = "QzoneIPStracyConfig";
    private static final String VIDEO_HOST_QZPB = "qzpb.qq.com";
    private static final String VIDEO_HOST_QZVV = "qzvv.video.qq.com";
    private String extraJsonAIPConfig;
    private String extraJsonBIPConfig;
    private String extraJsonIPConfig;
    private String jsonAIPConfig;
    private String jsonBIPConfig;
    private String jsonIPConfig;
    private ReadWriteLock RW_Lock = new ReentrantReadWriteLock();
    private Map<String, String> mConfigs = new HashMap();

    public QzoneIPStracyConfig() {
        initConfig();
        QzoneConfig.getInstance().addListener(this);
    }

    private void addWnsConfig() {
        if (QzoneConfig.enableDirectIpQZoneConfig()) {
            addConfigItem(this.mConfigs, "PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IP);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_MASTER_IP);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_PHOTO_AB_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IP_A);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_MASTER_IP_A);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_PHOTO_AB_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IP_B);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_MASTER_IP_B);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_VIDEO_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IP_VIDEO);
            addConfigItem(this.mConfigs, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_DIRECT_IP_VIDEO);
            addSpecifyItem(this.mConfigs, "PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_OPTIMUMIP_QZVV_IP_VIDEO, QzoneConfig.QZVV_IP_VIDEO_HOST, VIDEO_HOST_QZVV);
            addSpecifyItem(this.mConfigs, "PhotoSvrList", "qzpb.qq.com", QzoneConfig.QZPB_IP_VIDEO_HOST, "qzpb.qq.com");
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
            QLog.d(TAG, 2, "QzoneIPStracyConfig receive change");
        }
        initConfig();
    }

    private void addConfigItem(Map<String, String> map, String str, String str2) {
        if (map == null || str == null || str2 == null) {
            return;
        }
        map.put(str + "||" + str2, QzoneConfig.getInstance().getConfig(str, str2));
    }

    private void addSpecifyItem(Map<String, String> map, String str, String str2, String str3, String str4) {
        if (map == null || str == null || str2 == null) {
            return;
        }
        String config = QzoneConfig.getInstance().getConfig(str, str3, str4);
        String str5 = str + "||" + str2;
        String config2 = QzoneConfig.getInstance().getConfig(str, str2);
        String replace = (TextUtils.isEmpty(config2) || TextUtils.isEmpty(config)) ? null : config2.replace("ips", config);
        if (TextUtils.isEmpty(replace)) {
            map.put(str5, config2);
        } else {
            map.put(str5, replace);
        }
    }
}
