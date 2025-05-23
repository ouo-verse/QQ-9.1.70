package com.tencent.luggage.wxa.f9;

import com.tencent.luggage.wxa.cp.x;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends e {

    /* renamed from: r, reason: collision with root package name */
    public com.tencent.luggage.wxa.c9.d f125556r;

    /* renamed from: s, reason: collision with root package name */
    public OutputStream f125557s;

    /* renamed from: t, reason: collision with root package name */
    public InputStream f125558t;

    public f(com.tencent.luggage.wxa.c9.d dVar, int i3, int i16, int i17, String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioFixedConvertProcess", "AudioFixedConvertProcess src:%s, sample:%d, channels:%d, encodeBit:%d", str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        d.a();
        this.f125556r = dVar;
        String a16 = com.tencent.luggage.wxa.m9.a.a(str);
        this.f125553m = a16;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioFixedConvertProcess", "outFile:%s", a16);
        x.c(this.f125553m);
        com.tencent.luggage.wxa.d9.a.e().b(dVar.f123421c);
        try {
            this.f125557s = x.b(com.tencent.luggage.wxa.m9.a.b(this.f125553m));
        } catch (FileNotFoundException e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", e16, "VFSFileOp.openWrite", new Object[0]);
        } catch (Exception e17) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", e17, "VFSFileOp.openWrite", new Object[0]);
        }
        try {
            this.f125558t = x.a(com.tencent.luggage.wxa.m9.a.b(this.f125553m));
        } catch (FileNotFoundException e18) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", e18, "VFSFileOp.openRead", new Object[0]);
        } catch (Exception e19) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", e19, "VFSFileOp.openRead", new Object[0]);
        }
        this.f125552l = str;
        this.f125546f = 44100;
        this.f125547g = 2;
        this.f125548h = 2;
        a(i3, i16, i17);
    }

    @Override // com.tencent.luggage.wxa.f9.e, com.tencent.luggage.wxa.f9.i
    public byte[] a(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        byte[] a16 = super.a(bArr);
        OutputStream outputStream = this.f125557s;
        if (outputStream == null) {
            return a16;
        }
        if (a16 != null) {
            try {
                outputStream.write(a16, 0, a16.length);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", e16, com.tencent.mobileqq.msf.core.auth.k.f247492f, new Object[0]);
            }
            return a16;
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", "desdata is null");
        return null;
    }

    @Override // com.tencent.luggage.wxa.f9.i
    public void b() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioFixedConvertProcess", "finishProcess");
        try {
            OutputStream outputStream = this.f125557s;
            if (outputStream != null) {
                outputStream.flush();
                this.f125557s.close();
                this.f125557s = null;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", e16, "finishProcess", new Object[0]);
        }
        Runtime.getRuntime().gc();
    }

    @Override // com.tencent.luggage.wxa.f9.e
    public j e() {
        return c.a(1);
    }

    @Override // com.tencent.luggage.wxa.f9.e, com.tencent.luggage.wxa.f9.i
    public void release() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioFixedConvertProcess", "release");
        super.release();
        try {
            OutputStream outputStream = this.f125557s;
            if (outputStream != null) {
                outputStream.flush();
                this.f125557s.close();
                this.f125557s = null;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", e16, "outputStream close", new Object[0]);
        }
        try {
            InputStream inputStream = this.f125558t;
            if (inputStream != null) {
                inputStream.close();
                this.f125558t = null;
            }
        } catch (Exception e17) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", e17, "inputStream close", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.f9.i
    public com.tencent.luggage.wxa.c9.e a(int i3) {
        InputStream inputStream = this.f125558t;
        if (inputStream == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack, inputStream is null");
            return null;
        }
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            try {
                if (inputStream.read(bArr, 0, i3) > 0) {
                    com.tencent.luggage.wxa.c9.e b16 = com.tencent.luggage.wxa.d9.e.a().b();
                    b16.f123439f = bArr;
                    return b16;
                }
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack readSize is 0");
            } catch (Exception e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", e16, "readPcmDataTrack", new Object[0]);
            }
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.f9.i
    public void a() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache");
        if (this.f125558t == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, inputStream is null");
            return;
        }
        if (this.f125556r.h()) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, cache is complete");
            return;
        }
        int i3 = 0;
        while (i3 != -1) {
            byte[] bArr = new byte[3536];
            try {
                i3 = this.f125558t.read(bArr, 0, 3536);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioFixedConvertProcess", e16, "readPcmDataTrack", new Object[0]);
            }
            if (i3 > 0) {
                com.tencent.luggage.wxa.c9.e b16 = com.tencent.luggage.wxa.d9.e.a().b();
                b16.f123439f = bArr;
                this.f125556r.b(b16);
            }
        }
        this.f125556r.c();
    }
}
