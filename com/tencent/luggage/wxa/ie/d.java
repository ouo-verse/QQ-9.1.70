package com.tencent.luggage.wxa.ie;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f130100a = new a(null);

    @NotNull
    private static final String NAME = "closeBLEPeripheralServer";
    private static final int CTRL_INDEX = QVipServiceAccountFolderProcessor.CMD;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        if (jSONObject != null && jSONObject.has("serverId")) {
            int optInt = jSONObject.optInt("serverId");
            if (o.f130152a.a(optInt)) {
                com.tencent.luggage.wxa.pe.b.a(this, i3, env, (HashMap) null, 4, (Object) null);
                return;
            }
            w.d("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "invoke: fail: #" + optInt + " server is not exists");
            com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10020, "fail: no server", null, 16, null);
            return;
        }
        w.b("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "createBLEPeripheralServer data is invalid");
        com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10013, "fail:invalid data", null, 16, null);
    }
}
