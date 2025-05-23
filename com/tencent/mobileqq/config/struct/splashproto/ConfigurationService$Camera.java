package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$Camera extends MessageMicro<ConfigurationService$Camera> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"primary", "secondary", "flash"}, new Object[]{0L, 0L, Boolean.FALSE}, ConfigurationService$Camera.class);
    public final PBUInt64Field primary = PBField.initUInt64(0);
    public final PBUInt64Field secondary = PBField.initUInt64(0);
    public final PBBoolField flash = PBField.initBool(false);
}
