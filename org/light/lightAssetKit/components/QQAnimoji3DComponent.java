package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class QQAnimoji3DComponent extends Component {
    private String morphName = "";
    private boolean trackEyeRoll = false;
    private int eyeBoneId = -1;
    private ArrayList<AnimojiConfig> animojiConfig = new ArrayList<>();
    private EyeSetting eyeSetting = new EyeSetting();
    private boolean enableProMode = false;
    private float smoothStrength = 0.0f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof QQAnimoji3DComponent) {
            QQAnimoji3DComponent qQAnimoji3DComponent = (QQAnimoji3DComponent) componentBase;
            this.morphName = qQAnimoji3DComponent.morphName;
            this.trackEyeRoll = qQAnimoji3DComponent.trackEyeRoll;
            this.eyeBoneId = qQAnimoji3DComponent.eyeBoneId;
            this.animojiConfig = qQAnimoji3DComponent.animojiConfig;
            this.eyeSetting = qQAnimoji3DComponent.eyeSetting;
            this.enableProMode = qQAnimoji3DComponent.enableProMode;
            this.smoothStrength = qQAnimoji3DComponent.smoothStrength;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<AnimojiConfig> getAnimojiConfig() {
        return this.animojiConfig;
    }

    public boolean getEnableProMode() {
        return this.enableProMode;
    }

    public int getEyeBoneId() {
        return this.eyeBoneId;
    }

    public EyeSetting getEyeSetting() {
        return this.eyeSetting;
    }

    public String getMorphName() {
        return this.morphName;
    }

    public float getSmoothStrength() {
        return this.smoothStrength;
    }

    public boolean getTrackEyeRoll() {
        return this.trackEyeRoll;
    }

    public void setAnimojiConfig(ArrayList<AnimojiConfig> arrayList) {
        this.animojiConfig = arrayList;
        reportPropertyChange("animojiConfig", arrayList);
    }

    public void setEnableProMode(boolean z16) {
        this.enableProMode = z16;
        reportPropertyChange("enableProMode", Boolean.valueOf(z16));
    }

    public void setEyeBoneId(int i3) {
        this.eyeBoneId = i3;
        reportPropertyChange("eyeBoneId", Integer.valueOf(i3));
    }

    public void setEyeSetting(EyeSetting eyeSetting) {
        this.eyeSetting = eyeSetting;
        reportPropertyChange("eyeSetting", eyeSetting);
    }

    public void setMorphName(String str) {
        this.morphName = str;
        reportPropertyChange("morphName", str);
    }

    public void setSmoothStrength(float f16) {
        this.smoothStrength = f16;
        reportPropertyChange("smoothStrength", Float.valueOf(f16));
    }

    public void setTrackEyeRoll(boolean z16) {
        this.trackEyeRoll = z16;
        reportPropertyChange("trackEyeRoll", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "QQAnimoji3DComponent";
    }
}
