package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class RspGroupVideoInviteMember$GroupVideoInviteListChange extends MessageMicro<RspGroupVideoInviteMember$GroupVideoInviteListChange> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"rpt_member_join", "rpt_member_quit", "uint32_invite_list_total_count"}, new Object[]{null, null, 0}, RspGroupVideoInviteMember$GroupVideoInviteListChange.class);
    public final PBRepeatMessageField<RspGroupVideoInviteMember$MemberInfo> rpt_member_join = PBField.initRepeatMessage(RspGroupVideoInviteMember$MemberInfo.class);
    public final PBRepeatMessageField<RspGroupVideoInviteMember$MemberInfo> rpt_member_quit = PBField.initRepeatMessage(RspGroupVideoInviteMember$MemberInfo.class);
    public final PBUInt32Field uint32_invite_list_total_count = PBField.initUInt32(0);
}
