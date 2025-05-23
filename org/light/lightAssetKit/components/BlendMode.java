package org.light.lightAssetKit.components;

import com.tencent.luggage.wxa.c8.c;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.BlendModeType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BlendMode extends Component {
    private BlendModeType mode = BlendModeType.Normal;
    private float alpha = 1.0f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof BlendMode) {
            BlendMode blendMode = (BlendMode) componentBase;
            this.mode = blendMode.mode;
            this.alpha = blendMode.alpha;
        }
        super.doUpdate(componentBase);
    }

    public float getAlpha() {
        return this.alpha;
    }

    public BlendModeType getMode() {
        return this.mode;
    }

    public void setAlpha(float f16) {
        this.alpha = f16;
        reportPropertyChange(c.f123400v, Float.valueOf(f16));
    }

    public void setMode(BlendModeType blendModeType) {
        this.mode = blendModeType;
        reportPropertyChange("mode", blendModeType);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "BlendMode";
    }
}
