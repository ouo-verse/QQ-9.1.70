package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0x496$GroupMsgConfig extends MessageMicro<oidb_0x496$GroupMsgConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"bool_uin_enable", "uint32_max_aio_msg", "uint32_enable_helper", "uint32_group_max_number", "uint32_next_update_time"}, new Object[]{Boolean.FALSE, 0, 0, 0, 0}, oidb_0x496$GroupMsgConfig.class);
    public final PBBoolField bool_uin_enable = PBField.initBool(false);
    public final PBUInt32Field uint32_max_aio_msg = PBField.initUInt32(0);
    public final PBUInt32Field uint32_enable_helper = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_max_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_update_time = PBField.initUInt32(0);
}
