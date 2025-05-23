package com.tencent.luggage.wxa.yi;

import android.text.TextUtils;
import com.tencent.oskplayer.proxy.VideoProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class o implements i {

    /* renamed from: b, reason: collision with root package name */
    public int f145924b;

    /* renamed from: c, reason: collision with root package name */
    public final String f145925c;

    /* renamed from: d, reason: collision with root package name */
    public SSLContext f145926d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f145927e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f145928f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f145929g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f145930h = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.luggage.wxa.aj.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f145931a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f145932b;

        public a(String str, b bVar) {
            this.f145931a = str;
            this.f145932b = bVar;
        }

        @Override // com.tencent.luggage.wxa.aj.b
        public void a(String str, String str2) {
        }

        @Override // com.tencent.luggage.wxa.aj.b
        public void a(String str, String str2, String str3, int i3, long j3, Map map) {
            o.this.c(this.f145931a);
            this.f145932b.a(0, str3, i3);
        }

        @Override // com.tencent.luggage.wxa.aj.b
        public void a(JSONObject jSONObject) {
            this.f145932b.a(jSONObject);
        }

        @Override // com.tencent.luggage.wxa.aj.b
        public void a(String str, String str2, int i3, long j3, long j16) {
            this.f145932b.a(str, str2, i3, j3, j16);
        }

        @Override // com.tencent.luggage.wxa.aj.b
        public void a(String str, String str2, String str3, int i3) {
            o.this.c(this.f145931a);
            this.f145932b.b(-1, str3, i3);
        }

        @Override // com.tencent.luggage.wxa.aj.b
        public void a(String str) {
            o.this.f145930h.remove(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(int i3, String str, int i16);

        void a(String str, String str2, int i3, long j3, long j16);

        void a(JSONObject jSONObject);

        void b(int i3, String str, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
    }

    public o(com.tencent.luggage.wxa.xd.d dVar, boolean z16) {
        this.f145928f = false;
        this.f145927e = dVar;
        com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
        this.f145924b = aVar.f145799i;
        this.f145925c = aVar.K;
        this.f145926d = q.a(aVar);
        this.f145928f = z16;
    }

    public boolean b(String str) {
        return this.f145930h.contains(str);
    }

    public final void c(String str) {
        if (str == null) {
            return;
        }
        synchronized (this.f145929g) {
            Iterator it = this.f145929g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.luggage.wxa.aj.a aVar = (com.tencent.luggage.wxa.aj.a) it.next();
                if (str.equals(aVar.d())) {
                    this.f145929g.remove(aVar);
                    break;
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.yi.i
    public void release() {
        synchronized (this.f145929g) {
            Iterator it = this.f145929g.iterator();
            while (it.hasNext()) {
                ((com.tencent.luggage.wxa.aj.a) it.next()).b(false);
            }
            this.f145929g.clear();
        }
    }

    public void a(int i3, String str, String str2, JSONObject jSONObject, Map map, ArrayList arrayList, b bVar, String str3, String str4, String str5) {
        String a16 = q.a(jSONObject.optString("url"));
        String optString = jSONObject.optString("name");
        Map a17 = q.a(jSONObject);
        synchronized (this.f145929g) {
            if (this.f145929g.size() >= this.f145924b) {
                com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.i.f121362h;
                bVar.b(-1, cVar.f121278b, cVar.f121277a);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUpload", "max connected mUploadTaskList.size():%d,mMaxUploadConcurrent:%d", Integer.valueOf(this.f145929g.size()), Integer.valueOf(this.f145924b));
                return;
            }
            if (TextUtils.isEmpty(optString)) {
                bVar.b(-1, "fileName error", com.tencent.luggage.wxa.af.i.f121360f.f121277a);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUpload", "fileName error");
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("enableHttp2", false);
            boolean optBoolean2 = jSONObject.optBoolean("enableQuic", false);
            boolean optBoolean3 = jSONObject.optBoolean(VideoProxy.PARAM_ENABLE_CACHE, false);
            boolean optBoolean4 = jSONObject.optBoolean("enableProfile", true);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkUpload", "upload taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", str3, Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean3), Boolean.valueOf(optBoolean4));
            com.tencent.luggage.wxa.aj.a aVar = new com.tencent.luggage.wxa.aj.a(this.f145927e, a16, str2, optString, str5, str, this.f145925c, this.f145928f, optBoolean, optBoolean2, optBoolean3, optBoolean4, new a(str3, bVar));
            aVar.a(a17);
            aVar.b(map);
            aVar.c(i3);
            aVar.b(true);
            aVar.a(arrayList);
            aVar.a(this.f145926d);
            aVar.b(str3);
            aVar.a(str4);
            synchronized (this.f145929g) {
                this.f145929g.add(aVar);
            }
            com.tencent.luggage.wxa.zp.h.f146825d.b(aVar, "appbrand_upload_thread");
        }
    }

    public com.tencent.luggage.wxa.aj.a a(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.f145929g) {
            Iterator it = this.f145929g.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.aj.a aVar = (com.tencent.luggage.wxa.aj.a) it.next();
                if (str.equals(aVar.d())) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public void a(com.tencent.luggage.wxa.aj.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f145930h.add(aVar.d());
        c(aVar.d());
        aVar.a();
    }
}
