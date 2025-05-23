package com.tencent.mobileqq.intervideo.now.DownloadEngine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: h, reason: collision with root package name */
    public static c f238295h = new c();

    /* renamed from: a, reason: collision with root package name */
    private Downloader f238296a;

    /* renamed from: b, reason: collision with root package name */
    private DownloadTaskListenerBridge f238297b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, com.tencent.mobileqq.intervideo.now.DownloadEngine.a> f238298c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f238299d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f238300e = 0;

    /* renamed from: f, reason: collision with root package name */
    Map<String, f52.a> f238301f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private b f238302g = new a();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements b {
        a() {
        }

        @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.b
        public void a(DownloaderTask downloaderTask) {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskCompleted url=%s filePath=%s", downloaderTask.getUrl(), downloaderTask.getSavePath()));
            if (c.this.f238296a != null) {
                c.this.f238296a.deleteTask(downloaderTask, false);
            }
            if (c.this.f238298c != null && c.this.f238298c.containsKey(downloaderTask.getUrl()) && c.this.f238298c.get(downloaderTask.getUrl()) != null) {
                ((com.tencent.mobileqq.intervideo.now.DownloadEngine.a) c.this.f238298c.get(downloaderTask.getUrl())).onDownloadComplete();
            }
            c.this.k(downloaderTask.getUrl());
        }

        @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.b
        public void b(DownloaderTask downloaderTask) {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskPending url=%s filePath=%s", downloaderTask.getUrl(), downloaderTask.getSaveDir()));
        }

        @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.b
        public void c(DownloaderTask downloaderTask) {
            QLog.e("DownloadManager_Now_for_qq", 1, String.format("onTaskFailed url=%s failCode=%s failInfo=%s", downloaderTask.getUrl(), Integer.valueOf(downloaderTask.getFailCode()), downloaderTask.getFailInfo()));
            if (c.this.f238296a != null) {
                c.this.f238296a.deleteTask(downloaderTask, false);
            }
            if (c.this.f238298c != null && c.this.f238298c.containsKey(downloaderTask.getUrl()) && c.this.f238298c.get(downloaderTask.getUrl()) != null) {
                ((com.tencent.mobileqq.intervideo.now.DownloadEngine.a) c.this.f238298c.get(downloaderTask.getUrl())).onDownloadFailed(downloaderTask.getFailCode(), downloaderTask.getFailCode(), "failed");
            }
            c.this.k(downloaderTask.getUrl());
        }

        @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.b
        public void d(DownloaderTask downloaderTask) {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskStarted url=%s filePath=%s", downloaderTask.getUrl(), downloaderTask.getSaveDir()));
        }

        @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.b
        public void e(DownloaderTask downloaderTask) {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskReceived url=%s percent=%s", downloaderTask.getUrl(), Integer.valueOf(downloaderTask.getPercentage())));
            if (c.this.f238298c == null || !c.this.f238298c.containsKey(downloaderTask.getUrl()) || c.this.f238298c.get(downloaderTask.getUrl()) == null) {
                return;
            }
            ((com.tencent.mobileqq.intervideo.now.DownloadEngine.a) c.this.f238298c.get(downloaderTask.getUrl())).onDownloadProgress(downloaderTask.getReceivedLength(), downloaderTask.getTotalLength(), downloaderTask.getPercentage());
        }

        @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.b
        public void f(DownloaderTask downloaderTask) {
            QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskDetected url=%s filePath=%s", downloaderTask.getUrl(), downloaderTask.getSaveDir()));
        }
    }

    private void f(f52.a aVar) {
        DownloaderTask createNewTask = this.f238296a.createNewTask(aVar.f397852b, aVar.f397858h, aVar.f397859i, this.f238297b);
        createNewTask.setCategory(DownloaderTaskCategory.Cate_CustomMass1);
        createNewTask.setAppScene(aVar.f397854d);
        if (!TextUtils.isEmpty(aVar.f397855e)) {
            createNewTask.setApkId(aVar.f397855e);
        }
        createNewTask.setNotUseTempFile();
        aVar.c(createNewTask);
    }

    private DownloaderTask g(String str) {
        List<DownloaderTask> allTasks = this.f238296a.getAllTasks();
        if (!TextUtils.isEmpty(str) && allTasks != null) {
            for (DownloaderTask downloaderTask : allTasks) {
                if (downloaderTask.getUrl().equals(str)) {
                    QLog.i("DownloadManager_Now_for_qq", 4, "isHalleyTaskAlreadyExist:YES");
                    return downloaderTask;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        com.tencent.qphone.base.util.QLog.d("DownloadManager_Now_for_qq", 1, java.lang.String.format("removeNowDownloadTask next task url=%s", r0.f397852b));
        m(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(String str) {
        QLog.d("DownloadManager_Now_for_qq", 1, String.format("removeNowDownloadTask taskUrl=%s", str));
        this.f238301f.remove(str);
        if (this.f238301f.size() > 0) {
            Iterator<Map.Entry<String, f52.a>> it = this.f238301f.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f52.a value = it.next().getValue();
                if (value != null) {
                    break;
                }
            }
        }
    }

    private void l(Context context) {
        this.f238296a.setProgressInterval(1000);
        this.f238296a.setTaskNumForCategory(DownloaderTaskCategory.Cate_CustomMass1, 3);
        this.f238296a.enableUserAction(true);
        QQBeaconReport.start();
    }

    public void d(String str, com.tencent.mobileqq.intervideo.now.DownloadEngine.a aVar) {
        if (this.f238298c == null) {
            this.f238298c = new HashMap<>();
        }
        this.f238298c.put(str, aVar);
    }

    public synchronized void e(f52.a aVar) {
        QLog.d("DownloadManager_Now_for_qq", 1, String.format("addNowDownloadTask taskUrl=%s waitListSize=%s", aVar.f397852b, Integer.valueOf(this.f238301f.size())));
        if (this.f238301f.size() == 0) {
            this.f238301f.put(aVar.f397852b, aVar);
            m(aVar);
        } else {
            this.f238301f.put(aVar.f397852b, aVar);
        }
    }

    public void h(Context context) {
        if (this.f238299d) {
            return;
        }
        this.f238299d = true;
        this.f238300e = 0;
        this.f238298c = new HashMap<>();
        HalleyAgent.init(context, "1", "now_for_qq");
        this.f238296a = HalleyAgent.getDownloader();
        l(context);
        this.f238297b = new DownloadTaskListenerBridge(this.f238302g);
    }

    public void i(String str) {
        HashMap<String, com.tencent.mobileqq.intervideo.now.DownloadEngine.a> hashMap = this.f238298c;
        if (hashMap != null) {
            hashMap.remove(str);
        }
    }

    public void j(String str, boolean z16) {
        List<DownloaderTask> allTasks = this.f238296a.getAllTasks();
        if (TextUtils.isEmpty(str) || allTasks == null) {
            return;
        }
        for (DownloaderTask downloaderTask : allTasks) {
            if (downloaderTask.getUrl().equals(str)) {
                QLog.i("DownloadManager_Now_for_qq", 2, "removeDownloadTask---delete unactive halley task, Id:" + downloaderTask.getId());
                this.f238296a.deleteTask(downloaderTask, z16);
                return;
            }
        }
    }

    public void m(f52.a aVar) {
        DownloaderTask g16 = g(aVar.f397852b);
        try {
            String str = aVar.f397852b;
            if (TextUtils.isEmpty(str)) {
                QLog.i("DownloadManager_Now_for_qq", 4, "startDownload, wurl:" + str + "wrong status or parammter");
                HashMap<String, com.tencent.mobileqq.intervideo.now.DownloadEngine.a> hashMap = this.f238298c;
                if (hashMap == null || !hashMap.containsKey(str)) {
                    return;
                }
                this.f238298c.get(str).onDownloadFailed(-1000, -1, "url is invalid");
                return;
            }
            if (g16 != null && str.equals(g16.getUrl())) {
                aVar.c(g16);
                DownloaderTaskStatus status = g16.getStatus();
                QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----hstatus:" + status);
                if (status == DownloaderTaskStatus.COMPLETE) {
                    HashMap<String, com.tencent.mobileqq.intervideo.now.DownloadEngine.a> hashMap2 = this.f238298c;
                    if (hashMap2 != null && hashMap2.containsKey(str)) {
                        this.f238298c.get(str).onDownloadComplete();
                    }
                    j(g16.getUrl(), false);
                    return;
                }
                if (status == DownloaderTaskStatus.DOWNLOADING) {
                    QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----Task is already Downloading!");
                    return;
                } else {
                    QLog.i("DownloadManager_Now_for_qq", 4, "startDownload----resume halley task");
                    g16.resume();
                    return;
                }
            }
            QLog.i("DownloadManager_Now_for_qq", 4, "startDownload: url is changed, thread = " + Thread.currentThread().getId() + "," + str + "path = " + aVar.f397859i);
            f(aVar);
            this.f238296a.addNewTask(aVar.b());
            QLog.i("DownloadManager_Now_for_qq", 4, "mHellyDownloader.addNewTask");
        } catch (Exception e16) {
            QLog.i("DownloadManager_Now_for_qq", 4, "startDownload---exception happend:", e16);
            int i3 = this.f238300e;
            if (i3 < 3) {
                this.f238300e = i3 + 1;
                m(aVar);
            }
        }
    }

    public void n() {
        DownloadTaskListenerBridge downloadTaskListenerBridge = this.f238297b;
        if (downloadTaskListenerBridge != null) {
            downloadTaskListenerBridge.b();
            this.f238297b = null;
        }
        HashMap<String, com.tencent.mobileqq.intervideo.now.DownloadEngine.a> hashMap = this.f238298c;
        if (hashMap != null) {
            hashMap.clear();
            this.f238298c = null;
        }
        this.f238296a = null;
        this.f238299d = false;
        this.f238300e = 0;
    }
}
