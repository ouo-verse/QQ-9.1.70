package com.tencent.biz.qqcircle.richframework.video.preview;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.qqcircle.richframework.video.preview.QFSVideoCaptureFrameTaskQueue;
import com.tencent.mobileqq.qcircle.api.IQCircleResDrawableApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSVideoCaptureFrameTaskQueue {

    /* renamed from: l, reason: collision with root package name */
    private static volatile Object f92043l = new Object();

    /* renamed from: g, reason: collision with root package name */
    private long f92050g;

    /* renamed from: h, reason: collision with root package name */
    private a f92051h;

    /* renamed from: i, reason: collision with root package name */
    private long f92052i;

    /* renamed from: j, reason: collision with root package name */
    private int f92053j;

    /* renamed from: k, reason: collision with root package name */
    private long f92054k;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f92044a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private volatile List<QFSVideoCaptureFrameTask> f92045b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Integer, Long> f92046c = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private int f92048e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f92049f = 0;

    /* renamed from: d, reason: collision with root package name */
    private IQCircleResDrawableApi f92047d = (IQCircleResDrawableApi) QRoute.api(IQCircleResDrawableApi.class);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class QFSVideoCaptureFrameTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSVideoCaptureFrameTaskQueue> f92055d;

        /* renamed from: e, reason: collision with root package name */
        private int f92056e;

        /* renamed from: f, reason: collision with root package name */
        private long f92057f;

        /* renamed from: h, reason: collision with root package name */
        private int f92058h;

        /* renamed from: i, reason: collision with root package name */
        private int f92059i;

        public QFSVideoCaptureFrameTask(QFSVideoCaptureFrameTaskQueue qFSVideoCaptureFrameTaskQueue) {
            this.f92055d = new WeakReference<>(qFSVideoCaptureFrameTaskQueue);
        }

        public int e() {
            return this.f92056e;
        }

        public QFSVideoCaptureFrameTask f(int i3) {
            this.f92059i = i3;
            return this;
        }

        public QFSVideoCaptureFrameTask g(int i3) {
            this.f92058h = i3;
            return this;
        }

        public QFSVideoCaptureFrameTask h(long j3) {
            this.f92057f = j3;
            return this;
        }

        public void i(int i3) {
            this.f92056e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSVideoCaptureFrameTaskQueue qFSVideoCaptureFrameTaskQueue;
            WeakReference<QFSVideoCaptureFrameTaskQueue> weakReference = this.f92055d;
            if (weakReference == null) {
                qFSVideoCaptureFrameTaskQueue = null;
            } else {
                qFSVideoCaptureFrameTaskQueue = weakReference.get();
            }
            if (qFSVideoCaptureFrameTaskQueue == null) {
                QLog.e("QPP-QFSVideoDecodeFrameTask", 1, "[run] video capture frame task queue should not be null.");
            } else {
                qFSVideoCaptureFrameTaskQueue.q(this.f92057f, this.f92058h, this.f92059i);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void b(Bitmap bitmap);

        int e(long j3, int i3, int i16);
    }

    public QFSVideoCaptureFrameTaskQueue() {
        j();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(int i3, int i16, int i17) {
        QFSVideoCaptureFrameTask qFSVideoCaptureFrameTask;
        if (this.f92045b == null) {
            QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[addCaptureTaskToList] capture task queue should not be null.");
            return false;
        }
        QFSVideoCaptureFrameTask qFSVideoCaptureFrameTask2 = null;
        try {
            qFSVideoCaptureFrameTask = g(i3);
            try {
                if (!this.f92045b.isEmpty()) {
                    qFSVideoCaptureFrameTask2 = this.f92045b.get(this.f92045b.size() - 1);
                }
            } catch (Throwable th5) {
                th = th5;
                QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[addCaptureTaskToQueue] error: ", th);
                if (qFSVideoCaptureFrameTask == null) {
                }
                if (qFSVideoCaptureFrameTask != null) {
                }
                k(qFSVideoCaptureFrameTask);
                return true;
            }
        } catch (Throwable th6) {
            th = th6;
            qFSVideoCaptureFrameTask = null;
        }
        if (qFSVideoCaptureFrameTask == null && qFSVideoCaptureFrameTask == qFSVideoCaptureFrameTask2) {
            return false;
        }
        if (qFSVideoCaptureFrameTask != null) {
            qFSVideoCaptureFrameTask = e(i3, i16, i17);
        } else {
            s(qFSVideoCaptureFrameTask);
        }
        k(qFSVideoCaptureFrameTask);
        return true;
    }

    private String c(int i3) {
        return d() + "_" + i3;
    }

    private String d() {
        return hashCode() + "_" + this.f92053j + "_" + this.f92054k;
    }

    private QFSVideoCaptureFrameTask e(int i3, int i16, int i17) {
        long longValue;
        Long l3 = null;
        if (i16 != 0 && i17 != 0) {
            Map<Integer, Long> map = this.f92046c;
            if (map != null) {
                l3 = map.get(Integer.valueOf(i3));
            }
            if (l3 == null) {
                longValue = 0;
            } else {
                longValue = l3.longValue();
            }
            QFSVideoCaptureFrameTask qFSVideoCaptureFrameTask = new QFSVideoCaptureFrameTask(this);
            qFSVideoCaptureFrameTask.i(i3);
            qFSVideoCaptureFrameTask.h(longValue);
            qFSVideoCaptureFrameTask.g(i16);
            qFSVideoCaptureFrameTask.f(i17);
            return qFSVideoCaptureFrameTask;
        }
        QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[createCaptureFrameTask] current preview size illegal, flow return.");
        return null;
    }

    private void f() {
        if (this.f92045b != null && !this.f92045b.isEmpty()) {
            QFSVideoCaptureFrameTask qFSVideoCaptureFrameTask = this.f92045b.get(this.f92045b.size() - 1);
            s(qFSVideoCaptureFrameTask);
            if (qFSVideoCaptureFrameTask == null) {
                this.f92044a.set(0);
                f();
                QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[doNextCaptureFrame] capture task should not be null, queue size: " + this.f92045b.size());
                return;
            }
            int e16 = qFSVideoCaptureFrameTask.e();
            if (l(e16)) {
                this.f92044a.set(0);
                p(h(e16));
                f();
                QLog.w("QPP-QFSVideoCaptureFrameTaskQueue", 2, "[doNextCaptureFrame] exists capture bitmap, end flow.");
                return;
            }
            Handler serialThreadHandler = RFWThreadManager.getInstance().getSerialThreadHandler();
            if (serialThreadHandler == null) {
                this.f92044a.set(0);
                QLog.w("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[doNextCaptureFrame] serial handler should not be null.");
                return;
            } else {
                serialThreadHandler.removeCallbacksAndMessages(f92043l);
                serialThreadHandler.postAtTime(qFSVideoCaptureFrameTask, f92043l, SystemClock.uptimeMillis());
                this.f92044a.set(1);
                return;
            }
        }
        QLog.w("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[doNextCaptureFrame] capture task queue is empty, end flow.");
        this.f92044a.set(0);
    }

    private QFSVideoCaptureFrameTask g(long j3) {
        if (this.f92045b == null) {
            QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[findCaptureFrameTask] capture task queue should not be null.");
            return null;
        }
        for (QFSVideoCaptureFrameTask qFSVideoCaptureFrameTask : this.f92045b) {
            if (qFSVideoCaptureFrameTask.e() == j3) {
                return qFSVideoCaptureFrameTask;
            }
        }
        return null;
    }

    private Bitmap h(int i3) {
        if (this.f92047d == null) {
            return null;
        }
        return this.f92047d.getBitmapMemory(c(i3));
    }

    private int i() {
        return c.X0("qqcircle", "qqcircle_video_seek_capture_interval", 1000).intValue();
    }

    private void j() {
        this.f92050g = i();
    }

    private void k(QFSVideoCaptureFrameTask qFSVideoCaptureFrameTask) {
        if (this.f92045b == null) {
            QLog.w("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[insertTaskToQueueFirst] capture task queue should not be null. ");
        } else if (qFSVideoCaptureFrameTask == null) {
            QLog.w("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[insertTaskToQueueFirst] task should not be null.");
        } else {
            this.f92045b.add(qFSVideoCaptureFrameTask);
        }
    }

    private boolean l(int i3) {
        Bitmap h16 = h(i3);
        if (h16 != null && !h16.isRecycled()) {
            return true;
        }
        return false;
    }

    private boolean m() {
        if (this.f92044a.get() != 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(int i3, Bitmap bitmap) {
        Map<Integer, Long> map = this.f92046c;
        if (map == null) {
            QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[updateCaptureSuccess] task id map param is null, end flow.");
            return;
        }
        Long l3 = map.get(Integer.valueOf(i3));
        if (l3 == null) {
            QLog.d("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[updateCaptureSuccess] current captureTime is null, task id: " + i3);
            f();
            return;
        }
        z(l3.longValue(), bitmap);
        f();
    }

    private void s(QFSVideoCaptureFrameTask qFSVideoCaptureFrameTask) {
        if (this.f92045b == null) {
            QLog.w("QPP-QFSVideoCaptureFrameTaskQueue", 1, "removeQueueTask capture task queue should not be null.");
            return;
        }
        if (qFSVideoCaptureFrameTask == null) {
            QLog.d("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[removeQueueTask] handle task should not be null.");
            return;
        }
        try {
            this.f92045b.remove(qFSVideoCaptureFrameTask);
        } catch (Throwable th5) {
            QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[removeQueueTask] error: ", th5);
        }
    }

    private void y() {
        if (!m()) {
            return;
        }
        QLog.d("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[tryStartQueueTaskProc] current try start queue process.");
        f();
    }

    private void z(long j3, Bitmap bitmap) {
        if (j3 < 0) {
            QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[updateCaptureResultToMap] current capture time is illegal, update fail.");
            return;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f92047d.putBitmapMemory(c(mb0.a.c(j3, this.f92050g)), bitmap);
            if (j3 == this.f92052i) {
                p(bitmap);
                return;
            }
            return;
        }
        QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[updateCaptureResultToMap] current bitmap is illegal, update fail.");
    }

    public void A(final int i3, final Bitmap bitmap) {
        RFWThreadManager.getUIHandler().postAtTime(new Runnable() { // from class: mb0.d
            @Override // java.lang.Runnable
            public final void run() {
                QFSVideoCaptureFrameTaskQueue.this.n(i3, bitmap);
            }
        }, SystemClock.uptimeMillis());
    }

    public void o(long j3) {
        if (j3 <= 0) {
            QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[loadAllIntervalCaptureBitmap] load duration is illegal, end flow.");
            return;
        }
        long a16 = mb0.a.a(this.f92050g);
        long a17 = mb0.a.a(j3);
        this.f92054k = j3;
        int round = Math.round((float) (a17 / a16));
        QLog.d("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[loadAllIntervalCaptureBitmap] intervalSecond: " + a16 + " | durationSecond: " + a17 + " | count: " + round);
        int a18 = mb0.a.a(this.f92050g);
        int a19 = mb0.a.a(j3);
        for (int i3 = 0; i3 < round; i3++) {
            int i16 = round * a18;
            if (i16 > a19) {
                i16 = a19;
            }
            b(i16, this.f92048e, this.f92049f);
        }
        y();
    }

    public void p(Bitmap bitmap) {
        a aVar = this.f92051h;
        if (aVar == null) {
            QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[notifyCacheBitmapDisplay] capture frame listener should not be null.");
        } else {
            aVar.b(bitmap);
        }
    }

    public void q(long j3, int i3, int i16) {
        long longValue;
        if (this.f92051h == null) {
            QLog.e("QPP-QFSVideoCaptureFrameTaskQueue", 1, "[notifyCaptureTask] capture fame listener should not be null.");
            return;
        }
        Long l3 = this.f92046c.get(Long.valueOf(j3));
        if (l3 == null) {
            longValue = j3;
        } else {
            longValue = Long.valueOf(l3.toString()).longValue();
        }
        this.f92051h.e(longValue, i3, i16);
        this.f92046c.put(Integer.valueOf(mb0.a.c(j3, this.f92050g)), Long.valueOf(j3));
    }

    public void r() {
        if (this.f92045b != null) {
            this.f92045b.clear();
        }
        if (this.f92047d != null) {
            this.f92047d.release(d());
        }
        Map<Integer, Long> map = this.f92046c;
        if (map != null) {
            map.clear();
        }
        this.f92044a.set(0);
        RFWThreadManager.getInstance().getSerialThreadHandler().removeCallbacksAndMessages(f92043l);
    }

    public void t() {
        this.f92044a.set(0);
    }

    public void u(long j3) {
        this.f92052i = j3;
        int c16 = mb0.a.c(j3, this.f92050g);
        if (l(c16)) {
            p(h(c16));
            return;
        }
        this.f92046c.put(Integer.valueOf(c16), Long.valueOf(j3));
        b(c16, this.f92048e, this.f92049f);
        y();
    }

    public void v(int i3) {
        this.f92053j = i3;
    }

    public void w(a aVar) {
        this.f92051h = aVar;
    }

    public void x(int i3, int i16) {
        this.f92048e = i3;
        this.f92049f = i16;
    }
}
