package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0xac5$HaiWanRecord extends MessageMicro<oidb_0xac5$HaiWanRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_uin", "uint64_uid", "uint64_roomid", "uint32_timestamp", "uint32_haiwan_type"}, new Object[]{0L, 0L, 0L, 0, 0}, oidb_0xac5$HaiWanRecord.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_roomid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_haiwan_type = PBField.initUInt32(0);
}
