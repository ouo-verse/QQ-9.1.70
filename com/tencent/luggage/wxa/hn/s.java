package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128643d;

    /* renamed from: e, reason: collision with root package name */
    public String f128644e;

    /* renamed from: f, reason: collision with root package name */
    public int f128645f;

    /* renamed from: g, reason: collision with root package name */
    public mb f128646g;

    /* renamed from: h, reason: collision with root package name */
    public String f128647h;

    /* renamed from: i, reason: collision with root package name */
    public p9 f128648i;

    /* renamed from: j, reason: collision with root package name */
    public String f128649j;

    /* renamed from: k, reason: collision with root package name */
    public String f128650k;

    /* renamed from: l, reason: collision with root package name */
    public String f128651l;

    /* renamed from: m, reason: collision with root package name */
    public String f128652m;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128643d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128644e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.b(3, this.f128645f);
            mb mbVar = this.f128646g;
            if (mbVar != null) {
                aVar.c(4, mbVar.a());
                this.f128646g.a(aVar);
            }
            String str3 = this.f128647h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            p9 p9Var = this.f128648i;
            if (p9Var != null) {
                aVar.c(6, p9Var.a());
                this.f128648i.a(aVar);
            }
            String str4 = this.f128649j;
            if (str4 != null) {
                aVar.a(7, str4);
            }
            String str5 = this.f128650k;
            if (str5 != null) {
                aVar.a(8, str5);
            }
            String str6 = this.f128651l;
            if (str6 != null) {
                aVar.a(9, str6);
            }
            String str7 = this.f128652m;
            if (str7 != null) {
                aVar.a(10, str7);
            }
            return 0;
        }
        if (i3 == 1) {
            String str8 = this.f128643d;
            if (str8 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str8);
            }
            String str9 = this.f128644e;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str9);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128645f);
            mb mbVar2 = this.f128646g;
            if (mbVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(4, mbVar2.a());
            }
            String str10 = this.f128647h;
            if (str10 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str10);
            }
            p9 p9Var2 = this.f128648i;
            if (p9Var2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(6, p9Var2.a());
            }
            String str11 = this.f128649j;
            if (str11 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(7, str11);
            }
            String str12 = this.f128650k;
            if (str12 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(8, str12);
            }
            String str13 = this.f128651l;
            if (str13 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(9, str13);
            }
            String str14 = this.f128652m;
            if (str14 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(10, str14);
            }
            return b16;
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
        s sVar = (s) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                sVar.f128643d = aVar3.i(intValue);
                return 0;
            case 2:
                sVar.f128644e = aVar3.i(intValue);
                return 0;
            case 3:
                sVar.f128645f = aVar3.f(intValue);
                return 0;
            case 4:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    mb mbVar3 = new mb();
                    if (bArr != null && bArr.length > 0) {
                        mbVar3.a(bArr);
                    }
                    sVar.f128646g = mbVar3;
                }
                return 0;
            case 5:
                sVar.f128647h = aVar3.i(intValue);
                return 0;
            case 6:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    p9 p9Var3 = new p9();
                    if (bArr2 != null && bArr2.length > 0) {
                        p9Var3.a(bArr2);
                    }
                    sVar.f128648i = p9Var3;
                }
                return 0;
            case 7:
                sVar.f128649j = aVar3.i(intValue);
                return 0;
            case 8:
                sVar.f128650k = aVar3.i(intValue);
                return 0;
            case 9:
                sVar.f128651l = aVar3.i(intValue);
                return 0;
            case 10:
                sVar.f128652m = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "scope", this.f128643d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "scopeDesc", this.f128644e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "state", Integer.valueOf(this.f128645f), false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "userAvatarInfo", this.f128646g, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "scope_sub_desc", this.f128647h, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "risk_popup_info", this.f128648i, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "auth_wording", this.f128649j, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "bottom_desc", this.f128650k, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "scope_sec_desc", this.f128651l, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "item_title", this.f128652m, false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
