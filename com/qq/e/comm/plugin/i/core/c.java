package com.qq.e.comm.plugin.i.core;

import android.os.Process;
import com.qq.e.comm.plugin.i.b.a;
import com.qq.e.comm.plugin.i.d;
import com.qq.e.comm.plugin.i.d.b;
import com.qq.e.comm.plugin.i.e;
import com.qq.e.comm.plugin.i.i;
import com.qq.e.comm.plugin.k.ac;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.oskplayer.cache.FileDataSink;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class c implements b {

    /* renamed from: a, reason: collision with root package name */
    protected final e f39470a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f39471b = false;

    /* renamed from: c, reason: collision with root package name */
    protected a f39472c;

    /* renamed from: d, reason: collision with root package name */
    private final i f39473d;

    /* renamed from: e, reason: collision with root package name */
    private final b.a f39474e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f39475f;

    /* renamed from: g, reason: collision with root package name */
    private volatile int f39476g;

    public c(e eVar, i iVar, b.a aVar, a aVar2) {
        this.f39470a = eVar;
        this.f39473d = iVar;
        this.f39474e = aVar;
        this.f39472c = aVar2;
    }

    private void k() throws d {
        if (this.f39476g != 107) {
            if (this.f39476g != 106) {
                return;
            }
            b(this.f39473d);
            throw new d(106, "Download paused");
        }
        throw new d(107, "Download canceled");
    }

    @Override // com.qq.e.comm.plugin.i.d.b
    public void a() {
        this.f39476g = 106;
    }

    @Override // com.qq.e.comm.plugin.i.d.b
    public boolean b() {
        return this.f39475f == 104;
    }

    @Override // com.qq.e.comm.plugin.i.d.b
    public boolean c() {
        return this.f39475f == 105;
    }

    @Override // com.qq.e.comm.plugin.i.d.b
    public boolean d() {
        if (this.f39475f == 108) {
            return true;
        }
        return false;
    }

    protected abstract void e();

    protected abstract void f();

    protected abstract void g();

    public i h() {
        return this.f39473d;
    }

    protected void i() throws d {
        try {
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.f39473d.f()).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(10000);
                        httpURLConnection2.setReadTimeout(10000);
                        httpURLConnection2.setRequestMethod("GET");
                        a(c(this.f39473d), httpURLConnection2);
                        HttpURLConnection a16 = ac.a(httpURLConnection2);
                        int responseCode = a16.getResponseCode();
                        GDTLogger.d("DownloadTask responseCode :" + responseCode);
                        GDTLogger.d("DownloadTask response threadInfo:" + this.f39473d);
                        if (responseCode == j()) {
                            a(a16);
                            try {
                                a16.disconnect();
                                return;
                            } catch (Throwable th5) {
                                GDTLogger.e("DownloadTaskImpl download Throwable", th5);
                                return;
                            }
                        }
                        throw new d(108, responseCode);
                    } catch (ProtocolException e16) {
                        e = e16;
                        throw new d(108, 1001, e);
                    } catch (IOException e17) {
                        e = e17;
                        throw new d(108, 1002, e);
                    } catch (Exception e18) {
                        e = e18;
                        if (e instanceof d) {
                            throw ((d) e);
                        }
                        throw new d(108, 999, e);
                    } catch (Throwable th6) {
                        th = th6;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th7) {
                                GDTLogger.e("DownloadTaskImpl download Throwable", th7);
                            }
                        }
                        throw th;
                    }
                } catch (ProtocolException e19) {
                    e = e19;
                } catch (IOException e26) {
                    e = e26;
                } catch (Exception e27) {
                    e = e27;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (MalformedURLException e28) {
            throw new d(108, 1000, e28);
        }
    }

    protected abstract int j();

    @Override // java.lang.Runnable
    public void run() {
        long j3;
        long j16;
        f();
        GDTLogger.d("DownloadTask run threadInfo:" + this.f39473d);
        Process.setThreadPriority(10);
        a(this.f39473d);
        try {
            this.f39475f = 104;
            i();
            e();
            synchronized (this.f39474e) {
                if (this.f39471b) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("DownloaderImpl onPartialCompleted :");
                    i iVar = this.f39473d;
                    if (iVar != null) {
                        j3 = iVar.a();
                    } else {
                        j3 = -1;
                    }
                    sb5.append(j3);
                    GDTLogger.d(sb5.toString());
                    this.f39475f = 109;
                    b.a aVar = this.f39474e;
                    i iVar2 = this.f39473d;
                    if (iVar2 != null) {
                        j16 = iVar2.a();
                    } else {
                        j16 = 0;
                    }
                    aVar.a(j16);
                } else {
                    this.f39475f = 105;
                    this.f39474e.k();
                }
            }
        } catch (d e16) {
            g();
            a(e16);
        }
    }

    protected void a(d dVar) {
        switch (dVar.a()) {
            case 106:
                synchronized (this.f39474e) {
                    this.f39475f = 106;
                    this.f39474e.l();
                }
                return;
            case 107:
                synchronized (this.f39474e) {
                    this.f39475f = 107;
                    this.f39474e.m();
                }
                return;
            case 108:
                synchronized (this.f39474e) {
                    this.f39475f = 108;
                    this.f39474e.b(dVar);
                }
                return;
            default:
                synchronized (this.f39474e) {
                    this.f39475f = 108;
                    this.f39474e.b(dVar);
                }
                throw new IllegalArgumentException("Unknown state");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(i iVar) {
        a aVar = this.f39472c;
        if (aVar == null || iVar == null) {
            return;
        }
        aVar.a(iVar.e(), iVar.c(), iVar.b());
    }

    protected Map<String, String> c(i iVar) {
        if (iVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Range", "bytes=" + (iVar.d() + iVar.b()) + "-" + iVar.a());
        return hashMap;
    }

    private void a(HttpURLConnection httpURLConnection) throws d {
        Closeable closeable;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
            } catch (IOException e16) {
                throw new d(108, 1003, e16);
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
        }
        try {
            long d16 = this.f39473d.d() + this.f39473d.b();
            try {
                File b16 = this.f39470a.b();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.f39470a.a());
                sb5.append(this.f39471b ? ".part" : FileDataSink.TEMP_FILE);
                RandomAccessFile a16 = a(b16, sb5.toString(), d16);
                GDTLogger.d("transferData raf offset :" + d16);
                a(inputStream, a16);
                try {
                    com.qq.e.comm.plugin.i.f.a.a(inputStream);
                    com.qq.e.comm.plugin.i.f.a.a(a16);
                } catch (IOException e17) {
                    e17.printStackTrace();
                } catch (Exception e18) {
                    GDTLogger.e(e18.getMessage());
                }
            } catch (IOException e19) {
                throw new d(108, 1004, e19);
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            closeable = null;
            try {
                com.qq.e.comm.plugin.i.f.a.a(inputStream2);
                com.qq.e.comm.plugin.i.f.a.a(closeable);
            } catch (IOException e26) {
                e26.printStackTrace();
            } catch (Exception e27) {
                GDTLogger.e(e27.getMessage());
            }
            throw th;
        }
    }

    private void a(InputStream inputStream, RandomAccessFile randomAccessFile) throws d {
        byte[] bArr = new byte[16384];
        while (true) {
            k();
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return;
                }
                try {
                    randomAccessFile.write(bArr, 0, read);
                    i iVar = this.f39473d;
                    long j3 = read;
                    iVar.b(iVar.b() + j3);
                    synchronized (this.f39474e) {
                        e eVar = this.f39470a;
                        eVar.b(eVar.e() + j3);
                        this.f39474e.a(this.f39470a.e(), this.f39470a.d());
                    }
                } catch (IOException e16) {
                    throw new d(108, 1006, e16);
                }
            } catch (IOException e17) {
                throw new d(108, 1005, e17);
            }
        }
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.setRequestProperty(str, map.get(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar) {
        a aVar;
        if (iVar == null || (aVar = this.f39472c) == null || aVar.a(iVar.e(), iVar.c())) {
            return;
        }
        this.f39472c.a(iVar);
    }

    protected RandomAccessFile a(File file, String str, long j3) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        randomAccessFile.seek(j3);
        return randomAccessFile;
    }
}
