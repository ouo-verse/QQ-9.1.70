package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMemberDetectSvr$QueryDuplicateMembersRsp extends MessageMicro<TroopMemberDetectSvr$QueryDuplicateMembersRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{null}, TroopMemberDetectSvr$QueryDuplicateMembersRsp.class);
    public final PBRepeatMessageField<TroopMemberDetectSvr$DuplicateMember> list = PBField.initRepeatMessage(TroopMemberDetectSvr$DuplicateMember.class);
}
