package com.tencent.luggage.wxa.fe;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static JSONArray a(int i3) {
        if (i3 <= 0) {
            return new JSONArray();
        }
        ArrayList arrayList = new ArrayList(3);
        if ((i3 & 1) == 1) {
            arrayList.add("fingerPrint");
        }
        if ((i3 & 8) == 8) {
            arrayList.add("facial");
        }
        if ((i3 & 2) == 2) {
            arrayList.add("speech");
        }
        w.d("MicroMsg.AppBrandSoterTranslateUtil", "hy: final string is: %s", arrayList.toString());
        return new JSONArray((Collection) arrayList);
    }

    public static String a(JSONArray jSONArray) {
        Object[] objArr = new Object[1];
        objArr[0] = jSONArray == null ? null : jSONArray.toString();
        w.d("MicroMsg.AppBrandSoterTranslateUtil", "hy: translating string array: %s", objArr);
        if (jSONArray == null || jSONArray.length() == 0) {
            return "0x00";
        }
        byte b16 = 0;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                b16 = (byte) (b16 | a(jSONArray.getString(i3)));
            } catch (JSONException e16) {
                w.a("MicroMsg.AppBrandSoterTranslateUtil", e16, "hy: json error in translate", new Object[0]);
            }
        }
        String str = RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(b16);
        w.d("MicroMsg.AppBrandSoterTranslateUtil", "hy: translated bitsetStr: %s", str);
        return str;
    }

    public static int a(String str) {
        if ("fingerPrint".equals(str)) {
            return 1;
        }
        if ("facial".equals(str)) {
            return 8;
        }
        if ("speech".equals(str)) {
            return 2;
        }
        w.b("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
        return 0;
    }
}
