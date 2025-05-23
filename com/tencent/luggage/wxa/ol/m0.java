package com.tencent.luggage.wxa.ol;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f136873a = new m0();

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f136874b = false;

    static {
        n0.f136895a.a();
    }

    public static final void b(JSONObject data, com.tencent.luggage.wxa.vl.i params) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(params, "params");
        if (f136874b) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.EncryptInputLogic", "prepareSameLayerInvokeParams, data: " + data);
        }
        JSONObject optJSONObject = data.optJSONObject("encrypt");
        if (optJSONObject == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.EncryptInputLogic", "prepareSameLayerInvokeParams, encryptJsonObj is null");
            return;
        }
        if (optJSONObject.has("cert-path") && !optJSONObject.isNull("cert-path")) {
            params.N = optJSONObject.optString("cert-path");
        }
        if (optJSONObject.has("extra") && !optJSONObject.isNull("extra")) {
            params.O = optJSONObject.optString("extra");
        }
    }

    public final boolean a() {
        return f136874b;
    }

    public static final void a(JSONObject data, com.tencent.luggage.wxa.vl.i params) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(params, "params");
        if (f136874b) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.EncryptInputLogic", "prepareInvokeParams, data: " + data);
        }
        JSONObject optJSONObject = data.optJSONObject("encrypt");
        if (optJSONObject == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.EncryptInputLogic", "prepareInvokeParams, encryptJsonObj is null");
            return;
        }
        if (optJSONObject.has("certPath") && !optJSONObject.isNull("certPath")) {
            params.N = optJSONObject.optString("certPath");
        }
        if (!optJSONObject.has("extra") || optJSONObject.isNull("extra")) {
            return;
        }
        params.O = optJSONObject.optString("extra");
    }

    public static final void a(com.tencent.luggage.wxa.vl.i iVar, com.tencent.luggage.wxa.vl.i newParams) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(newParams, "newParams");
        String str = newParams.N;
        if (str != null) {
            iVar.N = str;
        }
        String str2 = newParams.O;
        if (str2 != null) {
            iVar.O = str2;
        }
    }

    public static final String a(s0 s0Var, com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.vl.i iVar) {
        String a16;
        if (s0Var == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.EncryptInputLogic", "encrypt, encryptException is null");
            throw new l0("env error");
        }
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.EncryptInputLogic", "encrypt, env is null");
            throw new l0("env error");
        }
        if (iVar != null) {
            String str = iVar.N;
            if (str != null) {
                String a17 = s0Var.a(dVar, str);
                if (r.a(s0Var.getInputType())) {
                    String a18 = s0Var.a();
                    a16 = a18 != null ? StringsKt__StringsJVMKt.replace$default(a18, " ", "", false, 4, (Object) null) : null;
                } else {
                    a16 = s0Var.a();
                }
                String str2 = iVar.O;
                if (str2 == null) {
                    str2 = "";
                }
                boolean z16 = f136874b;
                if (z16) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.EncryptInputLogic", "encrypt, certPem: " + a17);
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.EncryptInputLogic", "encrypt, inputValue: " + a16 + ", extra: " + str2);
                }
                if (a16 == null || a16.length() == 0) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.EncryptInputLogic", "encrypt, inputValue is empty, not need");
                    return null;
                }
                String a19 = com.tencent.luggage.wxa.cr.c.a().a(a17, a16, str2);
                if (z16) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.EncryptInputLogic", "encrypt, encryptedValue: " + a19);
                }
                if (!(a19 == null || a19.length() == 0)) {
                    return a19;
                }
                throw new l0("sdk error:" + com.tencent.luggage.wxa.cr.c.a().b());
            }
            throw new l0("need certPath");
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.EncryptInputLogic", "encrypt, params is null");
        throw new l0("env error");
    }
}
