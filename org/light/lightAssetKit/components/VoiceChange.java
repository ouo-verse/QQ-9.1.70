package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VoiceChange extends Component {
    private int voiceKind = -1;
    private int environment = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof VoiceChange) {
            VoiceChange voiceChange = (VoiceChange) componentBase;
            this.voiceKind = voiceChange.voiceKind;
            this.environment = voiceChange.environment;
        }
        super.doUpdate(componentBase);
    }

    public int getEnvironment() {
        return this.environment;
    }

    public int getVoiceKind() {
        return this.voiceKind;
    }

    public void setEnvironment(int i3) {
        this.environment = i3;
        reportPropertyChange("environment", Integer.valueOf(i3));
    }

    public void setVoiceKind(int i3) {
        this.voiceKind = i3;
        reportPropertyChange("voiceKind", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "VoiceChange";
    }
}
