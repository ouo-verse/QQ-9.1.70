package com.tencent.mobileqq.loginregister.servlet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.pb.AccountLogic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.UUID;
import mqq.app.Constants;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends MSFServlet {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String a() {
        String uuid = UUID.randomUUID().toString();
        if (TextUtils.isEmpty(uuid)) {
            return "";
        }
        return uuid.replaceAll("[^(0-9A-Za-z)]", "");
    }

    private void addOpenSdkExtra(Intent intent, ToServiceMsg toServiceMsg) {
        Bundle bundleExtra;
        if ("com.tencent.mobileqq:openSdk".equals(intent.getStringExtra("process")) && (bundleExtra = intent.getBundleExtra("extra")) != null) {
            for (String str : bundleExtra.keySet()) {
                toServiceMsg.addAttribute(str, bundleExtra.get(str));
                QLog.d("LoginServlet", 1, "addOpenSdkExtra --> key=" + str + ", value=" + bundleExtra.get(str));
            }
        }
    }

    private void b(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        String str2 = "";
        QLog.i("LoginServlet", 1, "onReceiveForQueryWxBindState ret=" + fromServiceMsg.getBusinessFailCode() + " trpcRspRetCode=" + fromServiceMsg.getTrpcRspRetCode() + " trpcRspFuncRetCode=" + fromServiceMsg.getTrpcRspFuncRetCode() + " msg=" + fromServiceMsg.getBusinessFailMsg());
        byte[] e16 = e(fromServiceMsg.getWupBuffer());
        if (e16 == null) {
            QLog.w("LoginServlet", 1, "onReceiveForQueryWxBindState wupBuffer is empty");
        }
        Bundle bundle = new Bundle();
        if (fromServiceMsg.isSuccess() && e16 != null) {
            AccountLogic.Cmd0x11fdResponse cmd0x11fdResponse = new AccountLogic.Cmd0x11fdResponse();
            try {
                cmd0x11fdResponse.mergeFrom(e16);
            } catch (Exception e17) {
                QLog.e("LoginServlet", 1, "onReceiveForQueryWxBindState wupBuffer", e17);
            }
            bundle.putInt("wxBindState", cmd0x11fdResponse.bind_state_thirdpart.get());
            bundle.putInt("qqBindState", cmd0x11fdResponse.binding_state_qq.get());
            long j3 = cmd0x11fdResponse.uin_info.uin.get();
            try {
                str = cmd0x11fdResponse.uin_info.nick_name.get().toStringUtf8();
            } catch (Exception e18) {
                QLog.e("LoginServlet", 1, "onReceiveForQueryWxBindState nickname", e18);
                str = "";
            }
            String str3 = cmd0x11fdResponse.third_part_info.wx_info.head_img_url.get();
            String str4 = cmd0x11fdResponse.third_part_info.wx_info.nick_name.get();
            String str5 = cmd0x11fdResponse.profile_sig.get();
            if (j3 != 0) {
                str2 = String.valueOf(j3);
            }
            bundle.putParcelable("wxBindInfo", new WechatInfo(str3, str4, str5, str2, str, cmd0x11fdResponse.uin_info.head_url.get()));
        } else {
            int trpcRspFuncRetCode = fromServiceMsg.getTrpcRspFuncRetCode();
            if (trpcRspFuncRetCode == 0) {
                trpcRspFuncRetCode = fromServiceMsg.getTrpcRspRetCode();
            }
            if (trpcRspFuncRetCode == 0) {
                trpcRspFuncRetCode = fromServiceMsg.getResultCode();
            }
            if (trpcRspFuncRetCode == 0) {
                trpcRspFuncRetCode = -1;
            }
            bundle.putInt("ret", trpcRspFuncRetCode);
            bundle.putString("businessFailMsg", fromServiceMsg.getBusinessFailMsg());
        }
        notifyObserver(intent, 2308, fromServiceMsg.isSuccess(), bundle, com.tencent.mobileqq.login.servlet.e.class);
    }

    private void c(Intent intent, Packet packet) {
        String a16 = a();
        packet.setSSOCommand("trpc.login.account_logic.AccountLogicService.SsoThirdPartQueryEncryptedBind");
        packet.setTimeout(30000L);
        packet.setTraceInfo(a16);
        String stringExtra = intent.getStringExtra("wxCode");
        String stringExtra2 = intent.getStringExtra("wxAppId");
        AccountLogic.Cmd0x11fdRequest cmd0x11fdRequest = new AccountLogic.Cmd0x11fdRequest();
        cmd0x11fdRequest.account_type.set(1);
        if (!TextUtils.isEmpty(stringExtra)) {
            cmd0x11fdRequest.third_part_info.wx_info.code.set(stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            cmd0x11fdRequest.third_part_info.wx_info.appid.set(stringExtra2);
        }
        cmd0x11fdRequest.third_part_info.wx_info.setHasFlag(true);
        cmd0x11fdRequest.third_part_info.setHasFlag(true);
        cmd0x11fdRequest.setHasFlag(true);
        packet.putSendData(d(cmd0x11fdRequest.toByteArray()));
        QLog.i("LoginServlet", 1, "onSendForQueryWxBindState traceInfo=" + a16);
    }

    private byte[] d(byte[] bArr) {
        int i3;
        if (bArr != null) {
            i3 = bArr.length;
        } else {
            i3 = 0;
        }
        int i16 = i3 + 4;
        byte[] bArr2 = new byte[i16];
        PkgTools.dWord2Byte(bArr2, 0, i16);
        if (i3 > 0) {
            PkgTools.copyData(bArr2, 4, bArr, i3);
        }
        return bArr2;
    }

    private void dispatchService(int i3, Intent intent) {
        if (i3 != 1007) {
            if (i3 != 1030) {
                if (i3 == 1032) {
                    serviceForActionChangeToken(intent);
                    return;
                }
                return;
            }
            serviceForActionGetKey(intent);
            return;
        }
        serviceForActionDeleteAccount(intent);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x000c. Please report as an issue. */
    private boolean dispatchServiceForLogin(int i3, Intent intent) {
        if (i3 != 1037) {
            if (i3 != 1101) {
                if (i3 != 1102) {
                    switch (i3) {
                        case Constants.Action.ACTION_VERIFY_PASSWD /* 2205 */:
                            serviceForActionVeriftyPasswd(intent);
                            break;
                        case Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE /* 2206 */:
                            serviceForActionVerifyPasswdSubmitImageCode(intent);
                            break;
                        case Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE /* 2207 */:
                            serviceForActionVerifyPassWDRefreshImageCode(intent);
                            break;
                        default:
                            return false;
                    }
                } else {
                    serviceForActionSSOGetA1WithA1(intent);
                }
            } else {
                serviceForActionGetTicketNoPasswd(intent);
            }
        } else {
            serviceForActionSubAccountGetKey(intent);
        }
        return true;
    }

    private byte[] e(byte[] bArr) {
        if (bArr != null && bArr.length > 4) {
            int length = bArr.length - 4;
            byte[] bArr2 = new byte[length];
            PkgTools.copyData(bArr2, 0, bArr, 4, length);
            return bArr2;
        }
        return null;
    }

    private void onReceiveForActionChangeToken(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("map", fromServiceMsg.attributes);
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, b.class);
    }

    private void onReceiveForActionGetKey(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("key", (String) fromServiceMsg.getAttribute(fromServiceMsg.getServiceCmd()));
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, b.class);
    }

    private void onReceiveForActionGetTicketNoPasswd(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        if (QLog.isColorLevel()) {
            QLog.d("LoginServlet", 2, "onReceive action_sso_login_no_passwd...");
        }
        bundle.putString("ssoAccount", (String) fromServiceMsg.getAttribute("userAccount"));
        if (fromServiceMsg.isSuccess()) {
            bundle.putByteArray("wtTicket", (byte[]) fromServiceMsg.getAttribute("wtTicket"));
            bundle.putParcelable("userSigInfo", (Parcelable) fromServiceMsg.getAttribute("userSigInfo"));
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (Parcelable) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR));
            bundle.putInt("targetTicket", intent.getIntExtra("targetTicket", 4096));
            bundle.putByteArray("st_temp", (byte[]) fromServiceMsg.getAttribute("st_temp"));
            bundle.putByteArray("st_temp_key", (byte[]) fromServiceMsg.getAttribute("st_temp_key"));
        }
        bundle.putInt("code", fromServiceMsg.getResultCode());
        bundle.putParcelable("errMsg", (Parcelable) fromServiceMsg.getAttribute("errMsg"));
        Object attribute = fromServiceMsg.getAttribute("ret");
        if (attribute instanceof Integer) {
            bundle.putInt("ret", ((Integer) attribute).intValue());
        } else {
            bundle.putInt("ret", -1);
        }
        bundle.putString("error", fromServiceMsg.getBusinessFailMsg());
        notifyObserver(intent, 1101, fromServiceMsg.isSuccess(), bundle, f.class);
    }

    private void onReceiveForActionSSOGetA1WithA1(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        bundle.putString("ssoAccount", (String) fromServiceMsg.getAttribute("userAccount"));
        if (fromServiceMsg.isSuccess()) {
            Object attribute = fromServiceMsg.getAttribute("dwSrcAppid");
            if (attribute instanceof Long) {
                bundle.putLong("dwSrcAppid", ((Long) attribute).longValue());
            }
            Object attribute2 = fromServiceMsg.getAttribute("dwMainSigMap");
            if (attribute2 instanceof Integer) {
                bundle.putInt("dwMainSigMap", ((Integer) attribute2).intValue());
            }
            Object attribute3 = fromServiceMsg.getAttribute("dwSubSrcAppid");
            if (attribute3 instanceof Long) {
                bundle.putLong("dwSubSrcAppid", ((Long) attribute3).longValue());
            }
            bundle.putByteArray("dstAppName", (byte[]) fromServiceMsg.getAttribute("dstAppName"));
            Object attribute4 = fromServiceMsg.getAttribute("dwDstSsoVer");
            if (attribute4 instanceof Long) {
                bundle.putLong("dwDstSsoVer", ((Long) attribute4).longValue());
            }
            Object attribute5 = fromServiceMsg.getAttribute("dwDstAppid");
            if (attribute5 instanceof Long) {
                bundle.putLong("dwDstAppid", ((Long) attribute5).longValue());
            }
            Object attribute6 = fromServiceMsg.getAttribute("dwSubDstAppid");
            if (attribute6 instanceof Long) {
                bundle.putLong("dwSubDstAppid", ((Long) attribute6).longValue());
            }
            bundle.putParcelable("userSigInfo", (Parcelable) fromServiceMsg.getAttribute("userSigInfo"));
            bundle.putParcelable("fastLoginInfo", (Parcelable) fromServiceMsg.getAttribute("fastLoginInfo"));
            bundle.putByteArray("dstAppVer", (byte[]) fromServiceMsg.getAttribute("dstAppVer"));
            bundle.putByteArray("dstAppSign", (byte[]) fromServiceMsg.getAttribute("dstAppSign"));
            bundle.putByteArray("wtTicket", (byte[]) fromServiceMsg.getAttribute("wtTicket"));
        }
        bundle.putInt("code", fromServiceMsg.getResultCode());
        bundle.putParcelable("errMsg", (Parcelable) fromServiceMsg.getAttribute("errMsg"));
        Object attribute7 = fromServiceMsg.getAttribute("ret");
        if (attribute7 instanceof Integer) {
            bundle.putInt("ret", ((Integer) attribute7).intValue());
        } else {
            bundle.putInt("ret", -1);
        }
        notifyObserver(intent, 1102, fromServiceMsg.isSuccess(), bundle, f.class);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0082, code lost:
    
        r3 = r7[0].substring(3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void onReceiveForActionSubAccountGetKey(Intent intent, FromServiceMsg fromServiceMsg) {
        String[] split;
        int indexOf;
        String substring;
        String[] split2;
        String str;
        Bundle bundle = new Bundle();
        String str2 = (String) fromServiceMsg.getAttribute(BaseConstants.CMD_GETKEY);
        String uin = fromServiceMsg.getUin();
        String str3 = null;
        if (str2 != null && (split = str2.split(";")) != null) {
            try {
                if (split.length > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= split.length) {
                            break;
                        }
                        String str4 = split[i3];
                        if (str4 != null && str4.length() != 0) {
                            if (str4.startsWith("UIN=" + uin + ",") && (indexOf = str4.indexOf("A2=")) >= 0 && (substring = str4.substring(indexOf)) != null && substring.length() != 0 && (split2 = substring.split(",")) != null && split2.length > 0 && (str = split2[0]) != null && str.length() > 4) {
                                break;
                            }
                        }
                        i3++;
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        bundle.putString("uin", uin);
        bundle.putString("error", fromServiceMsg.getBusinessFailMsg());
        bundle.putInt("code", fromServiceMsg.getResultCode());
        bundle.putString("subaccountA2", str3);
        bundle.putString("mainaccount", (String) fromServiceMsg.getAttribute("mainaccount"));
        notifyObserver(intent, 1037, fromServiceMsg.isSuccess(), bundle, g.class);
    }

    private void onReceiveForActionVeriftyPasswdRefreshImageCode(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        String uin = fromServiceMsg.getUin();
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        String str = (String) fromServiceMsg.getAttribute("userAccount");
        byte[] bArr = (byte[]) fromServiceMsg.getAttribute("pictureData");
        int intValue = ((Integer) fromServiceMsg.getAttribute("ret")).intValue();
        ErrMsg errMsg = (ErrMsg) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR);
        bundle.putString("uin", uin);
        bundle.putInt(QzoneIPCModule.RESULT_CODE, businessFailCode);
        bundle.putString("errorMsg", businessFailMsg);
        bundle.putString("userAccount", str);
        bundle.putByteArray("pictureData", bArr);
        bundle.putInt("ret", intValue);
        bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, errMsg);
        notifyObserver(intent, Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE, fromServiceMsg.isSuccess(), bundle, b.class);
    }

    private void onReceiveForActionVerifyPasswd(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        Bundle bundle = new Bundle();
        String uin = fromServiceMsg.getUin();
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        int intValue = ((Integer) fromServiceMsg.getAttribute("ret")).intValue();
        String str = null;
        if (fromServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_RESP_VERIFYIMAGE)) {
            bArr = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYIMAGE);
        } else {
            bArr = null;
        }
        if (fromServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_RESP_VERIFYMSG)) {
            str = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYMSG);
        }
        bundle.putString("uin", uin);
        bundle.putInt(QzoneIPCModule.RESULT_CODE, businessFailCode);
        bundle.putString("errorMsg", businessFailMsg);
        bundle.putInt("ret", intValue);
        bundle.putString(UinConfigManager.KEY_ADS, str);
        bundle.putByteArray("image", bArr);
        notifyObserver(intent, Constants.Action.ACTION_VERIFY_PASSWD, fromServiceMsg.isSuccess(), bundle, b.class);
    }

    private void onReceiveForActionVerifyPasswdSubmitImageCode(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        Bundle bundle = new Bundle();
        String uin = fromServiceMsg.getUin();
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        String str = (String) fromServiceMsg.getAttribute("userAccount");
        byte[] bArr2 = (byte[]) fromServiceMsg.getAttribute("userInput");
        int intValue = ((Integer) fromServiceMsg.getAttribute("ret")).intValue();
        ErrMsg errMsg = (ErrMsg) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR);
        if (fromServiceMsg.getAttributes().containsKey("image_buf")) {
            bArr = (byte[]) fromServiceMsg.getAttribute("image_buf");
        } else {
            bArr = null;
        }
        bundle.putString("uin", uin);
        bundle.putInt(QzoneIPCModule.RESULT_CODE, businessFailCode);
        bundle.putString("errorMsg", businessFailMsg);
        bundle.putString("userAccount", str);
        bundle.putByteArray("userInput", bArr2);
        bundle.putInt("ret", intValue);
        bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, errMsg);
        bundle.putByteArray("image", bArr);
        notifyObserver(intent, Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE, fromServiceMsg.isSuccess(), bundle, b.class);
    }

    private void serviceForActionChangeToken(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getChangeTokenAfterLoginMsg(getAppRuntime().getAccount(), 9, (HashMap) intent.getSerializableExtra("mapSt")));
    }

    private void serviceForActionDeleteAccount(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getDelLoginedAccount(getAppRuntime().getAccount(), intent.getStringExtra("uin"), intent.getStringExtra(NotificationActivity.KEY_ALIAS)));
    }

    private void serviceForActionGetKey(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getKeyMsg(getAppRuntime().getAccount()));
    }

    private void serviceForActionGetTicketNoPasswd(Intent intent) {
        String stringExtra = intent.getStringExtra("process");
        String stringExtra2 = intent.getStringExtra("ssoAccount");
        String stringExtra3 = intent.getStringExtra("from_where");
        ToServiceMsg loginWithoutPasswdMsg = getAppRuntime().getService().msfSub.getLoginWithoutPasswdMsg(stringExtra2);
        loginWithoutPasswdMsg.addAttribute("targetTicket", Integer.valueOf(intent.getIntExtra("targetTicket", 4096)));
        loginWithoutPasswdMsg.addAttribute("process", stringExtra);
        if (stringExtra3 != null && stringExtra3.length() > 0) {
            loginWithoutPasswdMsg.addAttribute("from_where", stringExtra3);
            if (QLog.isColorLevel()) {
                QLog.d("LoginServlet", 2, "ACTION_GET_TICKET_NO_PASSWD from_where is no null");
            }
        }
        addOpenSdkExtra(intent, loginWithoutPasswdMsg);
        loginWithoutPasswdMsg.setTimeout(40000L);
        sendToMSF(intent, loginWithoutPasswdMsg);
    }

    private void serviceForActionSSOGetA1WithA1(Intent intent) {
        String stringExtra = intent.getStringExtra("ssoAccount");
        byte[] byteArrayExtra = intent.getByteArrayExtra("dstAppName");
        long longExtra = intent.getLongExtra("dwDstSsoVer", 0L);
        long longExtra2 = intent.getLongExtra("dwDstAppid", 0L);
        long longExtra3 = intent.getLongExtra("dwSubDstAppid", 0L);
        byte[] byteArrayExtra2 = intent.getByteArrayExtra("dstAppVer");
        byte[] byteArrayExtra3 = intent.getByteArrayExtra("dstAppSign");
        ToServiceMsg a1WithA1 = getAppRuntime().getService().msfSub.getA1WithA1(stringExtra);
        a1WithA1.addAttribute("dstAppName", byteArrayExtra);
        a1WithA1.addAttribute("dwDstSsoVer", Long.valueOf(longExtra));
        a1WithA1.addAttribute("dwDstAppid", Long.valueOf(longExtra2));
        a1WithA1.addAttribute("dwSubDstAppid", Long.valueOf(longExtra3));
        a1WithA1.addAttribute("dstAppVer", byteArrayExtra2);
        a1WithA1.addAttribute("dstAppSign", byteArrayExtra3);
        a1WithA1.addAttribute("fastLoginInfo", new WFastLoginInfo());
        String stringExtra2 = intent.getStringExtra("process");
        if (!TextUtils.isEmpty(stringExtra2)) {
            a1WithA1.addAttribute("process", stringExtra2);
        }
        addOpenSdkExtra(intent, a1WithA1);
        a1WithA1.setTimeout(40000L);
        sendToMSF(intent, a1WithA1);
    }

    private void serviceForActionSubAccountGetKey(Intent intent) {
        String stringExtra = intent.getStringExtra("subaccountuin");
        String stringExtra2 = intent.getStringExtra("mainaccount");
        ToServiceMsg keyMsg = getAppRuntime().getService().msfSub.getKeyMsg(stringExtra);
        keyMsg.setTimeout(10000L);
        keyMsg.addAttribute("from_where", "subaccount");
        keyMsg.addAttribute("mainaccount", stringExtra2);
        sendToMSF(intent, keyMsg);
    }

    private void serviceForActionVeriftyPasswd(Intent intent) {
        ToServiceMsg verifyPasswdMsg = getAppRuntime().getService().msfSub.getVerifyPasswdMsg(intent.getStringExtra("account"), MD5.toMD5Byte(intent.getStringExtra(NotificationActivity.PASSWORD)));
        verifyPasswdMsg.setTimeout(40000L);
        verifyPasswdMsg.setIsSupportRetry(true);
        sendToMSF(intent, verifyPasswdMsg);
    }

    private void serviceForActionVerifyPassWDRefreshImageCode(Intent intent) {
        ToServiceMsg verifyPasswdRefreshImageMsg = getAppRuntime().getService().msfSub.getVerifyPasswdRefreshImageMsg(intent.getStringExtra("account"));
        verifyPasswdRefreshImageMsg.setTimeout(40000L);
        sendToMSF(intent, verifyPasswdRefreshImageMsg);
    }

    private void serviceForActionVerifyPasswdSubmitImageCode(Intent intent) {
        ToServiceMsg verifyPasswdImageMsg = getAppRuntime().getService().msfSub.getVerifyPasswdImageMsg(intent.getStringExtra("account"), intent.getStringExtra("verifyCode"));
        verifyPasswdImageMsg.setTimeout(40000L);
        sendToMSF(intent, verifyPasswdImageMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (intent != null) {
            i3 = intent.getIntExtra("action", 0);
        } else {
            i3 = -1;
        }
        if (i3 != 1007) {
            if (i3 != 1030) {
                if (i3 != 1032) {
                    if (i3 != 1037) {
                        if (i3 != 2308) {
                            if (i3 != 1101) {
                                if (i3 != 1102) {
                                    switch (i3) {
                                        case Constants.Action.ACTION_VERIFY_PASSWD /* 2205 */:
                                            onReceiveForActionVerifyPasswd(intent, fromServiceMsg);
                                            return;
                                        case Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE /* 2206 */:
                                            onReceiveForActionVerifyPasswdSubmitImageCode(intent, fromServiceMsg);
                                            return;
                                        case Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE /* 2207 */:
                                            onReceiveForActionVeriftyPasswdRefreshImageCode(intent, fromServiceMsg);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                onReceiveForActionSSOGetA1WithA1(intent, fromServiceMsg);
                                return;
                            }
                            onReceiveForActionGetTicketNoPasswd(intent, fromServiceMsg);
                            return;
                        }
                        b(intent, fromServiceMsg);
                        return;
                    }
                    onReceiveForActionSubAccountGetKey(intent, fromServiceMsg);
                    return;
                }
                onReceiveForActionChangeToken(intent, fromServiceMsg, i3);
                return;
            }
            onReceiveForActionGetKey(intent, fromServiceMsg, i3);
            return;
        }
        notifyObserver(intent, 1007, fromServiceMsg.isSuccess(), null, b.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) packet);
        } else if (intent.getIntExtra("action", 0) == 2308) {
            c(intent, packet);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet
    public void sendToMSF(Intent intent, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) toServiceMsg);
            return;
        }
        super.sendToMSF(intent, toServiceMsg);
        if (QLog.isDevelopLevel()) {
            QLog.d("LoginServlet", 4, "[ToServiceMsg] serviceCmd:" + toServiceMsg.getServiceCmd() + " msfCommand:" + toServiceMsg.getMsfCommand() + " uin:" + toServiceMsg.getUin() + " appSeq:" + toServiceMsg.getAppSeq() + " ssoSeq:" + toServiceMsg.getRequestSsoSeq() + " attributes:" + toServiceMsg.getAttributes());
        }
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        super.service(intent);
        int intExtra = intent.getIntExtra("action", 0);
        if (dispatchServiceForLogin(intExtra, intent)) {
            return;
        }
        dispatchService(intExtra, intent);
    }
}
