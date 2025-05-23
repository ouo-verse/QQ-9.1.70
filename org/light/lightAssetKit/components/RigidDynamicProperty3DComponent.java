package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* loaded from: classes29.dex */
public class RigidDynamicProperty3DComponent extends Component {
    private boolean independent_gravity_enabled_;
    private Vec3 independent_gravity_ = new Vec3();
    private Vec3 force_ = new Vec3();
    private Vec3 torque_ = new Vec3();
    private Vec3 linear_impulse_ = new Vec3();
    private Vec3 angular_impulse_ = new Vec3();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof RigidDynamicProperty3DComponent) {
            RigidDynamicProperty3DComponent rigidDynamicProperty3DComponent = (RigidDynamicProperty3DComponent) componentBase;
            this.independent_gravity_enabled_ = rigidDynamicProperty3DComponent.independent_gravity_enabled_;
            this.independent_gravity_ = rigidDynamicProperty3DComponent.independent_gravity_;
            this.force_ = rigidDynamicProperty3DComponent.force_;
            this.torque_ = rigidDynamicProperty3DComponent.torque_;
            this.linear_impulse_ = rigidDynamicProperty3DComponent.linear_impulse_;
            this.angular_impulse_ = rigidDynamicProperty3DComponent.angular_impulse_;
        }
        super.doUpdate(componentBase);
    }

    public Vec3 getAngular_impulse_() {
        return this.angular_impulse_;
    }

    public Vec3 getForce_() {
        return this.force_;
    }

    public Vec3 getIndependent_gravity_() {
        return this.independent_gravity_;
    }

    public boolean getIndependent_gravity_enabled_() {
        return this.independent_gravity_enabled_;
    }

    public Vec3 getLinear_impulse_() {
        return this.linear_impulse_;
    }

    public Vec3 getTorque_() {
        return this.torque_;
    }

    public void setAngular_impulse_(Vec3 vec3) {
        this.angular_impulse_ = vec3;
        reportPropertyChange("angular_impulse_", vec3);
    }

    public void setForce_(Vec3 vec3) {
        this.force_ = vec3;
        reportPropertyChange("force_", vec3);
    }

    public void setIndependent_gravity_(Vec3 vec3) {
        this.independent_gravity_ = vec3;
        reportPropertyChange("independent_gravity_", vec3);
    }

    public void setIndependent_gravity_enabled_(boolean z16) {
        this.independent_gravity_enabled_ = z16;
        reportPropertyChange("independent_gravity_enabled_", Boolean.valueOf(z16));
    }

    public void setLinear_impulse_(Vec3 vec3) {
        this.linear_impulse_ = vec3;
        reportPropertyChange("linear_impulse_", vec3);
    }

    public void setTorque_(Vec3 vec3) {
        this.torque_ = vec3;
        reportPropertyChange("torque_", vec3);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "RigidDynamicProperty3DComponent";
    }
}
