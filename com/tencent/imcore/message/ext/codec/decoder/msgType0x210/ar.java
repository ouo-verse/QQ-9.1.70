package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ar implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(com.tencent.imcore.message.af afVar, long j3, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse start");
        }
        submsgtype0x44$MsgBody c16 = c(bArr);
        if (c16 == null) {
            return;
        }
        j(c16);
        i(afVar, e(afVar, c16), f(afVar, c16));
        d(afVar, c16);
        g(afVar, c16);
        h(afVar, c16);
    }

    private static submsgtype0x44$MsgBody c(byte[] bArr) {
        try {
            return new submsgtype0x44$MsgBody().mergeFrom(bArr);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse failed.", e16);
            }
            return null;
        }
    }

    private static void d(com.tencent.imcore.message.af afVar, submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        if (submsgtype0x44_msgbody.msg_clean_count_msg.has() && submsgtype0x44_msgbody.msg_clean_count_msg.get() != null) {
            k(afVar, submsgtype0x44_msgbody);
        }
    }

    private static boolean e(com.tencent.imcore.message.af afVar, submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        if (submsgtype0x44_msgbody.msg_friend_msg_sync.has() && submsgtype0x44_msgbody.msg_friend_msg_sync.get() != null) {
            return l(afVar, submsgtype0x44_msgbody);
        }
        return false;
    }

    private static boolean f(com.tencent.imcore.message.af afVar, submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        boolean z16;
        if (submsgtype0x44_msgbody.msg_group_msg_sync.has() && submsgtype0x44_msgbody.msg_group_msg_sync.get() != null) {
            z16 = m(afVar, submsgtype0x44_msgbody);
        } else {
            z16 = false;
        }
        if (submsgtype0x44_msgbody.msg_general_notify.has() && submsgtype0x44_msgbody.msg_general_notify.get() != null) {
            return true;
        }
        return z16;
    }

    private static void g(com.tencent.imcore.message.af afVar, submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        if (submsgtype0x44_msgbody.msg_modify_msg_sync.has() && submsgtype0x44_msgbody.msg_modify_msg_sync.get() != null) {
            n(afVar, submsgtype0x44_msgbody);
        }
    }

    private static void h(com.tencent.imcore.message.af afVar, submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        if (submsgtype0x44_msgbody.msg_waiting_msg_sync.has() && submsgtype0x44_msgbody.msg_waiting_msg_sync.get() != null) {
            o(afVar, submsgtype0x44_msgbody);
        }
    }

    private static void i(com.tencent.imcore.message.af afVar, boolean z16, boolean z17) {
        if (z16 || z17) {
            p(afVar, z16, z17);
        }
    }

    private static void j(submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        if (QLog.isColorLevel()) {
            if (submsgtype0x44_msgbody.msg_friend_msg_sync.has() && submsgtype0x44_msgbody.msg_friend_msg_sync.get() != null) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync processflag=" + submsgtype0x44_msgbody.msg_friend_msg_sync.uint32_processflag.get() + ";processtype=" + submsgtype0x44_msgbody.msg_friend_msg_sync.uint32_processtype.get() + ";fuin" + submsgtype0x44_msgbody.msg_friend_msg_sync.uint64_fuin.get());
            }
            if (submsgtype0x44_msgbody.msg_group_msg_sync.has() && submsgtype0x44_msgbody.msg_group_msg_sync.get() != null) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync processflag=" + submsgtype0x44_msgbody.msg_group_msg_sync.uint32_processflag.get() + ";processtype=" + submsgtype0x44_msgbody.msg_group_msg_sync.uint32_msg_type.get() + ";grp_code=" + submsgtype0x44_msgbody.msg_group_msg_sync.uint64_grp_code.get());
            }
            if (submsgtype0x44_msgbody.msg_clean_count_msg.has() && submsgtype0x44_msgbody.msg_clean_count_msg.get() != null) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg processflag=" + submsgtype0x44_msgbody.msg_clean_count_msg.uint32_processflag.get());
            }
        }
    }

    private static void k(com.tencent.imcore.message.af afVar, submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        if (afVar.T(submsgtype0x44_msgbody.msg_clean_count_msg.uint32_processflag.get())) {
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setUnReadFriendSystemMsgNum(qQAppInterface, 0);
            INewFriendService iNewFriendService = (INewFriendService) qQAppInterface.getRuntimeService(INewFriendService.class);
            qQAppInterface.getMessageFacade().R0(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
            iNewFriendService.reloadNewFriendMsg();
        }
        int i3 = submsgtype0x44_msgbody.msg_clean_count_msg.get().uint32_updateflag.get();
        if (i3 > 0) {
            qQAppInterface.getMsgHandler().m3().v0(2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=" + submsgtype0x44_msgbody.msg_clean_count_msg.uint32_processflag.get() + " updateFlag=" + i3);
        }
    }

    private static boolean l(com.tencent.imcore.message.af afVar, submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        boolean T = afVar.T(submsgtype0x44_msgbody.msg_friend_msg_sync.uint32_processflag.get());
        if (afVar.S(submsgtype0x44_msgbody.msg_friend_msg_sync.uint32_processtype.get())) {
            String valueOf = String.valueOf(submsgtype0x44_msgbody.msg_friend_msg_sync.uint64_fuin.get());
            if (!TextUtils.isEmpty(valueOf) && StringUtil.isValideUin(valueOf)) {
                FriendListHandler friendListHandler = (FriendListHandler) afVar.d().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                int i3 = submsgtype0x44_msgbody.msg_friend_msg_sync.uint32_sourceid.get();
                String valueOf2 = String.valueOf(valueOf);
                if (!friendListHandler.addFriendToFriendList(valueOf2, 0, i3, null, false, false, -1L)) {
                    friendListHandler.getFriendDetailInfo(valueOf2);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + submsgtype0x44_msgbody.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + submsgtype0x44_msgbody.msg_friend_msg_sync.uint32_processtype.get());
        }
        return T;
    }

    private static boolean m(com.tencent.imcore.message.af afVar, submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        boolean T = afVar.T(submsgtype0x44_msgbody.msg_group_msg_sync.uint32_processflag.get());
        if (afVar.U(submsgtype0x44_msgbody.msg_group_msg_sync.uint32_msg_type.get())) {
            String valueOf = String.valueOf(submsgtype0x44_msgbody.msg_group_msg_sync.uint64_grp_code.get());
            String a16 = com.tencent.mobileqq.systemmsg.a.a(submsgtype0x44_msgbody.msg_group_msg_sync.uint64_grp_code.get());
            if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(a16) && StringUtil.isValideUin(valueOf)) {
                if (((TroopManager) afVar.d().getManager(QQManagerFactory.TROOP_MANAGER)).k(valueOf) == null) {
                    com.tencent.mobileqq.troop.api.handler.h hVar = (com.tencent.mobileqq.troop.api.handler.h) afVar.d().getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
                    ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfoWithExt(valueOf, "SubType0x44", null, null);
                    ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchTroopAdmin(valueOf, null, null);
                    ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).fetchTroopLevelInfo(valueOf, true);
                    hVar.a(com.tencent.mobileqq.troop.api.observer.b.f294307e, true, new Object[]{6, (byte) 0, valueOf});
                    hVar.a(com.tencent.mobileqq.troop.api.observer.b.C, true, new Object[]{valueOf});
                }
                afVar.l(2001, true, null);
            }
        }
        QLog.i("Q.msg.BaseMessageProcessor", 1, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + submsgtype0x44_msgbody.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + submsgtype0x44_msgbody.msg_group_msg_sync.uint32_msg_type.get());
        return T;
    }

    private static void n(com.tencent.imcore.message.af afVar, submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        ((com.tencent.mobileqq.app.message.n) ((BaseMessageHandler) afVar.d().getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM)).t0(2);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_modify_msg_sync =" + submsgtype0x44_msgbody.msg_modify_msg_sync.get());
        }
    }

    private static void o(com.tencent.imcore.message.af afVar, submsgtype0x44$MsgBody submsgtype0x44_msgbody) {
        ((com.tencent.mobileqq.app.message.n) ((BaseMessageHandler) afVar.d().getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM)).v0(2);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_waiting_msg_sync =" + submsgtype0x44_msgbody.msg_waiting_msg_sync.get());
        }
    }

    private static void p(com.tencent.imcore.message.af afVar, boolean z16, boolean z17) {
        com.tencent.mobileqq.app.message.n nVar = (com.tencent.mobileqq.app.message.n) ((BaseMessageHandler) afVar.d().getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM);
        if (z16) {
            nVar.v0(2);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b(afVar, j3, msgType0x210.vProtobuf);
        return null;
    }
}
