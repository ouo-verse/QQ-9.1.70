package com.tencent.luggage.wxa.ti;

import android.media.AudioRecord;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.luggage.wxa.jq.g;
import com.tencent.luggage.wxa.ti.a;
import com.tencent.luggage.wxa.ti.e;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.util.Arrays;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends e {

    /* renamed from: e, reason: collision with root package name */
    public boolean f141395e;

    /* renamed from: f, reason: collision with root package name */
    public int f141396f;

    /* renamed from: k, reason: collision with root package name */
    public b0 f141401k;

    /* renamed from: l, reason: collision with root package name */
    public AudioRecord f141402l;

    /* renamed from: o, reason: collision with root package name */
    public a.b f141405o;

    /* renamed from: u, reason: collision with root package name */
    public boolean f141411u;

    /* renamed from: g, reason: collision with root package name */
    public int f141397g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f141398h = 12800;

    /* renamed from: i, reason: collision with root package name */
    public boolean f141399i = false;

    /* renamed from: j, reason: collision with root package name */
    public HandlerThread f141400j = com.tencent.luggage.wxa.cq.d.c("RecordModeAsyncRead_record", 5);

    /* renamed from: m, reason: collision with root package name */
    public c f141403m = new c();

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.luggage.wxa.s9.b f141404n = null;

    /* renamed from: p, reason: collision with root package name */
    public final Object f141406p = new Object();

    /* renamed from: q, reason: collision with root package name */
    public final byte[] f141407q = new byte[0];

    /* renamed from: r, reason: collision with root package name */
    public final Object f141408r = new Object();

    /* renamed from: s, reason: collision with root package name */
    public Future f141409s = null;

    /* renamed from: t, reason: collision with root package name */
    public boolean f141410t = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements InterfaceC6758d {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ti.d.InterfaceC6758d
        public void finish() {
            d.this.f141403m.a(null);
            if (d.this.f141401k != null) {
                d.this.f141401k.a((Object) null);
                d.this.f141401k.c();
                d.this.f141401k = null;
            }
            if (d.this.f141400j != null) {
                d.this.f141400j.quitSafely();
                d.this.f141400j = null;
            }
            w.d("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
            if (d.this.f141404n != null) {
                if (d.this.f141409s != null) {
                    d.this.f141409s.cancel(false);
                    d.this.f141409s = null;
                }
                d.this.f141404n.a();
                synchronized (d.this.f141406p) {
                    d.this.f141404n = null;
                    d.this.f141405o = null;
                }
                d.this.f141410t = false;
                d.this.f141404n = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f141413a;

        /* renamed from: b, reason: collision with root package name */
        public int f141414b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f141415c;

        public b() {
            this.f141413a = d.this.f141396f * 2;
            this.f141414b = d.this.f141396f;
            this.f141415c = new byte[this.f141413a];
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.f141421c) {
                int d16 = (int) (r0.d() * 0.8d);
                int i3 = 8;
                if (d16 < d.this.f141396f * 8) {
                    d16 = d.this.f141396f * 8;
                }
                if (d.this.c() <= d16) {
                    i3 = 1;
                }
                for (int i16 = 0; i16 < i3; i16++) {
                    int a16 = d.this.a(this.f141415c, this.f141414b);
                    if (d.this.f141405o != null && a16 == 0) {
                        d.this.f141405o.a(this.f141415c, this.f141414b);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class c implements g {

        /* renamed from: a, reason: collision with root package name */
        public volatile InterfaceC6758d f141417a;

        public c() {
        }

        public void a(InterfaceC6758d interfaceC6758d) {
            this.f141417a = interfaceC6758d;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "RecordModeAsyncRead_record";
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", Integer.valueOf(d.this.f141396f));
            if (-123456789 != d.this.f141420b) {
                w.d("MicroMsg.RecordModeAsyncRead", "set priority to " + d.this.f141420b);
                Process.setThreadPriority(d.this.f141420b);
            }
            synchronized (d.this.f141408r) {
                w.d("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", Long.valueOf(Thread.currentThread().getId()), d.this.f141408r);
                if (1 == d.this.f141397g) {
                    d.this.f141397g = 2;
                    byte[] bArr = new byte[d.this.f141396f];
                    while (true) {
                        if (2 != d.this.f141397g) {
                            break;
                        }
                        synchronized (d.this.f141407q) {
                            d dVar = d.this;
                            if (dVar.f141421c) {
                                try {
                                    LockMethodProxy.wait(dVar.f141407q);
                                } catch (InterruptedException unused) {
                                }
                                if (2 != d.this.f141397g) {
                                    break;
                                }
                            }
                            if (d.this.f141402l == null) {
                                w.d("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
                                synchronized (d.this.f141408r) {
                                    d.this.f141397g = 3;
                                }
                                break;
                            }
                            if (d.this.f141395e) {
                                bArr = new byte[d.this.f141396f];
                            }
                            d.this.f141422d++;
                            new com.tencent.luggage.wxa.aa.c();
                            int read = d.this.f141402l.read(bArr, 0, d.this.f141396f);
                            if (2 != d.this.f141397g) {
                                w.d("MicroMsg.RecordModeAsyncRead", "record mode has not been running and break");
                                break;
                            }
                            e.a aVar = d.this.f141419a;
                            if (aVar != null) {
                                aVar.a(read, bArr);
                            }
                            if (d.this.f141396f != read) {
                                w.d("MicroMsg.RecordModeAsyncRead", "read len " + read);
                            }
                            if (read < d.this.f141396f) {
                                w.d("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
                                try {
                                    LockMethodProxy.sleep(10L);
                                } catch (InterruptedException unused2) {
                                }
                            }
                            if (d.this.f141405o != null && read > 0) {
                                if (read > bArr.length) {
                                    read = bArr.length;
                                }
                                if (d.this.f141404n != null) {
                                    if (d.this.f141399i) {
                                        Arrays.fill(bArr, 0, read, (byte) 0);
                                    }
                                    int b16 = d.this.f141404n.b(bArr, read);
                                    if (b16 != 0) {
                                        w.b("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", Integer.valueOf(b16), Integer.valueOf(d.this.f141404n.c()));
                                    }
                                } else if (d.this.f141405o == null) {
                                    continue;
                                } else {
                                    if (d.this.f141399i) {
                                        Arrays.fill(bArr, 0, read, (byte) 0);
                                    }
                                    if (2 != d.this.f141397g) {
                                        w.d("MicroMsg.RecordModeAsyncRead", "record mode has not been running and break, do not callback ");
                                        break;
                                    }
                                    d.this.f141405o.a(bArr, read);
                                }
                            }
                        }
                    }
                    if (this.f141417a != null) {
                        this.f141417a.finish();
                    }
                    w.d("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
                    return;
                }
                w.b("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + d.this.f141397g);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ti.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6758d {
        void finish();
    }

    public d(AudioRecord audioRecord, boolean z16, int i3, a.b bVar, boolean z17) {
        this.f141402l = audioRecord;
        this.f141395e = z16;
        this.f141396f = i3;
        this.f141405o = bVar;
        this.f141411u = z17;
    }

    @Override // com.tencent.luggage.wxa.ti.e
    public void b() {
        w.d("MicroMsg.RecordModeAsyncRead", "stopRecord");
        synchronized (this.f141408r) {
            this.f141397g = 3;
            this.f141403m.a(new a());
        }
        synchronized (this.f141407q) {
            this.f141407q.notify();
        }
    }

    public int c() {
        synchronized (this.f141406p) {
            com.tencent.luggage.wxa.s9.b bVar = this.f141404n;
            if (bVar == null) {
                return -1;
            }
            return bVar.c();
        }
    }

    public int d() {
        synchronized (this.f141406p) {
            com.tencent.luggage.wxa.s9.b bVar = this.f141404n;
            if (bVar == null) {
                return -1;
            }
            return bVar.d();
        }
    }

    public final boolean e() {
        this.f141404n = new com.tencent.luggage.wxa.s9.b();
        this.f141398h = this.f141396f * 20;
        w.d("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.f141398h);
        int a16 = this.f141404n.a(this.f141398h);
        if (a16 == 0) {
            return true;
        }
        w.b("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = " + a16);
        return false;
    }

    @Override // com.tencent.luggage.wxa.ti.e
    public boolean a() {
        w.d("MicroMsg.RecordModeAsyncRead", "startRecord");
        synchronized (this.f141408r) {
            this.f141397g = 1;
        }
        w.d("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", h.f146826e.a());
        this.f141400j.start();
        b0 b0Var = new b0(this.f141400j.getLooper());
        this.f141401k = b0Var;
        b0Var.a((Runnable) this.f141403m);
        this.f141401k.a(false);
        if (true == this.f141411u) {
            if (!e()) {
                w.b("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
                return false;
            }
            if (this.f141409s != null) {
                w.b("MicroMsg.RecordModeAsyncRead", "startRecord failed : last record is NOT stopped now");
                return false;
            }
            this.f141409s = h.f146825d.b(new b(), 60L, 20L);
            this.f141410t = true;
        }
        return true;
    }

    public int a(byte[] bArr, int i3) {
        synchronized (this.f141406p) {
            com.tencent.luggage.wxa.s9.b bVar = this.f141404n;
            if (bVar == null) {
                return -1;
            }
            return bVar.a(bArr, i3);
        }
    }
}
