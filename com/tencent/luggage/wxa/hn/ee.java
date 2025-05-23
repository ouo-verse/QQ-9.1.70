package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ee extends t8 {

    /* renamed from: f, reason: collision with root package name */
    public int f127572f;

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f127571e = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f127573g = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            h0 h0Var = this.f128743d;
            if (h0Var != null) {
                aVar.c(1, h0Var.a());
                this.f128743d.a(aVar);
            }
            aVar.a(2, 8, this.f127571e);
            aVar.b(3, this.f127572f);
            aVar.a(4, 1, this.f127573g);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f127571e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127572f) + com.tencent.luggage.wxa.gr.a.a(4, 1, this.f127573g);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127571e.clear();
            this.f127573g.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a16 = com.tencent.luggage.wxa.fn.b.a(aVar2); a16 > 0; a16 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a16)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        ee eeVar = (ee) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    eeVar.f127573g.add(aVar3.i(intValue));
                    return 0;
                }
                eeVar.f127572f = aVar3.f(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr2 = (byte[]) h16.get(i17);
                ki kiVar = new ki();
                if (bArr2 != null && bArr2.length > 0) {
                    kiVar.a(bArr2);
                }
                eeVar.f127571e.add(kiVar);
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr3 = (byte[]) h17.get(i18);
            h0 h0Var3 = new h0();
            if (bArr3 != null && bArr3.length > 0) {
                h0Var3.a(bArr3);
            }
            eeVar.f128743d = h0Var3;
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "BaseResponse", this.f128743d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "wxa_item_list", this.f127571e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "status", Integer.valueOf(this.f127572f), false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "all_shown_scope_list", this.f127573g, false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
