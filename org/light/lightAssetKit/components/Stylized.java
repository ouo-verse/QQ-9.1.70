package org.light.lightAssetKit.components;

import java.util.HashMap;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Stylized extends Component {
    private boolean isDenoise;
    private String stylizedType = "OldComicFilter";
    private HashMap<String, String> lutPaths = new HashMap<>();
    private HashMap<String, String> materialPaths = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Stylized) {
            Stylized stylized = (Stylized) componentBase;
            this.stylizedType = stylized.stylizedType;
            this.isDenoise = stylized.isDenoise;
            this.lutPaths = stylized.lutPaths;
            this.materialPaths = stylized.materialPaths;
        }
        super.doUpdate(componentBase);
    }

    public boolean getIsDenoise() {
        return this.isDenoise;
    }

    public HashMap<String, String> getLutPaths() {
        return this.lutPaths;
    }

    public HashMap<String, String> getMaterialPaths() {
        return this.materialPaths;
    }

    public String getStylizedType() {
        return this.stylizedType;
    }

    public void setIsDenoise(boolean z16) {
        this.isDenoise = z16;
        reportPropertyChange("isDenoise", Boolean.valueOf(z16));
    }

    public void setLutPaths(HashMap<String, String> hashMap) {
        this.lutPaths = hashMap;
        reportPropertyChange("lutPaths", hashMap);
    }

    public void setMaterialPaths(HashMap<String, String> hashMap) {
        this.materialPaths = hashMap;
        reportPropertyChange("materialPaths", hashMap);
    }

    public void setStylizedType(String str) {
        this.stylizedType = str;
        reportPropertyChange("stylizedType", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Stylized";
    }
}
