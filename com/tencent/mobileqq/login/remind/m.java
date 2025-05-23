package com.tencent.mobileqq.login.remind;

import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ*\u0010\u0010\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/login/remind/m;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "tlvData", "", "account", "Lcom/tencent/mobileqq/login/remind/h$b;", "loginCallback", "", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "loginResult", "k", tl.h.F, "e", "<init>", "()V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/login/remind/m$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.remind.m$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(h.b loginCallback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(loginCallback, "$loginCallback");
        loginCallback.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(h.b loginCallback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(loginCallback, "$loginCallback");
        loginCallback.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(h.b loginCallback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(loginCallback, "$loginCallback");
        loginCallback.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(h.b loginCallback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(loginCallback, "$loginCallback");
        loginCallback.a();
    }

    private final boolean k(QBaseActivity activity, LoginResult loginResult, String account, h.b loginCallback) {
        QLog.i("LoginRemindComponent", 2, "showRemindDialog account:" + account);
        if (account != null) {
            n.f242580a.a(account);
        }
        Dialog c16 = h.f242571a.c(activity, loginResult, loginCallback);
        if (c16 != null) {
            c16.show();
            QLog.i("LoginRemindComponent", 1, "buildDialogFromTlvData");
            return true;
        }
        return false;
    }

    private final boolean l(QBaseActivity activity, byte[] tlvData, String account, h.b loginCallback) {
        QLog.i("LoginRemindComponent", 2, "showRemindDialog account:" + account);
        n.f242580a.a(account);
        Dialog e16 = h.f242571a.e(activity, tlvData, loginCallback);
        if (e16 != null) {
            e16.show();
            QLog.i("LoginRemindComponent", 1, "buildDialogFromTlvData");
            return true;
        }
        return false;
    }

    public final boolean e(@Nullable QBaseActivity activity, @NotNull LoginResult loginResult, @Nullable String account, @NotNull final h.b loginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, activity, loginResult, account, loginCallback)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(loginResult, "loginResult");
        Intrinsics.checkNotNullParameter(loginCallback, "loginCallback");
        if (activity == null) {
            return false;
        }
        try {
            if (k(activity, loginResult, account, loginCallback)) {
                return true;
            }
            QLog.i("LoginRemindComponent", 1, "handleShowRemindDialog default");
            DialogUtil.createCustomDialog(activity, 230, "\u662f\u5426\u7ec8\u6b62\u6ce8\u9500\u6d41\u7a0b", "\u6b64\u8d26\u53f7\u5904\u4e8e\u6ce8\u9500\u53cd\u6094\u671f\uff0c\u82e5\u767b\u5f55\u6210\u529f\u5219\u89c6\u4f5c\u7ec8\u6b62\u6ce8\u9500\u6d41\u7a0b\u3002\u5982\u9700\u7ee7\u7eed\u6ce8\u9500\uff0c\u8bf7\u5728\u6ce8\u9500\u7533\u8bf7\u63d0\u4ea4\u540e\u768415\u5929\u5185\u4e0d\u8981\u767b\u5f55QQ\u3002", "\u8fd4\u56de", "\u7ee7\u7eed\u767b\u5f55", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    m.f(h.b.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    m.g(h.b.this, dialogInterface, i3);
                }
            }).show();
            return true;
        } catch (Exception e16) {
            QLog.e("LoginRemindComponent", 1, "handleShowRemindDialog error:" + e16);
            return false;
        }
    }

    public final boolean h(@Nullable QBaseActivity activity, @Nullable byte[] tlvData, @Nullable String account, @NotNull final h.b loginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, activity, tlvData, account, loginCallback)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(loginCallback, "loginCallback");
        if (activity == null) {
            return false;
        }
        try {
            if (l(activity, tlvData, account, loginCallback)) {
                return true;
            }
            QLog.i("LoginRemindComponent", 1, "handleShowRemindDialog default");
            DialogUtil.createCustomDialog(activity, 230, "\u662f\u5426\u7ec8\u6b62\u6ce8\u9500\u6d41\u7a0b", "\u6b64\u8d26\u53f7\u5904\u4e8e\u6ce8\u9500\u53cd\u6094\u671f\uff0c\u82e5\u767b\u5f55\u6210\u529f\u5219\u89c6\u4f5c\u7ec8\u6b62\u6ce8\u9500\u6d41\u7a0b\u3002\u5982\u9700\u7ee7\u7eed\u6ce8\u9500\uff0c\u8bf7\u5728\u6ce8\u9500\u7533\u8bf7\u63d0\u4ea4\u540e\u768415\u5929\u5185\u4e0d\u8981\u767b\u5f55QQ\u3002", "\u8fd4\u56de", "\u7ee7\u7eed\u767b\u5f55", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    m.i(h.b.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.remind.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    m.j(h.b.this, dialogInterface, i3);
                }
            }).show();
            return true;
        } catch (Exception e16) {
            QLog.e("LoginRemindComponent", 1, "handleShowRemindDialog error:" + e16);
            return false;
        }
    }
}
