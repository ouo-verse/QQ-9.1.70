package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$GetUserFollowListRequest extends MessageMicro<mobileqq_mp$GetUserFollowListRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"follow_seqno", "public_account_seqno", "begin", "limit", "is_increment", "group_info_seqno", "version"}, new Object[]{0, 0, 0, 0, Boolean.FALSE, 0, 0}, mobileqq_mp$GetUserFollowListRequest.class);
    public final PBUInt32Field follow_seqno = PBField.initUInt32(0);
    public final PBUInt32Field public_account_seqno = PBField.initUInt32(0);
    public final PBUInt32Field begin = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBBoolField is_increment = PBField.initBool(false);
    public final PBUInt32Field group_info_seqno = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
}
