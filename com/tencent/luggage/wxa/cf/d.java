package com.tencent.luggage.wxa.cf;

import android.os.Build;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.cf.a;
import com.tencent.luggage.wxa.cf.d;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.e0;
import com.tencent.luggage.wxa.uk.f;
import com.tencent.luggage.wxa.uk.i0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qqnt.kernel.nativeinterface.DigestErrCode;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 221;
    private static final String NAME = "startBeaconDiscovery";

    /* renamed from: a, reason: collision with root package name */
    public e.c f123487a = null;

    /* renamed from: b, reason: collision with root package name */
    public a.b.InterfaceC6109b f123488b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f123493a;

        public b(com.tencent.luggage.wxa.xd.d dVar) {
            this.f123493a = dVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.d("MicroMsg.JsApiStartBeaconDiscovery", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            com.tencent.luggage.wxa.ic.e.b(this.f123493a.getAppId(), this);
            a.b a16 = com.tencent.luggage.wxa.cf.a.a(this.f123493a.getAppId());
            if (a16 != null) {
                a16.e();
                com.tencent.luggage.wxa.cf.a.b(this.f123493a.getAppId());
            }
            d.this.f123487a = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f123495a;

        static {
            int[] iArr = new int[i0.values().length];
            f123495a = iArr;
            try {
                iArr[i0.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f123495a[i0.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f123495a[i0.REQUEST_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.cf.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6110d extends k0 {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        public C6110d() {
        }

        public /* synthetic */ C6110d(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e extends k0 {
        private static final int CTRL_INDEX = 224;
        private static final String NAME = "onBeaconUpdated";

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(final com.tencent.luggage.wxa.xd.d dVar, final JSONObject jSONObject, final int i3) {
        w.d("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", jSONObject);
        if (Build.VERSION.SDK_INT >= 31) {
            f.a(dVar, QQPermissionConstants.Permission.BLUETOOTH_SCAN, 144, "", "", new e0() { // from class: h21.a
                @Override // com.tencent.luggage.wxa.uk.e0
                public final void a(i0 i0Var) {
                    d.this.a(dVar, jSONObject, i3, i0Var);
                }
            });
        } else {
            a(dVar, jSONObject, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, i0 i0Var) {
        w.d("MicroMsg.JsApiStartBeaconDiscovery", "onRequestPermissionResult, result: %s", i0Var);
        int i16 = c.f123495a[i0Var.ordinal()];
        if (i16 == 1) {
            a(dVar, jSONObject, i3);
        } else if (i16 == 2) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121308d));
        } else {
            if (i16 != 3) {
                return;
            }
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        UUID[] a16 = a(jSONObject);
        if (a16 != null && a16.length > 0) {
            String appId = dVar.getAppId();
            a.b a17 = com.tencent.luggage.wxa.cf.a.a(dVar.getAppId());
            if (a17 == null) {
                w.d("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
                a17 = new a.b();
                com.tencent.luggage.wxa.cf.a.a(appId, a17);
            }
            if (this.f123488b == null) {
                w.d("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
                this.f123488b = new a(dVar);
            }
            if (this.f123487a == null) {
                w.d("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
                this.f123487a = new b(dVar);
                com.tencent.luggage.wxa.ic.e.a(dVar.getAppId(), this.f123487a);
            }
            a17.a(a16);
            a17.a(this.f123488b);
            com.tencent.luggage.wxa.ap.b d16 = a17.d();
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", d16.b());
            dVar.a(i3, makeReturnJson(((Integer) d16.b()).intValue() == 0 ? FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS : (String) d16.c(), hashMap));
            return;
        }
        w.b("MicroMsg.JsApiStartBeaconDiscovery", "serviceUuids is empty");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errCode", Integer.valueOf(DigestErrCode.MSG_EXPIRED));
        dVar.a(i3, makeReturnJson("fail:invalid data", hashMap2));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.b.InterfaceC6109b {

        /* renamed from: a, reason: collision with root package name */
        public e f123489a;

        /* renamed from: b, reason: collision with root package name */
        public C6110d f123490b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f123491c;

        public a(com.tencent.luggage.wxa.xd.d dVar) {
            this.f123491c = dVar;
            a aVar = null;
            this.f123489a = new e(aVar);
            this.f123490b = new C6110d(aVar);
        }

        @Override // com.tencent.luggage.wxa.cf.a.b.InterfaceC6109b
        public void a(Map map) {
            w.a("MicroMsg.JsApiStartBeaconDiscovery", "found device ibeacon %s", map);
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject : map.values()) {
                if (jSONObject != null) {
                    jSONArray.mo162put(jSONObject);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("beacons", jSONArray);
            } catch (JSONException e16) {
                w.b("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", e16);
            }
            e eVar = this.f123489a;
            com.tencent.luggage.wxa.xd.d dVar = this.f123491c;
            eVar.setContext(dVar, dVar.getComponentId()).setData(jSONObject2.toString()).dispatch();
        }

        @Override // com.tencent.luggage.wxa.cf.a.b.InterfaceC6109b
        public void a(boolean z16) {
            w.d("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", Boolean.valueOf(z16));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("available", z16);
                jSONObject.put("discovering", false);
            } catch (JSONException e16) {
                w.b("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", e16);
            }
            w.a("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject.toString());
            C6110d c6110d = this.f123490b;
            com.tencent.luggage.wxa.xd.d dVar = this.f123491c;
            c6110d.setContext(dVar, dVar.getComponentId()).setData(jSONObject.toString()).dispatch();
        }
    }

    public final UUID[] a(JSONObject jSONObject) {
        UUID[] uuidArr = null;
        if (jSONObject.has("uuids")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("uuids"));
                uuidArr = new UUID[jSONArray.length()];
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    String string = jSONArray.getString(i3);
                    w.a("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", string);
                    uuidArr[i3] = UUID.fromString(string);
                }
            } catch (JSONException unused) {
                w.b("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
            }
        }
        return uuidArr;
    }
}
