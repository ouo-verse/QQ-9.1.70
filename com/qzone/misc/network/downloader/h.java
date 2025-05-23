package com.qzone.misc.network.downloader;

import android.text.TextUtils;
import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public class h extends IPConfigStrategy implements QzoneConfig.QzoneConfigChangeListener {

    /* renamed from: d, reason: collision with root package name */
    private ReadWriteLock f48410d = new ReentrantReadWriteLock();

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f48411e = new HashMap();

    public h() {
        initConfig();
        QzoneConfig.getInstance().addListener(this);
    }

    private void addWnsConfig() {
        if (QzoneConfig.enableDirectIpQZoneConfig()) {
            addConfigItem(this.f48411e, "PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IP);
            addConfigItem(this.f48411e, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_MASTER_IP);
            addConfigItem(this.f48411e, QzoneConfig.MAIN_KEY_PHOTO_AB_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IP_A);
            addConfigItem(this.f48411e, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_MASTER_IP_A);
            addConfigItem(this.f48411e, QzoneConfig.MAIN_KEY_PHOTO_AB_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IP_B);
            addConfigItem(this.f48411e, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_MASTER_IP_B);
            addConfigItem(this.f48411e, QzoneConfig.MAIN_KEY_VIDEO_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IP_VIDEO);
            addConfigItem(this.f48411e, QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_DOWNLOAD_EXTRA_DIRECT_IP_VIDEO);
            addSpecifyItem(this.f48411e, "PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_OPTIMUMIP_QZVV_IP_VIDEO, QzoneConfig.QZVV_IP_VIDEO_HOST, "qzvv.video.qq.com");
            addSpecifyItem(this.f48411e, "PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_OPTIMUMIP_QZPB_IP_VIDEO, QzoneConfig.QZPB_IP_VIDEO_HOST, QzoneConfig.SECONDARY_DOWNLOAD_OPTIMUMIP_QZPB_IP_VIDEO);
        }
    }

    private void initConfig() {
        this.f48411e.clear();
        addWnsConfig();
        super.setConfig(this.f48411e);
    }

    @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
    public void onConfigChange() {
        if (QLog.isColorLevel()) {
            QLog.d("QzoneIPStracyConfig", 2, "QzoneIPStracyConfig receive change");
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
