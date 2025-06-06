package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$PunchCardInfoRequest extends MessageMicro<mobileqq_mp$PunchCardInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"versionInfo", "cuin", "cmd"}, new Object[]{"", 0L, 0}, mobileqq_mp$PunchCardInfoRequest.class);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBUInt64Field cuin = PBField.initUInt64(0);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
}
