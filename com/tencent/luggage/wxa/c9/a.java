package com.tencent.luggage.wxa.c9;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public RandomAccessFile f123410a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f123411b;

    /* renamed from: c, reason: collision with root package name */
    public String f123412c;

    /* renamed from: d, reason: collision with root package name */
    public String f123413d;

    public a(String str, String str2) {
        this.f123412c = str;
        this.f123411b = str2;
        String a16 = a(str, str2);
        this.f123413d = a16;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmCacheFile", "AudioPcmCacheFile mUrl:%s, fileName:%s,", this.f123411b, a16);
    }

    public boolean a(boolean z16) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmCacheFile", "open");
        try {
            try {
                v vVar = new v(this.f123413d);
                if (!vVar.e()) {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmCacheFile", "create file:%b", Boolean.valueOf(vVar.c()));
                } else if (!z16) {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmCacheFile", "delete");
                    vVar.d();
                }
                this.f123410a = x.c(vVar.m(), true);
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.f123413d);
                return true;
            } catch (FileNotFoundException e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "file not found", e16);
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.f123413d);
                return false;
            } catch (IOException e17) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "io ", e17);
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.f123413d);
                return false;
            }
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.f123413d);
            throw th5;
        }
    }

    public synchronized boolean b(byte[] bArr, long j3, int i3) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "write error, length == 0");
            return false;
        }
        RandomAccessFile randomAccessFile = this.f123410a;
        if (randomAccessFile == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "write error, randomAccessFile is null");
            return false;
        }
        try {
            randomAccessFile.seek(j3);
            this.f123410a.write(bArr, 0, i3);
            return true;
        } catch (IOException unused) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", String.format("Error writing %d bytes to from buffer with size %d", Integer.valueOf(i3), Integer.valueOf(bArr.length)));
            return false;
        }
    }

    public synchronized int c() {
        RandomAccessFile randomAccessFile = this.f123410a;
        if (randomAccessFile == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "getLength error, randomAccessFile is null");
            return -1;
        }
        try {
            return (int) randomAccessFile.length();
        } catch (IOException e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "Error get length of file , err %s", "" + e16.getMessage());
            return -1;
        }
    }

    public void b() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmCacheFile", "deleteFile");
        a(this.f123413d);
    }

    public synchronized void a() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmCacheFile", "close");
        RandomAccessFile randomAccessFile = this.f123410a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "close RandomAccessFile error ", "" + e16.getMessage());
            }
        }
    }

    public synchronized int a(byte[] bArr, long j3, int i3) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "read error, length == 0");
            return -1;
        }
        RandomAccessFile randomAccessFile = this.f123410a;
        if (randomAccessFile == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "read error, randomAccessFile is null");
            return -1;
        }
        try {
            randomAccessFile.seek(j3);
            return this.f123410a.read(bArr, 0, i3);
        } catch (IOException unused) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(c()), Integer.valueOf(bArr.length)));
            return -1;
        }
    }

    public synchronized void a(long j3) {
        if (this.f123410a == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "setLength error, randomAccessFile is null");
            return;
        }
        if (j3 <= 0) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "setLength error, length is " + j3);
            return;
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "set file length %s ", "" + j3);
        try {
            this.f123410a.setLength(j3);
        } catch (IOException e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "Error set length of file, err %s", "" + e16.getMessage());
        }
    }

    public static String a(String str, String str2) {
        return com.tencent.luggage.wxa.m9.a.b(str, str2);
    }

    public static void a(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmCacheFile", "deleteFile, fileName:" + str);
        v vVar = new v(str);
        if (vVar.e()) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmCacheFile", "delete the piece File");
            vVar.d();
        } else {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmCacheFile", "file not exist, delete piece File fail");
        }
    }
}
