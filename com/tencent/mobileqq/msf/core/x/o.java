package com.tencent.mobileqq.msf.core.x;

import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequest;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.protohandler.NearbyPeoplePicUpHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import mqq.app.MainService;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class o {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f250364a = "MSFWhiteListConfig";

    /* renamed from: b, reason: collision with root package name */
    private static final HashSet<String> f250365b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashSet<String> f250366c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashSet<String> f250367d;

    /* renamed from: e, reason: collision with root package name */
    private static final HashSet<String> f250368e;

    /* renamed from: f, reason: collision with root package name */
    private static final HashSet<String> f250369f;

    /* renamed from: g, reason: collision with root package name */
    private static final HashSet<String> f250370g;

    /* renamed from: h, reason: collision with root package name */
    private static final HashSet<String> f250371h;

    /* renamed from: i, reason: collision with root package name */
    private static final HashSet<String> f250372i;

    /* renamed from: j, reason: collision with root package name */
    public static final HashSet<String> f250373j;

    /* renamed from: k, reason: collision with root package name */
    public static final HashSet<MsfCommand> f250374k;

    /* renamed from: l, reason: collision with root package name */
    public static final HashSet<String> f250375l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final o f250376a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18526);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250376a = new o(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26465);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f250365b = new HashSet<>();
        f250366c = new HashSet<>();
        f250367d = new HashSet<>();
        f250368e = new HashSet<>();
        f250369f = new HashSet<>();
        f250370g = new HashSet<>();
        f250371h = new HashSet<>();
        f250372i = new HashSet<>();
        f250373j = new HashSet<>();
        f250374k = new HashSet<>();
        f250375l = new HashSet<>();
    }

    /* synthetic */ o(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    private void m() {
        HashSet<MsfCommand> hashSet = f250374k;
        hashSet.add(MsfCommand.onStartConnect);
        hashSet.add(MsfCommand.onConnOpened);
        hashSet.add(MsfCommand.reNotifyConnOpened);
        hashSet.add(MsfCommand.onConnClosed);
        hashSet.add(MsfCommand.onOepnConnAllFailed);
        hashSet.add(MsfCommand.onReceFirstResp);
    }

    private void n() {
        HashSet<String> hashSet = f250375l;
        hashSet.add("VideoSvc");
        hashSet.add("SharpSvr.s2c");
        hashSet.add("MessageSvc.Push");
        hashSet.add("OnlinePush");
        hashSet.add(BaseConstants.CMD_TRPC_MSG_PUSH);
        hashSet.add(BaseConstants.CMD_SEC_DISPATCH_TO_APP);
    }

    private void o() {
        HashSet<String> hashSet = f250373j;
        hashSet.add("friendlist.GetUserAddFriendSettingReq");
        hashSet.add("friendlist.AddFriendReq");
        hashSet.add(BaseConstants.CMD_WT_LOGIN_AUTH);
        hashSet.add(BaseConstants.CMD_WT_LOGIN_NAME2UIN);
        hashSet.add("wtlogin.exchange_emp");
        hashSet.add("wtlogin.register");
        hashSet.add(util.CMD_LOG_REPORT);
        hashSet.add(util.CMD_DEVICE_LOCK);
        hashSet.add(util.CMD_QR_LOGIN);
        hashSet.add("OidbSvcTcp.0x102a");
        hashSet.add(BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC);
        hashSet.add(BaseConstants.CMD_NT_REGPRXSYNC_GROUP_MSG);
        hashSet.add(BaseConstants.CMD_NT_REGPRXSYNC_BATCH_GET_MSG);
        hashSet.add(BaseConstants.CMD_NT_PUSH_REGISTER);
        hashSet.add(BaseConstants.CMD_NT_PUSH_UNREGISTER);
        hashSet.add(BaseConstants.CMD_NT_SSO_HEART_BEAT);
        hashSet.add(BaseConstants.CMD_MSG_PBSENDMSG);
        hashSet.add("trpc.group_pro.synclogic.SyncLogic.SyncFirstView");
        hashSet.add("trpc.group_pro.synclogic.SyncLogic.GetMultiChannelMsg");
        hashSet.add("trpc.group_pro.synclogic.SyncLogic.SsoGetSubscribedGuildMsg");
        hashSet.add("MsgProxy.SendMsg");
        hashSet.add("trpc.o3.ecdh_access.EcdhAccess.SsoEstablishShareKey");
        hashSet.add("trpc.o3.ecdh_access.EcdhAccess.SsoSecureAccess");
        hashSet.add("trpc.qqrtc.av_appsvr.AvAppsvr.SsoLoginQueryInfo");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoOIDB0x90cd");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoOIDB0x90ce");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoKeyExchange");
        hashSet.add("trpc.msg.olpush.OlPushService.SsoPushAck");
        hashSet.add("trpc.msg.register_proxy.RegisterProxy.SsoSyncPushNotifyMsg");
        hashSet.add(BaseConstants.CMD_NT_SSO_GET_PEER_SEQ);
        hashSet.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_C2C_MSG);
        hashSet.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_ROAM_MSG);
        hashSet.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_MSG);
        hashSet.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_SHARE_MSG);
        hashSet.add("trpc.msg.pushsvc.PushService.SsoSetToken");
        hashSet.add("trpc.msg.msg_svc.MsgService.SsoC2CRecallMsg");
        hashSet.add("trpc.msg.msg_svc.MsgService.SsoGroupRecallMsg");
        hashSet.add("trpc.msg.msg_svc.MsgService.SsoReadedReport");
        hashSet.add("trpc.msg.msg_svc.MsgService.SsoDeleteMsg");
        hashSet.add(BaseConstants.CMD_MSF_CONN_PROBE_ACK);
        hashSet.add(BaseConstants.CMD_STATUS_SVC_MSF_HELLO);
    }

    private void p() {
        HashSet<String> hashSet = f250368e;
        hashSet.add(BaseConstants.CMD_LOGIN_AUTH);
        hashSet.add(BaseConstants.CMD_LOGIN_CHANGEUIN_AUTH);
        hashSet.add("GrayUinPro.Check");
        hashSet.add(BaseConstants.CMD_WT_LOGIN_AUTH);
        hashSet.add(BaseConstants.CMD_WT_LOGIN_NAME2UIN);
        hashSet.add("wtlogin.exchange_emp");
        hashSet.add("wtlogin.trans_emp");
        hashSet.add(util.CMD_LOG_REPORT);
        hashSet.add("wtlogin.register");
        hashSet.add(BaseConstants.CMD_WT_LOGIN_ADDCONTACTS);
        hashSet.add(BaseConstants.CMD_WT_LOGIN_REQUESTREBINDMBL);
        hashSet.add(BaseConstants.CMD_CONNAUTHSVR_GETAPPINFO);
        hashSet.add(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST);
        hashSet.add(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI);
        hashSet.add("QQConnectLogin.pre_auth_emp");
        hashSet.add("QQConnectLogin.auth_emp");
        hashSet.add(BaseConstants.CMD_REQ_CHECKSIGNATURE);
        hashSet.add("trpc.o3.ecdh_access.EcdhAccess.SsoEstablishShareKey");
        hashSet.add("trpc.o3.ecdh_access.EcdhAccess.SsoSecureAccess");
        hashSet.add("trpc.o3.mobile_security.MobileSecurity.SsoCheckSwitch");
        hashSet.add(BaseConstants.CMD_REPORTSTAT);
        hashSet.add("trpc.qqlog.qqlog_push.Portal.SsoPullReportRule");
        hashSet.add("trpc.login.account_logic.AccountLogicService.SsoThirdPartQueryEncryptedBind");
        hashSet.add("trpc.zplan.avatar_head_info.Config.SsoGetRegisterHeadConfig");
        hashSet.add("trpc.group_pro.configdistribution.ConfigDistributionSvr.SsoGetNoLoginConfig");
        hashSet.add("trpc.o3.report.Report.SsoReport");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoOIDB0x90cd");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoOIDB0x90ce");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoKeyExchange");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginPasswordLogin");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginOptimusLogin");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginGetSaltList");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginCheckA1List");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginGetSms");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginCheckSms");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginCheckGateWayCode");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginCheckThirdCode");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginRefreshTicket");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginAuthNewDevice");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoOIDB0x916a");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoOIDB0x916b");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoOIDB0x916c");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoOIDB0x916d");
        hashSet.add("trpc.login.ecdh.EcdhService.SsoNTLoginRapidLogin");
        q();
    }

    private void r() {
        HashSet<String> hashSet = f250372i;
        hashSet.add(BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC);
        hashSet.add(BaseConstants.CMD_NT_REGPRXSYNC_BATCH_GET_MSG);
        hashSet.add(BaseConstants.CMD_NT_REGPRXSYNC_GROUP_MSG);
        hashSet.add("trpc.group_pro.synclogic.SyncLogic.SyncFirstView");
        hashSet.add("trpc.group_pro.synclogic.SyncLogic.GetMultiChannelMsg");
        hashSet.add("trpc.qq_new_tech.status_svc.StatusService.Kick");
        hashSet.add("trpc.qq_new_tech.status_svc.StatusService.GetStatus");
        hashSet.add("trpc.qq_new_tech.status_svc.StatusService.SetStatus");
        hashSet.add("trpc.msg.pushsvc.PushService.SsoSetToken");
        hashSet.add("trpc.msg.pushsvc.PushService.SsoSwitchChange");
        hashSet.add("trpc.msg.pushsvc.PushService.SsoDoForeGround");
        hashSet.add("trpc.msg.pushsvc.PushService.SsoDoBackGround");
        hashSet.add("PushService.settoken");
        hashSet.add("PushService.SvcReqForeGround");
        hashSet.add("PushService.SvcReqBackGround");
        hashSet.add(BaseConstants.CMD_NT_SSO_HEART_BEAT);
        hashSet.add(BaseConstants.CMD_NT_PUSH_REGISTER);
        hashSet.add(BaseConstants.CMD_NT_PUSH_UNREGISTER);
    }

    private void s() {
        HashSet<String> hashSet = f250369f;
        hashSet.add(BaseConstants.CMD_MSG_PBSENDMSG);
        hashSet.add("MsgProxy.SendMsg");
        hashSet.add("ImgStore.GroupPicUp");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GROUPPIC_DOWN);
        hashSet.add("LongConn.OffPicUp");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_OFFPIC_DOWN);
        hashSet.add("OidbSvc.0x6d8_4");
        hashSet.add("OidbSvc.0x6d6_0");
        hashSet.add("OidbSvc.0x6d6_1");
        hashSet.add("OidbSvc.0x6d6_2");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100");
        hashSet.add("GTalkFileAppSvr.CMD_DISCUSS_FILE");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800");
        hashSet.add("ProfileService.Pb.ReqSystemMsgAction.Friend");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GUILDPIC_UP);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GUILDPIC_DOWN);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_SHARE_PIC_TO_WX);
        hashSet.add("ProfileService.Pb.ReqSystemMsgRead.Friend");
        hashSet.add("ProfileService.Pb.ReqSystemMsgRead.Group");
        hashSet.add("ProfileService.Pb.ReqNextSystemMsg.Friend");
        hashSet.add("ProfileService.Pb.ReqNextSystemMsg.Group");
        hashSet.add("ProfileService.Pb.ReqSystemMsgAction.Group");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800");
        hashSet.add("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_BDH_COMMON_UP);
        hashSet.add(RichMediaConstants.CMD_TEMP_PTT_DOWNLOAD);
        hashSet.add(RichMediaConstants.CMD_OFFLINEFILE_PTT_DOWN);
        hashSet.add(RichMediaConstants.CMD_TEMP_PTT_UPLOAD);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GROUPPTT_DOWN);
        hashSet.add("PttStore.GroupPttDown#pttGd");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GROUPPTT_UP);
        hashSet.add("PttStore.GroupPttUp#pttGu");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_MULTIMSG_DOWN);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_MULTIMSG_UP);
        hashSet.add(NearbyPeoplePicUpHandler.CMD_GET_IP_LIST);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_LONG_STRUCT_MESSAGE_DOWN);
        hashSet.add(RichMediaConstants.CMD_SHORT_VIDEO_DOWN);
        hashSet.add(RichMediaConstants.CMD_GROUP_SHORT_VIDEO_UP);
        hashSet.add(RichMediaConstants.CMD_GROUP_SHORT_VIDEO_DOWN);
        hashSet.add(RichMediaConstants.CMD_SHORT_VIDEO_FORWARD);
        hashSet.add(RichMediaConstants.CMD_VIDEO_EMOTICON_DOWN);
        hashSet.add(RichMediaConstants.CMD_SHORT_VIDEO_UP);
        hashSet.add("ConnAuthSvr.get_auth_api_list");
        hashSet.add(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST);
        hashSet.add("ConnAuthSvr.sdk_auth_api");
        hashSet.add(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI);
    }

    private void t() {
        HashSet<String> hashSet = f250371h;
        hashSet.add(BaseConstants.CMD_MSG_PBSENDMSG);
        hashSet.add("MsgProxy.SendMsg");
        hashSet.add("ImgStore.GroupPicUp");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GROUPPIC_DOWN);
        hashSet.add("LongConn.OffPicUp");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_OFFPIC_DOWN);
        hashSet.add("OidbSvc.0x6d8_4");
        hashSet.add("OidbSvc.0x6d6_0");
        hashSet.add("OidbSvc.0x6d6_1");
        hashSet.add("OidbSvc.0x6d6_2");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100");
        hashSet.add("GTalkFileAppSvr.CMD_DISCUSS_FILE");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800");
        hashSet.add("ProfileService.Pb.ReqSystemMsgAction.Friend");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GUILDPIC_UP);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GUILDPIC_DOWN);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_SHARE_PIC_TO_WX);
        hashSet.add("ProfileService.Pb.ReqSystemMsgRead.Friend");
        hashSet.add("ProfileService.Pb.ReqSystemMsgRead.Group");
        hashSet.add("ProfileService.Pb.ReqNextSystemMsg.Friend");
        hashSet.add("ProfileService.Pb.ReqNextSystemMsg.Group");
        hashSet.add("ProfileService.Pb.ReqSystemMsgAction.Group");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800");
        hashSet.add("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ");
        hashSet.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_BDH_COMMON_UP);
        hashSet.add(RichMediaConstants.CMD_TEMP_PTT_DOWNLOAD);
        hashSet.add(RichMediaConstants.CMD_OFFLINEFILE_PTT_DOWN);
        hashSet.add(RichMediaConstants.CMD_TEMP_PTT_UPLOAD);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GROUPPTT_DOWN);
        hashSet.add("PttStore.GroupPttDown#pttGd");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GROUPPTT_UP);
        hashSet.add("PttStore.GroupPttUp#pttGu");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_MULTIMSG_DOWN);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_MULTIMSG_UP);
        hashSet.add(NearbyPeoplePicUpHandler.CMD_GET_IP_LIST);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_LONG_STRUCT_MESSAGE_DOWN);
        hashSet.add(RichMediaConstants.CMD_SHORT_VIDEO_DOWN);
        hashSet.add(RichMediaConstants.CMD_GROUP_SHORT_VIDEO_UP);
        hashSet.add(RichMediaConstants.CMD_GROUP_SHORT_VIDEO_DOWN);
        hashSet.add(RichMediaConstants.CMD_SHORT_VIDEO_FORWARD);
        hashSet.add(RichMediaConstants.CMD_VIDEO_EMOTICON_DOWN);
        hashSet.add(RichMediaConstants.CMD_SHORT_VIDEO_UP);
        hashSet.add("ConnAuthSvr.get_auth_api_list");
        hashSet.add(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST);
        hashSet.add("ConnAuthSvr.sdk_auth_api");
        hashSet.add(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI);
    }

    private void u() {
        f250370g.add(BaseConstants.CMD_MSG_PBSENDMSG);
    }

    private void v() {
        HashSet<String> hashSet = f250367d;
        hashSet.add("sso-qqchannel");
        hashSet.add(BaseConstants.KEY_CLIENT_CONN_SEQ);
        hashSet.add("sso_push_rsp_addr");
        hashSet.add("qq-trans");
    }

    private void w() {
        HashSet<String> hashSet = f250365b;
        hashSet.add("StatSvc.register");
        hashSet.add("PushService.register");
        hashSet.add("RegPrxySvc.info");
        hashSet.add("RegPrxySvc.infoNew");
        hashSet.add("RegPrxySvc.infoAndroid");
        hashSet.add(BaseConstants.CMD_REGPRXYSVC_INFOLOGIN);
        hashSet.add(BaseConstants.CMD_NEW_REGPRXYSVC_INFOSYNC);
        hashSet.add("im_status.stat_reg");
        hashSet.add(BaseConstants.CMD_SSO_LOGIN_MERGE);
        hashSet.add("wtlogin.trans_emp");
        hashSet.add(util.CMD_LOG_REPORT);
        hashSet.add("wtlogin.register");
        hashSet.add(util.CMD_DEVICE_LOCK);
        hashSet.add(util.CMD_QR_LOGIN);
        hashSet.add("wtlogin.exchange_emp");
        hashSet.add(BaseConstants.CMD_WT_LOGIN_NAME2UIN);
        hashSet.add(BaseConstants.CMD_WT_LOGIN_AUTH);
        hashSet.add(BaseConstants.CMD_NT_PUSH_REGISTER);
        hashSet.add(BaseConstants.CMD_NT_PUSH_UNREGISTER);
        hashSet.add(BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC);
        hashSet.add(BaseConstants.CMD_NT_REGPRXSYNC_GROUP_MSG);
        hashSet.add(BaseConstants.CMD_NT_REGPRXSYNC_BATCH_GET_MSG);
    }

    public static o x() {
        return b.f250376a;
    }

    public HashSet<MsfCommand> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? f250374k : (HashSet) iPatchRedirector.redirect((short) 14, (Object) this);
    }

    public HashSet<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (HashSet) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return f250375l;
    }

    public HashSet<String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HashSet) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return f250365b;
    }

    public HashSet<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (HashSet) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return f250373j;
    }

    public HashSet<String> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashSet) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return f250366c;
    }

    public HashSet<String> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (HashSet) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return f250368e;
    }

    public HashSet<String> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (HashSet) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return f250372i;
    }

    public HashSet<String> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashSet) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return f250369f;
    }

    public HashSet<String> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (HashSet) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return f250371h;
    }

    public HashSet<String> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashSet) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return f250370g;
    }

    public HashSet<String> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HashSet) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return f250367d;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            a(com.tencent.mobileqq.msf.core.x.b.V());
            w();
            v();
            p();
            s();
            u();
            t();
            r();
            o();
            m();
            n();
        } catch (Exception e16) {
            QLog.d(f250364a, 1, "[MSFWhiteListConfig] init error ", e16);
        }
    }

    o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void a(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) strArr);
            return;
        }
        if (strArr != null) {
            for (String str : strArr) {
                if (str != null && str.length() > 0) {
                    f250366c.add(str);
                }
            }
        }
        HashSet<String> hashSet = f250366c;
        hashSet.add("GrayUinPro.Check");
        hashSet.add("StatSvc.register");
        hashSet.add("StatSvc.get");
        hashSet.add(BaseConstants.CMD_REGPRXYSVC_INFOLOGIN);
        hashSet.add(BaseConstants.CMD_NEW_REGPRXYSVC_INFOSYNC);
        hashSet.add(BaseConstants.CMD_WT_LOGIN_AUTH);
        hashSet.add(BaseConstants.CMD_REGPRXYSVC_GETOFFMSG);
        hashSet.add(BaseConstants.CMD_LOGIN_AUTH);
        hashSet.add(BaseConstants.CMD_WT_LOGIN_EXCHANGE);
        hashSet.add("wtlogin.trans_emp");
        hashSet.add(util.CMD_LOG_REPORT);
        hashSet.add("wtlogin.register");
        hashSet.add(util.CMD_DEVICE_LOCK);
        hashSet.add(util.CMD_QR_LOGIN);
        hashSet.add(BaseConstants.CMD_MSG_PBSENDMSG);
        hashSet.add("LongConn.OffPicUp");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_OFFPIC_DOWN);
        hashSet.add("ImgStore.GroupPicUp");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GROUPPIC_DOWN);
        hashSet.add("StreamSvr.UploadStreamMsg");
        hashSet.add("StreamSvr.RespUploadStreamMsg");
        hashSet.add("StreamSvr.PushStreamMsg");
        hashSet.add("StreamSvr.RespPushStreamMsg");
        hashSet.add("OidbSvc.0x787_1");
        hashSet.add("OidbSvc.0x49d_107");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_MULTIMSG_UP);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_MULTIMSG_DOWN);
        hashSet.add(RichMediaConstants.CMD_SHORT_VIDEO_UP);
        hashSet.add(RichMediaConstants.CMD_SHORT_VIDEO_DOWN);
        hashSet.add("ImgStore.GroupPicUp#pttGu");
        hashSet.add("ImgStore.GroupPicDown#pttGd");
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GROUPPTT_UP);
        hashSet.add(RichMediaConstants.CMD_LONGCONN_GROUPPTT_DOWN);
        hashSet.add(BaseConstants.CMD_HEARTBEATALIVE);
        hashSet.add("friendlist.getFriendGroupList");
        hashSet.add("VideoSvc.Send");
        hashSet.add("VideoSvc.Ack");
        hashSet.add("SharpSvr.c2s");
        hashSet.add("SharpSvr.c2sack");
        hashSet.add("SharpSvr.s2c");
        hashSet.add("SharpSvr.s2cack");
        hashSet.add("MultiVideo.c2s");
        hashSet.add("MultiVideo.c2sack");
        hashSet.add("MultiVideo.s2c");
        hashSet.add("MultiVideo.s2cack");
        hashSet.add("MessageSvc.PbGetMsg");
        hashSet.add(RichMediaConstants.CMD_TEMP_PTT_DOWNLOAD);
        hashSet.add(RichMediaConstants.CMD_TEMP_PTT_UPLOAD);
        hashSet.add(RichMediaConstants.CMD_OFFLINEFILE_PTT_DOWN);
        hashSet.add(BaseConstants.CMD_OPENCONN);
        hashSet.add("wtlogin.exchange_emp");
        hashSet.add(BaseConstants.CMD_WT_LOGIN_NAME2UIN);
        hashSet.add(BaseConstants.CMD_GETTIMENEW);
        hashSet.add(BaseConstants.CMD_FORCEOFFLINERESP);
        hashSet.add(GetUserAppListRequest.CMD_STRING);
        hashSet.add("qzoneh5.video.vv");
        hashSet.add("MsgProxy.SendMsg");
        hashSet.add(ProfileContants.CMD_GROUPMNGREQ);
        hashSet.add("OidbSvc.0x758_0");
        hashSet.add("OidbSvc.0x758_1");
        hashSet.add("friendlist.addFriend");
        hashSet.add("OidbSvc.0x8a1_0");
        hashSet.add("OidbSvc.0x89a_0");
        hashSet.add("OidbSvc.0x88d_0");
        hashSet.add("OidbSvc.0xb77_9");
        hashSet.add("OidbSvc.0xdc2_9");
        hashSet.add("OidbSvc.0xd55");
        hashSet.add(MainService.CMD_PRE_AUTH);
        hashSet.add("ConnAuthSvr.get_app_info");
        hashSet.add("ConnAuthSvr.sdk_auth_api");
        hashSet.add("ConnAuthSvr.get_auth_api_list");
        hashSet.add("QQConnectLogin.pre_auth_emp");
        hashSet.add(BaseConstants.CMD_CONNAUTHSVR_GETAPPINFO);
        hashSet.add(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI);
        hashSet.add(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST);
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.PublishFeed");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoTop");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoFollow");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DelFeed");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoComment");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoReward");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoLike");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoPush");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoReply");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPagePymkRecomFeedList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.ClearRedPoint");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFollowTagList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRankingList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedDetail");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFollowList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetSessionInfo");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainpage");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRelationGroupList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetC2CFeed");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.BatchGetFeedDetail");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCloudSealFeed");
        hashSet.add(QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST);
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListMusic");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListUnifiedTag");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListLike");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCommentList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.ClearCount");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetGroupFeedList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetBackflowUserPymkPageFeedList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetLightInteractList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetBusiInfo");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRecomUserList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRewardInfo");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetNoticeList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetNewUserPymkPageFeedList");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.QQSubscription.GetFeedListSubscription");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.commreader.QQSubscription.GetFeedListDiscovery");
        hashSet.add("FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.DataReport");
        hashSet.add("FeedCloudSvr.trpc.videocircle.videourlexchange.VideoURLExchange.GetVideoAdaptInfo");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circletaskcenter.TaskCenterReader.GetTaskList");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circleprivatemsgshow.CirclePrivateMsgShow.BatchGetPMGiftInfo");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circleprivatemsgshow.CirclePrivateMsgShow.GetPMSetting");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circleprivatemsgaio.CirclePrivateMsgAio.GetPMBeginShowMsgReq");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circleprivatemsgshow.CirclePrivateMsgShow.ChangePMSetting");
        hashSet.add("FeedCloudSvr.trpc.circlesearch.exhibition.ExhibitionSvr.ExhibitionMoreData");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetSmartMatchMusic");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetMusicInfo");
        hashSet.add("FeedCloudSvr.trpc.feedcloud.tagcategorysvr.TagCategoryProcess.GetTagCategoryRecom");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.SetUserSwitch");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.SetProfile");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.CheckBindGroup");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circleright.CircleRight.SetCircleUnCare");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circleright.CircleRight.GetCircleUnCareList");
        hashSet.add("FeedCloudSvr.trpc.videocircle.circleenvhub.EnvHub.ExposeTips");
        hashSet.add("SQQzoneSvc.publishmood");
        hashSet.add("SQQzoneSvc.like");
        hashSet.add("SQQzoneSvc.addComment");
        hashSet.add("SQQzoneSvc.addReply");
        hashSet.add("SQQzoneSvc.forward");
        hashSet.add(ProfileContants.CMD_SET_DETAIL_INFO);
        hashSet.add("QChannelSvr.trpc.qchannel.commwriter.ComWriter.PublishFeed");
        hashSet.add("QChannelSvr.trpc.qchannel.commwriter.ComWriter.DoComment");
        hashSet.add("QChannelSvr.trpc.qchannel.commwriter.ComWriter.DoReply");
        hashSet.add("OidbSvcTrpcTcp.0xf88_1");
        hashSet.add("OidbSvcTrpcTcp.0xf89_1");
        hashSet.add("OidbSvcTrpcTcp.0xf57_1");
        hashSet.add("OidbSvcTrpcTcp.0xf57_106");
        hashSet.add("OidbSvcTrpcTcp.0xf57_9");
        hashSet.add("OidbSvcTrpcTcp.0xf55_1");
        hashSet.add("OidbSvcTrpcTcp.0xf67_1");
        hashSet.add("OidbSvcTrpcTcp.0xf67_5");
        hashSet.add("trpc.qlive.relationchain_svr.RelationchainSvr.Follow");
        hashSet.add("trpc.qlive.word_svr.WordSvr.NewPublicChat");
        hashSet.add("trpc.o3.ecdh_access.EcdhAccess.SsoEstablishShareKey");
        hashSet.add("trpc.o3.ecdh_access.EcdhAccess.SsoSecureAccess");
        hashSet.add("trpc.o3.report.Report.SsoReport");
        hashSet.add(BaseConstants.CMD_REPORTSTAT);
        hashSet.add("OidbSvcTrpcTcp.0x123c_1");
        hashSet.add(BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC);
        hashSet.add(BaseConstants.CMD_NT_REGPRXSYNC_GROUP_MSG);
        hashSet.add(BaseConstants.CMD_NT_REGPRXSYNC_BATCH_GET_MSG);
        hashSet.add("OidbSvcTrpcTcp.0x129c_1");
        hashSet.add("OidbSvcTrpcTcp.0x1266_1");
        hashSet.add("OidbSvcTrpcTcp.0x9293_0");
        hashSet.add("OidbSvcTrpcTcp.0x9294_0");
        hashSet.add("OidbSvcTrpcTcp.0x9295_0");
        hashSet.add("OidbSvcTrpcTcp.0x9296_0");
        hashSet.add("OidbSvcTrpcTcp.0x90a5_3");
    }

    private void q() {
    }
}
