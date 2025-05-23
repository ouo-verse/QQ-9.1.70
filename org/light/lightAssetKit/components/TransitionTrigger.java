package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TransitionTrigger extends Component {
    private int threshold = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof TransitionTrigger) {
            this.threshold = ((TransitionTrigger) componentBase).threshold;
        }
        super.doUpdate(componentBase);
    }

    public int getThreshold() {
        return this.threshold;
    }

    public void setThreshold(int i3) {
        this.threshold = i3;
        reportPropertyChange("threshold", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "TransitionTrigger";
    }
}
