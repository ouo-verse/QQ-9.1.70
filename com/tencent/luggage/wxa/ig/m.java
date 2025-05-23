package com.tencent.luggage.wxa.ig;

import android.os.Process;
import com.tencent.luggage.wxa.rc.p;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorage";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f130274a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fd.q f130275b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130276c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f130277d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130278e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f130279f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f130280g;

        public a(String str, com.tencent.luggage.wxa.fd.q qVar, int i3, String str2, com.tencent.luggage.wxa.xd.d dVar, int i16, long j3) {
            this.f130274a = str;
            this.f130275b = qVar;
            this.f130276c = i3;
            this.f130277d = str2;
            this.f130278e = dVar;
            this.f130279f = i16;
            this.f130280g = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            com.tencent.luggage.wxa.k4.a aVar = (com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class);
            String str3 = this.f130274a;
            com.tencent.luggage.wxa.fd.q qVar = this.f130275b;
            Object[] a16 = aVar.a(str3, qVar.f125967m, qVar.D).a(this.f130276c, this.f130274a, this.f130277d);
            p.a aVar2 = (p.a) a16[0];
            p.a aVar3 = p.a.NONE;
            String str4 = null;
            if (aVar2 == aVar3) {
                str = (String) a16[1];
            } else {
                str = null;
            }
            if (aVar2 == aVar3) {
                str4 = (String) a16[2];
            }
            String str5 = str4;
            if (str == null) {
                str2 = "fail:data not found";
            } else {
                str2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
            m.this.a(str2, str, str5, this.f130278e, this.f130279f);
            m.this.a(2, com.tencent.luggage.wxa.rc.v.a(this.f130277d, str), this.f130280g, this.f130275b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f130282a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130283b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130284c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f130285d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f130286e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fd.q f130287f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f130288g;

        public b(r rVar, com.tencent.luggage.wxa.xd.d dVar, int i3, String str, long j3, com.tencent.luggage.wxa.fd.q qVar, long j16) {
            this.f130282a = rVar;
            this.f130283b = dVar;
            this.f130284c = i3;
            this.f130285d = str;
            this.f130286e = j3;
            this.f130287f = qVar;
            this.f130288g = j16;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            r rVar = this.f130282a;
            String str2 = rVar.f130318k;
            if (str2 == null) {
                str = "fail:data not found";
            } else {
                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
            m.this.a(str, str2, rVar.f130319l, this.f130283b, this.f130284c);
            m.this.a(1, com.tencent.luggage.wxa.rc.v.a(this.f130285d, this.f130282a.f130318k), this.f130286e, this.f130287f);
            this.f130282a.f();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", this.f130282a.f130317j, Long.valueOf(System.currentTimeMillis() - this.f130288g));
        }
    }

    public String b(com.tencent.luggage.wxa.xd.d dVar) {
        return dVar.getAppId();
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b));
            return;
        }
        if (w0.c(optString)) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.k.f121388d));
            return;
        }
        String b16 = b(dVar);
        if (w0.c(b16)) {
            dVar.a(i3, makeReturnJson("fail:appID is empty"));
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        if (qVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetStorage", "invoke with appId[%s] callbackId[%d], NULL sysConfig", dVar.getAppId(), Integer.valueOf(i3));
            dVar.a(i3, makeReturnJson("fail:internal error"));
            return;
        }
        if (qVar.f125967m != 1) {
            com.tencent.luggage.wxa.co.a.a(new a(b16, qVar, optInt, optString, dVar, i3, currentTimeMillis2), "JsApiGetStorage");
            return;
        }
        r rVar = new r();
        rVar.f130310c = b16;
        rVar.f130317j = optString;
        rVar.f130311d = optInt;
        rVar.f130320m = "" + Process.myPid() + "" + super.hashCode();
        rVar.f130312e = new b(rVar, dVar, i3, optString, currentTimeMillis2, qVar, currentTimeMillis);
        rVar.b();
    }

    public final void a(int i3, int i16, long j3, com.tencent.luggage.wxa.fd.q qVar) {
        com.tencent.luggage.wxa.rc.u.a(i3, 2, i16, 1, System.currentTimeMillis() - j3, qVar);
    }

    public final void a(String str, String str2, String str3, com.tencent.luggage.wxa.xd.d dVar, int i3) {
        HashMap hashMap = new HashMap();
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("data", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("dataType", str3);
        dVar.a(i3, makeReturnJson(str, hashMap));
    }
}
