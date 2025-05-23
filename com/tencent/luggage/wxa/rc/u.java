package com.tencent.luggage.wxa.rc;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class u {
    public static final void a(int i3, int i16, int i17, int i18, long j3, com.tencent.luggage.wxa.fd.q qVar) {
        if (qVar == null) {
            com.tencent.luggage.wxa.tn.w.d("KVStoragePerformanceReport", "sysConfig is null");
            return;
        }
        if (!qVar.C) {
            com.tencent.luggage.wxa.tn.w.d("KVStoragePerformanceReport", "performance report off");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("KVStoragePerformanceReport", "report scheme=" + i3 + "  action=" + i16 + "  dataSize=" + i17 + "  count=" + i18 + "  cost=" + j3);
        ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(16336, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j3));
    }
}
