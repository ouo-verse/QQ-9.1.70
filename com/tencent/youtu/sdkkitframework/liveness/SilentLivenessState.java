package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Rect;
import android.hardware.Camera;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SilentLivenessState extends YtFSMBaseState {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SilentLivenessState";
    private float bigFaceThresholdBuffer;
    public float bigfaceThreshold;
    private float blurDetectThreshold;
    private int cameraRotateState;
    private String configIniName;
    private int continueCloseEyeCount;
    private int continueNoValidFaceCount;
    private int continueNovalidFaceCountThreshold;
    private int continueShelterJudgeCount;
    private int continuousAngleNum;
    private int continuousAngleNumThreshold;
    private TimeoutCounter countdowner;
    private int currentAdviseTip;
    private int currentShelterJudge;
    private int detectAvailableCount;
    private int detectIntervalCount;
    private String extraTips;
    private float eyeOpenThreshold;
    private boolean faceAngleCorrectionDone;
    private int frameNum;
    private float inRectThreshold;
    public float intersectRatio;
    private int invalidPointCount;
    private boolean isFirstStablePass;
    private boolean isLoadResourceOnline;
    private float maskHeightRatio;
    private float maskWidthRatio;
    private float maxEyeScore;
    private float maxInRectRatio;
    private float maxMouthScore;
    private float maxShelterScore;
    private float minEyeScore;
    private float minMouthScore;
    private boolean needBigFaceMode;
    private boolean needCheckEyeOpen;
    private boolean needCheckMultiFaces;
    private boolean needCheckPose;
    private boolean needCheckShelter;
    private boolean needCloseTimeout;
    private boolean needManualTrigger;
    private boolean needTimeoutTimer;
    private int pitchThreshold;
    private float poseThresholdBuffer;
    private TimeoutCounter predetectCountdowner;
    private int prevAdvise;
    private int prevJudge;
    private int previewHeight;
    private int previewWidth;
    private Rect previousFaceRect;
    private int previousShelterJudge;
    private String resourceDownloadPath;
    private int rollThreshold;
    private int sameFaceTipCount;
    private float secondaryPitchThreshold;
    private float secondaryRollThreshold;
    private float secondaryYawThreshold;
    private float smallFaceThresholdBuffer;
    public float smallfaceThreshold;
    private int stableCountNum;
    private int stableFaceCount;
    private float stableRoiThreshold;
    private boolean tipFilterFlag;
    private boolean triggerLiveBeginEventFlag;
    private int unstableCount;
    private int yawThreshold;
    private YTFaceTracker ytFaceTracker;

    /* compiled from: P */
    /* renamed from: com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState$2, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17965);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            YtSDKKitFramework.YtSDKKitFrameworkWorkMode.values();
            int[] iArr = new int[8];
            $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode2 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr3[5] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode3 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr4[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SilentLivenessState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.detectAvailableCount = 0;
        this.prevAdvise = -1;
        this.prevJudge = -1;
        this.isLoadResourceOnline = false;
        this.resourceDownloadPath = "";
        this.isFirstStablePass = false;
        this.countdowner = new TimeoutCounter("Liveness timeout counter");
        this.predetectCountdowner = new TimeoutCounter("Predetect timeout counter");
        this.needManualTrigger = false;
        this.eyeOpenThreshold = 0.22f;
        this.needCheckEyeOpen = false;
        this.pitchThreshold = 30;
        this.yawThreshold = 25;
        this.rollThreshold = 25;
        this.blurDetectThreshold = 0.3f;
        this.bigfaceThreshold = 1.0f;
        this.smallfaceThreshold = 0.5f;
        this.needTimeoutTimer = false;
        this.continueCloseEyeCount = 0;
        this.sameFaceTipCount = 0;
        this.triggerLiveBeginEventFlag = false;
        this.needBigFaceMode = true;
        this.detectIntervalCount = 5;
        this.stableCountNum = 5;
        this.maxEyeScore = -1.0E10f;
        this.minEyeScore = 1.0E10f;
        this.maxMouthScore = -1.0E10f;
        this.minMouthScore = 1.0E10f;
        this.maxInRectRatio = -1.0E10f;
        this.tipFilterFlag = true;
        this.inRectThreshold = 0.7f;
        this.maxShelterScore = -1.0E10f;
        this.bigFaceThresholdBuffer = 0.05f;
        this.smallFaceThresholdBuffer = 0.05f;
        this.poseThresholdBuffer = 0.05f;
        this.stableRoiThreshold = 0.9f;
        this.stableFaceCount = 0;
        this.unstableCount = 0;
        this.previousFaceRect = null;
        this.needCheckShelter = true;
        this.needCheckPose = false;
        this.continueNoValidFaceCount = 0;
        this.continueNovalidFaceCountThreshold = 5;
        this.intersectRatio = -1.0E10f;
        this.ytFaceTracker = null;
        this.currentShelterJudge = -1;
        this.previousShelterJudge = 0;
        this.continueShelterJudgeCount = 0;
        this.currentAdviseTip = 0;
        this.extraTips = "";
        this.frameNum = 0;
        this.needCheckMultiFaces = false;
        this.needCloseTimeout = false;
        this.configIniName = "yt_model_config.ini";
        this.secondaryYawThreshold = 50.0f;
        this.secondaryPitchThreshold = 50.0f;
        this.secondaryRollThreshold = 50.0f;
        this.faceAngleCorrectionDone = false;
        this.continuousAngleNumThreshold = 1;
        this.continuousAngleNum = 0;
    }

    private void checkBestImage(YTFaceTracker.TrackedFace trackedFace, YTImageData yTImageData) {
        float[] calcEyeScore = YtSDKKitCommon.ProcessHelper.calcEyeScore(trackedFace.faceShape);
        float calcMouthScore = YtSDKKitCommon.ProcessHelper.calcMouthScore(trackedFace.faceShape);
        int i3 = 0;
        float f16 = calcEyeScore[0] + calcEyeScore[1];
        float f17 = 0.0f;
        while (true) {
            float[] fArr = trackedFace.faceVisible;
            if (i3 >= fArr.length) {
                break;
            }
            f17 += fArr[i3];
            i3++;
        }
        if (this.stableFaceCount < this.stableCountNum) {
            YtLogger.e(TAG, "stable count " + this.stableFaceCount, null);
            return;
        }
        float f18 = this.intersectRatio;
        if (f18 >= this.maxInRectRatio - 0.05d) {
            this.maxInRectRatio = f18;
            if (this.needCheckShelter) {
                if (this.maxShelterScore <= f17) {
                    this.maxShelterScore = f17;
                } else {
                    YtLogger.d(TAG, "test1 shelter score " + f17 + " inRectThreshold " + this.intersectRatio + " eye " + f16 + " mouth " + calcMouthScore);
                    return;
                }
            }
            String str = TAG;
            YtLogger.d(str, "test2 shelter score " + f17 + " inRectThreshold " + this.intersectRatio + " eye " + f16 + " mouth " + calcMouthScore);
            if (f16 >= this.maxEyeScore - 0.05d && calcMouthScore <= Math.max(this.minMouthScore, 15.0f) && Math.abs(trackedFace.yaw) <= this.secondaryYawThreshold && Math.abs(trackedFace.pitch) <= this.secondaryPitchThreshold && Math.abs(trackedFace.roll) <= this.secondaryRollThreshold) {
                YtLogger.d(str, "best shelter score " + f17 + " inRectThreshold " + this.intersectRatio);
                this.maxEyeScore = f16;
                this.minMouthScore = calcMouthScore;
                this.stateData.put("best_image", yTImageData);
                this.stateData.put("best_shape", trackedFace.faceShape);
                this.stateData.put("best_face_status", trackedFace);
            }
            if (f16 < this.minEyeScore) {
                this.minEyeScore = f16;
                this.stateData.put("closeeye_image", yTImageData);
                this.stateData.put("closeeye_shape", trackedFace.faceShape);
                this.stateData.put("closeeye_face_status", trackedFace);
            }
            if (calcMouthScore > this.maxMouthScore) {
                this.maxMouthScore = calcMouthScore;
                this.stateData.put("openmouth_image", yTImageData);
                this.stateData.put("openmouth_shape", trackedFace.faceShape);
                this.stateData.put("openmouth_face_status", trackedFace);
                return;
            }
            return;
        }
        YtLogger.d(TAG, "test3 shelter score " + f17 + " inRectThreshold " + this.intersectRatio + " (" + this.maxInRectRatio + ") eye " + f16 + " mouth " + calcMouthScore);
    }

    private void detectScreenShaking(Rect rect) {
        Rect rect2 = this.previousFaceRect;
        if (rect2 == null) {
            this.previousFaceRect = rect;
            this.stableFaceCount = 0;
            return;
        }
        Rect intersectionRect = SilentLivenessHelper.getIntersectionRect(rect, rect2);
        if (rect.height() != 0 && rect.width() != 0) {
            float abs = Math.abs(((intersectionRect.width() * intersectionRect.height()) / rect.height()) / rect.width());
            if (abs < this.stableRoiThreshold) {
                YtLogger.o(TAG, "face shaking:" + abs);
                this.extraTips = StringCode.FL_ACT_SCREEN_SHAKING;
                this.stableFaceCount = 0;
            } else {
                this.extraTips = "";
                this.stableFaceCount++;
            }
        }
        this.previousFaceRect = rect;
    }

    private int getFacePreviewAdvise(Rect rect, Rect rect2, YTFaceTracker.TrackedFace trackedFace) {
        boolean z16;
        int i3;
        int i16;
        int intValue;
        boolean z17 = false;
        Rect rect3 = new Rect(0, 0, 0, 0);
        String str = TAG;
        YtLogger.d(str, "camera" + this.previewWidth + HippyTKDListViewAdapter.X + this.previewHeight + " ratio " + this.maskWidthRatio + HippyTKDListViewAdapter.X + this.maskHeightRatio);
        YtLogger.d(str, "detectrect :" + rect.left + " " + rect.top + " " + rect.right + " " + rect.bottom);
        float f16 = (float) rect2.left;
        float f17 = this.maskWidthRatio;
        rect3.left = (int) (f16 * f17);
        rect3.right = (int) (((float) rect2.right) * f17);
        float f18 = (float) rect2.top;
        float f19 = this.maskHeightRatio;
        rect3.top = (int) (f18 * f19);
        rect3.bottom = (int) (((float) rect2.bottom) * f19);
        this.invalidPointCount = 0;
        int i17 = 0;
        while (true) {
            float[] fArr = trackedFace.faceShape;
            if (i17 >= fArr.length / 2) {
                break;
            }
            int i18 = i17 * 2;
            float f26 = fArr[i18];
            if (f26 <= this.previewWidth && f26 >= 0.0f) {
                float f27 = fArr[i18 + 1];
                if (f27 >= 0.0f && f27 <= this.previewHeight) {
                    i17++;
                }
            }
            this.invalidPointCount++;
            i17++;
        }
        Rect intersectionRect = SilentLivenessHelper.getIntersectionRect(rect, rect3);
        this.intersectRatio = Math.abs(((intersectionRect.width() * intersectionRect.height()) / rect3.width()) / rect3.height());
        String str2 = TAG;
        YtLogger.d(str2, "faceInMask : " + rect3.left + " " + rect3.top + " " + rect3.right + " " + rect3.bottom + " in rect ratio" + this.intersectRatio);
        float abs = Math.abs(((float) (rect2.right - rect2.left)) / (((float) this.previewWidth) * 1.0f));
        YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
        int i19 = 4;
        if (stateByName != null && stateByName.containsKey("current_action_type") && ((intValue = ((Integer) stateByName.getStateDataBy("current_action_type")).intValue()) == 3 || intValue == 4)) {
            z16 = false;
        } else {
            z16 = true;
        }
        YtLogger.d(str2, "face area ratio:" + abs);
        if (this.invalidPointCount >= 3) {
            YtLogger.w(str2, "face incomplete invalid point count:" + this.invalidPointCount, null);
            i3 = 8;
        } else if (abs > this.bigfaceThreshold) {
            YtLogger.w(str2, "face too big:" + abs, null);
            if (abs <= this.bigfaceThreshold + this.bigFaceThresholdBuffer) {
                i16 = 3;
                i3 = i16;
                z17 = true;
            } else {
                i3 = 3;
            }
        } else if (this.intersectRatio < this.inRectThreshold) {
            YtLogger.w(str2, "face not in rect ratio:" + this.intersectRatio, null);
            i3 = 4;
        } else if (abs < this.smallfaceThreshold) {
            YtLogger.w(str2, "face too small:" + abs, null);
            if (abs >= this.smallfaceThreshold - this.smallFaceThresholdBuffer) {
                i16 = 2;
                i3 = i16;
                z17 = true;
            } else {
                i3 = 2;
            }
        } else if (z16 && (Math.abs(trackedFace.pitch) > this.pitchThreshold || Math.abs(trackedFace.yaw) > this.yawThreshold || Math.abs(trackedFace.roll) > this.rollThreshold)) {
            YtLogger.w(str2, "face pose not right (" + trackedFace.pitch + "," + trackedFace.yaw + "," + trackedFace.roll + ")", null);
            if (Math.abs(trackedFace.pitch) <= this.pitchThreshold + this.poseThresholdBuffer && Math.abs(trackedFace.yaw) <= this.yawThreshold + this.poseThresholdBuffer && Math.abs(trackedFace.roll) <= this.rollThreshold + this.poseThresholdBuffer) {
                i16 = 5;
                i3 = i16;
                z17 = true;
            } else {
                i3 = 5;
            }
        } else {
            if (this.needCheckEyeOpen && !isActionStage()) {
                float preCheckCloseEyeScore = YtSDKKitCommon.ProcessHelper.preCheckCloseEyeScore(trackedFace.faceShape);
                YtLogger.d(str2, "eye score:" + preCheckCloseEyeScore + " cnt:" + this.continueCloseEyeCount);
                if (preCheckCloseEyeScore < this.eyeOpenThreshold) {
                    this.continueCloseEyeCount++;
                    int i26 = this.detectAvailableCount - 1;
                    this.detectAvailableCount = i26;
                    if (i26 < 0) {
                        this.detectAvailableCount = 0;
                    }
                } else {
                    this.continueCloseEyeCount = 0;
                }
                if (YtFSM.getInstance().getWorkMode() != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE) {
                    i19 = 10;
                }
                if (this.continueCloseEyeCount >= i19) {
                    this.continueCloseEyeCount = 0;
                    i3 = 6;
                }
            }
            i3 = 0;
        }
        this.currentAdviseTip = i3;
        if (z17) {
            return 9;
        }
        return i3;
    }

    private int getShelterJudge(YTFaceTracker.TrackedFace[] trackedFaceArr) {
        int shelterJudge = SilentLivenessHelper.shelterJudge(trackedFaceArr[0].faceVisible);
        if (this.currentShelterJudge != shelterJudge) {
            this.continueShelterJudgeCount = 0;
            this.currentShelterJudge = shelterJudge;
        } else {
            this.continueShelterJudgeCount++;
        }
        if (this.frameNum >= 7 && this.continueShelterJudgeCount < 7) {
            return this.previousShelterJudge;
        }
        this.previousShelterJudge = this.currentShelterJudge;
        return shelterJudge;
    }

    private void initTrackerInstance() {
        try {
            if (!this.isLoadResourceOnline) {
                YtLogger.i(TAG, "init from asset");
                this.ytFaceTracker = new YTFaceTracker(YtFSM.getInstance().getContext().currentAppContext.getAssets(), "models/face-tracker-v003", this.configIniName);
            } else {
                YtLogger.i(TAG, "init from filesystem use local path : " + this.resourceDownloadPath);
                this.ytFaceTracker = new YTFaceTracker(this.resourceDownloadPath, this.configIniName);
            }
            YTFaceTracker.Param param = this.ytFaceTracker.getParam();
            String str = TAG;
            YtLogger.i(str, "big face mode" + this.needBigFaceMode);
            param.biggerFaceMode = this.needBigFaceMode ? 1 : 0;
            param.minFaceSize = Math.max(Math.min(this.previewWidth, this.previewHeight) / 5, 40);
            param.detInterval = this.detectIntervalCount;
            this.ytFaceTracker.setParam(param);
            YtLogger.o(str, "Detect version:" + YTFaceTracker.getVersion());
        } catch (Exception e16) {
            sendFSMEvent("failed", ErrorCode.YT_SDK_FACETRACE_INIT_FAILED, CommonUtils.makeMessageJson(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "Init YTFaceTrack SDK failed with "));
            e16.printStackTrace();
        }
    }

    private boolean isActionStage() {
        if (YtFSM.getInstance().getWorkMode() != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE && YtFSM.getInstance().getWorkMode() != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
            return false;
        }
        return true;
    }

    private void sendFSMEvent(HashMap<String, Object> hashMap) {
        YtFSM.getInstance().sendFSMEvent(hashMap);
    }

    private void sendFaceStatusUITips(int i3, int i16) {
        int i17;
        HashMap<String, Object> hashMap = new HashMap<>();
        if ((i3 != 0 && i3 != 9) || i16 != 0) {
            hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_NOTPASS);
            this.detectAvailableCount = 0;
        } else {
            this.detectAvailableCount++;
        }
        if (i3 == this.prevAdvise && i16 == this.prevJudge) {
            this.sameFaceTipCount++;
        } else {
            this.sameFaceTipCount = 0;
        }
        if (this.tipFilterFlag && this.sameFaceTipCount > 3 && this.currentAdviseTip == i3) {
            return;
        }
        this.prevAdvise = i3;
        this.prevJudge = i16;
        YtLogger.d(TAG, " tips:" + SilentLivenessHelper.convertAdvise(this.currentAdviseTip));
        int i18 = this.currentAdviseTip;
        if (i18 != 0 && i18 != 9) {
            hashMap.put(StateEvent.Name.UI_TIPS, SilentLivenessHelper.convertAdvise(i18));
        } else if (i16 == 1) {
            hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_LEFT_FACE);
        } else if (i16 == 2) {
            hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_CHIN);
        } else if (i16 == 3) {
            hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_MOUTH);
        } else if (i16 == 4) {
            hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_RIGHT_FACE);
        } else if (i16 == 5) {
            hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_NOSE);
        } else if (i16 == 6) {
            hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_RIGHT_EYE);
        } else if (i16 == 7) {
            hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_NO_LEFT_EYE);
        } else if (i16 == 0 && (i17 = this.sameFaceTipCount) > 2 && i17 < 5) {
            hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_POSE_KEEP);
            hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_PASS);
        }
        String str = this.extraTips;
        if (str != "") {
            hashMap.put(StateEvent.Name.UI_EXTRA_TIPS, str);
        }
        sendFSMEvent(hashMap);
    }

    private void sendUITipEvent(YTFaceTracker.TrackedFace[] trackedFaceArr) {
        int i3;
        int i16 = 1;
        int i17 = -1;
        if (trackedFaceArr == null) {
            this.currentAdviseTip = 1;
        } else if (trackedFaceArr.length > 1) {
            if (this.needCheckMultiFaces) {
                this.detectAvailableCount = 0;
                this.prevAdvise = 7;
                i3 = 7;
            } else {
                i3 = -1;
            }
            this.currentAdviseTip = 7;
            i16 = i3;
        } else {
            YTFaceTracker.TrackedFace trackedFace = trackedFaceArr[0];
            if (!this.faceAngleCorrectionDone) {
                if (SilentLivenessHelper.faceAngleForceCheck(trackedFace, this.secondaryYawThreshold, this.secondaryPitchThreshold, this.secondaryRollThreshold)) {
                    int i18 = this.continuousAngleNum + 1;
                    this.continuousAngleNum = i18;
                    if (i18 >= this.continuousAngleNumThreshold) {
                        this.faceAngleCorrectionDone = true;
                    }
                } else {
                    this.continuousAngleNum = 0;
                }
            }
            if (!this.faceAngleCorrectionDone) {
                YtLogger.d(TAG, "correction face failure");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_NOTPASS);
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_POSE_INCORRECT);
                sendFSMEvent(hashMap);
                return;
            }
            Rect faceRect = SilentLivenessHelper.getFaceRect(trackedFace);
            detectScreenShaking(faceRect);
            i16 = getFacePreviewAdvise(YtSDKKitFramework.getInstance().getDetectRect(), faceRect, trackedFace);
            i17 = getShelterJudge(trackedFaceArr);
            YtLogger.i(TAG, "advise " + i16 + "|shelter " + i17);
        }
        sendFaceStatusUITips(i16, i17);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.enter();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        YtLogger.o(TAG, makeStateInfo(TAG, 1));
        this.stateData.put("detect_instance", this.ytFaceTracker);
        if (!this.needCloseTimeout) {
            if (!this.needManualTrigger) {
                this.countdowner.start();
            } else {
                this.predetectCountdowner.start();
            }
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void exit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.exit();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) ytFrameworkFireEventType, obj);
            return;
        }
        super.handleEvent(ytFrameworkFireEventType, obj);
        if (this.needManualTrigger) {
            if (ytFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_BEGIN_LIVENESS) {
                this.detectAvailableCount = 0;
                this.triggerLiveBeginEventFlag = true;
                if (!this.needCloseTimeout) {
                    resetTimeout();
                    return;
                }
                return;
            }
            if (ytFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS) {
                this.detectAvailableCount = 0;
                this.triggerLiveBeginEventFlag = false;
                if (!this.needCloseTimeout) {
                    this.countdowner.cancel();
                    this.predetectCountdowner.reset();
                }
            }
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void handleStateAction(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, obj);
            return;
        }
        super.handleStateAction(str, obj);
        if (!this.needCloseTimeout) {
            if (str.equals("reset_timeout")) {
                YtLogger.d(TAG, "predetect status:" + this.predetectCountdowner.isRunning());
                if (!this.predetectCountdowner.isRunning()) {
                    resetTimeout();
                    return;
                }
                return;
            }
            if (str.equals("reset_manual_trigger")) {
                this.triggerLiveBeginEventFlag = false;
                this.countdowner.cancel();
            }
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
        Camera.Size previewSize = YtFSM.getInstance().getContext().currentCamera.getParameters().getPreviewSize();
        int i3 = YtFSM.getInstance().getContext().currentRotateState;
        this.cameraRotateState = i3;
        if (i3 >= 5) {
            this.previewWidth = previewSize.height;
            this.previewHeight = previewSize.width;
        } else {
            this.previewWidth = previewSize.width;
            this.previewHeight = previewSize.height;
        }
        SilentLivenessHelper.setPreviewWh(this.previewWidth, this.previewHeight);
        this.maskWidthRatio = YtSDKKitFramework.getInstance().getPreviewRect().width() / this.previewWidth;
        this.maskHeightRatio = YtSDKKitFramework.getInstance().getPreviewRect().height() / this.previewHeight;
        YtLogger.o(TAG, "Camera size:" + this.previewWidth + "*" + this.previewHeight + "|mask size:" + this.maskWidthRatio + "*" + this.maskHeightRatio);
        initTrackerInstance();
        reset();
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void moveToNextState() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.moveToNextState();
        boolean z16 = this.needManualTrigger;
        if (z16 && ((this.needCheckPose && (i16 = this.prevAdvise) != 0 && i16 != 9) || ((this.needCheckMultiFaces && this.prevAdvise == 7) || (i3 = this.prevAdvise) == 8 || i3 == 1))) {
            int i17 = this.continueNoValidFaceCount + 1;
            this.continueNoValidFaceCount = i17;
            if (i17 > this.continueNovalidFaceCountThreshold) {
                String makeMessageJson = CommonUtils.makeMessageJson(4194304, SilentLivenessHelper.convertAdvise(this.prevAdvise), "action check failed");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                hashMap.put(StateEvent.Name.PROCESS_RESULT, "failed");
                hashMap.put("error_code", 4194304);
                hashMap.put(StateEvent.Name.ERROR_REASON_CODE, 4194304);
                hashMap.put("message", makeMessageJson);
                YtFSM.getInstance().sendFSMEvent(hashMap);
                YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                return;
            }
        } else {
            this.continueNoValidFaceCount = 0;
        }
        if (!this.needCloseTimeout && z16 && this.predetectCountdowner.checkTimeout()) {
            YtLogger.d(TAG, "predectcountdowner.checkTimeout(): " + this.predetectCountdowner.checkTimeout());
            this.predetectCountdowner.cancel();
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_VERIFY_TIMEOUT, "yt_verify_step_timeout");
            YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
            return;
        }
        if (!this.needCloseTimeout && this.countdowner.checkTimeout()) {
            this.countdowner.cancel();
            YtLogger.d(TAG, "liveness timeout");
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_VERIFY_TIMEOUT, "yt_verify_step_timeout");
            YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
            return;
        }
        if (this.needManualTrigger || this.isFirstStablePass || this.detectAvailableCount > this.stableCountNum) {
            this.isFirstStablePass = true;
            if (!this.needCloseTimeout) {
                this.predetectCountdowner.cancel();
            }
            int ordinal = YtFSM.getInstance().getWorkMode().ordinal();
            if (ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5) {
                YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.QUALITY_STATE));
            }
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.prevAdvise = -1;
        this.detectAvailableCount = 0;
        this.continueCloseEyeCount = 0;
        this.frameNum = 0;
        this.triggerLiveBeginEventFlag = false;
        this.sameFaceTipCount = 0;
        this.maxEyeScore = -1.0E10f;
        this.minMouthScore = 1.0E10f;
        this.minEyeScore = 1.0E10f;
        this.maxMouthScore = -1.0E10f;
        this.maxShelterScore = -1.0E10f;
        this.isFirstStablePass = false;
        this.continueNoValidFaceCount = 0;
        this.invalidPointCount = 0;
        this.unstableCount = 0;
        this.maxInRectRatio = -1.0E10f;
        this.stableFaceCount = 0;
        this.currentShelterJudge = -1;
        this.previousFaceRect = null;
        this.faceAngleCorrectionDone = false;
        this.continuousAngleNum = 0;
        if (!this.needCloseTimeout) {
            this.countdowner.cancel();
            this.predetectCountdowner.cancel();
            if (!this.needManualTrigger) {
                this.countdowner.reset();
            } else {
                this.predetectCountdowner.reset();
            }
        }
        super.reset();
        this.stateData.put("detect_instance", this.ytFaceTracker);
    }

    public void resetTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.countdowner.reset();
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
        YTFaceTracker yTFaceTracker = this.ytFaceTracker;
        if (yTFaceTracker != null) {
            yTFaceTracker.destroy();
        }
        this.ytFaceTracker = null;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void update(YTImageData yTImageData, long j3) {
        YTFaceTracker.TrackedFace[] trackedFaceArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, yTImageData, Long.valueOf(j3));
            return;
        }
        super.update(yTImageData, j3);
        if (this.needCloseTimeout && this.isPause.get()) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SilentLivenessState.this);
                    } else {
                        put(StateEvent.Name.FSM_STATE_PAUSE, YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE);
                        put(StateEvent.Name.UI_TIPS, StringCode.MSG_FSM_PAUSE);
                    }
                }
            });
            try {
                LockMethodProxy.sleep(30L);
                return;
            } catch (InterruptedException e16) {
                YtLogger.e(TAG, "Thread sleep error", e16);
                return;
            }
        }
        YTFaceTracker.TrackedFace[] trackedFaceArr2 = null;
        if (yTImageData != null && yTImageData.imgData != null) {
            if (!this.needCloseTimeout && (this.countdowner.checkTimeout() || (this.needManualTrigger && this.predetectCountdowner.checkTimeout()))) {
                moveToNextState();
                return;
            }
            this.frameNum++;
            CommonUtils.benchMarkBegin("detect");
            try {
                trackedFaceArr = this.ytFaceTracker.track(0, yTImageData.imgData, yTImageData.width, yTImageData.height, this.cameraRotateState);
            } catch (Exception e17) {
                YtLogger.e(TAG, "track error ", e17);
                e17.printStackTrace();
                trackedFaceArr = null;
            }
            CommonUtils.benchMarkEnd("detect");
            String str = TAG;
            YtLogger.d(str, CommonUtils.getBenchMarkTime("detect"));
            if (trackedFaceArr != null && trackedFaceArr.length != 0) {
                YtLogger.i(str, "face status count " + trackedFaceArr.length);
                trackedFaceArr2 = SilentLivenessHelper.convert130To90(trackedFaceArr);
                SilentLivenessHelper.optimizationFace(trackedFaceArr2);
            }
            if (trackedFaceArr2 != null && trackedFaceArr2.length > 0) {
                YTFaceTracker.TrackedFace trackedFace = trackedFaceArr2[0];
                trackedFace.faceRect = SilentLivenessHelper.getFaceRect(trackedFace);
            }
            sendUITipEvent(trackedFaceArr2);
            this.stateData.put("pose_state", Integer.valueOf(this.prevAdvise));
            this.stateData.put("shelter_state", Integer.valueOf(this.prevJudge));
            this.stateData.put("face_status", trackedFaceArr2);
            this.stateData.put("continuous_detect_count", Integer.valueOf(this.detectAvailableCount));
            this.stateData.put("last_face_status", trackedFaceArr2);
            this.stateData.put("last_frame", yTImageData);
            YtLogger.o(str, SilentLivenessHelper.trackedFacesToJson(trackedFaceArr2, this.prevJudge, this.prevAdvise));
            int i3 = this.prevAdvise;
            if ((i3 == 0 || i3 == 9) && trackedFaceArr2 != null && trackedFaceArr2.length > 0) {
                checkBestImage(trackedFaceArr2[0], yTImageData);
            }
            if (this.continuousAngleNum >= this.continuousAngleNumThreshold && this.stateData.get("best_image") != null) {
                boolean z16 = this.needManualTrigger;
                if (!z16 || (z16 && this.triggerLiveBeginEventFlag)) {
                    moveToNextState();
                    return;
                }
                return;
            }
            return;
        }
        YtLogger.e(TAG, "image data is null", null);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void updateSDKSetting(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
            return;
        }
        try {
            if (jSONObject.has("check_eye_open")) {
                this.needCheckEyeOpen = jSONObject.getBoolean("check_eye_open");
            }
            if (jSONObject.has("open_eye_threshold")) {
                this.eyeOpenThreshold = (float) jSONObject.getDouble("open_eye_threshold");
            }
            if (jSONObject.has("pitch_threshold")) {
                this.pitchThreshold = jSONObject.getInt("pitch_threshold");
            }
            if (jSONObject.has("yaw_threshold")) {
                this.yawThreshold = jSONObject.getInt("yaw_threshold");
            }
            if (jSONObject.has("roll_threshold")) {
                this.rollThreshold = jSONObject.getInt("roll_threshold");
            }
            if (jSONObject.has("smallface_ratio_threshold")) {
                this.smallfaceThreshold = (float) jSONObject.getDouble("smallface_ratio_threshold");
            }
            if (jSONObject.has("bigface_ratio_threshold")) {
                this.bigfaceThreshold = (float) jSONObject.getDouble("bigface_ratio_threshold");
            }
            if (jSONObject.has("blur_detect_threshold")) {
                this.blurDetectThreshold = (float) jSONObject.getDouble("blur_detect_threshold");
            }
            if (jSONObject.has("need_big_face_mode")) {
                this.needBigFaceMode = jSONObject.getBoolean("need_big_face_mode");
            }
            if (jSONObject.has("detect_interval")) {
                this.detectIntervalCount = jSONObject.getInt("detect_interval");
            }
            if (jSONObject.has("stable_frame_num")) {
                this.stableCountNum = jSONObject.getInt("stable_frame_num");
            }
            if (jSONObject.has("net_request_timeout_ms")) {
                YtSDKKitFramework.getInstance().setNetworkRequestTimeoutMS(jSONObject.getInt("net_request_timeout_ms"));
            }
            if (jSONObject.has("force_pose_check")) {
                this.needCheckPose = jSONObject.getBoolean("force_pose_check");
            }
            if (jSONObject.has("novalid_face_count")) {
                this.continueNovalidFaceCountThreshold = jSONObject.getInt("novalid_face_count");
            }
            if (jSONObject.has("in_rect_ratio_threshold")) {
                this.inRectThreshold = (float) jSONObject.getDouble("in_rect_ratio_threshold");
            }
            if (jSONObject.has("need_check_shelter")) {
                this.needCheckShelter = jSONObject.getBoolean("need_check_shelter");
            }
            if (jSONObject.has("stable_roi_threshold")) {
                this.stableRoiThreshold = (float) jSONObject.getDouble("stable_roi_threshold");
            }
            if (jSONObject.has("need_close_timeout")) {
                this.needCloseTimeout = jSONObject.getBoolean("need_close_timeout");
            }
            if (jSONObject.has("resource_online")) {
                this.isLoadResourceOnline = jSONObject.getBoolean("resource_online");
            }
            if (jSONObject.has("resource_download_path")) {
                this.resourceDownloadPath = jSONObject.getString("resource_download_path");
            }
            if (jSONObject.has("timeout_countdown_ms")) {
                this.countdowner.init(Math.max(0, Math.min(30000, jSONObject.getInt("timeout_countdown_ms"))), true);
            }
            if (jSONObject.has("predetect_countdown_ms")) {
                this.predetectCountdowner.init(jSONObject.getInt("predetect_countdown_ms"), true);
            } else {
                this.predetectCountdowner.init(s.G, true);
            }
            if (jSONObject.has("same_tips_filter")) {
                this.tipFilterFlag = jSONObject.getBoolean("same_tips_filter");
            }
            if (jSONObject.has("manual_trigger")) {
                this.needManualTrigger = jSONObject.getBoolean("manual_trigger");
            }
            if (jSONObject.has("need_close_timeout")) {
                this.needCloseTimeout = jSONObject.getBoolean("need_close_timeout");
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
            if (jSONObject.has("continuous_angle_num_threshold")) {
                this.continuousAngleNumThreshold = jSONObject.getInt("continuous_angle_num_threshold");
            }
            if (jSONObject.has("need_local_face_best_image") && jSONObject.getBoolean("need_local_face_best_image")) {
                SilentLivenessHelper.SHELTER_NOSE_THRESHOLD = 0.3f;
                SilentLivenessHelper.SHELTER_MOUTH_THRESHOLD = 0.5f;
                SilentLivenessHelper.SHELTER_LEFT_FACE_THRESHOLD = 0.3f;
                SilentLivenessHelper.SHELTER_RIGHT_FACE_THRESHOLD = 0.3f;
                SilentLivenessHelper.SHELTER_CHIN_THRESHOLD = 0.3f;
            }
            this.configIniName = jSONObject.optString("model_config_ini_name", "yt_model_config.ini");
            this.needCheckMultiFaces = jSONObject.optBoolean("need_check_multiface", false);
            this.bigFaceThresholdBuffer = (float) jSONObject.optDouble("bigface_ratio_buffer", 0.05000000074505806d);
            this.smallFaceThresholdBuffer = (float) jSONObject.optDouble("smallface_ratio_buffer", 0.05000000074505806d);
            this.poseThresholdBuffer = (float) jSONObject.optDouble("pose_ratio_buffer", 0.05000000074505806d);
            this.stableRoiThreshold = (float) jSONObject.optDouble("stable_roi_threshold", 0.8999999761581421d);
        } catch (JSONException e16) {
            YtLogger.e(TAG, "Failed to parse json:", e16);
        }
    }

    private void sendFSMEvent(String str, int i3, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(StateEvent.Name.PROCESS_RESULT, str);
        hashMap.put("error_code", Integer.valueOf(i3));
        hashMap.put("message", str2);
        YtFSM.getInstance().sendFSMEvent(hashMap);
    }

    private void sendFSMEvent(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(StateEvent.Name.UI_ACTION, str);
        hashMap.put(StateEvent.Name.UI_TIPS, str2);
        YtFSM.getInstance().sendFSMEvent(hashMap);
    }
}
