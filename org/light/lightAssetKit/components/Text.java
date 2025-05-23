package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Text extends Component {
    private String text = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Text) {
            this.text = ((Text) componentBase).text;
        }
        super.doUpdate(componentBase);
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
        reportPropertyChange("text", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Text";
    }
}
