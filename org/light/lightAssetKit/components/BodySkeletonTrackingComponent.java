package org.light.lightAssetKit.components;

import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BodySkeletonTrackingComponent extends Component {
    private String config_file = "KEY_0.config.pr";
    private String smpl_model_file = "spider_n_qs.bin";
    private float slim_waist_mesh = 1.0f;
    private float long_leg_mesh = 1.0f;
    private float slim_arm_mesh = 1.0f;
    private float slim_leg_mesh = 1.0f;
    private float slim_waist = 1.0f;
    private float long_leg = 1.0f;
    private float slim_arm = 1.0f;
    private float slim_leg = 1.0f;
    private String maskResource = "";
    private String renderTarget = "";
    private String fireRenderTarget = "";
    private boolean enable_cut_body_index = true;
    private float x_offset_scale = 20.0f;
    private float y_offset_scale = 20.0f;
    private boolean use_gpu_inpainting = true;
    private float render_type = 0.0f;
    private boolean use_head_alg = true;
    private int queue_size = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof BodySkeletonTrackingComponent) {
            BodySkeletonTrackingComponent bodySkeletonTrackingComponent = (BodySkeletonTrackingComponent) componentBase;
            this.config_file = bodySkeletonTrackingComponent.config_file;
            this.smpl_model_file = bodySkeletonTrackingComponent.smpl_model_file;
            this.slim_waist_mesh = bodySkeletonTrackingComponent.slim_waist_mesh;
            this.long_leg_mesh = bodySkeletonTrackingComponent.long_leg_mesh;
            this.slim_arm_mesh = bodySkeletonTrackingComponent.slim_arm_mesh;
            this.slim_leg_mesh = bodySkeletonTrackingComponent.slim_leg_mesh;
            this.slim_waist = bodySkeletonTrackingComponent.slim_waist;
            this.long_leg = bodySkeletonTrackingComponent.long_leg;
            this.slim_arm = bodySkeletonTrackingComponent.slim_arm;
            this.slim_leg = bodySkeletonTrackingComponent.slim_leg;
            this.maskResource = bodySkeletonTrackingComponent.maskResource;
            this.renderTarget = bodySkeletonTrackingComponent.renderTarget;
            this.fireRenderTarget = bodySkeletonTrackingComponent.fireRenderTarget;
            this.enable_cut_body_index = bodySkeletonTrackingComponent.enable_cut_body_index;
            this.x_offset_scale = bodySkeletonTrackingComponent.x_offset_scale;
            this.y_offset_scale = bodySkeletonTrackingComponent.y_offset_scale;
            this.use_gpu_inpainting = bodySkeletonTrackingComponent.use_gpu_inpainting;
            this.render_type = bodySkeletonTrackingComponent.render_type;
            this.use_head_alg = bodySkeletonTrackingComponent.use_head_alg;
            this.queue_size = bodySkeletonTrackingComponent.queue_size;
        }
        super.doUpdate(componentBase);
    }

    public String getConfig_file() {
        return this.config_file;
    }

    public boolean getEnable_cut_body_index() {
        return this.enable_cut_body_index;
    }

    public String getFireRenderTarget() {
        return this.fireRenderTarget;
    }

    public float getLong_leg() {
        return this.long_leg;
    }

    public float getLong_leg_mesh() {
        return this.long_leg_mesh;
    }

    public String getMaskResource() {
        return this.maskResource;
    }

    public int getQueue_size() {
        return this.queue_size;
    }

    public String getRenderTarget() {
        return this.renderTarget;
    }

    public float getRender_type() {
        return this.render_type;
    }

    public float getSlim_arm() {
        return this.slim_arm;
    }

    public float getSlim_arm_mesh() {
        return this.slim_arm_mesh;
    }

    public float getSlim_leg() {
        return this.slim_leg;
    }

    public float getSlim_leg_mesh() {
        return this.slim_leg_mesh;
    }

    public float getSlim_waist() {
        return this.slim_waist;
    }

    public float getSlim_waist_mesh() {
        return this.slim_waist_mesh;
    }

    public String getSmpl_model_file() {
        return this.smpl_model_file;
    }

    public boolean getUse_gpu_inpainting() {
        return this.use_gpu_inpainting;
    }

    public boolean getUse_head_alg() {
        return this.use_head_alg;
    }

    public float getX_offset_scale() {
        return this.x_offset_scale;
    }

    public float getY_offset_scale() {
        return this.y_offset_scale;
    }

    public void setConfig_file(String str) {
        this.config_file = str;
        reportPropertyChange("config_file", str);
    }

    public void setEnable_cut_body_index(boolean z16) {
        this.enable_cut_body_index = z16;
        reportPropertyChange("enable_cut_body_index", Boolean.valueOf(z16));
    }

    public void setFireRenderTarget(String str) {
        this.fireRenderTarget = str;
        reportPropertyChange("fireRenderTarget", str);
    }

    public void setLong_leg(float f16) {
        this.long_leg = f16;
        reportPropertyChange("long_leg", Float.valueOf(f16));
    }

    public void setLong_leg_mesh(float f16) {
        this.long_leg_mesh = f16;
        reportPropertyChange("long_leg_mesh", Float.valueOf(f16));
    }

    public void setMaskResource(String str) {
        this.maskResource = str;
        reportPropertyChange("maskResource", str);
    }

    public void setQueue_size(int i3) {
        this.queue_size = i3;
        reportPropertyChange("queue_size", Integer.valueOf(i3));
    }

    public void setRenderTarget(String str) {
        this.renderTarget = str;
        reportPropertyChange("renderTarget", str);
    }

    public void setRender_type(float f16) {
        this.render_type = f16;
        reportPropertyChange(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, Float.valueOf(f16));
    }

    public void setSlim_arm(float f16) {
        this.slim_arm = f16;
        reportPropertyChange("slim_arm", Float.valueOf(f16));
    }

    public void setSlim_arm_mesh(float f16) {
        this.slim_arm_mesh = f16;
        reportPropertyChange("slim_arm_mesh", Float.valueOf(f16));
    }

    public void setSlim_leg(float f16) {
        this.slim_leg = f16;
        reportPropertyChange("slim_leg", Float.valueOf(f16));
    }

    public void setSlim_leg_mesh(float f16) {
        this.slim_leg_mesh = f16;
        reportPropertyChange("slim_leg_mesh", Float.valueOf(f16));
    }

    public void setSlim_waist(float f16) {
        this.slim_waist = f16;
        reportPropertyChange("slim_waist", Float.valueOf(f16));
    }

    public void setSlim_waist_mesh(float f16) {
        this.slim_waist_mesh = f16;
        reportPropertyChange("slim_waist_mesh", Float.valueOf(f16));
    }

    public void setSmpl_model_file(String str) {
        this.smpl_model_file = str;
        reportPropertyChange("smpl_model_file", str);
    }

    public void setUse_gpu_inpainting(boolean z16) {
        this.use_gpu_inpainting = z16;
        reportPropertyChange("use_gpu_inpainting", Boolean.valueOf(z16));
    }

    public void setUse_head_alg(boolean z16) {
        this.use_head_alg = z16;
        reportPropertyChange("use_head_alg", Boolean.valueOf(z16));
    }

    public void setX_offset_scale(float f16) {
        this.x_offset_scale = f16;
        reportPropertyChange("x_offset_scale", Float.valueOf(f16));
    }

    public void setY_offset_scale(float f16) {
        this.y_offset_scale = f16;
        reportPropertyChange("y_offset_scale", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "BodySkeletonTrackingComponent";
    }
}
