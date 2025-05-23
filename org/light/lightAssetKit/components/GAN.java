package org.light.lightAssetKit.components;

import java.util.ArrayList;
import java.util.HashMap;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GAN extends Component {
    private String resourcePath = "";
    private ArrayList<String> inputResources = new ArrayList<>();
    private HashMap<String, String> inputMap = new HashMap<>();
    private float factor = 1.0f;
    private boolean need_validator = false;
    private boolean multiFacesOverlapCulling = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof GAN) {
            GAN gan = (GAN) componentBase;
            this.resourcePath = gan.resourcePath;
            this.inputResources = gan.inputResources;
            this.inputMap = gan.inputMap;
            this.factor = gan.factor;
            this.need_validator = gan.need_validator;
            this.multiFacesOverlapCulling = gan.multiFacesOverlapCulling;
        }
        super.doUpdate(componentBase);
    }

    public float getFactor() {
        return this.factor;
    }

    public HashMap<String, String> getInputMap() {
        return this.inputMap;
    }

    public ArrayList<String> getInputResources() {
        return this.inputResources;
    }

    public boolean getMultiFacesOverlapCulling() {
        return this.multiFacesOverlapCulling;
    }

    public boolean getNeed_validator() {
        return this.need_validator;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public void setFactor(float f16) {
        this.factor = f16;
        reportPropertyChange("factor", Float.valueOf(f16));
    }

    public void setInputMap(HashMap<String, String> hashMap) {
        this.inputMap = hashMap;
        reportPropertyChange("inputMap", hashMap);
    }

    public void setInputResources(ArrayList<String> arrayList) {
        this.inputResources = arrayList;
        reportPropertyChange("inputResources", arrayList);
    }

    public void setMultiFacesOverlapCulling(boolean z16) {
        this.multiFacesOverlapCulling = z16;
        reportPropertyChange("multiFacesOverlapCulling", Boolean.valueOf(z16));
    }

    public void setNeed_validator(boolean z16) {
        this.need_validator = z16;
        reportPropertyChange("need_validator", Boolean.valueOf(z16));
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
        reportPropertyChange("resourcePath", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "GAN";
    }
}
