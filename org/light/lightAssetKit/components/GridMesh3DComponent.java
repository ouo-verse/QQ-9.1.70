package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GridMesh3DComponent extends Component {
    private int gridNum;
    private Vec3 eye = new Vec3();
    private Vec3 center = new Vec3();

    /* renamed from: up, reason: collision with root package name */
    private Vec3 f423813up = new Vec3();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof GridMesh3DComponent) {
            GridMesh3DComponent gridMesh3DComponent = (GridMesh3DComponent) componentBase;
            this.gridNum = gridMesh3DComponent.gridNum;
            this.eye = gridMesh3DComponent.eye;
            this.center = gridMesh3DComponent.center;
            this.f423813up = gridMesh3DComponent.f423813up;
        }
        super.doUpdate(componentBase);
    }

    public Vec3 getCenter() {
        return this.center;
    }

    public Vec3 getEye() {
        return this.eye;
    }

    public int getGridNum() {
        return this.gridNum;
    }

    public Vec3 getUp() {
        return this.f423813up;
    }

    public void setCenter(Vec3 vec3) {
        this.center = vec3;
        reportPropertyChange("center", vec3);
    }

    public void setEye(Vec3 vec3) {
        this.eye = vec3;
        reportPropertyChange("eye", vec3);
    }

    public void setGridNum(int i3) {
        this.gridNum = i3;
        reportPropertyChange("gridNum", Integer.valueOf(i3));
    }

    public void setUp(Vec3 vec3) {
        this.f423813up = vec3;
        reportPropertyChange("up", vec3);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "GridMesh3DComponent";
    }
}
