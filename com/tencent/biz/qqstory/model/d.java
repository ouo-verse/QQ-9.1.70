package com.tencent.biz.qqstory.model;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public final c[] f94040a = new c[2];

    private void a(c cVar, int i3) {
        this.f94040a[i3] = cVar;
    }

    public <T extends c> T b(int i3) {
        c[] cVarArr = this.f94040a;
        j jVar = (T) cVarArr[i3];
        if (jVar == null) {
            synchronized (cVarArr) {
                jVar = (T) this.f94040a[i3];
                if (jVar != null) {
                    return jVar;
                }
                if (i3 != 0) {
                    if (i3 == 1) {
                        jVar = new a();
                    }
                } else {
                    jVar = new j();
                }
                a(jVar, i3);
                if (jVar != null) {
                    jVar.d();
                }
            }
        }
        return jVar;
    }

    @Override // com.tencent.biz.qqstory.model.e
    public void onDestroy() {
        hd0.c.a("DataProviderManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        for (c cVar : this.f94040a) {
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    @Override // com.tencent.biz.qqstory.model.e
    public void onInit() {
        hd0.c.a("DataProviderManager", "onInit");
    }
}
