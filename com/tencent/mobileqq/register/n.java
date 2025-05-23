package com.tencent.mobileqq.register;

import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LoginPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.ao;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.register.fragment.GatewayRegisterFragment;
import com.tencent.mobileqq.register.fragment.RegisterPhoneNumFragment;
import com.tencent.mobileqq.util.aj;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.util.ce;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002JB\u0010\u0015\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bR\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010!R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/register/n;", "", "", "l", "f", "g", "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "", "isFromGatewayRegister", "hasCheckedAgreement", tl.h.F, "k", "j", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "from", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "isNeedGatewayRegister", "isFromOldAddAccount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/ref/WeakReference;", "b", "Ljava/lang/ref/WeakReference;", "mActivityRef", "Landroid/app/Dialog;", "c", "mLoadingRef", "d", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "mWechatInfo", "e", "Z", "mIsWechatRegister", "mIsGettingPhone", "mIsFromOldAddAccount", "mIsFromGatewayRegister", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f280469a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<QBaseActivity> mActivityRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<Dialog> mLoadingRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WechatInfo mWechatInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsWechatRegister;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsGettingPhone;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsFromOldAddAccount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsFromGatewayRegister;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/register/n$a", "Lcom/tencent/mobileqq/util/aj$c;", "", UIJsPlugin.EVENT_SHOW_LOADING, "a", UIJsPlugin.EVENT_HIDE_LOADING, "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements aj.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.util.aj.c
        public void a() {
            QBaseActivity qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                WeakReference weakReference = n.mActivityRef;
                if (weakReference != null) {
                    qBaseActivity = (QBaseActivity) weakReference.get();
                } else {
                    qBaseActivity = null;
                }
                QBaseActivity qBaseActivity2 = qBaseActivity;
                if (ce.d(qBaseActivity2)) {
                    return;
                }
                Intrinsics.checkNotNull(qBaseActivity2);
                QLog.i("RegisterHelper", 1, "getMaskPhoneInfo, doAction");
                n.mIsGettingPhone = false;
                if (aj.f306554f.g()) {
                    n.f280469a.g();
                    return;
                } else {
                    n.i(n.f280469a, qBaseActivity2, false, false, 4, null);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.mobileqq.util.aj.c
        public void hideLoading() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                n.f280469a.j();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.util.aj.c
        public void showLoading() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                n.f280469a.k();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f280469a = new n();
        }
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void f() {
        aj.f306554f.p(new a(), 8000L);
        cb.d("0X800C1F6");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        QBaseActivity qBaseActivity;
        WeakReference<QBaseActivity> weakReference = mActivityRef;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        if (ce.d(qBaseActivity)) {
            return;
        }
        Intrinsics.checkNotNull(qBaseActivity);
        j();
        Intent intent = new Intent();
        intent.putExtra("key_wechat_binding_info", mWechatInfo);
        intent.putExtra("key_is_from_old_add_account", mIsFromOldAddAccount);
        LoginPublicFragmentActivity.INSTANCE.a(qBaseActivity, intent, GatewayRegisterFragment.class);
    }

    private final void h(QBaseActivity context, boolean isFromGatewayRegister, boolean hasCheckedAgreement) {
        boolean z16;
        j();
        if (!hasCheckedAgreement && !mIsWechatRegister) {
            z16 = false;
        } else {
            z16 = true;
        }
        RegisterPhoneNumFragment.INSTANCE.a(context, mWechatInfo, z16, mIsFromOldAddAccount, isFromGatewayRegister);
    }

    static /* synthetic */ void i(n nVar, QBaseActivity qBaseActivity, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        nVar.h(qBaseActivity, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        QBaseActivity qBaseActivity;
        Dialog dialog;
        try {
            WeakReference<QBaseActivity> weakReference = mActivityRef;
            if (weakReference != null) {
                qBaseActivity = weakReference.get();
            } else {
                qBaseActivity = null;
            }
            if (ce.d(qBaseActivity)) {
                return;
            }
            WeakReference<Dialog> weakReference2 = mLoadingRef;
            if (weakReference2 != null) {
                dialog = weakReference2.get();
            } else {
                dialog = null;
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            mLoadingRef = null;
        } catch (Exception unused) {
            QLog.e("RegisterHelper", 1, "error : e");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        QBaseActivity qBaseActivity;
        WeakReference<QBaseActivity> weakReference = mActivityRef;
        Dialog dialog = null;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        if (ce.d(qBaseActivity)) {
            return;
        }
        WeakReference<Dialog> weakReference2 = mLoadingRef;
        if (weakReference2 != null) {
            dialog = weakReference2.get();
        }
        if (dialog == null) {
            dialog = LoadingUtil.showLoadingDialog(qBaseActivity, HardCodeUtil.qqStr(R.string.f211365km), false);
            mLoadingRef = new WeakReference<>(dialog);
        }
        if (dialog != null) {
            dialog.show();
        }
    }

    private final void l() {
        if (mIsGettingPhone) {
            QLog.d("RegisterHelper", 2, "is getting mask phone");
        } else if (aj.f306554f.g()) {
            g();
        } else {
            mIsGettingPhone = true;
            f();
        }
    }

    public final void m(@Nullable QBaseActivity activity, int from, @Nullable WechatInfo wechatInfo, boolean isNeedGatewayRegister, boolean hasCheckedAgreement, boolean isFromOldAddAccount, boolean isFromGatewayRegister) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, Integer.valueOf(from), wechatInfo, Boolean.valueOf(isNeedGatewayRegister), Boolean.valueOf(hasCheckedAgreement), Boolean.valueOf(isFromOldAddAccount), Boolean.valueOf(isFromGatewayRegister));
            return;
        }
        QLog.d("RegisterHelper", 1, "register context = " + activity + ", mIsFromOldAddAccount = " + mIsFromOldAddAccount + ",mIsFromGatewayRegister = " + mIsFromGatewayRegister);
        if (activity == null) {
            return;
        }
        ao.INSTANCE.g(from);
        mWechatInfo = wechatInfo;
        if (wechatInfo != null) {
            z16 = true;
        }
        mIsWechatRegister = z16;
        mActivityRef = new WeakReference<>(activity);
        mLoadingRef = null;
        mIsFromOldAddAccount = isFromOldAddAccount;
        mIsFromGatewayRegister = isFromGatewayRegister;
        if (isNeedGatewayRegister) {
            l();
        } else {
            h(activity, isFromGatewayRegister, hasCheckedAgreement);
        }
    }
}
