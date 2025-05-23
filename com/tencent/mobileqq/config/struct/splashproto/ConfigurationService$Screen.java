package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$Screen extends MessageMicro<ConfigurationService$Screen> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"model", "width", "height", "dpi", "multi_touch"}, new Object[]{"", 0, 0, 0, Boolean.FALSE}, ConfigurationService$Screen.class);
    public final PBStringField model = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field dpi = PBField.initUInt32(0);
    public final PBBoolField multi_touch = PBField.initBool(false);
}
