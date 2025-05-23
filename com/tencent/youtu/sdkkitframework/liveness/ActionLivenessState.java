package com.tencent.youtu.sdkkitframework.liveness;

import android.os.Environment;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.OperateInfoManager;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YTImageData;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtSdkConfig;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.data.ActionData;
import com.tencent.youtu.ytposedetect.data.PoseDetectData;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ActionLivenessState extends YtFSMBaseState {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ActionLivenessState";
    private YTActRefData actReflectData;
    public int actReflectUXMode;
    private float actionCloseMouthThreshold;
    private int actionContinuousFailedCount;
    private int actionCurrentIndex;
    private String[] actionDataParsed;
    private YTPoseDetectInterface.PoseDetectOnFrame actionFrameHandler;
    private int actionFrameNum;
    private JSONArray actionFramesJsonArray;
    private int actionLiveType;
    private int actionVideoShortenStrategy;
    private String anchorWidths;
    private float closeEyeLeftThreshold;
    private float closeEyeRightThreshold;
    private float closeMouthThreshold;
    private int codecSettingBitRate;
    private int codecSettingFrameRate;
    private int codecSettingiFrameInterval;
    private int continuousDetectCount;
    private int continuousQualityNumThreshold;
    private String controlConfig;
    private int correctionAngleActionType1;
    private int correctionAngleActionType2;
    private int currentRotateState;
    private String extraTips;
    private YTFaceTracker.TrackedFace[] faceStatus;
    private String innerMp4Path;
    private boolean isActionFinished;
    public boolean isOutActionLiveness;
    private boolean isReportEncodeVideoError;
    private boolean isSetColorData;
    private int lastActionFrameNum;
    private int lastActionLiveType;
    private String legitimatePoseVersion;
    private YTFaceTracker.Param mOriginParam;
    private int needBestOriginalSize;
    private boolean needCheckMultiFaces;
    private boolean needCloseTimeout;
    private boolean needFaceQuality;
    private boolean needLocalConfig;
    private boolean needManualTrigger;
    private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
    private int orientation;
    private int poseReadyCount;
    private int poseState;
    private float secondaryPitchThreshold;
    private float secondaryRollThreshold;
    private float secondaryYawThreshold;
    private int securityLevel;
    private int shelterState;
    private int stableCountNum;
    private String tips;
    private YTFaceTracker tracker;
    private String uiAction;
    private YtVideoEncoderHelper videoEncoder;

    public ActionLivenessState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.legitimatePoseVersion = "3.7.5";
        this.continuousDetectCount = 0;
        this.poseState = -1;
        this.shelterState = 0;
        this.actionLiveType = 1;
        this.actionContinuousFailedCount = 0;
        this.isActionFinished = false;
        this.innerMp4Path = Environment.getExternalStorageDirectory().getPath() + "/temp.mp4";
        this.securityLevel = 1;
        this.needLocalConfig = false;
        this.codecSettingBitRate = 2097152;
        this.codecSettingFrameRate = 30;
        this.codecSettingiFrameInterval = 1;
        this.extraTips = "";
        this.tips = "";
        this.uiAction = StateEvent.ActionValue.STAGE_PASS;
        this.needManualTrigger = false;
        this.poseReadyCount = 0;
        this.stableCountNum = 5;
        this.controlConfig = "";
        this.actionFrameNum = 20;
        this.actReflectUXMode = 0;
        this.needCheckMultiFaces = false;
        this.needCloseTimeout = false;
        this.secondaryYawThreshold = 50.0f;
        this.secondaryPitchThreshold = 50.0f;
        this.secondaryRollThreshold = 50.0f;
        this.correctionAngleActionType1 = -1;
        this.correctionAngleActionType2 = -1;
        this.orientation = 0;
        this.actionCloseMouthThreshold = 0.38f;
        this.needFaceQuality = false;
        this.continuousQualityNumThreshold = 10;
        this.closeEyeLeftThreshold = 0.25f;
        this.closeEyeRightThreshold = 0.25f;
        this.closeMouthThreshold = 0.38f;
        this.isSetColorData = false;
    }

    public static /* synthetic */ int access$1208(ActionLivenessState actionLivenessState) {
        int i3 = actionLivenessState.actionContinuousFailedCount;
        actionLivenessState.actionContinuousFailedCount = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean changeToNextAction(String[] strArr, int i3) {
        if (strArr.length == 0) {
            return false;
        }
        this.actionCurrentIndex = i3;
        if (i3 >= strArr.length) {
            return false;
        }
        int parseInt = Integer.parseInt(strArr[i3]);
        YtSDKStats.getInstance().reportEvent(parseInt);
        if (parseInt != 0 && parseInt != 1) {
            if (parseInt != 2) {
                if (parseInt != 3) {
                    if (parseInt != 4) {
                        if (parseInt == 5) {
                            this.actionLiveType = 5;
                        }
                    } else {
                        this.actionLiveType = 4;
                    }
                } else {
                    this.actionLiveType = 3;
                }
            } else {
                this.actionLiveType = 2;
            }
        } else {
            this.actionLiveType = 1;
        }
        this.stateData.put("current_action_type", Integer.valueOf(parseInt));
        YtLogger.o(TAG, "action check rounds: " + this.actionCurrentIndex + "start check pose: " + this.actionLiveType);
        if (!this.needCloseTimeout) {
            YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
        }
        this.poseReadyCount = 0;
        return true;
    }

    private void clearData() {
        this.actionContinuousFailedCount = 0;
        this.isActionFinished = false;
        this.poseReadyCount = 0;
        this.poseState = -1;
        this.isOutActionLiveness = false;
        this.isSetColorData = false;
        String[] strArr = this.actionDataParsed;
        this.actionCurrentIndex = 0;
        changeToNextAction(strArr, 0);
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        try {
            YtVideoEncoderHelper ytVideoEncoderHelper = this.videoEncoder;
            if (ytVideoEncoderHelper != null) {
                ytVideoEncoderHelper.reset();
            }
        } catch (Exception e16) {
            YtLogger.e(TAG, "video error:", e16);
        }
        this.actionFrameHandler = new YTPoseDetectInterface.PoseDetectOnFrame() { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this);
                }
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
            public void onActionFrames(YTActRefImage[] yTActRefImageArr) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                    YtLogger.o(ActionLivenessState.TAG, "action video error,conservation video,frame count:" + yTActRefImageArr.length);
                    ActionLivenessState.this.videoEncoder.conservationVideo(yTActRefImageArr);
                    return;
                }
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) yTActRefImageArr);
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
            public void onCanReflect() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                CommonUtils.benchMarkBegin("make_pack_use_time_best_img");
                ActionLivenessState.this.actReflectData = YTPoseDetectInterface.getActReflectData();
                if (ActionLivenessState.this.actReflectData.best != null && ActionLivenessState.this.actReflectData.best.image.length != 0) {
                    OperateInfoManager.getInstance().setPackUseTime(CommonUtils.benchMarkEnd("make_pack_use_time_best_img"));
                    return;
                }
                YtSDKStats.getInstance().reportError(4194304, "pose detect error");
                YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.7.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                            return;
                        }
                        put(StateEvent.Name.PROCESS_RESULT, "failed");
                        put("error_code", 4194304);
                        put("message", CommonUtils.makeMessageJson(4194304, StringCode.MSG_INNER_ERROR, "pose detect error4194304"));
                    }
                });
                YTPoseDetectInterface.reset();
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
            public void onFailed(int i3, String str, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2);
                    return;
                }
                YtSDKStats.getInstance().reportInfo("pose state " + i3);
                YtLogger.d(ActionLivenessState.TAG, "YTPoseDetectInterface.poseDetect.onFailed: " + i3 + " s: " + str);
                ActionLivenessState.access$1208(ActionLivenessState.this);
                int unused = ActionLivenessState.this.actionContinuousFailedCount;
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
            public boolean onOneActionFrame(byte[] bArr, int i3, int i16, int i17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                    YtLogger.i(ActionLivenessState.TAG, "codec info: rotatedWith: " + i3 + "rotatedHeight: " + i16 + " bitrate: " + ActionLivenessState.this.codecSettingBitRate + " framerate" + ActionLivenessState.this.codecSettingFrameRate + " iframeinterval" + ActionLivenessState.this.codecSettingiFrameInterval);
                    if (!ActionLivenessState.this.videoEncoder.isVideoStarted() && !ActionLivenessState.this.videoEncoder.startActionVideo(i3, i16, ActionLivenessState.this.orientation)) {
                        return false;
                    }
                    return ActionLivenessState.this.videoEncoder.makeActionOneVideoData(bArr, i3, i16);
                }
                return ((Boolean) iPatchRedirector.redirect((short) 6, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
            public void onRecordingDone(int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                if (!ActionLivenessState.this.isActionFinished) {
                    YTPoseDetectInterface.reset();
                    return;
                }
                try {
                    if (ActionLivenessState.this.videoEncoder != null) {
                        ActionLivenessState.this.videoEncoder.stop();
                    }
                } catch (Exception e17) {
                    YtLogger.d(ActionLivenessState.TAG, "encode stop error! " + Log.getStackTraceString(e17));
                }
                if (ActionLivenessState.this.videoEncoder != null && ActionLivenessState.this.videoEncoder.actionVideoFrames != null) {
                    ActionLivenessState.this.stateData.put("frames", ActionLivenessState.this.videoEncoder.actionVideoFrames.toString());
                    YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(OperateInfoManager.getInstance().conservationVideoErrorData(ActionLivenessState.this.videoEncoder.getSupportCodecJSONStr(), 400104)) { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.7.3
                        static IPatchRedirector $redirector_;
                        public final /* synthetic */ String val$msg;

                        {
                            this.val$msg = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this, (Object) r5);
                            } else {
                                put(StateEvent.Name.CONSERVATION_VIDEO_MESSAGE, r5);
                            }
                        }
                    });
                    ActionLivenessState actionLivenessState = ActionLivenessState.this;
                    actionLivenessState.controlConfig = actionLivenessState.videoEncoder.config;
                    YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE)).updateDataBy("control_config", ActionLivenessState.this.controlConfig);
                } else {
                    ActionData actionData = YTPoseDetectJNIInterface.getActionData();
                    if (!actionData.isSuccess) {
                        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.7.4
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                    return;
                                }
                                put(StateEvent.Name.PROCESS_RESULT, "failed");
                                put("error_code", 400102);
                                put("message", CommonUtils.makeMessageJson(400102, StringCode.MSG_INNER_ERROR, "read video error:400102"));
                            }
                        });
                        return;
                    }
                    ActionLivenessState.this.stateData.put("frames", actionData);
                }
                ActionLivenessState.this.putBestImageAndMoveNextState(i3, i16);
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
            public void onSuccess(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ActionLivenessState.this.extraTips = "";
                    ActionLivenessState.this.tips = null;
                    if (i3 == 1) {
                        YtLogger.d(ActionLivenessState.TAG, "Detect pose with sequence " + ActionLivenessState.this.actionDataParsed.length);
                        if (YtFSM.getInstance().getContext().baseFunctionListener != null) {
                            YtFSM.getInstance().getContext().baseFunctionListener.detectActionDone(ActionLivenessState.this.actionLiveType);
                        }
                        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.7.1
                            static IPatchRedirector $redirector_;

                            {
                                int length;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                    return;
                                }
                                put(StateEvent.Name.ACTION_DETECT_DONE_TYPE, Integer.valueOf(ActionLivenessState.this.actionLiveType));
                                if (ActionLivenessState.this.actionDataParsed == null) {
                                    length = 0;
                                } else {
                                    length = ActionLivenessState.this.actionDataParsed.length - (ActionLivenessState.this.actionCurrentIndex + 1);
                                }
                                put(StateEvent.Name.ACTION_DETECT_DONE_LAST_COUNT, Integer.valueOf(length));
                            }
                        });
                        ActionLivenessState actionLivenessState = ActionLivenessState.this;
                        if (actionLivenessState.changeToNextAction(actionLivenessState.actionDataParsed, ActionLivenessState.this.actionCurrentIndex + 1)) {
                            YtLogger.i(ActionLivenessState.TAG, "start check pose: " + ActionLivenessState.this.actionLiveType);
                        } else {
                            YtLogger.i(ActionLivenessState.TAG, "action seq all done");
                            ActionLivenessState.this.isActionFinished = true;
                        }
                    } else if (i3 == -3) {
                        ActionLivenessState.this.tips = StringCode.FL_INCOMPLETE_FACE;
                        ActionLivenessState.this.uiAction = StateEvent.ActionValue.STAGE_NOTPASS;
                    } else if (i3 == -1026) {
                        ActionLivenessState.this.tips = StringCode.FL_POSE_KEEP;
                        ActionLivenessState.this.uiAction = StateEvent.ActionValue.STAGE_PASS;
                    } else if (i3 == -1025) {
                        ActionLivenessState actionLivenessState2 = ActionLivenessState.this;
                        actionLivenessState2.tips = SilentLivenessHelper.convertAdvise(actionLivenessState2.poseState);
                        ActionLivenessState.this.uiAction = StateEvent.ActionValue.STAGE_NOTPASS;
                    } else if (i3 == -1029) {
                        ActionLivenessState actionLivenessState3 = ActionLivenessState.this;
                        actionLivenessState3.tips = SilentLivenessHelper.convertBlock(actionLivenessState3.shelterState);
                        ActionLivenessState.this.uiAction = StateEvent.ActionValue.STAGE_NOTPASS;
                    } else if (i3 == -1030) {
                        ActionLivenessState.this.tips = StringCode.FL_POSE_INCORRECT;
                        ActionLivenessState.this.uiAction = StateEvent.ActionValue.STAGE_NOTPASS;
                    } else if (i3 == -1031) {
                        ActionLivenessState.this.tips = StringCode.FL_POSE_OPEN_EYE;
                        ActionLivenessState.this.uiAction = StateEvent.ActionValue.STAGE_NOTPASS;
                    } else if (i3 == -1032) {
                        ActionLivenessState.this.tips = StringCode.FL_CLOSE_MOUTH;
                        ActionLivenessState.this.uiAction = StateEvent.ActionValue.STAGE_NOTPASS;
                    } else if (i3 == -1033) {
                        ActionLivenessState.this.tips = StringCode.FL_ACT_SCREEN_SHAKING;
                        ActionLivenessState.this.uiAction = StateEvent.ActionValue.STAGE_NOTPASS;
                    } else if (i3 == 0) {
                        ActionLivenessState.this.uiAction = StateEvent.ActionValue.STAGE_PASS;
                    } else if (i3 == -5) {
                        YtLogger.w(ActionLivenessState.TAG, "Act failed " + i3, null);
                        ActionLivenessState.this.extraTips = StringCode.FL_ACT_SCREEN_SHAKING;
                    } else if (i3 != -1 && i3 != 0) {
                        YtLogger.w(ActionLivenessState.TAG, "Act failed " + i3, null);
                    }
                    YtSDKStats.getInstance().reportInfo("pose state " + i3);
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        };
        YTPoseDetectInterface.start(YtFSM.getInstance().getContext().currentAppContext, YtFSM.getInstance().getContext().currentRotateState, new YTPoseDetectInterface.PoseDetectResult() { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this);
                }
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult
            public void onFailed(int i3, String str, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2);
                }
            }

            @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    YtLogger.d(ActionLivenessState.TAG, "start success");
                }
            }
        });
    }

    private String getTipsByPoseType(int i3) {
        if (i3 == 1) {
            return StringCode.FL_ACT_BLINK;
        }
        if (i3 == 2) {
            return StringCode.FL_ACT_OPEN_MOUTH;
        }
        if (i3 == 4) {
            return StringCode.FL_ACT_SHAKE_HEAD;
        }
        if (i3 == 3) {
            return StringCode.FL_ACT_NOD_HEAD;
        }
        if (i3 == 5) {
            return StringCode.FL_POSE_KEEP;
        }
        if (i3 == 6) {
            return StringCode.FL_ACT_TURN_LEFT;
        }
        if (i3 == 7) {
            return StringCode.FL_ACT_TURN_RIGHT;
        }
        if (i3 == 8) {
            return StringCode.FL_ACT_CLOSER_FAR;
        }
        if (i3 == 9) {
            return StringCode.FL_ACT_FAR_CLOSER;
        }
        YtLogger.e(TAG, "Action liveness state getTipsByPoseType action error", null);
        return StringCode.FL_POSE_KEEP;
    }

    private boolean isMouthCLose(YTFaceTracker.TrackedFace trackedFace) {
        float[] fArr = trackedFace.faceShape;
        float abs = Math.abs(((fArr[129] + fArr[109]) / 2.0f) - ((fArr[119] + fArr[97]) / 2.0f)) / Math.abs(fArr[90] - fArr[102]);
        String str = TAG;
        YtLogger.o(str, "action nod head mouth not close!ret:" + abs + "|threshold=" + this.actionCloseMouthThreshold + ",action type:" + this.actionLiveType);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isMouthCLose  rat=");
        sb5.append(abs);
        sb5.append("|threshold=");
        sb5.append(this.actionCloseMouthThreshold);
        YtLogger.d(str, sb5.toString());
        if (abs < this.actionCloseMouthThreshold) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putBestImageAndMoveNextState(int i3, int i16) {
        if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
            this.stateData.put("act_reflect_data", this.actReflectData);
            this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE;
        } else {
            YTImageData yTImageData = new YTImageData(YTPoseDetectJNIInterface.getBestImage(), i3, i16);
            yTImageData.imgData = yTImageData.bgr2JPEG(100);
            this.stateData.put("best_frame", yTImageData);
            this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE;
        }
    }

    private void sendFSMEvent(HashMap<String, Object> hashMap) {
        YtFSM.getInstance().sendFSMEvent(hashMap);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.enter();
        try {
            YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
            this.continuousDetectCount = ((Integer) stateByName.getStateDataBy("continuous_detect_count")).intValue();
            this.faceStatus = (YTFaceTracker.TrackedFace[]) stateByName.getStateDataBy("face_status");
            this.poseState = ((Integer) stateByName.getStateDataBy("pose_state")).intValue();
            this.shelterState = ((Integer) stateByName.getStateDataBy("shelter_state")).intValue();
            YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.QUALITY_STATE));
            YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
            if (stateByName2 != null && !this.needLocalConfig) {
                String str = (String) stateByName2.getStateDataBy("action_data");
                YtLogger.d(TAG, "action data :" + str);
                String[] split = str.split(",");
                this.actionDataParsed = split;
                int length = split.length;
                int i3 = this.actionCurrentIndex;
                if (length > i3) {
                    int parseInt = Integer.parseInt(split[i3]);
                    switch (parseInt) {
                        case 0:
                        case 1:
                            this.actionLiveType = 1;
                            break;
                        case 2:
                            this.actionLiveType = 2;
                            break;
                        case 3:
                            this.actionLiveType = 3;
                            break;
                        case 4:
                            this.actionLiveType = 4;
                            break;
                        case 5:
                            this.actionLiveType = 5;
                            break;
                        case 6:
                            this.actionLiveType = 6;
                            break;
                        case 7:
                            this.actionLiveType = 7;
                            break;
                        case 8:
                            this.actionLiveType = 8;
                            break;
                        case 9:
                            this.actionLiveType = 9;
                            break;
                    }
                    this.stateData.put("current_action_type", Integer.valueOf(parseInt));
                }
            }
            if (this.actReflectUXMode == 1) {
                this.actionLiveType = 5;
                this.actionDataParsed = new String[]{"5"};
            }
            this.stateData.put("action_seq", this.actionDataParsed);
            if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
                String[] split2 = YtSDKKitFramework.getInstance().version().split("-");
                String makeActionStr = ActionLivenessHelper.makeActionStr(this.actionDataParsed);
                if (stateByName2 != null && !this.isSetColorData) {
                    YTPoseDetectJNIInterface.setColorData((String) stateByName2.getStateDataBy("color_data"), split2[0], makeActionStr, this.innerMp4Path, (String) stateByName2.getStateDataBy("sd_data"));
                    this.isSetColorData = true;
                }
            } else {
                YTPoseDetectJNIInterface.setColorData("NULL", "NULL", "NULL", this.innerMp4Path, "NULL");
            }
        } catch (Exception e16) {
            YtLogger.e(TAG, "action enter failed ", e16);
            CommonUtils.reportException("action enter failed ", e16);
        }
        YtFSM.getInstance().updateCacheStrategy(YtFSM.YtFSMUpdateStrategy.CacheStrategy);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fc, code lost:
    
        if (r6 > 99) goto L47;
     */
    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void enterFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        YtLogger.o(TAG, makeStateInfo(TAG, 1));
        YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        stateByName.handleStateAction("reset_timeout", null);
        YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        if (stateByName2 != null) {
            try {
                Object stateDataBy = stateByName2.getStateDataBy(AEEditorConstants.VIDEO_BITRATE);
                if (stateDataBy != null) {
                    this.codecSettingBitRate = ((Integer) stateDataBy).intValue();
                }
                Object stateDataBy2 = stateByName2.getStateDataBy(AEEditorConstants.VIDEO_FRAMERATE);
                if (stateDataBy2 != null) {
                    this.codecSettingFrameRate = ((Integer) stateDataBy2).intValue();
                }
                Object stateDataBy3 = stateByName2.getStateDataBy("video_iframeinterval");
                if (stateDataBy3 != null) {
                    this.codecSettingiFrameInterval = ((Integer) stateDataBy3).intValue();
                }
                String str = (String) stateByName2.getStateDataBy("control_config");
                if (str != null) {
                    this.controlConfig = str;
                }
            } catch (Exception e16) {
                YtLogger.e(TAG, "action enter first failed:", e16);
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
                    if (split2.length > 1 && split2[0].equals("action_video_shorten_strategy")) {
                        int parseInt = Integer.parseInt(split2[1]);
                        this.actionVideoShortenStrategy = parseInt;
                        YTPoseDetectJNIInterface.updateParam("action_video_shorten_strategy", String.valueOf(parseInt));
                    }
                    if (split2.length > 1 && split2[0].equals("compress_pose_image_score")) {
                        int parseInt2 = Integer.parseInt(split2[1]);
                        int i3 = 80;
                        if (parseInt2 >= 80) {
                            i3 = 99;
                        }
                        parseInt2 = i3;
                        YtLogger.o(TAG, "compress pose image score:" + parseInt2);
                        YTPoseDetectJNIInterface.compressPoseImageScore = parseInt2;
                    }
                }
            }
        }
        YTFaceTracker yTFaceTracker = (YTFaceTracker) stateByName.getStateDataBy("detect_instance");
        this.tracker = yTFaceTracker;
        if (yTFaceTracker != null) {
            YTFaceTracker.Param param = yTFaceTracker.getParam();
            this.mOriginParam = param;
            if (param != null) {
                param.detInterval = this.actionFrameNum;
                this.tracker.setParam(param);
            }
        } else {
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_VERIFY_MODEL_INIT_FAIL, "\u6a21\u5f0f\u521d\u59cb\u5316\u5931\u8d25");
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this);
                        return;
                    }
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", Integer.valueOf(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "Init YTFaceTrack SDK failed with "));
                }
            });
        }
        this.videoEncoder = new YtVideoEncoderHelper(this.innerMp4Path, this.codecSettingBitRate, this.codecSettingFrameRate, this.codecSettingiFrameInterval, this.controlConfig);
        YTPoseDetectJNIInterface.updateParam("screen_orientation", String.valueOf(this.orientation));
        YTPoseDetectJNIInterface.updateParam("video_color_format_type", String.valueOf(this.videoEncoder.getColorFormat()));
        YTPoseDetectJNIInterface.updateParam("out_image_type", String.valueOf(0));
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void exit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.exit();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) ytFrameworkFireEventType, obj);
            return;
        }
        super.handleEvent(ytFrameworkFireEventType, obj);
        if (this.needManualTrigger && ytFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS) {
            clearData();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void loadStateWith(String str, JSONObject jSONObject, YtSdkConfig ytSdkConfig) {
        JSONArray jSONArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, jSONObject, ytSdkConfig);
            return;
        }
        super.loadStateWith(str, jSONObject, ytSdkConfig);
        String version = YTPoseDetectJNIInterface.getVersion();
        String str2 = TAG;
        YtLogger.i(str2, "YTPose Version: " + version);
        String[] split = version.split("\\.");
        String str3 = this.legitimatePoseVersion;
        YtLogger.i(str2, "Wanted YTPose Version: " + str3);
        String[] split2 = str3.split("\\.");
        if (Integer.parseInt(split[0]) != Integer.parseInt(split2[0])) {
            sendFSMEvent(new HashMap<String, Object>(version) { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.1
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String val$realVersion;

                {
                    this.val$realVersion = version;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this, (Object) version);
                        return;
                    }
                    put(StateEvent.Name.WARNING_TIPS, "\u52a8\u4f5c\u5e93\u7248\u672c\u5f02\u5e38\uff01\u76ee\u6807\u7248\u672c\uff1a" + ActionLivenessState.this.legitimatePoseVersion + " \u5f53\u524d\u7248\u672c\uff1a" + version);
                }
            });
        } else if (Integer.parseInt(split[1]) != Integer.parseInt(split2[1])) {
            sendFSMEvent(new HashMap<String, Object>(version) { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.2
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String val$realVersion;

                {
                    this.val$realVersion = version;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this, (Object) version);
                        return;
                    }
                    put(StateEvent.Name.WARNING_TIPS, "\u52a8\u4f5c\u5e93\u7248\u672c\u5f02\u5e38\uff01\u76ee\u6807\u7248\u672c\uff1a" + ActionLivenessState.this.legitimatePoseVersion + " \u5f53\u524d\u7248\u672c\uff1a" + version);
                }
            });
        } else if (Integer.parseInt(split[2]) < Integer.parseInt(split2[2])) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(version) { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.3
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String val$realVersion;

                {
                    this.val$realVersion = version;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this, (Object) version);
                        return;
                    }
                    put(StateEvent.Name.WARNING_TIPS, "\u52a8\u4f5c\u5e93\u7248\u672c\u8fc7\u4f4e\uff01\u76ee\u6807\u7248\u672c\uff1a" + ActionLivenessState.this.legitimatePoseVersion + " \u5f53\u524d\u7248\u672c\uff1a" + version);
                }
            });
        }
        int initModel = YTPoseDetectInterface.initModel();
        if (initModel != 0) {
            YtLogger.e(str2, "action load failed2: " + initModel, null);
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(initModel) { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.4
                static IPatchRedirector $redirector_;
                public final /* synthetic */ int val$initR;

                {
                    this.val$initR = initModel;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this, initModel);
                        return;
                    }
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", Integer.valueOf(ErrorCode.YT_SDK_POSEDETECT_INIT_FAILED));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_POSEDETECT_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "Init YtPose SDK failed with " + initModel));
                }
            });
            return;
        }
        this.continuousDetectCount = 0;
        this.stateData.put("action_type", Integer.valueOf(this.actionLiveType));
        try {
            if (jSONObject.has("action_security_level")) {
                this.securityLevel = jSONObject.getInt("action_security_level");
            }
            jSONArray = jSONObject.getJSONArray("action_default_seq");
        } catch (JSONException e16) {
            YtLogger.e(TAG, "action load failed3: ", e16);
            this.actionDataParsed = "0".split(" ");
        }
        if (jSONArray == null) {
            YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
            return;
        }
        this.actionDataParsed = new String[jSONArray.length()];
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            this.actionDataParsed[i3] = jSONArray.getString(i3);
        }
        YtLogger.d(TAG, "load action sequence from sdkconfig " + jSONObject.getString("action_default_seq") + " size :" + this.actionDataParsed.length);
        try {
            if (jSONObject.has("action_inner_settings")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("action_inner_settings");
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str4 = (String) keys.next();
                    YTPoseDetectJNIInterface.updateParam(str4, jSONObject2.getString(str4));
                }
            }
        } catch (JSONException e17) {
            YtLogger.e(TAG, "action load failed4: ", e17);
        }
        YTPoseDetectJNIInterface.setLoggerListener(new YTPoseDetectJNIInterface.IYtLoggerListener() { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this);
                }
            }

            @Override // com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface.IYtLoggerListener
            public void log(String str5, String str6) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str5, (Object) str6);
                    return;
                }
                YtLogger.d("[SUNNY]", str5 + "---" + str6);
                Log.e("sunny-->", "~~~~~" + str5 + "||||" + str6);
            }
        });
        YTPoseDetectJNIInterface.configNativeLog(true);
        YTPoseDetectJNIInterface.updateParam("log_level", "3");
        YTPoseDetectJNIInterface.updateParam("frame_num", "" + this.actionFrameNum);
        YTPoseDetectJNIInterface.updateParam("last_frame_num", "" + this.lastActionFrameNum);
        YTPoseDetectJNIInterface.updateParam("anchor_widths", this.anchorWidths);
        YTPoseDetectJNIInterface.updateParam("need_best_original_size", String.valueOf(this.needBestOriginalSize));
        YTPoseDetectJNIInterface.updateParam("action_close_mouth_threshold", String.valueOf(this.actionCloseMouthThreshold));
        YTPoseDetectJNIInterface.updateParam("need_frame_quality", String.valueOf(this.needFaceQuality ? 1 : 0));
        YTPoseDetectJNIInterface.updateParam("continuous_quality_num_threshold", String.valueOf(this.continuousQualityNumThreshold));
        YTPoseDetectJNIInterface.updateParam("secondary_yaw_threshold", String.valueOf(this.secondaryYawThreshold));
        YTPoseDetectJNIInterface.updateParam("secondary_pitch_threshold", String.valueOf(this.secondaryPitchThreshold));
        YTPoseDetectJNIInterface.updateParam("secondary_roll_threshold", String.valueOf(this.secondaryRollThreshold));
        this.currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        YTPoseDetectJNIInterface.setSafetyLevel(this.securityLevel);
        reset();
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void moveToNextState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.moveToNextState();
        if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE) {
            if (YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName)) == -1) {
                sendFSMTransitError(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
            }
        } else {
            this.isOutActionLiveness = true;
            YTPoseDetectInterface.stop();
            YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
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
        if (YTPoseDetectInterface.isDetecting()) {
            YTPoseDetectInterface.stop();
        }
        YTPoseDetectInterface.releaseModel();
        YtVideoEncoderHelper ytVideoEncoderHelper = this.videoEncoder;
        if (ytVideoEncoderHelper != null) {
            ytVideoEncoderHelper.unload();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void update(YTImageData yTImageData, long j3) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, yTImageData, Long.valueOf(j3));
            return;
        }
        super.update(yTImageData, j3);
        if (this.needCloseTimeout && this.isPause.get()) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this);
                    } else {
                        put(StateEvent.Name.FSM_STATE_PAUSE, YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE);
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
        YTFaceTracker.TrackedFace[] trackedFaceArr = this.faceStatus;
        if (trackedFaceArr != null && trackedFaceArr.length > 0 && (i3 = this.continuousDetectCount) > 0) {
            if (i3 <= 1 || (this.needCheckMultiFaces && this.poseState == 7)) {
                this.poseReadyCount = this.stableCountNum;
                YTPoseDetectInterface.reset();
                this.isActionFinished = false;
            }
            if (this.actionFrameHandler == null) {
                YtLogger.e(TAG, "FrameHandle is null, check init first", null);
                return;
            }
            String str = TAG;
            YtLogger.d(str, "pose count" + this.poseReadyCount + " stable " + this.stableCountNum + " isAction" + this.isActionFinished);
            if (this.lastActionLiveType != this.actionLiveType && this.needCloseTimeout) {
                YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.10
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this);
                        } else {
                            put(StateEvent.Name.ACTION_DETECT_TYPE, Integer.valueOf(ActionLivenessState.this.actionLiveType));
                        }
                    }
                });
                this.lastActionLiveType = this.actionLiveType;
            }
            int i16 = this.actionLiveType;
            if ((i16 == this.correctionAngleActionType1 || i16 == this.correctionAngleActionType2) && !SilentLivenessHelper.faceAngleForceCheck(this.faceStatus[0], this.secondaryYawThreshold, this.secondaryPitchThreshold, this.secondaryRollThreshold)) {
                this.poseReadyCount = this.stableCountNum;
                YTPoseDetectInterface.reset();
                this.isActionFinished = false;
                YtLogger.o(str, "action correction face failure:" + this.actionLiveType);
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_NOTPASS);
                hashMap.put(StateEvent.Name.UI_TIPS, StringCode.FL_POSE_INCORRECT);
                sendFSMEvent(hashMap);
                z16 = false;
            } else {
                z16 = true;
            }
            if (this.actionLiveType == 3 && Math.abs(this.faceStatus[0].yaw) > 20.0f) {
                this.poseReadyCount = this.stableCountNum;
                this.isActionFinished = false;
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_NOTPASS);
                hashMap2.put(StateEvent.Name.UI_TIPS, StringCode.FL_POSE_INCORRECT);
                sendFSMEvent(hashMap2);
                z16 = false;
            }
            if (z16 && this.poseReadyCount > this.stableCountNum + 10) {
                if (!this.isActionFinished && !this.isOutActionLiveness) {
                    sendFSMEvent(new HashMap<String, Object>(getTipsByPoseType(this.actionLiveType)) { // from class: com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.11
                        static IPatchRedirector $redirector_;
                        public final /* synthetic */ String val$actionLiveTip;

                        {
                            this.val$actionLiveTip = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionLivenessState.this, (Object) r5);
                                return;
                            }
                            put(StateEvent.Name.UI_EXTRA_TIPS, ActionLivenessState.this.extraTips);
                            put(StateEvent.Name.UI_TIPS, ActionLivenessState.this.tips != null ? ActionLivenessState.this.tips : r5);
                            put(StateEvent.Name.UI_ACTION, ActionLivenessState.this.uiAction);
                        }
                    });
                }
                YTFaceTracker.TrackedFace trackedFace = this.faceStatus[0];
                YTPoseDetectInterface.poseDetect(new PoseDetectData(trackedFace.faceShape, trackedFace.faceVisible, this.actionLiveType, yTImageData.imgData, trackedFace.pitch, trackedFace.yaw, trackedFace.roll, this.poseState, this.shelterState, trackedFace.faceRect, yTImageData.width, yTImageData.height, false), this.actionFrameHandler, 1);
            }
            this.poseReadyCount++;
        }
        moveToNextState();
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void updateSDKSetting(JSONObject jSONObject) {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            return;
        }
        try {
            if (jSONObject.has("quality_close_eye_left_threshold")) {
                this.closeEyeLeftThreshold = (float) jSONObject.getDouble("quality_close_eye_left_threshold");
            }
            if (jSONObject.has("quality_close_eye_right_threshold")) {
                this.closeEyeRightThreshold = (float) jSONObject.getDouble("quality_close_eye_right_threshold");
            }
            if (jSONObject.has("quality_close_mouth_threshold")) {
                this.closeMouthThreshold = (float) jSONObject.getDouble("quality_close_mouth_threshold");
            }
            if (jSONObject.has("need_face_quality")) {
                this.needFaceQuality = jSONObject.getBoolean("need_face_quality");
            }
            if (jSONObject.has(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_PATH)) {
                this.innerMp4Path = jSONObject.getString(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_PATH);
            } else {
                this.innerMp4Path = YtFSM.getInstance().getContext().currentAppContext.getFilesDir() + "/temp.mp4";
            }
            if (jSONObject.has("local_config_flag")) {
                this.needLocalConfig = jSONObject.getBoolean("local_config_flag");
            }
            if (jSONObject.has(AEEditorConstants.VIDEO_BITRATE)) {
                this.codecSettingBitRate = jSONObject.getInt(AEEditorConstants.VIDEO_BITRATE);
            }
            if (jSONObject.has(AEEditorConstants.VIDEO_FRAMERATE)) {
                this.codecSettingFrameRate = jSONObject.getInt(AEEditorConstants.VIDEO_FRAMERATE);
            }
            if (jSONObject.has("video_iframeinterval")) {
                this.codecSettingiFrameInterval = jSONObject.getInt("video_iframeinterval");
            }
            if (jSONObject.has("manual_trigger")) {
                this.needManualTrigger = jSONObject.getBoolean("manual_trigger");
            }
            if (jSONObject.has("stable_frame_num")) {
                this.stableCountNum = jSONObject.getInt("stable_frame_num");
            }
            if (jSONObject.has("control_config")) {
                this.controlConfig = jSONObject.getString("control_config");
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
            if (jSONObject.has("continuous_quality_num_threshold")) {
                this.continuousQualityNumThreshold = jSONObject.getInt("continuous_quality_num_threshold");
            }
            if (jSONObject.has("screen_orientation")) {
                this.orientation = jSONObject.getInt("screen_orientation");
            }
            if (jSONObject.has("need_best_original_size")) {
                this.needBestOriginalSize = jSONObject.getInt("need_best_original_size");
            }
            if (jSONObject.has("action_close_mouth_threshold")) {
                this.actionCloseMouthThreshold = (float) jSONObject.getDouble("action_close_mouth_threshold");
            }
            if (jSONObject.has("correction_angle_action_type") && (split = jSONObject.getString("correction_angle_action_type").split(",")) != null && split.length > 0) {
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (i3 == 0) {
                        this.correctionAngleActionType1 = Integer.parseInt(split[i3]);
                    } else if (i3 == 1) {
                        this.correctionAngleActionType2 = Integer.parseInt(split[i3]);
                    }
                }
            }
            this.actionFrameNum = jSONObject.optInt("action_frame_num", 20);
            this.lastActionFrameNum = jSONObject.optInt("last_action_frame_num", 3);
            this.anchorWidths = jSONObject.optString("anchor_widths", "480,240,240");
            this.needCheckMultiFaces = jSONObject.optBoolean("need_check_multiface", false);
        } catch (JSONException e16) {
            e16.printStackTrace();
            YtLogger.e(TAG, "action load failed1:", e16);
        }
    }
}
