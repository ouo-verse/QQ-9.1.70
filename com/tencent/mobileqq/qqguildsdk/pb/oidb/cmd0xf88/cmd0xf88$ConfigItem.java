package com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class cmd0xf88$ConfigItem extends MessageMicro<cmd0xf88$ConfigItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"config_id", "config_status", "desc"}, new Object[]{0, 0, ""}, cmd0xf88$ConfigItem.class);
    public final PBUInt32Field config_id = PBField.initUInt32(0);
    public final PBUInt32Field config_status = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
}
