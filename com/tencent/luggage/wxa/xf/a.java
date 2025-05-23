package com.tencent.luggage.wxa.xf;

import android.nfc.NfcAdapter;
import com.tencent.luggage.wxa.tn.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {
    public static final NfcAdapter a() {
        return NfcAdapter.getDefaultAdapter(z.c());
    }

    public static final List a(JSONArray jSONArray, Function1 transform) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return a(jSONArray, new ArrayList(jSONArray.length()), transform);
    }

    public static final List a(JSONArray jSONArray, List destination, Function1 transform) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = jSONArray.get(i3);
            Intrinsics.checkNotNullExpressionValue(obj, "get(index)");
            Object invoke = transform.invoke(obj);
            if (invoke instanceof JSONObject) {
                invoke = a((JSONObject) invoke, transform);
            } else if (invoke instanceof JSONArray) {
                invoke = a((JSONArray) invoke, transform);
            }
            destination.add(invoke);
        }
        return destination;
    }

    public static final Map a(JSONObject jSONObject, Function1 transform) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys()");
        while (keys.hasNext()) {
            String it = (String) keys.next();
            Object obj = jSONObject.get(it);
            Intrinsics.checkNotNullExpressionValue(obj, "get(it)");
            Object invoke = transform.invoke(obj);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (invoke instanceof JSONObject) {
                invoke = a((JSONObject) invoke, transform);
            } else if (invoke instanceof JSONArray) {
                invoke = a((JSONArray) invoke, transform);
            }
            hashMap.put(it, invoke);
        }
        return hashMap;
    }
}
