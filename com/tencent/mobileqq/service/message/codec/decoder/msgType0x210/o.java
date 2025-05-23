package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.TicketManager;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$AddQimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$MCardNotificationLike;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$QimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$VideoInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$VipInfoNotify;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o implements n {
    static IPatchRedirector $redirector_;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(MessageHandler messageHandler, SubMsgType0x6f$ForwardBody subMsgType0x6f$ForwardBody) {
        String str;
        int i3;
        long j3;
        SubMsgType0x6f$MCardNotificationLike subMsgType0x6f$MCardNotificationLike = subMsgType0x6f$ForwardBody.msg_mcard_notification_like.get();
        if (subMsgType0x6f$MCardNotificationLike.str_wording.has()) {
            str = subMsgType0x6f$MCardNotificationLike.str_wording.get();
        } else {
            str = "";
        }
        int i16 = 0;
        if (subMsgType0x6f$MCardNotificationLike.uint32_counter_new.has()) {
            i3 = subMsgType0x6f$MCardNotificationLike.uint32_counter_new.get();
        } else {
            i3 = 0;
        }
        if (subMsgType0x6f$MCardNotificationLike.uint64_from_uin.has()) {
            j3 = subMsgType0x6f$MCardNotificationLike.uint64_from_uin.get();
        } else {
            j3 = 0;
        }
        if (subMsgType0x6f$MCardNotificationLike.uint32_counter_total.has()) {
            i16 = subMsgType0x6f$MCardNotificationLike.uint32_counter_total.get();
        }
        if (QLog.isColorLevel()) {
            QLog.d("msg0x210.SubMsgType0x6f", 2, "card_notification_like : wording: " + str + " totalCount: " + i16 + " newCount: " + i3 + " fromUin: " + j3);
        }
        com.tencent.mobileqq.dating.d dVar = (com.tencent.mobileqq.dating.d) messageHandler.Q.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
        if (dVar != null) {
            dVar.b().f(subMsgType0x6f$MCardNotificationLike);
        }
    }

    private void b(MessageHandler messageHandler, SubMsgType0x6f$ForwardBody subMsgType0x6f$ForwardBody) {
        int i3;
        SubMsgType0x6f$QimFriendNotifyToQQ subMsgType0x6f$QimFriendNotifyToQQ = subMsgType0x6f$ForwardBody.msg_mod_qim_friend_to_qq.get();
        if (subMsgType0x6f$QimFriendNotifyToQQ.uint32_notify_type.has()) {
            i3 = subMsgType0x6f$QimFriendNotifyToQQ.uint32_notify_type.get();
        } else {
            i3 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIMNewNotifyPush_offLine", 2, "receive msg_add_notify_to_qq... " + i3);
        }
        if (i3 == 1) {
            if (subMsgType0x6f$QimFriendNotifyToQQ.msg_add_notify_to_qq.has()) {
                SubMsgType0x6f$AddQimFriendNotifyToQQ subMsgType0x6f$AddQimFriendNotifyToQQ = subMsgType0x6f$QimFriendNotifyToQQ.msg_add_notify_to_qq;
                QIMFollwerAdd qIMFollwerAdd = new QIMFollwerAdd();
                qIMFollwerAdd.uin = subMsgType0x6f$AddQimFriendNotifyToQQ.uint64_uin.get();
                qIMFollwerAdd.gender = subMsgType0x6f$AddQimFriendNotifyToQQ.uint32_gender.get();
                qIMFollwerAdd.careSCount = subMsgType0x6f$AddQimFriendNotifyToQQ.uint64_cares_count.get();
                qIMFollwerAdd.totalNum = subMsgType0x6f$AddQimFriendNotifyToQQ.uint64_storys_total_num.get();
                qIMFollwerAdd.smartRemark = subMsgType0x6f$AddQimFriendNotifyToQQ.bytes_smart_remark.get().toStringUtf8();
                qIMFollwerAdd.opType = subMsgType0x6f$AddQimFriendNotifyToQQ.uint32_op_type.get();
                qIMFollwerAdd.fansCount = subMsgType0x6f$AddQimFriendNotifyToQQ.uint64_fans_count.get();
                qIMFollwerAdd.longNick = RichStatus.parseStatus(subMsgType0x6f$AddQimFriendNotifyToQQ.bytes_longnick.get().toByteArray()).getPlainText();
                qIMFollwerAdd.upTime = com.tencent.mobileqq.service.message.e.K0();
                qIMFollwerAdd.source = subMsgType0x6f$AddQimFriendNotifyToQQ.bytes_src_wording.get().toStringUtf8();
                ((INewFriendService) messageHandler.Q.getRuntimeService(INewFriendService.class)).handleQIMNewFollower(qIMFollwerAdd);
                return;
            }
            return;
        }
        if (i3 != 2 && i3 == 3 && subMsgType0x6f$QimFriendNotifyToQQ.msg_add_not_login_frd_notify_to_qq.has()) {
            SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ = subMsgType0x6f$QimFriendNotifyToQQ.msg_add_not_login_frd_notify_to_qq.get();
            QIMNotifyAddFriend qIMNotifyAddFriend = new QIMNotifyAddFriend();
            qIMNotifyAddFriend.uin = subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.uint64_uin.get();
            qIMNotifyAddFriend.qqUin = subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.uint64_qq_uin.get();
            qIMNotifyAddFriend.nickName = subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.bytes_nick.get().toStringUtf8();
            qIMNotifyAddFriend.gender = subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.uint32_gender.get();
            qIMNotifyAddFriend.age = subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.uint32_age.get();
            qIMNotifyAddFriend.coverStory = subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.bytes_coverstory.get().toStringUtf8();
            qIMNotifyAddFriend.storyTotalNum = subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.uint64_storys_total_num.get();
            qIMNotifyAddFriend.wording = subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.bytes_wording.get().toStringUtf8();
            for (int i16 = 0; i16 < subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.rpt_msg_video_info.size(); i16++) {
                SubMsgType0x6f$VideoInfo subMsgType0x6f$VideoInfo = subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.rpt_msg_video_info.get(i16);
                QIMNotifyAddFriend.VideoInfo videoInfo = new QIMNotifyAddFriend.VideoInfo();
                videoInfo.coverUrl = subMsgType0x6f$VideoInfo.bytes_video_cover_url.get().toStringUtf8();
                videoInfo.videoVid = subMsgType0x6f$VideoInfo.bytes_vid.get().toStringUtf8();
                qIMNotifyAddFriend.videoInfos.add(videoInfo);
            }
            qIMNotifyAddFriend.pushTime = com.tencent.mobileqq.service.message.e.K0();
            if (QLog.isColorLevel()) {
                QLog.d("QIMNewNotifyPush_offLine", 2, "receive data= " + qIMNotifyAddFriend.toString());
            }
            ((QIMNewFriendManager) messageHandler.Q.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(qIMNotifyAddFriend);
        }
    }

    private void d(MessageHandler messageHandler, SubMsgType0x6f$ForwardBody subMsgType0x6f$ForwardBody) {
        long j3;
        int i3;
        SubMsgType0x6f$VipInfoNotify subMsgType0x6f$VipInfoNotify = subMsgType0x6f$ForwardBody.msg_vip_info_notify.get();
        if (QLog.isColorLevel()) {
            QLog.d("TurnBrandTipsDecoder", 2, "vip info notify: " + subMsgType0x6f$VipInfoNotify.toString());
        }
        if (subMsgType0x6f$VipInfoNotify.uint64_uin.has()) {
            j3 = subMsgType0x6f$VipInfoNotify.uint64_uin.get();
        } else {
            j3 = 0;
        }
        String l3 = Long.toString(j3);
        int i16 = 0;
        if (subMsgType0x6f$VipInfoNotify.uint32_vip_identify.has()) {
            i3 = subMsgType0x6f$VipInfoNotify.uint32_vip_identify.get();
        } else {
            i3 = 0;
        }
        if (subMsgType0x6f$VipInfoNotify.uint32_vip_level.has()) {
            i16 = subMsgType0x6f$VipInfoNotify.uint32_vip_level.get();
        }
        if (QLog.isColorLevel()) {
            QLog.d("TurnBrandTipsDecoder", 2, "UIN " + l3 + " vip info changed.");
        }
        if (i3 != 0 || i16 != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("TurnBrandTipsDecoder", 2, "need pull vip info from svr. vipIdentiy=" + i3 + "; vipLevel=" + i16);
            }
            ((VipInfoHandler) messageHandler.Q.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).sendGetBaseVipInfoReq(VasSkey.getSkey((TicketManager) messageHandler.Q.getManager(2), l3), l3);
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.n
    public void c(msg_comm$MsgType0x210 msg_comm_msgtype0x210, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar, MessageHandler messageHandler) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, msg_comm_msgtype0x210, msg_comm_msg, list, aVar, messageHandler);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush recv msg0x210.Submsgtype0x6f");
        }
        PBBytesField pBBytesField = msg_comm_msgtype0x210.msg_content;
        if (pBBytesField == null) {
            if (QLog.isColorLevel()) {
                QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content is null");
                return;
            }
            return;
        }
        byte[] byteArray = pBBytesField.get().toByteArray();
        if (byteArray == null) {
            if (QLog.isColorLevel()) {
                QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content.toByteArray is null");
                return;
            }
            return;
        }
        try {
            SubMsgType0x6f$MsgBody subMsgType0x6f$MsgBody = new SubMsgType0x6f$MsgBody();
            subMsgType0x6f$MsgBody.mergeFrom(byteArray);
            SubMsgType0x6f$ForwardBody subMsgType0x6f$ForwardBody = subMsgType0x6f$MsgBody.rpt_msg_mod_infos.get().get(0);
            if (subMsgType0x6f$ForwardBody.uint32_op_type.has()) {
                i3 = subMsgType0x6f$ForwardBody.uint32_op_type.get();
            } else {
                i3 = -1;
            }
            if (i3 == 2001 && subMsgType0x6f$ForwardBody.msg_mcard_notification_like.has()) {
                a(messageHandler, subMsgType0x6f$ForwardBody);
            } else if (i3 == 2002 && subMsgType0x6f$ForwardBody.msg_vip_info_notify.has()) {
                d(messageHandler, subMsgType0x6f$ForwardBody);
            } else if (i3 == 2011 && subMsgType0x6f$ForwardBody.msg_mod_qim_friend_to_qq.has()) {
                b(messageHandler, subMsgType0x6f$ForwardBody);
            }
            p.I(msg_comm_msg.msg_head.from_uin.get(), msg_comm_msg.msg_head.msg_seq.get(), msg_comm_msg.msg_head.msg_uid.get(), msg_comm_msg.msg_head.msg_type.get(), messageHandler.getApp());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TurnBrand", 2, "failed to get msg0x210.SubMsgType0x6f", e16);
            }
        }
    }
}
