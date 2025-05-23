package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$GetUserFollowListResponse extends MessageMicro<mobileqq_mp$GetUserFollowListResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48, 56, 66}, new String[]{"ret_info", "follow_seqno", "public_account_seqno", "total_count", "info", "has_next", "group_info_seqno", "group_info"}, new Object[]{null, 0, 0, 0, null, Boolean.FALSE, 0, null}, mobileqq_mp$GetUserFollowListResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBUInt32Field follow_seqno = PBField.initUInt32(0);
    public final PBUInt32Field public_account_seqno = PBField.initUInt32(0);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp$PublicAccountInfo> info = PBField.initRepeatMessage(mobileqq_mp$PublicAccountInfo.class);
    public final PBBoolField has_next = PBField.initBool(false);
    public final PBUInt32Field group_info_seqno = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp$GroupInfo> group_info = PBField.initRepeatMessage(mobileqq_mp$GroupInfo.class);
}
