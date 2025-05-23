package com.tencent.qqmini.sdk.core.utils;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class f {
    public static Boolean a(String str, String str2, boolean z16) {
        JSONObject qQMCConfig = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getQQMCConfig(str);
        if (qQMCConfig == null) {
            return Boolean.valueOf(z16);
        }
        return Boolean.valueOf(qQMCConfig.optBoolean(str2, z16));
    }

    public static String b(String str, String str2, String str3) {
        JSONObject qQMCConfig = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getQQMCConfig(str);
        if (qQMCConfig == null) {
            return str3;
        }
        return qQMCConfig.optString(str2, str3);
    }
}
