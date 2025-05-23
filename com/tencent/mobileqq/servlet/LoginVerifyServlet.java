package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe96$ReqBody;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe9a$ReqBody;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.av;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import face.FaceForeignIp$AvailableRequest;
import face.qqlogin.FaceSecureCheck$SecureCheckRequest;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$ReqBody;
import tencent.im.oidb.oidb_0x5e1$ReqBody;
import tencent.im.oidb.oidb_0x87a$ReqBody;
import tencent.im.oidb.oidb_0x87c$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LoginVerifyServlet extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static AtomicInteger f286421d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessObserver f286432a;

        a(BusinessObserver businessObserver) {
            this.f286432a = businessObserver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) businessObserver);
            }
        }

        @Override // com.tencent.mobileqq.servlet.LoginVerifyServlet.e
        public void onFailure(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.e("LoginVerifyServlet", 1, "sendGetTmpKeyRequest failed code=" + i3 + " errorMSg" + str);
            Bundle bundle = new Bundle();
            bundle.putString(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_MSG, str);
            bundle.putInt(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_CODE, i3);
            this.f286432a.onReceive(0, false, bundle);
        }

        @Override // com.tencent.mobileqq.servlet.LoginVerifyServlet.e
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.d("LoginVerifyServlet", 1, "sendGetTmpKeyRequest success content=" + str);
            Bundle bundle = new Bundle();
            bundle.putByteArray("data", str.getBytes());
            bundle.putString("cmd", "getTmpkey");
            this.f286432a.onReceive(0, true, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessObserver f286433a;

        b(BusinessObserver businessObserver) {
            this.f286433a = businessObserver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) businessObserver);
            }
        }

        @Override // com.tencent.mobileqq.servlet.LoginVerifyServlet.e
        public void onFailure(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.e("LoginVerifyServlet", 1, "sendGetEncContext failed code=" + i3 + " msg=" + str);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", "getEncContext");
            bundle.putInt(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_CODE, i3);
            bundle.putString(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_MSG, str);
            BusinessObserver businessObserver = this.f286433a;
            if (businessObserver != null) {
                businessObserver.onReceive(0, false, bundle);
            }
        }

        @Override // com.tencent.mobileqq.servlet.LoginVerifyServlet.e
        public void onSuccess(String str) {
            byte[] bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.d("LoginVerifyServlet", 1, "sendGetEncContext success content=" + str);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", "getEncContext");
            if (str != null) {
                bArr = str.getBytes();
            } else {
                bArr = null;
            }
            bundle.putByteArray("data", bArr);
            this.f286433a.onReceive(0, true, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessObserver f286434a;

        c(BusinessObserver businessObserver) {
            this.f286434a = businessObserver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) businessObserver);
            }
        }

        @Override // com.tencent.mobileqq.servlet.LoginVerifyServlet.e
        public void onFailure(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_MSG, str);
            bundle.putInt(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_CODE, i3);
            this.f286434a.onReceive(0, false, bundle);
        }

        @Override // com.tencent.mobileqq.servlet.LoginVerifyServlet.e
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putByteArray("data", str.getBytes());
            bundle.putString("cmd", "isIpForeign");
            this.f286434a.onReceive(0, true, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BusinessObserver f286435a;

        d(BusinessObserver businessObserver) {
            this.f286435a = businessObserver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) businessObserver);
            }
        }

        @Override // com.tencent.mobileqq.servlet.LoginVerifyServlet.e
        public void onFailure(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.e("LoginVerifyServlet", 1, "sendIpLocationRequest failed code=" + i3 + " msg=" + str);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", "https://graph.qq.com/face/get_region_code");
            bundle.putInt(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_CODE, i3);
            bundle.putString(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_MSG, str);
            BusinessObserver businessObserver = this.f286435a;
            if (businessObserver != null) {
                businessObserver.onReceive(0, false, bundle);
            }
        }

        @Override // com.tencent.mobileqq.servlet.LoginVerifyServlet.e
        public void onSuccess(String str) {
            byte[] bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.d("LoginVerifyServlet", 1, "sendIpLocationRequest success content=" + str);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", "https://graph.qq.com/face/get_region_code");
            if (str != null) {
                bArr = str.getBytes();
            } else {
                bArr = null;
            }
            bundle.putByteArray("data", bArr);
            this.f286435a.onReceive(0, true, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        void onFailure(int i3, String str);

        void onSuccess(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43558);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f286421d = new AtomicInteger(0);
        }
    }

    public LoginVerifyServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(AppRuntime appRuntime, BusinessObserver businessObserver) {
        o(appRuntime, 3734, "OidbSvc.0xe96_0", 0, new MessageMicro<oidb_0xe96$ReqBody>() { // from class: com.tencent.mobileqq.troop.org.pb.oidb_0xe96$ReqBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xe96$ReqBody.class);
        }.toByteArray(), businessObserver);
    }

    public static void b(AppRuntime appRuntime, int i3, BusinessObserver businessObserver) {
        oidb_0xe9a$ReqBody oidb_0xe9a_reqbody = new oidb_0xe9a$ReqBody();
        oidb_0xe9a_reqbody.uint32_use_status.set(i3);
        o(appRuntime, 3738, "OidbSvc.0xe9a_0", 0, oidb_0xe9a_reqbody.toByteArray(), businessObserver);
    }

    public static void c(AppRuntime appRuntime, com.tencent.mobileqq.observer.c cVar) {
        o(appRuntime, 2478, "OidbSvc.0x9ae_13", 13, new cmd0x9ae$ReqBody().toByteArray(), cVar);
    }

    public static void d(AppRuntime appRuntime, String str, com.tencent.mobileqq.observer.c cVar) {
        FaceSecureCheck$SecureCheckRequest faceSecureCheck$SecureCheckRequest = new FaceSecureCheck$SecureCheckRequest();
        String a16 = av.a(BaseApplication.getContext());
        if (a16 != null) {
            faceSecureCheck$SecureCheckRequest.bytes_client_addr.set(ByteStringMicro.copyFrom(a16.getBytes()));
        } else {
            QLog.e("LoginVerifyServlet", 1, "getIpAddress error");
            faceSecureCheck$SecureCheckRequest.bytes_client_addr.set(ByteStringMicro.copyFrom("0.0.0.0".getBytes()));
        }
        faceSecureCheck$SecureCheckRequest.uint32_client_addr.set(0);
        byte[] c16 = com.tencent.mobileqq.guid.c.f213821a.c();
        if (c16 != null) {
            faceSecureCheck$SecureCheckRequest.bytes_guid.set(ByteStringMicro.copyFrom(c16));
        } else {
            QLog.e("LoginVerifyServlet", 1, "guid is null");
        }
        faceSecureCheck$SecureCheckRequest.uint32_seq.set(f286421d.addAndGet(1));
        faceSecureCheck$SecureCheckRequest.uint32_timestamp.set((int) (System.currentTimeMillis() / 1000));
        faceSecureCheck$SecureCheckRequest.uint32_version.set(AppSetting.f());
        faceSecureCheck$SecureCheckRequest.uint64_appid.set(101810106L);
        faceSecureCheck$SecureCheckRequest.uint64_nonce.set(new Random().nextLong());
        byte[] byteArray = faceSecureCheck$SecureCheckRequest.toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        NewIntent newIntent = new NewIntent(appRuntime.getApp(), LoginVerifyServlet.class);
        newIntent.setObserver(cVar);
        newIntent.putExtra("cmd", "FaceRecognition.SecureCheck");
        newIntent.putExtra("data", byteArray);
        appRuntime.startServlet(newIntent);
    }

    public static void e(int i3, String str, BusinessObserver businessObserver) {
        k("https://graph.qq.com/face/get_enc_context", "application/x-www-form-urlencoded", "appid=" + i3 + "&tmpkey=" + URLEncoder.encode(str), new b(businessObserver));
    }

    public static void f(int i3, String str, String str2, String str3, String str4, BusinessObserver businessObserver) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", i3);
            jSONObject.put("key_type", str2);
            jSONObject.put("key", str3);
            jSONObject.put("uin", str);
            jSONObject.put("from", str4);
            jSONObject.put("nonce", Math.abs(new Random(System.currentTimeMillis()).nextLong()));
            k("https://graph.qq.com/face/if_proxy", "application/json", jSONObject.toString(), new a(businessObserver));
        } catch (JSONException e16) {
            QLog.e("LoginVerifyServlet", 1, "sendGetTmpKey JSONException : " + e16.getMessage());
        }
    }

    public static void g(int i3, String str, String str2, String str3, BusinessObserver businessObserver) {
        f(i3, str, str2, str3, "guard", businessObserver);
    }

    public static void h(AppRuntime appRuntime, String str, BusinessObserver businessObserver) {
        try {
            oidb_0x5e1$ReqBody oidb_0x5e1_reqbody = new oidb_0x5e1$ReqBody();
            oidb_0x5e1_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(str)));
            oidb_0x5e1_reqbody.user_login_guard_face.set(1);
            o(appRuntime, 1505, "OidbSvc.0x5e1_295", 295, oidb_0x5e1_reqbody.toByteArray(), businessObserver);
        } catch (Exception e16) {
            QLog.e("LoginVerifyServlet", 1, "sendGetUserFaceStateRequest error : " + e16.getMessage());
        }
    }

    public static void i(int i3, byte[] bArr, long j3, BusinessObserver businessObserver) {
        try {
            FaceForeignIp$AvailableRequest faceForeignIp$AvailableRequest = new FaceForeignIp$AvailableRequest();
            faceForeignIp$AvailableRequest.appID.set(i3);
            faceForeignIp$AvailableRequest.f398124ip.set(ByteStringMicro.copyFrom(bArr));
            faceForeignIp$AvailableRequest.uin.set(j3);
            String encodeToString = Base64.encodeToString(faceForeignIp$AvailableRequest.toByteArray(), 11);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("available_req", encodeToString);
            j("https://graph.qq.com/face/available", "application/json", jSONObject.toString(), 2000, 2000, new c(businessObserver));
        } catch (Exception e16) {
            QLog.e("LoginVerifyServlet", 1, "sendHTTPSIpForeignJudgeRequest error : ", e16.getMessage());
            Bundle bundle = new Bundle();
            bundle.putString(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_MSG, e16.getMessage());
            bundle.putInt(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_CODE, -1);
            businessObserver.onReceive(0, false, bundle);
        }
    }

    private static void j(String str, String str2, String str3, int i3, int i16, e eVar) {
        ThreadManagerV2.getNetExcutor().execute(new Runnable(str, i3, i16, str2, str3, eVar) { // from class: com.tencent.mobileqq.servlet.LoginVerifyServlet.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f286422d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f286423e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f286424f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f286425h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f286426i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ e f286427m;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.servlet.LoginVerifyServlet$5$a */
            /* loaded from: classes18.dex */
            class a implements HostnameVerifier {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ URL f286430a;

                a(URL url) {
                    this.f286430a = url;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) url);
                    }
                }

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) sSLSession)).booleanValue();
                    }
                    boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f286430a.getHost(), sSLSession);
                    if (!verify) {
                        QLog.d("LoginVerifyServlet", 1, "OpenVirtual.HostnameVerifier.host:", this.f286430a.getHost(), ",address:", sSLSession.getPeerHost(), ",isverify:", Boolean.valueOf(verify));
                    }
                    return verify;
                }
            }

            {
                this.f286422d = str;
                this.f286423e = i3;
                this.f286424f = i16;
                this.f286425h = str2;
                this.f286426i = str3;
                this.f286427m = eVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, str3, eVar);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:37:0x01ca  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x0190  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x01e6  */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v1 */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v12 */
            /* JADX WARN: Type inference failed for: r1v13 */
            /* JADX WARN: Type inference failed for: r1v14 */
            /* JADX WARN: Type inference failed for: r1v15 */
            /* JADX WARN: Type inference failed for: r1v16 */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v23, types: [java.io.OutputStream, java.io.Closeable] */
            /* JADX WARN: Type inference failed for: r1v25 */
            /* JADX WARN: Type inference failed for: r1v26 */
            /* JADX WARN: Type inference failed for: r1v27 */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
            /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable] */
            /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
            /* JADX WARN: Type inference failed for: r6v1 */
            /* JADX WARN: Type inference failed for: r6v10 */
            /* JADX WARN: Type inference failed for: r6v2 */
            /* JADX WARN: Type inference failed for: r6v23 */
            /* JADX WARN: Type inference failed for: r6v24 */
            /* JADX WARN: Type inference failed for: r6v25, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
            /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
            /* JADX WARN: Type inference failed for: r6v9 */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayOutputStream byteArrayOutputStream2;
                HttpsURLConnection httpsURLConnection;
                ?? r65;
                MqqHandler uIHandler;
                Runnable runnable;
                URL url;
                ?? r16 = "_";
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z16 = false;
                Closeable closeable = null;
                boolean z17 = false;
                try {
                    try {
                        url = new URL(this.f286422d);
                        a aVar = new a(url);
                        httpsURLConnection = (HttpsURLConnection) url.openConnection();
                        try {
                            httpsURLConnection.setHostnameVerifier(aVar);
                            httpsURLConnection.setConnectTimeout(this.f286423e);
                            httpsURLConnection.setReadTimeout(this.f286424f);
                            httpsURLConnection.setDoOutput(true);
                            httpsURLConnection.setDoInput(true);
                            httpsURLConnection.setUseCaches(false);
                            httpsURLConnection.setRequestMethod("POST");
                            httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                            StringBuilder sb5 = new StringBuilder("android");
                            sb5.append("_");
                            sb5.append(Build.VERSION.SDK);
                            sb5.append("_");
                            sb5.append(Build.DEVICE);
                            sb5.append("_");
                            sb5.append(Build.VERSION.RELEASE);
                            sb5.append("_");
                            String str4 = AppSetting.f99551k;
                            sb5.append(str4);
                            sb5.append("_");
                            sb5.append("QQ/");
                            sb5.append(str4 + AppSetting.f99542b);
                            httpsURLConnection.setRequestProperty("User-Agent", sb5.toString());
                            httpsURLConnection.setRequestProperty("Accept", "*/*");
                            httpsURLConnection.setRequestProperty("Content-Type", this.f286425h);
                            r16 = httpsURLConnection.getOutputStream();
                        } catch (MalformedURLException e16) {
                            e = e16;
                            r16 = 0;
                            byteArrayOutputStream = null;
                        } catch (IOException e17) {
                            e = e17;
                            r16 = 0;
                            byteArrayOutputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            r16 = 0;
                            byteArrayOutputStream = null;
                        }
                    } catch (MalformedURLException e18) {
                        e = e18;
                        r16 = 0;
                        byteArrayOutputStream = null;
                        r65 = 0;
                        httpsURLConnection = null;
                    } catch (IOException e19) {
                        e = e19;
                        r16 = 0;
                        byteArrayOutputStream = null;
                        r65 = 0;
                        httpsURLConnection = null;
                    } catch (Throwable th6) {
                        th = th6;
                        r16 = 0;
                        byteArrayOutputStream = null;
                        byteArrayOutputStream2 = null;
                        httpsURLConnection = null;
                    }
                    try {
                        r16.write(this.f286426i.getBytes());
                        r16.flush();
                        httpsURLConnection.connect();
                        int responseCode = httpsURLConnection.getResponseCode();
                        String responseMessage = httpsURLConnection.getResponseMessage();
                        QLog.d("LoginVerifyServlet", 1, "code : " + responseCode + " message : " + responseMessage + " url : " + url);
                        if (responseCode == 200) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                r65 = httpsURLConnection.getInputStream();
                            } catch (MalformedURLException e26) {
                                e = e26;
                                r65 = 0;
                            } catch (IOException e27) {
                                e = e27;
                                r65 = 0;
                            } catch (Throwable th7) {
                                th = th7;
                                byteArrayOutputStream2 = null;
                                Utils.j(r16);
                                Utils.j(byteArrayOutputStream2);
                                Utils.j(byteArrayOutputStream);
                                if (httpsURLConnection != null) {
                                }
                                ThreadManager.getUIHandler().post(new Runnable(z16, z17 ? 1 : 0) { // from class: com.tencent.mobileqq.servlet.LoginVerifyServlet.5.2
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ boolean f286428d;

                                    /* renamed from: e, reason: collision with root package name */
                                    final /* synthetic */ String f286429e;

                                    {
                                        this.f286428d = z16;
                                        this.f286429e = r7;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, Boolean.valueOf(z16), r7);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else if (this.f286428d) {
                                            AnonymousClass5.this.f286427m.onSuccess(this.f286429e);
                                        } else {
                                            AnonymousClass5.this.f286427m.onFailure(-1, this.f286429e);
                                        }
                                    }
                                });
                                throw th;
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = r65.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    }
                                }
                                z16 = true;
                                closeable = r65;
                                responseMessage = new String(byteArrayOutputStream.toByteArray());
                            } catch (MalformedURLException e28) {
                                e = e28;
                                String message = e.getMessage();
                                QLog.e("LoginVerifyServlet", 1, "get AppConfig MalformedURLException : " + e.getMessage());
                                Utils.j(r16);
                                Utils.j(r65);
                                Utils.j(byteArrayOutputStream);
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                uIHandler = ThreadManager.getUIHandler();
                                runnable = new Runnable(z16, message) { // from class: com.tencent.mobileqq.servlet.LoginVerifyServlet.5.2
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ boolean f286428d;

                                    /* renamed from: e, reason: collision with root package name */
                                    final /* synthetic */ String f286429e;

                                    {
                                        this.f286428d = z16;
                                        this.f286429e = message;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, Boolean.valueOf(z16), message);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else if (this.f286428d) {
                                            AnonymousClass5.this.f286427m.onSuccess(this.f286429e);
                                        } else {
                                            AnonymousClass5.this.f286427m.onFailure(-1, this.f286429e);
                                        }
                                    }
                                };
                                uIHandler.post(runnable);
                            } catch (IOException e29) {
                                e = e29;
                                String message2 = e.getMessage();
                                QLog.e("LoginVerifyServlet", 1, "get AppConfig IOException : " + e.getMessage());
                                Utils.j(r16);
                                Utils.j(r65);
                                Utils.j(byteArrayOutputStream);
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                uIHandler = ThreadManager.getUIHandler();
                                runnable = new Runnable(z16, message2) { // from class: com.tencent.mobileqq.servlet.LoginVerifyServlet.5.2
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ boolean f286428d;

                                    /* renamed from: e, reason: collision with root package name */
                                    final /* synthetic */ String f286429e;

                                    {
                                        this.f286428d = z16;
                                        this.f286429e = message2;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, Boolean.valueOf(z16), message2);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else if (this.f286428d) {
                                            AnonymousClass5.this.f286427m.onSuccess(this.f286429e);
                                        } else {
                                            AnonymousClass5.this.f286427m.onFailure(-1, this.f286429e);
                                        }
                                    }
                                };
                                uIHandler.post(runnable);
                            }
                        } else {
                            byteArrayOutputStream = null;
                        }
                        Utils.j(r16);
                        Utils.j(closeable);
                        Utils.j(byteArrayOutputStream);
                        httpsURLConnection.disconnect();
                        uIHandler = ThreadManager.getUIHandler();
                        runnable = new Runnable(z16, responseMessage) { // from class: com.tencent.mobileqq.servlet.LoginVerifyServlet.5.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f286428d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String f286429e;

                            {
                                this.f286428d = z16;
                                this.f286429e = responseMessage;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, Boolean.valueOf(z16), responseMessage);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else if (this.f286428d) {
                                    AnonymousClass5.this.f286427m.onSuccess(this.f286429e);
                                } else {
                                    AnonymousClass5.this.f286427m.onFailure(-1, this.f286429e);
                                }
                            }
                        };
                    } catch (MalformedURLException e36) {
                        e = e36;
                        byteArrayOutputStream = null;
                        r16 = r16;
                        r65 = byteArrayOutputStream;
                        String message3 = e.getMessage();
                        QLog.e("LoginVerifyServlet", 1, "get AppConfig MalformedURLException : " + e.getMessage());
                        Utils.j(r16);
                        Utils.j(r65);
                        Utils.j(byteArrayOutputStream);
                        if (httpsURLConnection != null) {
                        }
                        uIHandler = ThreadManager.getUIHandler();
                        runnable = new Runnable(z16, message3) { // from class: com.tencent.mobileqq.servlet.LoginVerifyServlet.5.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f286428d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String f286429e;

                            {
                                this.f286428d = z16;
                                this.f286429e = message3;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, Boolean.valueOf(z16), message3);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else if (this.f286428d) {
                                    AnonymousClass5.this.f286427m.onSuccess(this.f286429e);
                                } else {
                                    AnonymousClass5.this.f286427m.onFailure(-1, this.f286429e);
                                }
                            }
                        };
                        uIHandler.post(runnable);
                    } catch (IOException e37) {
                        e = e37;
                        byteArrayOutputStream = null;
                        r16 = r16;
                        r65 = byteArrayOutputStream;
                        String message22 = e.getMessage();
                        QLog.e("LoginVerifyServlet", 1, "get AppConfig IOException : " + e.getMessage());
                        Utils.j(r16);
                        Utils.j(r65);
                        Utils.j(byteArrayOutputStream);
                        if (httpsURLConnection != null) {
                        }
                        uIHandler = ThreadManager.getUIHandler();
                        runnable = new Runnable(z16, message22) { // from class: com.tencent.mobileqq.servlet.LoginVerifyServlet.5.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f286428d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String f286429e;

                            {
                                this.f286428d = z16;
                                this.f286429e = message22;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, Boolean.valueOf(z16), message22);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else if (this.f286428d) {
                                    AnonymousClass5.this.f286427m.onSuccess(this.f286429e);
                                } else {
                                    AnonymousClass5.this.f286427m.onFailure(-1, this.f286429e);
                                }
                            }
                        };
                        uIHandler.post(runnable);
                    } catch (Throwable th8) {
                        th = th8;
                        byteArrayOutputStream = null;
                        r16 = r16;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        Utils.j(r16);
                        Utils.j(byteArrayOutputStream2);
                        Utils.j(byteArrayOutputStream);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        ThreadManager.getUIHandler().post(new Runnable(z16, z17 ? 1 : 0) { // from class: com.tencent.mobileqq.servlet.LoginVerifyServlet.5.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f286428d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String f286429e;

                            {
                                this.f286428d = z16;
                                this.f286429e = message22;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, Boolean.valueOf(z16), message22);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else if (this.f286428d) {
                                    AnonymousClass5.this.f286427m.onSuccess(this.f286429e);
                                } else {
                                    AnonymousClass5.this.f286427m.onFailure(-1, this.f286429e);
                                }
                            }
                        });
                        throw th;
                    }
                    uIHandler.post(runnable);
                } catch (Throwable th9) {
                    th = th9;
                }
            }
        });
    }

    private static void k(String str, String str2, String str3, e eVar) {
        j(str, str2, str3, 10000, 30000, eVar);
    }

    public static void l(int i3, BusinessObserver businessObserver) {
        try {
            QLog.d("LoginVerifyServlet", 1, "fromscene = " + i3);
            k("https://graph.qq.com/face/get_region_code", "application/x-www-form-urlencoded", "fromscene=" + i3, new d(businessObserver));
        } catch (Exception e16) {
            QLog.e("LoginVerifyServlet", 1, "sendIpLocationRequest error : ", e16.getMessage());
        }
    }

    public static void m(AppRuntime appRuntime, com.tencent.mobileqq.observer.c cVar) {
        o(appRuntime, 2478, "OidbSvc.0x9ae_15", 15, new cmd0x9ae$ReqBody().toByteArray(), cVar);
    }

    public static void n(AppRuntime appRuntime, com.tencent.mobileqq.observer.c cVar) {
        o(appRuntime, 2478, "OidbSvc.0x9ae_14", 14, new cmd0x9ae$ReqBody().toByteArray(), cVar);
    }

    private static void o(AppRuntime appRuntime, int i3, String str, int i16, byte[] bArr, BusinessObserver businessObserver) {
        if (appRuntime == null) {
            QLog.e("LoginVerifyServlet", 1, "sendRequest QQAppInterface is null, command is " + str);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        NewIntent newIntent = new NewIntent(appRuntime.getApp(), LoginVerifyServlet.class);
        newIntent.setObserver(businessObserver);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        appRuntime.startServlet(newIntent);
    }

    public static void p(AppRuntime appRuntime, int i3, BusinessObserver businessObserver) {
        try {
            FaceForeignIp$AvailableRequest faceForeignIp$AvailableRequest = new FaceForeignIp$AvailableRequest();
            faceForeignIp$AvailableRequest.appID.set(i3);
            q(appRuntime, "FaceRecognition.Available", faceForeignIp$AvailableRequest.toByteArray(), 2000L, businessObserver);
        } catch (Exception e16) {
            QLog.e("LoginVerifyServlet", 1, "sendSSOIpForeignJudgeRequest error : ", e16.getMessage());
            Bundle bundle = new Bundle();
            bundle.putString(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_MSG, e16.getMessage());
            bundle.putInt(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_CODE, -1);
            businessObserver.onReceive(0, false, bundle);
        }
    }

    private static void q(AppRuntime appRuntime, String str, byte[] bArr, long j3, BusinessObserver businessObserver) {
        if (appRuntime == null) {
            QLog.e("LoginVerifyServlet", 1, "sendRequest AppRuntime is null, command is ", str);
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 4);
        allocate.putInt(bArr.length + 4);
        allocate.put(bArr);
        NewIntent newIntent = new NewIntent(appRuntime.getApp(), LoginVerifyServlet.class);
        newIntent.setObserver(businessObserver);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", bArr);
        if (j3 > 0) {
            newIntent.putExtra("timeout", j3);
        }
        appRuntime.startServlet(newIntent);
    }

    public static void r(AppRuntime appRuntime, BusinessObserver businessObserver) {
        oidb_0x87a$ReqBody oidb_0x87a_reqbody = new oidb_0x87a$ReqBody();
        oidb_0x87a_reqbody.enum_butype.set(1);
        o(appRuntime, 2170, "OidbSvc.0x87a_108", 108, oidb_0x87a_reqbody.toByteArray(), businessObserver);
    }

    public static void s(AppRuntime appRuntime, String str, BusinessObserver businessObserver) {
        oidb_0x87c$ReqBody oidb_0x87c_reqbody = new oidb_0x87c$ReqBody();
        oidb_0x87c_reqbody.str_sms_code.set(str);
        oidb_0x87c_reqbody.enum_butype.set(1);
        o(appRuntime, 2172, "OidbSvc.0x87c_108", 108, oidb_0x87c_reqbody.toByteArray(), businessObserver);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("LoginVerifyServlet", 2, "onReceive");
        }
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        Bundle bundle = extras;
        if (fromServiceMsg.isSuccess()) {
            bArr = fh.a(fromServiceMsg.getWupBuffer());
        } else {
            bundle.putString(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_MSG, fromServiceMsg.getBusinessFailMsg());
            bundle.putInt(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_CODE, fromServiceMsg.getBusinessFailCode());
            bArr = null;
        }
        bundle.putByteArray("data", bArr);
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
        if (QLog.isColorLevel()) {
            QLog.i("LoginVerifyServlet", 2, "onReceive exit");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("cmd");
        long longExtra = intent.getLongExtra("timeout", 0L);
        QLog.i("LoginVerifyServlet", 1, "onSend, cmd is " + stringExtra);
        packet.setSSOCommand(stringExtra);
        packet.putSendData(fh.b(byteArrayExtra));
        if (longExtra > 0) {
            packet.setTimeout(longExtra);
        }
        if (QLog.isColorLevel()) {
            QLog.i("LoginVerifyServlet", 2, "onSend exit");
        }
    }
}
