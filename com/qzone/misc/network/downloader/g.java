package com.qzone.misc.network.downloader;

import com.tencent.component.network.downloader.Downloader;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public class g implements Downloader.NetworkFlowStatistics {
    @Override // com.tencent.component.network.downloader.Downloader.NetworkFlowStatistics
    public void onDownloadFlow(String str, long j3, long j16) {
        boolean z16 = str == null || str.equalsIgnoreCase("wifi");
        if (QLog.isDevelopLevel()) {
            QLog.d("Traffic", 4, "wifi=" + z16 + ",size=" + j3);
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader.NetworkFlowStatistics
    public void onUploadFlow(String str, long j3, long j16) {
        boolean z16 = str == null || str.equalsIgnoreCase("wifi");
        if (QLog.isDevelopLevel()) {
            QLog.d("Traffic", 4, "wifi=" + z16 + ",size=" + j3);
        }
    }
}
