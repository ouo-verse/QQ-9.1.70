package com.tencent.mobileqq.identification;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.identification.j;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import eipc.EIPCResult;
import face.qqlogin.FaceCommon$EncryptContext;
import face.qqlogin.faceproto$Response;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes15.dex */
public class IdentificationIpcServer extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final List<String> f237896h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile IdentificationIpcServer f237897i;

    /* renamed from: d, reason: collision with root package name */
    private int f237898d;

    /* renamed from: e, reason: collision with root package name */
    private int f237899e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qqconnectface.impl.a f237900f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends com.tencent.mobileqq.observer.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f237902d;

        a(int i3) {
            this.f237902d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationIpcServer.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void ipJudgeSuccess(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("usable", z16);
            bundle.putString("msg", str);
            IdentificationIpcServer.this.callbackResult(this.f237902d, EIPCResult.createResult(0, bundle));
        }

        @Override // com.tencent.mobileqq.observer.c
        public void onFailedResponse(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("cmd", str);
            bundle.putInt("code", i3);
            bundle.putString("msg", str2);
            IdentificationIpcServer.this.callbackResult(this.f237902d, EIPCResult.createResult(-102, bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f237904d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppRuntime f237905e;

        b(int i3, AppRuntime appRuntime) {
            this.f237904d = i3;
            this.f237905e = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, IdentificationIpcServer.this, Integer.valueOf(i3), appRuntime);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (i3 == 17 && z16 && bundle != null) {
                QLog.d("IdentificationIpcServer", 1, "onReceive getAppConf");
                IdentificationIpcServer.this.callbackResult(this.f237904d, EIPCResult.createResult(0, bundle));
                return;
            }
            if (i3 != 15) {
                IdentificationIpcServer.this.callbackResult(this.f237904d, EIPCResult.createResult(-102, null));
            } else {
                IdentificationIpcServer.this.callbackResult(this.f237904d, EIPCResult.createResult(15, null));
            }
            if (i3 == 17) {
                if (bundle == null) {
                    str = "1";
                } else {
                    str = "2";
                }
                ReportController.o(this.f237905e, "dc00898", "", "", "0X8009D63", "0X8009D63", 0, 0, str, "", "", "");
                return;
            }
            QLog.e("IdentificationIpcServer", 1, "requestThirdPartyInfo unexpected error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends com.tencent.mobileqq.observer.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f237907d;

        c(int i3) {
            this.f237907d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IdentificationIpcServer.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void getEncContextSuccess(FaceCommon$EncryptContext faceCommon$EncryptContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) faceCommon$EncryptContext);
                return;
            }
            QLog.i("IdentificationIpcServer", 1, "sendGetEncContext success");
            EncryptContext encryptContext = new EncryptContext(faceCommon$EncryptContext.Method.get(), faceCommon$EncryptContext.EncryptKey.get().toByteArray(), faceCommon$EncryptContext.IV.get().toByteArray());
            if (QLog.isColorLevel()) {
                QLog.i("IdentificationIpcServer", 2, "getEncContext result = " + encryptContext);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("encContext", encryptContext);
            IdentificationIpcServer.this.callbackResult(this.f237907d, EIPCResult.createSuccessResult(bundle));
        }

        @Override // com.tencent.mobileqq.observer.c
        public void onFailedResponse(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
                return;
            }
            if ("getEncContext".equals(str)) {
                QLog.e("IdentificationIpcServer", 1, "sendGetEncContext fail, code = " + i3 + ", msg = " + str2);
                IdentificationIpcServer.this.callbackResult(this.f237907d, EIPCResult.createResult(i3, null));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20985);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f237896h = Arrays.asList("setFaceData", QCircleQualityReporter.KEY_ID, "deleteFace", "changeSecureMobile", "studyModeIdentify");
        }
    }

    IdentificationIpcServer(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    private void g(Bundle bundle, int i3) {
        if (bundle == null) {
            QLog.d("IdentificationIpcServer", 1, " params = null");
            return;
        }
        FaceConf faceConf = (FaceConf) bundle.getSerializable("faceConf");
        if (faceConf == null) {
            QLog.w("IdentificationIpcServer", 1, " faceConf is null");
            return;
        }
        if (faceConf.getPlatformAppId() != 0 && !TextUtils.isEmpty(faceConf.getKey())) {
            if (l.f237970b.contains(faceConf.getMethod()) && TextUtils.isEmpty(faceConf.getUin())) {
                QLog.d("IdentificationIpcServer", 1, "method is loginVerify but uin is empty");
                return;
            } else {
                AppRuntime appRuntime = getAppRuntime();
                o.g(appRuntime, faceConf, AppSetting.d(), new b(i3, appRuntime));
                return;
            }
        }
        QLog.d("IdentificationIpcServer", 1, " KEY_APP_ID not exist or temKey is empty");
    }

    private AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    private void h(Bundle bundle, int i3) {
        LoginVerifyServlet.e(bundle.getInt("srcAppId", 0), bundle.getString("key", ""), new c(i3));
    }

    private void i(AppRuntime appRuntime, Bundle bundle, int i3) {
        String string = bundle.getString("method", null);
        com.tencent.mobileqq.identification.c.j().e(appRuntime, bundle.getInt("srcAppId"), string, bundle.getString("uin"), new a(i3));
    }

    public static IdentificationIpcServer j() {
        if (f237897i == null) {
            synchronized (IdentificationIpcServer.class) {
                if (f237897i == null) {
                    f237897i = new IdentificationIpcServer("IdentificationIpcServer_Model");
                }
            }
        }
        return f237897i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(int i3) {
        int i16;
        IdentificationIpcServer identificationIpcServer;
        boolean z16 = true;
        QLog.i("IdentificationIpcServer", 1, "download so result " + i3);
        if (i3 == 0) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        ReportController.o(null, "dc00898", "", "", "0X800C42C", "0X800C42C", 0, i16, "", "", "", "");
        if (i3 == 0) {
            identificationIpcServer = this;
        } else {
            identificationIpcServer = this;
            z16 = false;
        }
        identificationIpcServer.n(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(int i3) {
        int i16;
        QLog.i("IdentificationIpcServer", 1, "download models result " + i3);
        if (i3 == 0) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        ReportController.o(null, "dc00898", "", "", "0X800C42A", "0X800C42A", 0, i16, "", "", "", "");
        if (i3 != 0) {
            n(false);
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800C42B", "0X800C42B", 0, 0, "", "", "", "");
            j.m().k(new j.d() { // from class: com.tencent.mobileqq.identification.ac
                @Override // com.tencent.mobileqq.identification.j.d
                public final void a(int i17) {
                    IdentificationIpcServer.this.k(i17);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i3, EIPCResult eIPCResult, int i16, byte[] bArr) {
        int i17;
        if (i16 != 0) {
            QLog.e("IdentificationIpcServer", 1, "get result error: " + i16);
            ReportController.o(getAppRuntime(), "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, "", "", i3 + "", "");
            eIPCResult.code = -102;
            Bundle bundle = new Bundle();
            bundle.putInt("ret", 209);
            bundle.putString("errMsg", HardCodeUtil.qqStr(R.string.f159571so));
            eIPCResult.data = bundle;
            callbackResult(this.f237898d, eIPCResult);
            return;
        }
        faceproto$Response faceproto_response = new faceproto$Response();
        try {
            faceproto_response.mergeFrom(bArr);
            Bundle bundle2 = new Bundle();
            int i18 = faceproto_response.Ret.get();
            bundle2.putInt("ret", i18);
            String str = faceproto_response.ErrMsg.get();
            bundle2.putString("errMsg", str);
            String str2 = faceproto_response.IDKey.get();
            bundle2.putString("idKey", str2);
            boolean z16 = faceproto_response.NeedRetry.get();
            bundle2.putBoolean("needRetry", z16);
            String str3 = faceproto_response.redirect_url.get();
            bundle2.putString("redirect_url", str3);
            Object[] objArr = new Object[2];
            try {
                objArr[0] = "upload file ret=" + i16 + ", errMsg=" + str + ", idKey=";
                objArr[1] = str2 + ", needRetry=" + z16 + ", redirectUrl=" + str3;
                QLog.d("IdentificationIpcServer", 1, objArr);
                eIPCResult.data = bundle2;
                if (i18 == 0) {
                    ReportController.o(getAppRuntime(), "dc00898", "", "", "0X80097ED", "0X80097ED", 0, 0, "", "", i3 + "", "");
                } else {
                    QLog.e("IdentificationIpcServer", 1, "request errMsg: " + i18 + ", " + str);
                    AppRuntime appRuntime = getAppRuntime();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(i3);
                    sb5.append("");
                    ReportController.o(appRuntime, "dc00898", "", "", "0X80097EE", "0X80097EE", 0, 0, "", "", sb5.toString(), i16 + "");
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
                i17 = 2;
                Object[] objArr2 = new Object[i17];
                objArr2[0] = "parse bytes error: ";
                objArr2[1] = e.getMessage();
                QLog.e("IdentificationIpcServer", 1, objArr2);
                eIPCResult.code = -102;
                Bundle bundle3 = new Bundle();
                bundle3.putString("subError", "InvalidProtocolBufferMicroException");
                bundle3.putInt("ret", 208);
                bundle3.putString("errMsg", HardCodeUtil.qqStr(R.string.f159571so));
                eIPCResult.data = bundle3;
                ReportController.o(getAppRuntime(), "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, "", "", i3 + "", "");
                callbackResult(this.f237898d, eIPCResult);
            }
        } catch (InvalidProtocolBufferMicroException e17) {
            e = e17;
            i17 = 2;
        }
        callbackResult(this.f237898d, eIPCResult);
    }

    private void n(boolean z16) {
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.code = !z16 ? 1 : 0;
        callbackResult(this.f237899e, eIPCResult);
        QLog.d("IdentificationIpcServer", 1, "downloadFinish download result = " + z16);
    }

    private void o(Bundle bundle, int i3) {
        String string = bundle.getString("report");
        if (string != null && !string.isEmpty()) {
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).feEnvReport((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), bundle.getString("tmpKey"), string, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Bundle bundle) {
        QLog.d("IdentificationIpcServer", 1, "start upload file");
        byte[] byteArray = bundle.getByteArray("protoByte");
        final EIPCResult eIPCResult = new EIPCResult();
        Bundle bundle2 = new Bundle();
        eIPCResult.data = bundle2;
        final int i3 = bundle.getInt("srcAppId", 0);
        if (byteArray == null) {
            eIPCResult.code = -102;
            bundle2.putBoolean("reset_null", true);
            callbackResult(this.f237898d, eIPCResult);
        }
        try {
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).sendRequest((AppInterface) getAppRuntime(), "FaceGetRecognitionResult", byteArray, new com.tencent.mobileqq.dt.api.a() { // from class: com.tencent.mobileqq.identification.aa
                @Override // com.tencent.mobileqq.dt.api.a
                public final void onResult(int i16, byte[] bArr) {
                    IdentificationIpcServer.this.m(i3, eIPCResult, i16, bArr);
                }
            });
        } catch (Exception e16) {
            QLog.e("IdentificationIpcServer", 1, "get result error: " + e16);
            eIPCResult.code = -102;
            bundle2.putBoolean("reset_null", true);
            bundle2.putString("subError", "get result error:" + e16);
            callbackResult(this.f237898d, eIPCResult);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d("IdentificationIpcServer", 1, "start download HuiYan res");
        ReportController.o(null, "dc00898", "", "", "0X800C429", "0X800C429", 0, 0, "", "", "", "");
        j.m().j(new j.d() { // from class: com.tencent.mobileqq.identification.ab
            @Override // com.tencent.mobileqq.identification.j.d
            public final void a(int i3) {
                IdentificationIpcServer.this.l(i3);
            }
        });
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        this.f237898d = i3;
        if (QLog.isColorLevel()) {
            QLog.d("IdentificationIpcServer", 2, "onCall, params=" + bundle + ", action=" + str + ", callBackId=" + i3);
        }
        if ("action_upload".equals(str)) {
            if (bundle == null) {
                QLog.d("IdentificationIpcServer", 1, "onCall, param is null, action=" + str + ", callBackId=" + i3);
                Bundle bundle2 = new Bundle();
                bundle2.putString("subError", "no params");
                bundle2.putBoolean("reset_null", true);
                callbackResult(i3, EIPCResult.createResult(-102, bundle2));
                return null;
            }
            ThreadManagerV2.excute(new Runnable(bundle) { // from class: com.tencent.mobileqq.identification.IdentificationIpcServer.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bundle f237901d;

                {
                    this.f237901d = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IdentificationIpcServer.this, (Object) bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        IdentificationIpcServer.this.p(this.f237901d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 128, null, false);
        } else {
            if ("action_is_video_chatting".equals(str)) {
                AppRuntime appRuntime = getAppRuntime();
                if (this.f237900f == null) {
                    this.f237900f = new com.tencent.mobileqq.qqconnectface.impl.a();
                }
                EIPCResult eIPCResult = new EIPCResult();
                if (!this.f237900f.isVideoChatting(appRuntime)) {
                    i16 = 2;
                }
                eIPCResult.code = i16;
                return eIPCResult;
            }
            if ("action_res_download".equals(str)) {
                this.f237899e = i3;
                f();
                return null;
            }
            if ("action_face_usable".equals(str)) {
                i(getAppRuntime(), bundle, i3);
            } else if ("action_app_conf".equals(str)) {
                g(bundle, i3);
            } else if ("action_get_enc_context".equals(str)) {
                h(bundle, i3);
            } else if ("action_report".equals(str)) {
                o(bundle, i3);
            }
        }
        return null;
    }
}
