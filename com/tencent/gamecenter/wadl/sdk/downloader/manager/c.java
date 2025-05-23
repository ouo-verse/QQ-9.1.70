package com.tencent.gamecenter.wadl.sdk.downloader.manager;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    private static c f107418i;

    /* renamed from: j, reason: collision with root package name */
    private static byte[] f107419j = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<a> f107420a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private long f107421b = 10000;

    /* renamed from: c, reason: collision with root package name */
    private int f107422c;

    /* renamed from: d, reason: collision with root package name */
    private long f107423d;

    /* renamed from: e, reason: collision with root package name */
    private long f107424e;

    /* renamed from: f, reason: collision with root package name */
    private long f107425f;

    /* renamed from: g, reason: collision with root package name */
    private long f107426g;

    /* renamed from: h, reason: collision with root package name */
    private long f107427h;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private class a extends InputStream {

        /* renamed from: d, reason: collision with root package name */
        final InputStream f107428d;

        public a(InputStream inputStream) {
            this.f107428d = inputStream;
        }

        @Override // java.io.InputStream
        public int read() {
            return this.f107428d.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) {
            int i17 = 0;
            while (i17 < i16) {
                long currentTimeMillis = System.currentTimeMillis();
                int read = this.f107428d.read(bArr, i3 + i17, i16 - i17);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (read <= 0) {
                    return -1;
                }
                i17 += read;
                c.this.f107423d += currentTimeMillis2 - currentTimeMillis;
                c.b(c.this, read);
                c cVar = c.this;
                cVar.f107427h = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(cVar.f107424e, c.this.f107423d);
                if (c.this.f107425f < 1 && c.this.f107423d > c.this.f107421b) {
                    c.this.c();
                } else {
                    c cVar2 = c.this;
                    cVar2.a(cVar2.f107427h);
                }
            }
            return i17;
        }
    }

    public long b() {
        return this.f107427h;
    }

    private void d() {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("SpeedLimitManager", "resetGlobalSpeed");
        this.f107425f = 0L;
        this.f107426g = 0L;
        this.f107423d = 0L;
        this.f107424e = 0L;
    }

    public static c a() {
        if (f107418i == null) {
            synchronized (f107419j) {
                if (f107418i == null) {
                    f107418i = new c();
                }
            }
        }
        return f107418i;
    }

    static /* synthetic */ long b(c cVar, long j3) {
        long j16 = cVar.f107424e + j3;
        cVar.f107424e = j16;
        return j16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        long a16 = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(this.f107424e, this.f107423d);
        this.f107425f = a16;
        int i3 = this.f107422c;
        if (i3 < 1) {
            return;
        }
        long j3 = a16 - i3;
        this.f107426g = j3;
        if (j3 < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
            this.f107426g = FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE;
        }
        this.f107423d = 0L;
        this.f107424e = 0L;
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("SpeedLimitManager", "onDetectedSpeed detectedSpeed=" + this.f107425f + ",globalSpeedBuffer=" + this.f107422c + ",limitSpeed=" + this.f107426g);
    }

    public c a(int i3) {
        if (i3 > 5120) {
            i3 = 5120;
        }
        this.f107422c = i3 * 1024;
        d();
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("SpeedLimitManager", "updateGlobalSpeedBuffer globalSpeedBuffer=" + this.f107422c);
        return this;
    }

    public c b(long j3) {
        this.f107421b = j3;
        return this;
    }

    public InputStream a(InputStream inputStream) {
        a aVar = new a(inputStream);
        this.f107420a.add(aVar);
        return aVar;
    }

    public void b(InputStream inputStream) {
        if ((inputStream instanceof a) && this.f107420a.contains(inputStream)) {
            this.f107420a.remove(inputStream);
        }
        if (this.f107420a.size() < 1) {
            a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j3) {
        if (this.f107423d >= 1000) {
            long j16 = this.f107426g;
            if (j16 < 1 || this.f107425f < 1 || j3 <= j16) {
                return;
            }
            long j17 = ((j3 - j16) * 1000) / j3;
            if (j17 > 100) {
                try {
                    LockMethodProxy.sleep(j17);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
