package com.tencent.luggage.wxa.fd;

import java.util.LinkedList;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class q0 {
    public static LinkedList a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            linkedList.add(jSONArray.optString(i3));
        }
        return linkedList;
    }
}
