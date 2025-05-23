package com.tencent.mobileqq.oidb.cmd0xf7e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class oidb_cmd0xf7e$ReqBody extends MessageMicro<oidb_cmd0xf7e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint64_frd_uin", "uint64_last_pull_time", "version", "lastTofus"}, new Object[]{0L, 0L, "", null}, oidb_cmd0xf7e$ReqBody.class);
    public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_last_pull_time = PBField.initUInt64(0);
    public final PBStringField version = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xf7e$LastTofu> lastTofus = PBField.initRepeatMessage(oidb_cmd0xf7e$LastTofu.class);
}
