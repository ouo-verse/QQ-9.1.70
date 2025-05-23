package com.tencent.mobileqq.account.processors;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.account.bean.QQAccount;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.login.api.IDirectLoginService;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.xps.api.IQEstApi;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001\u0010B\u001f\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\f\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/account/processors/AccountListProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "Lw51/a;", "", "H", "", "B", "", "uin", "D", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onCreate", "onResume", "maskedUin", "loginToken", "a", "Lcom/tencent/qphone/base/remote/SimpleAccount;", "sa", "c", "o", DomainData.DOMAIN_NAME, "b", "Lcom/tencent/mobileqq/account/viewmodel/a;", "g", "Lcom/tencent/mobileqq/account/viewmodel/a;", "vm", "Landroidx/lifecycle/LifecycleOwner;", tl.h.F, "Landroidx/lifecycle/LifecycleOwner;", "owner", "i", "Z", "isClickAccountFromThis", "j", "Lcom/tencent/qphone/base/remote/SimpleAccount;", "switchAccount", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/account/viewmodel/a;Landroidx/lifecycle/LifecycleOwner;)V", "k", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class AccountListProcessor extends com.tencent.mobileqq.setting.processor.c implements w51.a {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.account.viewmodel.a vm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner owner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isClickAccountFromThis;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SimpleAccount switchAccount;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/account/processors/AccountListProcessor$a;", "", "", "LOGIN_REQUEST_CHANGE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.account.processors.AccountListProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24881);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountListProcessor(@NotNull Context context, @NotNull com.tencent.mobileqq.account.viewmodel.a vm5, @NotNull LifecycleOwner owner) {
        super(context, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(owner, "owner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, vm5, owner);
        } else {
            this.vm = vm5;
            this.owner = owner;
        }
    }

    private final boolean B() {
        if (!((ISettingApi) QRoute.api(ISettingApi.class)).checkHasNotSetPwd(e())) {
            return true;
        }
        QLog.i("AccountListProcessor", 1, "checkHasSetPwd: return false");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(AccountListProcessor this$0, SimpleAccount simpleAccount) {
        Boolean bool;
        String str;
        ISubAccountService iSubAccountService;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppInterface f16 = this$0.f();
        if (f16 != null && (iSubAccountService = (ISubAccountService) f16.getRuntimeService(ISubAccountService.class, "")) != null) {
            bool = Boolean.valueOf(iSubAccountService.isSubAccountUin(simpleAccount.getUin()));
        } else {
            bool = null;
        }
        QLog.d("AccountListProcessor", 2, "onSelectAccountClick AccountManageActivity-changeAccountClick" + bool);
        AppInterface f17 = this$0.f();
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(f17, "dc00898", "", "", "0X800BDF0", "0X800BDF0", 0, 0, str, "", "", "");
    }

    private final void D(final String uin) {
        Activity e16 = e();
        if (e16 == null) {
            return;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Activity e17 = e();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = e16.getString(R.string.f211135k0);
        Intrinsics.checkNotNullExpressionValue(string, "requiredActivity.getStri\u2026gin_clear_account_prompt)");
        String format = String.format(string, Arrays.copyOf(new Object[]{uin}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(e17, 230, null, format, e16.getString(R.string.f211145k1), booleanRef.element, e16.getString(R.string.f211115jy), e16.getString(R.string.f211125jz), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.account.processors.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AccountListProcessor.E(Ref.BooleanRef.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.account.processors.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AccountListProcessor.F(AccountListProcessor.this, booleanRef, uin, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.account.processors.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AccountListProcessor.G(AccountListProcessor.this, dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createDialogWithCheckBox, "createDialogWithCheckBox\u2026         )\n            })");
        createDialogWithCheckBox.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Ref.BooleanRef isClearHistory, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(isClearHistory, "$isClearHistory");
        isClearHistory.element = !isClearHistory.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final AccountListProcessor this$0, Ref.BooleanRef isClearHistory, final String str, DialogInterface dialogInterface, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(isClearHistory, "$isClearHistory");
        AppInterface f16 = this$0.f();
        if (isClearHistory.element) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        ReportController.o(f16, "dc00898", "", "", "0X800C21B", "0X800C21B", i16, 0, "2", "", "", "");
        ((ISettingApi) QRoute.api(ISettingApi.class)).deleteAccount(str, isClearHistory.element, this$0.e(), new Function0<Unit>(str) { // from class: com.tencent.mobileqq.account.processors.AccountListProcessor$showDeleteAccountPromptDialog$deleteAccountPromptDialog$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $uin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$uin = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountListProcessor.this, (Object) str);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.mobileqq.account.viewmodel.a aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.i("AccountListProcessor", 2, "onDeleteAccountSuccess");
                aVar = AccountListProcessor.this.vm;
                aVar.T1(this.$uin, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(AccountListProcessor this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.o(this$0.f(), "dc00898", "", "", "0X800C21C", "0X800C21C", 0, 0, "2", "", "", "");
    }

    private final void H() {
        String str;
        ReportController.r(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(e(), 230);
        Activity e16 = e();
        String str2 = null;
        if (e16 != null) {
            str = e16.getString(R.string.f173179hs4);
        } else {
            str = null;
        }
        QQCustomDialog title = createCustomDialog.setTitle(str);
        Activity e17 = e();
        if (e17 != null) {
            str2 = e17.getString(R.string.f173178hs3);
        }
        QQCustomDialog message = title.setMessage(str2);
        Intrinsics.checkNotNullExpressionValue(message, "createCustomDialog(activ\u2026count_change_failed_tip))");
        message.setPositiveButton(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.account.processors.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AccountListProcessor.I(AccountListProcessor.this, dialogInterface, i3);
            }
        });
        message.setCancelable(true);
        message.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(AccountListProcessor this$0, DialogInterface dialogInterface, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("AccountListProcessor", 1, "switchFail, to LoginActivity");
        ReportController.r(null, "dc00898", "", "", "0X800B430", "0X800B430", 0, 0, "", "", "", "");
        Intent intent = new Intent();
        intent.putExtra("is_change_account", true);
        intent.putExtra("login_from_account_change", true);
        intent.putExtra("switch_account_fail", true);
        SimpleAccount simpleAccount = this$0.switchAccount;
        if (simpleAccount != null) {
            str = simpleAccount.getUin();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("uin", str);
        }
        AppInterface f16 = this$0.f();
        Intrinsics.checkNotNull(f16);
        intent.putExtra("befault_uin", f16.getCurrentAccountUin());
        RouteUtils.startActivityForResult(this$0.e(), intent, RouterConstants.UI_ROUTER_LOGIN, 9876);
    }

    @Override // w51.a
    public void a(@Nullable String maskedUin, @Nullable String loginToken) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) maskedUin, (Object) loginToken);
            return;
        }
        QLog.d("AccountListProcessor", 1, "add account");
        if (!B()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("IS_ADD_ACCOUNT", true);
        intent.putExtra("login_from_account_change", true);
        Activity e16 = e();
        if (e16 != null) {
            str = e16.getString(R.string.f199974qv);
        } else {
            str = null;
        }
        intent.putExtra("key_login_page_title", str);
        intent.putExtra("key_login_page_entrance", 3);
        intent.putExtra("loginFragmentType", 5);
        RouteUtils.startActivityForResult(e(), intent, RouterConstants.UI_ROUTER_LOGIN, 1000);
        ((ISubAccountAssistantForward) QRoute.api(ISubAccountAssistantForward.class)).doSomethingBeforeAddAccount(f(), e());
        ReportController.o(f(), "CliOper", "", "", "Setting_tab", "Clk_acc_add", 0, 0, "", "", "", "");
        ReportController.y(f(), "0X800B837");
    }

    @Override // w51.a
    public void b(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) uin);
        } else if (B() && !TextUtils.isEmpty(uin)) {
            D(uin);
            ReportController.o(f(), "dc00898", "", "", "0X800C21A", "0X800C21A", 0, 0, "", "", "", "");
            ReportController.o(f(), "CliOper", "", "", "Setting_tab", "Clk_acc_edit_delete", 0, 0, "", "", "", "");
        }
    }

    @Override // w51.a
    public void c(@Nullable final SimpleAccount sa5) {
        int i3;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) sa5);
            return;
        }
        List<QQAccount> value = this.vm.M1().getValue();
        if (value != null) {
            i3 = value.size();
        } else {
            i3 = 0;
        }
        ReportController.o(f(), "CliOper", "", "", "0X8004038", "0X8004038", 0, 0, String.valueOf(i3), "", "", "");
        if (sa5 != null) {
            String uin = sa5.getUin();
            AppInterface f16 = f();
            if (f16 != null) {
                str2 = f16.getCurrentAccountUin();
            } else {
                str2 = null;
            }
            if (!Intrinsics.areEqual(uin, str2) && !B()) {
                return;
            }
        }
        if (QLog.isColorLevel() && sa5 != null) {
            QLog.d("AccountListProcessor", 2, "switch uin:" + sa5.getUin());
        }
        if (sa5 != null) {
            String uin2 = sa5.getUin();
            AppInterface f17 = f();
            if (f17 != null) {
                str = f17.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(uin2, str)) {
                ReportController.o(f(), "CliOper", "", "", "0X8009C05", "0X8009C05", 0, 0, "", "", "", "");
                this.switchAccount = sa5;
                this.isClickAccountFromThis = true;
                if (sa5.isLogined()) {
                    ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginStart(18, 8, sa5.getUin());
                }
                ReportController.o(f(), "dc00898", "", "", "0X800AC38", "0X800AC38", 0, 0, sa5.getUin(), "", "", "");
                QRouteApi api = QRoute.api(IDirectLoginService.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IDirectLoginService::class.java)");
                ((IDirectLoginService) api).switchAccount(sa5.getUin(), null);
                ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(sa5.getUin(), (byte) 0);
                ((ISubAccountAssistantForward) QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccount(f(), e());
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.account.processors.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountListProcessor.C(AccountListProcessor.this, sa5);
                    }
                }, 32, null, false);
                ((IQEstApi) QRoute.api(IQEstApi.class)).rtReportSecInfo(5);
            }
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).clearLastAlbumInfo();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            if (!k()) {
                return;
            }
            super.n();
            this.isClickAccountFromThis = false;
            H();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.o();
        if (this.isClickAccountFromThis) {
            this.isClickAccountFromThis = false;
            l();
            ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginFinish(true, "");
            return;
        }
        this.vm.L1();
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onCreate();
        ReportController.y(f(), "0X800B7D3");
        this.vm.L1();
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            this.vm.L1();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.account.configs.a(this.vm, this.owner, this);
    }
}
