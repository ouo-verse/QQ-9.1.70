package com.tencent.luggage.wxa.o9;

import android.media.AudioRecord;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public AudioRecord f136248a;

    /* renamed from: b, reason: collision with root package name */
    public int f136249b;

    /* renamed from: c, reason: collision with root package name */
    public int f136250c;

    /* renamed from: d, reason: collision with root package name */
    public int f136251d;

    /* renamed from: e, reason: collision with root package name */
    public int f136252e;

    /* renamed from: f, reason: collision with root package name */
    public int f136253f;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f136256i;

    /* renamed from: k, reason: collision with root package name */
    public InterfaceC6539b f136258k;

    /* renamed from: g, reason: collision with root package name */
    public final ExecutorService f136254g = ProxyExecutors.newSingleThreadExecutor();

    /* renamed from: h, reason: collision with root package name */
    public Runnable f136255h = new a();

    /* renamed from: j, reason: collision with root package name */
    public boolean f136257j = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.o9.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6539b {
        void a(byte[] bArr, int i3);
    }

    public b(int i3, int i16, int i17, int i18) {
        this.f136249b = 1;
        this.f136250c = 44100;
        this.f136251d = 12;
        this.f136252e = 2;
        this.f136249b = i3;
        this.f136250c = i16;
        if (i17 == 2) {
            this.f136251d = 12;
        } else {
            this.f136251d = 16;
        }
        this.f136252e = i18;
        this.f136253f = AudioRecord.getMinBufferSize(i16, this.f136251d, i18) * 10;
        this.f136248a = new AudioRecord(this.f136249b, this.f136250c, this.f136251d, this.f136252e, this.f136253f);
        w.d("MicroMsg.RecorderPcm", "mAudioSource:%d, mSampleRate:%d mAudioChannel:%d mAudioFormat:%d mBufferSize:%d", Integer.valueOf(this.f136249b), Integer.valueOf(this.f136250c), Integer.valueOf(this.f136251d), Integer.valueOf(this.f136252e), Integer.valueOf(this.f136253f));
    }

    public int b() {
        return this.f136253f;
    }

    public synchronized void c() {
        AudioRecord audioRecord = this.f136248a;
        if (audioRecord != null) {
            audioRecord.setRecordPositionUpdateListener(null);
            this.f136248a.release();
            this.f136248a = null;
        }
    }

    public boolean d() {
        if (a()) {
            return false;
        }
        this.f136257j = true;
        try {
            AudioMonitor.startRecording(this.f136248a);
            this.f136254g.submit(this.f136255h);
            return true;
        } catch (Exception e16) {
            w.f("MicroMsg.RecorderPcm", "", e16);
            return false;
        }
    }

    public boolean e() {
        if (a()) {
            return false;
        }
        this.f136257j = false;
        try {
            this.f136248a.stop();
            c();
            return true;
        } catch (Exception e16) {
            w.f("MicroMsg.RecorderPcm", "", e16);
            return false;
        }
    }

    public final void f() {
        this.f136256i = new byte[this.f136253f];
        while (this.f136257j) {
            int read = this.f136248a.read(this.f136256i, 0, this.f136253f);
            if (read > 0) {
                this.f136258k.a(this.f136256i, read);
            }
        }
    }

    public void a(InterfaceC6539b interfaceC6539b) {
        this.f136258k = interfaceC6539b;
    }

    public final boolean a() {
        if (this.f136248a != null) {
            return false;
        }
        w.b("MicroMsg.RecorderPcm", "mAudioRecord is null, return");
        return true;
    }
}
