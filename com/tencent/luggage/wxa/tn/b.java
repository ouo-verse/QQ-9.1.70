package com.tencent.luggage.wxa.tn;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static int a(String str) {
        if (w0.c(str)) {
            w.a("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
            return 0;
        }
        if (!com.tencent.luggage.wxa.cp.x.d(str)) {
            w.a("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
            return 0;
        }
        return com.tencent.luggage.wxa.aa.d.a(str).a();
    }
}
