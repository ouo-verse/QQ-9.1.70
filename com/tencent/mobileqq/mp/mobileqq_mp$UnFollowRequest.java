package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$UnFollowRequest extends MessageMicro<mobileqq_mp$UnFollowRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "account_type", "luin"}, new Object[]{0, 0, 0L}, mobileqq_mp$UnFollowRequest.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
}
