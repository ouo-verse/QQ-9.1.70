package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Canvas extends Component {
    private String renderTarget = "";
    private String scriptPath = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Canvas) {
            Canvas canvas = (Canvas) componentBase;
            this.renderTarget = canvas.renderTarget;
            this.scriptPath = canvas.scriptPath;
        }
        super.doUpdate(componentBase);
    }

    public String getRenderTarget() {
        return this.renderTarget;
    }

    public String getScriptPath() {
        return this.scriptPath;
    }

    public void setRenderTarget(String str) {
        this.renderTarget = str;
        reportPropertyChange("renderTarget", str);
    }

    public void setScriptPath(String str) {
        this.scriptPath = str;
        reportPropertyChange("scriptPath", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Canvas";
    }
}
