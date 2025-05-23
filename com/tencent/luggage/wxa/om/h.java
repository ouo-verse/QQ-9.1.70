package com.tencent.luggage.wxa.om;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public RandomAccessFile f137041a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f137042b;

    /* renamed from: c, reason: collision with root package name */
    public String f137043c;

    public h(String str) {
        this.f137042b = str;
        String f16 = f(str);
        this.f137043c = f16;
        w.d("MicroMsg.Music.PieceFileCache", "PieceFileCache mUrl:%s, fileName:%s,", this.f137042b, f16);
    }

    public synchronized void a() {
        Logger.i("MicroMsg.Music.PieceFileCache", "close");
        RandomAccessFile randomAccessFile = this.f137041a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e16) {
                Logger.e("MicroMsg.Music.PieceFileCache", "close RandomAccessFile error ", "" + e16.getMessage());
            }
        }
    }

    public synchronized boolean b(byte[] bArr, long j3, int i3) {
        if (i3 == 0) {
            Logger.e("MicroMsg.Music.PieceFileCache", "write error, length == 0");
            return false;
        }
        RandomAccessFile randomAccessFile = this.f137041a;
        if (randomAccessFile == null) {
            Logger.e("MicroMsg.Music.PieceFileCache", "write error, randomAccessFile is null");
            return false;
        }
        try {
            randomAccessFile.seek(j3);
            this.f137041a.write(bArr, 0, i3);
            return true;
        } catch (IOException unused) {
            Logger.e("MicroMsg.Music.PieceFileCache", String.format("Error writing %d bytes to from buffer with size %d", Integer.valueOf(i3), Integer.valueOf(bArr.length)));
            return false;
        }
    }

    public synchronized long c() {
        v vVar = new v(this.f137043c);
        if (!vVar.e()) {
            return -1L;
        }
        return vVar.s();
    }

    public synchronized int d() {
        RandomAccessFile randomAccessFile = this.f137041a;
        if (randomAccessFile == null) {
            Logger.e("MicroMsg.Music.PieceFileCache", "getLength error, randomAccessFile is null");
            return -1;
        }
        try {
            return (int) randomAccessFile.length();
        } catch (IOException e16) {
            Logger.e("MicroMsg.Music.PieceFileCache", "Error get length of file , err %s", "" + e16.getMessage());
            return -1;
        }
    }

    public boolean e() {
        return new v(this.f137043c).e();
    }

    public void f() {
        Logger.i("MicroMsg.Music.PieceFileCache", "open");
        try {
            try {
                try {
                    v vVar = new v(this.f137043c);
                    if (!vVar.e()) {
                        w.d("MicroMsg.Music.PieceFileCache", "create file:%b", Boolean.valueOf(vVar.c()));
                    }
                    this.f137041a = x.c(vVar.m(), true);
                    Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", this.f137043c);
                } catch (IOException e16) {
                    Logger.e("MicroMsg.Music.PieceFileCache", "io ", e16);
                    Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", this.f137043c);
                }
            } catch (FileNotFoundException e17) {
                Logger.e("MicroMsg.Music.PieceFileCache", "file not found", e17);
                Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", this.f137043c);
            }
        } catch (Throwable th5) {
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", this.f137043c);
            throw th5;
        }
    }

    public static long e(String str) {
        v vVar = new v(f(str));
        if (vVar.e()) {
            return vVar.s();
        }
        return -1L;
    }

    public static boolean c(String str) {
        Logger.i("MicroMsg.Music.PieceFileCache", "existFile, fileName:" + str);
        boolean e16 = new v(str).e();
        w.d("MicroMsg.Music.PieceFileCache", "the piece File exist:%b", Boolean.valueOf(e16));
        return e16;
    }

    public static boolean d(String str) {
        Logger.i("MicroMsg.Music.PieceFileCache", "existFileByUrl");
        return c(f(str));
    }

    public synchronized int a(byte[] bArr, long j3, int i3) {
        if (i3 == 0) {
            Logger.e("MicroMsg.Music.PieceFileCache", "read error, length == 0");
            return -1;
        }
        RandomAccessFile randomAccessFile = this.f137041a;
        if (randomAccessFile == null) {
            Logger.e("MicroMsg.Music.PieceFileCache", "read error, randomAccessFile is null");
            return -1;
        }
        try {
            randomAccessFile.seek(j3);
            return this.f137041a.read(bArr, 0, i3);
        } catch (IOException unused) {
            Logger.e("MicroMsg.Music.PieceFileCache", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(d()), Integer.valueOf(bArr.length)));
            return -1;
        }
    }

    public void b() {
        Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile");
        a(this.f137043c);
    }

    public static void b(String str) {
        Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
        a(f(str));
    }

    public synchronized void a(long j3) {
        if (this.f137041a == null) {
            Logger.e("MicroMsg.Music.PieceFileCache", "setLength error, randomAccessFile is null");
            return;
        }
        if (j3 <= 0) {
            Logger.e("MicroMsg.Music.PieceFileCache", "setLength error, length is " + j3);
            return;
        }
        Logger.e("MicroMsg.Music.PieceFileCache", "set file length %s ", "" + j3);
        try {
            this.f137041a.setLength(j3);
        } catch (IOException e16) {
            Logger.e("MicroMsg.Music.PieceFileCache", "Error set length of file, err %s", "" + e16.getMessage());
        }
    }

    public static String f(String str) {
        return com.tencent.luggage.wxa.wm.b.c(str);
    }

    public static void a(String str) {
        Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile, fileName:" + str);
        v vVar = new v(str);
        if (vVar.e()) {
            Logger.i("MicroMsg.Music.PieceFileCache", "delete the piece File");
            vVar.d();
        } else {
            Logger.e("MicroMsg.Music.PieceFileCache", "file not exist, delete piece File fail");
        }
    }
}
