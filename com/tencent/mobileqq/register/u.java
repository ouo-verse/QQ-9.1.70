package com.tencent.mobileqq.register;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.RegisterNewBaseFragment;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.register.fragment.RegisterNickAndPwdFragment;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.BindInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetRegisterUinReq;
import com.tencent.qqnt.kernel.nativeinterface.GetRegisterUinRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetRegisterUinCallback;
import com.tencent.qqnt.kernel.nativeinterface.RegisterAccountInfo;
import java.io.UnsupportedEncodingException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 72\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u00104\u001a\u00020\u000e\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b5\u00106J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0004R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001aR\u0018\u0010'\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001aR$\u0010.\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/register/u;", "", "Landroid/content/Intent;", "intent", "", "j", "p", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "k", "l", ReportConstant.COSTREPORT_PREFIX, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/fragment/RegisterNewBaseFragment;", "a", "Lmqq/util/WeakReference;", "mFragmentRef", "", "b", "Ljava/lang/String;", "mSmsCode", "c", "mUin", "", "d", "[B", "mSign", "e", "curNick", "f", "curPwd", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "g", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "mWechatInfo", tl.h.F, "mNTRegisterContext", "i", "mSuperSig", "Lcom/tencent/mobileqq/register/AutoLoginHelper;", "Lcom/tencent/mobileqq/register/AutoLoginHelper;", "getMAutoLoginHelper", "()Lcom/tencent/mobileqq/register/AutoLoginHelper;", "setMAutoLoginHelper", "(Lcom/tencent/mobileqq/register/AutoLoginHelper;)V", "mAutoLoginHelper", "Lcom/tencent/mobileqq/loginregister/servlet/d;", "Lcom/tencent/mobileqq/loginregister/servlet/d;", "ao", "Landroid/content/Intent;", "mLoginIntent", "fragment", "<init>", "(Lcom/tencent/mobileqq/fragment/RegisterNewBaseFragment;Landroid/content/Intent;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class u {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<RegisterNewBaseFragment> mFragmentRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mSmsCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] mSign;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String curNick;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String curPwd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WechatInfo mWechatInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] mNTRegisterContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] mSuperSig;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AutoLoginHelper mAutoLoginHelper;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.loginregister.servlet.d ao;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Intent mLoginIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/register/u$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.u$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/register/u$b", "Lcom/tencent/mobileqq/loginregister/servlet/d;", "", "isSuccess", "", "code", "", "uin", "", "contactSig", "proError", "supersig", "", "d", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends com.tencent.mobileqq.loginregister.servlet.d {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Intent f280579f;

        b(Intent intent) {
            this.f280579f = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this, (Object) intent);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
        @Override // com.tencent.mobileqq.loginregister.servlet.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void d(boolean isSuccess, int code, @Nullable String uin, @Nullable byte[] contactSig, @Nullable byte[] proError, @Nullable byte[] supersig) {
            String str;
            WeakReference weakReference;
            boolean z16;
            RegisterNewBaseFragment registerNewBaseFragment;
            RegisterNewBaseFragment registerNewBaseFragment2;
            RegisterNewBaseFragment registerNewBaseFragment3;
            RegisterNewBaseFragment registerNewBaseFragment4;
            RegisterNewBaseFragment registerNewBaseFragment5;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(code), uin, contactSig, proError, supersig);
                return;
            }
            if (proError != null) {
                try {
                    str = new String(proError, Charsets.UTF_8);
                } catch (UnsupportedEncodingException e16) {
                    QLog.e("NTRegisterMainlineRegisterWithNickAndPwd", 1, "error: " + e16);
                }
                if (TextUtils.isEmpty(str)) {
                    str = HardCodeUtil.qqStr(R.string.g0j);
                }
                weakReference = u.this.mFragmentRef;
                if (weakReference != null && (registerNewBaseFragment5 = (RegisterNewBaseFragment) weakReference.get()) != null) {
                    registerNewBaseFragment5.rh();
                }
                if (isSuccess) {
                    WeakReference weakReference2 = u.this.mFragmentRef;
                    if (weakReference2 != null && (registerNewBaseFragment4 = (RegisterNewBaseFragment) weakReference2.get()) != null) {
                        registerNewBaseFragment4.zh(str, 1);
                        return;
                    }
                    return;
                }
                if (contactSig == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.i("NTRegisterMainlineRegisterWithNickAndPwd", 1, "onRegisterCommitPassResp code = " + code + " ;uin = " + uin + " ;contactsig = " + z16);
                if (code == 0) {
                    u.this.mUin = uin;
                    u.this.mSign = contactSig;
                    u.this.mSuperSig = supersig;
                    if (TextUtils.isEmpty(u.this.mUin)) {
                        WeakReference weakReference3 = u.this.mFragmentRef;
                        if (weakReference3 != null && (registerNewBaseFragment3 = (RegisterNewBaseFragment) weakReference3.get()) != null) {
                            registerNewBaseFragment3.zh(str, 1);
                            return;
                        }
                        return;
                    }
                    if (u.this.mSign != null) {
                        byte[] bArr = u.this.mSign;
                        Intrinsics.checkNotNull(bArr);
                        if (bArr.length == 0) {
                            z17 = true;
                        }
                        if (!z17) {
                            u.this.j(this.f280579f);
                            return;
                        }
                    }
                    WeakReference weakReference4 = u.this.mFragmentRef;
                    if (weakReference4 != null && (registerNewBaseFragment2 = (RegisterNewBaseFragment) weakReference4.get()) != null) {
                        registerNewBaseFragment2.zh(str, 1);
                        return;
                    }
                    return;
                }
                WeakReference weakReference5 = u.this.mFragmentRef;
                if (weakReference5 != null && (registerNewBaseFragment = (RegisterNewBaseFragment) weakReference5.get()) != null) {
                    registerNewBaseFragment.zh(str, 1);
                    return;
                }
                return;
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
            weakReference = u.this.mFragmentRef;
            if (weakReference != null) {
                registerNewBaseFragment5.rh();
            }
            if (isSuccess) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public u(@NotNull RegisterNewBaseFragment fragment, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment, (Object) intent);
            return;
        }
        this.mSmsCode = "";
        this.mFragmentRef = new WeakReference<>(fragment);
        String stringExtra = intent.getStringExtra(AppConstants.Key.KEY_REGISTER_SMSCODE);
        this.mSmsCode = stringExtra != null ? stringExtra : "";
        this.mWechatInfo = (WechatInfo) intent.getParcelableExtra("key_wechat_binding_info");
        this.mNTRegisterContext = intent.getByteArrayExtra(AppConstants.Key.KEY_NT_REGISTER_CONTEXT);
        this.ao = new b(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Intent intent) {
        RegisterNewBaseFragment registerNewBaseFragment;
        WeakReference<RegisterNewBaseFragment> weakReference = this.mFragmentRef;
        if (weakReference != null) {
            registerNewBaseFragment = weakReference.get();
        } else {
            registerNewBaseFragment = null;
        }
        if (registerNewBaseFragment != null && intent != null) {
            intent.putExtra("uin", this.mUin);
            intent.putExtra(AppConstants.Key.KEY_REGISTER_SIGN, this.mSign);
            intent.putExtra(AppConstants.Key.KEY_REGISTER_PASSWORD, this.curPwd);
            intent.putExtra(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG, this.mSuperSig);
            if (this.mLoginIntent == null) {
                this.mLoginIntent = intent;
            }
            AutoLoginHelper autoLoginHelper = this.mAutoLoginHelper;
            if (autoLoginHelper != null) {
                Intrinsics.checkNotNull(autoLoginHelper);
                autoLoginHelper.x();
                this.mAutoLoginHelper = null;
            }
            AutoLoginHelper autoLoginHelper2 = new AutoLoginHelper(registerNewBaseFragment, this.mLoginIntent);
            this.mAutoLoginHelper = autoLoginHelper2;
            Intrinsics.checkNotNull(autoLoginHelper2);
            autoLoginHelper2.w();
            AutoLoginHelper autoLoginHelper3 = this.mAutoLoginHelper;
            Intrinsics.checkNotNull(autoLoginHelper3);
            autoLoginHelper3.v();
            if (registerNewBaseFragment instanceof RegisterNickAndPwdFragment) {
                ((RegisterNickAndPwdFragment) registerNewBaseFragment).Yh(this.mUin);
                return;
            }
            return;
        }
        QLog.i("NTRegisterMainlineRegisterWithNickAndPwd", 1, "autoLogin, data is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final u this$0, final Intent intent, final int i3, final String str, final GetRegisterUinRsp getRegisterUinRsp) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        if (getRegisterUinRsp != null) {
            num = Integer.valueOf(getRegisterUinRsp.retCode);
        } else {
            num = null;
        }
        QLog.d("NTRegisterMainlineRegisterWithNickAndPwd", 1, "getRegisterUin result: " + i3 + ", business code: " + num);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.register.t
            @Override // java.lang.Runnable
            public final void run() {
                u.n(u.this, i3, getRegisterUinRsp, str, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(u this$0, int i3, GetRegisterUinRsp getRegisterUinRsp, String str, Intent intent) {
        Integer num;
        RegisterNewBaseFragment registerNewBaseFragment;
        RegisterNewBaseFragment registerNewBaseFragment2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        WeakReference<RegisterNewBaseFragment> weakReference = this$0.mFragmentRef;
        if (weakReference != null && (registerNewBaseFragment2 = weakReference.get()) != null) {
            registerNewBaseFragment2.rh();
        }
        if (i3 == 0 && getRegisterUinRsp != null && getRegisterUinRsp.uin != 0 && !TextUtils.isEmpty(getRegisterUinRsp.registerSucceedToken)) {
            this$0.mUin = String.valueOf(getRegisterUinRsp.uin);
            String str2 = getRegisterUinRsp.registerSucceedToken;
            Intrinsics.checkNotNullExpressionValue(str2, "getUinRsp.registerSucceedToken");
            byte[] bytes = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            this$0.mSuperSig = bytes;
            QLog.d("NTRegisterMainlineRegisterWithNickAndPwd", 1, "autoLogin, superSig length: " + getRegisterUinRsp.registerSucceedToken.length());
            this$0.j(intent);
            return;
        }
        if (getRegisterUinRsp != null) {
            num = Integer.valueOf(getRegisterUinRsp.retCode);
        } else {
            num = null;
        }
        QLog.e("NTRegisterMainlineRegisterWithNickAndPwd", 1, "doActionByNT getRegisterUin failed result: " + i3 + ", business code: " + num);
        String qqStr = HardCodeUtil.qqStr(R.string.g0j);
        if (TextUtils.isEmpty(str)) {
            str = qqStr;
        }
        WeakReference<RegisterNewBaseFragment> weakReference2 = this$0.mFragmentRef;
        if (weakReference2 != null && (registerNewBaseFragment = weakReference2.get()) != null) {
            registerNewBaseFragment.zh(str, 1);
        }
    }

    public final void k(@NotNull Intent intent) {
        String str;
        RegisterNewBaseFragment registerNewBaseFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.curNick = intent.getStringExtra(AppConstants.Key.KEY_REGISTER_NICK);
        this.curPwd = intent.getStringExtra(AppConstants.Key.KEY_REGISTER_PASSWORD);
        String stringExtra = intent.getStringExtra(AppConstants.Key.KEY_REGISTER_SMSCODE);
        this.mSmsCode = stringExtra;
        if (stringExtra == null) {
            this.mSmsCode = "";
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ILoginServletService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app\n                .get\u2026ava, ProcessConstant.ALL)");
            ((ILoginServletService) runtimeService).setRegDevLockFlag(1);
            q c16 = q.c();
            String str2 = this.curPwd;
            String str3 = this.curNick;
            String str4 = this.mSmsCode;
            WechatInfo wechatInfo = this.mWechatInfo;
            if (wechatInfo != null) {
                str = wechatInfo.a();
            } else {
                str = null;
            }
            c16.i(peekAppRuntime, str2, str3, str4, null, true, null, str, this.ao);
            WeakReference<RegisterNewBaseFragment> weakReference = this.mFragmentRef;
            if (weakReference != null && (registerNewBaseFragment = weakReference.get()) != null) {
                registerNewBaseFragment.sh(R.string.fyu);
            }
        } catch (Exception e16) {
            QLog.e("NTRegisterMainlineRegisterWithNickAndPwd", 1, "error: " + e16);
        }
    }

    public final void l(@NotNull final Intent intent) {
        Integer num;
        byte[] bArr;
        RegisterNewBaseFragment registerNewBaseFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        byte[] bArr2 = this.mNTRegisterContext;
        String str = null;
        if (bArr2 != null) {
            num = Integer.valueOf(bArr2.length);
        } else {
            num = null;
        }
        QLog.d("NTRegisterMainlineRegisterWithNickAndPwd", 1, "start get uin by NT cookie length: " + num);
        WeakReference<RegisterNewBaseFragment> weakReference = this.mFragmentRef;
        if (weakReference != null && (registerNewBaseFragment = weakReference.get()) != null) {
            registerNewBaseFragment.sh(R.string.fyu);
        }
        this.curNick = intent.getStringExtra(AppConstants.Key.KEY_REGISTER_NICK);
        this.curPwd = intent.getStringExtra(AppConstants.Key.KEY_REGISTER_PASSWORD);
        GetRegisterUinReq getRegisterUinReq = new GetRegisterUinReq();
        getRegisterUinReq.context = this.mNTRegisterContext;
        RegisterAccountInfo registerAccountInfo = getRegisterUinReq.registerInfo;
        String str2 = this.curNick;
        if (str2 != null) {
            bArr = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
        } else {
            bArr = null;
        }
        registerAccountInfo.nickname = bArr;
        getRegisterUinReq.registerInfo.password = this.curPwd;
        BindInfo bindInfo = new BindInfo();
        WechatInfo wechatInfo = this.mWechatInfo;
        if (wechatInfo != null) {
            str = wechatInfo.a();
        }
        bindInfo.profileSig = str;
        getRegisterUinReq.bindInfo = bindInfo;
        ((ILoginService) QRoute.api(ILoginService.class)).getRegisterUin(getRegisterUinReq, new IGetRegisterUinCallback() { // from class: com.tencent.mobileqq.register.s
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetRegisterUinCallback
            public final void onResult(int i3, String str3, GetRegisterUinRsp getRegisterUinRsp) {
                u.m(u.this, intent, i3, str3, getRegisterUinRsp);
            }
        });
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AutoLoginHelper autoLoginHelper = this.mAutoLoginHelper;
        if (autoLoginHelper != null) {
            Intrinsics.checkNotNull(autoLoginHelper);
            autoLoginHelper.s();
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AutoLoginHelper autoLoginHelper = this.mAutoLoginHelper;
        if (autoLoginHelper != null) {
            Intrinsics.checkNotNull(autoLoginHelper);
            autoLoginHelper.x();
            this.mAutoLoginHelper = null;
        }
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AutoLoginHelper autoLoginHelper = this.mAutoLoginHelper;
        if (autoLoginHelper != null) {
            Intrinsics.checkNotNull(autoLoginHelper);
            autoLoginHelper.y();
        }
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AutoLoginHelper autoLoginHelper = this.mAutoLoginHelper;
        if (autoLoginHelper != null) {
            Intrinsics.checkNotNull(autoLoginHelper);
            autoLoginHelper.z();
        }
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTRegisterMainlineRegisterWithNickAndPwd", 2, "reAutoLogin");
        }
        j(this.mLoginIntent);
    }
}
