package com.tencent.ditto.func;

import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;

/* loaded from: classes5.dex */
public abstract class DittoIdFuncPolyProxy implements DittoIdFuncPolyInf {
    protected abstract DittoIdFuncPoly getIdFuncPoly();

    @Override // com.tencent.ditto.func.DittoIdFuncPolyInf
    public void inflateArea(DittoAreaView dittoAreaView, DittoArea dittoArea, String str) {
        getIdFuncPoly().inflateArea(dittoAreaView, dittoArea, str);
    }
}
