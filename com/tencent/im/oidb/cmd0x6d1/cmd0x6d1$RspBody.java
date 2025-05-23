package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class cmd0x6d1$RspBody extends MessageMicro<cmd0x6d1$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"invite_rsp_body", "uninvite_rsp_body", "deal_invite_rsp_body"}, new Object[]{null, null, null}, cmd0x6d1$RspBody.class);
    public cmd0x6d1$InviteRspBody invite_rsp_body = new MessageMicro<cmd0x6d1$InviteRspBody>() { // from class: com.tencent.im.oidb.cmd0x6d1.cmd0x6d1$InviteRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_invited_uin_list", "rpt_uninvited_uin_list"}, new Object[]{null, null}, cmd0x6d1$InviteRspBody.class);
        public final PBRepeatMessageField<cmd0x6d1$ItemInfo> rpt_invited_uin_list = PBField.initRepeatMessage(cmd0x6d1$ItemInfo.class);
        public final PBRepeatMessageField<cmd0x6d1$ItemInfo> rpt_uninvited_uin_list = PBField.initRepeatMessage(cmd0x6d1$ItemInfo.class);
    };
    public cmd0x6d1$UniviteRspBody uninvite_rsp_body = new MessageMicro<cmd0x6d1$UniviteRspBody>() { // from class: com.tencent.im.oidb.cmd0x6d1.cmd0x6d1$UniviteRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x6d1$UniviteRspBody.class);
    };
    public cmd0x6d1$DealInviteRspBody deal_invite_rsp_body = new cmd0x6d1$DealInviteRspBody();
}
