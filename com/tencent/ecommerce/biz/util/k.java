package com.tencent.ecommerce.biz.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0013\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/util/k;", "Lcom/tencent/ecommerce/biz/util/l;", "Lorg/json/JSONArray;", "labels", tl.h.F, "Lorg/json/JSONObject;", "richTextJsonObj", "<init>", "(Lorg/json/JSONObject;)V", "c", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class k extends l {
    public /* synthetic */ k(JSONObject jSONObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : jSONObject);
    }

    public final l h(JSONArray labels) {
        int length = labels.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = labels.optJSONObject(i3);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            String f16 = oi0.a.f(optJSONObject);
            String c16 = oi0.a.c(optJSONObject);
            int g16 = oi0.a.g(optJSONObject);
            int b16 = oi0.a.b(optJSONObject);
            if (f16.length() > 0) {
                b(f16, g16, b16);
            } else if (c16.length() > 0) {
                b(c16, g16, b16);
            } else {
                c(oi0.a.a(optJSONObject), oi0.a.e(optJSONObject), oi0.a.d(optJSONObject));
            }
        }
        return this;
    }

    public k(JSONObject jSONObject) {
        super(jSONObject);
    }
}
