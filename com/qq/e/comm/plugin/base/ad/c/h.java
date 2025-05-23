package com.qq.e.comm.plugin.base.ad.c;

import com.qq.e.comm.plugin.k.w;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mtt.tbs.smartaccelerator.TbsSmartAcceleratorManager;
import com.tencent.mtt.tbs.smartaccelerator.X5UACallback;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h extends a {
    private void a(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            return;
        }
        final String e16 = y.e(jSONObject, "mqq_landing_page");
        try {
            TbsSmartAcceleratorManager.getTbsWebViewProvider().getX5UA(new X5UACallback() { // from class: com.qq.e.comm.plugin.base.ad.c.h.1
            });
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage(), th5);
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.c.a
    protected void b(JSONArray jSONArray, String str) {
        if (y.a(jSONArray)) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            a(w.c(jSONArray, i3));
        }
    }
}
