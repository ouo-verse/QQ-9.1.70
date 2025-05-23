package com.tencent.luggage.wxa.l8;

import com.tencent.luggage.wxa.ol.f1;
import com.tencent.luggage.wxa.ol.g1;
import com.tencent.luggage.wxa.t9.l;
import com.tencent.luggage.wxa.tn.w;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {
    public static final String a(a aVar, com.tencent.luggage.wxa.xd.f fVar, com.tencent.luggage.wxa.vl.i iVar) {
        String a16;
        if (aVar != null && fVar != null && iVar != null) {
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
                            String a18 = aVar.a(fVar, str);
                            l.a(true);
                            if (aVar.getSecureInputWidgetLogic$luggage_xweb_ext_release().a(a18, a17, l.a(true))) {
                                if (list.isEmpty()) {
                                    com.tencent.luggage.wxa.br.b secureInputWidgetLogic$luggage_xweb_ext_release = aVar.getSecureInputWidgetLogic$luggage_xweb_ext_release();
                                    secureInputWidgetLogic$luggage_xweb_ext_release.setSalt(str2);
                                    secureInputWidgetLogic$luggage_xweb_ext_release.setTimeStamp(longValue);
                                    secureInputWidgetLogic$luggage_xweb_ext_release.setNonce(longValue2);
                                    a16 = secureInputWidgetLogic$luggage_xweb_ext_release.getEncryptedData();
                                } else {
                                    a16 = g1.f136743a.a(aVar.getSecureInputWidgetLogic$luggage_xweb_ext_release(), list, longValue, longValue2);
                                }
                                w.a("MicroMsg.DelegateEditText", "getEncryptedData, encryptedData: " + a16);
                                if (a16 != null) {
                                    return a16;
                                }
                                throw new IllegalStateException("sdk error:" + aVar.getSecureInputWidgetLogic$luggage_xweb_ext_release().getLastError());
                            }
                            w.b("MicroMsg.DelegateEditText", "getEncryptedData, setCertContext fail");
                            throw new IllegalStateException("sdk error:" + aVar.getSecureInputWidgetLogic$luggage_xweb_ext_release().getLastError());
                        }
                        w.b("MicroMsg.DelegateEditText", "getEncryptedData, rootPath is null");
                        throw new IllegalStateException("env error");
                    }
                    throw new IllegalStateException("need nonce");
                }
                throw new IllegalStateException("need timeStamp");
            }
            throw new IllegalStateException("need certPath");
        }
        w.b("MicroMsg.DelegateEditText", "getEncryptedData, this: " + aVar + ", env: " + fVar + ", inputParams: " + iVar);
        throw new IllegalStateException("env error");
    }
}
