package org.light.lightAssetKit.components;

import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.FaceMorphingMethodType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CrazyFace extends Component {
    private int modelIndex = -1;
    private ArrayList<CrazyFaceModel> models = new ArrayList<>();
    private String modelImage = "";
    private String faceMaskImage = "";
    private String imageFaceJson = "";
    private float progress = 0.0f;
    private boolean needCache = true;
    private FaceMorphingMethodType method = FaceMorphingMethodType.RefineMorphing;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof CrazyFace) {
            CrazyFace crazyFace = (CrazyFace) componentBase;
            this.modelIndex = crazyFace.modelIndex;
            this.models = crazyFace.models;
            this.modelImage = crazyFace.modelImage;
            this.faceMaskImage = crazyFace.faceMaskImage;
            this.imageFaceJson = crazyFace.imageFaceJson;
            this.progress = crazyFace.progress;
            this.needCache = crazyFace.needCache;
            this.method = crazyFace.method;
        }
        super.doUpdate(componentBase);
    }

    public String getFaceMaskImage() {
        return this.faceMaskImage;
    }

    public String getImageFaceJson() {
        return this.imageFaceJson;
    }

    public FaceMorphingMethodType getMethod() {
        return this.method;
    }

    public String getModelImage() {
        return this.modelImage;
    }

    public int getModelIndex() {
        return this.modelIndex;
    }

    public ArrayList<CrazyFaceModel> getModels() {
        return this.models;
    }

    public boolean getNeedCache() {
        return this.needCache;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setFaceMaskImage(String str) {
        this.faceMaskImage = str;
        reportPropertyChange("faceMaskImage", str);
    }

    public void setImageFaceJson(String str) {
        this.imageFaceJson = str;
        reportPropertyChange("imageFaceJson", str);
    }

    public void setMethod(FaceMorphingMethodType faceMorphingMethodType) {
        this.method = faceMorphingMethodType;
        reportPropertyChange("method", faceMorphingMethodType);
    }

    public void setModelImage(String str) {
        this.modelImage = str;
        reportPropertyChange("modelImage", str);
    }

    public void setModelIndex(int i3) {
        this.modelIndex = i3;
        reportPropertyChange("modelIndex", Integer.valueOf(i3));
    }

    public void setModels(ArrayList<CrazyFaceModel> arrayList) {
        this.models = arrayList;
        reportPropertyChange(IQQGameCommApi.K_ABTEST_MODELS, arrayList);
    }

    public void setNeedCache(boolean z16) {
        this.needCache = z16;
        reportPropertyChange("needCache", Boolean.valueOf(z16));
    }

    public void setProgress(float f16) {
        this.progress = f16;
        reportPropertyChange("progress", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "CrazyFace";
    }
}
