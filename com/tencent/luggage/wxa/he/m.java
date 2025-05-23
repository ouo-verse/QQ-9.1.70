package com.tencent.luggage.wxa.he;

import android.os.Build;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.ge.b;
import com.tencent.luggage.wxa.he.m;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.e0;
import com.tencent.luggage.wxa.uk.i0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 173;
    public static final String NAME = "openBluetoothAdapter";

    /* renamed from: a, reason: collision with root package name */
    public boolean f127067a = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127068a;

        public a(com.tencent.luggage.wxa.xd.d dVar) {
            this.f127068a = dVar;
        }

        @Override // com.tencent.luggage.wxa.ge.b.c
        public void a(boolean z16) {
            i.a(this.f127068a, z16, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.ne.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127070a;

        public b(com.tencent.luggage.wxa.xd.d dVar) {
            this.f127070a = dVar;
        }

        @Override // com.tencent.luggage.wxa.ne.i
        public void a(String str, boolean z16) {
            g.a(this.f127070a, str, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.ne.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127072a;

        public c(com.tencent.luggage.wxa.xd.d dVar) {
            this.f127072a = dVar;
        }

        @Override // com.tencent.luggage.wxa.ne.h
        public void a(String str, String str2, String str3, String str4) {
            f.a(this.f127072a, str, str2, str3, str4);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.ne.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127074a;

        public d(com.tencent.luggage.wxa.xd.d dVar) {
            this.f127074a = dVar;
        }

        @Override // com.tencent.luggage.wxa.ne.g
        public void a(String str, int i3) {
            new h(null).a(this.f127074a, str, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f127076a;

        static {
            int[] iArr = new int[i0.values().length];
            f127076a = iArr;
            try {
                iArr[i0.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f127076a[i0.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f127076a[i0.REQUEST_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f extends k0 {
        private static final int CTRL_INDEX = 187;
        private static final String NAME = "onBLECharacteristicValueChange";

        public static void a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, String str3, String str4) {
            if (dVar == null) {
                w.b("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent dispatch fail, service is null");
                return;
            }
            f fVar = new f();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.remove("value");
                jSONObject.put("value", str4);
                jSONObject.remove(Constants.SP_DEVICE_ID);
                jSONObject.put(Constants.SP_DEVICE_ID, str);
                jSONObject.remove("serviceId");
                jSONObject.put("serviceId", str2);
                jSONObject.remove("characteristicId");
                jSONObject.put("characteristicId", str3);
            } catch (JSONException e16) {
                w.b("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e16);
            }
            fVar.setContext(dVar, dVar.getComponentId()).setData(jSONObject.toString()).dispatch();
            w.d("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent %s", jSONObject.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class g extends k0 {
        private static final int CTRL_INDEX = 188;
        private static final String NAME = "onBLEConnectionStateChanged";

        public static synchronized void a(com.tencent.luggage.wxa.xd.d dVar, String str, boolean z16) {
            synchronized (g.class) {
                if (dVar == null) {
                    w.b("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent dispatch fail, service is null");
                    return;
                }
                g gVar = new g();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.remove(Constants.SP_DEVICE_ID);
                    jSONObject.put(Constants.SP_DEVICE_ID, str);
                    jSONObject.remove("connected");
                    jSONObject.put("connected", z16);
                } catch (JSONException e16) {
                    w.b("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e16);
                }
                gVar.setContext(dVar, dVar.getComponentId()).setData(jSONObject.toString()).dispatch();
                w.d("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent %s", jSONObject.toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class h extends k0 {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onBLEMTUChange";

        public h() {
        }

        public void a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3) {
            if (dVar == null) {
                w.f("MicroMsg.JsApiOpenBluetoothAdapter", "dispatch#OnBLEMTUChangeEvent, service is null");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.SP_DEVICE_ID, str);
                jSONObject.put("mtu", i3);
            } catch (JSONException e16) {
                w.f("MicroMsg.JsApiOpenBluetoothAdapter", "dispatch#OnBLEMTUChangeEvent, put params fail since " + e16);
            }
            String jSONObject2 = jSONObject.toString();
            setContext(dVar, dVar.getComponentId()).setData(jSONObject2).dispatch();
            w.d("MicroMsg.JsApiOpenBluetoothAdapter", "dispatch#OnBLEMTUChangeEvent, paramsStr: " + jSONObject2);
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class i extends k0 {
        private static final int CTRL_INDEX = 189;
        private static final String NAME = "onBluetoothAdapterStateChange";

        public static void a(com.tencent.luggage.wxa.xd.d dVar, boolean z16, boolean z17) {
            if (dVar == null) {
                w.b("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                return;
            }
            i iVar = new i();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.remove("available");
                jSONObject.put("available", z16);
                jSONObject.remove("discovering");
                jSONObject.put("discovering", z17);
            } catch (JSONException e16) {
                w.b("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", e16);
            }
            iVar.setContext(dVar, dVar.getComponentId()).setData(jSONObject.toString()).dispatch();
            w.d("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChange %s", jSONObject.toString());
        }
    }

    public com.tencent.luggage.wxa.ne.k a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.ne.k kVar) {
        return kVar;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(final com.tencent.luggage.wxa.xd.d dVar, final JSONObject jSONObject, final int i3) {
        i0 i0Var;
        com.tencent.luggage.wxa.ge.f.a(0);
        String appId = dVar.getAppId();
        w.d("MicroMsg.JsApiOpenBluetoothAdapter", "appid:%s openBluetoothAdapter!", appId);
        if (Build.VERSION.SDK_INT >= 31) {
            if (!this.f127067a) {
                com.tencent.luggage.wxa.uk.f.a(dVar, QQPermissionConstants.Permission.BLUETOOTH_CONNECT, 144, "", "", new e0() { // from class: p21.a
                    @Override // com.tencent.luggage.wxa.uk.e0
                    public final void a(i0 i0Var2) {
                        m.this.a(dVar, jSONObject, i3, i0Var2);
                    }
                });
                return;
            }
            if (com.tencent.luggage.wxa.h6.k.a(dVar.getContext(), dVar, QQPermissionConstants.Permission.BLUETOOTH_CONNECT)) {
                i0Var = i0.GRANTED;
            } else {
                i0Var = i0.DENIED;
            }
            a(i0Var, dVar, jSONObject, i3);
            return;
        }
        a(dVar, jSONObject, i3, appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, i0 i0Var) {
        w.d("MicroMsg.JsApiOpenBluetoothAdapter", "onRequestPermissionResult, result: %s", i0Var);
        this.f127067a = true;
        a(i0Var, dVar, jSONObject, i3);
    }

    public final void a(i0 i0Var, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        int i16 = e.f127076a[i0Var.ordinal()];
        if (i16 == 1) {
            a(dVar, jSONObject, i3, dVar.getAppId());
        } else if (i16 == 2) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121308d));
        } else {
            if (i16 != 3) {
                return;
            }
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, String str) {
        com.tencent.luggage.wxa.ne.k a16 = a(dVar, com.tencent.luggage.wxa.ge.a.a(str, new a(dVar), new b(dVar), new c(dVar), new d(dVar)));
        HashMap hashMap = new HashMap();
        int i16 = a16.f135767a;
        if (i16 == 0) {
            a(jSONObject);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap));
            com.tencent.luggage.wxa.ge.f.a(1);
        } else if (i16 == 10001) {
            hashMap.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap));
            com.tencent.luggage.wxa.ge.f.a(2, 7);
        } else if (i16 != 10009) {
            hashMap.put("errCode", Integer.valueOf(i16));
            dVar.a(i3, makeReturnJson(a16.f135768b, a16.f135769c, hashMap));
            com.tencent.luggage.wxa.ge.f.a(2);
        } else {
            hashMap.put("errCode", 10009);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121233e, hashMap));
            com.tencent.luggage.wxa.ge.f.a(2, 8);
        }
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        w.d("MicroMsg.JsApiOpenBluetoothAdapter", "doSomeGlobalConfigAfterOpenBluetoothAdapter, data: " + jSONObject);
        if (jSONObject.has("refreshCache")) {
            try {
                com.tencent.luggage.wxa.je.a.a(jSONObject.getBoolean("refreshCache"));
            } catch (JSONException unused) {
            }
        }
    }
}
