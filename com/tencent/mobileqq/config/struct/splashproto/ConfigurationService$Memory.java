package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$Memory extends MessageMicro<ConfigurationService$Memory> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"total", "process"}, new Object[]{0L, 0L}, ConfigurationService$Memory.class);
    public final PBUInt64Field total = PBField.initUInt64(0);
    public final PBUInt64Field process = PBField.initUInt64(0);
}
