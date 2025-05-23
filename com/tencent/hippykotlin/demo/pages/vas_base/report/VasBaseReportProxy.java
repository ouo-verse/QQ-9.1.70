package com.tencent.hippykotlin.demo.pages.vas_base.report;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public class VasBaseReportProxy {
    public final void recordMap(Map<String, String> map, String str, Map<String, ? extends Object> map2) {
        if (map2.isEmpty()) {
            return;
        }
        e eVar = new e();
        for (Map.Entry<String, ? extends Object> entry : map2.entrySet()) {
            eVar.v(entry.getKey(), entry.getValue());
        }
        map.put(str, eVar.toString());
    }

    public final void recordString(Map<String, String> map, String str, String str2) {
        if (Intrinsics.areEqual(str2, "")) {
            return;
        }
        map.put(str, str2);
    }

    public final void recordNum(Map<String, String> map, String str, long j3) {
        if (j3 == -1) {
            return;
        }
        map.put(str, String.valueOf(j3));
    }
}
