package com.tencent.luggage.wxa.ih;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.o9.a;
import com.tencent.luggage.wxa.tk.l;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends com.tencent.luggage.wxa.ih.a {

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.o9.a f130365b;

    /* renamed from: c, reason: collision with root package name */
    public d.C6305d f130366c;

    /* renamed from: d, reason: collision with root package name */
    public long f130367d;

    /* renamed from: e, reason: collision with root package name */
    public int f130368e;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f130369f = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.j();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements a.c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.o9.a.c
        public void a(byte[] bArr, int i3, boolean z16) {
            w.g("MicroMsg.DefaultLuggageRecorder", "onFrameRecorded buffSize:%d isLastFrame:%b", Integer.valueOf(i3), Boolean.valueOf(z16));
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            c.this.a(bArr2, z16);
        }
    }

    @Override // com.tencent.luggage.wxa.ih.d
    public com.tencent.luggage.wxa.hh.g a(d.C6305d c6305d) {
        if (b(c6305d)) {
            return new com.tencent.luggage.wxa.hh.g("invalid params", new Object[0]);
        }
        release();
        this.f130366c = c6305d;
        if (c6305d.f130382b <= 0) {
            c6305d.f130382b = 60000;
        }
        this.f130365b = new com.tencent.luggage.wxa.o9.a(c6305d.f130388h.f130379a, c6305d.f130383c, c6305d.f130384d, 2, c6305d.f130386f, c6305d.f130387g, c6305d.f130381a, c6305d.f130385e);
        this.f130367d = System.currentTimeMillis();
        this.f130368e = 0;
        boolean d16 = this.f130365b.d();
        w.d("MicroMsg.DefaultLuggageRecorder", "startRecord() params:%s isOK:%b", c6305d, Boolean.valueOf(d16));
        if (d16) {
            this.f130365b.a(new b());
            c();
            b();
            return com.tencent.luggage.wxa.hh.g.f127194d;
        }
        release();
        return new com.tencent.luggage.wxa.hh.g("start fail", new Object[0]);
    }

    public boolean b(d.C6305d c6305d) {
        if (c6305d == null) {
            return true;
        }
        return false;
    }

    public final void c() {
        this.f130367d = System.currentTimeMillis();
        w.d("MicroMsg.DefaultLuggageRecorder", "resumeRecordTime mRecordingTime:%d mLastStartTime:%d", Integer.valueOf(this.f130368e), Long.valueOf(this.f130367d));
        l.a().b(this.f130369f, this.f130366c.f130382b - this.f130368e);
    }

    @Override // com.tencent.luggage.wxa.ih.d
    public com.tencent.luggage.wxa.hh.g j() {
        com.tencent.luggage.wxa.o9.a aVar = this.f130365b;
        if (aVar == null) {
            w.b("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
            return new com.tencent.luggage.wxa.hh.g("may be not start", new Object[0]);
        }
        aVar.e();
        String str = this.f130366c.f130381a;
        int i3 = this.f130368e;
        int e16 = (int) x.e(str);
        a(str, i3, e16);
        w.d("MicroMsg.DefaultLuggageRecorder", "stopRecord() filePath:%s duration:%d fileSize:%d", str, Integer.valueOf(i3), Integer.valueOf(e16));
        release();
        return com.tencent.luggage.wxa.hh.g.f127194d;
    }

    @Override // com.tencent.luggage.wxa.ih.d
    public void onBackground() {
        w.d("MicroMsg.DefaultLuggageRecorder", "onBackground");
    }

    @Override // com.tencent.luggage.wxa.ih.d
    public void onDestroy() {
        w.d("MicroMsg.DefaultLuggageRecorder", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        release();
    }

    @Override // com.tencent.luggage.wxa.ih.d
    public void onForeground() {
        w.d("MicroMsg.DefaultLuggageRecorder", "onForeground");
    }

    public synchronized void release() {
        this.f130366c = null;
        com.tencent.luggage.wxa.o9.a aVar = this.f130365b;
        if (aVar != null) {
            aVar.c();
            this.f130365b = null;
        }
    }
}
