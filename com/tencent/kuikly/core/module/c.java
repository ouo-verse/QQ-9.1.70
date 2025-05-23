package com.tencent.kuikly.core.module;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0003H\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/kuikly/core/module/l;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "b", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/b;", "c", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {
    private static final com.tencent.kuikly.core.nvi.serialization.json.e b(l lVar) {
        return new com.tencent.kuikly.core.nvi.serialization.json.e().v("opt", lVar.getOpt()).t("field", lVar.getField().getId()).t("value", lVar.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.tencent.kuikly.core.nvi.serialization.json.b c(List<? extends l> list) {
        com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            bVar.t(b((l) it.next()).toString());
        }
        return bVar;
    }
}
