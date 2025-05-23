package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$GetMessageConfigurationRequest extends MessageMicro<mobileqq_mp$GetMessageConfigurationRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26}, new String[]{"uin", "versionInfo"}, new Object[]{0L, ""}, mobileqq_mp$GetMessageConfigurationRequest.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField versionInfo = PBField.initString("");
}
