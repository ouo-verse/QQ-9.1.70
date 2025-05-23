package com.tencent.luggage.wxa.of;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.luggage.wxa.af.i;
import com.tencent.luggage.wxa.bf.l0;
import com.tencent.luggage.wxa.bo.e;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.ee.h;
import com.tencent.luggage.wxa.p9.a;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.yi.b;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements h {

    /* renamed from: a, reason: collision with root package name */
    public b.d f136448a;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.ee.a f136450c;

    /* renamed from: b, reason: collision with root package name */
    public boolean f136449b = false;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f136451d = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends k0 {
        public static final int CTRL_INDEX = 271;
        public static final String NAME = "onDownloadTaskStateChange";
    }

    public a(b.d dVar, com.tencent.luggage.wxa.ee.a aVar) {
        this.f136448a = dVar;
        this.f136450c = aVar;
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String b() {
        return com.tencent.luggage.wxa.yi.c.b().a() + "";
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String d() {
        return "downloadTaskId";
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar) {
        b.d dVar2 = this.f136448a;
        if (dVar2 != null) {
            this.f136449b = dVar2.a(dVar.getAppId());
        }
        if (this.f136449b) {
            com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
            CronetLogic.initializeNativeLib();
            if (aVar == null) {
                w.b("MicroMsg.BaseCreateDownloadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", dVar.getAppId());
                CronetLogic.setUserCertVerify(false);
            } else {
                w.d("MicroMsg.BaseCreateDownloadTask", "setupRequestMode(%b),appId(%s)", Boolean.valueOf(aVar.Q), dVar.getAppId());
                CronetLogic.setUserCertVerify(aVar.Q);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, String str) {
        w.a("MicroMsg.BaseCreateDownloadTask", "JsApiCreateDownloadTask");
        if (!this.f136451d.getAndSet(true)) {
            a(dVar);
        }
        dVar.getAppId();
        C6549a c6549a = new C6549a(jSONObject.optString("filePath"), dVar, str);
        com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
        Map a16 = q.a(jSONObject, aVar);
        String optString = jSONObject.optString("url");
        if (w0.c(optString)) {
            w.d("MicroMsg.BaseCreateDownloadTask", "url is null");
            a(dVar, str, "url is null or nil", i.f121360f.f121277a);
            return;
        }
        boolean z16 = jSONObject.optBoolean("__skipDomainCheck__") ? false : aVar.f145792b;
        if (z16 && !q.c(aVar.C, optString)) {
            w.d("MicroMsg.BaseCreateDownloadTask", "not in domain url %s", optString);
            a(dVar, str, "url not in domain list", i.f121357c.f121277a);
            return;
        }
        if (aVar.f145800j <= 0) {
            w.d("MicroMsg.BaseCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
        }
        int optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
            optInt = q.a(aVar, 3);
        }
        if (optInt <= 0) {
            optInt = 60000;
        }
        a(dVar, aVar, z16, jSONObject, optInt, a16, c6549a, str);
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.yi.a aVar, boolean z16, JSONObject jSONObject, int i3, Map map, b.c cVar, String str) {
        com.tencent.luggage.wxa.yi.b a16 = com.tencent.luggage.wxa.yi.c.b().a(dVar.getAppId());
        if (a16 == null) {
            a16 = new com.tencent.luggage.wxa.yi.b(dVar, this.f136449b);
            com.tencent.luggage.wxa.yi.c.b().a(dVar.getAppId(), a16);
        }
        com.tencent.luggage.wxa.yi.b bVar = a16;
        w.d("MicroMsg.BaseCreateDownloadTask", "before do download, checkDomains = %b, timeout %d, inputTimeout: %d", Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(jSONObject.optInt("timeout", 0)));
        bVar.a(jSONObject, i3, map, z16 ? aVar.C : null, aVar.I, cVar, str, com.tencent.luggage.wxa.of.b.NAME);
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, int i3) {
        w.h("MicroMsg.BaseCreateDownloadTask", "sendFailMsg, downloadTaskId = %s, errMsg = %s, errno = %d", str, str2, Integer.valueOf(i3));
        HashMap hashMap = new HashMap();
        hashMap.put("downloadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put(o.ERRNO_TAG, Integer.valueOf(i3));
        hashMap.put("errMsg", str2);
        new b().setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch(this.f136450c.a(str));
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.of.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6549a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        public JSONObject f136452a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f136453b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f136454c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f136455d;

        public C6549a(String str, com.tencent.luggage.wxa.xd.d dVar, String str2) {
            this.f136453b = str;
            this.f136454c = dVar;
            this.f136455d = str2;
        }

        @Override // com.tencent.luggage.wxa.yi.b.c
        public void a(int i3, String str, String str2, int i16, long j3, Map map) {
            w.d("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %d, dataLength = %d", Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Long.valueOf(j3));
            if (!w0.c(this.f136453b)) {
                String str3 = l0.a(this.f136454c, new v(str2), this.f136453b, null).f121278b;
                if (!FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS.equals(str3)) {
                    if (a.this.a(this.f136454c, this.f136455d)) {
                        return;
                    }
                    a.this.a(this.f136454c, this.f136455d, str3, i.G.f121277a);
                    return;
                }
                w.d("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode filePath %s", this.f136453b);
                HashMap hashMap = new HashMap();
                hashMap.put("downloadTaskId", this.f136455d);
                hashMap.put("filePath", this.f136453b);
                hashMap.put("dataLength", Long.valueOf(j3));
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i16));
                hashMap.put("state", "success");
                JSONObject jSONObject = this.f136452a;
                if (jSONObject != null) {
                    hashMap.put("header", jSONObject);
                }
                if (map != null && map.size() > 0) {
                    hashMap.put("profile", map);
                }
                new b().setContext(this.f136454c).setData(new JSONObject(hashMap).toString()).dispatch(a.this.f136450c.a(this.f136455d));
                a.this.f136450c.b(this.f136455d);
                return;
            }
            com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
            String a16 = a.this.a(this.f136454c, str2, str, iVar);
            if (a16 == null) {
                if (a.this.a(this.f136454c, this.f136455d)) {
                    return;
                }
                a.this.a(this.f136454c, this.f136455d, iVar.f141499a == l.ERR_EXCEED_DIRECTORY_MAX_SIZE ? "temp file size exceed limit" : "download fail save file fail", i.G.f121277a);
                return;
            }
            w.d("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode localId %s", a16);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("downloadTaskId", this.f136455d);
            hashMap2.put("tempFilePath", a16);
            hashMap2.put("dataLength", Long.valueOf(j3));
            hashMap2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i16));
            hashMap2.put("state", "success");
            JSONObject jSONObject2 = this.f136452a;
            if (jSONObject2 != null) {
                hashMap2.put("header", jSONObject2);
            }
            if (map != null && map.size() > 0) {
                hashMap2.put("profile", map);
            }
            new b().setContext(this.f136454c).setData(new JSONObject(hashMap2).toString()).dispatch(a.this.f136450c.a(this.f136455d));
            a.this.f136450c.b(this.f136455d);
        }

        @Override // com.tencent.luggage.wxa.yi.b.c
        public void a(int i3, long j3, long j16) {
            HashMap hashMap = new HashMap();
            hashMap.put("downloadTaskId", this.f136455d);
            hashMap.put("state", "progressUpdate");
            hashMap.put("progress", Integer.valueOf(i3));
            hashMap.put("totalBytesWritten", Long.valueOf(j3));
            hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j16));
            new b().setContext(this.f136454c).setData(new JSONObject(hashMap).toString()).dispatch(a.this.f136450c.a(this.f136455d));
        }

        @Override // com.tencent.luggage.wxa.yi.b.c
        public void a(int i3, String str, int i16) {
            w.d("MicroMsg.BaseCreateDownloadTask", "onDownloadError downloadTaskId=%s,errMsg=%d,error=%s,errno=%d", this.f136455d, Integer.valueOf(i3), str, Integer.valueOf(i16));
            if (a.this.a(this.f136454c, this.f136455d)) {
                return;
            }
            a.this.a(this.f136454c, this.f136455d, str, i16);
        }

        @Override // com.tencent.luggage.wxa.yi.b.c
        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                if (((com.tencent.luggage.wxa.yi.a) this.f136454c.a(com.tencent.luggage.wxa.yi.a.class)).O) {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    com.tencent.luggage.wxa.p9.a aVar = new com.tencent.luggage.wxa.p9.a();
                    a.C6597a c6597a = aVar.f137423d;
                    c6597a.f137424a = "download";
                    c6597a.f137426c = jSONObject;
                    c6597a.f137425b = this.f136455d;
                    aVar.c();
                    return;
                }
                return;
            }
            this.f136452a = jSONObject;
            HashMap hashMap = new HashMap();
            hashMap.put("downloadTaskId", this.f136455d);
            hashMap.put("state", "headersReceived");
            hashMap.put("header", this.f136452a);
            new b().setContext(this.f136454c).setData(new JSONObject(hashMap).toString()).dispatch(a.this.f136450c.a(this.f136455d));
        }
    }

    public final String a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, com.tencent.luggage.wxa.tk.i iVar) {
        String a16 = e.a(str2);
        if (w0.c(a16) && "audio/mp4".equals(str2)) {
            a16 = "mp4";
        }
        com.tencent.luggage.wxa.tk.i iVar2 = new com.tencent.luggage.wxa.tk.i();
        l createTempFileFrom = dVar.getFileSystem().createTempFileFrom(new v(str), a16, true, iVar2);
        iVar.f141499a = createTempFileFrom;
        if (createTempFileFrom != l.OK) {
            return null;
        }
        return (String) iVar2.f141499a;
    }

    public final boolean a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        com.tencent.luggage.wxa.yi.b a16 = com.tencent.luggage.wxa.yi.c.b().a(dVar.getAppId());
        if (a16 == null || !a16.c(str)) {
            return false;
        }
        w.d("MicroMsg.BaseCreateDownloadTask", "download abort %s", str);
        return true;
    }
}
