package com.tencent.mobileqq.login.relogin.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J:\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0004\u0012\u00020\u00040\nH\u0002J4\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0004\u0012\u00020\u00040\nH\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/dialog/AccountManagerComponent;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/login/account/a;", "account", "", "clearHistory", "Lkotlin/Function1;", "", "callback", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "uin", "v", "t", "u", "needConfirm", "w", "y", "Lcom/tencent/mobileqq/login/relogin/dialog/y;", "a", "Lcom/tencent/mobileqq/login/relogin/dialog/y;", "mDialog", "<init>", "()V", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class AccountManagerComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private y mDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/dialog/AccountManagerComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.relogin.dialog.AccountManagerComponent$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23179);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AccountManagerComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final Activity activity, final com.tencent.mobileqq.login.account.a account, final boolean clearHistory, final Function1<? super List<com.tencent.mobileqq.login.account.a>, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.relogin.dialog.k
            @Override // java.lang.Runnable
            public final void run() {
                AccountManagerComponent.o(com.tencent.mobileqq.login.account.a.this, clearHistory, activity, callback);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(com.tencent.mobileqq.login.account.a account, boolean z16, Activity activity, final Function1 callback) {
        Intrinsics.checkNotNullParameter(account, "$account");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        String f16 = account.f();
        QLog.i("AccountManagerComponent", 1, "deleteAccount uin=" + f16 + " clearHistory=" + z16);
        String lastLoginUin = MobileQQ.sMobileQQ.getLastLoginUin();
        if (lastLoginUin != null && Intrinsics.areEqual(lastLoginUin, f16)) {
            MobileQQ.sMobileQQ.setLastLoginUin("");
        }
        if (activity instanceof QBaseActivity) {
            new com.tencent.mobileqq.loginregister.w().h((QBaseActivity) activity, f16, z16);
        }
        final List<com.tencent.mobileqq.login.account.a> f17 = com.tencent.mobileqq.login.account.d.f241848a.f();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.relogin.dialog.m
            @Override // java.lang.Runnable
            public final void run() {
                AccountManagerComponent.p(Function1.this, f17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 callback, List accountList) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(accountList, "$accountList");
        callback.invoke(accountList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final Activity activity, final com.tencent.mobileqq.login.account.a account, final Function1<? super List<com.tencent.mobileqq.login.account.a>, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.relogin.dialog.l
            @Override // java.lang.Runnable
            public final void run() {
                AccountManagerComponent.r(com.tencent.mobileqq.login.account.a.this, activity, callback);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(com.tencent.mobileqq.login.account.a account, Activity activity, final Function1 callback) {
        com.tencent.mobileqq.loginregister.w h16;
        Intrinsics.checkNotNullParameter(account, "$account");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("AccountManagerComponent", 1, "deletePassword uin=" + account.f());
        account.h(false);
        MsfSdkUtils.updateSimpleAccountNotCreate(account.f(), false);
        MobileQQ.sMobileQQ.refreAccountList();
        if ((activity instanceof QBaseActivity) && (h16 = com.tencent.mobileqq.login.fragment.l.f242160a.h()) != null) {
            h16.l((QBaseActivity) activity, account.f());
        }
        final List<com.tencent.mobileqq.login.account.a> f16 = com.tencent.mobileqq.login.account.d.f241848a.f();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.relogin.dialog.n
            @Override // java.lang.Runnable
            public final void run() {
                AccountManagerComponent.s(Function1.this, f16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 callback, List accountList) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(accountList, "$accountList");
        callback.invoke(accountList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        y yVar = this.mDialog;
        if (yVar != null) {
            yVar.R();
        }
        this.mDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        return from.decodeBool("login_delete_pwd_need_confirm", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v(Activity activity, String uin) {
        if (!MobileQQ.sMobileQQ.peekAppRuntime().isLogin() || !TextUtils.equals(MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), uin)) {
            return false;
        }
        ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).logout(activity, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(boolean needConfirm) {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        from.encodeBool("login_delete_pwd_need_confirm", needConfirm);
    }

    private final void x(Activity activity) {
        AccountManagerComponent$showAccountManagerDialog$listener$1 accountManagerComponent$showAccountManagerDialog$listener$1 = new AccountManagerComponent$showAccountManagerDialog$listener$1(activity, this);
        if (this.mDialog == null) {
            List<com.tencent.mobileqq.login.account.a> f16 = com.tencent.mobileqq.login.account.d.f241848a.f();
            Intrinsics.checkNotNull(activity);
            this.mDialog = new y(activity, f16, f16.get(0).f(), accountManagerComponent$showAccountManagerDialog$listener$1, true);
        }
        try {
            y yVar = this.mDialog;
            if (yVar != null) {
                yVar.show();
            }
        } catch (Exception e16) {
            QLog.e("ReLoginAccountManagePart", 1, "dialog show error:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(AccountManagerComponent this$0, Activity activity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x(activity);
    }

    public final void y(@Nullable final Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        if (activity != null && !activity.isFinishing()) {
            if (com.tencent.mobileqq.utils.u.a().b()) {
                QLog.d("AccountManagerComponent", 1, "onClick too fast");
                return;
            }
            QQCustomDialog message = DialogUtil.createCustomDialog(activity, 230).setTitle(activity.getString(R.string.f1636423o)).setMessage("\u4f60\u767b\u5f55\u7684\u8d26\u53f7\u6570\u91cf\u5df2\u8fbe\u4e0a\u9650\uff0c\u8bf7\u5220\u9664\u90e8\u5206\u8d26\u53f7\u540e\u91cd\u65b0\u767b\u5f55");
            Intrinsics.checkNotNullExpressionValue(message, "createCustomDialog(activ\u2026\u5f55\u7684\u8d26\u53f7\u6570\u91cf\u5df2\u8fbe\u4e0a\u9650\uff0c\u8bf7\u5220\u9664\u90e8\u5206\u8d26\u53f7\u540e\u91cd\u65b0\u767b\u5f55\")");
            message.setPositiveButton(R.string.f16346237, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AccountManagerComponent.z(AccountManagerComponent.this, activity, dialogInterface, i3);
                }
            });
            message.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AccountManagerComponent.A(dialogInterface, i3);
                }
            });
            message.show();
            return;
        }
        QLog.e("AccountManagerComponent", 1, "showDeleteAccountDialog activity error");
    }
}
