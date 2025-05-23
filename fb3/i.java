package fb3;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.luggage.wxaapi.InitDynamicPkgResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.luggage.wxaapi.u;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IWeiXinMiniServiceAPI;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXPayHelper;
import com.tencent.mobileqq.wxmini.api.IWxMiniLibApi;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.impl.WxaSDKInit;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaPerformanceMetrics;
import com.tencent.mobileqq.wxmini.ui.WxMiniTipUserInfoFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.util.QQToastUtil;
import fb3.i;
import ib3.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i {

    /* renamed from: j, reason: collision with root package name */
    private static volatile i f398158j;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f398161m;

    /* renamed from: a, reason: collision with root package name */
    private WxaApi f398162a;

    /* renamed from: b, reason: collision with root package name */
    private String f398163b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f398164c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f398166e;

    /* renamed from: g, reason: collision with root package name */
    private Bundle f398168g;

    /* renamed from: i, reason: collision with root package name */
    private static AtomicInteger f398157i = new AtomicInteger(0);

    /* renamed from: k, reason: collision with root package name */
    private static final List<String> f398159k = Arrays.asList("getMeid", "getImei", "getDeviceId");

    /* renamed from: l, reason: collision with root package name */
    private static final List<String> f398160l = Arrays.asList("getInstalledPackages", "getInstalledApplications", "getConfiguredNetworks");

    /* renamed from: d, reason: collision with root package name */
    private InitDynamicPkgResult f398165d = InitDynamicPkgResult.Fail;

    /* renamed from: f, reason: collision with root package name */
    private int f398167f = 2;

    /* renamed from: h, reason: collision with root package name */
    private Map<Long, WxaPerformanceMetrics> f398169h = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements com.tencent.luggage.wxaapi.s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DeviceType f398170a;

        a(DeviceType deviceType) {
            this.f398170a = deviceType;
        }

        @Override // com.tencent.luggage.wxaapi.s
        public boolean isInFoldableAndExpandedDevice() {
            if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)) != null) {
                return this.f398170a == DeviceType.TABLET || i.this.f398166e;
            }
            return false;
        }

        @Override // com.tencent.luggage.wxaapi.s
        public boolean isInTabletWithNonFixedOrientation() {
            return this.f398170a == DeviceType.TABLET;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b extends u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f398172a;

        b(String str) {
            this.f398172a = str;
        }

        @Override // com.tencent.luggage.wxaapi.u
        public Object a(String str, String str2, Object obj, Object[] objArr, boolean[] zArr) {
            if (i.f398159k.contains(str) && zArr.length > 0) {
                zArr[0] = true;
                return this.f398172a;
            }
            if (i.f398160l.contains(str) && zArr.length > 0) {
                QLog.d("[wxa-q]WxApiWrapper", 1, "return empty list," + str);
                zArr[0] = true;
                return Collections.emptyList();
            }
            if ("listen".equals(str) && zArr.length > 0) {
                QLog.d("[wxa-q]WxApiWrapper", 1, "return null" + str);
                zArr[0] = true;
                return null;
            }
            return super.a(str, str2, obj, objArr, zArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class c implements com.tencent.luggage.wxaapi.c {
        c() {
        }

        @Override // com.tencent.luggage.wxaapi.c
        public void a(String str, int i3, long j3, boolean z16, boolean z17, boolean z18) {
            i.this.f398169h.put(Long.valueOf(j3), new WxaPerformanceMetrics(str, i3, j3, System.currentTimeMillis() - (j3 / 1000000), z16, z17, z18));
            i.w().f398163b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class e implements IWXAPIEventHandler, com.tencent.luggage.wxaapi.i {

        /* renamed from: d, reason: collision with root package name */
        private i f398179d;

        /* renamed from: e, reason: collision with root package name */
        private String f398180e = "";

        public e(i iVar) {
            this.f398179d = iVar;
        }

        @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
        public void onReq(BaseReq baseReq) {
            QLog.d("[wxa-q]WxApiWrapper", 1, "sendCombineAuth baseReq:" + baseReq);
        }

        @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
        public void onResp(BaseResp baseResp) {
            SendAuth.Resp resp = (SendAuth.Resp) baseResp;
            if (this.f398180e != null) {
                this.f398179d.v(resp.code);
                this.f398180e = resp.code;
            }
            QLog.d("[wxa-q]WxApiWrapper", 1, "sendCombineAuth onResp code:" + resp.code);
        }

        @Override // com.tencent.luggage.wxaapi.i
        public void onAuthFinish(TdiAuthErrCode tdiAuthErrCode, String str) {
            QLog.d("[wxa-q]WxApiWrapper", 1, "onAuthFinish, res: ", tdiAuthErrCode, " msg: ", str, " code: ", this.f398180e);
            Bundle bundle = new Bundle();
            bundle.putString("code", this.f398180e);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            TdiAuthErrCode tdiAuthErrCode2 = TdiAuthErrCode.WechatTdi_Auth_Err_OK;
            peekAppRuntime.notifyObservers(com.tencent.mobileqq.wxmini.api.account.a.class, 2, tdiAuthErrCode == tdiAuthErrCode2, bundle);
            if (tdiAuthErrCode == tdiAuthErrCode2) {
                int hashCode = this.f398180e.hashCode();
                if (i.f398157i.compareAndSet(hashCode, hashCode)) {
                    return;
                }
                i.f398157i.set(hashCode);
                HashMap hashMap = new HashMap();
                hashMap.put(StartupReportKey.TID_USERID, this.f398179d.f398162a.getTdiUserId());
                hashMap.put("applet_auth_source", String.valueOf(this.f398179d.f398167f));
                com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
                if (bindingWeChatUserInfo == null) {
                    return;
                }
                hashMap.put(StartupReportKey.WX_OPENID, bindingWeChatUserInfo.f());
                if (this.f398179d.f398167f == 2) {
                    hashMap.put("applet_appid", this.f398179d.f398163b);
                }
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).miniAppDesktopCommonReport("ev_applet_auth", "", hashMap, null);
            }
        }
    }

    i() {
        E();
    }

    private synchronized void E() {
        if (this.f398164c) {
            return;
        }
        WxaApi v3 = new WxaSDKInit().v();
        this.f398162a = v3;
        if (v3 == null) {
            QLog.e("[wxa-q]WxApiWrapper", 1, "WxaApi createApi error");
            return;
        }
        v3.addWxaAppCloseEventListener(new com.tencent.luggage.wxaapi.k() { // from class: fb3.e
            @Override // com.tencent.luggage.wxaapi.k
            public final void a(long j3, String str) {
                i.this.G(j3, str);
            }
        });
        this.f398162a.setSystemPropertiesExtensionImpl(new a(PadUtil.a(BaseApplication.getContext())));
        this.f398162a.setWxaSensitiveApiInvokeHandler(new b(com.tencent.mobileqq.statistics.o.c()));
        this.f398162a.addLaunchWxaAppPerformanceMetricsListener(new c());
        if (!MobileQQ.PACKAGE_NAME.equals(MobileQQ.sMobileQQ.getQQProcessName())) {
            this.f398162a.getExtendApiJSBridge().setInvokeHandler(((IWxMiniLibApi) QRoute.api(IWxMiniLibApi.class)).getHandler());
        }
        this.f398164c = true;
    }

    public static void F() {
        f398158j = w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(long j3, String str) {
        Q(str, j3);
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).preloadProcessEnv(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(com.tencent.mobileqq.wxmini.impl.launcher.a aVar, String str, int i3, String str2, int i16, long j3, LaunchWxaAppResult launchWxaAppResult) {
        WxaPerformanceMetrics x16 = x(j3);
        if (aVar != null) {
            if (x16 == null) {
                QLog.e("[wxa-q]WxApiWrapper", 1, "launchByUsername error null metrics username:" + str);
                aVar.a(str, i3, LaunchWxaAppResult.Fail, null);
            } else {
                aVar.a(x16.getWxaAppID(), i16, launchWxaAppResult, x16);
            }
        }
        if (LaunchWxaAppResult.OK == launchWxaAppResult) {
            if (x16 != null) {
                str2 = x16.getWxaAppID();
            }
            R(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(e eVar, com.tencent.luggage.wxaapi.i iVar, TdiAuthErrCode tdiAuthErrCode, String str) {
        eVar.onAuthFinish(tdiAuthErrCode, str);
        if (iVar != null) {
            iVar.onAuthFinish(tdiAuthErrCode, str);
        }
        f398161m = tdiAuthErrCode == TdiAuthErrCode.WechatTdi_Auth_Err_OK;
    }

    private void P(int i3) {
        com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        if (bindingWeChatUserInfo == null) {
            QLog.d("[wxa-q]WxApiWrapper", 1, "miniAppDtReport WechatAccountInfo is null!");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(StartupReportKey.TID_USERID, this.f398162a.getTdiUserId());
        hashMap.put("applet_revoke_auth_source", String.valueOf(i3));
        hashMap.put(StartupReportKey.WX_OPENID, bindingWeChatUserInfo.f());
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).miniAppDesktopCommonReport("ev_applet_revoke_auth", "", hashMap, null);
    }

    private void Q(String str, long j3) {
        if (TextUtils.equals(this.f398163b, str)) {
            WxMiniTipUserInfoFragment.INSTANCE.a();
            a.WxaRecord h16 = ib3.a.h(str);
            if (h16 == null) {
                QLog.w("[wxa-q]WxApiWrapper", 1, "onWxaHide not found record appId:" + str + ", timeStamp:" + j3);
            }
            if (h16 != null && h16.getWxaInfo().getScene() == 1021500100) {
                ((IWeiXinMiniServiceAPI) QRoute.api(IWeiXinMiniServiceAPI.class)).triggerPullDownAnim(str, true);
            }
            ib3.a.b().put(str, Boolean.TRUE);
        }
    }

    private void R(String str) {
        this.f398163b = str;
        ib3.a.c().put(str, Boolean.TRUE);
        ib3.a.b().put(str, Boolean.FALSE);
    }

    private void Y(Context context) {
        if (context instanceof Activity) {
            this.f398166e = com.tencent.mobileqq.pad.c.e((Activity) context);
        }
    }

    private Map<String, Object> q(int i3, HashMap<String, Object> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("host_scene", Integer.valueOf(i3));
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        return hashMap2;
    }

    private SendAuth.Req u() {
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo,snsapi_friend,snsapi_message,snsapi_contact";
        SendAuth.Options options = new SendAuth.Options();
        options.callbackClassName = "com.tencent.mobileqq.wxapi.WXEntryActivityCompat";
        req.options = options;
        req.state = String.valueOf(System.currentTimeMillis());
        req.transaction = String.valueOf(System.currentTimeMillis());
        return req;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("[wxa-q]WxApiWrapper", 1, "getAccountBindingUserInfoByCode wxAuthCode is null or empty!");
        } else {
            com.tencent.mobileqq.wxmini.impl.account.e.e().k(str, new d(str));
        }
    }

    public static i w() {
        if (f398158j == null) {
            synchronized (i.class) {
                if (f398158j == null) {
                    f398158j = new i();
                }
            }
        }
        return f398158j;
    }

    private WxaPerformanceMetrics x(long j3) {
        WxaPerformanceMetrics wxaPerformanceMetrics = this.f398169h.get(Long.valueOf(j3));
        this.f398169h.put(Long.valueOf(j3), null);
        return wxaPerformanceMetrics;
    }

    public String A() {
        WxaApi wxaApi = this.f398162a;
        if (wxaApi == null) {
            return "";
        }
        return wxaApi.getSDKVersion();
    }

    public String B() {
        WxaApi wxaApi = this.f398162a;
        if (wxaApi == null) {
            return "";
        }
        return wxaApi.getTdiUserId();
    }

    public boolean C(Context context, Intent intent) {
        Y(context);
        WxaApi wxaApi = this.f398162a;
        return wxaApi != null && wxaApi.handleIntent(context, intent);
    }

    public synchronized InitDynamicPkgResult D(String str) {
        if (this.f398162a != null && !TextUtils.isEmpty(str)) {
            InitDynamicPkgResult initDynamicPkgResult = this.f398165d;
            InitDynamicPkgResult initDynamicPkgResult2 = InitDynamicPkgResult.OK;
            if (initDynamicPkgResult == initDynamicPkgResult2) {
                return initDynamicPkgResult2;
            }
            try {
                QLog.i("[wxa-q]WxApiWrapper", 1, "initDynamicPkg...");
                InitDynamicPkgResult initDynamicPkg = this.f398162a.initDynamicPkg(str);
                this.f398165d = initDynamicPkg;
                QLog.e("[wxa-q]WxApiWrapper", 1, "initDynamicPkg result:", initDynamicPkg.name());
                return this.f398165d;
            } catch (UnsatisfiedLinkError e16) {
                QLog.e("[wxa-q]WxApiWrapper", 1, "initDynamicPkg failed! ", e16);
                return InitDynamicPkgResult.Fail;
            }
        }
        return InitDynamicPkgResult.Fail;
    }

    public void M(Context context, String str, int i3, final com.tencent.mobileqq.wxmini.impl.launcher.a aVar) {
        if (this.f398162a != null) {
            Y(context);
            this.f398162a.launchByQRRawData(context, str, q(i3, null), new com.tencent.luggage.wxaapi.d() { // from class: fb3.h
                @Override // com.tencent.luggage.wxaapi.d
                public final void onLaunchResult(String str2, int i16, long j3, LaunchWxaAppResult launchWxaAppResult) {
                    i.this.H(aVar, str2, i16, j3, launchWxaAppResult);
                }
            });
        } else if (aVar != null) {
            aVar.a("", 0, LaunchWxaAppResult.Fail, null);
        }
    }

    public void N(Context context, final String str, final int i3, String str2, int i16, HashMap<String, Object> hashMap, final com.tencent.mobileqq.wxmini.impl.launcher.a aVar) {
        if (this.f398162a != null) {
            Y(context);
            this.f398162a.launchByUsername(context, str, i3, str2, q(i16, hashMap), new com.tencent.luggage.wxaapi.b() { // from class: fb3.d
                @Override // com.tencent.luggage.wxaapi.b
                public final void onLaunchResult(String str3, int i17, long j3, LaunchWxaAppResult launchWxaAppResult) {
                    i.this.I(aVar, str, i3, str3, i17, j3, launchWxaAppResult);
                }
            });
        } else if (aVar != null) {
            aVar.a("", 0, LaunchWxaAppResult.Fail, null);
        }
    }

    public void S(int i3, com.tencent.luggage.wxaapi.g gVar) {
        WxaApi wxaApi = this.f398162a;
        if (wxaApi == null) {
            QLog.e("[wxa-q]WxApiWrapper", 1, "preloadWxaProcessEnv wxaApi == null");
        } else {
            wxaApi.preloadWxaProcessEnv(i3, gVar);
        }
    }

    public void T(int i3, int i16, com.tencent.luggage.wxaapi.j jVar) {
        if (this.f398162a == null) {
            QLog.e("[wxa-q]WxApiWrapper", 1, "requestUploadLogFiles wxaApi == null");
        } else {
            QLog.d("[wxa-q]WxApiWrapper", 2, "start requestUploadLogFiles");
            this.f398162a.requestUploadLogFiles(i3, i16, jVar);
        }
    }

    public void U(com.tencent.luggage.wxaapi.i iVar) {
        WxaApi wxaApi = this.f398162a;
        if (wxaApi != null) {
            wxaApi.sendAuth(iVar);
        } else if (iVar != null) {
            iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded, "dynamic module has not been loaded");
        }
    }

    public void V(SendAuth.Req req, IWXAPIEventHandler iWXAPIEventHandler, com.tencent.luggage.wxaapi.i iVar) {
        WxaApi wxaApi = this.f398162a;
        if (wxaApi != null) {
            wxaApi.sendCombineAuth(req, iWXAPIEventHandler, iVar);
        } else if (iVar != null) {
            iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded, "");
        }
    }

    public void W(int i3) {
        this.f398167f = i3;
    }

    public void X(Bundle bundle) {
        this.f398168g = bundle;
    }

    public void Z(boolean z16) {
        WxaApi wxaApi = this.f398162a;
        if (wxaApi == null) {
            QLog.e("[wxa-q]WxApiWrapper", 1, "[setIsDebugIP] error, wxaApi is null,  value:" + z16);
            return;
        }
        com.tencent.luggage.wxaapi.a debugApi = wxaApi.getDebugApi();
        if (debugApi == null) {
            QLog.e("[wxa-q]WxApiWrapper", 1, "[setIsDebugIP] error, debugApi is null,  value:" + z16);
            return;
        }
        QLog.i("[wxa-q]WxApiWrapper", 1, "[setIsDebugIP] value:" + z16);
        debugApi.setIsDebugIP(z16);
    }

    public void a0(final com.tencent.luggage.wxaapi.i iVar) {
        if (this.f398162a == null) {
            if (iVar != null) {
                iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded, "dynamic module has not been loaded");
            }
        } else if (f398161m) {
            if (iVar != null) {
                iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_OK, "");
            }
        } else {
            if (WXPayHelper.getInstance().getWXAppSupportAPI() >= 671091456) {
                QLog.d("[wxa-q]WxApiWrapper", 1, "startAuth sendCombineAuth!");
                SendAuth.Req u16 = u();
                final e eVar = new e(this);
                V(u16, eVar, new com.tencent.luggage.wxaapi.i() { // from class: fb3.f
                    @Override // com.tencent.luggage.wxaapi.i
                    public final void onAuthFinish(TdiAuthErrCode tdiAuthErrCode, String str) {
                        i.K(i.e.this, iVar, tdiAuthErrCode, str);
                    }
                });
                return;
            }
            QLog.d("[wxa-q]WxApiWrapper", 1, "startAuth sendAuth!");
            U(new com.tencent.luggage.wxaapi.i() { // from class: fb3.g
                @Override // com.tencent.luggage.wxaapi.i
                public final void onAuthFinish(TdiAuthErrCode tdiAuthErrCode, String str) {
                    i.L(com.tencent.luggage.wxaapi.i.this, tdiAuthErrCode, str);
                }
            });
        }
    }

    public void b0() {
        QLog.i("[wxa-q]WxApiWrapper", 1, "stopAllWxMiniProcess");
        com.tencent.mobileqq.wxmini.impl.util.g.f327781a.b();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) MobileQQ.sMobileQQ.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            return;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.contains(":wxa_container")) {
                QLog.d("[wxa-q]WxApiWrapper", 1, "kill process: ", Integer.valueOf(runningAppProcessInfo.pid), " name: ", runningAppProcessInfo.processName);
                SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    public void c0(String str) {
        WxaApi wxaApi = this.f398162a;
        if (wxaApi == null) {
            QLog.i("[wxa-q]WxApiWrapper", 1, "[updateTuringAIDTicket] error, wxaApi is null");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[updateTuringAIDTicket] aidTicket:");
        sb5.append(!TextUtils.isEmpty(str));
        QLog.i("[wxa-q]WxApiWrapper", 1, sb5.toString());
        wxaApi.updateTuringAIDTicket(str);
    }

    public void r(com.tencent.luggage.wxaapi.h hVar) {
        WxaApi wxaApi = this.f398162a;
        if (wxaApi != null) {
            wxaApi.checkAuthState(hVar);
        } else if (hVar != null) {
            hVar.onStateChecked(TdiAuthState.WechatTdi_Auth_State_Dynamic_Pkg_Not_Loaded, "");
        }
    }

    public void t(String str, int i3) {
        QLog.i("[wxa-q]WxApiWrapper", 1, "clearAuthWhenLogout: " + str);
        P(i3);
        s();
        this.f398162a.clearAuth();
        com.tencent.mobileqq.wxmini.impl.account.h.d("");
        b0();
    }

    public com.tencent.luggage.wxaapi.r y(String str) {
        return this.f398162a.queryWxaProfileForAppId(str);
    }

    public String z() {
        if (this.f398162a == null) {
            return "";
        }
        return "version:" + this.f398162a.getSDKVersion() + ", versionInt:" + this.f398162a.getSDKVersionInt();
    }

    public static void s() {
        f398161m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(com.tencent.mobileqq.wxmini.impl.launcher.a aVar, String str, int i3, long j3, LaunchWxaAppResult launchWxaAppResult) {
        if (aVar != null) {
            aVar.a(str, i3, launchWxaAppResult, x(j3));
        }
        if (LaunchWxaAppResult.OK == launchWxaAppResult) {
            R(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(com.tencent.mobileqq.wxmini.impl.launcher.a aVar, String str, String str2, int i3, long j3, LaunchWxaAppResult launchWxaAppResult) {
        if (aVar != null) {
            aVar.a(str, i3, launchWxaAppResult, x(j3));
        }
        if (LaunchWxaAppResult.OK == launchWxaAppResult) {
            R(str2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(StartupReportKey.TID_USERID, this.f398162a.getTdiUserId());
        hashMap.put("applet_appid", str);
        hashMap.put("applet_security_type", String.valueOf(launchWxaAppResult.code));
        com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        if (bindingWeChatUserInfo != null) {
            hashMap.put(StartupReportKey.WX_OPENID, bindingWeChatUserInfo.f());
        } else {
            hashMap.put(StartupReportKey.WX_OPENID, "");
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).miniAppDesktopCommonReport("ev_applet_security", "", hashMap, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(com.tencent.luggage.wxaapi.i iVar, TdiAuthErrCode tdiAuthErrCode, String str) {
        if (iVar != null) {
            iVar.onAuthFinish(tdiAuthErrCode, str);
        }
        f398161m = tdiAuthErrCode == TdiAuthErrCode.WechatTdi_Auth_Err_OK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class d implements com.tencent.mobileqq.wxmini.api.data.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f398175a;

        /* compiled from: P */
        /* loaded from: classes38.dex */
        class a implements com.tencent.mobileqq.wxmini.api.data.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.wxmini.api.data.d f398177a;

            a(com.tencent.mobileqq.wxmini.api.data.d dVar) {
                this.f398177a = dVar;
            }

            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public void onCallback(boolean z16, Bundle bundle) {
                HashMap hashMap = new HashMap();
                hashMap.put(StartupReportKey.TID_USERID, i.w().f398162a.getTdiUserId());
                hashMap.put("applet_auth_source", String.valueOf(i.w().f398167f));
                hashMap.put(StartupReportKey.WX_OPENID, this.f398177a.f());
                if (i.w().f398167f == 2) {
                    hashMap.put("applet_appid", i.w().f398163b);
                }
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).miniAppDesktopCommonReport("ev_applet_auth", "", hashMap, null);
            }
        }

        d(String str) {
            this.f398175a = str;
        }

        @Override // com.tencent.mobileqq.wxmini.api.data.a
        public void a(com.tencent.mobileqq.wxmini.api.data.d dVar) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key_wx_account_type", dVar.a());
                jSONObject.put("key_wx_account_app_id", dVar.b());
                jSONObject.put("key_wx_account_code", dVar.c());
                jSONObject.put("key_wx_account_union_id", dVar.g());
                jSONObject.put("key_wx_account_open_id", dVar.f());
                jSONObject.put("key_wx_account_nick_name", dVar.e());
                jSONObject.put("key_wx_account_head_image_url", dVar.d());
                jSONObject.put("key_wx_account_is_bound", dVar.i());
                jSONObject.put("key_wx_account_wx_func_token", dVar.h());
            } catch (JSONException e16) {
                QLog.e("[wxa-q]WxApiWrapper", 1, "reqWxUserInfoByCode onSuccess JSONException!" + dVar, e16);
            }
            com.tencent.mobileqq.wxmini.impl.account.h.d(jSONObject.toString());
            QQToastUtil.showQQToast(2, R.string.x6g);
            QLog.d("[wxa-q]WxApiWrapper", 1, "reqWxUserInfoByCode onSuccess:" + dVar);
            int hashCode = this.f398175a.hashCode();
            if (i.f398157i.compareAndSet(hashCode, hashCode)) {
                return;
            }
            i.f398157i.set(hashCode);
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).checkWxAuthed(new a(dVar));
        }

        @Override // com.tencent.mobileqq.wxmini.api.data.a
        public void onFail(int i3) {
            QQToastUtil.showQQToast(2, R.string.x6h);
            QLog.e("[wxa-q]WxApiWrapper", 1, "reqWxUserInfoByCode onFail:" + i3);
        }
    }

    public void O(Context context, final String str, int i3, String str2, int i16, final com.tencent.mobileqq.wxmini.impl.launcher.a aVar, HashMap<String, Object> hashMap) {
        if (this.f398162a == null || str == null) {
            if (aVar != null) {
                aVar.a("", 0, LaunchWxaAppResult.Fail, null);
                return;
            }
            return;
        }
        Y(context);
        QLog.d("[wxa-q]WxApiWrapper", 1, "launchWxaApp path:" + str2 + ",scene:" + i16, " extra: ", hashMap);
        this.f398162a.launchWxaApp(context, str, i3, str2, q(i16, hashMap), new com.tencent.luggage.wxaapi.d() { // from class: fb3.c
            @Override // com.tencent.luggage.wxaapi.d
            public final void onLaunchResult(String str3, int i17, long j3, LaunchWxaAppResult launchWxaAppResult) {
                i.this.J(aVar, str, str3, i17, j3, launchWxaAppResult);
            }
        });
    }
}
