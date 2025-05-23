package com.qq.e.comm.plugin.i.core;

import android.os.Process;
import android.text.TextUtils;
import com.qq.e.comm.plugin.i.d;
import com.qq.e.comm.plugin.i.d.a;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.k.ac;
import com.qq.e.comm.util.GDTLogger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements com.qq.e.comm.plugin.i.d.a {

    /* renamed from: a, reason: collision with root package name */
    private final String f39463a;

    /* renamed from: b, reason: collision with root package name */
    private final a.InterfaceC0286a f39464b;

    /* renamed from: c, reason: collision with root package name */
    private final int f39465c;

    /* renamed from: d, reason: collision with root package name */
    private final int f39466d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f39467e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f39468f;

    public a(String str, a.InterfaceC0286a interfaceC0286a, int i3, int i16, boolean z16) {
        this.f39463a = str;
        this.f39464b = interfaceC0286a;
        this.f39465c = i3;
        this.f39466d = i16;
        this.f39468f = z16;
    }

    private void c() throws d {
        try {
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.f39463a).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(this.f39465c);
                        httpURLConnection2.setReadTimeout(this.f39466d);
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                        HttpURLConnection a16 = ac.a(httpURLConnection2);
                        int responseCode = a16.getResponseCode();
                        GDTLogger.d("ConnectTask responseCode :" + responseCode);
                        boolean z16 = true;
                        if (!c.a("splash_preload_material_shard_download", 1, 1) || !this.f39468f) {
                            z16 = false;
                        }
                        if (responseCode == 200) {
                            a(a16, false);
                        } else if (responseCode == 206) {
                            a(a16, z16);
                        } else {
                            throw new d(108, responseCode);
                        }
                        try {
                            a16.disconnect();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
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
                                th7.printStackTrace();
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

    private void d() throws d {
        if (!b()) {
        } else {
            throw new d(107, "Download paused");
        }
    }

    @Override // com.qq.e.comm.plugin.i.d.a
    public void a() {
        this.f39467e = 107;
    }

    public boolean b() {
        if (this.f39467e == 107) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.f39467e = 102;
        a.InterfaceC0286a interfaceC0286a = this.f39464b;
        if (interfaceC0286a != null) {
            interfaceC0286a.i();
        }
        try {
            c();
        } catch (d e16) {
            a(e16);
        }
    }

    private void a(HttpURLConnection httpURLConnection, boolean z16) throws d {
        long contentLength;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField) && !headerField.equals("0") && !headerField.equals("-1")) {
            contentLength = Long.parseLong(headerField);
        } else {
            contentLength = httpURLConnection.getContentLength();
        }
        d();
        this.f39467e = 103;
        a.InterfaceC0286a interfaceC0286a = this.f39464b;
        if (interfaceC0286a != null) {
            interfaceC0286a.a(contentLength, z16);
        }
    }

    private void a(d dVar) {
        int a16 = dVar.a();
        if (a16 == 107) {
            this.f39467e = 107;
            a.InterfaceC0286a interfaceC0286a = this.f39464b;
            if (interfaceC0286a != null) {
                synchronized (interfaceC0286a) {
                    this.f39464b.j();
                }
                return;
            }
            return;
        }
        if (a16 == 108) {
            this.f39467e = 108;
            a.InterfaceC0286a interfaceC0286a2 = this.f39464b;
            if (interfaceC0286a2 != null) {
                synchronized (interfaceC0286a2) {
                    this.f39464b.a(dVar);
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Unknown state");
    }
}
