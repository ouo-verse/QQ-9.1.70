package com.tencent.luggage.wxa.zj;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mars.smc.IDKey;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f146727a = new a();

    @Override // com.tencent.luggage.wxa.zj.b
    public /* synthetic */ void a(long j3, long j16) {
        h.a(this, j3, j16);
    }

    @Override // com.tencent.luggage.wxa.zj.b
    public void a(long j3, long j16, long j17) {
        w.a("Luggage.IDKeyReporter", "idkeyStat ID:" + j3 + " key:" + j16 + ", val:" + j17);
    }

    @Override // com.tencent.luggage.wxa.zj.b
    public void a(long j3, long j16, long j17, boolean z16) {
        w.a("Luggage.IDKeyReporter", "idkeyStat ID:" + j3 + " key:" + j16 + " val:" + j17 + " important:" + z16);
    }

    @Override // com.tencent.luggage.wxa.zj.b
    public void a(ArrayList arrayList, boolean z16) {
        if (arrayList == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            StringBuilder sb6 = new StringBuilder();
            sb6.append('(');
            sb6.append(iDKey.GetId());
            sb6.append(',');
            sb6.append(iDKey.GetKey());
            sb6.append(',');
            sb6.append(iDKey.GetValue());
            sb6.append(')');
            sb5.append(sb6.toString());
            sb5.append(",");
        }
        w.a("Luggage.IDKeyReporter", "idkeyGroupStat " + ((Object) sb5) + " important:" + z16);
    }
}
