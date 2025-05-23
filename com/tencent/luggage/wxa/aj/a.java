package com.tencent.luggage.wxa.aj;

import android.net.http.Headers;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.af.e;
import com.tencent.luggage.wxa.af.i;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.luggage.wxa.yi.z;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements Runnable {
    public SSLContext C;
    public ArrayList D;
    public long E;
    public String F;
    public boolean I;
    public String K;
    public final String L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;

    /* renamed from: b, reason: collision with root package name */
    public d f121527b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.aj.b f121528c;

    /* renamed from: f, reason: collision with root package name */
    public String f121531f;

    /* renamed from: g, reason: collision with root package name */
    public String f121532g;

    /* renamed from: h, reason: collision with root package name */
    public String f121533h;

    /* renamed from: i, reason: collision with root package name */
    public String f121534i;

    /* renamed from: j, reason: collision with root package name */
    public String f121535j;

    /* renamed from: k, reason: collision with root package name */
    public Map f121536k;

    /* renamed from: l, reason: collision with root package name */
    public Map f121537l;

    /* renamed from: a, reason: collision with root package name */
    public int f121526a = 15;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f121529d = false;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f121530e = false;

    /* renamed from: m, reason: collision with root package name */
    public int f121538m = 60000;
    public HttpURLConnection G = null;
    public String H = null;
    public long J = System.currentTimeMillis();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.aj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6018a extends com.tencent.luggage.wxa.jq.b {
        public C6018a() {
        }

        @Override // com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "AppBrandNetworkUploadWorker#TimerTask";
        }

        @Override // java.lang.Runnable
        public void run() {
            w.b("MicroMsg.AppBrandNetworkUploadWorker", "call cronet time out taskid:%s,timeout:%d,url:%s", a.this.d(), Integer.valueOf(a.this.f121538m), a.this.e());
            if (!a.this.f121530e) {
                a.this.f121530e = true;
                com.tencent.luggage.wxa.aj.b bVar = a.this.f121528c;
                String str = a.this.f121534i;
                String str2 = a.this.f121532g;
                com.tencent.luggage.wxa.af.c cVar = e.f121310f;
                bVar.a(str, str2, cVar.f121278b, cVar.f121277a);
            } else {
                w.b("MicroMsg.AppBrandNetworkUploadWorker", "call cronet time out already callback");
            }
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, 6L, 1L, false);
            if (!w0.c(a.this.H)) {
                CronetLogic.cancelCronetTask(a.this.H);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f121545a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f121546b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f121547c = -1;

        public c() {
        }
    }

    public a(d dVar, String str, String str2, String str3, String str4, String str5, String str6, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, com.tencent.luggage.wxa.aj.b bVar) {
        this.I = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = true;
        this.f121527b = dVar;
        this.f121532g = str;
        this.f121531f = str2;
        this.f121533h = str3;
        this.f121534i = str4;
        this.f121535j = a(str5, "application/octet-stream");
        this.f121528c = bVar;
        this.L = str6;
        this.I = z16;
        this.M = z17;
        this.N = z18;
        this.O = z19;
        this.P = z26;
    }

    public static /* synthetic */ int l(a aVar) {
        int i3 = aVar.f121526a;
        aVar.f121526a = i3 - 1;
        return i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (!URLUtil.isHttpsUrl(this.f121532g) && !URLUtil.isHttpUrl(this.f121532g)) {
            this.f121528c.a(this.f121534i, this.f121532g, "uploadFile protocol must be http or https", i.f121360f.f121277a);
            ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(this.f121527b.getAppId(), c(), "POST", this.f121532g, 0L, 0L, 0, 2, b(), System.currentTimeMillis(), null, this.f121535j);
            return;
        }
        ArrayList arrayList = this.D;
        if (arrayList != null && !q.c(arrayList, this.f121532g)) {
            try {
                str = new URL(this.f121532g).getHost();
            } catch (MalformedURLException e16) {
                w.a("MicroMsg.AppBrandNetworkUploadWorker", e16, "get redirect url host fail Exception", new Object[0]);
                str = null;
            }
            if (!w0.c(str)) {
                this.f121528c.a(this.f121534i, this.f121532g, "redirect url not in domain list:" + str, i.f121357c.f121277a);
            } else {
                this.f121528c.a(this.f121534i, this.f121532g, "redirect url not in domain list", i.f121357c.f121277a);
            }
            ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(this.f121527b.getAppId(), c(), "POST", this.f121532g, 0L, 0L, 0, 2, b(), System.currentTimeMillis(), null, this.f121535j);
            w.d("MicroMsg.AppBrandNetworkUploadWorker", "not in domain url %s", this.f121532g);
            return;
        }
        if (this.I) {
            f();
        } else {
            g();
        }
    }

    public void b(boolean z16) {
        this.f121529d = z16;
    }

    public void c(int i3) {
        this.f121538m = i3;
    }

    public String d() {
        return this.F;
    }

    public String e() {
        return this.f121532g;
    }

    public final void f() {
        Class cls;
        int i3;
        int i16;
        b bVar;
        CronetLogic.CronetRequestParams cronetRequestParams;
        C6018a c6018a;
        String str;
        Map<String, String> map;
        long j3;
        int i17;
        long length;
        CronetLogic.CronetHttpsCreateResult startCronetUploadTask;
        Object[] objArr;
        if (!this.f121529d) {
            this.f121528c.a(this.f121534i, this.f121532g, "force stop", i.f121359e.f121277a);
            ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(this.f121527b.getAppId(), c(), "POST", this.f121532g, 0L, 0L, 0, 2, b(), System.currentTimeMillis(), null, this.f121535j);
            w.b("MicroMsg.AppBrandNetworkUploadWorker", "force stop!");
            return;
        }
        c cVar = new c();
        this.E = System.currentTimeMillis();
        this.f121528c.a(this.f121534i, this.f121532g);
        w.g("MicroMsg.AppBrandNetworkUploadWorker", "uploadFile filename %s", this.f121534i);
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, 0L, 1L, false);
        try {
            long s16 = new v(this.f121531f).s();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            C6018a c6018a2 = new C6018a();
            String l3 = Long.toString(System.currentTimeMillis());
            b bVar2 = new b(c6018a2, cVar);
            CronetLogic.CronetRequestParams cronetRequestParams2 = new CronetLogic.CronetRequestParams();
            cls = com.tencent.luggage.wxa.zj.b.class;
            try {
                cronetRequestParams2.url = this.f121532g;
                cronetRequestParams2.taskId = this.F;
                cronetRequestParams2.followRedirect = false;
                cronetRequestParams2.method = "POST";
                cronetRequestParams2.useHttp2 = this.M;
                cronetRequestParams2.useQuic = this.N;
                cronetRequestParams2.useMemoryCache = this.O;
                cronetRequestParams2.miniPrograms = true;
                cronetRequestParams2.maxRetryCount = 0;
                Map<String, String> map2 = this.f121537l;
                if (map2.containsKey("Accept-Encoding")) {
                    bVar = bVar2;
                    cronetRequestParams = cronetRequestParams2;
                    c6018a = c6018a2;
                    w.d("MicroMsg.AppBrandNetworkUploadWorker", "uploadCronetFile Accept-Encoding:%s", map2.get("Accept-Encoding"));
                } else {
                    bVar = bVar2;
                    map2.put("Accept-Encoding", "gzip,compress,br,deflate");
                    cronetRequestParams = cronetRequestParams2;
                    c6018a = c6018a2;
                }
                map2.put("Connection", "Keep-Alive");
                map2.put("User-Agent", this.L);
                String str2 = "Content-Length";
                if (map2.containsKey(Headers.CONTENT_LEN)) {
                    w.b("MicroMsg.AppBrandNetworkUploadWorker", "not allow to set content-length");
                    map2.remove(Headers.CONTENT_LEN);
                } else if (map2.containsKey("Content-Length")) {
                    w.b("MicroMsg.AppBrandNetworkUploadWorker", "not allow to set Content-Length");
                    map2.remove("Content-Length");
                }
                if (this.f121536k != null) {
                    map2.put("Content-Type", "multipart/form-data; boundary=" + l3);
                    Iterator it = this.f121536k.keySet().iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        Iterator it5 = it;
                        String str4 = (String) this.f121536k.get(str3);
                        String str5 = str2;
                        Map<String, String> map3 = map2;
                        long j16 = s16;
                        try {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = str3;
                            objArr2[1] = str4;
                            w.d("MicroMsg.AppBrandNetworkUploadWorker", "append form data: key = %s, value = %s", objArr2);
                            sb5.append("--" + l3 + "\r\n");
                            sb5.append("Content-Disposition: form-data; name=\"" + str3 + "\"");
                            sb5.append("\r\n");
                            sb5.append("\r\n");
                            sb5.append(str4);
                            sb5.append("\r\n");
                            it = it5;
                            str2 = str5;
                            map2 = map3;
                            s16 = j16;
                        } catch (UnsupportedEncodingException e16) {
                            e = e16;
                            i16 = 2;
                            Object[] objArr3 = new Object[i16];
                            objArr3[0] = this.f121532g;
                            objArr3[1] = this.f121531f;
                            w.a("MicroMsg.AppBrandNetworkUploadWorker", e, "UnsupportedEncodingException: url is %s filepath %s ", objArr3);
                            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(1791L, 4L, 1L, false);
                        } catch (Exception e17) {
                            e = e17;
                            i3 = 2;
                            Object[] objArr4 = new Object[i3];
                            objArr4[0] = this.f121532g;
                            objArr4[1] = this.f121531f;
                            w.a("MicroMsg.AppBrandNetworkUploadWorker", e, "IOException: url is %s filepath %s ", objArr4);
                            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(1791L, 5L, 1L, false);
                        }
                    }
                    str = str2;
                    map = map2;
                    j3 = s16;
                    sb5.append("--" + l3 + "\r\n");
                    sb5.append("Content-Disposition: form-data; name=\"" + this.f121533h + "\"; filename=\"" + this.f121534i + "\"\r\n");
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Content-Type: ");
                    sb7.append(this.f121535j);
                    sb5.append(sb7.toString());
                    sb5.append("\r\n");
                    sb5.append("\r\n");
                    sb6.append("\r\n--" + l3 + "--\r\n");
                } else {
                    str = "Content-Length";
                    map = map2;
                    j3 = s16;
                }
                byte[] bytes = sb5.toString().getBytes("UTF-8");
                byte[] bytes2 = sb6.toString().getBytes("UTF-8");
                if (bytes == null) {
                    i17 = 0;
                    bytes = new byte[0];
                } else {
                    i17 = 0;
                }
                if (bytes2 == null) {
                    bytes2 = new byte[i17];
                }
                length = bytes2.length + j3 + bytes.length;
                w.d("MicroMsg.AppBrandNetworkUploadWorker", "contentLenght = %d", Long.valueOf(length));
                Map<String, String> map4 = map;
                map4.put(str, length + "");
                CronetLogic.CronetRequestParams cronetRequestParams3 = cronetRequestParams;
                cronetRequestParams3.makeRequestHeader(map4);
                this.f121528c.a(q.a(q.b(map4), 1));
                CronetLogic.UploadParams uploadParams = new CronetLogic.UploadParams();
                uploadParams.filePath = this.f121531f;
                uploadParams.vfsPath = true;
                uploadParams.uploadOffset = 0L;
                uploadParams.uploadRange = length;
                uploadParams.formData = bytes;
                uploadParams.endData = bytes2;
                cronetRequestParams3.uploadParams = uploadParams;
                uploadParams.reportId = TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC;
                cronetRequestParams3.taskType = 7;
                h.f146825d.a(c6018a, this.f121538m);
                startCronetUploadTask = CronetLogic.startCronetUploadTask(cronetRequestParams3, bVar);
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(startCronetUploadTask.createRet);
                objArr[1] = this.F;
            } catch (UnsupportedEncodingException e18) {
                e = e18;
                i16 = 2;
                Object[] objArr32 = new Object[i16];
                objArr32[0] = this.f121532g;
                objArr32[1] = this.f121531f;
                w.a("MicroMsg.AppBrandNetworkUploadWorker", e, "UnsupportedEncodingException: url is %s filepath %s ", objArr32);
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(1791L, 4L, 1L, false);
            } catch (Exception e19) {
                e = e19;
                i3 = 2;
                Object[] objArr42 = new Object[i3];
                objArr42[0] = this.f121532g;
                objArr42[1] = this.f121531f;
                w.a("MicroMsg.AppBrandNetworkUploadWorker", e, "IOException: url is %s filepath %s ", objArr42);
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(1791L, 5L, 1L, false);
            }
        } catch (UnsupportedEncodingException e26) {
            e = e26;
            cls = com.tencent.luggage.wxa.zj.b.class;
        } catch (Exception e27) {
            e = e27;
            cls = com.tencent.luggage.wxa.zj.b.class;
        }
        try {
            objArr[2] = startCronetUploadTask.taskId;
            objArr[3] = this.f121532g;
            objArr[4] = this.f121534i;
            w.d("MicroMsg.AppBrandNetworkUploadWorker", "startCronetHttpsRequest createRet is %d, taskId %s,CronetRequestId:%s,url is %s, filename is %s", objArr);
            if (startCronetUploadTask.createRet != 0) {
                if (!this.f121530e) {
                    this.f121530e = true;
                    this.f121528c.a(this.f121534i, this.f121532g, "call request error:" + startCronetUploadTask.createRet, i.f121359e.f121277a);
                }
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(1791L, 1L, 1L, false);
                return;
            }
            this.H = startCronetUploadTask.taskId;
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(1791L, 2L, 1L, false);
            if (length > 0) {
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(1791L, 16L, length, false);
            }
        } catch (UnsupportedEncodingException e28) {
            e = e28;
            i16 = 2;
            Object[] objArr322 = new Object[i16];
            objArr322[0] = this.f121532g;
            objArr322[1] = this.f121531f;
            w.a("MicroMsg.AppBrandNetworkUploadWorker", e, "UnsupportedEncodingException: url is %s filepath %s ", objArr322);
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(1791L, 4L, 1L, false);
        } catch (Exception e29) {
            e = e29;
            i3 = 2;
            Object[] objArr422 = new Object[i3];
            objArr422[0] = this.f121532g;
            objArr422[1] = this.f121531f;
            w.a("MicroMsg.AppBrandNetworkUploadWorker", e, "IOException: url is %s filepath %s ", objArr422);
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(cls)).a(1791L, 5L, 1L, false);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final void g() {
        /*
            Method dump skipped, instructions count: 7430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.wxa.aj.a.g():void");
    }

    public void b(Map map) {
        this.f121537l = map;
    }

    public String c() {
        return this.K;
    }

    public void b(String str) {
        this.F = str;
    }

    public int b() {
        return (int) (System.currentTimeMillis() - this.J);
    }

    public void a(Map map) {
        this.f121536k = map;
    }

    public final void b(int i3) {
        int i16 = (i3 < 100 || i3 >= 200) ? 200 == i3 ? 21 : (i3 <= 200 || i3 >= 300) ? 302 == i3 ? 23 : (i3 < 300 || i3 >= 400) ? 404 == i3 ? 25 : (i3 < 400 || i3 >= 500) ? i3 >= 500 ? 27 : 28 : 26 : 24 : 22 : 20;
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(436L, i16, 1L, false);
        w.a("MicroMsg.AppBrandNetworkUploadWorker", "reportStatusCode:%d, key:%d", Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public void a(ArrayList arrayList) {
        this.D = arrayList;
    }

    public void a(SSLContext sSLContext) {
        this.C = sSLContext;
    }

    public final void b(long j3, long j16) {
        int i3;
        if (j3 <= 0 || j16 <= 0) {
            w.d("MicroMsg.AppBrandNetworkUploadWorker", "reportSpeed len:%d, time:%d return", Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        double d16 = (j3 / j16) * 0.9765625d;
        if (h0.f(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 30;
        } else if (h0.g(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 31;
        } else if (h0.h(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 32;
        } else {
            i3 = h0.l(com.tencent.luggage.wxa.tn.z.c()) ? 33 : 34;
        }
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(436L, i3, (long) d16, false);
        w.a("MicroMsg.AppBrandNetworkUploadWorker", "reportSpeed len:%d, time:%d, speed:%f, key:%d", Long.valueOf(j3), Long.valueOf(j16), Double.valueOf(d16), Integer.valueOf(i3));
    }

    public void a(String str) {
        this.K = str;
    }

    public final String a(String str, String str2) {
        return w0.c(str) ? str2 : str;
    }

    public void a() {
        this.f121529d = false;
        HttpURLConnection httpURLConnection = this.G;
        if (httpURLConnection != null) {
            try {
                try {
                    httpURLConnection.getInputStream().close();
                } catch (IOException e16) {
                    w.a("MicroMsg.AppBrandNetworkUploadWorker", e16, "abortTask IOException", new Object[0]);
                }
                this.G.disconnect();
            } catch (Exception e17) {
                w.a("MicroMsg.AppBrandNetworkUploadWorker", e17, "abortTask Exception", new Object[0]);
            }
        }
        if (w0.c(this.H)) {
            return;
        }
        CronetLogic.cancelCronetTask(this.H);
    }

    public final void a(int i3) {
        int i16 = (i3 < 100 || i3 >= 200) ? 200 == i3 ? 21 : (i3 <= 200 || i3 >= 300) ? 302 == i3 ? 23 : (i3 < 300 || i3 >= 400) ? 404 == i3 ? 25 : (i3 < 400 || i3 >= 500) ? i3 >= 500 ? 27 : 28 : 26 : 24 : 22 : 20;
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, i16, 1L, false);
        w.a("MicroMsg.AppBrandNetworkUploadWorker", "reportCronetStatusCode:%d, key:%d", Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public final void a(long j3, long j16) {
        int i3;
        if (j3 <= 0 || j16 <= 0) {
            w.d("MicroMsg.AppBrandNetworkUploadWorker", "reportCronetSpeed len:%d, time:%d return", Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        double d16 = (j3 / j16) * 0.9765625d;
        if (h0.f(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 30;
        } else if (h0.g(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 31;
        } else if (h0.h(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 32;
        } else {
            i3 = h0.l(com.tencent.luggage.wxa.tn.z.c()) ? 33 : 34;
        }
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, i3, (long) d16, false);
        w.a("MicroMsg.AppBrandNetworkUploadWorker", "reportCronetSpeed len:%d, time:%d, speed:%f, key:%d", Long.valueOf(j3), Long.valueOf(j16), Double.valueOf(d16), Integer.valueOf(i3));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements CronetLogic.CronetTaskCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.jq.b f121540a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f121541b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.aj.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6019a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CronetLogic.CronetTaskResult f121543a;

            public RunnableC6019a(CronetLogic.CronetTaskResult cronetTaskResult) {
                this.f121543a = cronetTaskResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3;
                CronetLogic.CronetTaskResult cronetTaskResult = this.f121543a;
                long j3 = cronetTaskResult.totalReceiveByte;
                int i16 = cronetTaskResult.statusCode;
                CronetLogic.CronetTaskResult cronetTaskResult2 = this.f121543a;
                w.d("MicroMsg.AppBrandNetworkUploadWorker", "onCronetTaskCompleted errorCode:%d,errorMsg:%s,statusCode:%d,totalReceiveByte:%d,taskid:%s,CronetRequestId:%s", Integer.valueOf(cronetTaskResult.errorCode), cronetTaskResult2.errorMsg, Integer.valueOf(cronetTaskResult2.statusCode), Long.valueOf(this.f121543a.totalReceiveByte), a.this.F, a.this.H);
                if (this.f121543a.errorCode == 0) {
                    a.this.a(i16);
                    if (i16 != 200 && q.e(i16)) {
                        String str = this.f121543a.newLocation;
                        if (!TextUtils.isEmpty(str)) {
                            if (a.l(a.this) <= 0) {
                                w.h("MicroMsg.AppBrandNetworkUploadWorker", "reach the max redirect count(%d)", 15);
                                if (!a.this.f121530e) {
                                    a.this.f121530e = true;
                                    if (a.this.P) {
                                        a.this.f121528c.a(a.this.f121534i, a.this.f121532g, "reach the max redirect count 15", i16, 0L, q.a(this.f121543a.webPageProfile));
                                    } else {
                                        a.this.f121528c.a(a.this.f121534i, a.this.f121532g, "reach the max redirect count 15", i16, 0L, null);
                                    }
                                    z zVar = (z) com.tencent.luggage.wxa.h1.e.c(z.class);
                                    String appId = a.this.f121527b.getAppId();
                                    String c16 = a.this.c();
                                    String e16 = a.this.e();
                                    CronetLogic.CronetTaskResult cronetTaskResult3 = this.f121543a;
                                    zVar.a(appId, c16, "POST", e16, cronetTaskResult3.totalSendByte, cronetTaskResult3.totalReceiveByte, i16, 1, a.this.b(), System.currentTimeMillis(), null, a.this.f121535j);
                                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, 10L, 1L, false);
                                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, 12L, System.currentTimeMillis() - a.this.E, false);
                                    return;
                                }
                                w.b("MicroMsg.AppBrandNetworkUploadWorker", "cronet onCronetTaskCompleted max redirect already callback");
                                return;
                            }
                            w.d("MicroMsg.AppBrandNetworkUploadWorker", "redirect(%d) URL(%s) to URL(%s)", Integer.valueOf(a.this.f121526a), a.this.f121532g, str);
                            a.this.f121532g = str;
                            a.this.run();
                            return;
                        }
                    }
                    if (!a.this.f121530e) {
                        a.this.f121530e = true;
                        if (a.this.f121529d) {
                            if (a.this.P) {
                                i3 = i16;
                                a.this.f121528c.a(a.this.f121534i, a.this.f121532g, this.f121543a.getDataString(), i16, j3, q.a(this.f121543a.webPageProfile));
                            } else {
                                i3 = i16;
                                a.this.f121528c.a(a.this.f121534i, a.this.f121532g, this.f121543a.getDataString(), i16, j3, null);
                            }
                            a.this.a(this.f121543a.totalSendByte, System.currentTimeMillis() - a.this.E);
                            b.this.f121541b.f121545a = true;
                        } else {
                            i3 = i16;
                            a.this.f121528c.a(a.this.f121534i, a.this.f121532g, "force stop", i.f121359e.f121277a);
                        }
                        w.d("MicroMsg.AppBrandNetworkUploadWorker", "cronet upload file finished taskid:%s,CronetRequestId:%s,filename: %s", a.this.F, a.this.H, a.this.f121534i);
                        a.this.f121528c.a(a.this.d());
                        z zVar2 = (z) com.tencent.luggage.wxa.h1.e.c(z.class);
                        String appId2 = a.this.f121527b.getAppId();
                        String c17 = a.this.c();
                        String e17 = a.this.e();
                        CronetLogic.CronetTaskResult cronetTaskResult4 = this.f121543a;
                        zVar2.a(appId2, c17, "POST", e17, cronetTaskResult4.totalSendByte, cronetTaskResult4.totalReceiveByte, i3, 1, a.this.b(), System.currentTimeMillis(), null, a.this.f121535j);
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, 10L, 1L, false);
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, 12L, System.currentTimeMillis() - a.this.E, false);
                        long currentTimeMillis = System.currentTimeMillis() - a.this.J;
                        w.a("cronet upload time", "request time is " + currentTimeMillis);
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(JoinTimeType.THIRTY_MINUTES, 3L, currentTimeMillis, false);
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(JoinTimeType.THIRTY_MINUTES, 1L, 1L, false);
                        return;
                    }
                    w.b("MicroMsg.AppBrandNetworkUploadWorker", "cronet onCronetTaskCompleted already callback");
                    return;
                }
                if (!a.this.f121530e) {
                    a.this.f121530e = true;
                    a.this.f121528c.a(a.this.f121534i, a.this.f121532g, "upload fail:" + this.f121543a.errorCode + ":" + this.f121543a.errorMsg, i.f121356b.f121277a);
                    z zVar3 = (z) com.tencent.luggage.wxa.h1.e.c(z.class);
                    String appId3 = a.this.f121527b.getAppId();
                    String c18 = a.this.c();
                    String e18 = a.this.e();
                    CronetLogic.CronetTaskResult cronetTaskResult5 = this.f121543a;
                    zVar3.a(appId3, c18, "POST", e18, cronetTaskResult5.totalSendByte, cronetTaskResult5.totalReceiveByte, i16, 2, a.this.b(), System.currentTimeMillis(), null, a.this.f121535j);
                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, 11L, 1L, false);
                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, 13L, System.currentTimeMillis() - a.this.E, false);
                    int d16 = h0.d(com.tencent.luggage.wxa.tn.z.c());
                    if (d16 == -1) {
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1791L, 7L, 1L, false);
                    }
                    w.d("MicroMsg.AppBrandNetworkUploadWorker", "cronet uploadFile fail ret:%d", Integer.valueOf(d16));
                    return;
                }
                w.b("MicroMsg.AppBrandNetworkUploadWorker", "cronet onCronetTaskCompleted uploadFile fail already callback");
            }
        }

        public b(com.tencent.luggage.wxa.jq.b bVar, c cVar) {
            this.f121540a = bVar;
            this.f121541b = cVar;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public int onCronetReceiveHeader(CronetLogic.ResponseHeader responseHeader, int i3, String str) {
            w.d("MicroMsg.AppBrandNetworkUploadWorker", "cronet file upload onCronetReceiveHeader status %d,protocol %s,taskid:%s,CronetRequestId:%s", Integer.valueOf(i3), str, a.this.F, a.this.H);
            JSONObject a16 = q.a(CronetLogic.getHeaderList(responseHeader), 2);
            try {
                if (!w0.c(str)) {
                    a16.put(AudienceReportConst.PROTOCOL, str);
                }
            } catch (JSONException e16) {
                w.a("MicroMsg.AppBrandNetworkUploadWorker", e16, "JSONException: upload onCronetReceiveHeader put protocol error", new Object[0]);
            }
            a.this.f121528c.a(a16);
            return 0;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveUploadProgress(long j3, long j16) {
            if (q.a(a.this.f121527b)) {
                w.h("MicroMsg.AppBrandNetworkUploadWorker", "onCronetReceiveUploadProgress shouldStopTask taskid %s,CronetRequestId:%s", a.this.F, a.this.H);
                if (!a.this.f121530e) {
                    a.this.f121530e = true;
                    CronetLogic.cancelCronetTask(a.this.H);
                    com.tencent.luggage.wxa.aj.b bVar = a.this.f121528c;
                    String str = a.this.f121534i;
                    String str2 = a.this.f121532g;
                    com.tencent.luggage.wxa.af.c cVar = i.f121358d;
                    bVar.a(str, str2, cVar.f121278b, cVar.f121277a);
                } else {
                    w.b("MicroMsg.AppBrandNetworkUploadWorker", "onCronetReceiveUploadProgress already callback");
                }
                com.tencent.luggage.wxa.jq.b bVar2 = this.f121540a;
                if (bVar2 != null) {
                    bVar2.b();
                    w.d("MicroMsg.AppBrandNetworkUploadWorker", "cronet onCronetReceiveUploadProgress shouldStopTask TimerTask cancel");
                    return;
                }
                return;
            }
            if (j16 > 0 && a.this.f121529d) {
                if (j16 > 0) {
                    if (j3 > j16) {
                        this.f121541b.f121546b = 100;
                    } else {
                        this.f121541b.f121546b = (int) ((100 * j3) / j16);
                    }
                    c cVar2 = this.f121541b;
                    if (cVar2.f121547c != cVar2.f121546b) {
                        a.this.f121528c.a(a.this.f121534i, a.this.f121532g, this.f121541b.f121546b, j3, j16);
                        c cVar3 = this.f121541b;
                        cVar3.f121547c = cVar3.f121546b;
                    }
                } else {
                    a.this.f121528c.a(a.this.f121534i, a.this.f121532g, this.f121541b.f121546b, j3, 0L);
                }
                if (this.f121541b.f121546b == 100) {
                    w.d("MicroMsg.AppBrandNetworkUploadWorker", "cronet upload size %d, totalSize %d, percent = %d", Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(this.f121541b.f121546b));
                }
            }
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetTaskCompleted(String str, CronetLogic.CronetTaskResult cronetTaskResult, String str2) {
            com.tencent.luggage.wxa.jq.b bVar = this.f121540a;
            if (bVar != null) {
                bVar.b();
            }
            h.f146825d.execute(new RunnableC6019a(cronetTaskResult));
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveChunkedData(CronetLogic.ChunkedData chunkedData, long j3) {
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onDownloadProgressChanged(String str, CronetLogic.CronetDownloadProgress cronetDownloadProgress) {
        }
    }
}
