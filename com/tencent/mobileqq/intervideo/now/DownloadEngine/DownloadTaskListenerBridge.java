package com.tencent.mobileqq.intervideo.now.DownloadEngine;

import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.mobileqq.app.ThreadManager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DownloadTaskListenerBridge implements DownloaderTaskListener {

    /* renamed from: d, reason: collision with root package name */
    private b f238293d;

    public DownloadTaskListenerBridge(b bVar) {
        this.f238293d = bVar;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskCompletedMainloop(DownloaderTask downloaderTask) {
        b bVar = this.f238293d;
        if (bVar != null) {
            bVar.a(downloaderTask);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskDetectedMainloop(DownloaderTask downloaderTask) {
        b bVar = this.f238293d;
        if (bVar != null) {
            bVar.f(downloaderTask);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskFailedMainloop(final DownloaderTask downloaderTask) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.intervideo.now.DownloadEngine.DownloadTaskListenerBridge.1
            @Override // java.lang.Runnable
            public void run() {
                if (DownloadTaskListenerBridge.this.f238293d != null) {
                    DownloadTaskListenerBridge.this.f238293d.c(downloaderTask);
                }
            }
        });
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskPendingMainloop(DownloaderTask downloaderTask) {
        b bVar = this.f238293d;
        if (bVar != null) {
            bVar.b(downloaderTask);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskReceivedMainloop(DownloaderTask downloaderTask) {
        b bVar = this.f238293d;
        if (bVar != null) {
            bVar.e(downloaderTask);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskStartedMainloop(DownloaderTask downloaderTask) {
        b bVar = this.f238293d;
        if (bVar != null) {
            bVar.d(downloaderTask);
        }
    }

    public void b() {
        this.f238293d = null;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskCompletedSubloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskDetectedSubloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskFailedSubloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskPausedMainloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskPausedSubloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskReceivedSubloop(DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public void onTaskStartedSubloop(DownloaderTask downloaderTask) {
    }
}
