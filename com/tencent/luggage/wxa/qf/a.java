package com.tencent.luggage.wxa.qf;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.luggage.wxa.af.i;
import com.tencent.luggage.wxa.bo.e;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.ee.h;
import com.tencent.luggage.wxa.p9.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.yi.o;
import com.tencent.luggage.wxa.yi.p;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements h {

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.ee.a f138680b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f138679a = false;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f138681c = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends k0 {
        public static final int CTRL_INDEX = 274;
        public static final String NAME = "onUploadTaskStateChange";
    }

    public a(o.c cVar, com.tencent.luggage.wxa.ee.a aVar) {
        this.f138680b = aVar;
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String b() {
        return p.b().a() + "";
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String d() {
        return "uploadTaskId";
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar) {
        if (this.f138679a) {
            com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
            CronetLogic.initializeNativeLib();
            if (aVar == null) {
                w.b("MicroMsg.BaseCreateUploadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", dVar.getAppId());
                CronetLogic.setUserCertVerify(false);
            } else {
                w.d("MicroMsg.BaseCreateUploadTask", "setupRequestMode(%b),appId(%s)", Boolean.valueOf(aVar.Q), dVar.getAppId());
                CronetLogic.setUserCertVerify(aVar.Q);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qf.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6643a implements o.b {

        /* renamed from: a, reason: collision with root package name */
        public JSONObject f138682a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f138683b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f138684c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f138685d;

        public C6643a(String str, String str2, com.tencent.luggage.wxa.xd.d dVar) {
            this.f138683b = str;
            this.f138684c = str2;
            this.f138685d = dVar;
        }

        @Override // com.tencent.luggage.wxa.yi.o.b
        public void a(int i3, String str, int i16) {
            w.d("MicroMsg.BaseCreateUploadTask", "onUploadResultWithCode uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d, statusCode %d", this.f138683b, this.f138684c, str, Integer.valueOf(i3), Integer.valueOf(i16));
            HashMap hashMap = new HashMap();
            hashMap.put("data", str);
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i16));
            hashMap.put("uploadTaskId", this.f138683b);
            hashMap.put("state", "success");
            JSONObject jSONObject = this.f138682a;
            if (jSONObject != null) {
                hashMap.put("header", jSONObject);
            }
            new b().setContext(this.f138685d).setData(new JSONObject(hashMap).toString()).dispatch(a.this.f138680b.a(this.f138683b));
            a.this.f138680b.b(this.f138683b);
        }

        @Override // com.tencent.luggage.wxa.yi.o.b
        public void b(int i3, String str, int i16) {
            w.d("MicroMsg.BaseCreateUploadTask", "onUploadResult uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d, errno:%d", this.f138683b, this.f138684c, str, Integer.valueOf(i3), Integer.valueOf(i16));
            if (!a.this.a(this.f138685d, this.f138683b)) {
                a.this.a(this.f138685d, this.f138683b, str, i16);
            }
        }

        @Override // com.tencent.luggage.wxa.yi.o.b
        public void a(String str, String str2, int i3, long j3, long j16) {
            HashMap hashMap = new HashMap();
            hashMap.put("uploadTaskId", this.f138683b);
            hashMap.put("state", "progressUpdate");
            hashMap.put("progress", Integer.valueOf(i3));
            hashMap.put("totalBytesSent", Long.valueOf(j3));
            hashMap.put("totalBytesExpectedToSend", Long.valueOf(j16));
            new b().setContext(this.f138685d).setData(new JSONObject(hashMap).toString()).dispatch(a.this.f138680b.a(this.f138683b));
        }

        @Override // com.tencent.luggage.wxa.yi.o.b
        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                if (((com.tencent.luggage.wxa.yi.a) this.f138685d.a(com.tencent.luggage.wxa.yi.a.class)).O) {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    com.tencent.luggage.wxa.p9.a aVar = new com.tencent.luggage.wxa.p9.a();
                    a.C6597a c6597a = aVar.f137423d;
                    c6597a.f137424a = JobDbManager.TBL_UPLOAD;
                    c6597a.f137426c = jSONObject;
                    c6597a.f137425b = this.f138683b;
                    aVar.c();
                    return;
                }
                return;
            }
            this.f138682a = jSONObject;
            HashMap hashMap = new HashMap();
            hashMap.put("uploadTaskId", this.f138683b);
            hashMap.put("state", "headersReceived");
            hashMap.put("header", this.f138682a);
            new b().setContext(this.f138685d).setData(new JSONObject(hashMap).toString()).dispatch(a.this.f138680b.a(this.f138683b));
        }
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, String str) {
        o a16;
        w.a("MicroMsg.BaseCreateUploadTask", "JsApiCreateUploadTask, appId:%s taskId:%s", dVar.getAppId(), str);
        if (!this.f138681c.getAndSet(true)) {
            a(dVar);
        }
        String appId = dVar.getAppId();
        String optString = jSONObject.optString("filePath");
        if (w0.c(optString)) {
            a(dVar, str, "filePath is null", i.f121360f.f121277a);
            return;
        }
        v absoluteFile = dVar.getFileSystem().getAbsoluteFile(optString);
        if (absoluteFile != null && absoluteFile.e()) {
            String g16 = absoluteFile.g();
            String d16 = e.d(optString);
            w.d("MicroMsg.BaseCreateUploadTask", "upload appId(%s) uploadTaskId(%s)", dVar.getAppId(), str);
            C6643a c6643a = new C6643a(str, g16, dVar);
            com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
            Map a17 = q.a(jSONObject, aVar);
            String optString2 = jSONObject.optString("url");
            if (w0.c(optString2)) {
                w.d("MicroMsg.BaseCreateUploadTask", "url is null");
                a(dVar, str, "url is null or nil", i.f121360f.f121277a);
                return;
            }
            boolean z16 = jSONObject.optBoolean("__skipDomainCheck__") ? false : aVar.f145792b;
            if (z16 && !q.c(aVar.f145803m, optString2)) {
                w.d("MicroMsg.BaseCreateUploadTask", "not in domain url %s", optString2);
                a(dVar, str, "url not in domain list", i.f121357c.f121277a);
                return;
            }
            if (aVar.f145799i <= 0) {
                w.d("MicroMsg.BaseCreateUploadTask", "concurrent <= 0 ");
            }
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = q.a(aVar, 2);
            }
            int i3 = optInt > 0 ? optInt : 60000;
            if (p.b().a(appId) == null) {
                o oVar = new o(dVar, this.f138679a);
                p.b().a(appId, oVar);
                a16 = oVar;
            } else {
                a16 = p.b().a(appId);
            }
            String name = FilenameUtils.getName(optString);
            if (a16 != null) {
                w.d("MicroMsg.BaseCreateUploadTask", "before do upload, checkDomains = %b, timeout %d, inputTimeout: %d", Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(jSONObject.optInt("timeout", 0)));
                if (!z16) {
                    a16.a(i3, d16, g16, jSONObject, a17, null, c6643a, str, com.tencent.luggage.wxa.qf.b.NAME, name);
                    return;
                } else {
                    a16.a(i3, d16, g16, jSONObject, a17, aVar.f145803m, c6643a, str, com.tencent.luggage.wxa.qf.b.NAME, name);
                    return;
                }
            }
            return;
        }
        w.b("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", dVar.getAppId(), optString);
        a(dVar, str, "fail:file doesn't exist", i.f121360f.f121277a);
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, int i3) {
        w.h("MicroMsg.BaseCreateUploadTask", "sendFailMsg, uploadTaskId = %s, errMsg = %s, errno = %d", str, str2, Integer.valueOf(i3));
        HashMap hashMap = new HashMap();
        hashMap.put("uploadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put(com.tencent.luggage.wxa.xd.o.ERRNO_TAG, Integer.valueOf(i3));
        hashMap.put("errMsg", str2);
        new b().setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch(this.f138680b.a(str));
    }

    public final boolean a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        o a16 = p.b().a(dVar.getAppId());
        if (a16 == null || !a16.b(str)) {
            return false;
        }
        w.d("MicroMsg.BaseCreateUploadTask", "upload abort %s", str);
        return true;
    }
}
