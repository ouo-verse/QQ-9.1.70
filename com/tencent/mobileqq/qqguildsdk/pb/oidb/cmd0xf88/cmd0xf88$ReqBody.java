package com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class cmd0xf88$ReqBody extends MessageMicro<cmd0xf88$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"msg_filter", "uint64_member_id", "uint64_member_tinyid", "uint64_guild_id"}, new Object[]{null, 0L, 0L, 0L}, cmd0xf88$ReqBody.class);
    public cmd0xf88$Filter msg_filter = new cmd0xf88$Filter();
    public final PBUInt64Field uint64_member_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_member_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
}
