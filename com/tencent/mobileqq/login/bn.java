package com.tencent.mobileqq.login;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.bn;
import com.tencent.mobileqq.login.verify.DevLockVerifyComponent;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import tencent.im.login.GatewayVerify$ReqBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class bn {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final bp f241991a;

    /* renamed from: b, reason: collision with root package name */
    private final e f241992b;

    /* renamed from: c, reason: collision with root package name */
    private final f f241993c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f241994d;

        a(long j3) {
            this.f241994d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bn.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void p(int i3, String str, aj ajVar, DevlockInfo devlockInfo) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, ajVar, devlockInfo);
                return;
            }
            if (ajVar != null) {
                str2 = ajVar.f241866c;
            } else {
                str2 = null;
            }
            QLog.i("PhoneUinTokenLoginComponent", 1, "getStViaSMSVerifyLogin ret=" + i3 + " msg=" + str2);
            if (bn.this.f241993c != null) {
                f fVar = bn.this.f241993c;
                if (i3 != 0) {
                    i16 = 1;
                }
                fVar.b(i16, System.currentTimeMillis() - this.f241994d);
            }
            if (i3 == 0) {
                if (bn.this.f241992b != null) {
                    bn.this.f241992b.c(str, new Bundle());
                }
            } else {
                if (i3 == 224) {
                    bn.this.j(i3, devlockInfo);
                    return;
                }
                if (i3 == 24) {
                    bn.this.f241992b.a(ajVar);
                    return;
                }
                if (ajVar == null) {
                    ajVar = new aj(i3, "");
                }
                if (bn.this.f241992b != null) {
                    bn.this.f241992b.d(ajVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f241996d;

        b(long j3) {
            this.f241996d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bn.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void n(int i3, String str, aj ajVar, DevlockInfo devlockInfo) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, ajVar, devlockInfo);
                return;
            }
            if (ajVar == null) {
                str2 = "";
            } else {
                str2 = ajVar.f241866c;
            }
            QLog.i("PhoneUinTokenLoginComponent", 1, "getStViaGatewayLogin ret=" + i3 + " msg=" + str2);
            if (bn.this.f241993c != null) {
                f fVar = bn.this.f241993c;
                if (i3 != 0) {
                    i16 = 1;
                }
                fVar.b(i16, System.currentTimeMillis() - this.f241996d);
            }
            if (i3 == 0) {
                if (bn.this.f241992b != null) {
                    bn.this.f241992b.c(str, new Bundle());
                }
            } else {
                if (i3 == 224) {
                    bn.this.j(i3, devlockInfo);
                    return;
                }
                if (i3 == 24) {
                    bn.this.f241992b.a(ajVar);
                    return;
                }
                if (ajVar == null) {
                    ajVar = new aj(i3, "");
                }
                if (bn.this.f241992b != null) {
                    bn.this.f241992b.d(ajVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f241998d;

        c(long j3) {
            this.f241998d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bn.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void o(int i3, String str, aj ajVar, DevlockInfo devlockInfo, Bundle bundle) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, ajVar, devlockInfo, bundle);
                return;
            }
            if (ajVar == null) {
                str2 = "";
            } else {
                str2 = ajVar.f241866c;
            }
            QLog.i("PhoneUinTokenLoginComponent", 1, "getStViaPhonePwdLogin ret=" + i3 + " msg=" + str2);
            if (bn.this.f241993c != null) {
                f fVar = bn.this.f241993c;
                if (i3 != 0) {
                    i16 = 1;
                }
                fVar.b(i16, System.currentTimeMillis() - this.f241998d);
            }
            if (i3 == 0) {
                if (bn.this.f241992b != null) {
                    bn.this.f241992b.c(str, bundle);
                }
            } else {
                if (DevLockVerifyComponent.o(i3)) {
                    bn.this.j(i3, devlockInfo);
                    return;
                }
                if (i3 == 24) {
                    bn.this.f241992b.a(ajVar);
                    return;
                }
                if (ajVar == null) {
                    ajVar = new aj(i3, "");
                }
                if (bn.this.f241992b != null) {
                    bn.this.f241992b.d(ajVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements DevLockVerifyComponent.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f242000a;

        d(long j3) {
            this.f242000a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bn.this, Long.valueOf(j3));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(aj ajVar) {
            bn.this.f241992b.a(ajVar);
        }

        @Override // com.tencent.mobileqq.login.verify.DevLockVerifyComponent.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i("PhoneUinTokenLoginComponent", 1, "devLockVerify onVerifyCancel");
            if (bn.this.f241993c != null) {
                bn.this.f241993c.d(2, System.currentTimeMillis() - this.f242000a);
            }
            if (bn.this.f241992b != null) {
                bn.this.f241992b.b();
            }
        }

        @Override // com.tencent.mobileqq.login.verify.DevLockVerifyComponent.c
        public void b(boolean z16, Bundle bundle) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            QLog.i("PhoneUinTokenLoginComponent", 1, "devLockVerify onVerifySuccess isLogin= " + z16);
            if (bn.this.f241993c != null) {
                bn.this.f241993c.d(0, System.currentTimeMillis() - this.f242000a);
            }
            if (z16) {
                if (bundle != null) {
                    str = bundle.getString("uin");
                } else {
                    str = "";
                }
                if (bn.this.f241992b != null) {
                    bn.this.f241992b.c(str, bundle);
                    return;
                }
                return;
            }
            if (bundle != null && bundle.getInt("ret") == 24) {
                if (bn.this.f241992b != null) {
                    final aj ajVar = new aj();
                    ajVar.f241869f = bundle.getByteArray("errorTlv");
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.login.bo
                        @Override // java.lang.Runnable
                        public final void run() {
                            bn.d.this.d(ajVar);
                        }
                    });
                    return;
                }
                return;
            }
            bn.this.i();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface e {
        void a(aj ajVar);

        void b();

        void c(String str, Bundle bundle);

        void d(aj ajVar);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface f {
        void a();

        void b(int i3, long j3);

        void c();

        void d(int i3, long j3);
    }

    public bn(bp bpVar, e eVar, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bpVar, eVar, fVar);
            return;
        }
        this.f241991a = bpVar;
        this.f241992b = eVar;
        this.f241993c = fVar;
    }

    private void e() {
        QLog.i("PhoneUinTokenLoginComponent", 1, "getStViaGatewayLogin uin=" + this.f241991a.f242006c.getMaskUin());
        long currentTimeMillis = System.currentTimeMillis();
        f fVar = this.f241993c;
        if (fVar != null) {
            fVar.c();
        }
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        if (this.f241991a.f242006c.getUinToken() != null) {
            gatewayVerify$ReqBody.msg_req_mask_qq_login.bytes_encrypt_uin_info.set(ByteStringMicro.copyFrom(this.f241991a.f242006c.getUinToken()));
            gatewayVerify$ReqBody.msg_req_mask_qq_login.setHasFlag(true);
            gatewayVerify$ReqBody.setHasFlag(true);
        }
        gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(com.tencent.mobileqq.login.remind.n.f242580a.c(this.f241991a.f242006c.getMaskUin()));
        gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
        ((ILoginServletService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILoginServletService.class, "all")).getStViaGatewayLogin(gatewayVerify$ReqBody.toByteArray(), this.f241991a.f242009f, new b(currentTimeMillis));
    }

    private void f() {
        QLog.i("PhoneUinTokenLoginComponent", 1, "getStViaPhonePwdLogin uin=" + this.f241991a.f242006c.getMaskUin());
        long currentTimeMillis = System.currentTimeMillis();
        f fVar = this.f241993c;
        if (fVar != null) {
            fVar.c();
        }
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        if (this.f241991a.f242006c.getUinToken() != null) {
            gatewayVerify$ReqBody.msg_req_mask_qq_login.bytes_encrypt_uin_info.set(ByteStringMicro.copyFrom(this.f241991a.f242006c.getUinToken()));
            gatewayVerify$ReqBody.msg_req_mask_qq_login.setHasFlag(true);
            gatewayVerify$ReqBody.setHasFlag(true);
        }
        bp bpVar = this.f241991a;
        if (bpVar.f242010g && !TextUtils.isEmpty(bpVar.f242011h)) {
            new com.tencent.mobileqq.loginregister.ai().a(gatewayVerify$ReqBody, this.f241991a.f242011h);
        }
        gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(com.tencent.mobileqq.login.remind.n.f242580a.c(this.f241991a.f242006c.getMaskUin()));
        gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
        ILoginServletService iLoginServletService = (ILoginServletService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILoginServletService.class, "all");
        byte[] byteArray = gatewayVerify$ReqBody.toByteArray();
        bp bpVar2 = this.f241991a;
        iLoginServletService.getStViaPhonePwdLogin(byteArray, bpVar2.f242009f, bpVar2.f242010g, new c(currentTimeMillis));
    }

    private void g() {
        QLog.i("PhoneUinTokenLoginComponent", 1, "getStViaSMSVerifyLogin uin=" + this.f241991a.f242006c.getMaskUin());
        long currentTimeMillis = System.currentTimeMillis();
        f fVar = this.f241993c;
        if (fVar != null) {
            fVar.c();
        }
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        if (this.f241991a.f242006c.getUinToken() != null) {
            gatewayVerify$ReqBody.msg_req_mask_qq_login.bytes_encrypt_uin_info.set(ByteStringMicro.copyFrom(this.f241991a.f242006c.getUinToken()));
            gatewayVerify$ReqBody.msg_req_mask_qq_login.setHasFlag(true);
            gatewayVerify$ReqBody.setHasFlag(true);
        }
        bp bpVar = this.f241991a;
        if (bpVar.f242010g && !TextUtils.isEmpty(bpVar.f242011h)) {
            new com.tencent.mobileqq.loginregister.ai().a(gatewayVerify$ReqBody, this.f241991a.f242011h);
        }
        gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(com.tencent.mobileqq.login.remind.n.f242580a.c(this.f241991a.f242006c.getMaskUin()));
        gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
        ILoginServletService iLoginServletService = (ILoginServletService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILoginServletService.class, "all");
        bp bpVar2 = this.f241991a;
        iLoginServletService.getStViaSMSVerifyLogin(bpVar2.f242008e, bpVar2.f242007d, bpVar2.f242009f, bpVar2.f242010g, gatewayVerify$ReqBody.toByteArray(), new a(currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        int i3 = this.f241991a.f242004a;
        if (i3 == 5) {
            g();
        } else if (i3 == 4) {
            e();
        } else if (i3 == 7) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3, DevlockInfo devlockInfo) {
        String str;
        String str2;
        if (devlockInfo != null) {
            str = devlockInfo.OtherDevLockVerifyUrl;
        } else {
            str = null;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PhoneUinTokenLoginComponent", 4, "dev lock verify url " + str);
        }
        if (this.f241991a.f242004a != 7 && TextUtils.isEmpty(str)) {
            QLog.w("PhoneUinTokenLoginComponent", 1, "DevLockVerifyUrl is empty");
            e eVar = this.f241992b;
            if (eVar != null) {
                eVar.d(new aj(-1001, -1001, "\u65b0\u8bbe\u5907\u9a8c\u8bc1\u53c2\u6570\u9519\u8bef", null, null, null, null));
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        f fVar = this.f241993c;
        if (fVar != null) {
            fVar.a();
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putSerializable("key_mask_user_info", this.f241991a.f242006c);
        if (this.f241991a.f242009f) {
            bundle.putBoolean("isSubaccount", true);
            bundle.putString("from_where", "subaccount");
        }
        bp bpVar = this.f241991a;
        if (bpVar.f242010g) {
            bundle.putString("appid", bpVar.f242011h);
            bundle.putString("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
        }
        bundle.putInt(TangramHippyConstants.LOGIN_TYPE, this.f241991a.f242004a);
        if (!bundle.containsKey("smsExtraData")) {
            GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
            gatewayVerify$ReqBody.msg_req_common_info.bool_need_remind_in_cancel_status.set(com.tencent.mobileqq.login.remind.n.f242580a.c(this.f241991a.f242006c.getMaskUin()));
            gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
            bundle.putByteArray("smsExtraData", gatewayVerify$ReqBody.toByteArray());
        } else if (!this.f241991a.f242010g) {
            try {
                byte[] byteArray = bundle.getByteArray("smsExtraData");
                GatewayVerify$ReqBody gatewayVerify$ReqBody2 = new GatewayVerify$ReqBody();
                gatewayVerify$ReqBody2.mergeFrom(byteArray);
                gatewayVerify$ReqBody2.msg_req_common_info.bool_need_remind_in_cancel_status.set(com.tencent.mobileqq.login.remind.n.f242580a.c(this.f241991a.f242006c.getMaskUin()));
                gatewayVerify$ReqBody2.msg_req_common_info.setHasFlag(true);
                bundle.putByteArray("smsExtraData", gatewayVerify$ReqBody2.toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("PhoneUinTokenLoginComponent", 1, "startDevLockVerify error" + e16);
            }
        }
        bp bpVar2 = this.f241991a;
        if (bpVar2.f242005b == 16 && bpVar2.f242012i) {
            str2 = com.tencent.mobileqq.accountbinding.d.f174609a.g();
        } else {
            str2 = null;
        }
        new DevLockVerifyComponent().A(this.f241991a.f242004a, devlockInfo, null, str2, i3, bundle, new d(currentTimeMillis));
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("PhoneUinTokenLoginComponent", 1, "loginByUinToken loginType=" + this.f241991a.f242004a + " uin=" + this.f241991a.f242006c.getMaskUin());
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.login.bm
            @Override // java.lang.Runnable
            public final void run() {
                bn.this.h();
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(runnable, 16, null, true);
        } else {
            runnable.run();
        }
    }
}
