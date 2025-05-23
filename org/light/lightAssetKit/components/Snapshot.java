package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Snapshot extends Component {
    private String outTextureId = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Snapshot) {
            this.outTextureId = ((Snapshot) componentBase).outTextureId;
        }
        super.doUpdate(componentBase);
    }

    public String getOutTextureId() {
        return this.outTextureId;
    }

    public void setOutTextureId(String str) {
        this.outTextureId = str;
        reportPropertyChange("outTextureId", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Snapshot";
    }
}
