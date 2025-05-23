package com.tencent.mobileqq.login.ntlogin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.login.ay;
import com.tencent.mobileqq.login.be;
import com.tencent.mobileqq.login.bl;
import com.tencent.mobileqq.login.bw;
import com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi;
import com.tencent.mobileqq.loginregister.impl.LoginFailedCommonSceneHandlerApiImpl;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.bk;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.LoginErrorCode;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import com.tencent.qqnt.kernel.nativeinterface.LoginRspInfo;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J4\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J\u001e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0014J \u0010\u001f\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u0014J \u0010!\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0014J \u0010#\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u0014J \u0010%\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010'\u001a\u0004\u0018\u00010&R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/u;", "", "", "errMsg", "", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "account", NotificationActivity.PASSWORD, "", "isLoginByMask", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginRspInfo;", "loginRspInfo", "v", "Landroid/app/Activity;", "url", "D", OpenHippyInfo.EXTRA_KEY_ERROR_URL, "W", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "loginInfo", "E", "X", "urlString", "paramName", "u", "Lcom/tencent/mobileqq/login/c;", "params", "y", "Lcom/tencent/mobileqq/login/be;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/login/bl;", "N", "Lcom/tencent/mobileqq/login/bw;", "T", "Lcom/tencent/mobileqq/login/ay;", "J", "Lmqq/app/AppRuntime;", "t", "", "", "b", "Ljava/util/Map;", "ntLoginLHErrorCodeMap", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f242388a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> ntLoginLHErrorCodeMap;

    static {
        Map<Integer, Integer> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21277);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f242388a = new u();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(LoginErrorCode.KLOGINERRORNICEACCOUNTEXPIRED), 41), TuplesKt.to(Integer.valueOf(LoginErrorCode.KLOGINERRORNICEACCOUNTPARENTCHILDEXPIRED), 116));
        ntLoginLHErrorCodeMap = mapOf;
    }

    u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(QBaseActivity activity, LoginResult loginInfo) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        f242388a.E(activity, loginInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(QBaseActivity activity, com.tencent.mobileqq.login.c params, LoginResult loginInfo) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        u uVar = f242388a;
        String str = params.f242042f;
        Intrinsics.checkNotNullExpressionValue(str, "params.account");
        String str2 = params.f242043g;
        LoginRspInfo loginRspInfo = loginInfo.rspInfo;
        Intrinsics.checkNotNullExpressionValue(loginRspInfo, "loginInfo.rspInfo");
        uVar.v(activity, str, str2, false, loginRspInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(QBaseActivity activity, LoginResult loginInfo, com.tencent.mobileqq.login.c params, int i3) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        Intrinsics.checkNotNullParameter(params, "$params");
        if (!((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).handleNTLoginErrorInfo(activity, loginInfo, new com.tencent.mobileqq.loginregister.h(Integer.valueOf(params.f242201b), params.f242042f, params.f242201b, i3))) {
            f242388a.X(activity, loginInfo.rspInfo);
        }
        QLog.i("NTLoginFailedHandler", 1, "ILoginFailedCommonSceneHandlerApi handleLoginErrorInfo errCode: " + i3);
    }

    private final void D(Activity activity, String url) {
        QLog.d("NTLoginFailedHandler", 2, "handleClickFrozen url: " + url);
        if (!W(url)) {
            RouteUtils.startActivity(activity, new Intent().putExtra("url", url), RouterConstants.UI_ROUTE_BROWSER);
            return;
        }
        Map<String, String> argumentsFromURL = MiniAppSecurityUtil.getArgumentsFromURL(url);
        if (argumentsFromURL == null) {
            QLog.e("handleMiniAppFeature", 1, "paramMap == null");
            return;
        }
        String str = argumentsFromURL.get("forbid_token");
        String str2 = argumentsFromURL.get("uin");
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str2)) {
            MiniAppSecurityUtil.updateLoginMiniAppUin(BaseApplication.getContext(), str2);
            if (str != null) {
                MiniAppSecurityUtil.updateLoginMiniAppForbidToken(BaseApplication.getContext(), str2, str);
            }
            if (MiniAppSecurityUtil.checkMiniAppForLogin(url)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, url, 2098, null);
                return;
            } else {
                QLog.e("NTLoginFailedHandler", 1, "MiniAppLauncher.startMiniApp error: fake app!");
                return;
            }
        }
        QLog.e("NTLoginFailedHandler", 1, "handleClickFrozen forbidToken or forbidUin is null");
    }

    private final void E(Activity activity, LoginResult loginInfo) {
        if (t() != null && activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (!ntLoginLHErrorCodeMap.keySet().contains(Integer.valueOf(loginInfo.rspInfo.errCode))) {
                QLog.d("NTLoginFailedHandler", 1, "handleLHExpiredError error code is not LH");
                return;
            }
            QLog.d("NTLoginFailedHandler", 1, "handleLHExpired lhUin= " + loginInfo.account.uin + ", errCode: " + loginInfo.rspInfo.errCode);
            Long l3 = 0L;
            try {
                String str = loginInfo.rspInfo.jumpUrl;
                Intrinsics.checkNotNullExpressionValue(str, "loginInfo.rspInfo.jumpUrl");
                String u16 = u(str, WidgetCacheConstellationData.NUM);
                if (u16 != null) {
                    l3 = Long.valueOf(Long.parseLong(u16));
                } else {
                    l3 = null;
                }
                if (l3 == null || l3.longValue() == 0) {
                    l3 = Long.valueOf(loginInfo.account.uin);
                }
            } catch (Exception e16) {
                QLog.e("NTLoginFailedHandler", 1, "handleLHExpiredError error: " + e16);
            }
            Intent intent = new Intent();
            intent.putExtra("type", 8);
            LoginRspInfo loginRspInfo = loginInfo.rspInfo;
            intent.putExtra("msg", loginRspInfo.errMsg + " " + loginRspInfo.jumpUrl);
            intent.putExtra("loginret", ntLoginLHErrorCodeMap.get(Integer.valueOf(loginInfo.rspInfo.errCode)));
            intent.putExtra(OpenHippyInfo.EXTRA_KEY_ERROR_URL, loginInfo.rspInfo.jumpUrl);
            String str2 = loginInfo.rspInfo.msgDetail.msgNiceAccountExpire.expireSig;
            Intrinsics.checkNotNullExpressionValue(str2, "loginInfo.rspInfo.msgDet\u2026ceAccountExpire.expireSig");
            byte[] bytes = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            intent.putExtra("expiredSig", bytes);
            intent.putExtra("loginalias", String.valueOf(l3));
            RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTER_NOTIFICATION);
            return;
        }
        QLog.e("NTLoginFailedHandler", 1, "handleLHExpiredError handleLHExpired appRuntime is null or activity is finishing!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            bk.g(qBaseActivity);
            bk.k("0X800B8D6");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(QBaseActivity qBaseActivity, LoginResult loginInfo) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        u uVar = f242388a;
        String valueOf = String.valueOf(loginInfo.account.uin);
        LoginRspInfo loginRspInfo = loginInfo.rspInfo;
        Intrinsics.checkNotNullExpressionValue(loginRspInfo, "loginInfo.rspInfo");
        uVar.v(qBaseActivity, valueOf, null, false, loginRspInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(QBaseActivity qBaseActivity, LoginResult loginInfo, be params, int i3) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        Intrinsics.checkNotNullParameter(params, "$params");
        if (!((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).handleNTLoginErrorInfo(qBaseActivity, loginInfo, new com.tencent.mobileqq.loginregister.h(Integer.valueOf(params.f242201b), params.f241956f, params.f242201b, i3))) {
            f242388a.X(qBaseActivity, loginInfo.rspInfo);
        }
        QLog.i("NTLoginFailedHandler", 1, "ILoginFailedCommonSceneHandlerApi handleLoginErrorInfo errCode: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            bk.g(qBaseActivity);
            bk.k("0X800B8D6");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(QBaseActivity qBaseActivity, LoginResult loginInfo) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        u uVar = f242388a;
        String valueOf = String.valueOf(loginInfo.account.uin);
        LoginRspInfo loginRspInfo = loginInfo.rspInfo;
        Intrinsics.checkNotNullExpressionValue(loginRspInfo, "loginInfo.rspInfo");
        uVar.v(qBaseActivity, valueOf, null, false, loginRspInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(QBaseActivity qBaseActivity, LoginResult loginInfo, ay params, int i3) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        Intrinsics.checkNotNullParameter(params, "$params");
        if (!((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).handleNTLoginErrorInfo(qBaseActivity, loginInfo, new com.tencent.mobileqq.loginregister.h(Integer.valueOf(params.f242201b), params.f241929f, params.f242201b, i3))) {
            f242388a.X(qBaseActivity, loginInfo.rspInfo);
        }
        QLog.i("NTLoginFailedHandler", 1, "ILoginFailedCommonSceneHandlerApi handleLoginErrorInfo errCode: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(QBaseActivity qBaseActivity, LoginResult loginInfo, bl params, int i3) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        Intrinsics.checkNotNullParameter(params, "$params");
        if (!((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).handleNTLoginErrorInfo(qBaseActivity, loginInfo, new com.tencent.mobileqq.loginregister.h(Integer.valueOf(params.f242201b), params.f241978g, params.f242201b, i3))) {
            f242388a.X(qBaseActivity, loginInfo.rspInfo);
        }
        QLog.i("NTLoginFailedHandler", 1, "ILoginFailedCommonSceneHandlerApi handleLoginErrorInfo errCode: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            bk.g(qBaseActivity);
            bk.k("0X800B8D6");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(QBaseActivity qBaseActivity, LoginResult loginInfo) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        u uVar = f242388a;
        String valueOf = String.valueOf(loginInfo.account.uin);
        LoginRspInfo loginRspInfo = loginInfo.rspInfo;
        Intrinsics.checkNotNullExpressionValue(loginRspInfo, "loginInfo.rspInfo");
        uVar.v(qBaseActivity, valueOf, null, false, loginRspInfo);
    }

    private final void R(final String errMsg) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.c
            @Override // java.lang.Runnable
            public final void run() {
                u.S(errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(String str) {
        if (TextUtils.isEmpty(str)) {
            str = BaseApplication.getContext().getString(R.string.f200704su);
        }
        QQToast.makeText(BaseApplication.getContext(), 1, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(QBaseActivity qBaseActivity, LoginResult loginInfo) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        u uVar = f242388a;
        String valueOf = String.valueOf(loginInfo.account.uin);
        LoginRspInfo loginRspInfo = loginInfo.rspInfo;
        Intrinsics.checkNotNullExpressionValue(loginRspInfo, "loginInfo.rspInfo");
        uVar.v(qBaseActivity, valueOf, null, false, loginRspInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(QBaseActivity qBaseActivity, LoginResult loginInfo, bw params, int i3) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        Intrinsics.checkNotNullParameter(params, "$params");
        if (!((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).handleNTLoginErrorInfo(qBaseActivity, loginInfo, new com.tencent.mobileqq.loginregister.h(Integer.valueOf(params.f242201b), "", params.f242201b, i3))) {
            f242388a.X(qBaseActivity, loginInfo.rspInfo);
        }
        QLog.i("NTLoginFailedHandler", 1, "ILoginFailedCommonSceneHandlerApi handleLoginErrorInfo errCode: " + i3);
    }

    private final boolean W(String errorUrl) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(errorUrl, LoginFailedCommonSceneHandlerApiImpl.KEY_MINIAPP_PREFIX, false, 2, null);
        return startsWith$default;
    }

    private final void X(Activity activity, final LoginRspInfo loginRspInfo) {
        boolean z16;
        String str;
        String str2;
        String str3;
        boolean z17 = true;
        if (loginRspInfo != null && loginRspInfo.errCode == 150022031) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("NTLoginFailedHandler", 1, "hard use wt login errcode: 150022031");
            MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), MobileQQ.FILE_COMMON)");
            from.encodeBool("login_hard_use_wt" + AppSetting.f99551k, true);
        }
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            String str4 = null;
            if (loginRspInfo != null) {
                str = loginRspInfo.tipsTitle;
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str2 = HardCodeUtil.qqStr(R.string.f172151nv4);
                Intrinsics.checkNotNullExpressionValue(str2, "{\n            HardCodeUt\u2026invie_3878dd48)\n        }");
            } else {
                Intrinsics.checkNotNull(loginRspInfo);
                str2 = loginRspInfo.tipsTitle;
                Intrinsics.checkNotNullExpressionValue(str2, "{\n            loginRspInfo!!.tipsTitle\n        }");
            }
            String str5 = str2;
            if (loginRspInfo == null || loginRspInfo.errCode != 150022031) {
                z17 = false;
            }
            if (z17) {
                str3 = "\u4e3a\u4e86\u786e\u4fdd\u60a8\u80fd\u591f\u6b63\u5e38\u767b\u5f55QQ\uff0c\u8bf7\u60a8\u5148\u9000\u51fa\u5e94\u7528\uff0c\u7136\u540e\u91cd\u65b0\u6253\u5f00QQ\u3002";
            } else {
                if (loginRspInfo != null) {
                    str4 = loginRspInfo.tipsContent;
                }
                if (TextUtils.isEmpty(str4)) {
                    str3 = "";
                } else {
                    Intrinsics.checkNotNull(loginRspInfo);
                    str3 = loginRspInfo.tipsContent;
                }
            }
            DialogUtil.createCustomDialog(activity, 230, str5, str3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.ntlogin.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    u.Y(LoginRspInfo.this, dialogInterface, i3);
                }
            }, null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(LoginRspInfo loginRspInfo, DialogInterface dialog, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (loginRspInfo != null && loginRspInfo.errCode == 150022031) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                MobileQQ.sMobileQQ.peekAppRuntime().exit(false);
            } catch (Exception e16) {
                QLog.e("NTLoginFailedHandler", 1, "onBackEvent app exit exception: " + e16.getMessage());
                e16.printStackTrace();
            }
        }
        dialog.dismiss();
    }

    private final String u(String urlString, String paramName) {
        List split$default;
        List split$default2;
        try {
            String query = new URL(urlString).getQuery();
            Intrinsics.checkNotNullExpressionValue(query, "query");
            split$default = StringsKt__StringsKt.split$default((CharSequence) query, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2 && Intrinsics.areEqual(split$default2.get(0), paramName)) {
                    return (String) split$default2.get(1);
                }
            }
            return null;
        } catch (Exception e16) {
            QLog.e("NTLoginFailedHandler", 1, "getParameterValue error: " + e16);
            return null;
        }
    }

    private final void v(final QBaseActivity activity, String account, String password, boolean isLoginByMask, final LoginRspInfo loginRspInfo) {
        String str;
        Resources resources;
        Resources resources2;
        Resources resources3;
        boolean z16 = true;
        QLog.d("NTLoginFailedHandler", 1, "handleAccountFrozen ");
        ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800AC0B", "0X800AC0B", 0, 0, "", "", "", "");
        if (((ILoginApi) QRoute.api(ILoginApi.class)).handleNTLoginFailByThirdPartyLogin(activity, loginRspInfo.msgDetail.msgBeenForbiden.area, account, password)) {
            QLog.i("NTLoginFailedHandler", 1, "handleLoginFailedByThirdPartyLogin true");
            return;
        }
        String title = loginRspInfo.tipsTitle;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        if (title.length() != 0) {
            z16 = false;
        }
        String str2 = null;
        if (z16) {
            if (activity != null && (resources3 = activity.getResources()) != null) {
                title = resources3.getString(R.string.f1355901v);
            } else {
                title = null;
            }
        }
        String str3 = loginRspInfo.tipsContent;
        RichTextHelper.RichTextData richTextData = new RichTextHelper.RichTextData("\u8d44\u91d1\u7ba1\u7406", "https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027");
        ArrayList arrayList = new ArrayList();
        arrayList.add(richTextData);
        SpannableString buildSpannable = RichTextHelper.buildSpannable(str3 + "\u4f60\u4e5f\u53ef\u4ee5\u5bf9\u8d26\u53f7\u8fdb\u884c\u8d44\u91d1\u7ba1\u7406\u3002", activity, false, arrayList);
        if (activity != null && (resources2 = activity.getResources()) != null) {
            str = resources2.getString(R.string.cancel);
        } else {
            str = null;
        }
        if (activity != null && (resources = activity.getResources()) != null) {
            str2 = resources.getString(R.string.f155601hy);
        }
        DialogUtil.createCustomDialogUrlWithoutAutoLink(activity, 230, title, buildSpannable, str, str2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.ntlogin.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                u.w(LoginRspInfo.this, activity, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.ntlogin.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                u.x(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(LoginRspInfo loginRspInfo, QBaseActivity qBaseActivity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(loginRspInfo, "$loginRspInfo");
        if (!TextUtils.isEmpty(loginRspInfo.jumpUrl)) {
            u uVar = f242388a;
            String str = loginRspInfo.jumpUrl;
            Intrinsics.checkNotNullExpressionValue(str, "loginRspInfo.jumpUrl");
            uVar.D(qBaseActivity, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(BaseApplication.getContext(), 1, msg2, 0).show();
    }

    public final boolean F(@Nullable final QBaseActivity activity, @NotNull final be params, @NotNull final LoginResult loginInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, activity, params, loginInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(loginInfo, "loginInfo");
        final int i3 = loginInfo.rspInfo.errCode;
        QLog.d("NTLoginFailedHandler", 1, "handlePhoneSmsLoginFail ret = " + i3 + ", scene = " + params.f242201b);
        if (i3 == 150022024) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.m
                @Override // java.lang.Runnable
                public final void run() {
                    u.G(QBaseActivity.this);
                }
            });
            return false;
        }
        if (140022018 == i3) {
            R(loginInfo.rspInfo.errMsg);
            return false;
        }
        if (ntLoginLHErrorCodeMap.keySet().contains(Integer.valueOf(i3))) {
            E(activity, loginInfo);
            return true;
        }
        if (i3 == 140022005) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.n
                @Override // java.lang.Runnable
                public final void run() {
                    u.H(QBaseActivity.this, loginInfo);
                }
            });
            return true;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.o
            @Override // java.lang.Runnable
            public final void run() {
                u.I(QBaseActivity.this, loginInfo, params, i3);
            }
        });
        return false;
    }

    public final boolean J(@Nullable final QBaseActivity activity, @NotNull final ay params, @NotNull final LoginResult loginInfo) {
        LoginRspInfo loginRspInfo;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, activity, params, loginInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(loginInfo, "loginInfo");
        final int i3 = loginInfo.rspInfo.errCode;
        QLog.d("NTLoginFailedHandler", 1, "handlePhonePwdLoginFail ret = " + i3 + ", scene = " + params.f242201b);
        if (i3 == 150022024) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.r
                @Override // java.lang.Runnable
                public final void run() {
                    u.K(QBaseActivity.this);
                }
            });
            return false;
        }
        if (140022018 == i3) {
            R(loginInfo.rspInfo.errMsg);
            return false;
        }
        if (ntLoginLHErrorCodeMap.keySet().contains(Integer.valueOf(i3))) {
            E(activity, loginInfo);
            return true;
        }
        if (i3 == 140022005) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.s
                @Override // java.lang.Runnable
                public final void run() {
                    u.L(QBaseActivity.this, loginInfo);
                }
            });
            return true;
        }
        if ((i3 == 140022013 || i3 == 150022029) && (loginRspInfo = loginInfo.rspInfo) != null && (bArr = loginRspInfo.longCookie) != null) {
            ah ahVar = ah.f242228a;
            String str = params.f241929f;
            Intrinsics.checkNotNullExpressionValue(str, "params.phoneNum");
            ahVar.b(str, new String(bArr, Charsets.UTF_8));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.t
            @Override // java.lang.Runnable
            public final void run() {
                u.M(QBaseActivity.this, loginInfo, params, i3);
            }
        });
        return false;
    }

    public final boolean N(@Nullable final QBaseActivity activity, @NotNull final bl params, @NotNull final LoginResult loginInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, activity, params, loginInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(loginInfo, "loginInfo");
        final int i3 = loginInfo.rspInfo.errCode;
        QLog.d("NTLoginFailedHandler", 1, "handlePhoneSmsLoginFail ret = " + i3 + ", scene = " + params.f242201b);
        if (i3 == 150022024) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.d
                @Override // java.lang.Runnable
                public final void run() {
                    u.P(QBaseActivity.this);
                }
            });
            return false;
        }
        if (140022018 == i3) {
            R(loginInfo.rspInfo.errMsg);
            return false;
        }
        if (ntLoginLHErrorCodeMap.keySet().contains(Integer.valueOf(i3))) {
            E(activity, loginInfo);
            return true;
        }
        if (i3 == 140022005) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.e
                @Override // java.lang.Runnable
                public final void run() {
                    u.Q(QBaseActivity.this, loginInfo);
                }
            });
            return true;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.f
            @Override // java.lang.Runnable
            public final void run() {
                u.O(QBaseActivity.this, loginInfo, params, i3);
            }
        });
        return true;
    }

    public final boolean T(@Nullable final QBaseActivity activity, @NotNull final bw params, @NotNull final LoginResult loginInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, activity, params, loginInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(loginInfo, "loginInfo");
        final int i3 = loginInfo.rspInfo.errCode;
        QLog.d("NTLoginFailedHandler", 1, "handlePhoneSmsLoginFail ret = " + i3 + ", scene = " + params.f242201b);
        if (140022018 == i3) {
            R(loginInfo.rspInfo.errMsg);
            return false;
        }
        if (ntLoginLHErrorCodeMap.keySet().contains(Integer.valueOf(i3))) {
            E(activity, loginInfo);
            return true;
        }
        if (i3 == 140022005) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.b
                @Override // java.lang.Runnable
                public final void run() {
                    u.U(QBaseActivity.this, loginInfo);
                }
            });
            return true;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.l
            @Override // java.lang.Runnable
            public final void run() {
                u.V(QBaseActivity.this, loginInfo, params, i3);
            }
        });
        return true;
    }

    @Nullable
    public final AppRuntime t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public final void y(@NotNull final QBaseActivity activity, @NotNull final com.tencent.mobileqq.login.c params, @NotNull final LoginResult loginInfo) {
        LoginRspInfo loginRspInfo;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, params, loginInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(loginInfo, "loginInfo");
        final int i3 = loginInfo.rspInfo.errCode;
        QLog.d("NTLoginFailedHandler", 1, "handleAccountLoginFailed ret = " + i3 + ", scene = " + params.f242201b);
        if (-1000 == i3) {
            QLog.i("NTLoginFailedHandler", 1, "[AccountLogin] show network error toast");
            final String string = BaseApplication.getContext().getResources().getString(R.string.f171137ci2);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.g\u2026tring(R.string.netFailed)");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.g
                @Override // java.lang.Runnable
                public final void run() {
                    u.z(string);
                }
            });
            ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C199", "0X800C199", params.f242201b, 0, "", "", "", string);
            return;
        }
        if (ntLoginLHErrorCodeMap.keySet().contains(Integer.valueOf(i3))) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.h
                @Override // java.lang.Runnable
                public final void run() {
                    u.A(QBaseActivity.this, loginInfo);
                }
            });
            return;
        }
        if (i3 == 140022005) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.i
                @Override // java.lang.Runnable
                public final void run() {
                    u.B(QBaseActivity.this, params, loginInfo);
                }
            });
            return;
        }
        if ((i3 == 140022013 || i3 == 150022029) && (loginRspInfo = loginInfo.rspInfo) != null && (bArr = loginRspInfo.longCookie) != null) {
            ah ahVar = ah.f242228a;
            String str = params.f242042f;
            Intrinsics.checkNotNullExpressionValue(str, "params.account");
            ahVar.b(str, new String(bArr, Charsets.UTF_8));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.j
            @Override // java.lang.Runnable
            public final void run() {
                u.C(QBaseActivity.this, loginInfo, params, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(DialogInterface dialogInterface, int i3) {
    }
}
