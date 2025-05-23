package com.tencent.luggage.wxa.om;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.vm.a f137008a;

    /* renamed from: b, reason: collision with root package name */
    public d f137009b;

    /* renamed from: c, reason: collision with root package name */
    public h f137010c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f137011d = new byte[81920];

    /* renamed from: e, reason: collision with root package name */
    public int f137012e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f137013f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f137014g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f137015h = 0;

    public a(com.tencent.luggage.wxa.vm.a aVar) {
        this.f137008a = aVar;
    }

    public void a() {
        String b16 = this.f137008a.b();
        d dVar = new d(b16);
        this.f137009b = dVar;
        dVar.a(d());
        this.f137009b.b();
        h hVar = new h(b16);
        this.f137010c = hVar;
        if (!hVar.e()) {
            w.d("MicroMsg.Music.FileBytesCacheMgr", "piece file not exist, clear cache!");
            this.f137009b.a();
        } else if (this.f137010c.c() != d() && d() != -1) {
            w.d("MicroMsg.Music.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
            this.f137009b.a();
            this.f137010c.b();
        } else if (d() == -1) {
            w.d("MicroMsg.Music.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
        } else {
            w.d("MicroMsg.Music.FileBytesCacheMgr", "piece file exist!");
        }
        long d16 = d();
        this.f137010c.f();
        this.f137010c.a(d16);
        g.a(b16, d16);
        w.d("MicroMsg.Music.FileBytesCacheMgr", "attach() fileLength is " + d16 + ",pieceFileCache length is " + this.f137010c.d());
        String mIMEType = this.f137008a.getMIMEType();
        if (!TextUtils.isEmpty(mIMEType) && !"application/octet-stream".equalsIgnoreCase(mIMEType)) {
            g.c(b16, mIMEType);
        }
        this.f137012e = -1;
        this.f137013f = 0;
        this.f137014g = -1;
        this.f137015h = 0;
    }

    public void b() {
        c();
        this.f137009b.d();
        this.f137010c.a();
        this.f137008a = null;
        w.d("MicroMsg.Music.FileBytesCacheMgr", "detach()");
    }

    public int c(byte[] bArr, int i3, int i16) {
        if (bArr == null || i3 < 0 || i16 < 0) {
            w.b("MicroMsg.Music.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", Integer.valueOf(i3), Integer.valueOf(i16));
            return -1;
        }
        if (d() <= 0) {
            w.b("MicroMsg.Music.FileBytesCacheMgr", "write() fileLength is error, file length is " + d());
            return -1;
        }
        int i17 = i3 + i16;
        long j3 = i17;
        if (j3 > d()) {
            w.b("MicroMsg.Music.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", Integer.valueOf(i17), Long.valueOf(d()));
            return -1;
        }
        if (c(i3) && c(i17)) {
            if (!b(i3) || !b(i17)) {
                if (b(i3)) {
                    a(bArr, i3, i16);
                    if (this.f137013f == 81920) {
                        c();
                        d(i17);
                    }
                } else {
                    c();
                    d(i3);
                    a(bArr, i3, i16);
                }
            }
        } else if (c(i3) && !c(i17) && b(i3)) {
            int i18 = 81920 - this.f137013f;
            int i19 = i16 - i18;
            if (i18 > 0) {
                a(bArr, i3, i18);
            }
            c();
            int i26 = i3 + i18;
            d(i26);
            if (i19 > 0) {
                a(bArr, i18, i26, i19);
            }
        } else {
            c();
            d(i3);
            a(bArr, i3, i16);
        }
        if (j3 == d()) {
            c();
            d(i17);
        }
        return 1;
    }

    public final synchronized void d(int i3) {
        this.f137014g = this.f137012e;
        this.f137015h = this.f137013f;
        this.f137012e = i3;
        this.f137013f = 0;
    }

    public long d() {
        return this.f137008a.getSize();
    }

    public int b(byte[] bArr, int i3, int i16) {
        if (bArr == null || i3 < 0 || i16 < 0) {
            w.b("MicroMsg.Music.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", Integer.valueOf(i3), Integer.valueOf(i16));
            return -1;
        }
        if (d() <= 0) {
            w.b("MicroMsg.Music.FileBytesCacheMgr", "read(), fileLength is error, file length is " + d());
            return -1;
        }
        int i17 = i3 + i16;
        if (i17 > d()) {
            w.b("MicroMsg.Music.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", Integer.valueOf(i3), Integer.valueOf(i17), Long.valueOf(d()));
            i16 = ((int) d()) - i3;
        }
        if (this.f137009b.a(i3, i16)) {
            return this.f137010c.a(bArr, i3, i16);
        }
        return -1;
    }

    public final synchronized boolean b(int i3) {
        boolean z16;
        int i16 = this.f137012e;
        if (i16 <= i3) {
            z16 = i3 <= i16 + this.f137013f;
        }
        return z16;
    }

    public final boolean a(int i3) {
        if (i3 <= 0) {
            return false;
        }
        int i16 = i3 - 1;
        if (this.f137009b.a(i16)) {
            return false;
        }
        int i17 = this.f137014g;
        int i18 = this.f137015h;
        if (i17 + i18 != this.f137012e || this.f137013f <= 0 || i18 < 8192) {
            return false;
        }
        w.d("MicroMsg.Music.FileBytesCacheMgr", "isCanSavePreviousIndex, save index :%d", Integer.valueOf(i16));
        return true;
    }

    public final synchronized boolean c(int i3) {
        int i16;
        i16 = this.f137012e;
        return i16 <= i3 && i3 <= i16 + 81920;
    }

    public final synchronized boolean c() {
        int i3;
        int i16 = this.f137012e;
        if (i16 >= 0 && (i3 = this.f137013f) > 0) {
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f137011d, 0, bArr, 0, i3);
            this.f137010c.b(bArr, this.f137012e, this.f137013f);
            int[] b16 = this.f137009b.b(this.f137012e, this.f137013f);
            if (b16 == null) {
                w.b("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll, range is null");
                return false;
            }
            int i17 = b16[0];
            if (i17 != -1 && b16[1] != -1) {
                while (i17 <= b16[1]) {
                    this.f137009b.e(i17);
                    i17++;
                }
                if (a(b16[0])) {
                    this.f137009b.e(b16[0] - 1);
                }
                this.f137009b.d();
                return true;
            }
            w.a("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", Integer.valueOf(i17), Integer.valueOf(b16[1]));
            return false;
        }
        w.b("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", Integer.valueOf(i16), Integer.valueOf(this.f137013f));
        return false;
    }

    public final synchronized void a(byte[] bArr, int i3, int i16) {
        int i17 = i3 - this.f137012e;
        this.f137013f = i17 + i16;
        System.arraycopy(bArr, 0, this.f137011d, i17, i16);
    }

    public final synchronized void a(byte[] bArr, int i3, int i16, int i17) {
        int i18 = i16 - this.f137012e;
        this.f137013f = i18 + i17;
        System.arraycopy(bArr, i3, this.f137011d, i18, i17);
    }
}
