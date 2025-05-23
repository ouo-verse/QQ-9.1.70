package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$GetFollowListRspOld extends MessageMicro<clientbusilogic$GetFollowListRspOld> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 32, 42, 48}, new String[]{"ret_info", "follow_seqno", "total_count", "info", "has_next"}, new Object[]{null, 0, 0, null, Boolean.FALSE}, clientbusilogic$GetFollowListRspOld.class);
    public clientbusilogic$RetInfo ret_info = new clientbusilogic$RetInfo();
    public final PBUInt32Field follow_seqno = PBField.initUInt32(0);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<clientbusilogic$PublicAccountInfo> info = PBField.initRepeatMessage(clientbusilogic$PublicAccountInfo.class);
    public final PBBoolField has_next = PBField.initBool(false);
}
