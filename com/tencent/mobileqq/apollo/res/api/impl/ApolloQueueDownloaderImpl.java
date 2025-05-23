package com.tencent.mobileqq.apollo.res.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloQueueDownloader;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApolloQueueDownloaderImpl implements INetInfoHandler, IApolloQueueDownloader {
    public static final String TAG = "[cmshow]ApolloQueue_Downloader";
    private DownloaderFactory.b config;
    AtomicInteger downloadLimitCount = new AtomicInteger(1);
    private LinkedList<g> downloadQueue;

    private g getNextTask() {
        synchronized (this.downloadQueue) {
            if (!this.downloadQueue.isEmpty()) {
                Iterator<g> it = this.downloadQueue.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    if (!next.k()) {
                        next.l();
                        return next;
                    }
                }
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.apollo.res.api.IApolloQueueDownloader, com.tencent.mobileqq.vip.h
    public int cancelTask(boolean z16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cancelTask stopAll=" + z16 + ",key=" + str);
        }
        synchronized (this.downloadQueue) {
            if (!this.downloadQueue.isEmpty()) {
                if (z16) {
                    Iterator<g> it = this.downloadQueue.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        next.c(true);
                        next.d();
                    }
                    this.downloadQueue.clear();
                } else {
                    if (str == null || TextUtils.isEmpty(str)) {
                        return -1;
                    }
                    Iterator<g> it5 = this.downloadQueue.iterator();
                    ArrayList arrayList = new ArrayList();
                    while (it5.hasNext()) {
                        g next2 = it5.next();
                        if (str.equals(next2.f313004c)) {
                            if (!next2.k()) {
                                it5.remove();
                                arrayList.add(next2);
                            } else {
                                next2.c(true);
                                next2.d();
                            }
                        } else if (next2.j() && !next2.k()) {
                            it5.remove();
                            arrayList.add(next2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.downloadQueue.removeAll(arrayList);
                    }
                }
            }
            return 0;
        }
    }

    synchronized void doTask() {
        synchronized (this.downloadQueue) {
            Iterator<g> it = this.downloadQueue.iterator();
            while (true) {
                boolean z16 = true;
                boolean z17 = false;
                if (!it.hasNext()) {
                    break;
                }
                g next = it.next();
                if (next.A > 0) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.k() || currentTimeMillis <= next.f313028z + next.A) {
                        z16 = false;
                    }
                    z17 = z16;
                }
                if (next.j() || z17) {
                    it.remove();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "remove task[" + next.f313004c + "], isCancal=" + next.j() + ", timeOut=" + z17);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doTask | downloadLimitCount=" + this.downloadLimitCount.get() + ",maxDownloadCount=3,downloadQueue size=" + this.downloadQueue.size());
        }
        while (this.downloadLimitCount.get() <= 3) {
            final g nextTask = getNextTask();
            if (nextTask == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doTask | run() null");
                }
                return;
            } else {
                ThreadManagerV2.postDownLoadTask(new Runnable() { // from class: com.tencent.mobileqq.apollo.res.api.impl.ApolloQueueDownloaderImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.d(ApolloQueueDownloaderImpl.TAG, 2, "doTask | run() downloadLimitCount=" + ApolloQueueDownloaderImpl.this.downloadLimitCount.get() + ",task=" + nextTask);
                        }
                        g gVar = nextTask;
                        if (gVar.f313023u && DownloaderFactory.E(gVar.f313004c)) {
                            g gVar2 = nextTask;
                            gVar2.f313006d = -101;
                            gVar2.y(-1);
                            nextTask.n();
                            ApolloQueueDownloaderImpl.this.removeTask(nextTask);
                            ApolloQueueDownloaderImpl.this.downloadLimitCount.addAndGet(-1);
                            ApolloQueueDownloaderImpl.this.doTask();
                            if (QLog.isColorLevel()) {
                                QLog.d(ApolloQueueDownloaderImpl.TAG, 2, "doTask | run() task is limit of failTime, task=" + nextTask);
                                return;
                            }
                            return;
                        }
                        int o16 = DownloaderFactory.o(nextTask, BaseApplicationImpl.getApplication().getRuntime());
                        if (QLog.isColorLevel()) {
                            QLog.d(ApolloQueueDownloaderImpl.TAG, 2, "doTask | run() download task result=" + o16 + ",task=" + nextTask);
                        }
                        ApolloQueueDownloaderImpl.this.removeTask(nextTask);
                        ApolloQueueDownloaderImpl.this.downloadLimitCount.addAndGet(-1);
                        ApolloQueueDownloaderImpl.this.doTask();
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
                    /* JADX WARN: Removed duplicated region for block: B:16:0x0041 A[Catch: Exception -> 0x0053, TryCatch #0 {Exception -> 0x0053, blocks: (B:3:0x0004, B:5:0x000f, B:8:0x0016, B:9:0x0025, B:12:0x004b, B:16:0x0041, B:17:0x0021), top: B:2:0x0004 }] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public String toString() {
                        String str;
                        try {
                            StringBuilder sb5 = new StringBuilder();
                            List<String> list = nextTask.f313009g;
                            if (list != null && list.size() != 0) {
                                str = nextTask.f313009g.get(0);
                                sb5.append(ApolloQueueDownloaderImpl.TAG);
                                sb5.append(" current task:");
                                sb5.append(str);
                                sb5.append(",downloadQueue size:");
                                sb5.append(ApolloQueueDownloaderImpl.this.downloadQueue != null ? 0 : ApolloQueueDownloaderImpl.this.downloadQueue.size());
                                return sb5.toString();
                            }
                            str = nextTask.f313004c;
                            sb5.append(ApolloQueueDownloaderImpl.TAG);
                            sb5.append(" current task:");
                            sb5.append(str);
                            sb5.append(",downloadQueue size:");
                            sb5.append(ApolloQueueDownloaderImpl.this.downloadQueue != null ? 0 : ApolloQueueDownloaderImpl.this.downloadQueue.size());
                            return sb5.toString();
                        } catch (Exception e16) {
                            QLog.e(ApolloQueueDownloaderImpl.TAG, 1, e16, new Object[0]);
                            return super.toString();
                        }
                    }
                }, 2, null, false);
                this.downloadLimitCount.addAndGet(1);
            }
        }
    }

    @Override // com.tencent.mobileqq.apollo.res.api.IApolloQueueDownloader, com.tencent.mobileqq.vip.h
    public g getTask(String str) {
        synchronized (this.downloadQueue) {
            if (str != null) {
                if (!this.downloadQueue.isEmpty()) {
                    Iterator<g> it = this.downloadQueue.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (str.equals(next.f313004c)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "getTask | " + str + " task find =" + next);
                            }
                            return next;
                        }
                    }
                }
            }
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "getTask | " + str + " task not find");
            return null;
        }
    }

    @Override // com.tencent.mobileqq.apollo.res.api.IApolloQueueDownloader
    public void init(AppRuntime appRuntime, Object obj) {
        this.downloadQueue = new LinkedList<>();
        if (obj instanceof DownloaderFactory.b) {
            this.config = (DownloaderFactory.b) obj;
        } else {
            this.config = new DownloaderFactory.b();
        }
        if (this.config.f312718a) {
            AppNetConnInfo.registerConnectionChangeReceiver(appRuntime.getApplication(), this);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        LinkedList<g> linkedList = this.downloadQueue;
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "queueDownload network-onNetMobile2None");
        }
        synchronized (this.downloadQueue) {
            Iterator<g> it = this.downloadQueue.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next.i() == 2) {
                    next.p();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "queueDownload network-onNetMobile2Wifi");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "queueDownload network-onNetNone2Mobile");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "queueDownload network-onNetNone2Wifi");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        LinkedList<g> linkedList = this.downloadQueue;
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        synchronized (this.downloadQueue) {
            Iterator<g> it = this.downloadQueue.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next.i() == 2) {
                    next.q();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        LinkedList<g> linkedList = this.downloadQueue;
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "queueDownload network-onNetWifi2None");
        }
        synchronized (this.downloadQueue) {
            Iterator<g> it = this.downloadQueue.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next.i() == 2) {
                    next.r();
                }
            }
        }
    }

    public void removeTask(g gVar) {
        synchronized (this.downloadQueue) {
            if (gVar != null) {
                if (!this.downloadQueue.isEmpty() && this.downloadQueue.contains(gVar)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "removeTask | task=" + gVar);
                    }
                    gVar.d();
                    this.downloadQueue.remove(gVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.apollo.res.api.IApolloQueueDownloader, com.tencent.mobileqq.vip.h
    public void startDownload(g gVar, f fVar, Bundle bundle) {
        if (!DownloaderFactory.e(gVar) || getTask(gVar.f313004c) == gVar) {
            return;
        }
        g task = getTask(gVar.f313004c);
        if (task != null) {
            if (task.f313001a0) {
                gVar.u(fVar);
                gVar.w(bundle);
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime != null) {
                    g.a aVar = gVar.Z;
                    if (aVar.f313030b < 0) {
                        aVar.f313030b = runtime.getLongAccountUin();
                    }
                }
                task.a(gVar);
                return;
            }
            return;
        }
        gVar.u(fVar);
        gVar.w(bundle);
        gVar.Y = 3;
        AppRuntime runtime2 = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime2 != null) {
            g.a aVar2 = gVar.Z;
            if (aVar2.f313030b < 0) {
                aVar2.f313030b = runtime2.getLongAccountUin();
            }
        }
        synchronized (this.downloadQueue) {
            g task2 = getTask(gVar.f313004c);
            if (task2 == null) {
                gVar.f313028z = (int) (System.currentTimeMillis() / 1000);
                if (gVar.f313019q) {
                    this.downloadQueue.addFirst(gVar);
                } else {
                    this.downloadQueue.addLast(gVar);
                }
            } else if (gVar.f313019q && !task2.k() && this.downloadQueue.remove(task2)) {
                this.downloadQueue.addFirst(task2);
            }
        }
        List<String> list = gVar.f313009g;
        String str = (list == null || list.size() == 0) ? null : gVar.f313009g.get(0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startDownload | task=" + gVar.f313004c, ", url:", str);
        }
        doTask();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        LinkedList<g> linkedList = this.downloadQueue;
        if (linkedList != null && linkedList.size() > 0) {
            synchronized (this.downloadQueue) {
                Iterator<g> it = this.downloadQueue.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    sb5.append("key=");
                    sb5.append(next.f313004c);
                    List<String> list = next.f313009g;
                    if (list != null && list.size() > 0) {
                        sb5.append(",size=");
                        sb5.append(next.f313009g.size());
                        sb5.append(JefsClass.INDEX_URL);
                        sb5.append(next.f313009g.get(0));
                    }
                    sb5.append(";");
                }
            }
        }
        return "QueueDownloader task url:" + sb5.toString();
    }

    @Override // com.tencent.mobileqq.apollo.res.api.IApolloQueueDownloader, com.tencent.mobileqq.vip.h
    public void onDestroy() {
        cancelTask(true, null);
    }
}
