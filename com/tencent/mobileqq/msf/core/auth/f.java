package com.tencent.mobileqq.msf.core.auth;

import com.qq.jce.wup.UniPacket;
import com.qq.jce.wup.WupHexUtil;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.msf.service.protocol.security.p;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    public static final String f247457b = "MSF.C.AccountRespHandler";

    /* renamed from: a, reason: collision with root package name */
    b f247458a;

    public f(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f247458a = bVar;
        }
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        com.tencent.msf.service.protocol.security.k kVar;
        a b16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg.isSuccess() && fromServiceMsg.getWupBuffer() != null && fromServiceMsg.getWupBuffer().length > 0) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("UTF-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            com.tencent.msf.service.protocol.security.k kVar2 = (com.tencent.msf.service.protocol.security.k) uniPacket.getByClass(e.f247452l, new com.tencent.msf.service.protocol.security.k());
            if (kVar2 != null) {
                if (!this.f247458a.f247397c.containsKey(kVar2.f336667d)) {
                    this.f247458a.a(kVar2.f336667d);
                }
                a aVar = this.f247458a.f247397c.get(kVar2.f336667d);
                int i3 = kVar2.f336669f;
                if (i3 == 101) {
                    this.f247458a.f247402h.a(toServiceMsg, fromServiceMsg, uniPacket, kVar2);
                    this.f247458a.f247395a.addRespToQuque(toServiceMsg, fromServiceMsg);
                    return;
                }
                if (i3 != 0 && i3 != 10) {
                    if (i3 == 203) {
                        com.tencent.msf.service.protocol.security.i iVar = (com.tencent.msf.service.protocol.security.i) uniPacket.getByClass(e.f247451k, new com.tencent.msf.service.protocol.security.i());
                        if (iVar == null || (str2 = iVar.f336658b) == null) {
                            str2 = "password error";
                        }
                        fromServiceMsg.setBusinessFail(2005, str2);
                        this.f247458a.f247395a.addRespToQuque(toServiceMsg, fromServiceMsg);
                        return;
                    }
                    if (i3 == 235) {
                        if (((com.tencent.msf.service.protocol.security.j) uniPacket.getByClass("RespondGetServerTime", new com.tencent.msf.service.protocol.security.j())) != null) {
                            this.f247458a.a((int) (r3.f336661b - (System.currentTimeMillis() / 1000)));
                            MsfCommand msfCommand = toServiceMsg.getMsfCommand();
                            MsfCommand msfCommand2 = MsfCommand.loginAuth;
                            if (msfCommand == msfCommand2 || toServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin || toServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin) {
                                if (toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_LOGIN_ALSOCHECKTIME) == null) {
                                    toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_LOGIN_ALSOCHECKTIME, 1);
                                    if (toServiceMsg.getMsfCommand() == msfCommand2) {
                                        this.f247458a.f247395a.login(toServiceMsg);
                                        return;
                                    }
                                    if (toServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) {
                                        this.f247458a.f247395a.ChangeUinLogin(toServiceMsg);
                                        return;
                                    } else if (toServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin) {
                                        this.f247458a.f247395a.wt_GetStViaSMSVerifyLogin(toServiceMsg);
                                        return;
                                    } else {
                                        QLog.d("AuthRespHandler", 2, "HandlerLoginResp authResp.result == com.tencent.msf.service.protocol.security.Const.RESULT_A1Overtime and go else?? what happen?");
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        fromServiceMsg.setBusinessFail(1012, "client time error");
                        this.f247458a.f247395a.addRespToQuque(toServiceMsg, fromServiceMsg);
                        return;
                    }
                    com.tencent.msf.service.protocol.security.i iVar2 = (com.tencent.msf.service.protocol.security.i) uniPacket.getByClass(e.f247451k, new com.tencent.msf.service.protocol.security.i());
                    if (iVar2 == null || (str = iVar2.f336658b) == null) {
                        str = "loginFailed.";
                    }
                    int i16 = kVar2.f336665b;
                    if (i16 == 14 || i16 == 0) {
                        QLog.d(f247457b, 1, Thread.currentThread().getName() + " HandlerLoginResp setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
                        this.f247458a.n(fromServiceMsg.getUin());
                    }
                    fromServiceMsg.setBusinessFail(kVar2.f336669f, str);
                    if (toServiceMsg.getMsfCommand() == MsfCommand._msf_refreToken) {
                        this.f247458a.f247404j.a(toServiceMsg, fromServiceMsg);
                        return;
                    } else {
                        this.f247458a.f247395a.addRespToQuque(toServiceMsg, fromServiceMsg);
                        return;
                    }
                }
                int i17 = kVar2.f336665b;
                if (i17 != 0) {
                    if (i17 != 1) {
                        if (i17 != 6) {
                            if (i17 != 9) {
                                if (i17 != 17) {
                                    switch (i17) {
                                        case 13:
                                            this.f247458a.a(toServiceMsg.getUin(), kVar2);
                                            aVar.b(kVar2.f336668e);
                                            fromServiceMsg.addAttribute(fromServiceMsg.getServiceCmd(), kVar2.f336667d);
                                            p pVar = (p) uniPacket.getByClass("ResponseNameExchangeUin", new p());
                                            if (pVar != null) {
                                                fromServiceMsg.addAttribute(BaseConstants.Attribute_TAG_SIGSESSION, pVar.f336713e);
                                            }
                                            this.f247458a.f247395a.addRespToQuque(toServiceMsg, fromServiceMsg);
                                            return;
                                        case 14:
                                            this.f247458a.f247402h.a(uniPacket, aVar);
                                            this.f247458a.f247402h.a(toServiceMsg, fromServiceMsg, kVar2);
                                            return;
                                        case 15:
                                            if (((com.tencent.msf.service.protocol.security.j) uniPacket.getByClass("RespondGetServerTime", new com.tencent.msf.service.protocol.security.j())) != null) {
                                                NetConnInfoCenter.handleGetServerTimeResp(r0.f336661b);
                                                return;
                                            }
                                            return;
                                        default:
                                            this.f247458a.f247395a.addRespToQuque(toServiceMsg, fromServiceMsg);
                                            return;
                                    }
                                }
                                return;
                            }
                            RespondCustomSig respondCustomSig = (RespondCustomSig) uniPacket.getByClass(e.f247454n, new RespondCustomSig());
                            ArrayList arrayList = new ArrayList();
                            int i18 = 0;
                            boolean z16 = false;
                            while (i18 < respondCustomSig.SigList.size()) {
                                CustomSigContent customSigContent = respondCustomSig.SigList.get(i18);
                                if (customSigContent.ulSigType == 13) {
                                    Cryptor cryptor = new Cryptor();
                                    byte[] bArr = customSigContent.SigContent;
                                    byte[] b17 = aVar.b();
                                    if ((b17 == null || b17.length == 0) && (b16 = this.f247458a.b(kVar2.f336667d)) != null) {
                                        b17 = b16.b();
                                    }
                                    if (b17 != null && b17.length != 0) {
                                        byte[] mD5Byte = MD5.toMD5Byte(b17);
                                        if (mD5Byte != null && mD5Byte.length != 0) {
                                            byte[] decrypt = cryptor.decrypt(bArr, mD5Byte);
                                            if (decrypt != null && decrypt.length != 0) {
                                                byte[] bArr2 = new byte[4];
                                                byte[] bArr3 = new byte[16];
                                                kVar = kVar2;
                                                byte[] bArr4 = new byte[2];
                                                e.a(bArr2, 0, decrypt, 4);
                                                e.a(bArr3, 0, decrypt, 4, 16);
                                                e.a(bArr4, 0, decrypt, 20, 2);
                                                int i19 = (bArr4[0] << 8) + bArr4[1];
                                                int i26 = i19 + 22;
                                                if (decrypt.length != i26) {
                                                    QLog.d(f247457b, 2, "D3.length is " + decrypt.length + ", but expected to be " + i26);
                                                } else {
                                                    byte[] bArr5 = new byte[i19];
                                                    e.a(bArr5, 0, decrypt, 22, i19);
                                                    arrayList.add(WupHexUtil.bytes2HexStr(bArr2) + "," + WupHexUtil.bytes2HexStr(bArr3) + "," + WupHexUtil.bytes2HexStr(bArr5));
                                                }
                                            } else {
                                                kVar = kVar2;
                                                QLog.d(f247457b, 2, "D3 decrypt by A2 failed, D3 is " + HexUtil.bytes2HexStr(bArr));
                                            }
                                        } else {
                                            kVar = kVar2;
                                            QLog.d(f247457b, 2, "dekey A2 is null!");
                                        }
                                    } else {
                                        kVar = kVar2;
                                        QLog.d(f247457b, 2, "A2 is null!");
                                    }
                                    z16 = true;
                                } else {
                                    kVar = kVar2;
                                    arrayList.add(customSigContent.toString());
                                    if (customSigContent.ulSigType == 3) {
                                        fromServiceMsg.addAttribute("A8", customSigContent);
                                    }
                                }
                                i18++;
                                kVar2 = kVar;
                            }
                            if (z16) {
                                fromServiceMsg.addAttribute(fromServiceMsg.getServiceCmd(), arrayList);
                            } else {
                                fromServiceMsg.addAttribute(fromServiceMsg.getServiceCmd(), respondCustomSig);
                            }
                            if (toServiceMsg.getMsfCommand() == MsfCommand._msf_refreToken) {
                                this.f247458a.f247404j.a(toServiceMsg, fromServiceMsg);
                                return;
                            } else {
                                this.f247458a.f247395a.addRespToQuque(toServiceMsg, fromServiceMsg);
                                return;
                            }
                        }
                        com.tencent.msf.service.protocol.security.l lVar = (com.tencent.msf.service.protocol.security.l) uniPacket.getByClass("RespondReFetchSid", new com.tencent.msf.service.protocol.security.l());
                        this.f247458a.a(fromServiceMsg.getUin(), new String(lVar.f336677b), System.currentTimeMillis());
                        fromServiceMsg.addAttribute(fromServiceMsg.getServiceCmd(), lVar.f336677b);
                        if (toServiceMsg.getMsfCommand() == MsfCommand._msf_refreToken) {
                            this.f247458a.f247404j.a(toServiceMsg, fromServiceMsg);
                            return;
                        } else {
                            this.f247458a.f247395a.addRespToQuque(toServiceMsg, fromServiceMsg);
                            return;
                        }
                    }
                    try {
                        if (uniPacket.getServantName().equals("Login.Register")) {
                            this.f247458a.f247395a.addRespToQuque(toServiceMsg, fromServiceMsg);
                            return;
                        }
                        com.tencent.msf.service.protocol.security.o oVar = (com.tencent.msf.service.protocol.security.o) uniPacket.getByClass("ResponseAuthWlogin", new com.tencent.msf.service.protocol.security.o());
                        if (oVar != null) {
                            byte[] bArr6 = oVar.f336705d;
                        }
                        this.f247458a.f247402h.a(uniPacket, aVar);
                        this.f247458a.f247402h.a(toServiceMsg, fromServiceMsg, kVar2);
                        return;
                    } catch (Exception e16) {
                        QLog.d(f247457b, 2, "handle _CMD_ID_VERIFY_PIC failed.", e16);
                        return;
                    }
                }
                this.f247458a.f247402h.a(toServiceMsg, fromServiceMsg, kVar2);
                return;
            }
            return;
        }
        if (toServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin || toServiceMsg.getMsfCommand() == MsfCommand.loginAuth || toServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin) {
            boolean equals = fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_LOGIN_CHANGEUIN_AUTH);
            long longValue = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE)).longValue();
            long a16 = com.tencent.mobileqq.msf.core.c0.j.a(toServiceMsg, fromServiceMsg);
            if (fromServiceMsg.getBusinessFailCode() == 1002) {
                long j3 = 0;
                if (toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_MSF2NET)) {
                    if (toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_ADDSENDQUEUE)) {
                        j3 = ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue() - ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE)).longValue();
                    }
                    if (this.f247458a.f247395a.getStatReporter() != null) {
                        this.f247458a.f247395a.getStatReporter().a(false, longValue, 1014, a16, equals, j3);
                        return;
                    }
                    return;
                }
                if (this.f247458a.f247395a.getStatReporter() != null) {
                    this.f247458a.f247395a.getStatReporter().a(false, longValue, fromServiceMsg.getBusinessFailCode(), a16, equals, 0L);
                    return;
                }
                return;
            }
            if (fromServiceMsg.getBusinessFailCode() == 2008) {
                if (this.f247458a.f247395a.getStatReporter() != null) {
                    this.f247458a.f247395a.getStatReporter().a(toServiceMsg.getUin(), false, longValue, fromServiceMsg.getBusinessFailCode(), a16);
                }
            } else if (this.f247458a.f247395a.getStatReporter() != null) {
                this.f247458a.f247395a.getStatReporter().a(true, longValue, fromServiceMsg.getBusinessFailCode(), a16, equals, 0L);
            }
        }
    }
}
