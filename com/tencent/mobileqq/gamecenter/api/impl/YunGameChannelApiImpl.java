package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.HandlerCompat;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.IMidasLogCallback;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.YunGameRuntime;
import com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.gamecenter.api.IYunGameManagerService;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.inner.auth.QQAuth;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize$AuthorizeRequest;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize$AuthorizeResponse;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.turingfd.sdk.xq.ITuringDID;
import eipc.EIPCResult;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class YunGameChannelApiImpl implements IYunGameChannelApi {
    public static final String APPID = "101477677";
    public static final String GAME_CENTER_DOMAINID = "323";
    private static final String KEY_YUNGAME_MIDAS_ENV_CFG = "key_yungame_midas_env_config";
    public static final String MIDAS_OFFER_ID = "1450023385";
    public static final String TAG = "YunGameChannelApiImpl";
    public static final long TIME_OUT_DELAY = 30000;
    private c mIpcModule;
    protected NewIntent mNewIntent = null;
    wp3.b openListener;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IYunGameChannelApi.PermissionHandler f211888a;

        a(IYunGameChannelApi.PermissionHandler permissionHandler) {
            this.f211888a = permissionHandler;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.i(YunGameChannelApiImpl.TAG, 1, "[requestPermissions] GRANTED===");
            IYunGameChannelApi.PermissionHandler permissionHandler = this.f211888a;
            if (permissionHandler != null) {
                permissionHandler.onAllGranted();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QLog.i(YunGameChannelApiImpl.TAG, 1, "[requestPermissions] DENIED===");
            IYunGameChannelApi.PermissionHandler permissionHandler = this.f211888a;
            if (permissionHandler != null) {
                permissionHandler.onDenied(list, list2);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
            QLog.i(YunGameChannelApiImpl.TAG, 1, "[requestPermissions] onDialogShow===");
            IYunGameChannelApi.PermissionHandler permissionHandler = this.f211888a;
            if (permissionHandler != null) {
                permissionHandler.onDialogShow(permissionRequestDialog, list);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onViewShow(PermissionRequestView permissionRequestView, List<String> list) {
            super.onViewShow(permissionRequestView, list);
            QLog.i(YunGameChannelApiImpl.TAG, 1, "[requestPermissions] onViewShow===");
            IYunGameChannelApi.PermissionHandler permissionHandler = this.f211888a;
            if (permissionHandler != null) {
                permissionHandler.onViewShow(permissionRequestView, list);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b implements IYunGameChannelApi.ResultHandler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<wp3.b> f211890a;

        public b(wp3.b bVar) {
            this.f211890a = new WeakReference<>(bVar);
        }

        @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.ResultHandler
        public void onActivityResult(int i3, int i16, Intent intent) {
            QLog.i(YunGameChannelApiImpl.TAG, 1, "[onActivityResult] onActivityResult======");
            wp3.b bVar = this.f211890a.get();
            if (bVar != null) {
                bVar.onActivityResult(i3, i16, intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c extends QIPCModule {
        public c(String str) {
            super(str);
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            QLog.e(YunGameChannelApiImpl.TAG, 1, "[onCall] action:" + str + ", callId:" + i3);
            IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) HippyUtils.getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            if (iYunGameManagerService == null) {
                return null;
            }
            return iYunGameManagerService.onCall(str, bundle, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d implements IMidasLogCallback {
        @Override // com.tencent.midas.api.IMidasLogCallback
        public void onLogging(int i3, String str, String str2) {
            String str3 = "YunGameChannelApiImpl_" + str;
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (QLog.isColorLevel()) {
                            QLog.d(str3, 4, str2);
                            return;
                        }
                        return;
                    }
                    QLog.e(str3, 1, str2);
                    return;
                }
                QLog.w(str3, 1, str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(str3, 2, str2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class e extends wp3.b {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<IYunGameChannelApi.AuthResult> f211891a;

        public e(IYunGameChannelApi.AuthResult authResult) {
            this.f211891a = new WeakReference<>(authResult);
        }

        @Override // wp3.b
        public void onCancel() {
            IYunGameChannelApi.AuthResult authResult = this.f211891a.get();
            if (authResult != null) {
                authResult.onCancel();
            }
        }

        @Override // wp3.b
        public void onComplete(Object obj) {
            IYunGameChannelApi.AuthResult authResult = this.f211891a.get();
            if (authResult != null) {
                authResult.onComplete(obj);
            }
        }

        @Override // wp3.b
        public void onError(wp3.a aVar) {
            IYunGameChannelApi.AuthResult authResult = this.f211891a.get();
            if (authResult != null) {
                authResult.onError(aVar);
            }
        }

        @Override // wp3.b
        public void onWarning(int i3) {
            IYunGameChannelApi.AuthResult authResult = this.f211891a.get();
            if (authResult != null) {
                authResult.onWarning(i3);
            }
        }
    }

    public YunGameChannelApiImpl() {
        QLog.e(TAG, 1, "[YunGameChannelApiImpl] init....");
        this.mIpcModule = new c(IYunGameConstant.IPC_NAME);
    }

    private void doHandleGetKeysReq(final String str, final IYunGameChannelApi.OnGetLaunchKeyListener onGetLaunchKeyListener, AppRuntime appRuntime, com.tencent.open.appcommon.d dVar) {
        long j3;
        FastAuthorize$AuthorizeRequest fastAuthorize$AuthorizeRequest = new FastAuthorize$AuthorizeRequest();
        long j16 = 0;
        try {
            j3 = Long.parseLong(appRuntime.getCurrentAccountUin());
        } catch (Exception unused) {
            j3 = 0;
        }
        fastAuthorize$AuthorizeRequest.uin.set(j3);
        try {
            j16 = Long.parseLong(str);
        } catch (Exception unused2) {
        }
        fastAuthorize$AuthorizeRequest.client_id.set(j16);
        fastAuthorize$AuthorizeRequest.f342472pf.set("");
        fastAuthorize$AuthorizeRequest.qqv.set(getApkVersionName(MobileQQ.sMobileQQ));
        fastAuthorize$AuthorizeRequest.sdkp.set("a");
        fastAuthorize$AuthorizeRequest.f342471os.set(Build.DISPLAY);
        fastAuthorize$AuthorizeRequest.flags.set(7);
        try {
            if (this.mNewIntent == null) {
                this.mNewIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.biz.m.class);
            }
            this.mNewIntent.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
            this.mNewIntent.putExtra("data", fastAuthorize$AuthorizeRequest.toByteArray());
            this.mNewIntent.setObserver(dVar);
            appRuntime.startServlet(this.mNewIntent);
            HandlerCompat.postDelayed(ThreadManagerV2.getUIHandlerV2(), new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.YunGameChannelApiImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    QLog.e(YunGameChannelApiImpl.TAG, 1, "[startGetLaunchKeys] overTime");
                    YunGameChannelApiImpl.this.resetGetKeysIntent();
                    onGetLaunchKeyListener.onResult("", "", "", str);
                }
            }, onGetLaunchKeyListener, 30000L);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage());
            }
            resetGetKeysIntent();
            onGetKeysFailed(onGetLaunchKeyListener, str);
        }
    }

    private static String getApkVersionName(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getApkVersionName error:", e16);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetKeysFailed(final IYunGameChannelApi.OnGetLaunchKeyListener onGetLaunchKeyListener, final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.YunGameChannelApiImpl.4
            @Override // java.lang.Runnable
            public void run() {
                onGetLaunchKeyListener.onResult("", "", "", str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetGetKeysIntent() {
        NewIntent newIntent = this.mNewIntent;
        if (newIntent != null) {
            newIntent.setObserver(null);
            this.mNewIntent = null;
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi
    public AppRuntime createAppInterface(MobileQQ mobileQQ, String str) {
        QLog.d(TAG, 1, "createAppInterface application=" + mobileQQ + ",processName=" + str);
        return new YunGameRuntime(mobileQQ, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00fb A[Catch: JSONException -> 0x0144, TryCatch #0 {JSONException -> 0x0144, blocks: (B:8:0x0031, B:10:0x00fb, B:12:0x010b, B:14:0x0111, B:16:0x012a, B:17:0x013f), top: B:7:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x012a A[Catch: JSONException -> 0x0144, TryCatch #0 {JSONException -> 0x0144, blocks: (B:8:0x0031, B:10:0x00fb, B:12:0x010b, B:14:0x0111, B:16:0x012a, B:17:0x013f), top: B:7:0x0031 }] */
    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDeviceInfo() {
        String str;
        String str2;
        String string;
        String model = DeviceInfoMonitor.getModel();
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.FINGERPRINT;
        String str5 = Build.VERSION.INCREMENTAL;
        String str6 = Build.BRAND;
        String str7 = Build.BOARD;
        String str8 = Build.MANUFACTURER;
        String str9 = Build.HARDWARE;
        try {
            str = com.tencent.mobileqq.statistics.o.b();
        } catch (Exception unused) {
            str = "";
        }
        try {
            str2 = com.tencent.mobileqq.statistics.o.c();
        } catch (Exception unused2) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "get QIMEI fail");
            }
            str2 = "";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("model", model);
            jSONObject.put("brand", str6);
            jSONObject.put("board", str7);
            jSONObject.put("manufacturer", str8);
            jSONObject.put("hardware", str9);
            jSONObject.put("imei", MobileInfoUtil.getImei());
            jSONObject.put("systemName", "android");
            jSONObject.put("systemVersion", str3);
            jSONObject.put("isMobileQQ", true);
            jSONObject.put(IECDtReport.ACTION_IDENTIFIER, "");
            jSONObject.put("fingerprint", str4);
            jSONObject.put("incremental", str5);
            jSONObject.put("macAddress", MobileInfoUtil.getLocalMacAddress());
            jSONObject.put("androidId", "");
            jSONObject.put(MobileInfoUtil.IMSI, com.tencent.mobileqq.utils.ah.A());
            jSONObject.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, str);
            jSONObject.put("qimei36", str2);
            jSONObject.put("totalMemory", String.valueOf(com.tencent.mobileqq.utils.m.c()));
            jSONObject.put("availableMemory", String.valueOf(com.tencent.mobileqq.utils.ah.X()));
            jSONObject.put("cpuType", com.tencent.mobileqq.utils.ah.o());
            jSONObject.put("cpuNum", com.tencent.mobileqq.utils.ah.n());
            jSONObject.put("cpuFreq", com.tencent.mobileqq.utils.ah.l());
            string = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getString(IYunGameConstant.KEY_OAID_CFG, "");
            if (TextUtils.isEmpty(string)) {
            }
            jSONObject.put("oaid", string);
            jSONObject.put("msfImei", MsfSdkUtils.getIMEIForMain(MsfSdkUtils.BUSINESS_ID_VIP_CUSTOMIZE_ONLINE_STATUS));
            if (QLog.isColorLevel()) {
            }
            return jSONObject.toString();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("model", model);
            jSONObject2.put("brand", str6);
            jSONObject2.put("board", str7);
            jSONObject2.put("manufacturer", str8);
            jSONObject2.put("hardware", str9);
            jSONObject2.put("imei", MobileInfoUtil.getImei());
            jSONObject2.put("systemName", "android");
            jSONObject2.put("systemVersion", str3);
            jSONObject2.put("isMobileQQ", true);
            jSONObject2.put(IECDtReport.ACTION_IDENTIFIER, "");
            jSONObject2.put("fingerprint", str4);
            jSONObject2.put("incremental", str5);
            jSONObject2.put("macAddress", MobileInfoUtil.getLocalMacAddress());
            jSONObject2.put("androidId", "");
            jSONObject2.put(MobileInfoUtil.IMSI, com.tencent.mobileqq.utils.ah.A());
            jSONObject2.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, str);
            jSONObject2.put("qimei36", str2);
            jSONObject2.put("totalMemory", String.valueOf(com.tencent.mobileqq.utils.m.c()));
            jSONObject2.put("availableMemory", String.valueOf(com.tencent.mobileqq.utils.ah.X()));
            jSONObject2.put("cpuType", com.tencent.mobileqq.utils.ah.o());
            jSONObject2.put("cpuNum", com.tencent.mobileqq.utils.ah.n());
            jSONObject2.put("cpuFreq", com.tencent.mobileqq.utils.ah.l());
            string = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getString(IYunGameConstant.KEY_OAID_CFG, "");
            if (TextUtils.isEmpty(string)) {
                QLog.i(TAG, 1, "[getDeviceInfo] oaid is empty. get from turingSdk");
                ITuringDID c16 = com.tencent.mobileqq.turingfd.c.a().c(true);
                if (c16 != null) {
                    string = c16.getAIDTicket();
                } else {
                    string = null;
                }
            }
            jSONObject2.put("oaid", string);
            jSONObject2.put("msfImei", MsfSdkUtils.getIMEIForMain(MsfSdkUtils.BUSINESS_ID_VIP_CUSTOMIZE_ONLINE_STATUS));
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "[getDeviceInfo] json:" + jSONObject2);
            }
            return jSONObject2.toString();
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "getDeviceInfo error:" + e16);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi
    public QIPCModule getIPCModule() {
        return this.mIpcModule;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi
    public void initMidas(Context context, String str, String str2, String str3) {
        QLog.i(TAG, 1, "[initMidas] =====deviceId:" + str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[initMidas] offerId:1450023385, uin:" + str2 + ", skey:" + str3);
        }
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        aPMidasGameRequest.setOfferId("1450023385");
        aPMidasGameRequest.setOpenId(str2);
        aPMidasGameRequest.setOpenKey(str3);
        aPMidasGameRequest.setSessionId("uin");
        aPMidasGameRequest.setSessionType("pskey_323");
        aPMidasGameRequest.setZoneId("1");
        aPMidasGameRequest.reserv = String.format("linkid=%s&cloud_platform=client", str);
        if (QMMKV.fromV2(context, "common_mmkv_configurations").getBoolean(KEY_YUNGAME_MIDAS_ENV_CFG, false)) {
            aPMidasGameRequest.setPf("qq_m_qq-2013-android-537035451-mvip.pingtai.mobileqq.mywallet.00001");
            aPMidasGameRequest.setPfKey("pfKey");
            APMidasPayAPI.setEnv("test");
        }
        APMidasPayAPI.setLogEnable(false);
        APMidasPayAPI.setLogCallback(d.class);
        APMidasPayAPI.init(context, aPMidasGameRequest);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi
    public boolean isFoldDevice() {
        boolean z16;
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i(TAG, 1, "isFold:" + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi
    public void releaseMidas(Context context, String str, String str2) {
        QLog.i(TAG, 1, "[resetMidas] resetMidas======");
        if (context instanceof Activity) {
            APMidasPayAPI.release((Activity) context);
        } else {
            QLog.d(TAG, 1, "[releaseMidas] context is not activity");
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi
    public IYunGameChannelApi.ResultHandler requesetLogin(Context context, String str, String str2, String str3, String str4, IYunGameChannelApi.AuthResult authResult) {
        if (context instanceof Activity) {
            QQAuth.AuthParams authParams = new QQAuth.AuthParams(str, APPID, str3, "all");
            this.openListener = new e(authResult);
            QQAuth.getInstance().proxyAuth((Activity) context, this.openListener, authParams);
            return new b(this.openListener);
        }
        QLog.e(TAG, 1, "[requesetLogin] context err======");
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi
    public void requestPermission(Context context, String str, IYunGameChannelApi.PermissionHandler permissionHandler) {
        if (context instanceof Activity) {
            QQPermission qQPermission = QQPermissionFactory.getQQPermission((Activity) context, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_GAME_CENTER_VOICE, QQPermissionConstants.Business.SCENE.GAME_CENTER_YUNGAME_VOICE));
            if (qQPermission == null) {
                QLog.i(TAG, 1, "[onGmCgPlayEventVoiceSwitched] create qqPermission err");
                if (permissionHandler != null) {
                    permissionHandler.onFailed("qqPermission is null.");
                    return;
                }
                return;
            }
            if (qQPermission.hasPermission(str) == 0) {
                QLog.i(TAG, 1, "[onGmCgPlayEventVoiceSwitched] GRANTED===");
                if (permissionHandler != null) {
                    permissionHandler.onAllGranted();
                    return;
                }
                return;
            }
            qQPermission.requestPermissions(new String[]{str}, 2, new a(permissionHandler));
            return;
        }
        if (permissionHandler != null) {
            permissionHandler.onFailed("context is not activity.");
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi
    public void startGetLaunchKeys(final String str, final IYunGameChannelApi.OnGetLaunchKeyListener onGetLaunchKeyListener) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && !TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "[startGetLaunchKeys] appId:" + str);
            final long currentTimeMillis = System.currentTimeMillis();
            doHandleGetKeysReq(str, onGetLaunchKeyListener, peekAppRuntime, new com.tencent.open.appcommon.d() { // from class: com.tencent.mobileqq.gamecenter.api.impl.YunGameChannelApiImpl.2
                @Override // mqq.observer.BusinessObserver
                public void onReceive(int i3, boolean z16, Bundle bundle) {
                    if (QLog.isColorLevel()) {
                        QLog.d(YunGameChannelApiImpl.TAG, 2, "startGetLaunchKeys cost=" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    ThreadManagerV2.getUIHandlerV2().removeCallbacksAndMessages(onGetLaunchKeyListener);
                    if (!z16) {
                        YunGameChannelApiImpl.this.onGetKeysFailed(onGetLaunchKeyListener, str);
                        QLog.e("AppLaucherHelper", 1, "FastAuthorize.AuthorizeRequest failed");
                    } else {
                        byte[] byteArray = bundle.getByteArray("data");
                        try {
                            FastAuthorize$AuthorizeResponse fastAuthorize$AuthorizeResponse = new FastAuthorize$AuthorizeResponse();
                            fastAuthorize$AuthorizeResponse.mergeFrom(byteArray);
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("FastAuthorize.AuthorizeResponse=[");
                                sb5.append("ret=" + fastAuthorize$AuthorizeResponse.ret.get() + ", msg=" + fastAuthorize$AuthorizeResponse.f342473msg.get() + ", access_token=" + fastAuthorize$AuthorizeResponse.access_token.get() + ", expires_in=" + fastAuthorize$AuthorizeResponse.expires_in.get() + ", openid=" + fastAuthorize$AuthorizeResponse.openid.get() + ", pay_token=" + fastAuthorize$AuthorizeResponse.pay_token.get() + ", pf=" + fastAuthorize$AuthorizeResponse.f342474pf.get() + ", pfkey=" + fastAuthorize$AuthorizeResponse.pfkey.get() + ", encrykey=" + fastAuthorize$AuthorizeResponse.encrykey.get() + ", apk_name=" + fastAuthorize$AuthorizeResponse.apk_name.get() + ", ");
                                sb5.append("]");
                                QLog.d(YunGameChannelApiImpl.TAG, 2, sb5.toString());
                            }
                            if (fastAuthorize$AuthorizeResponse.ret.get().equals("0")) {
                                final String str2 = fastAuthorize$AuthorizeResponse.access_token.get();
                                final String str3 = fastAuthorize$AuthorizeResponse.pay_token.get();
                                final String str4 = fastAuthorize$AuthorizeResponse.openid.get();
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.YunGameChannelApiImpl.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        onGetLaunchKeyListener.onResult(str2, str3, str4, str);
                                    }
                                });
                            } else {
                                QLog.d(YunGameChannelApiImpl.TAG, 4, "start without login state");
                                YunGameChannelApiImpl.this.onGetKeysFailed(onGetLaunchKeyListener, str);
                            }
                        } catch (InvalidProtocolBufferMicroException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d(YunGameChannelApiImpl.TAG, 2, e16.getMessage());
                            }
                            YunGameChannelApiImpl.this.onGetKeysFailed(onGetLaunchKeyListener, str);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(getClass().getSimpleName(), 2, "lauchApp now");
                    }
                    YunGameChannelApiImpl.this.resetGetKeysIntent();
                }
            });
            return;
        }
        QLog.i(TAG, 1, "[startGetLaunchKeys] appRuntime:" + peekAppRuntime + ",appId:" + str);
    }
}
