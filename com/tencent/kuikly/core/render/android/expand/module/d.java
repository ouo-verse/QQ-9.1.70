package com.tencent.kuikly.core.render.android.expand.module;

import com.tencent.kuikly.core.render.android.expand.module.t;
import d01.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002\u001a\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\u00020\u0003H\u0002\u00a8\u0006\u0006"}, d2 = {"Lorg/json/JSONObject;", "Lcom/tencent/kuikly/core/render/android/expand/module/t;", "b", "", "", "c", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class d {
    private static final t b(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("field");
        int optInt2 = jSONObject.optInt("value");
        Object opt = jSONObject.opt("opt");
        if (Intrinsics.areEqual(opt, "set")) {
            return new t.b(optInt, optInt2);
        }
        if (Intrinsics.areEqual(opt, "add")) {
            return new t.a(optInt, optInt2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<t> c(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException unused) {
            jSONArray = new JSONArray();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            try {
                String optString = jSONArray.optString(i3);
                if (optString == null) {
                    optString = "{}";
                }
                t b16 = b(new JSONObject(optString));
                if (b16 != null) {
                    arrayList.add(b16);
                }
            } catch (JSONException unused2) {
                w.f392617a.b("toOperations", "parse json error");
            }
        }
        return arrayList;
    }
}
