package com.tencent.luggage.wxa.ig;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfo";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f130290a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130291b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f130292c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f130293d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f130294e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f130295f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fd.q f130296g;

        public a(WeakReference weakReference, int i3, String str, int i16, int i17, long j3, com.tencent.luggage.wxa.fd.q qVar) {
            this.f130290a = weakReference;
            this.f130291b = i3;
            this.f130292c = str;
            this.f130293d = i16;
            this.f130294e = i17;
            this.f130295f = j3;
            this.f130296g = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.xd.d dVar = (com.tencent.luggage.wxa.xd.d) this.f130290a.get();
            if (dVar == null) {
                return;
            }
            Object[] a16 = ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(n.this.b(dVar), this.f130291b, this.f130292c).a(this.f130293d, n.this.b(dVar));
            List list = (List) a16[0];
            int ceil = (int) Math.ceil(((Integer) a16[1]).doubleValue() / 1000.0d);
            n.this.a(list, ceil, (int) Math.ceil(((Integer) a16[2]).doubleValue() / 1000.0d), dVar, this.f130294e);
            n.this.a(2, list, ceil * 1000, this.f130295f, this.f130296g);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f130298a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f130299b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130300c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f130301d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fd.q f130302e;

        public b(p pVar, WeakReference weakReference, int i3, long j3, com.tencent.luggage.wxa.fd.q qVar) {
            this.f130298a = pVar;
            this.f130299b = weakReference;
            this.f130300c = i3;
            this.f130301d = j3;
            this.f130302e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f130298a.f();
            com.tencent.luggage.wxa.xd.d dVar = (com.tencent.luggage.wxa.xd.d) this.f130299b.get();
            if (dVar == null) {
                return;
            }
            n nVar = n.this;
            p pVar = this.f130298a;
            nVar.a(pVar.f130306e, pVar.f130307f, pVar.f130308g, dVar, this.f130300c);
            n nVar2 = n.this;
            p pVar2 = this.f130298a;
            nVar2.a(1, pVar2.f130306e, pVar2.f130307f * 1000, this.f130301d, this.f130302e);
            this.f130298a.f();
        }
    }

    public String b(com.tencent.luggage.wxa.xd.d dVar) {
        return dVar.getAppId();
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        int optInt = jSONObject.optInt("storageId", 0);
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            dVar.a(i3, makeReturnJson("fail:nonexistent storage space"));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        WeakReference weakReference = new WeakReference(dVar);
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        int i16 = qVar.f125967m;
        String str = qVar.D;
        if (i16 != 1) {
            com.tencent.luggage.wxa.co.a.a(new a(weakReference, i16, str, optInt, i3, currentTimeMillis, qVar), "JsApiGetStorageInfo");
            return;
        }
        p pVar = new p();
        pVar.f130304c = b(dVar);
        pVar.f130305d = optInt;
        pVar.f130309h = new b(pVar, weakReference, i3, currentTimeMillis, qVar);
        pVar.b();
    }

    public final void a(int i3, List list, int i16, long j3, com.tencent.luggage.wxa.fd.q qVar) {
        com.tencent.luggage.wxa.rc.u.a(i3, 3, i16, list == null ? 0 : list.size(), System.currentTimeMillis() - j3, qVar);
    }

    public final void a(List list, int i3, int i16, com.tencent.luggage.wxa.xd.d dVar, int i17) {
        HashMap hashMap = new HashMap();
        hashMap.put("keys", list);
        hashMap.put("currentSize", Integer.valueOf(i3));
        hashMap.put("limitSize", Integer.valueOf(i16));
        dVar.a(i17, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
