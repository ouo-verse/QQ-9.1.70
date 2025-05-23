package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes10.dex */
public final class ConfigurationService$CPU extends MessageMicro<ConfigurationService$CPU> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"model", "cores", "frequency"}, new Object[]{"", 0, 0}, ConfigurationService$CPU.class);
    public final PBStringField model = PBField.initString("");
    public final PBUInt32Field cores = PBField.initUInt32(0);
    public final PBUInt32Field frequency = PBField.initUInt32(0);
}
