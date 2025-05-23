package com.tencent.ttpic.openapi.filter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LightConstants {
    public static final String AGE_DETECT = "ai.age.enable";
    public static final String DEFAULT_EXTERNAL_RENDER_KEY = "default_external_render_key";
    public static final String ENABLE_FACE_FEATURE = "beauty.faceFeature.enable";
    public static final String FACE_DETECT = "ai.face.enable";
    public static final String FEMALE = "female";
    public static final String GENDER_DETECT = "ai.gender.enable";
    public static final String HAND_DETECT = "ai.hand.enable";
    public static final String LIGHT_AI_BEAUTY = "auto_beauty_switch";
    public static final String LIGHT_BASIC_BEAUTY = "basicFaceBeauty.enable";
    public static final String LIGHT_BASIC_MESH = "basicMesh.enable";
    public static final String LIGHT_BEAUTY = "beauty.enable";
    public static final String LIGHT_BODY = "body.enable";
    public static final String LIGHT_DE_NOISE = "denoise.enable";
    public static final String LIGHT_MATERIAL_INNER_LUT = "materialLUT.enable";
    public static final String LIGHT_MATERIAL_MESH = "materialMesh.enable";
    public static final String LIGHT_NODE_LUT = "basicLUT.enable";
    public static final String LIGHT_SMOOTH = "smooth.enable";
    public static final String LIGHT_STICKER = "sticker.enable";
    public static final String LIGHT_TRANSFORM = "transform.enable";
    public static final String LIGHT_TRANSPARENT_MODE = "transparentMode";
    public static final String MALE = "male";
    public static final String SEGMENT_BG_DETECT = "ai.segmentation.bg.enable";
    public static final String SEGMENT_FOLLOW_FACE = "stroke.segmentFollowFace";

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class AGENT_TYPE {
        public static final String KLIGHT_3D_AGENT = "Ace_3d_Engine";
        public static final String k3D_MM_AGENT = "k3D_MM_AGENT";
        public static final String kAGE_AGENT = "AGE_AGENT";
        public static final String kAR_AGENT = "AR_AGENT";
        public static final String kBG_SEG_AGENT = "BG_SEG_AGENT";
        public static final String kBODY_3D_AGENT = "BODY3D_AGENT";
        public static final String kBODY_AGENT = "BODY_AGENT";
        public static final String kBRIGHTNESS_AGENT = "BRIGHTNESS_AGENT";
        public static final String kCAT_AGENT = "CAT_AGENT";
        public static final String kCUSTOM_SEG_AGENT = "CUSTOM_SEG_AGENT";
        public static final String kDEPTH_AGENT = "DEPTH_AGENT";
        public static final String kEMOTION_AGENT = "EMOTION_AGENT";
        public static final String kFACE_AGENT = "FACE_AGENT";
        public static final String kFULL_BODY_AGENT = "FULL_BODY_AGENT";
        public static final String kGAZE_AGENT = "VIEW_POINT_AGENT";
        public static final String kGENDER_AGENT = "GENDER_AGENT";
        public static final String kHAIR_SEG_AGENT = "HAIR_SEG_AGENT";
        public static final String kHAND_AGENT = "HAND_AGENT";
        public static final String kHEAD_SEG_AGENT = "HEAD_SEG_AGENT";
        public static final String kLIGHT_SCENE = "SCENE_AGENT";
        public static final String kSKY_SEG_AGENT = "SKY_SEG_AGENT";
        public static final String kSMILE_AGENT = "SMILE_AGENT";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class AIDataKey {
        public static final String BODY = "data.ai.body";
        public static final String EMOTION = "data.ai.emotion";
        public static final String FACE = "data.ai.face";
        public static final String GESTURE = "data.ai.gesture";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class AISwitchKey {
        public static final String BODY_AI_SWITCH_KEY = "ai.body.ignore";
        public static final String FACE_AI_SWITCH_KEY = "ai.face.ignore";
        public static final String HAND_AI_SWITCH_KEY = "ai.hand.ignore";
        public static final String MM_AI_SWITCH_KEY = "ai.3dmm.ignore";
        public static final String MOTION_AI_SWITCH_KEY = "ai.emotion.ignore";
        public static final String SEGMENT_AI_SWITCH_KEY = "ai.segmentation.ignore";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public @interface AISwitchType {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Asset {
        public static final String AVATAR_BG_SET_KEY = "replace.avatar2d.bg";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class BasicSwitch {
        public static final String BEAUTY = "allBeauty.enable";
        public static final String BODY = "allBody.enable";
        public static final String LUT = "allLut.enable";
        public static final String TRANSFORM = "allTransform.enable";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class BeautyBodyNameConfig {
        public static final String LONG_LEG = "body.legStretch";
        public static final String SLIM_WAIST = "body.thinShoulderStrength";
        public static final String THIN_BODY = "body.thinBodyStrength";
        public static final String THIN_SHOULDER = "body.waistStrength";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class BeautyNameConfig {
        public static final String BASIC3 = "liquefaction.basic3";
        public static final String BASIC4 = "liquefaction.basic4";
        public static final String BASIC5 = "liquefaction.basic5";
        public static final String BASIC6 = "liquefaction.basic6";
        public static final String BASIC7 = "liquefaction.basic7";
        public static final String BASIC8 = "liquefaction.basic8";
        public static final String BASIC_V7_FACTOR_EYE = "basicV7.enlargeEye";
        public static final String BASIC_V7_FACTOR_FEN_GE_ALPHA = "basicV7.makeupAlpha";
        public static final String BASIC_V7_FACTOR_FOREHEAD = "basicV7.forehead";
        public static final String BASIC_V7_FACTOR_GODDESS_THIN = "basicV7.godnessFace";
        public static final String BASIC_V7_FACTOR_GOD_THIN = "basicV7.maleGodFace";
        public static final String BASIC_V7_FACTOR_MOUTH = "basicV7.mouthSize";
        public static final String BASIC_V7_FACTOR_NATURE_THIN = "basicV7.natureFace";
        public static final String BASIC_V7_FACTOR_SMALL = "basicV7.shortFace";
        public static final String BASIC_V7_FACTOR_THIN_BONE = "basicV7.cheekboneThin";
        public static final String BASIC_V7_FACTOR_THIN_NOSE = "basicV7.thinNose";
        public static final String BASIC_V7_FACTOR_ZHAI_LIAN = "basicV7.thinFace";
        public static final String BEAUTY = "smooth.smooth";
        public static final String CHEEKBONE_THIN = "stretch.cheekboneThin";
        public static final String CHIN = "stretch.chin";
        public static final String CONTRAST_RATIO = "smooth.curveAdjustAlpha";
        public static final String DENOISE = "postEffect.denoise";
        public static final String ENABLE_BASIC_LIPS = "beauty.lips.enable";
        public static final String ENABLE_BASIC_SOFT_LIGHT = "beauty.softLight.enable";
        public static final String ENABLE_FACE_FEATURE = "beauty.faceFeature.enable";
        public static final String ENABLE_MULTIPLY = "beauty.makeupMultiply.enable";
        public static final String EXPOSURE_VALUE = "smooth.exposureValue";
        public static final String EYE = "stretch.enlargeEye";
        public static final String EYE_ANGLE = "stretch.eyeAngle";
        public static final String EYE_DISTANCE = "stretch.eyeDistance";
        public static final String EYE_LIGHTEN = "smooth.brightenEyeAlpha";
        public static final String FACE_ALPHA = "beauty.faceFeatureSoftlight";
        public static final String FACE_FEATURE_LIPS_LUT_ALPHA = "beauty.faceFeatureLipsLut";
        public static final String FACE_FEATURE_REDCHEEK_ALPHA = "beauty.faceFeatureRedCheek";
        public static final String FACE_SHORTEN = "liquefaction.shortFace";
        public static final String FACE_SMALLER = "stretch.vFace";
        public static final String FACE_THIN = "stretch.thinFace";
        public static final String FACE_V = "stretch.vFace";
        public static final String FOREHEAD = "stretch.forehead";
        public static final String IMAGE_CONTRAST_ALPHA = "beauty.imageContrastAlpha";
        public static final String LIPS_THICKNESS = "stretch.mouthHeight";
        public static final String LIPS_WIDTH = "stretch.mouthWidth";
        public static final String LUT_CLEAR_ALPHA = "beauty.lutClearAlpha";
        public static final String LUT_FOUNDATION_ALPHA = "beauty.lutFoundationAlpha";
        public static final String MAKE_UP_STRENGTH = "makeup.strength";
        public static final String MOUTH_SHAPE = "stretch.mouthSize";
        public static final String NOSE = "stretch.thinNose";
        public static final String NOSE_POSITION = "stretch.noseHeight";
        public static final String NOSE_WING = "stretch.noseWing";
        public static final String OVERALL = "smooth.overallSmooth";
        public static final String REMOVE_EYE_BAGS = "beauty.removeEyeBags";
        public static final String REMOVE_WRINKLES = "beauty.removeWrinkle";
        public static final String REMOVE_WRINKLES2 = "beauty.removeLawLine";
        public static final String SHARP_STRENGTH = "smooth.sharpen";
        public static final String SKIN_COLOR = "beauty.skinColor";
        public static final String SMOOTH_VERSION = "smooth.version";
        public static final String SMOOTH_VERSION_V5 = "defaultBeautyV5.json";
        public static final String SMOOTH_VERSION_V5_SIMPLE = "v5";
        public static final String SMOOTH_VERSION_V6 = "defaultBeautyV6.json";
        public static final String SMOOTH_VERSION_V6_SIMPLE = "v6";
        public static final String SMOOTH_VERSION_V7 = "defaultBeautyV7.json";
        public static final String SMOOTH_VERSION_V7_SIMPLE = "v7";
        public static final String SWITCH_GODDESS_THIN = "basicV7.godnessFace.enable";
        public static final String SWITCH_GOD_THIN = "basicV7.maleGodFace.enable";
        public static final String SWITCH_NATURE_THIN = "basicV7.natureFace.enable";
        public static final String TOOTH_WHITEN = "beauty.toothWhiten";
        public static final String VERY_LOW_DEVICE = "smooth.isVeryLowEndDevice";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class DeviceSupport {
        public static final String AVATAR_2D = "avatar2d";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Event {
        public static final String SCRIPT_BG = "event.script.bg";
        public static final String SCRIPT_EMOTION = "event.script.emotion";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class LIGHT_ASSET {
        public static final String ASSET_AR = "material.ar";
        public static final String ASSET_CHANGE_BG_EVENT = "event.script.switchBg";
        public static final String ASSET_GET_DEPTH_TYPE = "material.depthType";
        public static final String ASSET_HAS_AUDIO = "audio.hasAudio";
        public static final String ASSET_HAS_INNER_BEAUTY = "material.filterConfig";
        public static final String ASSET_IS_3D_KAPU = "3d.kapu";
        public static final String ASSET_IS_FACE_3D = "ai.face3d";
        public static final String ASSET_IS_FACE_MARKING = "todo";
        public static final String ASSET_IS_PAG = "material.pag";
        public static final String ASSET_IS_PARTICLE = "material.particle";
        public static final String ASSET_IS_POUT = "material.pout";
        public static final String ASSET_IS_STICKER_3D = "material.sticker3d";
        public static final String ASSET_MESH = "material.mesh";
        public static final String ASSET_NEED_3DMM = "ai.3dmm";
        public static final String ASSET_NEED_AI_EXPRESSION = "ai.expression";
        public static final String ASSET_NEED_AVATAR_2D = "material.isAvatar2D";
        public static final String ASSET_NEED_BEAUTY_BODY = "material.beautyBody";
        public static final String ASSET_NEED_BODY = "ai.body";
        public static final String ASSET_NEED_BODY_3D = "ai.body3d";
        public static final String ASSET_NEED_CAT_DETECT = "ai.catFace";
        public static final String ASSET_NEED_EMOTION = "ai.emotion";
        public static final String ASSET_NEED_EXPRESSION_DETECT = "ai.expression";
        public static final String ASSET_NEED_FACE = "ai.face";
        public static final String ASSET_NEED_GAN = "ai.gan";
        public static final String ASSET_NEED_GENDER_DETECT = "ai.gender";
        public static final String ASSET_NEED_HAIR_SEGMENT = "ai.segmentHair";
        public static final String ASSET_NEED_HAND_DETECT = "ai.hand";
        public static final String ASSET_NEED_HEAD_SEGMENT = "ai.headInset";
        public static final String ASSET_NEED_RGB_DEPT = "ai.rgbDepth";
        public static final String ASSET_NEED_SEGMENT = "ai.segment";
        public static final String ASSET_NEED_SKY_SEGMENT = "ai.segmentSky";
        public static final String ASSET_NEED_TNN = "ai.gan";
        public static final String ASSET_NEED_VIEW_POINT_DETECT = "ai.viewPoint";
        public static final String ASSET_NEED_VOICE_CHANGE = "material.voiceChange";
        public static final String ASSET_PAINT_EVENT = "event.paintPoint";
        public static final String ASSET_PAINT_EVENT_END = "event.paintPoint.end";
        public static final String ASSET_SUPPORT_TOUCH = "material.touch";
        public static final String ASSET_TOUCH_EVENT = "event.touchPoint";
        public static final String ASSET_TOUCH_ROTATE = "touch.rotate";
        public static final String ASSET_TOUCH_SCALE = "touch.scale";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class LutConfigKey {
        public static final String INTENSITY = "lut.intensity";
        public static final String LUT = "lut.src";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class SegmentConfigKey {
        public static final String STROKE_BG_COLOR = "stroke.bgColor";
        public static final String STROKE_COLOR = "stroke.color";
        public static final String STROKE_GAP = "stroke.gap";
        public static final String STROKE_WIDTH = "stroke.width";
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class WaterMarkConfigKeys {
        public static final String DICTIONARY = "watermark_dict";
        public static final String LOCATION = "[location]";
        public static final String ONLINE_USR_COUNT = "watermark.qq.online";
        public static final String TEMPERATURE = "[temperature]";
        public static final String WEATHER = "[weather]";
        public static final String WEATHER_TYPE = "[weatherType]";
    }
}
