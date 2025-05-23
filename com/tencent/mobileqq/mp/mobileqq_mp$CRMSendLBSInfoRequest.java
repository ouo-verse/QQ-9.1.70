package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$CRMSendLBSInfoRequest extends MessageMicro<mobileqq_mp$CRMSendLBSInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBDoubleField latitude = PBField.initDouble(0.0d);
    public final PBDoubleField longitude = PBField.initDouble(0.0d);
    public final PBStringField cityinfo = PBField.initString("");

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17, 25, 34}, new String[]{"uin", "latitude", "longitude", "cityinfo"}, new Object[]{0L, valueOf, valueOf, ""}, mobileqq_mp$CRMSendLBSInfoRequest.class);
    }
}
