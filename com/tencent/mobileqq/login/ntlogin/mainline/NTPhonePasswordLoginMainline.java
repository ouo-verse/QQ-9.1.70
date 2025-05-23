package com.tencent.mobileqq.login.ntlogin.mainline;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.login.account.impl.LoginAccountInfoApiImpl;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.ay;
import com.tencent.mobileqq.login.ntlogin.NTDevLockVerifyComponent;
import com.tencent.mobileqq.login.ntlogin.ah;
import com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.login.verify.PuzzleVerifyComponent;
import com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
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
import com.tencent.qqnt.kernel.nativeinterface.AccountType;
import com.tencent.qqnt.kernel.nativeinterface.BindUinInfo;
import com.tencent.qqnt.kernel.nativeinterface.ILoginCallback;
import com.tencent.qqnt.kernel.nativeinterface.Iframe;
import com.tencent.qqnt.kernel.nativeinterface.LoginProcessReqBody;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import com.tencent.qqnt.kernel.nativeinterface.LoginRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.PwdLoginInfo;
import com.tencent.qqnt.kernel.nativeinterface.UinInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserProfile;
import com.tencent.qqnt.kernel.nativeinterface.VerifySuccessSign;
import com.tencent.qqnt.kernel.nativeinterface.VerifyType;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J#\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J3\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010!\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000eH\u0002J!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0012\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u0003H\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020\u0007H\u0002J8\u00101\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0002J\b\u00102\u001a\u00020\u000eH\u0002J\b\u00103\u001a\u00020\u0007H\u0014J\"\u00107\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010\u000e2\u0006\u00106\u001a\u00020\u0017H\u0014J\b\u00108\u001a\u00020\u0007H\u0014J\b\u00109\u001a\u00020\u0005H\u0014J\u0018\u0010<\u001a\u0004\u0018\u00010\u000e2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000eR\u0016\u0010=\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010>R \u0010B\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010A\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010>R\u001e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010M\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhonePasswordLoginMainline;", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTBaseLoginMainline;", "Lcom/tencent/mobileqq/login/ay;", "Lcom/tencent/qqnt/kernel/nativeinterface/PwdLoginInfo;", "pwdLoginInfo", "", "loginByToken", "", "startLoginByCoroutine", "requestLoginByCoroutine", "(Lcom/tencent/qqnt/kernel/nativeinterface/PwdLoginInfo;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "loginResult", "Lcom/tencent/mobileqq/login/ntlogin/mainline/i;", "", "newDevLockVerify", "(Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDevLockReportInfo", "loginInfo", "handleMultiAccountLogin", "", TangramHippyConstants.LOGIN_TYPE, "verifyUrl", "Landroid/os/Bundle;", "passThroughParams", "Lcom/tencent/qqnt/kernel/nativeinterface/VerifySuccessSign;", "requestPuzzleVerify", "(ILjava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/mobileqq/bean/AccountInfo;", "accountInfoList", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$b;", "listener", "showMultiAccountDialog", "msg", UIJsPlugin.EVENT_SHOW_TOAST, "requestNTLogin", "(Lcom/tencent/qqnt/kernel/nativeinterface/PwdLoginInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRemindLogin", "reLogin", "getLoginInfo", "onNtLoginFailed", "dismissMultiAccountDialog", "tValue", "result", "r2", "r3", "r4", "r5", "reportEvent", "getLoginEndReportInfo", "startLogin", "uin", "nick", "bundle", "onNTLoginSuccess", "onLoginCancel", "needCreateNewRuntime", "urlString", "parameterName", "getParameterValue", "mHasPuzzleVerify", "Z", "mHasMultiAccountShown", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/widget/bm;", "mMultiAccountDialogRef", "Lmqq/util/WeakReference;", "mAccountInfo", "Lcom/tencent/mobileqq/bean/AccountInfo;", "mAccountInfoListSize", "I", "mHasDevLockVerify", "", "bindAccountList", "Ljava/util/List;", "mSelectAccountListener", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$b;", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NTPhonePasswordLoginMainline extends NTBaseLoginMainline<ay> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "NTLoginMainline_PhonePasswordLogin";

    @Nullable
    private List<AccountInfo> bindAccountList;

    @Nullable
    private AccountInfo mAccountInfo;
    private int mAccountInfoListSize;
    private boolean mHasDevLockVerify;
    private boolean mHasMultiAccountShown;
    private boolean mHasPuzzleVerify;

    @Nullable
    private WeakReference<bm> mMultiAccountDialogRef;

    @NotNull
    private final NTPhoneSmsLoginMainline.b mSelectAccountListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhonePasswordLoginMainline$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.ntlogin.mainline.NTPhonePasswordLoginMainline$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTPhonePasswordLoginMainline$b", "Lcom/tencent/mobileqq/login/remind/h$b;", "", "a", "b", "", "url", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements h.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoginResult f242280b;

        b(LoginResult loginResult) {
            this.f242280b = loginResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTPhonePasswordLoginMainline.this, (Object) loginResult);
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                NTPhonePasswordLoginMainline.this.onLoginCancel();
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                NTPhonePasswordLoginMainline.this.reLogin(this.f242280b);
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
            QLog.d(NTPhonePasswordLoginMainline.TAG, 1, "onJumpUrl :" + url);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTPhonePasswordLoginMainline$c", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$b;", "Lcom/tencent/mobileqq/bean/AccountInfo;", "accountInfo", "", "loginContext", "", "accountInfoListSize", "", "autoSelect", "", "a", "onCancel", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements NTPhoneSmsLoginMainline.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTPhonePasswordLoginMainline.this);
            }
        }

        @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline.b
        public void a(@NotNull AccountInfo accountInfo, @Nullable byte[] loginContext, int accountInfoListSize, boolean autoSelect) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, accountInfo, loginContext, Integer.valueOf(accountInfoListSize), Boolean.valueOf(autoSelect));
                return;
            }
            Intrinsics.checkNotNullParameter(accountInfo, "accountInfo");
            QLog.d(NTPhonePasswordLoginMainline.TAG, 1, "selectAccountFromList onSelectAccount uin=" + accountInfo.getMaskUin());
            NTPhonePasswordLoginMainline nTPhonePasswordLoginMainline = NTPhonePasswordLoginMainline.this;
            String valueOf = String.valueOf(accountInfoListSize);
            if (autoSelect) {
                str = "2";
            } else {
                str = "1";
            }
            if (!NTPhonePasswordLoginMainline.this.mHasPuzzleVerify) {
                str2 = "2";
            } else {
                str2 = "1";
            }
            nTPhonePasswordLoginMainline.reportEvent("0X800C385", 0, valueOf, str, str2, "");
            NTPhonePasswordLoginMainline.this.mAccountInfo = accountInfo;
            NTPhonePasswordLoginMainline.this.mAccountInfoListSize = accountInfoListSize;
            PwdLoginInfo loginInfo = NTPhonePasswordLoginMainline.this.getLoginInfo();
            loginInfo.loginContext = loginContext;
            loginInfo.uinInfo = accountInfo.getNtUinInfo();
            NTPhonePasswordLoginMainline.this.startLoginByCoroutine(loginInfo, true);
            NTPhonePasswordLoginMainline.this.showLoading();
        }

        @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline.b
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d(NTPhonePasswordLoginMainline.TAG, 1, "selectAccountFromList onCancel");
                NTPhonePasswordLoginMainline.this.onLoginCancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "loginResultInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class d implements ILoginCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<LoginResult>> f242282a;

        /* JADX WARN: Multi-variable type inference failed */
        d(CancellableContinuation<? super i<LoginResult>> cancellableContinuation) {
            this.f242282a = cancellableContinuation;
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
            CancellableContinuation<i<LoginResult>> cancellableContinuation = this.f242282a;
            i iVar = new i(i3, str, loginResult);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "request loginsafeResume call failed ");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTPhonePasswordLoginMainline$e", "Lcom/tencent/mobileqq/login/verify/PuzzleVerifyComponent$b;", "", "result", "", "ticket", "randStr", "appId", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements PuzzleVerifyComponent.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f242284b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<VerifySuccessSign>> f242285c;

        /* JADX WARN: Multi-variable type inference failed */
        e(String str, CancellableContinuation<? super i<VerifySuccessSign>> cancellableContinuation) {
            this.f242284b = str;
            this.f242285c = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTPhonePasswordLoginMainline.this, str, cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(NTPhonePasswordLoginMainline.TAG, 1, "PuzzleVerify cancel");
            NTPhonePasswordLoginMainline.this.reportEvent("0X800C4B1", 2, "", "", "", "");
            CancellableContinuation<i<VerifySuccessSign>> cancellableContinuation = this.f242285c;
            i iVar = new i(-1, "puzzle verify cancel", null);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "new puzzle verifysafeResume call failed ");
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void b(boolean result, @Nullable String ticket, @Nullable String randStr, @Nullable String appId) {
            byte[] bArr;
            byte[] bArr2;
            byte[] bArr3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), ticket, randStr, appId);
                return;
            }
            QLog.i(NTPhonePasswordLoginMainline.TAG, 1, "PuzzleVerify result=" + result);
            NTPhonePasswordLoginMainline.this.reportEvent("0X800C4B1", 0, "", "", "", "");
            Iframe iframe = new Iframe();
            if (ticket != null) {
                bArr = ticket.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr = null;
            }
            iframe.iframeSig = bArr;
            if (randStr != null) {
                bArr2 = randStr.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr2 = null;
            }
            iframe.iframeRandstr = bArr2;
            String parameterValue = NTPhonePasswordLoginMainline.this.getParameterValue(this.f242284b, "sid");
            if (parameterValue != null) {
                bArr3 = parameterValue.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr3, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr3 = null;
            }
            iframe.iframeSid = bArr3;
            VerifySuccessSign verifySuccessSign = new VerifySuccessSign();
            verifySuccessSign.verifyType = VerifyType.VERIFY_TYPE_CAPTCHA;
            verifySuccessSign.iframe = iframe;
            CancellableContinuation<i<VerifySuccessSign>> cancellableContinuation = this.f242285c;
            i iVar = new i(0, null, verifySuccessSign);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "new puzzle verifysafeResume call failed ");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTPhonePasswordLoginMainline$f", "Lcom/tencent/mobileqq/widget/bm$c;", "", "account", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class f implements bm.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NTPhoneSmsLoginMainline.b f242286a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoginResult f242287b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<AccountInfo> f242288c;

        /* JADX WARN: Multi-variable type inference failed */
        f(NTPhoneSmsLoginMainline.b bVar, LoginResult loginResult, List<? extends AccountInfo> list) {
            this.f242286a = bVar;
            this.f242287b = loginResult;
            this.f242288c = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, loginResult, list);
            }
        }

        @Override // com.tencent.mobileqq.widget.bm.c
        public void a(@NotNull Object account) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, account);
            } else {
                Intrinsics.checkNotNullParameter(account, "account");
                this.f242286a.a((AccountInfo) account, this.f242287b.rspInfo.loginContext, this.f242288c.size(), false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21757);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTPhonePasswordLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSelectAccountListener = new c();
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

    private final String getDevLockReportInfo() {
        boolean z16 = this.mHasPuzzleVerify;
        if (z16 && this.mHasMultiAccountShown) {
            return "1";
        }
        if (z16) {
            return "2";
        }
        if (this.mHasMultiAccountShown) {
            return "3";
        }
        return "4";
    }

    private final String getLoginEndReportInfo() {
        if (this.mHasPuzzleVerify) {
            if (this.mHasMultiAccountShown) {
                if (this.mHasDevLockVerify) {
                    return "1";
                }
                return "2";
            }
            if (this.mHasDevLockVerify) {
                return "3";
            }
            return "4";
        }
        if (this.mHasMultiAccountShown) {
            if (this.mHasDevLockVerify) {
                return "5";
            }
            return "6";
        }
        if (this.mHasDevLockVerify) {
            return "7";
        }
        return "8";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PwdLoginInfo getLoginInfo() {
        UserInfo userInfo = new UserInfo();
        T t16 = this.mLoginParams;
        userInfo.account = ((ay) t16).f241929f;
        userInfo.accountType = AccountType.ACCOUNTTYPE_PHONENUM;
        String str = ((ay) t16).f241930g;
        Intrinsics.checkNotNullExpressionValue(str, "mLoginParams.countryCode");
        userInfo.countryCode = Integer.parseInt(str);
        PwdLoginInfo pwdLoginInfo = new PwdLoginInfo();
        pwdLoginInfo.userInfo = userInfo;
        pwdLoginInfo.passwordMd5 = util.buf_to_string(((ay) this.mLoginParams).f241932i);
        pwdLoginInfo.appInfo = getAppInfo();
        LoginProcessReqBody loginProcessReqBody = new LoginProcessReqBody();
        loginProcessReqBody.needRemindCancellatedStatus = com.tencent.mobileqq.login.remind.n.f242580a.c(((ay) this.mLoginParams).f241929f);
        pwdLoginInfo.loginProcessReq = loginProcessReqBody;
        ah ahVar = ah.f242228a;
        String str2 = ((ay) this.mLoginParams).f241929f;
        Intrinsics.checkNotNullExpressionValue(str2, "mLoginParams.phoneNum");
        String a16 = ahVar.a(str2);
        if (a16 != null) {
            byte[] bytes = a16.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            pwdLoginInfo.longCookie = bytes;
        }
        return pwdLoginInfo;
    }

    private final void handleMultiAccountLogin(final LoginResult loginInfo) {
        BindUinInfo bindUinInfo;
        String str;
        final ArrayList arrayList = new ArrayList();
        try {
            LoginRspInfo loginRspInfo = loginInfo.rspInfo;
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
            if (this.mHasPuzzleVerify) {
                str = "1";
            } else {
                str = "2";
            }
            String str2 = str;
            if (arrayList.isEmpty()) {
                onNtLoginFailed(loginInfo);
                reportEvent("0X800C384", 1, "", str2, String.valueOf(loginInfo.rspInfo.errCode), "");
                QLog.e(TAG, 1, "onGetSaltUinList failed ret=" + loginInfo.rspInfo.errCode + " accountInfoList isEmpty");
                return;
            }
            int size = arrayList.size();
            QLog.i(TAG, 1, "onGetSaltUinList accountInfoListSize=" + size);
            reportEvent("0X800C384", 0, "", str2, "0", "");
            int i3 = 0;
            if (size == 1) {
                QLog.d(TAG, 1, "handleMultiAccountLogin only one auto login");
                NTPhoneSmsLoginMainline.b bVar = this.mSelectAccountListener;
                AccountInfo accountInfo = (AccountInfo) arrayList.get(0);
                LoginRspInfo loginRspInfo2 = loginInfo.rspInfo;
                if (loginRspInfo2 != null) {
                    bArr = loginRspInfo2.loginContext;
                }
                bVar.a(accountInfo, bArr, size, true);
                return;
            }
            T t16 = this.mLoginParams;
            AccountInfo d17 = z.d(arrayList, Marker.ANY_NON_NULL_MARKER + ((ay) t16).f241930g + " " + ((ay) t16).f241929f, ((ay) this.mLoginParams).f241931h);
            if (d17 != null) {
                QLog.i(TAG, 1, "startMultiAccountLogin auto select selectedAccountInfo uin " + StringUtil.getSimpleUinForPrint(((ay) this.mLoginParams).f241931h));
                NTPhoneSmsLoginMainline.b bVar2 = this.mSelectAccountListener;
                LoginRspInfo loginRspInfo3 = loginInfo.rspInfo;
                if (loginRspInfo3 != null) {
                    bArr = loginRspInfo3.loginContext;
                }
                bVar2.a(d17, bArr, size, true);
                return;
            }
            if (isLoginActivityInvalid()) {
                i3 = 1000;
            }
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.p
                @Override // java.lang.Runnable
                public final void run() {
                    NTPhonePasswordLoginMainline.handleMultiAccountLogin$lambda$2(NTPhonePasswordLoginMainline.this, arrayList, loginInfo);
                }
            }, i3);
        } catch (Exception e16) {
            onNtLoginFailed(loginInfo);
            QLog.e(TAG, 1, "onGetSaltUinList failed" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMultiAccountLogin$lambda$2(NTPhonePasswordLoginMainline this$0, List accountInfoList, LoginResult loginInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(accountInfoList, "$accountInfoList");
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        this$0.showMultiAccountDialog(accountInfoList, loginInfo, this$0.mSelectAccountListener);
    }

    private final void handleRemindLogin(final LoginResult loginInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.l
            @Override // java.lang.Runnable
            public final void run() {
                NTPhonePasswordLoginMainline.handleRemindLogin$lambda$9(LoginResult.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleRemindLogin$lambda$9(LoginResult loginInfo, NTPhonePasswordLoginMainline this$0) {
        String str;
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.login.remind.m mVar = new com.tencent.mobileqq.login.remind.m();
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        AccountInfo accountInfo = this$0.mAccountInfo;
        if (accountInfo != null) {
            str = accountInfo.getMaskUin();
        } else {
            str = null;
        }
        if (!mVar.e(qBaseActivity, loginInfo, str, new b(loginInfo))) {
            this$0.reLogin(loginInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object newDevLockVerify(LoginResult loginResult, Continuation<? super i<String>> continuation) {
        NTPhonePasswordLoginMainline$newDevLockVerify$1 nTPhonePasswordLoginMainline$newDevLockVerify$1;
        Object coroutine_suspended;
        int i3;
        long currentTimeMillis;
        NTPhonePasswordLoginMainline nTPhonePasswordLoginMainline;
        String g16;
        if (continuation instanceof NTPhonePasswordLoginMainline$newDevLockVerify$1) {
            nTPhonePasswordLoginMainline$newDevLockVerify$1 = (NTPhonePasswordLoginMainline$newDevLockVerify$1) continuation;
            int i16 = nTPhonePasswordLoginMainline$newDevLockVerify$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTPhonePasswordLoginMainline$newDevLockVerify$1.label = i16 - Integer.MIN_VALUE;
                NTPhonePasswordLoginMainline$newDevLockVerify$1 nTPhonePasswordLoginMainline$newDevLockVerify$12 = nTPhonePasswordLoginMainline$newDevLockVerify$1;
                Object obj = nTPhonePasswordLoginMainline$newDevLockVerify$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTPhonePasswordLoginMainline$newDevLockVerify$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        currentTimeMillis = nTPhonePasswordLoginMainline$newDevLockVerify$12.J$0;
                        NTPhonePasswordLoginMainline nTPhonePasswordLoginMainline2 = (NTPhonePasswordLoginMainline) nTPhonePasswordLoginMainline$newDevLockVerify$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        nTPhonePasswordLoginMainline = nTPhonePasswordLoginMainline2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.d(TAG, 1, "requestLoginByCoroutine need new device verify!");
                    this.mHasDevLockVerify = true;
                    QuestionnaireForLoginManager.g("new_device");
                    reportEvent("0X800C389", 0, "", getDevLockReportInfo(), "", "");
                    Bundle bundle = new Bundle();
                    bundle.putString("url", loginResult.rspInfo.jumpUrl);
                    bundle.putSerializable("key_mask_user_info", this.mAccountInfo);
                    if (((ay) this.mLoginParams).f242202c) {
                        bundle.putBoolean("isSubaccount", true);
                        bundle.putString("from_where", "subaccount");
                    }
                    T t16 = this.mLoginParams;
                    if (((ay) t16).f242203d) {
                        bundle.putString("appid", ((ay) t16).f241934k);
                        bundle.putString("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
                    }
                    T t17 = this.mLoginParams;
                    if (((ay) t17).f242201b == 16 && ((ay) t17).f242204e && (g16 = com.tencent.mobileqq.accountbinding.d.f174609a.g()) != null) {
                        bundle.putString("wechat_login_bind_uin", g16);
                    }
                    bundle.putInt(TangramHippyConstants.LOGIN_TYPE, ((ay) this.mLoginParams).f242200a);
                    currentTimeMillis = System.currentTimeMillis();
                    NTDevLockVerifyComponent nTDevLockVerifyComponent = new NTDevLockVerifyComponent();
                    int i17 = ((ay) this.mLoginParams).f242200a;
                    LoginRspInfo loginRspInfo = loginResult.rspInfo;
                    Intrinsics.checkNotNullExpressionValue(loginRspInfo, "loginResult.rspInfo");
                    nTPhonePasswordLoginMainline$newDevLockVerify$12.L$0 = this;
                    nTPhonePasswordLoginMainline$newDevLockVerify$12.J$0 = currentTimeMillis;
                    nTPhonePasswordLoginMainline$newDevLockVerify$12.label = 1;
                    obj = nTDevLockVerifyComponent.f(i17, "", loginRspInfo, bundle, nTPhonePasswordLoginMainline$newDevLockVerify$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTPhonePasswordLoginMainline = this;
                }
                i iVar = (i) obj;
                nTPhonePasswordLoginMainline.reportEvent("0X800C38A", iVar.c(), String.valueOf(System.currentTimeMillis() - currentTimeMillis), nTPhonePasswordLoginMainline.getDevLockReportInfo(), "", "");
                return iVar;
            }
        }
        nTPhonePasswordLoginMainline$newDevLockVerify$1 = new NTPhonePasswordLoginMainline$newDevLockVerify$1(this, continuation);
        NTPhonePasswordLoginMainline$newDevLockVerify$1 nTPhonePasswordLoginMainline$newDevLockVerify$122 = nTPhonePasswordLoginMainline$newDevLockVerify$1;
        Object obj2 = nTPhonePasswordLoginMainline$newDevLockVerify$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTPhonePasswordLoginMainline$newDevLockVerify$122.label;
        if (i3 == 0) {
        }
        i iVar2 = (i) obj2;
        nTPhonePasswordLoginMainline.reportEvent("0X800C38A", iVar2.c(), String.valueOf(System.currentTimeMillis() - currentTimeMillis), nTPhonePasswordLoginMainline.getDevLockReportInfo(), "", "");
        return iVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLoginCancel$lambda$4(NTPhonePasswordLoginMainline this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissMultiAccountDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNTLoginSuccess$lambda$3(NTPhonePasswordLoginMainline this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideLoading(true);
        this$0.dismissMultiAccountDialog();
    }

    private final void onNtLoginFailed(LoginResult loginInfo) {
        QLog.e(TAG, 1, "onNtLoginFailed ret = " + loginInfo.rspInfo.errCode);
        hideLoading(false);
        this.bindAccountList = null;
        com.tencent.mobileqq.login.ntlogin.u uVar = com.tencent.mobileqq.login.ntlogin.u.f242388a;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        T mLoginParams = this.mLoginParams;
        Intrinsics.checkNotNullExpressionValue(mLoginParams, "mLoginParams");
        if (uVar.J(qBaseActivity, (ay) mLoginParams, loginInfo)) {
            QLog.d(TAG, 1, "onNtLoginFailed can login other account");
            return;
        }
        aj ajVar = new aj();
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
        reportEvent("0X800C388", 1, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), String.valueOf(i3), getLoginEndReportInfo(), "");
        QLog.i(TAG, 1, "onLoginFailed ret=" + i3 + " msg=" + ajVar.f241866c);
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.n
            @Override // java.lang.Runnable
            public final void run() {
                NTPhonePasswordLoginMainline.onNtLoginFailed$lambda$11(NTPhonePasswordLoginMainline.this);
            }
        });
        QuestionnaireForLoginManager.e();
        QuestionnaireForLoginManager.d(8);
        onLoginFailed(ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNtLoginFailed$lambda$11(NTPhonePasswordLoginMainline this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideLoading(false);
        this$0.dismissMultiAccountDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reLogin(LoginResult loginResult) {
        LoginProcessReqBody loginProcessReqBody = new LoginProcessReqBody();
        loginProcessReqBody.needRemindCancellatedStatus = com.tencent.mobileqq.login.remind.n.f242580a.c(((ay) this.mLoginParams).f241929f);
        PwdLoginInfo loginInfo = getLoginInfo();
        loginInfo.loginProcessReq = loginProcessReqBody;
        loginInfo.loginContext = loginResult.rspInfo.loginContext;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new NTPhonePasswordLoginMainline$reLogin$1(this, loginInfo, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportEvent(String tValue, int result, String r26, String r36, String r46, String r56) {
        T t16 = this.mLoginParams;
        as.b("phone_pwd_login_mainline", tValue, ((ay) t16).f241929f, ((ay) t16).f242201b, result, true, r26, r36, r46, r56);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0030. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v5, types: [int] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r3v13, types: [com.tencent.mobileqq.login.ntlogin.mainline.NTPhonePasswordLoginMainline] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestLoginByCoroutine(PwdLoginInfo pwdLoginInfo, boolean z16, Continuation<? super Unit> continuation) {
        NTPhonePasswordLoginMainline$requestLoginByCoroutine$1 nTPhonePasswordLoginMainline$requestLoginByCoroutine$1;
        NTPhonePasswordLoginMainline$requestLoginByCoroutine$1 nTPhonePasswordLoginMainline$requestLoginByCoroutine$12;
        Object coroutine_suspended;
        boolean z17;
        String str;
        long currentTimeMillis;
        PwdLoginInfo pwdLoginInfo2;
        boolean z18;
        NTPhonePasswordLoginMainline nTPhonePasswordLoginMainline;
        String str2;
        String str3;
        boolean z19;
        i iVar;
        boolean z26;
        NTPhonePasswordLoginMainline nTPhonePasswordLoginMainline2;
        i iVar2;
        PwdLoginInfo pwdLoginInfo3;
        ?? r36;
        i iVar3;
        PwdLoginInfo pwdLoginInfo4;
        NTPhonePasswordLoginMainline nTPhonePasswordLoginMainline3;
        i iVar4;
        boolean z27;
        BindUinInfo bindUinInfo;
        ArrayList<UinInfo> arrayList;
        String str4;
        String str5;
        ?? r142;
        i iVar5;
        byte[] bArr;
        ?? r143;
        i iVar6;
        byte[] bArr2;
        byte[] bArr3;
        boolean z28;
        UserProfile userProfile;
        if (continuation instanceof NTPhonePasswordLoginMainline$requestLoginByCoroutine$1) {
            nTPhonePasswordLoginMainline$requestLoginByCoroutine$1 = (NTPhonePasswordLoginMainline$requestLoginByCoroutine$1) continuation;
            int i3 = nTPhonePasswordLoginMainline$requestLoginByCoroutine$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                nTPhonePasswordLoginMainline$requestLoginByCoroutine$1.label = i3 - Integer.MIN_VALUE;
                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12 = nTPhonePasswordLoginMainline$requestLoginByCoroutine$1;
                Object obj = nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        QLog.d(TAG, 1, "requestLoginByCoroutine ");
                        if (z16) {
                            String valueOf = String.valueOf(this.mAccountInfoListSize);
                            AccountInfo accountInfo = this.mAccountInfo;
                            if (accountInfo != null) {
                                str2 = accountInfo.getMaskUin();
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str3 = "";
                            } else {
                                str3 = str2;
                            }
                            z17 = true;
                            str = TAG;
                            reportEvent("0X800C386", 0, valueOf, "", str3, "");
                        } else {
                            z17 = true;
                            str = TAG;
                        }
                        currentTimeMillis = System.currentTimeMillis();
                        nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$0 = this;
                        nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$1 = pwdLoginInfo;
                        nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.Z$0 = z16;
                        nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.J$0 = currentTimeMillis;
                        nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.label = z17 ? 1 : 0;
                        obj = requestNTLogin(pwdLoginInfo, nTPhonePasswordLoginMainline$requestLoginByCoroutine$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pwdLoginInfo2 = pwdLoginInfo;
                        z18 = z16;
                        nTPhonePasswordLoginMainline = this;
                        z19 = z17;
                        iVar = (i) obj;
                        QLog.d(str, z19 ? 1 : 0, "requestLoginByCoroutine result: " + iVar.c() + " errMsg: " + iVar.a());
                        if (z18) {
                            int c16 = iVar.c();
                            String valueOf2 = String.valueOf(System.currentTimeMillis() - currentTimeMillis);
                            AccountInfo accountInfo2 = nTPhonePasswordLoginMainline.mAccountInfo;
                            if (accountInfo2 != null) {
                                str4 = accountInfo2.getMaskUin();
                            } else {
                                str4 = null;
                            }
                            if (str4 == null) {
                                str5 = "";
                            } else {
                                str5 = str4;
                            }
                            nTPhonePasswordLoginMainline.reportEvent("0X800C387", c16, valueOf2, "", str5, "");
                        }
                        if (iVar.c() != 0 && iVar.b() != null) {
                            int i16 = ((LoginResult) iVar.b()).rspInfo.errCode;
                            if (i16 == 0) {
                                LoginRspInfo loginRspInfo = ((LoginResult) iVar.b()).rspInfo;
                                if (loginRspInfo != null && (bindUinInfo = loginRspInfo.bindUinInfo) != null && (arrayList = bindUinInfo.uinInfoList) != null) {
                                    if (((arrayList.isEmpty() ? 1 : 0) ^ (z19 ? 1 : 0)) == z19) {
                                        z27 = z19 ? 1 : 0;
                                        if (z27) {
                                            QLog.d(str, 2, "requestLoginByCoroutine login multi accounts!");
                                            nTPhonePasswordLoginMainline.handleMultiAccountLogin((LoginResult) iVar.b());
                                            return Unit.INSTANCE;
                                        }
                                    }
                                }
                                z27 = false;
                                if (z27) {
                                }
                            }
                            if (i16 == 140022008) {
                                QLog.d(str, z19 ? 1 : 0, "startLogin need new water wall verify!!!");
                                int i17 = ((ay) nTPhonePasswordLoginMainline.mLoginParams).f242200a;
                                String jumpUrl = ((LoginResult) iVar.b()).rspInfo.getJumpUrl();
                                Intrinsics.checkNotNullExpressionValue(jumpUrl, "loginResult.extraData.rspInfo.getJumpUrl()");
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$0 = nTPhonePasswordLoginMainline;
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$1 = pwdLoginInfo2;
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$2 = iVar;
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.label = 2;
                                Object requestPuzzleVerify = nTPhonePasswordLoginMainline.requestPuzzleVerify(i17, jumpUrl, null, nTPhonePasswordLoginMainline$requestLoginByCoroutine$12);
                                if (requestPuzzleVerify == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                pwdLoginInfo4 = pwdLoginInfo2;
                                nTPhonePasswordLoginMainline3 = nTPhonePasswordLoginMainline;
                                iVar4 = iVar;
                                obj = requestPuzzleVerify;
                                r142 = z19;
                                iVar5 = (i) obj;
                                if (iVar5.c() != 0) {
                                    QLog.d(str, (int) r142, "requestLoginByCoroutine new water verify success!!!");
                                    pwdLoginInfo4.verifySign = (VerifySuccessSign) iVar5.b();
                                    LoginRspInfo loginRspInfo2 = ((LoginResult) iVar4.b()).rspInfo;
                                    if (loginRspInfo2 != null) {
                                        bArr = loginRspInfo2.loginContext;
                                    } else {
                                        bArr = null;
                                    }
                                    pwdLoginInfo4.loginContext = bArr;
                                    nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$0 = null;
                                    nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$1 = null;
                                    nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$2 = null;
                                    nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.label = 3;
                                    if (nTPhonePasswordLoginMainline3.requestLoginByCoroutine(pwdLoginInfo4, false, nTPhonePasswordLoginMainline$requestLoginByCoroutine$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                }
                                QLog.d(str, (int) r142, "requestLoginByCoroutine new water verify cancel");
                                nTPhonePasswordLoginMainline3.onLoginCancel();
                                return Unit.INSTANCE;
                            }
                            z26 = false;
                            if (i16 == 140022010) {
                                QLog.d(str, z19 ? 1 : 0, "requestLoginByCoroutine need new device verify!");
                                LoginResult loginResult = (LoginResult) iVar.b();
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$0 = nTPhonePasswordLoginMainline;
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$1 = pwdLoginInfo2;
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$2 = iVar;
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.label = 4;
                                Object newDevLockVerify = nTPhonePasswordLoginMainline.newDevLockVerify(loginResult, nTPhonePasswordLoginMainline$requestLoginByCoroutine$12);
                                if (newDevLockVerify == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                pwdLoginInfo3 = pwdLoginInfo2;
                                r36 = nTPhonePasswordLoginMainline;
                                iVar3 = iVar;
                                obj = newDevLockVerify;
                                r143 = z19;
                                iVar6 = (i) obj;
                                if (iVar6.c() != 0) {
                                    QLog.d(str, (int) r143, "requestLoginByCoroutine new device verify success!");
                                    VerifySuccessSign verifySuccessSign = new VerifySuccessSign();
                                    String str6 = (String) iVar6.b();
                                    if (str6 != null) {
                                        bArr2 = str6.getBytes(Charsets.UTF_8);
                                        Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
                                    } else {
                                        bArr2 = null;
                                    }
                                    verifySuccessSign.deviceCheckSucceedSig = bArr2;
                                    verifySuccessSign.verifyType = VerifyType.VERIFY_TYPE_NEW_DEVICE;
                                    pwdLoginInfo3.verifySign = verifySuccessSign;
                                    LoginRspInfo loginRspInfo3 = ((LoginResult) iVar3.b()).rspInfo;
                                    if (loginRspInfo3 != null) {
                                        bArr3 = loginRspInfo3.loginContext;
                                    } else {
                                        bArr3 = null;
                                    }
                                    pwdLoginInfo3.loginContext = bArr3;
                                    nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$0 = null;
                                    nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$1 = null;
                                    nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$2 = null;
                                    nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.label = 5;
                                    if (r36.requestLoginByCoroutine(pwdLoginInfo3, r143, nTPhonePasswordLoginMainline$requestLoginByCoroutine$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    QLog.d(str, (int) r143, "requestLoginByCoroutine new dev verify cancel!");
                                    r36.onLoginCancel();
                                }
                                return Unit.INSTANCE;
                            }
                            if (i16 == 150022028) {
                                nTPhonePasswordLoginMainline.handleRemindLogin((LoginResult) iVar.b());
                                return Unit.INSTANCE;
                            }
                            if (i16 == 0) {
                                QLog.d(str, 2, "requestLoginByCoroutine login success");
                                LoginResult loginResult2 = (LoginResult) iVar.b();
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$0 = nTPhonePasswordLoginMainline;
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$1 = iVar;
                                nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.label = 6;
                                Object commitMsfTicket = nTPhonePasswordLoginMainline.commitMsfTicket(loginResult2, nTPhonePasswordLoginMainline$requestLoginByCoroutine$12);
                                if (commitMsfTicket == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                nTPhonePasswordLoginMainline2 = nTPhonePasswordLoginMainline;
                                iVar2 = iVar;
                                obj = commitMsfTicket;
                                z28 = z19;
                                if (((i) obj).c() != 0) {
                                    String valueOf3 = String.valueOf(((LoginResult) iVar2.b()).getAccount().getUin());
                                    byte[] nick = ((LoginResult) iVar2.b()).getAccount().getUserProfile().getNickName();
                                    Bundle bundle = new Bundle();
                                    Account account = ((LoginResult) iVar2.b()).account;
                                    if (account != null && (userProfile = account.userProfile) != null && userProfile.registerWithoutPwd == z28) {
                                        z26 = z28;
                                    }
                                    if (z26) {
                                        bundle.putBoolean("without_pwd", z28);
                                    }
                                    Intrinsics.checkNotNullExpressionValue(nick, "nick");
                                    nTPhonePasswordLoginMainline2.onNTLoginSuccess(valueOf3, new String(nick, Charsets.UTF_8), bundle);
                                } else {
                                    QLog.d(str, 2, "requestLoginByCoroutine commit ticket failed!");
                                    nTPhonePasswordLoginMainline2.onNtLoginFailed((LoginResult) iVar2.b());
                                }
                                return Unit.INSTANCE;
                            }
                            nTPhonePasswordLoginMainline.onNtLoginFailed((LoginResult) iVar.b());
                            return Unit.INSTANCE;
                        }
                        QLog.e(str, z19 ? 1 : 0, "requestLoginByCoroutine login failed ret: " + iVar.c());
                        nTPhonePasswordLoginMainline.onLoginFailed(new aj(iVar.c(), ""));
                        nTPhonePasswordLoginMainline.showToast("\u767b\u5f55\u5931\u8d25:" + iVar.c());
                        return Unit.INSTANCE;
                    case 1:
                        currentTimeMillis = nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.J$0;
                        z18 = nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.Z$0;
                        pwdLoginInfo2 = (PwdLoginInfo) nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$1;
                        nTPhonePasswordLoginMainline = (NTPhonePasswordLoginMainline) nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        z19 = true;
                        str = TAG;
                        iVar = (i) obj;
                        QLog.d(str, z19 ? 1 : 0, "requestLoginByCoroutine result: " + iVar.c() + " errMsg: " + iVar.a());
                        if (z18) {
                        }
                        if (iVar.c() != 0) {
                            break;
                        }
                        QLog.e(str, z19 ? 1 : 0, "requestLoginByCoroutine login failed ret: " + iVar.c());
                        nTPhonePasswordLoginMainline.onLoginFailed(new aj(iVar.c(), ""));
                        nTPhonePasswordLoginMainline.showToast("\u767b\u5f55\u5931\u8d25:" + iVar.c());
                        return Unit.INSTANCE;
                    case 2:
                        iVar4 = (i) nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$2;
                        pwdLoginInfo4 = (PwdLoginInfo) nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$1;
                        nTPhonePasswordLoginMainline3 = (NTPhonePasswordLoginMainline) nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        r142 = 1;
                        str = TAG;
                        iVar5 = (i) obj;
                        if (iVar5.c() != 0) {
                        }
                        break;
                    case 3:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 4:
                        iVar3 = (i) nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$2;
                        pwdLoginInfo3 = (PwdLoginInfo) nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$1;
                        NTPhonePasswordLoginMainline nTPhonePasswordLoginMainline4 = (NTPhonePasswordLoginMainline) nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        r143 = 1;
                        str = TAG;
                        r36 = nTPhonePasswordLoginMainline4;
                        iVar6 = (i) obj;
                        if (iVar6.c() != 0) {
                        }
                        return Unit.INSTANCE;
                    case 5:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 6:
                        iVar2 = (i) nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$1;
                        NTPhonePasswordLoginMainline nTPhonePasswordLoginMainline5 = (NTPhonePasswordLoginMainline) nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        z28 = true;
                        str = TAG;
                        z26 = false;
                        nTPhonePasswordLoginMainline2 = nTPhonePasswordLoginMainline5;
                        if (((i) obj).c() != 0) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        nTPhonePasswordLoginMainline$requestLoginByCoroutine$1 = new NTPhonePasswordLoginMainline$requestLoginByCoroutine$1(this, continuation);
        nTPhonePasswordLoginMainline$requestLoginByCoroutine$12 = nTPhonePasswordLoginMainline$requestLoginByCoroutine$1;
        Object obj2 = nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (nTPhonePasswordLoginMainline$requestLoginByCoroutine$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestNTLogin(PwdLoginInfo pwdLoginInfo, Continuation<? super i<LoginResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "requestNTLogin uin: " + pwdLoginInfo.userInfo.account);
        ((ILoginService) QRoute.api(ILoginService.class)).passwordLogin(pwdLoginInfo, new d(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestPuzzleVerify(int i3, String str, Bundle bundle, Continuation<? super i<VerifySuccessSign>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.mHasPuzzleVerify = true;
        System.currentTimeMillis();
        reportEvent("0X800C383", 0, "", "", "", "");
        QLog.d(TAG, 2, "startPuzzleVerify url: " + str);
        new PuzzleVerifyComponent().d(i3, str, new e(str, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void showMultiAccountDialog(List<? extends AccountInfo> accountInfoList, LoginResult loginInfo, final NTPhoneSmsLoginMainline.b listener) {
        String str;
        QLog.d(TAG, 2, "showMultiAccountDialog");
        QBaseActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            bm b16 = bk.b(activity, accountInfoList, loginInfo.rspInfo.bindUinInfo.unbindWording, new f(listener, loginInfo, accountInfoList), new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.k
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    NTPhonePasswordLoginMainline.showMultiAccountDialog$lambda$6(NTPhoneSmsLoginMainline.b.this, dialogInterface);
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
            reportEvent("0X800C4B2", 0, valueOf, str, "", "");
            return;
        }
        QLog.e(TAG, 1, "activity == null || activity.isFinishing()");
        listener.onCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMultiAccountDialog$lambda$6(NTPhoneSmsLoginMainline.b listener, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onCancel();
    }

    private final void showToast(final String msg2) {
        if (TextUtils.isEmpty(msg2)) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.m
            @Override // java.lang.Runnable
            public final void run() {
                NTPhonePasswordLoginMainline.showToast$lambda$7(msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$7(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(BaseApplication.getContext(), 1, msg2, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startLoginByCoroutine(PwdLoginInfo pwdLoginInfo, boolean loginByToken) {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new NTPhonePasswordLoginMainline$startLoginByCoroutine$1(this, pwdLoginInfo, loginByToken, null), 14, null);
        }
    }

    @Nullable
    public final String getParameterValue(@NotNull String urlString, @NotNull String parameterName) {
        List split$default;
        List split$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) urlString, (Object) parameterName);
        }
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        String query = new URL(urlString).getQuery();
        Intrinsics.checkNotNullExpressionValue(query, "query");
        split$default = StringsKt__StringsKt.split$default((CharSequence) query, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
            if (split$default2.size() == 2 && Intrinsics.areEqual(split$default2.get(0), parameterName)) {
                return (String) split$default2.get(1);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTBaseLoginMainline
    protected boolean needCreateNewRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        T t16 = this.mLoginParams;
        if (!((ay) t16).f242202c && !((ay) t16).f242203d) {
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
        this.bindAccountList = null;
        reportEvent("0X800C388", 2, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getLoginEndReportInfo(), "");
        QLog.i(TAG, 1, "onLoginCancel");
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.o
            @Override // java.lang.Runnable
            public final void run() {
                NTPhonePasswordLoginMainline.onLoginCancel$lambda$4(NTPhonePasswordLoginMainline.this);
            }
        });
        QuestionnaireForLoginManager.e();
        QuestionnaireForLoginManager.d(8);
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
        this.bindAccountList = null;
        if (!checkBeforeLoginSuccess(uin, bundle)) {
            return;
        }
        reportEvent("0X800C388", 0, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getLoginEndReportInfo(), "");
        QLog.i(TAG, 1, "onLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(uin));
        LoginAccountInfoApiImpl.Companion companion = LoginAccountInfoApiImpl.INSTANCE;
        String str = ((ay) this.mLoginParams).f241929f;
        Intrinsics.checkNotNullExpressionValue(str, "mLoginParams.phoneNum");
        companion.b(str, uin, nick);
        ah ahVar = ah.f242228a;
        String str2 = ((ay) this.mLoginParams).f241929f;
        Intrinsics.checkNotNullExpressionValue(str2, "mLoginParams.phoneNum");
        ahVar.c(str2);
        com.tencent.mobileqq.login.account.d dVar = com.tencent.mobileqq.login.account.d.f241848a;
        T t16 = this.mLoginParams;
        dVar.b(uin, Marker.ANY_NON_NULL_MARKER + ((ay) t16).f241930g + " " + ((ay) t16).f241929f, 7);
        if (!TextUtils.isEmpty(uin)) {
            MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + uin, ((ay) this.mLoginParams).f241929f);
        }
        ((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).reportLoginSuccess(getAppRuntime(), Integer.valueOf(((ay) this.mLoginParams).f242201b), ((ay) this.mLoginParams).f241929f);
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.j
            @Override // java.lang.Runnable
            public final void run() {
                NTPhonePasswordLoginMainline.onNTLoginSuccess$lambda$3(NTPhonePasswordLoginMainline.this);
            }
        });
        bundle.putString("last_account", uin);
        bundle.putBoolean("fromLoginPhoneNum", true);
        super.onNTLoginSuccess(uin, nick, bundle);
    }

    @Override // com.tencent.mobileqq.login.k
    protected void startLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "startLogin phoneNum: " + ((ay) this.mLoginParams).f241929f);
        this.mHasPuzzleVerify = false;
        this.mHasMultiAccountShown = false;
        this.mAccountInfoListSize = 0;
        this.mHasDevLockVerify = false;
        reportEvent("0X800C382", 0, "", "", "", "");
        startLoginByCoroutine(getLoginInfo(), false);
    }
}
