package com.tencent.luggage.wxa.ie;

import android.os.Build;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.e0;
import com.tencent.luggage.wxa.uk.i0;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f130101a = new a(null);

    @NotNull
    private static final String NAME = "createBLEPeripheralServer";
    private static final int CTRL_INDEX = 721;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130102a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130103b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f130104c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f130105d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f130106a;

            static {
                int[] iArr = new int[i0.values().length];
                iArr[i0.REQUEST_FAIL.ordinal()] = 1;
                iArr[i0.GRANTED.ordinal()] = 2;
                iArr[i0.DENIED.ordinal()] = 3;
                f130106a = iArr;
            }
        }

        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, e eVar, Function0 function0) {
            this.f130102a = dVar;
            this.f130103b = i3;
            this.f130104c = eVar;
            this.f130105d = function0;
        }

        @Override // com.tencent.luggage.wxa.uk.e0
        public final void a(i0 res) {
            Intrinsics.checkNotNullParameter(res, "res");
            int i3 = a.f130106a[res.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.f130102a.a(this.f130103b, this.f130104c.makeReturnJson(com.tencent.luggage.wxa.af.e.f121308d));
                        return;
                    }
                    return;
                }
                this.f130105d.invoke();
                return;
            }
            this.f130102a.a(this.f130103b, this.f130104c.makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130108b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130109c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i3, com.tencent.luggage.wxa.xd.d dVar) {
            super(0);
            this.f130108b = i3;
            this.f130109c = dVar;
        }

        public final void a() {
            HashMap hashMap = new HashMap();
            o oVar = o.f130152a;
            if (oVar.c()) {
                w.d("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: out of bound");
                com.tencent.luggage.wxa.pe.b.a(e.this, this.f130108b, this.f130109c, 10008, "fail: servers count overflow", null, 16, null);
                return;
            }
            int a16 = oVar.a(this.f130109c);
            n b16 = oVar.b(a16);
            if (b16 != null && b16.e() == p.CREATED) {
                w.d("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: serverId = " + a16);
                hashMap.put("serverId", Integer.valueOf(a16));
                com.tencent.luggage.wxa.pe.b.a(e.this, this.f130108b, this.f130109c, hashMap);
                return;
            }
            com.tencent.luggage.wxa.pe.b.a(e.this, this.f130108b, this.f130109c, 10001, "fail:not available", null, 16, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        if (!com.tencent.luggage.wxa.pe.c.a()) {
            com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10001, "fail:not available", null, 16, null);
            w.d("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: Ble is not available");
            return;
        }
        c cVar = new c(i3, env);
        if (Build.VERSION.SDK_INT < 31) {
            cVar.invoke();
            return;
        }
        String[] strArr = {QQPermissionConstants.Permission.BLUETOOTH_CONNECT, QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE};
        boolean z16 = true;
        for (int i16 = 0; i16 < 2; i16++) {
            if (ContextCompat.checkSelfPermission(z.c(), strArr[i16]) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (!z16) {
            com.tencent.luggage.wxa.uk.f.a(env, strArr, 144, (r13 & 4) != 0 ? "" : null, (r13 & 8) != 0 ? "" : null, new b(env, i3, this, cVar));
        } else {
            cVar.invoke();
        }
    }
}
