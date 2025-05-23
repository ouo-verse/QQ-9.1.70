package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$SetFunctionFlagRequset extends MessageMicro<mobileqq_mp$SetFunctionFlagRequset> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uin", "type", "value", "account_type", "luin", "version"}, new Object[]{0, 0, 0, 0, 0L, 0}, mobileqq_mp$SetFunctionFlagRequset.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field value = PBField.initUInt32(0);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
}
