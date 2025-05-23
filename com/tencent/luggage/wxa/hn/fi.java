package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class fi extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public gi f127650d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f127651e = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            gi giVar = this.f127650d;
            if (giVar != null) {
                aVar.c(1, giVar.a());
                this.f127650d.a(aVar);
            }
            aVar.a(2, 8, this.f127651e);
            return 0;
        }
        if (i3 == 1) {
            gi giVar2 = this.f127650d;
            if (giVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, giVar2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f127651e);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127651e.clear();
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
        fi fiVar = (fi) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr2 = (byte[]) h16.get(i17);
                gi giVar3 = new gi();
                if (bArr2 != null && bArr2.length > 0) {
                    giVar3.a(bArr2);
                }
                fiVar.f127651e.add(giVar3);
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr3 = (byte[]) h17.get(i18);
            gi giVar4 = new gi();
            if (bArr3 != null && bArr3.length > 0) {
                giVar4.a(bArr3);
            }
            fiVar.f127650d = giVar4;
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "wxa_item", this.f127650d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "plugin_item_list", this.f127651e, false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
