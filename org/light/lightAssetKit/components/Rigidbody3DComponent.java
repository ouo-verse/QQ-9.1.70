package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Rigidbody3DComponent extends Component {
    private boolean is_dynamic_ = true;
    private float mass_ = 1.0f;
    private float friction_ = 0.0f;
    private float rolling_friction_ = 0.0f;
    private float restitution_ = 0.0f;
    private float linear_damping_ = 0.0f;
    private float angular_damping_ = 0.0f;
    private float ccd_motion_threshold_ = 1.0f;
    private int collision_filter_group_ = 1;
    private int collision_filter_mask_ = -1;
    private boolean emit_collision_event_ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Rigidbody3DComponent) {
            Rigidbody3DComponent rigidbody3DComponent = (Rigidbody3DComponent) componentBase;
            this.is_dynamic_ = rigidbody3DComponent.is_dynamic_;
            this.mass_ = rigidbody3DComponent.mass_;
            this.friction_ = rigidbody3DComponent.friction_;
            this.rolling_friction_ = rigidbody3DComponent.rolling_friction_;
            this.restitution_ = rigidbody3DComponent.restitution_;
            this.linear_damping_ = rigidbody3DComponent.linear_damping_;
            this.angular_damping_ = rigidbody3DComponent.angular_damping_;
            this.ccd_motion_threshold_ = rigidbody3DComponent.ccd_motion_threshold_;
            this.collision_filter_group_ = rigidbody3DComponent.collision_filter_group_;
            this.collision_filter_mask_ = rigidbody3DComponent.collision_filter_mask_;
            this.emit_collision_event_ = rigidbody3DComponent.emit_collision_event_;
        }
        super.doUpdate(componentBase);
    }

    public float getAngular_damping_() {
        return this.angular_damping_;
    }

    public float getCcd_motion_threshold_() {
        return this.ccd_motion_threshold_;
    }

    public int getCollision_filter_group_() {
        return this.collision_filter_group_;
    }

    public int getCollision_filter_mask_() {
        return this.collision_filter_mask_;
    }

    public boolean getEmit_collision_event_() {
        return this.emit_collision_event_;
    }

    public float getFriction_() {
        return this.friction_;
    }

    public boolean getIs_dynamic_() {
        return this.is_dynamic_;
    }

    public float getLinear_damping_() {
        return this.linear_damping_;
    }

    public float getMass_() {
        return this.mass_;
    }

    public float getRestitution_() {
        return this.restitution_;
    }

    public float getRolling_friction_() {
        return this.rolling_friction_;
    }

    public void setAngular_damping_(float f16) {
        this.angular_damping_ = f16;
        reportPropertyChange("angular_damping_", Float.valueOf(f16));
    }

    public void setCcd_motion_threshold_(float f16) {
        this.ccd_motion_threshold_ = f16;
        reportPropertyChange("ccd_motion_threshold_", Float.valueOf(f16));
    }

    public void setCollision_filter_group_(int i3) {
        this.collision_filter_group_ = i3;
        reportPropertyChange("collision_filter_group_", Integer.valueOf(i3));
    }

    public void setCollision_filter_mask_(int i3) {
        this.collision_filter_mask_ = i3;
        reportPropertyChange("collision_filter_mask_", Integer.valueOf(i3));
    }

    public void setEmit_collision_event_(boolean z16) {
        this.emit_collision_event_ = z16;
        reportPropertyChange("emit_collision_event_", Boolean.valueOf(z16));
    }

    public void setFriction_(float f16) {
        this.friction_ = f16;
        reportPropertyChange("friction_", Float.valueOf(f16));
    }

    public void setIs_dynamic_(boolean z16) {
        this.is_dynamic_ = z16;
        reportPropertyChange("is_dynamic_", Boolean.valueOf(z16));
    }

    public void setLinear_damping_(float f16) {
        this.linear_damping_ = f16;
        reportPropertyChange("linear_damping_", Float.valueOf(f16));
    }

    public void setMass_(float f16) {
        this.mass_ = f16;
        reportPropertyChange("mass_", Float.valueOf(f16));
    }

    public void setRestitution_(float f16) {
        this.restitution_ = f16;
        reportPropertyChange("restitution_", Float.valueOf(f16));
    }

    public void setRolling_friction_(float f16) {
        this.rolling_friction_ = f16;
        reportPropertyChange("rolling_friction_", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Rigidbody3DComponent";
    }
}
