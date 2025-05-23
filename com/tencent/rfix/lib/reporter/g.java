package com.tencent.rfix.lib.reporter;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.lib.RFix;
import com.tencent.rfix.lib.RFixParams;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g {
    static IPatchRedirector $redirector_;

    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "0e600064423");
        hashMap.put("token", "3528535772");
        RFixParams params = RFix.getInstance().getParams();
        hashMap.put("device_id", params.getDeviceId());
        hashMap.put("user_id", params.getUserId());
        hashMap.put("app_id", params.getAppId());
        hashMap.put("app_bundle_id", context.getPackageName());
        return hashMap;
    }

    public static boolean b(Context context, RFixLoadResult rFixLoadResult, String str) {
        int i3;
        boolean z16 = true;
        if (!rFixLoadResult.isSuccess() || (i3 = rFixLoadResult.safeModeSubResult) == 0) {
            if (rFixLoadResult.result == RFixConstants.LoadResult.LOAD_RESULT_SAFE_MODE_CHECK) {
                i3 = rFixLoadResult.subResult;
            } else {
                i3 = 0;
                z16 = false;
            }
        }
        if (!z16) {
            return false;
        }
        return c(context, str, String.valueOf(i3));
    }

    private static boolean c(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        Map<String, String> a16 = a(context);
        a16.put("config_id", str);
        a16.put("safemode_error_code", str2);
        return com.tencent.rfix.lib.atta.e.c(context).h(a16);
    }
}
