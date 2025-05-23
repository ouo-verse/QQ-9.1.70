package com.tencent.mobileqq.register;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LoginPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.callback.RegisterResult;
import com.tencent.mobileqq.loginregister.sms.RegisterVerifyResult;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.register.fragment.RegisterFailedFragment;
import com.tencent.mobileqq.register.fragment.RegisterNickAndPwdFragment;
import com.tencent.mobileqq.register.o;
import com.tencent.mobileqq.util.ce;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004J\b\u0010\u0006\u001a\u00020\u0004H\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0004J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004J\b\u0010\u0010\u001a\u00020\u0004H\u0004J\b\u0010\u0011\u001a\u00020\u0004H\u0004R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0013\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010$\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR$\u0010*\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010&\u001a\u0004\b\u001b\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/register/g;", "", "Landroid/os/Bundle;", "data", "", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Lcom/tencent/mobileqq/loginregister/sms/RegisterVerifyResult;", "result", tl.h.F, "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "", "protectUinsUrl", "c", "f", "g", "Lcom/tencent/mobileqq/loginregister/callback/b;", "a", "Lcom/tencent/mobileqq/loginregister/callback/b;", "getMRegisterCallback", "()Lcom/tencent/mobileqq/loginregister/callback/b;", "k", "(Lcom/tencent/mobileqq/loginregister/callback/b;)V", "mRegisterCallback", "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "()Lmqq/util/WeakReference;", "i", "(Lmqq/util/WeakReference;)V", "mActivityRef", "Landroid/app/Dialog;", "getMLoadingRef", "j", "mLoadingRef", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "()Lcom/tencent/mobileqq/register/bean/WechatInfo;", "l", "(Lcom/tencent/mobileqq/register/bean/WechatInfo;)V", "mWechatInfo", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class g {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.loginregister.callback.b mRegisterCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<QBaseActivity> mActivityRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Dialog> mLoadingRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WechatInfo mWechatInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/register/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.g$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/register/g$b", "Lcom/tencent/mobileqq/register/o$a;", "", "onSuccess", "onCancel", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements o.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f280440a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f280441b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RegisterVerifyResult f280442c;

        b(QBaseActivity qBaseActivity, g gVar, RegisterVerifyResult registerVerifyResult) {
            this.f280440a = qBaseActivity;
            this.f280441b = gVar;
            this.f280442c = registerVerifyResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qBaseActivity, gVar, registerVerifyResult);
            }
        }

        @Override // com.tencent.mobileqq.register.o.a
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f280441b.f();
            }
        }

        @Override // com.tencent.mobileqq.register.o.a
        public void onSuccess() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            RegisterNickAndPwdFragment.Companion companion = RegisterNickAndPwdFragment.INSTANCE;
            QBaseActivity qBaseActivity = this.f280440a;
            WechatInfo b16 = this.f280441b.b();
            RegisterVerifyResult registerVerifyResult = this.f280442c;
            if (registerVerifyResult != null) {
                str = registerVerifyResult.f242903e;
            } else {
                str = null;
            }
            companion.a(qBaseActivity, b16, str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24690);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WeakReference<QBaseActivity> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (WeakReference) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mActivityRef;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WechatInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (WechatInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mWechatInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(@NotNull QBaseActivity context, @NotNull String protectUinsUrl, @Nullable RegisterVerifyResult result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, context, protectUinsUrl, result);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(protectUinsUrl, "protectUinsUrl");
        QLog.d("BaseRegisterMainline", 1, "onCheckGatewayRegister gotoPhoneProtectUinsUrl");
        o.a(context, protectUinsUrl, new b(context, this, result));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(@Nullable Bundle data) {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) data);
            return;
        }
        QLog.i("BaseRegisterMainline", 1, "gotoReject");
        g();
        WeakReference<QBaseActivity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        if (ce.d(qBaseActivity)) {
            return;
        }
        Intrinsics.checkNotNull(qBaseActivity);
        Intent intent = new Intent();
        if (data != null) {
            intent.putExtras(data);
        }
        LoginPublicFragmentActivity.INSTANCE.a(qBaseActivity, intent, RegisterFailedFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        Dialog dialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        WeakReference<Dialog> weakReference = this.mLoadingRef;
        if (weakReference != null) {
            dialog = weakReference.get();
        } else {
            dialog = null;
        }
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.mobileqq.loginregister.callback.b bVar = this.mRegisterCallback;
        if (bVar != null) {
            bVar.a(RegisterResult.RegisterCancel);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        com.tencent.mobileqq.loginregister.callback.b bVar = this.mRegisterCallback;
        if (bVar != null) {
            bVar.a(RegisterResult.RegisterFailed);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(@Nullable RegisterVerifyResult result) {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) result);
            return;
        }
        if (result == null) {
            QLog.e("BaseRegisterMainline", 1, "onRegisterSmsVerifySuccess result is null");
            g();
            return;
        }
        QLog.i("BaseRegisterMainline", 1, "onRegisterSmsVerifySuccess isSendUpSms = " + result.f242905h);
        boolean isEmpty = TextUtils.isEmpty(result.f242904f) ^ true;
        WeakReference<QBaseActivity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        if (ce.d(qBaseActivity)) {
            g();
            return;
        }
        Intrinsics.checkNotNull(qBaseActivity);
        if (isEmpty) {
            String str = result.f242904f;
            Intrinsics.checkNotNullExpressionValue(str, "result.phoneProtectUinsUrl");
            c(qBaseActivity, str, result);
            return;
        }
        RegisterNickAndPwdFragment.INSTANCE.a(qBaseActivity, this.mWechatInfo, result.f242903e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(@Nullable WeakReference<QBaseActivity> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) weakReference);
        } else {
            this.mActivityRef = weakReference;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(@Nullable WeakReference<Dialog> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) weakReference);
        } else {
            this.mLoadingRef = weakReference;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(@Nullable com.tencent.mobileqq.loginregister.callback.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            this.mRegisterCallback = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(@Nullable WechatInfo wechatInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) wechatInfo);
        } else {
            this.mWechatInfo = wechatInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m() {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        WeakReference<QBaseActivity> weakReference = this.mActivityRef;
        Dialog dialog = null;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        if (ce.d(qBaseActivity)) {
            return;
        }
        WeakReference<Dialog> weakReference2 = this.mLoadingRef;
        if (weakReference2 != null) {
            dialog = weakReference2.get();
        }
        if (dialog == null) {
            dialog = LoadingUtil.showLoadingDialog(qBaseActivity, HardCodeUtil.qqStr(R.string.f211365km), false);
            this.mLoadingRef = new WeakReference<>(dialog);
        }
        if (dialog != null) {
            dialog.show();
        }
    }
}
