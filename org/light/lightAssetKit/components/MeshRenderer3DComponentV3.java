package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MeshRenderer3DComponentV3 extends Component {
    private boolean receiveShadow = true;
    private boolean castShadow = true;
    private int priority = 4;
    private boolean frustumCulling = true;
    private String meshResourceKey = "";
    private ArrayList<SubMeshConfig> subMeshConfigs = new ArrayList<>();
    private String skinInfoResourceKey = "";
    private boolean syncAppearance = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MeshRenderer3DComponentV3) {
            MeshRenderer3DComponentV3 meshRenderer3DComponentV3 = (MeshRenderer3DComponentV3) componentBase;
            this.receiveShadow = meshRenderer3DComponentV3.receiveShadow;
            this.castShadow = meshRenderer3DComponentV3.castShadow;
            this.priority = meshRenderer3DComponentV3.priority;
            this.frustumCulling = meshRenderer3DComponentV3.frustumCulling;
            this.meshResourceKey = meshRenderer3DComponentV3.meshResourceKey;
            this.subMeshConfigs = meshRenderer3DComponentV3.subMeshConfigs;
            this.skinInfoResourceKey = meshRenderer3DComponentV3.skinInfoResourceKey;
            this.syncAppearance = meshRenderer3DComponentV3.syncAppearance;
        }
        super.doUpdate(componentBase);
    }

    public boolean getCastShadow() {
        return this.castShadow;
    }

    public boolean getFrustumCulling() {
        return this.frustumCulling;
    }

    public String getMeshResourceKey() {
        return this.meshResourceKey;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean getReceiveShadow() {
        return this.receiveShadow;
    }

    public String getSkinInfoResourceKey() {
        return this.skinInfoResourceKey;
    }

    public ArrayList<SubMeshConfig> getSubMeshConfigs() {
        return this.subMeshConfigs;
    }

    public boolean getSyncAppearance() {
        return this.syncAppearance;
    }

    public void setCastShadow(boolean z16) {
        this.castShadow = z16;
        reportPropertyChange("castShadow", Boolean.valueOf(z16));
    }

    public void setFrustumCulling(boolean z16) {
        this.frustumCulling = z16;
        reportPropertyChange("frustumCulling", Boolean.valueOf(z16));
    }

    public void setMeshResourceKey(String str) {
        this.meshResourceKey = str;
        reportPropertyChange("meshResourceKey", str);
    }

    public void setPriority(int i3) {
        this.priority = i3;
        reportPropertyChange("priority", Integer.valueOf(i3));
    }

    public void setReceiveShadow(boolean z16) {
        this.receiveShadow = z16;
        reportPropertyChange("receiveShadow", Boolean.valueOf(z16));
    }

    public void setSkinInfoResourceKey(String str) {
        this.skinInfoResourceKey = str;
        reportPropertyChange("skinInfoResourceKey", str);
    }

    public void setSubMeshConfigs(ArrayList<SubMeshConfig> arrayList) {
        this.subMeshConfigs = arrayList;
        reportPropertyChange("subMeshConfigs", arrayList);
    }

    public void setSyncAppearance(boolean z16) {
        this.syncAppearance = z16;
        reportPropertyChange("syncAppearance", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MeshRenderer3DComponentV3";
    }
}
