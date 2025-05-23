package com.qq.e.comm.plugin.k;

import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ae {
    public static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object opt = jSONArray.opt(i3);
                if (opt instanceof String) {
                    arrayList.add((String) opt);
                } else {
                    GDTLogger.e("parseStringList error ! type wrong !");
                }
            }
        }
        return arrayList;
    }

    public static List<Integer> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object opt = jSONArray.opt(i3);
                if (opt instanceof Integer) {
                    arrayList.add((Integer) opt);
                } else {
                    GDTLogger.e("parseIntegerList error ! type wrong !");
                }
            }
        }
        return arrayList;
    }
}
