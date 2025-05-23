package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AudioEffect extends Component {
    private String preset = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof AudioEffect) {
            this.preset = ((AudioEffect) componentBase).preset;
        }
        super.doUpdate(componentBase);
    }

    public String getPreset() {
        return this.preset;
    }

    public void setPreset(String str) {
        this.preset = str;
        reportPropertyChange("preset", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "AudioEffect";
    }
}
