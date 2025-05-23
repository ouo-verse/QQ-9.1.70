package org.light.lightAssetKit.components;

import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.PAGScaleMode;
import org.light.lightAssetKit.enums.TransitionType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Transition extends Component {
    private int firstIndex = 0;
    private int lastIndex = 1;
    private long duration = 0;
    private PAGScaleMode scaleMode = PAGScaleMode.Stretch;
    private TransitionType renderType = TransitionType.PAG;
    private String src = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Transition) {
            Transition transition = (Transition) componentBase;
            this.firstIndex = transition.firstIndex;
            this.lastIndex = transition.lastIndex;
            this.duration = transition.duration;
            this.scaleMode = transition.scaleMode;
            this.renderType = transition.renderType;
            this.src = transition.src;
        }
        super.doUpdate(componentBase);
    }

    public long getDuration() {
        return this.duration;
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public int getLastIndex() {
        return this.lastIndex;
    }

    public TransitionType getRenderType() {
        return this.renderType;
    }

    public PAGScaleMode getScaleMode() {
        return this.scaleMode;
    }

    public String getSrc() {
        return this.src;
    }

    public void setDuration(long j3) {
        this.duration = j3;
        reportPropertyChange("duration", Long.valueOf(j3));
    }

    public void setFirstIndex(int i3) {
        this.firstIndex = i3;
        reportPropertyChange("firstIndex", Integer.valueOf(i3));
    }

    public void setLastIndex(int i3) {
        this.lastIndex = i3;
        reportPropertyChange("lastIndex", Integer.valueOf(i3));
    }

    public void setRenderType(TransitionType transitionType) {
        this.renderType = transitionType;
        reportPropertyChange("renderType", transitionType);
    }

    public void setScaleMode(PAGScaleMode pAGScaleMode) {
        this.scaleMode = pAGScaleMode;
        reportPropertyChange(HippyQQPagViewController.PropertyName.SCALE_MODE, pAGScaleMode);
    }

    public void setSrc(String str) {
        this.src = str;
        reportPropertyChange("src", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Transition";
    }
}
