package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnimationController extends Component {
    private ArrayList<AnimationClip> clips;

    public AnimationController() {
        this.clips = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof AnimationController) {
            this.clips = ((AnimationController) componentBase).clips;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<AnimationClip> getClips() {
        return this.clips;
    }

    public void setClips(ArrayList<AnimationClip> arrayList) {
        this.clips = arrayList;
        reportPropertyChange("clips", arrayList);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "AnimationController";
    }

    public AnimationController(ArrayList<AnimationClip> arrayList) {
        new ArrayList();
        this.clips = arrayList;
    }
}
