package com.qzone.misc.network.downloader;

import com.tencent.component.network.downloader.strategy.ConfigKeepAliveStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends ConfigKeepAliveStrategy implements QzoneConfig.QzoneConfigChangeListener {
    public e() {
        a();
        QzoneConfig.getInstance().addListener(this);
    }

    private void a() {
        setConfig(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_DOWNLOAD, QzoneConfig.SECONDARY_DOWNLOAD_KP_DOMAIN_LIST, QzoneConfig.DefaultValue.DOWNLOAD_KP_DOMAIN_LIST));
    }

    @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
    public void onConfigChange() {
        if (QLog.isColorLevel()) {
            QLog.d("ConfigKeepAliveStrategy", 2, "KeepAlive receive change");
        }
        a();
    }
}
