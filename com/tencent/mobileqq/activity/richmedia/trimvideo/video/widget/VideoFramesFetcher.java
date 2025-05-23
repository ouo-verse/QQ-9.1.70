package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.graphics.Bitmap;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VideoFramesFetcher implements d {

    /* renamed from: i, reason: collision with root package name */
    private static long f185943i;

    /* renamed from: c, reason: collision with root package name */
    private int f185946c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a f185947d;

    /* renamed from: e, reason: collision with root package name */
    private BlockingQueue<a> f185948e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f185949f;

    /* renamed from: g, reason: collision with root package name */
    private ExecutorService f185950g;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f185944a = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f185945b = 1000;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f185951h = false;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class FrameFetchRunnable implements Runnable {
        FrameFetchRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TrimNative.isGetThumbnailReady()) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoFramesFetcher", 2, "GetThumbnail is not ready!");
                    return;
                }
                return;
            }
            while (!VideoFramesFetcher.this.f185951h && VideoFramesFetcher.this.f185948e != null) {
                try {
                    try {
                        a aVar = (a) VideoFramesFetcher.this.f185948e.take();
                        if (VideoFramesFetcher.this.f185951h) {
                            return;
                        }
                        Bitmap b16 = o71.b.b(aVar.f185953e, aVar.f185954f);
                        if (b16 == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("VideoFramesFetcher", 2, "getThumbnail Failed");
                            }
                        } else {
                            c.b bVar = new c.b();
                            bVar.f186001a = b16.copy(Bitmap.Config.RGB_565, true);
                            bVar.f186002b = aVar.f185953e / VideoFramesFetcher.this.f185945b;
                            b16.recycle();
                            VideoFramesFetcher.this.f185947d.a(bVar);
                            VideoFramesFetcher.this.f185949f.remove(Integer.valueOf(aVar.f185953e));
                        }
                    } catch (InterruptedException e16) {
                        QLog.e("VideoFramesFetcher", 2, "FrameFetchRunnable, InterruptedException");
                        e16.printStackTrace();
                    }
                } finally {
                    TrimNative.release();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements Comparable<a> {

        /* renamed from: d, reason: collision with root package name */
        public long f185952d;

        /* renamed from: e, reason: collision with root package name */
        public int f185953e;

        /* renamed from: f, reason: collision with root package name */
        public int f185954f;

        public a(long j3, int i3, int i16) {
            this.f185952d = j3;
            this.f185953e = i3;
            this.f185954f = Math.min(i16, VideoFramesFetcher.this.f185946c);
            VideoFramesFetcher.this.f185949f.put(Integer.valueOf(i3), this);
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return -((int) (this.f185952d - aVar.f185952d));
        }
    }

    private c.b i(int i3) {
        if (!k()) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoFramesFetcher", 2, "FetchFrameAtTime fail, status=" + this.f185944a);
            }
            return null;
        }
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.f185949f.containsKey(Integer.valueOf(i3))) {
            a aVar = this.f185949f.get(Integer.valueOf(i3));
            long j3 = f185943i;
            f185943i = 1 + j3;
            aVar.f185952d = j3;
            return null;
        }
        long j16 = f185943i;
        f185943i = 1 + j16;
        a aVar2 = new a(j16, i3, i3 + this.f185945b);
        BlockingQueue<a> blockingQueue = this.f185948e;
        if (blockingQueue != null) {
            blockingQueue.offer(aVar2);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.d
    public int a(int i3, int i16, com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a aVar) {
        this.f185945b = i3;
        this.f185946c = i16;
        this.f185947d = aVar;
        this.f185948e = new PriorityBlockingQueue();
        this.f185949f = new ConcurrentHashMap<>();
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        this.f185950g = newSingleThreadExecutor;
        newSingleThreadExecutor.submit(new FrameFetchRunnable());
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.d
    public void b(int i3, int i16) {
        if (k() && i3 >= 0 && i16 >= 0) {
            for (int i17 = i16 - 1; i17 >= i3; i17--) {
                j(i17);
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoFramesFetcher", 2, "fetchFrameByIndex2 fail, status=" + this.f185944a);
        }
    }

    public c.b j(int i3) {
        if (k() && i3 >= 0) {
            if (this.f185947d.e(i3)) {
                return this.f185947d.c(i3);
            }
            return i(i3 * this.f185945b);
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoFramesFetcher", 2, "fetchFrameByIndex1 fail, status=" + this.f185944a);
            return null;
        }
        return null;
    }

    public boolean k() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.d
    public void release() {
        this.f185944a = 1;
        this.f185951h = true;
        BlockingQueue<a> blockingQueue = this.f185948e;
        if (blockingQueue != null) {
            blockingQueue.clear();
            this.f185948e = null;
        }
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f185949f;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.f185949f = null;
        }
        this.f185950g.shutdownNow();
        f185943i = 0L;
    }
}
