package com.tencent.luggage.wxa.ol;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c0 {
    public static final String a(b0 b0Var, com.tencent.luggage.wxa.kj.v vVar, com.tencent.luggage.wxa.vl.i iVar) {
        String a16;
        if (b0Var != null && vVar != null && iVar != null) {
            String str = iVar.H;
            if (str != null) {
                Long l3 = iVar.K;
                if (l3 != null) {
                    long longValue = l3.longValue();
                    Long l16 = iVar.L;
                    if (l16 != null) {
                        long longValue2 = l16.longValue();
                        String str2 = iVar.J;
                        List list = iVar.M;
                        Intrinsics.checkNotNullExpressionValue(list, "inputParams.safePasswordCompatList");
                        if (str2 == null && list.isEmpty()) {
                            throw new IllegalStateException("need salt or customHash");
                        }
                        String a17 = f1.a();
                        if (a17 != null) {
                            String a18 = b0Var.a(vVar, str);
                            com.tencent.luggage.wxa.t9.l.a(true);
                            if (b0Var.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release().a(a18, a17, com.tencent.luggage.wxa.t9.l.a(true))) {
                                if (list.isEmpty()) {
                                    com.tencent.luggage.wxa.br.b secureInputWidgetLogic$luggage_wxa_app_input_ext_release = b0Var.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release();
                                    secureInputWidgetLogic$luggage_wxa_app_input_ext_release.setSalt(str2);
                                    secureInputWidgetLogic$luggage_wxa_app_input_ext_release.setTimeStamp(longValue);
                                    secureInputWidgetLogic$luggage_wxa_app_input_ext_release.setNonce(longValue2);
                                    a16 = secureInputWidgetLogic$luggage_wxa_app_input_ext_release.getEncryptedData();
                                } else {
                                    a16 = g1.f136743a.a(b0Var.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release(), list, longValue, longValue2);
                                }
                                com.tencent.luggage.wxa.tn.w.a(b0Var.getMyTag$luggage_wxa_app_input_ext_release(), "getEncryptedData, encryptedData: " + a16);
                                if (a16 != null) {
                                    return a16;
                                }
                                throw new IllegalStateException("sdk error:" + b0Var.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release().getLastError());
                            }
                            com.tencent.luggage.wxa.tn.w.b(b0Var.getMyTag$luggage_wxa_app_input_ext_release(), "getEncryptedData, setCertContext fail");
                            throw new IllegalStateException("sdk error:" + b0Var.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release().getLastError());
                        }
                        com.tencent.luggage.wxa.tn.w.b(b0Var.getMyTag$luggage_wxa_app_input_ext_release(), "getEncryptedData, rootPath is null");
                        throw new IllegalStateException("env error");
                    }
                    throw new IllegalStateException("need nonce");
                }
                throw new IllegalStateException("need timeStamp");
            }
            throw new IllegalStateException("need certPath");
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.AppBrandSecureInputWidget", "getEncryptedData, this: " + b0Var + ", env: " + vVar + ", inputParams: " + iVar);
        throw new IllegalStateException("env error");
    }
}
