package com.tencent.luggage.wxa.yq;

import android.os.AsyncTask;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.z;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.xweb.XWebSdk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class n extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.yq.b f146089a = null;

    /* renamed from: b, reason: collision with root package name */
    public b f146090b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f146091c = 0;

    /* renamed from: d, reason: collision with root package name */
    public Timer f146092d = null;

    /* renamed from: e, reason: collision with root package name */
    public long f146093e = 0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            x0.a("XWebHttpTask", "task retry execute! mRetrytimes = " + n.this.f146091c);
            n.b(n.this.f146090b, n.this.f146089a, n.this.f146091c);
            n.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f146095a;

        /* renamed from: b, reason: collision with root package name */
        public String f146096b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f146097c;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f146098a;

        /* renamed from: b, reason: collision with root package name */
        public long f146099b;

        /* renamed from: c, reason: collision with root package name */
        public long f146100c;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f146101a;

        /* renamed from: b, reason: collision with root package name */
        public String f146102b;

        /* renamed from: c, reason: collision with root package name */
        public int f146103c;

        /* renamed from: d, reason: collision with root package name */
        public int f146104d;

        /* renamed from: e, reason: collision with root package name */
        public String f146105e;

        /* renamed from: f, reason: collision with root package name */
        public int f146106f;

        /* renamed from: g, reason: collision with root package name */
        public long f146107g;

        /* renamed from: h, reason: collision with root package name */
        public long f146108h;

        /* renamed from: i, reason: collision with root package name */
        public int f146109i;

        /* renamed from: j, reason: collision with root package name */
        public String f146110j;

        /* renamed from: k, reason: collision with root package name */
        public String f146111k;

        /* renamed from: l, reason: collision with root package name */
        public String f146112l;

        /* renamed from: m, reason: collision with root package name */
        public String f146113m;

        /* renamed from: n, reason: collision with root package name */
        public String f146114n;
    }

    public static void b(b bVar, com.tencent.luggage.wxa.yq.b bVar2, int i3) {
        n nVar = new n();
        nVar.f146089a = bVar2;
        nVar.f146090b = bVar;
        nVar.f146091c = i3;
        nVar.f146093e = System.currentTimeMillis();
        nVar.execute(nVar.f146090b);
    }

    public final void c() {
        Timer timer = this.f146092d;
        if (timer != null) {
            timer.cancel();
            this.f146092d = null;
        }
    }

    public static void a(b bVar, com.tencent.luggage.wxa.yq.b bVar2) {
        n nVar = new n();
        nVar.f146089a = bVar2;
        nVar.f146090b = bVar;
        nVar.f146091c = 0;
        nVar.f146093e = System.currentTimeMillis();
        nVar.execute(nVar.f146090b);
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(d dVar) {
        if (dVar == null) {
            dVar = new d();
            dVar.f146103c = -10004;
            x0.a("XWebHttpTask", "invalid params para onPostExecute");
        }
        if (dVar.f146103c == 0) {
            x0.a("XWebHttpTask", "task succeed!");
            this.f146089a.onTaskSucceed(dVar);
            return;
        }
        x0.a("XWebHttpTask", "task failed! mRetCode = " + dVar.f146103c + " mRetrytimes = " + this.f146091c);
        if (a(dVar)) {
            b();
        } else {
            this.f146089a.onTaskFailed(dVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0114, code lost:
    
        r16 = r2;
        com.tencent.luggage.wxa.ar.x0.d("XWebHttpTask", "response headers:\n" + a(r12.getHeaderFields()));
        r6.f146110j = r12.getHeaderField(com.tencent.mobileqq.utils.httputils.HttpMsg.CDN_LOG_UUID);
        r6.f146111k = r12.getHeaderField("X-COS-META-MD5");
        r6.f146112l = r12.getHeaderField("server_ip");
        r6.f146113m = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        com.tencent.luggage.wxa.ar.x0.d("XWebHttpTask", "response, uuid:" + r6.f146110j + ", md5:" + r6.f146111k + ", serverip:" + r6.f146112l + ", downloadTime:" + r6.f146113m);
        r6.f146108h = r4;
        r6.f146107g = java.lang.System.currentTimeMillis() - r17.f146093e;
        r6.f146114n = java.net.InetAddress.getByName(r11.getHost()).getHostAddress();
        r0 = new java.lang.StringBuilder();
        r0.append("response, DNSServerIP:");
        r0.append(r6.f146112l);
        com.tencent.luggage.wxa.ar.x0.d("XWebHttpTask", r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c9, code lost:
    
        r3 = r7;
        r9 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x024c A[Catch: IOException -> 0x0248, TRY_LEAVE, TryCatch #1 {IOException -> 0x0248, blocks: (B:67:0x0244, B:57:0x024c), top: B:66:0x0244 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0244 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d doInBackground(b... bVarArr) {
        b bVar;
        String str;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        int responseCode;
        String str2;
        int contentLength;
        byte[] bArr;
        c cVar;
        long j3;
        String str3 = "task close failed, error:";
        FileOutputStream fileOutputStream2 = null;
        d dVar = null;
        if (bVarArr == null || bVarArr.length != 1 || (bVar = bVarArr[0]) == null) {
            return null;
        }
        com.tencent.luggage.wxa.yq.b bVar2 = this.f146089a;
        if (bVar2 != null) {
            bVar2.onTaskStarted();
        }
        d dVar2 = new d();
        dVar2.f146101a = bVar.f146095a;
        dVar2.f146102b = bVar.f146096b;
        dVar2.f146103c = 0;
        dVar2.f146105e = "";
        dVar2.f146106f = this.f146091c;
        dVar2.f146107g = 0L;
        dVar2.f146108h = 0L;
        dVar2.f146109i = 0;
        dVar2.f146104d = z.a(XWalkEnvironment.getApplicationContext());
        String str4 = bVar.f146095a;
        if (str4 != null && bVar.f146096b != null && str4.length() != 0 && bVar.f146096b.length() != 0 && this.f146089a != null) {
            try {
                URL url = new URL(bVar.f146095a);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("User-Agent", a());
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    responseCode = httpURLConnection.getResponseCode();
                } catch (Throwable th5) {
                    th = th5;
                    str = "task close failed, error:";
                }
            } catch (Throwable th6) {
                th = th6;
                str = "task close failed, error:";
                fileOutputStream2 = null;
                inputStream = null;
                httpURLConnection = null;
            }
            if (responseCode == 200) {
                inputStream2 = httpURLConnection.getInputStream();
                try {
                    contentLength = httpURLConnection.getContentLength();
                    String str5 = bVar.f146096b;
                    File file = new File(str5);
                    if (file.exists()) {
                        try {
                            file.delete();
                        } catch (Throwable th7) {
                            th = th7;
                            str = "task close failed, error:";
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            inputStream2 = inputStream;
                            try {
                                x0.a("XWebHttpTask", "task failed, error", th);
                                dVar2.f146103c = -10002;
                                if (fileOutputStream != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                return dVar2;
                            } catch (Throwable th8) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e16) {
                                        x0.c("XWebHttpTask", str + e16);
                                        dVar2.f146103c = -10003;
                                        return dVar2;
                                    }
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th8;
                            }
                        }
                    }
                    fileOutputStream = new FileOutputStream(str5);
                    try {
                        bArr = new byte[4096];
                        cVar = new c();
                        cVar.f146098a = bVar.f146095a;
                        cVar.f146100c = contentLength;
                        j3 = 0;
                    } catch (Throwable th9) {
                        th = th9;
                        str2 = str3;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    str = "task close failed, error:";
                    inputStream = inputStream2;
                    fileOutputStream2 = null;
                }
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    if (isCancelled()) {
                        inputStream2.close();
                        try {
                            fileOutputStream.close();
                            inputStream2.close();
                            httpURLConnection.disconnect();
                            return dVar;
                        } catch (IOException e17) {
                            x0.c("XWebHttpTask", str3 + e17);
                            dVar2.f146103c = -10003;
                            return dVar2;
                        }
                    }
                    str2 = str3;
                    j3 += read;
                    try {
                        fileOutputStream.write(bArr, 0, read);
                        cVar.f146099b = j3;
                        if (contentLength > 0) {
                            publishProgress(cVar);
                        }
                        str3 = str2;
                        dVar = null;
                    } catch (Throwable th11) {
                        th = th11;
                    }
                    th = th11;
                    str = str2;
                    x0.a("XWebHttpTask", "task failed, error", th);
                    dVar2.f146103c = -10002;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            x0.c("XWebHttpTask", str + e18);
                            dVar2.f146103c = -10003;
                            return dVar2;
                        }
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return dVar2;
                }
            }
            str2 = "task close failed, error:";
            try {
                dVar2.f146103c = -10005;
                dVar2.f146105e = "responseCode " + responseCode;
                fileOutputStream2 = null;
                inputStream = null;
            } catch (Throwable th12) {
                th = th12;
                str = str2;
                fileOutputStream2 = null;
                inputStream = null;
                fileOutputStream = fileOutputStream2;
                inputStream2 = inputStream;
                x0.a("XWebHttpTask", "task failed, error", th);
                dVar2.f146103c = -10002;
                if (fileOutputStream != null) {
                }
                if (inputStream2 != null) {
                }
                if (httpURLConnection != null) {
                }
                return dVar2;
            }
            try {
                httpURLConnection.disconnect();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e19) {
                        x0.c("XWebHttpTask", str2 + e19);
                        dVar2.f146103c = -10003;
                        return dVar2;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                httpURLConnection.disconnect();
                return dVar2;
            } catch (Throwable th13) {
                th = th13;
                str = str2;
                fileOutputStream = fileOutputStream2;
                inputStream2 = inputStream;
                x0.a("XWebHttpTask", "task failed, error", th);
                dVar2.f146103c = -10002;
                if (fileOutputStream != null) {
                }
                if (inputStream2 != null) {
                }
                if (httpURLConnection != null) {
                }
                return dVar2;
            }
        }
        x0.a("XWebHttpTask", "invalid params");
        dVar2.f146103c = -10001;
        return dVar2;
    }

    public final void b() {
        this.f146091c++;
        x0.a("XWebHttpTask", "task retry! mRetrytimes = " + this.f146091c);
        BaseTimer baseTimer = new BaseTimer();
        this.f146092d = baseTimer;
        baseTimer.schedule(new a(), ((long) this.f146091c) * 3000);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }

    public String a(Map map) {
        if (map == null) {
            return "null";
        }
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb5.append(entry.getKey() == null ? "null" : (String) entry.getKey());
            sb5.append(ProgressTracer.SEPARATOR);
            List<String> list = (List) entry.getValue();
            if (list != null && list.size() > 0) {
                for (String str : list) {
                    if (str == null) {
                        str = "null";
                    }
                    sb5.append(str);
                }
            }
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public final String a() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("XWebSdk/" + XWebSdk.getXWebSdkVersion() + " ");
        sb5.append("XWebApk/" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " ");
        sb5.append("XWebGrayValue/" + v0.b() + " ");
        sb5.append("XWebTodayGrayValue/" + v0.d() + " ");
        sb5.append("XWebGrayValue2/" + v0.e() + " ");
        sb5.append("ABI/" + com.tencent.luggage.wxa.ar.b.b() + " ");
        sb5.append("APPINFO/dump (" + XWalkEnvironment.dumpAppInfo() + ") ");
        sb5.append("ProcessName/" + XWalkEnvironment.getProcessName() + " ");
        return sb5.toString();
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(c... cVarArr) {
        if (cVarArr.length != 1) {
            return;
        }
        this.f146089a.onTaskProgressChanged(cVarArr[0]);
    }

    public final boolean a(d dVar) {
        int i3;
        return (this.f146091c >= 2 || (i3 = dVar.f146103c) == -10001 || i3 == -10004) ? false : true;
    }
}
