package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$ReqGetInvitedMemberList extends MessageMicro<ReqGroupVideo$ReqGetInvitedMemberList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_group", "uint64_room_id"}, new Object[]{0L, 0L}, ReqGroupVideo$ReqGetInvitedMemberList.class);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0);
}
