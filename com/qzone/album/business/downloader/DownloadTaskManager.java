package com.qzone.album.business.downloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DownloadTaskManager implements Handler.Callback {
    private static DownloadTaskManager C;
    private static Object D = new Object();

    /* renamed from: i, reason: collision with root package name */
    private volatile int f42408i;

    /* renamed from: m, reason: collision with root package name */
    private volatile int f42409m;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f42404d = false;

    /* renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList<IDownloadQueueTask> f42406f = new CopyOnWriteArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private b f42407h = new b();

    /* renamed from: e, reason: collision with root package name */
    private Handler f42405e = new Handler(Looper.getMainLooper(), this);

    DownloadTaskManager() {
        this.f42408i = 1;
        this.f42409m = 1;
        this.f42408i = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DOWNLOAD_PIC_QUEUE_MAX_PARALLEL_TASK_COUNT, 1);
        this.f42409m = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DOWNLOAD_VIDEO_QUEUE_MAX_PARALLEL_TASK_COUNT, 1);
    }

    public static DownloadTaskManager i() {
        if (C == null) {
            synchronized (D) {
                if (C == null) {
                    C = new DownloadTaskManager();
                }
            }
        }
        return C;
    }

    private boolean n(IDownloadQueueTask iDownloadQueueTask) {
        return iDownloadQueueTask.getState() == 3 || iDownloadQueueTask.getState() == 4;
    }

    private boolean o(IDownloadQueueTask iDownloadQueueTask) {
        return iDownloadQueueTask.getState() == 1 || iDownloadQueueTask.getState() == 0 || iDownloadQueueTask.getState() == 51;
    }

    private void u() {
        QZLog.i("[PhotoAlbum]downloadPhotoAndVideo", "resetDownloadCount");
        this.f42408i = 1;
        this.f42409m = 1;
        this.f42404d = false;
    }

    private void z(int i3) {
        this.f42405e.sendEmptyMessage(i3);
    }

    public boolean A(IDownloadQueueTask iDownloadQueueTask) {
        if (iDownloadQueueTask != null && this.f42406f.contains(iDownloadQueueTask)) {
            QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "updateTask id:" + iDownloadQueueTask.getTaskId());
            this.f42407h.e(iDownloadQueueTask);
            return true;
        }
        QZLog.w("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "updateTask error");
        return false;
    }

    public boolean b(IDownloadQueueTask iDownloadQueueTask, boolean z16) {
        int i3;
        if (iDownloadQueueTask.getType() == 1) {
            i3 = z16 ? -1 : 1;
            QZLog.i("[PhotoAlbum]downloadPhotoAndVideo", "mDefaultDownloadPicTask:" + this.f42408i + " count:" + i3);
            if (this.f42408i + i3 < 0) {
                return false;
            }
            this.f42408i += i3;
            return true;
        }
        if (iDownloadQueueTask.getType() == 2) {
            i3 = z16 ? -1 : 1;
            QZLog.i("[PhotoAlbum]downloadPhotoAndVideo", "mDefaultDownloadVideoTask:" + this.f42409m + " count:" + i3);
            if (this.f42409m + i3 < 0) {
                return false;
            }
            this.f42409m += i3;
        }
        return true;
    }

    public void d() {
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null) {
                QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "continueAllTask id:" + next.getTaskId() + ", current state:" + next.getState());
                int state = next.getState();
                if (state == 0 || state == 51 || state == 3 || state == 4 || state == 5) {
                    next.onRestore();
                    if (NetworkState.isNetSupport()) {
                        next.setState(0);
                    } else {
                        next.setState(5);
                    }
                    A(next);
                }
            }
        }
    }

    public void e() {
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null && next.getType() != 1) {
                QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "continueAllVideoTask id:" + next.getTaskId() + ", current state:" + next.getState());
                int state = next.getState();
                if (state == 3 || state == 4 || state == 5 || state == 51) {
                    next.onRestore();
                    if (NetworkState.isWifiConn()) {
                        next.setState(0);
                    } else {
                        next.setState(5);
                    }
                    A(next);
                }
            }
        }
    }

    public int f() {
        int i3 = 0;
        if (this.f42406f.isEmpty()) {
            return 0;
        }
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null && o(next)) {
                i3 += next.getRunningCount();
            }
        }
        return i3;
    }

    public int g() {
        int i3 = 0;
        if (this.f42406f.isEmpty()) {
            return 0;
        }
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null && n(next)) {
                i3 += next.getFailCount();
            }
        }
        return i3;
    }

    public int h() {
        int i3 = 0;
        if (this.f42406f.isEmpty()) {
            return 0;
        }
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null && o(next)) {
                i3 += next.getRunningCount();
            }
        }
        QZLog.i("[PhotoAlbum]downloadPhotoAndVideo", "getEveryItemInAllTask count:" + i3);
        return i3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            com.qzone.album.env.common.a.m().U(R.string.gau);
            return false;
        }
        if (i3 != 2) {
            return false;
        }
        com.qzone.album.env.common.a.m().V(l.a(R.string.lrx));
        return false;
    }

    public int j() {
        QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "getRunningTaskCount mTaskList.isEmpty():" + this.f42406f.isEmpty());
        int i3 = 0;
        if (this.f42406f.isEmpty()) {
            return 0;
        }
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null) {
                QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "getRunningTaskCount task.getState():" + next.getState());
                if (next.getState() == 1 || next.getState() == 51 || next.getState() == 0) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public int k() {
        return this.f42406f.size();
    }

    public boolean l() {
        if (this.f42406f.isEmpty()) {
            return false;
        }
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null && next.getState() == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        return this.f42404d;
    }

    public void q() {
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null && next.getType() != 1) {
                QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "pauseAllVideoTask id:" + next.getTaskId() + ", current state:" + next.getState());
                if (next.getState() != 3 && next.getState() != 4 && next.getState() != 5 && next.cancel()) {
                    next.setState(51);
                    this.f42407h.e(next);
                }
            }
        }
    }

    public boolean r(IDownloadQueueTask iDownloadQueueTask) {
        if (iDownloadQueueTask != null && this.f42406f.contains(iDownloadQueueTask)) {
            QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "pauseTask id:" + iDownloadQueueTask.getTaskId());
            if (iDownloadQueueTask.getState() == 3 || iDownloadQueueTask.getState() == 4 || !iDownloadQueueTask.cancel()) {
                return true;
            }
            iDownloadQueueTask.setState(5);
            A(iDownloadQueueTask);
            return true;
        }
        QZLog.w("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "pauseTask error");
        return false;
    }

    public void s() {
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null) {
                if (next.cancel()) {
                    next.setState(6);
                }
                this.f42407h.b(next);
            }
        }
        this.f42406f.clear();
        u();
        z(2);
    }

    public boolean t(IDownloadQueueTask iDownloadQueueTask) {
        if (iDownloadQueueTask != null && this.f42406f.contains(iDownloadQueueTask)) {
            QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "removeTask id:" + iDownloadQueueTask.getTaskId());
            iDownloadQueueTask.cancel();
            this.f42406f.remove(iDownloadQueueTask);
            this.f42407h.b(iDownloadQueueTask);
            return true;
        }
        QZLog.w("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "removeTask error");
        return false;
    }

    public boolean v() {
        if (!this.f42406f.isEmpty()) {
            return false;
        }
        ArrayList<IDownloadQueueTask> c16 = this.f42407h.c();
        this.f42406f.clear();
        this.f42406f.addAll(c16);
        QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "restore total size:" + this.f42406f.size());
        return this.f42406f.size() > 0;
    }

    public void w() {
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null) {
                x(next);
            }
        }
    }

    public boolean y() {
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            final IDownloadQueueTask next = it.next();
            if (next != null && next.getState() == 0) {
                QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "task id:" + next.getTaskId());
                if (b(next, true)) {
                    next.setState(1);
                    com.qzone.album.env.common.a.m().H(new Runnable() { // from class: com.qzone.album.business.downloader.DownloadTaskManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            next.run();
                        }
                    });
                    z16 = true;
                }
            }
        }
        if (this.f42404d && this.f42406f.size() == 0) {
            z(1);
        }
        this.f42404d = j() > 0;
        return z16;
    }

    public boolean a(IDownloadQueueTask iDownloadQueueTask) {
        if (iDownloadQueueTask != null && !this.f42406f.contains(iDownloadQueueTask)) {
            QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "addTask id:" + iDownloadQueueTask.getTaskId());
            iDownloadQueueTask.setTime(System.currentTimeMillis());
            iDownloadQueueTask.setState(0);
            this.f42406f.add(iDownloadQueueTask);
            this.f42407h.d(iDownloadQueueTask);
            return true;
        }
        QZLog.w("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "addTask error");
        return false;
    }

    public boolean c(IDownloadQueueTask iDownloadQueueTask, boolean z16) {
        if (iDownloadQueueTask != null && this.f42406f.contains(iDownloadQueueTask)) {
            QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "completeTask id:" + iDownloadQueueTask.getTaskId() + ", succeed:" + z16 + ", state:" + iDownloadQueueTask.getState());
            b(iDownloadQueueTask, false);
            if (z16) {
                iDownloadQueueTask.setState(2);
                this.f42406f.remove(iDownloadQueueTask);
                this.f42407h.b(iDownloadQueueTask);
                return true;
            }
            if (iDownloadQueueTask.getState() != 5 && iDownloadQueueTask.getState() != 51) {
                iDownloadQueueTask.setState(3);
            }
            A(iDownloadQueueTask);
            return true;
        }
        QZLog.w("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "completeTask error");
        return false;
    }

    public void p() {
        QZLog.d("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", 2, "pauseAllTask");
        Iterator<IDownloadQueueTask> it = this.f42406f.iterator();
        while (it.hasNext()) {
            IDownloadQueueTask next = it.next();
            if (next != null && next.getState() != 3 && next.getState() != 4 && next.cancel()) {
                next.setState(5);
                this.f42407h.e(next);
            }
        }
    }

    public boolean x(IDownloadQueueTask iDownloadQueueTask) {
        if (iDownloadQueueTask != null && this.f42406f.contains(iDownloadQueueTask)) {
            QZLog.i("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "resumeTask id:" + iDownloadQueueTask.getTaskId() + ", current state:" + iDownloadQueueTask.getState());
            int state = iDownloadQueueTask.getState();
            if (state == 0 || state == 1 || state == 3 || state == 4 || state == 5 || state == 51) {
                iDownloadQueueTask.onRestore();
                if (NetworkState.isWifiConn()) {
                    iDownloadQueueTask.setState(0);
                } else {
                    iDownloadQueueTask.setState(5);
                }
                A(iDownloadQueueTask);
            }
            return true;
        }
        QZLog.w("[PhotoAlbum]downloadPhotoAndVideo [DownloadTaskManager]", "resumeTask error");
        return false;
    }
}
