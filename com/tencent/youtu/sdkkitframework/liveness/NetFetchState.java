package com.tencent.youtu.sdkkitframework.liveness;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtSdkConfig;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NetFetchState extends YtFSMBaseState {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NetFetchState";
    private String actionSeqData;
    private String appId;
    private int backendProtoType;
    private int changePointNum;
    private String configUrl;
    private String controlConfig;
    private String extraConfig;
    private String localColorData;
    private boolean needActiolLocalConfig;
    private boolean needLocalConfig;
    private JSONObject selectData;

    /* compiled from: P */
    /* renamed from: com.tencent.youtu.sdkkitframework.liveness.NetFetchState$4, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12014);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            YtSDKKitFramework.YtSDKKitFrameworkWorkMode.values();
            int[] iArr = new int[8];
            $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode2 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode3 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr4[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode4 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr5[5] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface NetworkCallback {
        void onFailed(int i3, String str);

        void onSucceed(String str);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class YTLiveStyleReq {
        static IPatchRedirector $redirector_;
        public String app_id;
        public LiveStyleRequester.SeleceData select_data;

        public YTLiveStyleReq(float f16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NetFetchState.this, Float.valueOf(f16), str);
            } else {
                this.select_data = new LiveStyleRequester.SeleceData(f16);
                this.app_id = str;
            }
        }
    }

    public NetFetchState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.localColorData = "";
        this.actionSeqData = "";
        this.needLocalConfig = false;
        this.needActiolLocalConfig = false;
        this.extraConfig = "";
        this.controlConfig = "";
        this.changePointNum = 2;
        this.selectData = null;
        this.backendProtoType = 0;
    }

    private void onReflectRequest() {
        YTLiveStyleReq yTLiveStyleReq = new YTLiveStyleReq(-10000.0f, YTAGReflectLiveCheckInterface.mAppId);
        this.stateData.put("select_data", yTLiveStyleReq.select_data);
        if ((!this.localColorData.isEmpty() && this.needLocalConfig) || this.configUrl == null) {
            String str = TAG;
            YtLogger.i(str, "Use local data");
            this.stateData.put("color_data", this.localColorData);
            this.stateData.put("action_data", this.actionSeqData);
            YtLogger.d(str, "select data:" + this.selectData);
            JSONObject jSONObject = this.selectData;
            if (jSONObject != null) {
                try {
                    if (jSONObject.has(DownloadInfo.spKey_Config)) {
                        this.stateData.put("control_config", this.selectData.getString(DownloadInfo.spKey_Config));
                    }
                    if (this.selectData.has("reflect_param")) {
                        this.stateData.put("extra_config", this.selectData.getString("reflect_param"));
                    }
                    if (this.selectData.has("change_point_num")) {
                        this.stateData.put("cp_num", this.selectData.getString("change_point_num"));
                    }
                } catch (JSONException e16) {
                    String str2 = "Select data parse failed " + e16.getLocalizedMessage();
                    YtLogger.e(TAG, str2, e16);
                    YtSDKStats.getInstance().reportInfo(str2);
                }
            } else {
                YtLogger.e(str, "select data is null", null);
                YtSDKStats.getInstance().reportInfo("select data is null");
            }
            moveToNextState();
            return;
        }
        YtLivenessNetProtoHelper.GetLiveTypeReqData getLiveTypeReqData = new YtLivenessNetProtoHelper.GetLiveTypeReqData();
        YtLivenessNetProtoHelper.NetBaseInfoData netBaseInfoData = new YtLivenessNetProtoHelper.NetBaseInfoData();
        getLiveTypeReqData.baseInfo = netBaseInfoData;
        netBaseInfoData.appId = this.appId;
        netBaseInfoData.businessId = "wx_default";
        netBaseInfoData.lux = yTLiveStyleReq.select_data.android_data.lux;
        getLiveTypeReqData.reflectConfig = this.extraConfig;
        getLiveTypeReqData.controlConfig = this.controlConfig;
        getLiveTypeReqData.colorNum = this.changePointNum;
        String makeGetLiveTypeReq = YtLivenessNetProtoHelper.makeGetLiveTypeReq(getLiveTypeReqData);
        YtLogger.i(TAG, "Use online data ---> on get config info: " + makeGetLiveTypeReq);
        YtFSM.getInstance().sendNetworkRequest(StringCode.NET_FETCH_DATA, this.configUrl, makeGetLiveTypeReq, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser(getLiveTypeReqData) { // from class: com.tencent.youtu.sdkkitframework.liveness.NetFetchState.3
            static IPatchRedirector $redirector_;
            public final /* synthetic */ YtLivenessNetProtoHelper.GetLiveTypeReqData val$reqData;

            {
                this.val$reqData = getLiveTypeReqData;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetFetchState.this, (Object) getLiveTypeReqData);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:90:0x02c7  */
            /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r13v1 */
            /* JADX WARN: Type inference failed for: r13v3 */
            /* JADX WARN: Type inference failed for: r13v5 */
            /* JADX WARN: Type inference failed for: r13v6 */
            /* JADX WARN: Type inference failed for: r13v7 */
            /* JADX WARN: Type inference failed for: r13v8 */
            /* JADX WARN: Type inference failed for: r13v9 */
            @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                boolean z16;
                boolean z17;
                JSONObject jSONObject2;
                int i3;
                String str3;
                String str4;
                boolean z18;
                String replaceAll;
                ?? r132 = "color_data";
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap, (Object) exc);
                    return;
                }
                if (exc != null) {
                    YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_NETWORK_ERROR, exc.getMessage());
                    String localizedMessage = exc.getLocalizedMessage();
                    if (hashMap != null && hashMap.containsKey("response")) {
                        replaceAll = hashMap.get("response");
                    } else {
                        replaceAll = localizedMessage.replaceAll("\"", "");
                    }
                    YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(exc, replaceAll) { // from class: com.tencent.youtu.sdkkitframework.liveness.NetFetchState.3.1
                        static IPatchRedirector $redirector_;
                        public final /* synthetic */ Exception val$error;
                        public final /* synthetic */ String val$finalResponse;

                        {
                            this.val$error = exc;
                            this.val$finalResponse = replaceAll;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass3.this, exc, replaceAll);
                                return;
                            }
                            put("ui_error", exc.getMessage());
                            put(StateEvent.Name.PROCESS_RESULT, "failed");
                            put("error_code", Integer.valueOf(ErrorCode.YT_SDK_NETWORK_ERROR));
                            put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_NETWORK_ERROR, StringCode.MSG_NET_ERROR, replaceAll));
                        }
                    });
                } else {
                    YtLogger.d(NetFetchState.TAG, "response : " + hashMap.get("response"));
                    try {
                        jSONObject2 = new JSONObject(hashMap.get("response"));
                        YtLogger.o(NetFetchState.TAG, "online actionData: " + jSONObject2);
                        if (jSONObject2.has("error_code")) {
                            i3 = jSONObject2.getInt("error_code");
                        } else if (jSONObject2.has("errorcode")) {
                            i3 = jSONObject2.getInt("errorcode");
                        } else {
                            i3 = -1;
                        }
                    } catch (JSONException e17) {
                        e = e17;
                        r132 = 1;
                    }
                    if (i3 == 0) {
                        if (jSONObject2.has("color_data")) {
                            str3 = jSONObject2.getString("color_data");
                        } else {
                            str3 = null;
                        }
                        if (jSONObject2.has("action_data")) {
                            str4 = jSONObject2.getString("action_data");
                        } else {
                            str4 = null;
                        }
                        NetFetchState.this.stateData.put("color_data", str3);
                        NetFetchState.this.stateData.put("action_data", str4);
                        if (NetFetchState.this.needActiolLocalConfig) {
                            NetFetchState.this.stateData.put("action_data", NetFetchState.this.actionSeqData);
                        }
                        try {
                            if (jSONObject2.has("select_data")) {
                                if (jSONObject2.getJSONObject("select_data").has(DownloadInfo.spKey_Config)) {
                                    String replaceAll2 = Pattern.compile("u0026|\\\\u0026").matcher(jSONObject2.getJSONObject("select_data").getString(DownloadInfo.spKey_Config).replaceAll("&amp;", ContainerUtils.FIELD_DELIMITER).replaceAll("%26", ContainerUtils.FIELD_DELIMITER).replaceAll("%3D", ContainerUtils.KEY_VALUE_DELIMITER)).replaceAll(ContainerUtils.FIELD_DELIMITER);
                                    NetFetchState.this.stateData.put("control_config", NetFetchState.this.resetNeedActionVideoFieldForTrue(replaceAll2));
                                    if (!replaceAll2.isEmpty()) {
                                        String[] split = replaceAll2.split(ContainerUtils.FIELD_DELIMITER);
                                        if (split.length > 0) {
                                            for (String str5 : split) {
                                                String[] split2 = str5.split(ContainerUtils.KEY_VALUE_DELIMITER);
                                                if (split2.length > 1 && split2[0].equals("actref_ux_mode")) {
                                                    if (Integer.parseInt(split2[1]) != 2) {
                                                        z18 = true;
                                                    } else {
                                                        z18 = false;
                                                    }
                                                    HashMap<String, Object> hashMap2 = new HashMap<>();
                                                    hashMap2.put(StateEvent.Name.LIVE_MODE_REFLECTION_OPEN, Boolean.valueOf(z18));
                                                    YtFSM.getInstance().sendFSMEvent(hashMap2);
                                                }
                                            }
                                        }
                                    }
                                }
                                r132 = 1;
                                r132 = 1;
                                if (jSONObject2.getJSONObject("select_data").has("reflect_param")) {
                                    NetFetchState.this.stateData.put("extra_config", jSONObject2.getJSONObject("select_data").getString("reflect_param"));
                                }
                                if (jSONObject2.getJSONObject("select_data").has("change_point_num")) {
                                    NetFetchState.this.stateData.put("cp_num", jSONObject2.getJSONObject("select_data").getString("change_point_num"));
                                }
                            } else {
                                r132 = 1;
                                YtLogger.e(NetFetchState.TAG, "select_data not found or select_data.config not found", null);
                            }
                            if (jSONObject2.has("video_config")) {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("video_config");
                                if (jSONObject3.has(AEEditorConstants.VIDEO_BITRATE)) {
                                    NetFetchState.this.stateData.put(AEEditorConstants.VIDEO_BITRATE, Integer.valueOf(jSONObject3.getInt(AEEditorConstants.VIDEO_BITRATE)));
                                }
                                if (jSONObject3.has(AEEditorConstants.VIDEO_FRAMERATE)) {
                                    NetFetchState.this.stateData.put(AEEditorConstants.VIDEO_FRAMERATE, Integer.valueOf(jSONObject3.getInt(AEEditorConstants.VIDEO_FRAMERATE)));
                                }
                                if (jSONObject3.has("video_iframeinterval")) {
                                    NetFetchState.this.stateData.put("video_iframeinterval", Integer.valueOf(jSONObject3.getInt("video_iframeinterval")));
                                }
                            }
                            YtLivenessNetProtoHelper.Version version = new YtLivenessNetProtoHelper.Version();
                            version.sdk_version = YtSDKKitFramework.getInstance().version();
                            version.ftrack_sdk_version = YTFaceTracker.getVersion();
                            version.faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
                            version.freflect_sdk_version = YTAGReflectLiveCheckInterface.VERSION;
                            String makeVersion = version.makeVersion();
                            YtLivenessNetProtoHelper.GetLiveTypeReqData getLiveTypeReqData2 = this.val$reqData;
                            NetFetchState.this.stateData.put("sd_data", new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(getLiveTypeReqData2.baseInfo.lux, getLiveTypeReqData2.colorNum, getLiveTypeReqData2.reflectConfig, makeVersion, getLiveTypeReqData2.controlConfig).toString());
                            NetFetchState.this.moveToNextState();
                            z17 = false;
                        } catch (JSONException e18) {
                            e = e18;
                            YtLogger.e(NetFetchState.TAG, "parse response json other object failed:", e);
                            z16 = r132;
                            z17 = z16;
                            if (z17) {
                            }
                        }
                        if (z17) {
                            YtLogger.e(NetFetchState.TAG, "parse response failed", null);
                            String str6 = "server return failed";
                            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_NETWORK_ERROR, "server return failed");
                            if (hashMap.containsKey("response")) {
                                str6 = hashMap.get("response");
                            }
                            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(str6) { // from class: com.tencent.youtu.sdkkitframework.liveness.NetFetchState.3.2
                                static IPatchRedirector $redirector_;
                                public final /* synthetic */ String val$finalResponse;

                                {
                                    this.val$finalResponse = str6;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) str6);
                                        return;
                                    }
                                    put("ui_error", "Response failed");
                                    put(StateEvent.Name.UI_TIPS, StringCode.NET_FETCH_FAILED);
                                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                                    put("error_code", Integer.valueOf(ErrorCode.YT_SDK_NETWORK_ERROR));
                                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_NETWORK_ERROR, StringCode.NET_FETCH_FAILED, str6));
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z16 = true;
                    z17 = z16;
                    if (z17) {
                    }
                }
            }
        });
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.enter();
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.NetFetchState.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NetFetchState.this);
                } else {
                    put(StateEvent.Name.UI_TIPS, StringCode.NET_FETCH_DATA);
                }
            }
        });
        int ordinal = YtFSM.getInstance().getWorkMode().ordinal();
        if (ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5) {
            onReflectRequest();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            YtLogger.o(TAG, makeStateInfo(TAG, 1));
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void exit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.exit();
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
            String string = jSONObject.getString("app_id");
            this.appId = string;
            if (string == null) {
                YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
            }
            if (jSONObject.has("config_api_url")) {
                this.configUrl = jSONObject.getString("config_api_url");
            }
            if (jSONObject.has("color_data")) {
                this.localColorData = jSONObject.getString("color_data");
            }
            if (jSONObject.has("local_config_flag")) {
                this.needLocalConfig = jSONObject.getBoolean("local_config_flag");
            }
            if (jSONObject.has("action_default_seq")) {
                JSONArray jSONArray = jSONObject.getJSONArray("action_default_seq");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    this.actionSeqData += jSONArray.getString(i3);
                    if (i3 < jSONArray.length() - 1) {
                        this.actionSeqData += ",";
                    }
                }
            } else {
                this.actionSeqData = "0";
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
            if (jSONObject.has("select_data")) {
                this.selectData = jSONObject.getJSONObject("select_data");
            }
            if (jSONObject.has("backend_proto_type")) {
                this.backendProtoType = jSONObject.getInt("backend_proto_type");
            }
            if (jSONObject.has("net_request_timeout_ms")) {
                YtSDKKitFramework.getInstance().setNetworkRequestTimeoutMS(jSONObject.getInt("net_request_timeout_ms"));
            }
            this.needActiolLocalConfig = jSONObject.optBoolean("action_local_config_flag", false);
        } catch (JSONException e16) {
            e16.printStackTrace();
            YtLogger.e(TAG, "Failed to parse json:", e16);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void moveToNextState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.moveToNextState();
        int ordinal = YtFSM.getInstance().getWorkMode().ordinal();
        if (ordinal != 2 && ordinal != 3 && ordinal != 4 && ordinal != 5) {
            String str = "msg_param_error current unknown work mode:" + YtFSM.getInstance().getWorkMode();
            YtSDKStats.getInstance().reportError(4194304, str);
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(str) { // from class: com.tencent.youtu.sdkkitframework.liveness.NetFetchState.2
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String val$message;

                {
                    this.val$message = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NetFetchState.this, (Object) str);
                        return;
                    }
                    put("ui_error", 4194304);
                    put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", 4194304);
                    put("message", CommonUtils.makeMessageJson(4194304, StringCode.MSG_PARAM_ERROR, str));
                }
            });
            return;
        }
        YtFSM ytFSM = YtFSM.getInstance();
        YtSDKKitCommon.StateNameHelper.StateClassName stateClassName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        if (ytFSM.transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(stateClassName)) == -1) {
            sendFSMTransitError(YtSDKKitCommon.StateNameHelper.classNameOfState(stateClassName));
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.reset();
        }
    }

    public String resetNeedActionVideoFieldForTrue(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        StringBuilder sb5 = new StringBuilder();
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        if (split.length > 0) {
            boolean z16 = false;
            boolean z17 = true;
            for (String str2 : split) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length > 1) {
                    if (split2[0].equals("need_action_video")) {
                        if (!split2[1].equals("true")) {
                            YtLogger.w(TAG, "Background configuration error\uff01 'need_action_video' is false,but must has video!!", null);
                        }
                        z16 = true;
                    } else if (z17) {
                        sb5.append(split2[0]);
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append(split2[1]);
                        z17 = false;
                    } else {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                        sb5.append(split2[0]);
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append(split2[1]);
                    }
                }
            }
            if (z16) {
                sb5.append("&need_action_video=true");
            }
        }
        return sb5.toString();
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
