package com.tencent.luggage.wxa.oi;

import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements com.tencent.luggage.wxa.qb.f {

    /* renamed from: a, reason: collision with root package name */
    public String f136533a;

    /* renamed from: b, reason: collision with root package name */
    public String f136534b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.h6.a f136535c;

    /* renamed from: d, reason: collision with root package name */
    public long f136536d;

    public d(String str, String str2) {
        this.f136535c = null;
        this.f136533a = str;
        this.f136534b = str2;
        this.f136535c = b(str, str2);
    }

    public final com.tencent.luggage.wxa.h6.a b(String str, String str2) {
        long nanoTime = System.nanoTime();
        if (w0.c(str2)) {
            w.b("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
            return null;
        }
        a0 a0Var = new a0(new v(str2));
        if (!a0Var.q()) {
            a0Var.close();
            w.b("MicroMsg.WxaAudioDataSource", "pkg invalid");
            return null;
        }
        if (!a0Var.m()) {
            a0Var.close();
            w.b("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
            return null;
        }
        InputStream b16 = a0Var.b(str);
        if (b16 == null) {
            a0Var.close();
            w.b("MicroMsg.WxaAudioDataSource", "inputstream for %s is null", str);
            return null;
        }
        a0Var.close();
        w.a("MicroMsg.WxaAudioDataSource", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
        return (com.tencent.luggage.wxa.h6.a) b16;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.tencent.luggage.wxa.h6.a aVar = this.f136535c;
        if (aVar != null) {
            w.d("MicroMsg.WxaAudioDataSource", "close");
            aVar.close();
            this.f136535c = null;
        }
    }

    @Override // com.tencent.luggage.wxa.qb.f
    public int getAudioType() {
        String str;
        if (this.f136535c == null) {
            this.f136535c = b(this.f136533a, this.f136534b);
        }
        if (this.f136535c == null) {
            w.b("MicroMsg.WxaAudioDataSource", "[getAudioType] inputStream is null");
            return 0;
        }
        if (this.f136533a.toLowerCase().endsWith(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)) {
            w.a("MicroMsg.WxaAudioDataSource", "[getAudioType] mp3");
            return 2;
        }
        if (this.f136533a.toLowerCase().contains(".wav")) {
            w.a("MicroMsg.WxaAudioDataSource", "[getAudioType] wav");
            return 3;
        }
        if (this.f136533a.toLowerCase().contains(".ogg")) {
            w.a("MicroMsg.WxaAudioDataSource", "[getAudioType] ogg");
            return 4;
        }
        try {
            try {
                byte[] bArr = new byte[64];
                this.f136535c.a(0);
                this.f136535c.read(bArr);
                str = new String(bArr);
            } catch (Exception e16) {
                w.b("MicroMsg.WxaAudioDataSource", "getAudioType", e16);
                this.f136535c.a(0);
                str = null;
            }
            if (str == null || !str.contains("ftyp")) {
                return 0;
            }
            w.a("MicroMsg.WxaAudioDataSource", "[getAudioType] aac");
            return 1;
        } finally {
            this.f136535c.a(0);
        }
    }

    @Override // com.tencent.luggage.wxa.qb.f
    public long getSize() {
        com.tencent.luggage.wxa.h6.a aVar = this.f136535c;
        if (aVar == null) {
            w.b("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
            return 0L;
        }
        return aVar.d();
    }

    @Override // com.tencent.luggage.wxa.qb.f
    public boolean isOpen() {
        if (this.f136535c != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.qb.f
    public void open() {
        w.d("MicroMsg.WxaAudioDataSource", "open");
        if (this.f136535c == null) {
            this.f136535c = b(this.f136533a, this.f136534b);
        }
        this.f136536d = 0L;
        com.tencent.luggage.wxa.h6.a aVar = this.f136535c;
        if (aVar != null) {
            aVar.a(0);
        }
    }

    @Override // com.tencent.luggage.wxa.qb.f
    public int readAt(long j3, byte[] bArr, int i3, int i16) {
        if (this.f136535c == null) {
            w.b("MicroMsg.WxaAudioDataSource", "[readAt]inputstream is null");
            return -1;
        }
        if (bArr != null && bArr.length > 0) {
            if (j3 >= 0 && i3 >= 0 && i16 > 0) {
                if (i3 + i16 > bArr.length) {
                    w.b("MicroMsg.WxaAudioDataSource", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(bArr.length));
                    return -1;
                }
                if (i16 + j3 > getSize()) {
                    w.b("MicroMsg.WxaAudioDataSource", "position:%d, size:%d, getSize():%d", Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(getSize()));
                }
                if (this.f136536d != j3) {
                    this.f136535c.a((int) j3);
                    this.f136536d = j3;
                }
                int read = this.f136535c.read(bArr, i3, i16);
                if (read >= 0) {
                    this.f136536d += read;
                }
                return read;
            }
            w.b("MicroMsg.WxaAudioDataSource", "position:%d, offset:%d, size:%d", Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return -1;
        }
        w.b("MicroMsg.WxaAudioDataSource", "[readAt]bytes is null");
        return -1;
    }
}
