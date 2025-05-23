package com.tencent.luggage.wxa.uh;

import android.os.Bundle;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.miniapp.plugin.EmbeddedLivePlayerJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements com.tencent.luggage.wxa.e8.b {

    /* renamed from: a, reason: collision with root package name */
    public AppBrandInvokeContext f142399a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.uh.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6801b extends k0 {
        private static final int CTRL_INDEX = 710;
        private static final String NAME = "onXWebLivePlayerAudioVolume";

        public C6801b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends k0 {
        private static final int CTRL_INDEX = 839;
        private static final String NAME = "onXWebLivePlayerBackgroundPlaybackChange";

        public c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends k0 {
        private static final int CTRL_INDEX = 575;
        private static final String NAME = "onXWebLivePlayerEvent";

        public d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends k0 {
        private static final int CTRL_INDEX = 576;
        private static final String NAME = "onXWebLivePlayerNetStatus";

        public e() {
        }
    }

    @Override // com.tencent.luggage.wxa.e8.b
    public void a(com.tencent.luggage.wxa.z7.c cVar) {
        if (cVar instanceof AppBrandInvokeContext) {
            this.f142399a = (AppBrandInvokeContext) cVar;
        }
    }

    @Override // com.tencent.luggage.wxa.e8.b
    public void a(int i3, int i16, Bundle bundle) {
        d dVar = new d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i3);
            jSONObject.put("errCode", i16);
            jSONObject.put("errMsg", bundle == null ? "" : bundle.getString("EVT_MSG"));
            a(dVar, jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerEvent fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.e8.b
    public void a(int i3, Bundle bundle) {
        k0 eVar = new e();
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
            a(eVar, jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerNetStatus fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.e8.b
    public void a(int i3, int i16) {
        C6801b c6801b = new C6801b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i3);
            jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, i16);
            a(c6801b, jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerAudioVolume fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.e8.b
    public void a(int i3, boolean z16) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewId", i3);
            jSONObject.put("playInBackground", z16);
            a(new c(), jSONObject);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerBackgroundPlaybackChange fail", e16);
        }
    }

    public final void a(k0 k0Var, JSONObject jSONObject) {
        com.tencent.luggage.wxa.xd.d e16;
        if (k0Var != null) {
            if (!k0Var.getName().equalsIgnoreCase(EmbeddedLivePlayerJsPlugin.EVENT_TYPE_PLAYER_EVENT) && !k0Var.getName().equalsIgnoreCase(EmbeddedLivePlayerJsPlugin.EVENT_TYPE_NET_STATUS) && !k0Var.getName().equalsIgnoreCase(EmbeddedLivePlayerJsPlugin.EVENT_ON_XWEB_LIVE_AUDIO_VOLUME)) {
                w.d("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "dispatch event:%s, data:%s", k0Var.getName(), jSONObject.toString());
            }
            k0 data = k0Var.setData(jSONObject.toString());
            AppBrandInvokeContext appBrandInvokeContext = this.f142399a;
            if (appBrandInvokeContext == null || (e16 = appBrandInvokeContext.e()) == null) {
                return;
            }
            if (e16 instanceof l) {
                l lVar = (l) e16;
                lVar.a(data, (int[]) null);
                v J = lVar.J();
                if (J != null) {
                    J.a(data, (int[]) null);
                    return;
                }
                return;
            }
            if (e16 instanceof v) {
                ((v) e16).a(data, (int[]) null);
            } else {
                e16.a(data, (int[]) null);
            }
        }
    }
}
