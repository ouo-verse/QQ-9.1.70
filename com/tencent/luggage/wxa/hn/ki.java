package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ki extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128043d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f128044e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public int f128045f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128043d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.a(2, 8, this.f128044e);
            aVar.b(3, this.f128045f);
            return 0;
        }
        if (i3 == 1) {
            String str2 = this.f128043d;
            if (str2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f128044e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128045f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128044e.clear();
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
        ki kiVar = (ki) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                kiVar.f128045f = aVar3.f(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr2 = (byte[]) h16.get(i17);
                ii iiVar = new ii();
                if (bArr2 != null && bArr2.length > 0) {
                    iiVar.a(bArr2);
                }
                kiVar.f128044e.add(iiVar);
            }
            return 0;
        }
        kiVar.f128043d = aVar3.i(intValue);
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "username", this.f128043d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "scope_item_list", this.f128044e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "update_time", Integer.valueOf(this.f128045f), false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
