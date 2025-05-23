package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$RspGetInvitedMemberList extends MessageMicro<ReqGroupVideo$RspGetInvitedMemberList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"result", "uint64_group", "uint64_room_id", "rpt_member_list"}, new Object[]{null, 0L, 0L, null}, ReqGroupVideo$RspGetInvitedMemberList.class);
    public common$ErrorInfo result = new common$ErrorInfo();
    public final PBUInt64Field uint64_group = PBField.initUInt64(0);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<ReqGroupVideo$MemberInfo> rpt_member_list = PBField.initRepeatMessage(ReqGroupVideo$MemberInfo.class);
}
