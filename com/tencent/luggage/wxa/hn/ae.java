package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ae extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public ob f127299e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f127300f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public fi f127301g;

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
            ob obVar = this.f127299e;
            if (obVar != null) {
                aVar.c(2, obVar.a());
                this.f127299e.a(aVar);
            }
            aVar.a(3, 8, this.f127300f);
            fi fiVar = this.f127301g;
            if (fiVar != null) {
                aVar.c(4, fiVar.a());
                this.f127301g.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            ob obVar2 = this.f127299e;
            if (obVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, obVar2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f127300f);
            fi fiVar2 = this.f127301g;
            if (fiVar2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.c(4, fiVar2.a());
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127300f.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a17 = com.tencent.luggage.wxa.fn.b.a(aVar2); a17 > 0; a17 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a17)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        ae aeVar = (ae) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    LinkedList h16 = aVar3.h(intValue);
                    int size = h16.size();
                    for (int i17 = 0; i17 < size; i17++) {
                        byte[] bArr2 = (byte[]) h16.get(i17);
                        fi fiVar3 = new fi();
                        if (bArr2 != null && bArr2.length > 0) {
                            fiVar3.a(bArr2);
                        }
                        aeVar.f127301g = fiVar3;
                    }
                    return 0;
                }
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    s sVar = new s();
                    if (bArr3 != null && bArr3.length > 0) {
                        sVar.a(bArr3);
                    }
                    aeVar.f127300f.add(sVar);
                }
                return 0;
            }
            LinkedList h18 = aVar3.h(intValue);
            int size3 = h18.size();
            for (int i19 = 0; i19 < size3; i19++) {
                byte[] bArr4 = (byte[]) h18.get(i19);
                ob obVar3 = new ob();
                if (bArr4 != null && bArr4.length > 0) {
                    obVar3.a(bArr4);
                }
                aeVar.f127299e = obVar3;
            }
            return 0;
        }
        LinkedList h19 = aVar3.h(intValue);
        int size4 = h19.size();
        for (int i26 = 0; i26 < size4; i26++) {
            byte[] bArr5 = (byte[]) h19.get(i26);
            h0 h0Var3 = new h0();
            if (bArr5 != null && bArr5.length > 0) {
                h0Var3.a(bArr5);
            }
            aeVar.f128743d = h0Var3;
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "BaseResponse", this.f128743d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "userMgrBaseResp", this.f127299e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "authItem", this.f127300f, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "use_user_info", this.f127301g, false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
