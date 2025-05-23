package com.tencent.ditto.func;

import android.support.v4.util.ArrayMap;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes5.dex */
public class DittoIdFuncPoly implements DittoIdFuncPolyInf {
    private final Map<String, DittoIdFunc> idFuncMap;

    public DittoIdFuncPoly(Map<String, DittoIdFunc> map) {
        this.idFuncMap = Collections.unmodifiableMap(map);
    }

    public static DittoIdFuncPoly createReflectIdFuncPoly(Class<? extends DittoAreaView> cls) {
        HashMap hashMap = new HashMap();
        ArrayMap<String, Field> fields = DittoAreaView.getFields(cls);
        ArrayMap<String, Method>[] methods = DittoAreaView.getMethods(cls);
        HashSet<String> hashSet = new HashSet(fields.keySet());
        hashSet.addAll(methods[0].keySet());
        hashSet.addAll(methods[1].keySet());
        for (String str : hashSet) {
            hashMap.put(str, new ReflectDittoIdFunc(fields.get(str), methods[0].get(str), methods[1].get(str)));
        }
        return new DittoIdFuncPoly(hashMap);
    }

    @Override // com.tencent.ditto.func.DittoIdFuncPolyInf
    public void inflateArea(DittoAreaView dittoAreaView, DittoArea dittoArea, String str) {
        DittoIdFunc dittoIdFunc = this.idFuncMap.get(str);
        if (dittoIdFunc != null) {
            dittoIdFunc.inflate(dittoAreaView, dittoArea);
        }
    }
}
