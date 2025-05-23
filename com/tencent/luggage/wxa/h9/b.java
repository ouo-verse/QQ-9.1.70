package com.tencent.luggage.wxa.h9;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f126935a = false;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f126936b = true;

    /* renamed from: c, reason: collision with root package name */
    public e f126937c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.qb.b f126938d;

    public b(e eVar) {
        this.f126937c = eVar;
    }

    @Override // com.tencent.luggage.wxa.h9.g
    public void a(com.tencent.luggage.wxa.l9.c cVar) {
        this.f126936b = false;
        if (cVar == null) {
            e eVar = this.f126937c;
            if (eVar != null) {
                eVar.a(null);
            }
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDownloadProcess", "process source is null");
            this.f126936b = true;
            return;
        }
        this.f126935a = false;
        com.tencent.luggage.wxa.qb.b c16 = cVar.c();
        if (c16 != null) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadProcess", "audio:%s, url:%s", c16.f138564a, c16.f138565b);
        }
        this.f126938d = c16;
        cVar.a();
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadProcess", "source connect, stop:%b", Boolean.valueOf(this.f126936b));
        long j3 = -1;
        String str = "";
        int i3 = 0;
        while (true) {
            if (i3 >= 3 || this.f126936b) {
                break;
            }
            i3++;
            if (j3 <= 0) {
                j3 = cVar.getSize();
            }
            if (TextUtils.isEmpty(str)) {
                str = cVar.b();
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadProcess", "fileSize:%d, mimetype:%s, tryCount:%d", Long.valueOf(j3), str, Integer.valueOf(i3));
            if (j3 > 0 && !TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str) && str.contains("text/")) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDownloadProcess", "mimetype not support");
                } else {
                    byte[] bArr = new byte[8192];
                    int i16 = 0;
                    while (true) {
                        long j16 = i16;
                        if (j16 >= j3 || this.f126936b) {
                            break;
                        }
                        int readAt = cVar.readAt(j16, bArr, 0, 8192);
                        if (readAt < 0) {
                            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDownloadProcess", "readSize:%d, terminal process or read end", Integer.valueOf(readAt));
                            break;
                        }
                        i16 += readAt;
                    }
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadProcess", "offSize:%d", Integer.valueOf(i16));
                    this.f126935a = true;
                }
            }
        }
        cVar.disconnect();
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadProcess", "source disconnect");
    }

    @Override // com.tencent.luggage.wxa.h9.g
    public void stop() {
        this.f126936b = true;
    }

    @Override // com.tencent.luggage.wxa.h9.g
    public void a(c cVar) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadProcess", "download process end, download finish:%b", Boolean.valueOf(this.f126935a));
        d.d(cVar);
        if (this.f126935a) {
            e eVar = this.f126937c;
            if (eVar != null) {
                eVar.b(this.f126938d);
            }
        } else {
            e eVar2 = this.f126937c;
            if (eVar2 != null) {
                eVar2.a(this.f126938d);
            }
        }
        this.f126936b = true;
        cVar.b();
        this.f126937c = null;
    }
}
