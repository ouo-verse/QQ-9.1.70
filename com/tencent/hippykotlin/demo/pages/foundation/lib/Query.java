package com.tencent.hippykotlin.demo.pages.foundation.lib;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Query {
    public Map<String, String> query;

    public Query(Map<String, String> map) {
        this.query = map;
    }

    public final int hashCode() {
        return this.query.hashCode();
    }

    public final String toString() {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.query.keySet(), ContainerUtils.FIELD_DELIMITER, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.Query$toString$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String str) {
                String str2 = str;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append('=');
                String str3 = Query.this.query.get(str2);
                if (str3 == null) {
                    str3 = "";
                }
                sb5.append(UriKt.encodeURIComponent(str3));
                return sb5.toString();
            }
        }, 30, null);
        return joinToString$default;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Query) && Intrinsics.areEqual(this.query, ((Query) obj).query);
    }
}
