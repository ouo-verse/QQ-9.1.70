package com.tencent.pb.pendantMarket;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class PendantMarket$SetAddonReq extends MessageMicro<PendantMarket$SetAddonReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 64, 72}, new String[]{"cmd", "int_platform", "int_version", "long_addon_id", "str_qq_version", "int_valid_days", "str_open_key", "i_key_type", "int_from_type"}, new Object[]{0, 0, 0, 0L, "", 0, "", 0, 0}, PendantMarket$SetAddonReq.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field int_platform = PBField.initUInt32(0);
    public final PBUInt32Field int_version = PBField.initUInt32(0);
    public final PBUInt64Field long_addon_id = PBField.initUInt64(0);
    public final PBStringField str_qq_version = PBField.initString("");
    public final PBUInt32Field int_valid_days = PBField.initUInt32(0);
    public final PBStringField str_open_key = PBField.initString("");
    public final PBUInt32Field i_key_type = PBField.initUInt32(0);
    public final PBUInt32Field int_from_type = PBField.initUInt32(0);
}
