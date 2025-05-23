package com.tencent.biz.pubaccount.api.impl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.pubaccount.accountdetail.jce.GetRecvMsgStateReq;
import com.tencent.biz.pubaccount.accountdetail.jce.SetRecvMsgStateReq;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJNetworkUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.app.Servlet;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$GetPublicAccountDetailInfoRequest;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes32.dex */
public class PublicAccountServletImpl extends MSFServlet implements IPublicAccountServlet {
    public static final String CMD_KANDIAN_BIU_GUIDE = "KandianSvc_biu_guide.";
    public static final String CMD_PREFIX_PUBLIC = "PubAccountSvc.";
    public static final String CMD_PREFIX_PUBLIC_REPORT = "PubAccountAdSvc.";
    private static final String NAME_NEED_HANDLER = "need_handler";
    private String TAG = "com.tencent.biz.pubaccount.api.impl.PublicAccountServlet";

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountServlet
    public void configNeedHandler(Intent intent) {
        intent.putExtra(NAME_NEED_HANDLER, true);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountServlet
    public Class<? extends Servlet> getServletClass() {
        return getClass();
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "onReceive");
        }
        if (intent == null) {
            QLog.d(this.TAG, 1, "onReceive request == null");
            return;
        }
        byte[] responseBytesData = getResponseBytesData(fromServiceMsg);
        ((IRIJNetworkUtils) QRoute.api(IRIJNetworkUtils.class)).debugReceivePb(fromServiceMsg);
        Bundle bundle = new Bundle();
        bundle.putByteArray("data", responseBytesData);
        bundle.putInt(IPublicAccountServlet.RESPONES_CODE, fromServiceMsg.getBusinessFailCode());
        bundle.putInt("type", intent.getIntExtra("type", 0));
        if (intent.getBooleanExtra(NAME_NEED_HANDLER, false)) {
            PublicAccountHandlerImpl publicAccountHandlerImpl = (PublicAccountHandlerImpl) ((QQAppInterface) super.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
            if (publicAccountHandlerImpl != null) {
                publicAccountHandlerImpl.onReceive(intent, fromServiceMsg, responseBytesData);
            }
        } else {
            super.notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, null);
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "onReceive exit");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0245, code lost:
    
        if (((com.tencent.biz.pubaccount.util.api.IPublicAccountUtil) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.biz.pubaccount.util.api.IPublicAccountUtil.class)).getAccountType((com.tencent.mobileqq.app.QQAppInterface) super.getAppRuntime(), r5 + "") != (-4)) goto L80;
     */
    @Override // mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSend(Intent intent, Packet packet) {
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "onSend");
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("cmd");
        ((IRIJNetworkUtils) QRoute.api(IRIJNetworkUtils.class)).debugSendPb(byteArrayExtra, stringExtra);
        if (stringExtra.equals(IPublicAccountManager.SSO_COMMAND_GET_RECOMMEND_LIST)) {
            packet.setSSOCommand("PubAccBusiRecSvc." + stringExtra);
        } else if (stringExtra.equals(PublicAccountManagerImpl.SSO_COMMAND_POST_PUNCHCARD_INFO)) {
            packet.setSSOCommand("PubAccountSSOProxySvc." + stringExtra);
        } else if (!stringExtra.equals("PubAccountFollowSvc.follow") && !stringExtra.equals("PubAccountFollowSvc.subscribe")) {
            if (stringExtra.equals("PubAccountAdSvc.recent_list_report")) {
                packet.setSSOCommand(stringExtra);
            } else if (!stringExtra.equals(IThirdVideoManager.CMD_VIDEO_UUIDFORURL) && !stringExtra.equals(IThirdVideoManager.CMD_VIDEO_URLFORUUID) && !stringExtra.equals(IThirdVideoManager.CMD_VIDEO_SHOP_AD)) {
                if (stringExtra.equals(CMD_PREFIX_PUBLIC_REPORT)) {
                    packet.setSSOCommand("PubAccountAdSvc.ad_report");
                } else if (!stringExtra.equals(IPublicAccountConfigUtil.SSO_COMMOND_NET_CONNECT_INFO) && !stringExtra.equals(PublicAccountSearchRecommendManagerImpl.SSO_COMMAND_GET_RECOMMEND_PUBACCOUNT)) {
                    if (stringExtra.equals(IPublicAccountManager.SSO_COMMAND_GET_GUIDE_FRIENDS)) {
                        packet.setSSOCommand(CMD_KANDIAN_BIU_GUIDE + stringExtra);
                    } else if (stringExtra.equals(IPublicAccountManager.CMD_GET_RECVMSG_STATE)) {
                        try {
                            ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getName());
                            String serviceCmd = toServiceMsg.getServiceCmd();
                            GetRecvMsgStateReq getRecvMsgStateReq = (GetRecvMsgStateReq) toServiceMsg.getAttribute("GetRecvMsgStateReq");
                            packet.setServantName("QQMP.ConfigServer.ConfigObj");
                            packet.setFuncName("getRecvMsgState");
                            packet.addRequestPacket("req", getRecvMsgStateReq);
                            packet.setSSOCommand(serviceCmd);
                            packet.setTimeout(15000L);
                        } catch (Exception unused) {
                            if (QLog.isColorLevel()) {
                                QLog.i(this.TAG, 2, "onSend exception");
                            }
                        }
                    } else if (stringExtra.equals(IPublicAccountManager.CMD_SET_RECVMSG_STATE)) {
                        try {
                            ToServiceMsg toServiceMsg2 = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getName());
                            String serviceCmd2 = toServiceMsg2.getServiceCmd();
                            SetRecvMsgStateReq setRecvMsgStateReq = (SetRecvMsgStateReq) toServiceMsg2.getAttribute("SetRecvMsgStateReq");
                            packet.setServantName("QQMP.ConfigServer.ConfigObj");
                            packet.setFuncName("setRecvMsgState");
                            packet.addRequestPacket("req", setRecvMsgStateReq);
                            packet.setSSOCommand(serviceCmd2);
                            packet.setTimeout(15000L);
                        } catch (Exception unused2) {
                            if (QLog.isColorLevel()) {
                                QLog.i(this.TAG, 2, "onSend exception");
                            }
                        }
                    } else {
                        if (IPublicAccountManager.SSO_COMMAND_GET_FOLLOW_LIST_NEW.equals(stringExtra)) {
                            packet.setSSOCommand(stringExtra);
                            packet.setTimeout(30000L);
                            packet.autoResend = true;
                        } else if (IPublicAccountManager.SSO_COMMAND_GET_FOLLOW_LIST.equals(stringExtra)) {
                            packet.autoResend = true;
                            packet.setSSOCommand(CMD_PREFIX_PUBLIC + stringExtra);
                        } else if (!IPublicAccountManager.SSO_COMMAND_GET_ACCOUNT_MENU_NEW.equals(stringExtra) && !IPublicAccountManager.SSO_COMMAND_SEND_MENU_EVENT_NEW.equals(stringExtra)) {
                            packet.setSSOCommand(CMD_PREFIX_PUBLIC + stringExtra);
                        } else {
                            packet.setSSOCommand(stringExtra);
                        }
                        if (stringExtra.equals(IPublicAccountManager.SSO_COMMAND_GET_DETAIL_INFO)) {
                            mobileqq_mp$GetPublicAccountDetailInfoRequest mobileqq_mp_getpublicaccountdetailinforequest = new mobileqq_mp$GetPublicAccountDetailInfoRequest();
                            try {
                                mobileqq_mp_getpublicaccountdetailinforequest.mergeFrom(byteArrayExtra);
                            } catch (InvalidProtocolBufferMicroException e16) {
                                e16.printStackTrace();
                            }
                            oidb_cmd0xcf8$GetPublicAccountDetailInfoRequest oidb_cmd0xcf8_getpublicaccountdetailinforequest = new oidb_cmd0xcf8$GetPublicAccountDetailInfoRequest();
                            long j3 = mobileqq_mp_getpublicaccountdetailinforequest.uin.get();
                            if (j3 < 0) {
                                j3 = (-(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH - j3)) + TTL.MAX_VALUE + 1;
                            }
                            if (!intent.getBooleanExtra("useNewProtocol", false)) {
                                if (super.getAppRuntime() instanceof QQAppInterface) {
                                }
                            }
                            intent.putExtra("type", 1);
                            oidb_cmd0xcf8_getpublicaccountdetailinforequest.luin.set(j3);
                            oidb_cmd0xcf8_getpublicaccountdetailinforequest.seqno.set(mobileqq_mp_getpublicaccountdetailinforequest.seqno.get());
                            oidb_cmd0xcf8_getpublicaccountdetailinforequest.version.set(mobileqq_mp_getpublicaccountdetailinforequest.version.get());
                            oidb_cmd0xcf8_getpublicaccountdetailinforequest.versionInfo.set(mobileqq_mp_getpublicaccountdetailinforequest.versionInfo.get());
                            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                            oidb_sso_oidbssopkg.uint32_command.set(3320);
                            oidb_sso_oidbssopkg.uint32_result.set(0);
                            oidb_sso_oidbssopkg.uint32_service_type.set(1);
                            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xcf8_getpublicaccountdetailinforequest.toByteArray()));
                            byteArrayExtra = oidb_sso_oidbssopkg.toByteArray();
                            packet.setSSOCommand("OidbSvc.0xcf8");
                        }
                    }
                } else {
                    packet.setTimeout(15000L);
                    packet.setSSOCommand(stringExtra);
                }
            } else {
                packet.setTimeout(15000L);
                packet.setSSOCommand(stringExtra);
            }
        } else {
            packet.setTimeout(10000L);
            packet.setSSOCommand(stringExtra);
        }
        if (byteArrayExtra != null) {
            packet.putSendData(fh.b(byteArrayExtra));
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "onSend exit");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] getResponseBytesData(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null || !fromServiceMsg.isSuccess()) {
            return null;
        }
        return fh.a(fromServiceMsg.getWupBuffer());
    }
}
