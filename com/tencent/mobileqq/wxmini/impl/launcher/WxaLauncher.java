package com.tencent.mobileqq.wxmini.impl.launcher;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StFirstPage;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.UploadLogResultCode;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.api.data.LaunchWxaErrorCode;
import com.tencent.mobileqq.wxmini.api.data.LauncherWxaState;
import com.tencent.mobileqq.wxmini.impl.util.WxAppStartHelper;
import com.tencent.mobileqq.wxmini.impl.util.WxaInfoObtainUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import hb3.f;
import java.io.Serializable;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class WxaLauncher {

    /* renamed from: b, reason: collision with root package name */
    private e f327680b;

    /* renamed from: c, reason: collision with root package name */
    private Boolean f327681c = Boolean.TRUE;

    /* renamed from: a, reason: collision with root package name */
    private final fb3.i f327679a = fb3.i.w();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements f.b {
        a() {
        }

        @Override // hb3.f.b
        public void a(boolean z16, String str) {
            QLog.i("[wxa-q]WxaLauncher", 1, "downloadDynamicPackage callback, success:" + z16 + ", message:" + str);
            if (z16) {
                WxaLauncher.this.v(LauncherWxaState.STATE_DOWNLOAD_SO_SUCCESS, -1, LaunchWxaErrorCode.Success.getCode());
            } else {
                WxaLauncher.this.v(LauncherWxaState.STATE_DOWNLOAD_SO_FAIL, -1, LaunchWxaErrorCode.FailDownloadSo.getCode());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements com.tencent.mobileqq.wxmini.api.data.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f327683a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f327684b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ db3.b f327685c;

        b(int i3, int i16, db3.b bVar) {
            this.f327683a = i3;
            this.f327684b = i16;
            this.f327685c = bVar;
        }

        @Override // com.tencent.mobileqq.wxmini.api.data.b
        public void onCallback(boolean z16, Bundle bundle) {
            QLog.i("[wxa-q]WxaLauncher", 1, "requestUploadLogFiles loadDynamicPackage, success:" + z16 + " tdiUserId:" + fb3.i.w().B());
            if (z16) {
                WxaLauncher.g0(this.f327683a, this.f327684b, this.f327685c);
                return;
            }
            db3.b bVar = this.f327685c;
            if (bVar != null) {
                bVar.a(-3, fb3.i.w().B());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements com.tencent.luggage.wxaapi.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f327686a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f327687b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ db3.b f327688c;

        c(int i3, int i16, db3.b bVar) {
            this.f327686a = i3;
            this.f327687b = i16;
            this.f327688c = bVar;
        }

        @Override // com.tencent.luggage.wxaapi.h
        public void onStateChecked(TdiAuthState tdiAuthState, String str) {
            QLog.i("[wxa-q]WxaLauncher", 1, "requestUploadLogFiles onStateChecked, tdiAuthState:" + tdiAuthState.name() + " tdiUserId:" + fb3.i.w().B());
            if (tdiAuthState == TdiAuthState.WechatTdi_Auth_State_OK) {
                WxaLauncher.e0(this.f327686a, this.f327687b, this.f327688c);
                return;
            }
            QLog.e("[wxa-q]WxaLauncher", 1, "onStateChecked tdiAuthState:" + tdiAuthState.name());
            db3.b bVar = this.f327688c;
            if (bVar != null) {
                bVar.a(-2, fb3.i.w().B());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class d implements com.tencent.luggage.wxaapi.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ db3.b f327689a;

        d(db3.b bVar) {
            this.f327689a = bVar;
        }

        @Override // com.tencent.luggage.wxaapi.j
        public void a(UploadLogResultCode uploadLogResultCode) {
            QLog.i("[wxa-q]WxaLauncher", 1, "requestUploadLogFiles result:" + uploadLogResultCode + " tdiUserId:" + fb3.i.w().B());
            db3.b bVar = this.f327689a;
            if (bVar != null) {
                bVar.a(uploadLogResultCode.ordinal(), fb3.i.w().B());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface e {
        void a(int i3, int i16, int i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(WxaInfo wxaInfo, String str, int i3, LaunchWxaAppResult launchWxaAppResult, WxaPerformanceMetrics wxaPerformanceMetrics) {
        u(wxaInfo, str, launchWxaAppResult, wxaPerformanceMetrics);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(WxaInfo wxaInfo, String str, int i3, LaunchWxaAppResult launchWxaAppResult, WxaPerformanceMetrics wxaPerformanceMetrics) {
        u(wxaInfo, str, launchWxaAppResult, wxaPerformanceMetrics);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(String str, int i3, String str2, int i16, final WxaInfo wxaInfo) {
        this.f327679a.O(BaseApplication.getContext(), str, i3, str2, i16, new com.tencent.mobileqq.wxmini.impl.launcher.a() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.g
            @Override // com.tencent.mobileqq.wxmini.impl.launcher.a
            public final void a(String str3, int i17, LaunchWxaAppResult launchWxaAppResult, WxaPerformanceMetrics wxaPerformanceMetrics) {
                WxaLauncher.this.B(wxaInfo, str3, i17, launchWxaAppResult, wxaPerformanceMetrics);
            }
        }, wxaInfo.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(WxaInfo wxaInfo, boolean z16, com.tencent.mobileqq.wxmini.api.data.e eVar) {
        P(wxaInfo, eVar, wxaInfo.getScene(), wxaInfo.getVersionType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(WxaInfo wxaInfo, boolean z16, JSONObject jSONObject) {
        String str = "";
        if (z16 && jSONObject != null) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = (INTERFACE$StApiAppInfo) jSONObject.opt("appInfo_pd");
            if (iNTERFACE$StApiAppInfo == null) {
                m0(LaunchWxaErrorCode.FailAppInfo.getCode());
                return;
            }
            String str2 = iNTERFACE$StApiAppInfo.appId.get();
            INTERFACE$StFirstPage iNTERFACE$StFirstPage = iNTERFACE$StApiAppInfo.first;
            if (iNTERFACE$StFirstPage != null && iNTERFACE$StFirstPage.pagePath.get() != null) {
                str = iNTERFACE$StApiAppInfo.first.pagePath.get();
            }
            Q(wxaInfo, str2, str, wxaInfo.getScene(), wxaInfo.getVersionType());
            return;
        }
        ib3.b bVar = ib3.b.f407378a;
        LaunchWxaErrorCode launchWxaErrorCode = LaunchWxaErrorCode.FailAppInfo;
        bVar.j(wxaInfo, "", launchWxaErrorCode.getCode());
        m0(launchWxaErrorCode.getCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(WxaInfo wxaInfo, boolean z16, com.tencent.mobileqq.wxmini.api.data.e eVar) {
        P(wxaInfo, eVar, wxaInfo.getScene(), wxaInfo.getVersionType());
        if (eVar == null || !eVar.f327614b) {
            return;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).setWxAppUrl(22, wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), eVar.f327613a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(WxaInfo wxaInfo, long j3, TdiAuthErrCode tdiAuthErrCode, String str) {
        QLog.i("[wxa-q]WxaLauncher", 1, "startAuth result:" + tdiAuthErrCode + ",errMsg:" + str);
        ib3.b.f407378a.e(wxaInfo, 2, tdiAuthErrCode, str);
        int code = com.tencent.mobileqq.wxmini.impl.util.i.a(tdiAuthErrCode).getCode();
        if (tdiAuthErrCode == TdiAuthErrCode.WechatTdi_Auth_Err_OK) {
            v(LauncherWxaState.STATE_AUTHORIZED, -1, LaunchWxaErrorCode.Success.getCode());
            L(wxaInfo);
        } else if (tdiAuthErrCode == TdiAuthErrCode.WechatTdi_Auth_Err_WechatNotInstalled) {
            Intent intent = new Intent();
            intent.putExtra("url", "https://weixin.qq.com/");
            Context context = QBaseActivity.sTopActivity;
            if (context == null) {
                context = BaseApplication.getContext();
                intent.addFlags(268435456);
            }
            RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
            o0("\u8bf7\u5b89\u88c5\u5fae\u4fe1", code, this.f327681c.booleanValue());
        } else if (tdiAuthErrCode == TdiAuthErrCode.WechatTdi_Auth_Err_WechatVersionTooLow) {
            o0("\u5fae\u4fe1\u7248\u672c\u592a\u4f4e", code, this.f327681c.booleanValue());
        } else {
            o0("\u5fae\u4fe1\u6388\u6743\u5931\u8d25", code, this.f327681c.booleanValue());
        }
        d0("wx_sendAuth_result", wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), String.valueOf(tdiAuthErrCode), String.valueOf(System.currentTimeMillis() - j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(final WxaInfo wxaInfo, TdiAuthState tdiAuthState, String str) {
        if (tdiAuthState == TdiAuthState.WechatTdi_Auth_State_OK) {
            ib3.b.f407378a.e(wxaInfo, 1, TdiAuthErrCode.WechatTdi_Auth_Err_OK, "");
            v(LauncherWxaState.STATE_AUTHORIZED, -1, LaunchWxaErrorCode.Success.getCode());
            L(wxaInfo);
            return;
        }
        d0("wx_sendAuth", wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), "", "");
        ib3.b.f407378a.f(wxaInfo);
        final long currentTimeMillis = System.currentTimeMillis();
        if (wxaInfo.getOriginBundle() != null) {
            this.f327679a.W(wxaInfo.getOriginBundle().getInt("auth_source", 2));
        }
        this.f327679a.a0(new com.tencent.luggage.wxaapi.i() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.l
            @Override // com.tencent.luggage.wxaapi.i
            public final void onAuthFinish(TdiAuthErrCode tdiAuthErrCode, String str2) {
                WxaLauncher.this.G(wxaInfo, currentTimeMillis, tdiAuthErrCode, str2);
            }
        });
        v(LauncherWxaState.STATE_AUTHORIZING, -1, LaunchWxaErrorCode.Success.getCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(final WxaInfo wxaInfo, boolean z16, Bundle bundle) {
        ib3.b.f407378a.h(wxaInfo, z16);
        if (z16) {
            this.f327679a.r(new com.tencent.luggage.wxaapi.h() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.j
                @Override // com.tencent.luggage.wxaapi.h
                public final void onStateChecked(TdiAuthState tdiAuthState, String str) {
                    WxaLauncher.this.H(wxaInfo, tdiAuthState, str);
                }
            });
        } else {
            o0("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", LaunchWxaErrorCode.FailLoadDynamic.getCode(), this.f327681c.booleanValue());
        }
    }

    private void L(WxaInfo wxaInfo) {
        QLog.i("[wxa-q]WxaLauncher", 1, "launch, tdiUserId: " + this.f327679a.B());
        switch (wxaInfo.getMetaType()) {
            case 0:
                R(wxaInfo);
                break;
            case 1:
                V(wxaInfo);
                break;
            case 2:
                S(wxaInfo);
                break;
            case 3:
                U(wxaInfo);
                break;
            case 4:
                T(wxaInfo);
                break;
            case 5:
                O(wxaInfo);
                break;
            case 6:
                v(LauncherWxaState.STATE_LAUNCH_SUCCEED, -1, LaunchWxaErrorCode.Success.getCode());
                return;
        }
        ib3.b.f407378a.l(wxaInfo);
        v(LauncherWxaState.STATE_LAUNCHING, -1, LaunchWxaErrorCode.Success.getCode());
        ib3.a.d(wxaInfo);
    }

    private void N(final WxaInfo wxaInfo, final String str, final String str2) {
        if (s(wxaInfo)) {
            h0(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.c
                @Override // java.lang.Runnable
                public final void run() {
                    WxaLauncher.this.y(str, wxaInfo, str2);
                }
            });
        }
    }

    private void O(final WxaInfo wxaInfo) {
        if (s(wxaInfo)) {
            h0(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.n
                @Override // java.lang.Runnable
                public final void run() {
                    WxaLauncher.this.z(wxaInfo);
                }
            });
        }
    }

    private void Q(final WxaInfo wxaInfo, final String str, final String str2, final int i3, final int i16) {
        if (s(wxaInfo)) {
            h0(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.e
                @Override // java.lang.Runnable
                public final void run() {
                    WxaLauncher.this.C(str, i16, str2, i3, wxaInfo);
                }
            });
        }
    }

    private void S(final WxaInfo wxaInfo) {
        WxaInfoObtainUtil.y(wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), new db3.a() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.m
            @Override // db3.a
            public final void a(boolean z16, com.tencent.mobileqq.wxmini.api.data.e eVar) {
                WxaLauncher.this.D(wxaInfo, z16, eVar);
            }
        });
    }

    private void T(final WxaInfo wxaInfo) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).getAppInfoByLink(wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), 2, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.o
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                WxaLauncher.this.E(wxaInfo, z16, jSONObject);
            }
        });
    }

    private void U(final WxaInfo wxaInfo) {
        WxaInfoObtainUtil.w(wxaInfo.getScene(), wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), 22, false, new db3.a() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.p
            @Override // db3.a
            public final void a(boolean z16, com.tencent.mobileqq.wxmini.api.data.e eVar) {
                WxaLauncher.this.F(wxaInfo, z16, eVar);
            }
        });
    }

    private void V(WxaInfo wxaInfo) {
        N(wxaInfo, wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), wxaInfo.getPath());
    }

    public static void Y(final int i3, final com.tencent.luggage.wxaapi.g gVar) {
        QLog.i("[wxa-q]WxaLauncher", 2, "preloadWxaProcessEnv wxaAppType:" + i3);
        if (!hb3.f.h().j()) {
            QLog.i("[wxa-q]WxaLauncher", 1, "preloadWxaProcessEnv but no dynamic package, need download!");
            hb3.f.h().o(new com.tencent.mobileqq.wxmini.api.data.b() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.b
                @Override // com.tencent.mobileqq.wxmini.api.data.b
                public final void onCallback(boolean z16, Bundle bundle) {
                    WxaLauncher.J(i3, gVar, z16, bundle);
                }
            });
        } else {
            Z(i3, gVar);
        }
    }

    private static void Z(int i3, com.tencent.luggage.wxaapi.g gVar) {
        try {
            fb3.i.w().S(i3, gVar);
        } catch (Exception e16) {
            QLog.e("[wxa-q]WxaLauncher", 1, "preloadWxaProcessEnv", e16);
        }
    }

    private void b0(String str, int i3, LaunchWxaAppResult launchWxaAppResult) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("[wxa-q]WxaLauncher", 1, "reportAfterLauncher appId is null");
        } else {
            WxaInfoObtainUtil.u(str, i3, this.f327679a.y(str), launchWxaAppResult);
        }
    }

    private void c0(String str, int i3, int i16, LaunchWxaAppResult launchWxaAppResult) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("[wxa-q]WxaLauncher", 1, "reportAfterLauncher appId is null");
        } else {
            WxaInfoObtainUtil.v(str, i3, this.f327679a.y(str), launchWxaAppResult, null);
            n0(str, i3, i16);
        }
    }

    private void d0(String str, String str2, String str3, String str4) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("page_view", str, str2, str3, str4, "");
    }

    public static void f0(int i3, int i16, db3.b bVar) {
        QLog.i("[wxa-q]WxaLauncher", 1, "requestUploadLogFiles tdiUserId:" + fb3.i.w().B());
        if (!hb3.f.h().j()) {
            QLog.i("[wxa-q]WxaLauncher", 1, "requestUploadLogFiles, but no dynamic package, start load it");
            hb3.f.h().o(new b(i3, i16, bVar));
        } else {
            g0(i3, i16, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g0(int i3, int i16, db3.b bVar) {
        fb3.i.w().r(new c(i3, i16, bVar));
    }

    private void h0(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    private void j0(WxaInfo wxaInfo, String str) {
        Intent intent = new Intent("com.tencent.mobileqq.ACTION_LAUNCH_WXA");
        wxaInfo.w(str);
        com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        wxaInfo.q(bindingWeChatUserInfo != null ? bindingWeChatUserInfo.f() : null);
        intent.putExtra("wxaInfo", wxaInfo);
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
    }

    private static String l0(Bundle bundle) {
        Uri uri = (Uri) bundle.get(LayoutAttrDefine.CLICK_URI);
        String string = bundle.getString("path");
        if (uri == null || uri.equals(Uri.EMPTY)) {
            return string;
        }
        String queryParameter = uri.getQueryParameter("_nq");
        if (!TextUtils.isEmpty(queryParameter)) {
            return string + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + "_miniapptype" + ContainerUtils.KEY_VALUE_DELIMITER + "2" + ContainerUtils.FIELD_DELIMITER + queryParameter;
        }
        String queryParameter2 = uri.getQueryParameter("_ext");
        if (TextUtils.isEmpty(queryParameter2)) {
            return string;
        }
        return string + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + "_miniapptype" + ContainerUtils.KEY_VALUE_DELIMITER + "2" + ContainerUtils.FIELD_DELIMITER + queryParameter2;
    }

    private void m0(int i3) {
        o0("\u6682\u4e0d\u652f\u6301\u6253\u5f00\u8be5\u5c0f\u7a0b\u5e8f", i3, this.f327681c.booleanValue());
    }

    private void n0(String str, int i3, int i16) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).updateRecentPlay(str, i3, i16);
    }

    private void o0(final String str, final int i3, final boolean z16) {
        h0(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.k
            @Override // java.lang.Runnable
            public final void run() {
                WxaLauncher.this.K(z16, str, i3);
            }
        });
    }

    private boolean s(WxaInfo wxaInfo) {
        if (TextUtils.isEmpty(wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String())) {
            ib3.b bVar = ib3.b.f407378a;
            LaunchWxaErrorCode launchWxaErrorCode = LaunchWxaErrorCode.FailAppInfo;
            bVar.j(wxaInfo, "", launchWxaErrorCode.getCode());
            m0(launchWxaErrorCode.getCode());
            return false;
        }
        if (!WxAppStartHelper.m(wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), wxaInfo.getScene())) {
            LaunchWxaErrorCode launchWxaErrorCode2 = LaunchWxaErrorCode.FailTeenager;
            o0("\u9752\u5c11\u5e74\u6a21\u5f0f\u4e0b\u8be5\u5185\u5bb9\u4e0d\u53ef\u8bbf\u95ee", launchWxaErrorCode2.getCode(), false);
            ib3.b.f407378a.j(wxaInfo, wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), launchWxaErrorCode2.getCode());
            return false;
        }
        gb3.a aVar = (gb3.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105878");
        if (aVar == null || !aVar.c(wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String())) {
            return true;
        }
        o0(aVar.getErrorTips(), LaunchWxaErrorCode.FailBlackAppId.getCode(), this.f327681c.booleanValue());
        QLog.e("[wxa-q]WxaLauncher", 1, "launchWxaApp failed, in black list metaData:" + wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String());
        return false;
    }

    private void u(WxaInfo wxaInfo, String str, LaunchWxaAppResult launchWxaAppResult, WxaPerformanceMetrics wxaPerformanceMetrics) {
        String wxaPerformanceMetrics2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleLaunchResult wxaInfo:");
        sb5.append(wxaInfo.toString());
        sb5.append(",result:");
        sb5.append(launchWxaAppResult);
        sb5.append(",metrics:");
        if (wxaPerformanceMetrics == null) {
            wxaPerformanceMetrics2 = "null";
        } else {
            wxaPerformanceMetrics2 = wxaPerformanceMetrics.toString();
        }
        sb5.append(wxaPerformanceMetrics2);
        QLog.d("[wxa-q]WxaLauncher", 1, sb5.toString());
        int scene = wxaInfo.getScene();
        int versionType = wxaInfo.getVersionType();
        if (TextUtils.isEmpty(wxaInfo.getWxAppId()) && !TextUtils.isEmpty(str)) {
            wxaInfo.w(str);
        }
        ib3.b.f407378a.k(wxaInfo, str, launchWxaAppResult.code, wxaPerformanceMetrics);
        int code = com.tencent.mobileqq.wxmini.impl.util.i.b(launchWxaAppResult).getCode();
        if (launchWxaAppResult == LaunchWxaAppResult.OK) {
            fb3.b.c().l(wxaInfo, this.f327679a.B());
            c0(str, scene, versionType, launchWxaAppResult);
            i0(str, scene);
            v(LauncherWxaState.STATE_LAUNCH_SUCCEED, -1, code);
            X();
            j0(wxaInfo, str);
            return;
        }
        if (launchWxaAppResult == LaunchWxaAppResult.Cancel) {
            b0(str, scene, launchWxaAppResult);
            v(LauncherWxaState.STATE_LAUNCH_FAILED, -1, code);
        } else {
            if (launchWxaAppResult == LaunchWxaAppResult.FailNoAuth) {
                b0(str, scene, launchWxaAppResult);
                v(LauncherWxaState.STATE_LAUNCH_FAILED, -1, code);
                fb3.i.w().t("FailNoAuth", 3);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.WxaLauncher.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).sendWxAuthEvent(MobileQQ.sMobileQQ, 2);
                    }
                });
                return;
            }
            b0(str, scene, launchWxaAppResult);
            m0(code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(final LauncherWxaState launcherWxaState, final int i3, final int i16) {
        h0(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.h
            @Override // java.lang.Runnable
            public final void run() {
                WxaLauncher.this.w(launcherWxaState, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(LauncherWxaState launcherWxaState, int i3, int i16) {
        e eVar = this.f327680b;
        if (eVar != null) {
            eVar.a(launcherWxaState.getState(), i3, i16);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("[wxa-q]WxaLauncher", 4, "invokeStateCallback, callback is null! state:" + launcherWxaState.getState());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(WxaInfo wxaInfo, String str, int i3, LaunchWxaAppResult launchWxaAppResult, WxaPerformanceMetrics wxaPerformanceMetrics) {
        u(wxaInfo, str, launchWxaAppResult, wxaPerformanceMetrics);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str, final WxaInfo wxaInfo, String str2) {
        this.f327679a.N(BaseApplication.getContext(), str, wxaInfo.getVersionType(), str2, wxaInfo.getScene(), wxaInfo.a(), new com.tencent.mobileqq.wxmini.impl.launcher.a() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.f
            @Override // com.tencent.mobileqq.wxmini.impl.launcher.a
            public final void a(String str3, int i3, LaunchWxaAppResult launchWxaAppResult, WxaPerformanceMetrics wxaPerformanceMetrics) {
                WxaLauncher.this.x(wxaInfo, str3, i3, launchWxaAppResult, wxaPerformanceMetrics);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(final WxaInfo wxaInfo) {
        this.f327679a.M(BaseApplication.getContext(), wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), wxaInfo.getScene(), new com.tencent.mobileqq.wxmini.impl.launcher.a() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.d
            @Override // com.tencent.mobileqq.wxmini.impl.launcher.a
            public final void a(String str, int i3, LaunchWxaAppResult launchWxaAppResult, WxaPerformanceMetrics wxaPerformanceMetrics) {
                WxaLauncher.this.A(wxaInfo, str, i3, launchWxaAppResult, wxaPerformanceMetrics);
            }
        });
    }

    public void M(WxaInfo wxaInfo, e eVar) {
        this.f327680b = eVar;
        this.f327679a.X(wxaInfo != null ? wxaInfo.getOriginBundle() : null);
        if (wxaInfo == null) {
            QLog.e("[wxa-q]WxaLauncher", 1, "launch data is null!");
            v(LauncherWxaState.STATE_LAUNCH_FAILED, -1, LaunchWxaErrorCode.FailParams.getCode());
            return;
        }
        QLog.i("[wxa-q]WxaLauncher", 1, "launch wxaInfo:" + wxaInfo + ",needToast:" + this.f327681c);
        hb3.f h16 = hb3.f.h();
        if (!h16.e()) {
            h16.g(new a());
        } else {
            W(wxaInfo, h16);
        }
    }

    public void W(final WxaInfo wxaInfo, hb3.f fVar) {
        fVar.o(new com.tencent.mobileqq.wxmini.api.data.b() { // from class: com.tencent.mobileqq.wxmini.impl.launcher.i
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                WxaLauncher.this.I(wxaInfo, z16, bundle);
            }
        });
    }

    public void a0() {
        if (QLog.isDevelopLevel()) {
            QLog.i("[wxa-q]WxaLauncher", 4, "removeLaunchCallback, callback:" + this.f327680b);
        }
        this.f327680b = null;
    }

    public void k0(Boolean bool) {
        this.f327681c = bool;
    }

    private void X() {
        QLog.d("[wxa-q]WxaLauncher", 2, "preloadNextMiniGameProcess");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(int i3, com.tencent.luggage.wxaapi.g gVar, boolean z16, Bundle bundle) {
        if (z16) {
            Z(i3, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(boolean z16, String str, int i3) {
        if (z16) {
            QQToast.makeText(BaseApplication.getContext(), str, 0).show();
        }
        v(LauncherWxaState.STATE_LAUNCH_FAILED, -1, i3);
        QLog.i("[wxa-q]WxaLauncher", 1, "warn, message\uff1a" + str);
    }

    private void P(WxaInfo wxaInfo, com.tencent.mobileqq.wxmini.api.data.e eVar, int i3, int i16) {
        if (eVar != null && (!TextUtils.isEmpty(eVar.f327615c) || !TextUtils.isEmpty(eVar.f327616d))) {
            if (!TextUtils.isEmpty(eVar.f327615c)) {
                Q(wxaInfo, eVar.f327615c, eVar.f327617e, i3, i16);
                return;
            }
            if (eVar.f327618f != wxaInfo.getVersionType()) {
                wxaInfo.v(eVar.f327618f);
            }
            N(wxaInfo, eVar.f327616d, eVar.f327617e);
            return;
        }
        ib3.b.f407378a.j(wxaInfo, "", LaunchWxaErrorCode.FailRequestWxaInfo.getCode());
        m0(LaunchWxaErrorCode.FailAppInfo.getCode());
    }

    private void R(WxaInfo wxaInfo) {
        if (wxaInfo != null && !TextUtils.isEmpty(wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String())) {
            Q(wxaInfo, wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String(), wxaInfo.getPath(), wxaInfo.getScene(), wxaInfo.getVersionType());
        } else {
            m0(LaunchWxaErrorCode.FailAppInfo.getCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e0(int i3, int i16, db3.b bVar) {
        if (bVar != null) {
            bVar.a(-1, fb3.i.w().B());
        }
        fb3.i.w().T(i3, i16, new d(bVar));
    }

    public static WxaInfo t(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        WxaInfo wxaInfo = new WxaInfo();
        int i3 = bundle.getInt("start_mode", -1);
        switch (i3) {
            case 0:
                wxaInfo.o(bundle.getString("app_id"));
                wxaInfo.s(l0(bundle));
                break;
            case 1:
                wxaInfo.o(bundle.getString("username"));
                wxaInfo.s(l0(bundle));
                break;
            case 2:
                wxaInfo.o(bundle.getString("qq_code"));
                break;
            case 3:
                wxaInfo.o(bundle.getString("wx_code"));
                break;
            case 4:
                wxaInfo.o(bundle.getString("url"));
                break;
            case 5:
                wxaInfo.o(bundle.getString("wx_raw_data"));
                break;
            case 6:
                break;
            default:
                QLog.e("[wxa-q]WxaLauncher", 1, "getWxaInfo error startMode:" + i3);
                return null;
        }
        Serializable serializable = bundle.getSerializable("hostExtraData");
        if (serializable instanceof HashMap) {
            wxaInfo.n((HashMap) serializable);
        }
        wxaInfo.p(i3);
        wxaInfo.t(bundle.getInt("scene", 0));
        wxaInfo.v(bundle.getInt("version_type", 0));
        wxaInfo.r(bundle);
        return wxaInfo;
    }

    private void i0(String str, int i3) {
        if (i3 == 1047 || i3 == 1012 || i3 == 1013 || i3 == 1011) {
            SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo = new SimpleMiniAppConfig.SimpleMiniAppInfo();
            simpleMiniAppInfo.appId = str;
            SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(simpleMiniAppInfo);
            simpleMiniAppConfig.launchParam.scene = i3;
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async(simpleMiniAppConfig, "scan", "scan", null, null);
        }
    }
}
