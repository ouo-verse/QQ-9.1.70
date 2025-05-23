package com.tencent.mobileqq.login.ntlogin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.al;
import com.tencent.mobileqq.login.bl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007J\"\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/ag;", "", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, ReportConstant.COSTREPORT_PREFIX, "", "uin", "Landroid/app/Activity;", "Lmqq/app/AppRuntime;", "app", "t", "msg", "w", "r", "j", "account", "", "noPassword", "u", "v", "phoneNum", "countryCode", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "noPasswordAccountMap", "c", "changePasswordAccountMap", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ag {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ag f242225a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Boolean> noPasswordAccountMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Boolean> changePasswordAccountMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/login/ntlogin/ag$a", "Lcom/tencent/mobileqq/login/aa;", "", "uin", "Landroid/os/Bundle;", "bundle", "", "c", "Lcom/tencent/mobileqq/login/aj;", "failedInfo", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.login.aa {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                QLog.d("PasswordTipsManager", 1, "changePasswordByPhone onLoginCancel");
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void b(@NotNull aj failedInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) failedInfo);
            } else {
                Intrinsics.checkNotNullParameter(failedInfo, "failedInfo");
                QLog.d("PasswordTipsManager", 1, "changePasswordByPhone onLoginFailed");
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void c(@NotNull String uin, @NotNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin, (Object) bundle);
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            QLog.d("PasswordTipsManager", 1, "change pwd onLoginSuccess");
            ag.changePasswordAccountMap.put(uin, Boolean.TRUE);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21341);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f242225a = new ag();
        noPasswordAccountMap = new ConcurrentHashMap<>();
        changePasswordAccountMap = new ConcurrentHashMap<>();
    }

    ag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final QBaseActivity qBaseActivity, final String str, final AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "$app");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230);
        createCustomDialog.setTitle(R.string.g1i);
        createCustomDialog.setMessage(R.string.g1h);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.ntlogin.ab
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.l(str, qBaseActivity, app, dialogInterface, i3);
            }
        };
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.ntlogin.ac
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.m(dialogInterface, i3);
            }
        };
        createCustomDialog.setPositiveButton(R.string.g1g, onClickListener);
        createCustomDialog.setNegativeButton(R.string.f171185d01, onClickListener2);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String uin, QBaseActivity qBaseActivity, AppRuntime app, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(app, "$app");
        try {
            dialogInterface.dismiss();
        } catch (Exception e16) {
            QLog.e("PasswordTipsManager", 1, "gotoPwdSetWebsite: dismiss exception. " + e16.getMessage());
        }
        ag agVar = f242225a;
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        agVar.t(uin, qBaseActivity, app);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DialogInterface dialogInterface, int i3) {
        try {
            dialogInterface.dismiss();
        } catch (Exception e16) {
            QLog.e("PasswordTipsManager", 1, "gotoPwdSetWebsite: dismiss exception. " + e16.getMessage());
        }
    }

    private final void n() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        ConcurrentHashMap<String, Boolean> concurrentHashMap = changePasswordAccountMap;
        if (!Intrinsics.areEqual(concurrentHashMap.get(currentAccountUin), Boolean.TRUE)) {
            return;
        }
        QLog.d("PasswordTipsManager", 1, "checkNeedChangePassword: guide to change");
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            concurrentHashMap.remove(currentAccountUin);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ag.o(QBaseActivity.this);
                }
            });
        } else {
            QLog.e("PasswordTipsManager", 1, "gotoPwdSetWebsite: activity is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final QBaseActivity qBaseActivity) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230);
        createCustomDialog.setTitle(R.string.iao);
        createCustomDialog.setMessage(R.string.f173292sr);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.ntlogin.ae
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.p(QBaseActivity.this, dialogInterface, i3);
            }
        };
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.ntlogin.af
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ag.q(dialogInterface, i3);
            }
        };
        createCustomDialog.setPositiveButton(R.string.iao, onClickListener);
        createCustomDialog.setNegativeButton(R.string.cancel, onClickListener2);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(QBaseActivity act, DialogInterface dialogInterface, int i3) {
        try {
            dialogInterface.dismiss();
        } catch (Exception e16) {
            QLog.e("PasswordTipsManager", 1, "gotoChangeSetWebsite: dismiss exception. " + e16.getMessage());
        }
        ag agVar = f242225a;
        Intrinsics.checkNotNullExpressionValue(act, "act");
        agVar.s(act);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(DialogInterface dialogInterface, int i3) {
        try {
            dialogInterface.dismiss();
        } catch (Exception e16) {
            QLog.e("PasswordTipsManager", 1, "gotoChangeSetWebsite: dismiss exception. " + e16.getMessage());
        }
    }

    private final void s(QBaseActivity activity) {
        AppInterface appInterface;
        boolean contains$default;
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (com.tencent.mobileqq.phonelogin.a.a().b(appInterface, currentAccountUin)) {
            Intent intent = new Intent();
            intent.putExtra("uin", currentAccountUin);
            String updatePwdUrl = ((ISafeApi) QRoute.api(ISafeApi.class)).getUpdatePwdUrl("HasSetPwdUrl");
            if (!(!TextUtils.isEmpty(updatePwdUrl))) {
                updatePwdUrl = "https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
            }
            if (updatePwdUrl != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) updatePwdUrl, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
                if (!contains$default) {
                    str = "?uin=" + currentAccountUin;
                } else {
                    str = "&uin=" + currentAccountUin;
                }
                updatePwdUrl = updatePwdUrl + str;
            }
            intent.putExtra("url", updatePwdUrl);
            RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
            appInterface.sendWirelessPswReq(1);
            return;
        }
        ((ISafeApi) QRoute.api(ISafeApi.class)).gotoPwdSetWebsite(((ISafeApi) QRoute.api(ISafeApi.class)).getUpdatePwdUrl("RegNewUrl"), currentAccountUin, activity, appInterface);
    }

    private final void t(String uin, Activity activity, AppRuntime app) {
        boolean contains$default;
        if (activity == null) {
            QLog.e("PasswordTipsManager", 1, "gotoPwdSetWebsite: activity is null");
            return;
        }
        String str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) "https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw", (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            str = ContainerUtils.FIELD_DELIMITER;
        }
        String str2 = ("https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw" + str) + "uin=" + uin + "&plat=1&app=1&version=" + AppSetting.f99554n + "&device=" + URLEncoder.encode(Build.DEVICE) + "&system=" + Build.VERSION.RELEASE + "&systemInt=" + Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        intent.putExtra("url", str2);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("uin", uin);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        VasWebviewUtil.openQQBrowserActivity(activity, str2, 32768L, intent, false, -1);
        ReportController.o(app, "CliOper", "", "", "Mobile_signup", "Setiing_pw_tips", 0, 0, "", "", "", "");
    }

    private final void w(final QBaseActivity activity, final String msg2) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.ad
            @Override // java.lang.Runnable
            public final void run() {
                ag.x(QBaseActivity.this, msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(QBaseActivity activity, String msg2) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(activity, msg2, 0).show();
    }

    public final void i(@NotNull QBaseActivity activity, @Nullable String phoneNum, @Nullable String countryCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, activity, phoneNum, countryCode);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.i("PasswordTipsManager", 1, "startPhoneSmsLogin");
        if (!TextUtils.isEmpty(countryCode) && !TextUtils.isEmpty(phoneNum)) {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                String qqStr = HardCodeUtil.qqStr(R.string.b3j);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.failedconnection)");
                w(activity, qqStr);
                return;
            } else {
                al.b(5).login(activity, new bl.a(19).b(countryCode).f(phoneNum).a(), null, new a());
                return;
            }
        }
        QLog.e("PasswordTipsManager", 1, "mCountryCode=" + countryCode + " phoneNum=" + phoneNum);
        String qqStr2 = HardCodeUtil.qqStr(R.string.c68);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.loginFailed)");
        w(activity, qqStr2);
    }

    public final void j() {
        final AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!MobileQQ.sMobileQQ.isLoginByNT() || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        final String uin = peekAppRuntime.getCurrentAccountUin();
        if (!Intrinsics.areEqual(noPasswordAccountMap.get(uin), Boolean.TRUE)) {
            return;
        }
        QLog.d("PasswordTipsManager", 1, "checkHasSetPwd: not set");
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            v(uin);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.z
                @Override // java.lang.Runnable
                public final void run() {
                    ag.k(QBaseActivity.this, uin, peekAppRuntime);
                }
            });
            return;
        }
        QLog.e("PasswordTipsManager", 1, "gotoPwdSetWebsite: activity is null");
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            j();
            n();
        }
    }

    public final void u(@NotNull String account, boolean noPassword) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, account, Boolean.valueOf(noPassword));
        } else {
            Intrinsics.checkNotNullParameter(account, "account");
            noPasswordAccountMap.put(account, Boolean.valueOf(noPassword));
        }
    }

    public final void v(@NotNull String account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) account);
        } else {
            Intrinsics.checkNotNullParameter(account, "account");
            noPasswordAccountMap.remove(account);
        }
    }
}
