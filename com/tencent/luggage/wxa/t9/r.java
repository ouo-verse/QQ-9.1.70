package com.tencent.luggage.wxa.t9;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Process;
import android.view.Surface;
import com.tencent.luggage.wxa.t9.s;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public MediaCodec f141134a;

    /* renamed from: b, reason: collision with root package name */
    public s.a f141135b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f141136c;

    /* renamed from: d, reason: collision with root package name */
    public AtomicInteger f141137d = new AtomicInteger();

    /* renamed from: e, reason: collision with root package name */
    public AtomicInteger f141138e = new AtomicInteger();

    /* renamed from: f, reason: collision with root package name */
    public AtomicInteger f141139f = new AtomicInteger();

    /* renamed from: g, reason: collision with root package name */
    public AtomicInteger f141140g = new AtomicInteger();

    /* renamed from: h, reason: collision with root package name */
    public AtomicInteger f141141h = new AtomicInteger();

    /* renamed from: i, reason: collision with root package name */
    public final int f141142i = 10;

    /* renamed from: j, reason: collision with root package name */
    public long f141143j = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f141144k = 5000;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.y9.a.makeText(com.tencent.luggage.wxa.tn.z.c(), String.format("MediaCodecProxy queueInputBuffer, thread:[%s]", Integer.valueOf(Process.myTid())), 1).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.y9.a.makeText(com.tencent.luggage.wxa.tn.z.c(), String.format("MediaCodecProxy dequeueInputBuffer, thread:[%s]", Integer.valueOf(Process.myTid())), 1).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.y9.a.makeText(com.tencent.luggage.wxa.tn.z.c(), String.format("MediaCodecProxy dequeueOutputBuffer, thread:[%s]", Integer.valueOf(Process.myTid())), 1).show();
        }
    }

    public r(MediaCodec mediaCodec, s.a aVar) {
        this.f141136c = false;
        this.f141134a = mediaCodec;
        this.f141135b = aVar;
        this.f141136c = true;
    }

    public static r a(String str) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxy", "into createDecoderByType, type = [%s]", str);
        s.a aVar = new s.a();
        try {
            a(7);
            a(60);
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(str);
            a(61);
            aVar = s.a(createDecoderByType.hashCode(), false, str);
            s.a(str, aVar);
            s.f();
            return new r(createDecoderByType, aVar);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "createDecoderByType error " + str, new Object[0]);
            a(0, e16, aVar);
            s.a(false, str, aVar);
            throw e16;
        }
    }

    public static r b(String str) {
        return a(str, false);
    }

    public final MediaFormat c() {
        try {
            a(120);
            MediaFormat outputFormat = this.f141134a.getOutputFormat();
            a(121);
            return outputFormat;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy getOutputFormat, thread:[%s]", Integer.valueOf(Process.myTid()));
            a(47, e16, this.f141135b);
            throw e16;
        }
    }

    public final void d() {
        try {
            a(11);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxy", "into release function, thread:[%s], stack:[%s]", Integer.valueOf(Process.myTid()), w0.b().toString());
            if (!this.f141136c) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "release error, multi release, stack:[%s]", w0.b().toString());
                a(10, null, this.f141135b);
            }
            s.a(this.f141134a.hashCode());
            s.f();
            a(69);
            this.f141134a.release();
            a(70);
            e();
            this.f141136c = false;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy release", new Object[0]);
            a(30, e16, this.f141135b);
            throw e16;
        }
    }

    public final void e() {
        String str;
        int i3 = this.f141137d.get() + this.f141140g.get() + this.f141141h.get() + this.f141138e.get() + this.f141139f.get();
        if (i3 > 10) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", "reportCount count:[%d]", Integer.valueOf(i3));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("countFlush:");
            sb5.append(this.f141137d);
            sb5.append(";");
            sb5.append("countDequeueInputBuffer:");
            sb5.append(this.f141140g);
            sb5.append(";");
            sb5.append("countDequeueOutputBuffer:");
            sb5.append(this.f141141h);
            sb5.append(";");
            sb5.append("countQueueInputBuffer:");
            sb5.append(this.f141138e);
            sb5.append(";");
            sb5.append("countQueueSecureInputBuffer:");
            sb5.append(this.f141139f);
            sb5.append(";");
            s.a aVar = this.f141135b;
            if (aVar != null) {
                String str2 = aVar.f141158f;
                if (str2 != null) {
                    str = str2.replace(",", ";");
                } else {
                    str = "";
                }
                sb5.append(this.f141135b.f141154b);
                sb5.append(";");
                sb5.append(this.f141135b.f141156d);
                sb5.append(";");
                sb5.append(this.f141135b.f141157e);
                sb5.append(";");
                sb5.append(com.tencent.luggage.wxa.tn.z.i());
                sb5.append(";");
                sb5.append(str);
                sb5.append(";");
                sb5.append("stack:");
                sb5.append(this.f141135b.f141155c);
            }
            s.b.a(16);
            s.b.b(16, sb5.toString());
            this.f141137d.set(0);
            this.f141140g.set(0);
            this.f141141h.set(0);
            this.f141138e.set(0);
            this.f141139f.set(0);
        }
    }

    public final void f() {
        try {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxy", "start function, thread:[%s]", Integer.valueOf(Process.myTid()));
            if (!this.f141136c) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy start not alive");
            }
            a(90);
            this.f141134a.start();
            a(91);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy start", new Object[0]);
            a(37, e16, this.f141135b);
            throw e16;
        }
    }

    public final void g() {
        try {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxy", "stop function, thread:[%s]", Integer.valueOf(Process.myTid()));
            if (!this.f141136c) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy stop not alive");
            }
            a(93);
            this.f141134a.stop();
            a(94);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy stop", new Object[0]);
            a(38, e16, this.f141135b);
            throw e16;
        }
    }

    public ByteBuffer[] b() {
        try {
            a(129);
            ByteBuffer[] outputBuffers = this.f141134a.getOutputBuffers();
            a(130);
            return outputBuffers;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy getOutputBuffers", new Object[0]);
            a(50, e16, this.f141135b);
            throw e16;
        }
    }

    public static r a(String str, boolean z16) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxy", "into createEncoderByType, type = [%s]", str);
        s.a aVar = new s.a();
        try {
            a(7);
            a(63);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
            a(64);
            aVar = s.a(createEncoderByType.hashCode(), true, str);
            s.a(str, aVar);
            s.f();
            return new r(createEncoderByType, aVar);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "createByCodecName error " + str, new Object[0]);
            if (!z16) {
                a(1, e16, aVar);
                s.a(true, str, aVar);
            }
            throw e16;
        }
    }

    public void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i3) {
        try {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxy", "configure 1 function, thread:[%s], threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("configure 1 format = ");
            sb5.append(mediaFormat != null ? mediaFormat.toString() : "null");
            sb5.append(" surface = ");
            sb5.append(surface != null ? surface.toString() : "null");
            sb5.append(" crypto = ");
            sb5.append(mediaCrypto != null ? mediaCrypto.toString() : "null");
            sb5.append(" flags = ");
            sb5.append(i3);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.MediaCodecProxy", sb5.toString());
            if (!this.f141136c) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy configure not alive");
            }
            if (mediaFormat != null) {
                this.f141135b.f141158f = mediaFormat.toString();
            }
            a(75);
            this.f141134a.configure(mediaFormat, surface, mediaCrypto, i3);
            a(76);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy configure 1", new Object[0]);
            a(32, e16, this.f141135b);
            throw e16;
        }
    }

    public final void a(int i3, int i16, int i17, long j3, int i18) {
        try {
            if (!this.f141136c) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "queueInputBuffer function, threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy queueInputBuffer not alive");
            }
            this.f141134a.queueInputBuffer(i3, i16, i17, j3, i18);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy queueInputBuffer, thread:[%s]", Integer.valueOf(Process.myTid()));
            s.b.a(40);
            this.f141138e.getAndIncrement();
            if ((com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g || com.tencent.luggage.wxa.tn.e.f141566h) && System.currentTimeMillis() - this.f141143j > this.f141144k) {
                this.f141143j = System.currentTimeMillis();
                c0.a(new a());
            }
            throw e16;
        }
    }

    public final int a(long j3) {
        try {
            if (!this.f141136c) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "dequeueInputBuffer function, threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueInputBuffer not alive");
            }
            return this.f141134a.dequeueInputBuffer(j3);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy dequeueInputBuffer, thread:[%s]", Integer.valueOf(Process.myTid()));
            s.b.a(42);
            this.f141140g.getAndIncrement();
            if ((com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g || com.tencent.luggage.wxa.tn.e.f141566h) && System.currentTimeMillis() - this.f141143j > this.f141144k) {
                this.f141143j = System.currentTimeMillis();
                c0.a(new b());
            }
            throw e16;
        }
    }

    public final int a(MediaCodec.BufferInfo bufferInfo, long j3) {
        try {
            if (!this.f141136c) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "dequeueOutputBuffer function, threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueOutputBuffer not alive");
            }
            return this.f141134a.dequeueOutputBuffer(bufferInfo, j3);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy dequeueOutputBuffer, thread:[%s]", Integer.valueOf(Process.myTid()));
            s.b.a(43);
            if ((com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g || com.tencent.luggage.wxa.tn.e.f141566h) && System.currentTimeMillis() - this.f141143j > this.f141144k) {
                this.f141143j = System.currentTimeMillis();
                c0.a(new c());
            }
            this.f141141h.getAndIncrement();
            throw e16;
        }
    }

    public final void a(int i3, boolean z16) {
        try {
            if (!this.f141136c) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", Integer.valueOf(Process.myTid()), Thread.currentThread().getName());
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
            }
            this.f141134a.releaseOutputBuffer(i3, z16);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy releaseOutputBuffer 1, thread:[%s]", Integer.valueOf(Process.myTid()));
            a(44, e16, this.f141135b);
            throw e16;
        }
    }

    public ByteBuffer[] a() {
        try {
            a(126);
            ByteBuffer[] inputBuffers = this.f141134a.getInputBuffers();
            a(127);
            return inputBuffers;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.MediaCodecProxy", e16, "MediaCodecProxy getInputBuffers", new Object[0]);
            a(49, e16, this.f141135b);
            throw e16;
        }
    }

    public static String a(Exception exc) {
        if (exc == null) {
            return w0.b().toString();
        }
        return exc.toString() + ProvinceSelectorView.NAME_NO_SELECT_PROFILE + w0.b().toString();
    }

    public static void a(int i3, Exception exc, s.a aVar) {
        if (aVar != null) {
            aVar.f141155c = a(exc);
        }
        s.b.a(i3);
        s.b.a(i3, aVar);
    }

    public static void a(int i3) {
        s.b.a(i3);
    }
}
