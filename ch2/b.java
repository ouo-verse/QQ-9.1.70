package ch2;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
class b implements com.tencent.mobileqq.qroute.module.c {
    @Override // com.tencent.mobileqq.qroute.module.c
    public void onInstallBegin(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandPluginPreloadManager", 4, "pluginInstall: onInstallBegin()", str);
        }
    }

    @Override // com.tencent.mobileqq.qroute.module.c
    public void onInstallDownloadProgress(String str, int i3, int i16) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandPluginPreloadManager", 4, "pluginInstall: onInstallDownloadProgress()", str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.qroute.module.c
    public void onInstallError(String str, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandPluginPreloadManager", 4, "pluginInstall: onInstallError()", str, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.qroute.module.c
    public void onInstallFinish(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandPluginPreloadManager", 4, "pluginInstall: onInstallFinish()", str);
        }
    }
}
