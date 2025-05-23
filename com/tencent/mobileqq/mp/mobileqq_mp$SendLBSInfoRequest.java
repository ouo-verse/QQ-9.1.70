package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$SendLBSInfoRequest extends MessageMicro<mobileqq_mp$SendLBSInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBDoubleField latitude = PBField.initDouble(0.0d);
    public final PBDoubleField longitude = PBField.initDouble(0.0d);
    public final PBUInt64Field luin = PBField.initUInt64(0);
    public final PBStringField cityinfo = PBField.initString("");

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17, 25, 32, 42}, new String[]{"uin", "latitude", "longitude", "luin", "cityinfo"}, new Object[]{0, valueOf, valueOf, 0L, ""}, mobileqq_mp$SendLBSInfoRequest.class);
    }
}
