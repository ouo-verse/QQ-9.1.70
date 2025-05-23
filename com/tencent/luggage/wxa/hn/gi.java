package com.tencent.luggage.wxa.hn;

import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class gi extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127725d;

    /* renamed from: e, reason: collision with root package name */
    public String f127726e;

    /* renamed from: f, reason: collision with root package name */
    public String f127727f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f127728g = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127725d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f127726e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f127727f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            aVar.a(4, 8, this.f127728g);
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f127725d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            String str5 = this.f127726e;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            String str6 = this.f127727f;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(4, 8, this.f127728g);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127728g.clear();
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
        gi giVar = (gi) objArr[1];
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
                        n9 n9Var = new n9();
                        if (bArr2 != null && bArr2.length > 0) {
                            n9Var.a(bArr2);
                        }
                        giVar.f127728g.add(n9Var);
                    }
                    return 0;
                }
                giVar.f127727f = aVar3.i(intValue);
                return 0;
            }
            giVar.f127726e = aVar3.i(intValue);
            return 0;
        }
        giVar.f127725d = aVar3.i(intValue);
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "appid", this.f127725d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, this.f127726e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "icon_url", this.f127727f, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "scope_item_list", this.f127728g, false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
