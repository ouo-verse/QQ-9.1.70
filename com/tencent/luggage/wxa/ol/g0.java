package com.tencent.luggage.wxa.ol;

import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g0 extends l {
    @Override // com.tencent.luggage.wxa.ol.l
    public boolean a(i0 i0Var, com.tencent.luggage.wxa.vl.f fVar) {
        com.tencent.luggage.wxa.kj.v vVar;
        if (i0Var == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
            return false;
        }
        int i3 = fVar.Q;
        WeakReference weakReference = this.f136820i;
        if (weakReference == null || (vVar = (com.tencent.luggage.wxa.kj.v) weakReference.get()) == null) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", Integer.valueOf(i3));
            return false;
        }
        com.tencent.luggage.wxa.kj.c0 customViewContainer = vVar.getCustomViewContainer();
        if (customViewContainer == null) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(i3));
            return false;
        }
        Boolean bool = fVar.f143682t;
        int i16 = (bool == null || !bool.booleanValue()) ? 0 : 4;
        int i17 = fVar.P;
        float[] fArr = {fVar.f143667e.intValue(), fVar.f143666d.intValue(), fVar.f143664b.intValue(), fVar.f143665c.intValue(), 0};
        Boolean bool2 = fVar.f143686x;
        boolean a16 = customViewContainer.a(i0Var, i3, i17, fArr, i16, bool2 != null && bool2.booleanValue());
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", Integer.valueOf(i3), Boolean.valueOf(a16));
        return a16;
    }

    @Override // com.tencent.luggage.wxa.ol.l
    public boolean b(i0 i0Var, com.tencent.luggage.wxa.vl.f fVar) {
        com.tencent.luggage.wxa.kj.v vVar;
        int i3;
        if (i0Var == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
            return false;
        }
        int inputId = i0Var.getInputId();
        WeakReference weakReference = this.f136820i;
        if (weakReference != null && (vVar = (com.tencent.luggage.wxa.kj.v) weakReference.get()) != null) {
            com.tencent.luggage.wxa.kj.c0 customViewContainer = vVar.getCustomViewContainer();
            if (customViewContainer == null) {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(inputId));
                return false;
            }
            Boolean bool = fVar.f143682t;
            if (bool != null && bool.booleanValue()) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            boolean a16 = customViewContainer.a(inputId, new float[]{fVar.f143667e.intValue(), fVar.f143666d.intValue(), fVar.f143664b.intValue(), fVar.f143665c.intValue(), 0}, i3, fVar.f143686x);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", Integer.valueOf(inputId), Boolean.valueOf(a16));
            return a16;
        }
        com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", Integer.valueOf(inputId));
        return false;
    }

    @Override // com.tencent.luggage.wxa.ol.l
    public synchronized s0 l() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.ol.l
    public void a(i0 i0Var) {
        if (i0Var == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
            return;
        }
        int inputId = i0Var.getInputId();
        i0Var.a(this.f136815d);
        WeakReference weakReference = this.f136820i;
        com.tencent.luggage.wxa.kj.v vVar = weakReference == null ? null : (com.tencent.luggage.wxa.kj.v) weakReference.get();
        if (vVar == null) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", Integer.valueOf(inputId));
            return;
        }
        com.tencent.luggage.wxa.kj.c0 customViewContainer = vVar.getCustomViewContainer();
        if (customViewContainer == null) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(inputId));
        } else {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", Integer.valueOf(inputId), Boolean.valueOf(customViewContainer.f(inputId)));
        }
    }
}
