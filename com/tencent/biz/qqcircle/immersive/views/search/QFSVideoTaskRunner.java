package com.tencent.biz.qqcircle.immersive.views.search;

import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import ua0.j;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSVideoTaskRunner implements Runnable {

    /* renamed from: h, reason: collision with root package name */
    private static WeakReference<QFSVideoTaskRunner> f91060h;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f91061d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentLinkedQueue<QFSVideoTask> f91062e = new ConcurrentLinkedQueue<>();

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f91063f;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static abstract class QFSVideoTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public final String f91064d;

        /* renamed from: e, reason: collision with root package name */
        public long f91065e;

        /* renamed from: f, reason: collision with root package name */
        public long f91066f;

        /* renamed from: h, reason: collision with root package name */
        public long f91067h;

        /* renamed from: i, reason: collision with root package name */
        public int f91068i;

        /* renamed from: m, reason: collision with root package name */
        public String f91069m = "";

        /* JADX INFO: Access modifiers changed from: protected */
        public QFSVideoTask(String str) {
            this.f91064d = str;
        }

        public boolean e() {
            if (this.f91068i == 1) {
                return true;
            }
            return false;
        }

        void f() {
            j.i(this);
        }

        void g(String str) {
            this.f91068i = -1;
            if (str == null) {
                str = "";
            }
            this.f91069m = str;
        }

        void h() {
            this.f91068i = 1;
        }
    }

    public static QFSVideoTaskRunner e() {
        QFSVideoTaskRunner qFSVideoTaskRunner;
        WeakReference<QFSVideoTaskRunner> weakReference = f91060h;
        if (weakReference != null && (qFSVideoTaskRunner = weakReference.get()) != null) {
            return qFSVideoTaskRunner;
        }
        QFSVideoTaskRunner qFSVideoTaskRunner2 = new QFSVideoTaskRunner();
        f91060h = new WeakReference<>(qFSVideoTaskRunner2);
        return qFSVideoTaskRunner2;
    }

    public void a(QFSVideoTask qFSVideoTask) {
        qFSVideoTask.f91065e = System.currentTimeMillis();
        this.f91062e.offer(qFSVideoTask);
        if (this.f91061d.compareAndSet(false, true)) {
            RFWThreadManager.getInstance().execOnAsyncDisplayThread(this);
        }
    }

    public void b(boolean z16, QFSVideoTask qFSVideoTask) {
        if (z16) {
            qFSVideoTask.run();
        } else {
            a(qFSVideoTask);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            if (this.f91062e.isEmpty()) {
                break;
            }
            if (this.f91063f) {
                this.f91062e.clear();
                break;
            }
            QFSVideoTask poll = this.f91062e.poll();
            if (poll != null) {
                try {
                    poll.f91066f = System.currentTimeMillis();
                    poll.run();
                    poll.f91067h = System.currentTimeMillis();
                    poll.h();
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
        this.f91061d.set(false);
    }
}
