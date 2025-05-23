package com.tencent.mobileqq.identification;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.could.component.common.ai.net.NetWorkLoggerCallBack;
import com.tencent.could.component.common.ai.net.TxNetWorkHelper;
import com.tencent.could.huiyansdk.api.CreateFaceIdToken;
import com.tencent.could.huiyansdk.api.HuiYanAuth;
import com.tencent.could.huiyansdk.api.HuiYanAuthResultListener;
import com.tencent.could.huiyansdk.api.HuiYanEventAuthCallback;
import com.tencent.could.huiyansdk.api.HuiYanPublicEventCallBack;
import com.tencent.could.huiyansdk.entity.AuthConfig;
import com.tencent.could.huiyansdk.entity.CustomerConfig;
import com.tencent.could.huiyansdk.entity.LanguageStyle;
import com.tencent.could.huiyansdk.enums.PageColorStyle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper;
import com.tencent.mobileqq.identification.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;
import java.util.Objects;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class IdentificationHuiyanSDKInitHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<Dialog> f237890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FaceConf f237892a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f237893b;

        a(FaceConf faceConf, f fVar) {
            this.f237892a = faceConf;
            this.f237893b = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) faceConf, (Object) fVar);
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.e
        public void a(EncryptContext encryptContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) encryptContext);
            } else {
                this.f237892a.setEncryptContext(encryptContext);
                IdentificationHuiyanSDKInitHelper.C(this.f237892a, this.f237893b);
            }
        }

        @Override // com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.e
        public void b(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            f fVar = this.f237893b;
            if (fVar != null) {
                fVar.onFailed(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements NetWorkLoggerCallBack {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.could.component.common.ai.net.NetWorkLoggerCallBack
        public void logger(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                return;
            }
            QLog.d("IdentificationHuiyanSDKInitHelper", 4, "[HuiyanSdkNet]|" + str + "\uff5c" + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements HuiYanPublicEventCallBack {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FaceConf f237894a;

        c(FaceConf faceConf) {
            this.f237894a = faceConf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) faceConf);
            }
        }

        @Override // com.tencent.could.huiyansdk.api.HuiYanPublicEventCallBack
        public void mainAuthEvent(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("report", str);
            bundle.putString("tmpKey", this.f237894a.getKey());
            QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_report", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements HuiYanAuthResultListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f237895a;

        d(g gVar) {
            this.f237895a = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        @Override // com.tencent.could.huiyansdk.api.HuiYanAuthResultListener
        public void onFail(final int i3, final String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2);
                return;
            }
            QLog.e("IdentificationHuiyanSDKInitHelper", 1, "HuiyanSdkIdentification onFail, huiyanSdkToken=" + str2 + " code=" + i3 + " msg=" + str);
            ReportController.o(null, "dc00898", "", "", "0X800C42E", "0X800C42E", 0, 1, String.valueOf(i3), "", "", "");
            if (i3 == 285) {
                j.m().h();
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final g gVar = this.f237895a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.identification.x
                @Override // java.lang.Runnable
                public final void run() {
                    IdentificationHuiyanSDKInitHelper.g.this.onFailed(i3, str);
                }
            });
            HuiYanAuth.setAuthEventCallBack(null);
            HuiYanAuth.release();
        }

        @Override // com.tencent.could.huiyansdk.api.HuiYanAuthResultListener
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.e("IdentificationHuiyanSDKInitHelper", 1, "HuiyanSdkIdentification onSuccess huiyanSdkToken=" + str);
            ReportController.o(null, "dc00898", "", "", "0X800C42E", "0X800C42E", 0, 0, "", "", "", "");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final g gVar = this.f237895a;
            Objects.requireNonNull(gVar);
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.identification.y
                @Override // java.lang.Runnable
                public final void run() {
                    IdentificationHuiyanSDKInitHelper.g.this.onSuccess();
                }
            });
            HuiYanAuth.setAuthEventCallBack(null);
            HuiYanAuth.release();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface e {
        void a(EncryptContext encryptContext);

        void b(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface f {
        void a(AppConf appConf);

        void onFailed(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface g {
        void onFailed(int i3, String str);

        void onSuccess();
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface h {
        void onFail();

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(EIPCResult eIPCResult, f fVar) {
        QLog.d("IdentificationHuiyanSDKInitHelper", 1, "onConfResponse callServer getConf error_code:" + eIPCResult.code);
        if (r(eIPCResult)) {
            AppConf appConf = (AppConf) eIPCResult.data.getSerializable("FaceQueryAppConf");
            if (fVar != null) {
                fVar.a(appConf);
                return;
            }
            return;
        }
        if (fVar != null) {
            fVar.onFailed(15, "");
        }
    }

    public static void B(final h hVar) {
        QLog.d("IdentificationHuiyanSDKInitHelper", 1, "start prepareSoAndModels");
        QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_res_download", new Bundle(), new EIPCResultCallback() { // from class: com.tencent.mobileqq.identification.s
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                IdentificationHuiyanSDKInitHelper.x(IdentificationHuiyanSDKInitHelper.h.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(FaceConf faceConf, final f fVar) {
        QLog.d("IdentificationHuiyanSDKInitHelper", 1, "realGetAppConfData appid : " + faceConf.getPlatformAppId());
        Bundle bundle = new Bundle();
        bundle.putSerializable("faceConf", faceConf);
        QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_app_conf", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.identification.t
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                IdentificationHuiyanSDKInitHelper.A(eIPCResult, IdentificationHuiyanSDKInitHelper.f.this);
            }
        });
    }

    public static void D(FaceConf faceConf, g gVar) {
        String str;
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            QLog.e("IdentificationHuiyanSDKInitHelper", 1, "startHuiyanSdk context==null");
            gVar.onFailed(214, HardCodeUtil.qqStr(R.string.f159591sq));
            return;
        }
        if (faceConf != null && faceConf.getAppConf() != null) {
            HuiYanAuth.initNoLoadLibs(context);
            final String str2 = faceConf.getAppConf().huiyanSdkToken;
            QLog.i("IdentificationHuiyanSDKInitHelper", 1, "startHuiyanSdk huiyanSdkToken=" + str2);
            HuiYanAuth.setFaceIdTokenCreateFunction(new CreateFaceIdToken() { // from class: com.tencent.mobileqq.identification.p
                @Override // com.tencent.could.huiyansdk.api.CreateFaceIdToken
                public final String getCustomerFaceIdToken() {
                    String z16;
                    z16 = IdentificationHuiyanSDKInitHelper.z(str2);
                    return z16;
                }
            });
            if (QLog.isDevelopLevel()) {
                TxNetWorkHelper.getInstance().setLoggerCallBack(new b());
            }
            MobileQQ.sMobileQQ.peekAppRuntime();
            HuiYanAuth.setHuiYanPublicEventCallBack(new c(faceConf));
            HuiYanAuth.setHuiYanEventListener(new HuiYanEventAuthCallback() { // from class: com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.could.huiyansdk.api.HuiYanEventAuthCallback
                public void onLoadingSuccess() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.4.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                                }
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                Dialog dialog;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                QLog.d("IdentificationHuiyanSDKInitHelper", 1, "onLoadingSuccess");
                                if (IdentificationHuiyanSDKInitHelper.f237890a != null && (dialog = (Dialog) IdentificationHuiyanSDKInitHelper.f237890a.get()) != null) {
                                    try {
                                        dialog.dismiss();
                                    } catch (Throwable th5) {
                                        QLog.e("IdentificationHuiyanSDKInitHelper", 1, th5, new Object[0]);
                                    }
                                    IdentificationHuiyanSDKInitHelper.f237890a = null;
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.could.huiyansdk.api.HuiYanEventAuthCallback
                public void onStartLoading(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity) { // from class: com.tencent.mobileqq.identification.IdentificationHuiyanSDKInitHelper.4.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Activity f237891d;

                            {
                                this.f237891d = activity;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) activity);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                QLog.d("IdentificationHuiyanSDKInitHelper", 1, "onStartLoading");
                                Activity activity2 = this.f237891d;
                                if (activity2 != null && !activity2.isFinishing()) {
                                    try {
                                        Dialog createWaitingDialog = DialogUtil.createWaitingDialog(this.f237891d, R.string.f159621st);
                                        IdentificationHuiyanSDKInitHelper.f237890a = new WeakReference(createWaitingDialog);
                                        createWaitingDialog.show();
                                    } catch (Throwable th5) {
                                        QLog.e("IdentificationHuiyanSDKInitHelper", 1, th5, new Object[0]);
                                    }
                                }
                            }
                        });
                    }
                }
            });
            AuthConfig o16 = o(faceConf);
            ReportController.o(null, "dc00898", "", "", "0X800C42D", "0X800C42D", 0, 0, "", "", "", "");
            CustomerConfig customerConfig = o16.getCustomerConfig();
            if (customerConfig != null) {
                str = customerConfig.getAuthTips();
            } else {
                str = null;
            }
            QLog.d("IdentificationHuiyanSDKInitHelper", 4, "startHuiyanSdk authTips: " + str);
            if (!TextUtils.isEmpty(str)) {
                HuiYanAuth.setAuthEventCallBack(new n(str));
            }
            HuiYanAuth.startHuiYanAuth(o16, new d(gVar));
            return;
        }
        QLog.e("IdentificationHuiyanSDKInitHelper", 1, "startHuiyanSdk faceConf error");
        gVar.onFailed(214, HardCodeUtil.qqStr(R.string.f159591sq));
    }

    private static void l(final h hVar) {
        j.m().v(new j.e() { // from class: com.tencent.mobileqq.identification.v
            @Override // com.tencent.mobileqq.identification.j.e
            public final void a(int i3) {
                IdentificationHuiyanSDKInitHelper.t(IdentificationHuiyanSDKInitHelper.h.this, i3);
            }
        });
    }

    public static void m(final FaceConf faceConf, final f fVar) {
        QLog.d("IdentificationHuiyanSDKInitHelper", 1, "getAppConfAndHuiyanSdkToken start");
        if (faceConf.getPlatformAppId() == 0) {
            QLog.e("IdentificationHuiyanSDKInitHelper", 1, "platformAppId=0");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.identification.q
                @Override // java.lang.Runnable
                public final void run() {
                    IdentificationHuiyanSDKInitHelper.u(FaceConf.this, fVar);
                }
            }, 16, null, false);
        }
    }

    private static String n(@NonNull FaceConf faceConf) {
        List<AppConf.AppWordings> list;
        int serviceType = faceConf.getServiceType();
        AppConf appConf = faceConf.getAppConf();
        if (appConf != null && serviceType != -1 && (list = appConf.f237888al) != null && !list.isEmpty()) {
            for (AppConf.AppWordings appWordings : appConf.f237888al) {
                if (appWordings.serviceType == serviceType) {
                    return appWordings.text;
                }
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IdentificationHuiyanSDKInitHelper", 2, "getAppWording PARAMS ERROR serviceType=" + serviceType + " appConf=" + appConf);
        }
        return null;
    }

    @NonNull
    private static AuthConfig o(@NonNull FaceConf faceConf) {
        AuthConfig authConfig = new AuthConfig();
        authConfig.setPageColorStyle(PageColorStyle.Light);
        authConfig.setAuthLicense("YTFaceSDK.license");
        authConfig.setUseCustomerModelPath(j.m().o());
        CustomerConfig customerConfig = new CustomerConfig();
        String n3 = n(faceConf);
        if (!TextUtils.isEmpty(n3)) {
            customerConfig.setAuthTips(n3);
            customerConfig.setAuthLayoutResId(R.layout.fch);
        }
        customerConfig.setHiddenResultRage(true);
        customerConfig.setHiddenProtocolPage(true);
        customerConfig.setNoteTipsErrorTextColor(-16777216);
        customerConfig.setHiddenExtraTipsTxt(true);
        customerConfig.setHiddenTimeoutLabel(false);
        customerConfig.setCancelBtnRight(true);
        customerConfig.setPrepareImageViewDrawable(new ColorDrawable(-1));
        customerConfig.setHiddenLoadingPage(true);
        if (com.tencent.mobileqq.identification.e.a()) {
            customerConfig.setUse720p(true);
        }
        authConfig.setCustomerConfig(customerConfig);
        authConfig.setLanguageStyle(LanguageStyle.SIMPLIFIED_CHINESE);
        return authConfig;
    }

    private static void p(FaceConf faceConf, final e eVar) {
        QLog.d("IdentificationHuiyanSDKInitHelper", 1, "getEncryptContext start");
        int platformAppId = faceConf.getPlatformAppId();
        String key = faceConf.getKey();
        Bundle bundle = new Bundle();
        bundle.putInt("srcAppId", platformAppId);
        bundle.putString("key", key);
        if (QLog.isDebugVersion() && QLog.isDevelopLevel()) {
            QLog.d("IdentificationHuiyanSDKInitHelper", 1, "getEncryptContext appId=" + platformAppId + " tmpKey=" + key);
        }
        QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_get_enc_context", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.identification.r
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                IdentificationHuiyanSDKInitHelper.v(IdentificationHuiyanSDKInitHelper.e.this, eIPCResult);
            }
        });
    }

    private static String q() {
        return HardCodeUtil.qqStr(R.string.f159571so);
    }

    private static boolean r(EIPCResult eIPCResult) {
        if (eIPCResult.code == 0 && eIPCResult.data != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(int i3, h hVar) {
        if (i3 == 0) {
            hVar.onSuccess();
        } else {
            hVar.onFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(final h hVar, final int i3) {
        QLog.d("IdentificationHuiyanSDKInitHelper", 1, "load so library result " + i3);
        if (hVar == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.identification.w
            @Override // java.lang.Runnable
            public final void run() {
                IdentificationHuiyanSDKInitHelper.s(i3, hVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(FaceConf faceConf, f fVar) {
        boolean z16;
        String method = faceConf.getMethod();
        if (method != null && !l.f237972d.contains(method)) {
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.d("IdentificationHuiyanSDKInitHelper", 1, "getAppConfAndHuiyanSdkToken method=" + method + " needEncryptUserInfo=" + z16);
        if (faceConf.getEncryptContext() == null) {
            QLog.i("IdentificationHuiyanSDKInitHelper", 1, "encrypt context is null, try to get it first");
            p(faceConf, new a(faceConf, fVar));
        } else {
            QLog.i("IdentificationHuiyanSDKInitHelper", 1, "encrypt context ok");
            C(faceConf, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(e eVar, EIPCResult eIPCResult) {
        Bundle bundle;
        EncryptContext encryptContext;
        if (eIPCResult.code == 0 && (bundle = eIPCResult.data) != null && (encryptContext = (EncryptContext) bundle.getSerializable("encContext")) != null) {
            QLog.i("IdentificationHuiyanSDKInitHelper", 1, "getEncryptContext success");
            if (eVar != null) {
                eVar.a(encryptContext);
                return;
            }
            return;
        }
        QLog.i("IdentificationHuiyanSDKInitHelper", 1, "getEncryptContext fail code=" + eIPCResult.code);
        if (eVar != null) {
            eVar.b(eIPCResult.code, q());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(h hVar) {
        if (hVar != null) {
            hVar.onFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(final h hVar, EIPCResult eIPCResult) {
        QLog.d("IdentificationHuiyanSDKInitHelper", 1, "prepareSoAndModels result " + eIPCResult.code);
        if (!eIPCResult.isSuccess()) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.identification.u
                @Override // java.lang.Runnable
                public final void run() {
                    IdentificationHuiyanSDKInitHelper.w(IdentificationHuiyanSDKInitHelper.h.this);
                }
            });
        } else {
            l(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String z(String str) {
        return str;
    }
}
