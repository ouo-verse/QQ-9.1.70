package com.tencent.luggage.wxa.n9;

import android.media.AudioTrack;
import android.os.Process;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.n9.a;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements com.tencent.luggage.wxa.n9.a {

    /* renamed from: a, reason: collision with root package name */
    public volatile AudioTrack f135592a;

    /* renamed from: b, reason: collision with root package name */
    public int f135593b;

    /* renamed from: c, reason: collision with root package name */
    public DataInputStream f135594c;

    /* renamed from: d, reason: collision with root package name */
    public Thread f135595d;

    /* renamed from: e, reason: collision with root package name */
    public Future f135596e;

    /* renamed from: f, reason: collision with root package name */
    public a.InterfaceC6506a f135597f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f135600i;

    /* renamed from: g, reason: collision with root package name */
    public int f135598g = 44100;

    /* renamed from: h, reason: collision with root package name */
    public int f135599h = 12;

    /* renamed from: j, reason: collision with root package name */
    public Runnable f135601j = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.this.f135592a == null) {
                    return;
                }
                c.this.f135592a.play();
                Process.setThreadPriority(-19);
                byte[] bArr = new byte[c.this.f135593b];
                while (c.this.f135594c.available() > 0) {
                    int read = c.this.f135594c.read(bArr);
                    if (read != -3 && read != -2 && read != 0 && read != -1) {
                        c.this.f135592a.write(bArr, 0, read);
                    }
                }
                c.this.stop();
                if (c.this.f135597f != null) {
                    c.this.f135597f.a();
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.yp.b.a("MicroMsg.VoicePlayerPcm", e16, "");
            }
        }
    }

    public final void e() {
        try {
            Thread thread = this.f135595d;
            if (thread != null && Thread.State.RUNNABLE == thread.getState()) {
                try {
                    LockMethodProxy.sleep(500L);
                    this.f135596e.cancel(false);
                } catch (Exception unused) {
                    this.f135595d = null;
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.a("MicroMsg.VoicePlayerPcm", e16, "");
        } finally {
            this.f135596e = null;
        }
    }

    @Override // com.tencent.luggage.wxa.n9.a
    public boolean pause() {
        if (!this.f135600i) {
            com.tencent.luggage.wxa.yp.b.b("MicroMsg.VoicePlayerPcm", "pause() not start play");
            return false;
        }
        this.f135600i = false;
        e();
        return true;
    }

    @Override // com.tencent.luggage.wxa.n9.a
    public void release() {
        c();
        e();
        a();
    }

    @Override // com.tencent.luggage.wxa.n9.a
    public boolean stop() {
        if (this.f135592a != null) {
            this.f135592a.stop();
        }
        this.f135600i = false;
        release();
        return true;
    }

    public final boolean a(String str) {
        try {
            v vVar = new v(str);
            if (!vVar.e()) {
                return false;
            }
            this.f135594c = new DataInputStream(x.a(vVar));
            return true;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.a("MicroMsg.VoicePlayerPcm", e16, String.format(Locale.US, "openFile(%s)", str));
            return false;
        }
    }

    public final AudioTrack b() {
        if (this.f135592a == null) {
            synchronized (this) {
                if (this.f135592a == null) {
                    this.f135593b = AudioTrack.getMinBufferSize(this.f135598g, this.f135599h, 2);
                    this.f135592a = new AudioTrack(3, this.f135598g, this.f135599h, 2, this.f135593b, 1);
                    if (this.f135592a.getState() == 0) {
                        c();
                        this.f135592a = new AudioTrack(3, this.f135598g, this.f135599h, 2, this.f135593b, 1);
                    }
                }
            }
        }
        return this.f135592a;
    }

    public final void c() {
        try {
            if (this.f135592a != null) {
                this.f135592a.flush();
                this.f135592a.release();
                this.f135592a = null;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.a("MicroMsg.VoicePlayerPcm", e16, "");
        }
    }

    public final void d() {
        e();
        if (this.f135596e == null) {
            this.f135596e = h.f146825d.d(this.f135601j);
        }
    }

    @Override // com.tencent.luggage.wxa.n9.a
    public void a(a.InterfaceC6506a interfaceC6506a) {
        this.f135597f = interfaceC6506a;
    }

    public final void a() {
        DataInputStream dataInputStream = this.f135594c;
        if (dataInputStream != null) {
            try {
                dataInputStream.close();
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.a("MicroMsg.VoicePlayerPcm", e16, "");
            }
            this.f135594c = null;
        }
    }

    @Override // com.tencent.luggage.wxa.n9.a
    public boolean b(String str) {
        if (this.f135600i) {
            com.tencent.luggage.wxa.yp.b.b("MicroMsg.VoicePlayerPcm", "already play");
            return false;
        }
        if (!a(str)) {
            com.tencent.luggage.wxa.yp.b.b("MicroMsg.VoicePlayerPcm", "openfile fail");
            return false;
        }
        b();
        if (this.f135592a.getState() == 0) {
            this.f135592a = null;
            return false;
        }
        this.f135600i = true;
        d();
        return true;
    }
}
