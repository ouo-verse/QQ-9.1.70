package com.tencent.mobileqq.identification;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f237935c;

    /* renamed from: a, reason: collision with root package name */
    protected int f237936a;

    /* renamed from: b, reason: collision with root package name */
    private String f237937b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends com.tencent.mobileqq.observer.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.observer.c f237938d;

        a(com.tencent.mobileqq.observer.c cVar) {
            this.f237938d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) cVar);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void ipJudgeSuccess(boolean z16, String str) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            c cVar = c.this;
            if (z16) {
                i3 = 11;
            } else {
                i3 = 10;
            }
            cVar.f237936a = i3;
            QLog.d("FaceContext", 1, "ipJudgeSuccess ", Boolean.valueOf(z16), str);
            com.tencent.mobileqq.observer.c cVar2 = this.f237938d;
            if (cVar2 != null) {
                cVar2.ipJudgeSuccess(z16, str);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void onFailedResponse(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
                return;
            }
            QLog.d("FaceContext", 1, "refreshIpState onFailedResponse : ", str2);
            c.this.f237936a = 11;
            com.tencent.mobileqq.observer.c cVar = this.f237938d;
            if (cVar != null) {
                cVar.onFailedResponse(str, i3, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.observer.c f237940d;

        b(com.tencent.mobileqq.observer.c cVar) {
            this.f237940d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) cVar);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
            } else {
                c.this.d(eIPCResult, this.f237940d);
            }
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static c j() {
        if (f237935c == null) {
            synchronized (c.class) {
                if (f237935c == null) {
                    f237935c = new c();
                }
            }
        }
        return f237935c;
    }

    public k a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (k) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        int i3 = this.f237936a;
        if (i3 != 11 && i3 != 0) {
            if (i3 == 10) {
                String qqStr = HardCodeUtil.qqStr(R.string.f199064oe);
                this.f237937b = qqStr;
                return new UnusableAreaStrategy(qqStr);
            }
            QLog.d("FaceContext", 1, "unknown usable state : ", Integer.valueOf(i3));
            return null;
        }
        return new af();
    }

    protected com.tencent.mobileqq.observer.c b(com.tencent.mobileqq.observer.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.observer.c) iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
        }
        return new a(cVar);
    }

    protected String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return com.dataline.util.a.a(false);
    }

    protected void d(EIPCResult eIPCResult, com.tencent.mobileqq.observer.c cVar) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) eIPCResult, (Object) cVar);
            return;
        }
        int i3 = 11;
        if (eIPCResult != null && (bundle = eIPCResult.data) != null) {
            int i16 = eIPCResult.code;
            if (i16 == 0) {
                boolean z16 = bundle.getBoolean("usable", false);
                if (!z16) {
                    i3 = 10;
                }
                this.f237936a = i3;
                cVar.ipJudgeSuccess(z16, eIPCResult.data.getString("msg"));
                return;
            }
            if (i16 == -102) {
                this.f237936a = 11;
                cVar.onFailedResponse(eIPCResult.data.getString("cmd"), bundle.getInt("code"), eIPCResult.data.getString("msg"));
                return;
            } else {
                this.f237936a = 11;
                QLog.e("FaceContext", 1, "refreshIpStateOnSubProcess error, unknown code : ", Integer.valueOf(i16));
                cVar.onFailedResponse(null, -1, "unknown code");
                return;
            }
        }
        this.f237936a = 11;
        QLog.e("FaceContext", 1, "refreshIpStateOnSubProcess error, eipcResult is null or data is null");
        cVar.onFailedResponse(null, -1, "eipcResult is null");
    }

    public void e(AppRuntime appRuntime, int i3, String str, String str2, com.tencent.mobileqq.observer.c cVar) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, Integer.valueOf(i3), str, str2, cVar);
            return;
        }
        com.tencent.mobileqq.observer.c b16 = b(cVar);
        QLog.d("FaceContext", 1, "start refreshIpState");
        if (l.f237969a.contains(str)) {
            i(appRuntime, i3, b16);
            return;
        }
        if (l.f237970b.contains(str)) {
            String c16 = c();
            if (IPAddressUtil.isIPv4LiteralAddress(c16)) {
                bArr = IPAddressUtil.textToNumericFormatV4(c16);
                QLog.d("FaceContext", 1, "v4");
            } else if (IPAddressUtil.isIPv6LiteralAddress(c16)) {
                bArr = IPAddressUtil.textToNumericFormatV6(c16);
                QLog.e("FaceContext", 1, "v6");
            } else {
                bArr = null;
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            byte[] bArr2 = bArr;
            long j3 = 0;
            if (str2 != null) {
                try {
                    j3 = Long.parseLong(str2);
                } catch (Exception e16) {
                    QLog.d("FaceContext", 1, "parse uin error, ", e16.getMessage());
                }
            }
            g(i3, bArr2, j3, b16);
        }
    }

    public void f(int i3, String str, String str2, com.tencent.mobileqq.observer.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), str, str2, cVar);
            return;
        }
        QLog.d("FaceContext", 1, "start refreshIpStateOnSubProcess");
        Bundle bundle = new Bundle();
        bundle.putString("method", str2);
        bundle.putInt("srcAppId", i3);
        bundle.putString("uin", str);
        h(bundle, cVar);
    }

    protected void g(int i3, byte[] bArr, long j3, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), bArr, Long.valueOf(j3), businessObserver);
        } else {
            LoginVerifyServlet.i(i3, bArr, j3, businessObserver);
        }
    }

    protected void h(Bundle bundle, com.tencent.mobileqq.observer.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle, (Object) cVar);
        } else {
            QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_face_usable", bundle, new b(cVar));
        }
    }

    protected void i(AppRuntime appRuntime, int i3, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, appRuntime, Integer.valueOf(i3), businessObserver);
        } else {
            LoginVerifyServlet.p(appRuntime, i3, businessObserver);
        }
    }
}
