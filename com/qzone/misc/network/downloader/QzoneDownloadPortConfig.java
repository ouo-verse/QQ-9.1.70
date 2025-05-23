package com.qzone.misc.network.downloader;

import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes39.dex */
public class QzoneDownloadPortConfig extends PortConfigStrategy implements QzoneConfig.QzoneConfigChangeListener {
    public QzoneDownloadPortConfig() {
        if (QLog.isDevelopLevel()) {
            QLog.d("QzoneDownloadPortConfig", 4, "initi {'a[0-9].qpic.cn':[{'port': '80'},{'port': '14000'}],'m.qpic.cn':[{'port': '80'},{'port': '14000'}]}");
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.misc.network.downloader.QzoneDownloadPortConfig.1
            @Override // java.lang.Runnable
            public void run() {
                QzoneDownloadPortConfig.this.b();
            }
        });
        QzoneConfig.getInstance().addListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String config = QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_ACCESS_PORT_LIST);
        if (config == null) {
            config = "{'a[0-9].qpic.cn':[{'port': '80'},{'port': '14000'}],'m.qpic.cn':[{'port': '80'},{'port': '14000'}]}";
        }
        setConfig(config);
    }

    private void c() {
        String config = QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_ACCESS_PORT_LIST);
        if (config != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QzoneDownloadPortConfig", 4, config);
            }
            setConfig(config);
        }
    }

    @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
    public void onConfigChange() {
        if (QLog.isColorLevel()) {
            QLog.d("QzoneIPStracyConfig", 2, "QzoneDownloadPortConfig receive change");
        }
        c();
    }
}
