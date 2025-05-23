package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.OperateInfoManager;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.TimeoutCounter;
import com.tencent.youtu.sdkkitframework.common.YTImageData;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtSdkConfig;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.ytagreflectlivecheck.ReflectionData;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectSettings;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectData;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectImage;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ReflectLivenessState extends YtFSMBaseState {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ReflectLivenessState";
    private YTActRefData actRefData;
    private int actReflectUXMode;
    private String appId;
    private int backendProtoType;
    private int changePointNum;
    private String colorData;
    private int continuousDetectCount;
    private String controlConfig;
    private ReflectProcessType currentProcessType;
    private String extraConfig;
    private YTFaceTracker.TrackedFace[] faceStatus;
    private String legitimateReflectVersion;
    private YTFaceTracker.Param mOriginParam;
    private boolean needAngleDetect;
    private boolean needCheckFaces;
    private boolean needCheckMultiFaces;
    private boolean needCheckPose;
    private boolean needLocalConfig;
    private boolean needManualTrigger;
    private boolean needRandom;
    private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
    private int poseState;
    private String randomColorData;
    public int reflectImagesShortenStrategy;
    private float secondaryPitchThreshold;
    private float secondaryRollThreshold;
    private float secondaryYawThreshold;
    private int securityLevel;
    private LiveStyleRequester.SeleceData seleceData;
    private int simiThreshold;
    private int stableFrameCount;
    private TimeoutCounter tipsTimer;
    private YTFaceTracker tracker;

    /* compiled from: P */
    /* renamed from: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState$14, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static /* synthetic */ class AnonymousClass14 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$youtu$sdkkitframework$liveness$ReflectLivenessState$ReflectProcessType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17063);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            ReflectProcessType.values();
            int[] iArr = new int[4];
            $SwitchMap$com$tencent$youtu$sdkkitframework$liveness$ReflectLivenessState$ReflectProcessType = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$tencent$youtu$sdkkitframework$liveness$ReflectLivenessState$ReflectProcessType;
                ReflectProcessType reflectProcessType = ReflectProcessType.RPT_TIPWAIT;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$tencent$youtu$sdkkitframework$liveness$ReflectLivenessState$ReflectProcessType;
                ReflectProcessType reflectProcessType2 = ReflectProcessType.RPT_TIPWAIT;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$tencent$youtu$sdkkitframework$liveness$ReflectLivenessState$ReflectProcessType;
                ReflectProcessType reflectProcessType3 = ReflectProcessType.RPT_TIPWAIT;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ReflectProcessType {
        private static final /* synthetic */ ReflectProcessType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ReflectProcessType RPT_FINISH;
        public static final ReflectProcessType RPT_INIT;
        public static final ReflectProcessType RPT_REFLECT;
        public static final ReflectProcessType RPT_TIPWAIT;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15120);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ReflectProcessType reflectProcessType = new ReflectProcessType("RPT_TIPWAIT", 0);
            RPT_TIPWAIT = reflectProcessType;
            ReflectProcessType reflectProcessType2 = new ReflectProcessType("RPT_INIT", 1);
            RPT_INIT = reflectProcessType2;
            ReflectProcessType reflectProcessType3 = new ReflectProcessType("RPT_REFLECT", 2);
            RPT_REFLECT = reflectProcessType3;
            ReflectProcessType reflectProcessType4 = new ReflectProcessType("RPT_FINISH", 3);
            RPT_FINISH = reflectProcessType4;
            $VALUES = new ReflectProcessType[]{reflectProcessType, reflectProcessType2, reflectProcessType3, reflectProcessType4};
        }

        ReflectProcessType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ReflectProcessType valueOf(String str) {
            return (ReflectProcessType) Enum.valueOf(ReflectProcessType.class, str);
        }

        public static ReflectProcessType[] values() {
            return (ReflectProcessType[]) $VALUES.clone();
        }
    }

    public ReflectLivenessState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.legitimateReflectVersion = "3.6.2";
        this.poseState = -1;
        this.currentProcessType = ReflectProcessType.RPT_INIT;
        this.continuousDetectCount = 0;
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        this.needCheckFaces = true;
        this.simiThreshold = 70;
        this.securityLevel = 2;
        this.needLocalConfig = false;
        this.stableFrameCount = 5;
        this.backendProtoType = 0;
        this.needCheckPose = false;
        this.extraConfig = "";
        this.changePointNum = 2;
        this.needRandom = false;
        this.needManualTrigger = false;
        this.tracker = null;
        this.controlConfig = "";
        this.actReflectUXMode = 0;
        this.tipsTimer = new TimeoutCounter("reflect tips timeout counter");
        this.needCheckMultiFaces = false;
        this.needAngleDetect = false;
        this.secondaryYawThreshold = 50.0f;
        this.secondaryPitchThreshold = 50.0f;
        this.secondaryRollThreshold = 50.0f;
    }

    private void clearData() {
        this.currentProcessType = ReflectProcessType.RPT_TIPWAIT;
        this.continuousDetectCount = 0;
        this.poseState = -1;
        this.needCheckFaces = true;
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        YTAGReflectLiveCheckInterface.cancel();
    }

    private ActionReflectReq getActionReflectLiveReq(ReflectionData reflectionData, YTActReflectData yTActReflectData, String str) {
        ActionReflectReq actionReflectReq = new ActionReflectReq();
        actionReflectReq.app_id = YTAGReflectLiveCheckInterface.mAppId;
        actionReflectReq.color_data = str;
        actionReflectReq.platform = 2;
        actionReflectReq.select_data = yTActReflectData.select_data;
        if (reflectionData != null) {
            actionReflectReq.reflect_data = translation(reflectionData);
        }
        actionReflectReq.live_image = new YTImageInfo(yTActReflectData.best);
        actionReflectReq.eye_image = new YTImageInfo(yTActReflectData.eye);
        actionReflectReq.mouth_image = new YTImageInfo(yTActReflectData.mouth);
        actionReflectReq.compare_image = null;
        actionReflectReq.mode = 0;
        actionReflectReq.session_id = null;
        return actionReflectReq;
    }

    private ReflectLiveReq getReflectLiveReq(ReflectionData reflectionData, String str) {
        ReflectLiveReq reflectLiveReq = new ReflectLiveReq();
        reflectLiveReq.color_data = str;
        reflectLiveReq.platform = 2;
        if (reflectionData != null) {
            reflectLiveReq.reflect_data = translation(reflectionData);
            reflectLiveReq.live_image = null;
        }
        reflectLiveReq.compare_image = null;
        reflectLiveReq.session_id = null;
        reflectLiveReq.app_id = YTAGReflectLiveCheckInterface.mAppId;
        return reflectLiveReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailure(int i3, String str, String str2) {
        String str3 = TAG;
        YtLogger.e(str3, "failed :" + ("message:" + str + "\ntips:" + str2 + "\ncode:" + i3), null);
        String makeMessageJson = CommonUtils.makeMessageJson(4194304, str, str);
        YtSDKStats.getInstance().reportError(i3, str);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
        hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
        hashMap.put(StateEvent.Name.PROCESS_RESULT, "failed");
        if (i3 == 500) {
            makeMessageJson = CommonUtils.makeMessageJson(ErrorCode.YT_SDK_REFLECTION_COLOR_DATA_PARSE_ERROR, str, str);
            hashMap.put("error_code", Integer.valueOf(ErrorCode.YT_SDK_REFLECTION_COLOR_DATA_PARSE_ERROR));
        } else {
            hashMap.put("error_code", 4194304);
        }
        hashMap.put(StateEvent.Name.ERROR_REASON_CODE, Integer.valueOf(i3));
        hashMap.put("message", makeMessageJson);
        YtFSM.getInstance().sendFSMEvent(hashMap);
        this.currentProcessType = ReflectProcessType.RPT_FINISH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSuccess(ReflectionData reflectionData) {
        int i3;
        int i16;
        if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
            try {
                YTActRefImage yTActRefImage = this.actRefData.best;
                YTActReflectImage yTActReflectImage = new YTActReflectImage(yTActRefImage.image, yTActRefImage.xys, yTActRefImage.checksum);
                YTActRefImage yTActRefImage2 = this.actRefData.eye;
                YTActReflectImage yTActReflectImage2 = new YTActReflectImage(yTActRefImage2.image, yTActRefImage2.xys, yTActRefImage2.checksum);
                YTActRefImage yTActRefImage3 = this.actRefData.mouth;
                ActionReflectReq actionReflectLiveReq = getActionReflectLiveReq(reflectionData, new YTActReflectData(yTActReflectImage, yTActReflectImage2, new YTActReflectImage(yTActRefImage3.image, yTActRefImage3.xys, yTActRefImage3.checksum), this.seleceData), this.colorData);
                actionReflectLiveReq.app_id = this.appId;
                Bitmap bitmap = YtFSM.getInstance().getContext().imageToCompare;
                if (bitmap != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    if (width > height) {
                        i3 = width;
                    } else {
                        i3 = height;
                    }
                    if (i3 > 640) {
                        bitmap = imageScale(bitmap, (width * 640) / i3, (height * 640) / i3);
                        YtLogger.d(TAG, "resize image. from w:" + width + " h:" + height + " to w:" + bitmap.getWidth() + " h:" + bitmap.getHeight());
                    }
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream);
                    actionReflectLiveReq.compare_image = new YTImageInfo(new YTActReflectImage(byteArrayOutputStream.toByteArray(), null, null));
                }
                actionReflectLiveReq.color_data = this.colorData;
                this.stateData.put("reflect_request_object", actionReflectLiveReq);
            } catch (Exception e16) {
                YtLogger.e(TAG, "Handle actref data failed:", e16);
            }
        } else {
            ReflectLiveReq reflectLiveReq = getReflectLiveReq(reflectionData, this.colorData);
            Bitmap bitmap2 = YtFSM.getInstance().getContext().imageToCompare;
            if (bitmap2 != null) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                int width2 = bitmap2.getWidth();
                int height2 = bitmap2.getHeight();
                if (width2 > height2) {
                    i16 = width2;
                } else {
                    i16 = height2;
                }
                if (i16 > 640) {
                    bitmap2 = imageScale(bitmap2, (width2 * 640) / i16, (height2 * 640) / i16);
                    YtLogger.d(TAG, "resize image. from w:" + width2 + " h:" + height2 + " to w:" + bitmap2.getWidth() + " h:" + bitmap2.getHeight());
                }
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream2);
                reflectLiveReq.compare_image = new String(Base64.encode(byteArrayOutputStream2.toByteArray(), 2));
            }
            YtLogger.d(TAG, "on Request...");
            reflectLiveReq.color_data = this.colorData;
            reflectLiveReq.select_data = this.seleceData;
            this.stateData.put("reflect_request_object", reflectLiveReq);
        }
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE;
    }

    private static Bitmap imageScale(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private void startReflect() {
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.12
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                } else {
                    put(StateEvent.Name.UI_TIPS, StringCode.FL_POSE_KEEP);
                }
            }
        });
        this.currentProcessType = ReflectProcessType.RPT_REFLECT;
        setupRequset();
        YTAGReflectSettings aGSettings = YTAGReflectLiveCheckInterface.getAGSettings();
        aGSettings.safetylevel = this.securityLevel;
        boolean z16 = false;
        aGSettings.isEncodeReflectData = false;
        if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
            z16 = true;
        }
        aGSettings.isActionReflect = z16;
        YTAGReflectLiveCheckInterface.setAGSettings(aGSettings);
        String str = TAG;
        YtLogger.i(str, "Settings: safetyLevel " + aGSettings.safetylevel);
        YtLogger.i(str, "Settings: isEncodeReflectData " + aGSettings.isEncodeReflectData);
        YtLogger.i(str, "Settings: isActionReflect " + aGSettings.isActionReflect);
        YtSDKKitFramework.YtSDKPlatformContext context = YtFSM.getInstance().getContext();
        YTAGReflectLiveCheckInterface.start(context.currentAppContext, context.currentCamera, context.currentRotateState, this.colorData, new YTAGReflectLiveCheckInterface.LightLiveCheckResult() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.13
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                }
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult
            public void onFailed(int i3, String str2, String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    ReflectLivenessState.this.handleFailure(i3, str2, str3);
                } else {
                    iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str2, str3);
                }
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult
            public void onReflectLiveImgData(RawImgData rawImgData) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) rawImgData);
                }
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult
            public void onSuccess(ReflectionData reflectionData) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    YtLogger.o(ReflectLivenessState.TAG, "reflect succeed,get frame count:" + reflectionData.videoData.length);
                    ReflectLivenessState.this.handleSuccess(reflectionData);
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) reflectionData);
            }
        });
    }

    private ReflectColorData translation(ReflectionData reflectionData) {
        CommonUtils.benchMarkBegin("make_pack_use_time_reflection");
        YtLogger.d(TAG, "translation reflectImagesShortenStrategy\uff1a" + this.reflectImagesShortenStrategy);
        int i3 = 0;
        if (this.reflectImagesShortenStrategy == 1) {
            int i16 = 0;
            while (true) {
                RawImgData[] rawImgDataArr = reflectionData.videoData;
                if (i16 >= rawImgDataArr.length) {
                    break;
                }
                if (i16 > 2 && i16 < rawImgDataArr.length - 2 && i16 % 2 != 0) {
                    rawImgDataArr[i16].frameBuffer = new byte[0];
                }
                i16++;
            }
        }
        ReflectColorData reflectColorData = new ReflectColorData();
        ArrayList<ColorImgData> arrayList = new ArrayList<>();
        int i17 = 0;
        while (true) {
            RawImgData[] rawImgDataArr2 = reflectionData.videoData;
            if (i17 >= rawImgDataArr2.length) {
                break;
            }
            arrayList.add(translation(rawImgDataArr2[i17]));
            i17++;
        }
        reflectColorData.setImages_data(arrayList);
        reflectColorData.setBegin_time(reflectionData.beginTime);
        reflectColorData.setChangepoint_time(reflectionData.changePointTime);
        reflectColorData.changepoint_time_list = new ArrayList<>();
        while (true) {
            long[] jArr = reflectionData.changePointTimeList;
            if (i3 >= jArr.length) {
                break;
            }
            reflectColorData.changepoint_time_list.add(Long.valueOf(jArr[i3]));
            i3++;
        }
        reflectColorData.setOffset_sys(reflectionData.offsetSys);
        reflectColorData.setFrame_num(reflectionData.frameNum);
        reflectColorData.setLandmark_num(reflectionData.landMarkNum);
        reflectColorData.setWidth(reflectionData.width);
        reflectColorData.setHeight(reflectionData.height);
        reflectColorData.version = YTAGReflectLiveCheckInterface.VERSION;
        try {
            reflectColorData.setLog(new String(reflectionData.log, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
        }
        reflectColorData.setConfig_begin(reflectionData.config_begin);
        OperateInfoManager.getInstance().setPackUseTime(CommonUtils.benchMarkEnd("make_pack_use_time_reflection"));
        return reflectColorData;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        YTFaceTracker.TrackedFace[] trackedFaceArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.enter();
        YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        try {
            this.poseState = ((Integer) stateByName.getStateDataBy("pose_state")).intValue();
            this.continuousDetectCount = ((Integer) stateByName.getStateDataBy("continuous_detect_count")).intValue();
            this.faceStatus = (YTFaceTracker.TrackedFace[]) stateByName.getStateDataBy("face_status");
            YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
            if (stateByName2 != null) {
                this.seleceData = (LiveStyleRequester.SeleceData) stateByName2.getStateDataBy("select_data");
                if (!this.needLocalConfig) {
                    this.colorData = (String) stateByName2.getStateDataBy("color_data");
                } else if (this.needRandom) {
                    this.colorData = this.randomColorData;
                }
                String str = (String) stateByName2.getStateDataBy("control_config");
                if (str != null) {
                    this.controlConfig = str;
                }
            }
            if (!this.controlConfig.isEmpty()) {
                String[] split = this.controlConfig.split(ContainerUtils.FIELD_DELIMITER);
                if (split.length > 0) {
                    for (String str2 : split) {
                        String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split2.length > 1 && split2[0].equals("actref_ux_mode")) {
                            this.actReflectUXMode = Integer.parseInt(split2[1]);
                        }
                        if (split2.length > 1 && split2[0].equals("reflect_images_shorten_strategy")) {
                            this.reflectImagesShortenStrategy = Integer.parseInt(split2[1]);
                        }
                        if (split2.length > 1 && split2[0].equals("compress_reflection_image_score")) {
                            int parseInt = Integer.parseInt(split2[1]);
                            int i3 = 80;
                            if (parseInt >= 80) {
                                i3 = 99;
                                if (parseInt > 99) {
                                }
                                YTAGReflectLiveCheckJNIInterface.compressReflectionImageScore = parseInt;
                            }
                            parseInt = i3;
                            YTAGReflectLiveCheckJNIInterface.compressReflectionImageScore = parseInt;
                        }
                    }
                }
            }
            YtFSMBaseState stateByName3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
            if (stateByName3 != null) {
                this.actRefData = (YTActRefData) stateByName3.getStateDataBy("act_reflect_data");
            }
            if (this.continuousDetectCount > this.stableFrameCount && this.poseState == 0 && (trackedFaceArr = this.faceStatus) != null && trackedFaceArr.length > 0) {
                YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.9
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                        } else {
                            put(StateEvent.Name.UI_TIPS, StringCode.FL_POSE_KEEP);
                        }
                    }
                });
            }
            if (this.actReflectUXMode == 2) {
                this.currentProcessType = ReflectProcessType.RPT_FINISH;
                handleSuccess(null);
            }
        } catch (Exception e16) {
            YtLogger.e(TAG, "reflection enter failed ", e16);
            CommonUtils.reportException("reflection enter failed ", e16);
        }
        YtFSM.getInstance().updateCacheStrategy(YtFSM.YtFSMUpdateStrategy.CacheStrategy);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        YtLogger.o(TAG, makeStateInfo(TAG, 1));
        YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        stateByName.handleStateAction("reset_timeout", null);
        YTFaceTracker yTFaceTracker = (YTFaceTracker) stateByName.getStateDataBy("detect_instance");
        this.tracker = yTFaceTracker;
        if (yTFaceTracker != null) {
            YTFaceTracker.Param param = yTFaceTracker.getParam();
            this.mOriginParam = param;
            if (param != null) {
                param.detInterval = -1;
                this.tracker.setParam(param);
            }
        } else {
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_VERIFY_MODEL_INIT_FAIL, "\u6a21\u5f0f\u521d\u59cb\u5316\u5931\u8d25");
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                        return;
                    }
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", Integer.valueOf(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "Init YTFaceTrack SDK failed with "));
                }
            });
        }
        this.tipsTimer.reset();
        YtFSM.getInstance().cleanUpQueue();
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void exit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.exit();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) ytFrameworkFireEventType, obj);
            return;
        }
        super.handleEvent(ytFrameworkFireEventType, obj);
        if (this.needManualTrigger && ytFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS) {
            clearData();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void loadStateWith(String str, JSONObject jSONObject, YtSdkConfig ytSdkConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, jSONObject, ytSdkConfig);
            return;
        }
        super.loadStateWith(str, jSONObject, ytSdkConfig);
        String str2 = TAG;
        YtLogger.i(str2, "Reflection version:3.6.9.2");
        String[] split = YTAGReflectLiveCheckInterface.VERSION.split("\\.");
        String str3 = this.legitimateReflectVersion;
        YtLogger.i(str2, "Wanted Reflection Version: " + str3);
        String[] split2 = str3.split("\\.");
        if (Integer.parseInt(split[0]) != Integer.parseInt(split2[0])) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                        return;
                    }
                    put(StateEvent.Name.WARNING_TIPS, "\u53cd\u5149\u5e93\u7248\u672c\u5f02\u5e38\uff01\u76ee\u6807\u7248\u672c\uff1a" + ReflectLivenessState.this.legitimateReflectVersion + " \u5f53\u524d\u7248\u672c\uff1a" + YTAGReflectLiveCheckInterface.VERSION);
                }
            });
        } else if (Integer.parseInt(split[1]) != Integer.parseInt(split2[1])) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                        return;
                    }
                    put(StateEvent.Name.WARNING_TIPS, "\u53cd\u5149\u5e93\u7248\u672c\u5f02\u5e38\uff01\u76ee\u6807\u7248\u672c\uff1a" + ReflectLivenessState.this.legitimateReflectVersion + " \u5f53\u524d\u7248\u672c\uff1a" + YTAGReflectLiveCheckInterface.VERSION);
                }
            });
        } else if (Integer.parseInt(split[2]) < Integer.parseInt(split2[2])) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                        return;
                    }
                    put(StateEvent.Name.WARNING_TIPS, "\u53cd\u5149\u5e93\u7248\u672c\u8fc7\u4f4e\uff01\u76ee\u6807\u7248\u672c\uff1a" + ReflectLivenessState.this.legitimateReflectVersion + " \u5f53\u524d\u7248\u672c\uff1a" + YTAGReflectLiveCheckInterface.VERSION);
                }
            });
        }
        int initModel = YTAGReflectLiveCheckInterface.initModel(this.appId, YtSDKKitFramework.getInstance().version().split("-")[0]);
        if (initModel != 0) {
            YtLogger.e(str2, "failed to init reflect sdk " + initModel, null);
            YtSDKStats.getInstance().reportError(initModel, "failed to init reflect sdk");
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(initModel) { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.4
                static IPatchRedirector $redirector_;
                public final /* synthetic */ int val$initR;

                {
                    this.val$initR = initModel;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this, initModel);
                        return;
                    }
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", Integer.valueOf(ErrorCode.YT_SDK_REFLECT_INIT_FAILED));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_REFLECT_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "Init YTReflect SDK failed with " + initModel));
                }
            });
        }
        if (this.needRandom) {
            this.randomColorData = YTAGReflectLiveCheckJNIInterface.FRGenConfigData(this.changePointNum, this.extraConfig);
        }
        YTAGReflectLiveCheckInterface.setReflectNotice(new YTReflectNotice() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                }
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice
            public void onDelayCalc() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ReflectLivenessState.this.needCheckFaces = false;
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        if (YtFSM.getInstance().getContext().reflectListener != null) {
            YTAGReflectLiveCheckInterface.setReflectListener(new YTAGReflectLiveCheckInterface.IYTReflectListener() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                    }
                }

                @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.IYTReflectListener
                public float onGetAppBrightness() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        return ((Float) iPatchRedirector2.redirect((short) 4, (Object) this)).floatValue();
                    }
                    try {
                        return YtFSM.getInstance().getContext().reflectListener.onGetAppBrightness();
                    } catch (Exception e16) {
                        YtLogger.e(ReflectLivenessState.TAG, "onGetAppBrightness error", e16);
                        return -1.0f;
                    }
                }

                @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.IYTReflectListener
                public void onReflectEvent(ColorMatrixColorFilter colorMatrixColorFilter, float f16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, colorMatrixColorFilter, Float.valueOf(f16));
                        return;
                    }
                    try {
                        if (!ReflectLivenessState.this.stateData.containsKey("refcontrol_begin")) {
                            ReflectLivenessState.this.stateData.put("refcontrol_begin", String.valueOf(System.currentTimeMillis() * 1000));
                        }
                        YtFSM.getInstance().getContext().reflectListener.onReflectEvent(colorMatrixColorFilter, f16);
                    } catch (Exception e16) {
                        YtLogger.e(ReflectLivenessState.TAG, "onReflectEvent error", e16);
                    }
                }

                @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.IYTReflectListener
                public void onReflectStart(long j3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, j3);
                        return;
                    }
                    try {
                        YtFSM.getInstance().getContext().reflectListener.onReflectStart(j3);
                    } catch (Exception e16) {
                        YtLogger.e(ReflectLivenessState.TAG, "onReflectStart error", e16);
                    }
                }
            });
        } else {
            YTAGReflectLiveCheckInterface.setReflectListener(null);
        }
        YTAGReflectLiveCheckJNIInterface.configNativeLog(true);
        YTAGReflectLiveCheckJNIInterface.updateParam("log_level", "3");
        YTAGReflectLiveCheckJNIInterface.updateParam("is_alone_raw_push", "0");
        YTAGReflectLiveCheckJNIInterface.setLoggerListener(new YTAGReflectLiveCheckJNIInterface.IYtLoggerListener() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                }
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface.IYtLoggerListener
            public void log(String str4, String str5) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str4, (Object) str5);
                } else {
                    YtLogger.d(str4, str5);
                }
            }
        });
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void moveToNextState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.moveToNextState();
        if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE) {
            if (YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName)) == -1) {
                sendFSMTransitError(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
                return;
            }
            return;
        }
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onPause();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onResume();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            clearData();
            super.reset();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void unload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.unload();
        YTAGReflectLiveCheckInterface.cancel();
        YTAGReflectLiveCheckInterface.releaseModel();
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void update(YTImageData yTImageData, long j3) {
        int i3;
        YTFaceTracker.TrackedFace[] trackedFaceArr;
        boolean z16;
        int i16;
        YTFaceTracker.TrackedFace[] trackedFaceArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, yTImageData, Long.valueOf(j3));
            return;
        }
        super.update(yTImageData, j3);
        if (this.needAngleDetect && (trackedFaceArr2 = this.faceStatus) != null && trackedFaceArr2.length > 0 && !SilentLivenessHelper.faceAngleForceCheck(trackedFaceArr2[0], this.secondaryYawThreshold, this.secondaryPitchThreshold, this.secondaryRollThreshold)) {
            YtLogger.o(TAG, "reflect face angle error");
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                        return;
                    }
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", 400103);
                    put("message", CommonUtils.makeMessageJson(400103, StringCode.YT_FACE_REF_ANGLE_DETECT_ERROR, "reflection angle detect fail"));
                }
            });
            this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE;
        }
        int ordinal = this.currentProcessType.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    String str = TAG;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("reflect continuous_detect_count ");
                    sb5.append(this.continuousDetectCount);
                    sb5.append("pass flag ");
                    if (this.poseState != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    YtLogger.d(str, sb5.toString());
                    YtLogger.d(str, "reflect pose state " + this.poseState);
                    if (this.needCheckFaces && ((this.needCheckPose && (i16 = this.poseState) != 0 && i16 != 9) || ((this.needCheckMultiFaces && this.poseState == 1) || this.poseState == 1))) {
                        YtLogger.o(str, "reflect error: no face");
                        YTAGReflectLiveCheckInterface.cancel();
                        handleFailure(-1, "\u68c0\u6d4b\u5f02\u5e38", "\u8bf7\u4fdd\u6301\u59ff\u6001");
                    }
                    if (this.faceStatus != null) {
                        byte[] bArr = yTImageData.imgData;
                        int i17 = yTImageData.width;
                        int i18 = yTImageData.height;
                        int i19 = YtFSM.getInstance().getContext().currentRotateState;
                        YTFaceTracker.TrackedFace trackedFace = this.faceStatus[0];
                        YTAGReflectLiveCheckInterface.pushImageData(bArr, i17, i18, j3, i19, trackedFace.faceShape, trackedFace.pitch, trackedFace.yaw, trackedFace.roll);
                    }
                }
            } else {
                if (this.continuousDetectCount > this.stableFrameCount && (((i3 = this.poseState) == 0 || i3 == 9) && (trackedFaceArr = this.faceStatus) != null && trackedFaceArr.length > 0)) {
                    startReflect();
                }
                this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
            }
        } else if (this.tipsTimer.isRunning() && !this.tipsTimer.checkTimeout()) {
            if (this.continuousDetectCount <= 1) {
                this.tipsTimer.reset();
            } else {
                YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.11
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReflectLivenessState.this);
                        } else {
                            put(StateEvent.Name.UI_TIPS, StringCode.FL_POSE_KEEP);
                        }
                    }
                });
            }
        } else {
            this.tipsTimer.cancel();
            this.currentProcessType = ReflectProcessType.RPT_INIT;
        }
        moveToNextState();
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void updateSDKSetting(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
            return;
        }
        try {
            if (jSONObject.has("similarity_threshold")) {
                this.simiThreshold = jSONObject.getInt("similarity_threshold");
            } else {
                this.simiThreshold = 70;
            }
            if (jSONObject.has("reflect_security_level")) {
                this.securityLevel = jSONObject.getInt("reflect_security_level");
            }
            if (jSONObject.has("local_config_flag")) {
                this.needLocalConfig = jSONObject.getBoolean("local_config_flag");
            }
            if (jSONObject.has("color_data")) {
                this.colorData = jSONObject.getString("color_data");
            }
            if (jSONObject.has("stable_frame_num")) {
                this.stableFrameCount = jSONObject.getInt("stable_frame_num");
            }
            if (jSONObject.has("backend_proto_type")) {
                this.backendProtoType = jSONObject.getInt("backend_proto_type");
            }
            if (jSONObject.has("force_pose_check")) {
                this.needCheckPose = jSONObject.getBoolean("force_pose_check");
            }
            if (jSONObject.has("manual_trigger")) {
                this.needManualTrigger = jSONObject.getBoolean("manual_trigger");
            }
            if (jSONObject.has("reflect_tips_countdown_ms")) {
                this.tipsTimer.init(Math.max(0, Math.min(10000, jSONObject.getInt("reflect_tips_countdown_ms"))), false);
            }
            if (jSONObject.has("control_config")) {
                this.controlConfig = jSONObject.getString("control_config");
            }
            this.appId = jSONObject.getString("app_id");
            if (jSONObject.has("extra_config")) {
                this.extraConfig = jSONObject.getString("extra_config");
            }
            if (jSONObject.has("change_point_num")) {
                this.changePointNum = jSONObject.getInt("change_point_num");
            }
            if (jSONObject.has("need_random_flag")) {
                this.needRandom = jSONObject.getBoolean("need_random_flag");
            }
            if (jSONObject.has("secondary_yaw_threshold")) {
                this.secondaryYawThreshold = (float) jSONObject.getDouble("secondary_yaw_threshold");
            }
            if (jSONObject.has("secondary_pitch_threshold")) {
                this.secondaryPitchThreshold = (float) jSONObject.getDouble("secondary_pitch_threshold");
            }
            if (jSONObject.has("secondary_roll_threshold")) {
                this.secondaryRollThreshold = (float) jSONObject.getDouble("secondary_roll_threshold");
            }
            this.needAngleDetect = jSONObject.optBoolean("need_angle_detect_reflection", false);
            this.needCheckMultiFaces = jSONObject.optBoolean("need_check_multiface", false);
        } catch (JSONException e16) {
            e16.printStackTrace();
            YtLogger.e(TAG, "Failed to parse json:", e16);
        }
    }

    private void setupRequset() {
    }

    private ColorImgData translation(RawImgData rawImgData) {
        ColorImgData colorImgData = new ColorImgData();
        colorImgData.setImage(new String(Base64.encode(rawImgData.frameBuffer, 2)));
        colorImgData.checksum = rawImgData.checksum;
        colorImgData.setCapture_time(rawImgData.captureTime);
        colorImgData.setX(rawImgData.f385202x);
        colorImgData.setY(rawImgData.f385203y);
        return colorImgData;
    }
}
