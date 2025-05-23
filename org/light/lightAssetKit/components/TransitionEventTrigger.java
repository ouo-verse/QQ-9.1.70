package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TransitionEventTrigger extends EventTrigger {
    private ArrayList<TransitionEventInfos> transitionEventInfos = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.EventTrigger, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof TransitionEventTrigger) {
            this.transitionEventInfos = ((TransitionEventTrigger) componentBase).transitionEventInfos;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<TransitionEventInfos> getTransitionEventInfos() {
        return this.transitionEventInfos;
    }

    public void setTransitionEventInfos(ArrayList<TransitionEventInfos> arrayList) {
        this.transitionEventInfos = arrayList;
        reportPropertyChange("transitionEventInfos", arrayList);
    }

    @Override // org.light.lightAssetKit.components.EventTrigger, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "TransitionEventTrigger";
    }
}
