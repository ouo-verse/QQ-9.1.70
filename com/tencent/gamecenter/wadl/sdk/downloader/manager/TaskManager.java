package com.tencent.gamecenter.wadl.sdk.downloader.manager;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.gamecenter.wadl.sdk.common.DownloaderException;
import com.tencent.gamecenter.wadl.sdk.common.b.d;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener;
import com.tencent.gamecenter.wadl.sdk.downloader.HistoryTask;
import com.tencent.gamecenter.wadl.sdk.downloader.task.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TaskManager implements com.tencent.gamecenter.wadl.sdk.downloader.task.h.c, DownloaderTaskListener, d {

    /* renamed from: e, reason: collision with root package name */
    private static volatile TaskManager f107406e;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.downloader.task.h.b f107408b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.downloader.task.g.b f107409c;

    /* renamed from: a, reason: collision with root package name */
    private Vector<f> f107407a = new Vector<>();

    /* renamed from: d, reason: collision with root package name */
    private boolean f107410d = false;

    TaskManager() {
        b();
    }

    private void a() {
        if (hasTaskRunning()) {
            this.f107408b.a();
        } else {
            this.f107408b.b();
        }
    }

    private void b() {
        this.f107408b = new com.tencent.gamecenter.wadl.sdk.downloader.task.h.b(this);
        com.tencent.gamecenter.wadl.sdk.common.b.c.a(QDLog.TAG_DOWNLOAD, this);
        this.f107409c = new com.tencent.gamecenter.wadl.sdk.downloader.task.g.b(com.tencent.gamecenter.wadl.sdk.common.a.b());
    }

    public static TaskManager getInstance() {
        if (f107406e == null) {
            synchronized (TaskManager.class) {
                if (f107406e == null) {
                    f107406e = new TaskManager();
                }
            }
        }
        return f107406e;
    }

    public void deleteAllTask(boolean z16) {
        synchronized (this.f107407a) {
            Vector vector = new Vector(this.f107407a);
            Iterator it = vector.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar.isWaiting()) {
                    deleteTask(fVar, z16);
                }
            }
            vector.removeAllElements();
            vector.addAll(this.f107407a);
            Iterator it5 = vector.iterator();
            while (it5.hasNext()) {
                deleteTask((f) it5.next(), z16);
            }
        }
    }

    public void deleteHistoryTask(HistoryTask historyTask, boolean z16) {
        this.f107409c.a(historyTask.getSaveDir(), historyTask.getSaveName());
        if (z16) {
            new f(historyTask.getSaveDir(), historyTask.getSaveName()).k();
        }
    }

    public void deleteTask(DownloaderTask downloaderTask, boolean z16) {
        if (downloaderTask == null) {
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskManager", "delete task:" + downloaderTask.getUrl());
        ((f) downloaderTask).a(z16);
        synchronized (this.f107407a) {
            this.f107407a.remove(downloaderTask);
        }
        a();
        this.f107409c.b(downloaderTask);
    }

    public DownloaderTask findTaskBySaveInfo(String str, String str2) {
        String realSaveName;
        for (DownloaderTask downloaderTask : getAllTasks()) {
            if (str.equalsIgnoreCase(downloaderTask.getSaveDir())) {
                if (((f) downloaderTask).u()) {
                    realSaveName = downloaderTask.getInitSaveName();
                } else {
                    realSaveName = downloaderTask.getRealSaveName();
                }
                if (str2.equalsIgnoreCase(realSaveName)) {
                    return downloaderTask;
                }
            }
        }
        return null;
    }

    public List<DownloaderTask> getAllTasks() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.f107407a) {
            linkedList.addAll(this.f107407a);
        }
        return linkedList;
    }

    public List<HistoryTask> getHistoryTasks() {
        return this.f107409c.d();
    }

    public long getRunningBufferSize() {
        long j3;
        synchronized (this.f107407a) {
            Iterator<f> it = this.f107407a.iterator();
            j3 = 0;
            while (it.hasNext()) {
                f next = it.next();
                if (next.isRunning()) {
                    j3 += next.o();
                }
            }
        }
        return j3;
    }

    public List<DownloaderTask> getRunningTasks() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.f107407a) {
            Iterator<f> it = this.f107407a.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next.isRunning()) {
                    linkedList.add(next);
                }
            }
        }
        return linkedList;
    }

    public int getTaskSize() {
        int size;
        synchronized (this.f107407a) {
            size = this.f107407a.size();
        }
        return size;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x002b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<DownloaderTask> getTasks(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28) {
        LinkedList linkedList = new LinkedList();
        synchronized (this.f107407a) {
            Iterator<f> it = this.f107407a.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next.isEaseTask()) {
                    if (z17) {
                        if (!next.isRunning()) {
                            if (z18) {
                                linkedList.add(next);
                            }
                        } else if (next.isWaiting()) {
                            if (z19) {
                                linkedList.add(next);
                            }
                        } else if (next.isPaused()) {
                            if (z26) {
                                linkedList.add(next);
                            }
                        } else if (next.isFailed()) {
                            if (z27) {
                                linkedList.add(next);
                            }
                        } else if (next.isCompleted() && z28) {
                            linkedList.add(next);
                        }
                    }
                } else if (z16) {
                    if (!next.isRunning()) {
                    }
                }
            }
        }
        return linkedList;
    }

    public boolean hasTaskRunning() {
        synchronized (this.f107407a) {
            Iterator<f> it = this.f107407a.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next.isRunning() || next.isWaiting()) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isBufferCanAdd() {
        if (getRunningBufferSize() < 2097152) {
            return true;
        }
        return false;
    }

    public boolean isBufferFull() {
        if (getRunningBufferSize() > 4194304) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.b.d
    public void onNetworkSwitch(int i3, String str) {
        List<DownloaderTask> runningTasks = getRunningTasks();
        if (runningTasks != null && runningTasks.size() > 0) {
            Iterator<DownloaderTask> it = runningTasks.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(i3, str);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.h.c
    public boolean onSave() {
        List<DownloaderTask> runningTasks = getRunningTasks();
        int size = runningTasks.size();
        Iterator<DownloaderTask> it = runningTasks.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            f fVar = (f) it.next();
            fVar.a(size);
            if (fVar.onSave()) {
                z16 = true;
            }
        }
        return z16;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskCompletedSubloop(DownloaderTask downloaderTask) {
        a();
        saveHistoryTask(downloaderTask);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskDetectedSubloop(DownloaderTask downloaderTask) {
        saveHistoryTask(downloaderTask);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskFailedSubloop(DownloaderTask downloaderTask) {
        a();
        saveHistoryTask(downloaderTask);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskPausedSubloop(DownloaderTask downloaderTask) {
        a();
        saveHistoryTask(downloaderTask);
    }

    public void onTaskPendingSubloop(DownloaderTask downloaderTask) {
        saveHistoryTask(downloaderTask);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskReceivedSubloop(DownloaderTask downloaderTask) {
        saveHistoryTask(downloaderTask);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskStartedSubloop(DownloaderTask downloaderTask) {
        a();
        saveHistoryTask(downloaderTask);
    }

    public boolean optAddTask(DownloaderTask downloaderTask) {
        boolean z16;
        if (downloaderTask instanceof f) {
            f fVar = (f) downloaderTask;
            synchronized (this) {
                if (g.e(fVar.f107510i)) {
                    fVar.f107510i = "";
                }
                if (fVar.f107510i.contains("../")) {
                    fVar.f107510i = fVar.f107510i.replace("../", "");
                }
                if (!g.e(fVar.f107510i) && findTaskBySaveInfo(fVar.f107509h, fVar.f107510i) == null) {
                    a(fVar);
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            return z16;
        }
        throw new DownloaderException("param task not illegal.");
    }

    public void pauseTasks(boolean z16, boolean z17, boolean z18, boolean z19) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskManager", "pauseTasks...containMass:" + z16 + ",containEase:" + z17 + ",pauseRunning:" + z18 + ",pauseWaiting:" + z19);
        List<DownloaderTask> tasks = getTasks(z16, z17, z18, z19, false, false, false);
        if (tasks != null) {
            LinkedList linkedList = new LinkedList(tasks);
            for (DownloaderTask downloaderTask : tasks) {
                if (downloaderTask.isWaiting()) {
                    downloaderTask.pause();
                    linkedList.remove(downloaderTask);
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((DownloaderTask) it.next()).pause();
            }
        }
    }

    public void resumeTasks(boolean z16, boolean z17, boolean z18, boolean z19) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-TaskManager", "resumeTasks... containMass:" + z16 + ",containEase:" + z17 + ",resumePaused:" + z18 + ",resumeFailed:" + z19);
        List<DownloaderTask> tasks = getTasks(z16, z17, false, false, z18, z19, false);
        if (tasks != null) {
            Iterator<DownloaderTask> it = tasks.iterator();
            while (it.hasNext()) {
                try {
                    it.next().resume();
                } catch (DownloaderException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public void saveHistoryTask(DownloaderTask downloaderTask) {
        if (!this.f107410d) {
            return;
        }
        this.f107409c.a(downloaderTask);
    }

    public void saveHistoryTasks() {
        if (!this.f107410d) {
            return;
        }
        synchronized (this.f107407a) {
            Iterator<f> it = this.f107407a.iterator();
            while (it.hasNext()) {
                this.f107409c.a(it.next());
            }
        }
    }

    public void setSaveHistoryTasks(boolean z16) {
        this.f107410d = z16;
    }

    public void wakeSaveService() {
        com.tencent.gamecenter.wadl.sdk.downloader.task.h.b bVar = this.f107408b;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void a(f fVar) {
        synchronized (this.f107407a) {
            this.f107407a.add(fVar);
        }
    }
}
