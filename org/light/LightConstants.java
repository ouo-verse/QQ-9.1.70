package org.light;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightConstants {
    public static final String OUTPUT_ALPHA_STATE = "outputAlphaState";
    public static final String TRANSPARENT_MODE = "transparentMode";

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class AIDebugConfigKey {
        public static final String AIDEBUG_BODY = "aiDebug.body";
        public static final String AIDEBUG_CAT = "aiDebug.cat";
        public static final String AIDEBUG_CLASSIFY = "aiDebug.classify";
        public static final String AIDEBUG_FACE = "aiDebug.face";
        public static final String AIDEBUG_HAND = "aiDebug.hand";
        public static final String AIDEBUG_MASK = "aiDebug.mask";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class AIPrepareConfigKeys {
        public static final int ASSET_PROCESSING_PREPAREAI_BEGIN = 1;
        public static final int ASSET_PROCESSING_PREPAREAI_FINISHED = 0;
        public static final String ASSET_PROCESSING_PREPAREAI_PROCESSING_STATE = "lightAsset.process.prepareai.processing";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class AgentType {
        public static final String ACE_3D_AGENT = "Ace_3d_Engine";
        public static final String AR_AGENT = "AR_AGENT";
        public static final String BG_SEG_AGENT = "BG_SEG_AGENT";
        public static final String BODY3D_POINT_AGENT = "BODY3D_POINT_AGENT";
        public static final String BODY_AGENT = "BODY_AGENT";
        public static final String BRIGHTNESS_AGENT = "BRIGHTNESS_AGENT";
        public static final String CAT_AGENT = "CAT_AGENT";
        public static final String CUSTOM_SEG_AGENT = "CUSTOM_SEG_AGENT";
        public static final String DEPTH_AGENT = "DEPTH_AGENT";
        public static final String DEPTH_RELATIVE_AGENT = "DEPTH_RELATIVE_AGENT";
        public static final String EMOTION_AGENT = "EMOTION_AGENT";
        public static final String EMOTION_SCOER_AGENT = "EMOTION_SCORE_AGENT";
        public static final String ESTIMATION_AGENT = "ESTIMATION_AGENT";
        public static final String FACE_3D_MM_AGENT_V2 = "k3D_MM_AGENT_V2";
        public static final String FACE_AGENT = "FACE_AGENT";
        public static final String FACE_CLASSIFY_AGENT = "FACE_CLASSIFY_AGENT";
        public static final String FACE_STATIC_FEATURE_AGENT = "FACE_STATIC_FEATURE_AGENT";
        public static final String GROUND_SEG_AGENT = "GROUND_SEG_AGENT";
        public static final String HAIR_SEG_AGENT = "HAIR_SEG_AGENT";
        public static final String HAND_AGENT = "HAND_AGENT";
        public static final String HEAD_SEG_AGENT = "HEAD_SEG_AGENT";
        public static final String LANDMARK_AGENT = "LANDMARK_AGENT";
        public static final String MOTION_BODY_AGENT = "MOTION_BODY_AGENT";
        public static final String MOTION_FACE_AGENT = "MOTION_FACE_AGENT";
        public static final String MOTION_MESH_NET_AGENT = "MOTION_MESH_NET_AGENT";
        public static final String PIC_ENHANCE_AGENT = "PIC_ENHANCE_AGENT";
        public static final String PIC_QUALITY_AGENT_AGENT = "MEDIA_PRECHECK";
        public static final String QNN_HTP_BUNDLE = "QNN_HTP_BUNDLE";
        public static final String REALTIME_PIC_ENHANCE_AGENT = "REALTIME_PIC_ENHANCE_AGENT";
        public static final String SCENE_CLASSIFY_AGENT = "SCENE_CLASSIFY";
        public static final String SKY_SEG_AGENT = "SKY_SEG_AGENT";
        public static final String SMILE_AGENT = "SMILE_AGENT";
        public static final String THREE_D_MM_AGENT = "k3D_MM_AGENT";
        public static final String THREE_D_MM_AGENT_V2 = "k3D_MM_AGENT_V2";
        public static final String TNN_GPU_BUNDLE = "TNN_GPU_BUNDLE";
        public static final String TRACK_AGENT = "TRACK_AGENT";
        public static final String ZPLAN_FACE_AGENT = "kZPLAN_AGENT";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class AssetFeatureKey {
        public static final String GET_DEPTH_TYPE = "material.depthType";
        public static final String GET_FILTER_CONFIG = "material.filterConfig";
        public static final String HAS_A2D = "material.isAvatar2D";
        public static final String HAS_AR = "material.ar";
        public static final String HAS_AUDIO = "audio.hasAudio";
        public static final String HAS_BEAUTY_BODY = "material.beautyBody";
        public static final String HAS_CYBERPUNK = "material.cyberpunk";
        public static final String HAS_EDIT_WATERMARK = "material.editWatermark";
        public static final String HAS_GRAVITY_INFO = "material.gravityInfo";
        public static final String HAS_MASK_PAINT = "material.maskPaint";
        public static final String HAS_MESH = "material.mesh";
        public static final String HAS_PAG = "material.pag";
        public static final String HAS_PARTICLE = "material.particle";
        public static final String HAS_RECORD_TOUCH = "material.recordTouch";
        public static final String HAS_TOUCH = "material.touch";
        public static final String HAS_VOICE_CHANGE = "material.voiceChange";
        public static final String HAS_VOICE_DECIBEL = "material.voiceDecibel";
        public static final String HAS_WATERMARK = "material.watermark";
        public static final String NEED_3DMM_V2 = "ai.3dmm_v2";
        public static final String NEED_BODY = "ai.body";
        public static final String NEED_BODY_3D = "ai.body3d";
        public static final String NEED_CAT_FACE = "ai.catFace";
        public static final String NEED_EMOTION = "ai.emotion";
        public static final String NEED_EMOTION_SCORE = "ai.emotionScore";
        public static final String NEED_ESTIMATION = "ai.estimation";
        public static final String NEED_EXPRESSION = "ai.expression";
        public static final String NEED_FACE = "ai.face";
        public static final String NEED_FACE_3D = "ai.face3d";
        public static final String NEED_FACE_STATIC_FEATURE = "ai.faceStaticFeature";
        public static final String NEED_GAN = "ai.gan";
        public static final String NEED_GROUND_SEGMENT = "ai.segmentGround";
        public static final String NEED_HAIR_SEGMENT = "ai.segmentHair";
        public static final String NEED_HAND_DETECT = "ai.hand";
        public static final String NEED_HEAD_INSET = "ai.headInset";
        public static final String NEED_MOTION_BODY = "ai.motion.body";
        public static final String NEED_MOTION_FACE = "ai.motion.face";
        public static final String NEED_MOTION_MESHNET = "ai.motion.meshNet";
        public static final String NEED_PIC_ENHANCE = "ai.picEnhance";
        public static final String NEED_REALTIME_PIC_ENHANCE = "ai.realtimePicEnhance";
        public static final String NEED_RGB_DEPT = "ai.rgbDepth";
        public static final String NEED_RGB_DEPTH_RELATIVE = "ai.rgbDepthRelative";
        public static final String NEED_SEGMENT = "ai.segment";
        public static final String NEED_SKY_SEGMENT = "ai.segmentSky";
        public static final String NEED_TNN = "ai.gan";
        public static final String NEED_USER_MATERIAL = "material.userMaterial";
        public static final String UPDATE_TOUCH_EVENT = "event.touchPoint";
        public static final String UPDATE_TOUCH_ROTATE = "touch.rotate";
        public static final String UPDATE_TOUCH_SCALE = "touch.scale";
        public static final String WATERMARK_NEED_LOCATION = "material.watermark.need.location";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BasicSwitchKey {
        public static final String ALL_BEAUTY_ENABLE = "allBeauty.enable";
        public static final String ALL_BODY_ENABLE = "allBody.enable";
        public static final String ALL_LUT_ENABLE = "allLUT.enable";
        public static final String ALL_TRANSFORM_ENABLE = "allTransform.enable";
        public static final String BASIC_BODY_BEAUTY_ENABLE = "basicBodyBeauty.enable";
        public static final String BASIC_FACE_FEATURE_ENABLE = "beauty.faceFeature.enable";
        public static final String BASIC_LIPS_ENABLE = "beauty.lips.enable";
        public static final String BASIC_LUT_ENABLE = "basicLUT.enable";
        public static final String BASIC_MAKEUP_MULTIPLY_ENABLE = "beauty.makeupMultiply.enable";
        public static final String BASIC_MESH_ENABLE = "basicMesh.enable";
        public static final String BASIC_SOFT_LIGHT_ENABLE = "beauty.softLight.enable";
        public static final String MATERIAL_BODY_BEAUTY_ENABLE = "materialBodyBeauty.enable";
        public static final String MATERIAL_FACE_BEAUTY_ENABLE = "materialFaceBeauty.enable";
        public static final String MATERIAL_LIPS_ENABLE = "makeup.lips.enable";
        public static final String MATERIAL_MAKEUP_MULTIPLY_ENABLE = "makeup.makeupMultiply.enable";
        public static final String MATERIAL_MESH_ENABLE = "materialMesh.enable";
        public static final String MATERIAL_SOFT_LIGHT_ENABLE = "makeup.softLight.enable";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class BeautyBodyConfigKey {
        public static final String BODY_AUTOTHIN_BODY_STRENGTH = "body.autothinBodyStrength";
        public static final String BODY_LEG_STRETCH = "body.legStretch";
        public static final String BODY_SLIM_HEAD_STRENGTH = "body.slimHeadStrength";
        public static final String BODY_SLIM_LEG_STRENGTH = "body.slimLegStrength";
        public static final String BODY_THIN_BODY_STRENGTH = "body.thinBodyStrength";
        public static final String BODY_THIN_SHOULDER_STRENGTH = "body.thinShoulderStrength";
        public static final String BODY_WAIST_STRENGTH = "body.waistStrength";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class BeautyConfigKey {
        public static final String AUTO_BEAUTY_SWITCH = "auto_beauty_switch";
        public static final String BASIC_EYE_ANGLE_V7 = "basicV7.eyeAngle";
        public static final String BASIC_EYE_DISTANCE_V7 = "basicV7.eyeDistance";
        public static final String BASIC_FACE_JAW = "basicV7.faceJaw";
        public static final String BASIC_FACE_V7 = "basicV7.natureFace";
        public static final String BASIC_GODNESS_FACE_V7 = "basicV7.godnessFace";
        public static final String BASIC_LONG_NOSE_V7 = "basicV7.longNose";
        public static final String BASIC_MALE_GODNESS_FACE_V7 = "basicV7.maleGodFace";
        public static final String BASIC_MOUTH_HEIGHT_V7 = "basicV7.mouthHeight";
        public static final String BASIC_MOUTH_POSITION_V7 = "basicV7.mouthPosition";
        public static final String BASIC_MOUTH_WIDTH_V7 = "basicV7.mouthWidth";
        public static final String BASIC_NOSE_HEIGHT_V7 = "basicV7.noseHeight";
        public static final String BASIC_NOSE_WING_V7 = "basicV7.noseWing";
        public static final String BASIC_V_FACE_V7 = "basicV7.shortFace";
        public static final String BASIC_V_FACE_V7_REAL = "basicV7.vFace";
        public static final String BEAUTY_EYEMAKEUP_DEFAULT_MASK = "beauty.eyeMakeup.defaultMask";
        public static final String BEAUTY_EYEMAKEUP_MALE_MASK = "beauty.eyeMakeup.maleMask";
        public static final String BEAUTY_EYEMAKEUP_STRENGTH = "beauty.eyeMakeup.strength";
        public static final String BEAUTY_EYE_LIGHTEN = "beauty.eyeLighten";
        public static final String BEAUTY_FACE_FEATURE = "beauty.faceFeature";
        public static final String BEAUTY_FACE_FEATURE_LIPS_LUT = "beauty.faceFeatureLipsLut";
        public static final String BEAUTY_FACE_FEATURE_RED_CHEEK = "beauty.faceFeatureRedCheek";
        public static final String BEAUTY_FACE_FEATURE_SOFT_LIGHT = "beauty.faceFeatureSoftlight";
        public static final String BEAUTY_FACIAL_FEATURE = "beauty.wuguan";
        public static final String BEAUTY_FACIAL_SHADOW_EYE = "beauty.facialShadowEye";
        public static final String BEAUTY_FACIAL_SHADOW_NOSE = "beauty.facialShadowNose";
        public static final String BEAUTY_IMAGE_CONTRAST_ALPHA = "beauty.imageContrastAlpha";
        public static final String BEAUTY_LIPS_LIPS_MASK = "beauty.lips.lipsMask";
        public static final String BEAUTY_LIPS_LIPS_TYPE = "beauty.lips.lipsType";
        public static final String BEAUTY_LUT_CLEAR_ALPHA = "beauty.lutClearAlpha";
        public static final String BEAUTY_LUT_FOUNDATION_ALPHA = "beauty.lutFoundationAlpha";
        public static final String BEAUTY_MAKEUP_MULTIPLY_MULTIPLY_MASK = "beauty.makeupMultiply.multiplyMask";
        public static final String BEAUTY_RED_CHEEK = "beauty.redCheek";
        public static final String BEAUTY_REMOVE_EYE_BAGS = "beauty.removeEyeBags";
        public static final String BEAUTY_REMOVE_LAW_LINE = "beauty.removeLawLine";
        public static final String BEAUTY_REMOVE_WRINKLE = "beauty.removeWrinkle";
        public static final String BEAUTY_SKIN_COLOR = "beauty.skinColor";
        public static final String BEAUTY_SOFTLIGHT_SOFTLIGHT_MASK = "beauty.softLight.softLightMask";
        public static final String BEAUTY_TOOTH_WHITEN = "beauty.toothWhiten";
        public static final String CHEEK_BONE_V7 = "basicV7.cheekboneThin";
        public static final String ENABLE_BASIC_FACE_V7 = "basicV7.natureFace.enable";
        public static final String ENABLE_GODNESS_FACE_V7 = "basicV7.godnessFace.enable";
        public static final String ENABLE_MALE_GODNESS_FACE_V7 = "basicV7.maleGodFace.enable";
        public static final String ENLARGE_EYE_V7 = "basicV7.enlargeEye";
        public static final String FACE_FEATURE_LIPS = "beauty.lips";
        public static final String FOREHEAD_V7 = "basicV7.forehead";
        public static final String KEY_BASIC_CONFIG = "basic_config";
        public static final String LIQUEFACTION_BASIC_3 = "liquefaction.basic3";
        public static final String LIQUEFACTION_BASIC_4 = "liquefaction.basic4";
        public static final String LIQUEFACTION_BASIC_5 = "liquefaction.basic5";
        public static final String LIQUEFACTION_BASIC_6 = "liquefaction.basic6";
        public static final String LIQUEFACTION_BASIC_7 = "liquefaction.basic7";
        public static final String LIQUEFACTION_BASIC_8 = "liquefaction.basic8";
        public static final String LIQUEFACTION_SHORT_FACE = "liquefaction.shortFace";
        public static final String MAKE_UP_ALPHA_V7 = "basicV7.makeupAlpha";
        public static final String MAKE_UP_DEFAULT_STRENGTH = "makeup.defaultStrength";
        public static final String MAKE_UP_STRENGTH = "makeup.strength";
        public static final String MOUTH_SIZE_V7 = "basicV7.mouthSize";
        public static final String POST_EFFECT_DE_NOISE = "postEffect.denoise";
        public static final String SMOOTH_BRIGHTEN_EYE_ALPHA = "smooth.brightenEyeAlpha";
        public static final String SMOOTH_CURVE_ADJUST_ALPHA = "smooth.curveAdjustAlpha";
        public static final String SMOOTH_EXPOSURE_VALUE = "smooth.exposureValue";
        public static final String SMOOTH_FACE_COLOR_ALPHA = "smooth.faceColorAlpha";
        public static final String SMOOTH_FOLLOW_FACE = "smooth.followFace";
        public static final String SMOOTH_LOW_END_DEVICE = "smooth.isVeryLowEndDevice";
        public static final String SMOOTH_OVERALL_SMOOTH = "smooth.overallSmooth";
        public static final String SMOOTH_SHARPEN = "smooth.sharpen";
        public static final String SMOOTH_SMOOTH = "smooth.smooth";
        public static final String SMOOTH_VERSION = "smooth.version";
        public static final String SMOOTH_VERSION_V5 = "v5";
        public static final String SMOOTH_VERSION_V6 = "v6";
        public static final String SMOOTH_VERSION_V7 = "v7";
        public static final String SMOOTH_VERSION_V8 = "v8";
        public static final String STRETCH_CHEEKBONE_THIN = "stretch.cheekboneThin";
        public static final String STRETCH_CHIN = "stretch.chin";
        public static final String STRETCH_ENLARGE_EYE = "stretch.enlargeEye";
        public static final String STRETCH_EYE_ANGLE = "stretch.eyeAngle";
        public static final String STRETCH_EYE_DISTANCE = "stretch.eyeDistance";
        public static final String STRETCH_FOREHEAD = "stretch.forehead";
        public static final String STRETCH_MOUTH_HEIGHT = "stretch.mouthHeight";
        public static final String STRETCH_MOUTH_POSITION = "stretch.mouthPosition";
        public static final String STRETCH_MOUTH_SIZE = "stretch.mouthSize";
        public static final String STRETCH_MOUTH_WIDTH = "stretch.mouthWidth";
        public static final String STRETCH_NOSE_HEIGHT = "stretch.noseHeight";
        public static final String STRETCH_NOSE_WING = "stretch.noseWing";
        public static final String STRETCH_SHORT_FACE = "stretch.shortFace";
        public static final String STRETCH_THIN_FACE = "stretch.thinFace";
        public static final String STRETCH_THIN_NOSE = "stretch.thinNose";
        public static final String STRETCH_V_FACE = "stretch.vFace";
        public static final String THIN_FACE_SUB_TYPE_V7 = "basicV7.basicFace";
        public static final String THIN_FACE_V7 = "basicV7.thinFace";
        public static final String THIN_NOSE_V7 = "basicV7.thinNose";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class BeautySwitchKey {
        public static final String BASIC_FACE_BEAUTY_ENABLE = "basicFaceBeauty.enable";
        public static final String BEAUTY_ENABLE = "beauty.enable";
        public static final String BEAUTY_ENABLE_FACE_COLOR_WHITE = "beauty.enableFaceColorWhite";
        public static final String BEAUTY_FACE_FEATURE_ENABLE = "beauty.faceFeature.enable";
        public static final String BODY_ENABLE = "body.enable";
        public static final String DE_NOISE_ENABLE = "denoise.enable";
        public static final String MATERIAL_INNER_LUT_ENABLE = "materialLUT.enable";
        public static final String SMOOTH_ENABLE = "smooth.enable";
        public static final String STICKER_ENABLE = "sticker.enable";
        public static final String TRANSFORM_ENABLE = "transform.enable";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BundleType {
        public static final String SKELETON_BUNDLE = "SKELETON_BUNDLE";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CacheConfigKey {
        public static final String PROGRAM_CACHE = "cache.program.enable";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DataSourceKey {
        public static final String DATE = "datasource.date";
        public static final String LOCATION = "datasource.location";
        public static final String USER_INFO = "datasource.userinfo";
        public static final String WEATHER = "datasource.weather";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DefaultBeautyVersion {
        public static final String DEFAULT_BEAUTY_VERSION_EMPTY = "defaultBeautyEmpty.json";
        public static final String DEFAULT_BEAUTY_VERSION_V5 = "defaultBeautyV5.json";
        public static final String DEFAULT_BEAUTY_VERSION_V6 = "defaultBeautyV6.json";
        public static final String DEFAULT_BEAUTY_VERSION_V7 = "defaultBeautyV7.json";
        public static final String DEFAULT_BEAUTY_VERSION_V7_1 = "defaultBeautyV7_1.json";
        public static final String DEFAULT_BEAUTY_VERSION_V8 = "defaultBeautyV8.json";
        public static final String DEFAULT_BEAUTY_VERSION_V9 = "defaultBeautyV9.json";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DetectSwitchKey {
        public static final String AI_FACE_STATIC_FEATURE_ENABLE = "ai.faceStaticFeature.enable";
        public static final String AI_SEGMENTATION_HAIR_ENABLE = "ai.segmentation.hair.enable";
        public static final String AI_SEGMENTATION_SKY_ENABLE = "ai.segmentation.sky.enable";
        public static final String AI_SMILE_ENABLE = "ai.smile.enable";
        public static final String FACE_DETECT_ENABLE = "ai.face.enable";
        public static final String HAND_DETECT_ENABLE = "ai.hand.enable";
        public static final String SEGMENT_BG_DETECT_ENABLE = "ai.segmentation.bg.enable";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DeviceSupport {
        public static final String AVATAR_2_D = "avatar2d";
        public static final String THREE_D_KAPU = "3d.kapu";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DowngradeStrategyKey {
        public static final String GLOBAL_BASIC_SMOOTH = "globalBasicSmooth";
        public static final String SMOOTH = "smooth";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ErrorCode {
        public static final int BONE_NOT_SUPPORT = -1500;
        public static final int CUT_COMPONENTS_NOT_SUPPORT = -900;
        public static final int DEVICE_NOT_SUPPORT = -200;
        public static final int FILAMENT_NOT_SUPPORT = -1100;
        public static final int GAN_RESOURCE_NOT_SUPPORT = -200;
        public static final int HEAD_INSET_RESOURCE_NOT_SUPPORT = -600;
        public static final int JAVA_SCRIPT_NOT_SUPPORT = -800;
        public static final int NO_ERROR = 0;
        public static final int OPENGL_NOT_SUPPORT = -700;
        public static final int SDK_VERSION_NOT_SUPPORT = -500;
        public static final int TEMPLATE_JSON_EMPTY = -400;
        public static final int TEMPLATE_JSON_PATH_EMPTY = -2;
        public static final int UNKNOWN = -1;
        public static final int k3D_ENGINE_RESOURCE_NOT_EXISTS = -100;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class EventKey {
        public static final String EVENT_EXTERNAL_FACE_DATA = "event.externalFaceData";
        public static final String EVENT_PAINT_POINT = "event.paintPoint";
        public static final String EVENT_PAINT_POINT_END = "event.paintPoint.end";
        public static final String EVENT_SCRIPT_AUTOFILTER_PARAMS = "event.script.autofilter.params";
        public static final String EVENT_SCRIPT_AUTOFILTER_STRENGTH = "event.script.autofilter.strength";
        public static final String EVENT_SCRIPT_BG = "event.script.bg";
        public static final String EVENT_SCRIPT_CAMERA_END_RECORD = "event.script.lightsdk.CameraEndRecord";
        public static final String EVENT_SCRIPT_CAMERA_START_RECORD = "event.script.lightsdk.CameraStartRecord";
        public static final String EVENT_SCRIPT_CAMERA_SWITCHED = "event.script.lightsdk.CameraSwitched";
        public static final String EVENT_SCRIPT_EMOTION = "event.script.emotion";
        public static final String EVENT_SCRIPT_PARAMS = "event.script.params";
        public static final String EVENT_SCRIPT_SPLIT_SCREEN_TYPE = "event.script.splitScreenType";
        public static final String EVENT_SCRIPT_SWITCH_BG = "event.script.switchBg";
        public static final String EVENT_SCRIPT_ZPLAN_FILAMENT_SETMOODTYPE = "event.zplan.filament.setMoodType";
        public static final String EVENT_SCRIPT_ZPLAN_FILAMENT_SETQQUIN = "event.zplan.filament.setQQUIN";
        public static final String EVENT_SCRIPT_ZPLAN_FILAMENT_SET_AVATAR_INFO_JSON_PATH = "event.zplan.filament.setAvatarInfoJsonPath";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LutConfigKey {
        public static final String LUT_INTENSITY = "lut.intensity";
        public static final String LUT_PATH = "lut.src";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MakeUpType {
        public static final int MAKEUP_TYPE_BEAUTY_MULTIPLY = 3;
        public static final int MAKEUP_TYPE_LIPS = 1;
        public static final int MAKEUP_TYPE_SOFT_LIGHT = 2;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Others {
        public static final String DEVICE_FALLBACK_SMOOTH = "device_fallback_smooth";
        public static final String ENABLE_BACK_BRIGHTNESS_DETECT = "enableBackBrightnessDetect";
        public static final String WATERMARK_QQ_ONLINE = "watermark.qq.online";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReshapeConfigKey {
        public static final String RESHAPE_BASIC_FACE_SUB_TYPE_UNIFORM = "reshape.basicFaceSubType";
        public static final String RESHAPE_BASIC_FACE_UNIFORM = "reshape.basicFace";
        public static final String RESHAPE_CHEEK_BONE_UNIFORM = "reshape.cheekboneThin";
        public static final String RESHAPE_CHIN_UNIFORM = "reshape.chin";
        public static final String RESHAPE_ENLARGE_EYE_UNIFORM = "reshape.enlargeEye";
        public static final String RESHAPE_ENLARGE_MESH = "reshape.enlargeMesh";
        public static final String RESHAPE_EYE_ANGLE_UNIFORM = "reshape.eyeAngle";
        public static final String RESHAPE_EYE_DISTANCE_UNIFORM = "reshape.eyeDistance";
        public static final String RESHAPE_FACE_JAW_UNIFORM = "reshape.faceJaw";
        public static final String RESHAPE_FOREHEAD_UNIFORM = "reshape.forehead";
        public static final String RESHAPE_LONG_NOSE_UNIFORM = "reshape.longNose";
        public static final String RESHAPE_MOUTH_HEIGHT_UNIFORM = "reshape.mouthHeight";
        public static final String RESHAPE_MOUTH_POSITION_UNIFORM = "reshape.mouthPosition";
        public static final String RESHAPE_MOUTH_SIZE_UNIFORM = "reshape.mouthSize";
        public static final String RESHAPE_MOUTH_WIDTH_UNIFORM = "reshape.mouthWidth";
        public static final String RESHAPE_NOSE_HEIGHT_UNIFORM = "reshape.noseHeight";
        public static final String RESHAPE_NOSE_WING_UNIFORM = "reshape.noseWing";
        public static final String RESHAPE_SHORT_FACE_UNIFORM = "reshape.shortFace";
        public static final String RESHAPE_SMALL_FACE_UNIFORM = "reshape.smallFace";
        public static final String RESHAPE_THIN_FACE_UNIFORM = "reshape.thinFace";
        public static final String RESHAPE_THIN_NOSE_UNIFORM = "reshape.thinNose";
        public static final String RESHAPE_V_FACE_UNIFORM = "reshape.vFace";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SegmentConfigKey {
        public static final String STROKE_BG_ALPHA = "stroke.bgAlpha";
        public static final String STROKE_BG_COLOR = "stroke.bgColor";
        public static final String STROKE_COLOR = "stroke.color";
        public static final String STROKE_ENABLE = "stroke.enable";
        public static final String STROKE_GAP = "stroke.gap";
        public static final String STROKE_SEGMENT_FOLLOW_FACE = "stroke.segmentFollowFace";
        public static final String STROKE_WIDTH = "stroke.width";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class SupportCameraPosition {
        public static final int ASSET_SUPPORT_BACK_CAMERA = 2;
        public static final int ASSET_SUPPORT_FRONT_BACK_CAMERA = 0;
        public static final int ASSET_SUPPORT_FRONT_CAMERA = 1;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class WaterMarkConfigKeys {
        public static final String DICTIONARY = "watermark_dict";
        public static final String LOCATION = "[location]";
        public static final String TEMPERATURE = "[temperature]";
        public static final String WEATHER = "[weather]";
        public static final String WEATHER_TYPE = "[weatherType]";
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ZPlanConfigKeys {
        public static final String ASSET_PROCESSING_ZPLAN_FILAMENT_ANIMATION_BEGIN = "lightAsset.process.zplan.filament.animation.begin";
        public static final String ASSET_PROCESSING_ZPLAN_FILAMENT_FIRSTFRAME = "lightAsset.process.zplan.filament.firstframe";
        public static final String ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY = "lightAsset.process.zplan.filament.setMoodTypeReady";
        public static final String ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_BLACKSLOTSTATE = "lightAsset.process.zplan.filament.setMoodTypeReady.blackSlotState";
        public static final String ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_MOODDURATION = "lightAsset.process.zplan.filament.setMoodTypeReady.moodDuration";
        public static final String ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_MOODPATH = "lightAsset.process.zplan.filament.setMoodTypeReady.moodPath";
        public static final String ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_MOODTYPE = "lightAsset.process.zplan.filament.setMoodTypeReady.moodType";
    }
}
