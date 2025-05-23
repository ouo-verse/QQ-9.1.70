package com.tencent.qidian.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.f;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qidian.proto.mobileqq_qidian$CRMMsgHead;
import com.tencent.qidian.proto.mobileqq_qidian$CheckMpqqRefuseFlagRsp;
import com.tencent.qidian.proto.mobileqq_qidian$ClickEManReqBody;
import com.tencent.qidian.proto.mobileqq_qidian$ClickReplyCmdActionReqBody;
import com.tencent.qidian.proto.mobileqq_qidian$ExternalInfo;
import com.tencent.qidian.proto.mobileqq_qidian$GetCorpUinDetailInfoReqBody;
import com.tencent.qidian.proto.mobileqq_qidian$GetCorpUinDetailInfoRspBody;
import com.tencent.qidian.proto.mobileqq_qidian$GetCustomerTransferInfoReqBody;
import com.tencent.qidian.proto.mobileqq_qidian$GetCustomerTransferInfoRspBody;
import com.tencent.qidian.proto.mobileqq_qidian$GetNavigationMenuConfigReqBody;
import com.tencent.qidian.proto.mobileqq_qidian$GetNavigationMenuConfigRspBody;
import com.tencent.qidian.proto.mobileqq_qidian$GetQiDianGroupInfoReq;
import com.tencent.qidian.proto.mobileqq_qidian$GetQiDianGroupInfoRsp;
import com.tencent.qidian.proto.mobileqq_qidian$GetUserDetailInfoReqBody;
import com.tencent.qidian.proto.mobileqq_qidian$GetUserDetailInfoRspBody;
import com.tencent.qidian.proto.mobileqq_qidian$NotRecvQdGroupMsgRsp;
import com.tencent.qidian.proto.mobileqq_qidian$QidianWpaAddFriendReqBody;
import com.tencent.qidian.proto.mobileqq_qidian$ReqBody;
import com.tencent.qidian.proto.mobileqq_qidian$ReqCorpUinWpaReq;
import com.tencent.qidian.proto.mobileqq_qidian$RetInfo;
import com.tencent.qidian.proto.mobileqq_qidian$RspBody;
import com.tencent.qidian.proto.mobileqq_qidian$VerifyWpaUinAndKeyRsp;
import com.tencent.qidian.proto.mobileqq_qidian$WpaAssignKfextReqBody;
import com.tencent.qidian.proto.mobileqq_qidian$WpaSigtToSigMsgReqBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x7e7.Oidb_0x7e7$ReqBody;
import tencent.im.oidb.cmd0x7e7.Oidb_0x7e7$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x92.SubMsgType0x92$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5$MsgBody;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QidianHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final String f342836e;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f342837d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements IGetTempChatInfoCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f342840a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ byte[] f342841b;

        /* compiled from: P */
        /* renamed from: com.tencent.qidian.controller.QidianHandler$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        class C9304a implements IOperateCallback {
            static IPatchRedirector $redirector_;

            C9304a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public void onResult(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QLog.d(QidianHandler.f342836e, 1, "prepareTempChat ret:" + i3 + " msg:" + str);
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            }
        }

        a(w wVar, byte[] bArr) {
            this.f342840a = wVar;
            this.f342841b = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QidianHandler.this, wVar, bArr);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
        public void onResult(int i3, String str, TempChatInfo tempChatInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, tempChatInfo);
                return;
            }
            if (i3 == 0) {
                IPhoneContactService iPhoneContactService = (IPhoneContactService) QidianHandler.this.f342837d.getRuntimeService(IPhoneContactService.class, "");
                this.f342840a.prepareTempChat(new TempChatPrepareInfo(tempChatInfo.getChatType(), tempChatInfo.getPeerUid(), tempChatInfo.getFromNick(), tempChatInfo.getGroupCode(), this.f342841b, QidianHandler.this.f342837d.getCurrentUid(), iPhoneContactService.getSelfBindInfo().nationCode + iPhoneContactService.getSelfBindInfo().mobileNo, new TempChatGameSession()), new C9304a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f342844a;

        /* renamed from: b, reason: collision with root package name */
        public int f342845b;

        /* renamed from: c, reason: collision with root package name */
        public long f342846c;

        /* renamed from: d, reason: collision with root package name */
        public long f342847d;

        /* renamed from: e, reason: collision with root package name */
        public int f342848e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77548);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
        } else {
            f342836e = QidianHandler.class.getName();
        }
    }

    public QidianHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f342837d = qQAppInterface;
        }
    }

    private mobileqq_qidian$CRMMsgHead J2(String str, int i3, String str2) {
        mobileqq_qidian$CRMMsgHead mobileqq_qidian_crmmsghead = new mobileqq_qidian$CRMMsgHead();
        mobileqq_qidian_crmmsghead.uint32_crm_sub_cmd.set(i3);
        mobileqq_qidian_crmmsghead.uint32_crm_sub_cmd.setHasFlag(true);
        if (!TextUtils.isEmpty(str)) {
            mobileqq_qidian_crmmsghead.uint64_kf_uin.set(Long.valueOf(str).longValue());
            mobileqq_qidian_crmmsghead.uint64_kf_uin.setHasFlag(true);
        }
        if (!TextUtils.isEmpty(str2)) {
            mobileqq_qidian_crmmsghead.uint64_ext_uin.set(Long.valueOf(str2).longValue());
            mobileqq_qidian_crmmsghead.uint64_ext_uin.setHasFlag(true);
        }
        mobileqq_qidian_crmmsghead.uint32_terminal_type.set(2);
        mobileqq_qidian_crmmsghead.uint32_terminal_version.set(com.tencent.qidian.util.b.c(AppSetting.f99551k));
        return mobileqq_qidian_crmmsghead;
    }

    private mobileqq_qidian$ReqBody R2(String str, int i3, String str2) {
        mobileqq_qidian$ReqBody mobileqq_qidian_reqbody = new mobileqq_qidian$ReqBody();
        mobileqq_qidian_reqbody.msg_crm_common_head.set(J2(str, i3, str2));
        mobileqq_qidian_reqbody.msg_crm_common_head.setHasFlag(true);
        mobileqq_qidian_reqbody.uint32_sub_cmd.set(i3);
        mobileqq_qidian_reqbody.uint32_sub_cmd.setHasFlag(true);
        return mobileqq_qidian_reqbody;
    }

    private void T2(SubMsgType0x92$MsgBody subMsgType0x92$MsgBody) {
        SubMsgType0x92$MsgBody.S2CPushEmanMsgToC s2CPushEmanMsgToC = subMsgType0x92$MsgBody.msg_Push_Eman_Msg.get();
        if (s2CPushEmanMsgToC != null) {
            long j3 = s2CPushEmanMsgToC.uint64_uin.get();
            if (s2CPushEmanMsgToC.str_xml.has()) {
                ((QidianManager) this.f342837d.getManager(QQManagerFactory.QIDIAN_MANAGER)).A(this.f342837d, j3, s2CPushEmanMsgToC.str_xml.get());
            }
        }
    }

    private void V2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        try {
            if (fromServiceMsg.isSuccess() && obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                if (mobileqq_qidian_rspbody.msg_not_recv_qd_group_msg_rsp.has()) {
                    mobileqq_qidian$NotRecvQdGroupMsgRsp mobileqq_qidian_notrecvqdgroupmsgrsp = mobileqq_qidian_rspbody.msg_not_recv_qd_group_msg_rsp.get();
                    int i3 = mobileqq_qidian_notrecvqdgroupmsgrsp.msg_ret.uint32_ret_code.get();
                    String str = mobileqq_qidian_notrecvqdgroupmsgrsp.msg_ret.str_error_msg.get();
                    HashMap hashMap = new HashMap();
                    hashMap.put("ret_code", Integer.valueOf(i3));
                    hashMap.put("ret_msg", str);
                    if (i3 == 0) {
                        ThreadManagerV2.executeOnSubThread(new Runnable(toServiceMsg, hashMap) { // from class: com.tencent.qidian.controller.QidianHandler.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ ToServiceMsg f342838d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ HashMap f342839e;

                            {
                                this.f342838d = toServiceMsg;
                                this.f342839e = hashMap;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, QidianHandler.this, toServiceMsg, hashMap);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                MessageRecord w06;
                                MessageForUniteGrayTip messageForUniteGrayTip;
                                g gVar;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                try {
                                    String string = this.f342838d.extraData.getString("extUin");
                                    long j3 = this.f342838d.extraData.getLong("uinseq");
                                    int i16 = this.f342838d.extraData.getInt("uinType");
                                    if (!TextUtils.isEmpty(string) && (w06 = QidianHandler.this.f342837d.getMessageFacade().w0(string, i16, j3)) != null && (w06 instanceof MessageForUniteGrayTip) && (gVar = (messageForUniteGrayTip = (MessageForUniteGrayTip) w06).tipParam) != null && gVar.f() != null) {
                                        messageForUniteGrayTip.tipParam.d();
                                        messageForUniteGrayTip.updateUniteGrayTipMsgData(QidianHandler.this.f342837d);
                                        QidianHandler.this.notifyUI(1005, true, this.f342839e);
                                    }
                                } catch (Exception e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(QidianHandler.f342836e, 2, "handleBlockBulkMsg ", e16);
                                    }
                                }
                            }
                        });
                    } else {
                        notifyUI(1005, false, hashMap);
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f342836e, 2, "handleBlockBulkMsg ", e16);
            }
        }
    }

    private void Y2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        Object obj2;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("key_sigt", toServiceMsg.extraData.get("key_sigt"));
        hashMap.put("uin", toServiceMsg.extraData.get("uin"));
        hashMap.put("key_return_root", toServiceMsg.extraData.get("key_return_root"));
        if (z16) {
            try {
                mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                if (mobileqq_qidian_rspbody.msg_req_corpuin_wpa_rsp.has()) {
                    if (mobileqq_qidian_rspbody.msg_req_corpuin_wpa_rsp.msg_ret.uint32_ret_code.get() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        int i3 = mobileqq_qidian_rspbody.msg_req_corpuin_wpa_rsp.uint32_aio_type.get();
                        if (mobileqq_qidian_rspbody.msg_req_corpuin_wpa_rsp.bytes_sigmsg.has() && (obj2 = toServiceMsg.extraData.get("uin")) != null) {
                            this.f342837d.getMsgCache().h(String.valueOf(obj2), mobileqq_qidian_rspbody.msg_req_corpuin_wpa_rsp.bytes_sigmsg.get().toByteArray());
                            p3(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(obj2)), mobileqq_qidian_rspbody.msg_wpa_assign_kfext_rsp.bytes_sigmsg.get().toByteArray());
                        }
                        hashMap.put("key_aio_type", Integer.valueOf(i3));
                        notifyUI(1007, true, hashMap);
                        return;
                    }
                    notifyUI(1007, false, hashMap);
                    return;
                }
                notifyUI(1007, false, hashMap);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleCorpUinWpaReport ", e16);
                }
                notifyUI(1007, false, hashMap);
                return;
            }
        }
        notifyUI(1007, false, hashMap);
    }

    private void e3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                if (mobileqq_qidian_rspbody.msg_wpa_sigt_to_sigmsg_rsp.has()) {
                    if (mobileqq_qidian_rspbody.msg_wpa_sigt_to_sigmsg_rsp.int32_result.get() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        byte[] byteArray = mobileqq_qidian_rspbody.msg_wpa_sigt_to_sigmsg_rsp.bytes_sigmsg_ext.get().toByteArray();
                        String valueOf = String.valueOf(mobileqq_qidian_rspbody.msg_wpa_sigt_to_sigmsg_rsp.uint64_kfext_uin.get());
                        HashMap hashMap = new HashMap();
                        hashMap.put("uin", valueOf);
                        hashMap.put("sigmsg", byteArray);
                        Bundle bundle = toServiceMsg.extraData;
                        if (bundle != null && !bundle.isEmpty()) {
                            for (String str : bundle.keySet()) {
                                hashMap.put(str, bundle.get(str));
                            }
                        }
                        notifyUI(1010, true, hashMap);
                        return;
                    }
                    notifyUI(1010, false, null);
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleGetSigmsgBySigt " + mobileqq_qidian_rspbody.msg_wpa_sigt_to_sigmsg_rsp.str_err_msg.get());
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleGetSigmsgBySigt ", e16);
                }
                notifyUI(1010, false, null);
                return;
            }
        }
        notifyUI(1010, false, null);
    }

    private void g3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                if (mobileqq_qidian_rspbody.msg_qidian_wpa_addfriend_rsp.has()) {
                    int i3 = mobileqq_qidian_rspbody.msg_close_session_rsp.msg_ret.uint32_ret_code.get();
                    if (i3 == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f342836e, 2, "handleGetWebImAddFriend errorCode = 0");
                        }
                    } else {
                        String str = mobileqq_qidian_rspbody.msg_close_session_rsp.msg_ret.str_error_msg.get();
                        if (QLog.isColorLevel()) {
                            QLog.d(f342836e, 2, "handleGetWebImAddFriend errorCode: " + i3 + " , errorMsg: " + str);
                        }
                    }
                }
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleGetWebImAddFriend ", e16);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "handleGetWebImAddFriend is Success = false");
        }
    }

    private void h3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        try {
            Intent intent = (Intent) toServiceMsg.extraData.getParcelable("intent");
            String str = zq3.b.c((byte[]) obj).f453010c;
            String stringExtra = intent.getStringExtra("uin");
            intent.putExtra("key_peerId", str);
            intent.putExtra("uinname", ac.h(this.f342837d, stringExtra, true));
            if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(stringExtra)) {
                ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(stringExtra, str);
            }
            intent.addFlags(268435456);
            this.f342837d.getApp().startActivity(intent);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void j3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.isSuccess()) {
            if (obj != null) {
                try {
                    mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
                    mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                    if (mobileqq_qidian_rspbody.msg_get_qidian_group_info_rsp.has()) {
                        mobileqq_qidian$GetQiDianGroupInfoRsp mobileqq_qidian_getqidiangroupinforsp = mobileqq_qidian_rspbody.msg_get_qidian_group_info_rsp.get();
                        mobileqq_qidian$RetInfo mobileqq_qidian_retinfo = mobileqq_qidian_getqidiangroupinforsp.msg_ret.get();
                        if (mobileqq_qidian_retinfo.uint32_ret_code.get() == 0) {
                            HashMap hashMap = new HashMap();
                            String stringUtf8 = mobileqq_qidian_getqidiangroupinforsp.bytes_wpalink.get().toStringUtf8();
                            hashMap.put("uin", (String) toServiceMsg.extraData.get("uin"));
                            hashMap.put("url", stringUtf8);
                            notifyUI(1018, true, hashMap);
                            return;
                        }
                        String str = mobileqq_qidian_retinfo.str_error_msg.get();
                        if (QLog.isColorLevel() && !TextUtils.isEmpty(str)) {
                            QLog.d(f342836e, 2, "handleQidianGroupInfo error is " + str);
                        }
                        notifyUI(1018, false, null);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleQidianGroupInfo throw exception is " + e16.toString());
                    }
                    notifyUI(1018, false, null);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "handleQidianGroupInfo data is null");
            }
            notifyUI(1018, false, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "handleQidianGroupInfo res is fail");
        }
        notifyUI(1018, false, null);
    }

    private void p3(String str, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            w msgService = ((IKernelService) this.f342837d.getRuntimeService(IKernelService.class, "")).getMsgService();
            if (msgService == null) {
                QLog.d(f342836e, 1, "uixConvert finish but msgService is null");
                return;
            } else {
                msgService.getTempChatInfo(102, str, new a(msgService, bArr));
                return;
            }
        }
        QLog.d(f342836e, 1, "prepareTempChatInfo sig is null");
    }

    private boolean r3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, String str) {
        boolean z16;
        String str2 = AppConstants.NET_TYPE_NAME[NetworkUtil.getSystemNetwork(this.f342837d.getApp().getBaseContext())];
        long currentTimeMillis = System.currentTimeMillis() - toServiceMsg.extraData.getLong("startTime");
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        if (z17) {
            ReportController.o(this.f342837d, "P_CliOper", "Qidian", "", str + "_success", str + "_success", 0, 0, String.valueOf((int) currentTimeMillis), "", str2, "");
            if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "handleAssignExt success, delta is " + currentTimeMillis);
            }
        } else {
            String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
            ReportController.o(this.f342837d, "P_CliOper", "Qidian", "", str + "_fail", str + "_fail", 0, 0, String.valueOf((int) currentTimeMillis), "", str2, businessFailMsg);
            if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "handleGetAccountType failed, fail message: " + businessFailMsg);
            }
        }
        return z17;
    }

    private void x3(QidianExternalInfo qidianExternalInfo, QidianProfileUiInfo qidianProfileUiInfo) {
        ((QidianManager) this.f342837d.getManager(QQManagerFactory.QIDIAN_MANAGER)).t0(qidianExternalInfo, qidianProfileUiInfo);
    }

    private void y3(QidianExternalInfo qidianExternalInfo, QidianInternalInfo qidianInternalInfo, QidianCorpInfo qidianCorpInfo, QidianProfileUiInfo qidianProfileUiInfo) {
        ((QidianManager) this.f342837d.getManager(QQManagerFactory.QIDIAN_MANAGER)).r0(qidianExternalInfo, qidianInternalInfo, qidianCorpInfo, qidianProfileUiInfo);
    }

    private void z3(mobileqq_qidian$ReqBody mobileqq_qidian_reqbody, String str, Map<String, String> map) {
        ToServiceMsg createToServiceMsg = super.createToServiceMsg(str);
        createToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
        if (map != null) {
            for (String str2 : map.keySet()) {
                createToServiceMsg.extraData.putString(str2, map.get(str2));
            }
        }
        createToServiceMsg.putWupBuffer(mobileqq_qidian_reqbody.toByteArray());
        super.sendPbReq(createToServiceMsg);
        ReportController.o(this.f342837d, "P_CliOper", "Qidian", "", str, str, 0, 0, "", "", AppConstants.NET_TYPE_NAME[NetworkUtil.getSystemNetwork(this.f342837d.getApp().getBaseContext())], "");
    }

    public void A3(String str, String str2, String str3, String str4, String str5, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, str2, str3, str4, str5, Boolean.valueOf(z16));
            return;
        }
        mobileqq_qidian$ReqBody R2 = R2(String.valueOf(str3), 1012, str4);
        if (z16) {
            R2.msg_crm_common_head.uint64_kfaccount.set(Long.valueOf(str5).longValue());
        }
        mobileqq_qidian$QidianWpaAddFriendReqBody mobileqq_qidian_qidianwpaaddfriendreqbody = new mobileqq_qidian$QidianWpaAddFriendReqBody();
        mobileqq_qidian_qidianwpaaddfriendreqbody.str_visitID.set(str);
        mobileqq_qidian_qidianwpaaddfriendreqbody.uint64_customer_uin.set(Long.valueOf(str2).longValue());
        R2.msg_qidian_wpa_addfriend_req.set(mobileqq_qidian_qidianwpaaddfriendreqbody);
        R2.msg_qidian_wpa_addfriend_req.setHasFlag(true);
        z3(R2, "QidianSsoProto.webimAddFriend", null);
    }

    public void F2(String str, int i3, boolean z16, double d16, double d17, String str2, int i16, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Double.valueOf(d16), Double.valueOf(d17), str2, Integer.valueOf(i16), str3, str4, str5);
            return;
        }
        mobileqq_qidian$ReqBody R2 = R2(str2, 3, "");
        mobileqq_qidian$ClickReplyCmdActionReqBody mobileqq_qidian_clickreplycmdactionreqbody = new mobileqq_qidian$ClickReplyCmdActionReqBody();
        mobileqq_qidian_clickreplycmdactionreqbody.str_key.set(str);
        mobileqq_qidian_clickreplycmdactionreqbody.uint32_type.set(i3);
        if (z16) {
            mobileqq_qidian_clickreplycmdactionreqbody.bool_is_need_lbs.set(z16);
            mobileqq_qidian_clickreplycmdactionreqbody.double_latitude.set(d16);
            mobileqq_qidian_clickreplycmdactionreqbody.double_longitude.set(d17);
        }
        mobileqq_qidian_clickreplycmdactionreqbody.uint32_src_type.set(i16);
        mobileqq_qidian_clickreplycmdactionreqbody.str_menu_title.set(str5);
        mobileqq_qidian_clickreplycmdactionreqbody.uint32_terminal_type.set(1001);
        mobileqq_qidian_clickreplycmdactionreqbody.uint32_pubno.set(AppSetting.f());
        R2.msg_click_reply_cmd_action_req.set(mobileqq_qidian_clickreplycmdactionreqbody);
        R2.msg_click_reply_cmd_action_req.setHasFlag(true);
        HashMap hashMap = new HashMap(1);
        hashMap.put("master_uin", str2);
        z3(R2, "QidianSsoProto.clickReplyCmd", hashMap);
        if (i3 == 1) {
            ReportController.o(this.f342837d, "dc00899", "Qidian", str4, "0X800849E", "ClickCard", i16, 1, str3, "1", null, null);
        }
    }

    public void G2(String str, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3, str4, str5, str6);
            return;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                mobileqq_qidian$ReqBody mobileqq_qidian_reqbody = new mobileqq_qidian$ReqBody();
                mobileqq_qidian_reqbody.msg_crm_common_head.set(J2(str, 1008, ""));
                mobileqq_qidian_reqbody.uint32_sub_cmd.set(1008);
                mobileqq_qidian$ReqCorpUinWpaReq mobileqq_qidian_reqcorpuinwpareq = new mobileqq_qidian$ReqCorpUinWpaReq();
                byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str2);
                if (hexStr2Bytes != null && hexStr2Bytes.length > 0) {
                    mobileqq_qidian_reqcorpuinwpareq.bytes_sigt.set(ByteStringMicro.copyFrom(hexStr2Bytes));
                }
                mobileqq_qidian_reqcorpuinwpareq.uint64_qquin.set(Long.parseLong(this.f342837d.getCurrentAccountUin()));
                mobileqq_qidian_reqcorpuinwpareq.uint64_touin.set(Long.parseLong(str3));
                mobileqq_qidian_reqcorpuinwpareq.uint32_assign_type.set(Integer.parseInt(str4));
                mobileqq_qidian_reqcorpuinwpareq.uint64_assign_id.set(Long.parseLong(str5));
                mobileqq_qidian_reqbody.msg_req_corpuin_wpa_req.set(mobileqq_qidian_reqcorpuinwpareq);
                HashMap hashMap = new HashMap();
                hashMap.put("key_return_root", str6);
                hashMap.put("key_sigt", str2);
                hashMap.put("uin", str3);
                z3(mobileqq_qidian_reqbody, "QidianSsoProto.corpUinWpaReport", hashMap);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "corpUinWpaReport ", e16);
                }
            }
        }
    }

    public void H2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
            return;
        }
        new Bundle().putString("k", str);
        StringBuilder sb5 = new StringBuilder("http://qm.qq.com/cgi-bin/qm/qr");
        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        sb5.append("k=");
        sb5.append(str);
        short length = (short) sb5.toString().getBytes().length;
        byte[] bArr = new byte[length + 14];
        PkgTools.word2Byte(bArr, 0, (short) 2);
        PkgTools.word2Byte(bArr, 2, (short) 1);
        PkgTools.word2Byte(bArr, 4, (short) 4);
        PkgTools.dWord2Byte(bArr, 6, 1);
        PkgTools.word2Byte(bArr, 10, (short) 5);
        PkgTools.word2Byte(bArr, 12, length);
        PkgTools.copyData(bArr, 14, sb5.toString().getBytes(), length);
        sendPbReq(makeOIDBPkg("OidbSvc.0x782", 1922, 0, bArr));
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "decodeQidianPrivateTroopUin");
        }
    }

    public void I2(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3);
            return;
        }
        mobileqq_qidian$ReqBody R2 = R2(str2, 1010, str3);
        mobileqq_qidian$ClickEManReqBody mobileqq_qidian_clickemanreqbody = new mobileqq_qidian$ClickEManReqBody();
        mobileqq_qidian_clickemanreqbody.str_key.set(str);
        R2.msg_click_eman_req.set(mobileqq_qidian_clickemanreqbody);
        HashMap hashMap = new HashMap(1);
        hashMap.put("master_uin", str2);
        z3(R2, "QidianSsoProto.emanClickReport", hashMap);
    }

    public void K2(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        mobileqq_qidian$ReqBody R2 = R2("", 1005, String.valueOf(j16));
        mobileqq_qidian$GetCustomerTransferInfoReqBody mobileqq_qidian_getcustomertransferinforeqbody = new mobileqq_qidian$GetCustomerTransferInfoReqBody();
        mobileqq_qidian_getcustomertransferinforeqbody.uint64_qq_uin.set(j3);
        mobileqq_qidian_getcustomertransferinforeqbody.uint64_kfext_uin.set(j16);
        mobileqq_qidian_getcustomertransferinforeqbody.uint32_mobile_client.set(1);
        mobileqq_qidian_getcustomertransferinforeqbody.uint32_ver_no.set(CrmUtils.e(AppSetting.f99551k));
        R2.msg_get_customer_transfer_info_req.set(mobileqq_qidian_getcustomertransferinforeqbody);
        R2.msg_get_customer_transfer_info_req.setHasFlag(true);
        HashMap hashMap = new HashMap(1);
        hashMap.put("kfext", String.valueOf(j16));
        z3(R2, "QidianSsoProto.getCustomerTransferInfo", hashMap);
    }

    public void L2(long j3, long j16, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(f342836e, 2, "getNavigationConfig...version=" + i3);
        }
        mobileqq_qidian$ReqBody R2 = R2(String.valueOf(j3), 1007, null);
        mobileqq_qidian$GetNavigationMenuConfigReqBody mobileqq_qidian_getnavigationmenuconfigreqbody = new mobileqq_qidian$GetNavigationMenuConfigReqBody();
        mobileqq_qidian_getnavigationmenuconfigreqbody.uint64_puin.set(j3);
        mobileqq_qidian_getnavigationmenuconfigreqbody.uint64_uin.set(j16);
        mobileqq_qidian_getnavigationmenuconfigreqbody.uint32_ver_no.set(i3);
        mobileqq_qidian_getnavigationmenuconfigreqbody.uint32_unread_msg_count.set(i16);
        mobileqq_qidian_getnavigationmenuconfigreqbody.uint32_is_click_graytip.set(z16 ? 1 : 0);
        mobileqq_qidian_getnavigationmenuconfigreqbody.uint32_is_support_cc_nav.set(1);
        R2.msg_get_navigation_menu_config_req_body.setHasFlag(true);
        R2.msg_get_navigation_menu_config_req_body.set(mobileqq_qidian_getnavigationmenuconfigreqbody);
        z3(R2, "QidianSsoProto.getNavigationConfig", null);
    }

    public void M2(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) str, (Object) str2);
            return;
        }
        mobileqq_qidian$ReqBody R2 = R2("", 1018, str2);
        mobileqq_qidian$GetQiDianGroupInfoReq mobileqq_qidian_getqidiangroupinforeq = new mobileqq_qidian$GetQiDianGroupInfoReq();
        mobileqq_qidian_getqidiangroupinforeq.uint32_groupcode.set(Integer.valueOf(str).intValue());
        mobileqq_qidian_getqidiangroupinforeq.uint64_groupowner.set(Long.valueOf(str2).longValue());
        R2.msg_get_qidian_group_info_req.set(mobileqq_qidian_getqidiangroupinforeq);
        R2.msg_get_qidian_group_info_req.setHasFlag(true);
        HashMap hashMap = new HashMap();
        hashMap.put("uin", str);
        z3(R2, "QidianSsoProto.getQidianGroupInfo", hashMap);
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "getQidianGroupInfoReq");
        }
    }

    public void N2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "getQidianMasterDetailReq uin: " + j3);
        }
        mobileqq_qidian$ReqBody R2 = R2(String.valueOf(j3), 1009, "");
        mobileqq_qidian$GetCorpUinDetailInfoReqBody mobileqq_qidian_getcorpuindetailinforeqbody = new mobileqq_qidian$GetCorpUinDetailInfoReqBody();
        mobileqq_qidian_getcorpuindetailinforeqbody.uint64_uin.set(j3);
        mobileqq_qidian_getcorpuindetailinforeqbody.uint32_req_type.set(0);
        R2.msg_get_corpuin_detail_info_req_body.set(mobileqq_qidian_getcorpuindetailinforeqbody);
        R2.msg_get_corpuin_detail_info_req_body.setHasFlag(true);
        HashMap hashMap = new HashMap(1);
        hashMap.put("uin", String.valueOf(j3));
        hashMap.put(AppConstants.Key.SHARE_REQ_TYPE, String.valueOf(0));
        z3(R2, "QidianSsoProto.fetchCorpDetailInfo", hashMap);
    }

    public void O2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "getQidianMasterSimpleInfo uin: " + j3);
        }
        mobileqq_qidian$ReqBody R2 = R2(String.valueOf(j3), 1009, "");
        mobileqq_qidian$GetCorpUinDetailInfoReqBody mobileqq_qidian_getcorpuindetailinforeqbody = new mobileqq_qidian$GetCorpUinDetailInfoReqBody();
        mobileqq_qidian_getcorpuindetailinforeqbody.uint64_uin.set(j3);
        mobileqq_qidian_getcorpuindetailinforeqbody.uint32_req_type.set(2);
        R2.msg_get_corpuin_detail_info_req_body.set(mobileqq_qidian_getcorpuindetailinforeqbody);
        R2.msg_get_corpuin_detail_info_req_body.setHasFlag(true);
        HashMap hashMap = new HashMap(1);
        hashMap.put("uin", String.valueOf(j3));
        hashMap.put(AppConstants.Key.SHARE_REQ_TYPE, String.valueOf(2));
        z3(R2, "QidianSsoProto.fetchCorpDetailInfo", hashMap);
    }

    public void P2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
            return;
        }
        mobileqq_qidian$ReqBody R2 = R2("", 4, String.valueOf(j3));
        mobileqq_qidian$GetUserDetailInfoReqBody mobileqq_qidian_getuserdetailinforeqbody = new mobileqq_qidian$GetUserDetailInfoReqBody();
        mobileqq_qidian_getuserdetailinforeqbody.uint32_req_type.set(3);
        mobileqq_qidian_getuserdetailinforeqbody.uint32_mobile_client.set(1);
        mobileqq_qidian_getuserdetailinforeqbody.uint64_uin.set(j3);
        R2.msg_get_user_detail_info_req.set(mobileqq_qidian_getuserdetailinforeqbody);
        R2.msg_get_user_detail_info_req.setHasFlag(true);
        HashMap hashMap = new HashMap(1);
        hashMap.put("uin", String.valueOf(j3));
        hashMap.put(AppConstants.Key.SHARE_REQ_TYPE, String.valueOf(3));
        z3(R2, "QidianSsoProto.getUserDetailInfo", hashMap);
    }

    public void Q2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
            return;
        }
        mobileqq_qidian$ReqBody R2 = R2("", 4, String.valueOf(j3));
        R2.msg_crm_common_head.uint32_ver_no.set(1);
        mobileqq_qidian$GetUserDetailInfoReqBody mobileqq_qidian_getuserdetailinforeqbody = new mobileqq_qidian$GetUserDetailInfoReqBody();
        mobileqq_qidian_getuserdetailinforeqbody.uint32_req_type.set(2);
        mobileqq_qidian_getuserdetailinforeqbody.uint32_mobile_client.set(1);
        mobileqq_qidian_getuserdetailinforeqbody.uint64_uin.set(j3);
        R2.msg_get_user_detail_info_req.set(mobileqq_qidian_getuserdetailinforeqbody);
        R2.msg_get_user_detail_info_req.setHasFlag(true);
        HashMap hashMap = new HashMap(1);
        hashMap.put("uin", String.valueOf(j3));
        hashMap.put(AppConstants.Key.SHARE_REQ_TYPE, String.valueOf(2));
        z3(R2, "QidianSsoProto.getUserDetailInfo", hashMap);
    }

    public void S2(String str, String str2, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, str, str2, hashMap);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                mobileqq_qidian$ReqBody mobileqq_qidian_reqbody = new mobileqq_qidian$ReqBody();
                mobileqq_qidian_reqbody.msg_crm_common_head.set(J2("", 2, str));
                mobileqq_qidian_reqbody.uint32_sub_cmd.set(2);
                mobileqq_qidian$WpaSigtToSigMsgReqBody mobileqq_qidian_wpasigttosigmsgreqbody = new mobileqq_qidian$WpaSigtToSigMsgReqBody();
                byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str2);
                if (hexStr2Bytes != null && hexStr2Bytes.length > 0) {
                    mobileqq_qidian_wpasigttosigmsgreqbody.bytes_sigT_ext.set(ByteStringMicro.copyFrom(hexStr2Bytes));
                }
                mobileqq_qidian_wpasigttosigmsgreqbody.uint64_kfext_uin.set(Long.parseLong(str));
                mobileqq_qidian_reqbody.msg_wpa_sigt_to_sigmsg_req.set(mobileqq_qidian_wpasigttosigmsgreqbody);
                if (hashMap != null) {
                    z3(mobileqq_qidian_reqbody, "QidianSsoProto.WpaGenSigMsg", hashMap);
                } else {
                    z3(mobileqq_qidian_reqbody, "QidianSsoProto.WpaGenSigMsg", null);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "getSigmsgBySigt ", e16);
                }
            }
        }
    }

    public void U2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ranKey", toServiceMsg.extraData.get("ranKey"));
        try {
            r3(toServiceMsg, fromServiceMsg, obj, "qidian_wpa_assign");
            if (fromServiceMsg.isSuccess() && obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                if (mobileqq_qidian_rspbody.msg_wpa_assign_kfext_rsp.has()) {
                    if (mobileqq_qidian_rspbody.msg_wpa_assign_kfext_rsp.int32_result.get() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        String valueOf = String.valueOf(mobileqq_qidian_rspbody.msg_wpa_assign_kfext_rsp.uint64_ext_uin.get());
                        String bytes2HexStr = HexUtil.bytes2HexStr(mobileqq_qidian_rspbody.msg_wpa_assign_kfext_rsp.bytes_sigT_ext.get().toByteArray());
                        int i3 = mobileqq_qidian_rspbody.msg_wpa_assign_kfext_rsp.uint32_aio_type.get();
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf);
                        if (mobileqq_qidian_rspbody.msg_wpa_assign_kfext_rsp.bytes_sigmsg.has() && valueOf != null) {
                            this.f342837d.getMsgCache().h(valueOf, mobileqq_qidian_rspbody.msg_wpa_assign_kfext_rsp.bytes_sigmsg.get().toByteArray());
                            p3(uidFromUin, mobileqq_qidian_rspbody.msg_wpa_assign_kfext_rsp.bytes_sigmsg.get().toByteArray());
                        }
                        hashMap.put("key_ext_uin", valueOf);
                        hashMap.put("key_sigt", bytes2HexStr);
                        hashMap.put("key_aio_type", Integer.valueOf(i3));
                        hashMap.put("key_return_root", toServiceMsg.extraData.get("key_return_root"));
                        notifyUI(1004, true, hashMap);
                        return;
                    }
                    notifyUI(1004, false, hashMap);
                    return;
                }
                notifyUI(1004, false, hashMap);
                return;
            }
            notifyUI(1004, false, hashMap);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "handleAssignExt ", e16);
            }
            notifyUI(1004, false, hashMap);
        }
    }

    public void W2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean r36 = r3(toServiceMsg, fromServiceMsg, obj, "QidianSsoProto.clickReplyCmd");
        if (r36) {
            mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
            try {
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                if (mobileqq_qidian_rspbody.msg_click_reply_cmd_action_rsp.has()) {
                    int i3 = mobileqq_qidian_rspbody.msg_click_reply_cmd_action_rsp.msg_ret.uint32_ret_code.get();
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleClickReplyCmd errorCode: " + i3);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", Integer.valueOf(i3));
                    hashMap.put("master_uin", toServiceMsg.extraData.get("master_uin"));
                    super.notifyUI(1008, r36, hashMap);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleClickReplyCmd no msg_click_reply_cmd_action_rsp");
                }
                super.notifyUI(1008, r36, null);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleClickReplyCmd exception: " + e16.getMessage());
                }
                super.notifyUI(1008, r36, null);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "handleClickReplyCmd isSuccess: " + r36);
        }
        super.notifyUI(1008, r36, null);
    }

    public void X2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
        try {
            mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
            if (mobileqq_qidian_rspbody.msg_close_session_rsp.has() && mobileqq_qidian_rspbody.msg_close_session_rsp.msg_ret.has()) {
                int i3 = mobileqq_qidian_rspbody.msg_close_session_rsp.msg_ret.uint32_ret_code.get();
                if (i3 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleCloseAIOSessionReport errorCode: " + i3);
                    }
                } else {
                    String str = mobileqq_qidian_rspbody.msg_close_session_rsp.msg_ret.str_error_msg.get();
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleCloseAIOSessionReport errorCode: " + i3 + " , errorMsg: " + str);
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "handleCloseAIOSessionReport no response");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "handleCloseAIOSessionReport exception: " + e16.getMessage());
            }
        }
    }

    public void Z2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
        try {
            mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
            if (mobileqq_qidian_rspbody.msg_click_eman_rsp.has() && mobileqq_qidian_rspbody.msg_click_eman_rsp.msg_ret.has()) {
                int i3 = mobileqq_qidian_rspbody.msg_click_eman_rsp.msg_ret.uint32_ret_code.get();
                if (i3 == 0 && mobileqq_qidian_rspbody.msg_click_eman_rsp.str_msg.has()) {
                    AbsStructMsg g16 = i.g(mobileqq_qidian_rspbody.msg_click_eman_rsp.str_msg.get().getBytes(), 0);
                    if (g16 != null) {
                        BaseActivity baseActivity = BaseActivity.sTopActivity;
                        if ((baseActivity instanceof SplashActivity) || (baseActivity instanceof ChatActivity)) {
                            if (baseActivity.getChatFragment() == null) {
                            } else {
                                ChatActivityFacade.U0(this.f342837d, baseActivity.getChatFragment().C.f25589n, g16);
                            }
                        }
                    }
                } else {
                    String str = mobileqq_qidian_rspbody.msg_click_eman_rsp.msg_ret.str_error_msg.get();
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleEmanClickReport errorCode: " + i3 + " , errorMsg: " + str);
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "handleEmanClickReport no response");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "handleEmanClickReport exception: " + e16.getMessage());
            }
        }
    }

    public void a3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean r36 = r3(toServiceMsg, fromServiceMsg, obj, "QidianSsoProto.getCustomerTransferInfo");
        String string = toServiceMsg.extraData.getString("kfext");
        if (r36) {
            mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
            try {
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                if (mobileqq_qidian_rspbody.msg_get_customer_transfer_info_rsp.has()) {
                    mobileqq_qidian$GetCustomerTransferInfoRspBody mobileqq_qidian_getcustomertransferinforspbody = mobileqq_qidian_rspbody.msg_get_customer_transfer_info_rsp.get();
                    if (mobileqq_qidian_getcustomertransferinforspbody.msg_ret.uint32_ret_code.get() == 0) {
                        o3(string, mobileqq_qidian_getcustomertransferinforspbody.str_transfer_info.get(), mobileqq_qidian_getcustomertransferinforspbody.str_link_info.get(), mobileqq_qidian_getcustomertransferinforspbody.str_link_url.get(), mobileqq_qidian_getcustomertransferinforspbody.str_pt_url.get());
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleGetCustomerTransferInfo ", e16);
                }
            }
        }
    }

    public void b3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(f342836e, 2, "handleGetNavigationConfig");
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
            try {
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                if (mobileqq_qidian_rspbody.msg_get_navigation_menu_config_rsp_body.has()) {
                    mobileqq_qidian$GetNavigationMenuConfigRspBody mobileqq_qidian_getnavigationmenuconfigrspbody = mobileqq_qidian_rspbody.msg_get_navigation_menu_config_rsp_body.get();
                    if (mobileqq_qidian_getnavigationmenuconfigrspbody.msg_ret.uint32_ret_code.get() == 0) {
                        b bVar = new b();
                        bVar.f342844a = mobileqq_qidian_getnavigationmenuconfigrspbody.int32_is_show.get();
                        bVar.f342845b = mobileqq_qidian_getnavigationmenuconfigrspbody.uint32_ver_no.get();
                        bVar.f342846c = mobileqq_qidian_getnavigationmenuconfigrspbody.uint64_puin.get();
                        bVar.f342847d = mobileqq_qidian_getnavigationmenuconfigrspbody.uint64_kf_uin.get();
                        bVar.f342848e = mobileqq_qidian_getnavigationmenuconfigrspbody.uint32_is_show_graytip.get();
                        notifyUI(1006, true, bVar);
                    } else {
                        notifyUI(1006, false, null);
                        if (QLog.isColorLevel()) {
                            QLog.d(f342836e, 2, "handleGetNavigationConfig error return");
                        }
                    }
                } else {
                    notifyUI(1006, false, null);
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleGetNavigationConfig without body");
                    }
                }
                return;
            } catch (Exception e16) {
                notifyUI(1006, false, null);
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleGetNavigationConfig ", e16);
                    return;
                }
                return;
            }
        }
        notifyUI(1006, false, null);
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "handleGetNavigationConfig-false");
        }
    }

    public void c3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        QidianExternalInfo qidianExternalInfo;
        QidianExternalInfo qidianExternalInfo2;
        QidianProfileUiInfo qidianProfileUiInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean r36 = r3(toServiceMsg, fromServiceMsg, obj, "QidianSsoProto.fetchCorpDetailInfo");
        String string = toServiceMsg.extraData.getString("uin");
        if (r36) {
            mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
            try {
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                HashMap hashMap = new HashMap();
                if (mobileqq_qidian_rspbody.msg_get_corpuin_detail_info_rsp_body.has()) {
                    mobileqq_qidian$GetCorpUinDetailInfoRspBody mobileqq_qidian_getcorpuindetailinforspbody = mobileqq_qidian_rspbody.msg_get_corpuin_detail_info_rsp_body.get();
                    if (mobileqq_qidian_getcorpuindetailinforspbody.int32_ret.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        try {
                            i3 = Integer.parseInt(toServiceMsg.extraData.getString(AppConstants.Key.SHARE_REQ_TYPE));
                        } catch (Exception unused) {
                            i3 = 0;
                        }
                        if (mobileqq_qidian_getcorpuindetailinforspbody.msg_external_info.has()) {
                            qidianExternalInfo2 = new QidianExternalInfo();
                            mobileqq_qidian$ExternalInfo mobileqq_qidian_externalinfo = mobileqq_qidian_getcorpuindetailinforspbody.msg_external_info.get();
                            qidianExternalInfo2.from(mobileqq_qidian_externalinfo);
                            QidianManager qidianManager = (QidianManager) this.f342837d.getManager(QQManagerFactory.QIDIAN_MANAGER);
                            QidianExternalInfo q16 = qidianManager.q(string);
                            if (q16 != null) {
                                if (i3 == 2) {
                                    q16.isShowVideoCall = qidianExternalInfo2.isShowVideoCall;
                                } else if (i3 == 0) {
                                    if (!mobileqq_qidian_externalinfo.uint32_videoshow.has()) {
                                        qidianExternalInfo2.isShowVideoCall = q16.isShowVideoCall;
                                    }
                                    q16.update(qidianExternalInfo2);
                                }
                                hashMap.put("external", q16);
                            } else {
                                hashMap.put("external", qidianExternalInfo2);
                            }
                            String str = qidianExternalInfo2.uin;
                            if (!TextUtils.isEmpty(str)) {
                                qidianManager.j0(new BmqqAccountType(String.valueOf(str), 6));
                            }
                            string = str;
                            qidianExternalInfo = q16;
                        } else {
                            qidianExternalInfo = null;
                            qidianExternalInfo2 = null;
                        }
                        if (!TextUtils.isEmpty(string) && mobileqq_qidian_getcorpuindetailinforspbody.rpt_msg_config_group_info.has()) {
                            qidianProfileUiInfo = new QidianProfileUiInfo();
                            qidianProfileUiInfo.from(string, mobileqq_qidian_getcorpuindetailinforspbody);
                            hashMap.put("ConfigGroupInfo", qidianProfileUiInfo);
                        } else {
                            qidianProfileUiInfo = null;
                        }
                        if (qidianExternalInfo != null) {
                            x3(qidianExternalInfo, qidianProfileUiInfo);
                        } else {
                            x3(qidianExternalInfo2, qidianProfileUiInfo);
                        }
                        super.notifyUI(1009, true, hashMap);
                        return;
                    }
                    super.notifyUI(1009, false, null);
                    return;
                }
                super.notifyUI(1009, false, null);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleGetQidianMasterDetailInfo exception: " + e16.getMessage());
                }
                super.notifyUI(1009, false, null);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "handleGetQidianMasterDetailInfo isSuccess: " + r36);
        }
        super.notifyUI(1009, r36, null);
    }

    public void d3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean r36 = r3(toServiceMsg, fromServiceMsg, obj, "QidianSsoProto.getShieldStatus");
        if (r36) {
            mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
            try {
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                if (mobileqq_qidian_rspbody.msg_check_mpqq_refuse_flag_rsp.has()) {
                    mobileqq_qidian$CheckMpqqRefuseFlagRsp mobileqq_qidian_checkmpqqrefuseflagrsp = mobileqq_qidian_rspbody.msg_check_mpqq_refuse_flag_rsp.get();
                    boolean z17 = false;
                    if (mobileqq_qidian_checkmpqqrefuseflagrsp.int32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        HashMap hashMap = new HashMap();
                        if (mobileqq_qidian_checkmpqqrefuseflagrsp.uint32_is_refuse.get() == 1) {
                            z17 = true;
                        }
                        hashMap.put("result", Boolean.valueOf(z17));
                        super.notifyUI(1003, true, hashMap);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleGetShieldStatus uint32_ret_code: " + z16);
                    }
                    super.notifyUI(1003, r36, null);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleGetShieldStatus no msg_verify_wpa_uin_and_key_rsp");
                }
                super.notifyUI(1003, r36, null);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleGetShieldStatus exception: " + e16.getMessage());
                }
                super.notifyUI(1003, r36, null);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "handleGetShieldStatus isSuccess: " + r36);
        }
        super.notifyUI(1003, r36, null);
    }

    public void f3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        QidianExternalInfo qidianExternalInfo;
        QidianInternalInfo qidianInternalInfo;
        QidianCorpInfo qidianCorpInfo;
        QidianProfileUiInfo qidianProfileUiInfo;
        QidianCorpInfo qidianCorpInfo2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean r36 = r3(toServiceMsg, fromServiceMsg, obj, "QidianSsoProto.getUserDetailInfo");
        String string = toServiceMsg.extraData.getString("uin");
        if (r36) {
            mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
            try {
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                HashMap hashMap = new HashMap();
                if (mobileqq_qidian_rspbody.msg_subcmd_get_user_detail_info_rsp_body.has()) {
                    mobileqq_qidian$GetUserDetailInfoRspBody mobileqq_qidian_getuserdetailinforspbody = mobileqq_qidian_rspbody.msg_subcmd_get_user_detail_info_rsp_body.get();
                    if (mobileqq_qidian_getuserdetailinforspbody.msg_ret.uint32_ret_code.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        try {
                            i3 = Integer.parseInt(toServiceMsg.extraData.getString(AppConstants.Key.SHARE_REQ_TYPE));
                        } catch (Exception unused) {
                            i3 = 2;
                        }
                        if (mobileqq_qidian_getuserdetailinforspbody.msg_external_info.has()) {
                            QidianExternalInfo qidianExternalInfo2 = new QidianExternalInfo();
                            qidianExternalInfo2.from(mobileqq_qidian_getuserdetailinforspbody.msg_external_info.get());
                            hashMap.put("external", qidianExternalInfo2);
                            String str = qidianExternalInfo2.uin;
                            if (!TextUtils.isEmpty(str)) {
                                ((QidianManager) this.f342837d.getManager(QQManagerFactory.QIDIAN_MANAGER)).j0(new BmqqAccountType(String.valueOf(str), 1));
                            }
                            qidianExternalInfo = qidianExternalInfo2;
                            string = str;
                        } else {
                            qidianExternalInfo = null;
                        }
                        if (mobileqq_qidian_getuserdetailinforspbody.msg_internal_info.has()) {
                            qidianInternalInfo = new QidianInternalInfo();
                            qidianInternalInfo.from(mobileqq_qidian_getuserdetailinforspbody.msg_internal_info.get());
                            hashMap.put("internal", qidianInternalInfo);
                        } else {
                            qidianInternalInfo = null;
                        }
                        if (mobileqq_qidian_getuserdetailinforspbody.msg_corp_info.has()) {
                            qidianCorpInfo = new QidianCorpInfo();
                            qidianCorpInfo.from(mobileqq_qidian_getuserdetailinforspbody.msg_corp_info.get());
                            hashMap.put("corp", qidianCorpInfo);
                        } else {
                            qidianCorpInfo = null;
                        }
                        if (!TextUtils.isEmpty(string) && mobileqq_qidian_getuserdetailinforspbody.rpt_msg_config_group_info.has()) {
                            qidianProfileUiInfo = new QidianProfileUiInfo();
                            qidianProfileUiInfo.from(string, mobileqq_qidian_getuserdetailinforspbody);
                            hashMap.put("ConfigGroupInfo", qidianProfileUiInfo);
                        } else {
                            qidianProfileUiInfo = null;
                        }
                        if (i3 == 3) {
                            QidianManager qidianManager = (QidianManager) this.f342837d.getManager(QQManagerFactory.QIDIAN_MANAGER);
                            QidianExternalInfo q16 = qidianManager.q(string);
                            if (q16 != null) {
                                q16.update(qidianExternalInfo);
                            }
                            QidianInternalInfo r16 = qidianManager.r(string);
                            if (r16 != null) {
                                r16.update(qidianInternalInfo);
                            }
                            if (qidianCorpInfo != null && qidianExternalInfo != null) {
                                String str2 = qidianExternalInfo.masterUin;
                                qidianCorpInfo.corpUin = str2;
                                qidianCorpInfo2 = qidianManager.o(str2);
                            } else {
                                qidianCorpInfo2 = null;
                            }
                            if (qidianCorpInfo2 != null) {
                                qidianCorpInfo2.update(qidianCorpInfo);
                            }
                            QidianProfileUiInfo u16 = qidianManager.u(string);
                            if (q16 != null && r16 != null && qidianCorpInfo2 != null && u16 != null) {
                                hashMap.put("external", q16);
                                hashMap.put("internal", r16);
                                hashMap.put("corp", qidianCorpInfo2);
                                hashMap.put("ConfigGroupInfo", u16);
                                y3(qidianExternalInfo, qidianInternalInfo, qidianCorpInfo, qidianProfileUiInfo);
                                super.notifyUI(1001, true, hashMap);
                                return;
                            }
                            return;
                        }
                        y3(qidianExternalInfo, qidianInternalInfo, qidianCorpInfo, qidianProfileUiInfo);
                        super.notifyUI(1001, true, hashMap);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleGetUserDetailInfo uint32_ret_code: " + z16);
                    }
                    super.notifyUI(1001, r36, null);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleGetUserDetailInfo no msg_subcmd_get_user_detail_info_rsp_body");
                }
                super.notifyUI(1001, r36, null);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleGetUserDetailInfo exception: " + e16.getMessage());
                }
                super.notifyUI(1001, r36, null);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "handleGetUserDetailInfo isSuccess: " + r36);
        }
        super.notifyUI(1001, r36, null);
    }

    public void i3(SubMsgType0x92$MsgBody subMsgType0x92$MsgBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) subMsgType0x92$MsgBody);
            return;
        }
        int i3 = subMsgType0x92$MsgBody.uint32_sub_cmd.get();
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "handleQidianSCPushMsg, subcmd =  " + i3);
        }
        if (i3 == 100) {
            T2(subMsgType0x92$MsgBody);
        }
    }

    public void k3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            if (obj != null) {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                        if (mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                            byte[] byteArray = mergeFrom.bytes_bodybuffer.get().toByteArray();
                            byte b16 = byteArray[0];
                            if (b16 == 0) {
                                PkgTools.getShortData(byteArray, 1);
                                PkgTools.getShortData(byteArray, 3);
                                int shortData = PkgTools.getShortData(byteArray, 5);
                                byte[] bArr = new byte[shortData];
                                PkgTools.getBytesData(byteArray, 7, bArr, shortData);
                                String uTFString = PkgTools.getUTFString(bArr, 0, shortData);
                                int i3 = 7 + shortData;
                                PkgTools.getShortData(byteArray, i3);
                                int i16 = i3 + 2;
                                int shortData2 = PkgTools.getShortData(byteArray, i16);
                                byte[] bArr2 = new byte[shortData2];
                                PkgTools.getBytesData(byteArray, i16 + 2, bArr2, shortData2);
                                String uTFString2 = PkgTools.getUTFString(bArr2, 0, shortData2);
                                HashMap hashMap = new HashMap();
                                hashMap.put("plain_text", uTFString);
                                hashMap.put("cipher_text", uTFString2);
                                notifyUI(1019, true, hashMap);
                                return;
                            }
                            QLog.d(f342836e, 2, "handleQidianPrivateTroopUin result is " + ((int) b16));
                            notifyUI(1019, false, null);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleQidianPrivateTroopUin pkg is null");
                    }
                    notifyUI(1019, false, null);
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleQidianPrivateTroopUin throw exception is " + e16.toString());
                    }
                    notifyUI(1019, false, null);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "handleQidianPrivateTroopUin data is null");
            }
            notifyUI(1019, false, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "handleQidianPrivateTroopUin res is fail");
        }
        notifyUI(1019, false, null);
    }

    public void l3(Submsgtype0xe5$MsgBody submsgtype0xe5$MsgBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) submsgtype0xe5$MsgBody);
        } else if (submsgtype0xe5$MsgBody.uint32_sub_cmd.get() == 10) {
            com.tencent.mobileqq.app.message.c.c(this.f342837d, String.valueOf(submsgtype0xe5$MsgBody.msg_s2c_user_get_coupon_for_c_event_push.uint64_kfext.get()), submsgtype0xe5$MsgBody.msg_s2c_user_get_coupon_for_c_event_push.str_tips_content.get(), 0, false, false);
        }
    }

    public void m3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        try {
            if (fromServiceMsg.isSuccess() && obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                Oidb_0x7e7$RspBody oidb_0x7e7$RspBody = new Oidb_0x7e7$RspBody();
                oidb_0x7e7$RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                if (oidb_0x7e7$RspBody.ret_code.has()) {
                    oidb_0x7e7$RspBody.ret_code.get();
                }
                if (oidb_0x7e7$RspBody.ret_msg.has()) {
                    oidb_0x7e7$RspBody.ret_msg.get().toString();
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "handleReportWPA ", e16);
            }
        }
    }

    public void n3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean r36 = r3(toServiceMsg, fromServiceMsg, obj, "QidianSsoProto.verifyWpaAndKey");
        if (r36) {
            mobileqq_qidian$RspBody mobileqq_qidian_rspbody = new mobileqq_qidian$RspBody();
            try {
                mobileqq_qidian_rspbody.mergeFrom((byte[]) obj);
                if (mobileqq_qidian_rspbody.msg_verify_wpa_uin_and_key_rsp.has()) {
                    mobileqq_qidian$VerifyWpaUinAndKeyRsp mobileqq_qidian_verifywpauinandkeyrsp = mobileqq_qidian_rspbody.msg_verify_wpa_uin_and_key_rsp.get();
                    if (mobileqq_qidian_verifywpauinandkeyrsp.int32_result.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        HashMap hashMap = new HashMap();
                        String str = mobileqq_qidian_verifywpauinandkeyrsp.str_welcome_word.get();
                        int i3 = mobileqq_qidian_verifywpauinandkeyrsp.uint32_is_valid.get();
                        hashMap.put("welcome", str);
                        hashMap.put("result", Integer.valueOf(i3));
                        super.notifyUI(1002, r36, hashMap);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f342836e, 2, "handleVerifyWpaAndKey uint32_ret_code: " + z16);
                    }
                    super.notifyUI(1002, r36, null);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleVerifyWpaAndKey no msg_verify_wpa_uin_and_key_rsp");
                }
                super.notifyUI(1002, r36, null);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(f342836e, 2, "handleVerifyWpaAndKey exception: " + e16.getMessage());
                }
                super.notifyUI(1002, r36, null);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "handleVerifyWpaAndKey isSuccess: " + r36);
        }
        super.notifyUI(1002, r36, null);
    }

    public void o3(String str, String str2, String str3, String str4, String str5) {
        String str6;
        String stweb;
        String str7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, str2, str3, str4, str5);
            return;
        }
        if (!TextUtils.isEmpty(str5)) {
            TicketManager ticketManager = (TicketManager) this.f342837d.getManager(2);
            if (ticketManager == null) {
                stweb = null;
            } else {
                stweb = ticketManager.getStweb(this.f342837d.getCurrentAccountUin());
            }
            if (stweb != null && stweb.length() != 0) {
                str7 = String.format(str5, this.f342837d.getCurrentAccountUin(), stweb);
            } else {
                new QQToastNotifier(this.f342837d.getApp()).notifyUser(R.string.bui, this.f342837d.getApp().getResources().getDimensionPixelSize(R.dimen.title_bar_height), 0, 1);
                str7 = "";
            }
            str6 = str7;
        } else if (TextUtils.isEmpty(str4)) {
            str6 = "";
        } else {
            str6 = str4;
        }
        g gVar = new g(str, str, str2 + str3, 0, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 1245187, e.K0());
        Bundle bundle = new Bundle();
        bundle.putInt("key_action", 1);
        bundle.putString("key_action_DATA", str6);
        bundle.putString("key_a_action_DATA", str6);
        int lastIndexOf = (str2 + str3).lastIndexOf(str3);
        if (lastIndexOf >= 0) {
            gVar.b(lastIndexOf, str3.length() + lastIndexOf, bundle);
        }
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.hasRead = 0;
        messageForUniteGrayTip.initGrayTipMsg(this.f342837d, gVar);
        f.a(this.f342837d, messageForUniteGrayTip);
        SharedPreferences.Editor edit = this.f342837d.getApplication().getBaseContext().getSharedPreferences(this.f342837d.getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
        edit.putBoolean(this.f342837d.getCurrentAccountUin() + "_" + str, true);
        edit.commit();
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.qidian.controller.b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d(f342836e, 2, "onReceive cmd: " + serviceCmd);
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.WpaAssignKfext")) {
            U2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.clickReplyCmd")) {
            W2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.getUserDetailInfo")) {
            f3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.verifyWpaAndKey")) {
            n3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.getShieldStatus")) {
            d3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("OidbSvc.0x7e7_0")) {
            m3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.blockBulkMsg")) {
            V2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.getCustomerTransferInfo")) {
            a3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.getNavigationConfig")) {
            b3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.corpUinWpaReport")) {
            Y2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.emanClickReport")) {
            Z2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equals("QidianSsoProto.fetchCorpDetailInfo")) {
            c3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.closeAIOSessionReport")) {
            X2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.WpaGenSigMsg")) {
            e3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.webimAddFriend")) {
            g3(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("QidianSsoProto.getQidianGroupInfo")) {
            j3(toServiceMsg, fromServiceMsg, obj);
        } else if (serviceCmd.equalsIgnoreCase("OidbSvc.0x782")) {
            k3(toServiceMsg, fromServiceMsg, obj);
        } else if (serviceCmd.equalsIgnoreCase("trpc.b2b.wpa.Wpa.SsoGetUID")) {
            h3(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void q3(String str, String str2, String str3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            Oidb_0x7e7$ReqBody oidb_0x7e7$ReqBody = new Oidb_0x7e7$ReqBody();
            oidb_0x7e7$ReqBody.cmd_id.set(i3);
            oidb_0x7e7$ReqBody.platform.set(2);
            oidb_0x7e7$ReqBody.timestamp.set(System.currentTimeMillis() / 1000);
            oidb_0x7e7$ReqBody.env.set(i16);
            if (!TextUtils.isEmpty(str2) && TextUtils.isDigitsOnly(str2)) {
                oidb_0x7e7$ReqBody.user_uin.set(Long.parseLong(str2));
            }
            if (!TextUtils.isEmpty(str3) && TextUtils.isDigitsOnly(str3)) {
                oidb_0x7e7$ReqBody.corp_uin.set(Long.parseLong(str3));
            }
            if (!TextUtils.isEmpty(str)) {
                oidb_0x7e7$ReqBody.json_string.set(ByteStringMicro.copyFromUtf8(str));
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2023);
            oidb_sso_oidbssopkg.uint32_service_type.set(0);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x7e7$ReqBody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x7e7_0");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f342836e, 2, "qidianUnifiedReport " + e16.getMessage());
            }
        }
    }

    public void s3(String str, long j3) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Long.valueOf(j3));
            return;
        }
        e msgCache = this.f342837d.getMsgCache();
        byte[] k06 = msgCache.k0(str);
        byte[] l06 = msgCache.l0(str);
        if (k06 != null && l06 != null) {
            i16 = 3;
        } else if (k06 == null) {
            if (l06 != null) {
                i16 = 1;
            } else {
                i16 = 0;
            }
        }
        if (((QidianManager) this.f342837d.getManager(QQManagerFactory.QIDIAN_MANAGER)).L(str)) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        ReportController.o(this.f342837d, "dc00899", "Qidian", str, "0X8006DEC", "SigCheck", i3, 1, "", "" + i16, "" + j3, "" + NetworkUtil.getSystemNetwork(this.f342837d.getApp()));
    }

    public void t3(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        e msgCache = this.f342837d.getMsgCache();
        byte[] k06 = msgCache.k0(str);
        byte[] l06 = msgCache.l0(str);
        if (k06 == null || l06 == null) {
            if (k06 != null) {
                i16 = 2;
            } else if (l06 != null) {
                i16 = 1;
            } else {
                i16 = 0;
            }
        }
        if (((QidianManager) this.f342837d.getManager(QQManagerFactory.QIDIAN_MANAGER)).L(str)) {
            i17 = 4;
        }
        ReportController.o(this.f342837d, "dc00899", "Qidian", str, "0X8006DEC", "SigCheck", i17, 2, "" + i3, "" + i16, "" + j3, "" + NetworkUtil.getSystemNetwork(this.f342837d.getApp()));
    }

    public void u3(String str, int i3, int i16) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Oidb_0x7e7$ReqBody oidb_0x7e7$ReqBody = new Oidb_0x7e7$ReqBody();
        oidb_0x7e7$ReqBody.cmd_id.set(i3);
        oidb_0x7e7$ReqBody.platform.set(2);
        oidb_0x7e7$ReqBody.timestamp.set(System.currentTimeMillis() / 1000);
        oidb_0x7e7$ReqBody.env.set(i16);
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put(StartupReportKey.USER_UIN, this.f342837d.getCurrentAccountUin());
            oidb_0x7e7$ReqBody.json_string.set(ByteStringMicro.copyFromUtf8(jSONObject.toString()));
            if (jSONObject.has("kfuin")) {
                oidb_0x7e7$ReqBody.corp_uin.set(Long.valueOf(jSONObject.getString("kfuin")).longValue());
            }
            if (jSONObject.has("kfext")) {
                oidb_0x7e7$ReqBody.user_uin.set(Long.valueOf(jSONObject.getString("kfext")).longValue());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f342836e, 2, "reportWPA json error  ", e16);
            }
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2023);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x7e7$ReqBody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x7e7_0");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void v3(String str, String str2, String str3, String str4, String str5, String str6, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, str4, str5, str6, Integer.valueOf(i3));
            return;
        }
        mobileqq_qidian$ReqBody mobileqq_qidian_reqbody = new mobileqq_qidian$ReqBody();
        mobileqq_qidian_reqbody.msg_crm_common_head.set(J2(str, 1, ""));
        mobileqq_qidian_reqbody.msg_crm_common_head.setHasFlag(true);
        mobileqq_qidian$WpaAssignKfextReqBody mobileqq_qidian_wpaassignkfextreqbody = new mobileqq_qidian$WpaAssignKfextReqBody();
        mobileqq_qidian_wpaassignkfextreqbody.uint32_wpa_type.set(Integer.valueOf(str2).intValue());
        mobileqq_qidian_wpaassignkfextreqbody.uint32_wpa_type.setHasFlag(true);
        mobileqq_qidian_wpaassignkfextreqbody.bytes_sigT_kf.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str3)));
        mobileqq_qidian_wpaassignkfextreqbody.bytes_sigT_kf.setHasFlag(true);
        mobileqq_qidian_wpaassignkfextreqbody.uint64_assign_id.set(Long.valueOf(str4).longValue());
        mobileqq_qidian_wpaassignkfextreqbody.uint64_assign_id.setHasFlag(true);
        mobileqq_qidian_wpaassignkfextreqbody.uint64_customer_uin.set(Long.valueOf(this.f342837d.getCurrentAccountUin()).longValue());
        mobileqq_qidian_wpaassignkfextreqbody.uint64_customer_uin.setHasFlag(true);
        if (!TextUtils.isEmpty(str5)) {
            mobileqq_qidian_wpaassignkfextreqbody.str_rkey.set(str5);
            mobileqq_qidian_wpaassignkfextreqbody.str_rkey.setHasFlag(true);
        }
        mobileqq_qidian_reqbody.msg_wpa_assign_kfext_req.set(mobileqq_qidian_wpaassignkfextreqbody);
        mobileqq_qidian_reqbody.msg_wpa_assign_kfext_req.setHasFlag(true);
        ToServiceMsg createToServiceMsg = super.createToServiceMsg("QidianSsoProto.WpaAssignKfext");
        createToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
        createToServiceMsg.extraData.putString("key_return_root", str6);
        createToServiceMsg.extraData.putInt("ranKey", i3);
        createToServiceMsg.putWupBuffer(mobileqq_qidian_reqbody.toByteArray());
        super.sendPbReq(createToServiceMsg);
        ReportController.o(this.f342837d, "P_CliOper", "Qidian", "", "qidian_wpa_assign", "qidian_wpa_assign", 0, 0, "", "", AppConstants.NET_TYPE_NAME[NetworkUtil.getSystemNetwork(this.f342837d.getApp().getBaseContext())], "");
    }

    public void w3(String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) intent);
            return;
        }
        zq3.a aVar = new zq3.a();
        aVar.f453007a = Long.parseLong(str);
        ToServiceMsg createToServiceMsg = super.createToServiceMsg("trpc.b2b.wpa.Wpa.SsoGetUID");
        createToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
        createToServiceMsg.putWupBuffer(MessageNano.toByteArray(aVar));
        createToServiceMsg.extraData.putParcelable("intent", intent);
        super.sendPbReq(createToServiceMsg);
    }
}
