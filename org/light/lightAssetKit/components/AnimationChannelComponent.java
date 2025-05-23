package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnimationChannelComponent extends Component {
    private ArrayList<AnimationChannel> animation_channels_ = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof AnimationChannelComponent) {
            this.animation_channels_ = ((AnimationChannelComponent) componentBase).animation_channels_;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<AnimationChannel> getAnimation_channels_() {
        return this.animation_channels_;
    }

    public void setAnimation_channels_(ArrayList<AnimationChannel> arrayList) {
        this.animation_channels_ = arrayList;
        reportPropertyChange("animation_channels_", arrayList);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "AnimationChannelComponent";
    }
}
