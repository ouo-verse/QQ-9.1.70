package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m {
    static IPatchRedirector $redirector_;

    public static boolean a(String str, String str2, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18) {
        Map<String, String> map2;
        if (map == null) {
            map2 = new HashMap();
        } else {
            map2 = map;
        }
        map2.put("q_consume_time", String.valueOf(j3));
        map2.put("q_length", String.valueOf(j16));
        return ReportMethodProxy.onUserActionToTunnel(str, str2, z16, j3, j16, map2, z17, z18);
    }
}
