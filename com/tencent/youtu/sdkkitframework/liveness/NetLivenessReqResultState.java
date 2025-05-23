package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.EncryptUtil;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
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
import com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytposedetect.data.ActionData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import cooperation.qzone.remote.ServiceConst;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NetLivenessReqResultState extends YtFSMBaseState {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NetLivenessReqResultState";
    private int actRefUXMode;
    private int actReflectType;
    private String appId;
    private int backendProtoType;
    private YTImageData bestImage;
    private int changePointNum;
    private String controlConfig;
    public int enhanceEncryptMethod;
    private String extraConfig;
    private int finalConfidenceThreshold;
    private boolean isLoadResourceOnline;
    private JSONObject jsonOptionObject;
    public boolean needEncrypt;
    private boolean needManualTrigger;
    private HashMap<String, String> requestOptions;
    private String resultUrl;
    private String secretId;
    private String secretKey;
    private String sessionId;
    private int simiThreshold;
    private String userId;

    /* compiled from: P */
    /* renamed from: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState$11, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static /* synthetic */ class AnonymousClass11 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19984);
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
                iArr3[4] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode3 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr4[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class Version {
        static IPatchRedirector $redirector_;
        public String faction_sdk_version;
        public String freflect_sdk_version;
        public String ftrack_sdk_version;
        public String sdk_version;

        public Version() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetLivenessReqResultState.this);
                return;
            }
            this.sdk_version = "";
            this.ftrack_sdk_version = "";
            this.freflect_sdk_version = "";
            this.faction_sdk_version = "";
        }
    }

    public NetLivenessReqResultState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sessionId = "";
        this.needManualTrigger = false;
        this.simiThreshold = 70;
        this.requestOptions = new HashMap<>();
        this.jsonOptionObject = null;
        this.actReflectType = 0;
        this.backendProtoType = 0;
        this.isLoadResourceOnline = false;
        this.extraConfig = "";
        this.controlConfig = "";
        this.changePointNum = 2;
        this.actRefUXMode = 0;
        this.needEncrypt = false;
        this.enhanceEncryptMethod = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:11|12|13|14|15|(3:20|21|(12:23|(3:45|46|(6:48|26|27|(3:38|(1:44)(1:42)|43)(3:32|(1:34)|35)|36|37))|25|26|27|(1:30)|38|(1:40)|44|43|36|37)(9:56|27|(0)|38|(0)|44|43|36|37))|57|(1:59)(2:69|(1:71)(2:72|(1:74)(1:75)))|(2:64|65)(1:61)|62|63|21|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e6, code lost:
    
        r11 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3 A[Catch: JSONException -> 0x00e5, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00e5, blocks: (B:21:0x00cd, B:23:0x00d3, B:63:0x00b3), top: B:62:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0130 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleResponseEvent(HashMap<String, String> hashMap, Exception exc) {
        int i3;
        int i16;
        boolean z16;
        Object obj;
        int i17;
        HashMap<String, Object> hashMap2;
        int i18;
        int i19;
        JSONObject jSONObject;
        YtSDKStats.getInstance().exitState();
        if (exc != null) {
            YtLogger.i(TAG, "failed: error");
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_NETWORK_ERROR, exc.getMessage());
            String message = exc.getMessage();
            if (hashMap != null && hashMap.containsKey("response")) {
                message = hashMap.get("response");
            }
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(message) { // from class: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.4
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String val$finalResponse;

                {
                    this.val$finalResponse = message;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetLivenessReqResultState.this, (Object) message);
                        return;
                    }
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                    put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", Integer.valueOf(ErrorCode.YT_SDK_NETWORK_ERROR));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_NETWORK_ERROR, StringCode.MSG_NET_ERROR, message));
                }
            });
            return;
        }
        int i26 = -1;
        try {
            jSONObject = new JSONObject(hashMap.get("response"));
            z16 = jSONObject.has(LocalPhotoFaceInfo.SCORE);
            try {
            } catch (JSONException e16) {
                e = e16;
                i3 = -1;
                i16 = -1;
            }
        } catch (JSONException e17) {
            e = e17;
            i3 = -1;
            i16 = -1;
            z16 = false;
        }
        if (!jSONObject.has("errorcode") && !jSONObject.has("error_code")) {
            YtLogger.e(TAG, "response not right", null);
            i3 = -1;
            i17 = -1;
            if (!jSONObject.has("similarity_float")) {
                i16 = jSONObject.getInt("similarity_float");
                if (i16 != -1) {
                    try {
                    } catch (JSONException e18) {
                        e = e18;
                        i26 = i17;
                        YtLogger.e(TAG, "handleResponseEvent error", e);
                        obj = StringCode.RST_FAILED;
                        i17 = i26;
                        i26 = i16;
                        hashMap2 = new HashMap<>();
                        YtLogger.i(TAG, "errorcode: " + i17 + " score " + i3);
                        i18 = i17;
                        if (i17 != 0) {
                        }
                        if (!z16) {
                        }
                        hashMap2.put(StateEvent.Name.ERROR_REASON_CODE, Integer.valueOf(i18));
                        hashMap2.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                        hashMap2.put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                        hashMap2.put(StateEvent.Name.PROCESS_RESULT, "failed");
                        hashMap2.put("error_code", 4194304);
                        i19 = i18;
                        hashMap2.put("message", CommonUtils.makeMessageJson(i19, StringCode.RST_FAILED, hashMap.get("response")));
                        YtSDKStats.getInstance().reportInfo("errorCode " + i19);
                        YtFSM.getInstance().sendFSMEvent(hashMap2);
                        return;
                    }
                    if (i16 > this.simiThreshold) {
                        obj = StringCode.RST_SUCCEED;
                        i26 = i16;
                        hashMap2 = new HashMap<>();
                        YtLogger.i(TAG, "errorcode: " + i17 + " score " + i3);
                        i18 = i17;
                        if (i17 != 0 && (!z16 || i3 >= this.finalConfidenceThreshold)) {
                            hashMap2.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                            hashMap2.put(StateEvent.Name.UI_TIPS, StringCode.RST_SUCCEED);
                            hashMap2.put(StateEvent.Name.PROCESS_RESULT, StateEvent.ProcessResult.SUCCEED);
                            hashMap2.put("error_code", 0);
                            hashMap2.put("message", CommonUtils.makeMessageJson(0, StringCode.RST_SUCCEED, hashMap.get("response")));
                            hashMap2.put(StateEvent.Name.EXTRA_MESSAGE, this.bestImage);
                            if (i26 > 0) {
                                hashMap2.put(StateEvent.Name.CMP_MESSAGE, obj);
                                hashMap2.put(StateEvent.Name.CMP_SCORE, Integer.valueOf(i26));
                            }
                            i19 = i18;
                        } else {
                            if (!z16 && i3 < this.finalConfidenceThreshold) {
                                hashMap2.put(StateEvent.Name.ERROR_REASON_CODE, Integer.valueOf(ErrorCode.YT_SDK_VERIFY_SCORE_FAILED));
                            } else {
                                hashMap2.put(StateEvent.Name.ERROR_REASON_CODE, Integer.valueOf(i18));
                            }
                            hashMap2.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                            hashMap2.put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                            hashMap2.put(StateEvent.Name.PROCESS_RESULT, "failed");
                            hashMap2.put("error_code", 4194304);
                            i19 = i18;
                            hashMap2.put("message", CommonUtils.makeMessageJson(i19, StringCode.RST_FAILED, hashMap.get("response")));
                        }
                        YtSDKStats.getInstance().reportInfo("errorCode " + i19);
                        YtFSM.getInstance().sendFSMEvent(hashMap2);
                        return;
                    }
                }
                obj = StringCode.RST_FAILED;
                i26 = i16;
                hashMap2 = new HashMap<>();
                YtLogger.i(TAG, "errorcode: " + i17 + " score " + i3);
                i18 = i17;
                if (i17 != 0) {
                }
                if (!z16) {
                }
                hashMap2.put(StateEvent.Name.ERROR_REASON_CODE, Integer.valueOf(i18));
                hashMap2.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                hashMap2.put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                hashMap2.put(StateEvent.Name.PROCESS_RESULT, "failed");
                hashMap2.put("error_code", 4194304);
                i19 = i18;
                hashMap2.put("message", CommonUtils.makeMessageJson(i19, StringCode.RST_FAILED, hashMap.get("response")));
                YtSDKStats.getInstance().reportInfo("errorCode " + i19);
                YtFSM.getInstance().sendFSMEvent(hashMap2);
                return;
            }
            obj = StringCode.RST_FAILED;
            hashMap2 = new HashMap<>();
            YtLogger.i(TAG, "errorcode: " + i17 + " score " + i3);
            i18 = i17;
            if (i17 != 0) {
            }
            if (!z16) {
            }
            hashMap2.put(StateEvent.Name.ERROR_REASON_CODE, Integer.valueOf(i18));
            hashMap2.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
            hashMap2.put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
            hashMap2.put(StateEvent.Name.PROCESS_RESULT, "failed");
            hashMap2.put("error_code", 4194304);
            i19 = i18;
            hashMap2.put("message", CommonUtils.makeMessageJson(i19, StringCode.RST_FAILED, hashMap.get("response")));
            YtSDKStats.getInstance().reportInfo("errorCode " + i19);
            YtFSM.getInstance().sendFSMEvent(hashMap2);
            return;
        }
        if (this.backendProtoType == 0) {
            i17 = jSONObject.getInt("errorcode");
        } else if (jSONObject.has("error_code")) {
            i17 = jSONObject.getInt("error_code");
        } else if (jSONObject.has("errorcode")) {
            i17 = jSONObject.getInt("errorcode");
        } else {
            i17 = -1;
        }
        if (z16) {
            try {
                i3 = jSONObject.getInt(LocalPhotoFaceInfo.SCORE);
            } catch (JSONException e19) {
                e = e19;
                i3 = -1;
                i16 = -1;
                i26 = i17;
                YtLogger.e(TAG, "handleResponseEvent error", e);
                obj = StringCode.RST_FAILED;
                i17 = i26;
                i26 = i16;
                hashMap2 = new HashMap<>();
                YtLogger.i(TAG, "errorcode: " + i17 + " score " + i3);
                i18 = i17;
                if (i17 != 0) {
                }
                if (!z16) {
                }
                hashMap2.put(StateEvent.Name.ERROR_REASON_CODE, Integer.valueOf(i18));
                hashMap2.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                hashMap2.put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                hashMap2.put(StateEvent.Name.PROCESS_RESULT, "failed");
                hashMap2.put("error_code", 4194304);
                i19 = i18;
                hashMap2.put("message", CommonUtils.makeMessageJson(i19, StringCode.RST_FAILED, hashMap.get("response")));
                YtSDKStats.getInstance().reportInfo("errorCode " + i19);
                YtFSM.getInstance().sendFSMEvent(hashMap2);
                return;
            }
        } else {
            i3 = -1;
        }
        YtLogger.i(TAG, "errorcode: " + i17 + " score " + i3);
        if (!jSONObject.has("similarity_float")) {
        }
    }

    private String makeActionStr(String[] strArr) {
        String str = "";
        for (int i3 = 0; i3 < strArr.length; i3++) {
            int parseInt = Integer.parseInt(strArr[i3]);
            if (parseInt != 0 && parseInt != 1) {
                if (parseInt != 2) {
                    if (parseInt != 3) {
                        if (parseInt != 4) {
                            if (parseInt == 5) {
                                str = str + "silence";
                            }
                        } else {
                            str = str + "shake";
                        }
                    } else {
                        str = str + "node";
                    }
                } else {
                    str = str + "mouth";
                }
            } else {
                str = str + "blink";
            }
            if (i3 != strArr.length - 1) {
                str = str + ",";
            }
        }
        return str;
    }

    private void onActReflectRequest() {
        String str;
        String str2;
        try {
            CommonUtils.benchMarkBegin("make_pack_use_time");
            YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
            YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
            YTImageData yTImageData = (YTImageData) stateByName2.getStateDataBy("best_frame");
            this.bestImage = yTImageData;
            this.stateData.put("best_frame", yTImageData);
            YtFSMBaseState stateByName3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
            ActionReflectReq actionReflectReq = (ActionReflectReq) stateByName3.getStateDataBy("reflect_request_object");
            String str3 = null;
            if (stateByName2.getStateDataBy("frames") instanceof String) {
                str = null;
                str2 = null;
                str3 = stateByName2.getStateDataBy("frames").toString();
            } else {
                ActionData actionData = (ActionData) stateByName2.getStateDataBy("frames");
                str = actionData.videoMD;
                str2 = actionData.sdMD;
                byte[] bArr = actionData.video;
                if (bArr == null) {
                    YtLogger.w(TAG, "action data is null", null);
                } else {
                    str3 = new String(Base64.encode(bArr, 2));
                }
            }
            String str4 = (String) stateByName.getStateDataBy("control_config");
            if (str4 != null) {
                this.controlConfig = str4;
            }
            String str5 = (String) stateByName.getStateDataBy("extra_config");
            if (str5 != null) {
                this.extraConfig = str5;
                YtLogger.d(TAG, "extraconfig:" + this.extraConfig);
            }
            String str6 = (String) stateByName3.getStateDataBy("refcontrol_begin");
            if (str6 != null) {
                StringBuilder sb5 = new StringBuilder();
                String str7 = this.extraConfig;
                if (str7 == null) {
                    str7 = "";
                }
                sb5.append(str7);
                sb5.append(" refcontrol_begin ");
                sb5.append(str6);
                this.extraConfig = sb5.toString();
            }
            String str8 = (String) stateByName.getStateDataBy("cp_num");
            if (str8 != null) {
                this.changePointNum = Integer.parseInt(str8);
                YtLogger.d(TAG, "cpnum:" + this.changePointNum);
            }
            parseControlConfig();
            String makeActionStr = makeActionStr((String[]) stateByName2.getStateDataBy("action_seq"));
            YtLivenessNetProtoHelper.ActionReflectLiveReqData actionReflectLiveReqData = new YtLivenessNetProtoHelper.ActionReflectLiveReqData();
            YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData = new YtLivenessNetProtoHelper.NetBaseInfoData();
            actionReflectLiveReqData.baseInfo = netBaseInfoData;
            netBaseInfoData.sessionId = UUID.randomUUID().toString();
            YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData2 = actionReflectLiveReqData.baseInfo;
            netBaseInfoData2.appId = this.appId;
            netBaseInfoData2.businessId = "";
            actionReflectLiveReqData.colorData = actionReflectReq.color_data;
            if (str3 == null) {
                str3 = "";
            }
            actionReflectLiveReqData.actionVideo = str3;
            actionReflectLiveReqData.actionStr = makeActionStr;
            YTImageInfo yTImageInfo = actionReflectReq.eye_image;
            actionReflectLiveReqData.eyeImage = new YtLivenessNetProtoHelper.ImageInfo(yTImageInfo.image, yTImageInfo.five_points, yTImageInfo.checksum);
            YTImageInfo yTImageInfo2 = actionReflectReq.mouth_image;
            actionReflectLiveReqData.mouthImage = new YtLivenessNetProtoHelper.ImageInfo(yTImageInfo2.image, yTImageInfo2.five_points, yTImageInfo2.checksum);
            YTImageInfo yTImageInfo3 = actionReflectReq.live_image;
            actionReflectLiveReqData.liveImage = new YtLivenessNetProtoHelper.ImageInfo(yTImageInfo3.image, yTImageInfo3.five_points, yTImageInfo3.checksum);
            actionReflectLiveReqData.reflectData = actionReflectReq.reflect_data;
            actionReflectLiveReqData.baseInfo.lux = actionReflectReq.select_data.android_data.lux;
            actionReflectLiveReqData.reflectConfig = this.extraConfig;
            actionReflectLiveReqData.controlConfig = this.controlConfig;
            actionReflectLiveReqData.colorNum = this.changePointNum;
            String version = YTPoseDetectJNIInterface.getVersion();
            if (str != null) {
                actionReflectLiveReqData.config = "videochecksum=" + str + "&&client_version=" + version;
            } else {
                actionReflectLiveReqData.config = "client_version=" + version;
            }
            String makeActionReflectLiveReq = YtLivenessNetProtoHelper.makeActionReflectLiveReq(actionReflectLiveReqData, str, str2);
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(str2, str) { // from class: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.8
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String val$finalCsds;
                public final /* synthetic */ String val$finalVideoChecksumStr;

                {
                    this.val$finalCsds = str2;
                    this.val$finalVideoChecksumStr = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, NetLivenessReqResultState.this, str2, str);
                        return;
                    }
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.LIVE_DATA_CB);
                    put(StateEvent.Name.SELECT_DATA_S, str2);
                    put(StateEvent.Name.ACTION_DATA_S, str);
                }
            });
            if (this.jsonOptionObject != null) {
                try {
                    JSONObject jSONObject = new JSONObject(makeActionReflectLiveReq);
                    Iterator keys = this.jsonOptionObject.keys();
                    while (keys.hasNext()) {
                        String str9 = (String) keys.next();
                        jSONObject.put(str9, this.jsonOptionObject.get(str9));
                    }
                    makeActionReflectLiveReq = jSONObject.toString();
                } catch (JSONException e16) {
                    YtLogger.e(TAG, "lipread net request parse json failed ", e16);
                }
            }
            if (this.needEncrypt) {
                EncryptUtil encryptUtil = new EncryptUtil();
                int i3 = this.enhanceEncryptMethod;
                if (i3 == 0) {
                    makeActionReflectLiveReq = encryptUtil.generateEncReq(makeActionReflectLiveReq, this.appId, this.sessionId, DownloadInfo.spKey_Config);
                } else if (i3 == 1) {
                    makeActionReflectLiveReq = encryptUtil.generateSMReq(makeActionReflectLiveReq, this.appId, this.sessionId);
                }
            }
            String str10 = makeActionReflectLiveReq;
            OperateInfoManager.getInstance().setPackUseTime(CommonUtils.benchMarkEnd("make_pack_use_time"));
            YtFSM.getInstance().sendNetworkRequest(StringCode.NET_REPORTING, this.resultUrl, str10, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() { // from class: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetLivenessReqResultState.this);
                    }
                }

                @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
                public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap, (Object) exc);
                        return;
                    }
                    YtLogger.i(NetLivenessReqResultState.TAG, "handle actreflect response");
                    NetLivenessReqResultState.this.handleResponseEvent(hashMap, exc);
                    NetLivenessReqResultState.this.onCheckResponseManual();
                }
            });
        } catch (Exception e17) {
            YtLogger.e(TAG, "actrefl request failed", e17);
            YtSDKStats.getInstance().reportInfo("actrefl request failed: " + e17.getLocalizedMessage());
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(e17) { // from class: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.10
                static IPatchRedirector $redirector_;
                public final /* synthetic */ Exception val$e;

                {
                    this.val$e = e17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetLivenessReqResultState.this, (Object) e17);
                        return;
                    }
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                    put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", 3145728);
                    put("message", CommonUtils.makeMessageJson(3145728, StringCode.MSG_PARAM_ERROR, e17.getLocalizedMessage()));
                }
            });
        }
    }

    private void onActionRequest() {
        String str;
        CommonUtils.benchMarkBegin("make_pack_use_time");
        YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
        if (stateByName == null) {
            YtSDKStats.getInstance().reportInfo("action request action state is null");
            YtLogger.e(TAG, "action request action state is null", null);
            return;
        }
        try {
            this.bestImage = (YTImageData) stateByName.getStateDataBy("best_frame");
            if (stateByName.getStateDataBy("frames") instanceof String) {
                str = (String) stateByName.getStateDataBy("frames");
            } else {
                str = new String(Base64.encode(((ActionData) stateByName.getStateDataBy("frames")).video, 2));
            }
            String makeActionStr = makeActionStr((String[]) stateByName.getStateDataBy("action_seq"));
            parseControlConfig();
            YtLivenessNetProtoHelper.ActionLiveReqData actionLiveReqData = new YtLivenessNetProtoHelper.ActionLiveReqData();
            YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData = new YtLivenessNetProtoHelper.NetBaseInfoData();
            actionLiveReqData.baseInfo = netBaseInfoData;
            netBaseInfoData.appId = this.appId;
            netBaseInfoData.sessionId = UUID.randomUUID().toString();
            actionLiveReqData.bestImage = new String(Base64.encode(this.bestImage.imgData, 2));
            actionLiveReqData.actionStr = makeActionStr;
            actionLiveReqData.actionVideo = str;
            actionLiveReqData.needEyeDetect = true;
            actionLiveReqData.needMouthDetect = true;
            actionLiveReqData.reflectConfig = this.extraConfig;
            actionLiveReqData.controlConfig = this.controlConfig;
            actionLiveReqData.colorNum = this.changePointNum;
            String makeActionLiveReq = YtLivenessNetProtoHelper.makeActionLiveReq(actionLiveReqData);
            OperateInfoManager.getInstance().setPackUseTime(CommonUtils.benchMarkEnd("make_pack_use_time"));
            YtFSM.getInstance().sendNetworkRequest(StringCode.NET_REPORTING, this.resultUrl, makeActionLiveReq, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() { // from class: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetLivenessReqResultState.this);
                    }
                }

                @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
                public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap, (Object) exc);
                        return;
                    }
                    YtLogger.i(NetLivenessReqResultState.TAG, "Handle action response");
                    NetLivenessReqResultState.this.handleResponseEvent(hashMap, exc);
                    NetLivenessReqResultState.this.onCheckResponseManual();
                }
            });
        } catch (Exception e16) {
            YtLogger.e(TAG, "action request failed", e16);
            YtSDKStats.getInstance().reportInfo("action request failed: " + e16.getLocalizedMessage());
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(e16) { // from class: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.6
                static IPatchRedirector $redirector_;
                public final /* synthetic */ Exception val$e;

                {
                    this.val$e = e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetLivenessReqResultState.this, (Object) e16);
                        return;
                    }
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                    put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", 3145728);
                    put("message", CommonUtils.makeMessageJson(3145728, StringCode.MSG_PARAM_ERROR, e16.getLocalizedMessage()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCheckResponseManual() {
        if (this.needManualTrigger) {
            try {
                YtFSM ytFSM = YtFSM.getInstance();
                YtSDKKitCommon.StateNameHelper.StateClassName stateClassName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
                ytFSM.getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(stateClassName)).handleStateAction("reset_manual_trigger", null);
                if (YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(stateClassName)) == -1) {
                    sendFSMTransitError(YtSDKKitCommon.StateNameHelper.classNameOfState(stateClassName));
                }
            } catch (Exception e16) {
                String str = "on Check response manual failed " + e16.getLocalizedMessage();
                YtLogger.e(TAG, "on Check response manual failed", e16);
                YtSDKStats.getInstance().reportInfo(str);
            }
        }
    }

    private void onReflectRequest() {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        String makeReflectLiveReq;
        CommonUtils.benchMarkBegin("make_pack_use_time");
        CommonUtils.benchMarkBegin("reflect_request_s1");
        YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        YTImageData yTImageData = (YTImageData) stateByName.getStateDataBy("best_image");
        this.bestImage = yTImageData;
        byte[] encode = Base64.encode(yTImageData.imgData, 2);
        this.stateData.put("best_frame", this.bestImage);
        YtFSMBaseState stateByName2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
        YtFSMBaseState stateByName3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        ReflectLiveReq reflectLiveReq = (ReflectLiveReq) stateByName2.getStateDataBy("reflect_request_object");
        String str5 = (String) stateByName3.getStateDataBy("extra_config");
        if (str5 != null) {
            this.extraConfig = str5;
        }
        String str6 = (String) stateByName2.getStateDataBy("refcontrol_begin");
        if (str6 != null) {
            StringBuilder sb5 = new StringBuilder();
            String str7 = this.extraConfig;
            if (str7 == null) {
                str7 = "";
            }
            sb5.append(str7);
            sb5.append(" refcontrol_begin ");
            sb5.append(str6);
            this.extraConfig = sb5.toString();
        }
        String str8 = (String) stateByName3.getStateDataBy("cp_num");
        if (str8 != null) {
            this.changePointNum = Integer.parseInt(str8);
        }
        reflectLiveReq.session_id = UUID.randomUUID().toString();
        YtLivenessNetProtoHelper.ReflectLiveReqData reflectLiveReqData = new YtLivenessNetProtoHelper.ReflectLiveReqData();
        YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData = new YtLivenessNetProtoHelper.NetBaseInfoData();
        reflectLiveReqData.baseInfo = netBaseInfoData;
        netBaseInfoData.appId = this.appId;
        netBaseInfoData.sessionId = UUID.randomUUID().toString();
        YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData2 = reflectLiveReqData.baseInfo;
        if (this.requestOptions.containsKey("business_id")) {
            str = this.requestOptions.get("business_id");
        } else {
            str = null;
        }
        netBaseInfoData2.businessId = str;
        YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData3 = reflectLiveReqData.baseInfo;
        if (this.requestOptions.containsKey("person_id")) {
            str2 = this.requestOptions.get("person_id");
        } else {
            str2 = null;
        }
        netBaseInfoData3.personId = str2;
        YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData4 = reflectLiveReqData.baseInfo;
        if (this.requestOptions.containsKey("person_type")) {
            str3 = this.requestOptions.get("person_type");
        } else {
            str3 = null;
        }
        netBaseInfoData4.personType = str3;
        YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData5 = reflectLiveReqData.baseInfo;
        if (this.requestOptions.containsKey(AppConstants.Key.SHARE_REQ_TYPE)) {
            str4 = this.requestOptions.get(AppConstants.Key.SHARE_REQ_TYPE);
        } else {
            str4 = null;
        }
        netBaseInfoData5.reqType = str4;
        YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData6 = reflectLiveReqData.baseInfo;
        if (this.requestOptions.containsKey("live_type")) {
            i3 = Integer.parseInt(this.requestOptions.get("live_type"));
        } else {
            i3 = 0;
        }
        netBaseInfoData6.liveType = i3;
        reflectLiveReqData.colorData = reflectLiveReq.color_data;
        reflectLiveReqData.liveImage = new String(encode);
        reflectLiveReqData.reflectData = reflectLiveReq.reflect_data;
        reflectLiveReqData.config = this.extraConfig;
        reflectLiveReqData.colorNum = this.changePointNum;
        if (this.backendProtoType == 2) {
            YuvImage yuvImage = (YuvImage) stateByName.getStateDataBy("best_image");
            float[] fArr = (float[]) stateByName.getStateDataBy("best_shape");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, byteArrayOutputStream);
            reflectLiveReqData.bestImage = new YtLivenessNetProtoHelper.ImageInfo(byteArrayOutputStream.toByteArray(), fArr, (String) null);
            YuvImage yuvImage2 = (YuvImage) stateByName.getStateDataBy("openmouth_image");
            float[] fArr2 = (float[]) stateByName.getStateDataBy("openmouth_shape");
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            yuvImage2.compressToJpeg(new Rect(0, 0, yuvImage2.getWidth(), yuvImage2.getHeight()), 95, byteArrayOutputStream2);
            reflectLiveReqData.openMouthImage = new YtLivenessNetProtoHelper.ImageInfo(byteArrayOutputStream2.toByteArray(), fArr2, (String) null);
            YuvImage yuvImage3 = (YuvImage) stateByName.getStateDataBy("closeeye_image");
            float[] fArr3 = (float[]) stateByName.getStateDataBy("closeeye_shape");
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            yuvImage3.compressToJpeg(new Rect(0, 0, yuvImage3.getWidth(), yuvImage3.getHeight()), 95, byteArrayOutputStream3);
            reflectLiveReqData.closeEyeImage = new YtLivenessNetProtoHelper.ImageInfo(byteArrayOutputStream3.toByteArray(), fArr3, (String) null);
            makeReflectLiveReq = YtLivenessNetProtoHelper.makePersonLiveReq(reflectLiveReqData);
        } else {
            makeReflectLiveReq = YtLivenessNetProtoHelper.makeReflectLiveReq(reflectLiveReqData);
        }
        String str9 = makeReflectLiveReq;
        YtLogger.d(TAG, "begin request...uploadsize " + str9.length());
        CommonUtils.benchMarkEnd("reflect_request_s1");
        CommonUtils.benchMarkBegin("reflect_request_s2");
        OperateInfoManager.getInstance().setPackUseTime(CommonUtils.benchMarkEnd("make_pack_use_time"));
        YtFSM.getInstance().sendNetworkRequest(StringCode.NET_REPORTING, this.resultUrl, str9, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() { // from class: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetLivenessReqResultState.this);
                }
            }

            @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
            public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap, (Object) exc);
                    return;
                }
                CommonUtils.benchMarkEnd("reflect_request_s2");
                CommonUtils.benchMarkBegin("reflect_request_s3");
                YtLogger.i(NetLivenessReqResultState.TAG, "handle reflection response");
                NetLivenessReqResultState.this.handleResponseEvent(hashMap, exc);
                CommonUtils.benchMarkEnd("reflect_request_s3");
                NetLivenessReqResultState.this.onCheckResponseManual();
            }
        });
    }

    private void onSilentRequest() {
        YTImageData yTImageData = (YTImageData) YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).getStateDataBy("best_image");
        this.bestImage = yTImageData;
        yTImageData.getWidth();
        this.bestImage.getHeight();
        byte[] bArr = this.bestImage.imgData;
        YtLivenessNetProtoHelper.PictureLiveReqData pictureLiveReqData = new YtLivenessNetProtoHelper.PictureLiveReqData();
        YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData = new YtLivenessNetProtoHelper.NetBaseInfoData();
        pictureLiveReqData.baseInfo = netBaseInfoData;
        netBaseInfoData.sessionId = UUID.randomUUID().toString();
        pictureLiveReqData.baseInfo.appId = this.appId;
        pictureLiveReqData.imageInfo = new YtLivenessNetProtoHelper.ImageInfo(bArr, (float[]) null, (String) null);
        YtFSM.getInstance().sendNetworkRequest(StringCode.NET_REPORTING, this.resultUrl, YtLivenessNetProtoHelper.makePictureLiveReq(pictureLiveReqData), null, new YtSDKKitFramework.IYtSDKKitNetResponseParser() { // from class: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetLivenessReqResultState.this);
                }
            }

            @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
            public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap, (Object) exc);
                    return;
                }
                YtLogger.i(NetLivenessReqResultState.TAG, "Parse silent response");
                NetLivenessReqResultState.this.handleResponseEvent(hashMap, exc);
                NetLivenessReqResultState.this.onCheckResponseManual();
            }
        });
    }

    private void parseControlConfig() {
        if (!this.controlConfig.isEmpty()) {
            String[] split = this.controlConfig.split(ContainerUtils.FIELD_DELIMITER);
            if (split.length > 0) {
                for (String str : split) {
                    String[] split2 = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2.length > 1 && split2[0].equals("actref_ux_mode")) {
                        this.actRefUXMode = Integer.parseInt(split2[1]);
                    }
                }
            }
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.enter();
        if (this.isPause.get()) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NetLivenessReqResultState.this);
                    } else {
                        put(StateEvent.Name.FSM_STATE_PAUSE, YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE);
                        put(StateEvent.Name.UI_TIPS, StringCode.MSG_FSM_PAUSE);
                    }
                }
            });
            try {
                LockMethodProxy.sleep(30L);
            } catch (InterruptedException e16) {
                YtLogger.e(TAG, "Thread sleep error", e16);
            }
            YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
            return;
        }
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NetLivenessReqResultState.this);
                } else {
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.NET_REQ);
                }
            }
        });
        int ordinal = YtFSM.getInstance().getWorkMode().ordinal();
        if (ordinal != 2 && ordinal != 3) {
            if (ordinal != 4) {
                if (ordinal == 5) {
                    onActReflectRequest();
                    return;
                }
                return;
            }
            onReflectRequest();
            return;
        }
        onActionRequest();
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
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
        try {
            this.appId = jSONObject.getString("app_id");
            String string = jSONObject.getString("result_api_url");
            this.resultUrl = string;
            if (string == null) {
                YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
                YtLogger.e(TAG, "parse url failed", null);
                return;
            }
            if (jSONObject.has("secret_key")) {
                this.secretKey = jSONObject.getString("secret_key");
            }
            if (jSONObject.has("secret_id")) {
                this.secretId = jSONObject.getString("secret_id");
            }
            if (jSONObject.has("user_id")) {
                this.userId = jSONObject.getString("user_id");
            }
            if (jSONObject.has("similarity_threshold")) {
                this.simiThreshold = jSONObject.getInt("similarity_threshold");
            }
            if (jSONObject.has("final_liveness_confidence_threshold")) {
                this.finalConfidenceThreshold = jSONObject.getInt("final_liveness_confidence_threshold");
            } else {
                this.finalConfidenceThreshold = 85;
            }
            if (jSONObject.has("extra_config")) {
                this.extraConfig = jSONObject.getString("extra_config");
            } else {
                this.extraConfig = " version 2";
            }
            if (jSONObject.has("control_config")) {
                this.controlConfig = jSONObject.getString("control_config");
            }
            if (jSONObject.has("change_point_num")) {
                this.changePointNum = jSONObject.getInt("change_point_num");
            }
            if (jSONObject.has("manual_trigger")) {
                this.needManualTrigger = jSONObject.getBoolean("manual_trigger");
            }
            if (jSONObject.has("request_options")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("request_options");
                this.jsonOptionObject = jSONObject2;
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    this.requestOptions.put(str2, this.jsonOptionObject.getString(str2));
                }
            }
            if (jSONObject.has("backend_proto_type")) {
                this.backendProtoType = jSONObject.getInt("backend_proto_type");
            }
            if (jSONObject.has("need_encrypt")) {
                this.needEncrypt = jSONObject.getBoolean("need_encrypt");
            }
            if (jSONObject.has(ServiceConst.PARA_SESSION_ID)) {
                this.sessionId = jSONObject.getString(ServiceConst.PARA_SESSION_ID);
            }
            if (jSONObject.has("enhance_encrypt_method")) {
                this.enhanceEncryptMethod = jSONObject.getInt("enhance_encrypt_method");
            }
            if (jSONObject.has("resource_online")) {
                this.isLoadResourceOnline = jSONObject.getBoolean("resource_online");
            }
            if (!this.isLoadResourceOnline && this.needEncrypt && this.enhanceEncryptMethod == 1) {
                FileUtils.loadLibrary("TencentSM");
            }
        } catch (JSONException e16) {
            YtLogger.e(TAG, "Failed to parse json:", e16);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void unload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.unload();
        }
    }
}
