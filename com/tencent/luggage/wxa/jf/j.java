package com.tencent.luggage.wxa.jf;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.fd.n;
import com.tencent.luggage.wxa.fd.x;
import com.tencent.luggage.wxa.jf.d;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ml.m;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j implements com.tencent.luggage.wxa.jf.d {

    /* renamed from: a, reason: collision with root package name */
    public static j f131023a = new j();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c f131024a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c5.e f131025b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f131026c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.jf.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6335a implements Runnable {
            public RunnableC6335a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f131026c.f141499a != null) {
                    ((com.tencent.luggage.wxa.xi.c) a.this.f131026c.f141499a).dismiss();
                }
            }
        }

        public a(d.c cVar, com.tencent.luggage.wxa.c5.e eVar, com.tencent.luggage.wxa.tk.i iVar) {
            this.f131024a = cVar;
            this.f131025b = eVar;
            this.f131026c = iVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public void a(Object obj) {
            String obj2;
            boolean z16;
            if (this.f131024a != null) {
                if (obj instanceof Exception) {
                    obj2 = ((Exception) obj).getMessage();
                } else if (d.b.a.IGNORE == obj) {
                    obj2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                    z16 = true;
                    w.h("MicroMsg.MiniProgramNavigator", "onNavigateResult ok:%b, reason:%s", Boolean.valueOf(z16), obj2);
                    this.f131024a.a(z16, obj2);
                } else if (d.b.a.CANCEL == obj) {
                    obj2 = "cancel";
                } else if (obj == null) {
                    obj2 = VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR;
                } else {
                    obj2 = obj.toString();
                }
                z16 = false;
                w.h("MicroMsg.MiniProgramNavigator", "onNavigateResult ok:%b, reason:%s", Boolean.valueOf(z16), obj2);
                this.f131024a.a(z16, obj2);
            }
            this.f131025b.e(new RunnableC6335a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f131029b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131030c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d.c f131031d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ki.a f131032e;

        public b(com.tencent.luggage.wxa.tk.i iVar, com.tencent.luggage.wxa.ic.d dVar, d.c cVar, com.tencent.luggage.wxa.ki.a aVar) {
            this.f131029b = iVar;
            this.f131030c = dVar;
            this.f131031d = cVar;
            this.f131032e = aVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(com.tencent.luggage.wxa.j4.d dVar) {
            if (this.f131029b.f141499a != null) {
                ((com.tencent.luggage.wxa.xi.c) this.f131029b.f141499a).dismiss();
            }
            if (dVar == null) {
                com.tencent.luggage.wxa.xo.h.a().a(new Exception("get attrs failed"));
            } else if (TextUtils.isEmpty(dVar.f125808a)) {
                if (!com.tencent.luggage.wxa.tn.e.f141559a) {
                    com.tencent.luggage.wxa.xo.h.a().a(new Exception("get invalid appId"));
                } else {
                    throw new IllegalAccessError("get invalid appId");
                }
            } else {
                if (!this.f131030c.isRunning()) {
                    com.tencent.luggage.wxa.xo.h.a().a(new Exception("fail:interrupted"));
                    return null;
                }
                com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) this.f131030c.getRuntime();
                if (eVar == null) {
                    com.tencent.luggage.wxa.xo.h.a().a(new Exception("fail:internal error"));
                    return null;
                }
                d.c cVar = this.f131031d;
                if (cVar != null) {
                    cVar.a(dVar);
                }
                dVar.f130794f0 = eVar.S().f130794f0;
                eVar.a(dVar, this.f131032e.f132032i);
                d.c cVar2 = this.f131031d;
                if (cVar2 != null) {
                    cVar2.a(true, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131034b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d.a f131035c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ki.a f131036d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f131037e;

        public c(com.tencent.luggage.wxa.ic.d dVar, d.a aVar, com.tencent.luggage.wxa.ki.a aVar2, JSONObject jSONObject) {
            this.f131034b = dVar;
            this.f131035c = aVar;
            this.f131036d = aVar2;
            this.f131037e = jSONObject;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.j4.d call(Boolean bool) {
            com.tencent.luggage.wxa.xo.h.a((com.tencent.luggage.wxa.xo.e) j.this.a(this.f131034b, this.f131035c, this.f131036d, this.f131037e));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f131039b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c5.e f131040c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f131041d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f131042e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131043f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ki.a f131044g;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Function {
            public a() {
            }

            @Override // androidx.arch.core.util.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public m.a apply(Context context) {
                d dVar = d.this;
                m.a a16 = j.this.a(dVar.f131040c);
                a16.setTitle("");
                a16.setMessage(context.getString(R.string.ywk));
                return a16;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements DialogInterface.OnCancelListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f131047a;

            public b(com.tencent.luggage.wxa.xo.b bVar) {
                this.f131047a = bVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                this.f131047a.a(new Exception("cancel"));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements d.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f131049a;

            public c(com.tencent.luggage.wxa.xo.b bVar) {
                this.f131049a = bVar;
            }
        }

        public d(com.tencent.luggage.wxa.tk.i iVar, com.tencent.luggage.wxa.c5.e eVar, String str, String str2, com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.ki.a aVar) {
            this.f131039b = iVar;
            this.f131040c = eVar;
            this.f131041d = str;
            this.f131042e = str2;
            this.f131043f = dVar;
            this.f131044g = aVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(Void r56) {
            com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
            this.f131039b.f141499a = new com.tencent.luggage.wxa.xi.c();
            ((com.tencent.luggage.wxa.xi.c) this.f131039b.f141499a).a(new a());
            ((com.tencent.luggage.wxa.xi.c) this.f131039b.f141499a).a(new b(b16));
            ((com.tencent.luggage.wxa.xi.c) this.f131039b.f141499a).a(this.f131040c);
            if (!j.this.a(this.f131043f, this.f131044g, new c(b16))) {
                b16.a(Boolean.TRUE);
            }
            return Boolean.FALSE;
        }
    }

    public int a(x xVar) {
        return 0;
    }

    public boolean a(com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.ki.a aVar, d.b bVar) {
        return false;
    }

    public final m.a a(com.tencent.luggage.wxa.ic.g gVar) {
        Context L = gVar.L();
        if (L == null) {
            L = gVar.F();
        }
        if (L == null) {
            return null;
        }
        return new com.tencent.luggage.wxa.ml.i(L);
    }

    public com.tencent.luggage.wxa.xo.d a(com.tencent.luggage.wxa.ic.d dVar, d.a aVar, com.tencent.luggage.wxa.ki.a aVar2, JSONObject jSONObject) {
        return com.tencent.luggage.wxa.xo.h.a((Object) null);
    }

    @Override // com.tencent.luggage.wxa.jf.d
    public final void a(com.tencent.luggage.wxa.ic.d dVar, String str, int i3, String str2, d.a aVar, JSONObject jSONObject, x xVar, d.c cVar) {
        com.tencent.luggage.wxa.gi.b.b(com.tencent.luggage.wxa.ik.a.class, str);
        com.tencent.luggage.wxa.gi.b.a(com.tencent.luggage.wxa.ik.a.class, str, String.format("Network:%s", h0.e(dVar.getRuntime().F())));
        w.d("MicroMsg.MiniProgramNavigator", "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d, callbackId:%d", dVar.getAppId(), str, Integer.valueOf(aVar.f130994g), Integer.valueOf(aVar.f130988a));
        String appId = dVar.getAppId();
        JSONObject optJSONObject = jSONObject.optJSONObject(WadlProxyConsts.EXTRA_DATA);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("privateExtraData");
        v a16 = a(dVar);
        String B0 = a16 != null ? a16.B0() : "";
        com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) dVar.getRuntime();
        String str3 = dVar.getAppId() + ":" + eVar.S().j() + ":" + (eVar.S().I + 1000);
        com.tencent.luggage.wxa.bk.e L1 = eVar.L1();
        com.tencent.luggage.wxa.bk.e eVar2 = new com.tencent.luggage.wxa.bk.e();
        int i16 = aVar.f130989b;
        eVar2.f122984c = i16 != 0 ? i16 : 1037;
        eVar2.f122987f = L1.f122987f;
        if (i16 != 0 && !w0.c(aVar.f130990c)) {
            str3 = String.format("%s:%s", str3, aVar.f130990c);
        }
        eVar2.f122985d = str3;
        eVar2.f122982a = aVar.f130991d;
        eVar2.f122983b = aVar.f130992e;
        eVar2.f122988g = aVar.f130995h;
        com.tencent.luggage.wxa.fd.n nVar = new com.tencent.luggage.wxa.fd.n();
        nVar.f125848b = dVar.getAppId();
        nVar.f125849c = optJSONObject == null ? "{}" : optJSONObject.toString();
        nVar.f125850d = optJSONObject2 != null ? optJSONObject2.toString() : "{}";
        nVar.f125847a = 1;
        nVar.f125852f = B0;
        nVar.f125854h = aVar.f130994g;
        nVar.f125853g = aVar.f130993f;
        String str4 = aVar.f130996i;
        nVar.f125855i = str4;
        if (!TextUtils.isEmpty(str4)) {
            n.b bVar = new n.b();
            nVar.f125856j = bVar;
            bVar.f125860a = aVar.f130998k;
            bVar.f125861b = aVar.f130999l;
        }
        com.tencent.luggage.wxa.ki.a aVar2 = new com.tencent.luggage.wxa.ki.a();
        aVar2.f132016a = null;
        aVar2.f132018b = str;
        aVar2.f132020c = 0;
        aVar2.f132022d = i3;
        if (jSONObject.has("devuin")) {
            aVar2.f132024e = com.tencent.luggage.wxa.y8.h.a(jSONObject.optString("devuin"));
        }
        aVar2.f132026f = str2;
        aVar2.f132032i = eVar2;
        aVar2.f132034j = nVar;
        aVar2.f132036k = null;
        aVar2.f();
        aVar2.Q = xVar == null ? x.f125989g0 : xVar;
        aVar2.f132023d0 = eVar.S().f130809u0;
        aVar2.f132025e0 = eVar.S().f130810v0;
        aVar2.O = a(xVar);
        aVar2.S = aVar.f130997j;
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        com.tencent.luggage.wxa.xo.h.c().a(eVar).a(new d(iVar, eVar, appId, str, dVar, aVar2)).a(new c(dVar, aVar, aVar2, jSONObject)).a(new b(iVar, dVar, cVar, aVar2)).a(new a(cVar, eVar, iVar));
    }

    @Override // com.tencent.luggage.wxa.jf.d
    public void a(com.tencent.luggage.wxa.ic.d dVar, String str, int i3, String str2, d.a aVar, JSONObject jSONObject, d.c cVar) {
        a(dVar, str, i3, str2, aVar, jSONObject, null, cVar);
    }

    public static v a(com.tencent.luggage.wxa.xd.i iVar) {
        if (iVar instanceof v) {
            return (v) iVar;
        }
        return ((com.tencent.luggage.wxa.ic.l) iVar).J();
    }
}
