package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.Camera3DFovType;
import org.light.lightAssetKit.enums.Camera3DProjectionType;
import org.light.lightAssetKit.enums.Camera3DTargetBufferFlags;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Camera3DComponent extends Component {
    private float far;
    private float fov;
    private Camera3DFovType fovType;
    private float near;
    private Camera3DProjectionType projectionType;
    private float size;
    private Camera3DTargetBufferFlags targetBufferFlags;
    private int layers = 1;
    private Rect viewportRect = new Rect(0.0f, 0.0f, 1.0f, 1.0f);
    private boolean useUETonemap = false;
    private boolean copyInput = true;
    private String clearColor = "";
    private float clearDepth = 1.0f;
    private int clearStencil = 0;
    private boolean frustumCulling = true;
    private String renderTargetKey = "";
    private boolean is_use_3d_rt_ = false;
    private String output_3d_rendertarget_ = "";
    private DynamicResolutionOptions dynamicResolutionOptions = new DynamicResolutionOptions();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Camera3DComponent) {
            Camera3DComponent camera3DComponent = (Camera3DComponent) componentBase;
            this.layers = camera3DComponent.layers;
            this.projectionType = camera3DComponent.projectionType;
            this.fovType = camera3DComponent.fovType;
            this.fov = camera3DComponent.fov;
            this.size = camera3DComponent.size;
            this.near = camera3DComponent.near;
            this.far = camera3DComponent.far;
            this.viewportRect = camera3DComponent.viewportRect;
            this.useUETonemap = camera3DComponent.useUETonemap;
            this.copyInput = camera3DComponent.copyInput;
            this.targetBufferFlags = camera3DComponent.targetBufferFlags;
            this.clearColor = camera3DComponent.clearColor;
            this.clearDepth = camera3DComponent.clearDepth;
            this.clearStencil = camera3DComponent.clearStencil;
            this.frustumCulling = camera3DComponent.frustumCulling;
            this.renderTargetKey = camera3DComponent.renderTargetKey;
            this.is_use_3d_rt_ = camera3DComponent.is_use_3d_rt_;
            this.output_3d_rendertarget_ = camera3DComponent.output_3d_rendertarget_;
            this.dynamicResolutionOptions = camera3DComponent.dynamicResolutionOptions;
        }
        super.doUpdate(componentBase);
    }

    public String getClearColor() {
        return this.clearColor;
    }

    public float getClearDepth() {
        return this.clearDepth;
    }

    public int getClearStencil() {
        return this.clearStencil;
    }

    public boolean getCopyInput() {
        return this.copyInput;
    }

    public DynamicResolutionOptions getDynamicResolutionOptions() {
        return this.dynamicResolutionOptions;
    }

    public float getFar() {
        return this.far;
    }

    public float getFov() {
        return this.fov;
    }

    public Camera3DFovType getFovType() {
        return this.fovType;
    }

    public boolean getFrustumCulling() {
        return this.frustumCulling;
    }

    public boolean getIs_use_3d_rt_() {
        return this.is_use_3d_rt_;
    }

    public int getLayers() {
        return this.layers;
    }

    public float getNear() {
        return this.near;
    }

    public String getOutput_3d_rendertarget_() {
        return this.output_3d_rendertarget_;
    }

    public Camera3DProjectionType getProjectionType() {
        return this.projectionType;
    }

    public String getRenderTargetKey() {
        return this.renderTargetKey;
    }

    public float getSize() {
        return this.size;
    }

    public Camera3DTargetBufferFlags getTargetBufferFlags() {
        return this.targetBufferFlags;
    }

    public boolean getUseUETonemap() {
        return this.useUETonemap;
    }

    public Rect getViewportRect() {
        return this.viewportRect;
    }

    public void setClearColor(String str) {
        this.clearColor = str;
        reportPropertyChange("clearColor", str);
    }

    public void setClearDepth(float f16) {
        this.clearDepth = f16;
        reportPropertyChange("clearDepth", Float.valueOf(f16));
    }

    public void setClearStencil(int i3) {
        this.clearStencil = i3;
        reportPropertyChange("clearStencil", Integer.valueOf(i3));
    }

    public void setCopyInput(boolean z16) {
        this.copyInput = z16;
        reportPropertyChange("copyInput", Boolean.valueOf(z16));
    }

    public void setDynamicResolutionOptions(DynamicResolutionOptions dynamicResolutionOptions) {
        this.dynamicResolutionOptions = dynamicResolutionOptions;
        reportPropertyChange("dynamicResolutionOptions", dynamicResolutionOptions);
    }

    public void setFar(float f16) {
        this.far = f16;
        reportPropertyChange("far", Float.valueOf(f16));
    }

    public void setFov(float f16) {
        this.fov = f16;
        reportPropertyChange("fov", Float.valueOf(f16));
    }

    public void setFovType(Camera3DFovType camera3DFovType) {
        this.fovType = camera3DFovType;
        reportPropertyChange("fovType", camera3DFovType);
    }

    public void setFrustumCulling(boolean z16) {
        this.frustumCulling = z16;
        reportPropertyChange("frustumCulling", Boolean.valueOf(z16));
    }

    public void setIs_use_3d_rt_(boolean z16) {
        this.is_use_3d_rt_ = z16;
        reportPropertyChange("is_use_3d_rt_", Boolean.valueOf(z16));
    }

    public void setLayers(int i3) {
        this.layers = i3;
        reportPropertyChange("layers", Integer.valueOf(i3));
    }

    public void setNear(float f16) {
        this.near = f16;
        reportPropertyChange("near", Float.valueOf(f16));
    }

    public void setOutput_3d_rendertarget_(String str) {
        this.output_3d_rendertarget_ = str;
        reportPropertyChange("output_3d_rendertarget_", str);
    }

    public void setProjectionType(Camera3DProjectionType camera3DProjectionType) {
        this.projectionType = camera3DProjectionType;
        reportPropertyChange("projectionType", camera3DProjectionType);
    }

    public void setRenderTargetKey(String str) {
        this.renderTargetKey = str;
        reportPropertyChange("renderTargetKey", str);
    }

    public void setSize(float f16) {
        this.size = f16;
        reportPropertyChange("size", Float.valueOf(f16));
    }

    public void setTargetBufferFlags(Camera3DTargetBufferFlags camera3DTargetBufferFlags) {
        this.targetBufferFlags = camera3DTargetBufferFlags;
        reportPropertyChange("targetBufferFlags", camera3DTargetBufferFlags);
    }

    public void setUseUETonemap(boolean z16) {
        this.useUETonemap = z16;
        reportPropertyChange("useUETonemap", Boolean.valueOf(z16));
    }

    public void setViewportRect(Rect rect) {
        this.viewportRect = rect;
        reportPropertyChange("viewportRect", rect);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Camera3DComponent";
    }
}
