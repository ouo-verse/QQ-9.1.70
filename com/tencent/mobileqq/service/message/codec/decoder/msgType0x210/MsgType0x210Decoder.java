package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.af;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xb3;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ae;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.br;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.cd;
import com.tencent.luggage.wxa.gf.d0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList$MsgBody;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList$NowPushMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.nt.api.IRelationNTPushService;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.view.FilterEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgType0x210;
import org.jetbrains.annotations.Nullable;
import tencent.im.msgrevoke.msgrevoke_userdef$UinTypeUserDef;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a$MsgInfo;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a$ReqBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x155.SubMsgType0x155$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MsgType0x210Decoder implements com.tencent.mobileqq.service.message.codec.decoder.d<MessageHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.imcore.message.basic.c<Integer, n> f286184a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f286185b;

    public MsgType0x210Decoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f286184a = new com.tencent.imcore.message.basic.d();
        this.f286185b = ((IRelationNTPushService) QRoute.api(IRelationNTPushService.class)).getRelationNTPushSwitch();
        J();
    }

    private void A(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: AIO Feed offline messageRecord: 0xf4");
        }
    }

    private void B(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        af afVar = (af) messageHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_BUSINESSBASE);
        MsgInfo msgInfo = new MsgInfo();
        msgInfo.lFromUin = msg_comm_msg.msg_head.from_uin.get();
        msgInfo.shMsgSeq = (short) msg_comm_msg.msg_head.msg_seq.get();
        msgInfo.uMsgTime = msg_comm_msg.msg_head.msg_time.get();
        msgInfo.uRealMsgTime = msg_comm_msg.msg_head.msg_time.get();
        msgInfo.lMsgUid = msg_comm_msg.msg_head.msg_uid.get();
        msgInfo.shMsgType = (short) msg_comm_msg.msg_head.msg_type.get();
        p.I(msgInfo.lFromUin, msgInfo.shMsgSeq, msgInfo.lMsgUid, msgInfo.shMsgType, messageHandler.getApp());
    }

    private void C(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0xfb");
        }
        try {
            NowPushMsgList$MsgBody nowPushMsgList$MsgBody = new NowPushMsgList$MsgBody();
            nowPushMsgList$MsgBody.mergeFrom(msg_comm_msgtype0x210.msg_content.get().toByteArray());
            for (NowPushMsgList$NowPushMsg nowPushMsgList$NowPushMsg : nowPushMsgList$MsgBody.rpt_now_push_msg.get()) {
                QQAppInterface qQAppInterface = messageHandler.Q;
                if (qQAppInterface != null) {
                    ((rb2.a) qQAppInterface.getManager(QQManagerFactory.NOW_HONG_BAO_PUSH_MANAGER)).c(nowPushMsgList$NowPushMsg);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 0xfb " + nowPushMsgList$NowPushMsg.uint32_switch.get() + "  uint32_task_id " + nowPushMsgList$NowPushMsg.uint32_task_id.get() + "  uint32_type " + nowPushMsgList$NowPushMsg.uint32_type.get() + "  uint64_start_time " + nowPushMsgList$NowPushMsg.uint64_start_time.get() + "  uint64_end_time " + nowPushMsgList$NowPushMsg.uint64_end_time.get() + " app=" + messageHandler.Q);
                }
            }
            L(messageHandler, msg_comm_msg);
        } catch (Exception e16) {
            QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0xfb], errInfo->" + e16.getMessage());
        }
    }

    private void D(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        af afVar = (af) messageHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_BUSINESSBASE);
        MsgInfo msgInfo = new MsgInfo();
        msgInfo.lFromUin = msg_comm_msg.msg_head.from_uin.get();
        msgInfo.shMsgSeq = (short) msg_comm_msg.msg_head.msg_seq.get();
        msgInfo.uMsgTime = msg_comm_msg.msg_head.msg_time.get();
        msgInfo.uRealMsgTime = msg_comm_msg.msg_head.msg_time.get();
        msgInfo.lMsgUid = msg_comm_msg.msg_head.msg_uid.get();
        msgInfo.shMsgType = (short) msg_comm_msg.msg_head.msg_type.get();
        p.I(msgInfo.lFromUin, msgInfo.shMsgSeq, msgInfo.lMsgUid, msgInfo.shMsgType, messageHandler.getApp());
    }

    private void E(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xfe push message");
        }
        long j3 = msg_comm_msg.msg_head.from_uin.get();
        int i3 = msg_comm_msg.msg_head.msg_seq.get();
        long j16 = msg_comm_msg.msg_head.msg_uid.get();
        int i16 = msg_comm_msg.msg_head.msg_type.get();
        ((MsgBoxInterFollowManager) messageHandler.Q.getManager(QQManagerFactory.MSG_BOX_INTERACT_MANAGER)).decode0xfeInteractAndFollowMsg(msg_comm_msgtype0x210.msg_content.get().toByteArray());
        p.I(j3, i3, j16, i16, messageHandler.getApp());
    }

    private MessageRecord F(MessageHandler messageHandler, byte[] bArr, msg_comm$Msg msg_comm_msg) {
        SubMsgType0xcb$MsgBody subMsgType0xcb$MsgBody = new SubMsgType0xcb$MsgBody();
        try {
            subMsgType0xcb$MsgBody.mergeFrom(bArr);
            MessageForNearbyLiveTip messageForNearbyLiveTip = (MessageForNearbyLiveTip) q.d(MessageRecord.MSG_TYPE_NEARBY_LIVE_TIP);
            boolean z16 = true;
            if (subMsgType0xcb$MsgBody.uint32_anchor_status.get() != 1) {
                z16 = false;
            }
            messageForNearbyLiveTip.isLiving = z16;
            messageForNearbyLiveTip.jumpingUrl = subMsgType0xcb$MsgBody.bytes_jump_schema.get().toStringUtf8();
            messageForNearbyLiveTip.f203106msg = subMsgType0xcb$MsgBody.bytes_live_wording.get().toStringUtf8();
            messageForNearbyLiveTip.headUrl = subMsgType0xcb$MsgBody.bytes_anchor_head_url.get().toStringUtf8();
            messageForNearbyLiveTip.nickName = subMsgType0xcb$MsgBody.bytes_anchor_nickname.get().toStringUtf8();
            messageForNearbyLiveTip.liveEndWording = subMsgType0xcb$MsgBody.bytes_live_end_wording.get().toStringUtf8();
            messageForNearbyLiveTip.c2cMsgWording = subMsgType0xcb$MsgBody.bytes_c2c_msg_wording.get().toStringUtf8();
            messageForNearbyLiveTip.startLiveWordingType = subMsgType0xcb$MsgBody.uint32_live_wording_type.get();
            messageForNearbyLiveTip.endLiveWordingType = subMsgType0xcb$MsgBody.uint32_end_wording_type.get();
            long j3 = msg_comm_msg.msg_head.from_uin.get();
            int i3 = msg_comm_msg.msg_head.msg_seq.get();
            long j16 = msg_comm_msg.msg_head.msg_uid.get();
            int i16 = msg_comm_msg.msg_head.msg_type.get();
            messageForNearbyLiveTip.time = msg_comm_msg.msg_head.get().msg_time.get();
            messageForNearbyLiveTip.msgseq = msg_comm_msg.msg_head.get().msg_time.get();
            messageForNearbyLiveTip.shmsgseq = i3;
            messageForNearbyLiveTip.msgUid = j16;
            messageForNearbyLiveTip.selfuin = messageHandler.Q.getCurrentAccountUin();
            messageForNearbyLiveTip.istroop = 1001;
            long j17 = AppConstants.NOW_LIVE_TIP_UIN_BASE;
            messageForNearbyLiveTip.senderuin = String.valueOf(j3 + j17);
            messageForNearbyLiveTip.frienduin = String.valueOf(j17 + j3);
            messageForNearbyLiveTip.getBytes();
            p.I(j3, i3, j16, i16, messageHandler.getApp());
            if (QLog.isColorLevel()) {
                QLog.i("MsgType0x210Decoder", 2, "status=" + messageForNearbyLiveTip.isLiving + "jumpingUrl=" + messageForNearbyLiveTip.jumpingUrl + "liveWording=" + messageForNearbyLiveTip.f203106msg + "headUrl" + messageForNearbyLiveTip.headUrl + "nickName" + messageForNearbyLiveTip.nickName + "startLiveWordingType=" + subMsgType0xcb$MsgBody.uint32_live_wording_type.get() + "endLiveWordingType=" + subMsgType0xcb$MsgBody.uint32_end_wording_type.get());
            }
            ReportController.o(null, "dc00899", "grp_lbs", "", "msg_box", "view_live_message", 0, 0, "", "", "", "");
            return messageForNearbyLiveTip;
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("MsgType0x210Decoder", 2, "decodeNearbyLiveTipMsg decode failed" + e16.toString());
                return null;
            }
            return null;
        }
    }

    private void G(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, boolean z16, msg_comm$MsgType0x210 msg_comm_msgtype0x210, int i3) {
        switch (i3) {
            case 135:
                q(messageHandler, msg_comm_msgtype0x210);
                break;
            case 138:
            case 139:
                r(messageHandler, z16, msg_comm_msgtype0x210);
                return;
            case 141:
                break;
            case 155:
                s(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 179:
                t(messageHandler, msg_comm_msgtype0x210);
                return;
            case 197:
                u(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 199:
                if (!this.f286185b) {
                    v(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                    return;
                }
                return;
            case 203:
                w(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 215:
                x(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 238:
                z(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 249:
                B(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 253:
                D(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 254:
                E(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 258:
                e(messageHandler, msg_comm_msg);
                return;
            default:
                H(messageHandler, msg_comm_msg, msg_comm_msgtype0x210, i3);
                return;
        }
        L(messageHandler, msg_comm_msg);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    private void H(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210, int i3) {
        switch (i3) {
            case 220:
                y(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 244:
                A(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 251:
                C(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 256:
                d(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 264:
                f(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 273:
                g(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 278:
                if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "submsgtype0x116 decodeC2CMsgPkg_MsgType0x210 receive 0x116 push message");
                    return;
                }
                return;
            case FilterEnum.MIC_PTU_TRANS_KONGCHENG /* 281 */:
                h(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 286:
                i(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 287:
                j(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 290:
            case 291:
                k(messageHandler, msg_comm_msg, msg_comm_msgtype0x210, i3);
                return;
            case 297:
                l(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 307:
                m(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            case 341:
                n(messageHandler, msg_comm_msgtype0x210, 2);
            case d0.CTRL_INDEX /* 343 */:
                o(messageHandler, msg_comm_msgtype0x210);
            case ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID /* 350 */:
                p(messageHandler, msg_comm_msg, msg_comm_msgtype0x210);
                return;
            default:
                return;
        }
    }

    @Nullable
    static msg_comm$MsgType0x210 I(msg_comm$Msg msg_comm_msg) {
        msg_comm$MsgType0x210 msg_comm_msgtype0x210;
        try {
            msg_comm_msgtype0x210 = new msg_comm$MsgType0x210().mergeFrom(msg_comm_msg.msg_body.get().msg_content.get().toByteArray());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : failed.", e16);
            }
            msg_comm_msgtype0x210 = null;
        }
        if (msg_comm_msgtype0x210 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 is null.");
            }
            return null;
        }
        if (msg_comm_msgtype0x210.sub_msg_type.has() && msg_comm_msgtype0x210.msg_content.has()) {
            return msg_comm_msgtype0x210;
        }
        if (QLog.isColorLevel()) {
            QLog.e("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 require more info: hasType:" + msg_comm_msgtype0x210.sub_msg_type.has() + ",hasMsgContent:" + msg_comm_msgtype0x210.msg_content.has());
        }
        return null;
    }

    public static void K(QQAppInterface qQAppInterface, Submsgtype0x8a$ReqBody submsgtype0x8a$ReqBody, long j3, boolean z16) {
        long j16;
        int i3;
        String str;
        String str2;
        ISubAccountService iSubAccountService;
        boolean z17;
        ArrayList arrayList = (ArrayList) submsgtype0x8a$ReqBody.msg_info.get();
        msgrevoke_userdef$UinTypeUserDef msgrevoke_userdef_uintypeuserdef = new msgrevoke_userdef$UinTypeUserDef();
        try {
            msgrevoke_userdef_uintypeuserdef.mergeFrom(submsgtype0x8a$ReqBody.bytes_reserved.get().toByteArray());
            int i16 = msgrevoke_userdef_uintypeuserdef.uint32_from_uin_type.get();
            if (i16 == 1) {
                j16 = msgrevoke_userdef_uintypeuserdef.uint64_from_group_code.get();
                i3 = 1000;
            } else if (i16 == 2) {
                j16 = msgrevoke_userdef_uintypeuserdef.uint64_from_group_code.get();
                i3 = 1004;
            } else {
                j16 = 0;
                i3 = 0;
            }
            ArrayList<RevokeMsgInfo> arrayList2 = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Submsgtype0x8a$MsgInfo submsgtype0x8a$MsgInfo = (Submsgtype0x8a$MsgInfo) it.next();
                RevokeMsgInfo revokeMsgInfo = new RevokeMsgInfo();
                revokeMsgInfo.f281286d = i3;
                revokeMsgInfo.f281289h = String.valueOf(submsgtype0x8a$MsgInfo.uint64_from_uin.get());
                revokeMsgInfo.f281288f = String.valueOf(submsgtype0x8a$MsgInfo.uint64_to_uin.get());
                revokeMsgInfo.D = String.valueOf(j16);
                revokeMsgInfo.f281287e = (short) submsgtype0x8a$MsgInfo.uint32_msg_seq.get();
                revokeMsgInfo.f281291m = submsgtype0x8a$MsgInfo.uint64_msg_uid.get();
                revokeMsgInfo.C = submsgtype0x8a$MsgInfo.uint64_msg_time.get();
                revokeMsgInfo.E = submsgtype0x8a$MsgInfo.uint32_div_seq.get();
                revokeMsgInfo.F = submsgtype0x8a$MsgInfo.uint32_pkg_num.get();
                revokeMsgInfo.G = submsgtype0x8a$MsgInfo.uint32_pkg_index.get();
                if ((submsgtype0x8a$MsgInfo.uint32_flag.get() & 8) == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                revokeMsgInfo.K = z17;
                if (submsgtype0x8a$MsgInfo.msg_wording_info.has()) {
                    revokeMsgInfo.L = submsgtype0x8a$MsgInfo.msg_wording_info.int32_item_id.get();
                    revokeMsgInfo.M = submsgtype0x8a$MsgInfo.msg_wording_info.string_item_name.get();
                }
                arrayList2.add(revokeMsgInfo);
                if (QLog.isColorLevel()) {
                    QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg," + revokeMsgInfo.toString());
                }
            }
            if (!z16) {
                qQAppInterface.getMessageFacade().I1(arrayList2, false);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b subaccount msg");
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            String l3 = Long.toString(j3);
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            ISubAccountService iSubAccountService2 = (ISubAccountService) qQAppInterface.getRuntimeService(ISubAccountService.class, "");
            if (iSubAccountService2 == null) {
                return;
            }
            List<SubAccountMessage> allMessage = iSubAccountService2.getAllMessage(l3);
            Iterator<RevokeMsgInfo> it5 = arrayList2.iterator();
            RevokeMsgInfo revokeMsgInfo2 = null;
            SubAccountMessage subAccountMessage = null;
            String str3 = "";
            while (it5.hasNext()) {
                RevokeMsgInfo next = it5.next();
                Iterator<SubAccountMessage> it6 = allMessage.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        SubAccountMessage next2 = it6.next();
                        iSubAccountService = iSubAccountService2;
                        str = l3;
                        str2 = currentAccountUin;
                        if (next.f281287e == next2.shmsgseq && next.f281291m == next2.msgUid) {
                            str3 = next.M;
                            subAccountMessage = next2;
                            revokeMsgInfo2 = next;
                            break;
                        } else {
                            iSubAccountService2 = iSubAccountService;
                            l3 = str;
                            currentAccountUin = str2;
                        }
                    } else {
                        str = l3;
                        str2 = currentAccountUin;
                        iSubAccountService = iSubAccountService2;
                        break;
                    }
                }
                iSubAccountService2 = iSubAccountService;
                l3 = str;
                currentAccountUin = str2;
            }
            String str4 = l3;
            String str5 = currentAccountUin;
            ISubAccountService iSubAccountService3 = iSubAccountService2;
            if (revokeMsgInfo2 != null) {
                String qqStr = HardCodeUtil.qqStr(R.string.o3c);
                SubAccountMessage subAccountMessage2 = (SubAccountMessage) subAccountMessage.deepCopyByReflect();
                subAccountMessage2.f203118msg = qqStr.concat(BaseApplicationImpl.getApplication().getString(R.string.cdg));
                if (!TextUtils.isEmpty(str3)) {
                    subAccountMessage2.f203118msg = subAccountMessage2.f203118msg.concat("\uff0c" + str3);
                }
                subAccountMessage2.unreadNum = Math.max(0, subAccountMessage.unreadNum - 1);
                long j17 = revokeMsgInfo2.C;
                subAccountMessage2.time = j17;
                subAccountMessage2.needNotify = qQAppInterface.isBackgroundPause;
                subAccountMessage2.mTimeString = en.p(j17 * 1000, true, ((ISubAccountControlService) qQAppInterface.getRuntimeService(ISubAccountControlService.class, "")).getDateFormate());
                subAccountMessage2.mEmoRecentMsg = new QQText(subAccountMessage2.f203118msg, 0);
                if (submsgtype0x8a$ReqBody.traceless_flag.get()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("revokeMsg", 2, "traceless_flag true");
                    }
                    if (subAccountMessage2.hasUnreadMsg()) {
                        subAccountMessage2.f203118msg = "\u65b0\u6d88\u606f";
                        subAccountMessage2.mEmoRecentMsg = new QQText(subAccountMessage2.f203118msg, 0);
                        iSubAccountService3.addNewMessage(subAccountMessage2);
                    } else {
                        iSubAccountService3.removeMessage(subAccountMessage2.subUin, subAccountMessage2.senderuin);
                    }
                } else {
                    iSubAccountService3.addNewMessage(subAccountMessage2);
                }
                ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(qQAppInterface, str4, 6);
                MessageRecord convertToMessageRecord = subAccountMessage2.convertToMessageRecord();
                convertToMessageRecord.istroop = 7000;
                convertToMessageRecord.frienduin = str4;
                qQAppInterface.getConversationFacade().c0(convertToMessageRecord.frienduin, convertToMessageRecord.istroop, -1);
                ArrayList<MessageRecord> arrayList3 = new ArrayList<>();
                arrayList3.add(convertToMessageRecord);
                qQAppInterface.getMessageFacade().g(arrayList3, str5, false, false, true);
                if (qQAppInterface.isLogin()) {
                    ((IAppBadgeService) qQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
                }
                com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
                aVar.f291123c = str5;
                aVar.f291124d = str4;
                aVar.f291132l = true;
                aVar.f291133m = true;
                aVar.f291121a = 0;
                qQAppInterface.getMsgHandler().l3().l(8003, true, aVar);
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg, prase uintypeUserdef error");
            }
        }
    }

    private void L(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg) {
        p.I(msg_comm_msg.msg_head.from_uin.get(), msg_comm_msg.msg_head.msg_seq.get(), msg_comm_msg.msg_head.msg_uid.get(), msg_comm_msg.msg_head.msg_type.get(), messageHandler.getApp());
    }

    private void d(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x100");
        }
        QQAppInterface qQAppInterface = messageHandler.Q;
        if (qQAppInterface == null) {
            return;
        }
        messageHandler.Q.getMessageFacade().c(com.tencent.mobileqq.dating.b.a(qQAppInterface, msg_comm_msgtype0x210.msg_content.get().toByteArray(), msg_comm_msg), messageHandler.Q.getCurrentAccountUin());
        L(messageHandler, msg_comm_msg);
    }

    private void e(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210_0x102 offline ");
        }
        L(messageHandler, msg_comm_msg);
    }

    private void f(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgType0x210Decoder", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x108");
        }
        QQAppInterface qQAppInterface = messageHandler.Q;
        if (qQAppInterface == null) {
            return;
        }
        messageHandler.Q.getMessageFacade().c(com.tencent.mobileqq.dating.k.a(qQAppInterface, msg_comm_msgtype0x210.msg_content.get().toByteArray(), msg_comm_msg), messageHandler.Q.getCurrentAccountUin());
        L(messageHandler, msg_comm_msg);
    }

    private void g(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x111");
        }
        try {
            MayknowRecommendManager.f(messageHandler.Q, msg_comm_msgtype0x210.msg_content.get().toByteArray());
            L(messageHandler, msg_comm_msg);
        } catch (Exception e16) {
            QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0x111], errInfo->" + e16.getMessage());
        }
    }

    private void h(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        byte[] byteArray = msg_comm_msgtype0x210.msg_content.get().toByteArray();
        if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "troopFormLog offLinePush receive submsgtype0x119 decodeC2CMsgPkg_MsgType0x210 receive 0x119 push message");
        }
        try {
            SubMsgType0x119$MsgBody subMsgType0x119$MsgBody = new SubMsgType0x119$MsgBody();
            subMsgType0x119$MsgBody.mergeFrom(byteArray);
            if (!((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isPushMessageDuplicated(msg_comm_msg.msg_head.msg_seq.get())) {
                ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).insertTroopFormGrayTips(messageHandler.Q, subMsgType0x119$MsgBody);
                QLog.d("MsgType0x210Decoder", 1, "troopFormLog isPushMessageDuplicated ");
            }
            L(messageHandler, msg_comm_msg);
        } catch (Exception e16) {
            QLog.e("MsgType0x210Decoder", 1, "troopFormLog offLinePush receive submsgtype0x119 decodeC2CMsgPkg_MsgType0x210 receive 0x119 push message, errInfo->" + e16.getMessage());
        }
    }

    private void i(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x11e");
        }
        try {
            byte[] byteArray = msg_comm_msgtype0x210.msg_content.get().toByteArray();
            FriendListHandler friendListHandler = (FriendListHandler) messageHandler.Q.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            if (friendListHandler != null) {
                friendListHandler.decodePush0x210_0x11e(byteArray);
            }
            L(messageHandler, msg_comm_msg);
        } catch (Exception e16) {
            QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0x11e], errInfo->" + e16.getMessage());
        }
    }

    private void j(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked, info: 0x11f");
        }
        ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).decodePush0x210_0x11f(msg_comm_msgtype0x210.msg_content.get().toByteArray(), msg_comm_msg.msg_head.msg_seq.get(), msg_comm_msg.msg_head.msg_time.get(), true);
        L(messageHandler, msg_comm_msg);
    }

    private void k(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210, int i3) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "handleC2COfflinePushMsgGrayTip subType = " + i3);
        }
        byte[] byteArray = msg_comm_msgtype0x210.msg_content.get().toByteArray();
        MsgInfo msgInfo = new MsgInfo();
        msgInfo.lFromUin = msg_comm_msg.msg_head.from_uin.get();
        msgInfo.shMsgSeq = (short) msg_comm_msg.msg_head.msg_seq.get();
        msgInfo.uMsgTime = msg_comm_msg.msg_head.msg_time.get();
        msgInfo.uRealMsgTime = msg_comm_msg.msg_head.msg_time.get();
        msgInfo.lMsgUid = msg_comm_msg.msg_head.msg_uid.get();
        msgInfo.shMsgType = (short) msg_comm_msg.msg_head.msg_type.get();
        QQAppInterface qQAppInterface = messageHandler.Q;
        if (i3 == 290) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.graytip.i.f(qQAppInterface, byteArray, msgInfo, z16);
    }

    private void l(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x127 invoked, info: 0x127");
        }
        byte[] byteArray = msg_comm_msgtype0x210.msg_content.get().toByteArray();
        tr2.e w3 = ((tr2.b) messageHandler.Q.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).w(4);
        if (w3 != null) {
            w3.d(messageHandler.Q, byteArray, msg_comm_msg.msg_head.msg_seq.get(), msg_comm_msg.msg_head.msg_time.get(), true);
        }
        L(messageHandler, msg_comm_msg);
    }

    private void m(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgType0x210Decoder", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x133");
        }
        try {
            byte[] byteArray = msg_comm_msgtype0x210.msg_content.get().toByteArray();
            Face2FaceAddContactHandler face2FaceAddContactHandler = (Face2FaceAddContactHandler) messageHandler.Q.getBusinessHandler(BusinessHandlerFactory.FACE2FACE_ADD_FRIEND_HANDLER);
            if (face2FaceAddContactHandler != null) {
                face2FaceAddContactHandler.D2(byteArray);
            }
            L(messageHandler, msg_comm_msg);
        } catch (Exception e16) {
            QLog.e("MsgType0x210Decoder", 1, "[msg0x210.uSubMsgType == 0x133], errInfo->" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(MessageHandler messageHandler, msg_comm$MsgType0x210 msg_comm_msgtype0x210, int i3) {
        if (!t61.a.d()) {
            return;
        }
        byte[] byteArray = msg_comm_msgtype0x210.msg_content.get().toByteArray();
        if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "MsgType0x210Decoder 0x210_0x155 retryCount=" + i3);
        }
        SubMsgType0x155$MsgBody subMsgType0x155$MsgBody = new SubMsgType0x155$MsgBody();
        try {
            subMsgType0x155$MsgBody.mergeFrom(byteArray);
            String valueOf = String.valueOf(subMsgType0x155$MsgBody.from_uin.get());
            String valueOf2 = String.valueOf(subMsgType0x155$MsgBody.beat_type.get());
            String stringUtf8 = subMsgType0x155$MsgBody.fold_msg.grey_prompt.get().toStringUtf8();
            String stringUtf82 = subMsgType0x155$MsgBody.fold_msg.toast.get().toStringUtf8();
            long j3 = subMsgType0x155$MsgBody.msg_uid.get();
            long j16 = subMsgType0x155$MsgBody.msg_time.get();
            List<MessageRecord> v06 = messageHandler.Q.getMessageFacade().v0(valueOf, 0, j16, j3);
            if (v06 != null && !v06.isEmpty()) {
                MessageRecord messageRecord = v06.get(0);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "from_uin=", StringUtil.getSimpleUinForPrint(valueOf), ", msgUid=", String.valueOf(j3), ", beat_type=", valueOf2, ", greyPrompt=", stringUtf8, ", toast=", stringUtf82, ", msgTime=", String.valueOf(j16), ", msg=" + messageRecord.f203106msg);
                }
                messageRecord.saveExtInfoToExtStr("safety_msg_beat_type", valueOf2);
                messageRecord.saveExtInfoToExtStr("safety_msg_grey_prompt", stringUtf8);
                messageRecord.saveExtInfoToExtStr("safety_msg_click_toast", stringUtf82);
                messageHandler.Q.getMessageFacade().a1(valueOf, 0, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "from_uin=", StringUtil.getSimpleUinForPrint(valueOf), ", msgUid=", String.valueOf(j3), ", beat_type=", valueOf2, ", greyPrompt=", stringUtf8, ", toast=", stringUtf82, ", msgTime=", String.valueOf(j16));
            }
            QLog.e("Q.msg.BaseMessageProcessor", 1, "MsgType0x210Decoder receive 0x210_0x155 mrList is null or empty");
            if (i3 > 0) {
                try {
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(messageHandler, msg_comm_msgtype0x210, i3) { // from class: com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.MsgType0x210Decoder.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ MessageHandler f286186d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ msg_comm$MsgType0x210 f286187e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ int f286188f;

                        {
                            this.f286186d = messageHandler;
                            this.f286187e = msg_comm_msgtype0x210;
                            this.f286188f = i3;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, MsgType0x210Decoder.this, messageHandler, msg_comm_msgtype0x210, Integer.valueOf(i3));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                MsgType0x210Decoder.this.n(this.f286186d, this.f286187e, this.f286188f - 1);
                            } else {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                        }
                    }, 3000L);
                } catch (Exception e16) {
                    e = e16;
                    QLog.d("MsgType0x210Decoder", 1, "MsgType0x210Decoder receive 0x210_0x155 " + e);
                }
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void o(MessageHandler messageHandler, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        ae.d(messageHandler.Q, msg_comm_msgtype0x210);
    }

    private void p(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        com.tencent.mobileqq.qcirclepush.b.a(messageHandler.Q, msg_comm_msgtype0x210.msg_content.get().toByteArray(), false);
        L(messageHandler, msg_comm_msg);
    }

    private void q(MessageHandler messageHandler, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        try {
            SubMsgType0x87$MsgBody subMsgType0x87$MsgBody = new SubMsgType0x87$MsgBody();
            subMsgType0x87$MsgBody.mergeFrom(msg_comm_msgtype0x210.msg_content.get().toByteArray());
            if (subMsgType0x87$MsgBody.rpt_msg_msg_notify.has()) {
                com.tencent.mobileqq.activity.contact.newfriend.a.g(messageHandler.Q, subMsgType0x87$MsgBody);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgType0x210Decoder", 2, "offline push parse 0x210 subtype 0x87 msg error", e16);
            }
        }
    }

    private void r(MessageHandler messageHandler, boolean z16, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (z16) {
            return;
        }
        Submsgtype0x8a$ReqBody submsgtype0x8a$ReqBody = new Submsgtype0x8a$ReqBody();
        try {
            submsgtype0x8a$ReqBody.mergeFrom(msg_comm_msgtype0x210.msg_content.get().toByteArray());
            K(messageHandler.Q, submsgtype0x8a$ReqBody, 0L, false);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b offline msg, prase reqBody error");
            }
        }
    }

    private void s(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        try {
            new MessageMicro<SubMsgType0x9b$MsgBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b$MsgBody
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField bytes_ext_msg;
                public final PBBytesField bytes_workflow_id;
                public final PBUInt64Field uint64_app_id = PBField.initUInt64(0);
                public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
                public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);

                static {
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint64_app_id", "uint32_main_type", "uint32_sub_type", "bytes_ext_msg", "bytes_workflow_id"}, new Object[]{0L, 0, 0, byteStringMicro, byteStringMicro}, SubMsgType0x9b$MsgBody.class);
                }

                {
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    this.bytes_ext_msg = PBField.initBytes(byteStringMicro);
                    this.bytes_workflow_id = PBField.initBytes(byteStringMicro);
                }
            }.mergeFrom(msg_comm_msgtype0x210.msg_content.get().toByteArray());
            L(messageHandler, msg_comm_msg);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    private void t(MessageHandler messageHandler, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xb3 receive 0xaa push message");
        }
        String decodeC2CMsgPkgSubMsgType0xb3 = SubType0xb3.decodeC2CMsgPkgSubMsgType0xb3(messageHandler.Q, msg_comm_msgtype0x210.msg_content.get().toByteArray());
        if (!TextUtils.isEmpty(decodeC2CMsgPkgSubMsgType0xb3)) {
            boolean c16 = com.tencent.qqnt.contact.friends.b.f355778a.c(decodeC2CMsgPkgSubMsgType0xb3, "MsgType0x210Decoder");
            if (QLog.isColorLevel()) {
                QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xb3 isFriend=" + c16 + ", uin=" + decodeC2CMsgPkgSubMsgType0xb3);
            }
            if (!c16) {
                QLog.d("MsgType0x210Decoder", 1, "handleMsgType0x210SubMsgType0xb3 not friend, getDetail");
                ((FriendListHandler) messageHandler.Q.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendDetailInfo(decodeC2CMsgPkgSubMsgType0xb3);
            }
        }
    }

    private void u(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xc5 receive 0xc5 push message");
        }
        br.b((af) messageHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_BUSINESSBASE), msg_comm_msgtype0x210.msg_content.get().toByteArray(), msg_comm_msg.msg_head.msg_time.get());
        L(messageHandler, msg_comm_msg);
    }

    private void v(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7  push message");
        }
        long j3 = msg_comm_msg.msg_head.from_uin.get();
        int i3 = msg_comm_msg.msg_head.msg_seq.get();
        long j16 = msg_comm_msg.msg_head.msg_uid.get();
        int i16 = msg_comm_msg.msg_head.msg_type.get();
        ((af) messageHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_BUSINESSBASE)).Y(msg_comm_msgtype0x210.msg_content.get().toByteArray(), new PushMsg0x210C7Info(j3, i3, j16, i16, msg_comm_msg.msg_head.msg_time.get(), false), "MsgType0x210Decoder");
        p.I(j3, i3, j16, i16, messageHandler.getApp());
    }

    private void w(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_NEARBY_LIVE_TIP, 4, "decodeC2CMsgPkg_MsgType0x210 receive 0xcb push message");
        }
        MessageRecord F = F(messageHandler, msg_comm_msgtype0x210.msg_content.get().toByteArray(), msg_comm_msg);
        if (F != null && !MessageHandlerUtils.msgFilter(messageHandler.Q, F, true) && F.msgtype == -2053) {
            MessageForNearbyLiveTip messageForNearbyLiveTip = (MessageForNearbyLiveTip) F;
            if (MessageForNearbyLiveTip.isHuayangTip(messageForNearbyLiveTip.jumpingUrl) && !MessageForNearbyLiveTip.isSupportHuayangBusinessType(messageForNearbyLiveTip.jumpingUrl)) {
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.TAG_NEARBY_LIVE_TIP, 2, "decodeC2CMsgPkg_MsgType0x210 discard a not support huayang tips message, jumpUrl=" + messageForNearbyLiveTip.jumpingUrl);
                    return;
                }
                return;
            }
            if (messageForNearbyLiveTip.isLiving) {
                messageHandler.Q.getMessageFacade().c(F, messageHandler.Q.getCurrentAccountUin());
                return;
            }
            Message lastMessage = messageHandler.Q.getMessageFacade().getLastMessage(messageForNearbyLiveTip.frienduin, messageForNearbyLiveTip.istroop);
            if (lastMessage != null) {
                messageHandler.Q.getMessageFacade().Y0(messageForNearbyLiveTip.frienduin, messageForNearbyLiveTip.istroop, lastMessage.uniseq, messageForNearbyLiveTip.msgData);
                ArrayList arrayList = new ArrayList();
                arrayList.add(messageForNearbyLiveTip);
                messageHandler.Q.getMessageFacade().l0(arrayList);
                return;
            }
            messageHandler.Q.getMessageFacade().c(F, messageHandler.Q.getCurrentAccountUin());
        }
    }

    private void x(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xd7 push message");
        }
        long j3 = msg_comm_msg.msg_head.from_uin.get();
        int i3 = msg_comm_msg.msg_head.msg_seq.get();
        long j16 = msg_comm_msg.msg_head.msg_uid.get();
        int i16 = msg_comm_msg.msg_head.msg_type.get();
        ((MsgBoxInterFollowManager) messageHandler.Q.getManager(QQManagerFactory.MSG_BOX_INTERACT_MANAGER)).decode0xd7InteractAndFollowMsg(msg_comm_msgtype0x210.msg_content.get().toByteArray());
        p.I(j3, i3, j16, i16, messageHandler.getApp());
    }

    private void y(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.i("MsgType0x210Decoder", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xdc push message");
        }
        L(messageHandler, msg_comm_msg);
    }

    private void z(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgType0x210Decoder", 2, "handleMsgType0x210SubMsgType0xee receive 0xee push message");
        }
        cd.b(messageHandler.Q, msg_comm_msgtype0x210.msg_content.get().toByteArray(), msg_comm_msg.msg_head.msg_time.get());
        L(messageHandler, msg_comm_msg);
    }

    protected void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f286184a.a(61, m.class);
        this.f286184a.a(81, d.class);
        this.f286184a.a(102, f.class);
        this.f286184a.a(107, e.class);
        this.f286184a.a(111, o.class);
        this.f286184a.a(114, g.class);
        this.f286184a.a(118, c.class);
        this.f286184a.a(124, k.class);
        this.f286184a.a(314, j.class);
        this.f286184a.a(284, ed1.a.class);
        this.f286184a.a(Integer.valueOf(com.tencent.luggage.wxa.fe.a.CTRL_INDEX), l.class);
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, messageHandler, msg_comm_msg, list, aVar);
            return;
        }
        if (!aVar.f286157l && msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().msg_content.has()) {
            boolean z16 = aVar.f286157l;
            msg_comm$MsgType0x210 I = I(msg_comm_msg);
            if (I == null) {
                return;
            }
            int i3 = I.sub_msg_type.get();
            if (QLog.isColorLevel()) {
                QLog.d("MsgType0x210Decoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 type:" + i3);
            }
            n nVar = this.f286184a.get(Integer.valueOf(i3));
            if (nVar != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x210Decoder", 2, "subType=" + i3 + ", decoder=" + nVar);
                }
                nVar.c(I, msg_comm_msg, list, aVar, messageHandler);
            }
            G(messageHandler, msg_comm_msg, z16, I, i3);
        }
    }
}
