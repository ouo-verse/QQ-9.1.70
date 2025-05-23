package com.tencent.mobileqq.comment.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class oidb_0xdea$DeleteBarrageReqBody extends MessageMicro<oidb_0xdea$DeleteBarrageReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_group_code", "uint32_group_seq", "uint64_delete_uin", "uint64_send_uin", "uint32_barrage_flag"}, new Object[]{0L, 0L, 0L, 0L, 0}, oidb_0xdea$DeleteBarrageReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint32_group_seq = PBField.initUInt64(0);
    public final PBUInt64Field uint64_delete_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_barrage_flag = PBField.initUInt32(0);
}
