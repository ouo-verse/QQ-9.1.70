package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg$FlagInfo;
import tencent.mobileim.structmsg.structmsg$ReqSystemMsgNew;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ct implements com.tencent.mobileqq.service.profile.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f195468d;

    public ct(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f195468d = appInterface;
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public ReqItem d2(int i3) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReqItem) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        ReqItem reqItem = new ReqItem();
        reqItem.eServiceID = 114;
        structmsg$ReqSystemMsgNew structmsg_reqsystemmsgnew = new structmsg$ReqSystemMsgNew();
        structmsg_reqsystemmsgnew.msg_num.set(20);
        structmsg_reqsystemmsgnew.checktype.set(2);
        structmsg_reqsystemmsgnew.uint32_need_uid.set(1);
        MessageHandler msgHandler = ((QQAppInterface) this.f195468d).getMsgHandler();
        boolean z16 = this.f195468d.getPreferences().getBoolean("SP_VERSION_UPDATE_NT", false);
        if (!z16) {
            this.f195468d.getPreferences().edit().putBoolean("SP_VERSION_UPDATE_NT", true);
        }
        PBUInt64Field pBUInt64Field = structmsg_reqsystemmsgnew.latest_friend_seq;
        if (z16) {
            j3 = msgHandler.Y2().a1("last_friend_seq_47");
        } else {
            j3 = 0;
        }
        pBUInt64Field.set(j3);
        structmsg_reqsystemmsgnew.latest_group_seq.set(0L);
        structmsg_reqsystemmsgnew.version.set(1000);
        structmsg_reqsystemmsgnew.is_get_grp_ribbon.set(false);
        structmsg_reqsystemmsgnew.friend_msg_type_flag.set(1L);
        structmsg$FlagInfo structmsg_flaginfo = new structmsg$FlagInfo();
        structmsg_flaginfo.GrpMsg_Kick_Admin.set(1);
        structmsg_flaginfo.GrpMsg_WordingDown.set(1);
        structmsg_flaginfo.GrpMsg_GetOfficialAccount.set(1);
        structmsg_flaginfo.FrdMsg_GetBusiCard.set(1);
        structmsg_flaginfo.GrpMsg_GetPayInGroup.set(1);
        structmsg_flaginfo.FrdMsg_Discuss2ManyChat.set(1);
        structmsg_flaginfo.FrdMsg_NeedWaitingMsg.set(1);
        structmsg_flaginfo.GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
        structmsg_flaginfo.FrdMsg_uint32_need_all_unread_msg.set(1);
        structmsg_flaginfo.GrpMsg_get_transfer_group_msg_flag.set(1);
        structmsg_flaginfo.GrpMsg_NeedAutoAdminWording.set(1);
        structmsg_flaginfo.GrpMsg_get_quit_pay_group_msg_flag.set(1);
        structmsg_flaginfo.GrpMsg_GetC2cInviteJoinGroup.set(1);
        structmsg_flaginfo.GrpMsg_support_invite_auto_join.set(1);
        structmsg_flaginfo.GrpMsg_mask_invite_auto_join.set(1);
        structmsg_reqsystemmsgnew.flag.set(structmsg_flaginfo);
        structmsg_reqsystemmsgnew.is_get_frd_ribbon.set(false);
        byte[] byteArray = structmsg_reqsystemmsgnew.toByteArray();
        byte[] bArr = new byte[byteArray.length + 4];
        PkgTools.dWord2Byte(bArr, 0, byteArray.length + 4);
        PkgTools.copyData(bArr, 4, byteArray, byteArray.length);
        reqItem.vecParam = bArr;
        return reqItem;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public void l2(RespItem respItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) respItem);
            return;
        }
        if (respItem.eServiceID == 114) {
            if (respItem.cResult == 2) {
                byte[] bArr = respItem.vecUpdate;
                int length = bArr.length - 4;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 4, bArr2, 0, length);
                ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195468d.getAccount(), "ProfileService.Pb.ReqSystemMsgNew");
                FromServiceMsg fromServiceMsg = new FromServiceMsg(this.f195468d.getAccount(), "ProfileService.Pb.ReqSystemMsgNew");
                fromServiceMsg.setServiceCmd("ProfileService.Pb.ReqSystemMsgNew");
                fromServiceMsg.setMsgSuccess();
                ((QQAppInterface) this.f195468d).getMsgHandler().onReceive(toServiceMsg, fromServiceMsg, bArr2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ReqSystemMsgNewItem", 2, "error happend item.cResult = " + ((int) respItem.cResult));
            }
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public int w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 5;
    }
}
