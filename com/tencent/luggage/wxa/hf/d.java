package com.tencent.luggage.wxa.hf;

import com.huawei.hms.framework.common.ContainerUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        int a16 = a(jSONObject);
        if (a16 == -1) {
            return "invalid_map_id";
        }
        return dVar.getComponentId() + ContainerUtils.FIELD_DELIMITER + a16;
    }

    public static int a(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception unused) {
            return -1;
        }
    }
}
