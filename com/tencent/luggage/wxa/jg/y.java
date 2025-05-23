package com.tencent.luggage.wxa.jg;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
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
public final class y extends d0 {

    /* renamed from: b, reason: collision with root package name */
    public static final b f131136b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f131137c;

    /* renamed from: a, reason: collision with root package name */
    public final Map f131138a = f131136b.a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f131139a = new a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.jg.y$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6340a extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public static final C6340a f131140a = new C6340a();

            public C6340a() {
                super(2);
            }

            public final void a(Context context, Map outRes) {
                Intrinsics.checkNotNullParameter(outRes, "outRes");
                if (context == null) {
                    return;
                }
                outRes.put("cameraAuthorized", y.f131136b.a(com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.CAMERA)));
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
            public static final b f131141a = new b();

            public b() {
                super(2);
            }

            public final void a(Context context, Map outRes) {
                Intrinsics.checkNotNullParameter(outRes, "outRes");
                if (context == null) {
                    return;
                }
                outRes.put("locationAuthorized", y.f131136b.a(com.tencent.luggage.wxa.h6.k.a(context, "android.permission.ACCESS_FINE_LOCATION")));
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
            public static final c f131142a = new c();

            public c() {
                super(2);
            }

            public final void a(Context context, Map outRes) {
                Intrinsics.checkNotNullParameter(outRes, "outRes");
                if (context == null) {
                    return;
                }
                outRes.put("microphoneAuthorized", y.f131136b.a(com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.RECORD_AUDIO)));
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
            public static final d f131143a = new d();

            public d() {
                super(2);
            }

            public final void a(Context context, Map outRes) {
                Intrinsics.checkNotNullParameter(outRes, "outRes");
                if (context == null) {
                    return;
                }
                outRes.put("notificationAuthorized", y.f131136b.a(NotificationManagerCompat.from(context).areNotificationsEnabled()));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Context) obj, (Map) obj2);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class e extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public static final e f131144a = new e();

            public e() {
                super(2);
            }

            public final void a(Context context, Map outRes) {
                Intrinsics.checkNotNullParameter(outRes, "outRes");
                outRes.put("phoneCalendarAuthorized", y.f131136b.a(true));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Context) obj, (Map) obj2);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class f extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public static final f f131145a = new f();

            public f() {
                super(2);
            }

            public final void a(Context context, Map outRes) {
                boolean z16;
                Intrinsics.checkNotNullParameter(outRes, "outRes");
                if (context == null) {
                    return;
                }
                boolean z17 = true;
                if (BluetoothAdapter.getDefaultAdapter() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && Build.VERSION.SDK_INT >= 31) {
                    if (!com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.BLUETOOTH_CONNECT) || !com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.BLUETOOTH_SCAN) || !com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE)) {
                        z17 = false;
                    }
                } else {
                    z17 = z16;
                }
                outRes.put("bluetoothAuthorized", y.f131136b.a(z17));
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
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cameraAuthorized", C6340a.f131140a), TuplesKt.to("locationAuthorized", b.f131141a), TuplesKt.to("microphoneAuthorized", c.f131142a), TuplesKt.to("notificationAuthorized", d.f131143a), TuplesKt.to("phoneCalendarAuthorized", e.f131144a), TuplesKt.to("bluetoothAuthorized", f.f131145a));
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

        public final String a(boolean z16) {
            return z16 ? "authorized" : "denied";
        }

        public final Map a() {
            return (Map) y.f131137c.getValue();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f131139a);
        f131137c = lazy;
    }

    @Override // com.tencent.luggage.wxa.jg.d0
    public Map a() {
        return this.f131138a;
    }
}
