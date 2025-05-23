package com.tencent.mobileqq.accountbinding;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.accountbinding.fragment.AccountBindingFragment;
import com.tencent.mobileqq.accountbinding.net.AccountBindingHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0016\u0010 \u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/accountbinding/d;", "", "", "profileSig", "", "i", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isSplashActivity", "e", "contentText", "rightBtnText", "j", "g", "uin", h.F, "Lcom/tencent/mobileqq/wxapi/IWXAuthApi$b;", "callback", "f", "b", "Ljava/lang/String;", "mProfileSig", "", "c", "J", "mTime", "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "mActivityRef", "mCurrentBindingAccount", "mCurrentBindingAccountTimeout", "Z", "mIsSplashActivity", "Lcom/tencent/mobileqq/accountbinding/net/AccountBindingHandler$b;", "Lcom/tencent/mobileqq/accountbinding/net/AccountBindingHandler$b;", "getMCallback", "()Lcom/tencent/mobileqq/accountbinding/net/AccountBindingHandler$b;", "mCallback", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f174609a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String mProfileSig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<QBaseActivity> mActivityRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String mCurrentBindingAccount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long mCurrentBindingAccountTimeout;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsSplashActivity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AccountBindingHandler.b mCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/accountbinding/d$a", "Lcom/tencent/mobileqq/accountbinding/net/AccountBindingHandler$c;", "", "Lcom/tencent/mobileqq/accountbinding/data/b;", "infos", "", "onSuccess", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class a implements AccountBindingHandler.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IWXAuthApi.b f174617a;

        a(IWXAuthApi.b bVar) {
            this.f174617a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.c
        public void onFail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f174617a.onResult(false);
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.c
        public void onSuccess(@Nullable List<? extends com.tencent.mobileqq.accountbinding.data.b> infos) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) infos);
                return;
            }
            List<? extends com.tencent.mobileqq.accountbinding.data.b> list = infos;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this.f174617a.onResult(false);
                return;
            }
            for (com.tencent.mobileqq.accountbinding.data.b bVar : infos) {
                bVar.j(true);
                if (bVar.a() == 1) {
                    this.f174617a.onResult(true);
                    return;
                }
            }
            this.f174617a.onResult(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/accountbinding/d$b", "Lcom/tencent/mobileqq/accountbinding/net/AccountBindingHandler$b;", "Lcom/tencent/mobileqq/accountbinding/data/b;", "info", "", "a", "", "type", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b implements AccountBindingHandler.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.b
        public void a(@Nullable com.tencent.mobileqq.accountbinding.data.b info) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                return;
            }
            QLog.i("AccountBindingManager", 1, "account bind success");
            String str2 = null;
            if (info != null) {
                str = info.e();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                e.f(str);
            }
            if (info != null) {
                str2 = info.d();
            }
            e.e(str2);
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.b
        public void onFail(int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, type);
                return;
            }
            QLog.e("AccountBindingManager", 1, "account bind failed, fail type is " + type);
            if (type != 0) {
                if (type == 1) {
                    d dVar = d.f174609a;
                    String qqStr = HardCodeUtil.qqStr(R.string.f200334ru);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_login_\u2026hat_binding_relationship)");
                    String qqStr2 = HardCodeUtil.qqStr(R.string.f200314rs);
                    Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qq_login_\u2026g_change_binding_account)");
                    dVar.j(qqStr, qqStr2);
                    return;
                }
                return;
            }
            d dVar2 = d.f174609a;
            String qqStr3 = HardCodeUtil.qqStr(R.string.f200344rv);
            Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.qq_login_\u2026og_wechat_binding_failed)");
            String qqStr4 = HardCodeUtil.qqStr(R.string.f200304rr);
            Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.qq_login_dialog_bind_account)");
            dVar2.j(qqStr3, qqStr4);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17387);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f174609a = new d();
        mIsSplashActivity = true;
        mCallback = new b();
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void e(@Nullable QBaseActivity activity, boolean isSplashActivity) {
        if (!TextUtils.isEmpty(mProfileSig) && activity != null) {
            if (System.currentTimeMillis() - mTime > 10000) {
                mProfileSig = null;
                return;
            }
            if (!MobileQQ.sMobileQQ.peekAppRuntime().isLogin()) {
                QLog.i("AccountBindingManager", 1, "app.isLogin is false");
                return;
            }
            mIsSplashActivity = isSplashActivity;
            mActivityRef = new WeakReference<>(activity);
            QLog.i("AccountBindingManager", 1, "bind wechat start");
            new com.tencent.mobileqq.accountbinding.component.f(activity).p(mProfileSig, 1, new com.tencent.mobileqq.accountbinding.data.b().i(((IWXAuthApi) QRoute.api(IWXAuthApi.class)).getWXAppId()), "", mCallback);
            mProfileSig = null;
        }
    }

    @JvmStatic
    public static final void i(@Nullable String profileSig) {
        mProfileSig = profileSig;
        mTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final String contentText, final String rightBtnText) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.a
            @Override // java.lang.Runnable
            public final void run() {
                d.k(contentText, rightBtnText);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String contentText, String rightBtnText) {
        QBaseActivity qBaseActivity;
        Intrinsics.checkNotNullParameter(contentText, "$contentText");
        Intrinsics.checkNotNullParameter(rightBtnText, "$rightBtnText");
        WeakReference<QBaseActivity> weakReference = mActivityRef;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        final QBaseActivity qBaseActivity2 = qBaseActivity;
        if (qBaseActivity2 != null && !qBaseActivity2.isFinishing()) {
            DialogUtil.createCustomDialog(qBaseActivity2, 230, HardCodeUtil.qqStr(R.string.f200744sy), contentText, HardCodeUtil.qqStr(R.string.nvd), rightBtnText, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.accountbinding.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    d.l(QBaseActivity.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.accountbinding.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    d.m(dialogInterface, i3);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(QBaseActivity qBaseActivity, DialogInterface dialogInterface, int i3) {
        AccountBindingFragment.yh(qBaseActivity, mIsSplashActivity, null);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    public final void f(@NotNull IWXAuthApi.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("login_binging_wechat_red_point_guide_switch", false);
        QLog.d("AccountBindingManager", 1, "checkNeedShowRedDotGuid united config status: " + isSwitchOn);
        if (!isSwitchOn) {
            return;
        }
        if (e.f174633a.a()) {
            QLog.d("AccountBindingManager", 1, "checkNeedShowRedDotGuide has click red dot");
            callback.onResult(true);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        BusinessHandler businessHandler = appInterface.getBusinessHandler(AccountBindingHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.accountbinding.net.AccountBindingHandler");
        ((AccountBindingHandler) businessHandler).J2(appInterface.getLongAccountUin(), new a(callback));
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (mCurrentBindingAccount != null && System.currentTimeMillis() > mCurrentBindingAccountTimeout) {
            QLog.i("AccountBindingManager", 1, "getCurrentBindingAccount timeout uin=" + mCurrentBindingAccount);
            mCurrentBindingAccount = null;
        }
        return mCurrentBindingAccount;
    }

    public final void h(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin);
            return;
        }
        QLog.i("AccountBindingManager", 1, "setCurrentBindingAccount uin=" + uin);
        mCurrentBindingAccount = uin;
        mCurrentBindingAccountTimeout = System.currentTimeMillis() + ((long) 300000);
    }
}
