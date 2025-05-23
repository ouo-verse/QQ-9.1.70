package com.tencent.mobileqq.login.relogin.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/login/relogin/dialog/AccountManagerComponent$showAccountManagerDialog$listener$1", "Lcom/tencent/mobileqq/login/relogin/dialog/h;", "Lcom/tencent/mobileqq/login/account/a;", "account", "", "b", "d", "a", "Lcom/tencent/mobileqq/login/relogin/dialog/y;", "dialog", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class AccountManagerComponent$showAccountManagerDialog$listener$1 implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f242429a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccountManagerComponent f242430b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountManagerComponent$showAccountManagerDialog$listener$1(Activity activity, AccountManagerComponent accountManagerComponent) {
        this.f242429a = activity;
        this.f242430b = accountManagerComponent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) accountManagerComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Ref.BooleanRef clearHistory, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(clearHistory, "$clearHistory");
        clearHistory.element = !clearHistory.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final Activity activity, Ref.BooleanRef clearHistory, final AccountManagerComponent this$0, final com.tencent.mobileqq.login.account.a account, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(clearHistory, "$clearHistory");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        final Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(activity, activity.getString(R.string.akr), false);
        if (clearHistory.element && showLoadingDialog != null) {
            try {
                showLoadingDialog.show();
            } catch (Exception e16) {
                QLog.e("BaseLoginFragment", 1, "showLoading exception", e16);
            }
        }
        this$0.n(activity, account, clearHistory.element, new Function1<List<? extends com.tencent.mobileqq.login.account.a>, Unit>(showLoadingDialog, this$0, activity, account) { // from class: com.tencent.mobileqq.login.relogin.dialog.AccountManagerComponent$showAccountManagerDialog$listener$1$deleteAccount$dialog$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.login.account.a $account;
            final /* synthetic */ Activity $activity;
            final /* synthetic */ Dialog $loadingDialog;
            final /* synthetic */ AccountManagerComponent this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$loadingDialog = showLoadingDialog;
                this.this$0 = this$0;
                this.$activity = activity;
                this.$account = account;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, showLoadingDialog, this$0, activity, account);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.login.account.a> list) {
                invoke2((List<com.tencent.mobileqq.login.account.a>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<com.tencent.mobileqq.login.account.a> it) {
                boolean v3;
                y yVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                this.$loadingDialog.dismiss();
                v3 = this.this$0.v(this.$activity, this.$account.f());
                if (v3 || it.isEmpty()) {
                    this.this$0.t();
                } else {
                    yVar = this.this$0.mDialog;
                    if (yVar != null) {
                        yVar.i0(it, this.$account.f());
                    }
                }
                com.tencent.mobileqq.login.account.d.f241848a.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Ref.BooleanRef needConfirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(needConfirm, "$needConfirm");
        needConfirm.element = !needConfirm.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Ref.BooleanRef needConfirm, final AccountManagerComponent this$0, final Activity activity, final com.tencent.mobileqq.login.account.a account, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(needConfirm, "$needConfirm");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        if (!needConfirm.element) {
            this$0.w(false);
        }
        this$0.q(activity, account, new Function1<List<? extends com.tencent.mobileqq.login.account.a>, Unit>(account, activity) { // from class: com.tencent.mobileqq.login.relogin.dialog.AccountManagerComponent$showAccountManagerDialog$listener$1$deletePassword$dialog$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.login.account.a $account;
            final /* synthetic */ Activity $activity;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$account = account;
                this.$activity = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AccountManagerComponent.this, account, activity);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.login.account.a> list) {
                invoke2((List<com.tencent.mobileqq.login.account.a>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<com.tencent.mobileqq.login.account.a> it) {
                y yVar;
                boolean v3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                yVar = AccountManagerComponent.this.mDialog;
                if (yVar != null) {
                    yVar.i0(it, this.$account.f());
                }
                v3 = AccountManagerComponent.this.v(this.$activity, this.$account.f());
                if (v3) {
                    AccountManagerComponent.this.t();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.login.relogin.dialog.h
    public void a(@NotNull com.tencent.mobileqq.login.account.a account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) account);
        } else {
            Intrinsics.checkNotNullParameter(account, "account");
            QLog.d("AccountManagerComponent", 1, "selectAccount do nothing");
        }
    }

    @Override // com.tencent.mobileqq.login.relogin.dialog.h
    public void b(@NotNull final com.tencent.mobileqq.login.account.a account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) account);
            return;
        }
        Intrinsics.checkNotNullParameter(account, "account");
        QLog.i("AccountManagerComponent", 2, "deleteAccount uin=" + account.f());
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Activity activity = this.f242429a;
        Intrinsics.checkNotNull(activity);
        String string = this.f242429a.getString(R.string.f200234rk);
        String string2 = this.f242429a.getString(R.string.f200224rj, account.f());
        String string3 = this.f242429a.getString(R.string.f211145k1);
        String string4 = this.f242429a.getString(R.string.f200204rh);
        String string5 = this.f242429a.getString(R.string.f200214ri);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AccountManagerComponent$showAccountManagerDialog$listener$1.k(Ref.BooleanRef.this, dialogInterface, i3);
            }
        };
        final Activity activity2 = this.f242429a;
        final AccountManagerComponent accountManagerComponent = this.f242430b;
        QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(activity, 230, string, string2, string3, false, string4, string5, onClickListener, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AccountManagerComponent$showAccountManagerDialog$listener$1.l(activity2, booleanRef, accountManagerComponent, account, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AccountManagerComponent$showAccountManagerDialog$listener$1.m(dialogInterface, i3);
            }
        });
        createDialogWithCheckBox.setCanceledOnTouchOutside(true);
        createDialogWithCheckBox.show();
    }

    @Override // com.tencent.mobileqq.login.relogin.dialog.h
    public void c(@NotNull y dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dialog);
        } else {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            this.f242430b.t();
        }
    }

    @Override // com.tencent.mobileqq.login.relogin.dialog.h
    public void d(@NotNull final com.tencent.mobileqq.login.account.a account) {
        boolean u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) account);
            return;
        }
        Intrinsics.checkNotNullParameter(account, "account");
        Activity activity = this.f242429a;
        if (activity != null && !activity.isFinishing()) {
            QLog.i("AccountManagerComponent", 2, "deletePassword uin=" + account.f());
            u16 = this.f242430b.u();
            if (!u16) {
                final AccountManagerComponent accountManagerComponent = this.f242430b;
                final Activity activity2 = this.f242429a;
                accountManagerComponent.q(activity2, account, new Function1<List<? extends com.tencent.mobileqq.login.account.a>, Unit>(account, activity2) { // from class: com.tencent.mobileqq.login.relogin.dialog.AccountManagerComponent$showAccountManagerDialog$listener$1$deletePassword$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.mobileqq.login.account.a $account;
                    final /* synthetic */ Activity $activity;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$account = account;
                        this.$activity = activity2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AccountManagerComponent.this, account, activity2);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.login.account.a> list) {
                        invoke2((List<com.tencent.mobileqq.login.account.a>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull List<com.tencent.mobileqq.login.account.a> it) {
                        y yVar;
                        boolean v3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        yVar = AccountManagerComponent.this.mDialog;
                        if (yVar != null) {
                            yVar.i0(it, this.$account.f());
                        }
                        v3 = AccountManagerComponent.this.v(this.$activity, this.$account.f());
                        if (v3) {
                            AccountManagerComponent.this.t();
                        }
                    }
                });
                return;
            }
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            Activity activity3 = this.f242429a;
            String string = activity3.getString(R.string.f200284rp);
            String string2 = this.f242429a.getString(R.string.f200274ro);
            String string3 = this.f242429a.getString(R.string.f200484s9);
            String string4 = this.f242429a.getString(R.string.f200254rm);
            String string5 = this.f242429a.getString(R.string.f200264rn);
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.r
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AccountManagerComponent$showAccountManagerDialog$listener$1.n(Ref.BooleanRef.this, dialogInterface, i3);
                }
            };
            final AccountManagerComponent accountManagerComponent2 = this.f242430b;
            final Activity activity4 = this.f242429a;
            QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(activity3, 230, string, string2, string3, false, string4, string5, onClickListener, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.s
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AccountManagerComponent$showAccountManagerDialog$listener$1.o(Ref.BooleanRef.this, accountManagerComponent2, activity4, account, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.dialog.t
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AccountManagerComponent$showAccountManagerDialog$listener$1.p(dialogInterface, i3);
                }
            });
            createDialogWithCheckBox.setCanceledOnTouchOutside(true);
            createDialogWithCheckBox.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DialogInterface dialogInterface, int i3) {
    }
}
