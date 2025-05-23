package com.huawei.hms.framework.network.grs.g.j;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.g.k.d;
import com.huawei.hms.framework.network.grs.h.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37028a = "a";

    /* renamed from: b, reason: collision with root package name */
    private static d f37029b;

    public static synchronized d a(Context context) {
        synchronized (a.class) {
            d dVar = f37029b;
            if (dVar != null) {
                return dVar;
            }
            String a16 = c.a(GrsApp.getInstance().getBrand("/") + "grs_sdk_server_config.json", context);
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(a16)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(a16).getJSONObject("grs_server");
                JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                if (jSONArray != null && jSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        arrayList.add(jSONArray.get(i3).toString());
                    }
                }
                d dVar2 = new d();
                f37029b = dVar2;
                dVar2.a(arrayList);
                f37029b.b(jSONObject.getString("grs_query_endpoint_1.0"));
                f37029b.a(jSONObject.getString("grs_query_endpoint_2.0"));
                f37029b.a(jSONObject.getInt("grs_query_timeout"));
            } catch (JSONException e16) {
                Logger.w(f37028a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e16.getMessage()));
            }
            return f37029b;
        }
    }
}
