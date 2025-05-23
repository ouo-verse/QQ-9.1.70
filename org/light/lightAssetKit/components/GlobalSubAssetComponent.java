package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.GlobalSubAssetSizeType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GlobalSubAssetComponent extends Component {
    private GlobalSubAssetSizeType globalSubAssetSizeType;
    private int width = 0;
    private int height = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof GlobalSubAssetComponent) {
            GlobalSubAssetComponent globalSubAssetComponent = (GlobalSubAssetComponent) componentBase;
            this.globalSubAssetSizeType = globalSubAssetComponent.globalSubAssetSizeType;
            this.width = globalSubAssetComponent.width;
            this.height = globalSubAssetComponent.height;
        }
        super.doUpdate(componentBase);
    }

    public GlobalSubAssetSizeType getGlobalSubAssetSizeType() {
        return this.globalSubAssetSizeType;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setGlobalSubAssetSizeType(GlobalSubAssetSizeType globalSubAssetSizeType) {
        this.globalSubAssetSizeType = globalSubAssetSizeType;
        reportPropertyChange("globalSubAssetSizeType", globalSubAssetSizeType);
    }

    public void setHeight(int i3) {
        this.height = i3;
        reportPropertyChange("height", Integer.valueOf(i3));
    }

    public void setWidth(int i3) {
        this.width = i3;
        reportPropertyChange("width", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "GlobalSubAssetComponent";
    }
}
