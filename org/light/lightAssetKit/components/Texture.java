package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Texture extends Component {
    private String sourceTextureId = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Texture) {
            this.sourceTextureId = ((Texture) componentBase).sourceTextureId;
        }
        super.doUpdate(componentBase);
    }

    public String getSourceTextureId() {
        return this.sourceTextureId;
    }

    public void setSourceTextureId(String str) {
        this.sourceTextureId = str;
        reportPropertyChange("sourceTextureId", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Texture";
    }
}
