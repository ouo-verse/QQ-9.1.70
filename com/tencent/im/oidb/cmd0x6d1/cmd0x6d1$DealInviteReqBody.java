package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class cmd0x6d1$DealInviteReqBody extends MessageMicro<cmd0x6d1$DealInviteReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_group_code", "uint64_uin", "str_id", "uint32_deal_result"}, new Object[]{0L, 0L, "", 0}, cmd0x6d1$DealInviteReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBStringField str_id = PBField.initString("");
    public final PBUInt32Field uint32_deal_result = PBField.initUInt32(0);
}
