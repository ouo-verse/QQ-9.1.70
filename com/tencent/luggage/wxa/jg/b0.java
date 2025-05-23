package com.tencent.luggage.wxa.jg;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b0 extends d0 {

    /* renamed from: b, reason: collision with root package name */
    public static final b f131061b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f131062c;

    /* renamed from: a, reason: collision with root package name */
    public final Map f131063a = f131061b.a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f131064a = new a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.jg.b0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6337a extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public static final C6337a f131065a = new C6337a();

            public C6337a() {
                super(2);
            }

            public final void a(Context context, Map outRes) {
                boolean z16;
                Intrinsics.checkNotNullParameter(outRes, "outRes");
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    z16 = defaultAdapter.isEnabled();
                } else {
                    z16 = false;
                }
                outRes.put("bluetoothEnabled", Boolean.valueOf(z16));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Context) obj, (Map) obj2);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public static final b f131066a = new b();

            public b() {
                super(2);
            }

            public final void a(Context context, Map outRes) {
                String str;
                Intrinsics.checkNotNullParameter(outRes, "outRes");
                if (context == null) {
                    context = com.tencent.luggage.wxa.tn.z.c();
                }
                if (2 == context.getResources().getConfiguration().orientation) {
                    str = "landscape";
                } else {
                    str = "portrait";
                }
                outRes.put("deviceOrientation", str);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Context) obj, (Map) obj2);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public static final c f131067a = new c();

            public c() {
                super(2);
            }

            public final void a(Context context, Map outRes) {
                Intrinsics.checkNotNullParameter(outRes, "outRes");
                outRes.put("locationEnabled", Boolean.valueOf(com.tencent.luggage.wxa.tn.v.a()));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Context) obj, (Map) obj2);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public static final d f131068a = new d();

            public d() {
                super(2);
            }

            public final void a(Context context, Map outRes) {
                Object obj;
                boolean z16;
                Intrinsics.checkNotNullParameter(outRes, "outRes");
                WifiManager wifiManager = null;
                if (context != null) {
                    obj = context.getSystemService("wifi");
                } else {
                    obj = null;
                }
                if (obj instanceof WifiManager) {
                    wifiManager = (WifiManager) obj;
                }
                if (wifiManager != null) {
                    z16 = wifiManager.isWifiEnabled();
                } else {
                    z16 = false;
                }
                outRes.put("wifiEnabled", Boolean.valueOf(z16));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Context) obj, (Map) obj2);
                return Unit.INSTANCE;
            }
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            Map mapOf;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("bluetoothEnabled", C6337a.f131065a), TuplesKt.to("deviceOrientation", b.f131066a), TuplesKt.to("locationEnabled", c.f131067a), TuplesKt.to("wifiEnabled", d.f131068a));
            return mapOf;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map a() {
            return (Map) b0.f131062c.getValue();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f131064a);
        f131062c = lazy;
    }

    @Override // com.tencent.luggage.wxa.jg.d0
    public Map a() {
        return this.f131063a;
    }
}
