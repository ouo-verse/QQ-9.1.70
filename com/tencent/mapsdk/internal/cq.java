package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes9.dex */
public final class cq extends ck {

    /* renamed from: f, reason: collision with root package name */
    static final String f148059f = "name";

    /* renamed from: g, reason: collision with root package name */
    static final String f148060g = "host";

    /* renamed from: h, reason: collision with root package name */
    static final String f148061h = "host_test";

    /* renamed from: i, reason: collision with root package name */
    static final String f148062i = "https";

    /* renamed from: j, reason: collision with root package name */
    static final String f148063j = "status";

    private void b(JSONObject jSONObject) {
        cs csVar = (cs) JsonUtils.parseToModel(jSONObject, cs.class, new Object[0]);
        cu cuVar = this.f148048b;
        cuVar.f148074a = csVar.f148072a;
        cuVar.f148075b = csVar.f148073b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject) {
        dp dpVar;
        boolean z16;
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("name", null);
        if (!TextUtils.isEmpty(optString) && (dpVar = (dp) b(optString)) != null) {
            boolean z17 = true;
            int optInt = jSONObject.optInt("status", 1);
            String optString2 = jSONObject.optString("host", null);
            String optString3 = jSONObject.optString(f148061h, null);
            boolean optBoolean = jSONObject.optBoolean("https", true);
            if (optInt != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            dpVar.f148119c = z16;
            dpVar.f148118b = optBoolean;
            if (!TextUtils.isEmpty(optString2)) {
                dpVar.f148138d = optString2;
            }
            if (!TextUtils.isEmpty(optString3)) {
                dpVar.f148139e = optString3;
            }
            if (optInt != 2) {
                z17 = false;
            }
            dpVar.f148117a = z17;
        }
    }
}
