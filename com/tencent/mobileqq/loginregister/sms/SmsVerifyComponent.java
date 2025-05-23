package com.tencent.mobileqq.loginregister.sms;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SmsVerifyComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, c> f242908a;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface FunctionCode {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends ISmsVerifyCodeService.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f242909d;

        a(d dVar) {
            this.f242909d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void a(QBaseActivity qBaseActivity, Bundle bundle, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, qBaseActivity, bundle, obj);
                return;
            }
            if (!(obj instanceof LoginResult)) {
                QLog.e("SmsVerifyComponent", 1, "SMS verify data error");
                this.f242909d.a(null);
                return;
            }
            this.f242909d.b((LoginResult) obj);
            if (qBaseActivity != null) {
                QLog.i("SmsVerifyComponent", 1, "onSuccess finish activity");
                qBaseActivity.finish();
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void d(QBaseActivity qBaseActivity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qBaseActivity, (Object) bundle);
                return;
            }
            this.f242909d.a(bundle);
            if (qBaseActivity != null) {
                QLog.i("SmsVerifyComponent", 1, "onCancel finish activity");
                qBaseActivity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends ISmsVerifyCodeService.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f242910d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f242911e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Intent f242912f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ISmsVerifyCodeService f242913h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f242914i;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a extends ISmsVerifyCodeService.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
            public void a(QBaseActivity qBaseActivity, Bundle bundle, Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, qBaseActivity, bundle, obj);
                    return;
                }
                b.this.f242910d.b(bundle);
                if (qBaseActivity != null) {
                    QLog.i("SmsVerifyComponent", 1, "onSuccess finish activity");
                    qBaseActivity.finish();
                }
            }

            @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
            public void d(QBaseActivity qBaseActivity, Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) qBaseActivity, (Object) bundle);
                    return;
                }
                b.this.f242910d.a(bundle);
                if (qBaseActivity != null) {
                    QLog.i("SmsVerifyComponent", 1, "onCancel finish activity");
                    qBaseActivity.finish();
                }
            }
        }

        b(f fVar, int i3, Intent intent, ISmsVerifyCodeService iSmsVerifyCodeService, int i16) {
            this.f242910d = fVar;
            this.f242911e = i3;
            this.f242912f = intent;
            this.f242913h = iSmsVerifyCodeService;
            this.f242914i = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, fVar, Integer.valueOf(i3), intent, iSmsVerifyCodeService, Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void a(QBaseActivity qBaseActivity, Bundle bundle, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, qBaseActivity, bundle, obj);
                return;
            }
            this.f242910d.b(bundle);
            if (qBaseActivity != null) {
                QLog.i("SmsVerifyComponent", 1, "onSuccess finish activity");
                qBaseActivity.finish();
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.a, com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void c(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
                return;
            }
            int i3 = this.f242911e;
            if (i3 != 1 && i3 != 6) {
                return;
            }
            this.f242912f.putExtras(bundle);
            com.tencent.mobileqq.loginregister.sms.d dVar = new com.tencent.mobileqq.loginregister.sms.d(4, this.f242912f);
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity == null) {
                QLog.e("SmsVerifyComponent", 1, "startVerify onTransToSendUpSms topActivity is null");
            } else {
                this.f242913h.startVerifyCode(qBaseActivity, this.f242914i, dVar, new a());
            }
        }

        @Override // com.tencent.mobileqq.loginregister.sms.ISmsVerifyCodeService.b
        public void d(QBaseActivity qBaseActivity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qBaseActivity, (Object) bundle);
                return;
            }
            this.f242910d.a(bundle);
            if (qBaseActivity != null) {
                QLog.i("SmsVerifyComponent", 1, "onCancel finish activity");
                qBaseActivity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final String f242916a;

        /* renamed from: b, reason: collision with root package name */
        final String f242917b;

        /* renamed from: c, reason: collision with root package name */
        final long f242918c;

        c(String str, String str2, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Long.valueOf(j3));
                return;
            }
            this.f242916a = str;
            this.f242917b = str2;
            this.f242918c = j3;
        }

        long a(String str, String str2, long j3) {
            if (TextUtils.equals(this.f242916a, str) && TextUtils.equals(this.f242917b, str2)) {
                return this.f242918c;
            }
            return j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        void a(Bundle bundle);

        void b(LoginResult loginResult);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class e implements f {
        static IPatchRedirector $redirector_;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface f {
        void a(Bundle bundle);

        void b(Bundle bundle);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_WX_UPLOAD_SUCC);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f242908a = new ConcurrentHashMap<>();
        }
    }

    public static boolean a(int i3, String str, String str2) {
        long b16 = b(i3, str, str2, 0L);
        if (b16 <= 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - b16;
        QLog.i("SmsVerifyComponent", 1, "click next step. smsCountdownStartTime= " + b16 + ", duration= " + currentTimeMillis);
        if (currentTimeMillis >= 60000) {
            return false;
        }
        return true;
    }

    public static long b(int i3, String str, String str2, long j3) {
        c cVar = f242908a.get(Integer.valueOf(i3));
        if (cVar != null) {
            return cVar.a(str, str2, j3);
        }
        return j3;
    }

    public static void c(int i3, String str, String str2, long j3) {
        f242908a.put(Integer.valueOf(i3), new c(str, str2, j3));
    }

    public static void d(String str, String str2, Bundle bundle, d dVar) {
        if (dVar == null) {
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            QLog.e("SmsVerifyComponent", 1, "startVerify topActivity is null");
            dVar.a(null);
            return;
        }
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        if (appRuntime == null) {
            QLog.e("SmsVerifyComponent", 1, "startVerify appRuntime is null");
            dVar.a(null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra(WadlProxyConsts.EXTRA_DATA, bundle);
        intent.putExtra(AppConstants.Key.PHONENUM, str);
        intent.putExtra("key", str2);
        ((ISmsVerifyCodeService) appRuntime.getRuntimeService(ISmsVerifyCodeService.class, "all")).startVerifyCode(qBaseActivity, 0, new com.tencent.mobileqq.loginregister.sms.d(5, intent), new a(dVar));
    }

    public static void e(int i3, String str, String str2, Bundle bundle, f fVar) {
        if (fVar == null) {
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            QLog.e("SmsVerifyComponent", 1, "startVerify topActivity is null");
            fVar.a(null);
            return;
        }
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        if (appRuntime == null) {
            QLog.e("SmsVerifyComponent", 1, "startVerify appRuntime is null");
            fVar.a(null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra(WadlProxyConsts.EXTRA_DATA, bundle);
        intent.putExtra(AppConstants.Key.PHONENUM, str);
        intent.putExtra("key", str2);
        com.tencent.mobileqq.loginregister.sms.d dVar = new com.tencent.mobileqq.loginregister.sms.d(i3, intent);
        ISmsVerifyCodeService iSmsVerifyCodeService = (ISmsVerifyCodeService) appRuntime.getRuntimeService(ISmsVerifyCodeService.class, "all");
        iSmsVerifyCodeService.startVerifyCode(qBaseActivity, 0, dVar, new b(fVar, i3, intent, iSmsVerifyCodeService, 0));
    }
}
