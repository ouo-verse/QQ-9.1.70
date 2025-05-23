package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$Storage extends MessageMicro<ConfigurationService$Storage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"builtin", "external"}, new Object[]{0L, 0L}, ConfigurationService$Storage.class);
    public final PBUInt64Field builtin = PBField.initUInt64(0);
    public final PBUInt64Field external = PBField.initUInt64(0);
}
