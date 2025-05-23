package com.tencent.mobileqq.register;

import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.ao;
import com.tencent.mobileqq.loginregister.servlet.IRegisterServletService;
import com.tencent.mobileqq.loginregister.sms.RegisterVerifyResult;
import com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.util.ce;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0004\n\u0002\b\u0007*\u0002\u001f#\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J8\u0010\b\u001a\u00020\u00072.\u0010\u0006\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005H\u0002J*\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/register/m;", "Lcom/tencent/mobileqq/register/g;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "extrasMap", "", "t", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/register/bean/a;", "phoneNumInfo", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "Lcom/tencent/mobileqq/loginregister/callback/b;", "registerCallback", ReportConstant.COSTREPORT_PREFIX, "Landroid/os/Bundle;", "g", "Landroid/os/Bundle;", "mBundle", "", tl.h.F, "Z", "mFromFriendVerify", "i", "mIsWechatRegister", "j", "Lcom/tencent/mobileqq/register/bean/a;", "mPhoneNumInfo", "com/tencent/mobileqq/register/m$a", "k", "Lcom/tencent/mobileqq/register/m$a;", "mRegisterObserver", "com/tencent/mobileqq/register/m$b", "l", "Lcom/tencent/mobileqq/register/m$b;", "mRegisterSafetyCallback", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class m extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final m f280462f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Bundle mBundle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean mFromFriendVerify;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsWechatRegister;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.register.bean.a mPhoneNumInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a mRegisterObserver;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b mRegisterSafetyCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/register/m$a", "Lcom/tencent/mobileqq/loginregister/servlet/d;", "", "isSuccess", "", "code", "", "strPromptInfo", DeviceType.DeviceCategory.MOBILE, "", "inviteCode", "", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
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
        public void c(boolean isSuccess, int code, @Nullable byte[] strPromptInfo, @Nullable byte[] mobile, @Nullable String inviteCode) {
            QBaseActivity qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(code), strPromptInfo, mobile, inviteCode);
                return;
            }
            QLog.i("PhoneNumRegisterMainline", 1, "onRegisterCommitMobileResp code: " + code + ", isSuccess: " + isSuccess);
            m mVar = m.f280462f;
            WeakReference<QBaseActivity> a16 = mVar.a();
            if (a16 != null) {
                qBaseActivity = a16.get();
            } else {
                qBaseActivity = null;
            }
            if (ce.d(qBaseActivity)) {
                mVar.g();
                return;
            }
            Intrinsics.checkNotNull(qBaseActivity);
            mVar.e();
            String h16 = ce.h(strPromptInfo);
            QLog.d("PhoneNumRegisterMainline", 2, "onRegisterCommitMobileResp strMsg: " + h16);
            cb.d("0X8009844");
            if (!isSuccess && code != 66) {
                if (TextUtils.isEmpty(h16)) {
                    h16 = HardCodeUtil.qqStr(R.string.g0j);
                }
                ce.l(h16, 1);
                mVar.g();
                return;
            }
            r.e(qBaseActivity, code, h16, m.mBundle, m.mRegisterSafetyCallback);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/register/m$b", "Lam2/a;", "", "result", "Landroid/os/Bundle;", "data", "", "onResult", "a", "b", "onCancel", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
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
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            int i3 = data.getInt("key_verify_code", -1);
            String str2 = null;
            if (i3 == 8) {
                m.mFromFriendVerify = true;
                m.f280462f.t(null);
                return;
            }
            if (i3 != 9) {
                if (i3 != 59) {
                    b();
                    return;
                }
                com.tencent.mobileqq.register.bean.b b16 = q.c().b();
                if (b16 != null) {
                    m.f280462f.t(b16.a());
                    return;
                } else {
                    QLog.e("PhoneNumRegisterMainline", 1, "onCheckAgain faceResult is null");
                    b();
                    return;
                }
            }
            HashMap<String, Object> g16 = ce.g(data);
            if (g16 != null) {
                com.tencent.mobileqq.register.bean.a aVar = m.mPhoneNumInfo;
                if (aVar != null) {
                    str = aVar.b();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    com.tencent.mobileqq.register.bean.a aVar2 = m.mPhoneNumInfo;
                    if (aVar2 != null) {
                        str2 = aVar2.b();
                    }
                    Intrinsics.checkNotNull(str2);
                    byte[] bytes = str2.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    g16.put("country_english_name", bytes);
                }
            }
            m.f280462f.t(g16);
        }

        @Override // am2.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QLog.e("PhoneNumRegisterMainline", 1, "mRegisterSafetyCallback onException");
            ce.l(HardCodeUtil.qqStr(R.string.g0j), 1);
            m.f280462f.g();
        }

        @Override // am2.a
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                m.f280462f.f();
            }
        }

        @Override // am2.a
        public void onResult(boolean result, @Nullable Bundle data) {
            RegisterVerifyResult registerVerifyResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), data);
                return;
            }
            if (!result) {
                m.f280462f.d(data);
                return;
            }
            if (data != null) {
                registerVerifyResult = (RegisterVerifyResult) data.getParcelable("key_verify_result");
            } else {
                registerVerifyResult = null;
            }
            m.f280462f.h(registerVerifyResult);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25449);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f280462f = new m();
        mBundle = new Bundle();
        mRegisterObserver = new a();
        mRegisterSafetyCallback = new b();
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(HashMap<String, Object> extrasMap) {
        String str;
        String str2;
        String str3;
        try {
            m();
            Bundle f16 = ce.f();
            Intrinsics.checkNotNullExpressionValue(f16, "getRegDefaultBundle()");
            String str4 = null;
            if (extrasMap != null) {
                f16.putSerializable("mapSt", extrasMap);
            } else {
                com.tencent.mobileqq.register.bean.a aVar = mPhoneNumInfo;
                if (aVar != null) {
                    str = aVar.b();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    HashMap hashMap = new HashMap();
                    com.tencent.mobileqq.register.bean.a aVar2 = mPhoneNumInfo;
                    if (aVar2 != null) {
                        str2 = aVar2.b();
                    } else {
                        str2 = null;
                    }
                    Intrinsics.checkNotNull(str2);
                    byte[] bytes = str2.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    hashMap.put("country_english_name", bytes);
                    f16.putSerializable("mapSt", hashMap);
                }
            }
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRegisterServletService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app\n                .get\u2026ava, ProcessConstant.ALL)");
            IRegisterServletService iRegisterServletService = (IRegisterServletService) runtimeService;
            com.tencent.mobileqq.register.bean.a aVar3 = mPhoneNumInfo;
            if (aVar3 != null) {
                str3 = aVar3.a();
            } else {
                str3 = null;
            }
            com.tencent.mobileqq.register.bean.a aVar4 = mPhoneNumInfo;
            if (aVar4 != null) {
                str4 = aVar4.c();
            }
            iRegisterServletService.sendRegisterByPhoneNumber(null, (byte) 2, str3, str4, null, Long.valueOf(AppSetting.f()), AppSetting.f99551k, f16, mRegisterObserver);
        } catch (Exception e16) {
            QLog.e("PhoneNumRegisterMainline", 1, "sendRegisterByPhone exception: " + e16);
            g();
        }
    }

    public final void s(@NotNull QBaseActivity activity, @NotNull com.tencent.mobileqq.register.bean.a phoneNumInfo, @Nullable WechatInfo wechatInfo, @Nullable com.tencent.mobileqq.loginregister.callback.b registerCallback) {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, phoneNumInfo, wechatInfo, registerCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(phoneNumInfo, "phoneNumInfo");
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            ce.k(R.string.b3j, 0);
            return;
        }
        q.c().k(registerCallback);
        ao.INSTANCE.h(phoneNumInfo.c(), phoneNumInfo.a(), phoneNumInfo.b());
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
        mPhoneNumInfo = phoneNumInfo;
        i(new WeakReference<>(activity));
        j(null);
        mFromFriendVerify = false;
        k(q.c().d());
        QLog.i("PhoneNumRegisterMainline", 1, "register isWechatRegister: " + mIsWechatRegister);
        com.tencent.mobileqq.register.bean.a aVar = mPhoneNumInfo;
        if (aVar != null) {
            str = aVar.a();
        } else {
            str = null;
        }
        com.tencent.mobileqq.register.bean.a aVar2 = mPhoneNumInfo;
        if (aVar2 != null) {
            str2 = aVar2.c();
        } else {
            str2 = null;
        }
        boolean a16 = SmsVerifyComponent.a(1, str, str2);
        Bundle bundle = mBundle;
        bundle.clear();
        com.tencent.mobileqq.register.bean.a aVar3 = mPhoneNumInfo;
        if (aVar3 != null) {
            str3 = aVar3.c();
        } else {
            str3 = null;
        }
        bundle.putString("key_phone_num", str3);
        com.tencent.mobileqq.register.bean.a aVar4 = mPhoneNumInfo;
        if (aVar4 != null) {
            str4 = aVar4.a();
        } else {
            str4 = null;
        }
        bundle.putString("key_country_code", str4);
        if (a16) {
            r.e(activity, 1, null, bundle, mRegisterSafetyCallback);
        } else {
            t(null);
        }
    }
}
