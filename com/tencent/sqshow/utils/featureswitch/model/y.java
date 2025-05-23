package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b#\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b#\u0010$R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\u00a8\u0006%"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/y;", "", "", "dressUpUrlTemplate", "Ljava/lang/String;", "getDressUpUrlTemplate", "()Ljava/lang/String;", "defaultTorsoUrlTemplate", "getDefaultTorsoUrlTemplate", "defaultLightFileUrl", "getDefaultLightFileUrl", "pinchFaceConfigUrl", "getPinchFaceConfigUrl", "femaleBodyAnimationUrlTemplate", "getFemaleBodyAnimationUrlTemplate", "maleBodyAnimationUrlTemplate", "getMaleBodyAnimationUrlTemplate", "femaleFaceAnimationUrlTemplate", "getFemaleFaceAnimationUrlTemplate", "maleFaceAnimationUrlTemplate", "getMaleFaceAnimationUrlTemplate", "maleEyelashUrl", "getMaleEyelashUrl", "femaleEyelashUrl", "getFemaleEyelashUrl", "makeupUrlTemplate", "getMakeupUrlTemplate", "cdnVersion", "a", "materialsUrl", "getMaterialsUrl", "lutUrl", "getLutUrl", "physicUrl", "getPhysicUrl", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class y {

    @SerializedName("dressup_url")
    private final String dressUpUrlTemplate = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/model/{res_id}.fasset";

    @SerializedName("default_torso_url")
    private final String defaultTorsoUrlTemplate = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/default/avatarTorso/{filename}.fasset";

    @SerializedName("light_res_url")
    private final String defaultLightFileUrl = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/default/envs/default_env.fasset";

    @SerializedName("pinch_face_config_v2_url")
    private final String pinchFaceConfigUrl = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/default/face_config_v2.fasset";

    @SerializedName("f_body_anim_res_url")
    private final String femaleBodyAnimationUrlTemplate = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/anim/F/BODY/F_BODY_{action_id}_Anim.fasset";

    @SerializedName("m_body_anim_res_url")
    private final String maleBodyAnimationUrlTemplate = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/anim/M/BODY/M_BODY_{action_id}_Anim.fasset";

    @SerializedName("f_face_anim_res_url")
    private final String femaleFaceAnimationUrlTemplate = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/anim/F/FACE/F_FACE_{action_id}_Anim.fasset";

    @SerializedName("m_face_anim_res_url")
    private final String maleFaceAnimationUrlTemplate = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/anim/M/FACE/M_FACE_{action_id}_Anim.fasset";

    @SerializedName("m_eyelash_res_url")
    private final String maleEyelashUrl = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/default/eyelash/SK_CH_M_Eyelash.fasset";

    @SerializedName("f_eyelash_res_url")
    private final String femaleEyelashUrl = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/default/eyelash/SK_CH_F_Eyelash.fasset";

    @SerializedName("makeup_url")
    private final String makeupUrlTemplate = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/makeup/{res_id}.fasset";

    @SerializedName("cdn_version")
    private final String cdnVersion = "v1.5.2";

    @SerializedName("materials_gl_v2_url")
    private final String materialsUrl = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/filamat/opengl/mobile/shaders.fasset";

    @SerializedName("lut_texture")
    private final String lutUrl = "";

    @SerializedName("kawaii_config")
    private final String physicUrl = "https://zplan-lite.cdn-go.cn/resources/v1.5.2/f/v1/default/kawaii_config.fasset";

    /* renamed from: a, reason: from getter */
    public final String getCdnVersion() {
        return this.cdnVersion;
    }
}
