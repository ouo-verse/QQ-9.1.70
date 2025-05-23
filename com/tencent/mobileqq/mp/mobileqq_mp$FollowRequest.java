package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$FollowRequest extends MessageMicro<mobileqq_mp$FollowRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"uin", "ext", "account_type", "luin", "type"}, new Object[]{0, "", 0, 0L, 0}, mobileqq_mp$FollowRequest.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField ext = PBField.initString("");
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
}
