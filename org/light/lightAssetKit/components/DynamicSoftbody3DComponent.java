package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.kSoftbodyAeroMode;
import org.light.lightAssetKit.enums.kSoftbodyCollisionMode;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DynamicSoftbody3DComponent extends Component {
    private float total_mass_ = 1.0f;
    private int cfg_blend_constraint_strength_ = 0;
    private float cfg_material_linear_stiffness_ = 1.0f;
    private float cfg_linear_damping_ = 0.0f;
    private float cfg_dynamic_friction_ = 0.2f;
    private float cfg_pressure_ = 0.0f;
    private int velocity_solver_iterations_ = 0;
    private int position_solver_iterations_ = 1;
    private boolean aero_mode_enabled_ = false;
    private kSoftbodyAeroMode aero_mode_ = kSoftbodyAeroMode.FlagMode;
    private Vec3 wind_velocity_ = new Vec3(0.0f, 0.0f, 0.0f);
    private float cfg_drag_coefficient_ = 0.0f;
    private float cfg_lift_coefficient_ = 0.0f;
    private boolean anchor_enabled_ = false;
    private ArrayList<SoftAnchorData> anchor_lists_ = new ArrayList<>();
    private boolean collision_filter_enabled_ = false;
    private kSoftbodyCollisionMode collision_mode_ = kSoftbodyCollisionMode.SoftWithRigid;
    private float collision_margin_ = 0.01f;
    private ArrayList<Integer> no_collision_objects_ids_ = new ArrayList<>();
    private boolean enable_point_fuse_ = false;
    private int collision_filter_group_ = 1;
    private int collision_filter_mask_ = -1;
    private boolean emit_collision_event_ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof DynamicSoftbody3DComponent) {
            DynamicSoftbody3DComponent dynamicSoftbody3DComponent = (DynamicSoftbody3DComponent) componentBase;
            this.total_mass_ = dynamicSoftbody3DComponent.total_mass_;
            this.cfg_blend_constraint_strength_ = dynamicSoftbody3DComponent.cfg_blend_constraint_strength_;
            this.cfg_material_linear_stiffness_ = dynamicSoftbody3DComponent.cfg_material_linear_stiffness_;
            this.cfg_linear_damping_ = dynamicSoftbody3DComponent.cfg_linear_damping_;
            this.cfg_dynamic_friction_ = dynamicSoftbody3DComponent.cfg_dynamic_friction_;
            this.cfg_pressure_ = dynamicSoftbody3DComponent.cfg_pressure_;
            this.velocity_solver_iterations_ = dynamicSoftbody3DComponent.velocity_solver_iterations_;
            this.position_solver_iterations_ = dynamicSoftbody3DComponent.position_solver_iterations_;
            this.aero_mode_enabled_ = dynamicSoftbody3DComponent.aero_mode_enabled_;
            this.aero_mode_ = dynamicSoftbody3DComponent.aero_mode_;
            this.wind_velocity_ = dynamicSoftbody3DComponent.wind_velocity_;
            this.cfg_drag_coefficient_ = dynamicSoftbody3DComponent.cfg_drag_coefficient_;
            this.cfg_lift_coefficient_ = dynamicSoftbody3DComponent.cfg_lift_coefficient_;
            this.anchor_enabled_ = dynamicSoftbody3DComponent.anchor_enabled_;
            this.anchor_lists_ = dynamicSoftbody3DComponent.anchor_lists_;
            this.collision_filter_enabled_ = dynamicSoftbody3DComponent.collision_filter_enabled_;
            this.collision_mode_ = dynamicSoftbody3DComponent.collision_mode_;
            this.collision_margin_ = dynamicSoftbody3DComponent.collision_margin_;
            this.no_collision_objects_ids_ = dynamicSoftbody3DComponent.no_collision_objects_ids_;
            this.enable_point_fuse_ = dynamicSoftbody3DComponent.enable_point_fuse_;
            this.collision_filter_group_ = dynamicSoftbody3DComponent.collision_filter_group_;
            this.collision_filter_mask_ = dynamicSoftbody3DComponent.collision_filter_mask_;
            this.emit_collision_event_ = dynamicSoftbody3DComponent.emit_collision_event_;
        }
        super.doUpdate(componentBase);
    }

    public kSoftbodyAeroMode getAero_mode_() {
        return this.aero_mode_;
    }

    public boolean getAero_mode_enabled_() {
        return this.aero_mode_enabled_;
    }

    public boolean getAnchor_enabled_() {
        return this.anchor_enabled_;
    }

    public ArrayList<SoftAnchorData> getAnchor_lists_() {
        return this.anchor_lists_;
    }

    public int getCfg_blend_constraint_strength_() {
        return this.cfg_blend_constraint_strength_;
    }

    public float getCfg_drag_coefficient_() {
        return this.cfg_drag_coefficient_;
    }

    public float getCfg_dynamic_friction_() {
        return this.cfg_dynamic_friction_;
    }

    public float getCfg_lift_coefficient_() {
        return this.cfg_lift_coefficient_;
    }

    public float getCfg_linear_damping_() {
        return this.cfg_linear_damping_;
    }

    public float getCfg_material_linear_stiffness_() {
        return this.cfg_material_linear_stiffness_;
    }

    public float getCfg_pressure_() {
        return this.cfg_pressure_;
    }

    public boolean getCollision_filter_enabled_() {
        return this.collision_filter_enabled_;
    }

    public int getCollision_filter_group_() {
        return this.collision_filter_group_;
    }

    public int getCollision_filter_mask_() {
        return this.collision_filter_mask_;
    }

    public float getCollision_margin_() {
        return this.collision_margin_;
    }

    public kSoftbodyCollisionMode getCollision_mode_() {
        return this.collision_mode_;
    }

    public boolean getEmit_collision_event_() {
        return this.emit_collision_event_;
    }

    public boolean getEnable_point_fuse_() {
        return this.enable_point_fuse_;
    }

    public ArrayList<Integer> getNo_collision_objects_ids_() {
        return this.no_collision_objects_ids_;
    }

    public int getPosition_solver_iterations_() {
        return this.position_solver_iterations_;
    }

    public float getTotal_mass_() {
        return this.total_mass_;
    }

    public int getVelocity_solver_iterations_() {
        return this.velocity_solver_iterations_;
    }

    public Vec3 getWind_velocity_() {
        return this.wind_velocity_;
    }

    public void setAero_mode_(kSoftbodyAeroMode ksoftbodyaeromode) {
        this.aero_mode_ = ksoftbodyaeromode;
        reportPropertyChange("aero_mode_", ksoftbodyaeromode);
    }

    public void setAero_mode_enabled_(boolean z16) {
        this.aero_mode_enabled_ = z16;
        reportPropertyChange("aero_mode_enabled_", Boolean.valueOf(z16));
    }

    public void setAnchor_enabled_(boolean z16) {
        this.anchor_enabled_ = z16;
        reportPropertyChange("anchor_enabled_", Boolean.valueOf(z16));
    }

    public void setAnchor_lists_(ArrayList<SoftAnchorData> arrayList) {
        this.anchor_lists_ = arrayList;
        reportPropertyChange("anchor_lists_", arrayList);
    }

    public void setCfg_blend_constraint_strength_(int i3) {
        this.cfg_blend_constraint_strength_ = i3;
        reportPropertyChange("cfg_blend_constraint_strength_", Integer.valueOf(i3));
    }

    public void setCfg_drag_coefficient_(float f16) {
        this.cfg_drag_coefficient_ = f16;
        reportPropertyChange("cfg_drag_coefficient_", Float.valueOf(f16));
    }

    public void setCfg_dynamic_friction_(float f16) {
        this.cfg_dynamic_friction_ = f16;
        reportPropertyChange("cfg_dynamic_friction_", Float.valueOf(f16));
    }

    public void setCfg_lift_coefficient_(float f16) {
        this.cfg_lift_coefficient_ = f16;
        reportPropertyChange("cfg_lift_coefficient_", Float.valueOf(f16));
    }

    public void setCfg_linear_damping_(float f16) {
        this.cfg_linear_damping_ = f16;
        reportPropertyChange("cfg_linear_damping_", Float.valueOf(f16));
    }

    public void setCfg_material_linear_stiffness_(float f16) {
        this.cfg_material_linear_stiffness_ = f16;
        reportPropertyChange("cfg_material_linear_stiffness_", Float.valueOf(f16));
    }

    public void setCfg_pressure_(float f16) {
        this.cfg_pressure_ = f16;
        reportPropertyChange("cfg_pressure_", Float.valueOf(f16));
    }

    public void setCollision_filter_enabled_(boolean z16) {
        this.collision_filter_enabled_ = z16;
        reportPropertyChange("collision_filter_enabled_", Boolean.valueOf(z16));
    }

    public void setCollision_filter_group_(int i3) {
        this.collision_filter_group_ = i3;
        reportPropertyChange("collision_filter_group_", Integer.valueOf(i3));
    }

    public void setCollision_filter_mask_(int i3) {
        this.collision_filter_mask_ = i3;
        reportPropertyChange("collision_filter_mask_", Integer.valueOf(i3));
    }

    public void setCollision_margin_(float f16) {
        this.collision_margin_ = f16;
        reportPropertyChange("collision_margin_", Float.valueOf(f16));
    }

    public void setCollision_mode_(kSoftbodyCollisionMode ksoftbodycollisionmode) {
        this.collision_mode_ = ksoftbodycollisionmode;
        reportPropertyChange("collision_mode_", ksoftbodycollisionmode);
    }

    public void setEmit_collision_event_(boolean z16) {
        this.emit_collision_event_ = z16;
        reportPropertyChange("emit_collision_event_", Boolean.valueOf(z16));
    }

    public void setEnable_point_fuse_(boolean z16) {
        this.enable_point_fuse_ = z16;
        reportPropertyChange("enable_point_fuse_", Boolean.valueOf(z16));
    }

    public void setNo_collision_objects_ids_(ArrayList<Integer> arrayList) {
        this.no_collision_objects_ids_ = arrayList;
        reportPropertyChange("no_collision_objects_ids_", arrayList);
    }

    public void setPosition_solver_iterations_(int i3) {
        this.position_solver_iterations_ = i3;
        reportPropertyChange("position_solver_iterations_", Integer.valueOf(i3));
    }

    public void setTotal_mass_(float f16) {
        this.total_mass_ = f16;
        reportPropertyChange("total_mass_", Float.valueOf(f16));
    }

    public void setVelocity_solver_iterations_(int i3) {
        this.velocity_solver_iterations_ = i3;
        reportPropertyChange("velocity_solver_iterations_", Integer.valueOf(i3));
    }

    public void setWind_velocity_(Vec3 vec3) {
        this.wind_velocity_ = vec3;
        reportPropertyChange("wind_velocity_", vec3);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "DynamicSoftbody3DComponent";
    }
}
