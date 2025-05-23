package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ao implements com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a extends com.tencent.mobileqq.loginregister.servlet.g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f116622d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ISubAccountService f116623e;

        a(QQAppInterface qQAppInterface, ISubAccountService iSubAccountService) {
            this.f116622d = qQAppInterface;
            this.f116623e = iSubAccountService;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) iSubAccountService);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.g
        protected void a(String str, String str2, String str3) {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3);
                return;
            }
            if (str3 != null && (qQAppInterface = this.f116622d) != null && str != null && str.equalsIgnoreCase(qQAppInterface.getAccount())) {
                this.f116623e.updateA2(str2, str3, true);
                ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).setBindUinStatus(this.f116622d, (byte) 1, str2);
                ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).loadServerMessage(this.f116622d, str2, false);
            }
        }
    }

    public ao() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(com.tencent.imcore.message.af afVar, long j3, byte[] bArr) {
        submsgtype0x31$MsgBody submsgtype0x31_msgbody;
        try {
            submsgtype0x31_msgbody = new submsgtype0x31$MsgBody().mergeFrom(bArr);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", e16);
            }
            submsgtype0x31_msgbody = null;
        }
        if (submsgtype0x31_msgbody == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", "12017");
            hashMap.put(ISubAccountControlService.FAIL_STEP, "msgbyod_null");
            hashMap.put(ISubAccountControlService.FAIL_LOCATION, BaseMessageHandler.TAG);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(afVar.d().getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, hashMap, "");
            return;
        }
        if (submsgtype0x31_msgbody.uint32_flag.has() && submsgtype0x31_msgbody.uint64_bind_uin.has() && submsgtype0x31_msgbody.uint64_uin.has()) {
            int i3 = submsgtype0x31_msgbody.uint32_flag.get();
            submsgtype0x31_msgbody.uint32_time.get();
            long j16 = submsgtype0x31_msgbody.uint64_uin.get();
            long j17 = submsgtype0x31_msgbody.uint64_bind_uin.get();
            if (j16 > 0 && j17 > 0) {
                if (!String.valueOf(j3).equalsIgnoreCase(afVar.d().getAccount())) {
                    return;
                }
                com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
                aVar.f291124d = String.valueOf(j16);
                aVar.f291123c = String.valueOf(j17);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("param_FailCode", "12018");
                hashMap2.put(ISubAccountControlService.FAIL_STEP, "success_" + i3);
                hashMap2.put(ISubAccountControlService.FAIL_LOCATION, BaseMessageHandler.TAG);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(afVar.d().getCurrentAccountUin(), "actSBPushNotifaction", true, 0L, 0L, hashMap2, "");
                c(afVar, i3, aVar, j16);
                return;
            }
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("param_FailCode", "12017");
            hashMap3.put(ISubAccountControlService.FAIL_STEP, "uin_error");
            hashMap3.put(ISubAccountControlService.FAIL_LOCATION, BaseMessageHandler.TAG);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(afVar.d().getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, hashMap3, "");
            return;
        }
        HashMap<String, String> hashMap4 = new HashMap<>();
        hashMap4.put("param_FailCode", "12017");
        hashMap4.put(ISubAccountControlService.FAIL_STEP, "uinflag_null");
        hashMap4.put(ISubAccountControlService.FAIL_LOCATION, BaseMessageHandler.TAG);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(afVar.d().getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, hashMap4, "");
    }

    public static void c(com.tencent.imcore.message.af afVar, int i3, com.tencent.mobileqq.subaccount.logic.a aVar, long j3) {
        boolean z16;
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) qQAppInterface.getRuntimeService(ISubAccountControlService.class, "all");
        if (i3 == 1) {
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).setBindUinStatus(qQAppInterface, (byte) 0, aVar.f291124d);
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).clearAllData(qQAppInterface, aVar.f291124d);
            aVar.f291121a = 1;
            iSubAccountControlService.addHintPair(aVar.f291124d, 1);
            afVar.l(8004, true, aVar);
            return;
        }
        if (i3 == 0) {
            String valueOf = String.valueOf(j3);
            ISubAccountService iSubAccountService = (ISubAccountService) qQAppInterface.getRuntimeService(ISubAccountService.class, "all");
            aVar.a(valueOf);
            iSubAccountService.updateSubAccountInfo(aVar);
            ArrayList<String> d16 = aVar.d();
            if (d16 != null && d16.size() > 0) {
                Iterator<String> it = d16.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (QLog.isColorLevel()) {
                        QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint is new,msg num=1, subUin=" + next);
                    }
                    int R = 1 - qQAppInterface.getConversationFacade().R(next, 7000);
                    if (R != 0) {
                        qQAppInterface.getConversationFacade().c0(next, 7000, R);
                    }
                }
            }
            Pair<Boolean, Boolean> checkSubAccountLoginStatus = ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).checkSubAccountLoginStatus(qQAppInterface, valueOf);
            if (checkSubAccountLoginStatus != null) {
                z16 = checkSubAccountLoginStatus.second.booleanValue();
            } else {
                z16 = false;
            }
            if (z16) {
                iSubAccountService.setStatus(valueOf, 1);
                ((ILoginServletService) qQAppInterface.getRuntimeService(ILoginServletService.class, "all")).getSubAccountKey(qQAppInterface.getAccount(), String.valueOf(j3), new a(qQAppInterface, iSubAccountService));
            } else if (iSubAccountService.setStatus(String.valueOf(j3), 2)) {
                int R2 = 1 - qQAppInterface.getConversationFacade().R(valueOf, 7000);
                if (R2 != 0) {
                    qQAppInterface.getConversationFacade().c0(valueOf, 7000, R2);
                    qQAppInterface.getMessageFacade().K0(new String[]{AppConstants.SUBACCOUNT_ASSISTANT_UIN, valueOf});
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint need to verify,msg num=1, subUin=" + valueOf);
                }
            }
            aVar.f291121a = 0;
            afVar.l(8004, true, aVar);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b(afVar, j3, bArr);
        return null;
    }
}
