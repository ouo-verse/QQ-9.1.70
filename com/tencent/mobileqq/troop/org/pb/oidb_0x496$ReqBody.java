package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0x496$ReqBody extends MessageMicro<oidb_0x496$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"uint64_group_code", "uint64_update_time", "uint64_manager_uin_list", "uint64_first_unread_manager_msg_seq", "uint32_just_fetch_msg_config", "uint32_type", "uint32_version", "uint32_aio_keyword_version"}, new Object[]{0L, 0L, 0L, 0L, 0, 0, 0, 0}, oidb_0x496$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_update_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_manager_uin_list = PBField.initUInt64(0);
    public final PBUInt64Field uint64_first_unread_manager_msg_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_just_fetch_msg_config = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_aio_keyword_version = PBField.initUInt32(0);
}
