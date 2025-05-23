package com.tencent.qcircle.weishi.module.publisher.data;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.light.LightAsset;

/* loaded from: classes22.dex */
public class AbilityPresetData {
    public static final String KEY_AI_BODY = "ai.body";
    public static final String KEY_AI_CAT_FACE = "ai.catFace";
    public static final String KEY_AI_EXPRESSION = "ai.expression";
    public static final String KEY_AI_FACE = "ai.face";
    public static final String KEY_AI_FACE_3D = "ai.face3d";
    public static final String KEY_AI_GAN = "ai.gan";
    public static final String KEY_AI_GENDER = "ai.gender";
    public static final String KEY_AI_RGB_DEPTH = "ai.rgbDepth";
    public static final String KEY_AI_SEGMENT = "ai.segment";
    public static final String KEY_AI_SEGMENT_HAIR = "ai.segmentHair";
    public static final String KEY_AI_SEGMENT_HAND = "ai.hand";
    public static final String KEY_AI_SEGMENT_SKY = "ai.segmentSky";
    public static final String KEY_MATERIAL_BEAUTY_BODY = "material.beautyBody";
    public static final String KEY_MATERIAL_DEPTH_TYPE = "material.depthType";
    public static final String KEY_MATERIAL_FILTER_CONFIG = "material.filterConfig";
    public static final String KEY_MATERIAL_MASK_PAINT = "material.maskPaint";
    public static final String KEY_MATERIAL_PAG = "material.pag";
    public static final String KEY_MATERIAL_PARTICLE = "material.particle";
    public static final String KEY_MATERIAL_STICKER_3D = "material.sticker3d";
    public static final String KEY_MATERIAL_TOUCH = "material.touch";
    private Map<String, Boolean> mAiParams = new HashMap();

    public AbilityPresetData(@Nullable LightAsset lightAsset) {
        parseData(lightAsset);
    }

    private void parseData(@Nullable LightAsset lightAsset) {
        if (lightAsset == null) {
            return;
        }
        this.mAiParams.put("ai.face", Boolean.valueOf(lightAsset.needRenderAbility("ai.face")));
        this.mAiParams.put("ai.body", Boolean.valueOf(lightAsset.needRenderAbility("ai.body")));
        this.mAiParams.put("ai.segment", Boolean.valueOf(lightAsset.needRenderAbility("ai.segment")));
        this.mAiParams.put("ai.segmentSky", Boolean.valueOf(lightAsset.needRenderAbility("ai.segmentSky")));
        this.mAiParams.put("ai.segmentHair", Boolean.valueOf(lightAsset.needRenderAbility("ai.segmentHair")));
        this.mAiParams.put("ai.hand", Boolean.valueOf(lightAsset.needRenderAbility("ai.hand")));
        this.mAiParams.put("ai.face3d", Boolean.valueOf(lightAsset.needRenderAbility("ai.face3d")));
        this.mAiParams.put("ai.catFace", Boolean.valueOf(lightAsset.needRenderAbility("ai.catFace")));
        this.mAiParams.put("ai.gender", Boolean.valueOf(lightAsset.needRenderAbility("ai.gender")));
        this.mAiParams.put("ai.rgbDepth", Boolean.valueOf(lightAsset.needRenderAbility("ai.rgbDepth")));
        this.mAiParams.put("ai.gan", Boolean.valueOf(lightAsset.needRenderAbility("ai.gan")));
        this.mAiParams.put("ai.expression", Boolean.valueOf(lightAsset.needRenderAbility("ai.expression")));
        this.mAiParams.put("material.beautyBody", Boolean.valueOf(lightAsset.needRenderAbility("material.beautyBody")));
        this.mAiParams.put("material.depthType", Boolean.valueOf(lightAsset.needRenderAbility("material.depthType")));
        this.mAiParams.put("material.touch", Boolean.valueOf(lightAsset.needRenderAbility("material.touch")));
        this.mAiParams.put("material.pag", Boolean.valueOf(lightAsset.needRenderAbility("material.pag")));
        this.mAiParams.put("material.particle", Boolean.valueOf(lightAsset.needRenderAbility("material.particle")));
        this.mAiParams.put("material.maskPaint", Boolean.valueOf(lightAsset.needRenderAbility("material.maskPaint")));
        this.mAiParams.put("material.sticker3d", Boolean.valueOf(lightAsset.needRenderAbility("material.sticker3d")));
        this.mAiParams.put("material.filterConfig", Boolean.valueOf(lightAsset.needRenderAbility("material.filterConfig")));
    }

    public Map<String, Boolean> getAiParams() {
        return this.mAiParams;
    }

    public boolean isAiBody() {
        if (this.mAiParams.containsKey("ai.body") && this.mAiParams.get("ai.body").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiCatFace() {
        if (this.mAiParams.containsKey("ai.catFace") && this.mAiParams.get("ai.catFace").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiExpression() {
        if (this.mAiParams.containsKey("ai.expression") && this.mAiParams.get("ai.expression").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiFace() {
        if (this.mAiParams.containsKey("ai.face") && this.mAiParams.get("ai.face").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiFace3d() {
        if (this.mAiParams.containsKey("ai.face3d") && this.mAiParams.get("ai.face3d").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiGan() {
        if (this.mAiParams.containsKey("ai.gan") && this.mAiParams.get("ai.gan").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiGender() {
        if (this.mAiParams.containsKey("ai.gender") && this.mAiParams.get("ai.gender").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiRgbDepth() {
        if (this.mAiParams.containsKey("ai.rgbDepth") && this.mAiParams.get("ai.rgbDepth").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiSegment() {
        if (this.mAiParams.containsKey("ai.segment") && this.mAiParams.get("ai.segment").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiSegmentHair() {
        if (this.mAiParams.containsKey("ai.segmentHair") && this.mAiParams.get("ai.segmentHair").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiSegmentHand() {
        if (this.mAiParams.containsKey("ai.hand") && this.mAiParams.get("ai.hand").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isAiSegmentSky() {
        if (this.mAiParams.containsKey("ai.segmentSky") && this.mAiParams.get("ai.segmentSky").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isMaterialBeautyBody() {
        if (this.mAiParams.containsKey("material.beautyBody") && this.mAiParams.get("material.beautyBody").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isMaterialDepthType() {
        if (this.mAiParams.containsKey("material.depthType") && this.mAiParams.get("material.depthType").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isMaterialMaskPaint() {
        if (this.mAiParams.containsKey("material.maskPaint") && this.mAiParams.get("material.maskPaint").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isMaterialPag() {
        if (this.mAiParams.containsKey("material.pag") && this.mAiParams.get("material.pag").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isMaterialParticle() {
        if (this.mAiParams.containsKey("material.particle") && this.mAiParams.get("material.particle").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isMaterialSticker3D() {
        if (this.mAiParams.containsKey("material.sticker3d") && this.mAiParams.get("material.sticker3d").booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isMaterialTouch() {
        if (this.mAiParams.containsKey("material.touch") && this.mAiParams.get("material.touch").booleanValue()) {
            return true;
        }
        return false;
    }
}
