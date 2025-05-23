package com.tencent.mobileqq.login.ntlogin.mainline;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.login.account.impl.LoginAccountInfoApiImpl;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.bl;
import com.tencent.mobileqq.login.ntlogin.NTDevLockVerifyComponent;
import com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.login.verify.PuzzleVerifyComponent;
import com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi;
import com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent;
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
import com.tencent.qqnt.kernel.nativeinterface.GetSmsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.ILoginCallback;
import com.tencent.qqnt.kernel.nativeinterface.Iframe;
import com.tencent.qqnt.kernel.nativeinterface.LoginProcessReqBody;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import com.tencent.qqnt.kernel.nativeinterface.LoginRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.OptimusLoginInfo;
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
import kotlin.coroutines.jvm.internal.Boxing;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\n\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002]^B\u0007\u00a2\u0006\u0004\bZ\u0010[J\u0013\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J3\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0019\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020 H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0016\u001a\u00020 H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\"J!\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010%\u001a\u00020$H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'J!\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010(\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020\u0003H\u0002J0\u00108\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0002J\n\u00109\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010:\u001a\u00020\u000bH\u0002J\b\u0010;\u001a\u00020\u0003H\u0014J\"\u0010?\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\u0006\u0010>\u001a\u00020\rH\u0014J\b\u0010@\u001a\u00020\u0003H\u0014J\b\u0010B\u001a\u00020AH\u0014J\u0018\u0010E\u001a\u0004\u0018\u00010\u000b2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u000bR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010GR \u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010J\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010M\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010GR\u0016\u0010R\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010GR\u0018\u0010S\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001e\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline;", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTBaseLoginMainline;", "Lcom/tencent/mobileqq/login/bl;", "", "requestLoginByCoroutine", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "smsVerifyResult", "handleMultiAccount", "", TangramHippyConstants.LOGIN_TYPE, "", "verifyUrl", "Landroid/os/Bundle;", "passThroughParams", "Lcom/tencent/mobileqq/login/ntlogin/mainline/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/VerifySuccessSign;", "requestPuzzleVerify", "(ILjava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/mobileqq/bean/AccountInfo;", "accountInfoList", "loginInfo", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$b;", "listener", "showMultiAccountDialog", "msg", UIJsPlugin.EVENT_SHOW_TOAST, "Lcom/tencent/qqnt/kernel/nativeinterface/GetSmsReqBody;", "getSmsReq", "requestSendSms", "(Lcom/tencent/qqnt/kernel/nativeinterface/GetSmsReqBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/OptimusLoginInfo;", "requestLoginByToken", "(Lcom/tencent/qqnt/kernel/nativeinterface/OptimusLoginInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestMaskLogin", "", "loginContext", "requestSmsVerify", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginResult", "newDevVerify", "(Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/UinInfo;", "uinInfo", "handleRemindLogin", "reLogin", "Lcom/tencent/qqnt/kernel/nativeinterface/UserInfo;", "getUserInfo", "onNtLoginFailed", "dismissMultiAccountDialog", "tValue", "result", "r2", "r3", "r4", "reportEvent", "getDevLockReportInfo", "getLoginEndReportInfo", "startLogin", "uin", "nick", "bundle", "onNTLoginSuccess", "onLoginCancel", "", "needCreateNewRuntime", "urlString", "parameterName", "getParameterValue", "mHasPuzzleVerify", "Z", "mHasMultiAccountShown", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/widget/bm;", "mMultiAccountDialogRef", "Lmqq/util/WeakReference;", "mAccountInfo", "Lcom/tencent/mobileqq/bean/AccountInfo;", "mAccountInfoListSize", "I", "mHasDevLockVerify", "mHasShowMultiAccountDialog", "mSendMsgCookie", "[B", "", "bindAccountList", "Ljava/util/List;", "mSelectAccountListener", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$b;", "<init>", "()V", "Companion", "a", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NTPhoneSmsLoginMainline extends NTBaseLoginMainline<bl> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "NTLoginMainline_PhoneSmsLogin";

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
    private final b mSelectAccountListener;

    @Nullable
    private byte[] mSendMsgCookie;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$b;", "", "Lcom/tencent/mobileqq/bean/AccountInfo;", "accountInfo", "", "loginContext", "", "accountInfoListSize", "", "autoSelect", "", "a", "onCancel", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void a(@NotNull AccountInfo accountInfo, @Nullable byte[] loginContext, int accountInfoListSize, boolean autoSelect);

        void onCancel();
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$c", "Lcom/tencent/mobileqq/login/remind/h$b;", "", "a", "b", "", "url", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements h.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ UinInfo f242290b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LoginResult f242291c;

        c(UinInfo uinInfo, LoginResult loginResult) {
            this.f242290b = uinInfo;
            this.f242291c = loginResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTPhoneSmsLoginMainline.this, uinInfo, loginResult);
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                NTPhoneSmsLoginMainline.this.onLoginCancel();
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                NTPhoneSmsLoginMainline.this.reLogin(this.f242290b, this.f242291c);
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
            QLog.d(NTPhoneSmsLoginMainline.TAG, 1, "onJumpUrl :" + url);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "loginResultInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class d implements ILoginCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f242293b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<LoginResult>> f242294c;

        d(long j3, CancellableContinuation<? super i<LoginResult>> cancellableContinuation) {
            this.f242293b = j3;
            this.f242294c = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTPhoneSmsLoginMainline.this, Long.valueOf(j3), cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginCallback
        public final void onResult(int i3, String str, LoginResult loginResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NTPhoneSmsLoginMainline.this.reportEvent("0X800C307", i3, String.valueOf(System.currentTimeMillis() - this.f242293b), "", "");
                CancellableContinuation<i<LoginResult>> cancellableContinuation = this.f242294c;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(new i(i3, str, loginResult)));
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, loginResult);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$e", "Lcom/tencent/mobileqq/login/verify/PuzzleVerifyComponent$b;", "", "result", "", "ticket", "randStr", "appId", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements PuzzleVerifyComponent.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f242296b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f242297c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<VerifySuccessSign>> f242298d;

        e(long j3, String str, CancellableContinuation<? super i<VerifySuccessSign>> cancellableContinuation) {
            this.f242296b = j3;
            this.f242297c = str;
            this.f242298d = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTPhoneSmsLoginMainline.this, Long.valueOf(j3), str, cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(NTPhoneSmsLoginMainline.TAG, 1, "PuzzleVerify cancel");
            NTPhoneSmsLoginMainline.this.reportEvent("0X800C302", 2, String.valueOf(System.currentTimeMillis() - this.f242296b), "", "");
            CancellableContinuation<i<VerifySuccessSign>> cancellableContinuation = this.f242298d;
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
            QLog.d(NTPhoneSmsLoginMainline.TAG, 1, "PuzzleVerify result=" + result);
            NTPhoneSmsLoginMainline.this.reportEvent("0X800C302", 0, String.valueOf(System.currentTimeMillis() - this.f242296b), "", "");
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
            String parameterValue = NTPhoneSmsLoginMainline.this.getParameterValue(this.f242297c, "sid");
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
            CancellableContinuation<i<VerifySuccessSign>> cancellableContinuation = this.f242298d;
            i iVar = new i(0, null, verifySuccessSign);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "new puzzle verifysafeResume call failed ");
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$f", "Lcom/tencent/qqnt/kernel/nativeinterface/ILoginCallback;", "", "result", "", "errorMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "loginResultInfo", "", "onResult", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class f implements ILoginCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f242300b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<LoginResult>> f242301c;

        f(long j3, CancellableContinuation<? super i<LoginResult>> cancellableContinuation) {
            this.f242300b = j3;
            this.f242301c = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTPhoneSmsLoginMainline.this, Long.valueOf(j3), cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginCallback
        public void onResult(int result, @Nullable String errorMsg, @Nullable LoginResult loginResultInfo) {
            Integer num;
            LoginRspInfo loginRspInfo;
            LoginRspInfo loginRspInfo2;
            LoginRspInfo loginRspInfo3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errorMsg, loginResultInfo);
                return;
            }
            Integer num2 = null;
            if (loginResultInfo != null && (loginRspInfo3 = loginResultInfo.rspInfo) != null) {
                num = Integer.valueOf(loginRspInfo3.errCode);
            } else {
                num = null;
            }
            QLog.d(NTPhoneSmsLoginMainline.TAG, 1, "onResult result: " + num);
            NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline = NTPhoneSmsLoginMainline.this;
            if (loginResultInfo != null && (loginRspInfo2 = loginResultInfo.rspInfo) != null && loginRspInfo2.errCode == 0) {
                i3 = 1;
            }
            int i16 = i3 ^ 1;
            String valueOf = String.valueOf(System.currentTimeMillis() - this.f242300b);
            if (loginResultInfo != null && (loginRspInfo = loginResultInfo.rspInfo) != null) {
                num2 = Integer.valueOf(loginRspInfo.errCode);
            }
            nTPhoneSmsLoginMainline.reportEvent("0X800C303", i16, valueOf, "", String.valueOf(num2));
            CancellableContinuation<i<LoginResult>> cancellableContinuation = this.f242301c;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new i(result, errorMsg, loginResultInfo)));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$g", "Lcom/tencent/mobileqq/widget/bm$c;", "", "account", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class g implements bm.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f242302a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoginResult f242303b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<AccountInfo> f242304c;

        /* JADX WARN: Multi-variable type inference failed */
        g(b bVar, LoginResult loginResult, List<? extends AccountInfo> list) {
            this.f242302a = bVar;
            this.f242303b = loginResult;
            this.f242304c = list;
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
                this.f242302a.a((AccountInfo) account, this.f242303b.rspInfo.loginContext, this.f242304c.size(), false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22013);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTPhoneSmsLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSelectAccountListener = new b() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline$mSelectAccountListener$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTPhoneSmsLoginMainline.this);
                    }
                }

                @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline.b
                public void a(@NotNull AccountInfo accountInfo, @Nullable byte[] loginContext, int accountInfoListSize, boolean autoSelect) {
                    String str;
                    boolean z16;
                    String str2;
                    List<AccountInfo> list;
                    UserInfo userInfo;
                    AccountInfo accountInfo2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, accountInfo, loginContext, Integer.valueOf(accountInfoListSize), Boolean.valueOf(autoSelect));
                        return;
                    }
                    Intrinsics.checkNotNullParameter(accountInfo, "accountInfo");
                    QLog.d("NTLoginMainline_PhoneSmsLogin", 1, "selectAccountFromList onSelectAccount uin=" + accountInfo.getMaskUin());
                    NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline = NTPhoneSmsLoginMainline.this;
                    String valueOf = String.valueOf(accountInfoListSize);
                    if (autoSelect) {
                        str = "2";
                    } else {
                        str = "1";
                    }
                    z16 = NTPhoneSmsLoginMainline.this.mHasPuzzleVerify;
                    if (!z16) {
                        str2 = "2";
                    } else {
                        str2 = "1";
                    }
                    nTPhoneSmsLoginMainline.reportEvent("0X800C4B9", 0, valueOf, str, str2);
                    NTPhoneSmsLoginMainline.this.mAccountInfo = accountInfo;
                    list = NTPhoneSmsLoginMainline.this.bindAccountList;
                    if (list != null) {
                        NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline2 = NTPhoneSmsLoginMainline.this;
                        for (AccountInfo accountInfo3 : list) {
                            if (TextUtils.equals(accountInfo3.getMaskUin(), accountInfo.getMaskUin()) && TextUtils.equals(accountInfo3.getMaskNick(), accountInfo.getMaskNick())) {
                                nTPhoneSmsLoginMainline2.mAccountInfo = accountInfo3;
                            }
                        }
                    }
                    NTPhoneSmsLoginMainline.this.mAccountInfoListSize = accountInfoListSize;
                    userInfo = NTPhoneSmsLoginMainline.this.getUserInfo();
                    OptimusLoginInfo optimusLoginInfo = new OptimusLoginInfo();
                    optimusLoginInfo.userInfo = userInfo;
                    optimusLoginInfo.loginContext = loginContext;
                    accountInfo2 = NTPhoneSmsLoginMainline.this.mAccountInfo;
                    Intrinsics.checkNotNull(accountInfo2);
                    optimusLoginInfo.uinInfo = accountInfo2.getNtUinInfo();
                    optimusLoginInfo.appInfo = NTPhoneSmsLoginMainline.this.getAppInfo();
                    NTPhoneSmsLoginMainline.this.showLoading();
                    CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
                    if (f16 != null) {
                        CorountineFunKt.e(f16, "NTLoginMainline_PhoneSmsLogin", null, null, null, new NTPhoneSmsLoginMainline$mSelectAccountListener$1$onSelectAccount$2(NTPhoneSmsLoginMainline.this, optimusLoginInfo, null), 14, null);
                    }
                }

                @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline.b
                public void onCancel() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                    } else {
                        QLog.d("NTLoginMainline_PhoneSmsLogin", 1, "selectAccountFromList onCancel");
                        NTPhoneSmsLoginMainline.this.onLoginCancel();
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

    private final String getDevLockReportInfo() {
        boolean z16 = this.mHasPuzzleVerify;
        if (z16 && this.mHasShowMultiAccountDialog) {
            return "1";
        }
        if (z16) {
            return "2";
        }
        if (this.mHasShowMultiAccountDialog) {
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
    public final UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        T t16 = this.mLoginParams;
        userInfo.account = ((bl) t16).f241978g;
        userInfo.accountType = AccountType.ACCOUNTTYPE_PHONENUM;
        String str = ((bl) t16).f241977f;
        Intrinsics.checkNotNullExpressionValue(str, "mLoginParams.countryCode");
        userInfo.countryCode = Integer.parseInt(str);
        return userInfo;
    }

    private final void handleMultiAccount(final LoginResult smsVerifyResult) {
        BindUinInfo bindUinInfo;
        int i3;
        String str;
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
            QLog.d(TAG, 1, "onGetSaltUinList accountInfoListSize=" + size);
            T t16 = this.mLoginParams;
            AccountInfo d17 = z.d(arrayList, Marker.ANY_NON_NULL_MARKER + ((bl) t16).f241977f + " " + ((bl) t16).f241978g, ((bl) this.mLoginParams).f241979h);
            if (d17 != null) {
                QLog.i(TAG, 1, "startMultiAccountLogin auto select selectedAccountInfo uin " + StringUtil.getSimpleUinForPrint(((bl) this.mLoginParams).f241979h));
                b bVar = this.mSelectAccountListener;
                LoginRspInfo loginRspInfo2 = smsVerifyResult.rspInfo;
                if (loginRspInfo2 != null) {
                    bArr = loginRspInfo2.loginContext;
                }
                bVar.a(d17, bArr, size, true);
                String valueOf = String.valueOf(size);
                if (this.mHasPuzzleVerify) {
                    str = "1";
                } else {
                    str = "2";
                }
                reportEvent("0X800C4B9", 0, valueOf, "2", str);
                return;
            }
            if (isLoginActivityInvalid()) {
                i3 = 1000;
            } else {
                i3 = 0;
            }
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.t
                @Override // java.lang.Runnable
                public final void run() {
                    NTPhoneSmsLoginMainline.handleMultiAccount$lambda$2(NTPhoneSmsLoginMainline.this, arrayList, smsVerifyResult);
                }
            }, i3);
        } catch (Exception e16) {
            onNtLoginFailed(smsVerifyResult);
            QLog.e(TAG, 1, "onGetSaltUinList failed" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMultiAccount$lambda$2(NTPhoneSmsLoginMainline this$0, List accountInfoList, LoginResult smsVerifyResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(accountInfoList, "$accountInfoList");
        Intrinsics.checkNotNullParameter(smsVerifyResult, "$smsVerifyResult");
        this$0.showMultiAccountDialog(accountInfoList, smsVerifyResult, this$0.mSelectAccountListener);
    }

    private final void handleRemindLogin(final UinInfo uinInfo, final LoginResult loginInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.q
            @Override // java.lang.Runnable
            public final void run() {
                NTPhoneSmsLoginMainline.handleRemindLogin$lambda$11(LoginResult.this, this, uinInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleRemindLogin$lambda$11(LoginResult loginInfo, NTPhoneSmsLoginMainline this$0, UinInfo uinInfo) {
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
        if (!mVar.e(qBaseActivity, loginInfo, str, new c(uinInfo, loginInfo))) {
            this$0.reLogin(uinInfo, loginInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object newDevVerify(LoginResult loginResult, Continuation<? super i<String>> continuation) {
        NTPhoneSmsLoginMainline$newDevVerify$1 nTPhoneSmsLoginMainline$newDevVerify$1;
        Object coroutine_suspended;
        int i3;
        NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline;
        long j3;
        String g16;
        if (continuation instanceof NTPhoneSmsLoginMainline$newDevVerify$1) {
            nTPhoneSmsLoginMainline$newDevVerify$1 = (NTPhoneSmsLoginMainline$newDevVerify$1) continuation;
            int i16 = nTPhoneSmsLoginMainline$newDevVerify$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTPhoneSmsLoginMainline$newDevVerify$1.label = i16 - Integer.MIN_VALUE;
                NTPhoneSmsLoginMainline$newDevVerify$1 nTPhoneSmsLoginMainline$newDevVerify$12 = nTPhoneSmsLoginMainline$newDevVerify$1;
                Object obj = nTPhoneSmsLoginMainline$newDevVerify$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTPhoneSmsLoginMainline$newDevVerify$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        j3 = nTPhoneSmsLoginMainline$newDevVerify$12.J$0;
                        NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline2 = (NTPhoneSmsLoginMainline) nTPhoneSmsLoginMainline$newDevVerify$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        nTPhoneSmsLoginMainline = nTPhoneSmsLoginMainline2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.d(TAG, 1, "requestLoginByCoroutine need new device verify!");
                    Bundle bundle = new Bundle();
                    bundle.putString("url", loginResult.rspInfo.jumpUrl);
                    bundle.putSerializable("key_mask_user_info", this.mAccountInfo);
                    if (((bl) this.mLoginParams).f242202c) {
                        bundle.putBoolean("isSubaccount", true);
                        bundle.putString("from_where", "subaccount");
                    }
                    T t16 = this.mLoginParams;
                    if (((bl) t16).f242203d) {
                        bundle.putString("appid", ((bl) t16).f241980i);
                        bundle.putString("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
                    }
                    bundle.putInt(TangramHippyConstants.LOGIN_TYPE, ((bl) this.mLoginParams).f242200a);
                    T t17 = this.mLoginParams;
                    if (((bl) t17).f242201b == 16 && ((bl) t17).f242204e && (g16 = com.tencent.mobileqq.accountbinding.d.f174609a.g()) != null) {
                        bundle.putString("wechat_login_bind_uin", g16);
                    }
                    QuestionnaireForLoginManager.g("new_device");
                    this.mHasDevLockVerify = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    String devLockReportInfo = getDevLockReportInfo();
                    Intrinsics.checkNotNull(devLockReportInfo);
                    reportEvent("0X800C378", 0, "", devLockReportInfo, "");
                    NTDevLockVerifyComponent nTDevLockVerifyComponent = new NTDevLockVerifyComponent();
                    int i17 = ((bl) this.mLoginParams).f242200a;
                    LoginRspInfo loginRspInfo = loginResult.rspInfo;
                    Intrinsics.checkNotNullExpressionValue(loginRspInfo, "loginResult.rspInfo");
                    nTPhoneSmsLoginMainline$newDevVerify$12.L$0 = this;
                    nTPhoneSmsLoginMainline$newDevVerify$12.J$0 = currentTimeMillis;
                    nTPhoneSmsLoginMainline$newDevVerify$12.label = 1;
                    obj = nTDevLockVerifyComponent.f(i17, "", loginRspInfo, bundle, nTPhoneSmsLoginMainline$newDevVerify$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTPhoneSmsLoginMainline = this;
                    j3 = currentTimeMillis;
                }
                i iVar = (i) obj;
                int c16 = iVar.c();
                String valueOf = String.valueOf(System.currentTimeMillis() - j3);
                String devLockReportInfo2 = nTPhoneSmsLoginMainline.getDevLockReportInfo();
                Intrinsics.checkNotNull(devLockReportInfo2);
                nTPhoneSmsLoginMainline.reportEvent("0X800C379", c16, valueOf, devLockReportInfo2, "");
                return iVar;
            }
        }
        nTPhoneSmsLoginMainline$newDevVerify$1 = new NTPhoneSmsLoginMainline$newDevVerify$1(this, continuation);
        NTPhoneSmsLoginMainline$newDevVerify$1 nTPhoneSmsLoginMainline$newDevVerify$122 = nTPhoneSmsLoginMainline$newDevVerify$1;
        Object obj2 = nTPhoneSmsLoginMainline$newDevVerify$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTPhoneSmsLoginMainline$newDevVerify$122.label;
        if (i3 == 0) {
        }
        i iVar2 = (i) obj2;
        int c162 = iVar2.c();
        String valueOf2 = String.valueOf(System.currentTimeMillis() - j3);
        String devLockReportInfo22 = nTPhoneSmsLoginMainline.getDevLockReportInfo();
        Intrinsics.checkNotNull(devLockReportInfo22);
        nTPhoneSmsLoginMainline.reportEvent("0X800C379", c162, valueOf2, devLockReportInfo22, "");
        return iVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNTLoginSuccess$lambda$3(NTPhoneSmsLoginMainline this$0) {
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
        if (uVar.N(qBaseActivity, (bl) mLoginParams, loginInfo)) {
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
        reportEvent("0X800C308", 1, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), String.valueOf(i3), getLoginEndReportInfo());
        QLog.i(TAG, 1, "onLoginFailed ret=" + i3 + " msg=" + ajVar.f241866c);
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.v
            @Override // java.lang.Runnable
            public final void run() {
                NTPhoneSmsLoginMainline.onNtLoginFailed$lambda$12(NTPhoneSmsLoginMainline.this);
            }
        });
        QuestionnaireForLoginManager.e();
        QuestionnaireForLoginManager.d(8);
        onLoginFailed(ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNtLoginFailed$lambda$12(NTPhoneSmsLoginMainline this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissMultiAccountDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reLogin(UinInfo uinInfo, LoginResult loginInfo) {
        LoginProcessReqBody loginProcessReqBody = new LoginProcessReqBody();
        loginProcessReqBody.needRemindCancellatedStatus = com.tencent.mobileqq.login.remind.n.f242580a.c(uinInfo.maskUin);
        OptimusLoginInfo optimusLoginInfo = new OptimusLoginInfo();
        optimusLoginInfo.loginProcessReq = loginProcessReqBody;
        optimusLoginInfo.userInfo = getUserInfo();
        optimusLoginInfo.uinInfo = uinInfo;
        optimusLoginInfo.appInfo = getAppInfo();
        optimusLoginInfo.loginContext = loginInfo.rspInfo.loginContext;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new NTPhoneSmsLoginMainline$reLogin$1(this, optimusLoginInfo, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportEvent(String tValue, int result, String r26, String r36, String r46) {
        T t16 = this.mLoginParams;
        as.b("phone_pwd_login_mainline", tValue, ((bl) t16).f241978g, ((bl) t16).f242201b, result, true, r26, r36, r46, ((bl) t16).f241977f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestLoginByCoroutine(Continuation<? super Unit> continuation) {
        NTPhoneSmsLoginMainline$requestLoginByCoroutine$1 nTPhoneSmsLoginMainline$requestLoginByCoroutine$1;
        Object coroutine_suspended;
        int i3;
        String str;
        int i16;
        NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline;
        GetSmsReqBody getSmsReqBody;
        NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline2;
        i iVar;
        LoginResult loginResult;
        int i17;
        i iVar2;
        GetSmsReqBody getSmsReqBody2;
        NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline3;
        LoginRspInfo loginRspInfo;
        i iVar3;
        LoginResult loginResult2;
        int i18;
        LoginRspInfo loginRspInfo2;
        i iVar4;
        Integer num;
        int i19;
        BindUinInfo bindUinInfo;
        int i26;
        BindUinInfo bindUinInfo2;
        ArrayList<UinInfo> arrayList;
        LoginRspInfo loginRspInfo3;
        if (continuation instanceof NTPhoneSmsLoginMainline$requestLoginByCoroutine$1) {
            nTPhoneSmsLoginMainline$requestLoginByCoroutine$1 = (NTPhoneSmsLoginMainline$requestLoginByCoroutine$1) continuation;
            int i27 = nTPhoneSmsLoginMainline$requestLoginByCoroutine$1.label;
            if ((i27 & Integer.MIN_VALUE) != 0) {
                nTPhoneSmsLoginMainline$requestLoginByCoroutine$1.label = i27 - Integer.MIN_VALUE;
                NTPhoneSmsLoginMainline$requestLoginByCoroutine$1 nTPhoneSmsLoginMainline$requestLoginByCoroutine$12 = nTPhoneSmsLoginMainline$requestLoginByCoroutine$1;
                Object obj = nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.label;
                String str2 = "1";
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
                                nTPhoneSmsLoginMainline2 = (NTPhoneSmsLoginMainline) nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$0;
                                ResultKt.throwOnFailure(obj);
                                i16 = 1;
                                iVar4 = (i) obj;
                                if (iVar4.c() != 0) {
                                    QLog.d(TAG, i16, "requestLoginByCoroutine sms verify canceled!");
                                    nTPhoneSmsLoginMainline2.onLoginCancel();
                                    return Unit.INSTANCE;
                                }
                                LoginResult loginResult3 = (LoginResult) iVar4.b();
                                if (loginResult3 != null && (loginRspInfo3 = loginResult3.rspInfo) != null) {
                                    num = Boxing.boxInt(loginRspInfo3.errCode);
                                } else {
                                    num = null;
                                }
                                if (num != null && num.intValue() == 0) {
                                    LoginRspInfo loginRspInfo4 = ((LoginResult) iVar4.b()).rspInfo;
                                    if (loginRspInfo4 != null && (bindUinInfo2 = loginRspInfo4.bindUinInfo) != null && (arrayList = bindUinInfo2.uinInfoList) != null && ((arrayList.isEmpty() ? 1 : 0) ^ i16) == i16) {
                                        i19 = i16;
                                    } else {
                                        i19 = 0;
                                    }
                                    if (i19 != 0) {
                                        ArrayList<UinInfo> arrayList2 = ((LoginResult) iVar4.b()).rspInfo.bindUinInfo.uinInfoList;
                                        if (arrayList2.size() == i16) {
                                            QLog.d(TAG, i16, "requestLoginByCoroutine  login the account!");
                                            if (!nTPhoneSmsLoginMainline2.mHasPuzzleVerify) {
                                                str2 = "2";
                                            }
                                            nTPhoneSmsLoginMainline2.reportEvent("0X800C4B9", 0, "1", "2", str2);
                                            LoginRspInfo loginRspInfo5 = ((LoginResult) iVar4.b()).rspInfo;
                                            if (loginRspInfo5 != null) {
                                                bindUinInfo = loginRspInfo5.bindUinInfo;
                                            } else {
                                                bindUinInfo = null;
                                            }
                                            List<AccountInfo> d16 = bk.d(bindUinInfo);
                                            if (d16 != null && ((d16.isEmpty() ? 1 : 0) ^ i16) == i16) {
                                                i26 = i16;
                                            } else {
                                                i26 = 0;
                                            }
                                            if (i26 != 0) {
                                                nTPhoneSmsLoginMainline2.mAccountInfo = d16.get(0);
                                            }
                                            UserInfo userInfo = nTPhoneSmsLoginMainline2.getUserInfo();
                                            OptimusLoginInfo optimusLoginInfo = new OptimusLoginInfo();
                                            optimusLoginInfo.userInfo = userInfo;
                                            optimusLoginInfo.appInfo = nTPhoneSmsLoginMainline2.getAppInfo();
                                            optimusLoginInfo.loginContext = ((LoginResult) iVar4.b()).rspInfo.loginContext;
                                            optimusLoginInfo.uinInfo = arrayList2.get(0);
                                            nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$0 = null;
                                            nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.label = 5;
                                            if (nTPhoneSmsLoginMainline2.requestLoginByToken(optimusLoginInfo, nTPhoneSmsLoginMainline$requestLoginByCoroutine$12) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        QLog.d(TAG, i16, "requestLoginByCoroutine login multi accounts!");
                                        nTPhoneSmsLoginMainline2.handleMultiAccount((LoginResult) iVar4.b());
                                        return Unit.INSTANCE;
                                    }
                                }
                                LoginResult loginResult4 = (LoginResult) iVar4.b();
                                if (loginResult4 != null) {
                                    nTPhoneSmsLoginMainline2.onNtLoginFailed(loginResult4);
                                }
                                return Unit.INSTANCE;
                            }
                            nTPhoneSmsLoginMainline3 = (NTPhoneSmsLoginMainline) nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            i16 = 1;
                            iVar = (i) obj;
                            nTPhoneSmsLoginMainline = nTPhoneSmsLoginMainline3;
                            if (iVar.c() == 0) {
                                LoginResult loginResult5 = (LoginResult) iVar.b();
                                if (loginResult5 != null && (loginRspInfo2 = loginResult5.rspInfo) != null && loginRspInfo2.errCode == 0) {
                                    i18 = i16;
                                } else {
                                    i18 = 0;
                                }
                                if (i18 != 0) {
                                    Object b16 = iVar.b();
                                    Intrinsics.checkNotNull(b16);
                                    byte[] bArr = ((LoginResult) b16).rspInfo.loginContext;
                                    nTPhoneSmsLoginMainline.mSendMsgCookie = bArr;
                                    if (bArr == null) {
                                        QLog.e(TAG, i16, "requestLoginByCoroutine cookie is null");
                                        aj ajVar = new aj();
                                        ajVar.f241864a = -1;
                                        nTPhoneSmsLoginMainline.onLoginFailed(ajVar);
                                        return Unit.INSTANCE;
                                    }
                                    nTPhoneSmsLoginMainline2 = nTPhoneSmsLoginMainline;
                                    byte[] bArr2 = nTPhoneSmsLoginMainline2.mSendMsgCookie;
                                    Intrinsics.checkNotNull(bArr2);
                                    nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$0 = nTPhoneSmsLoginMainline2;
                                    nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$1 = null;
                                    nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.label = 4;
                                    obj = nTPhoneSmsLoginMainline2.requestSmsVerify(bArr2, nTPhoneSmsLoginMainline$requestLoginByCoroutine$12);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    iVar4 = (i) obj;
                                    if (iVar4.c() != 0) {
                                    }
                                }
                            }
                            QLog.d(TAG, i16, "requestLoginByCoroutine send sms failed!");
                            loginResult2 = (LoginResult) iVar.b();
                            if (loginResult2 != null) {
                                nTPhoneSmsLoginMainline.onNtLoginFailed(loginResult2);
                            }
                            return Unit.INSTANCE;
                        }
                        i iVar5 = (i) nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$2;
                        GetSmsReqBody getSmsReqBody3 = (GetSmsReqBody) nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$1;
                        NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline4 = (NTPhoneSmsLoginMainline) nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        i16 = 1;
                        iVar2 = iVar5;
                        nTPhoneSmsLoginMainline3 = nTPhoneSmsLoginMainline4;
                        getSmsReqBody2 = getSmsReqBody3;
                        iVar3 = (i) obj;
                        if (iVar3.c() != 0) {
                            QLog.d(TAG, i16, "requestLoginByCoroutine new water verify success!!!");
                            getSmsReqBody2.verifySign = (VerifySuccessSign) iVar3.b();
                            Object b17 = iVar2.b();
                            Intrinsics.checkNotNull(b17);
                            getSmsReqBody2.loginContext = ((LoginResult) b17).rspInfo.loginContext;
                            nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$0 = nTPhoneSmsLoginMainline3;
                            nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$1 = null;
                            nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$2 = null;
                            nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.label = 3;
                            obj = nTPhoneSmsLoginMainline3.requestSendSms(getSmsReqBody2, nTPhoneSmsLoginMainline$requestLoginByCoroutine$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            iVar = (i) obj;
                            nTPhoneSmsLoginMainline = nTPhoneSmsLoginMainline3;
                            if (iVar.c() == 0) {
                            }
                            QLog.d(TAG, i16, "requestLoginByCoroutine send sms failed!");
                            loginResult2 = (LoginResult) iVar.b();
                            if (loginResult2 != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        QLog.d(TAG, i16, "requestLoginByCoroutine new water verify cancel");
                        nTPhoneSmsLoginMainline3.onLoginCancel();
                        return Unit.INSTANCE;
                    }
                    getSmsReqBody = (GetSmsReqBody) nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$1;
                    nTPhoneSmsLoginMainline = (NTPhoneSmsLoginMainline) nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    i16 = 1;
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.d(TAG, 1, "start login");
                    T t16 = this.mLoginParams;
                    boolean a16 = SmsVerifyComponent.a(2, ((bl) t16).f241977f, ((bl) t16).f241978g);
                    if (!a16) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    i16 = 1;
                    reportEvent("0X800C300", 0, str, "", "");
                    if (a16 && this.mSendMsgCookie != null) {
                        nTPhoneSmsLoginMainline2 = this;
                        byte[] bArr22 = nTPhoneSmsLoginMainline2.mSendMsgCookie;
                        Intrinsics.checkNotNull(bArr22);
                        nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$0 = nTPhoneSmsLoginMainline2;
                        nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$1 = null;
                        nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.label = 4;
                        obj = nTPhoneSmsLoginMainline2.requestSmsVerify(bArr22, nTPhoneSmsLoginMainline$requestLoginByCoroutine$12);
                        if (obj == coroutine_suspended) {
                        }
                        iVar4 = (i) obj;
                        if (iVar4.c() != 0) {
                        }
                    } else {
                        GetSmsReqBody getSmsReqBody4 = new GetSmsReqBody();
                        getSmsReqBody4.userInfo = getUserInfo();
                        getSmsReqBody4.appInfo = getAppInfo();
                        nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$0 = this;
                        nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$1 = getSmsReqBody4;
                        nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.label = 1;
                        Object requestSendSms = requestSendSms(getSmsReqBody4, nTPhoneSmsLoginMainline$requestLoginByCoroutine$12);
                        if (requestSendSms == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        nTPhoneSmsLoginMainline = this;
                        getSmsReqBody = getSmsReqBody4;
                        obj = requestSendSms;
                    }
                }
                iVar = (i) obj;
                loginResult = (LoginResult) iVar.b();
                if (loginResult == null && (loginRspInfo = loginResult.rspInfo) != null && loginRspInfo.errCode == 140022008) {
                    i17 = i16;
                } else {
                    i17 = 0;
                }
                if (i17 != 0) {
                    QLog.d(TAG, i16, "startLogin need new water wall verify!!!");
                    int i28 = ((bl) nTPhoneSmsLoginMainline.mLoginParams).f242200a;
                    Object b18 = iVar.b();
                    Intrinsics.checkNotNull(b18);
                    String jumpUrl = ((LoginResult) b18).rspInfo.getJumpUrl();
                    Intrinsics.checkNotNullExpressionValue(jumpUrl, "sendSmsResult.extraData!!.rspInfo.getJumpUrl()");
                    nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$0 = nTPhoneSmsLoginMainline;
                    nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$1 = getSmsReqBody;
                    nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.L$2 = iVar;
                    nTPhoneSmsLoginMainline$requestLoginByCoroutine$12.label = 2;
                    Object requestPuzzleVerify = nTPhoneSmsLoginMainline.requestPuzzleVerify(i28, jumpUrl, null, nTPhoneSmsLoginMainline$requestLoginByCoroutine$12);
                    if (requestPuzzleVerify == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline5 = nTPhoneSmsLoginMainline;
                    iVar2 = iVar;
                    obj = requestPuzzleVerify;
                    getSmsReqBody2 = getSmsReqBody;
                    nTPhoneSmsLoginMainline3 = nTPhoneSmsLoginMainline5;
                    iVar3 = (i) obj;
                    if (iVar3.c() != 0) {
                    }
                }
                if (iVar.c() == 0) {
                }
                QLog.d(TAG, i16, "requestLoginByCoroutine send sms failed!");
                loginResult2 = (LoginResult) iVar.b();
                if (loginResult2 != null) {
                }
                return Unit.INSTANCE;
            }
        }
        nTPhoneSmsLoginMainline$requestLoginByCoroutine$1 = new NTPhoneSmsLoginMainline$requestLoginByCoroutine$1(this, continuation);
        NTPhoneSmsLoginMainline$requestLoginByCoroutine$1 nTPhoneSmsLoginMainline$requestLoginByCoroutine$122 = nTPhoneSmsLoginMainline$requestLoginByCoroutine$1;
        Object obj2 = nTPhoneSmsLoginMainline$requestLoginByCoroutine$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTPhoneSmsLoginMainline$requestLoginByCoroutine$122.label;
        String str22 = "1";
        if (i3 == 0) {
        }
        iVar = (i) obj2;
        loginResult = (LoginResult) iVar.b();
        if (loginResult == null) {
        }
        i17 = 0;
        if (i17 != 0) {
        }
        if (iVar.c() == 0) {
        }
        QLog.d(TAG, i16, "requestLoginByCoroutine send sms failed!");
        loginResult2 = (LoginResult) iVar.b();
        if (loginResult2 != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestLoginByToken(OptimusLoginInfo optimusLoginInfo, Continuation<? super Unit> continuation) {
        NTPhoneSmsLoginMainline$requestLoginByToken$1 nTPhoneSmsLoginMainline$requestLoginByToken$1;
        Object coroutine_suspended;
        int i3;
        NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline;
        i iVar;
        NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline2;
        i iVar2;
        OptimusLoginInfo optimusLoginInfo2;
        i iVar3;
        NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline3;
        i iVar4;
        byte[] bArr;
        byte[] bArr2;
        UserProfile userProfile;
        if (continuation instanceof NTPhoneSmsLoginMainline$requestLoginByToken$1) {
            nTPhoneSmsLoginMainline$requestLoginByToken$1 = (NTPhoneSmsLoginMainline$requestLoginByToken$1) continuation;
            int i16 = nTPhoneSmsLoginMainline$requestLoginByToken$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTPhoneSmsLoginMainline$requestLoginByToken$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTPhoneSmsLoginMainline$requestLoginByToken$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTPhoneSmsLoginMainline$requestLoginByToken$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    iVar2 = (i) nTPhoneSmsLoginMainline$requestLoginByToken$1.L$1;
                                    nTPhoneSmsLoginMainline2 = (NTPhoneSmsLoginMainline) nTPhoneSmsLoginMainline$requestLoginByToken$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    if (((i) obj).c() != 0) {
                                        String valueOf = String.valueOf(((LoginResult) iVar2.b()).getAccount().getUin());
                                        byte[] nick = ((LoginResult) iVar2.b()).getAccount().getUserProfile().getNickName();
                                        Bundle bundle = new Bundle();
                                        Account account = ((LoginResult) iVar2.b()).account;
                                        boolean z16 = false;
                                        if (account != null && (userProfile = account.userProfile) != null && userProfile.registerWithoutPwd) {
                                            z16 = true;
                                        }
                                        if (z16) {
                                            bundle.putBoolean("without_pwd", true);
                                        }
                                        Intrinsics.checkNotNullExpressionValue(nick, "nick");
                                        nTPhoneSmsLoginMainline2.onNTLoginSuccess(valueOf, new String(nick, Charsets.UTF_8), bundle);
                                    } else {
                                        QLog.d(TAG, 1, "requestLoginByCoroutine commit ticket failed!");
                                        nTPhoneSmsLoginMainline2.onNtLoginFailed((LoginResult) iVar2.b());
                                    }
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        iVar3 = (i) nTPhoneSmsLoginMainline$requestLoginByToken$1.L$2;
                        optimusLoginInfo2 = (OptimusLoginInfo) nTPhoneSmsLoginMainline$requestLoginByToken$1.L$1;
                        nTPhoneSmsLoginMainline3 = (NTPhoneSmsLoginMainline) nTPhoneSmsLoginMainline$requestLoginByToken$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        iVar4 = (i) obj;
                        if (iVar4.c() != 0) {
                            QLog.d(TAG, 1, "requestLoginByCoroutine new device verify success!");
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
                            optimusLoginInfo2.verifySign = verifySuccessSign;
                            LoginRspInfo loginRspInfo = ((LoginResult) iVar3.b()).rspInfo;
                            if (loginRspInfo != null) {
                                bArr2 = loginRspInfo.loginContext;
                            } else {
                                bArr2 = null;
                            }
                            optimusLoginInfo2.loginContext = bArr2;
                            nTPhoneSmsLoginMainline$requestLoginByToken$1.L$0 = null;
                            nTPhoneSmsLoginMainline$requestLoginByToken$1.L$1 = null;
                            nTPhoneSmsLoginMainline$requestLoginByToken$1.L$2 = null;
                            nTPhoneSmsLoginMainline$requestLoginByToken$1.label = 3;
                            if (nTPhoneSmsLoginMainline3.requestLoginByToken(optimusLoginInfo2, nTPhoneSmsLoginMainline$requestLoginByToken$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            QLog.d(TAG, 1, "requestLoginByCoroutine new dev verify cancel!");
                            nTPhoneSmsLoginMainline3.onLoginCancel();
                        }
                        return Unit.INSTANCE;
                    }
                    optimusLoginInfo = (OptimusLoginInfo) nTPhoneSmsLoginMainline$requestLoginByToken$1.L$1;
                    nTPhoneSmsLoginMainline = (NTPhoneSmsLoginMainline) nTPhoneSmsLoginMainline$requestLoginByToken$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    showLoading();
                    nTPhoneSmsLoginMainline$requestLoginByToken$1.L$0 = this;
                    nTPhoneSmsLoginMainline$requestLoginByToken$1.L$1 = optimusLoginInfo;
                    nTPhoneSmsLoginMainline$requestLoginByToken$1.label = 1;
                    obj = requestMaskLogin(optimusLoginInfo, nTPhoneSmsLoginMainline$requestLoginByToken$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTPhoneSmsLoginMainline = this;
                }
                iVar = (i) obj;
                if (iVar.c() == 0) {
                    QLog.e(TAG, 1, "requestLoginByCoroutine login failed error: " + iVar.c());
                    Object b16 = iVar.b();
                    Intrinsics.checkNotNull(b16);
                    nTPhoneSmsLoginMainline.onNtLoginFailed((LoginResult) b16);
                    return Unit.INSTANCE;
                }
                Object b17 = iVar.b();
                Intrinsics.checkNotNull(b17);
                int i17 = ((LoginResult) b17).rspInfo.errCode;
                if (i17 == 140022010) {
                    LoginResult loginResult = (LoginResult) iVar.b();
                    nTPhoneSmsLoginMainline$requestLoginByToken$1.L$0 = nTPhoneSmsLoginMainline;
                    nTPhoneSmsLoginMainline$requestLoginByToken$1.L$1 = optimusLoginInfo;
                    nTPhoneSmsLoginMainline$requestLoginByToken$1.L$2 = iVar;
                    nTPhoneSmsLoginMainline$requestLoginByToken$1.label = 2;
                    Object newDevVerify = nTPhoneSmsLoginMainline.newDevVerify(loginResult, nTPhoneSmsLoginMainline$requestLoginByToken$1);
                    if (newDevVerify == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline4 = nTPhoneSmsLoginMainline;
                    optimusLoginInfo2 = optimusLoginInfo;
                    iVar3 = iVar;
                    obj = newDevVerify;
                    nTPhoneSmsLoginMainline3 = nTPhoneSmsLoginMainline4;
                    iVar4 = (i) obj;
                    if (iVar4.c() != 0) {
                    }
                    return Unit.INSTANCE;
                }
                if (i17 == 150022028) {
                    UinInfo uinInfo = optimusLoginInfo.uinInfo;
                    Intrinsics.checkNotNullExpressionValue(uinInfo, "loginInfo.uinInfo");
                    nTPhoneSmsLoginMainline.handleRemindLogin(uinInfo, (LoginResult) iVar.b());
                    return Unit.INSTANCE;
                }
                if (i17 == 0) {
                    QLog.d(TAG, 1, "requestLoginByCoroutine login success");
                    LoginResult loginResult2 = (LoginResult) iVar.b();
                    nTPhoneSmsLoginMainline$requestLoginByToken$1.L$0 = nTPhoneSmsLoginMainline;
                    nTPhoneSmsLoginMainline$requestLoginByToken$1.L$1 = iVar;
                    nTPhoneSmsLoginMainline$requestLoginByToken$1.label = 4;
                    Object commitMsfTicket = nTPhoneSmsLoginMainline.commitMsfTicket(loginResult2, nTPhoneSmsLoginMainline$requestLoginByToken$1);
                    if (commitMsfTicket == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTPhoneSmsLoginMainline2 = nTPhoneSmsLoginMainline;
                    obj = commitMsfTicket;
                    iVar2 = iVar;
                    if (((i) obj).c() != 0) {
                    }
                    return Unit.INSTANCE;
                }
                nTPhoneSmsLoginMainline.onNtLoginFailed((LoginResult) iVar.b());
                return Unit.INSTANCE;
            }
        }
        nTPhoneSmsLoginMainline$requestLoginByToken$1 = new NTPhoneSmsLoginMainline$requestLoginByToken$1(this, continuation);
        Object obj2 = nTPhoneSmsLoginMainline$requestLoginByToken$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTPhoneSmsLoginMainline$requestLoginByToken$1.label;
        if (i3 == 0) {
        }
        iVar = (i) obj2;
        if (iVar.c() == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestMaskLogin(OptimusLoginInfo optimusLoginInfo, Continuation<? super i<LoginResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "requestNTLogin phone: " + optimusLoginInfo.userInfo.account);
        long currentTimeMillis = System.currentTimeMillis();
        reportEvent("0X800C306", 0, "", "", "");
        ((ILoginService) QRoute.api(ILoginService.class)).optimusLogin(optimusLoginInfo, new d(currentTimeMillis, cancellableContinuationImpl));
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
        long currentTimeMillis = System.currentTimeMillis();
        reportEvent("0X800C301", 0, "", "", "");
        QLog.d(TAG, 1, "startPuzzleVerify url: " + str);
        new PuzzleVerifyComponent().d(i3, str, new e(currentTimeMillis, str, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestSendSms(GetSmsReqBody getSmsReqBody, Continuation<? super i<LoginResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "requestSendSms ");
        ((ILoginService) QRoute.api(ILoginService.class)).getSms(getSmsReqBody, new f(System.currentTimeMillis(), cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestSmsVerify(byte[] bArr, Continuation<? super i<LoginResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "requestSmsVerify");
        final long currentTimeMillis = System.currentTimeMillis();
        reportEvent("0X800C304", 0, "", "", "");
        final Bundle bundle = new Bundle();
        bundle.putString(AppConstants.Key.PHONENUM, ((bl) this.mLoginParams).f241978g);
        bundle.putString("key", ((bl) this.mLoginParams).f241977f);
        bundle.putByteArray("sendSmsCookies", bArr);
        bundle.putBoolean("is_open_sdk_add_account", ((bl) this.mLoginParams).f242203d);
        bundle.putInt("phoneNumLoginEntrance", ((bl) this.mLoginParams).f242201b);
        bundle.putString("appid", ((bl) this.mLoginParams).f241980i);
        ThreadManager.getUIHandler().post(new Runnable(bundle, currentTimeMillis, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.login.ntlogin.mainline.NTPhoneSmsLoginMainline$requestSmsVerify$2$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f242306d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f242307e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<i<LoginResult>> f242308f;

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTPhoneSmsLoginMainline$requestSmsVerify$2$1$a", "Lcom/tencent/mobileqq/loginregister/sms/SmsVerifyComponent$d;", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "loginResult", "", "b", "Landroid/os/Bundle;", "data", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes15.dex */
            public static final class a implements SmsVerifyComponent.d {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ NTPhoneSmsLoginMainline f242309a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ long f242310b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ CancellableContinuation<i<LoginResult>> f242311c;

                a(NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline, long j3, CancellableContinuation<? super i<LoginResult>> cancellableContinuation) {
                    this.f242309a = nTPhoneSmsLoginMainline;
                    this.f242310b = j3;
                    this.f242311c = cancellableContinuation;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, nTPhoneSmsLoginMainline, Long.valueOf(j3), cancellableContinuation);
                    }
                }

                @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.d
                public void a(@Nullable Bundle data) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
                        return;
                    }
                    QLog.d("NTLoginMainline_PhoneSmsLogin", 1, "requestSmsVerify onCancel ");
                    this.f242309a.reportEvent("0X800C305", 2, String.valueOf(System.currentTimeMillis() - this.f242310b), "", "");
                    CancellableContinuation<i<LoginResult>> cancellableContinuation = this.f242311c;
                    i iVar = new i(-1, "smsVerify verify cancel", null);
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                        return;
                    }
                    QLog.e("NTLogin", 1, "smsVerify verify cancelsafeResume call failed ");
                }

                @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.d
                public void b(@NotNull LoginResult loginResult) {
                    boolean z16;
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginResult);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(loginResult, "loginResult");
                    QLog.d("NTLoginMainline_PhoneSmsLogin", 1, "requestSmsVerify onSuccess");
                    NTPhoneSmsLoginMainline nTPhoneSmsLoginMainline = this.f242309a;
                    String valueOf = String.valueOf(System.currentTimeMillis() - this.f242310b);
                    z16 = this.f242309a.mHasPuzzleVerify;
                    if (z16) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    nTPhoneSmsLoginMainline.reportEvent("0X800C305", 0, valueOf, str, "");
                    CancellableContinuation<i<LoginResult>> cancellableContinuation = this.f242311c;
                    Result.Companion companion = Result.INSTANCE;
                    LoginRspInfo loginRspInfo = loginResult.rspInfo;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new i(loginRspInfo.errCode, loginRspInfo.errMsg, loginResult)));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f242306d = bundle;
                this.f242307e = currentTimeMillis;
                this.f242308f = cancellableContinuationImpl;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, NTPhoneSmsLoginMainline.this, bundle, Long.valueOf(currentTimeMillis), cancellableContinuationImpl);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    SmsVerifyComponent.d(((bl) ((com.tencent.mobileqq.login.k) NTPhoneSmsLoginMainline.this).mLoginParams).f241978g, ((bl) ((com.tencent.mobileqq.login.k) NTPhoneSmsLoginMainline.this).mLoginParams).f241977f, this.f242306d, new a(NTPhoneSmsLoginMainline.this, this.f242307e, this.f242308f));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void showMultiAccountDialog(List<? extends AccountInfo> accountInfoList, LoginResult loginInfo, final b listener) {
        String str;
        QLog.d(TAG, 1, "showMultiAccountDialog");
        QBaseActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            this.mHasShowMultiAccountDialog = true;
            bm b16 = bk.b(activity, accountInfoList, loginInfo.rspInfo.bindUinInfo.unbindWording, new g(listener, loginInfo, accountInfoList), new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.r
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    NTPhoneSmsLoginMainline.showMultiAccountDialog$lambda$5(NTPhoneSmsLoginMainline.b.this, dialogInterface);
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
            reportEvent("0X800C4B8", 0, valueOf, str, "");
            return;
        }
        QLog.e(TAG, 1, "activity == null || activity.isFinishing()");
        listener.onCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMultiAccountDialog$lambda$5(b listener, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onCancel();
    }

    private final void showToast(final String msg2) {
        if (TextUtils.isEmpty(msg2)) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.s
            @Override // java.lang.Runnable
            public final void run() {
                NTPhoneSmsLoginMainline.showToast$lambda$6(msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$6(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(BaseApplication.getContext(), 1, msg2, 0).show();
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
        try {
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
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getParameterValue error : " + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTBaseLoginMainline
    protected boolean needCreateNewRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        T t16 = this.mLoginParams;
        if (!((bl) t16).f242202c && !((bl) t16).f242203d) {
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
        reportEvent("0X800C308", 2, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getLoginEndReportInfo());
        this.bindAccountList = null;
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
        this.bindAccountList = null;
        if (!checkBeforeLoginSuccess(uin, bundle)) {
            return;
        }
        reportEvent("0X800C308", 0, String.valueOf(System.currentTimeMillis() - this.mLoginStartTime), "", getLoginEndReportInfo());
        QLog.i(TAG, 1, "onNTLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(uin));
        LoginAccountInfoApiImpl.Companion companion = LoginAccountInfoApiImpl.INSTANCE;
        String str = ((bl) this.mLoginParams).f241978g;
        Intrinsics.checkNotNullExpressionValue(str, "mLoginParams.phoneNum");
        companion.b(str, uin, nick);
        com.tencent.mobileqq.login.account.d dVar = com.tencent.mobileqq.login.account.d.f241848a;
        T t16 = this.mLoginParams;
        dVar.b(uin, Marker.ANY_NON_NULL_MARKER + ((bl) t16).f241977f + " " + ((bl) t16).f241978g, 7);
        if (!TextUtils.isEmpty(uin)) {
            MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + uin, uin);
        }
        ((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).reportLoginSuccess(getAppRuntime(), Integer.valueOf(((bl) this.mLoginParams).f242201b), ((bl) this.mLoginParams).f241978g);
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.u
            @Override // java.lang.Runnable
            public final void run() {
                NTPhoneSmsLoginMainline.onNTLoginSuccess$lambda$3(NTPhoneSmsLoginMainline.this);
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
        QLog.d(TAG, 1, "startLogin phoneNum: " + ((bl) this.mLoginParams).f241978g);
        this.mHasPuzzleVerify = false;
        this.mHasMultiAccountShown = false;
        this.mAccountInfoListSize = 0;
        this.mHasDevLockVerify = false;
        this.mHasShowMultiAccountDialog = false;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new NTPhoneSmsLoginMainline$startLogin$1(this, null), 14, null);
        }
    }
}
