package org.light.lightAssetKit.components;

import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.PAGScaleMode;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Image extends Component {
    private PAGScaleMode scaleMode = PAGScaleMode.LetterBox;
    private long duration = 0;
    private boolean loop = true;
    private String src = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Image) {
            Image image = (Image) componentBase;
            this.scaleMode = image.scaleMode;
            this.duration = image.duration;
            this.loop = image.loop;
            this.src = image.src;
        }
        super.doUpdate(componentBase);
    }

    public long getDuration() {
        return this.duration;
    }

    public boolean getLoop() {
        return this.loop;
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

    public void setLoop(boolean z16) {
        this.loop = z16;
        reportPropertyChange("loop", Boolean.valueOf(z16));
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
        return "Image";
    }
}
