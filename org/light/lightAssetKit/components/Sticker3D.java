package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.Sticker3DMaterialType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Sticker3D extends Component {
    private Sticker3DMaterialType materialType = Sticker3DMaterialType.Normal;
    private int fov = 60;
    private boolean use3DMMTransform = false;
    private boolean fit3DMM = false;
    private boolean isKapuMaterial = false;
    private boolean needFaceMeshFacekit = false;
    private boolean enableTessellation = false;
    private int faceMeshModelType = 0;
    private int modelType = 0;
    private float projectionFar = 1000.0f;
    private int kapuMaterialType = 0;
    private boolean useMetal = false;
    private Position initPosition = new Position(0.0f, 0.0f, 0.0f);
    private Position initRotation = new Position(0.0f, 0.0f, 0.0f);
    private Position rotationFactor = new Position(0.0f, 0.0f, 0.0f);
    private CameraTransform initialCameraTransform = new CameraTransform();
    private ArrayList<CameraViewConfig> cameraViewConfig = new ArrayList<>();
    private String resourcePath = "";
    private String materialPath = "";
    private ArrayList<String> externalInputKey = new ArrayList<>();
    private ArrayList<String> inputRenderTarget = new ArrayList<>();
    private String triggerJson = "";
    private boolean useRealSizeHead = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Sticker3D) {
            Sticker3D sticker3D = (Sticker3D) componentBase;
            this.materialType = sticker3D.materialType;
            this.fov = sticker3D.fov;
            this.use3DMMTransform = sticker3D.use3DMMTransform;
            this.fit3DMM = sticker3D.fit3DMM;
            this.isKapuMaterial = sticker3D.isKapuMaterial;
            this.needFaceMeshFacekit = sticker3D.needFaceMeshFacekit;
            this.enableTessellation = sticker3D.enableTessellation;
            this.faceMeshModelType = sticker3D.faceMeshModelType;
            this.modelType = sticker3D.modelType;
            this.projectionFar = sticker3D.projectionFar;
            this.kapuMaterialType = sticker3D.kapuMaterialType;
            this.useMetal = sticker3D.useMetal;
            this.initPosition = sticker3D.initPosition;
            this.initRotation = sticker3D.initRotation;
            this.rotationFactor = sticker3D.rotationFactor;
            this.initialCameraTransform = sticker3D.initialCameraTransform;
            this.cameraViewConfig = sticker3D.cameraViewConfig;
            this.resourcePath = sticker3D.resourcePath;
            this.materialPath = sticker3D.materialPath;
            this.externalInputKey = sticker3D.externalInputKey;
            this.inputRenderTarget = sticker3D.inputRenderTarget;
            this.triggerJson = sticker3D.triggerJson;
            this.useRealSizeHead = sticker3D.useRealSizeHead;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<CameraViewConfig> getCameraViewConfig() {
        return this.cameraViewConfig;
    }

    public boolean getEnableTessellation() {
        return this.enableTessellation;
    }

    public ArrayList<String> getExternalInputKey() {
        return this.externalInputKey;
    }

    public int getFaceMeshModelType() {
        return this.faceMeshModelType;
    }

    public boolean getFit3DMM() {
        return this.fit3DMM;
    }

    public int getFov() {
        return this.fov;
    }

    public Position getInitPosition() {
        return this.initPosition;
    }

    public Position getInitRotation() {
        return this.initRotation;
    }

    public CameraTransform getInitialCameraTransform() {
        return this.initialCameraTransform;
    }

    public ArrayList<String> getInputRenderTarget() {
        return this.inputRenderTarget;
    }

    public boolean getIsKapuMaterial() {
        return this.isKapuMaterial;
    }

    public int getKapuMaterialType() {
        return this.kapuMaterialType;
    }

    public String getMaterialPath() {
        return this.materialPath;
    }

    public Sticker3DMaterialType getMaterialType() {
        return this.materialType;
    }

    public int getModelType() {
        return this.modelType;
    }

    public boolean getNeedFaceMeshFacekit() {
        return this.needFaceMeshFacekit;
    }

    public float getProjectionFar() {
        return this.projectionFar;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public Position getRotationFactor() {
        return this.rotationFactor;
    }

    public String getTriggerJson() {
        return this.triggerJson;
    }

    public boolean getUse3DMMTransform() {
        return this.use3DMMTransform;
    }

    public boolean getUseMetal() {
        return this.useMetal;
    }

    public boolean getUseRealSizeHead() {
        return this.useRealSizeHead;
    }

    public void setCameraViewConfig(ArrayList<CameraViewConfig> arrayList) {
        this.cameraViewConfig = arrayList;
        reportPropertyChange("cameraViewConfig", arrayList);
    }

    public void setEnableTessellation(boolean z16) {
        this.enableTessellation = z16;
        reportPropertyChange("enableTessellation", Boolean.valueOf(z16));
    }

    public void setExternalInputKey(ArrayList<String> arrayList) {
        this.externalInputKey = arrayList;
        reportPropertyChange("externalInputKey", arrayList);
    }

    public void setFaceMeshModelType(int i3) {
        this.faceMeshModelType = i3;
        reportPropertyChange("faceMeshModelType", Integer.valueOf(i3));
    }

    public void setFit3DMM(boolean z16) {
        this.fit3DMM = z16;
        reportPropertyChange("fit3DMM", Boolean.valueOf(z16));
    }

    public void setFov(int i3) {
        this.fov = i3;
        reportPropertyChange("fov", Integer.valueOf(i3));
    }

    public void setInitPosition(Position position) {
        this.initPosition = position;
        reportPropertyChange("initPosition", position);
    }

    public void setInitRotation(Position position) {
        this.initRotation = position;
        reportPropertyChange("initRotation", position);
    }

    public void setInitialCameraTransform(CameraTransform cameraTransform) {
        this.initialCameraTransform = cameraTransform;
        reportPropertyChange("initialCameraTransform", cameraTransform);
    }

    public void setInputRenderTarget(ArrayList<String> arrayList) {
        this.inputRenderTarget = arrayList;
        reportPropertyChange("inputRenderTarget", arrayList);
    }

    public void setIsKapuMaterial(boolean z16) {
        this.isKapuMaterial = z16;
        reportPropertyChange("isKapuMaterial", Boolean.valueOf(z16));
    }

    public void setKapuMaterialType(int i3) {
        this.kapuMaterialType = i3;
        reportPropertyChange("kapuMaterialType", Integer.valueOf(i3));
    }

    public void setMaterialPath(String str) {
        this.materialPath = str;
        reportPropertyChange("materialPath", str);
    }

    public void setMaterialType(Sticker3DMaterialType sticker3DMaterialType) {
        this.materialType = sticker3DMaterialType;
        reportPropertyChange("materialType", sticker3DMaterialType);
    }

    public void setModelType(int i3) {
        this.modelType = i3;
        reportPropertyChange("modelType", Integer.valueOf(i3));
    }

    public void setNeedFaceMeshFacekit(boolean z16) {
        this.needFaceMeshFacekit = z16;
        reportPropertyChange("needFaceMeshFacekit", Boolean.valueOf(z16));
    }

    public void setProjectionFar(float f16) {
        this.projectionFar = f16;
        reportPropertyChange("projectionFar", Float.valueOf(f16));
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
        reportPropertyChange("resourcePath", str);
    }

    public void setRotationFactor(Position position) {
        this.rotationFactor = position;
        reportPropertyChange("rotationFactor", position);
    }

    public void setTriggerJson(String str) {
        this.triggerJson = str;
        reportPropertyChange("triggerJson", str);
    }

    public void setUse3DMMTransform(boolean z16) {
        this.use3DMMTransform = z16;
        reportPropertyChange("use3DMMTransform", Boolean.valueOf(z16));
    }

    public void setUseMetal(boolean z16) {
        this.useMetal = z16;
        reportPropertyChange("useMetal", Boolean.valueOf(z16));
    }

    public void setUseRealSizeHead(boolean z16) {
        this.useRealSizeHead = z16;
        reportPropertyChange("useRealSizeHead", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Sticker3D";
    }
}
