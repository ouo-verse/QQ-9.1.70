package com.tencent.mobileqq.paiyipai;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.XmlElement;
import okhttp3.internal.ws.WebSocketProtocol;
import tencent.im.oidb.cmd0xed3.oidb_cmd0xed3$ReqBody;
import tencent.im.oidb.cmd0xf51.oidb_cmd0xf51$C2CMsgInfo;
import tencent.im.oidb.cmd0xf51.oidb_cmd0xf51$CommGrayTipsInfo;
import tencent.im.oidb.cmd0xf51.oidb_cmd0xf51$GroupMsgInfo;
import tencent.im.oidb.cmd0xf51.oidb_cmd0xf51$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes16.dex */
public class PaiYiPaiHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public QQAppInterface f257105d;

    protected PaiYiPaiHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f257105d = qQAppInterface;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    private void D2(MsgRecord msgRecord, long j3, oidb_cmd0xf51$ReqBody oidb_cmd0xf51_reqbody) {
        oidb_cmd0xf51$C2CMsgInfo oidb_cmd0xf51_c2cmsginfo = new oidb_cmd0xf51$C2CMsgInfo();
        try {
            oidb_cmd0xf51_c2cmsginfo.uint64_aio_uin.set(j3);
            long msgType = msgRecord.getMsgType() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long msgSeq = WebSocketProtocol.PAYLOAD_SHORT_MAX & msgRecord.getMsgSeq();
            QLog.d("PaiYiPaiHandler", 1, "buildRevokeFriendPaiYiPaiReq() called with: msgType = [" + msgType + "], msgSeq = [" + msgSeq + "], time = [" + msgRecord.getMsgTime() + "], msgUid = [" + msgRecord.getMsgId() + "]");
            oidb_cmd0xf51_c2cmsginfo.uint64_msg_type.set(msgType);
            oidb_cmd0xf51_c2cmsginfo.uint64_msg_seq.set(msgSeq);
            oidb_cmd0xf51_c2cmsginfo.uint64_msg_time.set(msgRecord.getMsgTime());
            oidb_cmd0xf51_c2cmsginfo.uint64_msg_uid.set(msgRecord.getMsgId());
        } catch (NumberFormatException e16) {
            QLog.e("PaiYiPaiHandler", 1, "C2CMsgInfo", e16);
        }
        oidb_cmd0xf51_reqbody.msg_c2c_msg_info.set(oidb_cmd0xf51_c2cmsginfo);
    }

    private oidb_cmd0xf51$ReqBody E2(MsgRecord msgRecord, Long l3) {
        MsgElement msgElement;
        GrayTipElement grayTipElement;
        XmlElement xmlElement;
        oidb_cmd0xf51$ReqBody oidb_cmd0xf51_reqbody = null;
        if (msgRecord.getElements().isEmpty() || (msgElement = msgRecord.getElements().get(0)) == null || (grayTipElement = msgElement.getGrayTipElement()) == null || (xmlElement = grayTipElement.getXmlElement()) == null) {
            return null;
        }
        if (xmlElement.getBusiType() == 12 && xmlElement.getBusiId() == 1061) {
            oidb_cmd0xf51_reqbody = new oidb_cmd0xf51$ReqBody();
            int chatType = msgRecord.getChatType();
            if (chatType != 1) {
                if (chatType == 2) {
                    F2(msgRecord, oidb_cmd0xf51_reqbody);
                }
            } else {
                D2(msgRecord, l3.longValue(), oidb_cmd0xf51_reqbody);
            }
            oidb_cmd0xf51$CommGrayTipsInfo oidb_cmd0xf51_commgraytipsinfo = new oidb_cmd0xf51$CommGrayTipsInfo();
            try {
                oidb_cmd0xf51_commgraytipsinfo.uint64_busi_id.set(xmlElement.getBusiId());
                oidb_cmd0xf51_commgraytipsinfo.uint64_tips_seq_id.set(xmlElement.getSeqId().longValue());
            } catch (Exception e16) {
                QLog.e("PaiYiPaiHandler", 1, "CommGrayTipsInfo", e16);
            }
            oidb_cmd0xf51_reqbody.msg_comm_gray_tips_info.set(oidb_cmd0xf51_commgraytipsinfo);
        }
        return oidb_cmd0xf51_reqbody;
    }

    private void F2(MsgRecord msgRecord, oidb_cmd0xf51$ReqBody oidb_cmd0xf51_reqbody) {
        oidb_cmd0xf51$GroupMsgInfo oidb_cmd0xf51_groupmsginfo = new oidb_cmd0xf51$GroupMsgInfo();
        try {
            oidb_cmd0xf51_groupmsginfo.uint64_group_code.set(msgRecord.getPeerUin());
            long msgType = msgRecord.getMsgType() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long msgSeq = WebSocketProtocol.PAYLOAD_SHORT_MAX & msgRecord.getMsgSeq();
            String valueOf = String.valueOf(msgRecord.getMsgId());
            QLog.d("PaiYiPaiHandler", 1, "buildRevokeTroopPaiYiPaiReq() called with: msgType = [" + msgType + "], msgSeq = [" + msgSeq + "], time = [" + msgRecord.getMsgTime() + "], msgId = [" + valueOf + "]");
            oidb_cmd0xf51_groupmsginfo.uint64_msg_type.set(msgType);
            oidb_cmd0xf51_groupmsginfo.uint64_msg_seq.set(msgSeq);
            oidb_cmd0xf51_groupmsginfo.uint64_msg_time.set(msgRecord.getMsgTime());
            oidb_cmd0xf51_groupmsginfo.uint64_msg_uid.set(msgRecord.getMsgId());
            oidb_cmd0xf51_groupmsginfo.uint64_msg_id.set(Long.parseLong(valueOf));
        } catch (NumberFormatException e16) {
            QLog.e("PaiYiPaiHandler", 1, "GroupMsgInfo", e16);
        }
        oidb_cmd0xf51_reqbody.msg_group_msg_info.set(oidb_cmd0xf51_groupmsginfo);
    }

    private boolean G2(String str) {
        String account = this.appRuntime.getAccount();
        boolean z16 = false;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_user_double_tap_timestamp_" + account, 0);
        long j3 = sharedPreferences.getLong(str, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = currentTimeMillis - j3;
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiHandler", 2, "canSendReq() called with: toUin = [" + str + "], lastDoubleTapTimestamp = [" + j3 + "], now = [" + currentTimeMillis + "], interval = [" + j16 + "]ms");
        }
        boolean z17 = true;
        if (j3 != 0) {
            if (j16 > 10000) {
                z16 = true;
            }
            z17 = z16;
        }
        if (z17) {
            sharedPreferences.edit().putLong(str, currentTimeMillis).apply();
        }
        return z17;
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int resultCode = fromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiHandler", 2, "onReceiveEd3() called with: resultCode = [" + resultCode + "], req = [" + toServiceMsg + "], res = [" + fromServiceMsg + "]");
        }
        if (fromServiceMsg.isSuccess()) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.d("PaiYiPaiHandler", 1, "onReceiveEd3()  e =", e16);
            }
            notifyUI(oidb_sso_oidbssopkg.uint32_result.get(), true, null);
        }
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int resultCode = fromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiHandler", 2, "onReceiveEd3() called with: resultCode = [" + resultCode + "], req = [" + toServiceMsg + "], res = [" + fromServiceMsg + "]");
        }
        if (fromServiceMsg.isSuccess()) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.d("PaiYiPaiHandler", 1, "onReceiveEd3()  e =", e16);
            }
            notifyUI(oidb_sso_oidbssopkg.uint32_result.get(), true, null);
            ((IntimateInfoHandler) this.f257105d.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER)).U2((String) toServiceMsg.getAttribute("toUin"));
        }
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int resultCode = fromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiHandler", 2, "onReceiveF51() called with: resultCode = [" + resultCode + "], req = [" + toServiceMsg + "], res = [" + fromServiceMsg + "]");
        }
        if (fromServiceMsg.isSuccess()) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.d("PaiYiPaiHandler", 1, "onReceiveF51()  e =", e16);
            }
            int i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (i3 == 0) {
                notifyUI(i3, true, null);
                return;
            } else {
                notifyUI(AppConstants.VALUE.UIN_TYPE_OFFICE_OPEN, false, Integer.valueOf(i3));
                return;
            }
        }
        QLog.e("PaiYiPaiHandler", 1, "onReceiveF51() error, result Code = [" + fromServiceMsg.getResultCode() + "]");
        notifyUI(AppConstants.VALUE.UIN_TYPE_OFFICE_OPEN, false, 0);
    }

    public void K2(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3));
        } else {
            L2(str, str2, i3, 0);
        }
    }

    public void L2(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!G2(String.valueOf(str))) {
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f173112s_, 0).show();
            return;
        }
        oidb_cmd0xed3$ReqBody oidb_cmd0xed3_reqbody = new oidb_cmd0xed3$ReqBody();
        try {
            oidb_cmd0xed3_reqbody.uint64_to_uin.set(Long.parseLong(str));
            oidb_cmd0xed3_reqbody.uint32_nudge_type.set(0);
            if (i3 == 1) {
                oidb_cmd0xed3_reqbody.uint64_aio_uin.set(Long.parseLong(str2));
            } else if (i3 == 2) {
                oidb_cmd0xed3_reqbody.uint64_group_code.set(Long.parseLong(str2));
            } else {
                return;
            }
            sendPbReq(makeOIDBPkg("OidbSvc.0xed3", 3795, 1, oidb_cmd0xed3_reqbody.toByteArray()));
            if (QLog.isColorLevel()) {
                QLog.d("PaiYiPaiHandler", 2, "sendDoubleClickReq() called with: toUin = [" + str + "], friendUin = [" + str2 + "], uinType = [" + i3 + "]], where = [" + i16 + "]");
            }
        } catch (Exception e16) {
            QLog.e("PaiYiPaiHandler", 1, "sendDoubleClickReq ", e16);
        }
    }

    public void M2(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!G2(str)) {
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f173112s_, 0).show();
            return;
        }
        oidb_cmd0xed3$ReqBody oidb_cmd0xed3_reqbody = new oidb_cmd0xed3$ReqBody();
        oidb_cmd0xed3_reqbody.uint64_to_uin.set(Long.valueOf(str).longValue());
        oidb_cmd0xed3_reqbody.uint32_nudge_type.set(i16);
        if (i3 == 0) {
            oidb_cmd0xed3_reqbody.uint64_aio_uin.set(Long.valueOf(str2).longValue());
        } else if (i3 == 1) {
            oidb_cmd0xed3_reqbody.uint64_group_code.set(Long.valueOf(str2).longValue());
        } else {
            return;
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xed3", 3795, 1, oidb_cmd0xed3_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("toUin", str);
        makeOIDBPkg.addAttribute("source", "IntimateElegantCardView");
        sendPbReq(makeOIDBPkg);
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiHandler", 2, "sendDoubleClickReq() called with: toUin = [" + str + "], friendUin = [" + str2 + "], uinType = [" + i3 + "]");
        }
    }

    public void N2(MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgRecord);
            return;
        }
        long senderUin = msgRecord.getSenderUin();
        long peerUin = msgRecord.getPeerUin();
        K2(Long.toString(senderUin), Long.toString(peerUin), msgRecord.getChatType());
    }

    public void O2(MsgRecord msgRecord, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, msgRecord, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("revokePaiYiPai", 2, "sendRevokePaiYiPaiNT, timeout: " + j16);
        }
        oidb_cmd0xf51$ReqBody E2 = E2(msgRecord, Long.valueOf(j3));
        if (E2 == null) {
            QLog.e("revokePaiYiPai", 1, "sendRevokePaiYiPaiReq error, reqBody is null");
            return;
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xf51", 3921, 1, E2.toByteArray());
        if (makeOIDBPkg == null) {
            return;
        }
        makeOIDBPkg.setTimeout(j16);
        sendPbReq(makeOIDBPkg);
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiHandler", 2, "sendRevokePaiYiPaiReq() called with: mr = [" + msgRecord + "], timeout = [" + j16 + "]");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg == null) {
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("OidbSvc.0xed3".equals(serviceCmd)) {
            if (((String) toServiceMsg.getAttribute("source", "")).equals("IntimateElegantCardView")) {
                I2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                H2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
        }
        if ("OidbSvc.0xf51".equals(serviceCmd)) {
            J2(toServiceMsg, fromServiceMsg, obj);
        }
    }

    protected PaiYiPaiHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
    }
}
