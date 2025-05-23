package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMemberDetectSvr$QueryDuplicateMembersReq extends MessageMicro<TroopMemberDetectSvr$QueryDuplicateMembersReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_ids"}, new Object[]{0L}, TroopMemberDetectSvr$QueryDuplicateMembersReq.class);
    public final PBRepeatField<Long> group_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
