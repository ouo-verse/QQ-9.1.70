package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class me extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public ob f128207e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128208f = new LinkedList();

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
            ob obVar = this.f128207e;
            if (obVar != null) {
                aVar.c(2, obVar.a());
                this.f128207e.a(aVar);
            }
            aVar.a(3, 8, this.f128208f);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            ob obVar2 = this.f128207e;
            if (obVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, obVar2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f128208f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128208f.clear();
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
        me meVar = (me) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    s sVar = new s();
                    if (bArr2 != null && bArr2.length > 0) {
                        sVar.a(bArr2);
                    }
                    meVar.f128208f.add(sVar);
                }
                return 0;
            }
            LinkedList h17 = aVar3.h(intValue);
            int size2 = h17.size();
            for (int i18 = 0; i18 < size2; i18++) {
                byte[] bArr3 = (byte[]) h17.get(i18);
                ob obVar3 = new ob();
                if (bArr3 != null && bArr3.length > 0) {
                    obVar3.a(bArr3);
                }
                meVar.f128207e = obVar3;
            }
            return 0;
        }
        LinkedList h18 = aVar3.h(intValue);
        int size3 = h18.size();
        for (int i19 = 0; i19 < size3; i19++) {
            byte[] bArr4 = (byte[]) h18.get(i19);
            h0 h0Var3 = new h0();
            if (bArr4 != null && bArr4.length > 0) {
                h0Var3.a(bArr4);
            }
            meVar.f128743d = h0Var3;
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "BaseResponse", this.f128743d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "userMgrBaseResp", this.f128207e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "authItem", this.f128208f, false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
