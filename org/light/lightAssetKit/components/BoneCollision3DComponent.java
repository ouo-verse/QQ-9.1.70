package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BoneCollision3DComponent extends Component {
    private ArrayList<BoneCollisionObj> collision_objs = new ArrayList<>();
    private ArrayList<ArrayList<String>> bone_constraints = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof BoneCollision3DComponent) {
            BoneCollision3DComponent boneCollision3DComponent = (BoneCollision3DComponent) componentBase;
            this.collision_objs = boneCollision3DComponent.collision_objs;
            this.bone_constraints = boneCollision3DComponent.bone_constraints;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<ArrayList<String>> getBone_constraints() {
        return this.bone_constraints;
    }

    public ArrayList<BoneCollisionObj> getCollision_objs() {
        return this.collision_objs;
    }

    public void setBone_constraints(ArrayList<ArrayList<String>> arrayList) {
        this.bone_constraints = arrayList;
        reportPropertyChange("bone_constraints", arrayList);
    }

    public void setCollision_objs(ArrayList<BoneCollisionObj> arrayList) {
        this.collision_objs = arrayList;
        reportPropertyChange("collision_objs", arrayList);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "BoneCollision3DComponent";
    }
}
