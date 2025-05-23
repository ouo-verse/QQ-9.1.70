package com.tencent.gamecenter.wadl.sdk.downloader.task;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskStatus;
import com.tencent.gamecenter.wadl.sdk.downloader.manager.TaskManager;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private f f107472a;

    /* renamed from: b, reason: collision with root package name */
    private volatile DownloaderTaskStatus f107473b = DownloaderTaskStatus.NONE;

    /* renamed from: c, reason: collision with root package name */
    private Vector<DownloaderTaskListener> f107474c = new Vector<>();

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f107475d = false;

    /* renamed from: e, reason: collision with root package name */
    private LinkedBlockingQueue<b> f107476e = new LinkedBlockingQueue<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f107477a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f107478b;

        static {
            int[] iArr = new int[b.values().length];
            f107478b = iArr;
            try {
                iArr[b.INFORM_PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f107478b[b.INFORM_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f107478b[b.INFORM_DETECTED_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f107478b[b.INFORM_RECEIVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f107478b[b.INFORM_PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f107478b[b.INFORM_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f107478b[b.INFORM_SUCCEED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f107478b[b.INFORM_DELETED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[DownloaderTaskStatus.values().length];
            f107477a = iArr2;
            try {
                iArr2[DownloaderTaskStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f107477a[DownloaderTaskStatus.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f107477a[DownloaderTaskStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f107477a[DownloaderTaskStatus.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f107477a[DownloaderTaskStatus.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f107477a[DownloaderTaskStatus.PAUSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f107477a[DownloaderTaskStatus.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public enum b {
        INFORM_PENDING,
        INFORM_STARTED,
        INFORM_DETECTED_SIZE,
        INFORM_RECEIVED,
        INFORM_PAUSED,
        INFORM_FAILED,
        INFORM_SUCCEED,
        INFORM_DELETED
    }

    public d(f fVar) {
        this.f107472a = fVar;
    }

    public static b a(DownloaderTaskStatus downloaderTaskStatus) {
        switch (a.f107477a[downloaderTaskStatus.ordinal()]) {
            case 1:
                return b.INFORM_PENDING;
            case 2:
                return b.INFORM_STARTED;
            case 3:
                return b.INFORM_RECEIVED;
            case 4:
                return b.INFORM_SUCCEED;
            case 5:
                return b.INFORM_FAILED;
            case 6:
                return b.INFORM_PAUSED;
            case 7:
                return b.INFORM_DELETED;
            default:
                return null;
        }
    }

    private void e() {
        TaskManager.getInstance().onTaskDetectedSubloop(this.f107472a);
        synchronized (this.f107474c) {
            Iterator<DownloaderTaskListener> it = this.f107474c.iterator();
            while (it.hasNext()) {
                DownloaderTaskListener next = it.next();
                if (next != null) {
                    next.onTaskDetectedSubloop(this.f107472a);
                }
            }
        }
    }

    private void f() {
        TaskManager.getInstance().onTaskFailedSubloop(this.f107472a);
        synchronized (this.f107474c) {
            Iterator<DownloaderTaskListener> it = this.f107474c.iterator();
            while (it.hasNext()) {
                DownloaderTaskListener next = it.next();
                if (next != null) {
                    next.onTaskFailedSubloop(this.f107472a);
                }
            }
        }
    }

    private void g() {
        TaskManager.getInstance().onTaskPausedSubloop(this.f107472a);
        synchronized (this.f107474c) {
            Iterator<DownloaderTaskListener> it = this.f107474c.iterator();
            while (it.hasNext()) {
                DownloaderTaskListener next = it.next();
                if (next != null) {
                    next.onTaskPausedSubloop(this.f107472a);
                }
            }
        }
    }

    private void i() {
        TaskManager.getInstance().onTaskReceivedSubloop(this.f107472a);
        synchronized (this.f107474c) {
            Iterator<DownloaderTaskListener> it = this.f107474c.iterator();
            while (it.hasNext()) {
                DownloaderTaskListener next = it.next();
                if (next != null) {
                    next.onTaskReceivedSubloop(this.f107472a);
                }
            }
        }
    }

    private void j() {
        TaskManager.getInstance().onTaskStartedSubloop(this.f107472a);
        synchronized (this.f107474c) {
            Iterator<DownloaderTaskListener> it = this.f107474c.iterator();
            while (it.hasNext()) {
                DownloaderTaskListener next = it.next();
                if (next != null) {
                    next.onTaskStartedSubloop(this.f107472a);
                }
            }
        }
    }

    private void k() {
        synchronized (this.f107474c) {
            Iterator<DownloaderTaskListener> it = this.f107474c.iterator();
            while (it.hasNext()) {
                DownloaderTaskListener next = it.next();
                if (next != null) {
                    next.onTaskCompletedSubloop(this.f107472a);
                }
            }
        }
        TaskManager.getInstance().onTaskCompletedSubloop(this.f107472a);
    }

    public DownloaderTaskStatus b() {
        return this.f107473b;
    }

    public boolean c() {
        return this.f107475d;
    }

    public void d() {
        b take;
        this.f107475d = true;
        while (true) {
            try {
                take = this.f107476e.take();
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            if (c(take)) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-StatusInformer", "loopInform finish on command:" + take);
                this.f107475d = false;
                return;
            }
        }
    }

    public void l() {
        synchronized (this.f107474c) {
            this.f107474c.clear();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean c(b bVar) {
        switch (a.f107478b[bVar.ordinal()]) {
            case 1:
                h();
                return false;
            case 2:
                j();
                return false;
            case 3:
                e();
                return false;
            case 4:
                i();
                return false;
            case 5:
                g();
                return true;
            case 6:
                f();
                return true;
            case 7:
                k();
                return true;
            case 8:
                return true;
            default:
                return false;
        }
    }

    public synchronized void a() {
        this.f107476e.clear();
    }

    public void b(DownloaderTaskListener downloaderTaskListener) {
        if (downloaderTaskListener == null) {
            return;
        }
        try {
            synchronized (this.f107474c) {
                if (this.f107474c.contains(downloaderTaskListener)) {
                    this.f107474c.remove(downloaderTaskListener);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(DownloaderTaskListener downloaderTaskListener) {
        if (downloaderTaskListener == null) {
            return;
        }
        try {
            synchronized (this.f107474c) {
                if (!this.f107474c.contains(downloaderTaskListener)) {
                    this.f107474c.add(downloaderTaskListener);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void b(DownloaderTaskStatus downloaderTaskStatus) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-StatusInformer", "updateTaskStatus:" + downloaderTaskStatus.name());
        if ((this.f107473b == DownloaderTaskStatus.COMPLETE || this.f107473b == DownloaderTaskStatus.FAILED || this.f107473b == DownloaderTaskStatus.PAUSED || this.f107473b == DownloaderTaskStatus.DELETED) && downloaderTaskStatus != DownloaderTaskStatus.PENDING) {
            return;
        }
        this.f107473b = downloaderTaskStatus;
        a(a(downloaderTaskStatus));
    }

    private void b(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            this.f107476e.put(bVar);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            b(bVar);
        }
    }

    private void h() {
    }
}
