package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$SetRefuseFollowRequest extends MessageMicro<mobileqq_mp$SetRefuseFollowRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"luin", "account_type", "refuse_forever", "refuse_period"}, new Object[]{0L, 0, Boolean.FALSE, 0}, mobileqq_mp$SetRefuseFollowRequest.class);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBBoolField refuse_forever = PBField.initBool(false);
    public final PBUInt32Field refuse_period = PBField.initUInt32(0);
}
