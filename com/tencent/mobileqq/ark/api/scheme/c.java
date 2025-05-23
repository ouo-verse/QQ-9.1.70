package com.tencent.mobileqq.ark.api.scheme;

import com.tencent.mobileqq.ark.module.i;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements i {
    @Override // com.tencent.mobileqq.ark.module.i
    public boolean a(String str, String str2, JSONObject jSONObject) {
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
            com.tencent.mobileqq.ark.api.module.a.k(str);
            return true;
        }
        return false;
    }
}
