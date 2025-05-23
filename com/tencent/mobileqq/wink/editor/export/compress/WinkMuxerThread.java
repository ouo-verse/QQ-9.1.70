package com.tencent.mobileqq.wink.editor.export.compress;

import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkMuxerThread extends BaseThread {
    private final MediaMuxer C;
    private final CountDownLatch D;
    private final n63.a E;
    private volatile boolean G = false;
    private final AtomicInteger H = new AtomicInteger(0);
    private final LinkedBlockingQueue<n63.b> F = new LinkedBlockingQueue<>(100);

    public WinkMuxerThread(MediaMuxer mediaMuxer, CountDownLatch countDownLatch, n63.a aVar) {
        this.C = mediaMuxer;
        this.D = countDownLatch;
        this.E = aVar;
    }

    private void o() {
        try {
            this.C.stop();
            this.C.release();
            QLog.i("WinkPublish-NCompress-WinkMuxerThread", 1, "Muxer stopped and released");
        } catch (Exception e16) {
            QLog.e("WinkPublish-NCompress-WinkMuxerThread", 1, "Muxer release error: " + e16);
        }
    }

    public void c(n63.b bVar) {
        if (!this.G) {
            try {
                this.F.put(bVar);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                QLog.e("WinkPublish-NCompress-WinkMuxerThread", 1, "Interrupted while adding encoded data");
            }
        }
    }

    public void cancel() {
        this.G = true;
    }

    public int d(MediaFormat mediaFormat) {
        int addTrack = this.C.addTrack(mediaFormat);
        this.H.incrementAndGet();
        return addTrack;
    }

    public void p() {
        try {
            this.C.start();
            QLog.i("WinkPublish-NCompress-WinkMuxerThread", 1, "Muxer started");
        } catch (Exception e16) {
            QLog.e("WinkPublish-NCompress-WinkMuxerThread", 1, "Muxer started error: " + e16);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    this.D.await();
                    while (true) {
                        if (this.G && this.F.isEmpty()) {
                            break;
                        }
                        n63.b poll = this.F.poll(100L, TimeUnit.MILLISECONDS);
                        if (poll != null) {
                            this.C.writeSampleData(poll.c(), poll.b(), poll.a());
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("WinkPublish-NCompress-WinkMuxerThread", 1, "Muxer error: " + e16);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                QLog.w("WinkPublish-NCompress-WinkMuxerThread", 1, "Muxer thread interrupted");
            }
        } finally {
            o();
        }
    }
}
