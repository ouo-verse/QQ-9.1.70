package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.MaterialSupportRenderToTargetType;
import org.light.lightAssetKit.enums.UserMaterialTrackerType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class UserMaterial extends Component {
    private String defaultResourceSrc = "";
    private MaterialSupportRenderToTargetType renderToTargetType = MaterialSupportRenderToTargetType.RenderTarget;
    private UserMaterialTrackerType trackerType = UserMaterialTrackerType.NONE;
    private String faceMaskPath = "";
    private ArrayList<String> trackerTargetKeys = new ArrayList<>();
    private String src = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof UserMaterial) {
            UserMaterial userMaterial = (UserMaterial) componentBase;
            this.defaultResourceSrc = userMaterial.defaultResourceSrc;
            this.renderToTargetType = userMaterial.renderToTargetType;
            this.trackerType = userMaterial.trackerType;
            this.faceMaskPath = userMaterial.faceMaskPath;
            this.trackerTargetKeys = userMaterial.trackerTargetKeys;
            this.src = userMaterial.src;
        }
        super.doUpdate(componentBase);
    }

    public String getDefaultResourceSrc() {
        return this.defaultResourceSrc;
    }

    public String getFaceMaskPath() {
        return this.faceMaskPath;
    }

    public MaterialSupportRenderToTargetType getRenderToTargetType() {
        return this.renderToTargetType;
    }

    public String getSrc() {
        return this.src;
    }

    public ArrayList<String> getTrackerTargetKeys() {
        return this.trackerTargetKeys;
    }

    public UserMaterialTrackerType getTrackerType() {
        return this.trackerType;
    }

    public void setDefaultResourceSrc(String str) {
        this.defaultResourceSrc = str;
        reportPropertyChange("defaultResourceSrc", str);
    }

    public void setFaceMaskPath(String str) {
        this.faceMaskPath = str;
        reportPropertyChange("faceMaskPath", str);
    }

    public void setRenderToTargetType(MaterialSupportRenderToTargetType materialSupportRenderToTargetType) {
        this.renderToTargetType = materialSupportRenderToTargetType;
        reportPropertyChange("renderToTargetType", materialSupportRenderToTargetType);
    }

    public void setSrc(String str) {
        this.src = str;
        reportPropertyChange("src", str);
    }

    public void setTrackerTargetKeys(ArrayList<String> arrayList) {
        this.trackerTargetKeys = arrayList;
        reportPropertyChange("trackerTargetKeys", arrayList);
    }

    public void setTrackerType(UserMaterialTrackerType userMaterialTrackerType) {
        this.trackerType = userMaterialTrackerType;
        reportPropertyChange("trackerType", userMaterialTrackerType);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "UserMaterial";
    }
}
