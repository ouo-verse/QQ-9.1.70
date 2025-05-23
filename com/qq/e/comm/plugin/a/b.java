package com.qq.e.comm.plugin.a;

import com.qq.e.comm.plugin.base.ad.model.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends d {
    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9) {
        super(str, str2, str3, str4, str5, str6, str7, str8, i3, str9);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, jSONObject.toString());
        }
    }
}
