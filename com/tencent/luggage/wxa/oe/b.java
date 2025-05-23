package com.tencent.luggage.wxa.oe;

import com.tencent.luggage.wxa.tn.w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements j {

    /* renamed from: d, reason: collision with root package name */
    public static final a f136346d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f136347e;

    /* renamed from: a, reason: collision with root package name */
    public final String f136348a;

    /* renamed from: b, reason: collision with root package name */
    public Map f136349b;

    /* renamed from: c, reason: collision with root package name */
    public int f136350c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.oe.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6546a {

            /* renamed from: a, reason: collision with root package name */
            public final o f136351a;

            public C6546a(o theResult) {
                Intrinsics.checkNotNullParameter(theResult, "theResult");
                this.f136351a = theResult;
            }

            public final String a() {
                String oVar = this.f136351a.toString();
                Intrinsics.checkNotNullExpressionValue(oVar, "theResult.toString()");
                return oVar;
            }

            public boolean equals(Object obj) {
                Class<?> cls;
                if (this == obj) {
                    return true;
                }
                if (obj != null) {
                    cls = obj.getClass();
                } else {
                    cls = null;
                }
                if (!Intrinsics.areEqual(C6546a.class, cls)) {
                    return false;
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanPrinter.Companion.ScanResult");
                if (a(this.f136351a, ((C6546a) obj).f136351a)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return a(this.f136351a);
            }

            public String toString() {
                return "{rssi: " + this.f136351a.b() + ", timestampNanos: " + this.f136351a.d() + '}';
            }

            public final boolean a(o oVar, o oVar2) {
                return k.b(oVar.a(), oVar2.a()) && a(oVar.c(), oVar2.c());
            }

            public final int a(o oVar) {
                return k.a(oVar.a(), Integer.valueOf(a(oVar.c())));
            }

            public final boolean a(n nVar, n nVar2) {
                return (nVar == null && nVar2 == null) || !(nVar == null || nVar2 == null || !Arrays.equals(nVar.a(), nVar2.a()));
            }

            public final int a(n nVar) {
                return Arrays.hashCode(nVar != null ? nVar.a() : null);
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(JSONObject eventData) {
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            if (!b.f136347e) {
                return;
            }
            w.a("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent " + eventData);
        }
    }

    static {
        boolean z16 = true;
        if (w.d() > 1) {
            z16 = false;
        }
        f136347e = z16;
    }

    public b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.f136348a = tag;
    }

    public static final void a(JSONObject jSONObject) {
        f136346d.a(jSONObject);
    }

    public final Map b() {
        Map map = this.f136349b;
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        this.f136349b = hashMap;
        return hashMap;
    }

    @Override // com.tencent.luggage.wxa.oe.j
    public void a(int i3, o resultCompat) {
        Intrinsics.checkNotNullParameter(resultCompat, "resultCompat");
        if (f136347e) {
            w.a(this.f136348a, "callbackType:" + i3 + ", result:" + resultCompat);
            return;
        }
        Map b16 = b();
        a.C6546a c6546a = new a.C6546a(resultCompat);
        Integer num = (Integer) b16.get(c6546a);
        if (num == null) {
            int i16 = this.f136350c;
            this.f136350c = i16 + 1;
            Integer valueOf = Integer.valueOf(i16);
            b16.put(c6546a, valueOf);
            w.d(this.f136348a, "onScanResult, id: " + valueOf + ", result: " + c6546a.a());
            return;
        }
        w.d(this.f136348a, "onScanResult, id: " + num + ", result: " + c6546a);
    }
}
