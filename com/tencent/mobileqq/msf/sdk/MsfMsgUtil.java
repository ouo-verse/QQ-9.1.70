package com.tencent.mobileqq.msf.sdk;

import android.content.Intent;
import android.os.SystemClock;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.MainService;
import mqq.app.api.ProcessConstant;
import oicq.wlogin_sdk.request.WFastLoginInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfMsgUtil {
    static IPatchRedirector $redirector_;

    public MsfMsgUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] addByteLen(byte[] bArr) {
        int length = bArr.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(bArr).flip();
        return allocate.array();
    }

    public static ToServiceMsg getAppDataIncermentMsg(String str, String str2, String[] strArr, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APP_DATAINCERMENT);
        toServiceMsg.setMsfCommand(MsfCommand.appDataIncerment);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_DATAINCERMENT_APP, new Object[]{strArr, Long.valueOf(j3)});
        toServiceMsg.setNeedCallback(false);
        return toServiceMsg;
    }

    public static ToServiceMsg getConnOpenMsg(String str) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_OPENCONN);
        toServiceMsg.setMsfCommand(MsfCommand.openConn);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.setTimeout(30000L);
        return toServiceMsg;
    }

    public static ToServiceMsg getCurrentDataCountMsg(String str, String[] strArr) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APP_GETDATACOUNT);
        toServiceMsg.addAttribute(toServiceMsg.getServiceCmd(), strArr);
        toServiceMsg.setMsfCommand(MsfCommand.getAppDataCount);
        return toServiceMsg;
    }

    public static ToServiceMsg getGatewayIpMsg(String str) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_GETGATEWAYIP);
        toServiceMsg.setMsfCommand(MsfCommand.getGatewayIp);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.setTimeout(30000L);
        return toServiceMsg;
    }

    public static ToServiceMsg getNetworkTrafficDebugInfo(String str) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_NETWORKTRAFFICDEBUGINFO);
        toServiceMsg.setMsfCommand(MsfCommand.getMsfDebugInfo);
        return toServiceMsg;
    }

    public static ToServiceMsg getRdmReportMsg(String str, RdmReq rdmReq) {
        Map<String, String> map = rdmReq.params;
        if (map != null) {
            map.put(com.tencent.mobileqq.msf.core.c0.j.K, String.valueOf(SystemClock.elapsedRealtime()));
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_REPORTRDM);
        toServiceMsg.setMsfCommand(MsfCommand.reportRdm);
        JceOutputStream jceOutputStream = new JceOutputStream();
        rdmReq.writeTo(jceOutputStream);
        toServiceMsg.addAttribute(toServiceMsg.getServiceCmd(), jceOutputStream.toByteArray());
        toServiceMsg.setNeedCallback(false);
        return toServiceMsg;
    }

    public static ToServiceMsg getReportLogMsg(String str, String str2, String str3, String str4) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APP_REPORTLOG);
        toServiceMsg.setMsfCommand(MsfCommand.appReportLog);
        toServiceMsg.getAttributes().put(toServiceMsg.getServiceCmd(), new String[]{str2, str3, str4});
        toServiceMsg.setNeedCallback(false);
        return toServiceMsg;
    }

    public static ToServiceMsg getSetConnStatusMsg(String str, int i3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_SETMSFCONNSTATUS);
        toServiceMsg.setMsfCommand(MsfCommand.setMsfConnStatus);
        toServiceMsg.setNeedCallback(true);
        toServiceMsg.getAttributes().put("status", Integer.valueOf(i3));
        toServiceMsg.setTimeout(30000L);
        return toServiceMsg;
    }

    public static ToServiceMsg getSignalMsg() {
        ToServiceMsg toServiceMsg = new ToServiceMsg("", "0", ProcessConstant.MSF);
        toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
        toServiceMsg.setMsfCommand(MsfCommand.msf_msgsignal);
        int length = "CHNK".getBytes().length + 13 + 1 + 0 + 4;
        byte length2 = (byte) ("CHNK".getBytes().length + 1);
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).putInt(20140601).putInt(0).put(length2).put("CHNK".getBytes()).put((byte) 1).putInt(0);
        toServiceMsg.putWupBuffer(allocate.array());
        return toServiceMsg;
    }

    public static ToServiceMsg getUIDWithoutPasswd(String str, String str2, long j3, long j16, long j17) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_getUIDWithoutPasswd);
        toServiceMsg.getAttributes().put("dwSrcAppid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("dwDstAppid", Long.valueOf(j16));
        toServiceMsg.setTimeout(j17);
        return toServiceMsg;
    }

    public static ToServiceMsg getWtRefreshMemorySigMsg(String str) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_refreshMemorySig);
        return toServiceMsg;
    }

    public static ToServiceMsg getWxLoginMsg(String str, long j3, long j16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.loginByWx);
        toServiceMsg.getAttributes().put("appid", Long.valueOf(j3));
        toServiceMsg.setTimeout(j16);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_AskDevLockSms(String str, String str2, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_AskDevLockSms);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_CancelCode(String str, String str2, long j3, byte[] bArr, byte[] bArr2, long j16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_CancelCode);
        toServiceMsg.getAttributes().put("appid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("code", bArr);
        toServiceMsg.getAttributes().put(MainService.UIN_NOT_MATCH_TAG, 1);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_PB_DATA, bArr2);
        toServiceMsg.setTimeout(j16);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_CheckDevLockSms(String str, String str2, long j3, String str3, byte[] bArr, long j16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_CheckDevLockSms);
        toServiceMsg.getAttributes().put("subAppid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("smdCode", str3);
        toServiceMsg.getAttributes().put("sppKey", bArr);
        toServiceMsg.setTimeout(j16);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_CheckDevLockStatus(String str, String str2, long j3, long j16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_CheckDevLockStatus);
        toServiceMsg.getAttributes().put("subAppid", Long.valueOf(j3));
        toServiceMsg.setTimeout(j16);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_CheckPictureAndGetSt(String str, String str2, byte[] bArr, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_CheckPictureAndGetSt);
        toServiceMsg.getAttributes().put("userInput", bArr);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_CheckSMSAndGetSt(String str, String str2, byte[] bArr, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_CheckSMSAndGetSt);
        toServiceMsg.getAttributes().put("userInput", bArr);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_CheckSMSAndGetStExt(String str, String str2, byte[] bArr, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_CheckSMSAndGetStExt);
        toServiceMsg.getAttributes().put("userInput", bArr);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_CheckSMSVerifyLoginAccount(String str, String str2, String str3, int i3, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_CheckSMSVerifyLoginAccount);
        toServiceMsg.getAttributes().put("countryCode", str3);
        toServiceMsg.getAttributes().put("userAccount", str2);
        toServiceMsg.getAttributes().put("appid", Integer.valueOf(i3));
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_CloseCode(String str, String str2, long j3, byte[] bArr, int i3, ArrayList<String> arrayList, long j16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_CloseCode);
        toServiceMsg.getAttributes().put("appid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("code", bArr);
        toServiceMsg.getAttributes().put("version", Integer.valueOf(i3));
        toServiceMsg.getAttributes().put("data", arrayList);
        toServiceMsg.getAttributes().put(MainService.UIN_NOT_MATCH_TAG, 1);
        toServiceMsg.setTimeout(j16);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_CloseDevLock(String str, String str2, long j3, long j16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_CloseDevLock);
        toServiceMsg.getAttributes().put("subAppid", Long.valueOf(j3));
        toServiceMsg.setTimeout(j16);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_FetchCodeSigVerifyLogin(String str, int i3, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_FetchCodeSigVerifyLogin);
        toServiceMsg.getAttributes().put("subAppid", Integer.valueOf(i3));
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_GetA1WithA1(String str, String str2, long j3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WFastLoginInfo wFastLoginInfo, long j26) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetA1WithA1);
        toServiceMsg.getAttributes().put("dwSrcAppid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("dwSubSrcAppid", Long.valueOf(j16));
        toServiceMsg.getAttributes().put("dstAppName", bArr);
        toServiceMsg.getAttributes().put("dwDstSsoVer", Long.valueOf(j17));
        toServiceMsg.getAttributes().put("dwDstAppid", Long.valueOf(j18));
        toServiceMsg.getAttributes().put("dwSubDstAppid", Long.valueOf(j19));
        toServiceMsg.getAttributes().put("dstAppVer", bArr2);
        toServiceMsg.getAttributes().put("dstAppSign", bArr3);
        toServiceMsg.getAttributes().put("fastLoginInfo", wFastLoginInfo);
        toServiceMsg.setTimeout(j26);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_GetOpenKeyWithoutPasswd(String str, String str2, long j3, long j16, long j17) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetOpenKeyWithoutPasswd);
        toServiceMsg.getAttributes().put("dwSrcAppid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("dwDstAppid", Long.valueOf(j16));
        toServiceMsg.setTimeout(j17);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_GetSaltUinList(String str, long j3, long j16, boolean z16, byte[] bArr, long j17) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.getAttributes().put("appid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("subAppid", Long.valueOf(j16));
        toServiceMsg.getAttributes().put("isFromIFrame", Boolean.valueOf(z16));
        toServiceMsg.getAttributes().put("pwd", bArr);
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetSaltUinList);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_GetStViaGatewayLogin(String str, int i3, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.getAttributes().put("appid", Integer.valueOf(i3));
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetStViaGatewayLogin);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_GetStViaPhonePwdLogin(String str, long j3, long j16, long j17) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.getAttributes().put("appid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("subAppid", Long.valueOf(j16));
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetStViaPhonePwdLogin);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_GetStViaSMSVerifyLogin(String str, String str2, String str3, int i3, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetStViaSMSVerifyLogin);
        toServiceMsg.getAttributes().put("userAccount", str3);
        toServiceMsg.getAttributes().put("countryCode", str2);
        toServiceMsg.getAttributes().put("appid", Integer.valueOf(i3));
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_GetStViaWxLogin(String str, long j3, long j16, long j17) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.getAttributes().put("appid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("subAppid", Long.valueOf(j16));
        toServiceMsg.setMsfCommand(MsfCommand.wt_getStViaWxLogin);
        toServiceMsg.setTimeout(j17);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_GetStWithPasswd(String str, String str2, long j3, String str3, long j16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetStWithPasswd);
        toServiceMsg.getAttributes().put("appid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("passwd", str3);
        toServiceMsg.setTimeout(j16);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_GetStWithoutPasswd(String str, String str2, long j3, long j16, long j17) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetStWithoutPasswd);
        toServiceMsg.getAttributes().put("dwSrcAppid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("dwDstAppid", Long.valueOf(j16));
        toServiceMsg.setTimeout(j17);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_GetSubaccountStViaSMSVerifyLogin(String str, String str2, String str3, String str4, int i3, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetStViaSMSVerifyLogin);
        toServiceMsg.getAttributes().put("userAccount", str4);
        toServiceMsg.getAttributes().put("countryCode", str3);
        toServiceMsg.getAttributes().put("appid", Integer.valueOf(i3));
        toServiceMsg.getAttributes().put("from_where", "subaccount");
        toServiceMsg.getAttributes().put("mainaccount", str2);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_QueryCodeResult(String str, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_QueryCodeResult);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_QuickLoginByGateway(String str, Intent intent, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_QuickLoginByGateway);
        byte[] byteArrayExtra = intent.getByteArrayExtra(BaseConstants.ATTR_KET_PHONE_TOKEN);
        if (byteArrayExtra != null) {
            toServiceMsg.addAttribute(BaseConstants.ATTR_KET_PHONE_TOKEN, byteArrayExtra);
        }
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_RefreshPictureData(String str, String str2, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_RefreshPictureData);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_RefreshSMSData(String str, String str2, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_RefreshSMSData);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_RefreshSMSVerifyLoginCode(String str, String str2, String str3, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_RefreshSMSVerifyLoginCode);
        toServiceMsg.getAttributes().put("userAccount", str3);
        toServiceMsg.getAttributes().put("countryCode", str2);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_RegGetSMSVerifyLoginAccount(String str, byte[] bArr, byte[] bArr2, String str2, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_RegGetSMSVerifyLoginAccount);
        toServiceMsg.getAttributes().put("msgchk", bArr);
        toServiceMsg.getAttributes().put("nick", bArr2);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION, str2);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_SetDevlockMobileType(String str, int i3, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_SetDevlockMobileType);
        toServiceMsg.getAttributes().put("mobile_type", Integer.valueOf(i3));
        toServiceMsg.setTimeout(j3);
        toServiceMsg.setNeedCallback(false);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_VerifyCode(String str, String str2, long j3, boolean z16, byte[] bArr, int[] iArr, int i3, long j16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, str2, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_VerifyCode);
        toServiceMsg.getAttributes().put("appid", Long.valueOf(j3));
        toServiceMsg.getAttributes().put("close", Boolean.valueOf(z16));
        toServiceMsg.getAttributes().put("code", bArr);
        toServiceMsg.getAttributes().put("tlv", iArr);
        toServiceMsg.getAttributes().put("version", Integer.valueOf(i3));
        toServiceMsg.getAttributes().put(MainService.UIN_NOT_MATCH_TAG, 1);
        toServiceMsg.setTimeout(j16);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_VerifySMSVerifyLoginCode(String str, String str2, String str3, String str4, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_VerifySMSVerifyLoginCode);
        toServiceMsg.getAttributes().put("code", str4);
        toServiceMsg.getAttributes().put("userAccount", str3);
        toServiceMsg.getAttributes().put("countryCode", str2);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_getStWithQrSig(String str, String str2, int i3, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_getStWithQrSig);
        toServiceMsg.getAttributes().put("account", str2);
        toServiceMsg.getAttributes().put("subAppid", Integer.valueOf(i3));
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_setRegDevLockFlag(String str, int i3, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_setRegDevLockFlag);
        toServiceMsg.getAttributes().put("flag", Integer.valueOf(i3));
        toServiceMsg.setTimeout(j3);
        toServiceMsg.setNeedCallback(false);
        return toServiceMsg;
    }

    public static boolean hasResendMsg(ToServiceMsg toServiceMsg, String str) {
        if (toServiceMsg == null || str == null || toServiceMsg.getAttributes().get(str) == null) {
            return false;
        }
        return ((Boolean) toServiceMsg.getAttributes().get(str)).booleanValue();
    }

    public static ToServiceMsg keepProcessAliveMsg(String str, boolean z16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_KEEP_PROCESS_ALIVE);
        toServiceMsg.setMsfCommand(MsfCommand.keepProcessAlive);
        toServiceMsg.setNeedCallback(true);
        toServiceMsg.getAttributes().put("keepAlive", Boolean.valueOf(z16));
        toServiceMsg.setTimeout(30000L);
        return toServiceMsg;
    }

    public static ToServiceMsg get_wt_RegGetSMSVerifyLoginAccount(String str, byte[] bArr, byte[] bArr2, String str2, String str3, String str4, long j3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_RegGetSMSVerifyLoginAccount);
        toServiceMsg.getAttributes().put("msgchk", bArr);
        toServiceMsg.getAttributes().put("nick", bArr2);
        if (str2 != null && str2.length() > 0) {
            toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_LH_UIN, str2);
        } else if (str3 != null && str3.length() > 0) {
            toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_UNBIND_LH_UIN, str3);
        }
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION, str4);
        toServiceMsg.setTimeout(j3);
        return toServiceMsg;
    }
}
