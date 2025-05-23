package com.tencent.kuikly.core.nvi.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "jsonObject", "", "b", "Lcom/tencent/kuikly/core/nvi/serialization/json/b;", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d {
    public static final String a(b jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JSONStringer jSONStringer = new JSONStringer();
        jsonObject.x(jSONStringer);
        return jSONStringer.toString();
    }

    public static final String b(e jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JSONStringer jSONStringer = new JSONStringer();
        jsonObject.E(jSONStringer);
        return jSONStringer.toString();
    }
}
