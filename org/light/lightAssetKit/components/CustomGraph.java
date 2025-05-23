package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CustomGraph extends Component {
    private String resourcePath = "";
    private String uniformJson = "";
    private boolean needOnRender = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof CustomGraph) {
            CustomGraph customGraph = (CustomGraph) componentBase;
            this.resourcePath = customGraph.resourcePath;
            this.uniformJson = customGraph.uniformJson;
            this.needOnRender = customGraph.needOnRender;
        }
        super.doUpdate(componentBase);
    }

    public boolean getNeedOnRender() {
        return this.needOnRender;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public String getUniformJson() {
        return this.uniformJson;
    }

    public void setNeedOnRender(boolean z16) {
        this.needOnRender = z16;
        reportPropertyChange("needOnRender", Boolean.valueOf(z16));
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
        reportPropertyChange("resourcePath", str);
    }

    public void setUniformJson(String str) {
        this.uniformJson = str;
        reportPropertyChange("uniformJson", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "CustomGraph";
    }
}
