package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$MemberInfo extends MessageMicro<ReqGroupVideo$MemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_member_uin", "uint32_invite_timestamp"}, new Object[]{0L, 0}, ReqGroupVideo$MemberInfo.class);
    public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_invite_timestamp = PBField.initUInt32(0);
}
