package com.tencent.luggage.wxa.oi;

import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.x;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements com.tencent.luggage.wxa.qb.f {

    /* renamed from: g, reason: collision with root package name */
    public static x f136537g = new x(50);

    /* renamed from: h, reason: collision with root package name */
    public static x f136538h = new x(50);

    /* renamed from: i, reason: collision with root package name */
    public static x f136539i = new x(50);

    /* renamed from: a, reason: collision with root package name */
    public String f136540a;

    /* renamed from: b, reason: collision with root package name */
    public String f136541b;

    /* renamed from: c, reason: collision with root package name */
    public RandomAccessFile f136542c;

    /* renamed from: d, reason: collision with root package name */
    public int f136543d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f136544e = -1;

    /* renamed from: f, reason: collision with root package name */
    public long f136545f;

    public e(String str, String str2) {
        this.f136540a = str;
        this.f136541b = str2;
        this.f136542c = b(str, str2);
        c(str, str2);
    }

    public final RandomAccessFile b(String str, String str2) {
        RandomAccessFile randomAccessFile;
        if (w0.c(str2)) {
            w.b("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
            return null;
        }
        w.d("MicroMsg.WxaAudioDataSourceBelow19", "filePath:%s, resLength:%d, fileOffset:%d", str, Integer.valueOf(this.f136543d), Integer.valueOf(this.f136544e));
        try {
            try {
                if (!new v(str2).e()) {
                    w.b("MicroMsg.WxaAudioDataSourceBelow19", "file pkgPath:%s isn't exist ", str2);
                    return null;
                }
                RandomAccessFile c16 = com.tencent.luggage.wxa.cp.x.c(str2, false);
                try {
                    w.a("MicroMsg.WxaAudioDataSourceBelow19", "randomAccessFile.length:%d", Long.valueOf(c16.length()));
                    return c16;
                } catch (IOException e16) {
                    randomAccessFile = c16;
                    e = e16;
                    w.a("MicroMsg.WxaAudioDataSourceBelow19", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused) {
                        }
                    }
                    return null;
                }
            } catch (IOException e17) {
                e = e17;
                randomAccessFile = null;
            }
        } catch (FileNotFoundException e18) {
            w.a("MicroMsg.WxaAudioDataSourceBelow19", e18, "", new Object[0]);
            return null;
        }
    }

    public final void c(String str, String str2) {
        int i3;
        if (f136537g.a(str) && f136538h.a(str)) {
            this.f136543d = ((Integer) f136537g.get(str)).intValue();
            this.f136544e = ((Integer) f136538h.get(str)).intValue();
            return;
        }
        if (w0.c(str2)) {
            w.b("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
            return;
        }
        a0 a0Var = new a0(str2);
        if (!a0Var.q()) {
            a0Var.close();
            w.b("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
            return;
        }
        if (!a0Var.m()) {
            a0Var.close();
            w.b("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
            return;
        }
        a0.a c16 = a0Var.c(str);
        if (c16 == null) {
            a0Var.close();
            w.b("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
            return;
        }
        int i16 = c16.f134265d;
        if (i16 > 0 && (i3 = c16.f134264c) > 0) {
            this.f136543d = i16;
            this.f136544e = i3;
            f136537g.put(str, Integer.valueOf(i16));
            f136538h.put(str, Integer.valueOf(this.f136544e));
            a0Var.close();
            return;
        }
        a0Var.close();
        w.b("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f136542c != null) {
            w.d("MicroMsg.WxaAudioDataSourceBelow19", "close %d", Integer.valueOf(hashCode()));
            this.f136542c.close();
            this.f136542c = null;
        }
    }

    @Override // com.tencent.luggage.wxa.qb.f
    public int getAudioType() {
        String str;
        if (this.f136542c == null) {
            this.f136542c = b(this.f136540a, this.f136541b);
        }
        if (f136539i.a(this.f136540a)) {
            return ((Integer) f136539i.get(this.f136540a)).intValue();
        }
        if (this.f136542c == null) {
            w.b("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] inputStream is null");
            return 0;
        }
        if (this.f136540a.toLowerCase().endsWith(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)) {
            w.a("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] mp3");
            return 2;
        }
        if (this.f136540a.toLowerCase().contains(".wav")) {
            w.a("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] wav");
            return 3;
        }
        if (this.f136540a.toLowerCase().contains(".ogg")) {
            w.a("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] ogg");
            return 4;
        }
        try {
            try {
                byte[] bArr = new byte[64];
                this.f136542c.seek(this.f136544e);
                this.f136542c.read(bArr);
                str = new String(bArr);
            } catch (Exception e16) {
                w.b("MicroMsg.WxaAudioDataSourceBelow19", "getAudioType", e16);
                this.f136542c.seek(this.f136544e);
                str = null;
            }
            if (str == null || !str.contains("ftyp")) {
                return 0;
            }
            w.a("MicroMsg.WxaAudioDataSourceBelow19", "[getAudioType] aac");
            f136539i.put(this.f136540a, 1);
            return 1;
        } finally {
            this.f136542c.seek(this.f136544e);
        }
    }

    @Override // com.tencent.luggage.wxa.qb.f
    public long getSize() {
        if (this.f136542c == null) {
            w.b("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
            return 0L;
        }
        return this.f136543d;
    }

    @Override // com.tencent.luggage.wxa.qb.f
    public boolean isOpen() {
        if (this.f136542c == null && this.f136543d != -1 && this.f136544e != -1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.qb.f
    public void open() {
        w.d("MicroMsg.WxaAudioDataSourceBelow19", "open %d", Integer.valueOf(hashCode()));
        if (this.f136542c == null) {
            this.f136542c = b(this.f136540a, this.f136541b);
        }
        this.f136545f = 0L;
        RandomAccessFile randomAccessFile = this.f136542c;
        if (randomAccessFile != null) {
            randomAccessFile.seek(this.f136544e);
        }
    }

    @Override // com.tencent.luggage.wxa.qb.f
    public int readAt(long j3, byte[] bArr, int i3, int i16) {
        RandomAccessFile randomAccessFile = this.f136542c;
        if (randomAccessFile == null) {
            w.b("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
            return -1;
        }
        if (this.f136545f != j3) {
            randomAccessFile.seek(this.f136544e + j3);
            this.f136545f = j3;
        }
        if (bArr != null && bArr.length > 0) {
            if (j3 >= 0 && i3 >= 0 && i16 > 0) {
                if (i3 + i16 > bArr.length) {
                    w.b("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(bArr.length));
                    return -1;
                }
                long j16 = this.f136543d;
                if (j3 >= j16) {
                    w.b("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", Long.valueOf(j3), Integer.valueOf(this.f136543d));
                    return -1;
                }
                if (i16 + j3 >= j16) {
                    w.b("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(this.f136543d));
                    i16 = (int) (this.f136543d - j3);
                }
                int read = this.f136542c.read(bArr, i3, i16);
                if (read >= 0) {
                    this.f136545f += read;
                } else {
                    w.b("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", Integer.valueOf(read));
                }
                return read;
            }
            w.b("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return -1;
        }
        w.b("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
        return -1;
    }
}
