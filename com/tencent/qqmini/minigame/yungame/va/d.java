package com.tencent.qqmini.minigame.yungame.va;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ReportProxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class d {
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("ext6", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("ext3", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("ext7", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("ext29", str7);
        }
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put("ext49", str8);
        }
        ReportProxy reportProxy = (ReportProxy) ProxyManager.get(ReportProxy.class);
        if (reportProxy != null) {
            reportProxy.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", str, str2, str3, hashMap);
        }
    }

    public static void b(String str, String str2, String str3, Map<String, String> map) {
        ReportProxy reportProxy = (ReportProxy) ProxyManager.get(ReportProxy.class);
        if (reportProxy != null) {
            reportProxy.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", str, str2, str3, map);
        }
    }
}
