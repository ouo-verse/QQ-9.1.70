package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.SubAssetApplyType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SubAssetComponent extends Component {
    private ArrayList<Integer> indexes = new ArrayList<>();
    private SubAssetApplyType subAssetApplyType = SubAssetApplyType.All;
    private boolean renderAfterTransform = false;
    private boolean isUsingPropertiesSize = false;
    private boolean isInputScaleFit = false;
    private boolean cacheRenderResult = false;
    private Size render_size = new Size();
    private Size surface_size = new Size();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof SubAssetComponent) {
            SubAssetComponent subAssetComponent = (SubAssetComponent) componentBase;
            this.indexes = subAssetComponent.indexes;
            this.subAssetApplyType = subAssetComponent.subAssetApplyType;
            this.renderAfterTransform = subAssetComponent.renderAfterTransform;
            this.isUsingPropertiesSize = subAssetComponent.isUsingPropertiesSize;
            this.isInputScaleFit = subAssetComponent.isInputScaleFit;
            this.cacheRenderResult = subAssetComponent.cacheRenderResult;
            this.render_size = subAssetComponent.render_size;
            this.surface_size = subAssetComponent.surface_size;
        }
        super.doUpdate(componentBase);
    }

    public boolean getCacheRenderResult() {
        return this.cacheRenderResult;
    }

    public ArrayList<Integer> getIndexes() {
        return this.indexes;
    }

    public boolean getIsInputScaleFit() {
        return this.isInputScaleFit;
    }

    public boolean getIsUsingPropertiesSize() {
        return this.isUsingPropertiesSize;
    }

    public boolean getRenderAfterTransform() {
        return this.renderAfterTransform;
    }

    public Size getRender_size() {
        return this.render_size;
    }

    public SubAssetApplyType getSubAssetApplyType() {
        return this.subAssetApplyType;
    }

    public Size getSurface_size() {
        return this.surface_size;
    }

    public void setCacheRenderResult(boolean z16) {
        this.cacheRenderResult = z16;
        reportPropertyChange("cacheRenderResult", Boolean.valueOf(z16));
    }

    public void setIndexes(ArrayList<Integer> arrayList) {
        this.indexes = arrayList;
        reportPropertyChange("indexes", arrayList);
    }

    public void setIsInputScaleFit(boolean z16) {
        this.isInputScaleFit = z16;
        reportPropertyChange("isInputScaleFit", Boolean.valueOf(z16));
    }

    public void setIsUsingPropertiesSize(boolean z16) {
        this.isUsingPropertiesSize = z16;
        reportPropertyChange("isUsingPropertiesSize", Boolean.valueOf(z16));
    }

    public void setRenderAfterTransform(boolean z16) {
        this.renderAfterTransform = z16;
        reportPropertyChange("renderAfterTransform", Boolean.valueOf(z16));
    }

    public void setRender_size(Size size) {
        this.render_size = size;
        reportPropertyChange("render_size", size);
    }

    public void setSubAssetApplyType(SubAssetApplyType subAssetApplyType) {
        this.subAssetApplyType = subAssetApplyType;
        reportPropertyChange("subAssetApplyType", subAssetApplyType);
    }

    public void setSurface_size(Size size) {
        this.surface_size = size;
        reportPropertyChange("surface_size", size);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "SubAssetComponent";
    }
}
