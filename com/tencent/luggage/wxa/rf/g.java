package com.tencent.luggage.wxa.rf;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.rf.c;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.rf.c {
    public static final int CTRL_INDEX = 352;
    public static final String NAME = "startHCE";

    /* renamed from: b, reason: collision with root package name */
    public final Class f139638b;

    /* renamed from: e, reason: collision with root package name */
    public ResultReceiver f139641e;

    /* renamed from: h, reason: collision with root package name */
    public JSONObject f139644h;

    /* renamed from: i, reason: collision with root package name */
    public int f139645i;

    /* renamed from: k, reason: collision with root package name */
    public Future f139647k;

    /* renamed from: c, reason: collision with root package name */
    public Activity f139639c = null;

    /* renamed from: d, reason: collision with root package name */
    public Application.ActivityLifecycleCallbacks f139640d = null;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f139642f = null;

    /* renamed from: g, reason: collision with root package name */
    public int f139643g = -1;

    /* renamed from: j, reason: collision with root package name */
    public long f139646j = -1;

    /* renamed from: l, reason: collision with root package name */
    public final Object f139648l = new Object();

    /* renamed from: m, reason: collision with root package name */
    public boolean f139649m = false;
    public ResultReceiver C = new f(b0.a(Looper.getMainLooper()));

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.rf.c.a
        public void a(int i3, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i3));
            if (i3 == 0) {
                g.this.h();
                return;
            }
            com.tencent.luggage.wxa.tf.c.a(g.this.f139642f.getAppId(), i3);
            g gVar = g.this;
            gVar.b(j.a(gVar, i3, "fail: " + str, hashMap));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends ResultReceiver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i3, Bundle bundle) {
            w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI ResultReceiver resultCode: %d", Integer.valueOf(i3));
            if (bundle != null && i3 == 10001) {
                g.this.b(bundle.getInt("errCode", -1), bundle.getString("errMsg"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends e.c {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
            com.tencent.luggage.wxa.rf.b.a(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends ResultReceiver {
        public f(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i3, Bundle bundle) {
            w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver resultCode: %d", Integer.valueOf(i3));
            if (bundle != null && i3 == 10002) {
                int i16 = bundle.getInt("key_event_type", -1);
                String string = bundle.getString("key_appid");
                int i17 = bundle.getInt("errCode", -1);
                String string2 = bundle.getString("errMsg");
                w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver onReceiveResult eventType: %d, appId: %s", Integer.valueOf(i16), string);
                if (i16 == 12) {
                    g.this.a(string, i17, string2);
                } else if (i16 == 31 || i16 == 41) {
                    com.tencent.luggage.wxa.rf.a.a(g.this.f139642f, i16, bundle);
                }
            }
        }
    }

    public g(Class cls) {
        if (cls == null) {
            this.f139638b = HCEService.class;
        } else {
            this.f139638b = cls;
        }
    }

    public final void e() {
        boolean z16;
        synchronized (this.f139648l) {
            z16 = this.f139649m;
            if (!z16) {
                this.f139649m = true;
            }
        }
        if (z16) {
            w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
            return;
        }
        if (com.tencent.luggage.wxa.rf.b.b()) {
            w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
            return;
        }
        w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", 10);
        g();
        com.tencent.luggage.wxa.xd.d dVar = this.f139642f;
        if (dVar != null) {
            com.tencent.luggage.wxa.tf.c.a(dVar.getAppId(), TVKEventId.PLAYER_STATE_AUDIO_EFFECT_TYPE_INFO, -2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(TVKEventId.PLAYER_STATE_AUDIO_EFFECT_TYPE_INFO));
        b(j.a(this, TVKEventId.PLAYER_STATE_AUDIO_EFFECT_TYPE_INFO, "fail: start HCEService failed", hashMap));
    }

    public final void f() {
        HashMap hashMap = new HashMap();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = this.f139644h.getJSONArray("aid_list");
            int length = jSONArray.length();
            w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", this.f139644h.toString(), jSONArray.toString(), Integer.valueOf(length));
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(jSONArray.get(i3).toString());
            }
            com.tencent.luggage.wxa.ic.e.a(this.f139642f.getAppId(), new d());
            Intent intent = new Intent(this.f139639c, (Class<?>) this.f139638b);
            intent.putExtra("HCE_Result_Receiver", this.C);
            intent.putExtra("key_appid", this.f139642f.getAppId());
            intent.putExtra("key_time_limit", this.f139645i);
            intent.putStringArrayListExtra("key_aid_list", arrayList);
            com.tencent.luggage.wxa.rf.b.a(false);
            this.f139639c.startService(intent);
            this.f139646j = System.currentTimeMillis();
            this.f139647k = com.tencent.luggage.wxa.zp.h.f146825d.a(new e(), 10000L);
        } catch (Exception unused) {
            hashMap.put("errCode", Integer.valueOf(TVKEventId.PLAYER_STATE_VIDEO_SIZE_CHANGE));
            b(j.a(this, TVKEventId.PLAYER_STATE_VIDEO_SIZE_CHANGE, "fail: aid_list invalid", hashMap));
            com.tencent.luggage.wxa.tf.c.a(this.f139642f.getAppId(), TVKEventId.PLAYER_STATE_VIDEO_SIZE_CHANGE);
        }
    }

    public final void g() {
        com.tencent.luggage.wxa.rf.b.a(true);
    }

    public final void h() {
        if (!(this.f139642f.getContext() instanceof Activity)) {
            b(makeReturnJson("fail: unknown error"));
            return;
        }
        this.f139639c = (Activity) this.f139642f.getContext();
        this.f139640d = new b();
        this.f139639c.getApplication().registerActivityLifecycleCallbacks(this.f139640d);
        c cVar = new c(b0.a(Looper.getMainLooper()));
        this.f139641e = cVar;
        com.tencent.luggage.wxa.sf.a.f140322l.a(this.f139639c, cVar);
        com.tencent.luggage.wxa.sf.a.f140322l.h();
        com.tencent.luggage.wxa.sf.a.f140322l.b(new ComponentName(this.f139639c, HCEService.class.getCanonicalName()));
        com.tencent.luggage.wxa.sf.a.f140322l.a();
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", jSONObject.toString());
        this.f139642f = dVar;
        this.f139643g = i3;
        this.f139644h = jSONObject;
        synchronized (this.f139648l) {
            this.f139649m = false;
        }
        this.f139645i = this.f139644h.optInt("time_limit", 1500);
        a(new a());
    }

    public final void b(String str) {
        w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", str);
        com.tencent.luggage.wxa.xd.d dVar = this.f139642f;
        if (dVar != null) {
            dVar.a(this.f139643g, str);
        }
        if (this.f139639c == null || this.f139640d == null) {
            return;
        }
        w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
        this.f139639c.getApplication().unregisterActivityLifecycleCallbacks(this.f139640d);
    }

    public final void a(String str, int i3, String str2) {
        boolean z16;
        synchronized (this.f139648l) {
            z16 = this.f139649m;
            if (!z16) {
                this.f139649m = true;
            }
        }
        if (z16) {
            w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
            return;
        }
        if (com.tencent.luggage.wxa.rf.b.b()) {
            w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
            return;
        }
        HashMap hashMap = new HashMap();
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.f139646j);
        if (this.f139647k != null) {
            w.a("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
            this.f139647k.cancel(false);
            this.f139647k = null;
        }
        if (str != null && !str.equals(this.f139642f.getAppId())) {
            w.b("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", str);
            hashMap.put("errCode", 13010);
            com.tencent.luggage.wxa.tf.c.a(this.f139642f.getAppId(), 13010, currentTimeMillis);
            b(j.a(this, 13010, "fail: unknown error", hashMap));
            return;
        }
        w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", Integer.valueOf(i3), str2);
        if (i3 == 0) {
            com.tencent.luggage.wxa.rf.b.a(this.f139642f.getAppId());
            hashMap.put("errCode", Integer.valueOf(i3));
            b(j.a(this, i3, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
        } else {
            hashMap.put("errCode", Integer.valueOf(i3));
            b(j.a(this, i3, "fail: " + str2, hashMap));
        }
        com.tencent.luggage.wxa.tf.c.a(this.f139642f.getAppId(), i3, currentTimeMillis);
        g();
    }

    public final void b(int i3, String str) {
        w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI onResult errCode: %d, errMsg: %s", Integer.valueOf(i3), str);
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i3));
        if (i3 == 0) {
            f();
            return;
        }
        com.tencent.luggage.wxa.tf.c.a(this.f139642f.getAppId(), i3);
        b(j.a(this, i3, "fail: " + str, hashMap));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public boolean f139651a = false;

        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onActivityPaused");
            com.tencent.luggage.wxa.sf.a.f140322l.c();
            this.f139651a = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onActivityResumed");
            if (this.f139651a) {
                w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo onActivityResumed isPaused and do checLogic");
                this.f139651a = false;
                com.tencent.luggage.wxa.sf.a.f140322l.a();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
