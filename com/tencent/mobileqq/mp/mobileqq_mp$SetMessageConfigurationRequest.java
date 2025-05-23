package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$SetMessageConfigurationRequest extends MessageMicro<mobileqq_mp$SetMessageConfigurationRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uin", "type", "versionInfo"}, new Object[]{0L, 0, ""}, mobileqq_mp$SetMessageConfigurationRequest.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField versionInfo = PBField.initString("");
}
