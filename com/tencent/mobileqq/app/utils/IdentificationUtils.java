package com.tencent.mobileqq.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.loginregister.IFaceIdentificationEnablePrePageApi;
import com.tencent.mobileqq.loginregister.y;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck$SecureCheckResponse;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0x5e1$RspBody;
import tencent.im.oidb.oidb_0x5e1$UdcUinData;
import tencent.im.oidb.oidb_0x87a$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class IdentificationUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static int f196585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements IFaceIdentificationEnablePrePageApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f196591a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f196592b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f196593c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f196594d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f196595e;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.app.utils.IdentificationUtils$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C7392a extends com.tencent.mobileqq.qqconnectface.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Activity f196596a;

            C7392a(Activity activity) {
                this.f196596a = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) activity);
                }
            }

            @Override // com.tencent.mobileqq.qqconnectface.a
            public void onCallbackError() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                Activity activity = this.f196596a;
                if (activity != null) {
                    activity.finish();
                }
            }

            @Override // com.tencent.mobileqq.qqconnectface.a
            public void onLegacyPageCreate() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.i("IdentificationUtils", 1, "onLegacyPageCreate");
                Activity activity = this.f196596a;
                if (activity != null) {
                    activity.finish();
                }
            }
        }

        a(AppRuntime appRuntime, Activity activity, String str, String str2, c cVar) {
            this.f196591a = appRuntime;
            this.f196592b = activity;
            this.f196593c = str;
            this.f196594d = str2;
            this.f196595e = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appRuntime, activity, str, str2, cVar);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.IFaceIdentificationEnablePrePageApi.a
        public void a(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            } else {
                QLog.i("IdentificationUtils", 1, "onFail");
                IdentificationUtils.d(this.f196591a, this.f196592b, this.f196593c, this.f196594d, this.f196595e, activity);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.IFaceIdentificationEnablePrePageApi.a
        public void b(Activity activity, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, str, str2);
                return;
            }
            QLog.i("IdentificationUtils", 1, "onSuccess: setFaceDataStart");
            IdentificationUtils.c(this.f196592b, this.f196591a.getAccount(), str, str2, new C7392a(activity));
            IdentificationUtils.f196585a = 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b extends com.tencent.mobileqq.qqconnectface.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqconnectface.a f196598a;

        b(com.tencent.mobileqq.qqconnectface.a aVar) {
            this.f196598a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.qqconnectface.a
        public void onIdentificationCancelBtnClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A860", "0X800A860", 3, 0, "1", "", "", "");
            com.tencent.mobileqq.qqconnectface.a aVar = this.f196598a;
            if (aVar != null) {
                aVar.onIdentificationCancelBtnClick();
            }
        }

        @Override // com.tencent.mobileqq.qqconnectface.a
        public void onIdentificationFailed(com.tencent.mobileqq.qqconnectface.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
                return;
            }
            QLog.d("IdentificationUtils", 2, "setFaceData failed, result = " + cVar);
            com.tencent.mobileqq.qqconnectface.a aVar = this.f196598a;
            if (aVar != null) {
                aVar.onIdentificationFailed(cVar);
            }
        }

        @Override // com.tencent.mobileqq.qqconnectface.a
        public void onIdentificationSuccess(com.tencent.mobileqq.qqconnectface.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A31F", "0X800A31F", 0, 0, "", "", "", "");
            com.tencent.mobileqq.qqconnectface.a aVar = this.f196598a;
            if (aVar != null) {
                aVar.onIdentificationSuccess(cVar);
            }
        }

        @Override // com.tencent.mobileqq.qqconnectface.a
        public void onLegacyPageCreate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("IdentificationUtils", 2, "setFaceData onLegacyPageCreate");
            com.tencent.mobileqq.qqconnectface.a aVar = this.f196598a;
            if (aVar != null) {
                aVar.onLegacyPageCreate();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
        void error(String str);
    }

    public static void a(AppRuntime appRuntime, Activity activity, String str, String str2, boolean z16, oidb_0x5e1$RspBody oidb_0x5e1_rspbody, FaceSecureCheck$SecureCheckResponse faceSecureCheck$SecureCheckResponse, c cVar) {
        PBRepeatMessageField<oidb_0x5e1$UdcUinData> pBRepeatMessageField;
        if (z16) {
            QLog.e("IdentificationUtils", 1, "entrance click, has unverified phone");
            cVar.error(activity.getString(R.string.f199054od));
            f196585a = 7;
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("IdentificationUtils", 1, "entrance click, phoneNum is null");
            cVar.error(activity.getString(R.string.w4h));
            f196585a = 1;
            return;
        }
        if (oidb_0x5e1_rspbody != null && (pBRepeatMessageField = oidb_0x5e1_rspbody.rpt_msg_uin_data) != null && pBRepeatMessageField.size() != 0) {
            if (oidb_0x5e1_rspbody.rpt_msg_uin_data.get(0).user_login_guard_face.get() == 0) {
                if (faceSecureCheck$SecureCheckResponse != null && faceSecureCheck$SecureCheckResponse.bool_sec_pass.get()) {
                    b(activity, appRuntime.getAccount(), faceSecureCheck$SecureCheckResponse.str_openid.get(), faceSecureCheck$SecureCheckResponse.str_tmpkey.get());
                    f196585a = 5;
                    return;
                } else {
                    e(appRuntime, activity, str, str2, cVar);
                    return;
                }
            }
            QPublicFragmentActivity.startForResult(activity, (Class<? extends QPublicBaseFragment>) ((IIdentificationApi) QRoute.api(IIdentificationApi.class)).getDeleteFaceFragment(), 12);
            f196585a = 6;
            return;
        }
        QLog.e("IdentificationUtils", 1, "entrance click, status error");
        cVar.error(activity.getString(R.string.f199044oc));
        f196585a = 2;
    }

    public static void b(Context context, String str, String str2, String str3) {
        c(context, str, str2, str3, null);
    }

    public static void c(Context context, String str, String str2, String str3, com.tencent.mobileqq.qqconnectface.a aVar) {
        com.tencent.mobileqq.qqconnectface.b bVar = new com.tencent.mobileqq.qqconnectface.b();
        bVar.f262371a = 101810106;
        bVar.f262372b = "setFaceData";
        bVar.f262373c = 2;
        bVar.f262374d = str;
        bVar.f262375e = str2;
        bVar.f262376f = str3;
        bVar.f262377g = 1;
        ((IIdentificationApi) QRoute.api(IIdentificationApi.class)).startIdentification(context, bVar, new b(aVar));
    }

    protected static void d(AppRuntime appRuntime, Context context, String str, String str2, c cVar, Activity activity) {
        if (System.currentTimeMillis() - y.f243060b >= 60000) {
            LoginVerifyServlet.r(appRuntime, new com.tencent.mobileqq.observer.c(str, str2, context, activity, cVar) { // from class: com.tencent.mobileqq.app.utils.IdentificationUtils.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f196586d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f196587e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Context f196588f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Activity f196589h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ c f196590i;

                {
                    this.f196586d = str;
                    this.f196587e = str2;
                    this.f196588f = context;
                    this.f196589h = activity;
                    this.f196590i = cVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, str2, context, activity, cVar);
                    }
                }

                @Override // com.tencent.mobileqq.observer.c
                public void onFailedResponse(String str3, int i3, String str4) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, str3, Integer.valueOf(i3), str4);
                        return;
                    }
                    QLog.e("IdentificationUtils", 1, "cmd : ", str3, " code : ", Integer.valueOf(i3), " message : ", str4);
                    if (i3 == 89) {
                        str4 = this.f196588f.getString(R.string.w4h);
                    }
                    this.f196590i.error(str4);
                    Activity activity2 = this.f196589h;
                    if (activity2 != null) {
                        activity2.finish();
                    }
                }

                @Override // com.tencent.mobileqq.observer.c
                public void sendSmsCodeSuccess(oidb_0x87a$RspBody oidb_0x87a_rspbody) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) oidb_0x87a_rspbody);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra(MQPSecJsPlugin.KEY_FROM, "f_SetFaceData");
                    String str3 = this.f196586d;
                    String str4 = "";
                    if (str3 == null) {
                        str3 = "";
                    }
                    intent.putExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM, str3);
                    String str5 = this.f196587e;
                    if (str5 != null) {
                        str4 = str5;
                    }
                    intent.putExtra("country_code", str4);
                    RouteUtils.startActivityForResult(this.f196588f, intent, "/base/login/authDevVerifyCode", 11);
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.app.utils.IdentificationUtils.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            Activity activity2 = AnonymousClass2.this.f196589h;
                            if (activity2 != null) {
                                activity2.finish();
                            }
                        }
                    }, 200L);
                }
            });
            f196585a = 3;
            return;
        }
        f(context, str);
        f196585a = 4;
        if (activity != null) {
            activity.finish();
        }
    }

    static void e(AppRuntime appRuntime, Activity activity, String str, String str2, c cVar) {
        String str3;
        Intent intent = new Intent();
        intent.putExtra(MQPSecJsPlugin.KEY_FROM, "f_SetFaceData");
        String str4 = "";
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        intent.putExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM, str3);
        if (str2 != null) {
            str4 = str2;
        }
        intent.putExtra("country_code", str4);
        ((IFaceIdentificationEnablePrePageApi) QRoute.api(IFaceIdentificationEnablePrePageApi.class)).openEnablePrePage(activity, intent, new a(appRuntime, activity, str, str2, cVar));
    }

    protected static void f(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra(MQPSecJsPlugin.KEY_FROM, "f_SetFaceData");
        if (str == null) {
            str = "";
        }
        intent.putExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM, str);
        RouteUtils.startActivityForResult(context, intent, "/base/login/authDevVerifyCode", 11);
    }
}
