package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import mqq.app.BuiltInServlet;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    boolean f247503a;

    /* renamed from: b, reason: collision with root package name */
    boolean f247504b;

    /* renamed from: c, reason: collision with root package name */
    WtloginMsfListener f247505c;

    /* renamed from: d, reason: collision with root package name */
    ToServiceMsg f247506d;

    /* renamed from: e, reason: collision with root package name */
    MsfCore f247507e;

    /* renamed from: f, reason: collision with root package name */
    long f247508f;

    /* renamed from: g, reason: collision with root package name */
    boolean f247509g;

    /* renamed from: h, reason: collision with root package name */
    boolean f247510h;

    public o(MsfCore msfCore, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore, (Object) toServiceMsg);
            return;
        }
        this.f247503a = false;
        this.f247504b = true;
        this.f247509g = false;
        this.f247510h = false;
        this.f247507e = msfCore;
        this.f247506d = toServiceMsg;
    }

    private String a(int i3) {
        return (i3 & m.f247501g) == 1052704 ? "WebTicket" : (i3 & m.f247499e) == 262208 ? "BasicTicket" : "OtherTicket";
    }

    public void b(WUserSigInfo wUserSigInfo, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) wUserSigInfo, (Object) bArr);
            return;
        }
        if (this.f247509g) {
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, 3);
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void c(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        FromServiceMsg fromServiceMsg;
        int i16;
        Ticket GetUserSigInfoTicket;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, bArr, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckWebsigAndGetSt ret" + i3);
        }
        if (this.f247509g) {
            if (i3 == 0) {
                i.f247479m.getAccountCenter().a(false);
            }
            FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
            a16.setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
            a16.setMsgSuccess();
            a16.addAttribute("userAccount", str);
            a16.addAttribute("userInput", bArr);
            a16.addAttribute("userSigInfo", wUserSigInfo);
            a16.addAttribute("ret", Integer.valueOf(i3));
            a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
            a16.addAttribute("wtTicket", a(wUserSigInfo));
            a16.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
            try {
                a16.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.f247507e.addRespToQuque(this.f247506d, a16);
            return;
        }
        FromServiceMsg a17 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a17.setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
        a17.setMsgSuccess();
        a17.addAttribute("userAccount", str);
        a17.addAttribute("userInput", bArr);
        a17.addAttribute(BuiltInServlet.MSF_KEY_SIG_INFO, wUserSigInfo);
        a17.addAttribute("ret", Integer.valueOf(i3));
        a17.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
        a17.addAttribute("wtTicket", a(wUserSigInfo));
        a17.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
        a17.setUin(wUserSigInfo.uin);
        try {
            a17.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (i3 == -1000) {
            fromServiceMsg = a17;
            i16 = 1;
            fromServiceMsg.setBusinessFail(1002);
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt timeout");
        } else {
            if (i3 == 0) {
                try {
                    a(str);
                    m.a(this.f247507e, i.f247480n, str, wUserSigInfo);
                    m.a(this.f247507e, i.f247480n, this.f247506d, a17, str, wUserSigInfo);
                    if (this.f247503a) {
                        i.d(str);
                        return;
                    }
                    return;
                } catch (Exception e18) {
                    QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt succ exception " + e18.toString(), e18);
                    return;
                }
            }
            if (i3 == 2) {
                m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                long j3 = wUserSigInfo._seqence;
                this.f247508f = j3;
                m.b(str, this.f247507e, j3, this.f247506d, a17, errMsg.getMessage());
                return;
            }
            if (i3 != 160 && i3 != 239) {
                a17.setBusinessFail(1001, errMsg.getMessage());
                QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt failed");
                fromServiceMsg = a17;
                i16 = 1;
            } else {
                m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                long j16 = wUserSigInfo._seqence;
                this.f247508f = j16;
                m.a(str, this.f247507e, j16, this.f247506d, a17, errMsg.getMessage());
                return;
            }
        }
        if (i3 != 0) {
            if (errMsg.getType() == i16) {
                fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_URL, errMsg.getOtherinfo());
            }
            if ((i3 == 116 || i3 == 41) && (GetUserSigInfoTicket = WtloginHelper.GetUserSigInfoTicket(wUserSigInfo, 4194304)) != null) {
                byte[] bArr2 = GetUserSigInfoTicket._sig;
                if (bArr2 != null) {
                    fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_LHSIG, bArr2);
                } else if (QLog.isColorLevel()) {
                    QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt ret: " + i3 + " , t is null.");
                }
            }
        }
        fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_RET, Integer.valueOf(i3));
        this.f247507e.addRespToQuque(this.f247506d, fromServiceMsg);
    }

    public void d(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        if (this.f247509g) {
            FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
            a16.setBusinessFail(3001, String.valueOf(i3));
            a16.attributes.put("msg", bArr);
            MsfSdkUtils.addFromMsgProcessName("*", a16);
            this.f247507e.addRespToQuque(this.f247506d, a16);
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "found RegError " + i3 + " on call " + this.f247506d.getServiceCmd());
            return;
        }
        FromServiceMsg a17 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        if (i3 != 7 && i3 != 59) {
            if (i3 == 61) {
                a17.setMsgSuccess();
                a17.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, Integer.valueOf(i3));
                a17.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
                byte[] regTlvValue = WtloginHelper.getRegTlvValue(wUserSigInfo, 51);
                if (regTlvValue != null) {
                    String str = new String(regTlvValue);
                    a17.attributes.put(MsfConstants.ATTRIBUTE_RESP_PHONE_PROTECT_UINS_URL, str);
                    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRegError | phoneProtectUinsUrl=" + str);
                }
            } else {
                a17.setBusinessFail(3001, String.valueOf(i3));
                a17.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
                MsfSdkUtils.addFromMsgProcessName("*", a17);
            }
        } else {
            a17.setMsgSuccess();
            a17.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, Integer.valueOf(i3));
            a17.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
        }
        this.f247507e.addRespToQuque(this.f247506d, a17);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "found RegError " + i3 + " on call " + this.f247506d.getServiceCmd());
    }

    public void e(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("queryMobile", 2, "WtProviderImpl.OnRegQueryAccount ret = " + i3 + " appUseWt=" + this.f247509g);
        }
        if (!this.f247509g) {
            FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
            a16.setMsgSuccess();
            a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, Integer.valueOf(i3));
            a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
            this.f247507e.addRespToQuque(this.f247506d, a16);
        }
    }

    public void f(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, Integer.valueOf(i3));
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
        if (QLog.isColorLevel()) {
            QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | ret=" + i3);
        }
        if (i3 == 0) {
            byte[] regTlvValue = WtloginHelper.getRegTlvValue(wUserSigInfo, 36);
            if (regTlvValue != null) {
                String str = new String(regTlvValue);
                a16.addAttribute("bind_qq_uin", str);
                if (QLog.isColorLevel()) {
                    QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | uin=" + str);
                }
            }
            byte[] regTlvValue2 = WtloginHelper.getRegTlvValue(wUserSigInfo, 6);
            if (regTlvValue2 != null) {
                try {
                    String str2 = new String(regTlvValue2, "utf-8");
                    a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_ACCOUNT_NICK, str2);
                    if (QLog.isColorLevel()) {
                        QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | bindQQNick=" + str2);
                    }
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
            }
            byte[] regTlvValue3 = WtloginHelper.getRegTlvValue(wUserSigInfo, 40);
            if (regTlvValue3 != null) {
                String str3 = new String(regTlvValue3);
                a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_ACCOUNT_FACEURL, str3);
                if (QLog.isColorLevel()) {
                    QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | bindFaceUrl=" + str3);
                }
            }
            byte[] regTlvValue4 = WtloginHelper.getRegTlvValue(wUserSigInfo, 51);
            if (regTlvValue4 != null) {
                String str4 = new String(regTlvValue4);
                a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_PHONE_PROTECT_UINS_URL, str4);
                if (QLog.isColorLevel()) {
                    QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | phoneProtectUinsUrl=" + str4);
                }
            }
        }
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    byte[] a(WUserSigInfo wUserSigInfo) {
        Object attribute = this.f247506d.getAttribute("targetTicket");
        return WtloginHelper.GetTicketSig(wUserSigInfo, (attribute == null || !(attribute instanceof Integer)) ? 4096 : ((Integer) attribute).intValue());
    }

    public void a(int i3, WUserSigInfo wUserSigInfo, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), wUserSigInfo, errMsg);
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.addAttribute("userSigInfo", wUserSigInfo);
        a16.addAttribute("ret", Integer.valueOf(i3));
        a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
        if (i3 == 2) {
            m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
            this.f247508f = wUserSigInfo._seqence;
            if (TextUtils.isEmpty(errMsg.getOtherinfo())) {
                m.b(wUserSigInfo.uin, this.f247507e, this.f247508f, this.f247506d, a16, errMsg.getMessage());
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "appUseWt = false; puzzle CAPTCHA " + errMsg.getOtherinfo());
                }
                m.a(this.f247507e, this.f247508f, this.f247506d, a16, errMsg.getOtherinfo());
                return;
            }
        }
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void b(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        if (this.f247509g) {
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        if (QLog.isColorLevel()) {
            QLog.d("Login_Optimize_WtProviderImpl", 2, "ret=" + i3);
        }
        byte[] regTlvValue = WtloginHelper.getRegTlvValue(wUserSigInfo, 31);
        if (regTlvValue != null) {
            String valueOf = String.valueOf(util.buf_to_int64(regTlvValue, 0));
            a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_UIN, valueOf);
            if (QLog.isColorLevel()) {
                QLog.d("Login_Optimize_WtProviderImpl", 2, "uin=" + valueOf);
            }
        }
        byte[] regTlvValue2 = WtloginHelper.getRegTlvValue(wUserSigInfo, 30);
        if (regTlvValue2 != null) {
            String str = new String(regTlvValue2);
            a16.attributes.put(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE, str);
            if (QLog.isColorLevel()) {
                QLog.d("Login_Optimize_WtProviderImpl", 2, "phoneNum=" + str);
            }
        }
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, Integer.valueOf(i3));
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void a(String str, long j3, int i3, long j16, String str2, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
        String str3;
        int i17;
        Ticket GetUserSigInfoTicket;
        byte[] bArr;
        byte[] bArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), str2, wUserSigInfo, Integer.valueOf(i16), errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, this.f247506d.getRequestSsoSeq() + " OnGetStWithPasswd " + errMsg.getMessage() + " " + MsfSdkUtils.getShortUin(str) + ",  isVerifyPasswd=" + this.f247510h + " appUseWt=" + this.f247509g + " ret=" + i16 + " " + this.f247506d);
        if (this.f247510h) {
            FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
            a16.setMsgSuccess();
            ToServiceMsg toServiceMsg = this.f247506d;
            MsfCommand msfCommand = MsfCommand.verifyPasswd;
            toServiceMsg.setMsfCommand(msfCommand);
            a16.setMsfCommand(msfCommand);
            a16.addAttribute("userAccount", str);
            a16.addAttribute("dwAppid", Long.valueOf(j3));
            a16.addAttribute("dwMainSigMap", Integer.valueOf(i3));
            a16.addAttribute("dwSubDstAppid", Long.valueOf(j16));
            a16.addAttribute("userPasswd", str2);
            a16.addAttribute("userSigInfo", wUserSigInfo);
            a16.addAttribute("ret", Integer.valueOf(i16));
            a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
            a16.setUin(wUserSigInfo.uin);
            if (i16 == -1000) {
                a16.setBusinessFail(1002);
            } else if (i16 == 0) {
                a16.setMsgSuccess();
            } else if (i16 == 1) {
                a16.setBusinessFail(2005, errMsg.getMessage());
            } else if (i16 != 2) {
                a16.setBusinessFail(1001, errMsg.getMessage());
            } else {
                a16.setBusinessFail(2020, errMsg.getMessage());
                byte[] GetPictureData = i.f247480n.GetPictureData(a16.getUin(), wUserSigInfo._seqence);
                VerifyCodeInfo verifyCodeInfo = new VerifyCodeInfo();
                verifyCodeInfo.ssoSeq = a16.getRequestSsoSeq();
                verifyCodeInfo.verifyimage = GetPictureData;
                try {
                    verifyCodeInfo.verifyNote = m.a(str, i.f247480n.GetPicturePrompt(str, wUserSigInfo._seqence));
                } catch (Exception e16) {
                    QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "getImagePrompt exception " + e16.toString(), e16);
                    verifyCodeInfo.verifyNote = "getTipErr";
                }
                a16.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYIMAGE, verifyCodeInfo.verifyimage);
                a16.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYMSG, verifyCodeInfo.verifyNote);
            }
            this.f247507e.addRespToQuque(this.f247506d, a16);
            return;
        }
        if (this.f247509g) {
            try {
                byte[] bArr3 = new byte[0];
                if (i16 != 0) {
                    if (i16 == 2) {
                        if (TextUtils.isEmpty(errMsg.getOtherinfo())) {
                            bArr2 = i.f247480n.GetPictureData(str);
                            FromServiceMsg a17 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                            a17.setMsgSuccess();
                            a17.addAttribute("userAccount", str);
                            a17.addAttribute("dwAppid", Long.valueOf(j3));
                            a17.addAttribute("dwMainSigMap", Integer.valueOf(i3));
                            a17.addAttribute("dwSubDstAppid", Long.valueOf(j16));
                            a17.addAttribute("userPasswd", str2);
                            a17.addAttribute("pictureData", bArr2);
                            a17.addAttribute("userSigInfo", wUserSigInfo);
                            a17.addAttribute("wtTicket", a(wUserSigInfo));
                            a17.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
                            a17.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
                            a17.addAttribute("ret", Integer.valueOf(i16));
                            a17.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                            this.f247507e.addRespToQuque(this.f247506d, a17);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            bArr = bArr3;
                            sb5.append("puzzle CAPTCHA ");
                            sb5.append(errMsg.getOtherinfo());
                            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, sb5.toString());
                        }
                    }
                    bArr = bArr3;
                } else {
                    bArr = bArr3;
                    i.f247479m.getAccountCenter().a(false);
                }
                bArr2 = bArr;
                FromServiceMsg a172 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a172.setMsgSuccess();
                a172.addAttribute("userAccount", str);
                a172.addAttribute("dwAppid", Long.valueOf(j3));
                a172.addAttribute("dwMainSigMap", Integer.valueOf(i3));
                a172.addAttribute("dwSubDstAppid", Long.valueOf(j16));
                a172.addAttribute("userPasswd", str2);
                a172.addAttribute("pictureData", bArr2);
                a172.addAttribute("userSigInfo", wUserSigInfo);
                a172.addAttribute("wtTicket", a(wUserSigInfo));
                a172.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
                a172.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
                a172.addAttribute("ret", Integer.valueOf(i16));
                a172.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a172);
                return;
            } catch (Exception e17) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd error " + e17, e17);
                return;
            }
        }
        FromServiceMsg a18 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a18.setMsgSuccess();
        a18.addAttribute("userAccount", str);
        a18.addAttribute("dwAppid", Long.valueOf(j3));
        a18.addAttribute("dwMainSigMap", Integer.valueOf(i3));
        a18.addAttribute("dwSubDstAppid", Long.valueOf(j16));
        a18.addAttribute("userPasswd", str2);
        a18.addAttribute("userSigInfo", wUserSigInfo);
        a18.addAttribute("wtTicket", a(wUserSigInfo));
        a18.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
        try {
            a18.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        a18.addAttribute("ret", Integer.valueOf(i16));
        a18.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
        a18.setUin(wUserSigInfo.uin);
        if (i16 == -1000) {
            str3 = "MSF.C.WTLoginCenter.MsfProvider";
            i17 = 1;
            QLog.e(str3, 1, "OnGetStWithPasswd timeout");
            a18.setBusinessFail(1002);
        } else {
            if (i16 == 160 || i16 == 224 || i16 == 239) {
                m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                long j17 = wUserSigInfo._seqence;
                this.f247508f = j17;
                m.a(str, this.f247507e, j17, this.f247506d, a18, errMsg.getMessage());
                return;
            }
            if (i16 == 0) {
                str3 = "MSF.C.WTLoginCenter.MsfProvider";
                a(str);
                m.a(this.f247507e, i.f247480n, str, wUserSigInfo);
                if (wUserSigInfo._login_bitmap == 0) {
                    try {
                        m.a(this.f247507e, i.f247480n, this.f247506d, a18, str, wUserSigInfo);
                        if (this.f247503a) {
                            i.d(str);
                            return;
                        }
                        return;
                    } catch (Exception e19) {
                        QLog.e(str3, 1, "OnGetStWithPasswd succ exception " + e19.toString(), e19);
                        return;
                    }
                }
                a18.setMsgSuccess();
                a18.addAttribute(BaseConstants.Attribute_TAG_SERVERTIMEDIFF, Long.valueOf(i.f247480n.GetTimeDifference() * 1000));
            } else if (i16 == 1) {
                str3 = "MSF.C.WTLoginCenter.MsfProvider";
                a18.setBusinessFail(2005, errMsg.getMessage());
            } else if (i16 != 2) {
                str3 = "MSF.C.WTLoginCenter.MsfProvider";
                QLog.e(str3, 1, "OnGetStWithPasswd fail, " + errMsg.getMessage());
                a18.setBusinessFail(1001, errMsg.getMessage());
            } else {
                m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                this.f247508f = wUserSigInfo._seqence;
                if (TextUtils.isEmpty(errMsg.getOtherinfo())) {
                    m.b(str, this.f247507e, this.f247508f, this.f247506d, a18, errMsg.getMessage());
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "appUseWt = false; puzzle CAPTCHA " + errMsg.getOtherinfo());
                }
                m.a(this.f247507e, this.f247508f, this.f247506d, a18, errMsg.getOtherinfo());
                return;
            }
            i17 = 1;
        }
        if (i16 != 0) {
            if (errMsg.getType() == i17) {
                a18.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_URL, errMsg.getOtherinfo());
            }
            if ((i16 == 116 || i16 == 41) && (GetUserSigInfoTicket = WtloginHelper.GetUserSigInfoTicket(wUserSigInfo, 4194304)) != null) {
                byte[] bArr4 = GetUserSigInfoTicket._sig;
                if (bArr4 != null) {
                    a18.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_LHSIG, bArr4);
                } else {
                    QLog.e(str3, 1, "OnGetStWithPasswd ret: " + i16 + " , t is null.");
                }
            }
        }
        a18.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_RET, Integer.valueOf(i16));
        this.f247507e.addRespToQuque(this.f247506d, a18);
    }

    public void b(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, wUserSigInfo, devlockInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckDevLockStatus ret:" + i3);
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsfCommand(MsfCommand.wt_CheckDevLockStatus);
                a16.setMsgSuccess();
                a16.addAttribute(BuiltInServlet.MSF_KEY_SIG_INFO, wUserSigInfo);
                a16.addAttribute("devLockInfo", devlockInfo);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckDevLockStatus error " + e16, e16);
            }
        }
    }

    public void b(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCloseDevLock ret:" + i3);
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsfCommand(MsfCommand.wt_CloseDevLock);
                a16.setMsgSuccess();
                a16.addAttribute(BuiltInServlet.MSF_KEY_SIG_INFO, wUserSigInfo);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCloseDevLock error " + e16, e16);
            }
        }
    }

    public void b(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        Ticket GetUserSigInfoTicket;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, str, bArr, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRefreshSMSData ret:" + i3);
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsfCommand(MsfCommand.wt_CheckSMSAndGetSt);
                a16.setMsgSuccess();
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt response getuin = " + a16.getUin() + ", userAccount = " + str);
                if (!TextUtils.isEmpty(str) && !Objects.equals(str, "0") && MsfSdkUtils.isUinLong(str)) {
                    a16.setUin(str);
                }
                a16.addAttribute("userAccount", str);
                a16.addAttribute("userInput", bArr);
                a16.addAttribute(BuiltInServlet.MSF_KEY_SIG_INFO, wUserSigInfo);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                a16.addAttribute("userSigInfo", wUserSigInfo);
                a16.addAttribute("wtTicket", a(wUserSigInfo));
                a16.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
                try {
                    a16.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                a16.addAttribute("smsExtraData", WtloginHelper.getLoginResultData(wUserSigInfo, 1347));
                if (i3 == -1000) {
                    a16.setBusinessFail(1002);
                    QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt timeout");
                } else {
                    if (i3 == 0) {
                        try {
                            a(str);
                            m.a(this.f247507e, i.f247480n, str, wUserSigInfo);
                            m.a(this.f247507e, i.f247480n, this.f247506d, a16, str, wUserSigInfo);
                            if (this.f247503a) {
                                i.d(str);
                                return;
                            }
                            return;
                        } catch (Exception e17) {
                            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt succ exception " + e17.toString(), e17);
                            return;
                        }
                    }
                    if (i3 == 2) {
                        m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                        long j3 = wUserSigInfo._seqence;
                        this.f247508f = j3;
                        m.b(str, this.f247507e, j3, this.f247506d, a16, errMsg.getMessage());
                        return;
                    }
                    if (i3 != 160 && i3 != 239) {
                        a16.setBusinessFail(1001, errMsg.getMessage());
                        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt failed");
                    } else {
                        m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                        long j16 = wUserSigInfo._seqence;
                        this.f247508f = j16;
                        m.a(str, this.f247507e, j16, this.f247506d, a16, errMsg.getMessage());
                        return;
                    }
                }
                if ((i3 == 116 || i3 == 41) && (GetUserSigInfoTicket = WtloginHelper.GetUserSigInfoTicket(wUserSigInfo, 4194304)) != null) {
                    byte[] bArr2 = GetUserSigInfoTicket._sig;
                    if (bArr2 != null) {
                        a16.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_LHSIG, bArr2);
                    } else if (QLog.isColorLevel()) {
                        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt ret: " + i3 + " , t is null.");
                    }
                }
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e18) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt error " + e18, e18);
            }
        }
    }

    public void c(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        if (this.f247509g) {
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, 1);
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void a(String str, long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(j17), wUserSigInfo, Integer.valueOf(i16), errMsg);
        } else if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, this.f247506d.getRequestSsoSeq() + " found not need continue handle msg OnGetStWithoutPasswd.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x065e  */
    /* JADX WARN: Type inference failed for: r7v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, long j3, long j16, int i3, long j17, long[] jArr, WUserSigInfo wUserSigInfo, byte[][] bArr, int i16, ErrMsg errMsg) {
        boolean z16;
        FromServiceMsg fromServiceMsg;
        FromServiceMsg fromServiceMsg2;
        ?? r75;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(j17), jArr, wUserSigInfo, bArr, Integer.valueOf(i16), errMsg);
            return;
        }
        if (this.f247509g) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd serviceCmd=" + this.f247506d.getServiceCmd() + " ssoseq=" + this.f247506d.getRequestSsoSeq() + " ret=" + i16 + " error=" + errMsg);
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("userAccount", str);
                a16.addAttribute("dwSrcAppid", Long.valueOf(j3));
                a16.addAttribute("dwDstAppid", Long.valueOf(j16));
                a16.addAttribute("dwMainSigMap", Integer.valueOf(i3));
                a16.addAttribute("dwSubDstAppid", Long.valueOf(j17));
                a16.addAttribute("userSigInfo", wUserSigInfo);
                a16.addAttribute("wtTicket", a(wUserSigInfo));
                a16.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
                a16.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
                a16.addAttribute("openid", WtloginHelper.GetTicketSigKey(wUserSigInfo, 32768));
                a16.addAttribute(CommonConstant.KEY_ACCESS_TOKEN, WtloginHelper.GetTicketSig(wUserSigInfo, 32768));
                a16.addAttribute("ret", Integer.valueOf(i16));
                a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                boolean a17 = this.f247507e.getAccountCenter().g().a(wUserSigInfo.uin, wUserSigInfo);
                a16.addAttribute("hasUID", Boolean.valueOf(a17));
                if (a17 && !BaseApplication.getContext().getMSFInterfaceAdapter().useNtWtLogin()) {
                    byte[] GetTicketSig = WtloginHelper.GetTicketSig(wUserSigInfo, 262144);
                    byte[] GetTicketSig2 = WtloginHelper.GetTicketSig(wUserSigInfo, 64);
                    byte[] GetTicketSig3 = WtloginHelper.GetTicketSig(wUserSigInfo, 32);
                    byte[] GetTicketSig4 = WtloginHelper.GetTicketSig(wUserSigInfo, 4096);
                    byte[] bArr2 = new byte[16];
                    byte[] bArr3 = new byte[0];
                    try {
                        bArr3 = WtloginHelper.GetTicketSigKey(wUserSigInfo, 262144);
                    } catch (Exception e16) {
                        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "readD2Key error ", e16);
                    }
                    e.a(bArr2, 0, bArr3, bArr3.length);
                    this.f247507e.getAccountCenter().a(str, GetTicketSig3);
                    this.f247507e.getAccountCenter().a(str, GetTicketSig4, System.currentTimeMillis());
                    this.f247507e.getAccountCenter().a(str, GetTicketSig2, GetTicketSig, bArr2, System.currentTimeMillis());
                    d.f247429o.put(str, Boolean.TRUE);
                }
                this.f247507e.addRespToQuque(this.f247506d, a16);
                return;
            } catch (Exception e17) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd error " + e17, e17);
                return;
            }
        }
        FromServiceMsg a18 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a18.addAttribute("wtTicket", a(wUserSigInfo));
        a18.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
        try {
            a18.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        long longValue = (a18.getAttributes().containsKey(BaseConstants.TIMESTAMP_NET2MSF) && a18.getAttributes().containsKey(BaseConstants.TIMESTAMP_APP2MSF)) ? ((Long) a18.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - ((Long) this.f247506d.getAttribute(BaseConstants.TIMESTAMP_APP2MSF)).longValue() : 0L;
        long a19 = com.tencent.mobileqq.msf.core.c0.j.a(this.f247506d, a18);
        if (i16 == -1000) {
            FromServiceMsg fromServiceMsg3 = a18;
            fromServiceMsg3.setBusinessFail(1002);
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd timeout");
            fromServiceMsg2 = fromServiceMsg3;
            if (this.f247507e.getStatReporter() != null) {
                this.f247507e.getStatReporter().a(false, str, longValue, -1000, a19, a(i3), a(this.f247506d));
                fromServiceMsg2 = fromServiceMsg3;
            }
        } else if (i16 != 0) {
            String message = errMsg.getMessage();
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd2 fail, " + i16 + " " + message);
            if (!BaseApplication.getContext().getMSFInterfaceAdapter().useNtWtLogin()) {
                if (i16 == 1 || i16 == 192 || util.shouldKick(i16)) {
                    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, Thread.currentThread().getName() + " wtlogin kickout setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(a18.getUin()));
                    this.f247507e.getAccountCenter().n(a18.getUin());
                    a18.setBusinessFail(2001, message);
                    a18.addAttribute("changetoken", Boolean.TRUE);
                    MsfSdkUtils.addFromMsgProcessName("*", a18);
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (this.f247507e.getStatReporter() != null) {
                    this.f247507e.getStatReporter().a(false, str, longValue, i16, a19, a(i3), a(this.f247506d));
                }
                if (i16 == 15 && this.f247507e.getStatReporter() != null) {
                    this.f247507e.getStatReporter().a(longValue, a18.getBusinessFailCode(), a19);
                }
                fromServiceMsg = a18;
                if (this.f247504b) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnGetStWithoutPasswd2 found not need contine handle msg.");
                        return;
                    }
                    return;
                } else if (z16) {
                    this.f247507e.addRespToQuque(null, fromServiceMsg);
                    return;
                } else {
                    this.f247507e.addRespToQuque(this.f247506d, fromServiceMsg);
                    return;
                }
            }
            fromServiceMsg2 = a18;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f247506d.getRequestSsoSeq());
            sb5.append(" serviceCmd=");
            sb5.append(this.f247506d.getServiceCmd());
            sb5.append(" OnGetStWithoutPasswd2 succ, dwMainSigMap=");
            sb5.append(i3);
            sb5.append(", dwDstSubAppid.length=");
            sb5.append(jArr == null ? 0 : jArr.length);
            sb5.append(", st.length=");
            sb5.append(bArr == null ? 0 : bArr.length);
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, sb5.toString());
            try {
                this.f247507e.getAccountCenter().g().a(wUserSigInfo.uin, wUserSigInfo);
                a(str);
                a18.setMsgSuccess();
                RespondCustomSig respondCustomSig = new RespondCustomSig();
                respondCustomSig.reserved = new byte[0];
                respondCustomSig.SigList = new ArrayList<>();
                CustomSigContent customSigContent = new CustomSigContent();
                customSigContent.sResult = (short) 0;
                customSigContent.SigContent = new byte[0];
                if (this.f247506d.getServiceCmd().equals(BaseConstants.CMD_CHANGETOKEN_WEBVIEW_KEY)) {
                    if (BaseApplication.getContext().getMSFInterfaceAdapter().useNtWtLogin()) {
                        return;
                    }
                    byte[] GetTicketSig5 = WtloginHelper.GetTicketSig(wUserSigInfo, 32);
                    byte[] GetTicketSig6 = WtloginHelper.GetTicketSig(wUserSigInfo, 4096);
                    byte[] GetTicketSig7 = WtloginHelper.GetTicketSig(wUserSigInfo, 1048576);
                    byte[] GetTicketSig8 = WtloginHelper.GetTicketSig(wUserSigInfo, 134217728);
                    this.f247507e.getAccountCenter().a(str, GetTicketSig5);
                    this.f247507e.getAccountCenter().a(str, GetTicketSig6, System.currentTimeMillis());
                    this.f247507e.getAccountCenter().a(str, System.currentTimeMillis());
                    this.f247507e.getAccountCenter().f247404j.a(this.f247506d, a18);
                    byte[] bArr4 = wUserSigInfo._device_token;
                    if (bArr4 != null && bArr4.length > 0) {
                        l.a(str, bArr4);
                    }
                    try {
                        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd2 " + MsfSdkUtils.getShortStringKey(GetTicketSig6) + " " + MsfSdkUtils.getShortStringKey(GetTicketSig7) + " " + MsfSdkUtils.getShortHexKey(GetTicketSig5) + " " + MsfSdkUtils.getShortHexKey(GetTicketSig8));
                        if (this.f247507e.getStatReporter() != null) {
                            this.f247507e.getStatReporter().a(true, str, longValue, 0, a19, "WebTicket", a(this.f247506d));
                            return;
                        }
                        return;
                    } catch (Exception e19) {
                        e19.printStackTrace();
                        return;
                    }
                }
                r75 = this.f247506d.getServiceCmd().equals(BaseConstants.CMD_CHANGETOKEN_A2D2);
                try {
                    if (r75 != 0) {
                        if (BaseApplication.getContext().getMSFInterfaceAdapter().useNtWtLogin()) {
                            return;
                        }
                        byte[] GetTicketSig9 = WtloginHelper.GetTicketSig(wUserSigInfo, 262144);
                        byte[] GetTicketSig10 = WtloginHelper.GetTicketSig(wUserSigInfo, 64);
                        byte[] bArr5 = new byte[16];
                        byte[] bArr6 = new byte[0];
                        try {
                            bArr6 = WtloginHelper.GetTicketSigKey(wUserSigInfo, 262144);
                        } catch (Exception e26) {
                            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "readD2Key error " + e26);
                        }
                        e.a(bArr5, 0, bArr6, bArr6.length);
                        CustomSigContent customSigContent2 = new CustomSigContent();
                        customSigContent2.sResult = (short) 0;
                        try {
                            customSigContent2.ulSigType = 18L;
                            customSigContent2.SigContent = GetTicketSig9;
                            respondCustomSig.SigList.add(customSigContent2);
                            customSigContent.ulSigType = 0L;
                            customSigContent.SigContent = GetTicketSig10;
                            respondCustomSig.SigList.add(customSigContent);
                            CustomSigContent customSigContent3 = new CustomSigContent();
                            customSigContent3.ulSigType = 20L;
                            customSigContent3.SigContent = bArr5;
                            respondCustomSig.SigList.add(customSigContent3);
                            a18.addAttribute(a18.getServiceCmd(), respondCustomSig);
                            this.f247507e.getAccountCenter().f247404j.a(this.f247506d, a18);
                            if (this.f247507e.getStatReporter() != null) {
                                this.f247507e.getStatReporter().a(true, str, longValue, 0, a19, "BasicTicket", a(this.f247506d));
                                return;
                            }
                            return;
                        } catch (Exception e27) {
                            e = e27;
                            r75 = a18;
                        }
                    } else {
                        FromServiceMsg fromServiceMsg4 = a18;
                        if (this.f247506d.getServiceCmd().equals(BaseConstants.CMD_CHANGETOKEN_DA2)) {
                            fromServiceMsg4.getAttributes().put("da2", WtloginHelper.GetTicketSig(wUserSigInfo, 33554432));
                            if (this.f247507e.getStatReporter() != null) {
                                this.f247507e.getStatReporter().a(true, str, longValue, 0, a19, "BusTicket", a(this.f247506d));
                            }
                            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg4);
                            this.f247507e.addRespToQuque(this.f247506d, fromServiceMsg4);
                            return;
                        }
                        if ((i3 & 16384) == 16384) {
                            customSigContent.ulSigType = 16L;
                            customSigContent.SigContent = WtloginHelper.GetTicketSigKey(wUserSigInfo, 16384);
                            respondCustomSig.SigList.add(customSigContent);
                        }
                        UniPacket uniPacket = new UniPacket(true);
                        uniPacket.setEncodeName("UTF-8");
                        uniPacket.put(e.f247454n, respondCustomSig);
                        fromServiceMsg4.putWupBuffer(uniPacket.encode());
                        fromServiceMsg4.addAttribute(fromServiceMsg4.getServiceCmd(), respondCustomSig);
                        if (this.f247503a) {
                            i.d(str);
                        }
                        fromServiceMsg2 = fromServiceMsg4;
                        if (this.f247507e.getStatReporter() != null) {
                            this.f247507e.getStatReporter().a(true, str, longValue, 0, a19, "OtherTicket", a(this.f247506d));
                            fromServiceMsg2 = fromServiceMsg4;
                        }
                    }
                } catch (Exception e28) {
                    e = e28;
                }
            } catch (Exception e29) {
                e = e29;
                r75 = a18;
            }
            e = e29;
            r75 = a18;
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd2 error " + e.toString(), e);
            fromServiceMsg2 = r75;
        }
        z16 = false;
        fromServiceMsg = fromServiceMsg2;
        if (this.f247504b) {
        }
    }

    private void a(String str) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg(str, "msf.ticketchanged");
        fromServiceMsg.setUin(str);
        fromServiceMsg.setMsfCommand(MsfCommand.onTicketChanged);
        fromServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        this.f247507e.addRespToQuque(null, fromServiceMsg);
    }

    private String a(ToServiceMsg toServiceMsg) {
        ToServiceMsg toServiceMsg2 = this.f247506d;
        return (toServiceMsg2 == null || toServiceMsg2.getAttributes().get(MsfConstants.ATTRIBUTE_REFRESH_TICKET_SRC) == null) ? "OtherSrc" : (String) this.f247506d.getAttributes().get(MsfConstants.ATTRIBUTE_REFRESH_TICKET_SRC);
    }

    public void a(String str, WUserSigInfo wUserSigInfo, byte[] bArr, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, wUserSigInfo, bArr, Integer.valueOf(i3), errMsg);
            return;
        }
        if (this.f247510h) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("userAccount", str);
                a16.addAttribute("pictureData", bArr);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a16);
                return;
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshPictureData error, isVerifyPasswd, " + e16, e16);
                return;
            }
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a17 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a17.setMsgSuccess();
                a17.addAttribute("userAccount", str);
                a17.addAttribute("pictureData", bArr);
                a17.addAttribute("ret", Integer.valueOf(i3));
                a17.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a17);
                return;
            } catch (Exception e17) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshPictureData error, appUseWt, " + e17, e17);
                return;
            }
        }
        FromServiceMsg a18 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        if (i3 == 0) {
            m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
            long j3 = wUserSigInfo._seqence;
            this.f247508f = j3;
            m.b(str, this.f247507e, j3, this.f247506d, a18, errMsg.getMessage());
            return;
        }
        a18.setBusinessFail(1001, errMsg.getMessage());
        this.f247507e.addRespToQuque(this.f247506d, a18);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:16|17|(2:19|(1:21)(6:32|23|24|25|26|28))(1:33)|22|23|24|25|26|28) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0131, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0132, code lost:
    
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        int i16;
        Ticket GetUserSigInfoTicket;
        byte[] bArr2;
        byte[] bArr3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, bArr, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckPictureAndGetSt ret" + i3);
        }
        if (this.f247510h) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setServiceCmd(BaseConstants.CMD_VERIFY_PASSWD_IMAGE);
                a16.setMsfCommand(MsfCommand.verifyPasswdImage);
                a16.addAttribute("userAccount", str);
                a16.addAttribute("userInput", bArr);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                if (i3 == 0) {
                    a16.setMsgSuccess();
                } else if (i3 == 2) {
                    a16.addAttribute("image_buf", i.f247480n.GetPictureData(str));
                    a16.setBusinessFail(2020, errMsg.getMessage());
                }
                this.f247507e.addRespToQuque(this.f247506d, a16);
                return;
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt error, veryify pwd, " + e16, e16);
                return;
            }
        }
        if (this.f247509g) {
            try {
                byte[] bArr4 = new byte[0];
                if (i3 == 0) {
                    bArr2 = bArr4;
                    i.f247479m.getAccountCenter().a(false);
                } else {
                    if (i3 == 2) {
                        bArr3 = i.f247480n.GetPictureData(str);
                        FromServiceMsg a17 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                        a17.setMsfCommand(MsfCommand.wt_CheckPictureAndGetSt);
                        a17.setMsgSuccess();
                        a17.addAttribute("userAccount", str);
                        a17.addAttribute("userInput", bArr);
                        a17.addAttribute("image_buf", bArr3);
                        a17.addAttribute("userSigInfo", wUserSigInfo);
                        a17.addAttribute("ret", Integer.valueOf(i3));
                        a17.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                        a17.addAttribute("wtTicket", a(wUserSigInfo));
                        a17.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
                        a17.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
                        this.f247507e.addRespToQuque(this.f247506d, a17);
                        return;
                    }
                    bArr2 = bArr4;
                }
                bArr3 = bArr2;
                FromServiceMsg a172 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a172.setMsfCommand(MsfCommand.wt_CheckPictureAndGetSt);
                a172.setMsgSuccess();
                a172.addAttribute("userAccount", str);
                a172.addAttribute("userInput", bArr);
                a172.addAttribute("image_buf", bArr3);
                a172.addAttribute("userSigInfo", wUserSigInfo);
                a172.addAttribute("ret", Integer.valueOf(i3));
                a172.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                a172.addAttribute("wtTicket", a(wUserSigInfo));
                a172.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
                a172.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
                this.f247507e.addRespToQuque(this.f247506d, a172);
                return;
            } catch (Exception e17) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt error, appuserwt, " + e17, e17);
                return;
            }
        }
        FromServiceMsg a18 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a18.setMsfCommand(MsfCommand.wt_CheckPictureAndGetSt);
        a18.setMsgSuccess();
        a18.addAttribute("userAccount", str);
        a18.addAttribute("userInput", bArr);
        a18.addAttribute(BuiltInServlet.MSF_KEY_SIG_INFO, wUserSigInfo);
        a18.addAttribute("ret", Integer.valueOf(i3));
        a18.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
        a18.addAttribute("wtTicket", a(wUserSigInfo));
        a18.addAttribute("st_temp", WtloginHelper.GetTicketSig(wUserSigInfo, 128));
        a18.setUin(wUserSigInfo.uin);
        try {
            a18.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(wUserSigInfo, 128));
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        if (i3 == -1000) {
            i16 = 1;
            a18.setBusinessFail(1002);
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt timeout");
        } else {
            if (i3 == 0) {
                try {
                    a(str);
                    m.a(this.f247507e, i.f247480n, str, wUserSigInfo);
                    m.a(this.f247507e, i.f247480n, this.f247506d, a18, str, wUserSigInfo);
                    if (this.f247503a) {
                        i.d(str);
                        return;
                    }
                    return;
                } catch (Exception e19) {
                    QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt succ exception " + e19.toString(), e19);
                    return;
                }
            }
            if (i3 == 2) {
                m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                long j3 = wUserSigInfo._seqence;
                this.f247508f = j3;
                m.b(str, this.f247507e, j3, this.f247506d, a18, errMsg.getMessage());
                return;
            }
            if (i3 != 160 && i3 != 239) {
                a18.setBusinessFail(1001, errMsg.getMessage());
                i16 = 1;
                QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt failed");
            } else {
                m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                long j16 = wUserSigInfo._seqence;
                this.f247508f = j16;
                m.a(str, this.f247507e, j16, this.f247506d, a18, errMsg.getMessage());
                return;
            }
        }
        if (i3 != 0) {
            if (errMsg.getType() == i16) {
                a18.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_URL, errMsg.getOtherinfo());
            }
            if ((i3 == 116 || i3 == 41) && (GetUserSigInfoTicket = WtloginHelper.GetUserSigInfoTicket(wUserSigInfo, 4194304)) != null) {
                byte[] bArr5 = GetUserSigInfoTicket._sig;
                if (bArr5 != null) {
                    a18.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_LHSIG, bArr5);
                } else if (QLog.isColorLevel()) {
                    QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt ret: " + i3 + " , t is null.");
                }
            }
        }
        a18.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_RET, Integer.valueOf(i3));
        this.f247507e.addRespToQuque(this.f247506d, a18);
    }

    public void a(String str, int i3, WUserSigInfo wUserSigInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), wUserSigInfo);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnException " + str);
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setBusinessFail(3002, str);
                a16.addAttribute("error", str);
                a16.addAttribute("cmd", Integer.valueOf(i3));
                this.f247507e.addRespToQuque(this.f247506d, a16);
                return;
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnException error " + e16, e16);
                return;
            }
        }
        FromServiceMsg a17 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a17.setBusinessFail(3001, str);
        MsfSdkUtils.addFromMsgProcessName("*", a17);
        this.f247507e.addRespToQuque(this.f247506d, a17);
    }

    public void a(WUserSigInfo wUserSigInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) wUserSigInfo, (Object) str);
            return;
        }
        if (this.f247509g) {
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, 2);
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, str.getBytes());
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void a(WUserSigInfo wUserSigInfo, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) wUserSigInfo, (Object) bArr);
            return;
        }
        if (this.f247509g) {
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, 8);
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void a(WUserSigInfo wUserSigInfo, byte[] bArr, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, wUserSigInfo, bArr, obj);
            return;
        }
        if (this.f247509g) {
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, 9);
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void a(WUserSigInfo wUserSigInfo, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, wUserSigInfo, str, str2);
            return;
        }
        if (this.f247509g) {
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, 4);
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, str2.getBytes());
        } else {
            a16.setMsgSuccess();
            a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, str.getBytes());
        }
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void a(WUserSigInfo wUserSigInfo, int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, wUserSigInfo, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        if (this.f247509g) {
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, Integer.valueOf(i3));
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESENDTIME, Integer.valueOf(i16));
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_TIMEOVER, Integer.valueOf(i17));
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_ERRMSG, str);
        if (QLog.isColorLevel()) {
            QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | ret=" + i3);
        }
        if (i3 == 0) {
            byte[] regTlvValue = WtloginHelper.getRegTlvValue(wUserSigInfo, 36);
            if (regTlvValue != null) {
                String str2 = new String(regTlvValue);
                a16.addAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_UIN, str2);
                if (QLog.isColorLevel()) {
                    QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | uin=" + str2);
                }
            }
            byte[] regTlvValue2 = WtloginHelper.getRegTlvValue(wUserSigInfo, 6);
            if (regTlvValue2 != null) {
                try {
                    String str3 = new String(regTlvValue2, "utf-8");
                    a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_NICK, str3);
                    if (QLog.isColorLevel()) {
                        QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | nick=" + str3);
                    }
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
            }
            byte[] regTlvValue3 = WtloginHelper.getRegTlvValue(wUserSigInfo, 40);
            if (regTlvValue3 != null) {
                String str4 = new String(regTlvValue3);
                a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PICTURE_URL, str4);
                if (QLog.isColorLevel()) {
                    QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | bindFaceUrl=" + str4);
                }
            }
            byte[] regTlvValue4 = WtloginHelper.getRegTlvValue(wUserSigInfo, 51);
            if (regTlvValue4 != null) {
                String str5 = new String(regTlvValue4);
                a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_PHONE_PROTECT_UINS_URL, str5);
                if (QLog.isColorLevel()) {
                    QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | phoneProtectUinsUrl=" + str5);
                }
            }
        }
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void a(WUserSigInfo wUserSigInfo, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, wUserSigInfo, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, Integer.valueOf(i3));
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESENDTIME, Integer.valueOf(i16));
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_TIMEOVER, Integer.valueOf(i17));
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void a(WUserSigInfo wUserSigInfo, int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, wUserSigInfo, Integer.valueOf(i3), Long.valueOf(j3), bArr, bArr2, bArr3, bArr4);
            return;
        }
        if (this.f247509g) {
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, Integer.valueOf(i3));
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_UIN, String.valueOf(j3));
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_CONTACTSIG, bArr2);
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr3);
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG, bArr);
        if (bArr4 != null && bArr4.length > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRegGetAccount lhsig success");
            }
            a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_LH_SIG, bArr4);
        }
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void a(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Login_Optimize_WtProviderImpl", 2, "ret=" + i3);
        }
        if (this.f247509g) {
            return;
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(this.f247506d);
        a16.setMsgSuccess();
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE, Integer.valueOf(i3));
        a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO, bArr);
        this.f247507e.addRespToQuque(this.f247506d, a16);
    }

    public void a(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), bArr, Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), bArr2, bArr3, wUserSigInfo, wFastLoginInfo, Integer.valueOf(i16), errMsg);
            return;
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("userAccount", str);
                a16.addAttribute("dwSrcAppid", Long.valueOf(j3));
                a16.addAttribute("dwMainSigMap", Integer.valueOf(i3));
                a16.addAttribute("dwSubSrcAppid", Long.valueOf(j16));
                a16.addAttribute("dstAppName", bArr);
                a16.addAttribute("dwDstSsoVer", Long.valueOf(j17));
                a16.addAttribute("dwDstAppid", Long.valueOf(j18));
                a16.addAttribute("dwSubDstAppid", Long.valueOf(j19));
                a16.addAttribute("dstAppVer", bArr2);
                a16.addAttribute("dstAppSign", bArr3);
                a16.addAttribute("userSigInfo", wUserSigInfo);
                a16.addAttribute("fastLoginInfo", wFastLoginInfo);
                a16.addAttribute("wtTicket", wFastLoginInfo._outA1.clone());
                a16.addAttribute("ret", Integer.valueOf(i16));
                a16.addAttribute("errMsg", errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "onGetA1WithA1 error " + e16, e16);
            }
        }
    }

    public void a(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, wUserSigInfo, devlockInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnAskDevLockSms ret:" + i3);
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsfCommand(MsfCommand.wt_AskDevLockSms);
                a16.setMsgSuccess();
                a16.addAttribute(BuiltInServlet.MSF_KEY_SIG_INFO, wUserSigInfo);
                a16.addAttribute("devLockInfo", devlockInfo);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnAskDevLockSms error " + e16, e16);
            }
        }
    }

    public void a(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckDevLockSms ret:" + i3);
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsfCommand(MsfCommand.wt_CheckDevLockSms);
                a16.setMsgSuccess();
                a16.addAttribute(BuiltInServlet.MSF_KEY_SIG_INFO, wUserSigInfo);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckDevLockSms error " + e16, e16);
            }
        }
    }

    public void a(String str, long j3, WUserSigInfo wUserSigInfo, int i3, int i16, int i17, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, Long.valueOf(j3), wUserSigInfo, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), errMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRefreshSMSData ret:" + i17);
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsfCommand(MsfCommand.wt_RefreshSMSData);
                a16.setMsgSuccess();
                a16.addAttribute("userAccount", str);
                a16.addAttribute("smsAppid", Long.valueOf(j3));
                a16.addAttribute(BuiltInServlet.MSF_KEY_SIG_INFO, wUserSigInfo);
                a16.addAttribute("remainMsgCnt", Integer.valueOf(i3));
                a16.addAttribute("timeLimit", Integer.valueOf(i16));
                a16.addAttribute("ret", Integer.valueOf(i17));
                a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                a16.addAttribute("smsExtraData", WtloginHelper.getLoginResultData(wUserSigInfo, 1347));
                if (i17 == 0) {
                    m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                    long j16 = wUserSigInfo._seqence;
                    this.f247508f = j16;
                    m.a(str, this.f247507e, j16, this.f247506d, a16, errMsg.getMessage());
                } else {
                    a16.setBusinessFail(1001, errMsg.getMessage());
                    this.f247507e.addRespToQuque(this.f247506d, a16);
                }
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshSMSData error " + e16, e16);
            }
        }
    }

    public void a(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, int i3, ErrMsg errMsg) {
        Ticket GetUserSigInfoTicket;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, bArr, wUserSigInfo, bArr2, Integer.valueOf(i3), errMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRefreshSMSData ret:" + i3);
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsfCommand(MsfCommand.wt_CheckSMSAndGetStExt);
                a16.setMsgSuccess();
                a16.addAttribute("userAccount", str);
                a16.addAttribute("userInput", bArr);
                a16.addAttribute(BuiltInServlet.MSF_KEY_SIG_INFO, wUserSigInfo);
                a16.addAttribute("st", bArr2);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute(NotificationActivity.KEY_LAST_ERROR, errMsg);
                if (i3 == -1000) {
                    a16.setBusinessFail(1002);
                    QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt timeout");
                } else {
                    if (i3 == 0) {
                        try {
                            a(str);
                            m.a(this.f247507e, i.f247480n, str, wUserSigInfo);
                            m.a(this.f247507e, i.f247480n, this.f247506d, a16, str, wUserSigInfo);
                            if (this.f247503a) {
                                i.d(str);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt succ exception " + e16.toString(), e16);
                            return;
                        }
                    }
                    if (i3 == 2) {
                        m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                        long j3 = wUserSigInfo._seqence;
                        this.f247508f = j3;
                        m.b(str, this.f247507e, j3, this.f247506d, a16, errMsg.getMessage());
                        return;
                    }
                    if (i3 != 160 && i3 != 239) {
                        a16.setBusinessFail(1001, errMsg.getMessage());
                        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt failed");
                    } else {
                        m.f247498d.put(Integer.valueOf(this.f247506d.getRequestSsoSeq()), this);
                        long j16 = wUserSigInfo._seqence;
                        this.f247508f = j16;
                        m.a(str, this.f247507e, j16, this.f247506d, a16, errMsg.getMessage());
                        return;
                    }
                }
                if ((i3 == 116 || i3 == 41) && (GetUserSigInfoTicket = WtloginHelper.GetUserSigInfoTicket(wUserSigInfo, 4194304)) != null) {
                    byte[] bArr3 = GetUserSigInfoTicket._sig;
                    if (bArr3 != null) {
                        a16.addAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_LHSIG, bArr3);
                    } else if (QLog.isColorLevel()) {
                        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt ret: " + i3 + " , t is null.");
                    }
                }
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e17) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt error " + e17, e17);
            }
        }
    }

    public void a(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, str, bArr, Long.valueOf(j3), wUserSigInfo, bArr2, Integer.valueOf(i3));
            return;
        }
        if (this.f247509g) {
            try {
                ErrMsg errMsg = new ErrMsg();
                errMsg.setMessage(new String(bArr2, "utf-8"));
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("userAccount", str);
                a16.addAttribute("appName", bArr);
                a16.addAttribute("time", Long.valueOf(j3));
                a16.addAttribute("userSigInfo", wUserSigInfo);
                a16.addAttribute("errMsg", bArr2);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute("msg", errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCloseCode error " + e16, e16);
            }
        }
    }

    public void a(String str, byte[] bArr, long j3, List<byte[]> list, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, str, bArr, Long.valueOf(j3), list, wUserSigInfo, bArr2, Integer.valueOf(i3));
            return;
        }
        if (this.f247509g) {
            try {
                ErrMsg errMsg = new ErrMsg();
                errMsg.setMessage(new String(bArr2, "utf-8"));
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("userAccount", str);
                a16.addAttribute("appName", bArr);
                a16.addAttribute("time", Long.valueOf(j3));
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    Iterator it = ((ArrayList) list).iterator();
                    while (it.hasNext()) {
                        arrayList.add(HexUtil.bytes2HexStr((byte[]) it.next()));
                    }
                }
                a16.addAttribute("data", arrayList);
                a16.addAttribute("errMsg", bArr2);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute("msg", errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnVerifyCode error " + e16, e16);
            }
        }
    }

    public void a(int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), Long.valueOf(j3), bArr, bArr2, bArr3, bArr4);
            return;
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("userAccount", Long.valueOf(j3));
                a16.addAttribute("supersig", bArr);
                a16.addAttribute("contactssig", bArr2);
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute("msg", bArr3);
                if (bArr4 != null && bArr4.length > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRegGetSMSVerifyLoginAccount|lhsig success");
                    }
                    a16.attributes.put(MsfConstants.ATTRIBUTE_RESP_REGISTER_LH_SIG, bArr4);
                }
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRegGetSMSVerifyLoginAccount error " + e16, e16);
            }
        }
    }

    public void a(String str, long j3, int i3, long j16, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Integer.valueOf(i16), errMsg);
            return;
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("userAccount", str);
                a16.addAttribute("dwAppid", Long.valueOf(j3));
                a16.addAttribute("dwMainSigMap", Integer.valueOf(i3));
                a16.addAttribute("ret", Integer.valueOf(i16));
                a16.addAttribute("dwSubDstAppid", Long.valueOf(j16));
                a16.addAttribute("errMsg", errMsg);
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStViaSMSVerifyLogin error " + e16, e16);
            }
        }
    }

    public void a(long j3, long j16, String str, String str2, String str3, int i3, int i16, int i17, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Long.valueOf(j3), Long.valueOf(j16), str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), errMsg);
            return;
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("appid", Long.valueOf(j3));
                a16.addAttribute("subAppid", Long.valueOf(j16));
                a16.addAttribute("countryCode", str);
                a16.addAttribute("ret", Integer.valueOf(i17));
                a16.addAttribute(DeviceType.DeviceCategory.MOBILE, str2);
                a16.addAttribute("errMsg", errMsg);
                a16.addAttribute("msg", str3);
                a16.addAttribute("msgCnt", Integer.valueOf(i3));
                a16.addAttribute("timeLimit", Integer.valueOf(i16));
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSVerifyLoginAccount error " + e16, e16);
            }
        }
    }

    public void a(String str, String str2, int i3, int i16, int i17, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), errMsg);
            return;
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("ret", Integer.valueOf(i17));
                a16.addAttribute(DeviceType.DeviceCategory.MOBILE, str);
                a16.addAttribute("errMsg", errMsg);
                a16.addAttribute("msg", str2);
                a16.addAttribute("msgCnt", Integer.valueOf(i3));
                a16.addAttribute("timeLimit", Integer.valueOf(i16));
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshSMSVerifyLoginAccount error " + e16, e16);
            }
        }
    }

    public void a(String str, String str2, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, str2, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute(DeviceType.DeviceCategory.MOBILE, str);
                a16.addAttribute("errMsg", errMsg);
                a16.addAttribute("msgCode", str2);
                a16.addAttribute("userSigInfo", wUserSigInfo);
                a16.addAttribute(BaseConstants.ATTR_KET_SSO_SEQ, Integer.valueOf(this.f247506d.getRequestSsoSeq()));
                if (wUserSigInfo != null) {
                    DevlockInfo GetDevLockInfo = i.f247480n.GetDevLockInfo(null, wUserSigInfo._seqence);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("OnVerifySMSVerifyLoginAccount  DevlockInfo = ");
                    sb5.append(GetDevLockInfo == null);
                    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, sb5.toString());
                    a16.addAttribute(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, GetDevLockInfo);
                }
                this.f247507e.addRespToQuque(this.f247506d, a16);
            } catch (Exception e16) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnVerifySMSVerifyLoginAccount error ", e16);
            }
        }
    }

    public void a(long j3, WtloginHelper.QuickLoginParam quickLoginParam, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Long.valueOf(j3), quickLoginParam, Integer.valueOf(i3), errMsg);
            return;
        }
        if (this.f247509g) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "  called with: uin = [" + j3 + "], quickLoginParam = [" + quickLoginParam + "], ret = [" + i3 + "], errMsg = [" + errMsg + "]");
            FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
            a16.setMsgSuccess();
            a16.setUin(String.valueOf(j3));
            a16.addAttribute("ret", Integer.valueOf(i3));
            a16.addAttribute("errMsg", errMsg);
            a16.addAttribute("uin", Long.valueOf(j3));
            a16.addAttribute("userSigInfo", quickLoginParam.userSigInfo);
            this.f247507e.addRespToQuque(this.f247506d, a16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca A[Catch: Exception -> 0x00d2, TRY_LEAVE, TryCatch #2 {Exception -> 0x00d2, blocks: (B:11:0x0030, B:13:0x003c, B:15:0x005e, B:17:0x006e, B:19:0x0075, B:21:0x0086, B:34:0x00af, B:37:0x00ca), top: B:10:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i3, WUserSigInfo wUserSigInfo, String str, ErrMsg errMsg, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Integer.valueOf(i3), wUserSigInfo, str, errMsg, hashMap);
            return;
        }
        if (this.f247509g) {
            try {
                FromServiceMsg a16 = com.tencent.mobileqq.msf.service.n.a(this.f247506d);
                a16.setMsgSuccess();
                a16.addAttribute("ret", Integer.valueOf(i3));
                a16.addAttribute("errMsg", errMsg);
                a16.addAttribute("uin", str);
                a16.addAttribute(BaseConstants.ATTR_KET_EXTRA_MAP, hashMap);
                a16.addAttribute("userSigInfo", wUserSigInfo);
                a16.addAttribute(BaseConstants.ATTR_KET_SSO_SEQ, Integer.valueOf(this.f247506d.getRequestSsoSeq()));
                a16.addAttribute(BaseConstants.ATTR_KET_TO_SERVICE_MSG, this.f247506d);
                if (wUserSigInfo != null) {
                    a16.addAttribute(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, i.f247480n.GetDevLockInfo(null, wUserSigInfo._seqence));
                }
                if (i3 == 0 && !TextUtils.isEmpty(str)) {
                    try {
                        a(str);
                        m.a(this.f247507e, i.f247480n, str, wUserSigInfo);
                        m.a(this.f247507e, i.f247480n, this.f247506d, a16, str, wUserSigInfo);
                        try {
                            if (this.f247503a) {
                                i.d(str);
                            }
                            z16 = true;
                        } catch (Exception e16) {
                            e = e16;
                            z16 = true;
                            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "onLoginByGateway succ exception " + e.toString(), e);
                            if (z16) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                }
                if (z16) {
                    this.f247507e.addRespToQuque(this.f247506d, a16);
                }
            } catch (Exception e18) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "onLoginByGateway error " + e18, e18);
            }
        }
    }

    public void a(byte[] bArr, long j3, long j16, byte[] bArr2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) {
            j.a(this.f247509g, this.f247506d, this.f247507e, bArr, j3, j16, bArr2, i3);
        } else {
            iPatchRedirector.redirect((short) 41, this, bArr, Long.valueOf(j3), Long.valueOf(j16), bArr2, Integer.valueOf(i3));
        }
    }

    public void a(long j3, long j16, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 42)) {
            j.a(this.f247509g, this.f247506d, this.f247507e, j3, j16, bArr, i3);
        } else {
            iPatchRedirector.redirect((short) 42, this, Long.valueOf(j3), Long.valueOf(j16), bArr, Integer.valueOf(i3));
        }
    }
}
