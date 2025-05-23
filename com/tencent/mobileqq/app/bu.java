package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm$ContentHead;
import msf.msgcomm.msg_comm$GroupInfo;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import tencent.im.msg.nt_msg_common$ContentHead;
import tencent.im.msg.nt_msg_common$Group;
import tencent.im.msg.nt_msg_common$Msg;
import tencent.im.msg.nt_msg_common$RoutingHead;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bu {
    static IPatchRedirector $redirector_;

    public static ArrayList<msg_comm$Msg> a(List<nt_msg_common$Msg> list) {
        ArrayList<msg_comm$Msg> arrayList = new ArrayList<>();
        QLog.d("MsgUtils", 1, "convertNtMsgToCommonMsg size=" + list.size());
        for (nt_msg_common$Msg nt_msg_common_msg : list) {
            msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
            msg_comm_msg.msg_head.set(c(nt_msg_common_msg));
            msg_comm_msg.content_head.set(b(nt_msg_common_msg));
            msg_comm_msg.msg_body.set(nt_msg_common_msg.body);
            arrayList.add(msg_comm_msg);
        }
        return arrayList;
    }

    private static msg_comm$ContentHead b(nt_msg_common$Msg nt_msg_common_msg) {
        msg_comm$ContentHead msg_comm_contenthead = new msg_comm$ContentHead();
        msg_comm_contenthead.pkg_num.set(nt_msg_common_msg.content_head.pkg_num.get());
        msg_comm_contenthead.pkg_index.set(nt_msg_common_msg.content_head.pkg_index.get());
        msg_comm_contenthead.div_seq.set(nt_msg_common_msg.content_head.div_seq.get());
        msg_comm_contenthead.auto_reply.set(nt_msg_common_msg.content_head.auto_reply.get());
        return msg_comm_contenthead;
    }

    private static msg_comm$MsgHead c(nt_msg_common$Msg nt_msg_common_msg) {
        msg_comm$MsgHead msg_comm_msghead = new msg_comm$MsgHead();
        nt_msg_common$RoutingHead nt_msg_common_routinghead = nt_msg_common_msg.routing_head;
        nt_msg_common$Group nt_msg_common_group = nt_msg_common_routinghead.group;
        nt_msg_common$ContentHead nt_msg_common_contenthead = nt_msg_common_msg.content_head;
        msg_comm_msghead.from_uin.set(nt_msg_common_routinghead.from_uin.get());
        msg_comm_msghead.to_uin.set(nt_msg_common_routinghead.to_uin.get());
        msg_comm_msghead.msg_type.set((int) nt_msg_common_contenthead.msg_type.get());
        msg_comm_msghead.c2c_cmd.set(nt_msg_common_contenthead.c2c_cmd.get());
        msg_comm_msghead.msg_seq.set((int) nt_msg_common_contenthead.msg_seq.get());
        msg_comm_msghead.msg_time.set((int) nt_msg_common_contenthead.msg_time.get());
        msg_comm_msghead.msg_uid.set(nt_msg_common_contenthead.msg_uid.get());
        msg_comm$GroupInfo msg_comm_groupinfo = new msg_comm$GroupInfo();
        msg_comm_groupinfo.group_code.set(nt_msg_common_group.group_code.get());
        msg_comm_groupinfo.group_type.set(nt_msg_common_group.group_type.get());
        msg_comm_groupinfo.group_info_seq.set(nt_msg_common_group.group_info_seq.get());
        msg_comm_groupinfo.group_card.set(nt_msg_common_group.group_card.get());
        msg_comm_groupinfo.group_level.set(nt_msg_common_group.group_level.get());
        msg_comm_groupinfo.group_card_type.set(nt_msg_common_group.group_card_type.get());
        msg_comm_groupinfo.group_name.set(nt_msg_common_group.group_name.get());
        msg_comm_msghead.group_info.set(msg_comm_groupinfo);
        msg_comm_msghead.from_appid.set(nt_msg_common_routinghead.from_appid.get());
        msg_comm_msghead.from_instid.set(nt_msg_common_routinghead.from_instid.get());
        msg_comm_msghead.msg_type.set((int) nt_msg_common_contenthead.msg_type.get());
        msg_comm_msghead.msg_seq.set((int) nt_msg_common_contenthead.msg_seq.get());
        msg_comm_msghead.msg_time.set((int) nt_msg_common_contenthead.msg_time.get());
        msg_comm_msghead.msg_flag.set(nt_msg_common_group.msg_flag.get());
        return msg_comm_msghead;
    }
}
