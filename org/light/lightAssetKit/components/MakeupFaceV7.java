package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MakeupFaceV7 extends MakeupComponent {
    private boolean needLipsMask = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.MakeupComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MakeupFaceV7) {
            this.needLipsMask = ((MakeupFaceV7) componentBase).needLipsMask;
        }
        super.doUpdate(componentBase);
    }

    public boolean getNeedLipsMask() {
        return this.needLipsMask;
    }

    public void setNeedLipsMask(boolean z16) {
        this.needLipsMask = z16;
        reportPropertyChange("needLipsMask", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.MakeupComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MakeupFaceV7";
    }
}
