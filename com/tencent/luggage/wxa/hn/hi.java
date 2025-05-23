package com.tencent.luggage.wxa.hn;

import com.qzone.album.data.model.AlbumCacheData;
import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class hi extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public ji f127819d;

    /* renamed from: e, reason: collision with root package name */
    public ii f127820e;

    /* renamed from: f, reason: collision with root package name */
    public int f127821f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            ji jiVar = this.f127819d;
            if (jiVar != null) {
                aVar.c(1, jiVar.a());
                this.f127819d.a(aVar);
            }
            ii iiVar = this.f127820e;
            if (iiVar != null) {
                aVar.c(2, iiVar.a());
                this.f127820e.a(aVar);
            }
            aVar.b(3, this.f127821f);
            return 0;
        }
        if (i3 == 1) {
            ji jiVar2 = this.f127819d;
            if (jiVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, jiVar2.a());
            }
            ii iiVar2 = this.f127820e;
            if (iiVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, iiVar2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f127821f);
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
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
        hi hiVar = (hi) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                hiVar.f127821f = aVar3.f(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr = (byte[]) h16.get(i17);
                ii iiVar3 = new ii();
                if (bArr != null && bArr.length > 0) {
                    iiVar3.a(bArr);
                }
                hiVar.f127820e = iiVar3;
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr2 = (byte[]) h17.get(i18);
            ji jiVar3 = new ji();
            if (bArr2 != null && bArr2.length > 0) {
                jiVar3.a(bArr2);
            }
            hiVar.f127819d = jiVar3;
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "plugin_info", this.f127819d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "scope_item", this.f127820e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, AlbumCacheData.CREATE_TIME, Integer.valueOf(this.f127821f), false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
