package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.wxa.ff.i;
import com.tencent.luggage.wxa.ff.j;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.kj.f1;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mm.plugin.appbrand.jsapi.live.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class JsApiInsertLivePlayer extends com.tencent.luggage.wxa.ee.b {
    private static final int CTRL_INDEX = 364;
    public static final String NAME = "insertLivePlayer";
    private static final String TAG = "MicroMsg.JsApiInsertLivePlayer";

    /* loaded from: classes9.dex */
    public static final class OnLivePlayerAudioVolume extends k0 {
        private static final int CTRL_INDEX = 709;
        private static final String NAME = "onLivePlayerAudioVolume";

        OnLivePlayerAudioVolume() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class OnLivePlayerFullScreenChange extends k0 {
        private static final int CTRL_INDEX = 371;
        private static final String NAME = "onLivePlayerFullScreenChange";

        OnLivePlayerFullScreenChange() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class OnLivePlayerNetStatus extends k0 {
        private static final int CTRL_INDEX = 412;
        private static final String NAME = "onLivePlayerNetStatus";

        OnLivePlayerNetStatus() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class OnPlayEvent extends k0 {
        private static final int CTRL_INDEX = 369;
        private static final String NAME = "onLivePlayerEvent";

        OnPlayEvent() {
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) throws JSONException {
        return jSONObject.getInt("livePlayerId");
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public View inflateView(f fVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.ye.b bVar = new com.tencent.luggage.wxa.ye.b(fVar.getContext(), new a(fVar, fVar.getContext()));
        bVar.setBackgroundColor(-16777216);
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.ee.b, com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        i.b();
        super.invoke(dVar, jSONObject, i3);
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public void onInsertView(final f fVar, final int i3, View view, JSONObject jSONObject) {
        Context context;
        int i16;
        w.d(TAG, "onInsertView livePlayerId=%d", Integer.valueOf(i3));
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h(TAG, "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i3));
            return;
        }
        TXLiveBase.setAppVersion(String.format("weixin_%s", fVar.getAppId()));
        final a aVar = (a) ((com.tencent.luggage.wxa.ye.b) view).a(a.class);
        final f1 f1Var = new f1() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePlayer.1
            @Override // com.tencent.luggage.wxa.kj.f1
            public void onExitFullscreen() {
                aVar.b();
            }
        };
        final g.d dVar = new g.d() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePlayer.2
            @Override // com.tencent.luggage.wxa.xd.g.d
            public void onForeground() {
                aVar.c();
            }
        };
        final g.b bVar = new g.b() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePlayer.3
            @Override // com.tencent.luggage.wxa.xd.g.b
            public void onBackground() {
                e.d d16 = e.d(fVar.getAppId());
                w.d(JsApiInsertLivePlayer.TAG, "LivePlayer enter background, pause type:%s", d16.name());
                aVar.a(d16);
            }
        };
        g.c cVar = new g.c() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePlayer.4
            @Override // com.tencent.luggage.wxa.xd.g.c
            public void onDestroy() {
                aVar.a();
                fVar.b(this);
            }
        };
        fVar.b(dVar);
        fVar.a(bVar);
        fVar.a(cVar);
        final boolean independent = getIndependent(jSONObject);
        aVar.a(new a.InterfaceC7059a() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePlayer.5
            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.a.InterfaceC7059a
            public void enterFullScreen(int i17) {
                fVar.a(independent).a(i3, f1Var, i17);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.a.InterfaceC7059a
            public boolean isFullScreen() {
                return fVar.a(independent).a(i3);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.a.InterfaceC7059a
            public void quitFullScreen() {
                fVar.a(independent).e(i3);
            }
        });
        aVar.a(new a.b() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePlayer.6
            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.a.b
            public void onLivePlayerExit() {
                fVar.b(bVar);
                fVar.a(dVar);
            }
        });
        aVar.b(jSONObject.optBoolean("needEvent", false));
        aVar.a(new a.c() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePlayer.7
            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.a.c
            public void onFullScreenChange(boolean z16, int i17) {
                OnLivePlayerFullScreenChange onLivePlayerFullScreenChange = new OnLivePlayerFullScreenChange();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("fullScreen", z16);
                    jSONObject2.put("direction", i17);
                    jSONObject2.put("livePlayerId", i3);
                } catch (JSONException unused) {
                }
                fVar.a(onLivePlayerFullScreenChange.setData(jSONObject2.toString()), (int[]) null);
            }
        });
        Bundle a16 = j.a(jSONObject);
        aVar.a(a16);
        aVar.a(new ITXLivePlayListener() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePlayer.8
            @Override // com.tencent.rtmp.ITXLivePlayListener
            public void onNetStatus(Bundle bundle) {
                OnLivePlayerNetStatus onLivePlayerNetStatus = new OnLivePlayerNetStatus();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("livePlayerId", i3);
                    JSONObject jSONObject3 = new JSONObject();
                    if (bundle != null) {
                        for (String str : bundle.keySet()) {
                            jSONObject3.put(str, bundle.get(str));
                        }
                    }
                    jSONObject2.put("info", jSONObject3);
                } catch (JSONException unused) {
                }
                fVar.a(onLivePlayerNetStatus.setData(jSONObject2.toString()), (int[]) null);
            }

            @Override // com.tencent.rtmp.ITXLivePlayListener
            public void onPlayEvent(int i17, Bundle bundle) {
                w.d(JsApiInsertLivePlayer.TAG, "onPlayEvent errCode:%d", Integer.valueOf(i17));
                OnPlayEvent onPlayEvent = new OnPlayEvent();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("errCode", i17);
                    jSONObject2.put("errMsg", bundle.getString("EVT_MSG"));
                    jSONObject2.put("livePlayerId", i3);
                } catch (JSONException unused) {
                }
                fVar.a(onPlayEvent.setData(jSONObject2.toString()), (int[]) null);
            }
        });
        aVar.a(new TXLivePlayer.ITXAudioVolumeEvaluationListener() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePlayer.9
            @Override // com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener
            public void onAudioVolumeEvaluationNotify(int i17) {
                OnLivePlayerAudioVolume onLivePlayerAudioVolume = new OnLivePlayerAudioVolume();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("livePlayerId", i3);
                    jSONObject2.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, i17);
                } catch (JSONException unused) {
                }
                fVar.a(onLivePlayerAudioVolume.setData(jSONObject2.toString()), (int[]) null);
            }
        });
        if (a16.getInt("mode", 0) == 5) {
            context = view.getContext();
            i16 = R.string.ywg;
        } else {
            context = view.getContext();
            i16 = R.string.ywf;
        }
        aVar.setContentDescription(context.getString(i16));
    }
}
