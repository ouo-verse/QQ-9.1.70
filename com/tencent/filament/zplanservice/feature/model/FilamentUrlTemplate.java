package com.tencent.filament.zplanservice.feature.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b@\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010B\u001a\u00020\u0003H\u0016R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R\u0016\u0010\u001f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0016\u0010!\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R\u0016\u0010#\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0007R\u0016\u0010%\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0007R\u0016\u0010'\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0007R\u0016\u0010)\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007R\u0016\u0010+\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0007R\u0016\u0010-\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007R\u0016\u0010/\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0007R\u0016\u00101\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u0016\u00103\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0007R\u0016\u00105\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R\u0016\u00107\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0007R\u0016\u00109\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0007R\u0016\u0010;\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0007R\u001a\u0010=\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\u0004R\u0016\u0010@\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007\u00a8\u0006C"}, d2 = {"Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "", "version", "", "(Ljava/lang/String;)V", "animPathUrl", "getAnimPathUrl", "()Ljava/lang/String;", "avatarAdditionalJsonUrl", "getAvatarAdditionalJsonUrl", "avatarSuitJsonUrl", "getAvatarSuitJsonUrl", "backgroundPlane", "getBackgroundPlane", "backgroundPlaneTextures", "getBackgroundPlaneTextures", "bodyTypeUrl", "getBodyTypeUrl", "cdnUrlPrefix", "cdnVersion", "getCdnVersion", "colorConfigUrl", "getColorConfigUrl", "defaultTorsoUrl", "getDefaultTorsoUrl", "defaultTorsoUrlV2", "getDefaultTorsoUrlV2", "dressupUrl", "getDressupUrl", "fBodyAnimResUrl", "getFBodyAnimResUrl", "fEyelashResUrl", "getFEyelashResUrl", "fFaceAnimResUrl", "getFFaceAnimResUrl", "kawaiiConfig", "getKawaiiConfig", "lightAIBodyDriveRefPoseUrl", "getLightAIBodyDriveRefPoseUrl", "lightResUrl", "getLightResUrl", "lutResUrl", "getLutResUrl", "mBodyAnimResUrl", "getMBodyAnimResUrl", "mEyelashResUrl", "getMEyelashResUrl", "mFaceAnimResUrl", "getMFaceAnimResUrl", "makeupUrl", "getMakeupUrl", "makeupUrlV2", "getMakeupUrlV2", "materialSplitUrl", "getMaterialSplitUrl", "materialsUrl", "getMaterialsUrl", "particlePathUrl", "getParticlePathUrl", "pinchFaceConfigUrl", "getPinchFaceConfigUrl", "rawString", "getRawString", "setRawString", "recordStickDataBaseUrl", "getRecordStickDataBaseUrl", "toString", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentUrlTemplate {

    @SerializedName("anim_path_url")
    @NotNull
    private final String animPathUrl;

    @SerializedName("avatarAdditional_json_url")
    @NotNull
    private final String avatarAdditionalJsonUrl;

    @SerializedName("avatarSuit_json_url")
    @NotNull
    private final String avatarSuitJsonUrl;

    @SerializedName("background_plane")
    @NotNull
    private final String backgroundPlane;

    @SerializedName("background_plane_textures")
    @NotNull
    private final String backgroundPlaneTextures;

    @SerializedName("body_type_url")
    @NotNull
    private final String bodyTypeUrl;
    private final String cdnUrlPrefix;

    @SerializedName("cdn_version")
    @NotNull
    private final String cdnVersion;

    @SerializedName("color_config_url")
    @NotNull
    private final String colorConfigUrl;

    @SerializedName("default_torso_url")
    @NotNull
    private final String defaultTorsoUrl;

    @SerializedName("default_torso_v2_url")
    @NotNull
    private final String defaultTorsoUrlV2;

    @SerializedName("dressup_url")
    @NotNull
    private final String dressupUrl;

    @SerializedName("f_body_anim_res_url")
    @NotNull
    private final String fBodyAnimResUrl;

    @SerializedName("f_eyelash_res_url")
    @NotNull
    private final String fEyelashResUrl;

    @SerializedName("f_face_anim_res_url")
    @NotNull
    private final String fFaceAnimResUrl;

    @SerializedName("kawaii_config")
    @NotNull
    private final String kawaiiConfig;

    @SerializedName("light_ai_body_drive_ref_pose_url")
    @NotNull
    private final String lightAIBodyDriveRefPoseUrl;

    @SerializedName("light_res_url")
    @NotNull
    private final String lightResUrl;

    @SerializedName("lut_res_url")
    @NotNull
    private final String lutResUrl;

    @SerializedName("m_body_anim_res_url")
    @NotNull
    private final String mBodyAnimResUrl;

    @SerializedName("m_eyelash_res_url")
    @NotNull
    private final String mEyelashResUrl;

    @SerializedName("m_face_anim_res_url")
    @NotNull
    private final String mFaceAnimResUrl;

    @SerializedName("makeup_url")
    @NotNull
    private final String makeupUrl;

    @SerializedName("makeup_v2_url")
    @NotNull
    private final String makeupUrlV2;

    @SerializedName("materials_gl_v2_split_url")
    @NotNull
    private final String materialSplitUrl;

    @SerializedName("materials_gl_v2_url")
    @NotNull
    private final String materialsUrl;

    @SerializedName("particle_path_url")
    @NotNull
    private final String particlePathUrl;

    @SerializedName("pinch_face_config_v2_url")
    @NotNull
    private final String pinchFaceConfigUrl;

    @NotNull
    private String rawString;

    @SerializedName("record_stick_data_base_url")
    @NotNull
    private final String recordStickDataBaseUrl;

    public FilamentUrlTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final String getAnimPathUrl() {
        return this.animPathUrl;
    }

    @NotNull
    public final String getAvatarAdditionalJsonUrl() {
        return this.avatarAdditionalJsonUrl;
    }

    @NotNull
    public final String getAvatarSuitJsonUrl() {
        return this.avatarSuitJsonUrl;
    }

    @NotNull
    public final String getBackgroundPlane() {
        return this.backgroundPlane;
    }

    @NotNull
    public final String getBackgroundPlaneTextures() {
        return this.backgroundPlaneTextures;
    }

    @NotNull
    public final String getBodyTypeUrl() {
        return this.bodyTypeUrl;
    }

    @NotNull
    public final String getCdnVersion() {
        return this.cdnVersion;
    }

    @NotNull
    public final String getColorConfigUrl() {
        return this.colorConfigUrl;
    }

    @NotNull
    public final String getDefaultTorsoUrl() {
        return this.defaultTorsoUrl;
    }

    @NotNull
    public final String getDefaultTorsoUrlV2() {
        return this.defaultTorsoUrlV2;
    }

    @NotNull
    public final String getDressupUrl() {
        return this.dressupUrl;
    }

    @NotNull
    public final String getFBodyAnimResUrl() {
        return this.fBodyAnimResUrl;
    }

    @NotNull
    public final String getFEyelashResUrl() {
        return this.fEyelashResUrl;
    }

    @NotNull
    public final String getFFaceAnimResUrl() {
        return this.fFaceAnimResUrl;
    }

    @NotNull
    public final String getKawaiiConfig() {
        return this.kawaiiConfig;
    }

    @NotNull
    public final String getLightAIBodyDriveRefPoseUrl() {
        return this.lightAIBodyDriveRefPoseUrl;
    }

    @NotNull
    public final String getLightResUrl() {
        return this.lightResUrl;
    }

    @NotNull
    public final String getLutResUrl() {
        return this.lutResUrl;
    }

    @NotNull
    public final String getMBodyAnimResUrl() {
        return this.mBodyAnimResUrl;
    }

    @NotNull
    public final String getMEyelashResUrl() {
        return this.mEyelashResUrl;
    }

    @NotNull
    public final String getMFaceAnimResUrl() {
        return this.mFaceAnimResUrl;
    }

    @NotNull
    public final String getMakeupUrl() {
        return this.makeupUrl;
    }

    @NotNull
    public final String getMakeupUrlV2() {
        return this.makeupUrlV2;
    }

    @NotNull
    public final String getMaterialSplitUrl() {
        return this.materialSplitUrl;
    }

    @NotNull
    public final String getMaterialsUrl() {
        return this.materialsUrl;
    }

    @NotNull
    public final String getParticlePathUrl() {
        return this.particlePathUrl;
    }

    @NotNull
    public final String getPinchFaceConfigUrl() {
        return this.pinchFaceConfigUrl;
    }

    @NotNull
    public final String getRawString() {
        return this.rawString;
    }

    @NotNull
    public final String getRecordStickDataBaseUrl() {
        return this.recordStickDataBaseUrl;
    }

    public final void setRawString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rawString = str;
    }

    @NotNull
    public String toString() {
        boolean z16;
        if (this.rawString.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return this.rawString;
        }
        String json = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(this)");
        return json;
    }

    public FilamentUrlTemplate(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        this.rawString = "";
        String str = "https://zplan-lite.cdn-go.cn/resources/" + version + "/f/v1";
        this.cdnUrlPrefix = str;
        this.pinchFaceConfigUrl = str + "/default/face_config_v2.fasset";
        this.defaultTorsoUrl = str + "/default/avatarTorso/{filename}.fasset";
        this.defaultTorsoUrlV2 = str + "/default/avatarTorso_v2/{filename}.fasset";
        this.dressupUrl = str + "/model/{res_id}.fasset";
        this.makeupUrl = str + "/makeup/{res_id}.fasset";
        this.makeupUrlV2 = str + "/makeup_v2/{res_id}.fasset";
        this.fBodyAnimResUrl = str + "/anim/F/BODY/F_BODY_{action_id}_Anim.fasset";
        this.fFaceAnimResUrl = str + "/anim/F/FACE/F_FACE_{action_id}_Anim.fasset";
        this.mBodyAnimResUrl = str + "/anim/M/BODY/M_BODY_{action_id}_Anim.fasset";
        this.mFaceAnimResUrl = str + "/anim/M/FACE/M_FACE_{action_id}_Anim.fasset";
        this.lightResUrl = str + "/default/envs/default_env.fasset";
        this.mEyelashResUrl = str + "/default/eyelash/SK_CH_M_Eyelash.fasset";
        this.fEyelashResUrl = str + "/default/eyelash/SK_CH_F_Eyelash.fasset";
        this.materialsUrl = str + "/filamat/opengl/mobile/shaders_v2.fasset";
        this.materialSplitUrl = str + "/filamat/opengl/mobile/shaders_v2_split/{file_name}.fasset";
        this.kawaiiConfig = str + "/default/kawaii_config.fasset";
        this.lightAIBodyDriveRefPoseUrl = str + "/default/light_ai_body_drive_ref_pose.fasset";
        this.avatarSuitJsonUrl = str + "/default/avatar_suit.lite.json";
        this.avatarAdditionalJsonUrl = str + "/default/avatar_additional.lite.json";
        this.colorConfigUrl = str + "/default/color_config.fasset";
        this.animPathUrl = str + "/{action_path}.fasset";
        this.bodyTypeUrl = str + "/default/bodyType/{res_name}.fasset";
        this.lutResUrl = str + "/default/envs/lut_res.fasset";
        this.backgroundPlane = str + "/BackgroundPlane.fasset";
        this.backgroundPlaneTextures = str + "/{texture_path}.fasset";
        this.recordStickDataBaseUrl = str + '/';
        this.particlePathUrl = str + "/{particle_path}.fasset";
        this.cdnVersion = version;
    }

    public /* synthetic */ FilamentUrlTemplate(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "2" : str);
    }
}
