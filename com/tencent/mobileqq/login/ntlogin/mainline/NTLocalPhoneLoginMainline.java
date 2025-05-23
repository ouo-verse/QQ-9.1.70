package com.tencent.mobileqq.login.ntlogin.mainline;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.login.account.impl.LoginAccountInfoApiImpl;
import com.tencent.mobileqq.login.be;
import com.tencent.mobileqq.login.ntlogin.NTDevLockVerifyComponent;
import com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.util.aj;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.util.bk;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.bm;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.Account;
import com.tencent.qqnt.kernel.nativeinterface.BindUinInfo;
import com.tencent.qqnt.kernel.nativeinterface.CheckGatewayCodeReq;
import com.tencent.qqnt.kernel.nativeinterface.ILoginCallback;
import com.tencent.qqnt.kernel.nativeinterface.LoginProcessReqBody;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import com.tencent.qqnt.kernel.nativeinterface.LoginRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.OptimusLoginInfo;
import com.tencent.qqnt.kernel.nativeinterface.UinInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserProfile;
import com.tencent.qqnt.kernel.nativeinterface.VerifySuccessSign;
import com.tencent.qqnt.kernel.nativeinterface.VerifyType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\n\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0013\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0002J&\u0010\u0017\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\fH\u0002J!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001d2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\tJ!\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\u0005J!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u000e\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J\b\u0010&\u001a\u00020\u0019H\u0002J8\u0010.\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00192\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u0003H\u0014J\"\u00104\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00192\b\u00101\u001a\u0004\u0018\u00010\u00192\u0006\u00103\u001a\u000202H\u0014J\b\u00105\u001a\u00020\u0003H\u0014J\b\u00107\u001a\u000206H\u0014R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00109R \u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00109R\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00109R\u0014\u0010H\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010I\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTLocalPhoneLoginMainline;", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTBaseLoginMainline;", "Lcom/tencent/mobileqq/login/be;", "", "startLoginByCoroutine", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/OptimusLoginInfo;", "loginInfo", "requestLoginByToken", "(Lcom/tencent/qqnt/kernel/nativeinterface/OptimusLoginInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/UinInfo;", "uinInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "handleRemindLogin", "loginResult", "reLogin", "smsVerifyResult", "handleMultiAccount", "", "Lcom/tencent/mobileqq/bean/AccountInfo;", "accountInfoList", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$b;", "listener", "showMultiAccountDialog", "dismissMultiAccountDialog", "", "msg", UIJsPlugin.EVENT_SHOW_TOAST, "onNtLoginFailed", "Lcom/tencent/mobileqq/login/ntlogin/mainline/i;", "requestMaskLogin", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckGatewayCodeReq;", "req", "getAccountsByToken", "(Lcom/tencent/qqnt/kernel/nativeinterface/CheckGatewayCodeReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalPhoneToken", "newDevVerify", "(Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSecureReportInfo", "tValue", "", "result", "r2", "r3", "r4", "r5", "reportEvent", "startLogin", "uin", "nick", "Landroid/os/Bundle;", "bundle", "onNTLoginSuccess", "onLoginCancel", "", "needCreateNewRuntime", "mHasPuzzleVerify", "Z", "mHasMultiAccountShown", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/widget/bm;", "mMultiAccountDialogRef", "Lmqq/util/WeakReference;", "mAccountInfo", "Lcom/tencent/mobileqq/bean/AccountInfo;", "mAccountInfoListSize", "I", "mHasDevLockVerify", "", "bindAccountList", "Ljava/util/List;", "mHasShowMultiAccountDialog", "mSelectAccountListener", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$b;", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NTLocalPhoneLoginMainline extends NTBaseLoginMainline<be> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "NTLoginMainline_LocalPhoneLogin";

    @Nullable
    private List<AccountInfo> bindAccountList;

    @Nullable
    private AccountInfo mAccountInfo;
    private int mAccountInfoListSize;
    private boolean mHasDevLockVerify;
    private boolean mHasMultiAccountShown;
    private boolean mHasPuzzleVerify;
    private boolean mHasShowMultiAccountDialog;

    @Nullable
    private WeakReference<bm> mMultiAccountDialogRef;

    @NotNull
    private final NTPhoneSmsLoginMainline.b mSelectAccountListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTLocalPhoneLoginMainline$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.ntlogin.mainline.NTLocalPhoneLoginMainline$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "loginResultInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class b implements ILoginCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<LoginResult>> f242266a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super i<LoginResult>> cancellableContinuation) {
            this.f242266a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginCallback
        public final void onResult(int i3, String str, LoginResult loginResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, loginResult);
                return;
            }
            CancellableContinuation<i<LoginResult>> cancellableContinuation = this.f242266a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new i(i3, str, loginResult)));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTLocalPhoneLoginMainline$c", "Lne1/a;", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements ne1.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f242268b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<String>> f242269c;

        c(long j3, CancellableContinuation<? super i<String>> cancellableContinuation) {
            this.f242268b = j3;
            this.f242269c = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTLocalPhoneLoginMainline.this, Long.valueOf(j3), cancellableContinuation);
            }
        }

        @Override // ne1.a
        public void a(@NotNull GetLocalPhone$OIDBGetPhoneRsp data) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i(NTLocalPhoneLoginMainline.TAG, 1, "get phone token success");
            NTLocalPhoneLoginMainline.this.reportEvent("0X800C30B", 0, String.valueOf(System.currentTimeMillis() - this.f242268b), "", "", "");
            String str = data.msg_encrypt_phone_data.get().str_encypt_phone.get();
            if (str != null) {
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    CancellableContinuation<i<String>> cancellableContinuation = this.f242269c;
                    i iVar = new i(0, "success", str);
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "local phone verifysafeResume call failed ");
                    return;
                }
            }
            QLog.e(NTLocalPhoneLoginMainline.TAG, 1, "startVerifyByECDH onSuccess succeedSig is null");
            CancellableContinuation<i<String>> cancellableContinuation2 = this.f242269c;
            i iVar2 = new i(-1, "verify sig is null", null);
            if (cancellableContinuation2.isActive()) {
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(iVar2));
                return;
            }
            QLog.e("NTLogin", 1, "local phone verifysafeResume call failed ");
        }

        @Override // ne1.a
        public void onFail(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            QLog.e(NTLocalPhoneLoginMainline.TAG, 1, "new dev local phone verify onFail: " + errorCode + ", error: " + errorMsg);
            NTLocalPhoneLoginMainline.this.reportEvent("0X800C30B", 1, String.valueOf(System.currentTimeMillis() - this.f242268b), String.valueOf(errorCode), "", "");
            aj.f306554f.h();
            CancellableContinuation<i<String>> cancellableContinuation = this.f242269c;
            i iVar = new i(errorCode, errorMsg, null);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "local phone verifysafeResume call failed ");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTLocalPhoneLoginMainline$d", "Lcom/tencent/mobileqq/login/remind/h$b;", "", "a", "b", "", "url", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements h.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ UinInfo f242271b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LoginResult f242272c;

        d(UinInfo uinInfo, LoginResult loginResult) {
            this.f242271b = uinInfo;
            this.f242272c = loginResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTLocalPhoneLoginMainline.this, uinInfo, loginResult);
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                NTLocalPhoneLoginMainline.this.onLoginCancel();
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                NTLocalPhoneLoginMainline.this.reLogin(this.f242271b, this.f242272c);
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
            QLog.d(NTLocalPhoneLoginMainline.TAG, 1, "onJumpUrl :" + url);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "loginResultInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class e implements ILoginCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<LoginResult>> f242273a;

        /* JADX WARN: Multi-variable type inference failed */
        e(CancellableContinuation<? super i<LoginResult>> cancellableContinuation) {
            this.f242273a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginCallback
        public final void onResult(int i3, String str, LoginResult loginResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, loginResult);
                return;
            }
            CancellableContinuation<i<LoginResult>> cancellableContinuation = this.f242273a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new i(i3, str, loginResult)));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTLocalPhoneLoginMainline$f", "Lcom/tencent/mobileqq/widget/bm$c;", "", "account", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class f implements bm.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NTPhoneSmsLoginMainline.b f242274a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoginResult f242275b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<AccountInfo> f242276c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NTLocalPhoneLoginMainline f242277d;

        f(NTPhoneSmsLoginMainline.b bVar, LoginResult loginResult, List<? extends AccountInfo> list, NTLocalPhoneLoginMainline nTLocalPhoneLoginMainline) {
            this.f242274a = bVar;
            this.f242275b = loginResult;
            this.f242276c = list;
            this.f242277d = nTLocalPhoneLoginMainline;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, loginResult, list, nTLocalPhoneLoginMainline);
            }
        }

        @Override // com.tencent.mobileqq.widget.bm.c
        public void a(@NotNull Object account) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, account);
                return;
            }
            Intrinsics.checkNotNullParameter(account, "account");
            this.f242274a.a((AccountInfo) account, this.f242275b.rspInfo.loginContext, this.f242276c.size(), false);
            this.f242277d.reportEvent("0X800C4B5", 0, String.valueOf(this.f242276c.size()), "1", "", "");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21613);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTLocalPhoneLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSelectAccountListener = new NTPhoneSmsLoginMainline.b() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.NTLocalPhoneLoginMainline$mSelectAccountListener$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTLocalPhoneLoginMainline.this);
                    }
                }

                @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline.b
                public void a(@NotNull AccountInfo accountInfo, @Nullable byte[] loginContext, int accountInfoListSize, boolean autoSelect) {
                    List<AccountInfo> list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, accountInfo, loginContext, Integer.valueOf(accountInfoListSize), Boolean.valueOf(autoSelect));
                        return;
                    }
                    Intrinsics.checkNotNullParameter(accountInfo, "accountInfo");
                    QLog.d("NTLoginMainline_LocalPhoneLogin", 1, "selectAccountFromList onSelectAccount uin=" + accountInfo.getMaskUin());
                    NTLocalPhoneLoginMainline.this.mAccountInfo = accountInfo;
                    list = NTLocalPhoneLoginMainline.this.bindAccountList;
                    if (list != null) {
                        NTLocalPhoneLoginMainline nTLocalPhoneLoginMainline = NTLocalPhoneLoginMainline.this;
                        for (AccountInfo accountInfo2 : list) {
                            if (TextUtils.equals(accountInfo2.getMaskUin(), accountInfo.getMaskUin()) && TextUtils.equals(accountInfo2.getMaskNick(), accountInfo.getMaskNick())) {
                                nTLocalPhoneLoginMainline.mAccountInfo = accountInfo2;
                            }
                        }
                    }
                    NTLocalPhoneLoginMainline.this.mAccountInfoListSize = accountInfoListSize;
                    OptimusLoginInfo optimusLoginInfo = new OptimusLoginInfo();
                    optimusLoginInfo.loginContext = loginContext;
                    optimusLoginInfo.uinInfo = accountInfo.getNtUinInfo();
                    optimusLoginInfo.appInfo = NTLocalPhoneLoginMainline.this.getAppInfo();
                    NTLocalPhoneLoginMainline.this.showLoading();
                    CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
                    if (f16 != null) {
                        CorountineFunKt.e(f16, "NTLoginMainline_LocalPhoneLogin", null, null, null, new NTLocalPhoneLoginMainline$mSelectAccountListener$1$onSelectAccount$2(NTLocalPhoneLoginMainline.this, optimusLoginInfo, null), 14, null);
                    }
                }

                @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline.b
                public void onCancel() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                    } else {
                        QLog.d("NTLoginMainline_LocalPhoneLogin", 1, "selectAccountFromList onCancel");
                        NTLocalPhoneLoginMainline.this.onLoginCancel();
                    }
                }
            };
        }
    }

    private final void dismissMultiAccountDialog() {
        bm bmVar;
        WeakReference<bm> weakReference = this.mMultiAccountDialogRef;
        if (weakReference != null) {
            Intrinsics.checkNotNull(weakReference);
            bmVar = weakReference.get();
        } else {
            bmVar = null;
        }
        if (bmVar != null) {
            try {
                if (bmVar.isShowing()) {
                    bmVar.setOnDismissListener(null);
                    bmVar.dismiss();
                }
            } catch (Exception e16) {
                QLog.w(TAG, 1, "dismissMultiAccountDialog", e16);
            }
        }
        this.mMultiAccountDialogRef = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAccountsByToken(CheckGatewayCodeReq checkGatewayCodeReq, Continuation<? super i<LoginResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "requestNTLogin by local phone");
        ((ILoginService) QRoute.api(ILoginService.class)).checkGatewayCode(checkGatewayCodeReq, new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getLocalPhoneToken(Continuation<? super i<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "getLocalPhoneToken");
        long currentTimeMillis = System.currentTimeMillis();
        reportEvent("0X800C30A", 0, "", "", "", "");
        com.tencent.mobileqq.gateway.localphone.ecdh.g.m(3, 14, new c(currentTimeMillis, cancellableContinuationImpl), null);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final String getSecureReportInfo() {
        if (this.mHasMultiAccountShown) {
            if (this.mHasDevLockVerify) {
                return "4";
            }
            return "1";
        }
        if (this.mHasDevLockVerify) {
            return "2";
        }
        return "3";
    }

    private final void handleMultiAccount(final LoginResult smsVerifyResult) {
        BindUinInfo bindUinInfo;
        int i3;
        final ArrayList arrayList = new ArrayList();
        try {
            LoginRspInfo loginRspInfo = smsVerifyResult.rspInfo;
            byte[] bArr = null;
            if (loginRspInfo != null) {
                bindUinInfo = loginRspInfo.bindUinInfo;
            } else {
                bindUinInfo = null;
            }
            List<AccountInfo> d16 = bk.d(bindUinInfo);
            if (d16 != null) {
                arrayList.addAll(d16);
                this.bindAccountList = arrayList;
            }
            if (arrayList.isEmpty()) {
                onNtLoginFailed(smsVerifyResult);
                QLog.e(TAG, 1, "onGetSaltUinList failed ret=" + smsVerifyResult.rspInfo.errCode + " accountInfoList isEmpty");
                return;
            }
            int size = arrayList.size();
            QLog.i(TAG, 1, "onGetSaltUinList accountInfoListSize=" + size);
            AccountInfo d17 = z.d(arrayList, "+86 " + ((be) this.mLoginParams).f241956f, ((be) this.mLoginParams).f241957g);
            if (d17 != null) {
                QLog.i(TAG, 1, "startMultiAccountLogin auto select selectedAccountInfo uin " + StringUtil.getSimpleUinForPrint(((be) this.mLoginParams).f241957g));
                reportEvent("0X800C4B5", 0, String.valueOf(size), "2", "", "");
                NTPhoneSmsLoginMainline.b bVar = this.mSelectAccountListener;
                LoginRspInfo loginRspInfo2 = smsVerifyResult.rspInfo;
                if (loginRspInfo2 != null) {
                    bArr = loginRspInfo2.loginContext;
                }
                bVar.a(d17, bArr, size, true);
                return;
            }
            if (isLoginActivityInvalid()) {
                i3 = 1000;
            } else {
                i3 = 0;
            }
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.c
                @Override // java.lang.Runnable
                public final void run() {
                    NTLocalPhoneLoginMainline.handleMultiAccount$lambda$2(NTLocalPhoneLoginMainline.this, arrayList, smsVerifyResult);
                }
            }, i3);
        } catch (Exception e16) {
            onNtLoginFailed(smsVerifyResult);
            QLog.e(TAG, 1, "onGetSaltUinList failed" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMultiAccount$lambda$2(NTLocalPhoneLoginMainline this$0, List accountInfoList, LoginResult smsVerifyResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(accountInfoList, "$accountInfoList");
        Intrinsics.checkNotNullParameter(smsVerifyResult, "$smsVerifyResult");
        this$0.showMultiAccountDialog(accountInfoList, smsVerifyResult, this$0.mSelectAccountListener);
    }

    private final void handleRemindLogin(final UinInfo uinInfo, final LoginResult loginInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.d
            @Override // java.lang.Runnable
            public final void run() {
                NTLocalPhoneLoginMainline.handleRemindLogin$lambda$1(LoginResult.this, this, uinInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleRemindLogin$lambda$1(LoginResult loginInfo, NTLocalPhoneLoginMainline this$0, UinInfo uinInfo) {
        String str;
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uinInfo, "$uinInfo");
        com.tencent.mobileqq.login.remind.m mVar = new com.tencent.mobileqq.login.remind.m();
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        AccountInfo accountInfo = this$0.mAccountInfo;
        if (accountInfo != null) {
            str = accountInfo.getMaskUin();
        } else {
            str = null;
        }
        if (!mVar.e(qBaseActivity, loginInfo, str, new d(uinInfo, loginInfo))) {
            this$0.reLogin(uinInfo, loginInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object newDevVerify(LoginResult loginResult, Continuation<? super i<String>> continuation) {
        NTLocalPhoneLoginMainline$newDevVerify$1 nTLocalPhoneLoginMainline$newDevVerify$1;
        Object coroutine_suspended;
        int i3;
        String str;
        long j3;
        NTLocalPhoneLoginMainline nTLocalPhoneLoginMainline;
        String g16;
        String str2;
        if (continuation instanceof NTLocalPhoneLoginMainline$newDevVerify$1) {
            nTLocalPhoneLoginMainline$newDevVerify$1 = (NTLocalPhoneLoginMainline$newDevVerify$1) continuation;
            int i16 = nTLocalPhoneLoginMainline$newDevVerify$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTLocalPhoneLoginMainline$newDevVerify$1.label = i16 - Integer.MIN_VALUE;
                NTLocalPhoneLoginMainline$newDevVerify$1 nTLocalPhoneLoginMainline$newDevVerify$12 = nTLocalPhoneLoginMainline$newDevVerify$1;
                Object obj = nTLocalPhoneLoginMainline$newDevVerify$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTLocalPhoneLoginMainline$newDevVerify$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        j3 = nTLocalPhoneLoginMainline$newDevVerify$12.J$0;
                        NTLocalPhoneLoginMainline nTLocalPhoneLoginMainline2 = (NTLocalPhoneLoginMainline) nTLocalPhoneLoginMainline$newDevVerify$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        nTLocalPhoneLoginMainline = nTLocalPhoneLoginMainline2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.d(TAG, 1, "requestLoginByCoroutine need new device verify!");
                    long currentTimeMillis = System.currentTimeMillis();
                    QuestionnaireForLoginManager.g("new_device");
                    this.mHasDevLockVerify = true;
                    if (this.mHasShowMultiAccountDialog) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    reportEvent("0X800C30C", 0, "", str, "", "");
                    Bundle bundle = new Bundle();
                    bundle.putString("url", loginResult.rspInfo.jumpUrl);
                    bundle.putSerializable("key_mask_user_info", this.mAccountInfo);
                    if (((be) this.mLoginParams).f242202c) {
                        bundle.putBoolean("isSubaccount", true);
                        bundle.putString("from_where", "subaccount");
                    }
                    if (((be) this.mLoginParams).f242203d) {
                        bundle.putString("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
                    }
                    bundle.putInt(TangramHippyConstants.LOGIN_TYPE, ((be) this.mLoginParams).f242200a);
                    T t16 = this.mLoginParams;
                    if (((be) t16).f242201b == 16 && ((be) t16).f242204e && (g16 = com.tencent.mobileqq.accountbinding.d.f174609a.g()) != null) {
                        bundle.putString("wechat_login_bind_uin", g16);
                    }
                    NTDevLockVerifyComponent nTDevLockVerifyComponent = new NTDevLockVerifyComponent();
                    int i17 = ((be) this.mLoginParams).f242200a;
                    LoginRspInfo loginRspInfo = loginResult.rspInfo;
                    Intrinsics.checkNotNullExpressionValue(loginRspInfo, "loginResult.rspInfo");
                    nTLocalPhoneLoginMainline$newDevVerify$12.L$0 = this;
                    nTLocalPhoneLoginMainline$newDevVerify$12.J$0 = currentTimeMillis;
                    nTLocalPhoneLoginMainline$newDevVerify$12.label = 1;
                    j3 = currentTimeMillis;
                    obj = nTDevLockVerifyComponent.f(i17, "", loginRspInfo, bundle, nTLocalPhoneLoginMainline$newDevVerify$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTLocalPhoneLoginMainline = this;
                }
                i iVar = (i) obj;
                int c16 = iVar.c();
                String valueOf = String.valueOf(System.currentTimeMillis() - j3);
                if (!nTLocalPhoneLoginMainline.mHasShowMultiAccountDialog) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                nTLocalPhoneLoginMainline.reportEvent("0X800C30D", c16, valueOf, str2, "", "");
                return iVar;
            }
        }
        nTLocalPhoneLoginMainline$newDevVerify$1 = new NTLocalPhoneLoginMainline$newDevVerify$1(this, continuation);
        NTLocalPhoneLoginMainline$newDevVerify$1 nTLocalPhoneLoginMainline$newDevVerify$122 = nTLocalPhoneLoginMainline$newDevVerify$1;
        Object obj2 = nTLocalPhoneLoginMainline$newDevVerify$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTLocalPhoneLoginMainline$newDevVerify$122.label;
        if (i3 == 0) {
        }
        i iVar2 = (i) obj2;
        int c162 = iVar2.c();
        String valueOf2 = String.valueOf(System.currentTimeMillis() - j3);
        if (!nTLocalPhoneLoginMainline.mHasShowMultiAccountDialog) {
        }
        nTLocalPhoneLoginMainline.reportEvent("0X800C30D", c162, valueOf2, str2, "", "");
        return iVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLoginCancel$lambda$7(NTLocalPhoneLoginMainline this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissMultiAccountDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNTLoginSuccess$lambda$5(NTLocalPhoneLoginMainline this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissMultiAccountDialog();
    }

    private final void onNtLoginFailed(LoginResult loginInfo) {
        QLog.e(TAG, 1, "onNtLoginFailed ret = " + loginInfo.rspInfo.errCode);
        this.bindAccountList = null;
        hideLoading(false);
        com.tencent.mobileqq.login.ntlogin.u uVar = com.tencent.mobileqq.login.ntlogin.u.f242388a;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        T mLoginParams = this.mLoginParams;
        Intrinsics.checkNotNullExpressionValue(mLoginParams, "mLoginParams");
        if (uVar.F(qBaseActivity, (be) mLoginParams, loginInfo)) {
            QLog.d(TAG, 1, "onNtLoginFailed can login other account");
            return;
        }
        com.tencent.mobileqq.login.aj ajVar = new com.tencent.mobileqq.login.aj();
        LoginRspInfo loginRspInfo = loginInfo.rspInfo;
        ajVar.f241864a = loginRspInfo.errCode;
        ajVar.f241866c = loginRspInfo.errMsg;
        ajVar.f241871h = String.valueOf(loginInfo.account.uin);
        ErrMsg errMsg = new ErrMsg();
        ajVar.f241867d = errMsg;
        errMsg.setTitle(loginInfo.rspInfo.tipsTitle);
        ajVar.f241867d.setMessage(loginInfo.rspInfo.tipsContent);
        ajVar.f241868e = loginInfo.rspInfo.jumpUrl;
        int i3 = ajVar.f241864a;
        reportEvent("0X800C310", 1, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), String.valueOf(ajVar.f241864a), getSecureReportInfo(), "");
        QLog.i(TAG, 1, "onLoginFailed ret=" + i3 + " msg=" + ajVar.f241866c);
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.b
            @Override // java.lang.Runnable
            public final void run() {
                NTLocalPhoneLoginMainline.onNtLoginFailed$lambda$6(NTLocalPhoneLoginMainline.this);
            }
        });
        QuestionnaireForLoginManager.e();
        QuestionnaireForLoginManager.d(8);
        onLoginFailed(ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNtLoginFailed$lambda$6(NTLocalPhoneLoginMainline this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissMultiAccountDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reLogin(UinInfo uinInfo, LoginResult loginResult) {
        String str;
        LoginProcessReqBody loginProcessReqBody = new LoginProcessReqBody();
        com.tencent.mobileqq.login.remind.n nVar = com.tencent.mobileqq.login.remind.n.f242580a;
        AccountInfo accountInfo = this.mAccountInfo;
        if (accountInfo != null) {
            str = accountInfo.getMaskUin();
        } else {
            str = null;
        }
        loginProcessReqBody.needRemindCancellatedStatus = nVar.c(str);
        OptimusLoginInfo optimusLoginInfo = new OptimusLoginInfo();
        optimusLoginInfo.loginProcessReq = loginProcessReqBody;
        optimusLoginInfo.uinInfo = uinInfo;
        optimusLoginInfo.appInfo = getAppInfo();
        optimusLoginInfo.loginContext = loginResult.rspInfo.loginContext;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new NTLocalPhoneLoginMainline$reLogin$1(this, optimusLoginInfo, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportEvent(String tValue, int result, String r26, String r36, String r46, String r56) {
        as.b("phone_quick_login_mainline", tValue, "", ((be) this.mLoginParams).f242201b, result, true, r26, r36, r46, r56);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestLoginByToken(OptimusLoginInfo optimusLoginInfo, Continuation<? super Unit> continuation) {
        NTLocalPhoneLoginMainline$requestLoginByToken$1 nTLocalPhoneLoginMainline$requestLoginByToken$1;
        Object coroutine_suspended;
        int i3;
        int i16;
        long currentTimeMillis;
        NTLocalPhoneLoginMainline nTLocalPhoneLoginMainline;
        OptimusLoginInfo optimusLoginInfo2;
        i iVar;
        NTLocalPhoneLoginMainline nTLocalPhoneLoginMainline2;
        i iVar2;
        OptimusLoginInfo optimusLoginInfo3;
        NTLocalPhoneLoginMainline nTLocalPhoneLoginMainline3;
        i iVar3;
        int i17;
        i iVar4;
        byte[] bArr;
        byte[] bArr2;
        ?? r112;
        UserProfile userProfile;
        if (continuation instanceof NTLocalPhoneLoginMainline$requestLoginByToken$1) {
            nTLocalPhoneLoginMainline$requestLoginByToken$1 = (NTLocalPhoneLoginMainline$requestLoginByToken$1) continuation;
            int i18 = nTLocalPhoneLoginMainline$requestLoginByToken$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                nTLocalPhoneLoginMainline$requestLoginByToken$1.label = i18 - Integer.MIN_VALUE;
                NTLocalPhoneLoginMainline$requestLoginByToken$1 nTLocalPhoneLoginMainline$requestLoginByToken$12 = nTLocalPhoneLoginMainline$requestLoginByToken$1;
                Object obj = nTLocalPhoneLoginMainline$requestLoginByToken$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTLocalPhoneLoginMainline$requestLoginByToken$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    iVar2 = (i) nTLocalPhoneLoginMainline$requestLoginByToken$12.L$1;
                                    NTLocalPhoneLoginMainline nTLocalPhoneLoginMainline4 = (NTLocalPhoneLoginMainline) nTLocalPhoneLoginMainline$requestLoginByToken$12.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    r112 = 1;
                                    nTLocalPhoneLoginMainline2 = nTLocalPhoneLoginMainline4;
                                    if (((i) obj).c() != 0) {
                                        String valueOf = String.valueOf(((LoginResult) iVar2.b()).getAccount().getUin());
                                        byte[] nick = ((LoginResult) iVar2.b()).getAccount().getUserProfile().getNickName();
                                        Bundle bundle = new Bundle();
                                        Account account = ((LoginResult) iVar2.b()).account;
                                        boolean z16 = false;
                                        if (account != null && (userProfile = account.userProfile) != null && userProfile.registerWithoutPwd == r112) {
                                            z16 = r112;
                                        }
                                        if (z16) {
                                            bundle.putBoolean("without_pwd", r112);
                                        }
                                        nTLocalPhoneLoginMainline2.bindAccountList = null;
                                        Intrinsics.checkNotNullExpressionValue(nick, "nick");
                                        nTLocalPhoneLoginMainline2.onNTLoginSuccess(valueOf, new String(nick, Charsets.UTF_8), bundle);
                                    } else {
                                        QLog.d(TAG, (int) r112, "requestLoginByCoroutine commit ticket failed!");
                                        nTLocalPhoneLoginMainline2.onNtLoginFailed((LoginResult) iVar2.b());
                                    }
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        iVar3 = (i) nTLocalPhoneLoginMainline$requestLoginByToken$12.L$2;
                        optimusLoginInfo3 = (OptimusLoginInfo) nTLocalPhoneLoginMainline$requestLoginByToken$12.L$1;
                        nTLocalPhoneLoginMainline3 = (NTLocalPhoneLoginMainline) nTLocalPhoneLoginMainline$requestLoginByToken$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        i17 = 1;
                        iVar4 = (i) obj;
                        if (iVar4.c() != 0) {
                            QLog.d(TAG, i17, "requestLoginByCoroutine new device verify success!");
                            VerifySuccessSign verifySuccessSign = new VerifySuccessSign();
                            String str = (String) iVar4.b();
                            if (str != null) {
                                bArr = str.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
                            } else {
                                bArr = null;
                            }
                            verifySuccessSign.deviceCheckSucceedSig = bArr;
                            verifySuccessSign.verifyType = VerifyType.VERIFY_TYPE_NEW_DEVICE;
                            optimusLoginInfo3.verifySign = verifySuccessSign;
                            LoginRspInfo loginRspInfo = ((LoginResult) iVar3.b()).rspInfo;
                            if (loginRspInfo != null) {
                                bArr2 = loginRspInfo.loginContext;
                            } else {
                                bArr2 = null;
                            }
                            optimusLoginInfo3.loginContext = bArr2;
                            nTLocalPhoneLoginMainline$requestLoginByToken$12.L$0 = null;
                            nTLocalPhoneLoginMainline$requestLoginByToken$12.L$1 = null;
                            nTLocalPhoneLoginMainline$requestLoginByToken$12.L$2 = null;
                            nTLocalPhoneLoginMainline$requestLoginByToken$12.label = 3;
                            if (nTLocalPhoneLoginMainline3.requestLoginByToken(optimusLoginInfo3, nTLocalPhoneLoginMainline$requestLoginByToken$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            QLog.d(TAG, i17, "requestLoginByCoroutine new dev verify cancel!");
                            nTLocalPhoneLoginMainline3.onLoginCancel();
                        }
                        return Unit.INSTANCE;
                    }
                    currentTimeMillis = nTLocalPhoneLoginMainline$requestLoginByToken$12.J$0;
                    optimusLoginInfo2 = (OptimusLoginInfo) nTLocalPhoneLoginMainline$requestLoginByToken$12.L$1;
                    nTLocalPhoneLoginMainline = (NTLocalPhoneLoginMainline) nTLocalPhoneLoginMainline$requestLoginByToken$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    i16 = 1;
                } else {
                    ResultKt.throwOnFailure(obj);
                    showLoading();
                    i16 = 1;
                    reportEvent("0X800C30E", 0, "", "", "", "");
                    currentTimeMillis = System.currentTimeMillis();
                    nTLocalPhoneLoginMainline$requestLoginByToken$12.L$0 = this;
                    nTLocalPhoneLoginMainline$requestLoginByToken$12.L$1 = optimusLoginInfo;
                    nTLocalPhoneLoginMainline$requestLoginByToken$12.J$0 = currentTimeMillis;
                    nTLocalPhoneLoginMainline$requestLoginByToken$12.label = 1;
                    obj = requestMaskLogin(optimusLoginInfo, nTLocalPhoneLoginMainline$requestLoginByToken$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTLocalPhoneLoginMainline = this;
                    optimusLoginInfo2 = optimusLoginInfo;
                }
                iVar = (i) obj;
                if (iVar.c() != 0 && iVar.b() != null) {
                    int i19 = ((LoginResult) iVar.b()).rspInfo.errCode;
                    nTLocalPhoneLoginMainline.reportEvent("0X800C30F", ((LoginResult) iVar.b()).rspInfo.errCode, String.valueOf(System.currentTimeMillis() - currentTimeMillis), "", "", "");
                    if (i19 == 150022028) {
                        UinInfo uinInfo = optimusLoginInfo2.uinInfo;
                        Intrinsics.checkNotNullExpressionValue(uinInfo, "loginInfo.uinInfo");
                        nTLocalPhoneLoginMainline.handleRemindLogin(uinInfo, (LoginResult) iVar.b());
                        return Unit.INSTANCE;
                    }
                    if (i19 == 140022010) {
                        LoginResult loginResult = (LoginResult) iVar.b();
                        nTLocalPhoneLoginMainline$requestLoginByToken$12.L$0 = nTLocalPhoneLoginMainline;
                        nTLocalPhoneLoginMainline$requestLoginByToken$12.L$1 = optimusLoginInfo2;
                        nTLocalPhoneLoginMainline$requestLoginByToken$12.L$2 = iVar;
                        nTLocalPhoneLoginMainline$requestLoginByToken$12.label = 2;
                        Object newDevVerify = nTLocalPhoneLoginMainline.newDevVerify(loginResult, nTLocalPhoneLoginMainline$requestLoginByToken$12);
                        if (newDevVerify == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        optimusLoginInfo3 = optimusLoginInfo2;
                        nTLocalPhoneLoginMainline3 = nTLocalPhoneLoginMainline;
                        iVar3 = iVar;
                        obj = newDevVerify;
                        i17 = i16;
                        iVar4 = (i) obj;
                        if (iVar4.c() != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                    if (i19 == 0) {
                        QLog.d(TAG, i16 == true ? 1 : 0, "requestLoginByCoroutine login success");
                        LoginResult loginResult2 = (LoginResult) iVar.b();
                        nTLocalPhoneLoginMainline$requestLoginByToken$12.L$0 = nTLocalPhoneLoginMainline;
                        nTLocalPhoneLoginMainline$requestLoginByToken$12.L$1 = iVar;
                        nTLocalPhoneLoginMainline$requestLoginByToken$12.label = 4;
                        Object commitMsfTicket = nTLocalPhoneLoginMainline.commitMsfTicket(loginResult2, nTLocalPhoneLoginMainline$requestLoginByToken$12);
                        if (commitMsfTicket == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        nTLocalPhoneLoginMainline2 = nTLocalPhoneLoginMainline;
                        iVar2 = iVar;
                        obj = commitMsfTicket;
                        r112 = i16;
                        if (((i) obj).c() != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                    nTLocalPhoneLoginMainline.onNtLoginFailed((LoginResult) iVar.b());
                    return Unit.INSTANCE;
                }
                QLog.e(TAG, i16 == true ? 1 : 0, "requestLoginByCoroutine login failed error: " + iVar.c());
                nTLocalPhoneLoginMainline.reportEvent("0X800C30F", iVar.c(), String.valueOf(System.currentTimeMillis() - currentTimeMillis), "", "", "");
                Object b16 = iVar.b();
                Intrinsics.checkNotNull(b16);
                nTLocalPhoneLoginMainline.onNtLoginFailed((LoginResult) b16);
                return Unit.INSTANCE;
            }
        }
        nTLocalPhoneLoginMainline$requestLoginByToken$1 = new NTLocalPhoneLoginMainline$requestLoginByToken$1(this, continuation);
        NTLocalPhoneLoginMainline$requestLoginByToken$1 nTLocalPhoneLoginMainline$requestLoginByToken$122 = nTLocalPhoneLoginMainline$requestLoginByToken$1;
        Object obj2 = nTLocalPhoneLoginMainline$requestLoginByToken$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTLocalPhoneLoginMainline$requestLoginByToken$122.label;
        if (i3 == 0) {
        }
        iVar = (i) obj2;
        if (iVar.c() != 0) {
        }
        QLog.e(TAG, i16 == true ? 1 : 0, "requestLoginByCoroutine login failed error: " + iVar.c());
        nTLocalPhoneLoginMainline.reportEvent("0X800C30F", iVar.c(), String.valueOf(System.currentTimeMillis() - currentTimeMillis), "", "", "");
        Object b162 = iVar.b();
        Intrinsics.checkNotNull(b162);
        nTLocalPhoneLoginMainline.onNtLoginFailed((LoginResult) b162);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestMaskLogin(OptimusLoginInfo optimusLoginInfo, Continuation<? super i<LoginResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "requestNTLogin");
        ((ILoginService) QRoute.api(ILoginService.class)).optimusLogin(optimusLoginInfo, new e(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void showMultiAccountDialog(List<? extends AccountInfo> accountInfoList, LoginResult loginInfo, final NTPhoneSmsLoginMainline.b listener) {
        String str;
        QLog.d(TAG, 1, "showMultiAccountDialog");
        this.mHasShowMultiAccountDialog = true;
        QBaseActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            bm b16 = bk.b(activity, accountInfoList, loginInfo.rspInfo.bindUinInfo.unbindWording, new f(listener, loginInfo, accountInfoList, this), new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.h
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    NTLocalPhoneLoginMainline.showMultiAccountDialog$lambda$3(NTPhoneSmsLoginMainline.b.this, dialogInterface);
                }
            });
            this.mMultiAccountDialogRef = new WeakReference<>(b16);
            if (b16 == null) {
                String string = BaseApplication.getContext().getString(R.string.c68);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R.string.loginFailed)");
                showToast(string);
                listener.onCancel();
                return;
            }
            hideLoading(false);
            b16.show();
            this.mHasMultiAccountShown = true;
            String valueOf = String.valueOf(accountInfoList.size());
            if (this.mHasPuzzleVerify) {
                str = "1";
            } else {
                str = "2";
            }
            reportEvent("0X800C4B4", 0, valueOf, str, "", "");
            return;
        }
        QLog.e(TAG, 1, "activity == null || activity.isFinishing()");
        listener.onCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMultiAccountDialog$lambda$3(NTPhoneSmsLoginMainline.b listener, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onCancel();
    }

    private final void showToast(final String msg2) {
        if (TextUtils.isEmpty(msg2)) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.g
            @Override // java.lang.Runnable
            public final void run() {
                NTLocalPhoneLoginMainline.showToast$lambda$4(msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$4(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(BaseApplication.getContext(), 1, msg2, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startLoginByCoroutine(Continuation<? super Unit> continuation) {
        NTLocalPhoneLoginMainline$startLoginByCoroutine$1 nTLocalPhoneLoginMainline$startLoginByCoroutine$1;
        Object coroutine_suspended;
        int i3;
        NTLocalPhoneLoginMainline nTLocalPhoneLoginMainline;
        i iVar;
        i iVar2;
        Integer num;
        boolean z16;
        BindUinInfo bindUinInfo;
        LoginRspInfo loginRspInfo;
        BindUinInfo bindUinInfo2;
        ArrayList<UinInfo> arrayList;
        LoginRspInfo loginRspInfo2;
        if (continuation instanceof NTLocalPhoneLoginMainline$startLoginByCoroutine$1) {
            nTLocalPhoneLoginMainline$startLoginByCoroutine$1 = (NTLocalPhoneLoginMainline$startLoginByCoroutine$1) continuation;
            int i16 = nTLocalPhoneLoginMainline$startLoginByCoroutine$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTLocalPhoneLoginMainline$startLoginByCoroutine$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTLocalPhoneLoginMainline$startLoginByCoroutine$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTLocalPhoneLoginMainline$startLoginByCoroutine$1.label;
                boolean z17 = true;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        nTLocalPhoneLoginMainline = (NTLocalPhoneLoginMainline) nTLocalPhoneLoginMainline$startLoginByCoroutine$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        iVar2 = (i) obj;
                        if (iVar2.c() == 0) {
                            QLog.d(TAG, 1, "getAccountsByToken sms verify canceled!");
                            nTLocalPhoneLoginMainline.onLoginCancel();
                            return Unit.INSTANCE;
                        }
                        LoginResult loginResult = (LoginResult) iVar2.b();
                        if (loginResult != null && (loginRspInfo2 = loginResult.rspInfo) != null) {
                            num = Boxing.boxInt(loginRspInfo2.errCode);
                        } else {
                            num = null;
                        }
                        if (num != null && num.intValue() == 0) {
                            LoginResult loginResult2 = (LoginResult) iVar2.b();
                            if (loginResult2 != null && (loginRspInfo = loginResult2.rspInfo) != null && (bindUinInfo2 = loginRspInfo.bindUinInfo) != null && (arrayList = bindUinInfo2.uinInfoList) != null && (!arrayList.isEmpty())) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                Object b16 = iVar2.b();
                                Intrinsics.checkNotNull(b16);
                                ArrayList<UinInfo> arrayList2 = ((LoginResult) b16).rspInfo.bindUinInfo.uinInfoList;
                                if (arrayList2.size() == 1) {
                                    QLog.d(TAG, 1, "requestLoginByCoroutine  login the account!");
                                    nTLocalPhoneLoginMainline.reportEvent("0X800C4B5", 0, "1", "2", "", "");
                                    LoginRspInfo loginRspInfo3 = ((LoginResult) iVar2.b()).rspInfo;
                                    if (loginRspInfo3 != null) {
                                        bindUinInfo = loginRspInfo3.bindUinInfo;
                                    } else {
                                        bindUinInfo = null;
                                    }
                                    List<AccountInfo> d16 = bk.d(bindUinInfo);
                                    if (d16 == null || !(!d16.isEmpty())) {
                                        z17 = false;
                                    }
                                    if (z17) {
                                        nTLocalPhoneLoginMainline.mAccountInfo = d16.get(0);
                                    }
                                    OptimusLoginInfo optimusLoginInfo = new OptimusLoginInfo();
                                    optimusLoginInfo.appInfo = nTLocalPhoneLoginMainline.getAppInfo();
                                    Object b17 = iVar2.b();
                                    Intrinsics.checkNotNull(b17);
                                    optimusLoginInfo.loginContext = ((LoginResult) b17).rspInfo.loginContext;
                                    optimusLoginInfo.uinInfo = arrayList2.get(0);
                                    nTLocalPhoneLoginMainline$startLoginByCoroutine$1.L$0 = null;
                                    nTLocalPhoneLoginMainline$startLoginByCoroutine$1.label = 3;
                                    if (nTLocalPhoneLoginMainline.requestLoginByToken(optimusLoginInfo, nTLocalPhoneLoginMainline$startLoginByCoroutine$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                }
                                QLog.d(TAG, 1, "requestLoginByCoroutine login multi accounts!");
                                Object b18 = iVar2.b();
                                Intrinsics.checkNotNull(b18);
                                nTLocalPhoneLoginMainline.handleMultiAccount((LoginResult) b18);
                                return Unit.INSTANCE;
                            }
                        }
                        LoginResult loginResult3 = (LoginResult) iVar2.b();
                        if (loginResult3 != null) {
                            nTLocalPhoneLoginMainline.onNtLoginFailed(loginResult3);
                        }
                        return Unit.INSTANCE;
                    }
                    nTLocalPhoneLoginMainline = (NTLocalPhoneLoginMainline) nTLocalPhoneLoginMainline$startLoginByCoroutine$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    nTLocalPhoneLoginMainline$startLoginByCoroutine$1.L$0 = this;
                    nTLocalPhoneLoginMainline$startLoginByCoroutine$1.label = 1;
                    obj = getLocalPhoneToken(nTLocalPhoneLoginMainline$startLoginByCoroutine$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTLocalPhoneLoginMainline = this;
                }
                iVar = (i) obj;
                if (iVar.c() != 0 && iVar.b() != null) {
                    String str = (String) iVar.b();
                    CheckGatewayCodeReq checkGatewayCodeReq = new CheckGatewayCodeReq();
                    checkGatewayCodeReq.phoneToken = str;
                    checkGatewayCodeReq.appInfo = nTLocalPhoneLoginMainline.getAppInfo();
                    nTLocalPhoneLoginMainline$startLoginByCoroutine$1.L$0 = nTLocalPhoneLoginMainline;
                    nTLocalPhoneLoginMainline$startLoginByCoroutine$1.label = 2;
                    obj = nTLocalPhoneLoginMainline.getAccountsByToken(checkGatewayCodeReq, nTLocalPhoneLoginMainline$startLoginByCoroutine$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    iVar2 = (i) obj;
                    if (iVar2.c() == 0) {
                    }
                } else {
                    QLog.e(TAG, 1, "getLocalPhoneToken failed ret: " + iVar.c());
                    nTLocalPhoneLoginMainline.onLoginFailed(new com.tencent.mobileqq.login.aj(iVar.c(), ""));
                    return Unit.INSTANCE;
                }
            }
        }
        nTLocalPhoneLoginMainline$startLoginByCoroutine$1 = new NTLocalPhoneLoginMainline$startLoginByCoroutine$1(this, continuation);
        Object obj2 = nTLocalPhoneLoginMainline$startLoginByCoroutine$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTLocalPhoneLoginMainline$startLoginByCoroutine$1.label;
        boolean z172 = true;
        if (i3 == 0) {
        }
        iVar = (i) obj2;
        if (iVar.c() != 0) {
        }
        QLog.e(TAG, 1, "getLocalPhoneToken failed ret: " + iVar.c());
        nTLocalPhoneLoginMainline.onLoginFailed(new com.tencent.mobileqq.login.aj(iVar.c(), ""));
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTBaseLoginMainline
    protected boolean needCreateNewRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        T t16 = this.mLoginParams;
        if (!((be) t16).f242203d && !((be) t16).f242202c) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "onLoginCancel");
        reportEvent("0X800C310", 2, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getSecureReportInfo(), "");
        this.bindAccountList = null;
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.e
            @Override // java.lang.Runnable
            public final void run() {
                NTLocalPhoneLoginMainline.onLoginCancel$lambda$7(NTLocalPhoneLoginMainline.this);
            }
        });
        QuestionnaireForLoginManager.d(8);
        QuestionnaireForLoginManager.e();
        super.onLoginCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTBaseLoginMainline
    public void onNTLoginSuccess(@NotNull String uin, @Nullable String nick, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uin, nick, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!checkBeforeLoginSuccess(uin, bundle)) {
            return;
        }
        QLog.i(TAG, 1, "onLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(uin));
        com.tencent.mobileqq.login.account.d.f241848a.b(uin, "+86 " + ((be) this.mLoginParams).f241956f, 4);
        if (!TextUtils.isEmpty(uin)) {
            MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + uin, uin);
        }
        LoginAccountInfoApiImpl.Companion companion = LoginAccountInfoApiImpl.INSTANCE;
        String str = ((be) this.mLoginParams).f241956f;
        Intrinsics.checkNotNullExpressionValue(str, "mLoginParams.maskPhone");
        companion.b(str, uin, nick);
        reportEvent("0X800C310", 0, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getSecureReportInfo(), "");
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.f
            @Override // java.lang.Runnable
            public final void run() {
                NTLocalPhoneLoginMainline.onNTLoginSuccess$lambda$5(NTLocalPhoneLoginMainline.this);
            }
        });
        super.onNTLoginSuccess(uin, nick, bundle);
    }

    @Override // com.tencent.mobileqq.login.k
    protected void startLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "startLogin by local phone");
        this.mHasPuzzleVerify = false;
        this.mHasMultiAccountShown = false;
        this.mHasDevLockVerify = false;
        this.mHasShowMultiAccountDialog = false;
        this.mAccountInfoListSize = 0;
        reportEvent("0X800C309", 0, "", "", "", "");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new NTLocalPhoneLoginMainline$startLogin$1(this, null), 14, null);
        }
    }
}
