package com.tencent.mobileqq.wink.editor.export.compress;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes21.dex */
public class WinkAudioProcessThread extends BaseThread {
    private Exception C;
    private final WinkMuxerThread D;
    private int E;
    private MediaExtractor F;
    private CountDownLatch G;
    private n63.a H;
    private int I;
    private String J;
    private int K;
    private boolean L;
    private c M;

    public WinkAudioProcessThread(c cVar, String str, WinkMuxerThread winkMuxerThread, int i3, int i16, CountDownLatch countDownLatch, int i17) {
        super("WinkAudioProcessThread");
        this.L = false;
        this.M = cVar;
        this.J = str;
        this.D = winkMuxerThread;
        this.K = i3;
        this.E = i16;
        this.F = new MediaExtractor();
        this.G = countDownLatch;
        this.I = i17;
    }

    @SuppressLint({"WrongConstant"})
    private void o() throws Exception {
        int i3;
        int readSampleData;
        this.F.setDataSource(this.J);
        if (this.E >= 0) {
            this.F.selectTrack(this.K);
            MediaFormat trackFormat = this.F.getTrackFormat(this.K);
            if (this.G.await(3L, TimeUnit.SECONDS)) {
                if (trackFormat.getInteger("max-input-size") > 0) {
                    i3 = trackFormat.getInteger("max-input-size");
                } else {
                    i3 = 1048576;
                }
                ByteBuffer allocate = ByteBuffer.allocate(i3);
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                while (!this.L && (readSampleData = this.F.readSampleData(allocate, 0)) > 0) {
                    bufferInfo.flags = this.F.getSampleFlags();
                    bufferInfo.offset = 0;
                    bufferInfo.size = readSampleData;
                    long sampleTime = this.F.getSampleTime();
                    bufferInfo.presentationTimeUs = sampleTime;
                    this.H.a(((float) sampleTime) / (this.I * 1000.0f));
                    ByteBuffer allocate2 = ByteBuffer.allocate(readSampleData);
                    allocate2.put(allocate);
                    allocate2.flip();
                    this.D.c(new n63.b(this.E, allocate2, bufferInfo));
                }
            } else {
                throw new TimeoutException("wait muxerStartLatch timeout!");
            }
        }
        n63.a aVar = this.H;
        if (aVar != null && !this.L) {
            aVar.a(1.0f);
            w53.b.f("WinkPublish-NCompress-WinkAudioProcessThread", "audio process done");
        }
    }

    public void cancel() {
        this.L = true;
        this.G.countDown();
    }

    public Exception getException() {
        return this.C;
    }

    public void p(n63.a aVar) {
        this.H = aVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0012 -> B:8:0x002e). Please report as a decompilation issue!!! */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
        } catch (Exception e16) {
            w53.b.e("WinkPublish-NCompress-WinkAudioProcessThread", e16);
        }
        try {
            try {
                o();
                MediaExtractor mediaExtractor = this.F;
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
            } catch (Exception e17) {
                w53.b.e("WinkPublish-NCompress-WinkAudioProcessThread", this.C);
                this.C = e17;
                this.M.q();
                if (this.F != null) {
                    this.F.release();
                }
            }
        } catch (Throwable th5) {
            try {
                MediaExtractor mediaExtractor2 = this.F;
                if (mediaExtractor2 != null) {
                    mediaExtractor2.release();
                }
            } catch (Exception e18) {
                w53.b.e("WinkPublish-NCompress-WinkAudioProcessThread", e18);
            }
            throw th5;
        }
    }
}
