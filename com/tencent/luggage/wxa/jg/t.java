package com.tencent.luggage.wxa.jg;

import android.app.Activity;
import android.os.PowerManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoViewController;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setKeepScreenOn";

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f131121a;

    /* renamed from: b, reason: collision with root package name */
    public PowerManager.WakeLock f131122b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f131123c = false;

    /* renamed from: d, reason: collision with root package name */
    public e.c f131124d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f131125a;

        public a(com.tencent.luggage.wxa.xd.d dVar) {
            this.f131125a = dVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetKeepScreenOn", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            if (t.this.f()) {
                t.this.g();
            }
            com.tencent.luggage.wxa.ic.e.b(this.f131125a.getAppId(), this);
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetKeepScreenOn", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            if (t.this.f()) {
                t.this.g();
            }
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetKeepScreenOn", "onResume");
            if (t.this.f131123c) {
                t.this.e();
            }
        }
    }

    public final synchronized boolean e() {
        if (this.f131121a.getContext() == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
            return false;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
        Activity activity = (Activity) this.f131121a.getContext();
        if (this.f131122b == null) {
            this.f131122b = ((PowerManager) activity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
        }
        if (!this.f131122b.isHeld()) {
            this.f131122b.acquire();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
        } else {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
        }
        return true;
    }

    public final synchronized boolean f() {
        boolean z16;
        PowerManager.WakeLock wakeLock = this.f131122b;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    public final synchronized boolean g() {
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetKeepScreenOn", "release");
        PowerManager.WakeLock wakeLock = this.f131122b;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.f131122b.release();
            this.f131122b = null;
            return true;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetKeepScreenOn", "wakeLock is  null");
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
            dVar.a(i3, makeReturnJson("fail:data is null"));
            return;
        }
        if (dVar.getContext() == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
            dVar.a(i3, makeReturnJson("fail:context is null"));
            return;
        }
        if (!(dVar.getContext() instanceof Activity)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is not activity, don't do invoke");
            dVar.a(i3, makeReturnJson("fail:context is null"));
            return;
        }
        boolean z16 = false;
        boolean optBoolean = jSONObject.optBoolean(GameCenterVideoViewController.PropName.KEEP_SCREEN_ON, false);
        this.f131123c = optBoolean;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", Boolean.valueOf(optBoolean), dVar.getAppId());
        synchronized (this) {
            this.f131121a = dVar;
        }
        if (optBoolean) {
            if (this.f131124d == null) {
                this.f131124d = new a(dVar);
            }
            com.tencent.luggage.wxa.ic.e.a(dVar.getAppId(), this.f131124d);
            if (com.tencent.luggage.wxa.ic.e.b(dVar.getAppId()) != e.b.INIT && com.tencent.luggage.wxa.ic.e.b(dVar.getAppId()) != e.b.ON_CREATE && com.tencent.luggage.wxa.ic.e.b(dVar.getAppId()) != e.b.ON_RESUME) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetKeepScreenOn", "background status, don't acquire");
            } else {
                z16 = e();
            }
        } else if (f()) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
            z16 = g();
        } else {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
            dVar.a(i3, makeReturnJson("fail:has not set screen"));
            return;
        }
        if (z16) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        } else {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
            dVar.a(i3, makeReturnJson("fail"));
        }
    }
}
