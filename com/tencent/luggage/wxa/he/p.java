package com.tencent.luggage.wxa.he;

import android.os.Build;
import android.os.ParcelUuid;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.luggage.wxa.he.m;
import com.tencent.luggage.wxa.he.p;
import com.tencent.luggage.wxa.je.a;
import com.tencent.luggage.wxa.oe.m;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.e0;
import com.tencent.luggage.wxa.uk.i0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 176;
    private static final String NAME = "startBluetoothDevicesDiscovery";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ne.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127085a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f127086b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f127085a = dVar;
            this.f127086b = i3;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public void a(com.tencent.luggage.wxa.ne.k kVar) {
            w.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", kVar);
            if (kVar.f135767a != 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(kVar.f135767a));
                hashMap.put("isDiscovering", Boolean.FALSE);
                this.f127085a.a(this.f127086b, p.this.makeReturnJson(kVar.f135768b, kVar.f135769c, hashMap));
                com.tencent.luggage.wxa.ge.f.a(13);
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 0);
            hashMap2.put("isDiscovering", Boolean.TRUE);
            this.f127085a.a(this.f127086b, p.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(12);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.ne.j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127088a;

        public b(com.tencent.luggage.wxa.xd.d dVar) {
            this.f127088a = dVar;
        }

        @Override // com.tencent.luggage.wxa.ne.j
        public void a(com.tencent.luggage.wxa.ne.d dVar) {
            d.a(this.f127088a, dVar);
        }

        @Override // com.tencent.luggage.wxa.ne.j
        public void a(List list) {
            d.a(this.f127088a, list);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f127090a;

        static {
            int[] iArr = new int[i0.values().length];
            f127090a = iArr;
            try {
                iArr[i0.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f127090a[i0.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f127090a[i0.REQUEST_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, com.tencent.luggage.wxa.ge.b bVar, i0 i0Var) {
        w.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "onRequestPermissionResult, result: %s", i0Var);
        int i16 = c.f127090a[i0Var.ordinal()];
        if (i16 == 1) {
            a(dVar, jSONObject, i3, bVar);
        } else if (i16 == 2) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121308d));
        } else {
            if (i16 != 3) {
                return;
            }
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(final com.tencent.luggage.wxa.xd.d dVar, final JSONObject jSONObject, final int i3) {
        com.tencent.luggage.wxa.ge.f.a(11);
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k, hashMap));
            com.tencent.luggage.wxa.ge.f.a(13, 14);
            return;
        }
        w.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "appId:%s startBluetoothDevicesDiscovery data:%s", dVar.getAppId(), jSONObject);
        final com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(dVar.getAppId());
        if (b16 == null) {
            w.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(13, 16);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap3));
            com.tencent.luggage.wxa.ge.f.a(13, 18);
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            com.tencent.luggage.wxa.uk.f.a(dVar, QQPermissionConstants.Permission.BLUETOOTH_SCAN, 144, "", "", new e0() { // from class: p21.b
                @Override // com.tencent.luggage.wxa.uk.e0
                public final void a(i0 i0Var) {
                    p.this.a(dVar, jSONObject, i3, b16, i0Var);
                }
            });
        } else {
            a(dVar, jSONObject, i3, b16);
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, com.tencent.luggage.wxa.ge.b bVar) {
        ArrayList arrayList;
        boolean optBoolean = jSONObject.optBoolean("allowDuplicatesKey");
        int optInt = jSONObject.optInt(WidgetCacheConstellationData.INTERVAL);
        String optString = jSONObject.optString("powerLevel", "medium");
        boolean optBoolean2 = jSONObject.optBoolean("refreshCache", com.tencent.luggage.wxa.je.a.b());
        boolean optBoolean3 = jSONObject.optBoolean("scanWorkaround", true);
        if (jSONObject.has("services")) {
            arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("services"));
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    arrayList.add(new m.b().a(ParcelUuid.fromString(jSONArray.getString(i16).toUpperCase())).a());
                }
            } catch (Exception unused) {
                w.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
                HashMap hashMap = new HashMap();
                hashMap.put("isDiscovering", Boolean.FALSE);
                hashMap.put("errCode", 10004);
                dVar.a(i3, makeReturnJson("fail:no service", com.tencent.luggage.wxa.af.e.f121315k, hashMap));
                com.tencent.luggage.wxa.ge.f.a(13);
                return;
            }
        } else {
            arrayList = null;
        }
        bVar.a(new a.C6334a().a(optInt).a(optBoolean).a(optString).b(optBoolean2).c(optBoolean3).a());
        bVar.a(new a(dVar, i3), arrayList, new b(dVar));
        m.i.a(dVar, true, true);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d extends k0 {
        private static final int CTRL_INDEX = 190;
        private static final String NAME = "onBluetoothDeviceFound";

        public static void a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.ne.d dVar2) {
            if (dVar == null) {
                w.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.mo162put(dVar2.a());
            } catch (JSONException e16) {
                w.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e16);
            }
            d dVar3 = new d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.remove("devices");
                jSONObject.put("devices", jSONArray);
            } catch (JSONException e17) {
                w.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e17);
            }
            dVar3.setContext(dVar, dVar.getComponentId()).setData(jSONObject.toString()).dispatch();
            com.tencent.luggage.wxa.oe.b.a(jSONObject);
        }

        public static void a(com.tencent.luggage.wxa.xd.d dVar, List list) {
            if (dVar == null) {
                w.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.mo162put(((com.tencent.luggage.wxa.ne.d) it.next()).a());
                } catch (JSONException e16) {
                    w.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e16);
                }
            }
            d dVar2 = new d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.remove("devices");
                jSONObject.put("devices", jSONArray);
            } catch (JSONException e17) {
                w.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e17);
            }
            dVar2.setContext(dVar, dVar.getComponentId()).setData(jSONObject.toString()).dispatch();
            w.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", jSONObject.toString());
        }
    }
}
