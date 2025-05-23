package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* loaded from: classes29.dex */
public class PostEffect extends Component {
    private String src = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof PostEffect) {
            this.src = ((PostEffect) componentBase).src;
        }
        super.doUpdate(componentBase);
    }

    public String getSrc() {
        return this.src;
    }

    public void setSrc(String str) {
        this.src = str;
        reportPropertyChange("src", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "PostEffect";
    }
}
