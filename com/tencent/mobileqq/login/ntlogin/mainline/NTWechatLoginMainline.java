package com.tencent.mobileqq.login.ntlogin.mainline;

import android.os.Bundle;
import android.text.TextUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.accountbinding.fragment.WechatLoginBindingFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.login.account.impl.LoginAccountInfoApiImpl;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.bw;
import com.tencent.mobileqq.login.ntlogin.NTDevLockVerifyComponent;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.Account;
import com.tencent.qqnt.kernel.nativeinterface.CheckThirdCodeReq;
import com.tencent.qqnt.kernel.nativeinterface.CheckThirdCodeRsp;
import com.tencent.qqnt.kernel.nativeinterface.ICheckThirdCodeCallback;
import com.tencent.qqnt.kernel.nativeinterface.ILoginCallback;
import com.tencent.qqnt.kernel.nativeinterface.LoginProcessReqBody;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import com.tencent.qqnt.kernel.nativeinterface.LoginRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.OptimusLoginInfo;
import com.tencent.qqnt.kernel.nativeinterface.UinInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserProfile;
import com.tencent.qqnt.kernel.nativeinterface.VerifySuccessSign;
import com.tencent.qqnt.kernel.nativeinterface.VerifyType;
import com.tencent.qqnt.kernel.nativeinterface.WechatReqBody;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0013\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0005J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0014\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u0016J\u001b\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001d\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0011\u001a\u00020\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\u001cJ8\u0010,\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020\tH\u0002J\u0018\u00100\u001a\u00020\t2\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020&H\u0002J\b\u00102\u001a\u000201H\u0016J\b\u00103\u001a\u00020\u0003H\u0014J\"\u00105\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u00106\u001a\u00020\u0003H\u0014R\u0016\u00107\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010:\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010;\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTWechatLoginMainline;", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTBaseLoginMainline;", "Lcom/tencent/mobileqq/login/bw;", "", "startLoginByCoroutine", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "Lcom/tencent/mobileqq/login/ntlogin/mainline/i;", "", "startBindLogin", "(Lcom/tencent/mobileqq/register/bean/WechatInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uin", "Landroid/os/Bundle;", "bundle", "onBindLoginSuccess", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "loginInfo", "onNtLoginFailed", "getWXAuthCode", "wxCode", "queryBindState", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "profileSig", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginRspInfo;", "checkBindState", "Lcom/tencent/qqnt/kernel/nativeinterface/OptimusLoginInfo;", "wechatLogin", "(Lcom/tencent/qqnt/kernel/nativeinterface/OptimusLoginInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginResult", "newDevVerify", "(Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/UinInfo;", "uinInfo", "handleRemindLogin", "reLogin", "requestWechatLogin", "tValue", "", "result", "r2", "r3", "r4", "r5", "reportEvent", "getReportAuxiliaryInfo", "wxBindState", "qqBindState", "getReportBindState", "", "canLogin", "startLogin", "nick", "onNTLoginSuccess", "onLoginCancel", "mIsWeChatAuthing", "Z", "mHasDevLockVerify", "mHasBindLoginTransit", "mWxAppId", "Ljava/lang/String;", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NTWechatLoginMainline extends NTBaseLoginMainline<bw> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "NTLoginMainline_WechatLogin";
    private boolean mHasBindLoginTransit;
    private boolean mHasDevLockVerify;
    private boolean mIsWeChatAuthing;

    @NotNull
    private final String mWxAppId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTWechatLoginMainline$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.ntlogin.mainline.NTWechatLoginMainline$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckThirdCodeRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class b implements ICheckThirdCodeCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<LoginRspInfo>> f242312a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super i<LoginRspInfo>> cancellableContinuation) {
            this.f242312a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ICheckThirdCodeCallback
        public final void onResult(int i3, String str, CheckThirdCodeRsp checkThirdCodeRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, checkThirdCodeRsp);
                return;
            }
            QLog.d(NTWechatLoginMainline.TAG, 1, "checkBindState result: " + i3 + ", errMsg: " + str);
            CancellableContinuation<i<LoginRspInfo>> cancellableContinuation = this.f242312a;
            i iVar = new i(i3, str, checkThirdCodeRsp.loginRspInfo);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "wx login checkBindStatesafeResume call failed ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "errorCode", "", "kotlin.jvm.PlatformType", "errorMsg", "authCode", "", "a", "(ILjava/lang/String;Ljava/lang/String;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements IWXAuthApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f242313a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NTWechatLoginMainline f242314b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<String>> f242315c;

        c(long j3, NTWechatLoginMainline nTWechatLoginMainline, CancellableContinuation<? super i<String>> cancellableContinuation) {
            this.f242313a = j3;
            this.f242314b = nTWechatLoginMainline;
            this.f242315c = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), nTWechatLoginMainline, cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.wxapi.IWXAuthApi.a
        public final void a(int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                return;
            }
            QLog.d(NTWechatLoginMainline.TAG, 1, "getWXAuthCode result: " + i3 + ", errorMsg: " + str);
            String valueOf = String.valueOf(System.currentTimeMillis() - this.f242313a);
            this.f242314b.mIsWeChatAuthing = false;
            if (i3 == -2) {
                this.f242314b.reportEvent("0X800C39D", 2, valueOf, "", "", "");
                CancellableContinuation<i<String>> cancellableContinuation = this.f242315c;
                i iVar = new i(-2, str, null);
                if (cancellableContinuation.isActive()) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                } else {
                    QLog.e("NTLogin", 1, "request WX CodesafeResume call failed ");
                }
            } else if (i3 != 0) {
                QLog.d(NTWechatLoginMainline.TAG, 1, "onWXAuthResp, other");
                this.f242314b.reportEvent("0X800C39D", 1, valueOf, String.valueOf(i3), "", "");
                CancellableContinuation<i<String>> cancellableContinuation2 = this.f242315c;
                i iVar2 = new i(-3, BaseApplication.getContext().getString(R.string.f211495kz), null);
                if (cancellableContinuation2.isActive()) {
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(iVar2));
                } else {
                    QLog.e("NTLogin", 1, "request WX CodesafeResume call failed ");
                }
            } else {
                QLog.d(NTWechatLoginMainline.TAG, 1, "onWXAuthSuccess, get wxCode: " + str2);
                this.f242314b.reportEvent("0X800C39D", 0, valueOf, "", "", "");
                CancellableContinuation<i<String>> cancellableContinuation3 = this.f242315c;
                i iVar3 = new i(0, str, str2);
                if (cancellableContinuation3.isActive()) {
                    cancellableContinuation3.resumeWith(Result.m476constructorimpl(iVar3));
                } else {
                    QLog.e("NTLogin", 1, "request WX CodesafeResume call failed ");
                }
            }
            ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).reportWXAuthResult(1, i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTWechatLoginMainline$d", "Lcom/tencent/mobileqq/login/remind/h$b;", "", "a", "b", "", "url", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements h.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ UinInfo f242317b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LoginResult f242318c;

        d(UinInfo uinInfo, LoginResult loginResult) {
            this.f242317b = uinInfo;
            this.f242318c = loginResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTWechatLoginMainline.this, uinInfo, loginResult);
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                NTWechatLoginMainline.this.onLoginCancel();
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                NTWechatLoginMainline.this.reLogin(this.f242317b, this.f242318c);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void c(@NotNull String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) url);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.d(NTWechatLoginMainline.TAG, 1, "onJumpUrl :" + url);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTWechatLoginMainline$e", "Lcom/tencent/mobileqq/login/servlet/e;", "", "ret", "", "msg", "wxBindState", "qqBindState", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e extends com.tencent.mobileqq.login.servlet.e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f242319d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ NTWechatLoginMainline f242320e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<WechatInfo>> f242321f;

        e(long j3, NTWechatLoginMainline nTWechatLoginMainline, CancellableContinuation<? super i<WechatInfo>> cancellableContinuation) {
            this.f242319d = j3;
            this.f242320e = nTWechatLoginMainline;
            this.f242321f = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), nTWechatLoginMainline, cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.login.servlet.e
        public void b(int ret, @Nullable String msg2, int wxBindState, int qqBindState, @Nullable WechatInfo wechatInfo) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(ret), msg2, Integer.valueOf(wxBindState), Integer.valueOf(qqBindState), wechatInfo);
                return;
            }
            QLog.d(NTWechatLoginMainline.TAG, 1, "onQueryWxBindState ret=" + ret + " msg=" + msg2 + " wxBindState=" + wxBindState + " qqBindState=" + qqBindState);
            String valueOf = String.valueOf(System.currentTimeMillis() - this.f242319d);
            NTWechatLoginMainline nTWechatLoginMainline = this.f242320e;
            if (ret == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            nTWechatLoginMainline.reportEvent("0X800C39E", i3, valueOf, String.valueOf(ret), this.f242320e.getReportBindState(wxBindState, qqBindState), "");
            if (ret == 0) {
                if (qqBindState == 2) {
                    CancellableContinuation<i<WechatInfo>> cancellableContinuation = this.f242321f;
                    i iVar = new i(ret, msg2, wechatInfo);
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "wechat login queryBindState boundsafeResume call failed ");
                    return;
                }
                CancellableContinuation<i<WechatInfo>> cancellableContinuation2 = this.f242321f;
                i iVar2 = new i(1, msg2, wechatInfo);
                if (cancellableContinuation2.isActive()) {
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(iVar2));
                    return;
                }
                QLog.e("NTLogin", 1, "wechat login queryBindState unbindsafeResume call failed ");
                return;
            }
            CancellableContinuation<i<WechatInfo>> cancellableContinuation3 = this.f242321f;
            i iVar3 = new i(ret, msg2, null);
            if (cancellableContinuation3.isActive()) {
                cancellableContinuation3.resumeWith(Result.m476constructorimpl(iVar3));
                return;
            }
            QLog.e("NTLogin", 1, "wechat login queryBindState failedsafeResume call failed ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "loginResultInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class f implements ILoginCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f242323b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<LoginResult>> f242324c;

        f(long j3, CancellableContinuation<? super i<LoginResult>> cancellableContinuation) {
            this.f242323b = j3;
            this.f242324c = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTWechatLoginMainline.this, Long.valueOf(j3), cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginCallback
        public final void onResult(int i3, String str, LoginResult loginResult) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, loginResult);
                return;
            }
            NTWechatLoginMainline nTWechatLoginMainline = NTWechatLoginMainline.this;
            if (i3 == 0) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            nTWechatLoginMainline.reportEvent("0X800C39F", i16, String.valueOf(System.currentTimeMillis() - this.f242323b), String.valueOf(i3), "", "");
            CancellableContinuation<i<LoginResult>> cancellableContinuation = this.f242324c;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new i(i3, str, loginResult)));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23034);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTWechatLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        String b16 = com.tencent.mobileqq.wxapi.impl.a.a().b();
        Intrinsics.checkNotNullExpressionValue(b16, "getInstance().wxAppId");
        this.mWxAppId = b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object checkBindState(String str, Continuation<? super i<LoginRspInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "request checkBindState");
        WechatReqBody wechatReqBody = new WechatReqBody();
        wechatReqBody.wechatProfileSig = str;
        CheckThirdCodeReq checkThirdCodeReq = new CheckThirdCodeReq();
        checkThirdCodeReq.wechatReqBody = wechatReqBody;
        ((ILoginService) QRoute.api(ILoginService.class)).checkThirdCode(checkThirdCodeReq, new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getReportAuxiliaryInfo() {
        boolean z16 = this.mHasDevLockVerify;
        int i3 = z16;
        if (this.mHasBindLoginTransit) {
            i3 = (z16 ? 1 : 0) | 2;
        }
        return String.valueOf(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getReportBindState(int wxBindState, int qqBindState) {
        int i3;
        if (wxBindState == 2) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (qqBindState == 2) {
            i3 |= 2;
        }
        return String.valueOf(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getWXAuthCode(Continuation<? super i<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "startGetWXAuthCode");
        long currentTimeMillis = System.currentTimeMillis();
        this.mIsWeChatAuthing = true;
        com.tencent.mobileqq.wxapi.impl.a.a().g(new c(currentTimeMillis, this, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void handleRemindLogin(final UinInfo uinInfo, final LoginResult loginInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.w
            @Override // java.lang.Runnable
            public final void run() {
                NTWechatLoginMainline.handleRemindLogin$lambda$5(LoginResult.this, this, uinInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleRemindLogin$lambda$5(LoginResult loginInfo, NTWechatLoginMainline this$0, UinInfo uinInfo) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uinInfo, "$uinInfo");
        if (!new com.tencent.mobileqq.login.remind.m().e(QBaseActivity.sTopActivity, loginInfo, null, new d(uinInfo, loginInfo))) {
            this$0.reLogin(uinInfo, loginInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object newDevVerify(LoginResult loginResult, Continuation<? super i<String>> continuation) {
        NTWechatLoginMainline$newDevVerify$1 nTWechatLoginMainline$newDevVerify$1;
        Object coroutine_suspended;
        int i3;
        long j3;
        NTWechatLoginMainline nTWechatLoginMainline;
        i iVar;
        int i16;
        if (continuation instanceof NTWechatLoginMainline$newDevVerify$1) {
            nTWechatLoginMainline$newDevVerify$1 = (NTWechatLoginMainline$newDevVerify$1) continuation;
            int i17 = nTWechatLoginMainline$newDevVerify$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                nTWechatLoginMainline$newDevVerify$1.label = i17 - Integer.MIN_VALUE;
                NTWechatLoginMainline$newDevVerify$1 nTWechatLoginMainline$newDevVerify$12 = nTWechatLoginMainline$newDevVerify$1;
                Object obj = nTWechatLoginMainline$newDevVerify$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTWechatLoginMainline$newDevVerify$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        j3 = nTWechatLoginMainline$newDevVerify$12.J$0;
                        NTWechatLoginMainline nTWechatLoginMainline2 = (NTWechatLoginMainline) nTWechatLoginMainline$newDevVerify$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        nTWechatLoginMainline = nTWechatLoginMainline2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.d(TAG, 1, "requestLoginByCoroutine need new device verify!");
                    QuestionnaireForLoginManager.g("new_device");
                    long currentTimeMillis = System.currentTimeMillis();
                    reportEvent("0X800C3A1", 0, "", "", "", "");
                    this.mHasDevLockVerify = true;
                    Bundle bundle = new Bundle();
                    bundle.putInt(TangramHippyConstants.LOGIN_TYPE, ((bw) this.mLoginParams).f242200a);
                    T t16 = this.mLoginParams;
                    if (((bw) t16).f242201b == 16 && ((bw) t16).f242204e) {
                        bundle.putString("wechat_login_bind_uin", com.tencent.mobileqq.accountbinding.d.f174609a.g());
                    }
                    NTDevLockVerifyComponent nTDevLockVerifyComponent = new NTDevLockVerifyComponent();
                    int i18 = ((bw) this.mLoginParams).f242200a;
                    LoginRspInfo loginRspInfo = loginResult.rspInfo;
                    Intrinsics.checkNotNullExpressionValue(loginRspInfo, "loginResult.rspInfo");
                    nTWechatLoginMainline$newDevVerify$12.L$0 = this;
                    nTWechatLoginMainline$newDevVerify$12.J$0 = currentTimeMillis;
                    nTWechatLoginMainline$newDevVerify$12.label = 1;
                    obj = nTDevLockVerifyComponent.f(i18, "", loginRspInfo, bundle, nTWechatLoginMainline$newDevVerify$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = currentTimeMillis;
                    nTWechatLoginMainline = this;
                }
                iVar = (i) obj;
                if (iVar.c() != 0) {
                    i16 = 0;
                } else {
                    i16 = 2;
                }
                nTWechatLoginMainline.reportEvent("0X800C3A2", i16, String.valueOf(System.currentTimeMillis() - j3), "", "", "");
                return iVar;
            }
        }
        nTWechatLoginMainline$newDevVerify$1 = new NTWechatLoginMainline$newDevVerify$1(this, continuation);
        NTWechatLoginMainline$newDevVerify$1 nTWechatLoginMainline$newDevVerify$122 = nTWechatLoginMainline$newDevVerify$1;
        Object obj2 = nTWechatLoginMainline$newDevVerify$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTWechatLoginMainline$newDevVerify$122.label;
        if (i3 == 0) {
        }
        iVar = (i) obj2;
        if (iVar.c() != 0) {
        }
        nTWechatLoginMainline.reportEvent("0X800C3A2", i16, String.valueOf(System.currentTimeMillis() - j3), "", "", "");
        return iVar;
    }

    private final void onBindLoginSuccess(String uin, Bundle bundle) {
        QLog.i(TAG, 1, "onBindLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(uin));
        reportEvent("0X800C3A5", 0, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getReportAuxiliaryInfo(), "");
        super.onLoginSuccess(uin, bundle);
    }

    private final void onNtLoginFailed(final LoginResult loginInfo) {
        LoginRspInfo loginRspInfo = loginInfo.rspInfo;
        QLog.i(TAG, 1, "onLoginFailed ret=" + loginRspInfo.errCode + " msg=" + loginRspInfo.errMsg);
        reportEvent("0X800C3A5", 1, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), String.valueOf(loginInfo.rspInfo.errCode), getReportAuxiliaryInfo(), "");
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.x
            @Override // java.lang.Runnable
            public final void run() {
                NTWechatLoginMainline.onNtLoginFailed$lambda$1(NTWechatLoginMainline.this, loginInfo);
            }
        });
        QuestionnaireForLoginManager.d(16);
        QuestionnaireForLoginManager.e();
        aj ajVar = new aj();
        LoginRspInfo loginRspInfo2 = loginInfo.rspInfo;
        ajVar.f241864a = loginRspInfo2.errCode;
        ajVar.f241866c = loginRspInfo2.errMsg;
        ajVar.f241871h = String.valueOf(loginInfo.account.uin);
        ErrMsg errMsg = new ErrMsg();
        ajVar.f241867d = errMsg;
        errMsg.setTitle(loginInfo.rspInfo.tipsTitle);
        ajVar.f241867d.setMessage(loginInfo.rspInfo.tipsContent);
        ajVar.f241868e = loginInfo.rspInfo.jumpUrl;
        onLoginFailed(ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNtLoginFailed$lambda$1(NTWechatLoginMainline this$0, LoginResult loginInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        com.tencent.mobileqq.login.ntlogin.u uVar = com.tencent.mobileqq.login.ntlogin.u.f242388a;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        T mLoginParams = this$0.mLoginParams;
        Intrinsics.checkNotNullExpressionValue(mLoginParams, "mLoginParams");
        uVar.T(qBaseActivity, (bw) mLoginParams, loginInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object queryBindState(String str, Continuation<? super i<WechatInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        QLog.d(TAG, 1, "queryBindState");
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        showLoading();
        com.tencent.mobileqq.login.servlet.f.d(str, this.mWxAppId, new e(System.currentTimeMillis(), this, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reLogin(UinInfo uinInfo, LoginResult loginInfo) {
        LoginProcessReqBody loginProcessReqBody = new LoginProcessReqBody();
        loginProcessReqBody.needRemindCancellatedStatus = false;
        OptimusLoginInfo optimusLoginInfo = new OptimusLoginInfo();
        optimusLoginInfo.loginProcessReq = loginProcessReqBody;
        optimusLoginInfo.loginContext = loginInfo.rspInfo.loginContext;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new NTWechatLoginMainline$reLogin$1(this, optimusLoginInfo, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportEvent(String tValue, int result, String r26, String r36, String r46, String r56) {
        as.b("wechat_login_mainline", tValue, "", ((bw) this.mLoginParams).f242201b, result, true, r26, r36, r46, r56);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestWechatLogin(OptimusLoginInfo optimusLoginInfo, Continuation<? super i<LoginResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "requestWechatLogin");
        ((ILoginService) QRoute.api(ILoginService.class)).optimusLogin(optimusLoginInfo, new f(System.currentTimeMillis(), cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startBindLogin(final WechatInfo wechatInfo, Continuation<? super i<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        runOnUiThread(new Runnable(cancellableContinuationImpl, wechatInfo) { // from class: com.tencent.mobileqq.login.ntlogin.mainline.NTWechatLoginMainline$startBindLogin$2$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<i<String>> f242325d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ WechatInfo f242326e;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTWechatLoginMainline$startBindLogin$2$1$a", "Lcom/tencent/mobileqq/accountbinding/fragment/f;", "", "uin", "", "a", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes15.dex */
            public static final class a implements com.tencent.mobileqq.accountbinding.fragment.f {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ NTWechatLoginMainline f242327a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ long f242328b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ boolean f242329c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CancellableContinuation<i<String>> f242330d;

                a(NTWechatLoginMainline nTWechatLoginMainline, long j3, boolean z16, CancellableContinuation<? super i<String>> cancellableContinuation) {
                    this.f242327a = nTWechatLoginMainline;
                    this.f242328b = j3;
                    this.f242329c = z16;
                    this.f242330d = cancellableContinuation;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, nTWechatLoginMainline, Long.valueOf(j3), Boolean.valueOf(z16), cancellableContinuation);
                    }
                }

                @Override // com.tencent.mobileqq.accountbinding.fragment.f
                public void a(@NotNull String uin) {
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(uin, "uin");
                    QLog.i("NTLoginMainline_WechatLogin", 1, "onBindLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(uin));
                    this.f242327a.reportEvent("0X800C3A4", 0, String.valueOf(System.currentTimeMillis() - this.f242328b), "", "", "");
                    NTWechatLoginMainline nTWechatLoginMainline = this.f242327a;
                    if (this.f242329c) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    String str2 = str;
                    String c16 = com.tencent.mobileqq.statistics.o.c();
                    Intrinsics.checkNotNullExpressionValue(c16, "getQimei36()");
                    nTWechatLoginMainline.reportEvent("0X800C450", 0, "", str2, c16, "");
                    CancellableContinuation<i<String>> cancellableContinuation = this.f242330d;
                    i iVar = new i(0, "bind login success", uin);
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "startBindLogin failsafeResume call failed ");
                }

                @Override // com.tencent.mobileqq.accountbinding.fragment.f
                public void b() {
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                        return;
                    }
                    QLog.i("NTLoginMainline_WechatLogin", 1, "onBindCancel");
                    this.f242327a.reportEvent("0X800C3A4", 2, String.valueOf(System.currentTimeMillis() - this.f242328b), "", "", "");
                    NTWechatLoginMainline nTWechatLoginMainline = this.f242327a;
                    if (this.f242329c) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    String str2 = str;
                    String c16 = com.tencent.mobileqq.statistics.o.c();
                    Intrinsics.checkNotNullExpressionValue(c16, "getQimei36()");
                    nTWechatLoginMainline.reportEvent("0X800C450", 1, "", str2, c16, "");
                    CancellableContinuation<i<String>> cancellableContinuation = this.f242330d;
                    i iVar = new i(-1, "startBindLogin cancel", null);
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "startBindLogin cancelsafeResume call failed ");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.f242325d = cancellableContinuationImpl;
                this.f242326e = wechatInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, NTWechatLoginMainline.this, cancellableContinuationImpl, wechatInfo);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                QBaseActivity activity;
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.i("NTLoginMainline_WechatLogin", 1, "startBindLogin");
                NTWechatLoginMainline.this.hideLoading(false);
                activity = NTWechatLoginMainline.this.getActivity();
                if (activity == null || activity.isFinishing()) {
                    QLog.w("NTLoginMainline_WechatLogin", 1, "startBindLogin fail, activity is null or finishing");
                    CancellableContinuation<i<String>> cancellableContinuation = this.f242325d;
                    i iVar = new i(-1, "startBindLogin fail, activity is null or finishing", null);
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                    } else {
                        QLog.e("NTLogin", 1, "startBindLogin failsafeResume call failed ");
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                NTWechatLoginMainline.this.reportEvent("0X800C3A3", 0, "", "", "", "");
                NTWechatLoginMainline.this.mHasBindLoginTransit = true;
                WechatInfo wechatInfo2 = this.f242326e;
                if (wechatInfo2 != null && !TextUtils.isEmpty(wechatInfo2.f())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                WechatLoginBindingFragment.F.a(activity, this.f242326e, new a(NTWechatLoginMainline.this, currentTimeMillis, z16, this.f242325d));
                ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportWechatLoginBinding();
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startLoginByCoroutine(Continuation<? super Unit> continuation) {
        NTWechatLoginMainline$startLoginByCoroutine$1 nTWechatLoginMainline$startLoginByCoroutine$1;
        Object coroutine_suspended;
        int i3;
        NTWechatLoginMainline nTWechatLoginMainline;
        i iVar;
        i iVar2;
        NTWechatLoginMainline nTWechatLoginMainline2;
        i iVar3;
        i iVar4;
        LoginRspInfo loginRspInfo;
        if (continuation instanceof NTWechatLoginMainline$startLoginByCoroutine$1) {
            nTWechatLoginMainline$startLoginByCoroutine$1 = (NTWechatLoginMainline$startLoginByCoroutine$1) continuation;
            int i16 = nTWechatLoginMainline$startLoginByCoroutine$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTWechatLoginMainline$startLoginByCoroutine$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTWechatLoginMainline$startLoginByCoroutine$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTWechatLoginMainline$startLoginByCoroutine$1.label;
                boolean z16 = true;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 == 5) {
                                        ResultKt.throwOnFailure(obj);
                                        return Unit.INSTANCE;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                nTWechatLoginMainline = (NTWechatLoginMainline) nTWechatLoginMainline$startLoginByCoroutine$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                iVar4 = (i) obj;
                                int i17 = 0;
                                if (iVar4.c() == 0) {
                                    LoginRspInfo loginRspInfo2 = (LoginRspInfo) iVar4.b();
                                    if (loginRspInfo2 == null || loginRspInfo2.errCode != 0) {
                                        z16 = false;
                                    }
                                    if (z16) {
                                        OptimusLoginInfo optimusLoginInfo = new OptimusLoginInfo();
                                        optimusLoginInfo.loginContext = ((LoginRspInfo) iVar4.b()).loginContext;
                                        nTWechatLoginMainline$startLoginByCoroutine$1.L$0 = null;
                                        nTWechatLoginMainline$startLoginByCoroutine$1.label = 5;
                                        if (nTWechatLoginMainline.wechatLogin(optimusLoginInfo, nTWechatLoginMainline$startLoginByCoroutine$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                                LoginResult loginResult = new LoginResult();
                                LoginRspInfo loginRspInfo3 = new LoginRspInfo();
                                loginRspInfo = (LoginRspInfo) iVar4.b();
                                if (loginRspInfo != null) {
                                    i17 = loginRspInfo.errCode;
                                }
                                loginRspInfo3.errCode = i17;
                                loginRspInfo3.errMsg = BaseApplication.getContext().getString(R.string.c68);
                                loginResult.rspInfo = loginRspInfo3;
                                nTWechatLoginMainline.onNtLoginFailed(loginResult);
                                return Unit.INSTANCE;
                            }
                            nTWechatLoginMainline2 = (NTWechatLoginMainline) nTWechatLoginMainline$startLoginByCoroutine$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            iVar3 = (i) obj;
                            if (iVar3.c() != 0) {
                                Object b16 = iVar3.b();
                                Intrinsics.checkNotNull(b16);
                                nTWechatLoginMainline2.onBindLoginSuccess((String) b16, new Bundle());
                            } else {
                                nTWechatLoginMainline2.onLoginCancel();
                            }
                            return Unit.INSTANCE;
                        }
                        nTWechatLoginMainline = (NTWechatLoginMainline) nTWechatLoginMainline$startLoginByCoroutine$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        iVar2 = (i) obj;
                        if (iVar2.c() != 0 && iVar2.b() != null) {
                            String a16 = ((WechatInfo) iVar2.b()).a();
                            nTWechatLoginMainline$startLoginByCoroutine$1.L$0 = nTWechatLoginMainline;
                            nTWechatLoginMainline$startLoginByCoroutine$1.label = 4;
                            obj = nTWechatLoginMainline.checkBindState(a16, nTWechatLoginMainline$startLoginByCoroutine$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            iVar4 = (i) obj;
                            int i172 = 0;
                            if (iVar4.c() == 0) {
                            }
                            LoginResult loginResult2 = new LoginResult();
                            LoginRspInfo loginRspInfo32 = new LoginRspInfo();
                            loginRspInfo = (LoginRspInfo) iVar4.b();
                            if (loginRspInfo != null) {
                            }
                            loginRspInfo32.errCode = i172;
                            loginRspInfo32.errMsg = BaseApplication.getContext().getString(R.string.c68);
                            loginResult2.rspInfo = loginRspInfo32;
                            nTWechatLoginMainline.onNtLoginFailed(loginResult2);
                            return Unit.INSTANCE;
                        }
                        if (iVar2.c() != 1) {
                            WechatInfo wechatInfo = (WechatInfo) iVar2.b();
                            nTWechatLoginMainline$startLoginByCoroutine$1.L$0 = nTWechatLoginMainline;
                            nTWechatLoginMainline$startLoginByCoroutine$1.label = 3;
                            obj = nTWechatLoginMainline.startBindLogin(wechatInfo, nTWechatLoginMainline$startLoginByCoroutine$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            nTWechatLoginMainline2 = nTWechatLoginMainline;
                            iVar3 = (i) obj;
                            if (iVar3.c() != 0) {
                            }
                            return Unit.INSTANCE;
                        }
                        LoginResult loginResult3 = new LoginResult();
                        LoginRspInfo loginRspInfo4 = new LoginRspInfo();
                        loginRspInfo4.errCode = iVar2.c();
                        loginRspInfo4.errMsg = BaseApplication.getContext().getString(R.string.c68);
                        loginResult3.rspInfo = loginRspInfo4;
                        nTWechatLoginMainline.onNtLoginFailed(loginResult3);
                        return Unit.INSTANCE;
                    }
                    nTWechatLoginMainline = (NTWechatLoginMainline) nTWechatLoginMainline$startLoginByCoroutine$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    nTWechatLoginMainline$startLoginByCoroutine$1.L$0 = this;
                    nTWechatLoginMainline$startLoginByCoroutine$1.label = 1;
                    obj = getWXAuthCode(nTWechatLoginMainline$startLoginByCoroutine$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTWechatLoginMainline = this;
                }
                iVar = (i) obj;
                if (iVar.c() != 0 && iVar.b() != null) {
                    String str = (String) iVar.b();
                    nTWechatLoginMainline$startLoginByCoroutine$1.L$0 = nTWechatLoginMainline;
                    nTWechatLoginMainline$startLoginByCoroutine$1.label = 2;
                    obj = nTWechatLoginMainline.queryBindState(str, nTWechatLoginMainline$startLoginByCoroutine$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    iVar2 = (i) obj;
                    if (iVar2.c() != 0) {
                    }
                    if (iVar2.c() != 1) {
                    }
                } else {
                    if (iVar.c() != -2) {
                        nTWechatLoginMainline.onLoginCancel();
                    } else {
                        LoginResult loginResult4 = new LoginResult();
                        LoginRspInfo loginRspInfo5 = new LoginRspInfo();
                        loginRspInfo5.errCode = iVar.c();
                        loginRspInfo5.errMsg = BaseApplication.getContext().getString(R.string.f211495kz);
                        loginResult4.rspInfo = loginRspInfo5;
                        nTWechatLoginMainline.onNtLoginFailed(loginResult4);
                    }
                    return Unit.INSTANCE;
                }
            }
        }
        nTWechatLoginMainline$startLoginByCoroutine$1 = new NTWechatLoginMainline$startLoginByCoroutine$1(this, continuation);
        Object obj2 = nTWechatLoginMainline$startLoginByCoroutine$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTWechatLoginMainline$startLoginByCoroutine$1.label;
        boolean z162 = true;
        if (i3 == 0) {
        }
        iVar = (i) obj2;
        if (iVar.c() != 0) {
        }
        if (iVar.c() != -2) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object wechatLogin(OptimusLoginInfo optimusLoginInfo, Continuation<? super Unit> continuation) {
        NTWechatLoginMainline$wechatLogin$1 nTWechatLoginMainline$wechatLogin$1;
        Object coroutine_suspended;
        int i3;
        NTWechatLoginMainline nTWechatLoginMainline;
        Object b16;
        NTWechatLoginMainline nTWechatLoginMainline2;
        i iVar;
        OptimusLoginInfo optimusLoginInfo2;
        i iVar2;
        NTWechatLoginMainline nTWechatLoginMainline3;
        i iVar3;
        byte[] bArr;
        byte[] bArr2;
        UserProfile userProfile;
        if (continuation instanceof NTWechatLoginMainline$wechatLogin$1) {
            nTWechatLoginMainline$wechatLogin$1 = (NTWechatLoginMainline$wechatLogin$1) continuation;
            int i16 = nTWechatLoginMainline$wechatLogin$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTWechatLoginMainline$wechatLogin$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTWechatLoginMainline$wechatLogin$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTWechatLoginMainline$wechatLogin$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    iVar = (i) nTWechatLoginMainline$wechatLogin$1.L$1;
                                    nTWechatLoginMainline2 = (NTWechatLoginMainline) nTWechatLoginMainline$wechatLogin$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    if (((i) obj).c() != 0) {
                                        String valueOf = String.valueOf(((LoginResult) iVar.b()).getAccount().getUin());
                                        byte[] nick = ((LoginResult) iVar.b()).getAccount().getUserProfile().getNickName();
                                        Bundle bundle = new Bundle();
                                        Account account = ((LoginResult) iVar.b()).account;
                                        boolean z16 = false;
                                        if (account != null && (userProfile = account.userProfile) != null && userProfile.registerWithoutPwd) {
                                            z16 = true;
                                        }
                                        if (z16) {
                                            bundle.putBoolean("without_pwd", true);
                                        }
                                        Intrinsics.checkNotNullExpressionValue(nick, "nick");
                                        nTWechatLoginMainline2.onNTLoginSuccess(valueOf, new String(nick, Charsets.UTF_8), bundle);
                                    } else {
                                        QLog.e(TAG, 1, "requestLoginByCoroutine commit ticket failed!");
                                        nTWechatLoginMainline2.onNtLoginFailed((LoginResult) iVar.b());
                                    }
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        iVar2 = (i) nTWechatLoginMainline$wechatLogin$1.L$2;
                        optimusLoginInfo2 = (OptimusLoginInfo) nTWechatLoginMainline$wechatLogin$1.L$1;
                        nTWechatLoginMainline3 = (NTWechatLoginMainline) nTWechatLoginMainline$wechatLogin$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        iVar3 = (i) obj;
                        if (iVar3.c() != 0) {
                            QLog.d(TAG, 1, "requestLoginByCoroutine new device verify success!");
                            VerifySuccessSign verifySuccessSign = new VerifySuccessSign();
                            String str = (String) iVar3.b();
                            if (str != null) {
                                bArr = str.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
                            } else {
                                bArr = null;
                            }
                            verifySuccessSign.deviceCheckSucceedSig = bArr;
                            verifySuccessSign.verifyType = VerifyType.VERIFY_TYPE_NEW_DEVICE;
                            optimusLoginInfo2.verifySign = verifySuccessSign;
                            Object b17 = iVar2.b();
                            Intrinsics.checkNotNull(b17);
                            LoginRspInfo loginRspInfo = ((LoginResult) b17).rspInfo;
                            if (loginRspInfo != null) {
                                bArr2 = loginRspInfo.loginContext;
                            } else {
                                bArr2 = null;
                            }
                            optimusLoginInfo2.loginContext = bArr2;
                            nTWechatLoginMainline$wechatLogin$1.L$0 = null;
                            nTWechatLoginMainline$wechatLogin$1.L$1 = null;
                            nTWechatLoginMainline$wechatLogin$1.L$2 = null;
                            nTWechatLoginMainline$wechatLogin$1.label = 3;
                            if (nTWechatLoginMainline3.wechatLogin(optimusLoginInfo2, nTWechatLoginMainline$wechatLogin$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            QLog.d(TAG, 1, "requestLoginByCoroutine new dev verify cancel!");
                            nTWechatLoginMainline3.onLoginCancel();
                        }
                        return Unit.INSTANCE;
                    }
                    optimusLoginInfo = (OptimusLoginInfo) nTWechatLoginMainline$wechatLogin$1.L$1;
                    nTWechatLoginMainline = (NTWechatLoginMainline) nTWechatLoginMainline$wechatLogin$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.i(TAG, 1, "start wechatLogin");
                    nTWechatLoginMainline$wechatLogin$1.L$0 = this;
                    nTWechatLoginMainline$wechatLogin$1.L$1 = optimusLoginInfo;
                    nTWechatLoginMainline$wechatLogin$1.label = 1;
                    obj = requestWechatLogin(optimusLoginInfo, nTWechatLoginMainline$wechatLogin$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTWechatLoginMainline = this;
                }
                i iVar4 = (i) obj;
                b16 = iVar4.b();
                Intrinsics.checkNotNull(b16);
                if (((LoginResult) b16).rspInfo.errCode != 140022010) {
                    LoginResult loginResult = (LoginResult) iVar4.b();
                    nTWechatLoginMainline$wechatLogin$1.L$0 = nTWechatLoginMainline;
                    nTWechatLoginMainline$wechatLogin$1.L$1 = optimusLoginInfo;
                    nTWechatLoginMainline$wechatLogin$1.L$2 = iVar4;
                    nTWechatLoginMainline$wechatLogin$1.label = 2;
                    Object newDevVerify = nTWechatLoginMainline.newDevVerify(loginResult, nTWechatLoginMainline$wechatLogin$1);
                    if (newDevVerify == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    NTWechatLoginMainline nTWechatLoginMainline4 = nTWechatLoginMainline;
                    optimusLoginInfo2 = optimusLoginInfo;
                    iVar2 = iVar4;
                    obj = newDevVerify;
                    nTWechatLoginMainline3 = nTWechatLoginMainline4;
                    iVar3 = (i) obj;
                    if (iVar3.c() != 0) {
                    }
                    return Unit.INSTANCE;
                }
                if (((LoginResult) iVar4.b()).rspInfo.errCode == 150022028) {
                    QLog.d(TAG, 1, "requestLoginByCoroutine account is ");
                    UinInfo uinInfo = optimusLoginInfo.uinInfo;
                    Intrinsics.checkNotNullExpressionValue(uinInfo, "loginInfo.uinInfo");
                    nTWechatLoginMainline.handleRemindLogin(uinInfo, (LoginResult) iVar4.b());
                    return Unit.INSTANCE;
                }
                if (((LoginResult) iVar4.b()).rspInfo.errCode == 0) {
                    QLog.d(TAG, 1, "requestLoginByCoroutine login success");
                    LoginResult loginResult2 = (LoginResult) iVar4.b();
                    nTWechatLoginMainline$wechatLogin$1.L$0 = nTWechatLoginMainline;
                    nTWechatLoginMainline$wechatLogin$1.L$1 = iVar4;
                    nTWechatLoginMainline$wechatLogin$1.label = 4;
                    Object commitMsfTicket = nTWechatLoginMainline.commitMsfTicket(loginResult2, nTWechatLoginMainline$wechatLogin$1);
                    if (commitMsfTicket == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTWechatLoginMainline2 = nTWechatLoginMainline;
                    obj = commitMsfTicket;
                    iVar = iVar4;
                    if (((i) obj).c() != 0) {
                    }
                    return Unit.INSTANCE;
                }
                nTWechatLoginMainline.onNtLoginFailed((LoginResult) iVar4.b());
                return Unit.INSTANCE;
            }
        }
        nTWechatLoginMainline$wechatLogin$1 = new NTWechatLoginMainline$wechatLogin$1(this, continuation);
        Object obj2 = nTWechatLoginMainline$wechatLogin$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTWechatLoginMainline$wechatLogin$1.label;
        if (i3 == 0) {
        }
        i iVar42 = (i) obj2;
        b16 = iVar42.b();
        Intrinsics.checkNotNull(b16);
        if (((LoginResult) b16).rspInfo.errCode != 140022010) {
        }
    }

    @Override // com.tencent.mobileqq.login.k
    public boolean canLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean canLogin = super.canLogin();
        if (!canLogin && this.mIsWeChatAuthing) {
            return true;
        }
        return canLogin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "onLoginCancel");
        reportEvent("0X800C3A5", 2, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getReportAuxiliaryInfo(), "");
        QuestionnaireForLoginManager.d(16);
        QuestionnaireForLoginManager.e();
        super.onLoginCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTBaseLoginMainline
    public void onNTLoginSuccess(@NotNull String uin, @Nullable String nick, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uin, nick, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        QLog.i(TAG, 1, "onLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(uin));
        LoginAccountInfoApiImpl.INSTANCE.b(uin, uin, nick);
        com.tencent.mobileqq.login.account.d.f241848a.b(uin, uin, 6);
        if (!TextUtils.isEmpty(uin)) {
            MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + uin, uin);
        }
        reportEvent("0X800C3A5", 0, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getReportAuxiliaryInfo(), "");
        super.onNTLoginSuccess(uin, nick, bundle);
    }

    @Override // com.tencent.mobileqq.login.k
    protected void startLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "start wx login");
        this.mIsWeChatAuthing = false;
        this.mHasDevLockVerify = false;
        this.mHasBindLoginTransit = false;
        reportEvent("0X800C39C", 0, "", "", "", "");
        QuestionnaireForLoginManager.i("wechat_login");
        QuestionnaireForLoginManager.h(16);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new NTWechatLoginMainline$startLogin$1(this, null), 14, null);
        }
    }
}
