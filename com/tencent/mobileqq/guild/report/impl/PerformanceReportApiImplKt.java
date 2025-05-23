package com.tencent.mobileqq.guild.report.impl;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0018\u0010\u0003\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0002\u00a8\u0006\u0004"}, d2 = {"Ljava/util/concurrent/ConcurrentHashMap;", "", "", "b", "base_proj_ext_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PerformanceReportApiImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(ConcurrentHashMap<String, Object> concurrentHashMap) {
        String joinToString$default;
        Set<Map.Entry<String, Object>> entries = concurrentHashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entries, "entries");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(entries, ",", "{", "}", 0, null, new Function1<Map.Entry<String, Object>, CharSequence>() { // from class: com.tencent.mobileqq.guild.report.impl.PerformanceReportApiImplKt$toJsonString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Map.Entry<String, Object> entry) {
                Object quote;
                Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Number) {
                    quote = (Serializable) value;
                } else if (value instanceof Boolean) {
                    quote = (Serializable) value;
                } else {
                    quote = value instanceof Unit ? null : JSONObject.quote(value.toString());
                }
                return "\"" + key + "\":" + quote;
            }
        }, 24, null);
        return joinToString$default;
    }
}
