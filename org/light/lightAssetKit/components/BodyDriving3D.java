package org.light.lightAssetKit.components;

import java.util.HashMap;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.HeadRotationType;
import org.light.lightAssetKit.enums.ModelMoveType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BodyDriving3D extends Component {
    private boolean enableBlockByBody;
    private boolean enableTranslateXY;
    private boolean enableTranslateZ;
    private int groundPlaneEntityId;
    private String halfBodyMode = "FullBodyMode";
    private boolean enableHandMode = false;
    private HashMap<String, Boolean> trackingBones = new HashMap<>();
    private ModelMoveType modelMoveType = ModelMoveType.FollowUser;
    private HeadRotationType headRotationType = HeadRotationType.kHeadRotationTypeBody3D;
    private Vec3 offsetXYZ = new Vec3(0.0f, 0.0f, 0.0f);
    private boolean enableContactGround = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof BodyDriving3D) {
            BodyDriving3D bodyDriving3D = (BodyDriving3D) componentBase;
            this.halfBodyMode = bodyDriving3D.halfBodyMode;
            this.enableHandMode = bodyDriving3D.enableHandMode;
            this.trackingBones = bodyDriving3D.trackingBones;
            this.modelMoveType = bodyDriving3D.modelMoveType;
            this.headRotationType = bodyDriving3D.headRotationType;
            this.offsetXYZ = bodyDriving3D.offsetXYZ;
            this.enableTranslateXY = bodyDriving3D.enableTranslateXY;
            this.enableTranslateZ = bodyDriving3D.enableTranslateZ;
            this.enableBlockByBody = bodyDriving3D.enableBlockByBody;
            this.enableContactGround = bodyDriving3D.enableContactGround;
            this.groundPlaneEntityId = bodyDriving3D.groundPlaneEntityId;
        }
        super.doUpdate(componentBase);
    }

    public boolean getEnableBlockByBody() {
        return this.enableBlockByBody;
    }

    public boolean getEnableContactGround() {
        return this.enableContactGround;
    }

    public boolean getEnableHandMode() {
        return this.enableHandMode;
    }

    public boolean getEnableTranslateXY() {
        return this.enableTranslateXY;
    }

    public boolean getEnableTranslateZ() {
        return this.enableTranslateZ;
    }

    public int getGroundPlaneEntityId() {
        return this.groundPlaneEntityId;
    }

    public String getHalfBodyMode() {
        return this.halfBodyMode;
    }

    public HeadRotationType getHeadRotationType() {
        return this.headRotationType;
    }

    public ModelMoveType getModelMoveType() {
        return this.modelMoveType;
    }

    public Vec3 getOffsetXYZ() {
        return this.offsetXYZ;
    }

    public HashMap<String, Boolean> getTrackingBones() {
        return this.trackingBones;
    }

    public void setEnableBlockByBody(boolean z16) {
        this.enableBlockByBody = z16;
        reportPropertyChange("enableBlockByBody", Boolean.valueOf(z16));
    }

    public void setEnableContactGround(boolean z16) {
        this.enableContactGround = z16;
        reportPropertyChange("enableContactGround", Boolean.valueOf(z16));
    }

    public void setEnableHandMode(boolean z16) {
        this.enableHandMode = z16;
        reportPropertyChange("enableHandMode", Boolean.valueOf(z16));
    }

    public void setEnableTranslateXY(boolean z16) {
        this.enableTranslateXY = z16;
        reportPropertyChange("enableTranslateXY", Boolean.valueOf(z16));
    }

    public void setEnableTranslateZ(boolean z16) {
        this.enableTranslateZ = z16;
        reportPropertyChange("enableTranslateZ", Boolean.valueOf(z16));
    }

    public void setGroundPlaneEntityId(int i3) {
        this.groundPlaneEntityId = i3;
        reportPropertyChange("groundPlaneEntityId", Integer.valueOf(i3));
    }

    public void setHalfBodyMode(String str) {
        this.halfBodyMode = str;
        reportPropertyChange("halfBodyMode", str);
    }

    public void setHeadRotationType(HeadRotationType headRotationType) {
        this.headRotationType = headRotationType;
        reportPropertyChange("headRotationType", headRotationType);
    }

    public void setModelMoveType(ModelMoveType modelMoveType) {
        this.modelMoveType = modelMoveType;
        reportPropertyChange("modelMoveType", modelMoveType);
    }

    public void setOffsetXYZ(Vec3 vec3) {
        this.offsetXYZ = vec3;
        reportPropertyChange("offsetXYZ", vec3);
    }

    public void setTrackingBones(HashMap<String, Boolean> hashMap) {
        this.trackingBones = hashMap;
        reportPropertyChange("trackingBones", hashMap);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "BodyDriving3D";
    }
}
