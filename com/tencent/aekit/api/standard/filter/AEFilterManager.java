package com.tencent.aekit.api.standard.filter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.hardware.SensorEvent;
import android.media.AudioTrack;
import android.opengl.GLES20;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEFilterChain;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.openrender.util.IAEProfiler;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.camerasdk.avreport.PreviewPerformanceInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.AdjustRealConfig;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.listener.LightNodeAppliedListener;
import com.tencent.ttpic.openapi.listener.MaterialLoadFinishListener;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.plugin.AICtrl;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.params.LightBasicBeauty;
import com.tencent.vbox.VboxFactory;
import com.tencent.vbox.decode.VboxDecoder;
import com.tencent.vbox.util.VideoUtil;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import org.light.AudioFrame;
import org.light.AudioOutput;
import org.light.AudioPlaceHolder;
import org.light.CameraConfig;
import org.light.DeviceCameraConfig;
import org.light.LightAsset;
import org.light.LightConstants;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.WatermarkConfig;
import org.light.avatar.AvatarAIInfo;
import org.light.bean.LightAIDataWrapper;
import org.light.bean.WMElement;
import org.light.callback.ExternalRenderCallback;
import org.light.listener.OnClickWatermarkListener;
import org.light.listener.OnLoadAssetListener;
import org.light.listener.OnWatermarkDataListener;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEFilterManager implements IWatermarkHandle {
    static IPatchRedirector $redirector_ = null;
    private static final String DIEJIA_MATERIAL_NAME = "video_diejia_";
    private static final int MAX_RENDER_LENGTH_FOR_STROKE = 1080;
    private static final int MIN_RENDER_LENGTH_FOR_STROKE = 640;
    private static final SizeI NET_SIZE;
    public static final String SET_TEMP_FACEATTR = "SET_TEMP_FACEATTR";
    private static final String TAG = "AEFilterManager";
    private static final String TEST_PIC = "sample_input_16_9_1080.jpg";
    public static int colorfulness;
    public static int contrast;
    public static int lightness;
    public static String mVideoFilterName;
    public static int overexposure;
    public static int saturation;
    public static int sharpness;
    public static int temperature;
    public static int underexposure;
    private float adjustAlpha;
    private HashMap<String, String> adjustParams;
    private Map<String, String> aiSwitchMap;
    boolean assetListenerUpdated;
    private AudioOutput audioReader;
    private AudioTrack audioTrack;
    private boolean avatarMode;
    private int beautyContrastRatio;
    private int beautyEyeLighten;
    private int beautyFaceAlphaRedCheek;
    private int beautyFaceAlphaSoft;
    private int beautyFaceEyeMakeup;
    private int beautyFaceLipsLutAlpha;
    private int beautyLutClearAlpha;
    private int beautyLutFoundationAlpah;
    private float beautyNormalAlpha;
    private int beautyRemovePounch;
    private int beautyRemoveWrinkles;
    private int beautyRemoveWrinkles2;
    private int beautySkinColor;
    private int beautySkinLevel;
    private int beautyToothWhiten;
    private boolean beautyUpdated;
    private boolean beginVideoCodeProgress;
    private HashMap<String, String> bundlePathMap;
    boolean cameraExposureListenerUpdated;
    private boolean closeAIBeautyConfig;
    private int colorTemperature;
    private int compareLevel;
    private Map<String, String> configData;
    private int cosmeticsAlpha;
    private boolean cosmeticsAlphaUpdated;
    private String customMaterialPath;
    private boolean customMaterialUpdated;
    private int decodeTexture;
    private BeautyRealConfig.TYPE defaultTransBasicType;
    private HashMap<String, Integer> detectShorterLengthMap;
    private String[] deviceSupportAbility;
    private int douyinFactorSmall;
    private int douyinFactorThin;
    private int encodeTexture;
    private int exposureValue;
    ExternalRenderCallback externalRenderCallback;
    private boolean externalRenderUpdated;
    private Map<String, String> extraConfigData;
    private boolean extraConfigUpdated;
    private PTFaceAttr faceAttrInLight;
    private boolean faceDataUpdated;
    private boolean faceFeatureOpen;
    private boolean faceFeatureUpdated;
    private boolean faceGodOpen;
    private boolean faceGoddessOpen;
    private boolean faceNatureOpen;
    private boolean faceThinTypeUpdated;
    private boolean factorSmallUpdated;
    private boolean factorThinUpdated;
    private int fadeLevel;
    private HashMap<Integer, Boolean> filterConfigMap;
    private HashMap<String, String> filterInLightNodeMap;
    private boolean filterInLightUpdated;
    private boolean filterInSmooth;
    private boolean flipBeforeRenderUpdated;
    private boolean forceFaceDetect;
    private float glowAlpha;
    private int height;
    private int hightLightLevel;
    private boolean isAfterUpdateMaterial;
    private boolean isAudioPaused;
    private boolean isBgmHidden;
    private boolean isLowLightEnv;
    private boolean isNeedPictureTest;
    private boolean isNeedSkipFrame;
    private boolean isOverallSmooth;
    boolean isPicNeedFlipBeforeRender;
    private boolean isRealtime;
    private boolean isVeryLowEndDevice;
    private String lightAppEntry;
    private String lightAppId;
    private CameraConfig.ImageOrigin lightInputOriention;
    private String lightLicensePath;
    private LightNodeAppliedListener lightNodeAppliedListener;
    private int lightnessLevel;
    private boolean lipsBarUpdate;
    private int longLeg;
    private boolean lutAlphaUpdate;
    private boolean lutPathUpdated;
    private AEFilterChain mAEFilterChain;
    private IAEProfiler mAEProfiler;
    private AIBeautyParamsJsonBean mAIBeautyParamsJsonBean;
    private boolean mAIBeautyValid;
    private AIAttr mAiAttr;
    private boolean mAiBeautyEnable;
    private boolean mAiBeautyUpdated;
    private AICtrl mAiCtrl;
    private AIParam mAiParam;
    private boolean mAssetUpdate;
    private boolean mAsyncInitFilters;
    private boolean mAutoTest;
    private String mAutoTestSmoothVersion;
    private int mAutoTestSourceType;
    private LightNode.ILightNodeCameraExposureListener mCameraExposureListener;
    private volatile boolean mDestroyed;
    private Map<Integer, Boolean> mFilterNodeEnableMap;
    private List<Integer> mFilterOrderList;
    private int mFrameIndex;
    private AEGlow mGlow;
    private float mIntensity;
    private boolean mIsInited;
    private OnLoadAssetListener mLightAssetListener;
    private ConcurrentHashMap<String, LightBasicBeauty> mLightBasicParams;
    private LightNode mLightNode;
    private final ConcurrentHashMap<String, String> mLightNodeControllerPresetData;
    private boolean mLogFlag;
    private String mLutPath;
    private float mPhoneRoll;
    private Bitmap mPickUpBitmap;
    private List<Bitmap> mPickUpBitmapList;
    private Bitmap mTestBmp;
    private LightNode.ILightNodeTipsListener mTipsListener;
    private VideoMaterial mVideoMaterial;
    private double mViewAspectRatio;
    private OnClickWatermarkListener mWatermarkClickListener;
    private int makeupAlpha;
    private boolean makeupAlphaUpdated;
    private MaterialLoadFinishListener materialLoadFinishListener;
    private boolean needFaceDetect;
    private boolean needLowEndDownGrade;
    private boolean needUpdateAIFilter;
    private int outputTexture;
    private boolean pendingToSetBundles;
    private int phoneRotation;
    private boolean previewSizeUpdated;
    private PTFaceAttr ptFaceAttr;
    private boolean redCheekBarUpdate;
    private ImageStatisticsData resultData;
    private float[] rotationMatrix;
    private int saturationLevel;
    private int segBgColor;
    private int segStrokeColor;
    private float segStrokeGapInPixel;
    private float segStrokeWidthInPixel;
    private int segmentFrames;
    private boolean segmentUpdated;
    private String selectedBasicTransType;
    private int selectedBasicTransValue;
    private int shadowLevel;
    private int sharpLevel;
    private int slimWaist;
    private int smallHead;
    private List<Bitmap> smartBitmapList;
    private int smoothLevel;
    private float smoothSharpenStrength;
    private boolean smoothUpdated;
    private final String smoothVersion;
    private boolean softFaceBarUpdate;
    private MaterialInnerEffectListener stickerInnerLutFilterListener;
    private boolean syncMode;
    private boolean syncModeUpdated;
    private int[] testBmpTexture;
    private int[] textures;
    private int thinBody;
    private int thinBodyV2;
    private int thinLeg;
    private int thinShoulder;
    boolean tipsListenerUpdated;
    private int transBasic3;
    private int transBasic4;
    private int transBasic5;
    private int transBasic6;
    private int transBasic7;
    private int transBasic8;
    private int transCheekboneThin;
    private int transChin;
    private int transEye;
    private int transEyeAngle;
    private int transEyeDistance;
    private int transFaceShorten;
    private int transFaceThin;
    private int transFaceV;
    private int transForehead;
    private int transLipsThickness;
    private int transLipsWidth;
    private int transMouthShape;
    private int transNose;
    private int transNosePosition;
    private int transNoseWing;
    private IUEAbilityBase ueAbility;
    private int useLutType;
    private int useMeshType;
    private WatermarkConfig watermarkConfig;
    private int width;
    boolean wmClickListenerUpdated;
    private HashMap<String, OnWatermarkDataListener> wmDelegateMap;
    boolean wmOnlineUsrCountDelegateUpdated;
    private Thread writePCMThread;
    private IZplanFilamentAbility zplanFilamentAbility;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aekit.api.standard.filter.AEFilterManager$5, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE;
        static final /* synthetic */ int[] $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12157);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BeautyRealConfig.TYPE.values().length];
            $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE = iArr;
            try {
                iArr[BeautyRealConfig.TYPE.EXPOSURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.FACTOR_THIN_NEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.FACTOR_SMALL_NEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.BEAUTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.EYE_LIGHTEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.TOOTH_WHITEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.REMOVE_POUNCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.REMOVE_WRINKLES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.REMOVE_WRINKLES2.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.COLOR_TONE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.CONTRAST_RATIO.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.LUT_CLERA_ALPHA.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.LUT_FOUNDATION_ALPHA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.FACE_FEATURE_SOFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.EYE_MAKEUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.FOREHEAD.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.EYE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.EYE_DISTANCE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.EYE_ANGLE.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.MOUTH_SHAPE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.CHIN.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.FACE_THIN.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.FACE_V.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.NOSE_WING.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.NOSE_POSITION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.LIPS_THICKNESS.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.LIPS_WIDTH.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.NOSE.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.CHEEKBONE_THIN.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.FACE_SHORTEN.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.BASIC3.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.BASIC4.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.BASIC5.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.BASIC6.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.BASIC7.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.BASIC8.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.LONG_LEG.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.SLIM_WAIST.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.THIN_SHOULDER.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.THIN_BODY.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.BODY_AUTOTHIN_BODY.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.BODY_SLIM_HEAD.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[BeautyRealConfig.TYPE.BODY_SLIM_LEG.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            int[] iArr2 = new int[AdjustRealConfig.TYPE.values().length];
            $SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE = iArr2;
            try {
                iArr2[AdjustRealConfig.TYPE.LIGHTNESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[AdjustRealConfig.TYPE.HIGHLIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[AdjustRealConfig.TYPE.SHADOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[AdjustRealConfig.TYPE.COMPARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[AdjustRealConfig.TYPE.SHARP.ordinal()] = 5;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[AdjustRealConfig.TYPE.SATURATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[AdjustRealConfig.TYPE.COLOR_TEMPERATURE.ordinal()] = 7;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[AdjustRealConfig.TYPE.FADE.ordinal()] = 8;
            } catch (NoSuchFieldError unused53) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class FilterType {
        static IPatchRedirector $redirector_ = null;
        public static final int GLOW = 300;
        public static final int LIGHT_NODE = 100;

        public FilterType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface MaterialInnerEffectListener {
        public static final int LUT_IN_LIGHT_NODE = 1001;
        public static final int LUT_IN_MATERIAL = 1000;
        public static final int MESH_IN_LIGHT_NODE = 2001;
        public static final int MESH_IN_MATERIAL = 2000;

        void notifyEnableLutType(int i3);

        void notifyEnableMeshType(int i3);

        void onDeviceNotSupportMaterial();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12168);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 141)) {
            redirector.redirect((short) 141);
        } else {
            NET_SIZE = new SizeI(320, 320);
        }
    }

    public AEFilterManager() {
        this("defaultBeautyV6.json", false, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }

    private void applyVideoMaterial(@NonNull VideoMaterial videoMaterial, @NonNull LightNode lightNode) {
        if (videoMaterial.getLightAsset() == lightNode.getAsset()) {
            return;
        }
        if (this.zplanFilamentAbility != null && videoMaterial.getId() != null && this.zplanFilamentAbility.isFilamentMaterial(videoMaterial.getId()) && !this.zplanFilamentAbility.isFilamentReady()) {
            return;
        }
        IUEAbilityBase iUEAbilityBase = this.ueAbility;
        if (iUEAbilityBase != null && iUEAbilityBase.isUEMaterial(videoMaterial) && !this.ueAbility.isUEReady()) {
            IUEAbilityBase iUEAbilityBase2 = this.ueAbility;
            if (iUEAbilityBase2 instanceof IUEAbility) {
                LightSurface lightSurface = lightNode.getLightSurface();
                if (lightSurface != null) {
                    ((IUEAbility) this.ueAbility).startUE(lightSurface, this.width, this.height);
                    return;
                }
                return;
            }
            if (iUEAbilityBase2 instanceof IUEAbilityV2) {
                ((IUEAbilityV2) iUEAbilityBase2).startUE(AEModule.getContext());
                return;
            }
            return;
        }
        lightNode.updateAsset(videoMaterial.getLightAsset());
    }

    private void chainFilters() {
        AEGlow aEGlow;
        IAEProfiler iAEProfiler = this.mAEProfiler;
        if (iAEProfiler != null) {
            iAEProfiler.startByTag(IAEProfiler.TAG_CHAIN_FILTERS);
        }
        this.mAEFilterChain.clearFilterList();
        Iterator<Integer> it = this.mFilterOrderList.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (this.mFilterNodeEnableMap.get(Integer.valueOf(intValue)).booleanValue()) {
                if (intValue != 100) {
                    if (intValue == 300 && (aEGlow = this.mGlow) != null) {
                        this.mAEFilterChain.add(aEGlow);
                    }
                } else {
                    LightNode lightNode = this.mLightNode;
                    if (lightNode != null) {
                        this.mAEFilterChain.add(lightNode);
                    }
                }
            }
        }
        IAEProfiler iAEProfiler2 = this.mAEProfiler;
        if (iAEProfiler2 != null) {
            iAEProfiler2.endByTag(IAEProfiler.TAG_CHAIN_FILTERS);
        }
    }

    private int changeTextureIfNeed(boolean z16, int i3) {
        if (!z16) {
            return i3;
        }
        if (this.mTestBmp == null) {
            this.mTestBmp = decodeBitmap(TEST_PIC);
        }
        int bmpToTextue = getBmpToTextue(this.mTestBmp);
        if (bmpToTextue != -1) {
            return bmpToTextue;
        }
        return i3;
    }

    private void checkLightBasicParam() {
        LightNode lightNode;
        ConcurrentHashMap<String, LightBasicBeauty> concurrentHashMap = this.mLightBasicParams;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0 && (lightNode = this.mLightNode) != null && lightNode.isApplied()) {
            LightBasicBeauty lightBasicBeauty = this.mLightBasicParams.get(LightBasicBeauty.BASIC_MULTIPLY);
            if (lightBasicBeauty != null) {
                openAndUpdateBasicMultiply(lightBasicBeauty.getPath(), lightBasicBeauty.getDefValue());
            }
            LightBasicBeauty lightBasicBeauty2 = this.mLightBasicParams.get(LightBasicBeauty.BASIC_SOFT_LIGHT);
            if (lightBasicBeauty2 != null) {
                openAndUpdateBasicSoftLight(lightBasicBeauty2.getPath(), lightBasicBeauty2.getDefValue());
            }
            LightBasicBeauty lightBasicBeauty3 = this.mLightBasicParams.get(LightBasicBeauty.BASIC_BASIC_LIPS);
            if (lightBasicBeauty3 != null) {
                openAndUpdateBasicLips(lightBasicBeauty3.getPath(), lightBasicBeauty3.getDefValue(), lightBasicBeauty3.getType());
            }
            this.mLightBasicParams.clear();
            LogUtils.i(TAG, "lightsdk \u7f8e\u989c\u6570\u636e\u6062\u590d\u5b8c\u6210");
        }
    }

    private void clearSharedResources() {
        ShaderManager.getInstance().clear();
        FrameBufferCache.getInstance().destroy();
        PreviewPerformanceInfo.getInstance().destroy();
    }

    private void configFilters() {
        AEGlow aEGlow;
        boolean z16;
        IAEProfiler iAEProfiler = this.mAEProfiler;
        if (iAEProfiler != null) {
            iAEProfiler.startByTag(IAEProfiler.TAG_CONFIG_FILTERS);
            this.mAEProfiler.startByTag(IAEProfiler.TAG_GL_WAIT_FACE_Time);
        }
        IAEProfiler iAEProfiler2 = this.mAEProfiler;
        if (iAEProfiler2 != null) {
            iAEProfiler2.endByTag(IAEProfiler.TAG_GL_WAIT_FACE_Time);
        }
        for (Map.Entry<Integer, Boolean> entry : this.mFilterNodeEnableMap.entrySet()) {
            if (entry.getValue().booleanValue()) {
                AEProfiler.getInstance().start("IAEProfiler-configFilters-" + entry.getKey(), true);
                int intValue = entry.getKey().intValue();
                if (intValue != 100) {
                    if (intValue == 300 && (aEGlow = this.mGlow) != null) {
                        aEGlow.setAlpha(this.glowAlpha);
                    }
                } else {
                    LightNode lightNode = this.mLightNode;
                    if (lightNode != null) {
                        boolean z17 = this.mAutoTest;
                        if (!z17 || this.mAutoTestSourceType != 0) {
                            if (z17 && this.mAutoTestSourceType > 1) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            lightNode.setAutoTest(z16);
                            if (this.mAutoTest) {
                                LightNode lightNode2 = this.mLightNode;
                                int i3 = this.mFrameIndex;
                                this.mFrameIndex = i3 + 1;
                                lightNode2.setFrameIndex(i3);
                            }
                            VideoMaterial videoMaterial = this.mVideoMaterial;
                            if (videoMaterial != null) {
                                applyVideoMaterial(videoMaterial, this.mLightNode);
                            }
                            if (!this.mLightNodeControllerPresetData.isEmpty()) {
                                LogUtils.d(TAG, "configFilters---mLightNodeControllerPresetData=" + this.mLightNodeControllerPresetData);
                                for (Map.Entry<String, String> entry2 : this.mLightNodeControllerPresetData.entrySet()) {
                                    this.mLightNode.setAssetData(entry2.getKey(), entry2.getValue());
                                }
                                this.mLightNodeControllerPresetData.clear();
                            }
                            Map<String, String> map = this.configData;
                            if (map == null) {
                                this.configData = new ConcurrentHashMap();
                            } else {
                                map.clear();
                            }
                            String str = "";
                            if (this.smoothUpdated) {
                                this.configData.put("smooth.smooth", formatDecimalValue(this.smoothLevel));
                                this.configData.put("smooth.overallSmooth", formatBooleanValue(this.isOverallSmooth));
                                this.configData.put("smooth.isVeryLowEndDevice", formatBooleanValue(this.isVeryLowEndDevice));
                                this.configData.put("smooth.sharpen", "" + this.smoothSharpenStrength);
                                this.configData.put("smooth.exposureValue", formatDecimalValue(this.exposureValue));
                                this.smoothUpdated = false;
                            }
                            if (this.beautyUpdated) {
                                this.configData.put("body.legStretch", formatDecimalValue(this.longLeg));
                                this.configData.put("body.thinShoulderStrength", formatDecimalValue(this.thinShoulder));
                                this.configData.put("body.thinBodyStrength", formatDecimalValue(this.thinBody));
                                this.configData.put("body.waistStrength", formatDecimalValue(this.slimWaist));
                                this.configData.put(LightConstants.BeautyBodyConfigKey.BODY_AUTOTHIN_BODY_STRENGTH, formatDecimalValue(this.thinBodyV2));
                                this.configData.put(LightConstants.BeautyBodyConfigKey.BODY_SLIM_HEAD_STRENGTH, formatDecimalValue(this.smallHead));
                                this.configData.put(LightConstants.BeautyBodyConfigKey.BODY_SLIM_LEG_STRENGTH, formatDecimalValue(this.thinLeg));
                                if (this.softFaceBarUpdate) {
                                    this.configData.put("beauty.faceFeatureSoftlight", formatDecimalValue((int) this.beautyNormalAlpha));
                                    this.softFaceBarUpdate = false;
                                }
                                this.configData.put("smooth.brightenEyeAlpha", formatDecimalValue(this.beautyEyeLighten));
                                this.configData.put("beauty.toothWhiten", formatDecimalValue(this.beautyToothWhiten));
                                this.configData.put("beauty.removeEyeBags", formatDecimalValue(this.beautyRemovePounch));
                                this.configData.put("beauty.removeWrinkle", formatDecimalValue(this.beautyRemoveWrinkles));
                                this.configData.put("beauty.removeLawLine", formatDecimalValue(this.beautyRemoveWrinkles2));
                                this.configData.put("beauty.skinColor", formatDecimalValue(this.beautySkinColor));
                                this.configData.put("beauty.imageContrastAlpha", formatDecimalValue(this.beautyContrastRatio));
                                this.configData.put("beauty.lutClearAlpha", formatDecimalValue(this.beautyLutClearAlpha));
                                this.configData.put("beauty.lutFoundationAlpha", formatDecimalValue(this.beautyLutFoundationAlpah));
                                this.configData.put(LightConstants.BeautyConfigKey.BEAUTY_EYEMAKEUP_STRENGTH, formatDecimalValue(this.beautyFaceEyeMakeup));
                                if (this.redCheekBarUpdate) {
                                    this.configData.put("beauty.faceFeatureRedCheek", formatDecimalValue(this.beautyFaceAlphaRedCheek));
                                    this.redCheekBarUpdate = false;
                                }
                                if (this.lipsBarUpdate) {
                                    this.configData.put("beauty.faceFeatureLipsLut", formatDecimalValue(this.beautyFaceLipsLutAlpha));
                                    this.lipsBarUpdate = false;
                                }
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_EYE_DISTANCE_UNIFORM, formatDecimalValue(this.transEyeDistance));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_EYE_ANGLE_UNIFORM, formatDecimalValue(this.transEyeAngle));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_ENLARGE_EYE_UNIFORM, formatDecimalValue(this.transEye));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_THIN_FACE_UNIFORM, formatDecimalValue(this.transFaceThin));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_V_FACE_UNIFORM, formatDecimalValue(this.transFaceV));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_CHIN_UNIFORM, formatDecimalValue(this.transChin));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_CHEEK_BONE_UNIFORM, formatDecimalValue(this.transCheekboneThin));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_THIN_NOSE_UNIFORM, formatDecimalValue(this.transNose));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_NOSE_WING_UNIFORM, formatDecimalValue(this.transNoseWing));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_NOSE_HEIGHT_UNIFORM, formatDecimalValue(this.transNosePosition));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_MOUTH_SIZE_UNIFORM, formatDecimalValue(this.transMouthShape));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_MOUTH_HEIGHT_UNIFORM, formatDecimalValue(this.transLipsThickness));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_MOUTH_WIDTH_UNIFORM, formatDecimalValue(this.transLipsWidth));
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_FOREHEAD_UNIFORM, formatDecimalValue(this.transForehead));
                                this.configData.put("liquefaction.shortFace", formatDecimalValue(this.transFaceShorten));
                                String str2 = this.selectedBasicTransType;
                                if (str2 != null) {
                                    this.configData.put(str2, formatDecimalValue(this.selectedBasicTransValue));
                                }
                                this.beautyUpdated = false;
                            }
                            if (this.mAiBeautyUpdated) {
                                this.mAiBeautyUpdated = false;
                                this.configData.put("auto_beauty_switch", formatBooleanValue(this.mAiBeautyEnable));
                            }
                            if (this.faceThinTypeUpdated) {
                                if (this.faceNatureOpen) {
                                    this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_BASIC_FACE_SUB_TYPE_UNIFORM, "nature");
                                } else if (this.faceGodOpen) {
                                    this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_BASIC_FACE_SUB_TYPE_UNIFORM, "maleGod");
                                } else if (this.faceGoddessOpen) {
                                    this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_BASIC_FACE_SUB_TYPE_UNIFORM, "femaleGod");
                                } else {
                                    this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_BASIC_FACE_SUB_TYPE_UNIFORM, "");
                                }
                                this.faceThinTypeUpdated = false;
                            }
                            if (this.factorThinUpdated) {
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_BASIC_FACE_UNIFORM, formatDecimalValue(this.douyinFactorThin));
                                this.factorThinUpdated = false;
                            }
                            if (this.factorSmallUpdated) {
                                this.configData.put(LightConstants.ReshapeConfigKey.RESHAPE_SMALL_FACE_UNIFORM, formatDecimalValue(this.douyinFactorSmall));
                                this.factorSmallUpdated = false;
                            }
                            if (this.makeupAlphaUpdated) {
                                this.mLightNode.setAssetData("makeup.strength", formatDecimalValue(this.makeupAlpha));
                                this.makeupAlphaUpdated = false;
                            }
                            if (this.faceFeatureUpdated) {
                                this.configData.put("beauty.faceFeature.enable", formatBooleanValue(this.faceFeatureOpen));
                                this.faceFeatureUpdated = false;
                            }
                            if (this.isAfterUpdateMaterial || this.lutPathUpdated) {
                                int i16 = this.useLutType;
                                if (i16 == 1001) {
                                    switchAbilityInLightNode("basicLUT.enable", true);
                                    switchAbilityInLightNode("materialLUT.enable", false);
                                } else if (i16 == 1000) {
                                    switchAbilityInLightNode("basicLUT.enable", false);
                                    switchAbilityInLightNode("materialLUT.enable", true);
                                }
                                if (this.isAfterUpdateMaterial) {
                                    VideoMaterial videoMaterial2 = this.mVideoMaterial;
                                    if (videoMaterial2 != null && videoMaterial2.getLightAsset() != null) {
                                        switchAbilityInLightNode("beauty.faceFeature.enable", !this.mVideoMaterial.getLightAsset().hasMakeup());
                                    }
                                    this.isAfterUpdateMaterial = false;
                                }
                                if (this.lutPathUpdated) {
                                    Map<String, String> map2 = this.configData;
                                    String str3 = this.mLutPath;
                                    if (str3 != null) {
                                        str = str3;
                                    }
                                    map2.put("lut.src", str);
                                    this.lutPathUpdated = false;
                                }
                            }
                            if (this.lutAlphaUpdate) {
                                this.configData.put("lut.intensity", formatDecimalValue((int) this.mIntensity));
                                this.lutAlphaUpdate = false;
                            }
                            if (this.customMaterialUpdated) {
                                this.mLightNode.setCustomMaterial(this.customMaterialPath);
                                this.customMaterialUpdated = false;
                            }
                            HashMap<String, String> hashMap = this.filterInLightNodeMap;
                            if (hashMap != null && hashMap.size() > 0) {
                                this.configData.putAll(this.filterInLightNodeMap);
                                this.filterInLightNodeMap.clear();
                            }
                            if (this.extraConfigUpdated) {
                                this.configData.putAll(this.extraConfigData);
                                this.extraConfigData.clear();
                                this.extraConfigUpdated = false;
                            }
                            Map<String, String> map3 = this.configData;
                            if (map3 instanceof HashMap) {
                                map3.remove(null);
                            }
                            if (this.configData.size() > 0) {
                                this.mLightNode.updateCameraConfigData(this.configData);
                                LogUtils.d(TAG, "[configFilters] configData: " + this.configData.toString());
                            }
                            if (this.previewSizeUpdated) {
                                this.mLightNode.updatePreviewSize(this.width, this.height);
                                LogUtils.d(TAG, "[configFilters] \u6e32\u67d3\u5c3a\u5bf8\u66f4\u65b0");
                                this.previewSizeUpdated = false;
                            }
                            if (this.flipBeforeRenderUpdated) {
                                this.flipBeforeRenderUpdated = false;
                                this.mLightNode.setPicNeedFlip(this.isPicNeedFlipBeforeRender);
                                LogUtils.d(TAG, "[configFilters] flip before render update: " + this.isPicNeedFlipBeforeRender);
                            }
                            if (this.externalRenderUpdated) {
                                ExternalRenderCallback externalRenderCallback = this.externalRenderCallback;
                                if (externalRenderCallback != null) {
                                    this.mLightNode.setExternalRenderCallback(externalRenderCallback);
                                }
                                LogUtils.d(TAG, "[configFilters] \u5916\u6302\u6ee4\u955c\u66f4\u65b0");
                                this.externalRenderUpdated = false;
                            }
                            if (this.syncModeUpdated) {
                                this.syncModeUpdated = false;
                                this.mLightNode.setSyncMode(this.syncMode);
                            }
                            if (this.faceDataUpdated) {
                                this.faceDataUpdated = false;
                                this.mLightNode.setPtFaceAttr(this.ptFaceAttr);
                            }
                            if (this.cosmeticsAlphaUpdated) {
                                this.cosmeticsAlphaUpdated = false;
                                LogUtils.d(TAG, "cosmeticsAlpha: " + this.cosmeticsAlpha);
                                this.mLightNode.setAssetData("makeup.strength", formatDecimalValue(this.cosmeticsAlpha));
                            }
                        }
                    }
                }
                AEProfiler.getInstance().end("IAEProfiler-configFilters-" + entry.getKey(), true);
            }
        }
        IAEProfiler iAEProfiler3 = this.mAEProfiler;
        if (iAEProfiler3 != null) {
            iAEProfiler3.endByTag(IAEProfiler.TAG_CONFIG_FILTERS);
        }
    }

    private Vector copyArry2Vector(Object obj, Vector<Integer> vector) {
        if (obj == null) {
            if (vector != null) {
                vector.clear();
            }
            return vector;
        }
        if (!(obj instanceof int[])) {
            return vector;
        }
        if (vector == null) {
            vector = new Vector<>();
        }
        vector.clear();
        for (int i3 : (int[]) obj) {
            if (!vector.contains(Integer.valueOf(i3))) {
                vector.add(Integer.valueOf(i3));
            }
        }
        return vector;
    }

    private Bitmap decodeBitmap(String str) {
        if (AEModule.getContext() == null || str == null) {
            return null;
        }
        return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), AEModule.getContext().getExternalFilesDir(null).getPath() + File.separator + str, 1);
    }

    private String formatBooleanValue(boolean z16) {
        if (z16) {
            return "true";
        }
        return "false";
    }

    private String formatDecimalValue(int i3) {
        return Float.toString(i3 / 100.0f);
    }

    private int getBmpToTextue(Bitmap bitmap) {
        if (!BitmapUtils.isLegal(bitmap)) {
            return -1;
        }
        GlUtil.loadTexture(this.testBmpTexture[0], bitmap);
        return this.testBmpTexture[0];
    }

    private String getInputVideoPath() {
        String resouceRoot = AEModule.getResouceRoot();
        if (resouceRoot == null) {
            return null;
        }
        return resouceRoot + File.separator + "inputVideo";
    }

    private String getOutputVideoPath() {
        String resouceRoot = AEModule.getResouceRoot();
        if (resouceRoot == null) {
            return null;
        }
        return resouceRoot + File.separator + "outputVideo";
    }

    private void initAudioTrack() {
        try {
            int minBufferSize = AudioTrack.getMinBufferSize(44100, 12, 2);
            LogUtils.d(TAG, "minBufferSize is: " + minBufferSize);
            ReportAudioTrack reportAudioTrack = new ReportAudioTrack(3, 44100, 12, 2, minBufferSize * 2, 1);
            this.audioTrack = reportAudioTrack;
            reportAudioTrack.setStereoVolume(1.0f, 1.0f);
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
        }
    }

    private void initBundlePathsForLightNode() {
        if (this.pendingToSetBundles) {
            for (Map.Entry<String, String> entry : this.bundlePathMap.entrySet()) {
                if (entry != null) {
                    setLightBundle(entry.getValue(), entry.getKey());
                }
            }
            this.bundlePathMap.clear();
            this.pendingToSetBundles = false;
        }
    }

    private void initFilters() {
        long j3;
        Map<Integer, Boolean> map = this.mFilterNodeEnableMap;
        if (map != null && !map.isEmpty()) {
            if (!this.mLogFlag) {
                j3 = SystemClock.uptimeMillis();
                IAEProfiler iAEProfiler = this.mAEProfiler;
                if (iAEProfiler != null) {
                    iAEProfiler.startByTag(IAEProfiler.TAG_INIT_FILTERS);
                }
            } else {
                j3 = 0;
            }
            System.currentTimeMillis();
            for (Map.Entry<Integer, Boolean> entry : this.mFilterNodeEnableMap.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    int intValue = entry.getKey().intValue();
                    if (intValue != 100) {
                        if (intValue == 300) {
                            if (this.mGlow == null) {
                                this.mGlow = new AEGlow();
                            }
                            this.mGlow.applyFilterChain(false, this.width, this.height);
                        }
                    } else {
                        if (this.mLightNode == null) {
                            LogUtils.e(TAG, "appId = " + this.lightAppId + ", appEntry = " + this.lightAppEntry + ", licensePath = " + this.lightLicensePath);
                            int initLightEngineAuth = LightNode.initLightEngineAuth(this.lightAppId, this.lightAppEntry, this.lightLicensePath);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("lightEngine auth ret code = ");
                            sb5.append(initLightEngineAuth);
                            LogUtils.e(TAG, sb5.toString());
                            String str = this.mAutoTestSmoothVersion;
                            if (str != null) {
                                this.mLightNode = new LightNode(str, this.isBgmHidden, this.isRealtime, this.aiSwitchMap, this.needLowEndDownGrade);
                            } else {
                                this.mLightNode = new LightNode(this.smoothVersion, this.isBgmHidden, this.isRealtime, this.aiSwitchMap, this.needLowEndDownGrade);
                            }
                            LogUtils.d("testSmoothVersion", "[BeautyVersion] ver:" + this.smoothVersion);
                            this.mLightNode.setApplyListener(new LightNodeAppliedListener() { // from class: com.tencent.aekit.api.standard.filter.AEFilterManager.2
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AEFilterManager.this);
                                    }
                                }

                                @Override // com.tencent.ttpic.openapi.listener.LightNodeAppliedListener
                                public void onLightNodeApplied() {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    AEFilterManager aEFilterManager = AEFilterManager.this;
                                    aEFilterManager.audioReader = aEFilterManager.mLightNode.getAudioReader();
                                    AEFilterManager.this.initWritePCMThread();
                                }
                            });
                        }
                        initBundlePathsForLightNode();
                        initListenersForLightNode();
                        this.mLightNode.setAvatarMode(this.avatarMode);
                        this.mLightNode.initPreviewSize(this.width, this.height);
                        this.mLightNode.setInputOrigin(this.lightInputOriention);
                        HashMap<String, Integer> hashMap = this.detectShorterLengthMap;
                        if (hashMap != null && hashMap.size() != 0) {
                            this.mLightNode.setDetectShorterEdgeLengthMap(this.detectShorterLengthMap);
                        }
                        this.mLightNode.setWatermarkConfig(this.watermarkConfig);
                        this.mLightNode.apply();
                        checkLightBasicParam();
                        this.mIsInited = true;
                    }
                }
            }
            if (!this.mLogFlag) {
                this.mLogFlag = true;
                IAEProfiler iAEProfiler2 = this.mAEProfiler;
                if (iAEProfiler2 != null) {
                    iAEProfiler2.endByTag(IAEProfiler.TAG_INIT_FILTERS);
                }
                LogUtils.i("CameraLaunchPerf", "initFilters cost duration=" + (SystemClock.uptimeMillis() - j3));
                return;
            }
            return;
        }
        LogUtils.w(TAG, "[initFilters] warning, filters is empty!");
    }

    private void initLightAuthInfo() {
        String packageName = AEModule.getContext().getPackageName();
        LogUtils.e(TAG, "packageName = " + packageName);
        if (packageName != null && packageName.contains("aekit")) {
            this.lightAppId = "light_sdk_demo";
            this.lightAppEntry = "preview";
            this.lightLicensePath = "/sdcard/Download/license.lic";
        } else {
            this.lightAppId = "lightsdk_qq";
            this.lightAppEntry = "qq_aio";
            this.lightLicensePath = "";
        }
    }

    private void initListenersForLightNode() {
        if (this.tipsListenerUpdated) {
            this.mLightNode.setLightNodeTipsListener(new LightNode.ILightNodeTipsListener() { // from class: com.tencent.aekit.api.standard.filter.AEFilterManager.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AEFilterManager.this);
                    }
                }

                @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
                public void onHideNormalTip() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    } else if (AEFilterManager.this.mTipsListener != null) {
                        AEFilterManager.this.mTipsListener.onHideNormalTip();
                    }
                }

                @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
                public void onHidePagTip() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this);
                    } else if (AEFilterManager.this.mTipsListener != null) {
                        AEFilterManager.this.mTipsListener.onHidePagTip();
                    }
                }

                @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
                public void onShowNormalTip(String str, String str2, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3));
                    } else if (AEFilterManager.this.mTipsListener != null) {
                        AEFilterManager.this.mTipsListener.onShowNormalTip(str, str2, i3);
                    }
                }

                @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
                public void onShowPagTip(String str, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
                    } else if (AEFilterManager.this.mTipsListener != null) {
                        AEFilterManager.this.mTipsListener.onShowPagTip(str, i3);
                    }
                }
            });
            this.tipsListenerUpdated = false;
        }
        if (this.wmClickListenerUpdated) {
            this.mLightNode.setOnClickWatermarkListener(this.mWatermarkClickListener);
            this.wmClickListenerUpdated = false;
        }
        if (this.wmOnlineUsrCountDelegateUpdated) {
            for (Map.Entry<String, OnWatermarkDataListener> entry : this.wmDelegateMap.entrySet()) {
                if (entry != null) {
                    this.mLightNode.setGetOnlineUsrCountDelegate(entry.getKey(), entry.getValue());
                }
            }
            this.wmOnlineUsrCountDelegateUpdated = false;
        }
        if (this.assetListenerUpdated) {
            this.assetListenerUpdated = false;
            this.mLightNode.setLightNodeLightAssetListener(new OnLoadAssetListener() { // from class: com.tencent.aekit.api.standard.filter.AEFilterManager.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AEFilterManager.this);
                    }
                }

                @Override // org.light.listener.OnLoadAssetListener
                public void OnAssetDurationChange(long j3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, j3);
                    }
                }

                @Override // org.light.listener.OnLoadAssetListener
                public void OnAssetProcessing(HashMap<String, String> hashMap) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) hashMap);
                        return;
                    }
                    Log.d(AEFilterManager.TAG, "OnAssetProcessing: " + hashMap);
                    if (AEFilterManager.this.mLightAssetListener != null) {
                        AEFilterManager.this.mLightAssetListener.OnAssetProcessing(hashMap);
                    }
                }

                @Override // org.light.listener.OnLoadAssetListener
                public void OnLoadAssetError(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3);
                        return;
                    }
                    Log.d(AEFilterManager.TAG, "OnLoadAssetError: " + i3);
                    if (AEFilterManager.this.mLightAssetListener != null) {
                        AEFilterManager.this.mLightAssetListener.OnLoadAssetError(i3);
                    }
                }
            });
        }
        if (this.cameraExposureListenerUpdated) {
            this.cameraExposureListenerUpdated = false;
            this.mLightNode.setCameraExposureListener(this.mCameraExposureListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWritePCMThread() {
        if (this.writePCMThread == null && !this.isBgmHidden && !this.isAudioPaused) {
            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.aekit.api.standard.filter.AEFilterManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AEFilterManager.this);
                    }
                }

                @Override // java.lang.Runnable
                @RequiresApi(api = 21)
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (AEFilterManager.this.audioReader != null) {
                            AudioFrame copyNextSample = AEFilterManager.this.audioReader.copyNextSample();
                            while (copyNextSample != null) {
                                if (!AEFilterManager.this.isBgmHidden && !AEFilterManager.this.isAudioPaused) {
                                    AEFilterManager.this.audioTrack.play();
                                }
                                AEFilterManager.this.audioTrack.write(copyNextSample.data, (int) copyNextSample.length, 0);
                                copyNextSample = AEFilterManager.this.audioReader.copyNextSample();
                            }
                            if (AEFilterManager.this.audioTrack != null && AEFilterManager.this.audioTrack.getState() == 1) {
                                AEFilterManager.this.audioTrack.stop();
                                return;
                            }
                            return;
                        }
                        LogUtils.e(AEFilterManager.TAG, "audioReader is null!");
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            });
            this.writePCMThread = baseThread;
            baseThread.start();
        }
    }

    private boolean isDeviceSupportMaterial(VideoMaterial videoMaterial) {
        if (videoMaterial != null && videoMaterial.getLightAsset() != null) {
            for (String str : this.deviceSupportAbility) {
                if (videoMaterial.getLightAsset().needRenderAbility(str) && !LightEngine.isDeviceAbilitySupported(str)) {
                    LogUtils.e(TAG, "can not support ability " + str);
                    return false;
                }
            }
            return true;
        }
        LogUtils.e(TAG, "can not support because videoMaterial is null or lightAsset is null!");
        return false;
    }

    private boolean isLightNodeAvailable() {
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied() && this.mLightNode.getAsset() != null) {
            return true;
        }
        return false;
    }

    private String mapWeatherCode(int i3) {
        switch (i3) {
            case 0:
                return "\u6674";
            case 1:
                return "\u591a\u4e91";
            case 2:
                return "\u9634";
            case 3:
                return "\u96e8";
            case 4:
                return "\u96ea";
            case 5:
                return "\u96fe";
            case 6:
                return "\u96e8\u52a0\u96ea";
            case 7:
                return "\u96f7\u9635\u96e8";
            case 8:
                return "\u6c99\u5c18\u66b4";
            case 9:
                return "\u5927\u98ce";
            default:
                return "";
        }
    }

    private boolean onlyLightNode() {
        if (this.mFilterOrderList.size() == 1 && this.mAEFilterChain.containFilter(this.mLightNode) && this.mLightNode != null) {
            return true;
        }
        return false;
    }

    private List<Bitmap> pickUpFrame(String str) {
        long j3;
        new ArrayList();
        int[] iArr = new int[10];
        List framestamps = VideoUtil.getFramestamps(str);
        if (framestamps != null) {
            Collections.sort(framestamps);
        }
        Long l3 = (Long) Collections.max(framestamps);
        if (l3.longValue() > 30000) {
            j3 = 6000;
        } else {
            j3 = 3000;
        }
        double min = Math.min(l3.longValue() / j3, 10);
        int i3 = 0;
        for (int i16 = 0; i16 < min; i16++) {
            int i17 = 0;
            while (true) {
                if (i17 >= framestamps.size()) {
                    break;
                }
                if (((Long) framestamps.get(i17)).longValue() > i16 * j3) {
                    iArr[i3] = i17;
                    i3++;
                    break;
                }
                i17++;
            }
        }
        ArrayList arrayList = new ArrayList();
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        int i18 = iArr2[0];
        VboxDecoder createDecoder = VboxFactory.createDecoder(str, 2);
        createDecoder.setTexture(i18);
        for (int i19 = 0; i19 < min; i19++) {
            createDecoder.getFrameTexture(iArr[i19]);
            arrayList.add(RendererUtils.saveTexture(i18, createDecoder.getWidth(), createDecoder.getHeight()));
        }
        createDecoder.releaseDecoder();
        GLES20.glDeleteTextures(1, iArr2, 0);
        return arrayList;
    }

    private Bitmap pickUpFrameFirst(String str, int i3) {
        new ArrayList();
        List framestamps = VideoUtil.getFramestamps(str);
        if (framestamps != null) {
            Collections.sort(framestamps);
        }
        long j3 = i3;
        if (((Long) Collections.max(framestamps)).longValue() < j3) {
            return null;
        }
        int i16 = 0;
        while (true) {
            if (i16 < framestamps.size()) {
                if (((Long) framestamps.get(i16)).longValue() > j3) {
                    break;
                }
                i16++;
            } else {
                i16 = 0;
                break;
            }
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i17 = iArr[0];
        VboxDecoder createDecoder = VboxFactory.createDecoder(str, 2);
        createDecoder.setTexture(i17);
        createDecoder.getFrameTexture(i16);
        Bitmap saveTexture = RendererUtils.saveTexture(i17, createDecoder.getWidth(), createDecoder.getHeight());
        createDecoder.releaseDecoder();
        GLES20.glDeleteTextures(1, iArr, 0);
        return saveTexture;
    }

    private void setDefaultOrder() {
        this.mFilterOrderList.clear();
        this.mFilterOrderList.add(100);
        this.mFilterNodeEnableMap.put(100, Boolean.TRUE);
    }

    public static void setVideoAIFilter(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        mVideoFilterName = str;
        temperature = i3;
        lightness = i16;
        overexposure = i17;
        underexposure = i18;
        contrast = i19;
        sharpness = i26;
        saturation = i27;
        colorfulness = i28;
    }

    private void updateAIFilter() {
        if (!this.needUpdateAIFilter) {
            this.needUpdateAIFilter = true;
        }
    }

    private void updateAdjustValue(ImageStatisticsData imageStatisticsData) {
        if (imageStatisticsData != null) {
            this.lightnessLevel = (int) imageStatisticsData.lightness;
            this.hightLightLevel = (int) imageStatisticsData.overexposure;
            this.shadowLevel = (int) imageStatisticsData.underexposure;
            this.compareLevel = (int) imageStatisticsData.contrast;
            this.sharpLevel = (int) imageStatisticsData.sharpness;
            this.saturationLevel = (int) imageStatisticsData.saturation;
            this.colorTemperature = (int) imageStatisticsData.temperature;
            this.fadeLevel = (int) imageStatisticsData.colorfulness;
        }
    }

    private void updateLightBasicParams(String str, LightBasicBeauty lightBasicBeauty) {
        if (lightBasicBeauty == null) {
            return;
        }
        if (this.mLightBasicParams == null) {
            this.mLightBasicParams = new ConcurrentHashMap<>();
        }
        this.mLightBasicParams.put(str, lightBasicBeauty);
    }

    public void addMaskTouchPoint(PointF pointF, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this, (Object) pointF, i3);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied() && this.mLightNode.getAsset() != null && this.mLightNode.getAsset().needRenderAbility(LightConstants.AssetFeatureKey.HAS_RECORD_TOUCH) && i3 > 0 && pointF != null) {
            float f16 = this.width / i3;
            pointF.x *= f16;
            pointF.y *= f16;
            String str = "{\n\"x\":\"" + String.valueOf(pointF.x) + "\",\n\"y\":\"" + String.valueOf(pointF.y) + "\"\n}";
            Log.d(TAG, "addMaskTouchPoint: jsonStr=" + str);
            this.mLightNode.setAssetData("event.paintPoint", str);
        }
    }

    public boolean canUseLargeImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return ((Boolean) iPatchRedirector.redirect((short) 93, (Object) this)).booleanValue();
        }
        VideoMaterial videoMaterial = this.mVideoMaterial;
        if (videoMaterial != null && (videoMaterial.needBodySegment() || this.mVideoMaterial.isSticker3DMaterial() || this.mVideoMaterial.isFace3DMaterial())) {
            return false;
        }
        return true;
    }

    public boolean currentMaterialIsCyberpunk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this)).booleanValue();
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied() && this.mLightNode.currentMaterialIsCyberpunk()) {
            return true;
        }
        return false;
    }

    public boolean currentMaterialNeedGravityInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Boolean) iPatchRedirector.redirect((short) 63, (Object) this)).booleanValue();
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.getAsset() != null) {
            return this.mLightNode.getAsset().needRenderAbility(LightConstants.AssetFeatureKey.HAS_GRAVITY_INFO);
        }
        return false;
    }

    public boolean currentMaterialNeedTouchTriggerEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this)).booleanValue();
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.getAsset() != null) {
            return this.mLightNode.getAsset().needRenderAbility("material.touch");
        }
        return false;
    }

    public boolean currentMaterialNeedVoiceDecibel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Boolean) iPatchRedirector.redirect((short) 64, (Object) this)).booleanValue();
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.getAsset() != null) {
            return this.mLightNode.getAsset().needVoiceDecibel();
        }
        return false;
    }

    public void defineFiltersAndOrder(int... iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) iArr);
            return;
        }
        this.mFilterOrderList.clear();
        for (int i3 : iArr) {
            this.mFilterOrderList.add(Integer.valueOf(i3));
            this.mFilterNodeEnableMap.put(Integer.valueOf(i3), Boolean.TRUE);
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this);
            return;
        }
        PreviewPerformanceInfo.getInstance().report();
        AEGlow aEGlow = this.mGlow;
        if (aEGlow != null) {
            aEGlow.clear();
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.clear();
        }
        AEFilterChain aEFilterChain = this.mAEFilterChain;
        if (aEFilterChain != null) {
            aEFilterChain.destroy();
        }
        Thread thread = this.writePCMThread;
        if (thread != null) {
            thread.interrupt();
            this.writePCMThread = null;
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
        AudioOutput audioOutput = this.audioReader;
        if (audioOutput != null) {
            audioOutput.release();
            this.audioReader = null;
        }
        HashMap<String, OnWatermarkDataListener> hashMap = this.wmDelegateMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mTipsListener = null;
        this.mWatermarkClickListener = null;
        this.mCameraExposureListener = null;
        this.mLightAssetListener = null;
        clearSharedResources();
        int[] iArr = this.textures;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
        if (this.isNeedPictureTest) {
            int[] iArr2 = this.testBmpTexture;
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        }
        this.mIsInited = false;
        this.mDestroyed = true;
        this.needUpdateAIFilter = true;
    }

    public void destroyAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this);
            return;
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
        AudioOutput audioOutput = this.audioReader;
        if (audioOutput != null) {
            audioOutput.release();
            this.audioReader = null;
        }
    }

    public int drawFrame(int i3, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 52)) ? drawFrame(i3, z16, j3, 0, 0) : ((Integer) iPatchRedirector.redirect((short) 52, this, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3))).intValue();
    }

    public void endMaskTouchPoint(PointF pointF, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this, (Object) pointF, i3);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied() && this.mLightNode.getAsset() != null && this.mLightNode.getAsset().needRenderAbility(LightConstants.AssetFeatureKey.HAS_RECORD_TOUCH) && i3 > 0 && pointF != null) {
            float f16 = this.width / i3;
            pointF.x *= f16;
            pointF.y *= f16;
            String str = "{\n\"x\":\"" + String.valueOf(pointF.x) + "\",\n\"y\":\"" + String.valueOf(pointF.y) + "\"\n}";
            Log.d(TAG, "addMaskTouchPoint: jsonStr=" + str);
            this.mLightNode.setAssetData("event.paintPoint.end", str);
        }
    }

    public void freeCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.freeCache();
        }
    }

    @Nullable
    public AudioPlaceHolder[] getAudioPlaceHolder(@NonNull LightAsset lightAsset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (AudioPlaceHolder[]) iPatchRedirector.redirect((short) 65, (Object) this, (Object) lightAsset);
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            return lightNode.getAudioPlaceHolder(lightAsset);
        }
        return null;
    }

    public PTFaceAttr getFaceAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (PTFaceAttr) iPatchRedirector.redirect((short) 71, (Object) this);
        }
        if (this.mLightNode == null) {
            return null;
        }
        return this.faceAttrInLight;
    }

    @Nullable
    public LightAIDataWrapper getLightAIDataWrapper(String[] strArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            return (LightAIDataWrapper) iPatchRedirector.redirect((short) 102, (Object) this, (Object) strArr, i3);
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            return lightNode.getLightAIDataWrapper(strArr, i3);
        }
        return null;
    }

    public AvatarAIInfo getLightAvatarAIInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            return (AvatarAIInfo) iPatchRedirector.redirect((short) 104, (Object) this);
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            return lightNode.getLightAvatarAIInfo();
        }
        return null;
    }

    public LightNode getLightNode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LightNode) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mLightNode;
    }

    public String getLutPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (String) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return this.mLutPath;
    }

    public int getMusicCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            return ((Integer) iPatchRedirector.redirect((short) 123, (Object) this)).intValue();
        }
        return TouchTriggerManager.getInstance().getMusicCurrentPosition();
    }

    public int getMusicDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            return ((Integer) iPatchRedirector.redirect((short) 122, (Object) this)).intValue();
        }
        return TouchTriggerManager.getInstance().getMusicDuration();
    }

    public long getMusicStartTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            return ((Long) iPatchRedirector.redirect((short) 121, (Object) this)).longValue();
        }
        return TouchTriggerManager.getInstance().getMusicStartTime();
    }

    public VideoMaterial getVideoMaterial() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (VideoMaterial) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mVideoMaterial;
    }

    public boolean hasEffect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Boolean) iPatchRedirector.redirect((short) 73, (Object) this)).booleanValue();
        }
        LightNode lightNode = this.mLightNode;
        if ((lightNode != null && lightNode.isApplied()) || this.smoothLevel > 0 || this.transBasic4 > 0) {
            return true;
        }
        return !TextUtils.isEmpty(this.mLutPath);
    }

    public void initInGL(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.width = i3;
        this.height = i16;
        this.isVeryLowEndDevice = !DeviceUtils.hasDeviceLow(AEModule.getContext());
        int[] iArr = this.textures;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        if (this.isNeedPictureTest) {
            int[] iArr2 = this.testBmpTexture;
            GLES20.glGenTextures(iArr2.length, iArr2, 0);
        }
        this.outputTexture = this.textures[0];
        this.mAEFilterChain.init();
    }

    public void initLightFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
            return;
        }
        try {
            initFilters();
            configFilters();
            chainFilters();
        } catch (Throwable th5) {
            LogUtils.e(TAG, "initLightFilter throwable:" + th5.getMessage());
        }
    }

    public boolean isInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Boolean) iPatchRedirector.redirect((short) 72, (Object) this)).booleanValue();
        }
        return FeatureManager.Features.LIGHT_SDK.isFunctionReady();
    }

    public boolean needMaskRecordTouchPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            return ((Boolean) iPatchRedirector.redirect((short) 106, (Object) this)).booleanValue();
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.getAsset() != null) {
            return this.mLightNode.getAsset().needRenderAbility(LightConstants.AssetFeatureKey.HAS_RECORD_TOUCH);
        }
        return false;
    }

    public PTFaceAttr notifyDetectFaceAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (PTFaceAttr) iPatchRedirector.redirect((short) 70, (Object) this);
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode == null) {
            this.faceAttrInLight = null;
            return null;
        }
        PTFaceAttr ptFaceAttr = lightNode.getPtFaceAttr();
        this.faceAttrInLight = ptFaceAttr;
        return ptFaceAttr;
    }

    public void onStickerStatusChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, (Object) this, z16);
        }
    }

    public void openAndUpdateBasicLips(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied()) {
            this.mLightNode.openAndUpdateBasicLips(str, i3, i16);
        } else {
            updateLightBasicParams(LightBasicBeauty.BASIC_BASIC_LIPS, new LightBasicBeauty(str, i3, i16));
        }
    }

    @Deprecated
    public void openAndUpdateBasicMultiply(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) str, i3);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied()) {
            this.mLightNode.openAndUpdateBasicMultiply(str, i3);
        } else {
            updateLightBasicParams(LightBasicBeauty.BASIC_MULTIPLY, new LightBasicBeauty(str, i3));
        }
    }

    public void openAndUpdateBasicSoftLight(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) str, i3);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied()) {
            this.mLightNode.openAndUpdateBasicSoftLight(str, i3);
        } else {
            updateLightBasicParams(LightBasicBeauty.BASIC_SOFT_LIGHT, new LightBasicBeauty(str, i3));
        }
    }

    public void openBeautyEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, z16);
        } else {
            this.faceFeatureOpen = z16;
            this.faceFeatureUpdated = true;
        }
    }

    public void openFaceThinEnable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) str);
            return;
        }
        this.faceNatureOpen = false;
        this.faceGodOpen = false;
        this.faceGoddessOpen = false;
        if ("nature".equals(str)) {
            this.faceNatureOpen = true;
        } else if ("maleGod".equals(str)) {
            this.faceGodOpen = true;
        } else if ("femaleGod".equals(str)) {
            this.faceGoddessOpen = true;
        }
        this.faceThinTypeUpdated = true;
    }

    public void resetAdjustLut() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            iPatchRedirector.redirect((short) 118, (Object) this);
        } else {
            updateLutGL(this.mLutPath);
        }
    }

    public void setAIBeautyParamsJsonBean(AIBeautyParamsJsonBean aIBeautyParamsJsonBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) aIBeautyParamsJsonBean);
        } else {
            this.closeAIBeautyConfig = false;
            this.mAIBeautyParamsJsonBean = aIBeautyParamsJsonBean;
        }
    }

    public void setAIParam(String str, String str2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            iPatchRedirector.redirect((short) 126, this, str, str2, obj);
        } else if (this.mAiParam != null && !TextUtils.isEmpty(str2) && obj != null) {
            this.mAiParam.setModuleParam(str, str2, obj);
        }
    }

    public void setAIScale(String str, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            iPatchRedirector.redirect((short) 125, this, str, Float.valueOf(f16));
            return;
        }
        AIParam aIParam = this.mAiParam;
        if (aIParam != null && f16 > 0.0f) {
            aIParam.setModuleParam(str, "scale", Float.valueOf(f16));
        }
    }

    public void setAdjustAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, Float.valueOf(f16));
        } else {
            this.adjustAlpha = f16;
        }
    }

    public void setAdjustLevel(AdjustRealConfig.TYPE type, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, (Object) type, i3);
            return;
        }
        switch (AnonymousClass5.$SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[type.ordinal()]) {
            case 1:
                this.lightnessLevel = i3;
                return;
            case 2:
                this.hightLightLevel = i3;
                return;
            case 3:
                this.shadowLevel = i3;
                return;
            case 4:
                this.compareLevel = i3;
                return;
            case 5:
                this.sharpLevel = i3;
                return;
            case 6:
                this.saturationLevel = i3;
                return;
            case 7:
                this.colorTemperature = i3;
                return;
            case 8:
                this.fadeLevel = i3;
                return;
            default:
                return;
        }
    }

    public void setAdjustParams(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, (Object) hashMap);
        } else {
            this.adjustParams = hashMap;
        }
    }

    public void setArModelRotate(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 127)) {
            iPatchRedirector.redirect((short) 127, (Object) this, (Object) fArr);
            return;
        }
        AIParam aIParam = this.mAiParam;
        if (aIParam != null && fArr != null) {
            aIParam.setModuleParam(AEDetectorType.AR_DETECT.value, AIParam.AR_ROTATE, fArr);
        }
    }

    public void setAudioPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.isAudioPaused = true;
        Thread thread = this.writePCMThread;
        if (thread != null) {
            thread.interrupt();
            this.writePCMThread = null;
        }
        if (this.audioReader != null) {
            this.audioReader = null;
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null && audioTrack.getState() == 1) {
            this.audioTrack.stop();
        }
    }

    public void setAudioStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.isAudioPaused = false;
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied()) {
            this.audioReader = this.mLightNode.getAudioReader();
            initAudioTrack();
            initWritePCMThread();
        }
    }

    public void setAutoTest(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            iPatchRedirector.redirect((short) 129, (Object) this, z16);
        } else {
            this.mAutoTest = z16;
        }
    }

    public void setAutoTestSmoothVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) str);
        } else {
            this.mAutoTestSmoothVersion = str;
        }
    }

    public void setAutoTestSource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            iPatchRedirector.redirect((short) 130, (Object) this, i3);
        } else {
            this.mAutoTestSourceType = i3;
        }
    }

    public void setAvatarMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        this.avatarMode = z16;
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.setAvatarMode(z16);
        }
    }

    public void setBasicAbilityEnable(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, this, str, Boolean.valueOf(z16));
        } else if (isLightNodeAvailable()) {
            this.mLightNode.setAssetData(str, formatBooleanValue(z16));
        }
    }

    public void setBeautyNormalAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, this, Float.valueOf(f16));
        } else if (this.beautyNormalAlpha != f16) {
            this.beautyNormalAlpha = f16;
            this.beautyUpdated = true;
            this.softFaceBarUpdate = true;
        }
    }

    public void setBeautyOrTransformLevel(BeautyRealConfig.TYPE type, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, (Object) type, i3);
            return;
        }
        switch (AnonymousClass5.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[type.ordinal()]) {
            case 1:
                setExposureValue(i3);
                break;
            case 2:
                this.douyinFactorThin = i3;
                this.factorThinUpdated = true;
                break;
            case 3:
                this.douyinFactorSmall = i3;
                this.factorSmallUpdated = true;
                break;
            case 4:
                setSmoothLevel(i3);
                this.beautySkinLevel = i3;
                break;
            case 5:
                this.beautyEyeLighten = i3;
                break;
            case 6:
                this.beautyToothWhiten = i3;
                break;
            case 7:
                this.beautyRemovePounch = i3;
                break;
            case 8:
                this.beautyRemoveWrinkles = i3;
                break;
            case 9:
                this.beautyRemoveWrinkles2 = i3;
                break;
            case 10:
                this.beautySkinColor = i3;
                break;
            case 11:
                this.beautyContrastRatio = i3;
                break;
            case 12:
                this.beautyLutClearAlpha = i3;
                break;
            case 13:
                this.beautyLutFoundationAlpah = i3;
                break;
            case 14:
                setBeautyNormalAlpha(i3);
                break;
            case 15:
                setRedCheekBarUpdate(i3);
                break;
            case 16:
                setLipsBarUpdate(i3);
                break;
            case 17:
                this.beautyFaceEyeMakeup = i3;
                break;
            case 18:
                this.transForehead = i3;
                break;
            case 19:
                this.transEye = i3;
                break;
            case 20:
                this.transEyeDistance = i3;
                break;
            case 21:
                this.transEyeAngle = i3;
                break;
            case 22:
                this.transMouthShape = i3;
                break;
            case 23:
                this.transChin = i3;
                break;
            case 24:
                this.transFaceThin = i3;
                break;
            case 25:
                this.transFaceV = i3;
                break;
            case 26:
                this.transNoseWing = i3;
                break;
            case 27:
                this.transNosePosition = i3;
                break;
            case 28:
                this.transLipsThickness = i3;
                break;
            case 29:
                this.transLipsWidth = i3;
                break;
            case 30:
                this.transNose = i3;
                break;
            case 31:
                this.transCheekboneThin = i3;
                break;
            case 32:
                this.transFaceShorten = i3;
                break;
            case 33:
                this.transBasic3 = i3;
                this.selectedBasicTransType = "liquefaction.basic3";
                this.selectedBasicTransValue = i3;
                break;
            case 34:
                this.transBasic4 = i3;
                this.selectedBasicTransType = "liquefaction.basic4";
                this.selectedBasicTransValue = i3;
                break;
            case 35:
                this.transBasic5 = i3;
                this.selectedBasicTransType = "liquefaction.basic5";
                this.selectedBasicTransValue = i3;
                break;
            case 36:
                this.transBasic6 = i3;
                this.selectedBasicTransType = "liquefaction.basic6";
                this.selectedBasicTransValue = i3;
                break;
            case 37:
                this.transBasic7 = i3;
                this.selectedBasicTransType = "liquefaction.basic7";
                this.selectedBasicTransValue = i3;
                break;
            case 38:
                this.transBasic8 = i3;
                this.selectedBasicTransType = "liquefaction.basic8";
                this.selectedBasicTransValue = i3;
                break;
            case 39:
                this.longLeg = i3;
                break;
            case 40:
                this.slimWaist = i3;
                break;
            case 41:
                this.thinShoulder = i3;
                break;
            case 42:
                this.thinBody = i3;
                break;
            case 43:
                this.thinBodyV2 = i3;
                break;
            case 44:
                this.smallHead = i3;
                break;
            case 45:
                this.thinLeg = i3;
                break;
        }
        this.beautyUpdated = true;
    }

    public void setBgSwitchEvent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, (Object) this, (Object) str);
            return;
        }
        if (isLightNodeAvailable()) {
            String str2 = "{\"bgSrc\":\"" + str + "\"}";
            Log.d(TAG, "bgPath jsonStr= " + str2);
            this.mLightNode.setAssetData("event.script.switchBg", str2);
        }
    }

    public void setCamera2Timestamp(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            iPatchRedirector.redirect((short) 128, (Object) this, j3);
            return;
        }
        AIParam aIParam = this.mAiParam;
        if (aIParam != null) {
            aIParam.setModuleParam(AEDetectorType.AR_DETECT.value, AIParam.CAMERA2_TIMESTAMP, Long.valueOf(j3));
        }
    }

    public void setCameraExposureListener(LightNode.ILightNodeCameraExposureListener iLightNodeCameraExposureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, (Object) this, (Object) iLightNodeCameraExposureListener);
        } else {
            this.mCameraExposureListener = iLightNodeCameraExposureListener;
            this.cameraExposureListenerUpdated = true;
        }
    }

    public void setCloseAIBeautyConfig(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.closeAIBeautyConfig = z16;
        }
    }

    public void setCosmeticsAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            iPatchRedirector.redirect((short) 109, (Object) this, i3);
        } else {
            this.cosmeticsAlpha = i3;
            this.cosmeticsAlphaUpdated = true;
        }
    }

    public void setCustomMaterial(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) str);
        } else {
            this.customMaterialPath = str;
            this.customMaterialUpdated = true;
        }
    }

    public void setDetectShortLength(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, (Object) str, i3);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.setDetectShortLength(str, i3);
        }
    }

    public void setExposureValue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, i3);
        } else {
            this.exposureValue = i3;
            this.smoothUpdated = true;
        }
    }

    public void setExternalRenderCallback(ExternalRenderCallback externalRenderCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) externalRenderCallback);
        } else {
            this.externalRenderCallback = externalRenderCallback;
            this.externalRenderUpdated = true;
        }
    }

    public void setFilterInSmooth(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, z16);
        } else {
            this.filterInSmooth = z16;
        }
    }

    public void setForceFaceDetect(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, z16);
        } else {
            this.forceFaceDetect = z16;
        }
    }

    public void setGlowAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            iPatchRedirector.redirect((short) 110, this, Float.valueOf(f16));
        } else {
            this.glowAlpha = f16;
        }
    }

    public void setInputOriention(CameraConfig.ImageOrigin imageOrigin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this, (Object) imageOrigin);
        } else {
            this.lightInputOriention = imageOrigin;
        }
    }

    public void setIsAfterUpdateMaterial(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, z16);
        } else {
            this.isAfterUpdateMaterial = z16;
        }
    }

    public void setLightAIDataWrapper(LightAIDataWrapper lightAIDataWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, (Object) this, (Object) lightAIDataWrapper);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.setLightAIDataWrapper(lightAIDataWrapper);
        }
    }

    public void setLightAppEntry(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.lightAppEntry = str;
        }
    }

    public void setLightBundle(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            iPatchRedirector.redirect((short) 131, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if ("k3D_MM_AGENT".equals(str2)) {
            setLightBundle(str, "k3D_MM_AGENT_V2");
            setLightBundle(str, "kZPLAN_AGENT");
        }
        if (this.mLightNode == null) {
            LogUtils.e(TAG, "[setLightBundle] error, light node is null pending to set bundle!");
            this.bundlePathMap.put(str2, str);
            this.pendingToSetBundles = true;
        } else {
            if (str != null && !str.isEmpty()) {
                if (str2 != null && !str2.isEmpty()) {
                    this.mLightNode.setLightBundle(str, str2);
                    return;
                } else {
                    LogUtils.e(TAG, "[setLightBundle] error, nothing can set to light sdk!");
                    return;
                }
            }
            LogUtils.e(TAG, "[setLightBundle] error, bundle  assetDir is null can not set bundle!");
        }
    }

    public void setLightNodeAppliedListener(LightNodeAppliedListener lightNodeAppliedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lightNodeAppliedListener);
        } else {
            this.lightNodeAppliedListener = lightNodeAppliedListener;
        }
    }

    public void setLightNodeLightAssetListener(OnLoadAssetListener onLoadAssetListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            iPatchRedirector.redirect((short) 113, (Object) this, (Object) onLoadAssetListener);
        } else {
            this.mLightAssetListener = onLoadAssetListener;
            this.assetListenerUpdated = true;
        }
    }

    public void setLightNodePresetData(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, (Object) this, (Object) str, (Object) str2);
        } else if (isLightNodeAvailable()) {
            this.mLightNode.setAssetData(str, str2);
        }
    }

    public void setLightNodeTipsListener(LightNode.ILightNodeTipsListener iLightNodeTipsListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            iPatchRedirector.redirect((short) 112, (Object) this, (Object) iLightNodeTipsListener);
        } else {
            this.mTipsListener = iLightNodeTipsListener;
            this.tipsListenerUpdated = true;
        }
    }

    public void setLipsBarUpdate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, i3);
            return;
        }
        if (i3 != this.beautyFaceLipsLutAlpha) {
            this.lipsBarUpdate = true;
        }
        this.beautyFaceLipsLutAlpha = i3;
    }

    public void setMakeupDefaultStrength(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, i3);
        } else {
            setLightNodePresetData(LightConstants.BeautyConfigKey.MAKE_UP_DEFAULT_STRENGTH, formatDecimalValue(i3));
        }
    }

    public void setNeedPictureTest(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            iPatchRedirector.redirect((short) 116, (Object) this, z16);
        } else {
            this.isNeedPictureTest = z16;
        }
    }

    public void setNeedVideoTesttSwitch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            iPatchRedirector.redirect((short) 117, (Object) this, z16);
        }
    }

    public void setOnMaterialLoadFinishListener(MaterialLoadFinishListener materialLoadFinishListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            iPatchRedirector.redirect((short) 119, (Object) this, (Object) materialLoadFinishListener);
        } else {
            this.materialLoadFinishListener = materialLoadFinishListener;
        }
    }

    public void setOverallSmooth(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            iPatchRedirector.redirect((short) 120, (Object) this, z16);
        } else {
            this.isOverallSmooth = z16;
            this.smoothUpdated = true;
        }
    }

    public void setPagAssetText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "json value is null");
        } else if (isLightNodeAvailable()) {
            this.mLightNode.setAssetData(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, str);
        }
    }

    public void setPhoneRoll(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Float.valueOf(f16));
        } else {
            this.mPhoneRoll = f16;
        }
    }

    public void setPicNeedFlipBeforeRender(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, z16);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.setPicNeedFlip(z16);
        }
        this.isPicNeedFlipBeforeRender = z16;
        this.flipBeforeRenderUpdated = true;
    }

    public void setPreSetDetectShorterEdgeLengthMap(HashMap<String, Integer> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) hashMap);
            return;
        }
        HashMap<String, Integer> hashMap2 = this.detectShorterLengthMap;
        if (hashMap2 != null && hashMap != null) {
            hashMap2.putAll(hashMap);
        }
    }

    public void setPresetData(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mLightNodeControllerPresetData.put(str, str2);
        }
    }

    public void setPtFaceAttr(PTFaceAttr pTFaceAttr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 132)) {
            iPatchRedirector.redirect((short) 132, (Object) this, (Object) pTFaceAttr);
            return;
        }
        this.ptFaceAttr = pTFaceAttr;
        this.faceDataUpdated = true;
        LightNode lightNode = this.mLightNode;
        if (lightNode == null) {
            return;
        }
        lightNode.setPtFaceAttr(pTFaceAttr);
    }

    public void setRedCheekBarUpdate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, i3);
            return;
        }
        if (i3 != this.beautyFaceAlphaRedCheek) {
            this.redCheekBarUpdate = true;
        }
        this.beautyFaceAlphaRedCheek = i3;
    }

    public void setRotationMatrix(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            iPatchRedirector.redirect((short) 115, (Object) this, (Object) fArr);
        } else {
            System.arraycopy(fArr, 0, this.rotationMatrix, 0, 16);
        }
    }

    public void setSegBgColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, i3);
        } else {
            this.segBgColor = i3;
            this.segmentUpdated = true;
        }
    }

    public void setSegStrokeColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, (Object) this, i3);
        } else {
            this.segStrokeColor = i3;
            this.segmentUpdated = true;
        }
    }

    public void setSegStrokeGapInPixel(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, this, Float.valueOf(f16));
        } else {
            this.segStrokeGapInPixel = f16;
            this.segmentUpdated = true;
        }
    }

    public void setSegStrokeWidthInPixel(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, this, Float.valueOf(f16));
        } else {
            this.segStrokeWidthInPixel = f16;
            this.segmentUpdated = true;
        }
    }

    public void setSensorEventToLight(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) sensorEvent);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied()) {
            LogUtils.d(TAG, "lightNode applied\uff0csetSensorEvent");
            this.mLightNode.setSensorEvent(sensorEvent);
        } else {
            LogUtils.e(TAG, "lightNode not applied!");
        }
    }

    public void setSensorOrientationToLight(CameraConfig.DeviceCameraOrientation deviceCameraOrientation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) deviceCameraOrientation);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied()) {
            LogUtils.d(TAG, "lightNode applied\uff0conSensorOrientationChanged");
            this.mLightNode.onSensorOrientationChanged(deviceCameraOrientation);
        } else {
            LogUtils.e(TAG, "lightNode not applied!");
        }
    }

    public void setSmoothLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, i3);
        } else {
            this.smoothLevel = i3;
            this.smoothUpdated = true;
        }
    }

    public void setSmoothSharpenStrength(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, Float.valueOf(f16));
        } else {
            this.smoothSharpenStrength = f16;
            this.smoothUpdated = true;
        }
    }

    public void setStickerInnerLutFilterListener(MaterialInnerEffectListener materialInnerEffectListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            iPatchRedirector.redirect((short) 111, (Object) this, (Object) materialInnerEffectListener);
        } else {
            this.stickerInnerLutFilterListener = materialInnerEffectListener;
        }
    }

    public void setStickerPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        Thread thread = this.writePCMThread;
        if (thread != null) {
            thread.interrupt();
            this.writePCMThread = null;
        }
        if (this.audioReader != null) {
            this.audioReader = null;
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null && audioTrack.getState() == 1) {
            this.audioTrack.stop();
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.onPause();
        }
    }

    public void setStickerResume(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied()) {
            this.audioReader = this.mLightNode.getAudioReader();
            initAudioTrack();
            initWritePCMThread();
            this.mLightNode.onResume();
        }
    }

    public void setSyncMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, z16);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.setSyncMode(z16);
        }
        this.syncMode = z16;
        this.syncModeUpdated = true;
    }

    public void setTapEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            iPatchRedirector.redirect((short) 107, (Object) this, i3);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.getAsset() != null) {
            this.mLightNode.updateCameraConfigData("event.touchPoint", String.valueOf(i3));
        }
    }

    public void setTouchScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            iPatchRedirector.redirect((short) 124, this, Float.valueOf(f16));
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.getAsset() != null) {
            this.mLightNode.updateCameraConfigData("touch.scale", String.valueOf(f16));
        }
    }

    public void setTouchTriggerEvent(int i3, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied() && this.mLightNode.getAsset() != null) {
            String str = "{\"x\":" + f16 + ",\"y\":" + f17 + "}";
            Log.d(TAG, "setTouchTriggerEvent: jsonStr=" + str);
            this.mLightNode.setAssetData("event.touchPoint", str);
        }
    }

    public void setUEAbility(@Nullable IUEAbilityBase iUEAbilityBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iUEAbilityBase);
        } else {
            this.ueAbility = iUEAbilityBase;
        }
    }

    public void setWatermarkConfig(WatermarkConfig watermarkConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) watermarkConfig);
        } else {
            this.watermarkConfig = watermarkConfig;
        }
    }

    public void setZplanFilamentAbility(@Nullable IZplanFilamentAbility iZplanFilamentAbility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iZplanFilamentAbility);
        } else {
            this.zplanFilamentAbility = iZplanFilamentAbility;
        }
    }

    public void setmIntensity(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Float.valueOf(f16));
        } else {
            this.mIntensity = f16;
        }
    }

    public void stickerReset(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied()) {
            this.mLightNode.resetAsset();
        }
    }

    public void switchAIAbility(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.filterInLightNodeMap == null) {
            this.filterInLightNodeMap = new HashMap<>();
        }
        this.filterInLightNodeMap.put(str, str2);
    }

    public void switchAIBeauty(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        } else {
            this.mAiBeautyEnable = z16;
            this.mAiBeautyUpdated = true;
        }
    }

    public void switchAbilityInLightNode(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, Boolean.valueOf(z16));
            return;
        }
        if (this.filterInLightNodeMap == null) {
            this.filterInLightNodeMap = new HashMap<>();
        }
        this.filterInLightNodeMap.put(str, formatBooleanValue(z16));
    }

    public void switchDebugImage(boolean z16, String str, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26), Boolean.valueOf(z27));
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.switchDebugImage(z16, str, z17, z18, z19, z26, z27);
        }
    }

    public void switchFilterListOn(List<Integer> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, list, Boolean.valueOf(z16));
        } else if (list != null && list.size() != 0) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                switchFilterOn(it.next().intValue(), z16);
            }
        }
    }

    public void switchFilterOn(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.mFilterNodeEnableMap.put(Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    public void switchSegmentFastMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, z16);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null && lightNode.isApplied()) {
            this.mLightNode.switchSegmentFastMode(z16);
        }
    }

    public String toColorString(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (String) iPatchRedirector.redirect((short) 68, (Object) this, i3);
        }
        return String.format("#%02x%02x%02x%02x", Integer.valueOf(Color.red(i3)), Integer.valueOf(Color.green(i3)), Integer.valueOf(Color.blue(i3)), Integer.valueOf(Color.alpha(i3)));
    }

    public void updateCameraConfigData(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) map);
        } else if (map != null && map.size() > 0) {
            this.extraConfigData.putAll(map);
            this.extraConfigUpdated = true;
        }
    }

    public void updateDeviceCameraConfig(DeviceCameraConfig deviceCameraConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) deviceCameraConfig);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.updateDeviceCameraConfig(deviceCameraConfig);
        }
    }

    public void updateFenGeAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, i3);
        } else {
            this.makeupAlpha = i3;
            this.makeupAlphaUpdated = true;
        }
    }

    public void updateLightAuthInfo(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, str3);
            return;
        }
        this.lightAppId = str;
        this.lightAppEntry = str2;
        this.lightLicensePath = str3;
    }

    public void updateLutAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Float.valueOf(f16));
        } else {
            this.mIntensity = f16;
            this.lutAlphaUpdate = true;
        }
    }

    public void updateLutGL(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) {
            updateLutGL(str, 100.0f);
        } else {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        }
    }

    public void updateMakeupAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
        } else {
            this.makeupAlpha = i3;
            this.makeupAlphaUpdated = true;
        }
    }

    public void updateMaterialGL(VideoMaterial videoMaterial) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) videoMaterial);
            return;
        }
        this.isAfterUpdateMaterial = true;
        if (videoMaterial == null || videoMaterial.getLightAsset() == null) {
            videoMaterial = VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath());
        }
        if (!isDeviceSupportMaterial(videoMaterial)) {
            MaterialInnerEffectListener materialInnerEffectListener = this.stickerInnerLutFilterListener;
            if (materialInnerEffectListener != null) {
                materialInnerEffectListener.onDeviceNotSupportMaterial();
            }
            LogUtils.e(TAG, "can not support material");
            return;
        }
        this.mVideoMaterial = videoMaterial;
        if (videoMaterial.getLightAsset().hasMesh()) {
            i3 = 2000;
        } else {
            i3 = 2001;
        }
        this.useMeshType = i3;
        MaterialInnerEffectListener materialInnerEffectListener2 = this.stickerInnerLutFilterListener;
        if (materialInnerEffectListener2 != null) {
            materialInnerEffectListener2.notifyEnableMeshType(i3);
        }
        if (this.mVideoMaterial.getLightAsset().hasLut()) {
            i16 = 1000;
        } else {
            i16 = 1001;
        }
        this.useLutType = i16;
        MaterialInnerEffectListener materialInnerEffectListener3 = this.stickerInnerLutFilterListener;
        if (materialInnerEffectListener3 != null) {
            materialInnerEffectListener3.notifyEnableLutType(i16);
        }
        PreviewPerformanceInfo.getInstance().setStickerID(this.mVideoMaterial.getId());
        this.filterConfigMap.clear();
        IAEProfiler iAEProfiler = this.mAEProfiler;
        if (iAEProfiler != null) {
            iAEProfiler.reset();
        }
    }

    public void updatePhoneRotation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
        } else {
            this.phoneRotation = i3;
        }
    }

    public void updateTouchEvent(int i3, long j3, long j16, ArrayList<PointF> arrayList, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), arrayList, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.updateTouchEvent(i3, j3, j16, arrayList, i16, i17);
        }
    }

    public void updateVoiceDecibel(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.updateVoiceDecibel(f16);
        }
    }

    public void updateWidthHeight(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.width = i3;
        this.height = i16;
        this.previewSizeUpdated = true;
    }

    @Override // com.tencent.aekit.api.standard.filter.IWatermarkHandle
    public void wmAddInfoDict(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            iPatchRedirector.redirect((short) 137, (Object) this, (Object) map);
            return;
        }
        if (this.mLightNode != null) {
            String jSONObject = new JSONObject(map).toString();
            LogUtils.i(TAG, "addWatermarkDict: " + jSONObject);
            this.mLightNode.updateCameraConfigData("watermark_dict", jSONObject);
        }
    }

    @Override // com.tencent.aekit.api.standard.filter.IWatermarkHandle
    public List<WMElement> wmGetEditableWMElements() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            return (List) iPatchRedirector.redirect((short) 138, (Object) this);
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode == null) {
            return Collections.emptyList();
        }
        return lightNode.getEditableWMElement();
    }

    @Override // com.tencent.aekit.api.standard.filter.IWatermarkHandle
    public void wmSetLocation(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            iPatchRedirector.redirect((short) 133, (Object) this, (Object) str);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.updateCameraConfigData("[location]", str);
        }
    }

    @Override // com.tencent.aekit.api.standard.filter.IWatermarkHandle
    public void wmSetOnClickWatermarkListener(OnClickWatermarkListener onClickWatermarkListener) {
        LightNode lightNode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 140)) {
            iPatchRedirector.redirect((short) 140, (Object) this, (Object) onClickWatermarkListener);
            return;
        }
        if (this.mWatermarkClickListener != null && onClickWatermarkListener == null && (lightNode = this.mLightNode) != null) {
            lightNode.setOnClickWatermarkListener(null);
        }
        this.mWatermarkClickListener = onClickWatermarkListener;
        this.wmClickListenerUpdated = true;
    }

    @Override // com.tencent.aekit.api.standard.filter.IWatermarkHandle
    public void wmSetOnlineUsrCountDelegate(String str, OnWatermarkDataListener onWatermarkDataListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            iPatchRedirector.redirect((short) 139, (Object) this, (Object) str, (Object) onWatermarkDataListener);
        } else {
            this.wmDelegateMap.put(str, onWatermarkDataListener);
            this.wmOnlineUsrCountDelegateUpdated = true;
        }
    }

    @Override // com.tencent.aekit.api.standard.filter.IWatermarkHandle
    public void wmSetTemperature(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            iPatchRedirector.redirect((short) 136, (Object) this, (Object) str);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.updateCameraConfigData("[temperature]", str);
        }
    }

    @Override // com.tencent.aekit.api.standard.filter.IWatermarkHandle
    public void wmSetWeatherCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            iPatchRedirector.redirect((short) 134, (Object) this, i3);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.updateCameraConfigData("[weatherType]", String.valueOf(i3));
        }
    }

    @Override // com.tencent.aekit.api.standard.filter.IWatermarkHandle
    public void wmSetWeatherStr(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            iPatchRedirector.redirect((short) 135, (Object) this, (Object) str);
            return;
        }
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.updateCameraConfigData("[weather]", str);
        }
    }

    public AEFilterManager(String str, boolean z16, Map<String, String> map) {
        this(str, z16, true, map, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), map);
    }

    public int drawFrame(int i3, boolean z16, long j3, int i16, int i17) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Integer) iPatchRedirector.redirect((short) 53, this, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        int changeTextureIfNeed = changeTextureIfNeed(this.isNeedPictureTest, i3);
        IAEProfiler iAEProfiler = this.mAEProfiler;
        if (iAEProfiler != null) {
            iAEProfiler.startByTag(IAEProfiler.TAG_DRAW_FRAME);
        }
        long longValue = PreviewPerformanceInfo.getMicTime().longValue();
        initLightFilter();
        LightNode lightNode = this.mLightNode;
        if (lightNode != null) {
            lightNode.updateCameraTextureTimestamp(j3);
        }
        if (onlyLightNode() && i16 != 0 && i17 != 0) {
            i18 = this.mLightNode.render(changeTextureIfNeed, i16, i17);
        } else {
            this.mAEFilterChain.process(changeTextureIfNeed, this.outputTexture, this.width, this.height);
            i18 = this.outputTexture;
        }
        IAEProfiler iAEProfiler2 = this.mAEProfiler;
        if (iAEProfiler2 != null) {
            iAEProfiler2.endByTag(IAEProfiler.TAG_DRAW_FRAME);
            this.mAEProfiler.print();
        }
        PreviewPerformanceInfo.getInstance().updateInfo(PreviewPerformanceInfo.getMicTime().longValue() - longValue);
        IAEProfiler iAEProfiler3 = this.mAEProfiler;
        if (iAEProfiler3 != null) {
            iAEProfiler3.endByTag(IAEProfiler.TAG_CAL_FPS);
            this.mAEProfiler.startByTag(IAEProfiler.TAG_CAL_FPS);
        }
        return i18;
    }

    public void updateLutGL(String str, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, str, Float.valueOf(f16));
            return;
        }
        LogUtils.d(TAG, "[updateLutGL] lut = " + str);
        this.mLutPath = str;
        this.mIntensity = f16;
        this.lutPathUpdated = true;
        this.lutAlphaUpdate = true;
        LightNode lightNode = this.mLightNode;
        if (lightNode == null || lightNode.getAsset() == null) {
            return;
        }
        this.useLutType = 1001;
        MaterialInnerEffectListener materialInnerEffectListener = this.stickerInnerLutFilterListener;
        if (materialInnerEffectListener != null) {
            materialInnerEffectListener.notifyEnableLutType(1001);
        }
    }

    public AEFilterManager(String str, boolean z16, boolean z17, Map<String, String> map) {
        this(str, z16, z17, map, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), map);
    }

    public AEFilterManager(String str, boolean z16, boolean z17, Map<String, String> map, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), map, Boolean.valueOf(z18));
            return;
        }
        this.mLightNodeControllerPresetData = new ConcurrentHashMap<>();
        this.detectShorterLengthMap = new HashMap<>();
        this.filterConfigMap = new HashMap<>();
        this.bundlePathMap = new HashMap<>();
        this.pendingToSetBundles = false;
        this.useLutType = 1001;
        this.useMeshType = 2001;
        this.deviceSupportAbility = new String[]{"ai.segment", "ai.segmentHair", "ai.face3d", "3d.kapu", "ai.catFace", "ai.body", "ai.faceStaticFeature", "ai.expression"};
        this.wmDelegateMap = new HashMap<>();
        this.wmClickListenerUpdated = false;
        this.wmOnlineUsrCountDelegateUpdated = false;
        this.tipsListenerUpdated = false;
        this.assetListenerUpdated = false;
        this.cameraExposureListenerUpdated = false;
        this.isPicNeedFlipBeforeRender = false;
        this.isBgmHidden = false;
        this.isAudioPaused = false;
        this.isRealtime = true;
        this.needLowEndDownGrade = false;
        this.faceFeatureOpen = false;
        this.faceNatureOpen = true;
        this.faceGodOpen = false;
        this.faceGoddessOpen = false;
        this.softFaceBarUpdate = false;
        this.redCheekBarUpdate = false;
        this.lipsBarUpdate = false;
        this.smoothUpdated = true;
        this.beautyUpdated = true;
        this.lutPathUpdated = true;
        this.lutAlphaUpdate = true;
        this.segmentUpdated = true;
        this.filterInLightUpdated = true;
        this.previewSizeUpdated = true;
        this.externalRenderUpdated = true;
        this.faceDataUpdated = false;
        this.flipBeforeRenderUpdated = false;
        this.cosmeticsAlphaUpdated = false;
        this.makeupAlphaUpdated = false;
        this.factorThinUpdated = false;
        this.factorSmallUpdated = false;
        this.faceFeatureUpdated = false;
        this.faceThinTypeUpdated = false;
        this.lightInputOriention = CameraConfig.ImageOrigin.BottomLeft;
        this.mAssetUpdate = false;
        this.extraConfigData = new HashMap();
        this.extraConfigUpdated = false;
        this.mFilterNodeEnableMap = new LinkedHashMap();
        this.mFilterOrderList = new ArrayList();
        this.mAiAttr = null;
        this.mAiParam = new AIParam();
        this.mAiCtrl = new AICtrl();
        this.textures = new int[1];
        this.isVeryLowEndDevice = false;
        this.isLowLightEnv = false;
        this.avatarMode = false;
        this.mIntensity = 100.0f;
        this.makeupAlpha = 100;
        this.mIsInited = false;
        this.needFaceDetect = false;
        this.filterInSmooth = false;
        this.forceFaceDetect = true;
        this.syncMode = false;
        this.syncModeUpdated = false;
        this.mLogFlag = false;
        this.isOverallSmooth = false;
        this.stickerInnerLutFilterListener = null;
        this.isNeedPictureTest = false;
        this.testBmpTexture = new int[1];
        this.mTestBmp = null;
        this.closeAIBeautyConfig = false;
        this.mAIBeautyValid = true;
        this.mAIBeautyParamsJsonBean = null;
        this.mPickUpBitmapList = new ArrayList();
        this.smartBitmapList = new ArrayList();
        this.mFrameIndex = 0;
        this.mAutoTest = false;
        this.mAutoTestSourceType = 0;
        this.beginVideoCodeProgress = false;
        this.isNeedSkipFrame = false;
        this.isAfterUpdateMaterial = false;
        this.customMaterialUpdated = true;
        this.mAEProfiler = AEProfiler.getInstance();
        this.mAsyncInitFilters = false;
        this.mDestroyed = false;
        this.needUpdateAIFilter = true;
        this.segmentFrames = 0;
        this.ueAbility = null;
        this.zplanFilamentAbility = null;
        this.watermarkConfig = null;
        this.smoothLevel = 0;
        this.smoothSharpenStrength = 1.2f;
        this.beautyLutClearAlpha = 20;
        this.beautyLutFoundationAlpah = 30;
        this.defaultTransBasicType = BeautyRealConfig.TYPE.BASIC4;
        this.douyinFactorThin = 0;
        this.douyinFactorSmall = 0;
        this.exposureValue = 0;
        this.cosmeticsAlpha = 50;
        this.adjustAlpha = 1.0f;
        this.lightnessLevel = 0;
        this.hightLightLevel = 0;
        this.shadowLevel = 0;
        this.compareLevel = 0;
        this.sharpLevel = 0;
        this.saturationLevel = 0;
        this.colorTemperature = 0;
        this.fadeLevel = 0;
        this.segStrokeColor = Color.argb(255, 255, 255, 255);
        this.segBgColor = Color.argb(0, 0, 0, 0);
        this.rotationMatrix = new float[16];
        this.smoothVersion = str;
        this.isBgmHidden = z16;
        this.isRealtime = z17;
        this.aiSwitchMap = map;
        this.needLowEndDownGrade = z18;
        setDefaultOrder();
        this.mAEFilterChain = new AEFilterChain();
        initAudioTrack();
        initLightAuthInfo();
    }
}
