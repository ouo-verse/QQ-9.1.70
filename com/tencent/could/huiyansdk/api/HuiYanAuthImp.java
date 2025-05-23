package com.tencent.could.huiyansdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.could.component.common.ai.eventreport.api.EventReportConfig;
import com.tencent.could.component.common.ai.eventreport.api.EventReporter;
import com.tencent.could.component.common.ai.eventreport.entry.NetWorkParam;
import com.tencent.could.component.common.ai.eventreport.utils.DeviceInfoUtil;
import com.tencent.could.component.common.ai.log.AiLog;
import com.tencent.could.component.common.ai.net.HttpMethod;
import com.tencent.could.component.common.ai.net.TXCHttp;
import com.tencent.could.component.common.ai.utils.TwoTuple;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.entity.AuthConfig;
import com.tencent.could.huiyansdk.entity.AuthUiConfig;
import com.tencent.could.huiyansdk.entity.BuriedPointBody;
import com.tencent.could.huiyansdk.entity.CameraDemoReq;
import com.tencent.could.huiyansdk.entity.CameraDemoRes;
import com.tencent.could.huiyansdk.entity.CameraRiskChangeInfo;
import com.tencent.could.huiyansdk.entity.CameraRiskParamConfig;
import com.tencent.could.huiyansdk.entity.CommonDataCache;
import com.tencent.could.huiyansdk.entity.ConfigEntity;
import com.tencent.could.huiyansdk.entity.CustomerConfig;
import com.tencent.could.huiyansdk.entity.HuiYanSdkConfig;
import com.tencent.could.huiyansdk.entity.LiveTypeRequest;
import com.tencent.could.huiyansdk.entity.OperationModeConfig;
import com.tencent.could.huiyansdk.entity.RiskDemoImage;
import com.tencent.could.huiyansdk.entity.TuringResultCacheEntity;
import com.tencent.could.huiyansdk.enums.HuiYanAuthEvent;
import com.tencent.could.huiyansdk.enums.HuiYanAuthTipsEvent;
import com.tencent.could.huiyansdk.enums.HuiYanPublicEvent;
import com.tencent.could.huiyansdk.enums.PageColorStyle;
import com.tencent.could.huiyansdk.enums.RiskCameraType;
import com.tencent.could.huiyansdk.enums.VideoSize;
import com.tencent.could.huiyansdk.exception.AuthException;
import com.tencent.could.huiyansdk.manager.b;
import com.tencent.could.huiyansdk.manager.d;
import com.tencent.could.huiyansdk.manager.f;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.operate.HuiYanOperateBody;
import com.tencent.could.huiyansdk.operate.b;
import com.tencent.could.huiyansdk.operate.c;
import com.tencent.could.huiyansdk.turing.f;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.could.huiyansdk.utils.HYPCommonUtils;
import com.tencent.could.huiyansdk.utils.d;
import com.tencent.could.huiyansdk.utils.e;
import com.tencent.could.huiyansdk.utils.g;
import com.tencent.could.huiyansdk.utils.h;
import com.tencent.could.huiyansdk.utils.i;
import com.tencent.could.huiyansdk.utils.j;
import com.tencent.could.huiyansdk.utils.l;
import com.tencent.could.huiyansdk.utils.q;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tenpay.utils.SMUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HuiYanAuthImp {
    static IPatchRedirector $redirector_ = null;
    private static final String AFTER_PAGE_CLASS_NAME = "com.tencent.could.huiyansdk.fragments.AuthResultFragment";
    private static final String ERROR_INFO = "please call init() function first!";
    private static final String PRE_PAGE_ClASS_NAME = "com.tencent.could.huiyansdk.fragments.ProtocolAllowFragment";
    private static final String TAG = "HuiYanAuthImp";
    private AuthConfig authConfig;
    private CommonDataCache commonDataCache;
    private CreateFaceIdToken createFaceIdToken;
    private HuiYanEventAuthCallback eventAuthCallback;
    private HuiYanAuthEventCallBack huiYanAuthEventCallBack;
    private final Object lock;
    private HuiYanPublicEventCallBack publicEventCallBack;
    private WeakReference<TextView> tipsTextView;

    /* compiled from: P */
    /* renamed from: com.tencent.could.huiyansdk.api.HuiYanAuthImp$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 implements HuiYanSdkCallBack {
        static IPatchRedirector $redirector_;

        public AnonymousClass3() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HuiYanAuthImp.this);
            }
        }

        @Override // com.tencent.could.huiyansdk.api.HuiYanSdkCallBack
        public void onCompareSuccess(String str, String str2) {
            Activity activity;
            final TextView textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
                return;
            }
            if (HuiYanAuthImp.this.tipsTextView != null && (textView = (TextView) HuiYanAuthImp.this.tipsTextView.get()) != null) {
                textView.post(new Runnable() { // from class: com.tencent.could.huiyansdk.api.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        textView.setText("");
                    }
                });
            }
            k.a.f100197a.a(2, HuiYanAuthImp.TAG, "on compare success!!");
            HuiYanAuthImp huiYanAuthImp = HuiYanAuthImp.this;
            com.tencent.could.huiyansdk.common.a aVar = a.C1019a.f100038a;
            WeakReference<Activity> weakReference = aVar.f100032a;
            if (weakReference == null || weakReference.get() == null) {
                activity = null;
            } else {
                activity = aVar.f100032a.get();
            }
            huiYanAuthImp.sendOnStartLoading(activity);
            HuiYanOperateBody huiYanOperateBody = c.b.f100258a.f100252a;
            if (huiYanOperateBody != null) {
                huiYanOperateBody.updateInfo("LocalCheck", 1, 1L, System.currentTimeMillis());
            }
            HuiYanAuthImp.this.getSendResultRequest(str, str2);
        }

        @Override // com.tencent.could.huiyansdk.api.HuiYanSdkCallBack
        public void onFail(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
                return;
            }
            c.b.f100258a.a("LocalCheck", 1, 0L, "code: " + i3 + " msg: " + str);
            HuiYanAuthImp.this.getDoOnFail(i3, str);
        }

        @Override // com.tencent.could.huiyansdk.api.HuiYanSdkCallBack
        public void onSelectSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                k.a.f100197a.a(2, HuiYanAuthImp.TAG, "on select success!");
                HuiYanAuthImp.this.getLiveTypeRequest(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class HuiYanAuthImpHolder {
        static IPatchRedirector $redirector_;
        private static final HuiYanAuthImp INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13894);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new HuiYanAuthImp(null);
            }
        }

        HuiYanAuthImpHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ HuiYanAuthImp(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
    }

    private AuthUiConfig createAuthUiConfig(AuthConfig authConfig) {
        VideoSize videoSize;
        AuthUiConfig authUiConfig = new AuthUiConfig();
        if (authConfig != null && authConfig.getCustomerConfig() != null) {
            CustomerConfig customerConfig = authConfig.getCustomerConfig();
            authUiConfig.setShowErrorDialog(customerConfig.isHiddenErrorDialog());
            authUiConfig.setAuthLayoutResId(customerConfig.getAuthLayoutResId());
            authUiConfig.setLandAuthLayoutResId(customerConfig.getLandAuthLayoutResId());
            authUiConfig.setMainActivityThemeId(customerConfig.getMainActivityThemeId());
            authUiConfig.setFeedBackErrorColor(customerConfig.getNoteTipsErrorTextColor());
            authUiConfig.setCancelBtnRight(customerConfig.isCancelBtnRight());
            authUiConfig.setHiddenExtraTipsTxt(customerConfig.isHiddenExtraTipsTxt());
            authUiConfig.setPrepareImageViewDrawable(customerConfig.getPrepareImageViewDrawable());
            authUiConfig.setShowCountdown(!customerConfig.isHiddenTimeoutLabel());
            authUiConfig.setLandAuthLayoutResId(customerConfig.getLandAuthLayoutResId());
            authUiConfig.setMainActivityThemeId(customerConfig.getMainActivityThemeId());
            authUiConfig.setAuthCircleCorrectColor(customerConfig.getAuthCircleCorrectColor());
            authUiConfig.setAuthCircleErrorColor(customerConfig.getAuthCircleErrorColor());
            authUiConfig.setFeedBackTxtColor(customerConfig.getFeedBackTxtColor());
            authUiConfig.setAuthLayoutBgColor(customerConfig.getAuthLayoutBgColor());
            authUiConfig.setStatusBarColor(customerConfig.getStatusBarColor());
            authUiConfig.setTransparentStatusBar(customerConfig.isTransparentStatusBar());
            authUiConfig.setTransparentStatusBarMoveHeight(customerConfig.getTransparentStatusBarMoveHeight());
            authUiConfig.setUseDeepColorStatusBarIcon(customerConfig.isUseDeepColorStatusBarIcon());
            authUiConfig.setHideAvatarGuideFrame(customerConfig.isHideAvatarGuideFrame());
            if (customerConfig.isUse720p()) {
                videoSize = VideoSize.SIZE_720P;
            } else {
                videoSize = VideoSize.SIZE_480P;
            }
            authUiConfig.setVideoSize(videoSize);
        }
        return authUiConfig;
    }

    private HuiYanSdkConfig createHuiYanConfig(AuthConfig authConfig) {
        HuiYanSdkConfig huiYanSdkConfig = new HuiYanSdkConfig();
        huiYanSdkConfig.setAuthTimeOutMs(authConfig.getAuthTimeOutMs());
        huiYanSdkConfig.setPrepareFaceTimeOutMs(authConfig.getAuthTimeOutMs());
        huiYanSdkConfig.setPageColorStyle(authConfig.getPageColorStyle());
        huiYanSdkConfig.setAuthLicense(authConfig.getAuthLicense());
        huiYanSdkConfig.setUseCustomerModelPath(authConfig.getUseCustomerModelPath());
        huiYanSdkConfig.setLanguageStyle(authConfig.getLanguageStyle());
        huiYanSdkConfig.setLanguageCode(authConfig.getLanguageCode());
        huiYanSdkConfig.setCloseEncrypt(true);
        huiYanSdkConfig.setOpenLog(authConfig.isOpenLog());
        huiYanSdkConfig.setOpenFullLog(authConfig.isOpenFullLog());
        huiYanSdkConfig.setWaitingUserCompare(true);
        huiYanSdkConfig.setStartActivityContext(authConfig.getStartActivityContext());
        return huiYanSdkConfig;
    }

    public static HuiYanAuthImp getInstance() {
        return HuiYanAuthImpHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLiveTypeRequest(String str) {
        try {
            c.b.f100258a.a("GetLiveTypeDateUseTime", 1, false, "");
            getInstance().sendPublicEvent(HuiYanPublicEvent.GET_LIVE_TYPE);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("select_data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("select_data");
                LiveTypeRequest liveTypeRequest = new LiveTypeRequest();
                liveTypeRequest.setSelectData(jSONObject2.toString());
                liveTypeRequest.setTuringFaceData(getInstance().getTuringResultDate());
                d dVar = d.b.f100161a;
                String deviceToken = dVar.f100155a.getDeviceToken();
                if (TextUtils.isEmpty(deviceToken)) {
                    deviceToken = DeviceInfoUtil.getDeviceUuid(HuiYanBaseApi.b.f100031a.a());
                    dVar.f100155a.setDeviceToken(deviceToken);
                }
                liveTypeRequest.setDeviceToken(deviceToken);
                liveTypeRequest.setEnableSecretKey(getInstance().isOpenEncrypt());
                liveTypeRequest.setTimestamp((System.currentTimeMillis() / 1000) + 0);
                TwoTuple<String, String> requestConnectIp = HYPCommonUtils.getRequestConnectIp(false);
                String tokenUrl = HYPCommonUtils.getTokenUrl(requestConnectIp.first + "/api/v3/new/getLiveType");
                String tokenUrl2 = HYPCommonUtils.getTokenUrl(requestConnectIp.second + "/api/v3/new/getLiveType");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("https://121.14.78.51");
                sb5.append("/api/v3/new/getLiveType");
                String tokenUrl3 = HYPCommonUtils.getTokenUrl(sb5.toString());
                com.tencent.could.huiyansdk.operate.a a16 = b.a.f100251a.a();
                Gson gson = new Gson();
                liveTypeRequest.setDeviceInfo(CommonUtils.base64EncodeToString(gson.toJson(a16)));
                String jSONObject3 = new JSONObject(gson.toJson(liveTypeRequest)).toString();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("summary", CommonUtils.md5(jSONObject3));
                NetWorkParam createNetWorkParam = NetWorkParam.NetWorkParamBuilder.newBuilder().setUrl(tokenUrl).setDeputyUrl(tokenUrl2).setBackUpIpStringUrl(tokenUrl3).setHttpMethod(HttpMethod.POST).setRequestHeaders(hashMap).setGzip(true).setTimeOutTimes(16000).setHttpsVerifyHost("sdk.faceid.qq.com").setRequestData(jSONObject3).createNetWorkParam();
                k.a.f100197a.a(1, "HuiYanSenderHelper", "start get live type!" + tokenUrl);
                dVar.a("AuthCheckStage", "GetLiveTypeStart", "");
                TXCHttp.sendRequest(createNetWorkParam, new i(gson));
            }
        } catch (JSONException unused) {
            k.a.f100197a.a(2, "HuiYanSenderHelper", "do request content error!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0072 A[Catch: JSONException -> 0x03e7, TryCatch #0 {JSONException -> 0x03e7, blocks: (B:8:0x004c, B:10:0x0072, B:11:0x0078, B:13:0x0082, B:15:0x008e, B:16:0x0099, B:19:0x00a6, B:21:0x00aa, B:23:0x00b8, B:25:0x00c4, B:26:0x00e4, B:27:0x00fe, B:29:0x0104, B:31:0x010e, B:33:0x011e, B:34:0x0135, B:36:0x0152, B:37:0x015a, B:39:0x0163, B:40:0x017a, B:99:0x012d, B:101:0x0132, B:103:0x00d7, B:105:0x00db), top: B:7:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008e A[Catch: JSONException -> 0x03e7, TryCatch #0 {JSONException -> 0x03e7, blocks: (B:8:0x004c, B:10:0x0072, B:11:0x0078, B:13:0x0082, B:15:0x008e, B:16:0x0099, B:19:0x00a6, B:21:0x00aa, B:23:0x00b8, B:25:0x00c4, B:26:0x00e4, B:27:0x00fe, B:29:0x0104, B:31:0x010e, B:33:0x011e, B:34:0x0135, B:36:0x0152, B:37:0x015a, B:39:0x0163, B:40:0x017a, B:99:0x012d, B:101:0x0132, B:103:0x00d7, B:105:0x00db), top: B:7:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0104 A[Catch: JSONException -> 0x03e7, LOOP:0: B:27:0x00fe->B:29:0x0104, LOOP_END, TryCatch #0 {JSONException -> 0x03e7, blocks: (B:8:0x004c, B:10:0x0072, B:11:0x0078, B:13:0x0082, B:15:0x008e, B:16:0x0099, B:19:0x00a6, B:21:0x00aa, B:23:0x00b8, B:25:0x00c4, B:26:0x00e4, B:27:0x00fe, B:29:0x0104, B:31:0x010e, B:33:0x011e, B:34:0x0135, B:36:0x0152, B:37:0x015a, B:39:0x0163, B:40:0x017a, B:99:0x012d, B:101:0x0132, B:103:0x00d7, B:105:0x00db), top: B:7:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011e A[Catch: JSONException -> 0x03e7, TryCatch #0 {JSONException -> 0x03e7, blocks: (B:8:0x004c, B:10:0x0072, B:11:0x0078, B:13:0x0082, B:15:0x008e, B:16:0x0099, B:19:0x00a6, B:21:0x00aa, B:23:0x00b8, B:25:0x00c4, B:26:0x00e4, B:27:0x00fe, B:29:0x0104, B:31:0x010e, B:33:0x011e, B:34:0x0135, B:36:0x0152, B:37:0x015a, B:39:0x0163, B:40:0x017a, B:99:0x012d, B:101:0x0132, B:103:0x00d7, B:105:0x00db), top: B:7:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0152 A[Catch: JSONException -> 0x03e7, TryCatch #0 {JSONException -> 0x03e7, blocks: (B:8:0x004c, B:10:0x0072, B:11:0x0078, B:13:0x0082, B:15:0x008e, B:16:0x0099, B:19:0x00a6, B:21:0x00aa, B:23:0x00b8, B:25:0x00c4, B:26:0x00e4, B:27:0x00fe, B:29:0x0104, B:31:0x010e, B:33:0x011e, B:34:0x0135, B:36:0x0152, B:37:0x015a, B:39:0x0163, B:40:0x017a, B:99:0x012d, B:101:0x0132, B:103:0x00d7, B:105:0x00db), top: B:7:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0163 A[Catch: JSONException -> 0x03e7, TryCatch #0 {JSONException -> 0x03e7, blocks: (B:8:0x004c, B:10:0x0072, B:11:0x0078, B:13:0x0082, B:15:0x008e, B:16:0x0099, B:19:0x00a6, B:21:0x00aa, B:23:0x00b8, B:25:0x00c4, B:26:0x00e4, B:27:0x00fe, B:29:0x0104, B:31:0x010e, B:33:0x011e, B:34:0x0135, B:36:0x0152, B:37:0x015a, B:39:0x0163, B:40:0x017a, B:99:0x012d, B:101:0x0132, B:103:0x00d7, B:105:0x00db), top: B:7:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012d A[Catch: JSONException -> 0x03e7, TRY_LEAVE, TryCatch #0 {JSONException -> 0x03e7, blocks: (B:8:0x004c, B:10:0x0072, B:11:0x0078, B:13:0x0082, B:15:0x008e, B:16:0x0099, B:19:0x00a6, B:21:0x00aa, B:23:0x00b8, B:25:0x00c4, B:26:0x00e4, B:27:0x00fe, B:29:0x0104, B:31:0x010e, B:33:0x011e, B:34:0x0135, B:36:0x0152, B:37:0x015a, B:39:0x0163, B:40:0x017a, B:99:0x012d, B:101:0x0132, B:103:0x00d7, B:105:0x00db), top: B:7:0x004c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getSendResultRequest(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        String turingFrameResult;
        HuiYanOperateBody huiYanOperateBody;
        Iterator<String> it;
        CommonDataCache commonDataCache;
        String a16;
        String str4;
        String str5;
        String tokenUrl;
        String tokenUrl2;
        String tokenUrl3;
        HuiYanOperateBody huiYanOperateBody2;
        String encodeToString;
        c.b.f100258a.a("LocalCheckUseTime", 2, false, "");
        try {
            str3 = HYPCommonUtils.readFileAndCreateRequestBase64(str2);
        } catch (AuthException e16) {
            e = e16;
            str3 = "";
        }
        try {
            CommonUtils.deleteFileByPath(str2);
        } catch (AuthException e17) {
            e = e17;
            k.a.f100197a.a(2, "HuiYanSenderHelper", "readFileAndCreateRequestBase64 error: " + e.f100040b);
            getInstance().sendPublicEvent(HuiYanPublicEvent.LOCAL_CHECK_OVER);
            jSONObject = new JSONObject();
            StringBuilder sb5 = new StringBuilder();
            jSONObject.put("timestamp", (System.currentTimeMillis() / 1000) + 0);
            jSONObject.put("validate_data", str);
            turingFrameResult = getInstance().getTuringFrameResult();
            if (!TextUtils.isEmpty(turingFrameResult)) {
            }
            sb5.append(turingFrameResult);
            c cVar = c.b.f100258a;
            long length = str.getBytes().length / 1024;
            huiYanOperateBody = cVar.f100252a;
            if (huiYanOperateBody != null) {
            }
            if (TextUtils.isEmpty(str3)) {
            }
            jSONObject.put("video_base64", str3);
            sb5.append(CommonUtils.sha256(str3));
            List<String> list = f.a.f100180a.f100176n;
            JSONArray jSONArray = new JSONArray();
            it = list.iterator();
            while (it.hasNext()) {
            }
            jSONObject.put("cameraData", jSONArray);
            commonDataCache = getInstance().getCommonDataCache();
            if (commonDataCache == null) {
            }
            sb5.append(HYPCommonUtils.getFaceIdToken());
            String turingActiveParam = getInstance().getTuringActiveParam();
            String sha256 = CommonUtils.sha256(sb5.toString());
            com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
            if (fVar.f100278g == null) {
            }
            if (a16.startsWith("error")) {
            }
            jSONObject.put("turingSign", a16);
            String jSONObject2 = jSONObject.toString();
            TwoTuple<String, String> requestConnectIp = HYPCommonUtils.getRequestConnectIp(false);
            str4 = requestConnectIp.first;
            str5 = requestConnectIp.second;
            if (getInstance().isOpenEncrypt()) {
            }
            tokenUrl = HYPCommonUtils.getTokenUrl(str4 + "/api/v3/new/compare");
            tokenUrl2 = HYPCommonUtils.getTokenUrl(str5 + "/api/v3/new/compare");
            tokenUrl3 = HYPCommonUtils.getTokenUrl("https://121.14.78.51/api/v3/new/compare");
            c cVar2 = c.b.f100258a;
            long length2 = jSONObject2.getBytes().length / 1024;
            huiYanOperateBody2 = cVar2.f100252a;
            if (huiYanOperateBody2 != null) {
            }
            HashMap<String, String> hashMap = new HashMap<>();
            String replace = jSONObject2.replace("\\/", "/");
            hashMap.put("summary", CommonUtils.md5(replace));
            NetWorkParam createNetWorkParam = NetWorkParam.NetWorkParamBuilder.newBuilder().setUrl(tokenUrl).setDeputyUrl(tokenUrl2).setBackUpIpStringUrl(tokenUrl3).setRequestHeaders(hashMap).setHttpMethod(HttpMethod.POST).setRequestData(replace).setTimeOutTimes(50000).setHttpsVerifyHost("sdk.faceid.qq.com").setGzip(true).createNetWorkParam();
            d.b.f100161a.a("AuthCheckStage", "RequestCompareStart", "");
            cVar2.a("GetCompareResultUseTime", 1, false, "");
            if (l.a.f100309a.f100307a) {
            }
            TXCHttp.sendRequest(createNetWorkParam, new com.tencent.could.huiyansdk.utils.k());
        }
        getInstance().sendPublicEvent(HuiYanPublicEvent.LOCAL_CHECK_OVER);
        jSONObject = new JSONObject();
        try {
            StringBuilder sb52 = new StringBuilder();
            jSONObject.put("timestamp", (System.currentTimeMillis() / 1000) + 0);
            jSONObject.put("validate_data", str);
            turingFrameResult = getInstance().getTuringFrameResult();
            if (!TextUtils.isEmpty(turingFrameResult)) {
                jSONObject.put("turing_video_data", turingFrameResult);
            }
            sb52.append(turingFrameResult);
            c cVar3 = c.b.f100258a;
            long length3 = str.getBytes().length / 1024;
            huiYanOperateBody = cVar3.f100252a;
            if (huiYanOperateBody != null) {
                huiYanOperateBody.updateInfo("LivenessPackSize", 1, length3, System.currentTimeMillis());
            }
            if (TextUtils.isEmpty(str3)) {
                HuiYanOperateBody huiYanOperateBody3 = cVar3.f100252a;
                if (huiYanOperateBody3 != null) {
                    huiYanOperateBody3.updateInfo("LocalVideo", 1, 1L, System.currentTimeMillis());
                }
                long length4 = str3.getBytes().length / 1024;
                HuiYanOperateBody huiYanOperateBody4 = cVar3.f100252a;
                if (huiYanOperateBody4 != null) {
                    huiYanOperateBody4.updateInfo("LocalVideoSize", 1, length4, System.currentTimeMillis());
                }
            } else {
                HuiYanOperateBody huiYanOperateBody5 = cVar3.f100252a;
                if (huiYanOperateBody5 != null) {
                    huiYanOperateBody5.updateInfo("LocalVideo", 1, 0L, System.currentTimeMillis());
                }
            }
            jSONObject.put("video_base64", str3);
            sb52.append(CommonUtils.sha256(str3));
            List<String> list2 = f.a.f100180a.f100176n;
            JSONArray jSONArray2 = new JSONArray();
            it = list2.iterator();
            while (it.hasNext()) {
                jSONArray2.mo162put(it.next());
            }
            jSONObject.put("cameraData", jSONArray2);
            commonDataCache = getInstance().getCommonDataCache();
            if (commonDataCache == null) {
                sb52.append(commonDataCache.getSelectData());
                sb52.append(commonDataCache.getActionData());
            } else {
                k.a.f100197a.a(2, "HuiYanSenderHelper", "common data cache is null.");
            }
            sb52.append(HYPCommonUtils.getFaceIdToken());
            String turingActiveParam2 = getInstance().getTuringActiveParam();
            String sha2562 = CommonUtils.sha256(sb52.toString());
            com.tencent.could.huiyansdk.turing.f fVar2 = f.a.f100288a;
            a16 = fVar2.f100278g == null ? fVar2.f100278g.a(turingActiveParam2, sha2562) : "";
            if (a16.startsWith("error")) {
                k.a.f100197a.a(2, "HuiYanSenderHelper", "turingSign error: " + a16);
            }
            jSONObject.put("turingSign", a16);
            String jSONObject22 = jSONObject.toString();
            TwoTuple<String, String> requestConnectIp2 = HYPCommonUtils.getRequestConnectIp(false);
            str4 = requestConnectIp2.first;
            str5 = requestConnectIp2.second;
            if (getInstance().isOpenEncrypt() || TextUtils.isEmpty(getInstance().getPubKey())) {
                tokenUrl = HYPCommonUtils.getTokenUrl(str4 + "/api/v3/new/compare");
                tokenUrl2 = HYPCommonUtils.getTokenUrl(str5 + "/api/v3/new/compare");
                tokenUrl3 = HYPCommonUtils.getTokenUrl("https://121.14.78.51/api/v3/new/compare");
            } else {
                k.a.f100197a.a(2, "HuiYanSenderHelper", "send compare use encrypt");
                String tokenUrl4 = HYPCommonUtils.getTokenUrl(str4 + "/api/v3/reflect/encrypt_compare");
                String tokenUrl5 = HYPCommonUtils.getTokenUrl(str5 + "/api/v3/reflect/encrypt_compare");
                String tokenUrl6 = HYPCommonUtils.getTokenUrl("https://121.14.78.51/api/v3/reflect/encrypt_compare");
                d.a.f100302a.getClass();
                byte[] SM4GenKey = SMUtils.getInstance().SM4GenKey();
                byte[] bArr = new byte[16];
                new SecureRandom().nextBytes(bArr);
                byte[] sm4GCMEncryptNoPadding = SMUtils.getInstance().sm4GCMEncryptNoPadding(jSONObject22.getBytes(), 16, SM4GenKey, bArr, new byte[0]);
                byte[] bArr2 = new byte[32];
                int i3 = 0;
                for (int length5 = sm4GCMEncryptNoPadding.length - 16; length5 < sm4GCMEncryptNoPadding.length; length5++) {
                    bArr2[i3] = sm4GCMEncryptNoPadding[length5];
                    i3++;
                }
                byte[] bArr3 = new byte[sm4GCMEncryptNoPadding.length - 16];
                for (int i16 = 0; i16 < sm4GCMEncryptNoPadding.length - 16; i16++) {
                    bArr3[i16] = sm4GCMEncryptNoPadding[i16];
                }
                for (int i17 = 0; i17 < 16; i17++) {
                    bArr2[i17 + 16] = bArr[i17];
                }
                TwoTuple twoTuple = new TwoTuple(Base64.encodeToString(bArr3, 2), bArr2);
                com.tencent.could.huiyansdk.utils.d dVar = d.a.f100302a;
                byte[] bArr4 = (byte[]) twoTuple.second;
                String pubKey = getInstance().getPubKey();
                dVar.getClass();
                long SM2InitCtxWithPubKey = SMUtils.getInstance().SM2InitCtxWithPubKey(pubKey);
                byte[] bArr5 = new byte[48];
                for (int i18 = 0; i18 < SM4GenKey.length; i18++) {
                    bArr5[i18] = SM4GenKey[i18];
                }
                for (int i19 = 0; i19 < bArr4.length; i19++) {
                    bArr5[i19 + 16] = bArr4[i19];
                }
                byte[] SM2Encrypt = SMUtils.getInstance().SM2Encrypt(SM2InitCtxWithPubKey, bArr5, pubKey);
                SMUtils.getInstance().SM2FreeCtx(SM2InitCtxWithPubKey);
                if (SM2Encrypt == null) {
                    k.a.f100197a.a(2, "EncryptUtilsHelper", "sm4 key to sm2 is null.");
                    encodeToString = "";
                } else {
                    encodeToString = Base64.encodeToString(SM2Encrypt, 2);
                }
                if (!TextUtils.isEmpty(encodeToString)) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("timestamp", (System.currentTimeMillis() / 1000) + 0);
                        jSONObject3.put("validate_data", twoTuple.first);
                        jSONObject3.put("sign", encodeToString);
                        jSONObject22 = jSONObject3.toString().replace("\\/", "/");
                    } catch (JSONException e18) {
                        k.a.f100197a.a(2, "HuiYanSenderHelper", "getSendResultRequest error: " + e18.getLocalizedMessage());
                    }
                    if (!TextUtils.isEmpty(jSONObject22)) {
                        e.a(213, R.string.txy_network_json_error);
                        return;
                    } else {
                        tokenUrl2 = tokenUrl5;
                        tokenUrl3 = tokenUrl6;
                        tokenUrl = tokenUrl4;
                    }
                }
                jSONObject22 = "";
                if (!TextUtils.isEmpty(jSONObject22)) {
                }
            }
            c cVar22 = c.b.f100258a;
            long length22 = jSONObject22.getBytes().length / 1024;
            huiYanOperateBody2 = cVar22.f100252a;
            if (huiYanOperateBody2 != null) {
                huiYanOperateBody2.updateInfo("SendPackSize", 1, length22, System.currentTimeMillis());
            }
            HashMap<String, String> hashMap2 = new HashMap<>();
            String replace2 = jSONObject22.replace("\\/", "/");
            hashMap2.put("summary", CommonUtils.md5(replace2));
            NetWorkParam createNetWorkParam2 = NetWorkParam.NetWorkParamBuilder.newBuilder().setUrl(tokenUrl).setDeputyUrl(tokenUrl2).setBackUpIpStringUrl(tokenUrl3).setRequestHeaders(hashMap2).setHttpMethod(HttpMethod.POST).setRequestData(replace2).setTimeOutTimes(50000).setHttpsVerifyHost("sdk.faceid.qq.com").setGzip(true).createNetWorkParam();
            d.b.f100161a.a("AuthCheckStage", "RequestCompareStart", "");
            cVar22.a("GetCompareResultUseTime", 1, false, "");
            if (l.a.f100309a.f100307a) {
                AiLog.debug("HuiYanSenderHelper", "start send compare");
            }
            TXCHttp.sendRequest(createNetWorkParam2, new com.tencent.could.huiyansdk.utils.k());
        } catch (JSONException e19) {
            k.a.f100197a.a(2, "HuiYanSenderHelper", "getSendResultRequest error: " + e19.getLocalizedMessage());
            e.a(213, R.string.txy_network_json_error);
        }
    }

    private void initAndGetConfig(Context context) {
        if (context == null) {
            return;
        }
        if (l.a.f100309a.f100307a) {
            AiLog.debug("HuiYanSenderHelper", "start get config GET_CONFIG");
        }
        TwoTuple<String, String> requestConnectIp = HYPCommonUtils.getRequestConnectIp(true);
        String str = requestConnectIp.first + "/api/common/config";
        String str2 = "https://121.14.78.51/api/common/config";
        TXCHttp.sendRequest(NetWorkParam.NetWorkParamBuilder.newBuilder().setUrl(str).setHttpMethod(HttpMethod.POST).setRequestHeaders(null).setGzip(true).setDeputyUrl(requestConnectIp.second + "/api/common/config").setHttpsVerifyHost("sdk.faceid.qq.com").setBackUpIpStringUrl(str2).setRequestData("{\"packageName\":\"" + context.getPackageName() + "\"}").createNetWorkParam(), new com.tencent.could.huiyansdk.utils.f());
    }

    private void initInputDataCallback() {
        HuiYanSdkImp.getInstance().setInputDataCallBack(new HuiYanInputDataCallBack() { // from class: com.tencent.could.huiyansdk.api.HuiYanAuthImp.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HuiYanAuthImp.this);
                }
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanInputDataCallBack
            public String getCurrentToken() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return HYPCommonUtils.getFaceIdToken();
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanInputDataCallBack
            public AnimationDrawable getWaitingAnimation() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (AnimationDrawable) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                if (HuiYanAuthImp.this.authConfig.getCustomerConfig() != null && HuiYanAuthImp.this.authConfig.getCustomerConfig().isHiddenLoadingPage()) {
                    return null;
                }
                return HYPCommonUtils.createFrameAnimation(HuiYanBaseApi.b.f100031a.a().getResources());
            }
        });
    }

    private void initOthers(Context context) {
        c cVar = c.b.f100258a;
        cVar.getClass();
        HuiYanOperateBody huiYanOperateBody = new HuiYanOperateBody();
        cVar.f100252a = huiYanOperateBody;
        huiYanOperateBody.setDeviceModel(DeviceInfoUtil.getDeviceModel());
        cVar.f100252a.setOsVersion("android-" + Build.VERSION.SDK_INT);
        cVar.f100252a.setSdkName("HuiYanSDK");
        cVar.f100252a.setSdkVersion("v1.0.9.31");
        HuiYanOperateBody huiYanOperateBody2 = cVar.f100252a;
        HuiYanBaseApi.b.f100031a.getClass();
        huiYanOperateBody2.setYouTuVersion(YtSDKKitFramework.getInstance().version());
        cVar.f100252a.setTuringVersion(HuiYanSdkImp.getInstance().getTruingSdkVersion());
        cVar.f100252a.setDeviceToken(DeviceInfoUtil.getDeviceUuid(context));
        cVar.f100252a.setPackageName(context.getPackageName());
        String packageName = context.getPackageName();
        cVar.f100252a.setPackageName(packageName);
        try {
            cVar.f100252a.setPackageVersion(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), packageName, 0).versionName);
        } catch (PackageManager.NameNotFoundException e16) {
            k.a.f100197a.a(2, "OperateInfoManager", "get package info error: " + e16.getLocalizedMessage());
        }
        cVar.b();
        TwoTuple<String, String> requestConnectIp = HYPCommonUtils.getRequestConnectIp(true);
        EventReporter.getInstance().initEventReporter(context, EventReportConfig.builder().setDeviceInfoUrl(requestConnectIp.first + "/api/v3/data/device-info").setErrorInfoUrl(requestConnectIp.first + "/api/common/error-report").setBusiness("huiyan").setOrigin("sdk").setSdkVersion("v1.0.9.31").create());
        com.tencent.could.huiyansdk.operate.b bVar = b.a.f100251a;
        bVar.getClass();
        HuiYanOperateBody huiYanOperateBody3 = c.b.f100258a.f100252a;
        bVar.f100250a.f100235b = huiYanOperateBody3.getDeviceModel();
        bVar.f100250a.f100246m = huiYanOperateBody3.getDeviceToken();
        bVar.f100250a.f100240g = huiYanOperateBody3.getPackageName();
        bVar.f100250a.f100241h = huiYanOperateBody3.getPackageVersion();
        bVar.f100250a.f100237d = huiYanOperateBody3.getSdkVersion();
        bVar.f100250a.f100234a = huiYanOperateBody3.getOsVersion();
        bVar.f100250a.f100239f = huiYanOperateBody3.getTuringVersion();
        bVar.f100250a.f100238e = huiYanOperateBody3.getYouTuVersion();
        bVar.f100250a.f100236c = Build.BRAND;
        initAndGetConfig(context);
        b.a.f100131a.f100128a = PRE_PAGE_ClASS_NAME;
        initInputDataCallback();
        com.tencent.could.huiyansdk.manager.d dVar = d.b.f100161a;
        dVar.f100155a.setDeviceModel(DeviceInfoUtil.getDeviceModel());
        dVar.f100155a.setOsVersion("android-" + Build.VERSION.SDK_INT);
        dVar.f100155a.setSdkName("HuiYanSDK");
        dVar.f100155a.setSdkVersion("v1.0.9.31");
        BuriedPointBody buriedPointBody = dVar.f100155a;
        HuiYanBaseApi.b.f100031a.getClass();
        buriedPointBody.setYouTuVersion(YtSDKKitFramework.getInstance().version());
        dVar.f100155a.setTuringVersion(HuiYanSdkImp.getInstance().getTruingSdkVersion());
        dVar.f100156b = false;
        dVar.a(false);
        com.tencent.could.huiyansdk.common.a aVar = a.C1019a.f100038a;
        aVar.f100033b = "v1.0.9.31";
        aVar.f100036e = true;
    }

    private boolean isNeedShowProtocolPage(AuthConfig authConfig) {
        CustomerConfig customerConfig;
        if (authConfig == null || (customerConfig = authConfig.getCustomerConfig()) == null || !customerConfig.isHiddenProtocolPage()) {
            return true;
        }
        d.b.f100161a.a("ProtocolStage", "CustomerHideProtocolPage", "");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$tryToGetFaceIdToken$0(CustomerConfig customerConfig, Context context) {
        if (createFaceIdToken()) {
            String faceIdToken = this.commonDataCache.getCustomerTokenEntity().getFaceIdToken();
            com.tencent.could.huiyansdk.manager.d dVar = d.b.f100161a;
            dVar.f100155a.setFaceIdToken(faceIdToken);
            startGetCustomerConfig(customerConfig);
            dVar.f100155a.setNetWorkType(HYPCommonUtils.getNetWorkTypeState(context));
        }
    }

    private void startGetCustomerConfig(CustomerConfig customerConfig) {
        if (customerConfig == null) {
            k.a.f100197a.a(2, TAG, "customer config is null!");
            return;
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            commonDataCache.setCustomerConfig(customerConfig);
        }
        String authTips = customerConfig.getAuthTips();
        if (TextUtils.isEmpty(authTips)) {
            k.a.f100197a.a(2, "HuiYanSenderHelper", "auth tips is empty!");
            return;
        }
        if (authTips.length() > 100) {
            k.a.f100197a.a(2, "HuiYanSenderHelper", "authTips length check > 100");
            return;
        }
        TwoTuple<String, String> requestConnectIp = HYPCommonUtils.getRequestConnectIp(false);
        String tokenUrl = HYPCommonUtils.getTokenUrl(requestConnectIp.first + "/api/v2/data/text");
        String tokenUrl2 = HYPCommonUtils.getTokenUrl(requestConnectIp.second + "/api/v2/data/text");
        String tokenUrl3 = HYPCommonUtils.getTokenUrl("https://121.14.78.51/api/v2/data/text");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hint", authTips);
            TXCHttp.sendRequest(NetWorkParam.NetWorkParamBuilder.newBuilder().setHttpMethod(HttpMethod.POST).setGzip(true).setUrl(tokenUrl).setDeputyUrl(tokenUrl2).setBackUpIpStringUrl(tokenUrl3).setHttpsVerifyHost("sdk.faceid.qq.com").setRequestData(jSONObject.toString()).createNetWorkParam(), new h(customerConfig));
        } catch (JSONException e16) {
            k.a.f100197a.a(2, "HuiYanSenderHelper", "get config error: " + e16.getLocalizedMessage());
        }
    }

    private void tryToGetFaceIdToken(final CustomerConfig customerConfig) {
        final Context a16 = HuiYanBaseApi.b.f100031a.a();
        if (a16 != null) {
            com.tencent.could.huiyansdk.manager.d dVar = d.b.f100161a;
            dVar.f100155a.setDeviceToken(DeviceInfoUtil.getDeviceUuid(a16));
            dVar.f100155a.setPackageName(a16.getPackageName());
            String packageName = a16.getPackageName();
            dVar.f100155a.setPackageName(packageName);
            try {
                dVar.f100155a.setPackageVersion(InstalledAppListMonitor.getPackageInfo(a16.getPackageManager(), packageName, 0).versionName);
            } catch (PackageManager.NameNotFoundException e16) {
                k.a.f100197a.a(2, "BuriedPointManager", "get package info error: " + e16.getLocalizedMessage());
            }
        }
        q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.api.a
            @Override // java.lang.Runnable
            public final void run() {
                HuiYanAuthImp.this.lambda$tryToGetFaceIdToken$0(customerConfig, a16);
            }
        });
    }

    private void updateLocalCustomerTokenEntity(String str) {
        Log.e(TAG, "update: customer token: " + str);
        this.commonDataCache.updateCustomerTokenEntity(true, str);
        HuiYanOperateBody huiYanOperateBody = c.b.f100258a.f100252a;
        if (huiYanOperateBody != null) {
            huiYanOperateBody.setToken(str);
        }
    }

    public void cleanCommonDataListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            commonDataCache.setResultListener(null);
        }
    }

    public boolean createFaceIdToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.createFaceIdToken == null) {
            return false;
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null && commonDataCache.getCustomerTokenEntity() != null && !TextUtils.isEmpty(this.commonDataCache.getCustomerTokenEntity().getFaceIdToken())) {
            k.a.f100197a.a(1, TAG, "already get token before!");
            return true;
        }
        String customerFaceIdToken = this.createFaceIdToken.getCustomerFaceIdToken();
        if (TextUtils.isEmpty(customerFaceIdToken)) {
            return false;
        }
        updateLocalCustomerTokenEntity(customerFaceIdToken);
        c cVar = c.b.f100258a;
        Context a16 = HuiYanBaseApi.b.f100031a.a();
        HuiYanOperateBody huiYanOperateBody = cVar.f100252a;
        if (huiYanOperateBody != null) {
            huiYanOperateBody.setNetWorkType(HYPCommonUtils.getNetWorkTypeState(a16));
        }
        return true;
    }

    public void doNoticeCustomConfigSuccess(CustomerConfig customerConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) customerConfig);
            return;
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            commonDataCache.setCustomerConfig(customerConfig);
            this.commonDataCache.onConfigListenerSuccess();
        }
    }

    public HuiYanAuthResultListener getAuthResultListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (HuiYanAuthResultListener) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.commonDataCache.getResultListener();
    }

    public CommonDataCache getCommonDataCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (CommonDataCache) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.commonDataCache;
    }

    public CreateFaceIdToken getCreateFaceIdToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (CreateFaceIdToken) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.createFaceIdToken;
    }

    public CustomerConfig getCurrentCustomerConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (CustomerConfig) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache == null) {
            return null;
        }
        return commonDataCache.getCustomerConfig();
    }

    public void getDoOnFail(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) str);
            return;
        }
        k.a.f100197a.a(2, TAG, "error code: " + i3 + " error msg: " + str);
        HuiYanAuthResultListener authResultListener = getAuthResultListener();
        if (authResultListener != null) {
            authResultListener.onFail(i3, str, HYPCommonUtils.getFaceIdToken());
        }
        c cVar = c.b.f100258a;
        cVar.a(i3, str);
        getInstance().cleanCommonDataListener();
        com.tencent.could.huiyansdk.manager.d dVar = d.b.f100161a;
        dVar.a(dVar.a(), false, (File) null);
        cVar.a(cVar.a(), false, null);
    }

    public PageColorStyle getPageColorStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (PageColorStyle) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        AuthConfig authConfig = this.authConfig;
        if (authConfig == null) {
            return PageColorStyle.Light;
        }
        return authConfig.getPageColorStyle();
    }

    public String getPubKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            return commonDataCache.getPubKey();
        }
        return "";
    }

    public String getTuringActiveParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            return commonDataCache.getTuringActiveParam();
        }
        return "";
    }

    public String getTuringFrameResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        TuringResultCacheEntity turingResultCacheEntity = f.a.f100288a.f100277f;
        if (turingResultCacheEntity != null) {
            return turingResultCacheEntity.getTuringFrameResult();
        }
        return "";
    }

    public String getTuringResultDate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        TuringResultCacheEntity turingResultCacheEntity = f.a.f100288a.f100277f;
        if (turingResultCacheEntity != null) {
            return turingResultCacheEntity.getTuringResultDate();
        }
        k.a.f100197a.a(2, TAG, "turing result cache entity is null.");
        return "";
    }

    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "v1.0.9.31";
    }

    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            HuiYanSdk.init(context);
            initOthers(context);
        }
    }

    public void initNoLoadLibs(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else {
            HuiYanSdk.initNoLoadLibs(context);
            initOthers(context);
        }
    }

    public boolean isNeedFrameCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        TuringResultCacheEntity turingResultCacheEntity = f.a.f100288a.f100277f;
        if (turingResultCacheEntity != null) {
            return turingResultCacheEntity.isNeedFrameCheck();
        }
        return false;
    }

    public boolean isOpenEncrypt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        AuthConfig authConfig = this.authConfig;
        if (authConfig != null) {
            return authConfig.isUseEncrypt();
        }
        return false;
    }

    public void onCameraCheckResult(CameraDemoRes cameraDemoRes, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) cameraDemoRes, i3);
            return;
        }
        k.a.f100197a.a(1, TAG, "onCameraCheckResult: " + cameraDemoRes + " type:" + i3);
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        l.a.f100309a.f100308b = false;
        AiLog.release();
        k.a.f100197a.b();
        this.commonDataCache.reset();
        if (this.createFaceIdToken != null) {
            this.createFaceIdToken = null;
        }
        if (this.eventAuthCallback != null) {
            this.eventAuthCallback = null;
        }
        if (this.huiYanAuthEventCallBack != null) {
            this.huiYanAuthEventCallBack = null;
        }
        if (this.publicEventCallBack != null) {
            this.publicEventCallBack = null;
        }
    }

    public void sendOnLoadingEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        HuiYanEventAuthCallback huiYanEventAuthCallback = this.eventAuthCallback;
        if (huiYanEventAuthCallback != null) {
            huiYanEventAuthCallback.onLoadingSuccess();
        }
    }

    public void sendOnStartLoading(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) activity);
            return;
        }
        HuiYanEventAuthCallback huiYanEventAuthCallback = this.eventAuthCallback;
        if (huiYanEventAuthCallback != null) {
            huiYanEventAuthCallback.onStartLoading(activity);
        }
    }

    public void sendPublicEvent(HuiYanPublicEvent huiYanPublicEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) huiYanPublicEvent);
        } else if (this.publicEventCallBack != null) {
            q.a.f100321a.a(new Runnable(huiYanPublicEvent) { // from class: com.tencent.could.huiyansdk.api.HuiYanAuthImp.5
                static IPatchRedirector $redirector_;
                public final /* synthetic */ HuiYanPublicEvent val$huiYanPublicEvent;

                {
                    this.val$huiYanPublicEvent = huiYanPublicEvent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HuiYanAuthImp.this, (Object) huiYanPublicEvent);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        synchronized (HuiYanAuthImp.this.lock) {
                            if (HuiYanAuthImp.this.publicEventCallBack == null) {
                                return;
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("platform", 2);
                                jSONObject.put("publicEvent", this.val$huiYanPublicEvent);
                                HuiYanAuthImp.this.publicEventCallBack.mainAuthEvent(jSONObject.toString());
                                return;
                            } catch (JSONException e16) {
                                k.a.f100197a.a(2, HuiYanAuthImp.TAG, "json error: " + e16.getLocalizedMessage());
                                HuiYanAuthImp.this.publicEventCallBack.mainAuthEvent("{\"platform\":2,\"publicEvent\":\"NONE\"}");
                                return;
                            }
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    public void setAuthEventCallBack(HuiYanAuthEventCallBack huiYanAuthEventCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) huiYanAuthEventCallBack);
        } else if (huiYanAuthEventCallBack == null) {
            k.a.f100197a.a(2, TAG, "error set huiyan auth event callback is null!");
        } else {
            this.huiYanAuthEventCallBack = huiYanAuthEventCallBack;
            HuiYanSdk.setHuiYanSdkEventCallback(new HuiYanSdkEventCallBack() { // from class: com.tencent.could.huiyansdk.api.HuiYanAuthImp.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HuiYanAuthImp.this);
                    }
                }

                @Override // com.tencent.could.huiyansdk.api.HuiYanSdkEventCallBack
                public void onAuthEvent(HuiYanAuthEvent huiYanAuthEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) huiYanAuthEvent);
                    } else if (HuiYanAuthImp.this.huiYanAuthEventCallBack != null) {
                        HuiYanAuthImp.this.huiYanAuthEventCallBack.onAuthEvent(huiYanAuthEvent);
                    }
                }

                @Override // com.tencent.could.huiyansdk.api.HuiYanSdkEventCallBack
                public void onAuthTipsEvent(HuiYanAuthTipsEvent huiYanAuthTipsEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) huiYanAuthTipsEvent);
                    } else if (HuiYanAuthImp.this.huiYanAuthEventCallBack != null) {
                        HuiYanAuthImp.this.huiYanAuthEventCallBack.onAuthTipsEvent(huiYanAuthTipsEvent);
                    }
                }

                @Override // com.tencent.could.huiyansdk.api.HuiYanSdkEventCallBack
                public void onBeginTransition() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                        iPatchRedirector2.redirect((short) 6, (Object) this);
                    }
                }

                @Override // com.tencent.could.huiyansdk.api.HuiYanSdkEventCallBack
                public void onEndTransition() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                        iPatchRedirector2.redirect((short) 7, (Object) this);
                    }
                }

                @Override // com.tencent.could.huiyansdk.api.HuiYanSdkEventCallBack
                public void onMainViewCreate(View view) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) view);
                    } else if (HuiYanAuthImp.this.huiYanAuthEventCallBack != null) {
                        HuiYanAuthImp.this.huiYanAuthEventCallBack.onMainViewCreate(view);
                    }
                }

                @Override // com.tencent.could.huiyansdk.api.HuiYanSdkEventCallBack
                public void onMainViewDestroy() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this);
                    } else if (HuiYanAuthImp.this.huiYanAuthEventCallBack != null) {
                        HuiYanAuthImp.this.huiYanAuthEventCallBack.onMainViewDestroy();
                    }
                }
            });
        }
    }

    public void setConfigEntity(ConfigEntity configEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configEntity);
            return;
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            commonDataCache.setConfigEntity(configEntity);
        }
    }

    public void setFaceIdTokenCreateFunction(CreateFaceIdToken createFaceIdToken) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) createFaceIdToken);
        } else {
            this.createFaceIdToken = createFaceIdToken;
        }
    }

    public void setHuiYanEventListener(HuiYanEventAuthCallback huiYanEventAuthCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) huiYanEventAuthCallback);
        } else {
            this.eventAuthCallback = huiYanEventAuthCallback;
        }
    }

    public void setHuiYanPublicEventCallBack(HuiYanPublicEventCallBack huiYanPublicEventCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) huiYanPublicEventCallBack);
        } else {
            this.publicEventCallBack = huiYanPublicEventCallBack;
        }
    }

    public void setOperationModeConfig(OperationModeConfig operationModeConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) operationModeConfig);
            return;
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            commonDataCache.setOperationModeConfig(operationModeConfig);
        }
    }

    public void setPubKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
            return;
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            commonDataCache.setPubKey(str);
        }
    }

    public void setShouldShowCustomerTxt(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
            return;
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            commonDataCache.setShouldShowCustomerTxt(z16);
        }
    }

    public void setTuringActiveParam(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            commonDataCache.setTuringActiveParam(str);
        }
    }

    public void setTuringRiskSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        CommonDataCache commonDataCache = this.commonDataCache;
        if (commonDataCache != null) {
            commonDataCache.setStreamRiskDataFinish(true);
        }
    }

    public void startHuiYanAuth(AuthConfig authConfig, HuiYanAuthResultListener huiYanAuthResultListener) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) authConfig, (Object) huiYanAuthResultListener);
            return;
        }
        this.authConfig = authConfig;
        this.commonDataCache.reset();
        d.b.f100161a.f100155a.resetActionDate();
        c cVar = c.b.f100258a;
        Map<String, Long> map = cVar.f100253b;
        if (map != null) {
            map.clear();
        }
        HuiYanOperateBody huiYanOperateBody = cVar.f100252a;
        if (huiYanOperateBody != null) {
            huiYanOperateBody.reset();
        }
        com.tencent.could.huiyansdk.common.a aVar = a.C1019a.f100038a;
        aVar.f100035d = "";
        boolean z17 = false;
        aVar.f100034c = false;
        this.commonDataCache.setResultListener(huiYanAuthResultListener);
        HuiYanSdk.setHuiYanSdkExtraCallBack(new HuiYanExtraCallBack() { // from class: com.tencent.could.huiyansdk.api.HuiYanAuthImp.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HuiYanAuthImp.this);
                }
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanExtraCallBack
            public void onBuriedPointCallBack(String str, String str2, String str3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, str, str2, str3);
                    return;
                }
                com.tencent.could.huiyansdk.manager.d dVar = d.b.f100161a;
                dVar.a(str, str2, str3);
                if ("CrashStage".equals(str)) {
                    dVar.a(dVar.a());
                }
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanExtraCallBack
            public void onCameraInfoStr(int i3, boolean z18) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 9)) {
                    iPatchRedirector2.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z18));
                }
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanExtraCallBack
            public void onCameraRiskData(Map<RiskCameraType, RiskDemoImage> map2, int i3) {
                CameraRiskChangeInfo cameraRiskChangeStageReflect;
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                    iPatchRedirector2.redirect((short) 8, (Object) this, (Object) map2, i3);
                    return;
                }
                if (HuiYanSdkImp.getInstance().getSdkConfig() == null) {
                    k.a.f100197a.a(2, "HuiYanSenderHelper", "sendOnCameraRiskData huiYanSdkConfig is null!");
                    return;
                }
                CameraRiskParamConfig cameraRiskParamConfig = HuiYanSdkImp.getInstance().getCameraRiskParamConfig();
                if (cameraRiskParamConfig == null) {
                    k.a.f100197a.a(2, "HuiYanSenderHelper", "sendOnCameraRiskData cameraRiskParamConfig is null");
                    return;
                }
                CameraDemoReq cameraDemoReq = new CameraDemoReq();
                if (i3 == 1) {
                    cameraRiskChangeStageReflect = cameraRiskParamConfig.getCameraRiskChangeStageStart();
                } else {
                    cameraRiskChangeStageReflect = cameraRiskParamConfig.getCameraRiskChangeStageReflect();
                }
                if (cameraRiskChangeStageReflect == null) {
                    k.a.f100197a.a(2, "HuiYanSenderHelper", "sendOnCameraRiskData cameraRiskChangeInfo is null");
                    return;
                }
                if (Math.abs(cameraRiskChangeStageReflect.getExposure() - (-10.0f)) >= 1.0E-6f) {
                    cameraDemoReq.setExposure(cameraRiskChangeStageReflect.getRealExposure());
                }
                cameraDemoReq.setDelayTime(cameraRiskChangeStageReflect.getDelay());
                if (!TextUtils.isEmpty(cameraRiskChangeStageReflect.getWhiteBalance())) {
                    cameraDemoReq.setWhiteBalance(cameraRiskChangeStageReflect.getWhiteBalance());
                }
                if (cameraRiskChangeStageReflect.getNetZoom() != -1) {
                    cameraDemoReq.setFaceZoom(cameraRiskChangeStageReflect.getRealZoom());
                }
                if (i3 == 1) {
                    str = "start";
                } else {
                    str = "reflect";
                }
                cameraDemoReq.setStage(str);
                CameraDemoRes cameraDemoRes = new CameraDemoRes();
                for (Map.Entry<RiskCameraType, RiskDemoImage> entry : map2.entrySet()) {
                    RiskCameraType key = entry.getKey();
                    RiskDemoImage value = entry.getValue();
                    int ordinal = key.ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 1) {
                            if (ordinal != 2) {
                                if (ordinal == 3) {
                                    cameraDemoRes.setCheckWhite(true);
                                    cameraDemoReq.setWhiteImage(value);
                                }
                            } else {
                                cameraDemoRes.setCheckFace(true);
                                cameraDemoReq.setZoomImage(value);
                            }
                        } else {
                            cameraDemoRes.setCheckExposure(true);
                            cameraDemoReq.setExposureImage(value);
                        }
                    } else {
                        cameraDemoReq.setBaseImage(value);
                    }
                }
                String json = new Gson().toJson(cameraDemoReq);
                String str2 = null;
                if (TextUtils.isEmpty(json)) {
                    k.a.f100197a.a(2, "CameraDataEncryptHelper", "encodeCameraInfo: " + json);
                } else {
                    int nextInt = new Random().nextInt(10);
                    try {
                        byte[] encryptAESEncode = CommonUtils.encryptAESEncode(CommonUtils.hexStringToBytes(com.tencent.could.huiyansdk.utils.c.f100300a[nextInt]), CommonUtils.hexStringToBytes(com.tencent.could.huiyansdk.utils.c.f100301b[nextInt]), json.getBytes());
                        byte[] bArr = new byte[encryptAESEncode.length + 2];
                        bArr[0] = 1;
                        bArr[1] = (byte) nextInt;
                        System.arraycopy(encryptAESEncode, 0, bArr, 2, encryptAESEncode.length);
                        str2 = Base64.encodeToString(bArr, 2);
                    } catch (Exception e16) {
                        k.a.f100197a.a(2, "CameraDataEncryptHelper", "CameraData e: " + e16.getLocalizedMessage());
                    }
                }
                List<String> list = f.a.f100180a.f100176n;
                if (list != null) {
                    list.add(str2);
                }
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanExtraCallBack
            public void onLiveDataCallBackInfo(String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 10)) {
                    iPatchRedirector2.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
                    return;
                }
                if (HuiYanAuthImp.this.commonDataCache != null) {
                    if ("selectData".equals(str)) {
                        HuiYanAuthImp.this.commonDataCache.setSelectData(str2);
                        return;
                    } else {
                        if (PublicAccountMessageUtilImpl.ITEM_ACTION_DATA.equals(str)) {
                            HuiYanAuthImp.this.commonDataCache.setActionData(str2);
                            return;
                        }
                        return;
                    }
                }
                k.a.f100197a.a(1, HuiYanAuthImp.TAG, "common data cache is null");
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanExtraCallBack
            public void onOperateTimeEvent(String str, int i3, boolean z18, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, this, str, Integer.valueOf(i3), Boolean.valueOf(z18), str2);
                } else {
                    c.b.f100258a.a(str, i3, z18, str2);
                }
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanExtraCallBack
            public void onPrepare(HuiYanOperationConfigCallBack huiYanOperationConfigCallBack) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, (Object) this, (Object) huiYanOperationConfigCallBack);
                    return;
                }
                String faceIdToken = HYPCommonUtils.getFaceIdToken();
                j jVar = new j(huiYanOperationConfigCallBack);
                k.a.f100197a.a(2, "HuiYanSenderHelper", ">>>start get config");
                c.b.f100258a.a("GetConfigDataUseTime", 1, false, "");
                TwoTuple<String, String> requestConnectIp = HYPCommonUtils.getRequestConnectIp(true);
                String str = requestConnectIp.first + "/api/v2/getConfig?FaceIdToken=" + faceIdToken;
                String str2 = requestConnectIp.second + "/api/v2/getConfig?FaceIdToken=" + faceIdToken;
                String str3 = "https://121.14.78.51/api/v2/getConfig?FaceIdToken=" + faceIdToken;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("enable_secret_key", HuiYanAuthImp.getInstance().isOpenEncrypt());
                    if (l.a.f100309a.f100307a) {
                        AiLog.debug("HuiYanSenderHelper", "start getOperationModeConfig");
                    }
                    TXCHttp.sendRequest(NetWorkParam.NetWorkParamBuilder.newBuilder().setUrl(str).setHttpMethod(HttpMethod.POST).setRequestHeaders(null).setGzip(true).setDeputyUrl(str2).setHttpsVerifyHost("sdk.faceid.qq.com").setBackUpIpStringUrl(str3).setRequestData(jSONObject.toString()).createNetWorkParam(), new g(jVar));
                } catch (JSONException e16) {
                    k.a.f100197a.a(2, "HuiYanSenderHelper", "get config error: " + e16.getLocalizedMessage());
                }
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanExtraCallBack
            public void onStreamRiskDataSuccess(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                k.a.f100197a.a(1, HuiYanAuthImp.TAG, "onStreamRiskDataSuccess: " + str.length());
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanExtraCallBack
            public void onTuringFaceDataSuccess(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this, (Object) str);
                }
            }

            @Override // com.tencent.could.huiyansdk.api.HuiYanExtraCallBack
            public void updateOperateInfo(String str, int i3, long j3, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2);
                } else {
                    c.b.f100258a.a(str, i3, j3, str2);
                }
            }
        });
        tryToGetFaceIdToken(authConfig.getCustomerConfig());
        HuiYanSdk.setAuthUiConfig(createAuthUiConfig(authConfig));
        if (!isNeedShowProtocolPage(authConfig)) {
            b.a.f100131a.f100128a = "";
        }
        com.tencent.could.huiyansdk.operate.b bVar = b.a.f100251a;
        Context a16 = HuiYanBaseApi.b.f100031a.a();
        bVar.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.could.huiyansdk.operate.a aVar2 = bVar.f100250a;
        TelephonyManager telephonyManager = (TelephonyManager) a16.getSystemService("phone");
        if (telephonyManager != null && telephonyManager.getSimState() != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar2.f100247n = z16;
        bVar.f100250a.f100242i = HYPCommonUtils.getNetWorkTypeState(a16);
        com.tencent.could.huiyansdk.operate.a aVar3 = bVar.f100250a;
        try {
            if (Settings.Secure.getInt(a16.getContentResolver(), "accessibility_enabled") == 1) {
                z17 = true;
            }
        } catch (Settings.SettingNotFoundException unused) {
        }
        aVar3.f100248o = z17;
        Log.e("DeviceInfoHelper", "use time: " + (System.currentTimeMillis() - currentTimeMillis));
        HuiYanSdk.startHuiYanCheck(createHuiYanConfig(authConfig), new AnonymousClass3());
    }

    HuiYanAuthImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.lock = new Object();
            this.commonDataCache = new CommonDataCache();
        }
    }
}
