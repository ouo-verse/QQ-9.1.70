package com.tencent.hippykotlin.demo.pages.base.module;

import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CalendarModuleKt {
    public static final b access$toJSONArray(List list) {
        b bVar = new b();
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return bVar;
        }
        Operation operation = (Operation) it.next();
        e eVar = new e();
        operation.getClass();
        eVar.v("opt", null);
        throw null;
    }
}
