package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: P */
@TargetApi(10)
/* loaded from: classes10.dex */
public class VideoFramesRetriever implements d {

    /* renamed from: l, reason: collision with root package name */
    private static long f185956l;

    /* renamed from: c, reason: collision with root package name */
    private int f185959c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a f185960d;

    /* renamed from: e, reason: collision with root package name */
    private BlockingQueue<a> f185961e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f185962f;

    /* renamed from: g, reason: collision with root package name */
    private ExecutorService f185963g;

    /* renamed from: i, reason: collision with root package name */
    private MediaMetadataRetriever f185965i;

    /* renamed from: j, reason: collision with root package name */
    private String f185966j;

    /* renamed from: k, reason: collision with root package name */
    private float f185967k;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f185957a = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f185958b = 1000;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f185964h = false;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class FrameFetchRunnable implements Runnable {
        FrameFetchRunnable() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7, types: [int, boolean] */
        /* JADX WARN: Type inference failed for: r8v9 */
        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            float f16;
            int width;
            ?? r85;
            Bitmap bitmap;
            if (VideoFramesRetriever.this.f185965i == null) {
                return;
            }
            while (true) {
                try {
                    if (!VideoFramesRetriever.this.f185964h && VideoFramesRetriever.this.f185961e != null) {
                        a aVar = (a) VideoFramesRetriever.this.f185961e.take();
                        if (VideoFramesRetriever.this.f185964h) {
                            return;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        Bitmap frameAtTime = VideoFramesRetriever.this.f185965i.getFrameAtTime(((aVar.f185969e + aVar.f185970f) / 2) * 1000);
                        if (frameAtTime == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("VideoFramesRetriever", 2, "getThumbnail Failed");
                            }
                        } else {
                            if (frameAtTime.getWidth() > frameAtTime.getHeight()) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                f16 = VideoFramesRetriever.this.f185967k;
                                width = frameAtTime.getHeight();
                            } else {
                                f16 = VideoFramesRetriever.this.f185967k;
                                width = frameAtTime.getWidth();
                            }
                            float f17 = f16 / width;
                            Matrix matrix = new Matrix();
                            matrix.postScale(f17, f17);
                            if (z16) {
                                r85 = 1;
                                bitmap = Bitmap.createBitmap(frameAtTime, (frameAtTime.getWidth() - frameAtTime.getHeight()) / 2, 0, frameAtTime.getHeight(), frameAtTime.getHeight(), matrix, true);
                            } else {
                                r85 = 1;
                                bitmap = Bitmap.createBitmap(frameAtTime, 0, (frameAtTime.getHeight() - frameAtTime.getWidth()) / 2, frameAtTime.getWidth(), frameAtTime.getWidth(), matrix, true);
                            }
                            frameAtTime.recycle();
                            c.b bVar = new c.b();
                            bVar.f186001a = bitmap.copy(Bitmap.Config.RGB_565, r85);
                            bVar.f186002b = aVar.f185969e / VideoFramesRetriever.this.f185958b;
                            bitmap.recycle();
                            QLog.i("VideoFramesRetriever", r85, "end get frame bitmap, cost time=" + (System.currentTimeMillis() - currentTimeMillis));
                            VideoFramesRetriever.this.f185960d.a(bVar);
                            VideoFramesRetriever.this.f185962f.remove(Integer.valueOf(aVar.f185969e));
                        }
                    } else {
                        return;
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements Comparable<a> {

        /* renamed from: d, reason: collision with root package name */
        public long f185968d;

        /* renamed from: e, reason: collision with root package name */
        public int f185969e;

        /* renamed from: f, reason: collision with root package name */
        public int f185970f;

        public a(long j3, int i3, int i16) {
            this.f185968d = j3;
            this.f185969e = i3;
            this.f185970f = Math.min(i16, VideoFramesRetriever.this.f185959c);
            VideoFramesRetriever.this.f185962f.put(Integer.valueOf(i3), this);
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return -((int) (this.f185968d - aVar.f185968d));
        }
    }

    public VideoFramesRetriever(String str, float f16) {
        this.f185966j = str;
        this.f185967k = f16;
    }

    private c.b k(int i3) {
        if (!m()) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoFramesRetriever", 2, "FetchFrameAtTime fail, status=" + this.f185957a);
            }
            return null;
        }
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.f185962f.containsKey(Integer.valueOf(i3))) {
            a aVar = this.f185962f.get(Integer.valueOf(i3));
            long j3 = f185956l;
            f185956l = 1 + j3;
            aVar.f185968d = j3;
            return null;
        }
        long j16 = f185956l;
        f185956l = 1 + j16;
        a aVar2 = new a(j16, i3, i3 + this.f185958b);
        BlockingQueue<a> blockingQueue = this.f185961e;
        if (blockingQueue != null) {
            blockingQueue.offer(aVar2);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.d
    public int a(int i3, int i16, com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.a aVar) {
        this.f185958b = i3;
        this.f185959c = i16;
        this.f185960d = aVar;
        this.f185961e = new PriorityBlockingQueue();
        this.f185962f = new ConcurrentHashMap<>();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        this.f185965i = mediaMetadataRetriever;
        mediaMetadataRetriever.setDataSource(this.f185966j);
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        this.f185963g = newSingleThreadExecutor;
        newSingleThreadExecutor.submit(new FrameFetchRunnable());
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.d
    public void b(int i3, int i16) {
        if (m() && i3 >= 0 && i16 >= 0) {
            for (int i17 = i16 - 1; i17 >= i3; i17--) {
                l(i17);
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoFramesRetriever", 2, "fetchFrameByIndex2 fail, status=" + this.f185957a);
        }
    }

    public c.b l(int i3) {
        if (m() && i3 >= 0) {
            if (this.f185960d.e(i3)) {
                return this.f185960d.c(i3);
            }
            return k(i3 * this.f185958b);
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoFramesRetriever", 2, "fetchFrameByIndex1 fail, status=" + this.f185957a);
            return null;
        }
        return null;
    }

    public boolean m() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.d
    public void release() {
        this.f185957a = 1;
        this.f185964h = true;
        BlockingQueue<a> blockingQueue = this.f185961e;
        if (blockingQueue != null) {
            blockingQueue.clear();
            this.f185961e = null;
        }
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f185962f;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.f185962f = null;
        }
        this.f185963g.shutdownNow();
        MediaMetadataRetriever mediaMetadataRetriever = this.f185965i;
        if (mediaMetadataRetriever != null) {
            mediaMetadataRetriever.release();
        }
        f185956l = 0L;
    }
}
