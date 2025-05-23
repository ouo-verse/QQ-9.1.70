package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SnapOneShot extends Component {
    private String outTextureId = "";
    private boolean triggered = false;
    private long last_dt = Long.MAX_VALUE;
    private String texSavePath = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof SnapOneShot) {
            SnapOneShot snapOneShot = (SnapOneShot) componentBase;
            this.outTextureId = snapOneShot.outTextureId;
            this.triggered = snapOneShot.triggered;
            this.last_dt = snapOneShot.last_dt;
            this.texSavePath = snapOneShot.texSavePath;
        }
        super.doUpdate(componentBase);
    }

    public long getLast_dt() {
        return this.last_dt;
    }

    public String getOutTextureId() {
        return this.outTextureId;
    }

    public String getTexSavePath() {
        return this.texSavePath;
    }

    public boolean getTriggered() {
        return this.triggered;
    }

    public void setLast_dt(long j3) {
        this.last_dt = j3;
        reportPropertyChange("last_dt", Long.valueOf(j3));
    }

    public void setOutTextureId(String str) {
        this.outTextureId = str;
        reportPropertyChange("outTextureId", str);
    }

    public void setTexSavePath(String str) {
        this.texSavePath = str;
        reportPropertyChange("texSavePath", str);
    }

    public void setTriggered(boolean z16) {
        this.triggered = z16;
        reportPropertyChange("triggered", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "SnapOneShot";
    }
}
