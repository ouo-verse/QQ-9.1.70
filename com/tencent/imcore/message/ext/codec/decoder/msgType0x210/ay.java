package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$AddQimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$MCardNotificationLike;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$QimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$VideoInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$VipInfoNotify;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ay implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, MessageHandler messageHandler, MsgInfo msgInfo, MsgType0x210 msgType0x210) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        if (QLog.isColorLevel()) {
            QLog.d("msg0x210.SubMsgType0x6f", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
        }
        try {
            SubMsgType0x6f$MsgBody subMsgType0x6f$MsgBody = new SubMsgType0x6f$MsgBody();
            subMsgType0x6f$MsgBody.mergeFrom(msgType0x210.vProtobuf);
            for (int i27 = 0; i27 < subMsgType0x6f$MsgBody.rpt_msg_mod_infos.size(); i27++) {
                SubMsgType0x6f$ForwardBody subMsgType0x6f$ForwardBody = subMsgType0x6f$MsgBody.rpt_msg_mod_infos.get().get(i27);
                int i28 = -1;
                if (subMsgType0x6f$ForwardBody.uint32_op_type.has()) {
                    i3 = subMsgType0x6f$ForwardBody.uint32_op_type.get();
                } else {
                    i3 = -1;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("msg0x210.SubMsgType0x6f", 2, "get notice from handleC2COnlinePushMsg0x210Resp " + i3);
                }
                long j3 = 0;
                if (i3 == 2001 && subMsgType0x6f$ForwardBody.msg_mcard_notification_like.has()) {
                    SubMsgType0x6f$MCardNotificationLike subMsgType0x6f$MCardNotificationLike = subMsgType0x6f$ForwardBody.msg_mcard_notification_like.get();
                    String str = "";
                    if (subMsgType0x6f$MCardNotificationLike.str_wording.has()) {
                        str = subMsgType0x6f$MCardNotificationLike.str_wording.get();
                    }
                    if (subMsgType0x6f$MCardNotificationLike.uint32_counter_new.has()) {
                        i19 = subMsgType0x6f$MCardNotificationLike.uint32_counter_new.get();
                    } else {
                        i19 = 0;
                    }
                    if (subMsgType0x6f$MCardNotificationLike.uint64_from_uin.has()) {
                        j3 = subMsgType0x6f$MCardNotificationLike.uint64_from_uin.get();
                    }
                    if (subMsgType0x6f$MCardNotificationLike.uint32_counter_total.has()) {
                        i26 = subMsgType0x6f$MCardNotificationLike.uint32_counter_total.get();
                    } else {
                        i26 = 0;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("msg0x210.SubMsgType0x6f", 2, "card_notification_like : wording: " + str + " totalCount: " + i26 + " newCount: " + i19 + " fromUin: " + j3);
                    }
                    com.tencent.mobileqq.dating.d dVar = (com.tencent.mobileqq.dating.d) qQAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
                    if (dVar != null) {
                        dVar.b().f(subMsgType0x6f$MCardNotificationLike);
                    }
                } else if (i3 == 2002 && subMsgType0x6f$ForwardBody.msg_vip_info_notify.has()) {
                    SubMsgType0x6f$VipInfoNotify subMsgType0x6f$VipInfoNotify = subMsgType0x6f$ForwardBody.msg_vip_info_notify.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "vip info notify: " + subMsgType0x6f$VipInfoNotify.toString());
                    }
                    if (subMsgType0x6f$VipInfoNotify.uint64_uin.has()) {
                        j3 = subMsgType0x6f$VipInfoNotify.uint64_uin.get();
                    }
                    String l3 = Long.toString(j3);
                    if (subMsgType0x6f$VipInfoNotify.uint32_vip_identify.has()) {
                        i16 = subMsgType0x6f$VipInfoNotify.uint32_vip_identify.get();
                    } else {
                        i16 = 0;
                    }
                    if (subMsgType0x6f$VipInfoNotify.uint32_vip_level.has()) {
                        i17 = subMsgType0x6f$VipInfoNotify.uint32_vip_level.get();
                    } else {
                        i17 = 0;
                    }
                    if (subMsgType0x6f$VipInfoNotify.uint32_red_flag.has()) {
                        i18 = subMsgType0x6f$VipInfoNotify.uint32_red_flag.get();
                    } else {
                        i18 = -1;
                    }
                    if (subMsgType0x6f$VipInfoNotify.uint32_disable_red_envelope.has()) {
                        i28 = subMsgType0x6f$VipInfoNotify.uint32_disable_red_envelope.get();
                    }
                    int i29 = subMsgType0x6f$VipInfoNotify.uint32_redpack_id.get();
                    String str2 = subMsgType0x6f$VipInfoNotify.str_redpack_name.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "iRedPacketId = " + i29 + ";redText = " + str2);
                    }
                    if (i18 >= 0 || i28 >= 0) {
                        IndividualRedPacketManager individualRedPacketManager = (IndividualRedPacketManager) qQAppInterface.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
                        individualRedPacketManager.Q(i18, i28, true);
                        individualRedPacketManager.R(i29, str2);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "UIN " + l3 + " vip info changed.");
                    }
                    if (i16 != 0 || i17 != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageProcessor", 2, "need pull vip info from svr. vipIdentiy=" + i16 + "; vipLevel=" + i17);
                        }
                        VasLogNtReporter.getVipIcon().reportDebug("0x6f change and request vipinfo data");
                        ((VipInfoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).sendGetBaseVipInfoReq(VasSkey.getSkey((TicketManager) qQAppInterface.getManager(2), l3), l3);
                    }
                    TroopKeywordManager.e(qQAppInterface).k();
                } else if (i3 == 2007 && subMsgType0x6f$ForwardBody.msg_babyq_reward_info.has()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "receive msg_babyq_reward_info...");
                    }
                } else if (i3 == 2011 && subMsgType0x6f$ForwardBody.msg_mod_qim_friend_to_qq.has()) {
                    SubMsgType0x6f$QimFriendNotifyToQQ subMsgType0x6f$QimFriendNotifyToQQ = subMsgType0x6f$ForwardBody.msg_mod_qim_friend_to_qq.get();
                    if (subMsgType0x6f$QimFriendNotifyToQQ.uint32_notify_type.has()) {
                        i28 = subMsgType0x6f$QimFriendNotifyToQQ.uint32_notify_type.get();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMNewNotifyPush", 2, "receive msg_add_notify_to_qq... " + i28);
                    }
                    if (i28 == 1) {
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
                            ((INewFriendService) qQAppInterface.getRuntimeService(INewFriendService.class)).handleQIMNewFollower(qIMFollwerAdd);
                        }
                    } else if (i28 != 2 && i28 == 3 && subMsgType0x6f$QimFriendNotifyToQQ.msg_add_not_login_frd_notify_to_qq.has()) {
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
                        for (int i36 = 0; i36 < subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.rpt_msg_video_info.size(); i36++) {
                            SubMsgType0x6f$VideoInfo subMsgType0x6f$VideoInfo = subMsgType0x6f$AddQimNotLoginFrdNotifyToQQ.rpt_msg_video_info.get(i36);
                            QIMNotifyAddFriend.VideoInfo videoInfo = new QIMNotifyAddFriend.VideoInfo();
                            videoInfo.coverUrl = subMsgType0x6f$VideoInfo.bytes_video_cover_url.get().toStringUtf8();
                            videoInfo.videoVid = subMsgType0x6f$VideoInfo.bytes_vid.get().toStringUtf8();
                            qIMNotifyAddFriend.videoInfos.add(videoInfo);
                        }
                        qIMNotifyAddFriend.pushTime = com.tencent.mobileqq.service.message.e.K0();
                        if (QLog.isColorLevel()) {
                            QLog.d("QIMNewNotifyPush", 2, "receive data= " + qIMNotifyAddFriend.toString());
                        }
                        ((QIMNewFriendManager) qQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(qIMNotifyAddFriend);
                    }
                }
                com.tencent.mobileqq.service.message.p.I(msgInfo.lFromUin, msgInfo.shMsgSeq, msgInfo.lMsgUid, msgInfo.shMsgType, messageHandler.getApp());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("msg0x210.SubMsgType0x6f", 2, "exception : " + e16);
            }
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        b(qQAppInterface, qQAppInterface.getMsgHandler(), msgInfo, msgType0x210);
        return null;
    }
}
