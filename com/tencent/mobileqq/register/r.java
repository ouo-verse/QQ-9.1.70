package com.tencent.mobileqq.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.login.verify.PuzzleVerifyComponent;
import com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.util.ce;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\"\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J,\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/register/r;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "", "code", "", "strMsg", "Landroid/os/Bundle;", "bundle", "Lam2/a;", "callback", "", "e", "c", "tmpUrl", "a", WadlProxyConsts.EXTRA_DATA, "d", "b", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class r {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f280551a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/register/r$a", "Lcom/tencent/mobileqq/login/verify/PuzzleVerifyComponent$b;", "", "result", "", "ticket", "randStr", "appId", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements PuzzleVerifyComponent.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f280552a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ am2.a f280553b;

        a(int i3, am2.a aVar) {
            this.f280552a = i3;
            this.f280553b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                cb.f("0X800C3B8", "0X800C3B7", 2, "");
                this.f280553b.onCancel();
            }
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void b(boolean result, @Nullable String ticket, @Nullable String randStr, @Nullable String appId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), ticket, randStr, appId);
                return;
            }
            QLog.d("RegisterSafetyCheckComponent", 2, "RegisterPuzzleVerifyCallBack onVerifyResult");
            cb.f("0X800C3B8", "0X800C3B7", 0, "");
            Bundle bundle = new Bundle();
            bundle.putInt("key_verify_code", this.f280552a);
            bundle.putString("ticket", ticket);
            bundle.putString(MQPSecJsPlugin.KEY_RANDSTR, randStr);
            this.f280553b.a(bundle);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/register/r$b", "Lcom/tencent/mobileqq/loginregister/sms/SmsVerifyComponent$e;", "Landroid/os/Bundle;", "extra", "", "b", "a", "", "Ljava/lang/String;", "getTFinishValue", "()Ljava/lang/String;", "tFinishValue", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends SmsVerifyComponent.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tFinishValue;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f280555b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f280556c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ am2.a f280557d;

        b(int i3, String str, am2.a aVar) {
            String str2;
            this.f280555b = i3;
            this.f280556c = str;
            this.f280557d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, aVar);
                return;
            }
            if (i3 == 2) {
                str2 = "0X800C3B2";
            } else {
                str2 = "0X800C3B4";
            }
            this.tFinishValue = str2;
        }

        @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.f
        public void a(@Nullable Bundle extra) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) extra);
                return;
            }
            QLog.i("RegisterSafetyCheckComponent", 1, "smsVerify user cancel");
            cb.f(this.tFinishValue, this.f280556c, 2, "");
            this.f280557d.onCancel();
        }

        @Override // com.tencent.mobileqq.loginregister.sms.SmsVerifyComponent.f
        public void b(@Nullable Bundle extra) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) extra);
                return;
            }
            QLog.d("RegisterSafetyCheckComponent", 1, "smsVerify onSuccess");
            Bundle bundle = new Bundle();
            if (extra != null) {
                bundle.putAll(extra);
            }
            bundle.putInt("key_verify_code", this.f280555b);
            cb.f(this.tFinishValue, this.f280556c, 0, "");
            this.f280557d.onResult(true, bundle);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25579);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f280551a = new r();
        }
    }

    r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(QBaseActivity context, String tmpUrl, am2.a callback) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        String str = tmpUrl;
        try {
            if (tmpUrl.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http://", false, 2, null);
                if (!startsWith$default) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "https://", false, 2, null);
                    if (!startsWith$default2) {
                        str = "https://" + str;
                    }
                }
                Intent intent = new Intent();
                intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.f171898lr0));
                intent.putExtra("url", str);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                z.z(context, intent, RouterConstants.UI_ROUTE_BROWSER);
                ReportController.o(peekAppRuntime, "CliOper", "", "", "0X800665B", "0X800665B", 0, 0, "", "", "", "");
                return;
            }
            QLog.e("RegisterSafetyCheckComponent", 1, "createGoUrlDialog url is empty");
            callback.b();
        } catch (Exception e16) {
            QLog.e("RegisterSafetyCheckComponent", 1, "createGoUrlDialog error : " + e16);
            callback.b();
        }
    }

    private final void b(int code, String strMsg, am2.a callback) {
        boolean startsWith$default;
        boolean startsWith$default2;
        try {
            if (TextUtils.isEmpty(strMsg)) {
                QLog.e("RegisterSafetyCheckComponent", 1, "gotoPuzzleVerify url is empty");
                callback.b();
                return;
            }
            cb.g("0X800C3B7");
            Intrinsics.checkNotNull(strMsg);
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(strMsg, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(strMsg, "https://", false, 2, null);
                if (!startsWith$default2) {
                    strMsg = "https://" + strMsg;
                }
            }
            new PuzzleVerifyComponent().d(3, strMsg, new a(code, callback));
        } catch (Throwable th5) {
            QLog.e("RegisterSafetyCheckComponent", 1, "gotoPuzzleVerify throwable : " + th5);
            callback.b();
        }
    }

    private final void c(QBaseActivity context, String strMsg, am2.a callback) {
        if (TextUtils.isEmpty(strMsg)) {
            ce.k(R.string.g0j, 1);
            callback.b();
        } else {
            Intrinsics.checkNotNull(strMsg);
            a(context, strMsg, callback);
        }
    }

    private final void d(int code, String strMsg, am2.a callback, Bundle extraData) {
        String str;
        int i3 = 1;
        if (code == 2) {
            if (TextUtils.isEmpty(strMsg)) {
                ce.k(R.string.g0j, 1);
                QLog.e("RegisterSafetyCheckComponent", 1, "REGISTER_UP_SMS strMsg is null");
                callback.b();
                return;
            }
            i3 = 4;
            str = "0X800C3B1";
        } else {
            str = "0X800C3B3";
        }
        cb.g(str);
        Bundle bundle = new Bundle();
        if (extraData != null) {
            bundle.putAll(extraData);
        }
        bundle.putString(AppConstants.Key.KEY_REGISTER_PROMPT_INFO, strMsg);
        SmsVerifyComponent.e(i3, bundle.getString("key_phone_num", ""), bundle.getString("key_country_code", ""), bundle, new b(code, str, callback));
    }

    @JvmStatic
    public static final void e(@NotNull QBaseActivity context, int code, @Nullable String strMsg, @Nullable Bundle bundle, @NotNull am2.a callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (code != 0) {
            if (code != 1) {
                if (code != 2) {
                    if (code != 3) {
                        if (code != 7) {
                            if (code != 8) {
                                if (code != 9) {
                                    if (code != 59) {
                                        if (code != 61) {
                                            if (code != 66) {
                                                callback.b();
                                                return;
                                            }
                                        } else {
                                            callback.onResult(true, null);
                                            return;
                                        }
                                    } else {
                                        h.a(context, code, strMsg, 2019, callback);
                                        return;
                                    }
                                } else {
                                    f280551a.b(code, strMsg, callback);
                                    return;
                                }
                            } else {
                                i.a(context, code, strMsg, 2018, callback);
                                return;
                            }
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("key_verify_code", code);
                        callback.onResult(false, bundle2);
                        return;
                    }
                    f280551a.c(context, strMsg, callback);
                    return;
                }
                f280551a.d(code, strMsg, callback, bundle);
                return;
            }
            f280551a.d(code, strMsg, callback, bundle);
            return;
        }
        f280551a.d(code, strMsg, callback, bundle);
    }
}
