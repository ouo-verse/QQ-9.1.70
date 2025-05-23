package com.tencent.av.audio;

import android.annotation.TargetApi;
import android.media.AudioFormat;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
@TargetApi(29)
/* loaded from: classes3.dex */
public class ShareAudioCapture {

    /* renamed from: a, reason: collision with root package name */
    private boolean f73212a = false;

    /* renamed from: b, reason: collision with root package name */
    private AudioRecord f73213b;

    /* renamed from: c, reason: collision with root package name */
    private Thread f73214c;

    /* renamed from: d, reason: collision with root package name */
    private e f73215d;

    @VisibleForTesting
    public void a(AudioFormat audioFormat, int i3, AudioPlaybackCaptureConfiguration audioPlaybackCaptureConfiguration) {
        AudioRecord.Builder audioPlaybackCaptureConfig;
        try {
            audioPlaybackCaptureConfig = new AudioRecord.Builder().setAudioFormat(audioFormat).setBufferSizeInBytes(i3).setAudioPlaybackCaptureConfig(audioPlaybackCaptureConfiguration);
            this.f73213b = audioPlaybackCaptureConfig.build();
        } catch (Exception e16) {
            com.tencent.qav.log.a.d("ShareAudioCapture", "createAudioRecord failed " + e16);
        }
    }

    @VisibleForTesting
    public AudioFormat b() {
        return new AudioFormat.Builder().setEncoding(2).setSampleRate(48000).setChannelMask(16).build();
    }

    @VisibleForTesting
    public AudioPlaybackCaptureConfiguration c(MediaProjection mediaProjection) {
        AudioPlaybackCaptureConfiguration.Builder addMatchingUsage;
        AudioPlaybackCaptureConfiguration.Builder addMatchingUsage2;
        AudioPlaybackCaptureConfiguration.Builder addMatchingUsage3;
        AudioPlaybackCaptureConfiguration build;
        addMatchingUsage = new AudioPlaybackCaptureConfiguration.Builder(mediaProjection).addMatchingUsage(1);
        addMatchingUsage2 = addMatchingUsage.addMatchingUsage(0);
        addMatchingUsage3 = addMatchingUsage2.addMatchingUsage(14);
        build = addMatchingUsage3.build();
        return build;
    }

    @VisibleForTesting
    public int d() {
        return AudioRecord.getMinBufferSize(48000, 16, 2);
    }

    @VisibleForTesting
    public boolean e() {
        return Thread.currentThread().isInterrupted();
    }

    @VisibleForTesting
    @WorkerThread
    public void f() {
        int d16 = d();
        if (d16 <= 0) {
            QLog.d("ShareAudioCapture", 1, "readAudioData MinBufferSize illegal.");
            return;
        }
        int i3 = d16 / 2;
        short[] sArr = new short[i3];
        byte[] bArr = new byte[d16];
        while (!e()) {
            AudioRecord audioRecord = this.f73213b;
            if (audioRecord != null) {
                audioRecord.read(sArr, 0, i3);
            }
            h(sArr, bArr);
            e eVar = this.f73215d;
            if (eVar != null) {
                eVar.a(16, 48000, 2, bArr);
            }
        }
    }

    public void g(e eVar) {
        this.f73215d = eVar;
    }

    @VisibleForTesting
    @WorkerThread
    public void h(short[] sArr, byte[] bArr) {
        ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(sArr);
    }

    public void i(MediaProjection mediaProjection) {
        if (!this.f73212a && mediaProjection != null) {
            com.tencent.qav.log.a.d("ShareAudioCapture", "startCapture.");
            this.f73212a = true;
            a(b(), d(), c(mediaProjection));
            AudioRecord audioRecord = this.f73213b;
            if (audioRecord != null) {
                try {
                    AudioMonitor.startRecording(audioRecord);
                } catch (IllegalStateException e16) {
                    com.tencent.qav.log.a.d("ShareAudioCapture", "startCapture failed" + e16);
                    return;
                }
            }
            j();
        }
    }

    @VisibleForTesting
    public void j() {
        Thread newFreeThread = ThreadManagerV2.newFreeThread(new Runnable() { // from class: com.tencent.av.audio.ShareAudioCapture.1
            @Override // java.lang.Runnable
            public void run() {
                ShareAudioCapture.this.f();
            }
        }, "ShareAudioCapture", 5);
        this.f73214c = newFreeThread;
        newFreeThread.start();
    }

    public void k() {
        if (!this.f73212a) {
            return;
        }
        com.tencent.qav.log.a.d("ShareAudioCapture", "stopCapture.");
        this.f73212a = false;
        l();
        AudioRecord audioRecord = this.f73213b;
        if (audioRecord != null) {
            try {
                audioRecord.stop();
            } catch (IllegalStateException unused) {
                com.tencent.qav.log.a.d("ShareAudioCapture", "mAudioRecord stop failed");
            }
            this.f73213b.release();
            this.f73213b = null;
        }
    }

    @VisibleForTesting
    public void l() {
        Thread thread = this.f73214c;
        if (thread == null) {
            return;
        }
        thread.interrupt();
        try {
            this.f73214c.join();
        } catch (InterruptedException unused) {
            com.tencent.qav.log.a.d("ShareAudioCapture", "mAudioReadThread join failed");
        }
        this.f73214c = null;
    }
}
