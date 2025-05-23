package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.u;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class m {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    static final String f247495a = "MSF.C.WTLoginCenter.MsfProvider";

    /* renamed from: b, reason: collision with root package name */
    public static final String f247496b = "process";

    /* renamed from: c, reason: collision with root package name */
    public static final String f247497c = "com.tencent.mobileqq:openSdk";

    /* renamed from: d, reason: collision with root package name */
    static ConcurrentHashMap<Integer, o> f247498d = null;

    /* renamed from: e, reason: collision with root package name */
    public static final int f247499e = 262208;

    /* renamed from: f, reason: collision with root package name */
    public static final int f247500f = 34869344;

    /* renamed from: g, reason: collision with root package name */
    public static final int f247501g = 1052704;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24296);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f247498d = new ConcurrentHashMap<>();
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(int i3) {
    }

    public static o b(WUserSigInfo wUserSigInfo) {
        return f247498d.get(Integer.valueOf(a(wUserSigInfo)));
    }

    public static o c(WUserSigInfo wUserSigInfo) {
        return f247498d.remove(Integer.valueOf(a(wUserSigInfo)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b7, code lost:
    
        if (r5.equals(com.tencent.qphone.base.BaseConstants.CMD_WT_LOGIN_NAME2UIN) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(WUserSigInfo wUserSigInfo, String str, String str2, byte[] bArr, int i3, boolean z16, WtloginMsfListener wtloginMsfListener) {
        ToServiceMsg toServiceMsg;
        MsfCommand msfCommand;
        o oVar;
        if (QLog.isColorLevel()) {
            QLog.d(f247495a, 2, "SendData uin:" + str + " serviceCmd:" + str2 + " timeout:" + i3 + " isWTSendSelf:" + z16 + " wUserSigInfo:" + HexUtil.bytes2HexStr(wUserSigInfo._reserveData));
        }
        if (!z16) {
            int a16 = a(wUserSigInfo);
            oVar = f247498d.get(Integer.valueOf(a16));
            if (oVar == null) {
                QLog.e(f247495a, 1, "can not find WtloginWrapper sendData for " + a16);
                return -1;
            }
            oVar.f247505c = wtloginMsfListener;
            toServiceMsg = oVar.f247506d;
            MsfCommand msfCommand2 = toServiceMsg.getMsfCommand();
            msfCommand = MsfCommand.wt_name2uin;
            if (msfCommand2 == msfCommand && str2.equals(BaseConstants.CMD_WT_LOGIN_AUTH)) {
                oVar.f247507e.getAccountCenter().c(toServiceMsg.getUin(), str);
            }
            MsfCommand msfCommand3 = toServiceMsg.getMsfCommand();
            if (msfCommand3 != MsfCommand.wt_CheckSMSVerifyLoginAccount && msfCommand3 != MsfCommand.wt_RefreshSMSVerifyLoginCode && msfCommand3 != MsfCommand.wt_VerifySMSVerifyLoginCode) {
                if (str2.equals(BaseConstants.CMD_WT_LOGIN_AUTH)) {
                    msfCommand = MsfCommand.wt_loginAuth;
                }
            }
            msfCommand = msfCommand3;
        } else {
            toServiceMsg = new ToServiceMsg("", str, str2);
            toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
            toServiceMsg.setTimeout(i3);
            MsfSdkUtils.addToMsgProcessName("*", toServiceMsg);
            MsfCommand msfCommand4 = MsfCommand.wt_other;
            toServiceMsg.setMsfCommand(msfCommand4);
            a(toServiceMsg);
            a(i.f247479m, toServiceMsg);
            o oVar2 = f247498d.get(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
            oVar2.f247505c = wtloginMsfListener;
            msfCommand = msfCommand4;
            oVar = oVar2;
        }
        int length = bArr.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putInt(length);
        allocate.put(bArr);
        toServiceMsg.setUin(str);
        toServiceMsg.setServiceCmd(str2);
        toServiceMsg.setMsfCommand(msfCommand);
        toServiceMsg.putWupBuffer(allocate.array());
        return oVar.f247507e.sendSsoMsg(toServiceMsg);
    }

    public static void b(String str, MsfCore msfCore, long j3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str2) {
        try {
            byte[] GetPictureData = i.f247480n.GetPictureData(fromServiceMsg.getUin(), j3);
            u.a(fromServiceMsg);
            VerifyCodeInfo verifyCodeInfo = new VerifyCodeInfo();
            verifyCodeInfo.ssoSeq = fromServiceMsg.getRequestSsoSeq();
            verifyCodeInfo.verifyimage = GetPictureData;
            try {
                verifyCodeInfo.verifyNote = a(str, i.f247480n.GetPicturePrompt(str, j3));
            } catch (Exception e16) {
                QLog.e(f247495a, 1, "getImagePrompt exception " + e16.toString(), e16);
                verifyCodeInfo.verifyNote = "getTipErr";
            }
            VerifyCodeInfo.putVerifyCodeInfo(fromServiceMsg, verifyCodeInfo);
            fromServiceMsg.setBusinessFail(2002, str2);
            msfCore.addRespToQuque(toServiceMsg, fromServiceMsg);
        } catch (Exception e17) {
            QLog.e(f247495a, 1, "OnGetStWithPasswd exception " + e17.toString(), e17);
        }
    }

    public static WUserSigInfo c(int i3) {
        try {
            HashSet<String> o06 = com.tencent.mobileqq.msf.core.x.b.o0();
            WUserSigInfo wUserSigInfo = new WUserSigInfo();
            wUserSigInfo._reserveData = MsfSdkUtils.convertInt2Bytes(i3);
            if (o06 != null) {
                Iterator<String> it = o06.iterator();
                while (it.hasNext()) {
                    wUserSigInfo._domains.add(it.next());
                }
            }
            return wUserSigInfo;
        } catch (Exception e16) {
            QLog.d(f247495a, 1, "getWUSigInfoFromSeq error " + i3, e16);
            return null;
        }
    }

    public static WUserSigInfo b(int i3) {
        try {
            WUserSigInfo wUserSigInfo = new WUserSigInfo();
            wUserSigInfo._reserveData = MsfSdkUtils.convertInt2Bytes(i3);
            return wUserSigInfo;
        } catch (Exception e16) {
            QLog.d(f247495a, 1, "getWUSigInfoFromSeq error " + i3, e16);
            return null;
        }
    }

    public static void a(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return;
        }
        if (toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_APP2MSF) == null) {
            toServiceMsg.addAttribute(BaseConstants.TIMESTAMP_APP2MSF, Long.valueOf(System.currentTimeMillis()));
        }
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_WTLOGIN_OLDCMD, toServiceMsg.getServiceCmd());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static o a(MsfCore msfCore, ToServiceMsg toServiceMsg) {
        o oVar;
        MsfCommand msfCommand = null;
        try {
            MsfCommand msfCommand2 = toServiceMsg.getMsfCommand();
            try {
                if (msfCommand2 != MsfCommand.refreVerifyCode && toServiceMsg.getMsfCommand() != MsfCommand.submitVerifyCode && toServiceMsg.getMsfCommand() != MsfCommand.wt_CheckPictureAndGetSt && toServiceMsg.getMsfCommand() != MsfCommand.wt_RefreshPictureData) {
                    if (toServiceMsg.getRequestSsoSeq() == -1) {
                        toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
                    }
                    oVar = new o(msfCore, toServiceMsg);
                    oVar.f247506d = toServiceMsg;
                    f247498d.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), oVar);
                    return oVar;
                }
                oVar = f247498d.get(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
                if (oVar == null) {
                    QLog.e(f247495a, 1, "can not find wtloginMsfListener VerifyCode for " + toServiceMsg.getRequestSsoSeq());
                    return null;
                }
                oVar.f247506d = toServiceMsg;
                f247498d.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), oVar);
                return oVar;
            } catch (Exception e16) {
                e = e16;
                msfCommand = msfCommand2;
                e.printStackTrace();
                return msfCommand;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        o oVar = f247498d.get(Integer.valueOf(fromServiceMsg.getRequestSsoSeq()));
        if (oVar == null) {
            QLog.e(f247495a, 1, "can not find wtloginMsfListener onRecvData for " + fromServiceMsg.getRequestSsoSeq());
            return;
        }
        QLog.d(f247495a, 1, "onRecvData find wtloginMsfListener for " + fromServiceMsg.getRequestSsoSeq());
        String str = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_WTLOGIN_OLDCMD);
        if (str != null) {
            toServiceMsg.setServiceCmd(str);
        }
        if (fromServiceMsg.isSuccess()) {
            ByteBuffer wrap = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
            wrap.order(ByteOrder.BIG_ENDIAN);
            int i3 = wrap.getInt() - 4;
            byte[] bArr = new byte[i3];
            wrap.get(bArr, 0, i3);
            oVar.f247505c.onReceiveData(fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd(), bArr);
            return;
        }
        oVar.f247505c.onReceiveFail(fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd(), fromServiceMsg.getBusinessFailCode());
    }

    public static void a(MsfCore msfCore, WtloginHelper wtloginHelper, String str, WUserSigInfo wUserSigInfo) {
        try {
            WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
            if (wtloginHelper.GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
                str = String.valueOf(wloginSimpleInfo._uin);
            }
            if (a(str)) {
                msfCore.getAccountCenter().g().a(str, wUserSigInfo);
            } else {
                msfCore.getAccountCenter().g().a(wUserSigInfo.uin, wUserSigInfo);
            }
        } catch (Exception e16) {
            QLog.e(f247495a, 1, e16, new Object[0]);
        }
    }

    public static void a(MsfCore msfCore, WtloginHelper wtloginHelper, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str, WUserSigInfo wUserSigInfo) {
        if (wUserSigInfo == null) {
            return;
        }
        QLog.d(f247495a, 1, "wtlogin succ.");
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        String valueOf = wtloginHelper.GetBasicUserInfo(str, wloginSimpleInfo).booleanValue() ? String.valueOf(wloginSimpleInfo._uin) : str;
        byte[] bArr = new byte[16];
        byte[] GetTicketSig = WtloginHelper.GetTicketSig(wUserSigInfo, 262144);
        byte[] bArr2 = new byte[0];
        try {
            bArr2 = WtloginHelper.GetTicketSigKey(wUserSigInfo, 262144);
        } catch (Exception e16) {
            QLog.d(f247495a, 1, "readD2Key error " + e16);
        }
        byte[] GetTicketSig2 = WtloginHelper.GetTicketSig(wUserSigInfo, 64);
        byte[] GetTicketSig3 = WtloginHelper.GetTicketSig(wUserSigInfo, 4096);
        byte[] GetTicketSig4 = WtloginHelper.GetTicketSig(wUserSigInfo, 32);
        e.a(bArr, 0, bArr2, bArr2.length);
        a aVar = new a(valueOf);
        aVar.b(GetTicketSig2);
        aVar.f(GetTicketSig);
        aVar.g(bArr);
        aVar.l(GetTicketSig3);
        aVar.m(GetTicketSig4);
        aVar.b(com.tencent.mobileqq.msf.service.n.b(toServiceMsg));
        if (wtloginHelper.GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            aVar.a((int) wloginSimpleInfo._age[0]);
            aVar.j(wloginSimpleInfo._nick);
            aVar.d(wloginSimpleInfo._gender[0] == 1 ? 1 : 2);
            aVar.c(util.buf_to_int16(wloginSimpleInfo._face, 0));
        }
        QLog.d(f247495a, 1, Thread.currentThread().getName() + " handleLoginSucc updateAccount " + MsfSdkUtils.getShortUin(aVar.z()));
        String str2 = (String) toServiceMsg.getAttribute("from_where");
        if (!"subaccount".equals(str2) && !BaseConstants.SSO_ACCOUNT_ACTION.equals(str2)) {
            msfCore.getAccountCenter().d(valueOf, "login");
        }
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_SIMPLEACCOUNT, msfCore.getAccountCenter().d(aVar).w().toStoreString());
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.addAttribute(BaseConstants.Attribute_TAG_SERVERTIMEDIFF, Long.valueOf(wtloginHelper.GetTimeDifference() * 1000));
        msfCore.addRespToQuque(toServiceMsg, fromServiceMsg);
        byte[] bArr3 = wUserSigInfo._device_token;
        if (bArr3 == null || bArr3.length <= 0) {
            return;
        }
        l.a(valueOf, bArr3);
        i.f247480n.SetUinDeviceToken(false);
    }

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && !Objects.equals(str, "0")) {
            try {
                Long.parseLong(str);
                return true;
            } catch (Exception e16) {
                QLog.e(f247495a, 1, e16, new Object[0]);
            }
        }
        return false;
    }

    public static void a(String str, MsfCore msfCore, long j3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str2) {
        try {
            DevlockInfo GetDevLockInfo = i.f247480n.GetDevLockInfo(str, j3);
            if (fromServiceMsg.getAttribute("timeLimit") != null) {
                GetDevLockInfo.TimeLimit = ((Integer) fromServiceMsg.getAttribute("timeLimit")).intValue();
            }
            if (GetDevLockInfo != null && QLog.isColorLevel() && QLog.isColorLevel()) {
                QLog.d(f247495a, 2, "GetDevLockInfo: " + GetDevLockInfo.Mobile + " " + GetDevLockInfo.DevSetup);
            }
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, GetDevLockInfo);
            fromServiceMsg.setBusinessFail(2016, str2);
            msfCore.addRespToQuque(toServiceMsg, fromServiceMsg);
        } catch (Exception e16) {
            QLog.e(f247495a, 1, "OnGetStWithPasswd exception " + e16.toString(), e16);
        }
    }

    public static void a(MsfCore msfCore, long j3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str) {
        VerifyCodeInfo verifyCodeInfo = new VerifyCodeInfo();
        verifyCodeInfo.ssoSeq = fromServiceMsg.getRequestSsoSeq();
        verifyCodeInfo.verifyurl = str;
        VerifyCodeInfo.putVerifyCodeInfo(fromServiceMsg, verifyCodeInfo);
        fromServiceMsg.setBusinessFail(2002, "");
        msfCore.addRespToQuque(toServiceMsg, fromServiceMsg);
    }

    public static String a(String str, byte[] bArr) {
        int buf_to_int8;
        int buf_to_int82;
        int buf_to_int32;
        int i3;
        int buf_to_int322;
        if (bArr != null && bArr.length > 3) {
            int i16 = 0;
            int buf_to_int323 = util.buf_to_int32(bArr, 0);
            int i17 = 4;
            while (i16 < buf_to_int323) {
                int i18 = i17 + 1;
                if (bArr.length < i18 || bArr.length < (buf_to_int82 = i18 + (buf_to_int8 = util.buf_to_int8(bArr, i17)))) {
                    break;
                }
                String str2 = new String(bArr, i18, buf_to_int8);
                if (bArr.length < buf_to_int82 + 2 || bArr.length < (buf_to_int322 = (i3 = buf_to_int82 + 4) + (buf_to_int32 = util.buf_to_int32(bArr, buf_to_int82)))) {
                    break;
                }
                String str3 = new String(bArr, i3, buf_to_int32);
                util.LOGI("key_data:" + str2 + " value:" + str3);
                if (str2.equals("pic_reason")) {
                    return str3;
                }
                i16++;
                i17 = buf_to_int322;
            }
        }
        return null;
    }

    public static int a(WUserSigInfo wUserSigInfo) {
        try {
            return MsfSdkUtils.convertBytes2Int(wUserSigInfo._reserveData);
        } catch (Exception e16) {
            QLog.d(f247495a, 1, "getSsoSeqFromInfo error " + wUserSigInfo, e16);
            return -1;
        }
    }
}
