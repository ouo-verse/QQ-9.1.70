package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.fDrawFlags;

/* loaded from: classes29.dex */
public class PhysicsWorld3DComponent extends Component {
    private Vec3 gravity_ = new Vec3();
    private boolean detailed_configuration_enabled_ = false;
    private float physics_simulation_speed_ = 1.0f;
    private int internal_sub_step_ = 60;
    private boolean debug_draw_enabled_ = false;
    private int physics_world_debug_draw_mode_ = 0;
    private fDrawFlags soft_body_debug_draw_flag_ = fDrawFlags.Std;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof PhysicsWorld3DComponent) {
            PhysicsWorld3DComponent physicsWorld3DComponent = (PhysicsWorld3DComponent) componentBase;
            this.gravity_ = physicsWorld3DComponent.gravity_;
            this.detailed_configuration_enabled_ = physicsWorld3DComponent.detailed_configuration_enabled_;
            this.physics_simulation_speed_ = physicsWorld3DComponent.physics_simulation_speed_;
            this.internal_sub_step_ = physicsWorld3DComponent.internal_sub_step_;
            this.debug_draw_enabled_ = physicsWorld3DComponent.debug_draw_enabled_;
            this.physics_world_debug_draw_mode_ = physicsWorld3DComponent.physics_world_debug_draw_mode_;
            this.soft_body_debug_draw_flag_ = physicsWorld3DComponent.soft_body_debug_draw_flag_;
        }
        super.doUpdate(componentBase);
    }

    public boolean getDebug_draw_enabled_() {
        return this.debug_draw_enabled_;
    }

    public boolean getDetailed_configuration_enabled_() {
        return this.detailed_configuration_enabled_;
    }

    public Vec3 getGravity_() {
        return this.gravity_;
    }

    public int getInternal_sub_step_() {
        return this.internal_sub_step_;
    }

    public float getPhysics_simulation_speed_() {
        return this.physics_simulation_speed_;
    }

    public int getPhysics_world_debug_draw_mode_() {
        return this.physics_world_debug_draw_mode_;
    }

    public fDrawFlags getSoft_body_debug_draw_flag_() {
        return this.soft_body_debug_draw_flag_;
    }

    public void setDebug_draw_enabled_(boolean z16) {
        this.debug_draw_enabled_ = z16;
        reportPropertyChange("debug_draw_enabled_", Boolean.valueOf(z16));
    }

    public void setDetailed_configuration_enabled_(boolean z16) {
        this.detailed_configuration_enabled_ = z16;
        reportPropertyChange("detailed_configuration_enabled_", Boolean.valueOf(z16));
    }

    public void setGravity_(Vec3 vec3) {
        this.gravity_ = vec3;
        reportPropertyChange("gravity_", vec3);
    }

    public void setInternal_sub_step_(int i3) {
        this.internal_sub_step_ = i3;
        reportPropertyChange("internal_sub_step_", Integer.valueOf(i3));
    }

    public void setPhysics_simulation_speed_(float f16) {
        this.physics_simulation_speed_ = f16;
        reportPropertyChange("physics_simulation_speed_", Float.valueOf(f16));
    }

    public void setPhysics_world_debug_draw_mode_(int i3) {
        this.physics_world_debug_draw_mode_ = i3;
        reportPropertyChange("physics_world_debug_draw_mode_", Integer.valueOf(i3));
    }

    public void setSoft_body_debug_draw_flag_(fDrawFlags fdrawflags) {
        this.soft_body_debug_draw_flag_ = fdrawflags;
        reportPropertyChange("soft_body_debug_draw_flag_", fdrawflags);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "PhysicsWorld3DComponent";
    }
}
