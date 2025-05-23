package com.yolo.esports.download.cb;

import android.text.TextUtils;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.utils.l;
import com.yolo.esports.download.common.DownloadInfo;
import com.yolo.esports.download.common.HalleyDownloaderProxy;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b implements DownloaderTaskListener {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f390012d;

    b() {
    }

    public static b b() {
        if (f390012d == null) {
            synchronized (b.class) {
                if (f390012d == null) {
                    f390012d = new b();
                }
            }
        }
        return f390012d;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DownloadInfo c(DownloaderTask downloaderTask) {
        String str;
        Throwable th5;
        try {
            str = (String) downloaderTask.getTag();
        } catch (Throwable th6) {
            str = "";
            th5 = th6;
        }
        try {
            l.i("InnerDownloadListener", "<getDownloadInfoFromHalleyTask>\u4eceTag\u83b7\u53d6\u5230ticket:" + str);
        } catch (Throwable th7) {
            th5 = th7;
            l.e("InnerDownloadListener", "<getDownloadInfoFromHalleyTask>\u4eceTag\u83b7\u53d6ticket\u5931\u8d25\uff1a" + th5.getMessage());
            if (TextUtils.isEmpty(str)) {
            }
            l.i("InnerDownloadListener", "<getDownloadInfoFromHalleyTask>TaskSpeedLimit: un support,receivedLength:" + downloaderTask.getReceivedLength() + ",totalLength" + downloaderTask.getTotalLength() + ", url:" + downloaderTask.getUrl());
            return HalleyDownloaderProxy.h().g(str);
        }
        if (TextUtils.isEmpty(str)) {
            str = DownloadInfo.q(downloaderTask.getUrl());
            l.i("InnerDownloadListener", "<getDownloadInfoFromHalleyTask>\u4eceURL\u83b7\u53d6\u5230ticket:" + str);
        }
        l.i("InnerDownloadListener", "<getDownloadInfoFromHalleyTask>TaskSpeedLimit: un support,receivedLength:" + downloaderTask.getReceivedLength() + ",totalLength" + downloaderTask.getTotalLength() + ", url:" + downloaderTask.getUrl());
        return HalleyDownloaderProxy.h().g(str);
    }

    private void d(DownloadInfo downloadInfo, DownloaderTask downloaderTask) {
        downloadInfo.F = downloaderTask.getReceivedLength();
        downloadInfo.G = downloaderTask.getTotalLength();
        downloadInfo.f390017i = downloaderTask.getSavePath();
        downloadInfo.H = downloaderTask.getFailCode();
        downloadInfo.I = downloaderTask.getFailInfo();
        downloadInfo.S = downloaderTask.getAverageSpeed();
        downloadInfo.T = downloaderTask.getRealTimeSpeed();
        if (downloadInfo.M == 2) {
            if (System.currentTimeMillis() - downloadInfo.Q > 1000) {
                HalleyDownloaderProxy.h().q(downloadInfo);
                return;
            } else {
                HalleyDownloaderProxy.h().r(downloadInfo);
                return;
            }
        }
        HalleyDownloaderProxy.h().q(downloadInfo);
    }

    public void a(DownloadInfo downloadInfo) {
        TaskCallbackCenter.f().l(downloadInfo.s(), downloadInfo);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskCompletedSubloop(DownloaderTask downloaderTask) {
        DownloadInfo c16 = c(downloaderTask);
        l.i("InnerDownloadListener", "<onTaskCompletedSubloop>info:" + c16);
        if (c16 == null) {
            l.e("InnerDownloadListener", "<onTaskCompletedSubloop>task is null");
            return;
        }
        c16.M = 4;
        d(c16, downloaderTask);
        a(c16);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskDetectedSubloop(DownloaderTask downloaderTask) {
        DownloadInfo c16 = c(downloaderTask);
        if (c16 == null) {
            QLog.e("InnerDownloadListener", 1, "<onTaskDetectedSubloop>task is null");
            return;
        }
        c16.M = 1;
        d(c16, downloaderTask);
        TaskCallbackCenter.f().l(c16.s(), c16);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskFailedSubloop(DownloaderTask downloaderTask) {
        DownloadInfo c16 = c(downloaderTask);
        l.i("InnerDownloadListener", "<onTaskFailedSubloop>info:" + c16);
        if (c16 == null) {
            l.e("InnerDownloadListener", "<onTaskFailedSubloop>task is null");
            return;
        }
        c16.M = 5;
        d(c16, downloaderTask);
        TaskCallbackCenter.f().l(c16.s(), c16);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskPausedSubloop(DownloaderTask downloaderTask) {
        DownloadInfo c16 = c(downloaderTask);
        l.i("InnerDownloadListener", "<onTaskPausedSubloop>info:" + c16);
        if (c16 == null) {
            l.i("InnerDownloadListener", "<onTaskPausedSubloop>task is null");
            return;
        }
        c16.M = 3;
        d(c16, downloaderTask);
        TaskCallbackCenter.f().l(c16.s(), c16);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskReceivedSubloop(DownloaderTask downloaderTask) {
        DownloadInfo c16 = c(downloaderTask);
        if (c16 == null) {
            QLog.e("InnerDownloadListener", 1, "<onTaskReceivedSubloop>task is null");
            return;
        }
        c16.M = 2;
        d(c16, downloaderTask);
        TaskCallbackCenter.f().h(c16.s(), c16);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskStartedSubloop(DownloaderTask downloaderTask) {
        int i3;
        DownloadInfo c16 = c(downloaderTask);
        QLog.i("InnerDownloadListener", 4, "<onTaskStartedSubloop>info:" + c16);
        if (c16 != null && ((i3 = c16.M) == 0 || i3 == 6)) {
            TaskCallbackCenter.f().j(c16.s(), c16);
        }
        if (c16 == null) {
            QLog.e("InnerDownloadListener", 1, "<onTaskStartedSubloop>task is null");
            return;
        }
        c16.M = 2;
        d(c16, downloaderTask);
        TaskCallbackCenter.f().l(c16.s(), c16);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskCompletedMainloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskDetectedMainloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskFailedMainloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskPausedMainloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskPendingMainloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskReceivedMainloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskStartedMainloop(DownloaderTask downloaderTask) {
    }
}
