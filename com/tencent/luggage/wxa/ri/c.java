package com.tencent.luggage.wxa.ri;

import com.tencent.luggage.wxa.ri.d;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c implements d {

    /* renamed from: f, reason: collision with root package name */
    public byte[] f139762f;

    /* renamed from: a, reason: collision with root package name */
    public String f139757a = "audio/mp4a-latm";

    /* renamed from: b, reason: collision with root package name */
    public String f139758b = "audio/mpeg";

    /* renamed from: c, reason: collision with root package name */
    public d.a f139759c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f139760d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f139761e = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f139763g = 0;

    @Override // com.tencent.luggage.wxa.ri.d
    public void a(int i3) {
        w.d("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", Integer.valueOf(this.f139760d));
        this.f139760d = i3;
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public void a(d.a aVar) {
        this.f139759c = aVar;
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public void a(double d16) {
        this.f139761e = (int) (1024.0d * d16);
        w.d("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", Double.valueOf(d16), Integer.valueOf(this.f139761e));
        this.f139762f = new byte[this.f139761e];
    }

    public void a(byte[] bArr, int i3, boolean z16) {
        if (this.f139759c == null) {
            w.b("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
            return;
        }
        int i16 = this.f139761e;
        if (i16 == 0.0d) {
            w.b("MicroMsg.Record.AudioEncoder", "no frameSize, return");
            return;
        }
        if (i3 > i16) {
            w.h("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", Integer.valueOf(i3), Integer.valueOf(this.f139761e));
        }
        w.a("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", Integer.valueOf(this.f139763g), Integer.valueOf(i3));
        int i17 = this.f139763g;
        int i18 = i17 + i3;
        if (i18 >= this.f139761e && bArr != null) {
            w.a("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", Integer.valueOf(i18));
            if (i18 > this.f139762f.length) {
                w.d("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", Integer.valueOf(i18));
                byte[] bArr2 = this.f139762f;
                byte[] bArr3 = new byte[i18];
                this.f139762f = bArr3;
                System.arraycopy(bArr2, 0, bArr3, 0, this.f139763g);
            }
            System.arraycopy(bArr, 0, this.f139762f, this.f139763g, i3);
            this.f139759c.a(this.f139762f, i18, false);
            this.f139763g = 0;
        } else if (bArr != null) {
            System.arraycopy(bArr, 0, this.f139762f, i17, i3);
            this.f139763g = i18;
            w.a("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", Integer.valueOf(i18));
        }
        if (z16) {
            w.d("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", Integer.valueOf(this.f139763g));
            this.f139759c.a(this.f139762f, this.f139763g, z16);
            this.f139763g = 0;
        }
    }
}
