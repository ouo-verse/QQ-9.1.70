package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.fe.EventCallback;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.f;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.core.push.RegPushReason;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.v;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msf.service.protocol.pb.WirelessMibao;
import com.tencent.msf.service.protocol.pb.WirelessPsw;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.MsfServiceBindInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.report.LogManager;
import com.tencent.qphone.base.util.log.report.LogReport;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static String f250961a = "MSF.S.ReqHandler";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements EventCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f250962a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f250963b;

        a(ToServiceMsg toServiceMsg, String str) {
            this.f250962a = toServiceMsg;
            this.f250963b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, l.this, toServiceMsg, str);
            }
        }

        @Override // com.tencent.mobileqq.fe.EventCallback
        public void onResult(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            FromServiceMsg a16 = n.a(this.f250962a);
            a16.setMsgSuccess();
            a16.addAttribute(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_RET, Integer.valueOf(i3));
            a16.addAttribute(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_DATA, bArr);
            e.b(this.f250963b, this.f250962a, a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f250965a;

        b(ToServiceMsg toServiceMsg) {
            this.f250965a = toServiceMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this, (Object) toServiceMsg);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                NetConnInfoCenter.handleServerTimeFromOnlineRegister(this.f250965a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f250967a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16377);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MsfCommand.values().length];
            f250967a = iArr;
            try {
                iArr[MsfCommand.registerMsfService.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f250967a[MsfCommand.gm_GuardEvent.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f250967a[MsfCommand.unRegisterMsfService.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f250967a[MsfCommand.verifyPasswd.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f250967a[MsfCommand.verifyPasswdImage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f250967a[MsfCommand.verifyPasswdRefreshImage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f250967a[MsfCommand.loginAuth.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f250967a[MsfCommand.changeUinLogin.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f250967a[MsfCommand.changeToken.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f250967a[MsfCommand.delLoginedAccount.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f250967a[MsfCommand.submitVerifyCode.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f250967a[MsfCommand.refreVerifyCode.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f250967a[MsfCommand.submitPuzzleVerifyCodeTicket.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f250967a[MsfCommand.refreshTickets.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f250967a[MsfCommand.registerPush.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f250967a[MsfCommand.unRegisterPush.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f250967a[MsfCommand.registerCmdCallback.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f250967a[MsfCommand.resetCmdCallback.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f250967a[MsfCommand.proxyRegisterPush.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f250967a[MsfCommand.proxyUnRegisterPush.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f250967a[MsfCommand.reportMsg.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f250967a[MsfCommand.getKey.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f250967a[MsfCommand.getAlterTickets.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f250967a[MsfCommand.getServerConfig.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f250967a[MsfCommand.getPluginConfig.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f250967a[MsfCommand.regUin_queryMobile.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f250967a[MsfCommand.regUin_commitMobile.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f250967a[MsfCommand.regUin_querySmsStat.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f250967a[MsfCommand.regUin_reSendSms.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f250967a[MsfCommand.regUin_commitSmsCode.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f250967a[MsfCommand.regUin_commitPass.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f250967a[MsfCommand.quick_register_checkAccount.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f250967a[MsfCommand.quick_register_getAccount.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f250967a[MsfCommand._setMsfSuspend.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f250967a[MsfCommand._setMsfResunmed.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f250967a[MsfCommand.appDataIncerment.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f250967a[MsfCommand.getAppDataCount.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f250967a[MsfCommand.getMsfDebugInfo.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                f250967a[MsfCommand.reportRdm.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f250967a[MsfCommand.reportSocket.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f250967a[MsfCommand.getGatewayIp.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f250967a[MsfCommand.setMsfConnStatus.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f250967a[MsfCommand.keepProcessAlive.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f250967a[MsfCommand._msf_NetException.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f250967a[MsfCommand.SEND_WIRELESS_PSWREQ.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f250967a[MsfCommand.SEND_WIRELESS_MEIBAOREQ.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f250967a[MsfCommand.wt_GetOpenKeyWithoutPasswd.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f250967a[MsfCommand.wt_GetStWithPasswd.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f250967a[MsfCommand.wt_sig_checker_when_online.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f250967a[MsfCommand.wt_GetStWithoutPasswd.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f250967a[MsfCommand.wt_getUIDWithoutPasswd.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f250967a[MsfCommand.wt_CheckPictureAndGetSt.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f250967a[MsfCommand.wt_RefreshPictureData.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                f250967a[MsfCommand.wt_VerifyCode.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f250967a[MsfCommand.wt_CloseCode.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f250967a[MsfCommand.wt_CancelCode.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                f250967a[MsfCommand.wt_GetA1WithA1.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f250967a[MsfCommand.wt_CheckDevLockStatus.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f250967a[MsfCommand.wt_AskDevLockSms.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                f250967a[MsfCommand.wt_CheckDevLockSms.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                f250967a[MsfCommand.wt_CloseDevLock.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                f250967a[MsfCommand.wt_setRegDevLockFlag.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                f250967a[MsfCommand.wt_SetDevlockMobileType.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                f250967a[MsfCommand.wt_RefreshSMSData.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                f250967a[MsfCommand.wt_CheckSMSAndGetSt.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                f250967a[MsfCommand.wt_CheckSMSAndGetStExt.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                f250967a[MsfCommand.wt_RegGetSMSVerifyLoginAccount.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                f250967a[MsfCommand.nt_login_inject_sig.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                f250967a[MsfCommand.wt_CheckSMSVerifyLoginAccount.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                f250967a[MsfCommand.wt_RefreshSMSVerifyLoginCode.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                f250967a[MsfCommand.wt_VerifySMSVerifyLoginCode.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                f250967a[MsfCommand.wt_GetStViaSMSVerifyLogin.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                f250967a[MsfCommand.wt_GetStViaGatewayLogin.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                f250967a[MsfCommand.wt_getStViaWxLogin.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                f250967a[MsfCommand.wt_QuickLoginByGateway.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                f250967a[MsfCommand.wt_GetSaltUinList.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                f250967a[MsfCommand.wt_GetStViaPhonePwdLogin.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                f250967a[MsfCommand.loginByWx.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                f250967a[MsfCommand.wt_refreshMemorySig.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                f250967a[MsfCommand.sendVideoAck.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                f250967a[MsfCommand.check_msf_conErro.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                f250967a[MsfCommand.msf_msgsignal.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                f250967a[MsfCommand.msf_refreshDA2.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                f250967a[MsfCommand.msf_step_counter.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                f250967a[MsfCommand.msf_pbSyncMsg.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                f250967a[MsfCommand.msf_save_geoginfo.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                f250967a[MsfCommand.msf_manual_set_log_level.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                f250967a[MsfCommand.msf_update_locale_id.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                f250967a[MsfCommand.msf_update_battery.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                f250967a[MsfCommand.msfUpdateManagerConfig.ordinal()] = 90;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                f250967a[MsfCommand.msfUpdateToggle.ordinal()] = 91;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                f250967a[MsfCommand.msfGetWeakNet.ordinal()] = 92;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                f250967a[MsfCommand.msf_sec_dispatch_event.ordinal()] = 93;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                f250967a[MsfCommand.msf_active_log_report.ordinal()] = 94;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                f250967a[MsfCommand.msf_after_fetch_config_log_report.ordinal()] = 95;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                f250967a[MsfCommand.msf_new_log_report_color.ordinal()] = 96;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                f250967a[MsfCommand.msf_update_weakNet_config.ordinal()] = 97;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                f250967a[MsfCommand.msf_update_common_config.ordinal()] = 98;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                f250967a[MsfCommand.msf_weak_net_switch.ordinal()] = 99;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                f250967a[MsfCommand.msf_update_complex_connect_config.ordinal()] = 100;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                f250967a[MsfCommand.msf_update_mmkv_config.ordinal()] = 101;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                f250967a[MsfCommand.msf_push_register_switch.ordinal()] = 102;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                f250967a[MsfCommand.msf_listen_msg_sync_end.ordinal()] = 103;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                f250967a[MsfCommand.msf_before_msg_sync_config.ordinal()] = 104;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                f250967a[MsfCommand.msf_listen_online_register.ordinal()] = 105;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                f250967a[MsfCommand.msf_test_close_conn.ordinal()] = 106;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                f250967a[MsfCommand.msfCoreState.ordinal()] = 107;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                f250967a[MsfCommand.wt_FetchCodeSigVerifyLogin.ordinal()] = 108;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                f250967a[MsfCommand.wt_QueryCodeResult.ordinal()] = 109;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                f250967a[MsfCommand.wt_getStWithQrSig.ordinal()] = 110;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                f250967a[MsfCommand.regUin_queryMobileWatch.ordinal()] = 111;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                f250967a[MsfCommand.regUin_commitMobileWatch.ordinal()] = 112;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                f250967a[MsfCommand.regUin_querySmsStatWatch.ordinal()] = 113;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                f250967a[MsfCommand.regUin_reSendSmsWatch.ordinal()] = 114;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                f250967a[MsfCommand.regUin_commitSmsCodeWatch.ordinal()] = 115;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                f250967a[MsfCommand.regUin_commitPassWatch.ordinal()] = 116;
            } catch (NoSuchFieldError unused116) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18092);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, ToServiceMsg toServiceMsg, int i3) {
        if (toServiceMsg == null || f.c().a(toServiceMsg, i3)) {
            return;
        }
        String b16 = n.b(toServiceMsg);
        toServiceMsg.addAttribute(BaseConstants.TIMESTAMP_APP2MSF, Long.valueOf(System.currentTimeMillis()));
        if ((toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_REGPRXYSVC_INFOLOGIN) || toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_NEW_REGPRXYSVC_INFOSYNC)) && !com.tencent.mobileqq.msf.core.push.h.f249718n0) {
            QLog.d(f250961a, 1, "get infoLogin, but not register push, register now");
            String packageName = context.getPackageName();
            if (packageName != null) {
                ToServiceMsg toServiceMsg2 = new ToServiceMsg("", toServiceMsg.getUin(), BaseConstants.CMD_REGISTER_PUSH);
                toServiceMsg2.setMsfCommand(MsfCommand.registerPush);
                toServiceMsg2.setAppId(toServiceMsg.getAppId());
                toServiceMsg2.setTimeout(30000L);
                MsfSdkUtils.addToMsgProcessName(packageName, toServiceMsg2);
                com.tencent.mobileqq.msf.core.push.a aVar = MsfService.core.pushManager.f249742i.get(packageName);
                if (aVar != null) {
                    com.tencent.mobileqq.msf.sdk.o.a(toServiceMsg2, aVar.f249597k);
                    MsfService.core.pushManager.a(toServiceMsg2, RegPushReason.fillRegProxy);
                } else {
                    QLog.d(f250961a, 1, "AppPushInfo not find can not register");
                    PushRegisterInfo pushRegisterInfo = new PushRegisterInfo();
                    ArrayList<Long> arrayList = new ArrayList<>();
                    arrayList.add(1L);
                    arrayList.add(2L);
                    arrayList.add(4L);
                    pushRegisterInfo.pushIds = arrayList;
                    pushRegisterInfo.uin = toServiceMsg.getUin();
                    pushRegisterInfo.iStatus = 11;
                    pushRegisterInfo.bKikPC = (byte) 0;
                    pushRegisterInfo.bKikWeak = (byte) 0;
                    pushRegisterInfo.timeStamp = 0L;
                    pushRegisterInfo.iLargeSeq = 0L;
                    com.tencent.mobileqq.msf.sdk.o.a(toServiceMsg2, pushRegisterInfo);
                    MsfService.core.pushManager.a(toServiceMsg2, RegPushReason.createDefaultRegInfo);
                }
            } else {
                QLog.d(f250961a, 1, "qqprocessName not find can not register");
            }
        }
        if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_NT_SSO_HEART_BEAT)) {
            QLog.d(f250961a, 1, "onSend StatusService heartbeat");
            MsfCore core = MsfService.getCore();
            if (core != null && core.getMsfProbeManager() != null) {
                core.getMsfProbeManager().c();
            }
        } else if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC)) {
            com.tencent.mobileqq.msf.core.auth.b accountCenter = MsfService.getCore().getAccountCenter();
            if (!TextUtils.isEmpty(toServiceMsg.getUin()) && accountCenter != null) {
                accountCenter.d(toServiceMsg.getUin(), "RegPush");
            }
            if (MsfService.getCore().getMsfProbeManager() != null) {
                MsfService.getCore().getMsfProbeManager().b();
            }
            NetConnInfoCenter.onRegProxySvcSend();
        } else if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_NT_PUSH_UNREGISTER)) {
            com.tencent.mobileqq.msf.core.auth.b accountCenter2 = MsfService.getCore().getAccountCenter();
            if (!TextUtils.isEmpty(toServiceMsg.getUin()) && accountCenter2 != null && toServiceMsg.getUin().equals(accountCenter2.e())) {
                accountCenter2.d("0", "unRegPush");
            }
        }
        switch (c.f250967a[toServiceMsg.getMsfCommand().ordinal()]) {
            case 1:
                QLog.d(f250961a, 1, "handleMsfRequest registerMsfService");
                MsfServiceBindInfo msfServiceBindInfo = (MsfServiceBindInfo) toServiceMsg.getAttributes().get(MsfConstants.INTENT_BINDSERVICEINFO);
                e.a(msfServiceBindInfo.getProcessName(), msfServiceBindInfo.getBootBoradcastName(), msfServiceBindInfo.getMsfServiceCallbacker(), toServiceMsg.getAppId());
                MsfCore.initAppProMsg(n.b(toServiceMsg), toServiceMsg.getAppId());
                return;
            case 2:
                e.a(b16, ((Integer) toServiceMsg.getAttribute(MsfConstants.K_EVENT)).intValue(), ((Long) toServiceMsg.getAttribute(MsfConstants.K_ARG0)).longValue(), ((Long) toServiceMsg.getAttribute(MsfConstants.K_ARG1)).longValue());
                return;
            case 3:
                QLog.d(f250961a, 1, "handleMsfRequest unRegisterMsfService");
                MsfService.core.getNetFlowStore().a();
                Boolean bool = Boolean.TRUE;
                if (toServiceMsg.extraData.containsKey(MsfConstants.ATTRIBUTE_STOP_WAKE_PROCESS)) {
                    bool = Boolean.valueOf(toServiceMsg.extraData.getBoolean(MsfConstants.ATTRIBUTE_STOP_WAKE_PROCESS));
                }
                e.a(b16, bool);
                return;
            case 4:
                MsfService.core.verifyPasswd(toServiceMsg);
                return;
            case 5:
                MsfService.core.verifyPasswdImage(toServiceMsg);
                return;
            case 6:
                MsfService.core.verifyPasswdRefreshImage(toServiceMsg);
                return;
            case 7:
                MsfService.core.login(toServiceMsg, 16, 0, new byte[0]);
                return;
            case 8:
                MsfService.core.ChangeUinLogin(toServiceMsg);
                return;
            case 9:
                MsfService.core.changeTokenAfterLogin(toServiceMsg, true, com.tencent.mobileqq.msf.core.auth.d.f247424j);
                return;
            case 10:
                MsfService.core.syncDelAccount(toServiceMsg);
                FromServiceMsg a16 = n.a(toServiceMsg);
                a16.addAttribute(MsfConstants.ATTRIBUTE_RESP_SIMPLEACCOUNT_UIN, toServiceMsg.getUin());
                a16.setMsgSuccess();
                e.b(b16, toServiceMsg, a16);
                return;
            case 11:
                MsfService.core.submitVerifycode(toServiceMsg);
                return;
            case 12:
                MsfService.core.refreVerifycode(toServiceMsg);
                return;
            case 13:
                MsfService.core.submitPuzzleVerifyCodeTicket(toServiceMsg);
                return;
            case 14:
                String uin = toServiceMsg.getUin();
                if (TextUtils.isEmpty(uin)) {
                    return;
                }
                MsfService.core.refreshWebviewTickets(uin, "NotifyReLogin");
                return;
            case 15:
                MsfService.core.registerPush(toServiceMsg, (RegPushReason) toServiceMsg.getAttribute("regPushReason"));
                return;
            case 16:
                MsfService.core.unRegisterPush(toServiceMsg);
                return;
            case 17:
                MsfService.core.registerCmdCall(toServiceMsg);
                return;
            case 18:
                MsfService.core.unRegisterCmdCall(toServiceMsg);
                return;
            case 19:
                QLog.d(f250961a, 1, "handleMsfRequest proxyRegisterPush");
                com.tencent.mobileqq.msf.sdk.n c16 = com.tencent.mobileqq.msf.sdk.o.c(toServiceMsg);
                e.a(c16.f250621b, c16.f250622c, (IMsfServiceCallbacker) null, toServiceMsg.getAppId());
                MsfService.core.proxyRegister(c16, toServiceMsg);
                return;
            case 20:
                String str = (String) toServiceMsg.getAttribute(toServiceMsg.getServiceCmd());
                if (e.b(str)) {
                    MsfService.core.proxyUnRegister(str, toServiceMsg);
                    return;
                }
                FromServiceMsg a17 = n.a(toServiceMsg);
                a17.setBusinessFail(1011, "can not unregister by proxy.");
                e.b(b16, toServiceMsg, a17);
                return;
            case 21:
                MsfService.core.report(toServiceMsg);
                return;
            case 22:
                String handleGetAccountKey = MsfService.core.handleGetAccountKey(context, toServiceMsg, i3);
                FromServiceMsg a18 = n.a(toServiceMsg);
                a18.addAttribute(a18.getServiceCmd(), handleGetAccountKey);
                a18.setMsgSuccess();
                e.b(b16, toServiceMsg, a18);
                return;
            case 23:
                HashMap<String, String> a19 = MsfService.core.getWtLoginCenter().a(toServiceMsg.getUin());
                FromServiceMsg a26 = n.a(toServiceMsg);
                a26.getAttributes().put("keyMap", a19);
                a26.setMsgSuccess();
                e.b(b16, toServiceMsg, a26);
                return;
            case 24:
                String syncGetServerConfig = MsfService.core.syncGetServerConfig(toServiceMsg);
                FromServiceMsg a27 = n.a(toServiceMsg);
                a27.addAttribute(MsfConstants.ATTRIBUTE_GETSERVERCONFIG_TYPE, Integer.valueOf(((Integer) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_GETSERVERCONFIG_TYPE)).intValue()));
                a27.addAttribute(MsfConstants.ATTRIBUTE_GETSERVERCONFIG_CONTENT, syncGetServerConfig);
                a27.setMsgSuccess();
                e.b(b16, toServiceMsg, a27);
                return;
            case 25:
                MsfService.core.getPluginConfig(toServiceMsg);
                return;
            case 26:
                MsfService.core.getWtLoginCenter().b(toServiceMsg);
                return;
            case 27:
                MsfService.core.getWtLoginCenter().e(toServiceMsg);
                return;
            case 28:
                MsfService.core.getWtLoginCenter().c(toServiceMsg);
                return;
            case 29:
                MsfService.core.getWtLoginCenter().d(toServiceMsg);
                return;
            case 30:
                MsfService.core.getWtLoginCenter().f(toServiceMsg);
                return;
            case 31:
                MsfService.core.getWtLoginCenter().a(toServiceMsg);
                return;
            case 32:
                MsfService.core.getWtLoginCenter().g(toServiceMsg);
                return;
            case 33:
                MsfService.core.getWtLoginCenter().i(toServiceMsg);
                return;
            case 34:
                MsfService.core.suspend();
                return;
            case 35:
                MsfService.core.resume();
                return;
            case 36:
                QLog.e(f250961a, 1, "appDataIncerment not handled");
                return;
            case 37:
                QLog.e(f250961a, 1, "appDataIncerment not handled");
                return;
            case 38:
                FromServiceMsg a28 = n.a(toServiceMsg);
                a28.addAttribute(toServiceMsg.getServiceCmd(), "dropped");
                a28.setMsgSuccess();
                e.b(b16, toServiceMsg, a28);
                return;
            case 39:
                JceInputStream jceInputStream = new JceInputStream((byte[]) toServiceMsg.getAttribute(toServiceMsg.getServiceCmd()));
                RdmReq rdmReq = new RdmReq();
                rdmReq.readFrom(jceInputStream);
                if (MsfService.core.getStatReporter() != null) {
                    MsfService.core.getStatReporter().a(rdmReq.appKey, rdmReq.eventName, rdmReq.isSucceed, rdmReq.elapse, rdmReq.size, rdmReq.params, rdmReq.isRealTime, rdmReq.isImmediatelyUpload, rdmReq.isMerge);
                    return;
                }
                return;
            case 40:
                MsfService.core.getNetFlowStore().a(toServiceMsg);
                return;
            case 41:
                String gatewayIp = MsfService.core.getGatewayIp();
                FromServiceMsg a29 = n.a(toServiceMsg);
                a29.addAttribute(toServiceMsg.getServiceCmd(), gatewayIp);
                a29.setMsgSuccess();
                e.b(b16, toServiceMsg, a29);
                return;
            case 42:
                e.c(b16, toServiceMsg, n.a(toServiceMsg));
                return;
            case 43:
                e.a(b16, toServiceMsg, n.a(toServiceMsg));
                return;
            case 44:
                int intValue = ((Integer) toServiceMsg.getAttribute(BaseConstants.NETEXCEPTION_ATTRIBUTE_EXCEPTYPE)).intValue();
                if (QLog.isDevelopLevel()) {
                    QLog.d(com.tencent.mobileqq.msf.core.net.l.f248784a, 4, "get a NetExceptionStatistics event value:" + intValue);
                }
                if (intValue != 1) {
                    return;
                }
                com.tencent.mobileqq.msf.core.net.l.a(l.b.f248789a);
                return;
            case 45:
                int intValue2 = ((Integer) toServiceMsg.getAttribute("cmd")).intValue();
                WirelessPsw.CWirelessPswReq cWirelessPswReq = new WirelessPsw.CWirelessPswReq();
                cWirelessPswReq.cmd.set(intValue2);
                cWirelessPswReq.time.set((int) (System.currentTimeMillis() / 1000));
                cWirelessPswReq.uin.set(Long.parseLong(toServiceMsg.getUin()));
                try {
                    InetAddress byName = InetAddress.getByName(MsfService.core.getGatewayIp());
                    byte[] address = byName.getAddress();
                    if (address.length <= 4 && address.length > 0) {
                        cWirelessPswReq.f336522ip.set(((address[0] & 255) << 24) | 0 | ((address[1] & 255) << 16) | ((address[2] & 255) << 8) | (address[3] & 255));
                        byte[] d16 = MsfService.getCore().getAccountCenter().d();
                        cWirelessPswReq.ksid.set(ByteStringMicro.copyFrom(d16));
                        byte[] byteArray = cWirelessPswReq.toByteArray();
                        long length = byteArray.length;
                        int i16 = (int) length;
                        byte[] bArr = new byte[i16 + 4];
                        a(bArr, 0, length + 4);
                        System.arraycopy(byteArray, 0, bArr, 4, i16);
                        toServiceMsg.putWupBuffer(bArr);
                        if (QLog.isDevelopLevel()) {
                            QLog.d(f250961a, 4, "WIRELESS_PSWREQ cmd:" + intValue2 + " time:" + cWirelessPswReq.time.get() + " uin:" + cWirelessPswReq.uin.get() + " ip:" + cWirelessPswReq.f336522ip.get() + " ksid:" + d16);
                        }
                        MsfService.core.sendSsoMsg(toServiceMsg);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f250961a, 2, "SEND_WIRELESS_PSWREQ inetAddress error :" + byName);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            case 46:
                int intValue3 = ((Integer) toServiceMsg.getAttribute("cmd")).intValue();
                WirelessMibao.CWirelessMibaoReq cWirelessMibaoReq = new WirelessMibao.CWirelessMibaoReq();
                cWirelessMibaoReq.cmd.set(intValue3);
                cWirelessMibaoReq.time.set((int) (System.currentTimeMillis() / 1000));
                cWirelessMibaoReq.uin.set(Long.parseLong(toServiceMsg.getUin()));
                try {
                    InetAddress byName2 = InetAddress.getByName(MsfService.core.getGatewayIp());
                    byte[] address2 = byName2.getAddress();
                    if (address2.length <= 4 && address2.length > 0) {
                        cWirelessMibaoReq.f336521ip.set(((address2[0] & 255) << 24) | 0 | ((address2[1] & 255) << 16) | ((address2[2] & 255) << 8) | (address2[3] & 255));
                        byte[] d17 = MsfService.getCore().getAccountCenter().d();
                        cWirelessMibaoReq.ksid.set(ByteStringMicro.copyFrom(d17));
                        cWirelessMibaoReq.imei.set(com.tencent.mobileqq.msf.core.o.e());
                        cWirelessMibaoReq.guid.set(ByteStringMicro.copyFrom(com.tencent.mobileqq.msf.core.auth.i.c()));
                        byte[] byteArray2 = cWirelessMibaoReq.toByteArray();
                        long length2 = byteArray2.length;
                        int i17 = (int) length2;
                        byte[] bArr2 = new byte[i17 + 4];
                        a(bArr2, 0, length2 + 4);
                        System.arraycopy(byteArray2, 0, bArr2, 4, i17);
                        toServiceMsg.putWupBuffer(bArr2);
                        if (QLog.isDevelopLevel()) {
                            QLog.d(f250961a, 4, "WIRELESS_MEIBAOREQ cmd:" + intValue3 + " time:" + cWirelessMibaoReq.time.get() + " uin:" + cWirelessMibaoReq.uin.get() + " ip:" + cWirelessMibaoReq.f336521ip.get() + " ksid:" + d17);
                        }
                        MsfService.core.sendSsoMsg(toServiceMsg);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f250961a, 2, "SEND_WIRELESS_PSWREQ inetAddress error :" + byName2);
                        return;
                    }
                    return;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    return;
                }
            case 47:
                MsfService.core.wt_GetOpenKeyWithoutPasswd(toServiceMsg);
                return;
            case 48:
                MsfService.core.wt_GetStWithPasswd(toServiceMsg);
                return;
            case 49:
                MsfService.core.wt_check_sig(toServiceMsg);
                return;
            case 50:
                MsfService.core.wt_GetStWithoutPasswd(toServiceMsg);
                return;
            case 51:
                MsfService.core.wt_GetUIDWithoutPasswd(toServiceMsg);
                return;
            case 52:
                MsfService.core.wt_CheckPictureAndGetSt(toServiceMsg);
                return;
            case 53:
                MsfService.core.wt_RefreshPictureData(toServiceMsg);
                return;
            case 54:
                MsfService.core.wt_VerifyCode(toServiceMsg);
                return;
            case 55:
                MsfService.core.wt_CloseCode(toServiceMsg);
                return;
            case 56:
                MsfService.core.wt_CancelCode(toServiceMsg);
                return;
            case 57:
                MsfService.core.wt_GetA1WithA1(toServiceMsg);
                return;
            case 58:
                MsfService.core.wt_CheckDevLockStatus(toServiceMsg);
                return;
            case 59:
                MsfService.core.wt_AskDevLockSms(toServiceMsg);
                return;
            case 60:
                MsfService.core.wt_CheckDevLockSms(toServiceMsg);
                return;
            case 61:
                MsfService.core.wt_CloseDevLock(toServiceMsg);
                return;
            case 62:
                MsfService.core.wt_setRegDevLockFlag(toServiceMsg);
                return;
            case 63:
                MsfService.core.wt_SetDevlockMobileType(toServiceMsg);
                return;
            case 64:
                MsfService.core.wt_RefreshSMSData(toServiceMsg);
                return;
            case 65:
                MsfService.core.wt_CheckSMSAndGetSt(toServiceMsg);
                return;
            case 66:
                MsfService.core.wt_CheckSMSAndGetStExt(toServiceMsg);
                return;
            case 67:
                MsfService.core.wt_RegGetSMSVerifyLoginAccount(toServiceMsg);
                return;
            case 68:
                MsfService.core.injectSigToMsf(toServiceMsg);
                return;
            case 69:
                MsfService.core.wt_CheckSMSVerifyLoginAccount(toServiceMsg);
                return;
            case 70:
                MsfService.core.wt_RefreshSMSVerifyLoginCode(toServiceMsg);
                return;
            case 71:
                MsfService.core.wt_VerifySMSVerifyLoginCode(toServiceMsg);
                return;
            case 72:
                MsfService.core.wt_GetStViaGatewayLogin(toServiceMsg);
                return;
            case 73:
                MsfService.core.wt_GetStViaGatewayLogin(toServiceMsg);
                return;
            case 74:
                MsfService.core.wt_getStViaWxLogin(toServiceMsg);
                return;
            case 75:
                MsfService.core.wt_QuickLoginByGateway(toServiceMsg);
                return;
            case 76:
                MsfService.core.wt_GetSaltUinList(toServiceMsg);
                return;
            case 77:
                MsfService.core.wt_GetStByPhoneAndPassword(toServiceMsg);
                return;
            case 78:
                MsfService.core.wt_loginByWx(toServiceMsg);
                return;
            case 79:
                MsfService.core.wt_refreshMemorySig();
                return;
            case 80:
                MsfService.core.sendSsoMsg(toServiceMsg);
                String valueOf = String.valueOf(toServiceMsg.getAttribute("stype", 0));
                HashMap hashMap = new HashMap();
                hashMap.put("MsgType", toServiceMsg.toString());
                hashMap.put("SharpType", valueOf);
                MsfService.core.getStatReporter().a("dim.Msf.RecvVideoS2CACK", false, 0L, 0L, (Map<String, String>) hashMap, true, false);
                com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247657i, toServiceMsg.getWupBuffer(), 0);
                return;
            case 81:
                FromServiceMsg a36 = n.a(toServiceMsg);
                a36.addAttribute("msf_con_erro", com.tencent.mobileqq.msf.core.net.o.W);
                a36.setMsgSuccess();
                e.b(b16, toServiceMsg, a36);
                return;
            case 82:
                MsfService.core.sendMsgSignal();
                return;
            case 83:
                MsfService.core.refreshDA2(toServiceMsg);
                return;
            case 84:
                com.tencent.mobileqq.msf.core.stepcount.f.b(b16, toServiceMsg);
                return;
            case 85:
                try {
                    long longValue = ((Long) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_INFOSYNC_TIMESTAMP)).longValue();
                    v.a(toServiceMsg.getUin(), longValue);
                    QLog.d(f250961a, 1, "recv infoSync timestamp:" + longValue);
                    return;
                } catch (Exception e18) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f250961a, 2, "failed to recv infologin end ", e18);
                        return;
                    }
                    return;
                }
            case 86:
                try {
                    com.tencent.mobileqq.msf.core.o.a((String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_GEOGINFO_LONGITUDE), (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_GEOGINFO_LATITUDE), NetConnInfoCenter.getServerTime());
                    return;
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f250961a, 2, "failed to save geog info ", e19);
                        return;
                    }
                    return;
                }
            case 87:
                LogManager.checkManualLogLevel(((Integer) toServiceMsg.getAttribute("opType")).intValue(), ((Integer) toServiceMsg.getAttribute("manualLogLevel")).intValue());
                return;
            case 88:
                MsfCore.mLocaleId = ((Integer) toServiceMsg.getAttribute("localeId", Integer.valueOf(MsfCore.mLocaleId))).intValue();
                return;
            case 89:
                MsfService.core.updateBatteryStatus(toServiceMsg);
                return;
            case 90:
                com.tencent.mobileqq.msf.core.x.d.a(toServiceMsg);
                return;
            case 91:
                com.tencent.mobileqq.msf.core.m.i().a(toServiceMsg);
                return;
            case 92:
                boolean isWeakNet = MsfService.getCore().isWeakNet();
                FromServiceMsg a37 = n.a(toServiceMsg);
                a37.addAttribute(BaseConstants.ATTRIBUTE_KEY_GET_WEAK_NET, Boolean.valueOf(isWeakNet));
                a37.setMsgSuccess();
                e.b(b16, toServiceMsg, a37);
                return;
            case 93:
                com.tencent.mobileqq.msf.core.d0.a.c().a((String) toServiceMsg.getAttribute(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_CMD, ""), (String) toServiceMsg.getAttribute(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_PARAM, ""), new a(toServiceMsg, b16));
                return;
            case 94:
                LogReport.reportLog(toServiceMsg.getUin(), ((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_WITHOUTLOGIN, Boolean.FALSE)).booleanValue(), ((Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_STARTTIME, 0L)).longValue(), ((Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_ENDTIME, 0L)).longValue(), (String) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_PSKEY, ""));
                return;
            case 95:
                LogReport.reportLogAfterFetchConfig(toServiceMsg);
                return;
            case 96:
                LogReport.getInstance().onLogPushColorLevel(toServiceMsg);
                return;
            case 97:
                com.tencent.mobileqq.msf.core.i0.a.v().a(toServiceMsg);
                return;
            case 98:
                com.tencent.mobileqq.msf.core.x.e.o().a(toServiceMsg);
                return;
            case 99:
                com.tencent.mobileqq.msf.core.i0.a.v().b(toServiceMsg);
                return;
            case 100:
                com.tencent.mobileqq.msf.core.b.f().a(toServiceMsg);
                return;
            case 101:
                com.tencent.mobileqq.msf.core.x.i.a().a(toServiceMsg);
                return;
            case 102:
                MsfService.core.pushManager.d(((Boolean) toServiceMsg.getAttribute(BaseConstants.KEY_IS_BLOCK_PUSH_REGISTER, Boolean.TRUE)).booleanValue());
                return;
            case 103:
                f.c().d();
                return;
            case 104:
                com.tencent.mobileqq.msf.core.x.a.b().a(toServiceMsg);
                return;
            case 105:
                q.s().post(new b(toServiceMsg));
                return;
            case 106:
                if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                    return;
                }
                com.tencent.mobileqq.msf.core.f0.a msfNetService = MsfService.core.getMsfNetService();
                if (msfNetService instanceof com.tencent.mobileqq.msf.core.f0.d.a) {
                    try {
                        ((com.tencent.mobileqq.msf.core.f0.d.a) msfNetService).r().j().f250076a.i().a(com.tencent.qphone.base.a.readError);
                        return;
                    } catch (Exception e26) {
                        QLog.e(f250961a, 1, "msf_test_close_conn error", e26);
                        return;
                    }
                }
                return;
            case 107:
                if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                    return;
                }
                com.tencent.mobileqq.msf.core.f0.a msfNetService2 = MsfService.core.getMsfNetService();
                if (msfNetService2 instanceof com.tencent.mobileqq.msf.core.f0.c.b) {
                    JSONObject jSONObject = new JSONObject(((com.tencent.mobileqq.msf.core.f0.c.b) msfNetService2).s());
                    FromServiceMsg a38 = n.a(toServiceMsg);
                    a38.setMsgSuccess();
                    a38.addAttribute(BaseConstants.ATTRIBUTE_KEY_MSF_CORE_STATE_PARAM_MAP, jSONObject.toString());
                    MsfService.getCore().addRespToQuque(toServiceMsg, a38);
                    return;
                }
                return;
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
                return;
            default:
                MsfService.core.sendSsoMsg(toServiceMsg);
                return;
        }
    }

    public static void a(byte[] bArr, int i3, long j3) {
        bArr[i3] = (byte) (j3 >> 24);
        bArr[i3 + 1] = (byte) (j3 >> 16);
        bArr[i3 + 2] = (byte) (j3 >> 8);
        bArr[i3 + 3] = (byte) j3;
    }
}
