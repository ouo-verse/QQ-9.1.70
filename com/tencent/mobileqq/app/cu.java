package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.AccountSecurityInfo$SecCheckBanner;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x4a.MsgBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cu {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static int f195469b;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f195470a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69943);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f195469b = 0;
        }
    }

    public cu(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195470a = qQAppInterface;
        }
    }

    public void a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            return;
        }
        MsgBody msgBody = new MsgBody();
        try {
            msgBody.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SafeCenterPushHandler", 2, "onReceive: onReceive push package: msgbody parse fail");
            }
            e16.printStackTrace();
        }
        if (msgBody.has() && msgBody.uint32_sec_cmd.has()) {
            int i3 = msgBody.uint32_sec_cmd.get();
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 4) {
                        byte[] byteArray = msgBody.bytes_data.get().toByteArray();
                        AccountSecurityInfo$SecCheckBanner accountSecurityInfo$SecCheckBanner = new AccountSecurityInfo$SecCheckBanner();
                        try {
                            accountSecurityInfo$SecCheckBanner.mergeFrom(byteArray);
                        } catch (InvalidProtocolBufferMicroException e17) {
                            e17.printStackTrace();
                        }
                        String str = accountSecurityInfo$SecCheckBanner.str_wording.get();
                        int i16 = accountSecurityInfo$SecCheckBanner.u32_timeToShow.get();
                        Intent intent = new Intent();
                        intent.putExtra("wording", str);
                        intent.putExtra("timetowait", i16);
                        this.f195470a.setSecDetBannerIntent(intent);
                        return;
                    }
                    return;
                }
                com.tencent.mqpsdk.secsrv.b bVar = (com.tencent.mqpsdk.secsrv.b) new com.tencent.mqpsdk.b(this.f195470a.getApp().getApplicationContext(), (MSFNetTransportProvider) this.f195470a.getBusinessHandler(BusinessHandlerFactory.MSF_NET_TRANSPORT_PROVIDER_HANDLER)).a("intchk");
                if (bVar != null) {
                    bVar.c(1, new MSFIntChkStrike(this.f195470a, 1));
                    bVar.c(2, new MSFIntChkStrike(this.f195470a, 2));
                    bVar.c(3, new MSFIntChkStrike(this.f195470a, 3));
                    bVar.j(AppSetting.f99551k + "." + AppSetting.l());
                    return;
                }
                return;
            }
            new com.tencent.ctsz.m(this.f195470a).h();
        }
    }
}
