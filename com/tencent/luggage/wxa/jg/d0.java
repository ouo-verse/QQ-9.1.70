package com.tencent.luggage.wxa.jg;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d0 implements f {
    public abstract Map a();

    public Map a(String type, com.tencent.luggage.wxa.ic.d component) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(component, "component");
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.GetSystemInfoNewLU", "get#PartOfGetSystemInfo_TypeSpecificInfo, type: " + type);
        Function2 function2 = (Function2) a().get(type);
        if (function2 == null) {
            return null;
        }
        Context context = component.getContext();
        HashMap hashMap = new HashMap();
        function2.invoke(context, hashMap);
        return hashMap;
    }
}
