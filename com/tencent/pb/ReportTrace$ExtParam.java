package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class ReportTrace$ExtParam extends MessageMicro<ReportTrace$ExtParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"param_id", "value"}, new Object[]{0, 0L}, ReportTrace$ExtParam.class);
    public final PBUInt32Field param_id = PBField.initUInt32(0);
    public final PBUInt64Field value = PBField.initUInt64(0);
}
