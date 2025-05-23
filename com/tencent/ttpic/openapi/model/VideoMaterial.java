package com.tencent.ttpic.openapi.model;

import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.filter.LightConstants;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.light.LightAsset;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoMaterial {
    public static final String CRAZYFACE_FACE_COLOR2 = "imageFaceColor2";
    public static final String CRAZYFACE_FACE_COLOR_RANGE = "faceColorRange";
    public static final int INVALID_INT_FIELD_VALUE = -999999;
    public static final int INVALID_ONLY_ONE_GESTURE = -1;
    public static final String MP4_SUFFIX = ".mp4";
    public static final String PARAMS_FILE_NAME = "params";
    public static final String PNG_SUFFIX = ".png";
    public static final double SCALE_DIFF = 100.0d;
    public static final int SIZE_FACE_ANGLE = 3;
    public static final int SIZE_FACE_POINT = 90;
    private String dataPath;

    /* renamed from: id, reason: collision with root package name */
    private String f381704id;
    private boolean isAR3DMaterial;
    LightAsset lightAsset;
    private int shaderType;
    private LazyLoadAnimationDrawable.Info tipsDrawableInfo;
    public static final String[] DEVICE_NEED_COPY_TRANSFORM = {"A1001", "SM-N9006", "vivo_X5Max_L", "vivo_X5Max_L", "vivo_X5V", "vivo_Y23L"};
    public static FilenameFilter mPngFilter = new FilenameFilter() { // from class: com.tencent.ttpic.openapi.model.VideoMaterial.2
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".png");
        }
    };
    private boolean isFreezeFrameRequired = false;
    private boolean loadImageFromCache = true;
    private float[] arShaderPlanOffset = {0.0f, 0.0f, 0.0f};

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum AR_MATERIAL_TYPE {
        NORMAL(1),
        CLICKABLE(2);

        public int value;

        AR_MATERIAL_TYPE(int i3) {
            this.value = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum DISTORTION_ITEM_FILED {
        POSITION("position"),
        DISTORTION("distortion"),
        DIRECTION("direction"),
        RADIUS("radius"),
        STRENGH("strength"),
        X("dx"),
        Y("dy"),
        TARGETDX("targetDx"),
        TARGETDY("targetDy");

        public String value;

        DISTORTION_ITEM_FILED(String str) {
            this.value = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum FACE_OFF_ITEM_FIELD {
        ID("id"),
        FACE_EXCHANGE_IMAGE("faceExchangeImage"),
        BLEND_ALPHA("blendAlpha"),
        FEATURE_TYPE("featureType"),
        GRAY_SCALE("grayScale"),
        BLEND_MODE(c.W),
        BLEND_IRIS("blendIris"),
        PERSON_ID("personID"),
        GENDER_TYPE("genderType"),
        RANDOM_GROUP_NUM("randomGroupNum"),
        FACE_POINTS("facePoints"),
        IRIS_IMAGE("eyeIrisImage"),
        FRAME_TYPE("frameType"),
        FRAMES("frames"),
        FRAME_DURATION("frameDuration"),
        TRIGGER_TYPE("triggerType"),
        COS_3D("cos3d"),
        COS3D_AMBIENT_STRENGTH("cos3DAmbientStrength"),
        COS3D_DIFFUSE_STRENGTH("cos3DDiffuseStrength"),
        FILTER_SKIN("filterSkin"),
        DISABLE_3D_CORRECT("disable3DCorrect"),
        FACE_EXCHANGE_IMAGE_FULL_FACE("faceExchangeImageFullFace"),
        FACE_EXCHANGE_IMAGE_DISABLE_OPACITY("faceExchangeImageDisableOpacity"),
        FACE_EXCHANGE_IMAGE_DISABLE_FACECROP("faceExchangeImageDisableFaceCrop"),
        LIPS_STYLE_MASK("lipsStyleMask"),
        LIPS_RGBA("lipsRGBA");

        public String value;

        FACE_OFF_ITEM_FIELD(String str) {
            this.value = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum FIELD {
        SUBSTITUTE("substitute"),
        DEPENDENCY_LIST("dependencies"),
        MIN_APP_VERSION("minAppVersion"),
        PREFER_CAMERA_ID("preferCameraId"),
        SHADER_TYPE("shaderType"),
        BLEND_MODE(c.W),
        MAX_FACE_COUNT("maxFaceCount"),
        TIPS_TEXT("tipsText"),
        TIPS_ICON("tipsIcon"),
        HAND_BOOST_ENABLE("handBoostEnable"),
        DETECTOR_FLAG("detectorFlag"),
        TOUCH_FLAG("touchFlag"),
        STATE_VERSION("stateVersion"),
        RENDER_ORDER("renderOrder"),
        IS_INTERNAL_RECORD("isInternalRecord"),
        IS_CAN_SIY("isCanDiyPitcureVideo"),
        IS_AR_3D_Material("isAR3DMaterial"),
        AR_Material_Type("arMaterialType"),
        AUTO_BRIGHTNESS_STRENGTH("autoBrightnessStrength"),
        AUTO_CONTRAST_STRENGTH("autoContrastStrength"),
        FACE_COLOR_STRENGTH("faceColorStrength"),
        LOWLIGHT_BRIGHTNESS_STRENGTH("lowlightBrightnessStrength"),
        SUPPORT_LANDSCAPE("supportLandscape"),
        RESET_WHEN_START_RECORD("resetWhenStartRecord"),
        SUPPORT_PAUSE("supportPause"),
        SPLIT_SCREEN("splitScreen"),
        RESOURCE_LIST("resourceList"),
        ALPHA(c.f123400v),
        ITEM_LIST(VideoTemplateParser.ITEM_LIST),
        RANDOM_GROUP_COUNT("randomGroupCount"),
        FILTER_BLUR_STRENGTH("filterBlurStrength"),
        LIPS_LUT("lipsLut"),
        LIPS_STYLE_MASK("lipsStyleMask"),
        LIPS_SEG_TYPE("lipsSegType"),
        FILTER_ID(ShortVideoConstants.PARAM_KEY_FILTER_ID),
        FILTER_EFFECT("filterEffect"),
        AD_ICON("adIcon"),
        AD_LINK("adH5Link"),
        AD_APP_LINK("adAppLink"),
        WEIBO_TAG("weiboTag"),
        VOICE_KIND("voicekind"),
        ENVIRONMENT("environment"),
        AR_PARTICLE_TYPE("arParticleType"),
        AR_PARTICLE_LIST("arParticleList"),
        FILAMENT_PARTICLE_LIST("filamentParticleList"),
        USE_MESH("useMesh"),
        NOT_ALLOW_BEAUTY_SETTING("notAllowBeautySetting"),
        DISTORTION_LIST("distortionList"),
        OVAL_DISTORTION_LIST("ovalDistortionList"),
        NEED_RECALCULATE_FACE("needReCaculateFace"),
        FACE_EXPRESSION("faceExpression"),
        FACE_AVERAGE("faceAverage"),
        FACE_CROP("videoFaceCrop"),
        FACE_HEAD_CROP_ITEM_LIST("headCropItemList"),
        FACE_BEAUTY_ITEM_LIST("faceBeautyItemList"),
        FACE_OFF_ITEM_LIST("faceOffItemList"),
        FACE_EXCHANGE_IMAGE("faceExchangeImage"),
        FACE_EXCHANGE_IMAGE_FULL_FACE("faceExchangeImageFullFace"),
        FACE_EXCHANGE_IMAGE_DISABLE_OPACITY("faceExchangeImageDisableOpacity"),
        FACE_EXCHANGE_IMAGE_DISABLE_FACECROP("faceExchangeImageDisableFaceCrop"),
        COSMETIC_SHELTER_SWITCH_CLOSE("cosmeticShelterSwitchClose"),
        COSMETIC_CHANGE_SWITCH("cosmeticChangeSwitch"),
        COSMETIC_CHANGE_MODE("cosmeticChangeMode"),
        IMAGE_FACE_POINTS_FILE_NAME("imageFacePointsFileName"),
        FACE_OFF_TYPE("faceOffType"),
        FACE_SWAP_TYPE("faceSwapType"),
        BLEND_ALPHA("blendAlpha"),
        GRAY_SCALE("grayScale"),
        FEATURE_TYPE("featureType"),
        FACE_POINTS_LIST("facePoints"),
        STYLE_FILTER_LIST("styleFilterList"),
        FILTER_CONFIG_FILE("filterConfigFile"),
        GRID_MODEL("gridModel"),
        MULTI_VIEWER("multiViewer"),
        GRID_VIEWER("gridViewer"),
        MV_TEMPLATE_FILE("mvTemplateFile"),
        STAR_EFFECT("starEffect"),
        PHANTOM_ITEM_LIST("phantomItemList"),
        AUDIO_2_TEXT("audio2text"),
        FACE_STYLE_ITEM_LIST("faceStyleItemList"),
        CUSTOM_STYLE_FILTER_CONFIG_FILE("customStyleFilterConfigFile"),
        CUSTOM_FILTER_CONFIG_FILE("customFilterConfigFile"),
        CUSTOM_COSFUN_INNER_FILTER_CONFIG_FILE("customCosFunInnerFilterConfigFile"),
        NUMBER_ROLL_EFFECT("numberRollEffect"),
        CHARM_RANGE("charmRange"),
        WATERMARK_GROUP("watermarkGroup"),
        STICKER_ORDER_MODE("stickerOrderMode"),
        MUSIC_ID("musicID"),
        DEPTHTYPE("rgbDepthType"),
        MASK_TYPE("maskType"),
        MASK_PAINT_TYPE("maskPaintType"),
        MASK_PAINT_SIZE("maskPaintSize"),
        MASK_PAINT_IMAGE("maskPaintImage"),
        MASK_PAINT_RENDER_ID("maskPaintRenderId"),
        ORDER_MODE("orderMode"),
        FACE_MESH_ITEM_LIST("faceMeshItemList"),
        FACE_MOVE_LIST("faceMoveList"),
        FACE_MOVE_TRIANGLE("faceMoveTriangle"),
        CATEGORY_FLAG("categoryFlag");

        public final String value;

        FIELD(String str) {
            this.value = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum GLB_FIELD {
        GLB_LIST("glbList"),
        NODE_LIST("nodeList"),
        DYNAMICBONE_LIST("dynamicBoneList"),
        EXPRESSION_ORDER_LIST("expressionOrderList"),
        EXPRESSION_CONFIG_LIST("expressionConfigList"),
        EXPRESSION_CONFIG_VERSION("expressionConfigVersion"),
        ANIMATION__LIST("animationList"),
        PATH("path"),
        IBLPATH("iblPath"),
        BLEND_ALPHA("blendShapeAdjustAlpha"),
        IBL_INTENSITY("iblIntensity"),
        IBL_ROTATION("iblRotation"),
        ORDER("order"),
        HIDE_USER_HEAD_MODEL("hideUserHeadModel"),
        USE_3DMM_TRANSFORM("use3DMMTransform"),
        NEED_AVATAR_FACEKIT("needAvatarFacekit"),
        NEED_FACE_MESH_FACEKIT("needFaceMeshFacekit"),
        TRANSFORM_ADJUST_ALPHA("featureTransformAdjustAlpha"),
        FOV("fov"),
        COLLIDER_LIST("colliderList"),
        TRANSLATE(CanvasView.ACTION_TRANSLATE),
        ROTATE(CanvasView.ACTION_ROTATE),
        ROTATE_TYPE("rotateType"),
        FLIP("flip"),
        EYE_NODE_LIST("eyeNodeList"),
        EULER_ANGLES("eulerAngles"),
        SCALE("scale"),
        LIGHT(MiniAppConst.MENU_STYLE_LIGHT),
        BLOOM("bloom"),
        DIRECTION("direction"),
        COLOR("color"),
        INTENSITY("intensity"),
        CAST_SHADOW("castShadow"),
        NAME("name"),
        FACEMESH("faceMesh"),
        CONTENT("content"),
        MODEL_ID("modelId"),
        ROOTNAME("rootName"),
        NO_ROTATE_UPDATE("noRotationUpdate"),
        BONE_COUNT("boneCount"),
        BONE_PARAM_LIST("boneParamsList"),
        GRAVITY(LayoutAttrDefine.Gravity.Gravity),
        TRIGGER_TYPE("triggerType"),
        EXTERNAL_TRIGGER_WORDS("externalTriggerWords"),
        FRAMES("frames"),
        FRAME_DURATION("frameDuration"),
        ALWAYS_TRIGGERED("alwaysTriggered"),
        PLAY_COUNT("playCount"),
        ROTATE_REQUIRED("rotateRequied"),
        MATERIAL(WadlProxyConsts.KEY_MATERIAL),
        ACTIVE_TYPE("activateTriggerType"),
        ACTIVE_COUNT("activateTriggerCount"),
        ACTIVE_TOTAL_COUNT("activateTriggerTotalCount"),
        NEED_HIDE_ENTITY("hideEntity"),
        NEED_SHOW("needShow"),
        SHAPE_NAME("shapeName"),
        CONTROLLED_NAME("controlledName"),
        SHAPE_RANGE("shapeRange"),
        ENABLE_SSAO("enableSSAO"),
        POSITION_TYPE("positionType");

        public final String value;

        GLB_FIELD(String str) {
            this.value = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum ITEM_SOURCE_TYPE {
        IMAGE,
        VIDEO_UP_DOWN,
        VIDEO_LEFT_RIGHT,
        VIDEO_NORMAL,
        PAG
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum PARTICLE_CLEAR_MODE {
        DO_NOT_CLEAR(0),
        CLEAR_ALL(1);

        public int value;

        PARTICLE_CLEAR_MODE(int i3) {
            this.value = i3;
        }
    }

    public static List<PointF> arrayToPointList(int[][] iArr) {
        ArrayList arrayList = new ArrayList();
        if (iArr == null) {
            return arrayList;
        }
        for (int[] iArr2 : iArr) {
            arrayList.add(new PointF(iArr2[0], iArr2[1]));
        }
        return arrayList;
    }

    public static int calSampleSize(long j3, long j16) {
        if (j3 <= 0) {
            return 128;
        }
        int i3 = 1;
        while (j16 > j3) {
            i3 <<= 1;
            j16 >>= 2;
        }
        return i3;
    }

    public static List<PointF> copyList(List<PointF> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (PointF pointF : list) {
            arrayList.add(new PointF(pointF.x, pointF.y));
        }
        return arrayList;
    }

    public static List<PointF> genFullScreenVertices(int i3, int i16, float f16, float f17, float f18, float f19) {
        ArrayList arrayList = new ArrayList();
        if (i3 > 0 && i16 > 0) {
            float f26 = (f17 - f16) / i3;
            float f27 = (f19 - f18) / i16;
            arrayList.add(new PointF(getCoordinate(f16, f26, 0), getCoordinate(f18, f27, 0)));
            for (int i17 = 0; i17 < i3; i17++) {
                if (i17 % 2 == 0) {
                    int i18 = 0;
                    while (i18 < i16) {
                        arrayList.add(new PointF(getCoordinate(f16, f26, i17 + 1), getCoordinate(f18, f27, i18)));
                        i18++;
                        arrayList.add(new PointF(getCoordinate(f16, f26, i17), getCoordinate(f18, f27, i18)));
                    }
                    arrayList.add(new PointF(getCoordinate(f16, f26, i17 + 1), getCoordinate(f18, f27, i16)));
                } else {
                    for (int i19 = i16; i19 > 0; i19--) {
                        arrayList.add(new PointF(getCoordinate(f16, f26, i17 + 1), getCoordinate(f18, f27, i19)));
                        arrayList.add(new PointF(getCoordinate(f16, f26, i17), getCoordinate(f18, f27, i19 - 1)));
                    }
                    arrayList.add(new PointF(getCoordinate(f16, f26, i17 + 1), getCoordinate(f18, f27, 0)));
                }
            }
        }
        return arrayList;
    }

    public static int getAllImageSize(String str) {
        int i3;
        int length;
        if (str.startsWith("assets://")) {
            try {
                String[] list = AEModule.getContext().getAssets().list(FileUtils.getRealPath(str));
                if (list != null && list.length != 0) {
                    Point bitmapSize = BitmapUtils.getBitmapSize(AEModule.getContext(), str + File.separator + list[0]);
                    if (bitmapSize == null) {
                        return 0;
                    }
                    i3 = bitmapSize.x * bitmapSize.y * 4;
                    length = list.length;
                }
                return 0;
            } catch (IOException e16) {
                e16.printStackTrace();
                return 0;
            }
        }
        String[] list2 = new File(str).list(mPngFilter);
        if (list2 == null || list2.length == 0) {
            return 0;
        }
        Point bitmapSize2 = BitmapUtils.getBitmapSize(AEModule.getContext(), str + File.separator + list2[0]);
        if (bitmapSize2 == null) {
            return 0;
        }
        i3 = bitmapSize2.x * bitmapSize2.y * 4;
        length = list2.length;
        return 0 + (i3 * length);
    }

    private static float getCoordinate(float f16, float f17, int i3) {
        return f16 + (i3 * f17);
    }

    public static String getMaterialId(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(File.separator);
        for (int length = split.length - 1; length >= 0; length--) {
            if (!TextUtils.isEmpty(split[length])) {
                return split[length];
            }
        }
        return null;
    }

    public static float[][] listToFloatArray(List<PointF> list) {
        if (list == null) {
            return new float[0];
        }
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, list.size(), 2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            fArr[i3][0] = list.get(i3).x;
            fArr[i3][1] = list.get(i3).y;
        }
        return fArr;
    }

    public static int[][] listToIntArray(List<PointF> list) {
        if (list == null) {
            return new int[0];
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, list.size(), 2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            iArr[i3][0] = (int) list.get(i3).x;
            iArr[i3][1] = (int) list.get(i3).y;
        }
        return iArr;
    }

    public static VideoMaterial loadLightAsset(String str) {
        VideoMaterial videoMaterial = new VideoMaterial();
        videoMaterial.setDataPath(str);
        videoMaterial.setId(getMaterialId(str));
        videoMaterial.lightAsset = LightAsset.Load(str, 0);
        return videoMaterial;
    }

    public static boolean needCopyTransform() {
        String trim = DeviceInstance.getInstance().getDeviceName().trim();
        if (!TextUtils.isEmpty(trim)) {
            for (String str : DEVICE_NEED_COPY_TRANSFORM) {
                if (trim.toLowerCase().endsWith(str.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean needReal3DMM() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.3dmm")) {
            return true;
        }
        return false;
    }

    public static float[] toFlatArray(PointF[] pointFArr) {
        if (pointFArr == null) {
            return new float[0];
        }
        try {
            float[] fArr = new float[pointFArr.length * 2];
            for (int i3 = 0; i3 < pointFArr.length; i3++) {
                PointF pointF = pointFArr[i3];
                if (pointF != null) {
                    int i16 = i3 * 2;
                    fArr[i16] = pointF.x;
                    fArr[i16 + 1] = pointF.y;
                }
            }
            return fArr;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return new float[0];
        }
    }

    public void createTipsDrawableInfo(Resources resources, String str, String str2, int i3, int i16) {
        int i17;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str + File.separator + str2);
            if (file.isDirectory()) {
                ArrayList arrayList = new ArrayList();
                int i18 = 0;
                for (File file2 : file.listFiles()) {
                    if (!file2.getName().startsWith(".")) {
                        arrayList.add(file2);
                    }
                }
                int size = arrayList.size();
                final int[] iArr = new int[size];
                for (int i19 = 0; i19 < arrayList.size(); i19++) {
                    String name = ((File) arrayList.get(i19)).getName();
                    iArr[i19] = Integer.parseInt(name.substring(str2.length() + 1, name.lastIndexOf(46)));
                }
                Integer[] numArr = new Integer[size];
                for (int i26 = 0; i26 < size; i26++) {
                    numArr[i26] = Integer.valueOf(i26);
                }
                Arrays.sort(numArr, new Comparator<Integer>() { // from class: com.tencent.ttpic.openapi.model.VideoMaterial.1
                    @Override // java.util.Comparator
                    public int compare(Integer num, Integer num2) {
                        return iArr[num.intValue()] - iArr[num2.intValue()];
                    }
                });
                int[] iArr2 = new int[size];
                while (true) {
                    i17 = size - 1;
                    if (i18 >= i17) {
                        break;
                    }
                    int i27 = i18 + 1;
                    iArr2[i18] = (iArr[numArr[i27].intValue()] - iArr[numArr[i18].intValue()]) * i3;
                    i18 = i27;
                }
                if (size >= 1) {
                    iArr2[i17] = i3 * (i16 - iArr[numArr[i17].intValue()]);
                }
                this.tipsDrawableInfo = new LazyLoadAnimationDrawable.Info(resources, arrayList, iArr2, numArr);
            }
        }
    }

    public float[] getArShaderPlanOffset() {
        return this.arShaderPlanOffset;
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public String getId() {
        String str;
        String str2 = this.f381704id;
        if ((str2 == null || str2.length() == 0) && (str = this.dataPath) != null && str.length() > 0) {
            this.f381704id = getMaterialId(this.dataPath);
        }
        return this.f381704id;
    }

    public boolean getIsAR3DMaterial() {
        return this.isAR3DMaterial;
    }

    public LightAsset getLightAsset() {
        return this.lightAsset;
    }

    public int getShaderType() {
        return this.shaderType;
    }

    public LazyLoadAnimationDrawable getTipsDrawable() {
        if (this.tipsDrawableInfo == null) {
            return null;
        }
        return new LazyLoadAnimationDrawable(this.tipsDrawableInfo);
    }

    public String getTipsIcon() {
        return null;
    }

    public String getTipsText() {
        return null;
    }

    public boolean hasInnerBeauty() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("materialLUT.enable")) {
            return true;
        }
        return false;
    }

    public boolean isAR3DMaterial() {
        return getIsAR3DMaterial();
    }

    public boolean isAudio2textMaterial() {
        return false;
    }

    public boolean isCyberpunkMaterial() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility(LightConstants.AssetFeatureKey.HAS_CYBERPUNK)) {
            return true;
        }
        return false;
    }

    public boolean isEditableWatermark() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility(LightConstants.AssetFeatureKey.HAS_EDIT_WATERMARK)) {
            return true;
        }
        return false;
    }

    public boolean isFace3DMaterial() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.face3d")) {
            return true;
        }
        return false;
    }

    public boolean isFaceMarkingMaterial() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility(LightConstants.LIGHT_ASSET.ASSET_IS_FACE_MARKING)) {
            return true;
        }
        return false;
    }

    public boolean isFreezeFrameRequired() {
        return this.isFreezeFrameRequired;
    }

    public boolean isGestureDetectMaterial() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null) {
            return lightAsset.needRenderAbility("ai.hand");
        }
        return false;
    }

    public boolean isNeedFreezeFrame() {
        return this.isFreezeFrameRequired;
    }

    public boolean isParticleMaterial() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("material.particle")) {
            return true;
        }
        return false;
    }

    public boolean isSticker3DMaterial() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("material.sticker3d")) {
            return true;
        }
        return false;
    }

    public boolean isTNNMaterial() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.gan")) {
            return true;
        }
        return false;
    }

    public boolean isUse3DMMTransform() {
        return isFace3DMaterial();
    }

    public boolean isUseMesh() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("material.mesh")) {
            return true;
        }
        return false;
    }

    public boolean isWatermarkMaterial() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility(LightConstants.AssetFeatureKey.HAS_WATERMARK)) {
            return true;
        }
        return false;
    }

    public boolean need3DMM() {
        if (!isSticker3DMaterial() && !isFace3DMaterial() && !needPout() && !needReal3DMM()) {
            return false;
        }
        return true;
    }

    public boolean needAce3D() {
        return isSticker3DMaterial();
    }

    public boolean needAvatar2D() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("material.isAvatar2D")) {
            return true;
        }
        return false;
    }

    public boolean needBody3D() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.body3d")) {
            return true;
        }
        return false;
    }

    public boolean needBodyDetect() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.body")) {
            return true;
        }
        return false;
    }

    public boolean needBodySegment() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.segment")) {
            return true;
        }
        return false;
    }

    public boolean needDetectCat() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.catFace")) {
            return true;
        }
        return false;
    }

    public boolean needDetectGender() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.faceStaticFeature")) {
            return true;
        }
        return false;
    }

    public boolean needEmotion() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.emotion")) {
            return true;
        }
        return false;
    }

    public boolean needFaceInfo() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.face")) {
            return true;
        }
        return false;
    }

    public boolean needHairSegment() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.segmentHair")) {
            return true;
        }
        return false;
    }

    public boolean needHandDetect() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.hand")) {
            return true;
        }
        return false;
    }

    public boolean needHeadSegment() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.headInset")) {
            return true;
        }
        return false;
    }

    public boolean needPag() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("material.pag")) {
            return true;
        }
        return false;
    }

    public boolean needPout() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility(LightConstants.LIGHT_ASSET.ASSET_IS_POUT)) {
            return true;
        }
        return false;
    }

    public boolean needRGBDepth() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.rgbDepth")) {
            return true;
        }
        return false;
    }

    public boolean needResetWhenRecord() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needResetAssetWhenStartRecord()) {
            return true;
        }
        return false;
    }

    public boolean needSkySegment() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("ai.segmentSky")) {
            return true;
        }
        return false;
    }

    public boolean needVoiceChange() {
        LightAsset lightAsset = this.lightAsset;
        if (lightAsset != null && lightAsset.needRenderAbility("material.voiceChange")) {
            return true;
        }
        return false;
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public void setId(String str) {
        this.f381704id = str;
    }

    public void setShaderType(int i3) {
        this.shaderType = i3;
    }

    public String toString() {
        return "VideoMaterial{dataPath='" + this.dataPath + "', id='" + this.f381704id + "', useMesh=" + isUseMesh() + ", segmentRequired=" + needBodySegment() + ", needFaceInfo=" + needFaceInfo() + '}';
    }
}
