package com.tencent.mobileqq.register.prettyaccount;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.login.aa;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.al;
import com.tencent.mobileqq.login.c;
import com.tencent.mobileqq.login.fragment.l;
import com.tencent.mobileqq.login.y;
import com.tencent.mobileqq.loginregister.callback.RegisterResult;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.fragment.GatewayRegisterFragment;
import com.tencent.mobileqq.register.fragment.RegisterPhoneNumFragment;
import com.tencent.mobileqq.register.prettyaccount.PrettyAccountRegisterAutoLoginHelper;
import com.tencent.mobileqq.register.q;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J(\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/register/prettyaccount/PrettyAccountRegisterAutoLoginHelper;", "", "", "l", "", "uin", "pwd", "", "superSig", "Lcom/tencent/mobileqq/login/aa;", "loginCallback", "j", "", "msgId", "icon", DomainData.DOMAIN_NAME, "p", "i", "o", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Dialog;", "a", "Landroid/app/Dialog;", "loadingDialog", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLogging", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lmqq/os/MqqHandler;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mqqHandlerList", "d", "Lcom/tencent/mobileqq/login/aa;", "e", "internalLoginCallback", "<init>", "()V", "f", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PrettyAccountRegisterAutoLoginHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Handler f280532g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isLogging;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.qqnt.avatar.meta.refresh.c<MqqHandler>> mqqHandlerList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private aa loginCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private aa internalLoginCallback;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/register/prettyaccount/PrettyAccountRegisterAutoLoginHelper$a;", "", "Lkotlin/Function0;", "", "block", "b", "", "DELAY_TIME", "J", "", "TAG", "Ljava/lang/String;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.prettyaccount.PrettyAccountRegisterAutoLoginHelper$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function0 tmp0) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }

        public final void b(@NotNull final Function0<Unit> block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) block);
                return;
            }
            Intrinsics.checkNotNullParameter(block, "block");
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                block.invoke();
            } else {
                PrettyAccountRegisterAutoLoginHelper.f280532g.post(new Runnable() { // from class: com.tencent.mobileqq.register.prettyaccount.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        PrettyAccountRegisterAutoLoginHelper.Companion.c(Function0.this);
                    }
                });
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/register/prettyaccount/PrettyAccountRegisterAutoLoginHelper$b", "Lcom/tencent/mobileqq/login/y;", "", "msg", "", "a", "", "loginSuccess", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements y {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.login.y
        public void a(@Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
            }
        }

        @Override // com.tencent.mobileqq.login.y
        public void b(boolean loginSuccess) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, loginSuccess);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/register/prettyaccount/PrettyAccountRegisterAutoLoginHelper$c", "Lcom/tencent/mobileqq/login/aa;", "", "uin", "Landroid/os/Bundle;", "bundle", "", "c", "Lcom/tencent/mobileqq/login/aj;", "failedInfo", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements aa {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrettyAccountRegisterAutoLoginHelper.this);
            }
        }

        @Override // com.tencent.mobileqq.login.aa
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QLog.i("PrettyAccountRegisterAutoLoginHelper", 1, "loginCallback onLoginCancel");
            PrettyAccountRegisterAutoLoginHelper.this.k();
            aa aaVar = PrettyAccountRegisterAutoLoginHelper.this.loginCallback;
            if (aaVar != null) {
                aaVar.a();
            }
            PrettyAccountRegisterAutoLoginHelper.this.isLogging.set(false);
        }

        @Override // com.tencent.mobileqq.login.aa
        public void b(@NotNull aj failedInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) failedInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(failedInfo, "failedInfo");
            QLog.i("PrettyAccountRegisterAutoLoginHelper", 1, "loginCallback onLoginFailed, ret: " + failedInfo.f241864a + ", uin: " + MsfSdkUtils.getShortUin(failedInfo.f241871h) + ", msg: " + failedInfo.f241866c);
            PrettyAccountRegisterAutoLoginHelper.this.k();
            aa aaVar = PrettyAccountRegisterAutoLoginHelper.this.loginCallback;
            if (aaVar != null) {
                aaVar.b(failedInfo);
            }
            PrettyAccountRegisterAutoLoginHelper.this.isLogging.set(false);
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
            com.tencent.mobileqq.loginregister.callback.b d16 = q.c().d();
            if (d16 != null) {
                d16.a(RegisterResult.RegisterAndLoginSuccess);
            }
            QLog.d("PrettyAccountRegisterAutoLoginHelper", 1, "loginCallback onLoginSuccess");
            PrettyAccountRegisterAutoLoginHelper.this.k();
            aa aaVar = PrettyAccountRegisterAutoLoginHelper.this.loginCallback;
            if (aaVar != null) {
                aaVar.c(uin, bundle);
            }
            PrettyAccountRegisterAutoLoginHelper.this.p();
            PrettyAccountRegisterAutoLoginHelper.this.isLogging.set(false);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f280532g = new Handler(Looper.getMainLooper());
        }
    }

    public PrettyAccountRegisterAutoLoginHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isLogging = new AtomicBoolean(false);
        this.mqqHandlerList = new CopyOnWriteArrayList<>();
        this.internalLoginCallback = new c();
    }

    private final void i() {
        if (!(MobileQQ.sMobileQQ.peekAppRuntime() instanceof AppInterface)) {
            QLog.e("PrettyAccountRegisterAutoLoginHelper", 1, "closeLoginAndRegisterAct, app is not appInterface");
            return;
        }
        l.c(l.f242160a, false, 1, null);
        synchronized (this.mqqHandlerList) {
            Iterator<com.tencent.qqnt.avatar.meta.refresh.c<MqqHandler>> it = this.mqqHandlerList.iterator();
            while (it.hasNext()) {
                MqqHandler mqqHandler = it.next().get();
                if (mqqHandler != null) {
                    mqqHandler.sendEmptyMessage(2004);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void j(String uin, String pwd, byte[] superSig, aa loginCallback) {
        o();
        this.loginCallback = loginCallback;
        byte[] mD5Byte = MD5.toMD5Byte(pwd);
        Intrinsics.checkNotNullExpressionValue(mD5Byte, "toMD5Byte(pwd)");
        com.tencent.mobileqq.phonelogin.a.a().e(true);
        al.b(1).login(null, new c.a(1, 5, uin, pwd).B(mD5Byte).C(superSig).r(), new b(), this.internalLoginCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        INSTANCE.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.register.prettyaccount.PrettyAccountRegisterAutoLoginHelper$hideLoading$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrettyAccountRegisterAutoLoginHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Dialog dialog;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    dialog = PrettyAccountRegisterAutoLoginHelper.this.loadingDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                } catch (Exception e16) {
                    QLog.e("PrettyAccountRegisterAutoLoginHelper", 1, "hideLoading exception", e16);
                }
                PrettyAccountRegisterAutoLoginHelper.this.loadingDialog = null;
            }
        });
    }

    private final void l() {
        AppInterface appInterface;
        this.mqqHandlerList.clear();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            MqqHandler handlerWithoutDefault = appInterface.getHandlerWithoutDefault(RegisterPhoneNumFragment.class);
            if (handlerWithoutDefault != null) {
                Intrinsics.checkNotNullExpressionValue(handlerWithoutDefault, "getHandlerWithoutDefault\u2026eNumFragment::class.java)");
                this.mqqHandlerList.add(new com.tencent.qqnt.avatar.meta.refresh.c<>(handlerWithoutDefault));
            }
            MqqHandler handlerWithoutDefault2 = appInterface.getHandlerWithoutDefault(GatewayRegisterFragment.class);
            if (handlerWithoutDefault2 != null) {
                Intrinsics.checkNotNullExpressionValue(handlerWithoutDefault2, "getHandlerWithoutDefault\u2026sterFragment::class.java)");
                this.mqqHandlerList.add(new com.tencent.qqnt.avatar.meta.refresh.c<>(handlerWithoutDefault2));
            }
        }
    }

    private final void n(int msgId, int icon) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return;
        }
        new QQToastNotifier(qBaseActivity).notifyUser(msgId, qBaseActivity.getTitleBarHeight(), 1, icon);
    }

    private final void o() {
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return;
        }
        INSTANCE.b(new Function0<Unit>(qBaseActivity) { // from class: com.tencent.mobileqq.register.prettyaccount.PrettyAccountRegisterAutoLoginHelper$showLoading$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QBaseActivity $activity;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$activity = qBaseActivity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrettyAccountRegisterAutoLoginHelper.this, (Object) qBaseActivity);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Dialog dialog;
                Dialog dialog2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    dialog = PrettyAccountRegisterAutoLoginHelper.this.loadingDialog;
                    if (dialog == null && !this.$activity.isFinishing()) {
                        PrettyAccountRegisterAutoLoginHelper.this.loadingDialog = LoadingUtil.showLoadingDialog(this.$activity, HardCodeUtil.qqStr(R.string.f211365km), false);
                    }
                    dialog2 = PrettyAccountRegisterAutoLoginHelper.this.loadingDialog;
                    if (dialog2 != null) {
                        dialog2.show();
                    }
                } catch (Exception e16) {
                    QLog.e("PrettyAccountRegisterAutoLoginHelper", 1, "showLoading exception", e16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        f280532g.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.register.prettyaccount.a
            @Override // java.lang.Runnable
            public final void run() {
                PrettyAccountRegisterAutoLoginHelper.q(PrettyAccountRegisterAutoLoginHelper.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(PrettyAccountRegisterAutoLoginHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            QRoute.createNavigator(qBaseActivity, RouterConstants.UI_ROUTER_SPLASH).withInt("tab_index", 0).withInt(SplashActivity.FRAGMENT_ID, 1).withBoolean("is_need_close_drawer", true).withFlags(67108864).requestWithReturn();
        }
        this$0.i();
    }

    public final void m(@NotNull String uin, @NotNull String pwd, @NotNull byte[] superSig, @Nullable aa loginCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uin, pwd, superSig, loginCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        Intrinsics.checkNotNullParameter(superSig, "superSig");
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            n(R.string.b3j, 0);
            if (loginCallback != null) {
                loginCallback.a();
                return;
            }
            return;
        }
        if (this.isLogging.compareAndSet(false, true)) {
            o();
            l();
            j(uin, pwd, superSig, loginCallback);
            return;
        }
        QLog.i("PrettyAccountRegisterAutoLoginHelper", 1, "call login method but now isLogging");
    }
}
