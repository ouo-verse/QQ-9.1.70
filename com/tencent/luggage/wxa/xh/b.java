package com.tencent.luggage.wxa.xh;

import android.os.Bundle;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements com.tencent.luggage.wxa.g8.b {

    /* renamed from: a, reason: collision with root package name */
    public AppBrandInvokeContext f144986a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xh.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6910b extends k0 {
        private static final int CTRL_INDEX = 784;
        private static final String NAME = "onXWebLivePusherAudioVolume";

        public C6910b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends k0 {
        private static final int CTRL_INDEX = 573;
        private static final String NAME = "onXWebLivePusherBGMComplete";

        public c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends k0 {
        private static final int CTRL_INDEX = 572;
        private static final String NAME = "onXWebLivePusherBGMProgress";

        public d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e extends k0 {
        private static final int CTRL_INDEX = 571;
        private static final String NAME = "onXWebLivePusherBGMStart";

        public e() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class f extends k0 {
        private static final int CTRL_INDEX = 574;
        private static final String NAME = "onXWebLivePusherError";

        public f() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class g extends k0 {
        private static final int CTRL_INDEX = 569;
        private static final String NAME = "onXWebLivePusherEvent";

        public g() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class h extends k0 {
        private static final int CTRL_INDEX = 570;
        private static final String NAME = "onXWebLivePusherNetStatus";

        public h() {
        }
    }

    @Override // com.tencent.luggage.wxa.g8.b
    public void a(com.tencent.luggage.wxa.z7.c cVar) {
        if (cVar instanceof AppBrandInvokeContext) {
            this.f144986a = (AppBrandInvokeContext) cVar;
        }
    }

    @Override // com.tencent.luggage.wxa.g8.b
    public void b(int i3, int i16) {
        C6910b c6910b = new C6910b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i3);
            jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, i16);
            a(c6910b, jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherAudioVolume fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.g8.b
    public void a(int i3, int i16, Bundle bundle) {
        g gVar = new g();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i3);
            jSONObject.put("errCode", i16);
            jSONObject.put("errMsg", bundle == null ? "" : bundle.getString("EVT_MSG"));
            a(gVar, jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherEvent fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.g8.b
    public void a(int i3, Bundle bundle) {
        k0 hVar = new h();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i3);
            JSONObject jSONObject2 = new JSONObject();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    jSONObject2.put(str, bundle.get(str));
                }
            }
            jSONObject.put("info", jSONObject2);
            a(hVar, jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherNetStatus fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.g8.b
    public void a(int i3) {
        e eVar = new e();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i3);
            a(eVar, jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMStart fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.g8.b
    public void a(int i3, long j3, long j16) {
        d dVar = new d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i3);
            jSONObject.put("progress", j3);
            jSONObject.put("duration", j16);
            a(dVar, jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMProgress fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.g8.b
    public void a(int i3, int i16) {
        c cVar = new c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i3);
            jSONObject.put("errCode", i16);
            a(cVar, jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMComplete fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.g8.b
    public void a(int i3, com.tencent.luggage.wxa.af.c cVar, int i16, String str, HashMap hashMap) {
        f fVar = new f();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i3);
            jSONObject.put(o.ERRNO_TAG, cVar.f121277a);
            jSONObject.put("errCode", i16);
            jSONObject.put("errMsg", w0.d(str));
            if (hashMap != null && !hashMap.isEmpty()) {
                jSONObject.put("data", new JSONObject(hashMap));
            }
            a(fVar, jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherError fail", e16);
        }
    }

    public final void a(k0 k0Var, JSONObject jSONObject) {
        com.tencent.luggage.wxa.xd.d e16;
        if (k0Var != null) {
            if (!k0Var.getName().equalsIgnoreCase(EmbeddedLivePusherJsPlugin.EVENT_ON_XWEB_LIVE_PUSHER_EVENT) && !k0Var.getName().equalsIgnoreCase(EmbeddedLivePusherJsPlugin.EVENT_ON_XWEB_LIVE_PUSHER_NET_STATUS)) {
                w.d("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "dispatch event:%s, data:%s", k0Var.getName(), jSONObject.toString());
            }
            k0 data = k0Var.setData(jSONObject.toString());
            AppBrandInvokeContext appBrandInvokeContext = this.f144986a;
            if (appBrandInvokeContext == null || (e16 = appBrandInvokeContext.e()) == null) {
                return;
            }
            if (e16 instanceof l) {
                ((l) e16).a(data, (int[]) null);
            } else if (e16 instanceof v) {
                ((v) e16).a(data, (int[]) null);
            } else {
                e16.a(data, (int[]) null);
            }
        }
    }
}
