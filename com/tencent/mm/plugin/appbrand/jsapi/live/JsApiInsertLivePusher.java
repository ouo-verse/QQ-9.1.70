package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.luggage.wxa.af.e;
import com.tencent.luggage.wxa.ff.j;
import com.tencent.luggage.wxa.h6.k;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.rj.q;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.g;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.y8.i;
import com.tencent.mm.plugin.appbrand.jsapi.live.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class JsApiInsertLivePusher extends com.tencent.luggage.wxa.ee.b {
    private static final int CTRL_INDEX = 360;
    public static final String NAME = "insertLivePusher";
    private static final String TAG = "MicroMsg.JsApiInsertLivePusher";
    private int preventiveCnt;

    /* loaded from: classes9.dex */
    public static final class OnLivePusherAudioVolume extends k0 {
        private static final int CTRL_INDEX = 783;
        private static final String NAME = "onLivePusherAudioVolume";

        OnLivePusherAudioVolume() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class OnLivePusherBGMComplete extends k0 {
        private static final int CTRL_INDEX = 515;
        private static final String NAME = "onLivePusherBGMComplete";

        OnLivePusherBGMComplete() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class OnLivePusherBGMProgress extends k0 {
        private static final int CTRL_INDEX = 514;
        private static final String NAME = "onLivePusherBGMProgress";

        OnLivePusherBGMProgress() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class OnLivePusherBGMStart extends k0 {
        private static final int CTRL_INDEX = 513;
        private static final String NAME = "onLivePusherBGMStart";

        OnLivePusherBGMStart() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class OnLivePusherError extends k0 {
        private static final int CTRL_INDEX = 531;
        private static final String NAME = "onLivePusherError";

        OnLivePusherError() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class OnLivePusherNetStatus extends k0 {
        private static final int CTRL_INDEX = 411;
        private static final String NAME = "onLivePusherNetStatus";

        OnLivePusherNetStatus() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class OnPushEvent extends k0 {
        private static final int CTRL_INDEX = 368;
        private static final String NAME = "onLivePusherEvent";

        OnPushEvent() {
        }
    }

    private void convertBackgroundImageToLocalPath(com.tencent.luggage.wxa.xd.d dVar, final b bVar, JSONObject jSONObject) {
        final String optString = jSONObject.optString("backgroundImage");
        String optString2 = jSONObject.optString("backgroundMD5");
        if (w0.c(optString)) {
            w.d(TAG, "convertBackgroundImageToLocalPath, url is null");
        } else {
            g.c(dVar, optString, optString2, new g.d() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.10
                @Override // com.tencent.luggage.wxa.uk.g.d
                public void onLoad(String str) {
                    if (!w0.c(str)) {
                        String a16 = i.a(str, false);
                        w.d(JsApiInsertLivePusher.TAG, "convertBackgroundImageToLocalPath, targetPath:%s", a16);
                        Bundle bundle = new Bundle();
                        bundle.putString("backgroundImage", a16);
                        bVar.b(bundle);
                        return;
                    }
                    w.d(JsApiInsertLivePusher.TAG, "convertBackgroundImageToLocalPath, load background image fail");
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("url", optString);
                    bVar.a(com.tencent.luggage.wxa.af.g.f121349r, 10004, "load background image fail", hashMap);
                }
            });
        }
    }

    private void convertFilterImageToLocalPath(com.tencent.luggage.wxa.xd.d dVar, final b bVar, JSONObject jSONObject) {
        final String optString = jSONObject.optString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE);
        if (w0.c(optString)) {
            w.d(TAG, "convertFilterImageToLocalPath, url is null");
        } else {
            g.c(dVar, optString, null, new g.d() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.11
                @Override // com.tencent.luggage.wxa.uk.g.d
                public void onLoad(String str) {
                    if (!w0.c(str)) {
                        String a16 = i.a(str, false);
                        w.d(JsApiInsertLivePusher.TAG, "convertFilterImageToLocalPath, localPath:%s", a16);
                        Bundle bundle = new Bundle();
                        bundle.putString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, a16);
                        bVar.b(bundle);
                        return;
                    }
                    w.d(JsApiInsertLivePusher.TAG, "convertFilterImageToLocalPath, load filter image fail");
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("url", optString);
                    bVar.a(com.tencent.luggage.wxa.af.g.f121349r, 10005, "load filter image fail", hashMap);
                }
            });
        }
    }

    private void convertWatermarkImageToLocalPath(com.tencent.luggage.wxa.xd.d dVar, final b bVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("watermarkImage");
        String optString2 = jSONObject.optString("watermarkMD5");
        if (w0.c(optString)) {
            w.d(TAG, "convertWatermarkImageToLocalPath, url is null");
        } else {
            g.c(dVar, optString, optString2, new g.d() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.12
                @Override // com.tencent.luggage.wxa.uk.g.d
                public void onLoad(String str) {
                    if (!w0.c(str)) {
                        String a16 = i.a(str, false);
                        w.d(JsApiInsertLivePusher.TAG, "convertWatermarkImageToLocalPath, localPath:%s", a16);
                        Bundle bundle = new Bundle();
                        bundle.putString("watermarkImage", a16);
                        bVar.b(bundle);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInvokeAfterRequestPermission(final Activity activity, final com.tencent.luggage.wxa.xd.d dVar, final JSONObject jSONObject, final int i3) {
        int i16 = this.preventiveCnt;
        this.preventiveCnt = i16 + 1;
        if (i16 > 5) {
            w.d(TAG, "doInvokeAfterRequestPermission, avoid dead loop");
            return;
        }
        q.c(dVar.getAppId(), new ActivityCompat.OnRequestPermissionsResultCallback() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.13
            @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
            public void onRequestPermissionsResult(int i17, @NonNull String[] strArr, @NonNull int[] iArr) {
                w.d(JsApiInsertLivePusher.TAG, "onRequestPermissionsResult callback requestCode:%d", Integer.valueOf(i17));
                if (i17 == 117) {
                    if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                        c0.a(new Runnable() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                                JsApiInsertLivePusher.this.doInvokeAfterRequestPermission(activity, dVar, jSONObject, i3);
                            }
                        }, 50L);
                    } else {
                        w.d(JsApiInsertLivePusher.TAG, "onRequestPermissionsResult callback not grant");
                        w.d(JsApiInsertLivePusher.TAG, "doInvokeAfterRequestPermission, super.invoke");
                        JsApiInsertLivePusher.super.invoke(dVar, jSONObject, i3);
                    }
                }
                q.b(dVar.getAppId(), this);
            }
        });
        q.c(dVar.getAppId(), new ActivityCompat.OnRequestPermissionsResultCallback() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.14
            @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
            public void onRequestPermissionsResult(int i17, @NonNull String[] strArr, @NonNull int[] iArr) {
                w.d(JsApiInsertLivePusher.TAG, "onRequestPermissionsResult callback requestCode:%d", Integer.valueOf(i17));
                if (i17 == 118) {
                    if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                        c0.a(new Runnable() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                JsApiInsertLivePusher.this.doInvokeAfterRequestPermission(activity, dVar, jSONObject, i3);
                            }
                        }, 50L);
                    } else {
                        w.d(JsApiInsertLivePusher.TAG, "onRequestPermissionsResult callback not grant");
                        w.d(JsApiInsertLivePusher.TAG, "doInvokeAfterRequestPermission, super.invoke");
                        JsApiInsertLivePusher.super.invoke(dVar, jSONObject, i3);
                    }
                    q.b(dVar.getAppId(), this);
                }
            }
        });
        if (!k.a(activity, dVar, QQPermissionConstants.Permission.CAMERA, 117, "", "")) {
            w.d(TAG, "doInvokeAfterRequestPermission, !retCameraPermission");
        } else if (!k.a(activity, dVar, QQPermissionConstants.Permission.RECORD_AUDIO, 118, "", "")) {
            w.d(TAG, "doInvokeAfterRequestPermission, !retMicrophonePermission");
        } else {
            w.d(TAG, "doInvokeAfterRequestPermission, super.invoke");
            super.invoke(dVar, jSONObject, i3);
        }
    }

    private void invokeAfterRequestPermission(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (!(dVar.getContext() instanceof Activity)) {
            w.f(TAG, "invokeAfterRequestPermission pageContext not activity");
            dVar.a(i3, makeReturnJson(e.f121309e));
            q.a(dVar.getAppId());
        } else {
            this.preventiveCnt = 0;
            doInvokeAfterRequestPermission((Activity) dVar.getContext(), dVar, jSONObject, i3);
        }
    }

    private void parseFilterImage(JSONObject jSONObject, b bVar) {
        if (jSONObject.has(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE)) {
            bVar.f152110e = jSONObject.optString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, bVar.f152110e);
            bVar.f152111f = jSONObject.optString(com.tencent.luggage.wxa.ff.g.f126099a, null);
            if (w0.c(bVar.f152110e)) {
                try {
                    jSONObject.put(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, "");
                    return;
                } catch (JSONException e16) {
                    w.h(TAG, "parseFilterImage, ignore exception:%s", e16);
                    return;
                }
            }
            if (bVar.f152110e.startsWith("http://") || bVar.f152110e.startsWith("https://")) {
                jSONObject.remove(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) throws JSONException {
        return jSONObject.getInt("livePusherId");
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public View inflateView(f fVar, JSONObject jSONObject) {
        return new com.tencent.luggage.wxa.ye.b(fVar.getContext(), new b(fVar.getContext()));
    }

    @Override // com.tencent.luggage.wxa.ee.b, com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.ff.i.b();
        invokeAfterRequestPermission(dVar, jSONObject, i3);
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public void onInsertView(final f fVar, final int i3, View view, JSONObject jSONObject) {
        w.d(TAG, "onInsertView livePusherId=%d", Integer.valueOf(i3));
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h(TAG, "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i3));
            return;
        }
        TXLiveBase.setAppVersion(String.format("weixin_%s", fVar.getAppId()));
        final b bVar = (b) ((com.tencent.luggage.wxa.ye.b) view).a(b.class);
        if (bVar == null) {
            w.b(TAG, "pusherView null");
            return;
        }
        final g.d dVar = new g.d() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.1
            @Override // com.tencent.luggage.wxa.xd.g.d
            public void onForeground() {
                bVar.e();
            }
        };
        final g.b bVar2 = new g.b() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.2
            @Override // com.tencent.luggage.wxa.xd.g.b
            public void onBackground() {
                bVar.c();
            }
        };
        final e.c cVar = new e.c() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.3
            @Override // com.tencent.luggage.wxa.ic.e.c
            public void onDestroy() {
                com.tencent.luggage.wxa.ic.e.b(fVar.getAppId(), this);
            }

            @Override // com.tencent.luggage.wxa.ic.e.c
            public void onPause(e.d dVar2) {
                bVar.a(dVar2);
            }

            @Override // com.tencent.luggage.wxa.ic.e.c
            public void onResume() {
                bVar.b();
            }
        };
        g.c cVar2 = new g.c() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.4
            @Override // com.tencent.luggage.wxa.xd.g.c
            public void onDestroy() {
                bVar.d();
                fVar.b(this);
                com.tencent.luggage.wxa.ic.e.b(fVar.getAppId(), cVar);
            }
        };
        fVar.b(dVar);
        fVar.a(bVar2);
        fVar.a(cVar2);
        bVar.a(new b.f() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.5
            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.b.f
            public void onLivePusherExit() {
                fVar.a(dVar);
                fVar.b(bVar2);
            }
        });
        com.tencent.luggage.wxa.ic.e.a(fVar.getAppId(), cVar);
        bVar.a(new ITXLivePushListener() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.6
            @Override // com.tencent.rtmp.ITXLivePushListener
            public void onNetStatus(Bundle bundle) {
                OnLivePusherNetStatus onLivePusherNetStatus = new OnLivePusherNetStatus();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("livePusherId", i3);
                    JSONObject jSONObject3 = new JSONObject();
                    if (bundle != null) {
                        for (String str : bundle.keySet()) {
                            jSONObject3.put(str, bundle.get(str));
                        }
                    }
                    jSONObject2.put("info", jSONObject3);
                } catch (JSONException unused) {
                }
                fVar.a(onLivePusherNetStatus.setData(jSONObject2.toString()), (int[]) null);
            }

            @Override // com.tencent.rtmp.ITXLivePushListener
            public void onPushEvent(int i16, Bundle bundle) {
                w.d(JsApiInsertLivePusher.TAG, "onPushEvent errCode:%d", Integer.valueOf(i16));
                OnPushEvent onPushEvent = new OnPushEvent();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("errCode", i16);
                    jSONObject2.put("errMsg", bundle.getString("EVT_MSG"));
                    jSONObject2.put("livePusherId", i3);
                } catch (JSONException unused) {
                }
                fVar.a(onPushEvent.setData(jSONObject2.toString()), (int[]) null);
            }
        });
        bVar.a(new TXLivePusher.OnBGMNotify() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.7
            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public void onBGMComplete(int i16) {
                w.d(JsApiInsertLivePusher.TAG, "onBGMComplete, error:%s", Integer.valueOf(i16));
                OnLivePusherBGMComplete onLivePusherBGMComplete = new OnLivePusherBGMComplete();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("errCode", i16);
                    jSONObject2.put("livePusherId", i3);
                } catch (JSONException e16) {
                    w.b(JsApiInsertLivePusher.TAG, "onBGMComplete fail", e16);
                }
                fVar.a(onLivePusherBGMComplete.setData(jSONObject2.toString()), (int[]) null);
            }

            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public void onBGMProgress(long j3, long j16) {
                OnLivePusherBGMProgress onLivePusherBGMProgress = new OnLivePusherBGMProgress();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("progress", j3);
                    jSONObject2.put("duration", j16);
                    jSONObject2.put("livePusherId", i3);
                } catch (JSONException e16) {
                    w.b(JsApiInsertLivePusher.TAG, "onBGMProgress fail", e16);
                }
                fVar.a(onLivePusherBGMProgress.setData(jSONObject2.toString()), (int[]) null);
            }

            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public void onBGMStart() {
                w.d(JsApiInsertLivePusher.TAG, "onBGMStart");
                OnLivePusherBGMStart onLivePusherBGMStart = new OnLivePusherBGMStart();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("livePusherId", i3);
                } catch (JSONException e16) {
                    w.b(JsApiInsertLivePusher.TAG, "onBGMStart fail", e16);
                }
                fVar.a(onLivePusherBGMStart.setData(jSONObject2.toString()), (int[]) null);
            }
        });
        bVar.a(new b.e() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.8
            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.b.e
            public void onError(@NonNull com.tencent.luggage.wxa.af.c cVar3, int i16, String str, HashMap<String, Object> hashMap) {
                w.d(JsApiInsertLivePusher.TAG, "onError, error:%s", Integer.valueOf(i16));
                OnLivePusherError onLivePusherError = new OnLivePusherError();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(o.ERRNO_TAG, cVar3.f121277a);
                    jSONObject2.put("errCode", i16);
                    jSONObject2.put("errMsg", w0.d(str));
                    jSONObject2.put("livePusherId", i3);
                    if (hashMap != null && !hashMap.isEmpty()) {
                        jSONObject2.put("data", new JSONObject(hashMap));
                    }
                } catch (JSONException e16) {
                    w.b(JsApiInsertLivePusher.TAG, "onError fail", e16);
                }
                fVar.a(onLivePusherError.setData(jSONObject2.toString()), (int[]) null);
            }
        });
        bVar.a(new TXLivePusher.ITXAudioVolumeEvaluationListener() { // from class: com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher.9
            @Override // com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener
            public void onAudioVolumeEvaluationNotify(int i16) {
                w.d(JsApiInsertLivePusher.TAG, "onAudioVolumeEvaluationNotify, volume:%s", Integer.valueOf(i16));
                OnLivePusherAudioVolume onLivePusherAudioVolume = new OnLivePusherAudioVolume();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, i16);
                    jSONObject2.put("livePusherId", i3);
                } catch (JSONException e16) {
                    w.b(JsApiInsertLivePusher.TAG, "onAudioVolumeEvaluationNotify fail", e16);
                }
                fVar.a(onLivePusherAudioVolume.setData(jSONObject2.toString()), (int[]) null);
            }
        });
        parseFilterImage(jSONObject, bVar);
        bVar.a(j.b(jSONObject));
        convertBackgroundImageToLocalPath(fVar, bVar, jSONObject);
        convertFilterImageToLocalPath(fVar, bVar, jSONObject);
        convertWatermarkImageToLocalPath(fVar, bVar, jSONObject);
        bVar.setContentDescription(view.getContext().getString(R.string.ywh));
    }
}
