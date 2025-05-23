package com.tencent.qmethod.pandoraex.core.ext.netcap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public String f344112a;

    /* renamed from: b, reason: collision with root package name */
    private o f344113b;

    /* renamed from: e, reason: collision with root package name */
    public String f344116e;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, List<String>> f344114c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    int f344115d = 1;

    /* renamed from: f, reason: collision with root package name */
    public long f344117f = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f344118g = "";

    /* renamed from: h, reason: collision with root package name */
    private long f344119h = 0;

    public p(String str) {
        this.f344116e = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputStream a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getErrorStream();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputStream b(HttpURLConnection httpURLConnection) throws IOException {
        if (this.f344113b == null) {
            Map<String, List<String>> map = this.f344114c;
            String str = "";
            long j3 = 0;
            if (map != null) {
                List<String> list = map.get("Content-Type");
                if (list != null && list.size() > 0) {
                    str = list.get(0);
                }
                try {
                    List<String> list2 = map.get("Content-Length");
                    if (list2 != null && list2.size() > 0) {
                        j3 = Long.parseLong(list2.get(0));
                    }
                } catch (Exception unused) {
                }
            }
            this.f344113b = new o(httpURLConnection.getOutputStream(), k.a(this.f344112a, this.f344116e, str, j3));
        }
        return this.f344113b;
    }

    void c(HttpURLConnection httpURLConnection) {
        byte[] bArr;
        if (this.f344115d > 3) {
            return;
        }
        try {
            o oVar = this.f344113b;
            if (oVar != null) {
                bArr = oVar.f344110e.toByteArray();
            } else {
                bArr = null;
            }
            k.e(httpURLConnection.getURL().getProtocol().toUpperCase(), this.f344116e, this.f344114c, bArr, this.f344117f, "openConnection", this.f344118g, this.f344119h);
        } catch (Exception e16) {
            com.tencent.qmethod.pandoraex.core.o.d("URLConnectionRecorder", "logRequestBody", e16);
        }
    }

    void d(HttpURLConnection httpURLConnection) {
        if (this.f344115d > 2) {
            return;
        }
        try {
            this.f344114c = httpURLConnection.getRequestProperties();
        } catch (Exception e16) {
            com.tencent.qmethod.pandoraex.core.o.d("", "logRequestHeader", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i3, HttpURLConnection httpURLConnection) {
        while (true) {
            int i16 = this.f344115d;
            if (i16 < i3) {
                int i17 = i16 + 1;
                this.f344115d = i17;
                if (i17 != 2) {
                    if (i17 == 3) {
                        c(httpURLConnection);
                    }
                } else {
                    this.f344117f = System.currentTimeMillis();
                    d(httpURLConnection);
                }
            } else {
                return;
            }
        }
    }
}
