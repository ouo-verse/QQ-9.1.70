package com.tencent.mobileqq.register;

import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginregister.ao;
import com.tencent.mobileqq.loginregister.servlet.IRegisterServletService;
import com.tencent.mobileqq.loginregister.sms.RegisterVerifyResult;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.register.fragment.RegisterNickAndPwdFragment;
import com.tencent.mobileqq.register.j;
import com.tencent.mobileqq.util.aj;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.util.ce;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$EncryptPhoneData;
import tencent.im.login.GetLocalPhone$MaskPhoneData;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u001f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/register/j;", "Lcom/tencent/mobileqq/register/g;", "", "w", "", "code", "u", "Lcom/tencent/mobileqq/register/bean/b;", "result", BaseConstants.ATTR_KET_PHONE_TOKEN, "v", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "Lcom/tencent/mobileqq/loginregister/callback/b;", "registerCallback", "t", "", "g", "Z", "mFromFriendVerify", tl.h.F, "mIsWechatRegister", "i", "Ljava/lang/String;", "mPhoneToken", "Lcom/tencent/mobileqq/loginregister/servlet/d;", "j", "Lcom/tencent/mobileqq/loginregister/servlet/d;", "mRegisterObserver", "com/tencent/mobileqq/register/j$b", "k", "Lcom/tencent/mobileqq/register/j$b;", "mRegisterSafetyCallback", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final j f280455f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean mFromFriendVerify;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsWechatRegister;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String mPhoneToken;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.mobileqq.loginregister.servlet.d mRegisterObserver;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b mRegisterSafetyCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/register/j$a", "Lcom/tencent/mobileqq/loginregister/servlet/d;", "", "isSuccess", "", "code", "", "strPromptInfo", "", "protectUinsUrl", DeviceType.DeviceCategory.MOBILE, "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends com.tencent.mobileqq.loginregister.servlet.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.d
        public void a(boolean isSuccess, int code, @Nullable byte[] strPromptInfo, @Nullable String protectUinsUrl, @Nullable byte[] mobile) {
            QBaseActivity qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(code), strPromptInfo, protectUinsUrl, mobile);
                return;
            }
            QLog.d("GatewayRegisterMainline", 1, "onCheckGatewayRegister code = " + code + ", isSuccess = " + isSuccess);
            j jVar = j.f280455f;
            WeakReference<QBaseActivity> a16 = jVar.a();
            if (a16 != null) {
                qBaseActivity = a16.get();
            } else {
                qBaseActivity = null;
            }
            if (ce.d(qBaseActivity)) {
                jVar.g();
                return;
            }
            Intrinsics.checkNotNull(qBaseActivity);
            jVar.e();
            if (!TextUtils.isEmpty(protectUinsUrl)) {
                Intrinsics.checkNotNull(protectUinsUrl);
                jVar.c(qBaseActivity, protectUinsUrl, null);
                return;
            }
            String h16 = ce.h(strPromptInfo);
            QLog.d("GatewayRegisterMainline", 2, "onRegisterCommitMobileResp strMsg: " + h16);
            if (!isSuccess && code != 66) {
                if (code == 162) {
                    QLog.e("GatewayRegisterMainline", 1, "onCheckGatewayRegister phoneToken is expired");
                    jVar.u("");
                    return;
                } else {
                    if (TextUtils.isEmpty(h16)) {
                        h16 = HardCodeUtil.qqStr(R.string.g0j);
                    }
                    ce.l(h16, 1);
                    jVar.g();
                    return;
                }
            }
            r.e(qBaseActivity, code, h16, null, j.mRegisterSafetyCallback);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/register/j$b", "Lam2/a;", "", "result", "Landroid/os/Bundle;", "data", "", "onResult", "a", "b", "onCancel", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements am2.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // am2.a
        public void a(@NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            int i3 = data.getInt("key_verify_code", -1);
            if (i3 == 8) {
                j.mFromFriendVerify = true;
                j.f280455f.v(null, j.mPhoneToken);
            } else {
                if (i3 != 59) {
                    b();
                    return;
                }
                com.tencent.mobileqq.register.bean.b b16 = q.c().b();
                if (b16 != null) {
                    j.f280455f.v(b16, j.mPhoneToken);
                } else {
                    QLog.e("GatewayRegisterMainline", 1, "onCheckAgain faceResult is null");
                    b();
                }
            }
        }

        @Override // am2.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QLog.e("GatewayRegisterMainline", 1, "mRegisterSafetyCallback onException");
            ce.l(HardCodeUtil.qqStr(R.string.g0j), 1);
            j.f280455f.g();
        }

        @Override // am2.a
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                j.f280455f.f();
            }
        }

        @Override // am2.a
        public void onResult(boolean result, @Nullable Bundle data) {
            QBaseActivity qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), data);
                return;
            }
            if (!result) {
                j.f280455f.d(data);
                return;
            }
            if (data != null) {
                j.f280455f.h((RegisterVerifyResult) data.getParcelable("key_verify_result"));
                return;
            }
            j jVar = j.f280455f;
            WeakReference<QBaseActivity> a16 = jVar.a();
            if (a16 != null) {
                qBaseActivity = a16.get();
            } else {
                qBaseActivity = null;
            }
            if (ce.d(qBaseActivity)) {
                jVar.g();
                return;
            }
            Intrinsics.checkNotNull(qBaseActivity);
            RegisterNickAndPwdFragment.INSTANCE.a(qBaseActivity, jVar.b(), null);
            cb.d("0X800C1FB");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/register/j$c", "Lne1/a;", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements ne1.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(int i3) {
            j.f280455f.u(String.valueOf(i3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e() {
            j.f280455f.v(null, j.mPhoneToken);
        }

        @Override // ne1.a
        public void a(@NotNull GetLocalPhone$OIDBGetPhoneRsp data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            GetLocalPhone$EncryptPhoneData getLocalPhone$EncryptPhoneData = data.msg_encrypt_phone_data.get();
            cb.d("0X800C1FA");
            if (getLocalPhone$EncryptPhoneData == null) {
                QLog.e("GatewayRegisterMainline", 1, "getPhoneNumSuccess, phoneData is null");
                j.f280455f.u("");
                return;
            }
            QLog.i("GatewayRegisterMainline", 1, "getPhoneNumSuccess success");
            j jVar = j.f280455f;
            j.mPhoneToken = getLocalPhone$EncryptPhoneData.str_encypt_phone.get();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.register.k
                @Override // java.lang.Runnable
                public final void run() {
                    j.c.e();
                }
            });
            cb.f("0X800C3AC", "0X800C3AB", 0, "");
        }

        @Override // ne1.a
        public void onFail(final int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            QLog.e("GatewayRegisterMainline", 1, "getPhoneTokenWithMaskPhone onException : " + errorMsg);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.register.l
                @Override // java.lang.Runnable
                public final void run() {
                    j.c.d(errorCode);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25366);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f280455f = new j();
        mRegisterObserver = new a();
        mRegisterSafetyCallback = new b();
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String code) {
        e();
        ce.k(R.string.f2036350q, 1);
        cb.f("0X800C3AC", "0X800C3AB", 1, code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(com.tencent.mobileqq.register.bean.b result, String phoneToken) {
        String str;
        PBStringField pBStringField;
        try {
            m();
            Bundle f16 = ce.f();
            GetLocalPhone$MaskPhoneData mMaskPhoneData = aj.f306554f.getMMaskPhoneData();
            if (mMaskPhoneData != null && (pBStringField = mMaskPhoneData.str_mask_phone) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            f16.putString(DeviceType.DeviceCategory.MOBILE, str);
            if (result != null) {
                f16.putSerializable("mapSt", result.a());
            }
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRegisterServletService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026onstant.ALL\n            )");
            ((IRegisterServletService) runtimeService).checkPhoneNumGatewayRegisterAccount(phoneToken, Long.valueOf(AppSetting.f()), AppSetting.f99551k, mRegisterObserver, f16);
        } catch (Exception e16) {
            QLog.e("GatewayRegisterMainline", 1, "sendRegisterByPhoneToken exception : " + e16);
            g();
        }
    }

    private final void w() {
        com.tencent.mobileqq.gateway.localphone.ecdh.g.n(3, 2, new c(), null, 8, null);
    }

    public final void t(@NotNull QBaseActivity activity, @Nullable WechatInfo wechatInfo, @Nullable com.tencent.mobileqq.loginregister.callback.b registerCallback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, wechatInfo, registerCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        q.c().k(registerCallback);
        ao.INSTANCE.h("", "", LocaleManager.MOBILE_COUNTRY_CODE_CN_STR);
        String c16 = cb.f306645a.c();
        String c17 = com.tencent.mobileqq.statistics.o.c();
        Intrinsics.checkNotNullExpressionValue(c17, "getQimei36()");
        cb.h("0X800C3AA", c16, c17);
        l(wechatInfo);
        if (b() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        mIsWechatRegister = z16;
        i(new WeakReference<>(activity));
        j(null);
        mFromFriendVerify = false;
        k(q.c().d());
        QLog.i("GatewayRegisterMainline", 1, "register isWechatRegister: " + mIsWechatRegister);
        w();
        m();
    }
}
