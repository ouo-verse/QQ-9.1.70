package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Tips extends Component {
    private String tips = "";
    private String image = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Tips) {
            Tips tips = (Tips) componentBase;
            this.tips = tips.tips;
            this.image = tips.image;
        }
        super.doUpdate(componentBase);
    }

    public String getImage() {
        return this.image;
    }

    public String getTips() {
        return this.tips;
    }

    public void setImage(String str) {
        this.image = str;
        reportPropertyChange("image", str);
    }

    public void setTips(String str) {
        this.tips = str;
        reportPropertyChange("tips", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Tips";
    }
}
