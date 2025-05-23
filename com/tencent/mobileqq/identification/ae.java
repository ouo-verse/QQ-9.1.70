package com.tencent.mobileqq.identification;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import face.qqlogin.FaceCommon$UserInfo;
import face.qqlogin.faceproto$App;
import face.qqlogin.faceproto$FaceInfo;
import face.qqlogin.faceproto$Request;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ae {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final b f237917a;

    /* renamed from: b, reason: collision with root package name */
    private String f237918b;

    /* renamed from: c, reason: collision with root package name */
    private final int f237919c;

    /* renamed from: d, reason: collision with root package name */
    private final int f237920d;

    /* renamed from: e, reason: collision with root package name */
    private String f237921e;

    /* renamed from: f, reason: collision with root package name */
    private String f237922f;

    /* renamed from: g, reason: collision with root package name */
    private String f237923g;

    /* renamed from: h, reason: collision with root package name */
    private String f237924h;

    /* renamed from: i, reason: collision with root package name */
    private final String f237925i;

    /* renamed from: j, reason: collision with root package name */
    private final String f237926j;

    /* renamed from: k, reason: collision with root package name */
    private final String f237927k;

    /* renamed from: l, reason: collision with root package name */
    private final int f237928l;

    /* renamed from: m, reason: collision with root package name */
    private String f237929m;

    /* renamed from: n, reason: collision with root package name */
    private int f237930n;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f237931o;

    /* renamed from: p, reason: collision with root package name */
    private byte[] f237932p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ae.this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ae.this.d(eIPCResult);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void a(int i3, Bundle bundle);
    }

    public ae(FaceConf faceConf, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) faceConf, (Object) bVar);
            return;
        }
        this.f237919c = faceConf.getPlatformAppId();
        this.f237920d = faceConf.getAppId();
        this.f237921e = faceConf.getOpenId();
        this.f237922f = faceConf.getIdNum();
        this.f237923g = faceConf.getName();
        this.f237924h = faceConf.getKey();
        this.f237925i = faceConf.getMethod();
        this.f237926j = faceConf.getUin();
        this.f237927k = faceConf.getTicket();
        this.f237928l = faceConf.getServiceType();
        AppConf appConf = faceConf.getAppConf();
        if (appConf != null) {
            this.f237918b = appConf.session;
            this.f237929m = appConf.huiyanSdkToken;
        } else {
            QLog.e("IdentificationResultCheckHelper", 1, "appConf is null");
        }
        EncryptContext encryptContext = faceConf.getEncryptContext();
        if (encryptContext != null) {
            this.f237930n = encryptContext.method;
            this.f237931o = encryptContext.encryptKey;
            this.f237932p = encryptContext.f237889iv;
        } else {
            QLog.e("IdentificationResultCheckHelper", 1, "encryptContext is null");
        }
        String str = this.f237921e;
        this.f237921e = str == null ? "" : str;
        String str2 = this.f237922f;
        this.f237922f = str2 == null ? "" : str2;
        String str3 = this.f237923g;
        this.f237923g = str3 == null ? "" : str3;
        String str4 = this.f237924h;
        this.f237924h = str4 == null ? "" : str4;
        String str5 = this.f237918b;
        this.f237918b = str5 == null ? "" : str5;
        String str6 = this.f237929m;
        this.f237929m = str6 != null ? str6 : "";
        this.f237917a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Bundle bundle) {
        QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_upload", bundle, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(EIPCResult eIPCResult) {
        QLog.d("IdentificationResultCheckHelper", 1, "onIdentificationResponse");
        int i3 = eIPCResult.code;
        if (i3 != -102) {
            if (i3 == 0) {
                this.f237917a.a(1, eIPCResult.data);
            }
        } else {
            this.f237917a.a(2, eIPCResult.data);
        }
        ReportController.o(null, "dc00898", "", "", "0X800AC2D", "0X800AC2D", 0, 0, "", "", "", "");
    }

    private faceproto$Request e(String str) {
        QLog.d("IdentificationResultCheckHelper", 1, "packLightData method=" + this.f237925i);
        faceproto$Request faceproto_request = new faceproto$Request();
        faceproto_request.AppID.set(this.f237919c);
        faceproto_request.TmpKey.set(this.f237924h);
        faceproto$App faceproto_app = new faceproto$App();
        faceproto_app.AppID.set(this.f237920d);
        faceproto_app.OpenID.set(this.f237921e);
        faceproto_request.SrcApp.set(faceproto_app);
        FaceCommon$UserInfo faceCommon$UserInfo = new FaceCommon$UserInfo();
        faceCommon$UserInfo.IDCardNumber.set(this.f237922f);
        faceCommon$UserInfo.Name.set(this.f237923g);
        faceproto$FaceInfo faceproto_faceinfo = new faceproto$FaceInfo();
        faceproto_faceinfo.RecMode.set(4);
        faceproto_request.Session.set(str);
        g(faceproto_request, faceCommon$UserInfo, faceproto_faceinfo);
        return faceproto_request;
    }

    private void g(faceproto$Request faceproto_request, FaceCommon$UserInfo faceCommon$UserInfo, faceproto$FaceInfo faceproto_faceinfo) {
        ByteStringMicro byteStringMicro;
        ByteStringMicro byteStringMicro2;
        QLog.d("IdentificationResultCheckHelper", 4, "encryptContextMethod=" + this.f237930n + " userInfo=" + faceCommon$UserInfo + " faceInfo=" + faceproto_faceinfo);
        byte[] byteArray = faceCommon$UserInfo.toByteArray();
        byte[] byteArray2 = faceproto_faceinfo.toByteArray();
        if (this.f237930n == 3) {
            byteArray = com.tencent.mobileqq.util.y.a(byteArray, this.f237931o, this.f237932p);
            byteArray2 = com.tencent.mobileqq.util.y.a(byteArray2, this.f237931o, this.f237932p);
        }
        if (byteArray != null) {
            byteStringMicro = ByteStringMicro.copyFrom(byteArray);
        } else {
            byteStringMicro = ByteStringMicro.EMPTY;
            QLog.e("IdentificationResultCheckHelper", 1, "userInfoByte is null");
        }
        faceproto_request.EncUserInfo.set(byteStringMicro);
        if (byteArray2 != null) {
            byteStringMicro2 = ByteStringMicro.copyFrom(byteArray2);
        } else {
            byteStringMicro2 = ByteStringMicro.EMPTY;
            QLog.e("IdentificationResultCheckHelper", 1, "faceInfoByte is null");
        }
        faceproto_request.EncFaceInfo.set(byteStringMicro2);
    }

    private void h(final Bundle bundle) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.identification.ad
            @Override // java.lang.Runnable
            public final void run() {
                ae.this.c(bundle);
            }
        }, 128, null, true);
    }

    public void f() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        faceproto$Request e16 = e(this.f237918b);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = "";
        }
        QLog.d("IdentificationResultCheckHelper", 1, "start pack request Uin=" + this.f237926j + " currentUin=" + str + " huiyanSdkToken=" + this.f237929m);
        Bundle bundle = new Bundle();
        bundle.putByteArray("protoByte", e16.toByteArray());
        bundle.putInt("srcAppId", this.f237920d);
        bundle.putInt("serviceType", this.f237928l);
        bundle.putString("method", this.f237925i);
        bundle.putString("uin", this.f237926j);
        bundle.putString("ticket", this.f237927k);
        bundle.putInt("key_identification_type", 4);
        h(bundle);
    }
}
