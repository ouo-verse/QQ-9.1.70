package org.light.lightAssetKit.components;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AITextureComponent extends Component {
    private String aiType = "";
    private String aiInputType = "";
    private boolean isRealTimeResult = true;
    private String inputRenderTarget = "";
    private String resourcePath = "";
    private int fps = 1;
    private boolean preLoad = false;
    private ArrayList<String> renderTargetList = new ArrayList<>();
    private JsonObject aiTextureInputParams = new JsonObject();
    private JsonObject aiTextureOutputParams = new JsonObject();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof AITextureComponent) {
            AITextureComponent aITextureComponent = (AITextureComponent) componentBase;
            this.aiType = aITextureComponent.aiType;
            this.aiInputType = aITextureComponent.aiInputType;
            this.isRealTimeResult = aITextureComponent.isRealTimeResult;
            this.inputRenderTarget = aITextureComponent.inputRenderTarget;
            this.resourcePath = aITextureComponent.resourcePath;
            this.fps = aITextureComponent.fps;
            this.preLoad = aITextureComponent.preLoad;
            this.renderTargetList = aITextureComponent.renderTargetList;
            this.aiTextureInputParams = aITextureComponent.aiTextureInputParams;
            this.aiTextureOutputParams = aITextureComponent.aiTextureOutputParams;
        }
        super.doUpdate(componentBase);
    }

    public String getAiInputType() {
        return this.aiInputType;
    }

    public JsonObject getAiTextureInputParams() {
        return this.aiTextureInputParams;
    }

    public JsonObject getAiTextureOutputParams() {
        return this.aiTextureOutputParams;
    }

    public String getAiType() {
        return this.aiType;
    }

    public int getFps() {
        return this.fps;
    }

    public String getInputRenderTarget() {
        return this.inputRenderTarget;
    }

    public boolean getIsRealTimeResult() {
        return this.isRealTimeResult;
    }

    public boolean getPreLoad() {
        return this.preLoad;
    }

    public ArrayList<String> getRenderTargetList() {
        return this.renderTargetList;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public void setAiInputType(String str) {
        this.aiInputType = str;
        reportPropertyChange("aiInputType", str);
    }

    public void setAiTextureInputParams(JsonObject jsonObject) {
        this.aiTextureInputParams = jsonObject;
        reportPropertyChange("aiTextureInputParams", jsonObject);
    }

    public void setAiTextureOutputParams(JsonObject jsonObject) {
        this.aiTextureOutputParams = jsonObject;
        reportPropertyChange("aiTextureOutputParams", jsonObject);
    }

    public void setAiType(String str) {
        this.aiType = str;
        reportPropertyChange("aiType", str);
    }

    public void setFps(int i3) {
        this.fps = i3;
        reportPropertyChange("fps", Integer.valueOf(i3));
    }

    public void setInputRenderTarget(String str) {
        this.inputRenderTarget = str;
        reportPropertyChange("inputRenderTarget", str);
    }

    public void setIsRealTimeResult(boolean z16) {
        this.isRealTimeResult = z16;
        reportPropertyChange("isRealTimeResult", Boolean.valueOf(z16));
    }

    public void setPreLoad(boolean z16) {
        this.preLoad = z16;
        reportPropertyChange("preLoad", Boolean.valueOf(z16));
    }

    public void setRenderTargetList(ArrayList<String> arrayList) {
        this.renderTargetList = arrayList;
        reportPropertyChange("renderTargetList", arrayList);
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
        reportPropertyChange("resourcePath", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "AITextureComponent";
    }
}
